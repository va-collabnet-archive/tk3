package org.ihtsdo.cc.relationship;

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import org.ihtsdo.cc.P;
import org.ihtsdo.cc.component.ConceptComponent;
import org.ihtsdo.cc.component.Revision;
import org.ihtsdo.cern.colt.list.IntArrayList;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.blueprint.InvalidCAB;
import org.ihtsdo.tk.api.blueprint.RelCAB;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.relationship.RelationshipAnalogBI;
import org.ihtsdo.tk.binding.SnomedMetadataRf1;
import org.ihtsdo.tk.binding.SnomedMetadataRf2;
import org.ihtsdo.tk.dto.concept.component.relationship.TkRelType;
import org.ihtsdo.tk.dto.concept.component.relationship.TkRelationshipRevision;

public class RelationshipRevision extends Revision<RelationshipRevision, Relationship>
        implements RelationshipAnalogBI<RelationshipRevision> {
   private int characteristicNid;
   private int group;
   private int refinabilityNid;
   private int typeNid;

   //~--- constructors --------------------------------------------------------

   public RelationshipRevision() {
      super();
   }

   public RelationshipRevision(Relationship primordialRel) {
      super(primordialRel.primordialStampNid, primordialRel);
      this.characteristicNid = primordialRel.getCharacteristicNid();
      this.group             = primordialRel.getGroup();
      this.refinabilityNid   = primordialRel.getRefinabilityNid();
      this.typeNid           = primordialRel.getTypeNid();
   }

   public RelationshipRevision(int statusAtPositionNid, Relationship primordialRel) {
      super(statusAtPositionNid, primordialRel);
   }

   public RelationshipRevision(RelationshipRevision another, Relationship primordialRel) {
      super(another.stampNid, primordialRel);
      this.characteristicNid = another.characteristicNid;
      this.group             = another.group;
      this.refinabilityNid   = another.refinabilityNid;
      this.typeNid           = another.typeNid;
   }

   public RelationshipRevision(TkRelationshipRevision erv, Relationship primordialRel) throws IOException {
      super(P.s.getNidForUuids(erv.getStatusUuid()), erv.getTime(), P.s.getNidForUuids(erv.getAuthorUuid()),
            P.s.getNidForUuids(erv.getModuleUuid()), P.s.getNidForUuids(erv.getPathUuid()), primordialRel);
      this.characteristicNid = P.s.getNidForUuids(erv.getCharacteristicUuid());
      this.group             = erv.getGroup();
      this.refinabilityNid   = P.s.getNidForUuids(erv.getRefinabilityUuid());
      this.typeNid           = P.s.getNidForUuids(erv.getTypeUuid());
      this.stampNid          = P.s.getSapNid(erv);
   }

   public RelationshipRevision(TupleInput input, Relationship primordialRel) {
      super(input.readInt(), primordialRel);
      this.characteristicNid = input.readInt();
      this.group             = input.readSortedPackedInt();
      this.refinabilityNid   = input.readInt();
      this.typeNid           = input.readInt();
   }

   public RelationshipRevision(RelationshipAnalogBI another, int statusNid, long time, int authorNid,
                               int moduleNid, int pathNid, Relationship primordialRel) {
      super(statusNid, time, authorNid, moduleNid, pathNid, primordialRel);
      this.characteristicNid = another.getCharacteristicNid();
      this.group             = another.getGroup();
      this.refinabilityNid   = another.getRefinabilityNid();
      this.typeNid           = another.getTypeNid();
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected void addComponentNids(Set<Integer> allNids) {
      allNids.add(primordialComponent.getDestinationNid());
      allNids.add(characteristicNid);
      allNids.add(refinabilityNid);
      allNids.add(typeNid);
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (RelationshipRevision.class.isAssignableFrom(obj.getClass())) {
         RelationshipRevision another = (RelationshipRevision) obj;

         return this.stampNid == another.stampNid;
      }

      return false;
   }

   @Override
   public RelationshipRevision makeAnalog(int statusNid, long time, int authorNid, int moduleNid,
           int pathNid) {
      if ((this.getTime() == time) && (this.getPathNid() == pathNid)) {
         this.setStatusNid(statusNid);
         this.setAuthorNid(authorNid);
         this.setModuleNid(moduleNid);

         return this;
      }

      RelationshipRevision newR = new RelationshipRevision(this, statusNid, time, authorNid, moduleNid,
                                     pathNid, this.primordialComponent);

      this.primordialComponent.addRevision(newR);

      return newR;
   }

   @Override
   public RelCAB makeBlueprint(ViewCoordinate vc) throws IOException, ContradictionException, InvalidCAB {
      TkRelType relType = null;

      if ((getCharacteristicNid()
              == SnomedMetadataRf1.INFERRED_DEFINING_CHARACTERISTIC_TYPE_RF1.getLenient()
                 .getNid()) || (getCharacteristicNid()
                                == SnomedMetadataRf2.INFERRED_RELATIONSHIP_RF2.getLenient().getNid())) {
         throw new InvalidCAB("Inferred relationships can not be used to make blueprints");
      } else if ((getCharacteristicNid()
                  == SnomedMetadataRf1.STATED_DEFINING_CHARACTERISTIC_TYPE_RF1.getLenient()
                     .getNid()) || (getCharacteristicNid()
                                    == SnomedMetadataRf2.STATED_RELATIONSHIP_RF2.getLenient().getNid())) {
         relType = TkRelType.STATED_HIERARCHY;
      }

      RelCAB relBp = new RelCAB(getOriginNid(), getTypeNid(), getDestinationNid(), getGroup(), relType,
                                getVersion(vc), vc);

      return relBp;
   }

   @Override
   public boolean readyToWriteRevision() {
      assert characteristicNid != Integer.MAX_VALUE : assertionString();
      assert group != Integer.MAX_VALUE : assertionString();
      assert refinabilityNid != Integer.MAX_VALUE : assertionString();
      assert typeNid != Integer.MAX_VALUE : assertionString();

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
      buf.append("src:");
      ConceptComponent.addNidToBuffer(buf, this.primordialComponent.enclosingConceptNid);
      buf.append(" t:");
      ConceptComponent.addNidToBuffer(buf, typeNid);
      buf.append(" dest:");
      ConceptComponent.addNidToBuffer(buf, this.primordialComponent.getDestinationNid());
      buf.append(" c:");
      ConceptComponent.addNidToBuffer(buf, this.characteristicNid);
      buf.append(" g:").append(this.group);
      buf.append(" r:");
      ConceptComponent.addNidToBuffer(buf, this.refinabilityNid);
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   public String toUserString() {
      StringBuffer buf = new StringBuffer();

      ConceptComponent.addTextToBuffer(buf, typeNid);
      buf.append(": ");
      ConceptComponent.addTextToBuffer(buf, primordialComponent.getDestinationNid());

      return buf.toString();
   }

   @Override
   public void writeFieldsToBdb(TupleOutput output) {
      output.writeInt(characteristicNid);
      output.writeSortedPackedInt(group);
      output.writeInt(refinabilityNid);
      output.writeInt(typeNid);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public int getCharacteristicNid() {
      return characteristicNid;
   }

   @Override
   public int getDestinationNid() {
      return primordialComponent.getDestinationNid();
   }

   @Override
   public int getGroup() {
      return group;
   }

   @Override
   public int getOriginNid() {
      return primordialComponent.getOriginNid();
   }

   @Override
   public Relationship getPrimordialVersion() {
      return primordialComponent;
   }

   @Override
   public int getRefinabilityNid() {
      return refinabilityNid;
   }

   @Override
   public int getTypeNid() {
      return typeNid;
   }

   @Override
   public IntArrayList getVariableVersionNids() {
      IntArrayList nids = new IntArrayList(5);

      nids.add(characteristicNid);
      nids.add(refinabilityNid);
      nids.add(typeNid);

      return nids;
   }

   @Override
   public Relationship.Version getVersion(ViewCoordinate c) throws ContradictionException {
      return primordialComponent.getVersion(c);
   }

   @Override
   public Collection<? extends Relationship.Version> getVersions() {
      return ((Relationship) primordialComponent).getVersions();
   }

   @Override
   public Collection<Relationship.Version> getVersions(ViewCoordinate c) {
      return primordialComponent.getVersions(c);
   }

   @Override
   public boolean isInferred() {
      return (getCharacteristicNid() == Relationship.INFERRED_NID_RF2)
             || (getCharacteristicNid() == Relationship.INFERRED_NID_RF1);
   }

   @Override
   public boolean isStated() {
      return (getCharacteristicNid() == Relationship.STATED_NID_RF2)
             || (getCharacteristicNid() == Relationship.STATED_NID_RF1);
   }

   //~--- set methods ---------------------------------------------------------

   @Override
   public void setCharacteristicNid(int characteristicNid) {
      this.characteristicNid = characteristicNid;
   }

   @Override
   public void setDestinationNid(int nid) throws PropertyVetoException {
      throw new UnsupportedOperationException();
   }

   @Override
   public void setGroup(int group) {
      this.group = group;
      modified();
   }

   @Override
   public void setRefinabilityNid(int refinabilityNid) {
      this.refinabilityNid = refinabilityNid;
   }

   @Override
   public void setTypeNid(int typeNid) {
      this.typeNid = typeNid;
      modified();
   }
}
