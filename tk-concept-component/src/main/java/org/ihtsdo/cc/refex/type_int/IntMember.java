package org.ihtsdo.cc.refex.type_int;

//~--- non-JDK imports --------------------------------------------------------

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;

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
import org.ihtsdo.tk.api.refex.type_int.RefexIntAnalogBI;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_int.TkRefexIntMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_int.TkRefexIntRevision;
import org.ihtsdo.tk.hash.Hashcode;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyVetoException;

import java.io.IOException;

import java.util.*;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_int.RefexIntVersionBI;

public class IntMember extends RefexMember<IntRevision, IntMember>
        implements RefexIntAnalogBI<IntRevision> {
   private static VersionComputer<RefexMember<IntRevision, IntMember>.Version> computer =
      new VersionComputer<RefexMember<IntRevision, IntMember>.Version>();

   //~--- fields --------------------------------------------------------------

   private int int1;

   //~--- constructors --------------------------------------------------------

   public IntMember() {
      super();
   }

   public IntMember(int enclosingConceptNid, TupleInput input) throws IOException {
      super(enclosingConceptNid, input);
   }

   public IntMember(TkRefexIntMember refsetMember, int enclosingConceptNid) throws IOException {
      super(refsetMember, enclosingConceptNid);
      int1 = refsetMember.getIntValue();

      if (refsetMember.getRevisionList() != null) {
         revisions = new RevisionSet<IntRevision, IntMember>(primordialSapNid);

         for (TkRefexIntRevision eVersion : refsetMember.getRevisionList()) {
            revisions.add(new IntRevision(eVersion, this));
         }
      }
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected void addRefsetTypeNids(Set<Integer> allNids) {

      //
   }

   @Override
   protected void addSpecProperties(RefexCAB rcs) {
      rcs.with(RefexProperty.INTEGER1, this.int1);
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (IntMember.class.isAssignableFrom(obj.getClass())) {
         IntMember another = (IntMember) obj;

         return this.nid == another.nid;
      }

      return false;
   }

   @Override
   public int hashCode() {
      return Hashcode.compute(new int[] { this.nid });
   }

   @Override
   public IntRevision makeAnalog() {
      IntRevision newR = new IntRevision(getStatusNid(), getAuthorNid(), getPathNid(), getTime(), this);

      return newR;
   }

   @Override
   public IntRevision makeAnalog(int statusNid, int authorNid, int pathNid, long time) {
      IntRevision newR = new IntRevision(statusNid, authorNid, pathNid, time, this);

      addRevision(newR);

      return newR;
   }

   @Override
   protected boolean refexFieldsEqual(ConceptComponent<IntRevision, IntMember> obj) {
      if (IntMember.class.isAssignableFrom(obj.getClass())) {
         IntMember another = (IntMember) obj;

         return this.int1 == another.int1;
      }

      return false;
   }
   
   @Override
    public boolean refexFieldsEqual(RefexVersionBI another) {
        if(RefexIntVersionBI.class.isAssignableFrom(another.getClass())){
            RefexIntVersionBI iv = (RefexIntVersionBI) another;
            return this.int1 == iv.getInt1();
        }
        return false;
    }

   @Override
   protected void readMemberFields(TupleInput input) {
      int1 = input.readInt();
   }

   @Override
   protected final IntRevision readMemberRevision(TupleInput input) {
      return new IntRevision(input, this);
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

      buf.append(this.getClass().getSimpleName()).append(" ");
      buf.append(this.int1);
      buf.append(" ");
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   protected void writeMember(TupleOutput output) {
      output.writeInt(int1);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public int getInt1() {
      return int1;
   }

   
   @Override
   public TkRefexAbstractMember<?> getTkRefexMemberActiveOnly(ViewCoordinate vc, NidBitSetBI exclusionSet,
           Map<UUID, UUID> conversionMap)
           throws ContradictionException, IOException {
      return new TkRefexIntMember(this, exclusionSet, conversionMap, 0, true, vc);
   }

   @Override
   protected TK_REFEX_TYPE getTkRefsetType() {
      return TK_REFEX_TYPE.INT;
   }

   @Override
   public int getTypeNid() {
      return TK_REFEX_TYPE.INT.getTypeToken();
   }

   @Override
   protected IntArrayList getVariableVersionNids() {
      return new IntArrayList(2);
   }

   @Override
   protected VersionComputer<RefexMember<IntRevision, IntMember>.Version> getVersionComputer() {
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
            for (RefexIntAnalogBI r : revisions) {
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

   @Override
   public void setInt1(int intValue) throws PropertyVetoException {
      this.int1 = intValue;
      modified();
   }

   //~--- inner classes -------------------------------------------------------

   public class Version extends RefexMember<IntRevision, IntMember>.Version
           implements RefexIntAnalogBI<IntRevision> {
      private Version(RefexIntAnalogBI cv) {
         super(cv);
      }

      //~--- methods ----------------------------------------------------------



      //~--- get methods ------------------------------------------------------

      RefexIntAnalogBI getCv() {
         return (RefexIntAnalogBI) cv;
      }

      @Override
      public TkRefexIntMember getERefsetMember() throws IOException {
         return new TkRefexIntMember(this);
      }

      @Override
      public TkRefexIntRevision getERefsetRevision() throws IOException {
         return new TkRefexIntRevision(this);
      }

      @Override
      public int getInt1() {
         return getCv().getInt1();
      }

      //~--- set methods ------------------------------------------------------

      @Override
      public void setInt1(int value) throws PropertyVetoException {
         getCv().setInt1(value);
      }
   }
}
