package org.ihtsdo.tk.dto.concept.component.media;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.NidBitSetBI;
import org.ihtsdo.tk.api.TerminologyStoreDI;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.media.MediaChronicleBI;
import org.ihtsdo.tk.api.media.MediaVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkComponent;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.*;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentFields;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentTransformerBI;

public class TkMedia extends TkComponent<TkMediaRevision> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   public UUID   conceptUuid;
   public byte[] dataBytes;
   public String format;
   public String textDescription;
   public UUID   typeUuid;

   //~--- constructors --------------------------------------------------------

   public TkMedia() {
      super();
   }

   public TkMedia(MediaChronicleBI another) throws IOException {
      super(another.getPrimordialVersion());

      Collection<? extends MediaVersionBI> media        = another.getVersions();
      int                                  partCount    = media.size();
      Iterator<? extends MediaVersionBI>   itr          = media.iterator();
      TerminologyStoreDI                   ts           = Ts.get();
      MediaVersionBI                       mediaVersion = itr.next();

      this.conceptUuid     = ts.getUuidPrimordialForNid(mediaVersion.getConceptNid());
      this.typeUuid        = ts.getUuidPrimordialForNid(mediaVersion.getTypeNid());
      this.dataBytes       = mediaVersion.getMedia();
      this.format          = mediaVersion.getFormat();
      this.textDescription = mediaVersion.getTextDescription();

      if (partCount > 1) {
         revisions = new ArrayList<>(partCount - 1);

         while (itr.hasNext()) {
            mediaVersion = itr.next();
            revisions.add(new TkMediaRevision(mediaVersion));
         }
      }
   }

   public TkMedia(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super();
      readExternal(in, dataVersion);
   }

   public TkMedia(TkMedia another, ComponentTransformerBI transformer) {
      super(another, transformer);

         this.conceptUuid     = transformer.transform(another.conceptUuid, another, ComponentFields.MEDIA_ENCLOSING_CONCEPT_UUID);
         this.dataBytes       = transformer.transform(another.dataBytes, another, ComponentFields.MEDIA_DATA);
         this.format          = transformer.transform(another.format, another, ComponentFields.MEDIA_FORMAT);
         this.textDescription = transformer.transform(another.textDescription, another, ComponentFields.MEDIA_TEXT_DESCRIPTION);
         this.typeUuid        = transformer.transform(another.typeUuid, another, ComponentFields.MEDIA_TYPE_UUID);
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>EImage</tt> object, and contains the same values, field by field,
    * as this <tt>EImage</tt>.
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

      if (TkMedia.class.isAssignableFrom(obj.getClass())) {
         TkMedia another = (TkMedia) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare conceptUuid
         if (!this.conceptUuid.equals(another.conceptUuid)) {
            return false;
         }

         // Compare format
         if (!this.format.equals(another.format)) {
            return false;
         }

         // Compare image (had to loop through the array)
         for (int i = 0; i < this.dataBytes.length; i++) {
            if (this.dataBytes[i] != another.dataBytes[i]) {
               return false;
            }
         }

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

   /**
    * Returns a hash code for this <code>EImage</code>.
    *
    * @return a hash code value for this <tt>EImage</tt>.
    */
   @Override
   public int hashCode() {
      return this.primordialUuid.hashCode();
   }

   @Override
   public TkMedia makeTransform(ComponentTransformerBI transformer) {
      return new TkMedia(this, transformer);
   }

   @Override
   public void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);
      conceptUuid = new UUID(in.readLong(), in.readLong());
      format      = in.readUTF();

      int imageSize = in.readInt();

      dataBytes = new byte[imageSize];
      in.readFully(dataBytes);
      textDescription = in.readUTF();
      typeUuid        = new UUID(in.readLong(), in.readLong());

      int versionLength = in.readInt();

      if (versionLength > 0) {
         revisions = new ArrayList<>(versionLength);

         for (int i = 0; i < versionLength; i++) {
            revisions.add(new TkMediaRevision(in, dataVersion));
         }
      }
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName()).append(": ");
      buff.append(" concept:");
      buff.append(informAboutUuid(this.conceptUuid));
      buff.append(" format:");
      buff.append("'").append(this.format).append("'");
      buff.append(" image:");
      buff.append(new String(this.dataBytes));
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
      out.writeLong(conceptUuid.getMostSignificantBits());
      out.writeLong(conceptUuid.getLeastSignificantBits());
      out.writeUTF(format);
      out.writeInt(dataBytes.length);
      out.write(dataBytes);
      out.writeUTF(textDescription);
      out.writeLong(typeUuid.getMostSignificantBits());
      out.writeLong(typeUuid.getLeastSignificantBits());

      if (revisions == null) {
         out.writeInt(0);
      } else {
         out.writeInt(revisions.size());

         for (TkMediaRevision eiv : revisions) {
            eiv.writeExternal(out);
         }
      }
   }

   //~--- get methods ---------------------------------------------------------

   public UUID getConceptUuid() {
      return conceptUuid;
   }

   public byte[] getDataBytes() {
      return dataBytes;
   }

   public String getFormat() {
      return format;
   }

   @Override
   public List<TkMediaRevision> getRevisionList() {
      return revisions;
   }

   public String getTextDescription() {
      return textDescription;
   }

   public UUID getTypeUuid() {
      return typeUuid;
   }

   //~--- set methods ---------------------------------------------------------

   public void setConceptUuid(UUID conceptUuid) {
      this.conceptUuid = conceptUuid;
   }

   public void setDataBytes(byte[] data) {
      this.dataBytes = data;
   }

   public void setFormat(String format) {
      this.format = format;
   }

   public void setTextDescription(String textDescription) {
      this.textDescription = textDescription;
   }

   public void setTypeUuid(UUID typeUuid) {
      this.typeUuid = typeUuid;
   }
}
