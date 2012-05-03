package org.ihtsdo.concept.component.refex.type_nid_int;

//~--- non-JDK imports --------------------------------------------------------
import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.ihtsdo.cc.P;
import org.ihtsdo.cern.colt.list.IntArrayList;
import org.ihtsdo.concept.component.ConceptComponent;
import org.ihtsdo.concept.component.refex.RefexRevision;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.NidBitSetBI;
import org.ihtsdo.tk.api.blueprint.RefexCAB;
import org.ihtsdo.tk.api.blueprint.RefexCAB.RefexProperty;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_int.RefexNidIntAnalogBI;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_uuid_int.TkRefexUuidIntMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_uuid_int.TkRefexUuidIntRevision;

public class NidIntRevision extends RefexRevision<NidIntRevision, NidIntMember>
        implements RefexNidIntAnalogBI<NidIntRevision> {

    private int c1Nid;
    private int intValue;

    //~--- constructors --------------------------------------------------------
    public NidIntRevision() {
        super();
    }

    protected NidIntRevision(int statusAtPositionNid, NidIntMember primoridalMember) {
        super(statusAtPositionNid, primoridalMember);
        c1Nid = primoridalMember.getC1Nid();
        intValue = primoridalMember.getInt1();
    }

    public NidIntRevision(TkRefexUuidIntRevision eVersion, NidIntMember member) throws IOException {
        super(eVersion, member);
        c1Nid = P.s.getNidForUuids(eVersion.getUuid1());
        intValue = eVersion.getIntValue();
    }

    public NidIntRevision(TupleInput input, NidIntMember primoridalMember) {
        super(input, primoridalMember);
        c1Nid = input.readInt();
        intValue = input.readInt();
    }

    protected NidIntRevision(int statusNid, int authorNid, int pathNid, long time,
            NidIntMember primoridalMember) {
        super(statusNid, authorNid, pathNid, time, primoridalMember);
        c1Nid = primoridalMember.getC1Nid();
        intValue = primoridalMember.getInt1();
    }

    protected NidIntRevision(int statusNid, int authorNid, int pathNid, long time, NidIntRevision another) {
        super(statusNid, authorNid, pathNid, time, another.primordialComponent);
        c1Nid = another.c1Nid;
        intValue = another.intValue;
    }

    //~--- methods -------------------------------------------------------------
    @Override
    protected void addRefsetTypeNids(Set<Integer> allNids) {
        allNids.add(c1Nid);
    }

    @Override
    protected void addSpecProperties(RefexCAB rcs) {
        rcs.with(RefexProperty.CNID1, getNid1());
        rcs.with(RefexProperty.INTEGER1, getInt1());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (NidIntRevision.class.isAssignableFrom(obj.getClass())) {
            NidIntRevision another = (NidIntRevision) obj;

            return (this.c1Nid == another.c1Nid) && (this.intValue == another.intValue) && super.equals(obj);
        }

        return false;
    }

    @Override
    public NidIntRevision makeAnalog() {
        return new NidIntRevision(getStatusNid(), getAuthorNid(), getPathNid(), getTime(), this);
    }

    @Override
    public NidIntRevision makeAnalog(int statusNid, int authorNid, int pathNid, long time) {
        if ((this.getTime() == time) && (this.getPathNid() == pathNid)) {
            this.setStatusNid(statusNid);

            return this;
        }

        NidIntRevision newR = new NidIntRevision(statusNid, authorNid, pathNid, time, this);

        primordialComponent.addRevision(newR);

        return newR;
    }

    @Override
    public boolean readyToWriteRefsetRevision() {
        assert c1Nid != Integer.MAX_VALUE;

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
        ConceptComponent.addNidToBuffer(buf, c1Nid);
        buf.append(" intValue:").append(this.intValue);
        buf.append(super.toString());

        return buf.toString();
    }

    @Override
    protected void writeFieldsToBdb(TupleOutput output) {
        output.writeInt(c1Nid);
        output.writeInt(intValue);
    }

    //~--- get methods ---------------------------------------------------------
    public int getC1Nid() {
        return c1Nid;
    }

    @Override
    public int getNid1() {
        return c1Nid;
    }

    @Override
    public int getInt1() {
        return intValue;
    }

    @Override
    public TkRefexAbstractMember<?> getTkRefexMemberActiveOnly(ViewCoordinate vc, NidBitSetBI exclusionSet,
            Map<UUID, UUID> conversionMap)
            throws ContradictionException, IOException {
        return new TkRefexUuidIntMember(this, exclusionSet, conversionMap, 0, true, vc);
    }

    @Override
    protected TK_REFEX_TYPE getTkRefsetType() {
        return TK_REFEX_TYPE.CID_INT;
    }

    @Override
    public IntArrayList getVariableVersionNids() {
        IntArrayList variableNids = new IntArrayList(3);

        variableNids.add(getC1Nid());

        return variableNids;
    }

    @Override
    public NidIntMember.Version getVersion(ViewCoordinate c) throws ContradictionException {
        return (NidIntMember.Version) ((NidIntMember) primordialComponent).getVersion(c);
    }

    @Override
    public Collection<NidIntMember.Version> getVersions() {
        return ((NidIntMember) primordialComponent).getVersions();
    }

    @Override
    public Collection<? extends RefexVersionBI<NidIntRevision>> getVersions(ViewCoordinate c) {
        return ((NidIntMember) primordialComponent).getVersions(c);
    }

    //~--- set methods ---------------------------------------------------------
    public void setC1Nid(int c1Nid) {
        this.c1Nid = c1Nid;
        modified();
    }

    @Override
    public void setNid1(int cnid) throws PropertyVetoException {
        this.c1Nid = cnid;
        modified();
    }

    @Override
    public void setInt1(int l) throws PropertyVetoException {
        this.intValue = l;
        modified();
    }
}
