package org.ihtsdo.ttk.concept.cc.refex.type_nid_nid_nid_long;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.concept.cc.refex.type_nid_nid_nid_long.*;
import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;

import org.ihtsdo.cern.colt.list.IntArrayList;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TK_REFEX_TYPE;
import org.ihtsdo.ttk.api.blueprint.RefexCAB;
import org.ihtsdo.ttk.api.blueprint.RefexCAB.RefexProperty;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_nid_nid_long
   .RefexNidNidNidLongAnalogBI;
import org.ihtsdo.ttk.concept.cc.P;
import org.ihtsdo.ttk.concept.cc.component.ConceptComponent;
import org.ihtsdo.ttk.concept.cc.refex.RefexRevision;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid_long
   .TkRefexUuidUuidUuidLongRevision;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyVetoException;

import java.io.IOException;

import java.util.*;

public class NidNidNidLongRevision
        extends RefexRevision<NidNidNidLongRevision, NidNidNidLongMember>
        implements RefexNidNidNidLongAnalogBI<NidNidNidLongRevision> {
   private int   nid1;
   private int   nid2;
   private int   nid3;
   private long long1;

   public NidNidNidLongRevision() {
      super();
   }

   public NidNidNidLongRevision(int statusAtPositionNid,
                                 NidNidNidLongMember primoridalMember) {
      super(statusAtPositionNid, primoridalMember);
      nid1  = primoridalMember.getNid1();
      nid2  = primoridalMember.getNid2();
      nid3  = primoridalMember.getNid3();
      long1 = primoridalMember.getLong1();
   }

   public NidNidNidLongRevision(TkRefexUuidUuidUuidLongRevision eVersion,
                                 NidNidNidLongMember member)
           throws IOException {
      super(eVersion, member);
      nid1  = P.s.getNidForUuids(eVersion.getUuid1());
      nid2  = P.s.getNidForUuids(eVersion.getUuid2());
      nid3  = P.s.getNidForUuids(eVersion.getUuid3());
      long1 = eVersion.getLong1();
   }

   public NidNidNidLongRevision(TupleInput input,
                                 NidNidNidLongMember primoridalMember) {
      super(input, primoridalMember);
      nid1  = input.readInt();
      nid2  = input.readInt();
      nid3  = input.readInt();
      long1 = input.readLong();
   }

   public NidNidNidLongRevision(int statusNid, long time, int authorNid,
                                 int moduleNid, int pathNid,
                                 NidNidNidLongMember primoridalMember) {
      super(statusNid, time, authorNid, moduleNid, pathNid, primoridalMember);
      nid1  = primoridalMember.getNid1();
      nid2  = primoridalMember.getNid2();
      nid3  = primoridalMember.getNid3();
      long1 = primoridalMember.getLong1();
   }

   protected NidNidNidLongRevision(int statusNid, long time, int authorNid,
                                    int moduleNid, int pathNid,
                                    NidNidNidLongRevision another) {
      super(statusNid, time, authorNid, moduleNid, pathNid,
            another.primordialComponent);
      nid1  = another.nid1;
      nid2  = another.nid2;
      nid3  = another.nid3;
      long1 = another.long1;
   }

   @Override
   protected void addRefsetTypeNids(Set<Integer> allNids) {
      allNids.add(nid1);
      allNids.add(nid2);
      allNids.add(nid3);
   }

   @Override
   protected void addSpecProperties(RefexCAB rcs) {
      rcs.with(RefexProperty.CNID1, getNid1());
      rcs.with(RefexProperty.CNID2, getNid2());
      rcs.with(RefexProperty.CNID3, getNid3());
      rcs.with(RefexProperty.LONG1, getLong1());
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (NidNidNidLongRevision.class.isAssignableFrom(obj.getClass())) {
         NidNidNidLongRevision another = (NidNidNidLongRevision) obj;

         return (this.nid1 == another.nid1) && (this.nid2 == another.nid2)
                && (this.nid3 == another.nid3)
                && (this.long1 == another.long1) && super.equals(obj);
      }

      return false;
   }

   @Override
   public NidNidNidLongRevision makeAnalog() {
      return new NidNidNidLongRevision(getStatusNid(), getTime(),
                                        getAuthorNid(), getModuleNid(),
                                        getPathNid(), this);
   }

   @Override
   public NidNidNidLongRevision makeAnalog(int statusNid, long time,
           int authorNid, int moduleNid, int pathNid) {
      if ((this.getTime() == time) && (this.getPathNid() == pathNid)) {
         this.setStatusNid(statusNid);
         this.setAuthorNid(authorNid);
         this.setModuleNid(moduleNid);

         return this;
      }

      NidNidNidLongRevision newR = new NidNidNidLongRevision(statusNid, time,
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
      buf.append(" long1: ").append(long1);
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   protected void writeFieldsToBdb(TupleOutput output) {
      output.writeInt(nid1);
      output.writeInt(nid2);
      output.writeInt(nid3);
      output.writeLong(long1);
   }

   @Override
   public long getLong1() {
      return long1;
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
      return TK_REFEX_TYPE.CID_CID_CID_LONG;
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
   public NidNidNidLongMember.Version getVersion(ViewCoordinate c)
           throws ContradictionException {
      return (NidNidNidLongMember
         .Version) ((NidNidNidLongMember) primordialComponent).getVersion(c);
   }

   @Override
   public Collection<NidNidNidLongMember.Version> getVersions() {
      return ((NidNidNidLongMember) primordialComponent).getVersions();
   }

   @Override
   public Collection<? extends RefexVersionBI<NidNidNidLongRevision>> getVersions(
           ViewCoordinate c) {
      return ((NidNidNidLongMember) primordialComponent).getVersions(c);
   }

   @Override
   public void setLong1(long long1) {
      this.long1 = long1;
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