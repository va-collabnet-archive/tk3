package org.ihtsdo.cc;

public class NidPairForRel extends NidPair {

    protected NidPairForRel(int rNid, int typeNid) {
        super(rNid, typeNid);
    }

    protected NidPairForRel(long nids) {
        super(nids);
    }

    @Override
    public boolean isRelPair() {
        return true;
    }

    public int getRelNid() {
        return nid1;
    }

    public int getTypeNid() {
        return nid2;
    }

    @Override
    public String toString() {
        return "relNid: " + nid1 + " typeNid:" + nid2;
    }
}