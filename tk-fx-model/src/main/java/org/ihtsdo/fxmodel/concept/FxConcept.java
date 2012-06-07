package org.ihtsdo.fxmodel.concept;

//~--- non-JDK imports --------------------------------------------------------

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.ihtsdo.fxmodel.concept.component.FxVersion;
import org.ihtsdo.fxmodel.concept.component.attribute.FxConceptAttributesChronicle;
import org.ihtsdo.fxmodel.concept.component.description.FxDescriptionChronicle;
import org.ihtsdo.fxmodel.concept.component.media.FxMediaChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_boolean.FxRefexBooleanChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_int.FxRefexIntChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_long.FxRefexLongChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_member.FxRefexMembershipChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_string.FxRefexStringChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_uuid.FxRefexUuidChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_uuid_float.FxRefexUuidFloatChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_uuid_int.FxRefexUuidIntMember;
import org.ihtsdo.fxmodel.concept.component.refex.type_uuid_long.FxRefexUuidLongChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_uuid_string.FxRefexUuidStringChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_uuid_uuid.FxRefexUuidUuidChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_uuid_uuid_string.FxRefexUuidUuidStringChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_uuid_uuid_uuid.FxRefexUuidUuidUuidChronicle;
import org.ihtsdo.fxmodel.concept.component.relationship.FxRelationshipChronicle;
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

import java.util.*;

public class FxConcept {
   public static final String PADDING          = "     ";
   public static final int    dataVersion      = 7;
   public static final long   serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   protected boolean                                 annotationStyleRefex = false;
   protected FxConceptAttributesChronicle            conceptAttributes;
   protected ObservableList<FxDescriptionChronicle>  descriptions;
   protected ObservableList<FxMediaChronicle>        media;
   protected UUID                                    primordialUuid;
   protected ObservableList<FxRefexChronicle<?>>     refsetMembers;
   protected ObservableList<FxRelationshipChronicle> relationships;

   //~--- constructors --------------------------------------------------------

   public FxConcept() {
      super();
   }

