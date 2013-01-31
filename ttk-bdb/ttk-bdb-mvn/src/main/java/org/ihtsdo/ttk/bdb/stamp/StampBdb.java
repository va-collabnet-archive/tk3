package org.ihtsdo.ttk.bdb.stamp;

import org.ihtsdo.ttk.api.PathBI;
import org.ihtsdo.ttk.api.NidSetBI;
import org.ihtsdo.ttk.api.PositionBI;
import org.ihtsdo.ttk.api.NidSet;
import com.sleepycat.bind.tuple.IntegerBinding;
import com.sleepycat.bind.tuple.TupleBinding;
import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import org.ihtsdo.ttk.bdb.Bdb;
import org.ihtsdo.ttk.bdb.ComponentBdb;
import org.ihtsdo.ttk.bdb.temp.AceLog;
import org.ihtsdo.ttk.concept.cc.Position;

/**
 * @author kec
 *
 */
public class StampBdb extends ComponentBdb {
   private static final int                                    MIN_ARRAY_SIZE         = 100;
   private static int                                          initialPosition        = -1;
   private static PositionArrayBinder                          positionArrayBinder    =
      new PositionArrayBinder();
   private static final Map<UncommittedStatusForPath, Integer> uncomittedStampEntries =
      new ConcurrentHashMap<>();
   private static CountDownLatch setupLatch = new CountDownLatch(1);
   private static AtomicInteger  misses     = new AtomicInteger(0);
   private static AtomicInteger  hits       = new AtomicInteger(0);
   private static Set<Integer>   currentPaths;
   private static PositionArrays mutableArray;
   private static PositionArrays readOnlyArray;

   //~--- fields --------------------------------------------------------------

   private Semaphore     expandPermit = new Semaphore(1);
   private AtomicInteger sequence;

   /**
    * TODO future optimization is to use a map that uses an index to the
    * <code>PositionArrays</code> rather than duplicating the key data.
    */
   private StampToIntHashMap stampToIntMap;

   //~--- constructors --------------------------------------------------------

   public StampBdb(Bdb readOnlyBdbEnv, Bdb mutableBdbEnv) throws IOException {
      super(readOnlyBdbEnv, mutableBdbEnv);
   }

   //~--- methods -------------------------------------------------------------

   public void cancelAfterCommit(NidSetBI commitStamps) throws IOException {
      synchronized (uncomittedStampEntries) {
         int min = Integer.MAX_VALUE;

         expandPermit.acquireUninterruptibly();

         try {
            for (int sapNid : commitStamps.getSetValues()) {
               min = Math.min(min, sapNid);
            }

            for (int sapNid : uncomittedStampEntries.values()) {
               min = Math.min(min, sapNid);
            }

            for (int i = min; i < sequence.get(); i++) {
               mutableArray.commitTimes[getMutableIndex(i)] = Long.MIN_VALUE;
               stampToIntMap.put(getStatusNid(i), Long.MIN_VALUE, getAuthorNid(i), getModuleNid(i),
                                 getPathNid(i), i);
            }

            uncomittedStampEntries.clear();
         } finally {
            expandPermit.release();
         }
      }

      sync();
   }

   private void checkTimeAndAdd(long startTime, long endTime, NidSetBI specifiedSapNids, int sapNid) {
      long time = getTime(sapNid);

      if ((time >= startTime) && (time <= endTime)) {
         specifiedSapNids.add(sapNid);
      }
   }

   @Override
   public void close() {
      try {
         this.sync();
      } catch (IOException e) {
         AceLog.getAppLog().alertAndLogException(e);
      }

      super.close();
      initialPosition     = -1;
      positionArrayBinder = new PositionArrayBinder();
      uncomittedStampEntries.clear();
      setupLatch    = new CountDownLatch(1);
      misses        = new AtomicInteger(0);
      hits          = new AtomicInteger(0);
      currentPaths  = null;
      mutableArray  = null;
      readOnlyArray = null;
   }

