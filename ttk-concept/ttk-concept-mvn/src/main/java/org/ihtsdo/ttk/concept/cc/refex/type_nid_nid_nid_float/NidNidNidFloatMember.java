package org.ihtsdo.ttk.concept.cc.refex.type_nid_nid_nid_float;

//~--- non-JDK imports --------------------------------------------------------

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;

import org.ihtsdo.cern.colt.list.IntArrayList;
import org.ihtsdo.ttk.api.TK_REFEX_TYPE;
import org.ihtsdo.ttk.api.blueprint.RefexCAB;
import org.ihtsdo.ttk.api.blueprint.RefexCAB.RefexProperty;
import org.ihtsdo.ttk.api.hash.Hashcode;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_nid_nid_float
   .RefexNidNidNidFloatAnalogBI;
import org.ihtsdo.ttk.api.refex.type_nid_nid_nid_float
   .RefexNidNidNidFloatVersionBI;
import org.ihtsdo.ttk.concept.cc.P;
import org.ihtsdo.ttk.concept.cc.component.ConceptComponent;
import org.ihtsdo.ttk.concept.cc.component.RevisionSet;
import org.ihtsdo.ttk.concept.cc.computer.version.VersionComputer;
import org.ihtsdo.ttk.concept.cc.refex.RefexMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid_float
   .TkRefexUuidUuidUuidFloatMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid_float
   .TkRefexUuidUuidUuidFloatRevision;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyVetoException;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NidNidNidFloatMember
        extends RefexMember<NidNidNidFloatRevision, NidNidNidFloatMember>
        implements RefexNidNidNidFloatVersionBI<NidNidNidFloatRevision>,
                   RefexNidNidNidFloatAnalogBI<NidNidNidFloatRevision> {
   private static VersionComputer<RefexMember<NidNidNidFloatRevision, NidNidNidFloatMember>.Version> computer =
      new VersionComputer<>();
   private int   nid1;
   private int   nid2;
   private int   nid3;
   private float float1;

   public NidNidNidFloatMember() {
      super();
   }

   public NidNidNidFloatMember(int enclosingConceptNid, TupleInput input)
           throws IOException {
      super(enclosingConceptNid, input);
   }

   public NidNidNidFloatMember(TkRefexUuidUuidUuidFloatMember refsetMember,
                               int enclosingConceptNid)
           throws IOException {
      super(refsetMember, enclosingConceptNid);
      nid1   = P.s.getNidForUuids(refsetMember.getUuid1());
      nid2   = P.s.getNidForUuids(refsetMember.getUuid2());
      nid3   = P.s.getNidForUuids(refsetMember.getUuid3());
      float1 = refsetMember.float1;

      if (refsetMember.getRevisionList() != null) {
         revisions = new RevisionSet<>(primordialStamp);

         for (TkRefexUuidUuidUuidFloatRevision eVersion :
                 refsetMember.getRevisionList()) {
            revisions.add(new NidNidNidFloatRevision(eVersion, this));
         }
      }
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
      rcs.with(RefexProperty.FLOAT1, getFloat1());
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (NidNidNidFloatMember.class.isAssignableFrom(obj.getClass())) {
         NidNidNidFloatMember another = (NidNidNidFloatMember) obj;

         return (this.nid1 == another.nid1) && (this.nid2 == another.nid2)
                && (this.nid3 == another.nid3) && (this.float1 == another.float1)
                && (this.referencedComponentNid
                    == another.referencedComponentNid);
      }

      return false;
   }

   @Override
   public int hashCode() {
      return Hashcode.compute(new int[] { nid1, nid2, nid3 });
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
      NidNidNidFloatRevision newR = new NidNidNidFloatRevision(statusNid, time,
                                       authorNid, moduleNid, pathNid, this);

      addRevision(newR);

      return newR;
   }

   @Override
   protected void readMemberFields(TupleInput input) {
      nid1 = input.readInt();
      nid2 = input.readInt();
      nid3 = input.readInt();
      float1 = input.readFloat();
   }

   @Override
   protected final NidNidNidFloatRevision readMemberRevision(TupleInput input) {
      return new NidNidNidFloatRevision(input, this);
   }

   @Override
   public boolean readyToWriteRefsetMember() {
      assert nid1 != Integer.MAX_VALUE;
      assert nid2 != Integer.MAX_VALUE;
      assert nid3 != Integer.MAX_VALUE;

      return true;
   }

   @Override
   protected boolean refexFieldsEqual(ConceptComponent<NidNidNidFloatRevision,
           NidNidNidFloatMember> obj) {
      if (NidNidNidFloatMember.class.isAssignableFrom(obj.getClass())) {
         NidNidNidFloatMember another = (NidNidNidFloatMember) obj;

         return (this.nid1 == another.nid1) && (this.nid2 == another.nid2)
                && (this.nid3 == another.nid3) && (this.float1 == another.float1);
      }

      return false;
   }

   @Override
   public boolean refexFieldsEqual(RefexVersionBI another) {
      if (RefexNidNidNidFloatVersionBI.class.isAssignableFrom(another.getClass())) {
         RefexNidNidNidFloatVersionBI cv = (RefexNidNidNidFloatVersionBI) another;

         return (this.nid1 == cv.getNid1()) && (this.nid2 == cv.getNid2())
                && (this.nid3 == cv.getNid3() && (this.float1 == cv.getFloat1()));
      }

      return false;
   }

   /*
    *  (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuffer buf = new StringBuffer();

      buf.append(this.getClass().getSimpleName()).append(" ");
      buf.append(" nid1: ");
      addNidToBuffer(buf, nid1);
      buf.append(" nid2: ");
      addNidToBuffer(buf, nid2);
      buf.append(" nid3: ");
      addNidToBuffer(buf, nid3);
      buf.append(" float1: ");
      buf.append(float1);
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   protected void writeMember(TupleOutput output) {
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
   public int getTypeNid() {
      return TK_REFEX_TYPE.CID_CID_CID_FLOAT.getTypeToken();
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
   protected VersionComputer<RefexMember<NidNidNidFloatRevision,
           NidNidNidFloatMember>.Version> getVersionComputer() {
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
            for (NidNidNidFloatRevision r : revisions) {
               if (r.getTime() != Long.MIN_VALUE) {
                  list.add(new Version(r));
               }
            }
         }

         versions = list;
      }

      return (List<Version>) versions;
   }

   @Override
   public void setFloat1(float float1) {
      this.float1 = float1;
      modified();
   }

   @Override
   public void setNid1(int cnid1) throws PropertyVetoException {
      this.nid1 = cnid1;
      modified();
   }

   @Override
   public void setNid2(int cnid2) throws PropertyVetoException {
      this.nid2 = cnid2;
      modified();
   }

   @Override
   public void setNid3(int cnid) throws PropertyVetoException {
      this.nid3 = cnid;
      modified();
   }

   public class Version
           extends RefexMember<NidNidNidFloatRevision,
                               NidNidNidFloatMember>.Version
           implements RefexNidNidNidFloatVersionBI<NidNidNidFloatRevision> {
      private Version(RefexNidNidNidFloatAnalogBI cv) {
         super(cv);
      }

      RefexNidNidNidFloatAnalogBI getCv() {
         return (RefexNidNidNidFloatAnalogBI) cv;
      }

      @Override
      public TkRefexUuidUuidUuidFloatMember getERefsetMember()
              throws IOException {
         return new TkRefexUuidUuidUuidFloatMember(this);
      }

      @Override
      public TkRefexUuidUuidUuidFloatRevision getERefsetRevision()
              throws IOException {
         return new TkRefexUuidUuidUuidFloatRevision(this);
      }

      @Override
      public float getFloat1() {
         return getCv().getFloat1();
      }

      @Override
      public int getNid1() {
         return getCv().getNid1();
      }

      @Override
      public int getNid2() {
         return getCv().getNid2();
      }

      @Override
      public int getNid3() {
         return getCv().getNid3();
      }
   }
}