   public FxConcept(ConceptChronicleBI c) throws IOException {
      conceptAttributes = new FxConceptAttributesChronicle(this, c.getConAttrs());
      primordialUuid    = conceptAttributes.primordialUuid;
      relationships     = FXCollections.observableArrayList(
         new ArrayList<FxRelationshipChronicle>(c.getRelsOutgoing().size()));

      for (RelationshipChronicleBI rel : c.getRelsOutgoing()) {
         relationships.add(new FxRelationshipChronicle(this, rel));
      }

      descriptions =
         FXCollections.observableArrayList(new ArrayList<FxDescriptionChronicle>(c.getDescs().size()));

      for (DescriptionChronicleBI desc : c.getDescs()) {
         descriptions.add(new FxDescriptionChronicle(this, desc));
      }

      media = FXCollections.observableArrayList(new ArrayList<FxMediaChronicle>(c.getMedia().size()));

      for (MediaChronicleBI mediaChronicle : c.getMedia()) {
         FxMediaChronicle tkMedia = new FxMediaChronicle(this, mediaChronicle);

         media.add(tkMedia);
      }

      if (!c.isAnnotationStyleRefex()) {
         Collection<? extends RefexChronicleBI> members = c.getRefsetMembers();

         if (members != null) {
            refsetMembers =
               FXCollections.observableArrayList(new ArrayList<FxRefexChronicle<?>>(members.size()));

            for (RefexChronicleBI m : members) {
               FxRefexChronicle<?> member = convertRefex(m);

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

   private FxRefexChronicle<?> convertRefex(RefexChronicleBI<?> m) throws IOException {
      return convertRefex(this, m);
   }

   public static FxRefexChronicle<?> convertRefex(FxConcept concept, RefexChronicleBI<?> m)
           throws IOException {
      if (m.getPrimordialVersion() instanceof RefexNidNidNidVersionBI) {
         return new FxRefexUuidUuidUuidChronicle(concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexNidNidStringVersionBI) {
         return new FxRefexUuidUuidStringChronicle(concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexNidNidVersionBI) {
         return new FxRefexUuidUuidChronicle(concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexNidFloatVersionBI) {
         return new FxRefexUuidFloatChronicle(concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexNidIntVersionBI) {
         return new FxRefexUuidIntMember(concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexNidLongVersionBI) {
         return new FxRefexUuidLongChronicle(concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexNidStringVersionBI) {
         return new FxRefexUuidStringChronicle(concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexNidVersionBI) {
         return new FxRefexUuidChronicle(concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexIntVersionBI) {
         return new FxRefexIntChronicle(concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexStringVersionBI) {
         return new FxRefexStringChronicle(concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexLongVersionBI) {
         return new FxRefexLongChronicle(concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexBooleanVersionBI) {
         return new FxRefexBooleanChronicle(concept, m);
      } else if (m.getPrimordialVersion() instanceof RefexMemberVersionBI) {
         return new FxRefexMembershipChronicle(concept, m);
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
            if (another.descriptions == null) {              // Equal!
            } else if (another.descriptions.isEmpty()) {     // Equal!
            } else {
               return false;
            }
         } else if (!this.descriptions.equals(another.descriptions)) {
            return false;
         }

         // Compare Relationships
         if (this.relationships == null) {
            if (another.relationships == null) {             // Equal!
            } else if (another.relationships.isEmpty()) {    // Equal!
            } else {
               return false;
            }
         } else if (!this.relationships.equals(another.relationships)) {
            return false;
         }

         // Compare Images
         if (this.media == null) {
            if (another.media == null) {                     // Equal!
            } else if (another.media.isEmpty()) {            // Equal!
            } else {
               return false;
            }
         } else if (!this.media.equals(another.media)) {
            return false;
         }

         // Compare Refset Members
         if (this.refsetMembers == null) {
            if (another.refsetMembers == null) {             // Equal!
            } else if (another.refsetMembers.isEmpty()) {    // Equal!
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

      if (this.relationships == null) {
         buff.append(PADDING + "none\n");
      } else {
         for (FxRelationshipChronicle r : this.relationships) {
            buff.append(PADDING);
            buff.append(r);
            buff.append("\n");
         }
      }

      buff.append("\n   RefsetMembers: \n");

      if (this.refsetMembers == null) {
         buff.append(PADDING + "none\n");
      } else {
         for (FxRefexChronicle<?> r : this.refsetMembers) {
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

   public ObservableList<FxMediaChronicle> getImages() {
      return media;
   }

   public UUID getPrimordialUuid() {
      return primordialUuid;
   }

   public ObservableList<FxRefexChronicle<?>> getRefsetMembers() {
      return refsetMembers;
   }

   public ObservableList<FxRelationshipChronicle> getRelationships() {
      return relationships;
   }

   public boolean isAnnotationStyleRefex() {
      return annotationStyleRefex;
   }

   //~--- set methods ---------------------------------------------------------

   public void setAnnotationStyleRefex(boolean annotationStyleRefex) {
      this.annotationStyleRefex = annotationStyleRefex;
   }

   public void setConceptAttributes(FxConceptAttributesChronicle conceptAttributes) {
      this.conceptAttributes = conceptAttributes;
   }

   public void setDescriptions(List<FxDescriptionChronicle> descriptions) {
      this.descriptions = FXCollections.observableArrayList(descriptions);
   }

   public void setImages(List<FxMediaChronicle> images) {
      this.media = FXCollections.observableArrayList(images);
   }

   public void setPrimordialUuid(UUID primordialUuid) {
      this.primordialUuid = primordialUuid;
   }

   public void setRefsetMembers(List<FxRefexChronicle<?>> refsetMembers) {
      this.refsetMembers = FXCollections.observableArrayList(refsetMembers);
   }

   public void setRelationships(List<FxRelationshipChronicle> relationships) {
      this.relationships = FXCollections.observableArrayList(relationships);
   }
}
