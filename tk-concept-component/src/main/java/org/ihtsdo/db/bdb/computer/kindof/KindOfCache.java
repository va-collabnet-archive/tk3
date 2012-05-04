package org.ihtsdo.db.bdb.computer.kindof;

import java.io.IOException;
import org.ihtsdo.cc.P;

import org.ihtsdo.tk.api.NidBitSetBI;

public class KindOfCache {

    /**
     * Only need an approximate query count, so no need to incur
     * AtomicInt overhead.
     */
    private int queryCount = 0;
    /**
     * The set of cNids for which kindOf has been tested.
     */
    private NidBitSetBI tested;
    private long lastRequestTime = System.currentTimeMillis();
    /**
     * The set of tested cNids that are 
     * determined to be a kind-of. 
     */
    private NidBitSetBI kindOf;
    private NidBitSetBI possiblyKindOf;

    public KindOfCache(NidBitSetBI possiblyKindOf) throws IOException {
        super();
        tested = P.s.getEmptyNidSet();
        kindOf = P.s.getEmptyNidSet();
        this.possiblyKindOf = possiblyKindOf;
    }

    public boolean tested(int cNid) {
        if (possiblyKindOf.isMember(cNid) == false) {
            return true;
        }
        return tested.isMember(cNid);
    }

    public boolean isKindOf(int cNid) {
        if (possiblyKindOf.isMember(cNid) == false) {
            return false;
        }
        if (tested.isMember(cNid)) {
            queryCount++;
            lastRequestTime = System.currentTimeMillis();
            return kindOf.isMember(cNid);
        }
        throw new RuntimeException(
                "You must setKindOf before calling isKindOf."
                + " Use tested(int cNid) to determine if setKindOf is set.");
    }

    public void setKindOf(int cNid, boolean isKindOf) {
        if (!tested.isMember(cNid)) {
            if (isKindOf) {
                kindOf.setMember(cNid);
            }
            tested.setMember(cNid);
        }
    }

    public int getSize() {
        return tested.cardinality();
    }

    public long getLastRequestTime() {
        return lastRequestTime;
    }

    public int getQueryCount() {
        return queryCount;
    }

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder();
        buff.append("KindOfCache: tested count: ");
        buff.append(tested.cardinality());
        buff.append("\n   tested: ");
        buff.append(tested.toString());
        buff.append("\n kindOf count: ");
        buff.append(kindOf.cardinality());
        buff.append("\n   kindOf: ");
        buff.append(kindOf);
        return buff.toString();
    }

    public NidBitSetBI getPossibleKindOfConcepts() {
        return possiblyKindOf;
    }
}