   public NidSetBI commit(long time) throws IOException {
      NidSetBI committedSapNids = new NidSet();

      synchronized (uncomittedStampEntries) {
         expandPermit.acquireUninterruptibly();

         try {
            for (int sapNid : uncomittedStampEntries.values()) {
               mutableArray.commitTimes[getMutableIndex(sapNid)] = time;
               stampToIntMap.put(getStatusNid(sapNid), time, getAuthorNid(sapNid), getModuleNid(sapNid),
                                 getPathNid(sapNid), sapNid);
               committedSapNids.add(sapNid);
            }

            uncomittedStampEntries.clear();
         } finally {
            expandPermit.release();
         }
      }

      sync();

      return committedSapNids;
   }

   @Override
   protected void init() throws IOException {
      preloadBoth();
      sequence = new AtomicInteger(Integer.MIN_VALUE + 1);

      DatabaseEntry theKey = new DatabaseEntry();

      IntegerBinding.intToEntry(0, theKey);

      DatabaseEntry theData = new DatabaseEntry();

      try {
         if (readOnly.get(null, theKey, theData, LockMode.READ_UNCOMMITTED) == OperationStatus.SUCCESS) {
            readOnlyArray = positionArrayBinder.entryToObject(theData);
         } else {
            readOnlyArray = new PositionArrays();
         }

         if (mutable.get(null, theKey, theData, LockMode.READ_UNCOMMITTED) == OperationStatus.SUCCESS) {
            mutableArray = positionArrayBinder.entryToObject(theData);
         } else {
            mutableArray = new PositionArrays();
         }

         int size         = getPositionCount();
         int readOnlySize = readOnlyArray.getSize();
         int mutableSize  = mutableArray.getSize();

         sequence.set(Math.max(size, 1));
         stampToIntMap = new StampToIntHashMap(sequence.get());

         for (int i = 0; i < readOnlySize; i++) {
            if (readOnlyArray.commitTimes[i] != 0) {
               stampToIntMap.put(readOnlyArray.statusNids[i], readOnlyArray.commitTimes[i],
                                 readOnlyArray.authorNids[i], readOnlyArray.moduleNids[i],
                                 readOnlyArray.pathNids[i], i);
            }
         }

         closeReadOnly();

         for (int i = 0; i < mutableSize; i++) {
            int mutableIndex = i + readOnlySize;

            assert i < mutableArray.commitTimes.length :
                   " mutableIndex: " + mutableIndex + " commitTimes.length: "
                   + mutableArray.commitTimes.length;
            assert i < mutableArray.statusNids.length :
                   " mutableIndex: " + mutableIndex + " statusNids.length: " + mutableArray.statusNids.length;
            assert i < mutableArray.pathNids.length :
                   " mutableIndex: " + mutableIndex + " pathNids.length: " + mutableArray.pathNids.length;

            if (mutableArray.commitTimes[i] != 0) {
               stampToIntMap.put(mutableArray.statusNids[i], mutableArray.commitTimes[i],
                                 mutableArray.authorNids[i], mutableArray.moduleNids[i],
                                 mutableArray.pathNids[i], mutableIndex);
            }
         }

         if (size == 0) {
            initialPosition = 1;
         } else if ((readOnlyArray.size > 0) && (readOnlyArray.pathNids[0] == 0)) {
            initialPosition = 1;
         } else if ((readOnlyArray.size == 0) && (mutableArray.pathNids[0] == 0)) {
            initialPosition = 1;
         } else {
            initialPosition = 0;
         }

         setupLatch.countDown();
      } catch (DatabaseException e) {
         throw new IOException(e);
      }
   }

   public static void reportStats() {
      float hitStat = hits.get();
      float misStat = misses.get();
      float percent = hitStat / (misStat + hitStat);

      System.out.println("hits: " + (int) hitStat + " misses: " + (int) misStat);
      System.out.println("hit %: " + percent);
   }

