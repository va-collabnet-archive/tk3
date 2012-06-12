package org.ihtsdo.fxmodel.concept.component.relationship;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.fxmodel.concept.component.FxVersion;
import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.TerminologyStoreDI;
import org.ihtsdo.tk.api.relationship.RelationshipVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.UUID;
import org.ihtsdo.fxmodel.FxComponentReference;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;


public class FxRelationshipVersion extends FxVersion {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   public FxComponentReference characteristicRef;
   public int  group;
   public FxComponentReference refinabilityRef;
   public FxComponentReference typeRef;

   //~--- constructors --------------------------------------------------------

   public FxRelationshipVersion() {
      super();
   }

   public FxRelationshipVersion(TerminologySnapshotDI ss, RelationshipVersionBI rv) throws IOException, ContradictionException {
      super(ss, rv);

      TerminologyStoreDI ts = Ts.get();

      characteristicRef = new FxComponentReference(ss.getConceptVersion(rv.getCharacteristicNid()));
      refinabilityRef   = new FxComponentReference(ss.getConceptVersion(rv.getRefinabilityNid()));
      group              = rv.getGroup();
      typeRef           = new FxComponentReference(ss.getConceptVersion(rv.getTypeNid()));
   }

   //~--- methods -------------------------------------------------------------

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
      buff.append(this.group);
      buff.append(" char:");
      buff.append(this.characteristicRef);
      buff.append(" ref:");
      buff.append(this.refinabilityRef);
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   public FxComponentReference getCharacteristicRef() {
      return characteristicRef;
   }

   public int getGroup() {
      return group;
   }

   public FxComponentReference getRefinabilityRef() {
      return refinabilityRef;
   }

   public int getRelGroup() {
      return group;
   }

   public FxComponentReference getTypeRef() {
      return typeRef;
   }

   //~--- set methods ---------------------------------------------------------

   public void setCharacteristicUuid(FxComponentReference characteristicRef) {
      this.characteristicRef = characteristicRef;
   }

   public void setRefinabilityRef(FxComponentReference refinabilityRef) {
      this.refinabilityRef = refinabilityRef;
   }

   public void setRelGroup(int relGroup) {
      this.group = relGroup;
   }

   public void setTypeUuid(FxComponentReference typeRef) {
      this.typeRef = typeRef;
   }
}
