package org.ihtsdo.concept.component.refex.type_nid_nid_nid;

//~--- non-JDK imports --------------------------------------------------------

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;

import org.ihtsdo.cern.colt.list.IntArrayList;


import org.ihtsdo.concept.component.ConceptComponent;
import org.ihtsdo.concept.component.refex.RefexRevision;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.NidBitSetBI;
import org.ihtsdo.tk.api.blueprint.RefexCAB;
import org.ihtsdo.tk.api.blueprint.RefexCAB.RefexProperty;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_nid_nid.RefexNidNidNidAnalogBI;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidRevision;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyVetoException;

import java.io.IOException;

import java.util.*;
import org.ihtsdo.cc.P;

public class NidNidNidRevision extends RefexRevision<NidNidNidRevision, NidNidNidMember>
        implements RefexNidNidNidAnalogBI<NidNidNidRevision> {
   private int c1Nid;
   private int c2Nid;
   private int c3Nid;

   //~--- constructors --------------------------------------------------------

   public NidNidNidRevision() {
      super();
   }

   public NidNidNidRevision(int statusAtPositionNid, NidNidNidMember primoridalMember) {
      super(statusAtPositionNid, primoridalMember);
      c1Nid = primoridalMember.getC1Nid();
      c2Nid = primoridalMember.getC2Nid();
      c3Nid = primoridalMember.getC3Nid();
   }

   public NidNidNidRevision(TkRefexUuidUuidUuidRevision eVersion, NidNidNidMember member) throws IOException {
      super(eVersion, member);
      c1Nid = P.s.getNidForUuids(eVersion.getUuid1());
      c2Nid = P.s.getNidForUuids(eVersion.getUuid2());
      c3Nid = P.s.getNidForUuids(eVersion.getUuid3());
   }

   public NidNidNidRevision(TupleInput input, NidNidNidMember primoridalMember) {
      super(input, primoridalMember);
      c1Nid = input.readInt();
      c2Nid = input.readInt();
      c3Nid = input.readInt();
   }

   public NidNidNidRevision(int statusNid, int authorNid, int pathNid, long time,
                            NidNidNidMember primoridalMember) {
      super(statusNid, authorNid, pathNid, time, primoridalMember);
      c1Nid = primoridalMember.getC1Nid();
      c2Nid = primoridalMember.getC2Nid();
      c3Nid = primoridalMember.getC3Nid();
   }

   protected NidNidNidRevision(int statusNid, int authorNid, int pathNid, long time,
                               NidNidNidRevision another) {
      super(statusNid, authorNid, pathNid, time, another.primordialComponent);
      c1Nid = another.c1Nid;
      c2Nid = another.c2Nid;
      c3Nid = another.c3Nid;
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

      if (NidNidNidRevision.class.isAssignableFrom(obj.getClass())) {
         NidNidNidRevision another = (NidNidNidRevision) obj;

         return (this.c1Nid == another.c1Nid) && (this.c2Nid == another.c2Nid)
                && (this.c3Nid == another.c3Nid) && super.equals(obj);
      }

      return false;
   }

   @Override
   public NidNidNidRevision makeAnalog() {
      return new NidNidNidRevision(getStatusNid(), getAuthorNid(), getPathNid(), getTime(), this);
   }

   @Override
   public NidNidNidRevision makeAnalog(int statusNid, int authorNid, int pathNid, long time) {
      if ((this.getTime() == time) && (this.getPathNid() == pathNid)) {
         this.setStatusNid(statusNid);

         return this;
      }

      NidNidNidRevision newR = new NidNidNidRevision(statusNid, authorNid, pathNid, time, this);

      primordialComponent.addRevision(newR);

      return newR;
   }

   @Override
   public boolean readyToWriteRefsetRevision() {
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

      buf.append(this.getClass().getSimpleName()).append(":{");
      buf.append(" c1Nid: ");
      ConceptComponent.addNidToBuffer(buf, c1Nid);
      buf.append(" c2Nid: ");
      ConceptComponent.addNidToBuffer(buf, c2Nid);
      buf.append(" c3Nid: ");
      ConceptComponent.addNidToBuffer(buf, c3Nid);
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   protected void writeFieldsToBdb(TupleOutput output) {
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
   public TkRefexAbstractMember<?> getTkRefexMemberActiveOnly(ViewCoordinate vc, NidBitSetBI exclusionSet,
           Map<UUID, UUID> conversionMap)
           throws ContradictionException, IOException {
      return new TkRefexUuidUuidUuidMember(this, exclusionSet, conversionMap, 0, true, vc);
   }

   @Override
   protected TK_REFEX_TYPE getTkRefsetType() {
      return TK_REFEX_TYPE.CID_CID_CID;
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
   public NidNidNidMember.Version getVersion(ViewCoordinate c) throws ContradictionException {
      return (NidNidNidMember.Version) ((NidNidNidMember) primordialComponent).getVersion(c);
   }

   @Override
   public Collection<NidNidNidMember.Version> getVersions() {
      return ((NidNidNidMember) primordialComponent).getVersions();
   }

   @Override
   public Collection<? extends RefexVersionBI<NidNidNidRevision>> getVersions(ViewCoordinate c) {
      return ((NidNidNidMember) primordialComponent).getVersions(c);
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
   public void setNid1(int cnid) throws PropertyVetoException {
      this.c1Nid = cnid;
      modified();
   }

   @Override
   public void setNid2(int cnid) throws PropertyVetoException {
      this.c2Nid = cnid;
      modified();
   }

   @Override
   public void setNid3(int cnid) throws PropertyVetoException {
      this.c3Nid = cnid;
      modified();
   }
}
