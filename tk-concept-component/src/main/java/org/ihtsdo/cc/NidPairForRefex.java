package org.ihtsdo.cc;

public class NidPairForRefex extends NidPair {

    protected NidPairForRefex(int refexNid, int memberNid) {
        super(refexNid, memberNid);
    }

    protected NidPairForRefex(long nids) {
        super(nids);
    }

    @Override
    public boolean isRelPair() {
        return false;
    }

    public int getRefsetNid() {
        return nid1;
    }

    public int getMemberNid() {
        return nid2;
    }

    @Override
    public String toString() {
        return "refexNid: " + nid1 + " memberNid:" + nid2;
    }
}