   public static void reset() {
      hits.set(0);
      misses.set(0);
      initialPosition = -1;
      currentPaths    = null;
   }

   @Override
   public void sync() throws IOException {
      expandPermit.acquireUninterruptibly();

      try {
         DatabaseEntry valueEntry = new DatabaseEntry();

         positionArrayBinder.objectToEntry(mutableArray, valueEntry);

         DatabaseEntry theKey = new DatabaseEntry();

         IntegerBinding.intToEntry(0, theKey);
         mutable.put(null, theKey, valueEntry);
         super.sync();
      } finally {
         expandPermit.release();
      }
   }

   //~--- get methods ---------------------------------------------------------

   public int getAuthorNid(int sapNid) {
      if (sapNid < 0) {
         return Integer.MIN_VALUE;
      }

      if (sapNid < readOnlyArray.getSize()) {
         return readOnlyArray.authorNids[sapNid];
      } else {
         return mutableArray.authorNids[getMutableIndex(sapNid)];
      }
   }

   public static Set<Integer> getCurrentPaths() {
      try {
         currentPaths = Bdb.getPathManager().getPathNids();

         return currentPaths;
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   @Override
   protected String getDbName() {
      return "stampDb";
   }

   public static int getInitialPosition() {
      try {
         setupLatch.await();
      } catch (InterruptedException ex) {
         AceLog.getAppLog().alertAndLogException(ex);
      }

      return initialPosition;
   }

   public int getModuleNid(int sapNid) {
      if (sapNid < 0) {
         return Integer.MIN_VALUE;
      }

      if (sapNid < readOnlyArray.getSize()) {
         return readOnlyArray.moduleNids[sapNid];
      } else {
         return mutableArray.moduleNids[getMutableIndex(sapNid)];
      }
   }

   private int getMutableIndex(int index) {
      return index - readOnlyArray.getSize();
   }

   public int getPathNid(int index) {
      if (index < 0) {
         return Integer.MIN_VALUE;
      }

      if (index < readOnlyArray.getSize()) {
         return readOnlyArray.pathNids[index];
      } else {
         return mutableArray.pathNids[getMutableIndex(index)];
      }
   }

   public PositionBI getPosition(int sapNid) throws IOException {
      int  status;
      int  author;
      int  pathNid;
      long time;

      if (sapNid < readOnlyArray.getSize()) {
         pathNid = readOnlyArray.pathNids[sapNid];
         time    = readOnlyArray.commitTimes[sapNid];
         status  = readOnlyArray.statusNids[sapNid];
         author  = readOnlyArray.authorNids[sapNid];
      } else {
         int mutableIndex = getMutableIndex(sapNid);

         pathNid = mutableArray.pathNids[mutableIndex];
         time    = mutableArray.commitTimes[mutableIndex];
         status  = mutableArray.statusNids[mutableIndex];
         author  = mutableArray.authorNids[mutableIndex];
      }

      if (pathNid == 0) {
         AceLog.getAppLog().severe("readOnly: " + (sapNid < readOnlyArray.getSize()) + " pathNid == 0 "
                                   + "sapNid == " + sapNid + " time: " + time + " status == " + status
                                   + " author: " + author);
      }

      PathBI path = Bdb.getPathManager().get(pathNid);

      return new Position(time, path);
   }

   public int getPositionCount() {
      return readOnlyArray.getSize() + mutableArray.getSize();
   }

   public int getReadOnlyMax() {
      return readOnlyArray.size - 1;
   }

   public int getSapNid(Stamp tsp) {
      return getSapNid(tsp.getStatusNid(), tsp.getTime(), tsp.getAuthorNid(), tsp.getModuleNid(),
                       tsp.getPathNid());
   }

   public int getSapNid(int statusNid, long time, int authorNid, int moduleNid, int pathNid) {
      if (time == Long.MAX_VALUE) {
         UncommittedStatusForPath usp = new UncommittedStatusForPath(statusNid, authorNid, pathNid,
                                           moduleNid);

         if (uncomittedStampEntries.containsKey(usp)) {
            return uncomittedStampEntries.get(usp);
         } else {
            expandPermit.acquireUninterruptibly();

            try {
               if (uncomittedStampEntries.containsKey(usp)) {
                  return uncomittedStampEntries.get(usp);
               }

               int statusAtPositionNid = sequence.getAndIncrement();

               mutableArray.setSize(getMutableIndex(statusAtPositionNid) + 1);
               mutableArray.statusNids[getMutableIndex(statusAtPositionNid)]  = statusNid;
               mutableArray.authorNids[getMutableIndex(statusAtPositionNid)]  = authorNid;
               mutableArray.pathNids[getMutableIndex(statusAtPositionNid)]    = pathNid;
               mutableArray.moduleNids[getMutableIndex(statusAtPositionNid)]  = moduleNid;
               mutableArray.commitTimes[getMutableIndex(statusAtPositionNid)] = time;
               uncomittedStampEntries.put(usp, statusAtPositionNid);
               hits.incrementAndGet();

               return statusAtPositionNid;
            } finally {
               expandPermit.release();
            }
         }
      }

      if (stampToIntMap.containsKey(statusNid, time, authorNid, moduleNid, pathNid)) {
         hits.incrementAndGet();

         return stampToIntMap.get(statusNid, time, authorNid, moduleNid, pathNid);
      }

      expandPermit.acquireUninterruptibly();

      try {

         // Try one last time...
         if (stampToIntMap.containsKey(statusNid, time, authorNid, moduleNid, pathNid)) {
            hits.incrementAndGet();

            return stampToIntMap.get(statusNid, time, authorNid, moduleNid, pathNid);
         }

         int statusAtPositionNid = sequence.getAndIncrement();

         mutableArray.setSize(getMutableIndex(statusAtPositionNid) + 1);
         mutableArray.statusNids[getMutableIndex(statusAtPositionNid)]  = statusNid;
         mutableArray.authorNids[getMutableIndex(statusAtPositionNid)]  = authorNid;
         mutableArray.pathNids[getMutableIndex(statusAtPositionNid)]    = pathNid;
         mutableArray.moduleNids[getMutableIndex(statusAtPositionNid)]  = moduleNid;
         mutableArray.commitTimes[getMutableIndex(statusAtPositionNid)] = time;
         stampToIntMap.put(statusNid, time, authorNid, moduleNid, pathNid, statusAtPositionNid);
         misses.incrementAndGet();

         return statusAtPositionNid;
      } catch (Throwable e) {
         throw new RuntimeException(e);
      } finally {
         expandPermit.release();
      }
   }

   public NidSetBI getSpecifiedSapNids(NidSetBI pathIds, long startTime, long endTime) {
      NidSetBI            specifiedSapNids = new NidSet();
      Collection<Integer> values           = stampToIntMap.values();

      if ((pathIds != null) && (pathIds.size() > 0)) {
         for (int sapNid : values) {
            if (pathIds.contains(getPathNid(sapNid))) {
               checkTimeAndAdd(startTime, endTime, specifiedSapNids, sapNid);
            }
         }
      } else {
         for (int sapNid : values) {
            checkTimeAndAdd(startTime, endTime, specifiedSapNids, sapNid);
         }
      }

      return specifiedSapNids;
   }

   public int getStatusNid(int index) {
      if (index < 0) {
         return Integer.MIN_VALUE;
      }

      if (index < readOnlyArray.getSize()) {
         return readOnlyArray.statusNids[index];
      } else {
         return mutableArray.statusNids[getMutableIndex(index)];
      }
   }

   public long getTime(int index) {
      if (index == Integer.MAX_VALUE) {
         throw new RuntimeException("index == Integer.MAX_VALUE");
      }

      if (index < 0) {
         return Long.MIN_VALUE;
      }

      if (index < readOnlyArray.getSize()) {
         return readOnlyArray.commitTimes[index];
      } else {
         return mutableArray.commitTimes[getMutableIndex(index)];
      }
   }

   //~--- inner classes -------------------------------------------------------

   private static class PositionArrayBinder extends TupleBinding<PositionArrays> {
      @Override
      public PositionArrays entryToObject(TupleInput input) {
         int            size   = input.readInt();
         int            length = input.readInt();
         PositionArrays pa     = new PositionArrays(length);

         for (int i = 0; i < length; i++) {
            pa.statusNids[i]  = input.readInt();
            pa.authorNids[i]  = input.readInt();
            pa.pathNids[i]    = input.readInt();
            pa.moduleNids[i]  = input.readInt();
            pa.commitTimes[i] = input.readLong();
         }

         pa.size = size;

         return pa;
      }

      @Override
      public void objectToEntry(PositionArrays pa, TupleOutput output) {
         output.writeInt(pa.size);
         output.writeInt(pa.pathNids.length);

         for (int i = 0; i < pa.pathNids.length; i++) {
            output.writeInt(pa.statusNids[i]);
            output.writeInt(pa.authorNids[i]);
            output.writeInt(pa.pathNids[i]);
            output.writeInt(pa.moduleNids[i]);
            output.writeLong(pa.commitTimes[i]);
         }
      }
   }


   private static class PositionArrays {
      int    size = 0;
      int[]  authorNids;
      long[] commitTimes;
      int[]  moduleNids;
      int[]  pathNids;
      int[]  statusNids;

      //~--- constructors -----------------------------------------------------

      public PositionArrays() {
         statusNids  = new int[MIN_ARRAY_SIZE];
         authorNids  = new int[MIN_ARRAY_SIZE];
         pathNids    = new int[MIN_ARRAY_SIZE];
         moduleNids  = new int[MIN_ARRAY_SIZE];
         commitTimes = new long[MIN_ARRAY_SIZE];
         this.size   = 0;
      }

      public PositionArrays(int size) {
         statusNids  = new int[size];
         authorNids  = new int[size];
         pathNids    = new int[size];
         moduleNids  = new int[size];
         commitTimes = new long[size];
         this.size   = size;
      }

      //~--- methods ----------------------------------------------------------

      private void ensureCapacity(int size) {
         if (size > getCapacity()) {
            int   newCapacity    = pathNids.length + MIN_ARRAY_SIZE;
            int[] tempStatusNids = new int[newCapacity];

            System.arraycopy(statusNids, 0, tempStatusNids, 0, statusNids.length);
            statusNids = tempStatusNids;

            int[] tempAuthorhNids = new int[newCapacity];

            System.arraycopy(authorNids, 0, tempAuthorhNids, 0, authorNids.length);
            authorNids = tempAuthorhNids;

            int[] tempPathNids = new int[newCapacity];

            System.arraycopy(pathNids, 0, tempPathNids, 0, pathNids.length);
            pathNids = tempPathNids;

            int[] tempModuleNids = new int[newCapacity];

            System.arraycopy(moduleNids, 0, tempModuleNids, 0, moduleNids.length);
            moduleNids = tempModuleNids;

            long[] tempCommitTimes = new long[newCapacity];

            System.arraycopy(commitTimes, 0, tempCommitTimes, 0, commitTimes.length);
            commitTimes = tempCommitTimes;
         }
      }

      //~--- get methods ------------------------------------------------------

      private int getCapacity() {
         return pathNids.length;
      }

      private int getSize() {
         return size;
      }

      //~--- set methods ------------------------------------------------------

      private void setSize(int size) {
         this.size = size;
         ensureCapacity(size);
      }
   }
}
