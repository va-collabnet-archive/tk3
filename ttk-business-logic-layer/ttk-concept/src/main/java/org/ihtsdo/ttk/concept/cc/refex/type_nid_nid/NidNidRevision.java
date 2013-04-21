package org.ihtsdo.ttk.concept.cc.refex.type_nid_nid;

//~--- non-JDK imports --------------------------------------------------------

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import org.ihtsdo.ttk.concept.cc.P;
import org.ihtsdo.cern.colt.list.IntArrayList;
import org.ihtsdo.ttk.concept.cc.component.ConceptComponent;
import org.ihtsdo.ttk.concept.cc.refex.RefexRevision;
import org.ihtsdo.ttk.concept.cc.refex.type_nid_nid.NidNidMember.Version;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.blueprint.RefexCAB;
import org.ihtsdo.ttk.api.blueprint.RefexProperty;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_nid.RefexNidNidAnalogBI;
import org.ihtsdo.ttk.api.TK_REFEX_TYPE;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid.TkRefexUuidUuidRevision;

public class NidNidRevision extends RefexRevision<NidNidRevision, NidNidMember>
        implements RefexNidNidAnalogBI<NidNidRevision> {
   private int c1Nid;
   private int c2Nid;

   //~--- constructors --------------------------------------------------------

   public NidNidRevision() {
      super();
   }

   public NidNidRevision(int statusAtPositionNid, NidNidMember primoridalMember) {
      super(statusAtPositionNid, primoridalMember);
      c1Nid = primoridalMember.getC1Nid();
      c2Nid = primoridalMember.getC2Nid();
   }

   public NidNidRevision(TkRefexUuidUuidRevision eVersion, NidNidMember member) throws IOException {
      super(eVersion, member);
      c1Nid = P.s.getNidForUuids(eVersion.getUuid1());
      c2Nid = P.s.getNidForUuids(eVersion.getUuid2());
   }

   public NidNidRevision(TupleInput input, NidNidMember primoridalMember) {
      super(input, primoridalMember);
      c1Nid = input.readInt();
      c2Nid = input.readInt();
   }
   
   public NidNidRevision(int statusNid, long time, int authorNid,
           int moduleNid, int pathNid, NidNidMember primoridalMember) {
      super(statusNid, time, authorNid, moduleNid, pathNid, primoridalMember);
      c1Nid = primoridalMember.getC1Nid();
      c2Nid = primoridalMember.getC2Nid();
   }

   protected NidNidRevision(int statusNid, long time, int authorNid,
           int moduleNid, int pathNid, NidNidRevision another) {
      super(statusNid, time, authorNid, moduleNid, pathNid, another.primordialComponent);
      c1Nid = another.c1Nid;
      c2Nid = another.c2Nid;
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected void addRefsetTypeNids(Set<Integer> allNids) {
      allNids.add(c1Nid);
      allNids.add(c2Nid);
   }

   @Override
   protected void addSpecProperties(RefexCAB rcs) {
      rcs.with(RefexProperty.COMPONENT_EXTENSION_1_ID, getNid1());
      rcs.with(RefexProperty.COMPONENT_EXTENSION_2_ID, getNid2());
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (NidNidRevision.class.isAssignableFrom(obj.getClass())) {
         NidNidRevision another = (NidNidRevision) obj;

         if ((this.c1Nid == another.c1Nid) && (this.c2Nid == another.c2Nid)) {
            return super.equals(obj);
         }
      }

      return false;
   }

   @Override
   public NidNidRevision makeAnalog() {
      return new NidNidRevision(getStatusNid(), getTime(), getAuthorNid(),
              getModuleNid(), getPathNid(), this);
   }

   @Override
   public NidNidRevision makeAnalog(int statusNid, long time, int authorNid, int moduleNid, int pathNid) {
      if ((this.getTime() == time) && (this.getPathNid() == pathNid)) {
         this.setStatusNid(statusNid);
         this.setAuthorNid(authorNid);
         this.setModuleNid(moduleNid);
         return this;
      }

      NidNidRevision newR = new NidNidRevision(statusNid, time,
              authorNid, moduleNid, pathNid, this);

      primordialComponent.addRevision(newR);

      return newR;
   }

   @Override
   public boolean readyToWriteRefsetRevision() {
      assert c1Nid != Integer.MAX_VALUE;
      assert c2Nid != Integer.MAX_VALUE;

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
      ConceptComponent.addNidToBuffer(buf, c1Nid);
      buf.append(" c2Nid: ");
      ConceptComponent.addNidToBuffer(buf, c2Nid);
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   protected void writeFieldsToBdb(TupleOutput output) {
      output.writeInt(c1Nid);
      output.writeInt(c2Nid);
   }

   //~--- get methods ---------------------------------------------------------

   public int getC1Nid() {
      return c1Nid;
   }

   public int getC2Nid() {
      return c2Nid;
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
   protected TK_REFEX_TYPE getTkRefsetType() {
      return TK_REFEX_TYPE.CID_CID;
   }

   @Override
   public IntArrayList getVariableVersionNids() {
      IntArrayList variableNids = new IntArrayList(4);

      variableNids.add(getC1Nid());
      variableNids.add(getC2Nid());

      return variableNids;
   }

   @Override
   public NidNidMember.Version getVersion(ViewCoordinate c) throws ContradictionException {
      return (Version) ((NidNidMember) primordialComponent).getVersion(c);
   }

   @Override
   public Collection<NidNidMember.Version> getVersions() {
      return ((NidNidMember) primordialComponent).getVersions();
   }

   @Override
   public Collection<? extends RefexVersionBI<NidNidRevision>> getVersions(ViewCoordinate c) {
      return ((NidNidMember) primordialComponent).getVersions(c);
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

   @Override
   public void setNid1(int cnid) throws PropertyVetoException {
      this.c1Nid = cnid;
      modified();
   }

   @Override
   public void setNid2(int cnid) throws PropertyVetoException {
      this.c2Nid = cnid;
      modified();
   }
}
