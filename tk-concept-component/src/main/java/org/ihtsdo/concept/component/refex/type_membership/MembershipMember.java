package org.ihtsdo.concept.component.refex.type_membership;

//~--- non-JDK imports --------------------------------------------------------

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;

import org.ihtsdo.cern.colt.list.IntArrayList;


import org.ihtsdo.concept.component.ConceptComponent;
import org.ihtsdo.concept.component.RevisionSet;
import org.ihtsdo.concept.component.refex.RefexMember;
import org.ihtsdo.db.bdb.computer.version.VersionComputer;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.NidBitSetBI;
import org.ihtsdo.tk.api.blueprint.RefexCAB;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.refex.RefexAnalogBI;
import org.ihtsdo.tk.api.refex.type_long.RefexLongAnalogBI;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_member.TkRefexMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_member.TkRefexRevision;
import org.ihtsdo.tk.hash.Hashcode;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_member.RefexMemberAnalogBI;
import org.ihtsdo.tk.api.refex.type_member.RefexMemberVersionBI;

public class MembershipMember extends RefexMember<MembershipRevision, MembershipMember> 
    implements RefexMemberAnalogBI<MembershipRevision> {
   
    private static VersionComputer<RefexMember<MembershipRevision, MembershipMember>.Version> computer =
      new VersionComputer<RefexMember<MembershipRevision, MembershipMember>.Version>();

   //~--- constructors --------------------------------------------------------

   public MembershipMember() {
      super();
   }

   public MembershipMember(int enclosingConceptNid, TupleInput input) throws IOException {
      super(enclosingConceptNid, input);
   }

   public MembershipMember(TkRefexMember refsetMember, int enclosingConceptNid) throws IOException {
      super(refsetMember, enclosingConceptNid);

      if (refsetMember.getRevisionList() != null) {
         revisions = new RevisionSet<MembershipRevision, MembershipMember>(primordialSapNid);

         for (TkRefexRevision eVersion : refsetMember.getRevisionList()) {
            revisions.add(new MembershipRevision(eVersion, this));
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

      // no fields to add...
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (MembershipMember.class.isAssignableFrom(obj.getClass())) {
         MembershipMember another = (MembershipMember) obj;

         return this.nid == another.nid;
      }

      return false;
   }

   @Override
   public int hashCode() {
      return Hashcode.compute(new int[] { this.nid });
   }

   @Override
   public MembershipRevision makeAnalog() {
      MembershipRevision newR = new MembershipRevision(getStatusNid(), getAuthorNid(), getPathNid(), getTime(), this);

      return newR;
   }

   @Override
   public MembershipRevision makeAnalog(int statusNid, int authorNid, int pathNid, long time) {
      MembershipRevision newR = new MembershipRevision(statusNid, authorNid, pathNid, time, this);

      addRevision(newR);

      return newR;
   }

   @Override
   protected boolean refexFieldsEqual(ConceptComponent<MembershipRevision, MembershipMember> obj) {
      if (MembershipMember.class.isAssignableFrom(obj.getClass())) {
         return true;
      }

      return false;
   }
   
   
   @Override
    public boolean refexFieldsEqual(RefexVersionBI another) {
        if(RefexMemberVersionBI.class.isAssignableFrom(another.getClass())){
            return true;
        }
        return false;
    }

   @Override
   protected void readMemberFields(TupleInput input) {

      // nothing to read...
   }

   @Override
   protected final MembershipRevision readMemberRevision(TupleInput input) {
      return new MembershipRevision(input, this);
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
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   protected void writeMember(TupleOutput output) {

      // nothing to write
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public TkRefexAbstractMember<?> getTkRefexMemberActiveOnly(ViewCoordinate vc, NidBitSetBI exclusionSet,
           Map<UUID, UUID> conversionMap)
           throws ContradictionException, IOException {
      return new TkRefexMember(this, exclusionSet, conversionMap, 0, true, vc);
   }

   @Override
   protected TK_REFEX_TYPE getTkRefsetType() {
      return TK_REFEX_TYPE.MEMBER;
   }

   @Override
   public int getTypeNid() {
      return TK_REFEX_TYPE.MEMBER.getTypeToken();
   }

   @Override
   protected IntArrayList getVariableVersionNids() {
      return new IntArrayList(2);
   }

   @Override
   protected VersionComputer<RefexMember<MembershipRevision,
           MembershipMember>.Version> getVersionComputer() {
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
            for (MembershipRevision r : revisions) {
               if (r.getTime() != Long.MIN_VALUE) {
                  list.add(new Version(r));
               }
            }
         }

         versions = list;
      }

      return (List<Version>) versions;
   }

   //~--- inner classes -------------------------------------------------------

   public class Version extends RefexMember<MembershipRevision, MembershipMember>.Version
           implements RefexAnalogBI<MembershipRevision> {
      private Version(RefexAnalogBI cv) {
         super(cv);
      }

      //~--- methods ----------------------------------------------------------

      //~--- get methods ------------------------------------------------------

      RefexLongAnalogBI getCv() {
         return (RefexLongAnalogBI) cv;
      }

      @Override
      public TkRefexMember getERefsetMember() throws IOException {
         return new TkRefexMember(this);
      }

      @Override
      public TkRefexRevision getERefsetRevision() throws IOException {
         return new TkRefexRevision(this);
      }
   }
}
