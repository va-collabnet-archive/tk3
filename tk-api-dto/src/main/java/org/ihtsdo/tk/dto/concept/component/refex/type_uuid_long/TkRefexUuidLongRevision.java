package org.ihtsdo.tk.dto.concept.component.refex.type_uuid_long;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.TerminologyStoreDI;
import org.ihtsdo.tk.api.refex.type_nid_long.RefexNidLongVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.UUID;
import javax.xml.bind.annotation.XmlAttribute;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentFields;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentTransformerBI;

public class TkRefexUuidLongRevision extends TkRevision {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlAttribute
   public UUID uuid1;
   @XmlAttribute
   public long long1;

   //~--- constructors --------------------------------------------------------

   public TkRefexUuidLongRevision() {
      super();
   }

   public TkRefexUuidLongRevision(RefexNidLongVersionBI another) throws IOException {
      super(another);

      TerminologyStoreDI ts = Ts.get();

      this.uuid1    = ts.getUuidPrimordialForNid(another.getNid1());
      this.long1 = another.getLong1();
   }

   public TkRefexUuidLongRevision(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super();
      readExternal(in, dataVersion);
   }

   public TkRefexUuidLongRevision(TkRefexUuidLongRevision another, ComponentTransformerBI transformer) {
      super(another, transformer);

      this.uuid1 = transformer.transform(another.uuid1, another, ComponentFields.REFEX_COMPONENT_1_UUID);
      this.long1 = transformer.transform(another.long1, another, ComponentFields.REFEX_LONG1);
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERefsetCidLongVersion</tt> object, and contains the same values, field by field,
    * as this <tt>ERefsetCidLongVersion</tt>.
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

      if (TkRefexUuidLongRevision.class.isAssignableFrom(obj.getClass())) {
         TkRefexUuidLongRevision another = (TkRefexUuidLongRevision) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare c1Uuid
         if (!this.uuid1.equals(another.uuid1)) {
            return false;
         }

         // Compare longValue
         if (this.long1 != another.long1) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   @Override
   public TkRefexUuidLongRevision makeTransform(ComponentTransformerBI transformer) {
      return new TkRefexUuidLongRevision(this, transformer);
   }

   @Override
   public void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);
      uuid1    = new UUID(in.readLong(), in.readLong());
      long1 = in.readLong();
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
      buff.append(" long: ");
      buff.append(this.long1);
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   @Override
   public void writeExternal(DataOutput out) throws IOException {
      super.writeExternal(out);
      out.writeLong(uuid1.getMostSignificantBits());
      out.writeLong(uuid1.getLeastSignificantBits());
      out.writeLong(long1);
   }

   //~--- get methods ---------------------------------------------------------

   public UUID getUuid1() {
      return uuid1;
   }

   public long getLong1() {
      return long1;
   }

   //~--- set methods ---------------------------------------------------------

   public void setUuid1(UUID uuid1) {
      this.uuid1 = uuid1;
   }

   public void setLong1(long long1) {
      this.long1 = long1;
   }
}
