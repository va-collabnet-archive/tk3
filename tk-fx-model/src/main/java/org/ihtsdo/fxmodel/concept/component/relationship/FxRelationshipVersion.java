package org.ihtsdo.fxmodel.concept.component.relationship;

//~--- non-JDK imports --------------------------------------------------------

import javafx.beans.property.SimpleIntegerProperty;

import org.ihtsdo.fxmodel.FxComponentRef;
import org.ihtsdo.fxmodel.concept.component.FxVersion;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.relationship.RelationshipVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class FxRelationshipVersion extends FxVersion {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   protected SimpleIntegerProperty groupProperty = new SimpleIntegerProperty(this, "group");
   protected FxComponentRef  characteristicRef;
   protected FxComponentRef  refinabilityRef;
   protected FxComponentRef  typeRef;

   //~--- constructors --------------------------------------------------------

   public FxRelationshipVersion() {
      super();
   }

   public FxRelationshipVersion(TerminologySnapshotDI ss, RelationshipVersionBI rv)
           throws IOException, ContradictionException {
      super(ss, rv);
      characteristicRef = new FxComponentRef(ss.getConceptVersion(rv.getCharacteristicNid()));
      refinabilityRef   = new FxComponentRef(ss.getConceptVersion(rv.getRefinabilityNid()));
      groupProperty.set(rv.getGroup());
      typeRef = new FxComponentRef(ss.getConceptVersion(rv.getTypeNid()));
   }

   //~--- methods -------------------------------------------------------------

   public SimpleIntegerProperty groupProperty() {
      return groupProperty;
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName()).append(": ");
      buff.append(" type:");
      buff.append(this.typeRef);
      buff.append(" grp:");
      buff.append(this.groupProperty);
      buff.append(" char:");
      buff.append(this.characteristicRef);
      buff.append(" ref:");
      buff.append(this.refinabilityRef);
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   public FxComponentRef getCharacteristicRef() {
      return characteristicRef;
   }

   public FxComponentRef getRefinabilityRef() {
      return refinabilityRef;
   }

   public int getRelGroup() {
      return groupProperty.get();
   }

   public FxComponentRef getTypeRef() {
      return typeRef;
   }

   //~--- set methods ---------------------------------------------------------

   public void setCharacteristicRef(FxComponentRef characteristicRef) {
      this.characteristicRef = characteristicRef;
   }

   public void setRefinabilityRef(FxComponentRef refinabilityRef) {
      this.refinabilityRef = refinabilityRef;
   }

   public void setRelGroup(int relGroup) {
      this.groupProperty.set(relGroup);
   }

   public void setTypeRef(FxComponentRef typeRef) {
      this.typeRef = typeRef;
   }
}
