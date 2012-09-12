package org.ihtsdo.fxmodel.concept;

import java.beans.Transient;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.ihtsdo.fxmodel.FxComponentReference;
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
import org.ihtsdo.fxmodel.concept.component.relationship.FxRelationshipVersion;
import org.ihtsdo.fxmodel.fetchpolicy.RefexPolicy;
import org.ihtsdo.fxmodel.fetchpolicy.RelationshipPolicy;
import org.ihtsdo.fxmodel.fetchpolicy.VersionPolicy;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.NidSetBI;
import org.ihtsdo.tk.api.RelAssertionType;
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
import org.ihtsdo.tk.api.relationship.RelationshipVersionBI;

/**
 * Property definition pattern from
 * https://wikis.oracle.com/display/OpenJDK/JavaFX+Property+Architecture
 * using "Basic Lazy With Default Value" example.
 * @author kec
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement()
public class FxConcept implements Serializable {
   public static final String PADDING          = "     ";
   public static final long   serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlElementWrapper(name = "descriptionList")
   @XmlElement(name = "description")
   protected ObservableList<FxDescriptionChronicle>                      _descriptions;
   @XmlElementWrapper(name = "destinationRelationshipList")
   @XmlElement(name = "destinationRelationship")
   protected ObservableList<FxRelationshipChronicle>                     _destinationRelationships;
   @XmlElementWrapper(name = "mediaList")
   @XmlElement(name = "media")
   protected ObservableList<FxMediaChronicle>                            _media;
   @XmlElementWrapper(name = "originRelationshipList")
   @XmlElement(name = "originRelationship")
   protected ObservableList<FxRelationshipChronicle>                     _originRelationships;
   @XmlElementWrapper(name = "refsetMemberList")
   @XmlElement(name = "refsetMember")
   protected ObservableList<FxRefexChronicle<?, ?>>                      _refsetMembers;
   @XmlElement()
   protected FxConceptAttributesChronicle                                conceptAttributes;
   @XmlElement()
   protected FxComponentReference                                        conceptReference;
   @XmlTransient
   private SimpleObjectProperty<ObservableList<FxDescriptionChronicle>>  descriptions;
   @XmlTransient
   private SimpleObjectProperty<ObservableList<FxRelationshipChronicle>> destinationRelationships;
   @XmlTransient
   private SimpleObjectProperty<ObservableList<FxMediaChronicle>>        media;
   @XmlTransient
   private SimpleObjectProperty<ObservableList<FxRelationshipChronicle>> originRelationships;
   @XmlElement()
   protected UUID                                                        primordialUuid;
   private RefexPolicy                                                   refexPolicy;
   @XmlTransient
   private SimpleObjectProperty<ObservableList<FxRefexChronicle<?, ?>>>  refsetMembers;
   private RelationshipPolicy                                            relationshipPolicy;
   private VersionPolicy                                                 versionPolicy;

   //~--- constructors --------------------------------------------------------

   public FxConcept() {
      super();
      _originRelationships      =
         FXCollections.observableArrayList(new ArrayList<FxRelationshipChronicle>(1));
      _destinationRelationships =
         FXCollections.observableArrayList(new ArrayList<FxRelationshipChronicle>(1));
      _descriptions  = FXCollections.observableArrayList(new ArrayList<FxDescriptionChronicle>(1));
      _media         = FXCollections.observableArrayList(new ArrayList<FxMediaChronicle>(1));
      _refsetMembers = FXCollections.observableArrayList(new ArrayList<FxRefexChronicle<?, ?>>(0));
   }

   public FxConcept(TerminologySnapshotDI ss, ConceptChronicleBI c, VersionPolicy versionPolicy,
                    RefexPolicy refexPolicy, RelationshipPolicy relationshipPolicy)
           throws IOException, ContradictionException {
      this.versionPolicy      = versionPolicy;
      this.refexPolicy        = refexPolicy;
      this.relationshipPolicy = relationshipPolicy;
      this.conceptReference   = new FxComponentReference(c.getPrimUuid(), c.getNid(),
              ss.getConceptForNid(c.getNid()).getPreferredDescription().getText());
      conceptAttributes = new FxConceptAttributesChronicle(ss, this, c.getConAttrs());
      primordialUuid    = conceptAttributes.getPrimordialComponentUuid();

      switch (relationshipPolicy) {
      case DESTINATION_RELATIONSHIPS :
         _destinationRelationships =
            FXCollections.observableArrayList(new ArrayList<FxRelationshipChronicle>(0));
         addDestinationRelationships(c, ss);

         break;

      case ORIGINATING_RELATIONSHIPS :
         _originRelationships = FXCollections.observableArrayList(new ArrayList<FxRelationshipChronicle>(0));
         addOriginRelationships(c, ss);

         break;

      case ORIGINATING_AND_DESTINATION_RELATIONSHIPS :
         addOriginRelationships(c, ss);
         addDestinationRelationships(c, ss);

         break;

      case ORIGINATING_AND_DESTINATION_TAXONOMY_RELATIONSHIPS :
         addOriginTaxonomyRelationships(c, ss);
         addDestinationTaxonomyRelationships(c, ss);

         break;

      default :
         throw new UnsupportedOperationException("Can't handle: " + relationshipPolicy);
      }

      _descriptions =
         FXCollections.observableArrayList(new ArrayList<FxDescriptionChronicle>(c.getDescs().size()));

      for (DescriptionChronicleBI desc : c.getDescs()) {
         FxDescriptionChronicle dc = new FxDescriptionChronicle(ss, this, desc);

         if (!dc.getVersions().isEmpty()) {
            _descriptions.add(dc);
         }
      }

      _media = FXCollections.observableArrayList(new ArrayList<FxMediaChronicle>(c.getMedia().size()));

      for (MediaChronicleBI mediaChronicle : c.getMedia()) {
         FxMediaChronicle tkMedia = new FxMediaChronicle(ss, this, mediaChronicle);

         if (!tkMedia.getVersions().isEmpty()) {
            _media.add(tkMedia);
         }
      }

      if (((refexPolicy == RefexPolicy.ANNOTATION_MEMBERS_AND_REFSET_MEMBERS)
              || (refexPolicy
                  == RefexPolicy.REFEX_MEMBERS_AND_REFSET_MEMBERS)) &&!c.isAnnotationStyleRefex()) {
         Collection<? extends RefexChronicleBI> members = c.getRefsetMembers();

         if (members != null) {
            _refsetMembers = FXCollections.observableArrayList(new ArrayList<FxRefexChronicle<?,
                    ?>>(members.size()));

            for (RefexChronicleBI m : members) {
               FxRefexChronicle<?, ?> member = convertRefex(ss, m);

               if ((member != null) &&!member.getVersions().isEmpty()) {
                  _refsetMembers.add(member);
               } else {
                  throw new IOException("Could not convert refset member: " + m + "\nfrom refset: " + c);
               }
            }
         }
      }
   }

   //~--- methods -------------------------------------------------------------

   protected final void addDestinationRelationships(ConceptChronicleBI c, TerminologySnapshotDI ss)
           throws ContradictionException, IOException {
      Collection<? extends RelationshipChronicleBI> relsIncoming = c.getRelsIncoming();

      _destinationRelationships =
         FXCollections.observableArrayList(new ArrayList<FxRelationshipChronicle>(relsIncoming.size()));

      for (RelationshipChronicleBI rel : relsIncoming) {
         FxRelationshipChronicle fxc = new FxRelationshipChronicle(ss, this, rel);

         if (!fxc.getVersions().isEmpty()) {
            _destinationRelationships.add(fxc);
         }
      }
   }

   protected final void addDestinationTaxonomyRelationships(ConceptChronicleBI c, TerminologySnapshotDI ss)
           throws ContradictionException, IOException {
      Collection<? extends RelationshipChronicleBI> relsIncoming = c.getRelsIncoming();

      _destinationRelationships =
         FXCollections.observableArrayList(new ArrayList<FxRelationshipChronicle>(relsIncoming.size()));

      NidSetBI taxonomyTypes = ss.getViewCoordinate().getIsaTypeNids();

      NEXT_REL:
      for (RelationshipChronicleBI rel : relsIncoming) {
         RelationshipVersionBI relVersion = rel.getPrimordialVersion();

         switch (ss.getViewCoordinate().getRelationshipAssertionType()) {
         case INFERRED :
            if (!relVersion.isInferred()) {
               continue NEXT_REL;
            }

            break;

         case STATED :
            if (!relVersion.isStated()) {
               continue NEXT_REL;
            }

            break;

         case INFERRED_THEN_STATED :
            if (!relVersion.isInferred()) {
               continue NEXT_REL;
            }

            break;
         }

         boolean foundType = false;

         for (RelationshipVersionBI rv : rel.getVersions(ss.getViewCoordinate())) {
            if (taxonomyTypes.contains(rv.getTypeNid())) {
               foundType = true;

               break;
            }
         }

         if (!foundType) {
            continue NEXT_REL;
         }

         FxRelationshipChronicle fxc = new FxRelationshipChronicle(ss, this, rel);

         _destinationRelationships.add(fxc);
      }

      if (_destinationRelationships.isEmpty()
              && (ss.getViewCoordinate().getRelationshipAssertionType() == RelAssertionType.INFERRED_THEN_STATED)) {
         for (RelationshipChronicleBI rel : relsIncoming) {
            RelationshipVersionBI relVersion = rel.getPrimordialVersion();

            if (relVersion.isStated()) {
               boolean foundType = false;

               for (RelationshipVersionBI rv : rel.getVersions(ss.getViewCoordinate())) {
                  if (!taxonomyTypes.contains(rv.getTypeNid())) {
                     foundType = true;

                     break;
                  }
               }

               if (foundType) {
                  FxRelationshipChronicle fxc = new FxRelationshipChronicle(ss, this, rel);

                  _destinationRelationships.add(fxc);
               }
            }
         }
      }
   }

   protected final void addOriginRelationships(ConceptChronicleBI c, TerminologySnapshotDI ss)
           throws ContradictionException, IOException {
      _originRelationships = FXCollections.observableArrayList(
         new ArrayList<FxRelationshipChronicle>(c.getRelsOutgoing().size()));

      for (RelationshipChronicleBI rel : c.getRelsOutgoing()) {
         FxRelationshipChronicle fxc = new FxRelationshipChronicle(ss, this, rel);

         if (!fxc.getVersions().isEmpty()) {
            _originRelationships.add(fxc);
         }
      }
   }

   protected final void addOriginTaxonomyRelationships(ConceptChronicleBI c, TerminologySnapshotDI ss)
           throws ContradictionException, IOException {
      _originRelationships = FXCollections.observableArrayList(
         new ArrayList<FxRelationshipChronicle>(c.getRelsOutgoing().size()));

      NidSetBI taxonomyTypes = ss.getViewCoordinate().getIsaTypeNids();

      for (RelationshipChronicleBI rel : c.getRelsOutgoing()) {
         FxRelationshipChronicle          fxc      = new FxRelationshipChronicle(ss, this, rel);
         ArrayList<FxRelationshipVersion> toRemove = new ArrayList<>();

         for (FxRelationshipVersion fxv : fxc.getVersions()) {
            if (!taxonomyTypes.contains(fxv.getTypeReference().getNid())) {
               toRemove.add(fxv);

               break;
            }

            switch (ss.getViewCoordinate().getRelationshipAssertionType()) {
            case INFERRED :
               if (!(fxv.getAuthorReference().getNid() == ss.getViewCoordinate().getClassifierNid())) {
                  toRemove.add(fxv);
               }

               break;

            case STATED :
               if (fxv.getAuthorReference().getNid() == ss.getViewCoordinate().getClassifierNid()) {
                  toRemove.add(fxv);
               }

               break;
            }
         }

         fxc.getVersions().removeAll(toRemove);

         if (!fxc.getVersions().isEmpty()) {
            _originRelationships.add(fxc);
         }
      }
   }

   private FxRefexChronicle<?, ?> convertRefex(TerminologySnapshotDI ss, RefexChronicleBI<?> m)
           throws IOException, ContradictionException {
      return convertRefex(ss, this, m);
   }

   public static FxRefexChronicle<?, ?> convertRefex(TerminologySnapshotDI ss, FxConcept concept,
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

   public ObjectProperty<ObservableList<FxDescriptionChronicle>> descriptions() {
      if (descriptions == null) {
         descriptions = new SimpleObjectProperty<>(_descriptions);
      }

      return descriptions;
   }

   public SimpleObjectProperty<ObservableList<FxRelationshipChronicle>> destinationRelationships() {
      if (destinationRelationships == null) {
         destinationRelationships = new SimpleObjectProperty<>(_destinationRelationships);
      }

      return destinationRelationships;
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
         if (this._descriptions == null) {
            if (another._descriptions == null) {                    // Equal!
            } else if (another._descriptions.isEmpty()) {           // Equal!
            } else {
               return false;
            }
         } else if (!this._descriptions.equals(another._descriptions)) {
            return false;
         }

         // Compare Relationships
         if (this._originRelationships == null) {
            if (another._originRelationships == null) {             // Equal!
            } else if (another._originRelationships.isEmpty()) {    // Equal!
            } else {
               return false;
            }
         } else if (!this._originRelationships.equals(another._originRelationships)) {
            return false;
         }

         // Compare Images
         if (this._media == null) {
            if (another._media == null) {                           // Equal!
            } else if (another._media.isEmpty()) {                  // Equal!
            } else {
               return false;
            }
         } else if (!this._media.equals(another._media)) {
            return false;
         }

         // Compare Refset Members
         if (this._refsetMembers == null) {
            if (another._refsetMembers == null) {                   // Equal!
            } else if (another._refsetMembers.isEmpty()) {          // Equal!
            } else {
               return false;
            }
         } else if (!this._refsetMembers.equals(another._refsetMembers)) {
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

   public ObjectProperty<ObservableList<FxMediaChronicle>> media() {
      if (media == null) {
         media = new SimpleObjectProperty<>(_media);
      }

      return media;
   }

   public SimpleObjectProperty<ObservableList<FxRelationshipChronicle>> originRelationships() {
      if (originRelationships == null) {
         originRelationships = new SimpleObjectProperty<>(_originRelationships);
      }

      return originRelationships;
   }

   public ObjectProperty<ObservableList<FxRefexChronicle<?, ?>>> refsetMembers() {
      if (refsetMembers == null) {
         refsetMembers = new SimpleObjectProperty<>(_refsetMembers);
      }

      return refsetMembers;
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      return this.conceptReference.getText();
   }

   //~--- get methods ---------------------------------------------------------

   public FxConceptAttributesChronicle getConceptAttributes() {
      return conceptAttributes;
   }

   public FxComponentReference getConceptReference() {
      return conceptReference;
   }

   public ObservableList<FxDescriptionChronicle> getDescriptions() {
      return _descriptions;
   }

   public ObservableList<FxRelationshipChronicle> getDestinationRelationships() {
      return _destinationRelationships;
   }

   public ObservableList<FxMediaChronicle> getMedia() {
      return _media;
   }

   public ObservableList<FxRelationshipChronicle> getOriginRelationships() {
      return _originRelationships;
   }

   public UUID getPrimordialUuid() {
      return primordialUuid;
   }

   public RefexPolicy getRefexPolicy() {
      return refexPolicy;
   }

   public ObservableList<FxRefexChronicle<?, ?>> getRefsetMembers() {
      return _refsetMembers;
   }

   public RelationshipPolicy getRelationshipPolicy() {
      return relationshipPolicy;
   }

   public VersionPolicy getVersionPolicy() {
      return versionPolicy;
   }

   //~--- set methods ---------------------------------------------------------

   public void setConceptAttributes(FxConceptAttributesChronicle conceptAttributes) {
      this.conceptAttributes = conceptAttributes;
   }

   public void setConceptReference(FxComponentReference conceptReference) {
      this.conceptReference = conceptReference;
   }

   public void setDescriptions(List<FxDescriptionChronicle> descriptions) {
      this._descriptions = FXCollections.observableArrayList(descriptions);
   }

   public void setDestinationRelationships(ObservableList<FxRelationshipChronicle> destinationRelationships) {
      this._destinationRelationships = destinationRelationships;
   }

   public void setImages(List<FxMediaChronicle> images) {
      this._media = FXCollections.observableArrayList(images);
   }

   public void setMedia(ObservableList<FxMediaChronicle> media) {
      this._media = media;
   }

   public void setOriginRelationships(List<FxRelationshipChronicle> relationships) {
      this._originRelationships = FXCollections.observableArrayList(relationships);
   }

   public void setPrimordialUuid(UUID primordialUuid) {
      this.primordialUuid = primordialUuid;
   }

   public void setRefexPolicy(RefexPolicy refexPolicy) {
      this.refexPolicy = refexPolicy;
   }

   public void setRefsetMembers(List<FxRefexChronicle<?, ?>> refsetMembers) {
      this._refsetMembers = FXCollections.observableArrayList(refsetMembers);
   }

   public void setRelationshipPolicy(RelationshipPolicy relationshipPolicy) {
      this.relationshipPolicy = relationshipPolicy;
   }

   public void setVersionPolicy(VersionPolicy versionPolicy) {
      this.versionPolicy = versionPolicy;
   }
}
