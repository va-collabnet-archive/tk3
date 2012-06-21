package org.ihtsdo.fxmodel.concept;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.fxmodel.fetchpolicy.VersionPolicy;
import org.ihtsdo.fxmodel.fetchpolicy.RelationshipPolicy;
import org.ihtsdo.fxmodel.fetchpolicy.RefexPolicy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.ihtsdo.fxmodel.concept.component.FxVersion;
import org.ihtsdo.fxmodel.concept.component.attribute.FxConceptAttributesChronicle;
import org.ihtsdo.fxmodel.concept.component.description.FxDescriptionChronicle;
import org.ihtsdo.fxmodel.concept.component.media.FxMediaChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_boolean.FxRefexBooleanChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_comp.FxRefexCompChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_comp_comp.FxRefexCompCompChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_comp_comp_comp.FxRefexCompCompCompChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_comp_comp_string.FxRefexCompCompStringChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_comp_float.FxRefexCompFloatChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_comp_int.FxRefexCompIntChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_comp_long.FxRefexCompLongChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_comp_string.FxRefexCompStringChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_int.FxRefexIntChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_long.FxRefexLongChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_member.FxRefexMembershipChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_string.FxRefexStringChronicle;
import org.ihtsdo.fxmodel.concept.component.relationship.FxRelationshipChronicle;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.description.DescriptionChronicleBI;
import org.ihtsdo.tk.api.media.MediaChronicleBI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.type_boolean.RefexBooleanVersionBI;
import org.ihtsdo.tk.api.refex.type_int.RefexIntVersionBI;
import org.ihtsdo.tk.api.refex.type_long.RefexLongVersionBI;
import org.ihtsdo.tk.api.refex.type_member.RefexMemberVersionBI;
import org.ihtsdo.tk.api.refex.type_nid.RefexNidVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_float.RefexNidFloatVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_int.RefexNidIntVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_long.RefexNidLongVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_nid.RefexNidNidVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_nid_nid.RefexNidNidNidVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_nid_string.RefexNidNidStringVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_string.RefexNidStringVersionBI;
import org.ihtsdo.tk.api.refex.type_string.RefexStringVersionBI;
import org.ihtsdo.tk.api.relationship.RelationshipChronicleBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;
import java.io.Serializable;

import java.util.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement; 

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement()
public class FxConcept implements Serializable {
   public static final String PADDING          = "     ";
   public static final long   serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlElement()
   protected FxConceptAttributesChronicle            conceptAttributes;
   @XmlElementWrapper(name = "descriptionList")
   @XmlElement(name = "description")
   protected ObservableList<FxDescriptionChronicle>  descriptions;
   @XmlElementWrapper(name = "destinationRelationshipList")
   @XmlElement(name = "destinationRelationship")
   protected ObservableList<FxRelationshipChronicle> destinationRelationships;
   @XmlElementWrapper(name = "mediaList")
   @XmlElement(name = "media")
   protected ObservableList<FxMediaChronicle>        media;
   @XmlElementWrapper(name = "originRelationshipList")
   @XmlElement(name = "originRelationship")
   protected ObservableList<FxRelationshipChronicle> originRelationships;
   @XmlElement()
   protected UUID                                    primordialUuid;
   private EnumSet<RefexPolicy>                      refexPolicy;
   @XmlElementWrapper(name = "refsetMemberList")
   @XmlElement(name = "refsetMember")
   protected ObservableList<FxRefexChronicle<?,?>>     refsetMembers;
   private EnumSet<RelationshipPolicy>               relationshipPolicy;
   private EnumSet<VersionPolicy>                    versionPolicy;

   //~--- constructors --------------------------------------------------------

   public FxConcept() {
      super();
      originRelationships      = FXCollections.observableArrayList(new ArrayList<FxRelationshipChronicle>(1));
      destinationRelationships = FXCollections.observableArrayList(new ArrayList<FxRelationshipChronicle>(1));
      descriptions             = FXCollections.observableArrayList(new ArrayList<FxDescriptionChronicle>(1));
      media                    = FXCollections.observableArrayList(new ArrayList<FxMediaChronicle>(1));
      refsetMembers            = FXCollections.observableArrayList(new ArrayList<FxRefexChronicle<?,?>>(0));
   }

