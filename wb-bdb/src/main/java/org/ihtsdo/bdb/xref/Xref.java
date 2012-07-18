package org.ihtsdo.bdb.xref;

import com.sleepycat.bind.tuple.LongBinding;
import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;
import com.sleepycat.je.Cursor;
import com.sleepycat.je.CursorConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.ihtsdo.bdb.Bdb;
import org.ihtsdo.bdb.ComponentBdb;
import org.ihtsdo.bdb.concept.I_ProcessUnfetchedConceptData;
import org.ihtsdo.bdb.concept.ParallelConceptIterator;
import org.ihtsdo.cc.NidPair;
import org.ihtsdo.cc.NidPairForRefex;
import org.ihtsdo.cc.NidPairForRel;
import org.ihtsdo.cc.change.LastChange;
import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.concurrency.ConcurrentReentrantLocks;
import org.ihtsdo.tk.api.ConceptFetcherBI;
import org.ihtsdo.tk.api.NidBitSetBI;
import org.ihtsdo.tk.api.NidSetBI;

/**
 * All data for an individual component will be in the mutable, if modified
 * after the baseline (the baseline xref will be copied to mutable when a new
 * pair is added). Otherwise, all pairs (if any) will be in the read-only
 * database.
 *
 * @author kec
 *
 */
public class Xref extends ComponentBdb implements I_ProcessUnfetchedConceptData {
   private ConcurrentReentrantLocks                            locks = new ConcurrentReentrantLocks(128);
   private AtomicReference<ConcurrentHashMap<Integer, long[]>> mutableXref;
   private HashMap<Integer, long[]>                            readOnlyXref;
   private ReentrantReadWriteLock                              rwl;

   //~--- constructors --------------------------------------------------------

   public Xref(Bdb readOnlyBdbEnv, Bdb mutableBdbEnv) throws IOException {
      super(readOnlyBdbEnv, mutableBdbEnv);
   }

   //~--- methods -------------------------------------------------------------

   public void addPair(int nid, NidPair pair) {

      // only need a read lock for sync,
      // since underlying structure is concurrent...
      rwl.readLock().lock();
      locks.lock(nid);

      try {
         LastChange.touchXref(nid);

         long pairAsLong = pair.asLong();

         assert pairAsLong != 0;

         long[] currentPairs = mutableXref.get().get(nid);

         if (currentPairs == null) {
            currentPairs = readOnlyXref.get(nid);
         }

         long[] newPairs;

         if (currentPairs == null) {
            newPairs     = new long[] { pairAsLong };
            currentPairs = mutableXref.get().putIfAbsent(nid, newPairs);

            if (currentPairs == null) {
               return;
            }
         }

         if (mutableXref.get().get(nid) == null) {

            // copy readOnlyXref record over to mutable.
            mutableXref.get().putIfAbsent(nid, currentPairs);
         }

         while (true) {
            int index = Arrays.binarySearch(currentPairs, pairAsLong);

            if (index >= 0) {
               return;    // it's there already.
            }

            int insertionPoint = -index - 1;

            newPairs = new long[currentPairs.length + 1];

            if (insertionPoint > 0) {
               System.arraycopy(currentPairs, 0, newPairs, 0, insertionPoint);
            }

            newPairs[insertionPoint] = pairAsLong;

            if (insertionPoint < currentPairs.length) {
               System.arraycopy(currentPairs, insertionPoint, newPairs, insertionPoint + 1,
                                currentPairs.length - insertionPoint);
            }

            assert Arrays.binarySearch(newPairs, 0) < 0 :
                   "currentPairs: " + Arrays.toString(currentPairs) + "\nnewPairs"
                   + Arrays.toString(newPairs) + "\npairAsLong: " + pairAsLong + "\nindex: " + index
                   + "\ninsertionPoint: " + insertionPoint;

            if (mutableXref.get().replace(nid, currentPairs, newPairs)) {
               return;
            }

            currentPairs = mutableXref.get().get(nid);
         }
      } finally {
         locks.unlock(nid);
         rwl.readLock().unlock();
      }
   }

   @Override
   public boolean continueWork() {
      return true;
   }

