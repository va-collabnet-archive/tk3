package org.ihtsdo.bdb.id;

import com.sleepycat.bind.tuple.IntegerBinding;
import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;
import com.sleepycat.je.Cursor;
import com.sleepycat.je.CursorConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import org.ihtsdo.bdb.Bdb;
import org.ihtsdo.bdb.ComponentBdb;
import org.ihtsdo.bdb.temp.AceLog;
import org.ihtsdo.cern.colt.map.OpenIntIntHashMap;
import org.ihtsdo.concurrency.ConcurrentReentrantLocks;

/**
 * <h2>Implementation Details</h2>
 * The <code>nid</code> is the <code>(nid - Integer.MIN_VALUE)</code> index into an <code>int[]</code>
 * which stores the cNid and the sequence  of a component. The sequence is contiguous, starts at 0,
 * and can be used as an index for that component into an array containing data for just that component type).
 * <br/>
 * <br/>The array is twice the size of the number if nids in the array, and the cNid is stored in first
 * integer and the sequence is stored in the second. So for any given nid index, the cNid is stored at location
 * <code>index * 2</code>, and the sequence is stored at <code>index * 2 + 1</code>.
 *
 * <br>
 * <br>This single array approach is taken because Java stores multidimensional arrays as arrays of arrays,
 * rather than a contiguous block of arrays. Each array has an overhead of 96 bits (above and beyond its
 * data), which doubles the memory size, and also increases the burden on the garbage collector.
 *
 *
 * @author kec
 *
 */
public class NidCNidMapBdb extends ComponentBdb {
   private static final int NID_CNID_MAP_SIZE = 50000;

   //~--- fields --------------------------------------------------------------

   private ReentrantReadWriteLock     rwl           = new ReentrantReadWriteLock();
   private ConcurrentReentrantLocks   sequenceLocks = new ConcurrentReentrantLocks(128);
   private AtomicInteger              conceptSequence;
   private AtomicReference<int[][][]> indexCacheRecords;
   private boolean[]                  mapChanged;
   private AtomicReference<int[][]>   nidCNidMaps;
   private int                        readOnlyRecords;
   private AtomicInteger              relationshipSequence;

   //~--- constructors --------------------------------------------------------

   public NidCNidMapBdb(Bdb readOnlyBdbEnv, Bdb mutableBdbEnv) throws IOException {
      super(readOnlyBdbEnv, mutableBdbEnv);
   }

   //~--- enums ---------------------------------------------------------------

   public enum SequenceType {
      RELATIONSHIP, CONCEPT;

      public String getPropertyName() {
         return SequenceType.class.getName().concat(this.name());
      }

      public AtomicInteger getSequenceValue() throws IOException {
         String propertyValue = Bdb.getProperty(this.getPropertyName());

         if (propertyValue == null) {
            return new AtomicInteger(0);
         }

         return new AtomicInteger(Integer.parseInt(propertyValue));
      }

      //~--- set methods ------------------------------------------------------

      public void setSequenceValue(AtomicInteger sequence) throws IOException {
         Bdb.setProperty(this.getPropertyName(), sequence.toString());
      }
   }

   ;

   //~--- methods -------------------------------------------------------------

   @Override
   public void close() {
      try {
         sync();
      } catch (IOException e) {
         AceLog.getAppLog().severe(e.getLocalizedMessage(), e);
      }

      super.close();
   }

   private void ensureCapacity(int nextId) throws IOException {
      long next           = nextId;
      long numIds         = (next - Integer.MIN_VALUE);
      long maps           = numIds / NID_CNID_MAP_SIZE;
      int  nidCidMapCount = (int) maps + 1;

      rwl.readLock().lock();

      try {
         if (nidCidMapCount > nidCNidMaps.get().length) {
            rwl.readLock().unlock();
            rwl.writeLock().lock();

            if (nidCidMapCount > nidCNidMaps.get().length) {
               try {
                  expandCapacity(nidCidMapCount);
               } finally {
                  rwl.readLock().lock();
                  rwl.writeLock().unlock();
               }
            } else {
               rwl.readLock().lock();
               rwl.writeLock().unlock();
            }
         }
      } finally {
         rwl.readLock().unlock();
      }
   }

