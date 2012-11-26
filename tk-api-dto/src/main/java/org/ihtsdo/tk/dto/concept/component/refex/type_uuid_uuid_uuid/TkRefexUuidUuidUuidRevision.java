package org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.TerminologyStoreDI;
import org.ihtsdo.tk.api.refex.type_nid_nid_nid.RefexNidNidNidVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.UUID;
import javax.xml.bind.annotation.XmlAttribute;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentFields;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentTransformerBI;

public class TkRefexUuidUuidUuidRevision extends TkRevision {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlAttribute
   public UUID uuid1;
   @XmlAttribute
   public UUID uuid2;
   @XmlAttribute
   public UUID uuid3;

   //~--- constructors --------------------------------------------------------

   public TkRefexUuidUuidUuidRevision() {
      super();
   }

   public TkRefexUuidUuidUuidRevision(RefexNidNidNidVersionBI another) throws IOException {
      super(another);

      TerminologyStoreDI ts = Ts.get();

      this.uuid1 = ts.getUuidPrimordialForNid(another.getNid1());
      this.uuid2 = ts.getUuidPrimordialForNid(another.getNid2());
      this.uuid3 = ts.getUuidPrimordialForNid(another.getNid3());
   }

   public TkRefexUuidUuidUuidRevision(DataInput in, int dataVersion)
           throws IOException, ClassNotFoundException {
      super();
      readExternal(in, dataVersion);
   }

   public TkRefexUuidUuidUuidRevision(TkRefexUuidUuidUuidRevision another, ComponentTransformerBI transformer) {
      super(another, transformer);
      this.uuid1 = transformer.transform(another.uuid1, another, ComponentFields.REFEX_COMPONENT_1_UUID);
      this.uuid2 = transformer.transform(another.uuid2, another, ComponentFields.REFEX_COMPONENT_2_UUID);
      this.uuid3 = transformer.transform(another.uuid3, another, ComponentFields.REFEX_COMPONENT_3_UUID);
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERefsetCidCidCidVersion</tt> object, and contains the same values, field by field,
    * as this <tt>ERefsetCidCidCidVersion</tt>.
    *
    * @param obj the object to compare with.
    * @return <code>true</code> if the objects are the same;
    *         <code>false</code> otherwise.
    */
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (TkRefexUuidUuidUuidRevision.class.isAssignableFrom(obj.getClass())) {
         TkRefexUuidUuidUuidRevision another = (TkRefexUuidUuidUuidRevision) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare c1Uuid
         if (!this.uuid1.equals(another.uuid1)) {
            return false;
         }

         // Compare c2Uuid
         if (!this.uuid2.equals(another.uuid2)) {
            return false;
         }

         // Compare c3Uuid
         if (!this.uuid3.equals(another.uuid3)) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   @Override
   public TkRefexUuidUuidUuidRevision makeTransform(ComponentTransformerBI transformer) {
      return new TkRefexUuidUuidUuidRevision(this, transformer);
   }

   @Override
   public void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);
      uuid1 = new UUID(in.readLong(), in.readLong());
      uuid2 = new UUID(in.readLong(), in.readLong());
      uuid3 = new UUID(in.readLong(), in.readLong());
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName()).append(": ");
      buff.append(" c1:");
      buff.append(informAboutUuid(this.uuid1));
      buff.append(" c2:");
      buff.append(informAboutUuid(this.uuid2));
      buff.append(" c3:");
      buff.append(informAboutUuid(this.uuid3));
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   @Override
   public void writeExternal(DataOutput out) throws IOException {
      super.writeExternal(out);
      out.writeLong(uuid1.getMostSignificantBits());
      out.writeLong(uuid1.getLeastSignificantBits());
      out.writeLong(uuid2.getMostSignificantBits());
      out.writeLong(uuid2.getLeastSignificantBits());
      out.writeLong(uuid3.getMostSignificantBits());
      out.writeLong(uuid3.getLeastSignificantBits());
   }

   //~--- get methods ---------------------------------------------------------

   public UUID getUuid1() {
      return uuid1;
   }

   public UUID getUuid2() {
      return uuid2;
   }

   public UUID getUuid3() {
      return uuid3;
   }

   //~--- set methods ---------------------------------------------------------

   public void setUuid1(UUID uuid1) {
      this.uuid1 = uuid1;
   }

   public void setUuid2(UUID uuid2) {
      this.uuid2 = uuid2;
   }

   public void setUuid3(UUID uuid3) {
      this.uuid3 = uuid3;
   }
}
