package org.ihtsdo.cc.refex.type_nid_nid_nid;

//~--- non-JDK imports --------------------------------------------------------
import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;

import org.ihtsdo.cern.colt.list.IntArrayList;


import org.ihtsdo.cc.component.ConceptComponent;
import org.ihtsdo.cc.component.RevisionSet;
import org.ihtsdo.cc.refex.RefexMember;
import org.ihtsdo.cc.computer.version.VersionComputer;
import org.ihtsdo.tk.api.blueprint.RefexCAB;
import org.ihtsdo.tk.api.blueprint.RefexCAB.RefexProperty;
import org.ihtsdo.tk.api.refex.type_nid_nid_nid.RefexNidNidNidAnalogBI;
import org.ihtsdo.tk.api.refex.type_nid_nid_nid.RefexNidNidNidVersionBI;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidRevision;
import org.ihtsdo.tk.hash.Hashcode;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyVetoException;

import java.io.IOException;

import java.util.*;
import org.ihtsdo.cc.P;
import org.ihtsdo.tk.api.refex.RefexVersionBI;

public class NidNidNidMember extends RefexMember<NidNidNidRevision, NidNidNidMember>
        implements
        RefexNidNidNidVersionBI<NidNidNidRevision>,
        RefexNidNidNidAnalogBI<NidNidNidRevision> {

    private static VersionComputer<RefexMember<NidNidNidRevision, NidNidNidMember>.Version> computer =
            new VersionComputer<>();
    //~--- fields --------------------------------------------------------------
    private int c1Nid;
    private int c2Nid;
    private int c3Nid;

    //~--- constructors --------------------------------------------------------
    public NidNidNidMember() {
        super();
    }

    public NidNidNidMember(int enclosingConceptNid, TupleInput input) throws IOException {
        super(enclosingConceptNid, input);
    }

    public NidNidNidMember(TkRefexUuidUuidUuidMember refsetMember, int enclosingConceptNid) throws IOException {
        super(refsetMember, enclosingConceptNid);
        c1Nid = P.s.getNidForUuids(refsetMember.getUuid1());
        c2Nid = P.s.getNidForUuids(refsetMember.getUuid2());
        c3Nid = P.s.getNidForUuids(refsetMember.getUuid3());

        if (refsetMember.getRevisionList() != null) {
            revisions = new RevisionSet<>(primordialStampNid);

            for (TkRefexUuidUuidUuidRevision eVersion : refsetMember.getRevisionList()) {
                revisions.add(new NidNidNidRevision(eVersion, this));
            }
        }
    }

    //~--- methods -------------------------------------------------------------
    @Override
    protected void addRefsetTypeNids(Set<Integer> allNids) {
        allNids.add(c1Nid);
        allNids.add(c2Nid);
        allNids.add(c3Nid);
    }

    @Override
    protected void addSpecProperties(RefexCAB rcs) {
        rcs.with(RefexProperty.CNID1, getNid1());
        rcs.with(RefexProperty.CNID2, getNid2());
        rcs.with(RefexProperty.CNID3, getNid3());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (NidNidNidMember.class.isAssignableFrom(obj.getClass())) {
            NidNidNidMember another = (NidNidNidMember) obj;

            return (this.c1Nid == another.c1Nid) && (this.c2Nid == another.c2Nid)
                    && (this.c3Nid == another.c3Nid) && (this.nid == another.nid)
                    && (this.referencedComponentNid == another.referencedComponentNid);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Hashcode.compute(new int[]{c1Nid, c2Nid, c3Nid});
    }

    @Override
    public NidNidNidRevision makeAnalog() {
        return new NidNidNidRevision(getStatusNid(), getTime(), getAuthorNid(), getModuleNid(), getPathNid(), this);
    }

    @Override
    public NidNidNidRevision makeAnalog(int statusNid, long time, int authorNid, int moduleNid, int pathNid) {
        NidNidNidRevision newR = new NidNidNidRevision(statusNid, time, authorNid, moduleNid, pathNid, this);

        addRevision(newR);

        return newR;
    }

    @Override
    protected boolean refexFieldsEqual(ConceptComponent<NidNidNidRevision, NidNidNidMember> obj) {
        if (NidNidNidMember.class.isAssignableFrom(obj.getClass())) {
            NidNidNidMember another = (NidNidNidMember) obj;

            return (this.c1Nid == another.c1Nid) && (this.c2Nid == another.c2Nid)
                    && (this.c3Nid == another.c3Nid);
        }

        return false;
    }
    
    
   @Override
    public boolean refexFieldsEqual(RefexVersionBI another) {
        if(RefexNidNidNidVersionBI.class.isAssignableFrom(another.getClass())){
            RefexNidNidNidVersionBI cv = (RefexNidNidNidVersionBI) another;
            return (this.c1Nid == cv.getNid1()) && (this.c2Nid == cv.getNid2())
                    && (this.c3Nid == cv.getNid3());
        }
        return false;
    }

    @Override
    protected void readMemberFields(TupleInput input) {
        c1Nid = input.readInt();
        c2Nid = input.readInt();
        c3Nid = input.readInt();
    }

    @Override
    protected final NidNidNidRevision readMemberRevision(TupleInput input) {
        return new NidNidNidRevision(input, this);
    }

    @Override
    public boolean readyToWriteRefsetMember() {
        assert c1Nid != Integer.MAX_VALUE;
        assert c2Nid != Integer.MAX_VALUE;
        assert c3Nid != Integer.MAX_VALUE;

        return true;
    }

    /*
    *  (non-Javadoc)
    * @see java.lang.Object#toString()
    */
    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();

        buf.append(this.getClass().getSimpleName()).append(" ");
        buf.append(" c1Nid: ");
        addNidToBuffer(buf, c1Nid);
        buf.append(" c2Nid: ");
        addNidToBuffer(buf, c2Nid);
        buf.append(" c3Nid: ");
        addNidToBuffer(buf, c3Nid);
        buf.append(super.toString());

        return buf.toString();
    }

    @Override
    protected void writeMember(TupleOutput output) {
        output.writeInt(c1Nid);
        output.writeInt(c2Nid);
        output.writeInt(c3Nid);
    }

    //~--- get methods ---------------------------------------------------------
    public int getC1Nid() {
        return c1Nid;
    }

    public int getC2Nid() {
        return c2Nid;
    }

    public int getC3Nid() {
        return c3Nid;
    }

    @Override
    public int getNid1() {
        return c1Nid;
    }

    @Override
    public int getNid2() {
        return c2Nid;
    }

    @Override
    public int getNid3() {
        return c3Nid;
    }

    @Override
    protected TK_REFEX_TYPE getTkRefsetType() {
        return TK_REFEX_TYPE.CID_CID_CID;
    }

    @Override
    public int getTypeNid() {
        return TK_REFEX_TYPE.CID_CID_CID.getTypeToken();
    }

    @Override
    public IntArrayList getVariableVersionNids() {
        IntArrayList variableNids = new IntArrayList(5);

        variableNids.add(getC1Nid());
        variableNids.add(getC2Nid());
        variableNids.add(getC3Nid());

        return variableNids;
    }

    @Override
    protected VersionComputer<RefexMember<NidNidNidRevision, NidNidNidMember>.Version> getVersionComputer() {
        return computer;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Version> getVersions() {
        if (versions == null) {
            int count = 1;

            if (revisions != null) {
                count = count + revisions.size();
            }

            ArrayList<Version> list = new ArrayList<>(count);

            if (getTime() != Long.MIN_VALUE) {
                list.add(new Version(this));
            }

            if (revisions != null) {
                for (NidNidNidRevision r : revisions) {
                    if (r.getTime() != Long.MIN_VALUE) {
                        list.add(new Version(r));
                    }
                }
            }

            versions = list;
        }

        return (List<Version>) versions;
    }

    //~--- set methods ---------------------------------------------------------
    public void setC1Nid(int c1Nid) {
        this.c1Nid = c1Nid;
        modified();
    }

    public void setC2Nid(int c2Nid) {
        this.c2Nid = c2Nid;
        modified();
    }

    public void setC3Nid(int c3Nid) {
        this.c3Nid = c3Nid;
        modified();
    }

    @Override
    public void setNid1(int cnid1) throws PropertyVetoException {
        this.c1Nid = cnid1;
        modified();
    }

    @Override
    public void setNid2(int cnid2) throws PropertyVetoException {
        this.c2Nid = cnid2;
        modified();
    }

    @Override
    public void setNid3(int cnid) throws PropertyVetoException {
        this.c3Nid = cnid;
        modified();
    }

    //~--- inner classes -------------------------------------------------------
    public class Version extends RefexMember<NidNidNidRevision, NidNidNidMember>.Version
            implements RefexNidNidNidVersionBI<NidNidNidRevision> {

        private Version(RefexNidNidNidAnalogBI cv) {
            super(cv);
        }

        RefexNidNidNidAnalogBI getCv() {
            return (RefexNidNidNidAnalogBI) cv;
        }

        @Override
        public TkRefexUuidUuidUuidMember getERefsetMember() throws IOException {
            return new TkRefexUuidUuidUuidMember(this);
        }

        @Override
        public TkRefexUuidUuidUuidRevision getERefsetRevision() throws IOException {
            return new TkRefexUuidUuidUuidRevision(this);
        }

        //~--- set methods ------------------------------------------------------
 
        @Override
        public int getNid3() {
            return getCv().getNid3();
        }

        @Override
        public int getNid2() {
            return getCv().getNid2();
        }

        @Override
        public int getNid1() {
            return getCv().getNid1();
        }
    }
}