   private void expandCapacity(int nidCidMapCount) throws IOException {
      int       oldCount             = nidCNidMaps.get().length;
      int[][]   newNidCidMaps        = new int[nidCidMapCount][];
      int[][][] newIndexCacheRecords = new int[nidCidMapCount][][];
      boolean[] newMapChanged        = new boolean[nidCidMapCount];

      for (int i = 0; i < oldCount; i++) {
         newIndexCacheRecords[i] = indexCacheRecords.get()[i];
         newNidCidMaps[i]        = nidCNidMaps.get()[i];
         newMapChanged[i]        = mapChanged[i];
      }

      for (int i = oldCount; i < nidCidMapCount; i++) {
         if (AceLog.getAppLog().isLoggable(Level.FINE)) {
            AceLog.getAppLog().fine("Expanding NidCidMaps to: " + (i + 1));
         }

         newIndexCacheRecords[i] = new int[NID_CNID_MAP_SIZE][];
         newNidCidMaps[i]        = new int[NID_CNID_MAP_SIZE * 2];
         newMapChanged[i]        = true;
         Arrays.fill(newNidCidMaps[i], Integer.MAX_VALUE);
      }

      indexCacheRecords.set(newIndexCacheRecords);
      nidCNidMaps.set(newNidCidMaps);
      mapChanged = newMapChanged;
   }

   @Override
   protected void init() throws IOException {
      relationshipSequence = SequenceType.RELATIONSHIP.getSequenceValue();
      conceptSequence      = SequenceType.CONCEPT.getSequenceValue();
      preloadBoth();

      int maxId = Bdb.getUuidsToNidMap().getCurrentMaxNid();

      readOnlyRecords = (int) readOnly.count();

      int mutableRecords = (int) mutable.count();

      AceLog.getAppLog().info("NidCidMap readOnlyRecords: " + readOnlyRecords);
      AceLog.getAppLog().info("NidCidMap mutableRecords: " + mutableRecords);

      int nidCidMapCount = ((maxId - Integer.MIN_VALUE) / NID_CNID_MAP_SIZE) + 1;

      nidCNidMaps = new AtomicReference<>(new int[nidCidMapCount][]);
      indexCacheRecords = new AtomicReference<>(new int[nidCidMapCount][][]);
      mapChanged  = new boolean[nidCidMapCount];
      Arrays.fill(mapChanged, false);

      for (int index = 0; index < nidCidMapCount; index++) {
         nidCNidMaps.get()[index] = new int[NID_CNID_MAP_SIZE * 2];
         indexCacheRecords.get()[index] = new int[NID_CNID_MAP_SIZE][];
         Arrays.fill(nidCNidMaps.get()[index], Integer.MAX_VALUE);
      }

      readMaps(readOnly, true);
      closeReadOnly();
      readMaps(mutable, false);

      if (AceLog.getAppLog().isLoggable(Level.FINE)) {
         printKeys("Read only keys: ", readOnly);
         printKeys("Mutable keys: ", mutable);
      }

      rwl = new ReentrantReadWriteLock();
   }

   private void printKeys(String prefix, Database db) {
      int               size         = (int) db.count();
      OpenIntIntHashMap nidMap       = new OpenIntIntHashMap(size + 2);
      CursorConfig      cursorConfig = new CursorConfig();

      cursorConfig.setReadUncommitted(true);

      try (Cursor cursor = db.openCursor(null, cursorConfig)) {
         DatabaseEntry foundKey  = new DatabaseEntry();
         DatabaseEntry foundData = new DatabaseEntry();

         foundData.setPartial(true);
         foundData.setPartial(0, 0, true);

         int max = Integer.MIN_VALUE;

         while (cursor.getNext(foundKey, foundData, LockMode.READ_UNCOMMITTED) == OperationStatus.SUCCESS) {
            int cNid = IntegerBinding.entryToInt(foundKey);

            nidMap.put(cNid, cNid);
            max = Math.max(max, cNid);
         }

         cursor.close();
         AceLog.getAppLog().fine(prefix + nidMap.keys().toList().toString());
      }
   }

   public void putIndexCacheRecord(int cNid, int[] indexCacheRecord) {
      assert cNid != Integer.MAX_VALUE;

      int mapIndex       = (cNid - Integer.MIN_VALUE) / NID_CNID_MAP_SIZE;
      int cNidIndexInMap = (cNid - Integer.MIN_VALUE) % NID_CNID_MAP_SIZE;

      indexCacheRecords.get()[mapIndex][cNidIndexInMap] = indexCacheRecord;
      mapChanged[mapIndex]                              = true;
   }

