package org.ihtsdo.bdb.id;

//~--- non-JDK imports --------------------------------------------------------
import com.sleepycat.bind.tuple.IntegerBinding;
import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;
import com.sleepycat.je.Cursor;
import com.sleepycat.je.CursorConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;


import org.ihtsdo.cern.colt.map.OpenIntIntHashMap;
import org.ihtsdo.bdb.Bdb;
import org.ihtsdo.bdb.ComponentBdb;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import org.ihtsdo.bdb.temp.AceLog;

/**
 *
 * @author kec
 *
 */
public class NidCNidMapBdb extends ComponentBdb {

    private static final int NID_CNID_MAP_SIZE = 50000;
    //~--- fields --------------------------------------------------------------
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private boolean[] mapChanged;
    private AtomicReference<int[][]> nidCNidMaps;
    private int readOnlyRecords;
    
    static TreeSet<Integer> maxValueEntries = new TreeSet<Integer>();


    //~--- constructors --------------------------------------------------------
    public NidCNidMapBdb(Bdb readOnlyBdbEnv, Bdb mutableBdbEnv) throws IOException {
        super(readOnlyBdbEnv, mutableBdbEnv);
    }

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
        long next = nextId;
        long numIds = (next - Integer.MIN_VALUE);
        long maps = numIds / NID_CNID_MAP_SIZE;
        int nidCidMapCount = (int) maps + 1;

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
        int oldCount = nidCNidMaps.get().length;
        int[][] newNidCidMaps = new int[nidCidMapCount][];
        boolean[] newMapChanged = new boolean[nidCidMapCount];

        for (int i = 0; i < oldCount; i++) {
            newNidCidMaps[i] = nidCNidMaps.get()[i];
            newMapChanged[i] = mapChanged[i];
        }

        for (int i = oldCount; i < nidCidMapCount; i++) {
            if (AceLog.getAppLog().isLoggable(Level.FINE)) {
                AceLog.getAppLog().fine("Expanding NidCidMaps to: " + (i + 1));
            }

            newNidCidMaps[i] = new int[NID_CNID_MAP_SIZE];
            newMapChanged[i] = true;
            Arrays.fill(newNidCidMaps[i], Integer.MAX_VALUE);
        }