   public void forgetPair(int nid, NidPair pair) {

      // only need a read lock for sync,
      // since underlying structure is concurrent...
      rwl.readLock().lock();
      locks.lock(nid);

      try {
         LastChange.touchXref(nid);

         long   pairAsLong   = pair.asLong();
         long[] currentPairs = mutableXref.get().get(nid);

         if (currentPairs == null) {
            currentPairs = readOnlyXref.get(nid);
         }

         long[] newPairs;

         if (currentPairs == null) {

            // nothing to forget
            return;
         }

         if (mutableXref.get().get(nid) == null) {

            // copy readOnlyXref record over to mutable.
            mutableXref.get().putIfAbsent(nid, currentPairs);
         }

         /*
          * public static void arraycopy(Object src, int srcPos, Object dest,
          * int destPos, int length)
          */
         while (true) {
            int index = Arrays.binarySearch(currentPairs, pairAsLong);

            if (index < 0) {
               return;    // it's removed already.
            }

            newPairs = new long[currentPairs.length - 1];

            if (index == 0) {
               System.arraycopy(currentPairs, 1, newPairs, 0, currentPairs.length - 1);
            } else {
               System.arraycopy(currentPairs, 0, newPairs, 0, index);

               if (index < currentPairs.length) {
                  System.arraycopy(currentPairs, index + 1, newPairs, index, currentPairs.length - index - 1);
               }
            }

            if (mutableXref.get().replace(nid, currentPairs, newPairs)) {
               return;
            }

            currentPairs = mutableXref.get().get(nid);
         }
      } catch (Throwable e) {
         throw new RuntimeException(e);
      } finally {
         locks.unlock(nid);
         rwl.readLock().unlock();
      }
   }

   @Override
   protected void init() throws IOException {
      Bdb.xref     = this;
      readOnlyXref = new HashMap<>();
      mutableXref  = new AtomicReference<>(new ConcurrentHashMap<Integer, long[]>());
      rwl          = new ReentrantReadWriteLock();

      if ((readOnly == null) && (mutable.count() == 0)) {
         mutableXref.set(new ConcurrentHashMap<Integer, long[]>(Bdb.getConceptDb().getCount() * 2));

         try {
            Bdb.getConceptDb().iterateConceptDataInParallel(this);
         } catch (Exception e) {
            throw new IOException(e);
         }
      } else {
         readOnlyXref = new HashMap<>(Bdb.getConceptDb().getCount() * 2);
         preloadReadOnly();
         readXref(readOnly);
         closeReadOnly();
         preloadMutable();
         readXref(mutable);
      }
   }

   @Override
   public void processUnfetchedConceptData(int cNid, ConceptFetcherBI fcfc) throws Exception {
      ((Concept) fcfc.fetch()).updateXrefs();
   }

   private void readXref(Database db) {
      if (db == null) {
         return;
      }

      CursorConfig cursorConfig = new CursorConfig();

      cursorConfig.setReadUncommitted(true);

      try (Cursor cursor = db.openCursor(null, cursorConfig)) {
         DatabaseEntry foundKey  = new DatabaseEntry();
         DatabaseEntry foundData = new DatabaseEntry();

         while (cursor.getNext(foundKey, foundData, LockMode.READ_UNCOMMITTED) == OperationStatus.SUCCESS) {
            @SuppressWarnings("unused") long index   = LongBinding.entryToLong(foundKey);
            TupleInput                       ti      = new TupleInput(foundData.getData());
            int                              records = ti.readInt();

            for (int i = 0; i < records; i++) {
               int    nid       = ti.readInt();
               int    xrefSize  = ti.readInt();
               long[] xrefArray = new long[xrefSize];

               for (int j = 0; j < xrefSize; j++) {
                  xrefArray[j] = ti.readLong();
               }

               readOnlyXref.put(nid, xrefArray);
            }
         }
      }
   }

