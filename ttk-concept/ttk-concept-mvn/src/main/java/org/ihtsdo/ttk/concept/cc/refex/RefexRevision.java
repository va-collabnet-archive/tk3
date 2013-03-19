package org.ihtsdo.ttk.concept.cc.refex;

//~--- non-JDK imports --------------------------------------------------------
import com.sleepycat.bind.tuple.TupleInput;

import org.ihtsdo.ttk.concept.cc.component.Revision;
import org.ihtsdo.ttk.api.blueprint.RefexCAB;
import org.ihtsdo.ttk.api.refex.RefexAnalogBI;
import org.ihtsdo.ttk.dto.component.TkRevision;
import org.ihtsdo.ttk.api.TK_REFEX_TYPE;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyVetoException;

import java.io.IOException;

import java.util.Set;
import org.ihtsdo.ttk.concept.cc.P;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.blueprint.InvalidBlueprintException;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;

public abstract class RefexRevision<V extends RefexRevision<V, C>, C extends RefexMember<V, C>>
        extends Revision<V, C> implements RefexAnalogBI<V> {

    public RefexRevision() {
        super();
    }

    public RefexRevision(int statusAtPositionNid, C primordialComponent) {
        super(statusAtPositionNid, primordialComponent);
    }

    public RefexRevision(TkRevision eVersion, C member)  throws IOException{
        super(P.s.getNidForUuids(eVersion.getStatusUuid()), eVersion.getTime(), P.s.getNidForUuids(eVersion.getAuthorUuid()),
                 P.s.getNidForUuids(eVersion.getModuleUuid()), P.s.getNidForUuids(eVersion.getPathUuid()),  member);
    }

    public RefexRevision(TupleInput input, C primordialComponent) {
        super(input, primordialComponent);
    }

    public RefexRevision(int statusNid, long time, int authorNid, int moduleNid, int pathNid, C primordialComponent) {
        super(statusNid, time, authorNid, moduleNid, pathNid, primordialComponent);
    }

    //~--- methods -------------------------------------------------------------
    @Override
    protected void addComponentNids(Set<Integer> allNids) {
        allNids.add(primordialComponent.referencedComponentNid);
        allNids.add(primordialComponent.refexExtensionNid);
        addRefsetTypeNids(allNids);
    }

    protected abstract void addRefsetTypeNids(Set<Integer> allNids);

    protected abstract void addSpecProperties(RefexCAB rcs);

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (RefexRevision.class.isAssignableFrom(obj.getClass())) {
            RefexRevision<?, ?> another = (RefexRevision<?, ?>) obj;

            if (this.stamp == another.stamp) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean refexFieldsEqual(RefexVersionBI another) {
        return primordialComponent.refexFieldsEqual(another);
    }

    public abstract V makeAnalog();

    public abstract boolean readyToWriteRefsetRevision();

    @Override
    public final boolean readyToWriteRevision() {
        assert readyToWriteRefsetRevision() : assertionString();

        return true;
    }

    /*
     *  (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();

        buf.append(super.toString());

        return buf.toString();
    }

    @Override
    public String toUserString() {
        return toString();
    }

    //~--- get methods ---------------------------------------------------------
    @Override
    public int getRefexExtensionNid() {
        return primordialComponent.refexExtensionNid;
    }

    @Override
    public RefexMember getPrimordialVersion() {
        return primordialComponent;
    }

    @Override
    public int getReferencedComponentNid() {
        return primordialComponent.getReferencedComponentNid();
    }

    @Override
    public RefexCAB makeBlueprint(ViewCoordinate vc) throws IOException,
            InvalidBlueprintException, ContradictionException {
        RefexCAB rcs = new RefexCAB(getTkRefsetType(),
                P.s.getUuidPrimordialForNid(getReferencedComponentNid()),
                Ts.get().getUuidPrimordialForNid(getRefexExtensionNid()),
                getVersion(vc), vc, Ts.get().getUuidPrimordialForNid(getModuleNid()));

        addSpecProperties(rcs);

        return rcs;
    }

    protected abstract TK_REFEX_TYPE getTkRefsetType();

    //~--- set methods ---------------------------------------------------------
    @Override
    public void setRefexExtensionNid(int collectionNid) throws PropertyVetoException, IOException {
        primordialComponent.setRefexExtensionNid(collectionNid);
    }

    @Override
    public void setReferencedComponentNid(int componentNid) throws PropertyVetoException, IOException {
        primordialComponent.setReferencedComponentNid(componentNid);
    }
}
