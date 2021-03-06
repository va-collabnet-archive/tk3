package org.ihtsdo.fxmodel.concept.component.relationship;

//~--- non-JDK imports --------------------------------------------------------

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import org.ihtsdo.fxmodel.FxComponentReference;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.relationship.RelationshipVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;
import org.ihtsdo.fxmodel.concept.component.FxTypedComponentVersion;

public class FxRelationshipVersion
        extends FxTypedComponentVersion<FxRelationshipChronicle, FxRelationshipVersion> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   protected SimpleIntegerProperty                      groupProperty                   = new SimpleIntegerProperty(this, "group");
   protected SimpleObjectProperty<FxComponentReference> characteristicReferenceProperty =
      new SimpleObjectProperty<>(this, "characteristic");
   protected SimpleObjectProperty<FxComponentReference> refinabilityReferenceProperty =
      new SimpleObjectProperty<>(this, "refinability");

   //~--- constructors --------------------------------------------------------

   public FxRelationshipVersion() {
      super();
   }

   public FxRelationshipVersion(FxRelationshipChronicle chronicle, TerminologySnapshotDI ss,
                                RelationshipVersionBI rv)
           throws IOException, ContradictionException {
      super(chronicle, ss, rv);
      characteristicReferenceProperty.set(
          new FxComponentReference(ss.getConceptVersion(rv.getCharacteristicNid())));
      refinabilityReferenceProperty.set(
          new FxComponentReference(ss.getConceptVersion(rv.getRefinabilityNid())));
      groupProperty.set(rv.getGroup());
      typeReferenceProperty.set(new FxComponentReference(ss.getConceptVersion(rv.getTypeNid())));
   }

   //~--- methods -------------------------------------------------------------

   public SimpleObjectProperty<FxComponentReference> characteristicReferenceProperty() {
      return characteristicReferenceProperty;
   }

   public SimpleIntegerProperty groupProperty() {
      return groupProperty;
   }

   public SimpleObjectProperty<FxComponentReference> refinabilityReferenceProperty() {
      return refinabilityReferenceProperty;
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName()).append(": ");
      buff.append(" origin:");
      buff.append(this.getOriginReference());
      buff.append(" type:");
      buff.append(this.typeReferenceProperty.get());
      buff.append(" destination:");
      buff.append(this.getDestinationReference());
      buff.append(" grp:");
      buff.append(this.groupProperty.get());
      buff.append(" char:");
      buff.append(this.characteristicReferenceProperty.get());
      buff.append(" ref:");
      buff.append(this.refinabilityReferenceProperty.get());
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   public FxComponentReference getCharacteristicReference() {
      return characteristicReferenceProperty.get();
   }

   public FxComponentReference getDestinationReference() {
      return this.chronicle.getDestinationReference();
   }

   public FxComponentReference getOriginReference() {
      return this.chronicle.getOriginReference();
   }

   public FxComponentReference getRefinabilityReference() {
      return refinabilityReferenceProperty.get();
   }

   public int getRelGroup() {
      return groupProperty.get();
   }

   //~--- set methods ---------------------------------------------------------

   public void setCharacteristicReference(FxComponentReference characteristicReference) {
      this.characteristicReferenceProperty.set(characteristicReference);
   }

   public void setRefinabilityReference(FxComponentReference refinabilityReference) {
      this.refinabilityReferenceProperty.set(refinabilityReference);
   }

   public void setRelGroup(int relGroup) {
      this.groupProperty.set(relGroup);
   }
 }