   @Override
   public void sync() throws IOException {
      ConcurrentHashMap<Integer, long[]> oldXref = null;

      rwl.writeLock().lock();

      try {
         if (!mutableXref.get().isEmpty()) {
            ConcurrentHashMap<Integer, long[]> newXref = new ConcurrentHashMap<>();

            oldXref = mutableXref.getAndSet(newXref);
            readOnlyXref.putAll(oldXref);
         }
      } finally {
         rwl.writeLock().unlock();
      }

      if (oldXref != null) {
         long        key    = Bdb.gVersion.incrementAndGet();
         TupleOutput output = new TupleOutput();
         int         size   = oldXref.size();

         output.writeInt(size);

         for (Iterator<Entry<Integer, long[]>> it = oldXref.entrySet().iterator(); it.hasNext(); ) {
            Entry<Integer, long[]> entry = it.next();

            output.writeInt(entry.getKey());

            long[] refs        = entry.getValue();
            int    arrayLength = refs.length;

            output.writeInt(arrayLength);

            for (int i = 0; i < arrayLength; i++) {
               output.writeLong(refs[i]);
            }
         }

         DatabaseEntry keyEntry = new DatabaseEntry();

         LongBinding.longToEntry(key, keyEntry);

         DatabaseEntry   valueEntry = new DatabaseEntry(output.toByteArray());
         OperationStatus status     = mutable.put(null, keyEntry, valueEntry);

         if (status != OperationStatus.SUCCESS) {
            throw new IOException("Unsuccessful operation: " + status);
         }
      }

      super.sync();
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   protected String getDbName() {
      return "xref";
   }

   public int[] getDestRelOrigins(int cNid, NidSetBI relTypes) {
      rwl.readLock().lock();    // only need a read lock for sync,

      // since underlying structure is concurrent...
      try {
         long[] allPairs = mutableXref.get().get(cNid);

         if (allPairs == null) {
            allPairs = readOnlyXref.get(cNid);
         }

         if ((allPairs != null) && (allPairs.length != 0)) {
            return NidPair.getOriginsForRels(allPairs, relTypes);
         }

         return new int[0];
      } finally {
         rwl.readLock().unlock();
      }
   }

   public List<NidPairForRel> getDestRelPairs(int cNid) {

      // only need a read lock for sync,
      // since underlying structure is concurrent...
      rwl.readLock().lock();

      try {
         HashSet<NidPairForRel> result   = new HashSet<>();
         long[]                 allPairs = mutableXref.get().get(cNid);

         if (allPairs == null) {
            allPairs = readOnlyXref.get(cNid);
         }

         if ((allPairs != null) && (allPairs.length != 0)) {
            return NidPair.getNidPairsForRel(allPairs);
         }

         return new ArrayList<>(result);
      } finally {
         rwl.readLock().unlock();
      }
   }

   public List<NidPairForRel> getDestRelPairs(int cNid, NidSetBI relTypes) {
      rwl.readLock().lock();    // only need a read lock for sync,

      // since underlying structure is concurrent...
      try {
         long[] allPairs = mutableXref.get().get(cNid);

         if (allPairs == null) {
            allPairs = readOnlyXref.get(cNid);
         }

         if ((allPairs != null) && (allPairs.length != 0)) {
            return NidPair.getNidPairsForRel(allPairs, relTypes);
         }

         return new ArrayList<>();
      } finally {
         rwl.readLock().unlock();
      }
   }

   @Override
   public NidBitSetBI getNidSet() throws IOException {
      return Bdb.getConceptDb().getConceptNidSet();
   }

   public List<NidPairForRefex> getRefsetPairs(int nid) {

      // only need a read lock for sync,
      // since underlying structure is concurrent...
      rwl.readLock().lock();

      try {
         HashSet<NidPairForRefex> result   = new HashSet<>();
         long[]                    allPairs = mutableXref.get().get(nid);

         if (allPairs == null) {
            allPairs = readOnlyXref.get(nid);
         }

         if ((allPairs != null) && (allPairs.length != 0)) {
            return NidPair.getNidPairsForRefset(allPairs);
         }

         return new ArrayList<>(result);
      } finally {
         rwl.readLock().unlock();
      }
   }

   //~--- set methods ---------------------------------------------------------

   @Override
   public void setParallelConceptIterators(List<ParallelConceptIterator> pcis) {

      // Nothing to do...
   }
}