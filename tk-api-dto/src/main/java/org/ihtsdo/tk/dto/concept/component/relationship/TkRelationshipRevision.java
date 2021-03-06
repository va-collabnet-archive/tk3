package org.ihtsdo.tk.dto.concept.component.relationship;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.TerminologyStoreDI;
import org.ihtsdo.tk.api.relationship.RelationshipVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.UUID;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentFields;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentTransformerBI;

@XmlRootElement(name="relationship-revision")
public class TkRelationshipRevision extends TkRevision {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlAttribute
   public UUID characteristicUuid;
   @XmlAttribute
   public int  group;
   @XmlAttribute
   public UUID refinabilityUuid;
   @XmlAttribute
   public UUID typeUuid;

   //~--- constructors --------------------------------------------------------

   public TkRelationshipRevision() {
      super();
   }

   public TkRelationshipRevision(RelationshipVersionBI rv) throws IOException {
      TerminologyStoreDI ts = Ts.get();

      characteristicUuid = ts.getUuidPrimordialForNid(rv.getCharacteristicNid());
      refinabilityUuid   = ts.getUuidPrimordialForNid(rv.getRefinabilityNid());
      group              = rv.getGroup();
      typeUuid           = ts.getUuidPrimordialForNid(rv.getTypeNid());
      pathUuid           = ts.getUuidPrimordialForNid(rv.getPathNid());
      statusUuid         = ts.getUuidPrimordialForNid(rv.getStatusNid());
      time               = rv.getTime();
   }

   public TkRelationshipRevision(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super();
      readExternal(in, dataVersion);
   }

   public TkRelationshipRevision(TkRelationshipRevision another, ComponentTransformerBI transformer) {
      super(another, transformer); 

         this.characteristicUuid = transformer.transform(another.characteristicUuid, another, ComponentFields.RELATIONSHIP_CHARACTERISTIC_UUID);
         this.refinabilityUuid   = transformer.transform(another.refinabilityUuid, another, ComponentFields.RELATIONSHIP_REFINABILITY_UUID);
         this.group           = transformer.transform(another.group, another, ComponentFields.RELATIONSHIP_GROUP);
         this.typeUuid           = transformer.transform(another.typeUuid, another, ComponentFields.RELATIONSHIP_TYPE_UUID);
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERelationshipVersion</tt> object, and contains the same values,
    * field by field, as this <tt>ERelationshipVersion</tt>.
    *
    * @param obj the object to compare with.
    * @return <code>true</code> if the objects are the same;
    *         <code>false</code> otherwise.
    */
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (TkRelationshipRevision.class.isAssignableFrom(obj.getClass())) {
         TkRelationshipRevision another = (TkRelationshipRevision) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare characteristicUuid
         if (!this.characteristicUuid.equals(another.characteristicUuid)) {
            return false;
         }

         // Compare refinabilityUuid
         if (!this.refinabilityUuid.equals(another.refinabilityUuid)) {
            return false;
         }

         // Compare group
         if (this.group != another.group) {
            return false;
         }

         // Compare typeUuid
         if (!this.typeUuid.equals(another.typeUuid)) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   @Override
   public TkRelationshipRevision makeTransform(ComponentTransformerBI transformer) {
      return new TkRelationshipRevision(this, transformer);
   }

   @Override
   public void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);
      characteristicUuid = new UUID(in.readLong(), in.readLong());
      refinabilityUuid   = new UUID(in.readLong(), in.readLong());
      group              = in.readInt();
      typeUuid           = new UUID(in.readLong(), in.readLong());
   }

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

   @Override
   public void writeExternal(DataOutput out) throws IOException {
      super.writeExternal(out);
      out.writeLong(characteristicUuid.getMostSignificantBits());
      out.writeLong(characteristicUuid.getLeastSignificantBits());
      out.writeLong(refinabilityUuid.getMostSignificantBits());
      out.writeLong(refinabilityUuid.getLeastSignificantBits());
      out.writeInt(group);
      out.writeLong(typeUuid.getMostSignificantBits());
      out.writeLong(typeUuid.getLeastSignificantBits());
   }

   //~--- get methods ---------------------------------------------------------

   public UUID getCharacteristicUuid() {
      return characteristicUuid;
   }

   public int getGroup() {
      return group;
   }

   public int getRelGroup() {
      return group;
   }

   public UUID getRefinabilityUuid() {
      return refinabilityUuid;
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
