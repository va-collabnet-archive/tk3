package org.ihtsdo.ttk.concept.cc.refex.type_nid_nid_nid_string;

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
import org.ihtsdo.ttk.api.refex.type_nid_nid_nid_string
   .RefexNidNidNidStringAnalogBI;
import org.ihtsdo.ttk.concept.cc.P;
import org.ihtsdo.ttk.concept.cc.component.ConceptComponent;
import org.ihtsdo.ttk.concept.cc.refex.RefexRevision;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid_string
   .TkRefexUuidUuidUuidStringRevision;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyVetoException;

import java.io.IOException;

import java.util.*;

public class NidNidNidStringRevision
        extends RefexRevision<NidNidNidStringRevision, NidNidNidStringMember>
        implements RefexNidNidNidStringAnalogBI<NidNidNidStringRevision> {
   private int   nid1;
   private int   nid2;
   private int   nid3;
   private String string1;

   public NidNidNidStringRevision() {
      super();
   }

   public NidNidNidStringRevision(int statusAtPositionNid,
                                 NidNidNidStringMember primoridalMember) {
      super(statusAtPositionNid, primoridalMember);
      nid1  = primoridalMember.getNid1();
      nid2  = primoridalMember.getNid2();
      nid3  = primoridalMember.getNid3();
      string1 = primoridalMember.getString1();
   }

   public NidNidNidStringRevision(TkRefexUuidUuidUuidStringRevision eVersion,
                                 NidNidNidStringMember member)
           throws IOException {
      super(eVersion, member);
      nid1  = P.s.getNidForUuids(eVersion.getUuid1());
      nid2  = P.s.getNidForUuids(eVersion.getUuid2());
      nid3  = P.s.getNidForUuids(eVersion.getUuid3());
      string1 = eVersion.getString1();
   }

   public NidNidNidStringRevision(TupleInput input,
                                 NidNidNidStringMember primoridalMember) {
      super(input, primoridalMember);
      nid1  = input.readInt();
      nid2  = input.readInt();
      nid3  = input.readInt();
      string1 = input.readString();
   }

   public NidNidNidStringRevision(int statusNid, long time, int authorNid,
                                 int moduleNid, int pathNid,
                                 NidNidNidStringMember primoridalMember) {
      super(statusNid, time, authorNid, moduleNid, pathNid, primoridalMember);
      nid1  = primoridalMember.getNid1();
      nid2  = primoridalMember.getNid2();
      nid3  = primoridalMember.getNid3();
      string1 = primoridalMember.getString1();
   }

   protected NidNidNidStringRevision(int statusNid, long time, int authorNid,
                                    int moduleNid, int pathNid,
                                    NidNidNidStringRevision another) {
      super(statusNid, time, authorNid, moduleNid, pathNid,
            another.primordialComponent);
      nid1  = another.nid1;
      nid2  = another.nid2;
      nid3  = another.nid3;
      string1 = another.string1;
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
      rcs.with(RefexProperty.STRING_EXTENSION_1, getString1());
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (NidNidNidStringRevision.class.isAssignableFrom(obj.getClass())) {
         NidNidNidStringRevision another = (NidNidNidStringRevision) obj;

         return (this.nid1 == another.nid1) && (this.nid2 == another.nid2)
                && (this.nid3 == another.nid3)
                && (this.string1.equals(another.string1)) && super.equals(obj);
      }

      return false;
   }

   @Override
   public NidNidNidStringRevision makeAnalog() {
      return new NidNidNidStringRevision(getStatusNid(), getTime(),
                                        getAuthorNid(), getModuleNid(),
                                        getPathNid(), this);
   }

   @Override
   public NidNidNidStringRevision makeAnalog(int statusNid, long time,
           int authorNid, int moduleNid, int pathNid) {
      if ((this.getTime() == time) && (this.getPathNid() == pathNid)) {
         this.setStatusNid(statusNid);
         this.setAuthorNid(authorNid);
         this.setModuleNid(moduleNid);

         return this;
      }

      NidNidNidStringRevision newR = new NidNidNidStringRevision(statusNid, time,
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
      buf.append(" string1: ").append(string1);
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   protected void writeFieldsToBdb(TupleOutput output) {
      output.writeInt(nid1);
      output.writeInt(nid2);
      output.writeInt(nid3);
      output.writeString(string1);
   }

   @Override
   public String getString1() {
      return string1;
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
      return TK_REFEX_TYPE.CID_CID_CID_STRING;
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
   public NidNidNidStringMember.Version getVersion(ViewCoordinate c)
           throws ContradictionException {
      return (NidNidNidStringMember
         .Version) ((NidNidNidStringMember) primordialComponent).getVersion(c);
   }

   @Override
   public Collection<NidNidNidStringMember.Version> getVersions() {
      return ((NidNidNidStringMember) primordialComponent).getVersions();
   }

   @Override
   public Collection<? extends RefexVersionBI<NidNidNidStringRevision>> getVersions(
           ViewCoordinate c) {
      return ((NidNidNidStringMember) primordialComponent).getVersions(c);
   }

   @Override
   public void setString1(String string1) {
      this.string1 = string1;
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