   private void readMaps(Database db, boolean readOnly) {
      CursorConfig cursorConfig = new CursorConfig();

      cursorConfig.setReadUncommitted(true);

      try (Cursor cursor = db.openCursor(null, cursorConfig)) {
         DatabaseEntry foundKey  = new DatabaseEntry();
         DatabaseEntry foundData = new DatabaseEntry();

         while (cursor.getNext(foundKey, foundData, LockMode.READ_UNCOMMITTED) == OperationStatus.SUCCESS) {
            int        index = IntegerBinding.entryToInt(foundKey);
            TupleInput ti    = new TupleInput(foundData.getData());
            int        j     = 0;
            int        k     = 0;

            while (ti.available() > 0) {
               nidCNidMaps.get()[index][j++] = ti.readInt();
               nidCNidMaps.get()[index][j++] = ti.readSortedPackedInt();

               int length = ti.readSortedPackedInt();

               if (length != 0) {
                  int[] cacheData = new int[length];

                  for (int i = 0; i < length; i++) {
                     cacheData[i] = ti.readInt();
                  }

                  indexCacheRecords.get()[index][k++] = cacheData;
               }
            }
         }
      }
   }

   public void resetCidForNid(int cNid, int nid) throws IOException {
      assert cNid != Integer.MAX_VALUE;

      int mapIndex = (nid - Integer.MIN_VALUE) / NID_CNID_MAP_SIZE;

      assert mapIndex >= 0 : "cNid: " + cNid + " nid: " + nid + " mapIndex: " + mapIndex;

      int cNidIndexInMap = (nid - Integer.MIN_VALUE) % NID_CNID_MAP_SIZE * 2;

      assert cNidIndexInMap < NID_CNID_MAP_SIZE * 2 :
             "cNid: " + cNid + " nid: " + nid + " mapIndex: " + mapIndex + " cNidIndexInMap: "
             + cNidIndexInMap;
      ensureCapacity(nid);

      if ((nidCNidMaps.get() != null) && (nidCNidMaps.get()[mapIndex] != null)) {
         if (nidCNidMaps.get()[mapIndex][cNidIndexInMap] != cNid) {
            nidCNidMaps.get()[mapIndex][cNidIndexInMap] = cNid;
            mapChanged[mapIndex]                        = true;
         }
      } else {
         if (nidCNidMaps.get() == null) {
            throw new IOException("Null nidCidMap: ");
         }

         throw new IOException("nidCidMap[" + mapIndex + "] " + "is null. cNid: " + cNid + " nid: " + nid);
      }
   }

   @Override
   public void sync() throws IOException {
      writeChangedMaps();
      super.sync();
   }

   private void writeChangedMaps() throws IOException {
      rwl.writeLock().lock();

      try {
         SequenceType.RELATIONSHIP.setSequenceValue(relationshipSequence);
         SequenceType.CONCEPT.setSequenceValue(conceptSequence);

         DatabaseEntry keyEntry = new DatabaseEntry();
         int           mapCount = nidCNidMaps.get().length;

         found:
         for (int key = 0; key < mapCount; key++) {
            if (mapChanged[key]) {
               IntegerBinding.intToEntry(key, keyEntry);

               // NID_CNID_MAP_SIZE * 4 * 2 = 4 bytes per integer, 2 integers per nid
               TupleOutput output = new TupleOutput(new byte[NID_CNID_MAP_SIZE * 4 * 2]);

               for (int i = 0; i < NID_CNID_MAP_SIZE; ) {
                  output.writeInt(nidCNidMaps.get()[key][i * 2]);
                  output.writeSortedPackedInt(nidCNidMaps.get()[key][i * 2 + 1]);

                  int[] cacheRecord = indexCacheRecords.get()[key][i];

                  if (cacheRecord == null) {
                     output.writeSortedPackedInt(0);
                  } else {
                     output.writeSortedPackedInt(cacheRecord.length);

                     for (int j = 0; j < cacheRecord.length; j++) {
                        output.writeInt(cacheRecord[j]);
                     }
                  }
               }

               DatabaseEntry   valueEntry = new DatabaseEntry(output.toByteArray());
               OperationStatus status     = mutable.put(null, keyEntry, valueEntry);

               if (status != OperationStatus.SUCCESS) {
                  throw new IOException("Unsuccessful operation: " + status);
               }

               mapChanged[key] = false;
            }
         }
      } finally {
         rwl.writeLock().unlock();
      }
   }