   public FxConcept(TerminologySnapshotDI ss, ConceptChronicleBI c, EnumSet<VersionPolicy> versionPolicy,
                    EnumSet<RefexPolicy> refexPolicy, EnumSet<RelationshipPolicy> relationshipPolicy)
           throws IOException, ContradictionException {
      this.versionPolicy      = versionPolicy;
      this.refexPolicy        = refexPolicy;
      this.relationshipPolicy = relationshipPolicy;
      conceptAttributes       = new FxConceptAttributesChronicle(ss, this, c.getConAttrs());
      primordialUuid          = conceptAttributes.getPrimordialComponentUuid();
      originRelationships     = FXCollections.observableArrayList(
         new ArrayList<FxRelationshipChronicle>(c.getRelsOutgoing().size()));

      for (RelationshipChronicleBI rel : c.getRelsOutgoing()) {
         originRelationships.add(new FxRelationshipChronicle(ss, this, rel));
      }

      descriptions =
         FXCollections.observableArrayList(new ArrayList<FxDescriptionChronicle>(c.getDescs().size()));

      for (DescriptionChronicleBI desc : c.getDescs()) {
         descriptions.add(new FxDescriptionChronicle(ss, this, desc));
      }

      media = FXCollections.observableArrayList(new ArrayList<FxMediaChronicle>(c.getMedia().size()));

      for (MediaChronicleBI mediaChronicle : c.getMedia()) {
         FxMediaChronicle tkMedia = new FxMediaChronicle(ss, this, mediaChronicle);

         media.add(tkMedia);
      }

      if (refexPolicy.contains(RefexPolicy.REFSET_MEMBERS_WITH_REFSET_CONCEPT)
              &&!c.isAnnotationStyleRefex()) {
         Collection<? extends RefexChronicleBI> members = c.getRefsetMembers();

         if (members != null) {
            refsetMembers =
               FXCollections.observableArrayList(new ArrayList<FxRefexChronicle<?,?>>(members.size()));

            for (RefexChronicleBI m : members) {
               FxRefexChronicle<?,?> member = convertRefex(ss, m);

               if (member != null) {
                  refsetMembers.add(member);
               } else {
                  throw new IOException("Could not convert refset member: " + m + "\nfrom refset: " + c);
               }
            }
         }
      }
   }

   //~--- methods -------------------------------------------------------------

   private FxRefexChronicle<?,?> convertRefex(TerminologySnapshotDI ss, RefexChronicleBI<?> m)
           throws IOException, ContradictionException {
      return convertRefex(ss, this, m);
   }

