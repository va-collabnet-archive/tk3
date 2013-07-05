package org.ihtsdo.ttk.concept.cc.refex.type_membership;

//~--- non-JDK imports --------------------------------------------------------

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;

import org.ihtsdo.cern.colt.list.IntArrayList;


import org.ihtsdo.ttk.concept.cc.refex.RefexRevision;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.blueprint.RefexCAB;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.ToolkitRefexType;
import org.ihtsdo.ttk.dto.component.refex.type_member.TtkRefexRevision;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;
import org.ihtsdo.ttk.api.refex.type_member.RefexMemberAnalogBI;

public class MembershipRevision extends RefexRevision<MembershipRevision, MembershipMember> 
    implements RefexMemberAnalogBI<MembershipRevision> {
   public MembershipRevision() {
      super();
   }

   public MembershipRevision(int statusAtPositionNid, MembershipMember primoridalMember) {
      super(statusAtPositionNid, primoridalMember);
   }

   public MembershipRevision(TtkRefexRevision eVersion, MembershipMember member) throws IOException {
      super(eVersion, member);
   }

   public MembershipRevision(TupleInput input, MembershipMember primoridalMember) {
      super(input, primoridalMember);
   }


   public MembershipRevision(int statusNid, long time, int authorNid, int moduleNid, int pathNid,
                             MembershipMember primoridalMember) {
      super(statusNid, time, authorNid, moduleNid, pathNid, primoridalMember);
   }

   protected MembershipRevision(int statusNid, long time, int authorNid, int moduleNid, int pathNid,
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
   protected ToolkitRefexType getTkRefsetType() {
      return ToolkitRefexType.MEMBER;
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