   //~--- get methods ---------------------------------------------------------

   public int getCNid(int nid) {
      assert nid != Integer.MAX_VALUE;

      int mapIndex      = (nid - Integer.MIN_VALUE) / NID_CNID_MAP_SIZE;
      int nidIndexInMap = ((nid - Integer.MIN_VALUE) % NID_CNID_MAP_SIZE) * 2;

      assert(mapIndex >= 0) && (nidIndexInMap >= 0) :
            "mapIndex: " + mapIndex + " indexInMap: " + nidIndexInMap + " nid: " + nid;

      if (mapIndex >= nidCNidMaps.get().length) {
         return Integer.MAX_VALUE;
      }

      return nidCNidMaps.get()[mapIndex][nidIndexInMap];
   }

   @Override
   protected String getDbName() {
      return "NidCidMap";
   }

   public int getSequence(int nid, SequenceType sequenceType) throws IOException {
      assert nid != Integer.MAX_VALUE;

      int mapIndex           = (nid - Integer.MIN_VALUE) / NID_CNID_MAP_SIZE;
      int nidIndexInMap      = ((nid - Integer.MIN_VALUE) % NID_CNID_MAP_SIZE) * 2;
      int sequenceIndexInMap = nidIndexInMap + 1;

      assert(mapIndex >= 0) && (nidIndexInMap >= 0) :
            "mapIndex: " + mapIndex + " nidIndexInMap: " + nidIndexInMap + " nid: " + nid;

      if (mapIndex >= nidCNidMaps.get().length) {
         return Integer.MAX_VALUE;
      }

      int sequence = nidCNidMaps.get()[mapIndex][sequenceIndexInMap];

      if (sequence != Integer.MAX_VALUE) {
         return sequence;
      }

      return setSequenceForNid(nid, sequenceType);
   }

   public boolean hasConcept(int cNid) {
      assert cNid > Integer.MIN_VALUE : "Invalid cNid == Integer.MIN_VALUE: " + cNid;
      assert cNid <= Bdb.getUuidsToNidMap().getCurrentMaxNid() :
             "Invalid cNid: " + cNid + " currentMax: " + Bdb.getUuidsToNidMap().getCurrentMaxNid();

      int mapIndex       = (cNid - Integer.MIN_VALUE) / NID_CNID_MAP_SIZE;
      int cNidIndexInMap = ((cNid - Integer.MIN_VALUE) % NID_CNID_MAP_SIZE) * 2;

      if ((mapIndex < 0) || (mapIndex >= nidCNidMaps.get().length)) {
         return false;
      }

      if ((cNidIndexInMap < 0) || (cNidIndexInMap >= NID_CNID_MAP_SIZE * 2)) {
         return false;
      }

      if (nidCNidMaps.get()[mapIndex][cNidIndexInMap] == cNid) {
         return true;
      }

      return false;
   }

   public boolean hasMap(int nid) {
      int mapIndex           = (nid - Integer.MIN_VALUE) / NID_CNID_MAP_SIZE;
      int nidIndexInMap      = ((nid - Integer.MIN_VALUE) % NID_CNID_MAP_SIZE) * 2;
      int sequenceIndexInMap = nidIndexInMap + 1;

      if ((mapIndex < nidCNidMaps.get().length) && (nidIndexInMap < NID_CNID_MAP_SIZE * 2)) {
         if (nidCNidMaps.get()[mapIndex][sequenceIndexInMap] < Integer.MAX_VALUE) {
            return true;
         }
      }

      return false;
   }

   //~--- set methods ---------------------------------------------------------

