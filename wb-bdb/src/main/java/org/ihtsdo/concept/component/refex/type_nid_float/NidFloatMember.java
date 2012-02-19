package org.ihtsdo.concept.component.refex.type_nid_float;

//~--- non-JDK imports --------------------------------------------------------

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;



import org.ihtsdo.concept.component.ConceptComponent;
import org.ihtsdo.concept.component.RevisionSet;
import org.ihtsdo.concept.component.refex.RefexMember;
import org.ihtsdo.db.bdb.Bdb;
import org.ihtsdo.db.bdb.computer.version.VersionComputer;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.NidBitSetBI;
import org.ihtsdo.tk.api.blueprint.RefexCAB;
import org.ihtsdo.tk.api.blueprint.RefexCAB.RefexProperty;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.refex.type_nid_float.RefexNidFloatAnalogBI;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_uuid_float.TkRefexUuidFloatMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_uuid_float.TkRefexUuidFloatRevision;
import org.ihtsdo.tk.hash.Hashcode;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyVetoException;

import java.io.IOException;

import java.util.*;
import org.ihtsdo.cern.colt.list.IntArrayList;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_float.RefexNidFloatVersionBI;

public class NidFloatMember extends RefexMember<NidFloatRevision, NidFloatMember>
        implements RefexNidFloatAnalogBI<NidFloatRevision> {
   private static VersionComputer<RefexMember<NidFloatRevision, NidFloatMember>.Version> computer =
      new VersionComputer<RefexMember<NidFloatRevision, NidFloatMember>.Version>();

   //~--- fields --------------------------------------------------------------

   private int   c1Nid;
   private float floatValue;

   //~--- constructors --------------------------------------------------------

   public NidFloatMember() {
      super();
   }

   public NidFloatMember(int enclosingConceptNid, TupleInput input) throws IOException {
      super(enclosingConceptNid, input);
   }

   public NidFloatMember(TkRefexUuidFloatMember refsetMember, int enclosingConceptNid) throws IOException {
      super(refsetMember, enclosingConceptNid);
      c1Nid      = Bdb.uuidToNid(refsetMember.getUuid1());
      floatValue = refsetMember.getFloatValue();

      if (refsetMember.getRevisionList() != null) {
         revisions = new RevisionSet<NidFloatRevision, NidFloatMember>(primordialSapNid);

         for (TkRefexUuidFloatRevision eVersion : refsetMember.getRevisionList()) {
            revisions.add(new NidFloatRevision(eVersion, this));
         }
      }
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

      if (NidFloatMember.class.isAssignableFrom(obj.getClass())) {
         NidFloatMember another = (NidFloatMember) obj;

         return this.c1Nid == another.c1Nid;
      }

      return false;
   }

   @Override
   public int hashCode() {
      return Hashcode.compute(new int[] { c1Nid });
   }

   @Override
   public NidFloatRevision makeAnalog() {
      return new NidFloatRevision(getStatusNid(), getAuthorNid(), getPathNid(), getTime(), this);
   }

   @Override
   public NidFloatRevision makeAnalog(int statusNid, int authorNid, int pathNid, long time) {
      NidFloatRevision newR = new NidFloatRevision(statusNid, authorNid, pathNid, time, this);

      addRevision(newR);

      return newR;
   }

   @Override
   protected boolean refexFieldsEqual(ConceptComponent<NidFloatRevision, NidFloatMember> obj) {
      if (NidFloatMember.class.isAssignableFrom(obj.getClass())) {
         NidFloatMember another = (NidFloatMember) obj;

         return (this.c1Nid == another.c1Nid) && (this.floatValue == another.floatValue);
      }

      return false;
   }
   
   @Override
    public boolean refexFieldsEqual(RefexVersionBI another) {
        if(RefexNidFloatVersionBI.class.isAssignableFrom(another.getClass())){
            RefexNidFloatVersionBI cv = (RefexNidFloatVersionBI) another;
            return (this.c1Nid == cv.getNid1()) && (this.floatValue == cv.getFloat1());
        }
        return false;
    }

   @Override
   protected void readMemberFields(TupleInput input) {
      c1Nid      = input.readInt();
      floatValue = input.readFloat();
   }

   @Override
   protected final NidFloatRevision readMemberRevision(TupleInput input) {
      return new NidFloatRevision(input, this);
   }

   @Override
   public boolean readyToWriteRefsetMember() {
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

      buf.append(this.getClass().getSimpleName()).append(":{");
      buf.append(" c1Nid: ");
      addNidToBuffer(buf, c1Nid);
      buf.append(" floatValue:").append(this.floatValue);
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   protected void writeMember(TupleOutput output) {
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
   public int getTypeNid() {
      return TK_REFEX_TYPE.CID_FLOAT.getTypeToken();
   }

   @Override
   public IntArrayList getVariableVersionNids() {
      IntArrayList variableNids = new IntArrayList(3);

      variableNids.add(getC1Nid());

      return variableNids;
   }

   @Override
   protected VersionComputer<RefexMember<NidFloatRevision, NidFloatMember>.Version> getVersionComputer() {
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

         ArrayList<Version> list = new ArrayList<Version>(count);

         if (getTime() != Long.MIN_VALUE) {
            list.add(new Version(this));
         }

         if (revisions != null) {
            for (NidFloatRevision r : revisions) {
               if (r.getTime() != Long.MIN_VALUE) {
                  list.add(new Version(r));
               }
            }
         }

         versions = list;
      }

      return (List<Version>) versions;
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

   //~--- inner classes -------------------------------------------------------

   public class Version extends RefexMember<NidFloatRevision, NidFloatMember>.Version
           implements RefexNidFloatAnalogBI<NidFloatRevision> {
      private Version(RefexNidFloatAnalogBI cv) {
         super(cv);
      }

      //~--- methods ----------------------------------------------------------
      //~--- get methods ------------------------------------------------------

      @Override
      public int getNid1() {
         return getCv().getNid1();
      }

      RefexNidFloatAnalogBI getCv() {
         return (RefexNidFloatAnalogBI) cv;
      }

      @Override
      public TkRefexUuidFloatMember getERefsetMember() throws IOException {
         return new TkRefexUuidFloatMember(this);
      }

      @Override
      public TkRefexUuidFloatRevision getERefsetRevision() throws IOException {
         return new TkRefexUuidFloatRevision(this);
      }

      @Override
      public float getFloat1() {
         return getCv().getFloat1();
      }

      @Override
      public void setNid1(int cnid1) throws PropertyVetoException {
         getCv().setNid1(cnid1);
      }

      @Override
      public void setFloat1(float f) throws PropertyVetoException {
         getCv().setFloat1(f);
      }
   }
}
