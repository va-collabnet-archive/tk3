package org.ihtsdo.fxmodel.concept.component;

//~--- non-JDK imports --------------------------------------------------------

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.identifier.FxIdentifier;
import org.ihtsdo.fxmodel.concept.component.identifier.FxIdentifierUuid;
import org.ihtsdo.fxmodel.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.tk.api.ComponentVersionBI;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.id.IdBI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;
import java.io.Serializable;

import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;

public abstract class FxComponentChronicle<V extends FxVersion> implements Serializable {
   private static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlElementWrapper(name = "additionalIdList")
   @XmlElement(name="additionalId")
   public ObservableList<FxIdentifier>        additionalIds =
            FXCollections.observableArrayList(new ArrayList<FxIdentifier>(0));
   @XmlElementWrapper(name = "annotationList")
   @XmlElement(name = "annotation")
   public ObservableList<FxRefexChronicle<?>> annotations=
            FXCollections.observableArrayList(new ArrayList<FxRefexChronicle<?>>(0));
   @XmlTransient
   protected FxConcept                        concept;
   private UUID                                primordialComponentUuid;
   @XmlElementWrapper(name = "versionList")
   @XmlElement()
   public ObservableList<V>                   versions;

   //~--- constructors --------------------------------------------------------

   public FxComponentChronicle() {
      super();
   }

   public FxComponentChronicle(TerminologySnapshotDI ss, FxConcept concept, ComponentVersionBI another)
           throws IOException, ContradictionException {
      super();
      this.concept        = concept;
      this.primordialComponentUuid = another.getPrimUuid();

      Collection<? extends IdBI> anotherAdditionalIds = another.getAdditionalIds();

      if (anotherAdditionalIds != null) {
         this.additionalIds =
            FXCollections.observableArrayList(new ArrayList<FxIdentifier>(anotherAdditionalIds.size()));
         nextId:
         for (IdBI id : anotherAdditionalIds) {
            this.additionalIds.add((FxIdentifier) FxIdentifier.convertId(ss, id));
         }
      }

      Collection<? extends RefexChronicleBI<?>> anotherAnnotations = another.getAnnotations();

      processAnnotations(ss, anotherAnnotations);
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
   public final boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (FxComponentChronicle.class.isAssignableFrom(obj.getClass())) {
         FxComponentChronicle<?> another = (FxComponentChronicle<?>) obj;

         return this.primordialComponentUuid.equals(another.primordialComponentUuid);
      }

      return false;
   }

   /**
    * Returns a hash code for this <code>EComponent</code>.
    *
    * @return a hash code value for this <tt>EComponent</tt>.
    */
   @Override
   public final int hashCode() {
      return this.primordialComponentUuid.hashCode();
   }

   private void processAnnotations(TerminologySnapshotDI ss,
                                   Collection<? extends RefexChronicleBI<?>> annotations)
           throws IOException, ContradictionException {
      if ((annotations != null) &&!annotations.isEmpty()) {
         this.annotations =
            FXCollections.observableArrayList(new ArrayList<FxRefexChronicle<?>>(annotations.size()));

         for (RefexChronicleBI<?> r : annotations) {
            this.annotations.add(FxConcept.convertRefex(ss, concept, r));
         }
      }
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public final String toString() {
      int depth = 1;

      if (this instanceof FxRefexChronicle) {
         depth = 2;
      }

      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName()).append(": ");
      buff.append(" primordial:");
      buff.append(this.primordialComponentUuid);
      buff.append(" xtraIds:");
      buff.append(this.additionalIds);
      buff.append(super.toString());

      if ((annotations != null) && (annotations.size() > 0)) {
         buff.append("\n" + FxConcept.PADDING);

         for (int i = 0; i < depth; i++) {
            buff.append(FxConcept.PADDING);
         }

         buff.append("annotations:\n");

         for (FxRefexChronicle m : this.annotations) {
            buff.append(FxConcept.PADDING);
            buff.append(FxConcept.PADDING);

            for (int i = 0; i < depth; i++) {
               buff.append(FxConcept.PADDING);
            }

            buff.append(m);
            buff.append("\n");
         }
      }

      if ((versions != null) && (versions.size() > 0)) {
         buff.append("\n" + FxConcept.PADDING + "revisions:\n");

         for (FxVersion r : this.versions) {
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

   public List<FxIdentifier> getAdditionalIds() {
      return additionalIds;
   }

   public List<FxRefexChronicle<?>> getAnnotations() {
      return annotations;
   }

   public FxConcept getConcept() {
      return concept;
   }

   public int getIdCount() {
      if (additionalIds == null) {
         return 1;
      }

      return additionalIds.size() + 1;
   }

   public UUID getPrimordialComponentUuid() {
      return primordialComponentUuid;
   }

   public List<UUID> getUuids() {
      List<UUID> uuids = new ArrayList<>();

      uuids.add(primordialComponentUuid);

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
      List<? extends FxVersion> extraVersions = getVersions();

      if (extraVersions == null) {
         return 1;
      }

      return extraVersions.size() + 1;
   }

   public final List<V> getVersions() {
      return versions;
   }

   //~--- set methods ---------------------------------------------------------

   public void setAdditionalIds(ObservableList<FxIdentifier> additionalIds) {
      this.additionalIds = additionalIds;
   }

   public void setAnnotations(ObservableList<FxRefexChronicle<?>> annotations) {
      this.annotations = annotations;
   }

   public void setPrimordialComponentUuid(UUID primordialComponentUuid) {
      this.primordialComponentUuid = primordialComponentUuid;
   }

   public void setVersions(ObservableList<V> versions) {
      this.versions = versions;
   }
}
