package org.ihtsdo.cc.refex.type_membership;

//~--- non-JDK imports --------------------------------------------------------

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;

import org.ihtsdo.cern.colt.list.IntArrayList;


import org.ihtsdo.cc.refex.RefexRevision;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.blueprint.RefexCAB;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.type_member.TkRefexRevision;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;
import org.ihtsdo.tk.api.refex.type_member.RefexMemberAnalogBI;

public class MembershipRevision extends RefexRevision<MembershipRevision, MembershipMember> 
    implements RefexMemberAnalogBI<MembershipRevision> {
   public MembershipRevision() {
      super();
   }

   public MembershipRevision(int statusAtPositionNid, MembershipMember primoridalMember) {
      super(statusAtPositionNid, primoridalMember);
   }

   public MembershipRevision(TkRefexRevision eVersion, MembershipMember member) throws IOException {
      super(eVersion, member);
   }

   public MembershipRevision(TupleInput input, MembershipMember primoridalMember) {
      super(input, primoridalMember);
   }


   public MembershipRevision(int statusNid, long time, int authorNid, int pathNid, int moduleNid,
                             MembershipMember primoridalMember) {
      super(statusNid, time, authorNid, moduleNid, pathNid, primoridalMember);
   }

   protected MembershipRevision(int statusNid, long time, int authorNid, int pathNid, int moduleNid,
                                MembershipRevision another) {
      super(statusNid, time, authorNid, moduleNid, pathNid, another.primordialComponent);
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

      if (MembershipRevision.class.isAssignableFrom(obj.getClass())) {
         return super.equals(obj);
      }

      return false;
   }

   @Override
   public MembershipRevision makeAnalog() {
      return new MembershipRevision(getStatusNid(), getTime(), getAuthorNid(), getModuleNid(), getPathNid(),  this);
   }

   @Override
   public MembershipRevision makeAnalog(int statusNid, long time, int authorNid, int moduleNid, int pathNid) {
      if ((this.getTime() == time) && (this.getPathNid() == pathNid)) {
         this.setStatusNid(statusNid);
         this.setAuthorNid(authorNid);
         this.setModuleNid(moduleNid);

         return this;
      }

      MembershipRevision newR = new MembershipRevision(statusNid, time, authorNid, moduleNid, pathNid, this);

      primordialComponent.addRevision(newR);

      return newR;
   }

   @Override
   public boolean readyToWriteRefsetRevision() {
      return true;
   }

   /*
    *  (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuilder buf = new StringBuilder();

      buf.append(this.getClass().getSimpleName()).append(":{");
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   protected void writeFieldsToBdb(TupleOutput output) {

      // nothing to write
   }

   //~--- get methods ---------------------------------------------------------

    @Override
   protected TK_REFEX_TYPE getTkRefsetType() {
      return TK_REFEX_TYPE.MEMBER;
   }

   @Override
   public IntArrayList getVariableVersionNids() {
      return new IntArrayList(2);
   }

   @Override
   public MembershipMember.Version getVersion(ViewCoordinate c) throws ContradictionException {
      return (MembershipMember.Version) ((MembershipMember) primordialComponent).getVersion(c);
   }

   @Override
   public Collection<MembershipMember.Version> getVersions() {
      return ((MembershipMember) primordialComponent).getVersions();
   }

   @Override
   public Collection<? extends RefexVersionBI<MembershipRevision>> getVersions(ViewCoordinate c) {
      return ((MembershipMember) primordialComponent).getVersions(c);
   }
}