   public void setCNidForNid(int cNid, int nid) throws IOException {
      assert cNid != Integer.MAX_VALUE;

      int mapIndex = (nid - Integer.MIN_VALUE) / NID_CNID_MAP_SIZE;

      assert mapIndex >= 0 : "cNid: " + cNid + " nid: " + nid + " mapIndex: " + mapIndex;

      int nidIndexInMap = ((nid - Integer.MIN_VALUE) % NID_CNID_MAP_SIZE) * 2;

      assert nidIndexInMap < NID_CNID_MAP_SIZE * 2 :
             "cNid: " + cNid + " nid: " + nid + " mapIndex: " + mapIndex + " nidIndexInMap: " + nidIndexInMap;
      assert(cNid == nid) || hasConcept(cNid) : cNid + " is not a concept nid. nid: " + nid;
      ensureCapacity(nid);

      int[][] nidCNidMapArrays = nidCNidMaps.get();

      assert(nidCNidMapArrays[mapIndex][nidIndexInMap] == Integer.MAX_VALUE)
            || ((int) (nidCNidMapArrays[mapIndex][nidIndexInMap]) == cNid) :
            "processing cNid: " + cNid + " " + Bdb.getUuidsToNidMap().getUuidsForNid(cNid) + " nid: " + nid
            + " found existing cNid: " + ((int) nidCNidMapArrays[mapIndex][nidIndexInMap]) + " "
            + Bdb.getUuidsToNidMap().getUuidsForNid((int) nidCNidMapArrays[mapIndex][nidIndexInMap])
            + "\n    " + cNid + " maps to: " + getCNid(cNid) + "\n    "
            + ((int) nidCNidMapArrays[mapIndex][nidIndexInMap]) + " maps to: "
            + getCNid((int) nidCNidMapArrays[mapIndex][nidIndexInMap]);

      if ((nidCNidMapArrays != null) && (nidCNidMapArrays[mapIndex] != null)) {
         if (nidCNidMapArrays[mapIndex][nidIndexInMap] != cNid) {
            nidCNidMapArrays[mapIndex][nidIndexInMap] = cNid;

            if (cNid == nid) {
               setSequenceForNid(nid, SequenceType.CONCEPT);
            }

            mapChanged[mapIndex] = true;
         }
      } else {
         if (nidCNidMapArrays == null) {
            throw new IOException("Null nidCidMap: ");
         }

         throw new IOException("nidCidMap[" + mapIndex + "] " + "is null. cNid: " + cNid + " nid: " + nid);
      }
   }

   private int setSequenceForNid(int sequence, int nid) throws IOException {
      assert sequence != Integer.MAX_VALUE;

      int mapIndex = (nid - Integer.MIN_VALUE) / NID_CNID_MAP_SIZE;

      assert mapIndex >= 0 : "sequence: " + sequence + " nid: " + nid + " mapIndex: " + mapIndex;

      int nidIndexInMap      = ((nid - Integer.MIN_VALUE) % NID_CNID_MAP_SIZE) * 2;
      int sequenceIndexInMap = nidIndexInMap + 1;

      assert sequenceIndexInMap < NID_CNID_MAP_SIZE * 2 :
             "sequence: " + sequence + " nid: " + nid + " mapIndex: " + mapIndex + " sequenceIndexInMap: "
             + sequenceIndexInMap;

      if ((nidCNidMaps.get() != null) && (nidCNidMaps.get()[mapIndex] != null)) {
         if (nidCNidMaps.get()[mapIndex][sequenceIndexInMap] != sequence) {
            if (nidCNidMaps.get()[mapIndex][sequenceIndexInMap] != Integer.MAX_VALUE) {
               throw new RuntimeException("Resetting sequence from "
                                          + nidCNidMaps.get()[mapIndex][sequenceIndexInMap] + " to: "
                                          + sequence + " for " + nid);
            }

            nidCNidMaps.get()[mapIndex][sequenceIndexInMap] = sequence;
            mapChanged[mapIndex]                            = true;
         }
      } else {
         if (nidCNidMaps.get() == null) {
            throw new IOException("Null nidCidMap: ");
         }

         throw new IOException("nidCidMap[" + mapIndex + "] " + "is null. sequence: " + sequence + " nid: "
                               + nid);
      }

      return sequence;
   }

   private int setSequenceForNid(int nid, SequenceType sequenceType) throws IOException {
      sequenceLocks.lock(nid);

      try {
         switch (sequenceType) {
         case RELATIONSHIP :
            return setSequenceForNid(relationshipSequence.getAndIncrement(), nid);

         case CONCEPT :
            return setSequenceForNid(relationshipSequence.getAndIncrement(), nid);

         default :
            throw new UnsupportedOperationException("No support for sequence: " + sequenceType);
         }
      } finally {
         sequenceLocks.unlock(nid);
      }
   }
}
