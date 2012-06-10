package org.ihtsdo.fxmodel.concept.component.relationship;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.fxmodel.concept.component.FxVersion;
import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.TerminologyStoreDI;
import org.ihtsdo.tk.api.relationship.RelationshipVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.UUID;


public class FxRelationshipVersion extends FxVersion {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   public UUID characteristicUuid;
   public int  group;
   public UUID refinabilityUuid;
   public UUID typeUuid;

   //~--- constructors --------------------------------------------------------

   public FxRelationshipVersion() {
      super();
   }

   public FxRelationshipVersion(RelationshipVersionBI rv) throws IOException {
      super(rv);

      TerminologyStoreDI ts = Ts.get();

      characteristicUuid = ts.getUuidPrimordialForNid(rv.getCharacteristicNid());
      refinabilityUuid   = ts.getUuidPrimordialForNid(rv.getRefinabilityNid());
      group              = rv.getGroup();
      typeUuid           = ts.getUuidPrimordialForNid(rv.getTypeNid());
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
      buff.append(informAboutUuid(this.typeUuid));
      buff.append(" grp:");
      buff.append(this.group);
      buff.append(" char:");
      buff.append(this.characteristicUuid);
      buff.append(" ref:");
      buff.append(this.refinabilityUuid);
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   public UUID getCharacteristicUuid() {
      return characteristicUuid;
   }

   public int getGroup() {
      return group;
   }

   public UUID getRefinabilityUuid() {
      return refinabilityUuid;
   }

   public int getRelGroup() {
      return group;
   }

   public UUID getTypeUuid() {
      return typeUuid;
   }

   //~--- set methods ---------------------------------------------------------

   public void setCharacteristicUuid(UUID characteristicUuid) {
      this.characteristicUuid = characteristicUuid;
   }

   public void setRefinabilityUuid(UUID refinabilityUuid) {
      this.refinabilityUuid = refinabilityUuid;
   }

   public void setRelGroup(int relGroup) {
      this.group = relGroup;
   }

   public void setTypeUuid(UUID typeUuid) {
      this.typeUuid = typeUuid;
   }
}