        nidCNidMaps.set(newNidCidMaps);
        mapChanged = newMapChanged;
    }

    @Override
    protected void init() throws IOException {
        preloadBoth();

        int maxId = Bdb.getUuidsToNidMap().getCurrentMaxNid();

        readOnlyRecords = (int) readOnly.count();

        int mutableRecords = (int) mutable.count();

        AceLog.getAppLog().info("NidCidMap readOnlyRecords: " + readOnlyRecords);
        AceLog.getAppLog().info("NidCidMap mutableRecords: " + mutableRecords);

        int nidCidMapCount = ((maxId - Integer.MIN_VALUE) / NID_CNID_MAP_SIZE) + 1;

        nidCNidMaps = new AtomicReference<int[][]>(new int[nidCidMapCount][]);
        mapChanged = new boolean[nidCidMapCount];
        Arrays.fill(mapChanged, false);

        for (int index = 0; index < nidCidMapCount; index++) {
            nidCNidMaps.get()[index] = new int[NID_CNID_MAP_SIZE];
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
        int size = (int) db.count();
        OpenIntIntHashMap nidMap = new OpenIntIntHashMap(size + 2);
        CursorConfig cursorConfig = new CursorConfig();

        cursorConfig.setReadUncommitted(true);

        Cursor cursor = db.openCursor(null, cursorConfig);

        try {
            DatabaseEntry foundKey = new DatabaseEntry();
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
        } finally {
            cursor.close();
        }
    }

    private void readMaps(Database db, boolean readOnly) {
        CursorConfig cursorConfig = new CursorConfig();

        cursorConfig.setReadUncommitted(true);

        Cursor cursor = db.openCursor(null, cursorConfig);

        maxValueEntries.clear();
        try {
            DatabaseEntry foundKey = new DatabaseEntry();
            DatabaseEntry foundData = new DatabaseEntry();

            while (cursor.getNext(foundKey, foundData, LockMode.READ_UNCOMMITTED) == OperationStatus.SUCCESS) {
                int index = IntegerBinding.entryToInt(foundKey);
                TupleInput ti = new TupleInput(foundData.getData());
                int j = 0;

                while (ti.available() > 0) {
                    nidCNidMaps.get()[index][j++] = ti.readInt();

                    if (nidCNidMaps.get()[index][j - 1] == Integer.MAX_VALUE) {
                        int nid = Integer.MIN_VALUE + (index + 1) * (j - 1);
                        maxValueEntries.add(nid);
                    }
                }

                if (AceLog.getAppLog().isLoggable(Level.FINE)) {
                    maxValueEntries.remove(-2147483648);
                    maxValueEntries.remove(-2147483647);
                    if (readOnly) {
                        AceLog.getAppLog().info("\n\nmax value entry count for read only index[" + index + "]: "
                                + maxValueEntries.size());
                    } else {
                        AceLog.getAppLog().info("\n\nmax value entry count for mutable index[" + index + "]: "
                                + maxValueEntries.size());

                        if ((maxValueEntries.size() > 0) && (index < (nidCNidMaps.get().length - 1))) {
                            AceLog.getAppLog().info("\n\n\nmax value entries: " + maxValueEntries);
                        }
                    }
                }
            }
        } finally {
            cursor.close();
        }
    }

    public void resetCidForNid(int cNid, int nid) throws IOException {
        assert cNid != Integer.MAX_VALUE;

        int mapIndex = (nid - Integer.MIN_VALUE) / NID_CNID_MAP_SIZE;

        assert mapIndex >= 0 : "cNid: " + cNid + " nid: " + nid + " mapIndex: " + mapIndex;

        int indexInMap = (nid - Integer.MIN_VALUE) % NID_CNID_MAP_SIZE;

        assert indexInMap < NID_CNID_MAP_SIZE :
                "cNid: " + cNid + " nid: " + nid + " mapIndex: " + mapIndex + " indexInMap: " + indexInMap;
        ensureCapacity(nid);

        if ((nidCNidMaps.get() != null) && (nidCNidMaps.get()[mapIndex] != null)) {
            if (nidCNidMaps.get()[mapIndex][indexInMap] != cNid) {
                nidCNidMaps.get()[mapIndex][indexInMap] = cNid;
                mapChanged[mapIndex] = true;
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
            DatabaseEntry keyEntry = new DatabaseEntry();
            int mapCount = nidCNidMaps.get().length;
            int[] lastRow = nidCNidMaps.get()[mapCount - 1];
            int maxIndex = NID_CNID_MAP_SIZE - 1;
            for (int i = NID_CNID_MAP_SIZE - 1; i >= 0; i--) {
                if (lastRow[i] != Integer.MAX_VALUE) {
                    maxIndex = i;
                    break;
                }

            }
            found:
            for (int key = 0; key < mapCount; key++) {
                if (mapChanged[key]) {
                    IntegerBinding.intToEntry(key, keyEntry);
                    TupleOutput output = new TupleOutput(new byte[NID_CNID_MAP_SIZE * 4]);

                    for (int i = 0; i < NID_CNID_MAP_SIZE; i++) {
                        output.writeInt(nidCNidMaps.get()[key][i]);

                        if (nidCNidMaps.get()[key][i] == Integer.MAX_VALUE) {
                            int nid = Integer.MIN_VALUE + (key + 1) * i;
                            if (key < mapCount - 1) {
                                maxValueEntries.add(nid);
                            } else if (i < maxIndex) {
                                maxValueEntries.add(nid);
                            }
                        }
                    }

                    maxValueEntries.remove(-2147483648);
                    maxValueEntries.remove(-2147483647);
                    if ((maxValueEntries.size() > 0) && (key < nidCNidMaps.get().length - 1)) {
                        ArrayList<Integer> toRemove = new ArrayList<Integer>(maxValueEntries.size());
                        for (int nid: maxValueEntries) {
                            if (getCNid(nid) != Integer.MAX_VALUE) {
                                toRemove.add(nid);
                            } 
                        }
                        maxValueEntries.removeAll(toRemove);
                        if (maxValueEntries.size() > 0) {
                            AceLog.getAppLog().info("writing max value entry count: " + maxValueEntries.size() + 
                                "\nvalues: " + maxValueEntries);
                        }
                    }

                    DatabaseEntry valueEntry = new DatabaseEntry(output.toByteArray());

                    OperationStatus status = mutable.put(null, keyEntry, valueEntry);

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

        int mapIndex = (nid - Integer.MIN_VALUE) / NID_CNID_MAP_SIZE;
        int indexInMap = (nid - Integer.MIN_VALUE) % NID_CNID_MAP_SIZE;

        assert (mapIndex >= 0) && (indexInMap >= 0) :
                "mapIndex: " + mapIndex + " indexInMap: " + indexInMap + " nid: " + nid;

        if (mapIndex >= nidCNidMaps.get().length) {
            return Integer.MAX_VALUE;
        }

        return nidCNidMaps.get()[mapIndex][indexInMap];
    }

    @Override
    protected String getDbName() {
        return "NidCidMap";
    }

    public boolean hasConcept(int cNid) {
        assert cNid > Integer.MIN_VALUE : "Invalid cNid == Integer.MIN_VALUE: " + cNid;
        assert cNid <= Bdb.getUuidsToNidMap().getCurrentMaxNid() :
                "Invalid cNid: " + cNid + " currentMax: " + Bdb.getUuidsToNidMap().getCurrentMaxNid();

        int mapIndex = (cNid - Integer.MIN_VALUE) / NID_CNID_MAP_SIZE;
        int indexInMap = (cNid - Integer.MIN_VALUE) % NID_CNID_MAP_SIZE;

        if ((mapIndex < 0) || (mapIndex >= nidCNidMaps.get().length)) {
            return false;
        }

        if ((indexInMap < 0) || (indexInMap >= NID_CNID_MAP_SIZE)) {
            return false;
        }

        if (nidCNidMaps.get()[mapIndex][indexInMap] == cNid) {
            return true;
        }

        return false;
    }

    public boolean hasMap(int nid) {
        int mapIndex = (nid - Integer.MIN_VALUE) / NID_CNID_MAP_SIZE;
        int indexInMap = (nid - Integer.MIN_VALUE) % NID_CNID_MAP_SIZE;

        if ((mapIndex < nidCNidMaps.get().length) && (indexInMap < NID_CNID_MAP_SIZE)) {
            if (nidCNidMaps.get()[mapIndex][indexInMap] < Integer.MAX_VALUE) {
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

        int indexInMap = (nid - Integer.MIN_VALUE) % NID_CNID_MAP_SIZE;

        assert indexInMap < NID_CNID_MAP_SIZE :
                "cNid: " + cNid + " nid: " + nid + " mapIndex: " + mapIndex + " indexInMap: " + indexInMap;
        assert (cNid == nid) || hasConcept(cNid) : cNid + " is not a concept nid. nid: " + nid;
        ensureCapacity(nid);
        assert (nidCNidMaps.get()[mapIndex][indexInMap] == Integer.MAX_VALUE)
                || (nidCNidMaps.get()[mapIndex][indexInMap] == cNid) :
                "processing cNid: " + cNid + " " + Bdb.getUuidsToNidMap().getUuidsForNid(cNid) + " nid: " + nid
                + " found existing cNid: " + nidCNidMaps.get()[mapIndex][indexInMap] + " "
                + Bdb.getUuidsToNidMap().getUuidsForNid(nidCNidMaps.get()[mapIndex][indexInMap]) + "\n    "
                + cNid + " maps to: " + getCNid(cNid) + "\n    " + nidCNidMaps.get()[mapIndex][indexInMap]
                + " maps to: " + getCNid(nidCNidMaps.get()[mapIndex][indexInMap]);

        if ((nidCNidMaps.get() != null) && (nidCNidMaps.get()[mapIndex] != null)) {
            if (nidCNidMaps.get()[mapIndex][indexInMap] != cNid) {
                nidCNidMaps.get()[mapIndex][indexInMap] = cNid;
                mapChanged[mapIndex] = true;
            }
        } else {
            if (nidCNidMaps.get() == null) {
                throw new IOException("Null nidCidMap: ");
            }

            throw new IOException("nidCidMap[" + mapIndex + "] " + "is null. cNid: " + cNid + " nid: " + nid);
        }
    }
}