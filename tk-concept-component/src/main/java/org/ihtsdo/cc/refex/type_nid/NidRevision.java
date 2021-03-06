package org.ihtsdo.cc.refex.type_nid;

//~--- non-JDK imports --------------------------------------------------------
import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import org.ihtsdo.cc.P;
import org.ihtsdo.cern.colt.list.IntArrayList;
import org.ihtsdo.cc.component.ConceptComponent;
import org.ihtsdo.cc.refex.RefexRevision;
import org.ihtsdo.cc.refex.type_nid.NidMember.Version;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.blueprint.RefexCAB;
import org.ihtsdo.tk.api.blueprint.RefexCAB.RefexProperty;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_nid.RefexNidAnalogBI;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.type_uuid.TkRefexUuidRevision;

public class NidRevision extends RefexRevision<NidRevision, NidMember>
        implements RefexNidAnalogBI<NidRevision> {

    private int nid1;

    //~--- constructors --------------------------------------------------------
    public NidRevision() {
        super();
    }

    protected NidRevision(int statusAtPositionNid, NidMember primoridalMember) {
        super(statusAtPositionNid, primoridalMember);
        nid1 = primoridalMember.getC1Nid();
    }

    public NidRevision(TkRefexUuidRevision eVersion, NidMember member) throws IOException {
        super(eVersion, member);
        nid1 = P.s.getNidForUuids(eVersion.getUuid1());
    }

    public NidRevision(TupleInput input, NidMember primoridalMember) {
        super(input, primoridalMember);
        nid1 = input.readInt();
    }

    protected NidRevision(int statusNid, long time, int authorNid, int moduleNid, int pathNid, NidMember primoridalMember) {
        super(statusNid, time, authorNid, moduleNid, pathNid, primoridalMember);
        nid1 = primoridalMember.getC1Nid();
    }

    protected NidRevision(int statusNid, long time, int authorNid, int moduleNid, int pathNid, NidRevision another) {
        super(statusNid, time, authorNid, moduleNid, pathNid, another.primordialComponent);
        nid1 = another.nid1;
    }

    //~--- methods -------------------------------------------------------------
    @Override
    protected void addRefsetTypeNids(Set<Integer> allNids) {
        allNids.add(nid1);
    }

    @Override
    protected void addSpecProperties(RefexCAB rcs) {
        rcs.with(RefexProperty.CNID1, getNid1());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (NidRevision.class.isAssignableFrom(obj.getClass())) {
            NidRevision another = (NidRevision) obj;

            if (this.nid1 == another.nid1) {
                return super.equals(obj);
            }
        }

        return false;
    }

    @Override
    public NidRevision makeAnalog() {
        return new NidRevision(getStatusNid(), getTime(), getAuthorNid(), getModuleNid(), getPathNid(), this);
    }

    @Override
    public NidRevision makeAnalog(int statusNid, long time, int authorNid, int moduleNid, int pathNid) {
        if ((this.getTime() == time) && (this.getPathNid() == pathNid)) {
         this.setStatusNid(statusNid);
         this.setAuthorNid(authorNid);
         this.setModuleNid(moduleNid);
            return this;
        }

        NidRevision newR = new NidRevision(statusNid, time, authorNid, moduleNid, pathNid, this);

        primordialComponent.addRevision(newR);

        return newR;
    }

    @Override
    public boolean readyToWriteRefsetRevision() {
        assert nid1 != Integer.MAX_VALUE;

        return true;
    }

    /*
     * (non-Javadoc) @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();

        buf.append(this.getClass().getSimpleName()).append(":{");
        buf.append(" c1Nid: ");
        ConceptComponent.addNidToBuffer(buf, this.nid1);
        buf.append(super.toString());

        return buf.toString();
    }

    @Override
    protected void writeFieldsToBdb(TupleOutput output) {
        output.writeInt(nid1);
    }

    //~--- get methods ---------------------------------------------------------
    @Override
    public int getNid1() {
        return nid1;
    }

    @Override
    protected TK_REFEX_TYPE getTkRefsetType() {
        return TK_REFEX_TYPE.CID;
    }

    @Override
    public IntArrayList getVariableVersionNids() {
        IntArrayList variableNids = new IntArrayList(3);

        variableNids.add(getNid1());

        return variableNids;
    }

    @Override
    public NidMember.Version getVersion(ViewCoordinate c) throws ContradictionException {
        return (Version) ((NidMember) primordialComponent).getVersion(c);
    }

    @Override
    public Collection<NidMember.Version> getVersions() {
        return ((NidMember) primordialComponent).getVersions();
    }

    @Override
    public Collection<? extends RefexVersionBI<NidRevision>> getVersions(ViewCoordinate c) {
        return ((NidMember) primordialComponent).getVersions(c);
    }

    //~--- set methods ---------------------------------------------------------
    @Override
    public void setNid1(int c1Nid) {
        this.nid1 = c1Nid;
        modified();
    }
}
