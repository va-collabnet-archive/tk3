package org.ihtsdo.ttk.concept.cc.refex.type_nid_nid_nid_float;

//~--- non-JDK imports --------------------------------------------------------

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;

import org.ihtsdo.cern.colt.list.IntArrayList;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TK_REFEX_TYPE;
import org.ihtsdo.ttk.api.blueprint.RefexCAB;
import org.ihtsdo.ttk.api.blueprint.RefexProperty;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_nid_nid_float
   .RefexNidNidNidFloatAnalogBI;
import org.ihtsdo.ttk.concept.cc.P;
import org.ihtsdo.ttk.concept.cc.component.ConceptComponent;
import org.ihtsdo.ttk.concept.cc.refex.RefexRevision;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid_float
   .TkRefexUuidUuidUuidFloatRevision;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyVetoException;

import java.io.IOException;

import java.util.*;

public class NidNidNidFloatRevision
        extends RefexRevision<NidNidNidFloatRevision, NidNidNidFloatMember>
        implements RefexNidNidNidFloatAnalogBI<NidNidNidFloatRevision> {
   private int   nid1;
   private int   nid2;
   private int   nid3;
   private float float1;

   public NidNidNidFloatRevision() {
      super();
   }

   public NidNidNidFloatRevision(int statusAtPositionNid,
                                 NidNidNidFloatMember primoridalMember) {
      super(statusAtPositionNid, primoridalMember);
      nid1  = primoridalMember.getNid1();
      nid2  = primoridalMember.getNid2();
      nid3  = primoridalMember.getNid3();
      float1 = primoridalMember.getFloat1();
   }

   public NidNidNidFloatRevision(TkRefexUuidUuidUuidFloatRevision eVersion,
                                 NidNidNidFloatMember member)
           throws IOException {
      super(eVersion, member);
      nid1  = P.s.getNidForUuids(eVersion.getUuid1());
      nid2  = P.s.getNidForUuids(eVersion.getUuid2());
      nid3  = P.s.getNidForUuids(eVersion.getUuid3());
      float1 = eVersion.getFloat1();
   }

   public NidNidNidFloatRevision(TupleInput input,
                                 NidNidNidFloatMember primoridalMember) {
      super(input, primoridalMember);
      nid1  = input.readInt();
      nid2  = input.readInt();
      nid3  = input.readInt();
      float1 = input.readFloat();
   }

   public NidNidNidFloatRevision(int statusNid, long time, int authorNid,
                                 int moduleNid, int pathNid,
                                 NidNidNidFloatMember primoridalMember) {
      super(statusNid, time, authorNid, moduleNid, pathNid, primoridalMember);
      nid1  = primoridalMember.getNid1();
      nid2  = primoridalMember.getNid2();
      nid3  = primoridalMember.getNid3();
      float1 = primoridalMember.getFloat1();
   }

   protected NidNidNidFloatRevision(int statusNid, long time, int authorNid,
                                    int moduleNid, int pathNid,
                                    NidNidNidFloatRevision another) {
      super(statusNid, time, authorNid, moduleNid, pathNid,
            another.primordialComponent);
      nid1  = another.nid1;
      nid2  = another.nid2;
      nid3  = another.nid3;
      float1 = another.float1;
   }

   @Override
   protected void addRefsetTypeNids(Set<Integer> allNids) {
      allNids.add(nid1);
      allNids.add(nid2);
      allNids.add(nid3);
   }

   @Override
   protected void addSpecProperties(RefexCAB rcs) {
      rcs.with(RefexProperty.COMPONENT_EXTENSION_1_ID, getNid1());
      rcs.with(RefexProperty.COMPONENT_EXTENSION_2_ID, getNid2());
      rcs.with(RefexProperty.COMPONENT_EXTENSION_3_ID, getNid3());
      rcs.with(RefexProperty.FLOAT_EXTENSION_1, getFloat1());
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (NidNidNidFloatRevision.class.isAssignableFrom(obj.getClass())) {
         NidNidNidFloatRevision another = (NidNidNidFloatRevision) obj;

         return (this.nid1 == another.nid1) && (this.nid2 == another.nid2)
                && (this.nid3 == another.nid3)
                && (this.float1 == another.float1) && super.equals(obj);
      }

      return false;
   }

   @Override
   public NidNidNidFloatRevision makeAnalog() {
      return new NidNidNidFloatRevision(getStatusNid(), getTime(),
                                        getAuthorNid(), getModuleNid(),
                                        getPathNid(), this);
   }

   @Override
   public NidNidNidFloatRevision makeAnalog(int statusNid, long time,
           int authorNid, int moduleNid, int pathNid) {
      if ((this.getTime() == time) && (this.getPathNid() == pathNid)) {
         this.setStatusNid(statusNid);
         this.setAuthorNid(authorNid);
         this.setModuleNid(moduleNid);

         return this;
      }

      NidNidNidFloatRevision newR = new NidNidNidFloatRevision(statusNid, time,
                                       authorNid, moduleNid, pathNid, this);

      primordialComponent.addRevision(newR);

      return newR;
   }

   @Override
   public boolean readyToWriteRefsetRevision() {
      assert nid1 != Integer.MAX_VALUE;
      assert nid2 != Integer.MAX_VALUE;
      assert nid3 != Integer.MAX_VALUE;

      return true;
   }

   /*
    *  (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuffer buf = new StringBuffer();

      buf.append(this.getClass().getSimpleName()).append(":{");
      buf.append(" nid1: ");
      ConceptComponent.addNidToBuffer(buf, nid1);
      buf.append(" nid2: ");
      ConceptComponent.addNidToBuffer(buf, nid2);
      buf.append(" nid3: ");
      ConceptComponent.addNidToBuffer(buf, nid3);
      buf.append(" float1: ").append(float1);
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   protected void writeFieldsToBdb(TupleOutput output) {
      output.writeInt(nid1);
      output.writeInt(nid2);
      output.writeInt(nid3);
      output.writeFloat(float1);
   }

   @Override
   public float getFloat1() {
      return float1;
   }

   @Override
   public int getNid1() {
      return nid1;
   }

   @Override
   public int getNid2() {
      return nid2;
   }

   @Override
   public int getNid3() {
      return nid3;
   }

   @Override
   protected TK_REFEX_TYPE getTkRefsetType() {
      return TK_REFEX_TYPE.CID_CID_CID_FLOAT;
   }

   @Override
   public IntArrayList getVariableVersionNids() {
      IntArrayList variableNids = new IntArrayList(5);

      variableNids.add(nid1);
      variableNids.add(nid2);
      variableNids.add(nid3);

      return variableNids;
   }

   @Override
   public NidNidNidFloatMember.Version getVersion(ViewCoordinate c)
           throws ContradictionException {
      return (NidNidNidFloatMember
         .Version) ((NidNidNidFloatMember) primordialComponent).getVersion(c);
   }

   @Override
   public Collection<NidNidNidFloatMember.Version> getVersions() {
      return ((NidNidNidFloatMember) primordialComponent).getVersions();
   }

   @Override
   public Collection<? extends RefexVersionBI<NidNidNidFloatRevision>> getVersions(
           ViewCoordinate c) {
      return ((NidNidNidFloatMember) primordialComponent).getVersions(c);
   }

   @Override
   public void setFloat1(float float1) {
      this.float1 = float1;
      modified();
   }

   @Override
   public void setNid1(int cnid) throws PropertyVetoException {
      this.nid1 = cnid;
      modified();
   }

   @Override
   public void setNid2(int cnid) throws PropertyVetoException {
      this.nid2 = cnid;
      modified();
   }

   @Override
   public void setNid3(int cnid) throws PropertyVetoException {
      this.nid3 = cnid;
      modified();
   }
}
