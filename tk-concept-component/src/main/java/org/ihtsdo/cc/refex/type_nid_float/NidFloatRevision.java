package org.ihtsdo.cc.refex.type_nid_float;

//~--- non-JDK imports --------------------------------------------------------

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;

import org.ihtsdo.cern.colt.list.IntArrayList;


import org.ihtsdo.cc.component.ConceptComponent;
import org.ihtsdo.cc.refex.RefexRevision;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.NidBitSetBI;
import org.ihtsdo.tk.api.blueprint.RefexCAB;
import org.ihtsdo.tk.api.blueprint.RefexCAB.RefexProperty;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_float.RefexNidFloatAnalogBI;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_uuid_float.TkRefexUuidFloatMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_uuid_float.TkRefexUuidFloatRevision;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyVetoException;

import java.io.IOException;

import java.util.*;
import org.ihtsdo.cc.P;

public class NidFloatRevision extends RefexRevision<NidFloatRevision, NidFloatMember>
        implements RefexNidFloatAnalogBI<NidFloatRevision> {
   private int   c1Nid;
   private float floatValue;

   //~--- constructors --------------------------------------------------------

   public NidFloatRevision() {
      super();
   }

   public NidFloatRevision(int statusAtPositionNid, NidFloatMember primoridalMember) {
      super(statusAtPositionNid, primoridalMember);
      c1Nid      = primoridalMember.getC1Nid();
      floatValue = primoridalMember.getFloatValue();
   }

   public NidFloatRevision(TkRefexUuidFloatRevision eVersion, NidFloatMember member) throws IOException {
      super(eVersion, member);
      c1Nid      = P.s.getNidForUuids(eVersion.getUuid1());
      floatValue = eVersion.getFloat1();
   }

   public NidFloatRevision(TupleInput input, NidFloatMember primoridalMember) {
      super(input, primoridalMember);
      c1Nid      = input.readInt();
      floatValue = input.readFloat();
   }

   public NidFloatRevision(int statusNid, long time, int authorNid, int pathNid, int moduleNid,
                           NidFloatMember primoridalMember) {
      super(statusNid, time, authorNid, moduleNid, pathNid, primoridalMember);
      c1Nid      = primoridalMember.getC1Nid();
      floatValue = primoridalMember.getFloatValue();
   }

   protected NidFloatRevision(int statusNid, long time, int authorNid, int pathNid, int moduleNid,
                              NidFloatRevision another) {
      super(statusNid, time, authorNid, moduleNid, pathNid, another.primordialComponent);
      c1Nid      = another.c1Nid;
      floatValue = another.floatValue;
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected void addRefsetTypeNids(Set<Integer> allNids) {
      allNids.add(c1Nid);
   }

    @Override
   protected void addSpecProperties(RefexCAB rcs) {
      rcs.with(RefexProperty.CNID1, getNid1());
      rcs.with(RefexProperty.FLOAT1, getFloat1());
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (NidFloatRevision.class.isAssignableFrom(obj.getClass())) {
         NidFloatRevision another = (NidFloatRevision) obj;

         return (this.c1Nid == another.c1Nid) && (this.floatValue == another.floatValue) && super.equals(obj);
      }

      return false;
   }

   @Override
   public NidFloatRevision makeAnalog() {
      return new NidFloatRevision(getStatusNid(), getTime(), getAuthorNid(), getModuleNid(), getPathNid(), this);
   }

   @Override
   public NidFloatRevision makeAnalog(int statusNid, long time, int authorNid, int moduleNid, int pathNid) {
      if ((this.getTime() == time) && (this.getPathNid() == pathNid)) {
         this.setStatusNid(statusNid);
         this.setAuthorNid(authorNid);
         this.setModuleNid(moduleNid);

         return this;
      }

      NidFloatRevision newR = new NidFloatRevision(statusNid, time, authorNid, moduleNid, pathNid,this);

      primordialComponent.addRevision(newR);

      return newR;
   }

   @Override
   public boolean readyToWriteRefsetRevision() {
      assert c1Nid != Integer.MAX_VALUE;

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
        buf.append(" floatValue:").append(this.floatValue);
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   protected void writeFieldsToBdb(TupleOutput output) {
      output.writeInt(c1Nid);
      output.writeFloat(floatValue);
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
   public float getFloat1() {
      return this.floatValue;
   }

   public float getFloatValue() {
      return floatValue;
   }

   @Override
   public TkRefexAbstractMember<?> getTkRefexMemberActiveOnly(ViewCoordinate vc, NidBitSetBI exclusionSet,
           Map<UUID, UUID> conversionMap)
           throws ContradictionException, IOException {
      return new TkRefexUuidFloatMember(this, exclusionSet, conversionMap, 0, true, vc);
   }

    @Override
   protected TK_REFEX_TYPE getTkRefsetType() {
      return TK_REFEX_TYPE.CID_FLOAT;
   }
   
   @Override
   public IntArrayList getVariableVersionNids() {
      IntArrayList variableNids = new IntArrayList(3);

      variableNids.add(getC1Nid());

      return variableNids;
   }

   @Override
   public NidFloatMember.Version getVersion(ViewCoordinate c) throws ContradictionException {
      return (NidFloatMember.Version) ((NidFloatMember) primordialComponent).getVersion(c);
   }

   @Override
   public Collection<NidFloatMember.Version> getVersions() {
      return ((NidFloatMember) primordialComponent).getVersions();
   }

   @Override
   public Collection<? extends RefexVersionBI<NidFloatRevision>> getVersions(ViewCoordinate c) {
      return ((NidFloatMember) primordialComponent).getVersions(c);
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
   public void setFloat1(float f) throws PropertyVetoException {
      this.floatValue = f;
      modified();
   }

   public void setFloatValue(float floatValue) {
      this.floatValue = floatValue;
      modified();
   }
}
