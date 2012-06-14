package org.ihtsdo.cc.refex.type_long;

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
import org.ihtsdo.tk.api.refex.type_long.RefexLongAnalogBI;
import org.ihtsdo.tk.dto.concept.component.refex.type_long.TkRefexLongMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_long.TkRefexLongRevision;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.ihtsdo.tk.hash.Hashcode;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyVetoException;

import java.io.IOException;

import java.util.*;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_long.RefexLongVersionBI;

public class LongMember extends RefexMember<LongRevision, LongMember>
        implements RefexLongAnalogBI<LongRevision> {
   private static VersionComputer<RefexMember<LongRevision, LongMember>.Version> computer =
      new VersionComputer<>();

   //~--- fields --------------------------------------------------------------

   private long longValue;

   //~--- constructors --------------------------------------------------------

   public LongMember() {
      super();
   }

   public LongMember(int enclosingConceptNid, TupleInput input) throws IOException {
      super(enclosingConceptNid, input);
   }

   public LongMember(TkRefexLongMember refsetMember, int enclosingConceptNid) throws IOException {
      super(refsetMember, enclosingConceptNid);
      longValue = refsetMember.getLongValue();

      if (refsetMember.getRevisionList() != null) {
         revisions = new RevisionSet<>(primordialStampNid);

         for (TkRefexLongRevision eVersion : refsetMember.getRevisionList()) {
            revisions.add(new LongRevision(eVersion, this));
         }
      }
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected void addRefsetTypeNids(Set<Integer> allNids) {

      // ;
   }

   @Override
   protected void addSpecProperties(RefexCAB rcs) {
      rcs.with(RefexProperty.LONG1, getLong1());
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (LongMember.class.isAssignableFrom(obj.getClass())) {
         LongMember another = (LongMember) obj;

         return this.nid == another.nid;
      }

      return false;
   }

   @Override
   public int hashCode() {
      return Hashcode.compute(new int[] { this.nid });
   }

   @Override
   public LongRevision makeAnalog() {
      LongRevision newR = new LongRevision(getStatusNid(), getTime(), getAuthorNid(), getModuleNid(), getPathNid(), this);

      return newR;
   }

   @Override
   public LongRevision makeAnalog(int statusNid, long time, int authorNid, int moduleNid, int pathNid) {
      LongRevision newR = new LongRevision(statusNid, time, authorNid, moduleNid, pathNid, this);

      addRevision(newR);

      return newR;
   }

   @Override
   protected boolean refexFieldsEqual(ConceptComponent<LongRevision, LongMember> obj) {
      if (LongMember.class.isAssignableFrom(obj.getClass())) {
         LongMember another = (LongMember) obj;

         return this.longValue == another.longValue;
      }

      return false;
   }
   
   @Override
    public boolean refexFieldsEqual(RefexVersionBI another) {
        if(RefexLongVersionBI.class.isAssignableFrom(another.getClass())){
            RefexLongVersionBI lv = (RefexLongVersionBI) another;
            return this.longValue == lv.getLong1();
        }
        return false;
    }

   @Override
   protected void readMemberFields(TupleInput input) {
      longValue = input.readLong();
   }

   @Override
   protected final LongRevision readMemberRevision(TupleInput input) {
      return new LongRevision(input, this);
   }

   @Override
   public boolean readyToWriteRefsetMember() {
      return true;
   }

   /*
    * (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuilder buf = new StringBuilder();

      buf.append(this.getClass().getSimpleName());
      buf.append(" longValue:").append(this.longValue);
      buf.append(" ");
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   protected void writeMember(TupleOutput output) {
      output.writeLong(longValue);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public long getLong1() {
      return longValue;
   }

   @Override
   public TkRefexAbstractMember<?> getTkRefexMemberActiveOnly(ViewCoordinate vc, NidBitSetBI exclusionSet,
           Map<UUID, UUID> conversionMap)
           throws ContradictionException, IOException {
      return new TkRefexLongMember(this, exclusionSet, conversionMap, 0, true, vc);
   }

   @Override
   protected TK_REFEX_TYPE getTkRefsetType() {
      return TK_REFEX_TYPE.LONG;
   }

   @Override
   public int getTypeNid() {
      return TK_REFEX_TYPE.LONG.getTypeToken();
   }

   @Override
   protected IntArrayList getVariableVersionNids() {
      return new IntArrayList(2);
   }

   @Override
   protected VersionComputer<RefexMember<LongRevision, LongMember>.Version> getVersionComputer() {
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
            for (LongRevision lr : revisions) {
               if (lr.getTime() != Long.MIN_VALUE) {
                  list.add(new Version(lr));
               }
            }
         }

         versions = list;
      }

      return (List<Version>) versions;
   }

   //~--- set methods ---------------------------------------------------------

   @Override
   public void setLong1(long l) throws PropertyVetoException {
      this.longValue = l;
      modified();
   }

   //~--- inner classes -------------------------------------------------------

   public class Version extends RefexMember<LongRevision, LongMember>.Version
           implements RefexLongAnalogBI<LongRevision> {
      private Version(RefexLongAnalogBI cv) {
         super(cv);
      }

      //~--- methods ----------------------------------------------------------

      //~--- get methods ------------------------------------------------------

      RefexLongAnalogBI getCv() {
         return (RefexLongAnalogBI) cv;
      }

      @Override
      public TkRefexLongMember getERefsetMember() throws IOException {
         return new TkRefexLongMember(this);
      }

      @Override
      public TkRefexLongRevision getERefsetRevision() throws IOException {
         return new TkRefexLongRevision(this);
      }

      @Override
      public long getLong1() {
         return getCv().getLong1();
      }

      //~--- set methods ------------------------------------------------------

      @Override
      public void setLong1(long l) throws PropertyVetoException {
         getCv().setLong1(l);
      }

   }
}