   public static FxRefexChronicle<?,?> convertRefex(TerminologySnapshotDI ss, FxConcept concept,
           RefexChronicleBI<?> m)
           throws IOException, ContradictionException {
      if (m.getPrimordialVersion() instanceof RefexNidNidNidVersionBI) {
         return new FxRefexCompCompCompChronicle(ss, concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexNidNidStringVersionBI) {
         return new FxRefexCompCompStringChronicle(ss, concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexNidNidVersionBI) {
         return new FxRefexCompCompChronicle(ss, concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexNidFloatVersionBI) {
         return new FxRefexCompFloatChronicle(ss, concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexNidIntVersionBI) {
         return new FxRefexCompIntChronicle(ss, concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexNidLongVersionBI) {
         return new FxRefexCompLongChronicle(ss, concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexNidStringVersionBI) {
         return new FxRefexCompStringChronicle(ss, concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexNidVersionBI) {
         return new FxRefexCompChronicle(ss, concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexIntVersionBI) {
         return new FxRefexIntChronicle(ss, concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexStringVersionBI) {
         return new FxRefexStringChronicle(ss, concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexLongVersionBI) {
         return new FxRefexLongChronicle(ss, concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexBooleanVersionBI) {
         return new FxRefexBooleanChronicle(ss, concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexMemberVersionBI) {
         return new FxRefexMembershipChronicle(ss, concept, m);
      } else {
         throw new UnsupportedOperationException("Cannot handle: " + m);
      }
   }

   /**
    * Compares this object to the specified object. The result is <tt>true</tt> if and only if the argument
    * is not <tt>null</tt>, is a <tt>EConcept</tt> object, and contains the same values, field by field, as
    * this <tt>EConcept</tt>.
    *
    * @param obj the object to compare with.
    * @return
    * <code>true</code> if the objects are the same;
    * <code>false</code> otherwise.
    */
   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (FxConcept.class.isAssignableFrom(obj.getClass())) {
         FxConcept another = (FxConcept) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare ConceptAttributes
         if (this.conceptAttributes == null) {
            if (this.conceptAttributes != another.conceptAttributes) {
               return false;
            }
         } else if (!this.conceptAttributes.equals(another.conceptAttributes)) {
            return false;
         }

         // Compare Descriptions
         if (this.descriptions == null) {
            if (another.descriptions == null) {                    // Equal!
            } else if (another.descriptions.isEmpty()) {           // Equal!
            } else {
               return false;
            }
         } else if (!this.descriptions.equals(another.descriptions)) {
            return false;
         }

         // Compare Relationships
         if (this.originRelationships == null) {
            if (another.originRelationships == null) {             // Equal!
            } else if (another.originRelationships.isEmpty()) {    // Equal!
            } else {
               return false;
            }
         } else if (!this.originRelationships.equals(another.originRelationships)) {
            return false;
         }

         // Compare Images
         if (this.media == null) {
            if (another.media == null) {                           // Equal!
            } else if (another.media.isEmpty()) {                  // Equal!
            } else {
               return false;
            }
         } else if (!this.media.equals(another.media)) {
            return false;
         }

         // Compare Refset Members
         if (this.refsetMembers == null) {
            if (another.refsetMembers == null) {                   // Equal!
            } else if (another.refsetMembers.isEmpty()) {          // Equal!
            } else {
               return false;
            }
         } else if (!this.refsetMembers.equals(another.refsetMembers)) {
            return false;
         }

         // If none of the previous comparisons fail, the objects must be equal
         return true;
      }

      return false;
   }

   /**
    * Returns a hash code for this
    * <code>EConcept</code>.
    *
    * @return a hash code value for this <tt>EConcept</tt>.
    */
   @Override
   public int hashCode() {
      return this.conceptAttributes.getPrimordialComponentUuid().hashCode();
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName());
      buff.append(": \n   primordial UUID: ");
      buff.append(FxVersion.informAboutUuid(this.primordialUuid));
      buff.append("\n   ConceptAttributes: \n");
      buff.append(PADDING);

      if (this.conceptAttributes == null) {
         buff.append(PADDING + "none\n");
      } else {
         buff.append(this.conceptAttributes);
         buff.append("\n");
      }

      buff.append("\n   Descriptions: \n");

      if (this.descriptions == null) {
         buff.append(PADDING + "none\n");
      } else {
         for (FxDescriptionChronicle d : this.descriptions) {
            buff.append(PADDING);
            buff.append(d);
            buff.append("\n");
         }
      }

      buff.append("\n   Relationships: \n");

      if (this.originRelationships == null) {
         buff.append(PADDING + "none\n");
      } else {
         for (FxRelationshipChronicle r : this.originRelationships) {
            buff.append(PADDING);
            buff.append(r);
            buff.append("\n");
         }
      }

      buff.append("\n   RefsetMembers: \n");

      if (this.refsetMembers == null) {
         buff.append(PADDING + "none\n");
      } else {
         for (FxRefexChronicle<?,?> r : this.refsetMembers) {
            buff.append(PADDING);
            buff.append(r);
            buff.append("\n");
         }
      }

      buff.append("\n   Media: \n");

      if (this.media == null) {
         buff.append(PADDING + "none");
      } else {
         for (FxMediaChronicle m : this.media) {
            buff.append(PADDING);
            buff.append(m);
            buff.append("\n");
         }
      }

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   public FxConceptAttributesChronicle getConceptAttributes() {
      return conceptAttributes;
   }

   public ObservableList<FxDescriptionChronicle> getDescriptions() {
      return descriptions;
   }

   public ObservableList<FxRelationshipChronicle> getDestinationRelationships() {
      return destinationRelationships;
   }

   public ObservableList<FxMediaChronicle> getImages() {
      return media;
   }

   public ObservableList<FxMediaChronicle> getMedia() {
      return media;
   }

   public ObservableList<FxRelationshipChronicle> getOriginRelationships() {
      return originRelationships;
   }

   public UUID getPrimordialUuid() {
      return primordialUuid;
   }

   public EnumSet<RefexPolicy> getRefexPolicy() {
      return refexPolicy;
   }

   public ObservableList<FxRefexChronicle<?,?>> getRefsetMembers() {
      return refsetMembers;
   }

   public EnumSet<RelationshipPolicy> getRelationshipPolicy() {
      return relationshipPolicy;
   }

   public EnumSet<VersionPolicy> getVersionPolicy() {
      return versionPolicy;
   }

   //~--- set methods ---------------------------------------------------------

   public void setConceptAttributes(FxConceptAttributesChronicle conceptAttributes) {
      this.conceptAttributes = conceptAttributes;
   }

   public void setDescriptions(List<FxDescriptionChronicle> descriptions) {
      this.descriptions = FXCollections.observableArrayList(descriptions);
   }

   public void setDestinationRelationships(ObservableList<FxRelationshipChronicle> destinationRelationships) {
      this.destinationRelationships = destinationRelationships;
   }

   public void setImages(List<FxMediaChronicle> images) {
      this.media = FXCollections.observableArrayList(images);
   }

   public void setMedia(ObservableList<FxMediaChronicle> media) {
      this.media = media;
   }

   public void setOriginRelationships(List<FxRelationshipChronicle> relationships) {
      this.originRelationships = FXCollections.observableArrayList(relationships);
   }

   public void setPrimordialUuid(UUID primordialUuid) {
      this.primordialUuid = primordialUuid;
   }

   public void setRefexPolicy(EnumSet<RefexPolicy> refexPolicy) {
      this.refexPolicy = refexPolicy;
   }

   public void setRefsetMembers(List<FxRefexChronicle<?,?>> refsetMembers) {
      this.refsetMembers = FXCollections.observableArrayList(refsetMembers);
   }

   public void setRelationshipPolicy(EnumSet<RelationshipPolicy> relationshipPolicy) {
      this.relationshipPolicy = relationshipPolicy;
   }

   public void setVersionPolicy(EnumSet<VersionPolicy> versionPolicy) {
      this.versionPolicy = versionPolicy;
   }
}
