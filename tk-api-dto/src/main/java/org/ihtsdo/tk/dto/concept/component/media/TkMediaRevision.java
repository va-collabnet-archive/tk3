package org.ihtsdo.tk.dto.concept.component.media;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.media.MediaVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.Map;
import java.util.UUID;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentFields;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentTransformerBI;

public class TkMediaRevision extends TkRevision {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   public String textDescription;
   public UUID   typeUuid;

   //~--- constructors --------------------------------------------------------

   public TkMediaRevision() {
      super();
   }

   public TkMediaRevision(MediaVersionBI another) throws IOException {
      super(another);
      this.textDescription = another.getTextDescription();
      this.typeUuid        = Ts.get().getUuidPrimordialForNid(another.getTypeNid());
   }

   public TkMediaRevision(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super();
      readExternal(in, dataVersion);
   }

   public TkMediaRevision(TkMediaRevision another, ComponentTransformerBI transformer) {
      super(another, transformer);
      this.textDescription = transformer.transform(another.textDescription, another, ComponentFields.MEDIA_TEXT_DESCRIPTION);
      this.typeUuid = transformer.transform(another.typeUuid, another, ComponentFields.MEDIA_TYPE_UUID);
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>EImageVersion</tt> object, and contains the same values, field by field,
    * as this <tt>EImageVersion</tt>.
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

      if (TkMediaRevision.class.isAssignableFrom(obj.getClass())) {
         TkMediaRevision another = (TkMediaRevision) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare textDescription
         if (!this.textDescription.equals(another.textDescription)) {
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
   public TkRevision makeTransform(ComponentTransformerBI transformer) {
      return new TkMediaRevision(this, transformer);
   }

   @Override
   public void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);
      textDescription = in.readUTF();
      typeUuid        = new UUID(in.readLong(), in.readLong());
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName()).append(": ");
      buff.append(" desc:");
      buff.append("'").append(this.textDescription).append("'");
      buff.append(" type:");
      buff.append(informAboutUuid(this.typeUuid));
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   @Override
   public void writeExternal(DataOutput out) throws IOException {
      super.writeExternal(out);
      out.writeUTF(textDescription);
      out.writeLong(typeUuid.getMostSignificantBits());
      out.writeLong(typeUuid.getLeastSignificantBits());
   }

   //~--- get methods ---------------------------------------------------------

   public String getTextDescription() {
      return textDescription;
   }

   public UUID getTypeUuid() {
      return typeUuid;
   }

   //~--- set methods ---------------------------------------------------------

   public void setTextDescription(String textDescription) {
      this.textDescription = textDescription;
   }

   public void setTypeUuid(UUID typeUuid) {
      this.typeUuid = typeUuid;
   }
}
