package org.ihtsdo.concept.component.attributes;

//~--- non-JDK imports --------------------------------------------------------

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;

import java.io.IOException;
import org.ihtsdo.cern.colt.list.IntArrayList;


import org.ihtsdo.concept.component.Revision;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.blueprint.ConAttrAB;
import org.ihtsdo.tk.api.conattr.ConAttrAnalogBI;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;

//~--- JDK imports ------------------------------------------------------------

import java.util.Collection;
import java.util.Set;
import org.ihtsdo.db.bdb.Bdb;
import org.ihtsdo.tk.api.blueprint.InvalidCAB;
import org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributesRevision;

public class ConceptAttributesRevision extends Revision<ConceptAttributesRevision, ConceptAttributes>
        implements ConAttrAnalogBI<ConceptAttributesRevision> {  
   private boolean defined = false;

   //~--- constructors --------------------------------------------------------

   public ConceptAttributesRevision(ConAttrAnalogBI another, ConceptAttributes primoridalMember) {
      super(another.getStatusNid(), another.getAuthorNid(), another.getPathNid(), another.getTime(),
            primoridalMember);
      this.defined = another.isDefined();
   }

   public ConceptAttributesRevision(TkConceptAttributesRevision another, ConceptAttributes primoridalMember) {
      super(Bdb.uuidToNid(another.getStatusUuid()), Bdb.uuidToNid(another.getAuthorUuid()),
            Bdb.uuidToNid(another.getPathUuid()), another.getTime(), primoridalMember);
      this.defined = another.isDefined();
   }

   public ConceptAttributesRevision(int statusAtPositionNid, ConceptAttributes primoridalMember) {
      super(statusAtPositionNid, primoridalMember);
   }

   public ConceptAttributesRevision(TupleInput input, ConceptAttributes primoridalMember) {
      super(input, primoridalMember);
      defined = input.readBoolean();
   }

   public ConceptAttributesRevision(int statusNid, int authorNid, int pathNid, long time,
                                    ConceptAttributes primoridalMember) {
      super(statusNid, authorNid, pathNid, time, primoridalMember);
   }

   public ConceptAttributesRevision(ConAttrAnalogBI another, int statusNid, int authorNid,
                                    int pathNid, long time, ConceptAttributes primoridalMember) {
      super(statusNid, authorNid, pathNid, time, primoridalMember);
      this.defined = another.isDefined();
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected void addComponentNids(Set<Integer> allNids) {

      // nothing to add
   }


   // TODO Verify this is a correct implementation
   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (ConceptAttributesRevision.class.isAssignableFrom(obj.getClass())) {
         ConceptAttributesRevision another = (ConceptAttributesRevision) obj;

         if (this.sapNid == another.sapNid) {
            return true;
         }
      }

      return false;
   }

   @Override
   public ConceptAttributesRevision makeAnalog(int statusNid, int authorNid, int pathNid, long time) {
      if ((this.getTime() == time) && (this.getPathNid() == pathNid)) {
         this.setStatusNid(statusNid);
         this.setAuthorNid(authorNid);

         return this;
      }

      ConceptAttributesRevision newR;

      newR = new ConceptAttributesRevision(this, statusNid, authorNid, pathNid, time,
              this.primordialComponent);
      this.primordialComponent.addRevision(newR);

      return newR;
   }

   @Override
   public boolean readyToWriteRevision() {
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
      buf.append("conceptAttributes: ").append(this.primordialComponent.nid);
      buf.append(" defined: ").append(this.defined);
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   public String toUserString() {
      StringBuilder buf = new StringBuilder();

      buf.append("concept ");

      if (defined) {
         buf.append("is fully defined");
      } else {
         buf.append("is primitive");
      }

      return buf.toString();
   }

   @Override
   protected void writeFieldsToBdb(TupleOutput output) {
      output.writeBoolean(defined);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public ConceptAttributes getPrimordialVersion() {
      return primordialComponent;
   }

   @Override
   public IntArrayList getVariableVersionNids() {
      return new IntArrayList(2);
   }

   @Override
   public ConceptAttributes.Version getVersion(ViewCoordinate c) throws ContradictionException {
      return primordialComponent.getVersion(c);
   }

   @Override
   public Collection<ConceptAttributes.Version> getVersions() {
      return ((ConceptAttributes) primordialComponent).getVersions();
   }

   @Override
   public Collection<ConceptAttributes.Version> getVersions(ViewCoordinate c) {
      return primordialComponent.getVersions(c);
   }

   @Override
   public boolean isDefined() {
      return defined;
   }

   //~--- set methods ---------------------------------------------------------

   @Override
   public void setDefined(boolean defined) {
      this.defined = defined;
      modified();
   }

    @Override
    public ConAttrAB makeBlueprint(ViewCoordinate vc) throws IOException, ContradictionException, InvalidCAB {
        ConAttrAB conAttrBp = new ConAttrAB(primordialComponent.getConceptNid(), defined, getVersion(vc), vc);
        return conAttrBp;
    }
}
