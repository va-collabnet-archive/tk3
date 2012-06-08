package org.ihtsdo.cc.refex.type_boolean;

//~--- non-JDK imports --------------------------------------------------------
import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.*;
import org.ihtsdo.cern.colt.list.IntArrayList;
import org.ihtsdo.cc.component.ConceptComponent;
import org.ihtsdo.cc.component.RevisionSet;
import org.ihtsdo.cc.refex.RefexMember;
import org.ihtsdo.cc.computer.version.VersionComputer;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.NidBitSetBI;
import org.ihtsdo.tk.api.blueprint.RefexCAB;
import org.ihtsdo.tk.api.blueprint.RefexCAB.RefexProperty;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_boolean.RefexBooleanAnalogBI;
import org.ihtsdo.tk.api.refex.type_boolean.RefexBooleanVersionBI;
import org.ihtsdo.tk.dto.concept.component.refex.type_boolean.TkRefexBooleanMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_boolean.TkRefexBooleanRevision;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.ihtsdo.tk.hash.Hashcode;

public class BooleanMember extends RefexMember<BooleanRevision, BooleanMember>
        implements RefexBooleanAnalogBI<BooleanRevision> {

    private static VersionComputer<RefexMember<BooleanRevision, BooleanMember>.Version> computer =
            new VersionComputer<>();
    //~--- fields --------------------------------------------------------------
    private boolean booleanValue;

    //~--- constructors --------------------------------------------------------
    public BooleanMember() {
        super();
    }

    public BooleanMember(int enclosingConceptNid, TupleInput input) throws IOException {
        super(enclosingConceptNid, input);
    }

    public BooleanMember(TkRefexBooleanMember refsetMember, int enclosingConceptNid) throws IOException {
        super(refsetMember, enclosingConceptNid);
        booleanValue = refsetMember.getBooleanValue();

        if (refsetMember.getRevisionList() != null) {
            revisions = new RevisionSet(primordialSapNid);

            for (TkRefexBooleanRevision eVersion : refsetMember.getRevisionList()) {
                revisions.add(new BooleanRevision(eVersion, this));
            }
        }
    }

    //~--- methods -------------------------------------------------------------
    @Override
    protected void addRefsetTypeNids(Set<Integer> allNids) {
        // ;
    }

    @Override
    protected void addSpecProperties(RefexCAB rcs) {
        rcs.with(RefexProperty.BOOLEAN1, getBoolean1());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (BooleanMember.class.isAssignableFrom(obj.getClass())) {
            BooleanMember another = (BooleanMember) obj;

            return this.nid == another.nid;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Hashcode.compute(new int[]{nid});
    }

    @Override
    public BooleanRevision makeAnalog() {
        BooleanRevision newR = new BooleanRevision(getStatusNid(), getTime(),
                getAuthorNid(), getModuleNid(), getPathNid(), this);

        return newR;
    }

    @Override
    public BooleanRevision makeAnalog(int statusNid, long time, int authorNid, int moduleNid, int pathNid) {
        BooleanRevision newR = new BooleanRevision(getStatusNid(), getTime(),
                authorNid, moduleNid, getPathNid(), this);

        addRevision(newR);

        return newR;
    }

     @Override
    protected boolean refexFieldsEqual(ConceptComponent<BooleanRevision, BooleanMember> obj) {
        if (BooleanMember.class.isAssignableFrom(obj.getClass())) {
            BooleanMember another = (BooleanMember) obj;

            return this.booleanValue = another.booleanValue;
        }

        return false;
    }

    @Override
    public boolean refexFieldsEqual(RefexVersionBI another) {
        if(RefexBooleanVersionBI.class.isAssignableFrom(another.getClass())){
            RefexBooleanVersionBI bv = (RefexBooleanVersionBI) another;
            return this.booleanValue = bv.getBoolean1();
        }
        return false;
    }

    @Override
    protected void readMemberFields(TupleInput input) {
        booleanValue = input.readBoolean();
    }

    @Override
    protected final BooleanRevision readMemberRevision(TupleInput input) {
        return new BooleanRevision(input, this);
    }

    @Override
    public boolean readyToWriteRefsetMember() {
        return true;
    }

    /*
     *  (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();

        buf.append(this.getClass().getSimpleName()).append(":{");
        buf.append(" booleanValue:").append(this.booleanValue);
        buf.append("; ");
        buf.append(super.toString());

        return buf.toString();
    }

    @Override
    protected void writeMember(TupleOutput output) {
        output.writeBoolean(booleanValue);
    }

    //~--- get methods ---------------------------------------------------------
    @Override
    public boolean getBoolean1() {
        return this.booleanValue;
    }

    @Override
    public TkRefexAbstractMember<?> getTkRefexMemberActiveOnly(ViewCoordinate vc, NidBitSetBI exclusionSet,
            Map<UUID, UUID> conversionMap)
            throws ContradictionException, IOException {
        return new TkRefexBooleanMember(this, exclusionSet, conversionMap, 0, true, vc);
    }

    @Override
    protected TK_REFEX_TYPE getTkRefsetType() {
        return TK_REFEX_TYPE.BOOLEAN;
    }

    @Override
    public int getTypeNid() {
        return TK_REFEX_TYPE.BOOLEAN.getTypeToken();
    }

    @Override
    protected IntArrayList getVariableVersionNids() {

        // TODO Auto-generated method stub
        return null;
    }

    protected VersionComputer<RefexMember<BooleanRevision, BooleanMember>.Version> getVersionComputer() {
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
                for (BooleanRevision br : revisions) {
                    if (br.getTime() != Long.MIN_VALUE) {
                        list.add(new Version(br));
                    }
                }
            }

            versions = list;
        }

        return (List<Version>) versions;
    }

    //~--- set methods ---------------------------------------------------------
    @Override
    public void setBoolean1(boolean l) throws PropertyVetoException {
        this.booleanValue = l;
        modified();
    }

    //~--- inner classes -------------------------------------------------------
    public class Version extends RefexMember<BooleanRevision, BooleanMember>.Version
            implements RefexBooleanAnalogBI<BooleanRevision> {

        private Version(RefexBooleanAnalogBI<BooleanRevision> cv) {
            super(cv);
        }

        //~--- methods ----------------------------------------------------------

        //~--- get methods ------------------------------------------------------
        @Override
        public boolean getBoolean1() {
            return getCv().getBoolean1();
        }

        RefexBooleanAnalogBI<BooleanRevision> getCv() {
            return (RefexBooleanAnalogBI<BooleanRevision>) cv;
        }

        @Override
        public TkRefexBooleanMember getERefsetMember() throws IOException {
            return new TkRefexBooleanMember(this);
        }

        @Override
        public TkRefexBooleanRevision getERefsetRevision() throws IOException {
            return new TkRefexBooleanRevision(this);
        }

        @Override
        public IntArrayList getVariableVersionNids() {
            return new IntArrayList();
        }

        //~--- set methods ------------------------------------------------------
        @Override
        public void setBoolean1(boolean value) throws PropertyVetoException {
            getCv().setBoolean1(value);
        }
    }
}
