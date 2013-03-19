package org.ihtsdo.ttk.dto.component.refex.type_uuid_boolean;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.TerminologyStoreDI;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.refex.type_nid_boolean.RefexNidBooleanVersionBI;
import org.ihtsdo.ttk.dto.component.TkRevision;
import org.ihtsdo.ttk.dto.component.transformer.ComponentFields;
import org.ihtsdo.ttk.dto.component.transformer.ComponentTransformerBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.UUID;

import javax.xml.bind.annotation.XmlAttribute;

public class TkRefexUuidBooleanRevision extends TkRevision {
   public static final long serialVersionUID = 1;
   @XmlAttribute
   public UUID              uuid1;
   @XmlAttribute
   public boolean           boolean1;

   public TkRefexUuidBooleanRevision() {
      super();
   }

   public TkRefexUuidBooleanRevision(RefexNidBooleanVersionBI another) throws IOException {
      super(another);

      TerminologyStoreDI ts = Ts.get();

      this.uuid1    = ts.getUuidPrimordialForNid(another.getNid1());
      this.boolean1 = another.getBoolean1();
   }

   public TkRefexUuidBooleanRevision(DataInput in, int dataVersion)
           throws IOException, ClassNotFoundException {
      super();
      readExternal(in, dataVersion);
   }

   public TkRefexUuidBooleanRevision(TkRefexUuidBooleanRevision another, ComponentTransformerBI transformer) {
      super(another, transformer);
      this.uuid1    = transformer.transform(another.uuid1, another, ComponentFields.REFEX_COMPONENT_1_UUID);
      this.boolean1 = transformer.transform(another.boolean1, another, ComponentFields.REFEX_BOOLEAN1);
   }

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERefsetCidStrVersion</tt> object, and contains the same values, field by field,
    * as this <tt>ERefsetCidStrVersion</tt>.
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

      if (TkRefexUuidBooleanRevision.class.isAssignableFrom(obj.getClass())) {
         TkRefexUuidBooleanRevision another = (TkRefexUuidBooleanRevision) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare c1Uuid
         if (!this.uuid1.equals(another.uuid1)) {
            return false;
         }

         // Compare strValue
         if (this.boolean1 != another.boolean1) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   @Override
   public TkRefexUuidBooleanRevision makeTransform(ComponentTransformerBI transformer) {
      return new TkRefexUuidBooleanRevision(this, transformer);
   }

   @Override
   public final void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);
      uuid1   = new UUID(in.readLong(), in.readLong());
      boolean1= in.readBoolean();
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName()).append(": ");
      buff.append(" c1: ");
      buff.append(informAboutUuid(this.uuid1));
      buff.append(" str: ");
      buff.append("'").append(this.boolean1).append("'");
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   @Override
   public void writeExternal(DataOutput out) throws IOException {
      super.writeExternal(out);
      out.writeLong(uuid1.getMostSignificantBits());
      out.writeLong(uuid1.getLeastSignificantBits());
      out.writeBoolean(boolean1);
   }

   public UUID getUuid1() {
      return uuid1;
   }

   public boolean isBoolean1() {
      return boolean1;
   }

   public void setBoolean1(boolean boolean1) {
      this.boolean1 = boolean1;
   }

   public void setUuid1(UUID uuid1) {
      this.uuid1 = uuid1;
   }
}
