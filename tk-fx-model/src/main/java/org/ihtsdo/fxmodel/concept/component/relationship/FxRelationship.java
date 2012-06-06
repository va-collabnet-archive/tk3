package org.ihtsdo.fxmodel.concept.component.relationship;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.TerminologyStoreDI;
import org.ihtsdo.tk.api.ext.I_RelateExternally;
import org.ihtsdo.tk.api.relationship.RelationshipChronicleBI;
import org.ihtsdo.tk.api.relationship.RelationshipVersionBI;
import org.ihtsdo.fxmodel.concept.component.FxComponent;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="relationship")
public class FxRelationship extends FxComponent<FxRelationshipRevision> implements I_RelateExternally {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlAttribute
   public UUID c1Uuid;
   @XmlAttribute
   public UUID c2Uuid;
   @XmlAttribute
   public UUID characteristicUuid;
   @XmlAttribute
   public UUID refinabilityUuid;
   @XmlAttribute
   public int  relGroup;
   @XmlAttribute
   public UUID typeUuid;

   //~--- constructors --------------------------------------------------------

   public FxRelationship() {
      super();
   }

   public FxRelationship(RelationshipChronicleBI rel) throws IOException {
      super(rel.getPrimordialVersion());

      Collection<? extends RelationshipVersionBI> rels      = rel.getVersions();
      int                                         partCount = rels.size();
      Iterator<? extends RelationshipVersionBI>   relItr    = rels.iterator();
      TerminologyStoreDI                          ts        = Ts.get();
      RelationshipVersionBI                       rv        = relItr.next();

      c1Uuid             = ts.getUuidPrimordialForNid(rv.getConceptNid());
      c2Uuid             = ts.getUuidPrimordialForNid(rv.getDestinationNid());
      characteristicUuid = ts.getUuidPrimordialForNid(rv.getCharacteristicNid());
      refinabilityUuid   = ts.getUuidPrimordialForNid(rv.getRefinabilityNid());
      relGroup           = rv.getGroup();
      typeUuid           = ts.getUuidPrimordialForNid(rv.getTypeNid());
      pathUuid           = ts.getUuidPrimordialForNid(rv.getPathNid());
      statusUuid         = ts.getUuidPrimordialForNid(rv.getStatusNid());
      time               = rv.getTime();

      if (partCount > 1) {
         revisions = new ArrayList<>(partCount - 1);

         while (relItr.hasNext()) {
            rv = relItr.next();
            revisions.add(new FxRelationshipRevision(rv));
         }
      }
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERelationship</tt> object, and contains the same values,
    * field by field, as this <tt>ERelationship</tt>.
    *
    * @param obj the object to compare with.
    * @return <code>true</code> if the objects are the same;
    *         <code>false</code> otherwise.
    */
   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (FxRelationship.class.isAssignableFrom(obj.getClass())) {
         FxRelationship another = (FxRelationship) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare c1Uuid
         if (!this.c1Uuid.equals(another.c1Uuid)) {
            return false;
         }

         // Compare c2Uuid
         if (!this.c2Uuid.equals(another.c2Uuid)) {
            return false;
         }

         // Compare characteristicUuid
         if (!this.characteristicUuid.equals(another.characteristicUuid)) {
            return false;
         }

         // Compare refinabilityUuid
         if (!this.refinabilityUuid.equals(another.refinabilityUuid)) {
            return false;
         }

         // Compare relGroup
         if (this.relGroup != another.relGroup) {
            return false;
         }

         // Compare typeUuid
         if (!this.typeUuid.equals(another.typeUuid)) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   /**
    * Returns a hash code for this <code>ERelationship</code>.
    *
    * @return a hash code value for this <tt>ERelationship</tt>.
    */
   @Override
   public int hashCode() {
      return this.primordialUuid.hashCode();
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName()).append(": ");
      buff.append(" c1: ");
      buff.append(informAboutUuid(this.c1Uuid));
      buff.append(" type:");
      buff.append(informAboutUuid(this.typeUuid));
      buff.append(" c2: ");
      buff.append(informAboutUuid(this.c2Uuid));
      buff.append(" grp:");
      buff.append(this.relGroup);
      buff.append(" char: ");
      buff.append(informAboutUuid(this.characteristicUuid));
      buff.append(" ref: ");
      buff.append(informAboutUuid(this.refinabilityUuid));
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

    //~--- get methods ---------------------------------------------------------

   /*
    *  (non-Javadoc)
    * @see org.ihtsdo.tk.concept.component.relationship.I_RelateExternally#getC1Uuid()
    */
   @Override
   public UUID getC1Uuid() {
      return c1Uuid;
   }

   /*
    *  (non-Javadoc)
    * @see org.ihtsdo.tk.concept.component.relationship.I_RelateExternally#getC2Uuid()
    */
   @Override
   public UUID getC2Uuid() {
      return c2Uuid;
   }

   /*
    *  (non-Javadoc)
    * @see org.ihtsdo.tk.concept.component.relationship.I_RelateExternally#getCharacteristicUuid()
    */
   @Override
   public UUID getCharacteristicUuid() {
      return characteristicUuid;
   }

   /*
    *  (non-Javadoc)
    * @see org.ihtsdo.tk.concept.component.relationship.I_RelateExternally#getRefinabilityUuid()
    */
   @Override
   public UUID getRefinabilityUuid() {
      return refinabilityUuid;
   }

   /*
    *  (non-Javadoc)
    * @see org.ihtsdo.tk.concept.component.relationship.I_RelateExternally#getRelGroup()
    */
   @Override
   public int getRelGroup() {
      return relGroup;
   }

   @Override
   public List<FxRelationshipRevision> getRevisionList() {
      return revisions;
   }

   /*
    *  (non-Javadoc)
    * @see org.ihtsdo.tk.concept.component.relationship.I_RelateExternally#getTypeUuid()
    */
   @Override
   public UUID getTypeUuid() {
      return typeUuid;
   }

   //~--- set methods ---------------------------------------------------------

   public void setC1Uuid(UUID c1Uuid) {
      this.c1Uuid = c1Uuid;
   }

   public void setC2Uuid(UUID c2Uuid) {
      this.c2Uuid = c2Uuid;
   }

   public void setCharacteristicUuid(UUID characteristicUuid) {
      this.characteristicUuid = characteristicUuid;
   }

   public void setRefinabilityUuid(UUID refinabilityUuid) {
      this.refinabilityUuid = refinabilityUuid;
   }

   public void setRelGroup(int relGroup) {
      this.relGroup = relGroup;
   }

   public void setTypeUuid(UUID typeUuid) {
      this.typeUuid = typeUuid;
   }
}
