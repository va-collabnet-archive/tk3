package org.ihtsdo.ttk.fx.concept.component.relationship;

//~--- non-JDK imports --------------------------------------------------------

import javafx.beans.property.SimpleObjectProperty;

import org.ihtsdo.ttk.fx.FxComponentReference;
import org.ihtsdo.ttk.fx.concept.FxConcept;
import org.ihtsdo.ttk.fx.concept.component.FxComponentChronicle;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologySnapshotDI;
import org.ihtsdo.ttk.api.relationship.RelationshipChronicleBI;
import org.ihtsdo.ttk.api.relationship.RelationshipVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class FxRelationshipChronicle
        extends FxComponentChronicle<FxRelationshipVersion, RelationshipVersionBI> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   protected SimpleObjectProperty<FxComponentReference> destinationReferenceProperty =
      new SimpleObjectProperty<>(this, "destination");
   protected SimpleObjectProperty<FxComponentReference> originReferenceProperty =
      new SimpleObjectProperty<>(this, "origin");

   //~--- constructors --------------------------------------------------------

   public FxRelationshipChronicle() {
      super();
   }

   public FxRelationshipChronicle(TerminologySnapshotDI ss, FxConcept concept,
                                  RelationshipChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, another.getPrimordialVersion());
      this.originReferenceProperty.set(
          new FxComponentReference(ss.getConceptVersion(another.getOriginNid())));
      this.destinationReferenceProperty.set(
          new FxComponentReference(ss.getConceptVersion(another.getDestinationNid())));
   }

   //~--- methods -------------------------------------------------------------

   public SimpleObjectProperty<FxComponentReference> destinationReferenceProperty() {
      return destinationReferenceProperty;
   }

   @Override
   protected FxRelationshipVersion makeVersion(TerminologySnapshotDI ss, RelationshipVersionBI version)
           throws IOException, ContradictionException {
      return new FxRelationshipVersion(this, ss, version);
   }

   public SimpleObjectProperty<FxComponentReference> originReferenceProperty() {
      return originReferenceProperty;
   }

   //~--- get methods ---------------------------------------------------------

   public FxComponentReference getDestinationReference() {
      return destinationReferenceProperty.get();
   }

   public FxComponentReference getOriginReference() {
      return originReferenceProperty.get();
   }

   //~--- set methods ---------------------------------------------------------

   public void setDestinationReference(FxComponentReference destinationReference) {
      this.destinationReferenceProperty.set(destinationReference);
   }

   public void setOriginReference(FxComponentReference originReference) {
      this.originReferenceProperty.set(originReference);
   }
}
