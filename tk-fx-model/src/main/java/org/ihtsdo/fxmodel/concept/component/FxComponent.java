package org.ihtsdo.fxmodel.concept.component;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.api.ComponentVersionBI;
import org.ihtsdo.tk.api.id.IdBI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.identifier.FxIdentifier;
import org.ihtsdo.fxmodel.concept.component.identifier.FxIdentifierUuid;
import org.ihtsdo.fxmodel.concept.component.refex.FxRefexAbstractMember;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;
import javax.xml.bind.annotation.*;
        
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class FxComponent<V extends FxRevision> extends FxRevision {
   private static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlElementWrapper(name="additional-ids")
   @XmlElement(name="id")
   public List<FxIdentifier>              additionalIds;
   @XmlElementWrapper(name="annotations")
   @XmlElement(name="refex")
   public List<FxRefexAbstractMember<?>> annotations;
   @XmlAttribute
   public UUID                            primordialUuid;
   @XmlElementWrapper(name="revisions")
   @XmlElement(name="revision")
   public List<V>                         revisions;

   //~--- constructors --------------------------------------------------------

   public FxComponent() {
      super();
   }

   public FxComponent(ComponentVersionBI another) throws IOException {
      super(another);

      Collection<? extends IdBI> anotherAdditionalIds = another.getAdditionalIds();

      if (anotherAdditionalIds != null) {
         this.additionalIds = new ArrayList<>(anotherAdditionalIds.size());
         nextId:
         for (IdBI id : anotherAdditionalIds) {
            this.additionalIds.add((FxIdentifier) FxIdentifier.convertId(id));
         }
      }

      Collection<? extends RefexChronicleBI<?>> anotherAnnotations = another.getAnnotations();

      processAnnotations(anotherAnnotations);
      this.primordialUuid = another.getPrimUuid();
   }

   //~--- methods -------------------------------------------------------------


   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>EComponent</tt> object, and contains the same values, field by field,
    * as this <tt>EComponent</tt>.
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

      if (FxComponent.class.isAssignableFrom(obj.getClass())) {
         FxComponent<?> another = (FxComponent<?>) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare primordialComponentUuid
         if (!this.primordialUuid.equals(another.primordialUuid)) {
            return false;
         }

         // Compare additionalIdComponents
         if (this.additionalIds == null) {
            if (another.additionalIds == null) {             // Equal!
            } else if (another.additionalIds.isEmpty()) {    // Equal!
            } else {
               return false;
            }
         } else if (!this.additionalIds.equals(another.additionalIds)) {
            return false;
         }

         // Compare extraVersions
         if (this.revisions == null) {
            if (another.revisions == null) {                 // Equal!
            } else if (another.revisions.isEmpty()) {        // Equal!
            } else {
               return false;
            }
         } else if (!this.revisions.equals(another.revisions)) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   /**
    * Returns a hash code for this <code>EComponent</code>.
    *
    * @return a hash code value for this <tt>EComponent</tt>.
    */
   @Override
   public int hashCode() {
      return Arrays.hashCode(new int[] { getPrimordialComponentUuid().hashCode(), statusUuid.hashCode(),
                                         pathUuid.hashCode(), (int) time, (int) (time >>> 32) });
   }

   private void processAnnotations(Collection<? extends RefexChronicleBI<?>> annotations) throws IOException {
      if ((annotations != null) &&!annotations.isEmpty()) {
         this.annotations = new ArrayList<>(annotations.size());

         for (RefexChronicleBI<?> r : annotations) {
            this.annotations.add(FxConcept.convertRefex(r));
         }
      }
   }
 
   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      int depth = 1;

      if (this instanceof FxRefexAbstractMember) {
         depth = 2;
      }

      StringBuilder buff = new StringBuilder();

      buff.append(" primordial:");
      buff.append(this.primordialUuid);
      buff.append(" xtraIds:");
      buff.append(this.additionalIds);
      buff.append(super.toString());

      if ((annotations != null) && (annotations.size() > 0)) {
         buff.append("\n" + FxConcept.PADDING);

         for (int i = 0; i < depth; i++) {
            buff.append(FxConcept.PADDING);
         }

         buff.append("annotations:\n");

         for (FxRefexAbstractMember m : this.annotations) {
            buff.append(FxConcept.PADDING);
            buff.append(FxConcept.PADDING);

            for (int i = 0; i < depth; i++) {
               buff.append(FxConcept.PADDING);
            }

            buff.append(m);
            buff.append("\n");
         }
      }

      if ((revisions != null) && (revisions.size() > 0)) {
         buff.append("\n" + FxConcept.PADDING + "revisions:\n");

         for (FxRevision r : this.revisions) {
            buff.append(FxConcept.PADDING);
            buff.append(FxConcept.PADDING);

            for (int i = 0; i < depth; i++) {
               buff.append(FxConcept.PADDING);
            }

            buff.append(r);
            buff.append("\n");
         }
      }

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   public List<FxIdentifier> getAdditionalIdComponents() {
      return additionalIds;
   }

   public List<FxRefexAbstractMember<?>> getAnnotations() {
      return annotations;
   }

   public List<FxIdentifier> getEIdentifiers() {
      List<FxIdentifier> ids;

      if (additionalIds != null) {
         ids = new ArrayList<>(additionalIds.size() + 1);
         ids.addAll(additionalIds);
      } else {
         ids = new ArrayList<>(1);
      }

      ids.add(new FxIdentifierUuid(this.primordialUuid));

      return ids;
   }

   public int getIdComponentCount() {
      if (additionalIds == null) {
         return 1;
      }

      return additionalIds.size() + 1;
   }

   public UUID getPrimordialComponentUuid() {
      return primordialUuid;
   }

   public abstract List<? extends FxRevision> getRevisionList();

   public List<V> getRevisions() {
      return revisions;
   }
   public List<UUID> getUuids() {
      List<UUID> uuids = new ArrayList<>();

      uuids.add(primordialUuid);

      if (additionalIds != null) {
         for (FxIdentifier idv : additionalIds) {
            if (FxIdentifierUuid.class.isAssignableFrom(idv.getClass())) {
               uuids.add((UUID) idv.getDenotation());
            }
         }
      }

      return uuids;
   }

   public int getVersionCount() {
      List<? extends FxRevision> extraVersions = getRevisionList();

      if (extraVersions == null) {
         return 1;
      }

      return extraVersions.size() + 1;
   }

   //~--- set methods ---------------------------------------------------------

   public void setAdditionalIdComponents(List<FxIdentifier> additionalIdComponents) {
      this.additionalIds = additionalIdComponents;
   }

   public void setAnnotations(List<FxRefexAbstractMember<?>> annotations) {
      this.annotations = annotations;
   }

   public void setPrimordialComponentUuid(UUID primordialComponentUuid) {
      this.primordialUuid = primordialComponentUuid;
   }

   public void setRevisions(List<V> revisions) {
      this.revisions = revisions;
   }
}
