package org.ihtsdo.tk.dto.concept.component.identifier;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.id.IdBI;
import org.ihtsdo.tk.api.id.LongIdBI;
import org.ihtsdo.tk.api.id.StringIdBI;
import org.ihtsdo.tk.api.id.UuidIdBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.Arrays;
import java.util.UUID;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentFields;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentTransformerBI;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class TkIdentifier extends TkRevision {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------
   @XmlAttribute
   public UUID authorityUuid;

   //~--- constructors --------------------------------------------------------

   public TkIdentifier() {
      super();
   }

   public TkIdentifier(IdBI id) throws IOException {
      super(id);
      this.authorityUuid = Ts.get().getComponent(id.getAuthorityNid()).getPrimUuid();
   }

   public TkIdentifier(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super();
      readExternal(in, dataVersion);
   }

   public TkIdentifier(TkIdentifier another, ComponentTransformerBI transformer) {
      super(another, transformer);
      this.authorityUuid = transformer.transform(another.authorityUuid, another, ComponentFields.ID_AUTHORITY_UUID);
   }

   //~--- methods -------------------------------------------------------------

   public static TkIdentifier convertId(IdBI id) throws IOException {
      Object denotation = id.getDenotation();

      switch (IDENTIFIER_PART_TYPES.getType(denotation.getClass())) {
      case LONG :
         return new TkIdentifierLong((LongIdBI) id);

      case STRING :
         return new TkIdentifierString((StringIdBI) id);

      case UUID :
         return new TkIdentifierUuid((UuidIdBI) id);

      default :
         throw new UnsupportedOperationException();
      }
   }

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>EIdentifierVersion</tt> object, and contains the same values, field by field,
    * as this <tt>EIdentifierVersion</tt>.
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

      if (TkIdentifier.class.isAssignableFrom(obj.getClass())) {
         TkIdentifier another = (TkIdentifier) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare authorityUuid
         if (!this.authorityUuid.equals(another.authorityUuid)) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   /**
    * Returns a hash code for this <code>EIdentifierVersion</code>.
    *
    * @return a hash code value for this <tt>EIdentifierVersion</tt>.
    */
   @Override
   public int hashCode() {
      return Arrays.hashCode(new int[] { statusUuid.hashCode(), pathUuid.hashCode(), (int) time,
                                         (int) (time >>> 32) });
   }

   @Override
   public void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);
      authorityUuid = new UUID(in.readLong(), in.readLong());
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(" authority:");
      buff.append(informAboutUuid(this.authorityUuid));
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   public abstract void writeDenotation(DataOutput out) throws IOException;

   @Override
   public void writeExternal(DataOutput out) throws IOException {
      super.writeExternal(out);
      out.writeLong(authorityUuid.getMostSignificantBits());
      out.writeLong(authorityUuid.getLeastSignificantBits());
      writeDenotation(out);
   }

   //~--- get methods ---------------------------------------------------------

   public UUID getAuthorityUuid() {
      return authorityUuid;
   }

   public abstract Object getDenotation();

   public abstract IDENTIFIER_PART_TYPES getIdType();

   //~--- set methods ---------------------------------------------------------

   public void setAuthorityUuid(UUID authorityUuid) {
      this.authorityUuid = authorityUuid;
   }

   public abstract void setDenotation(Object denotation);
}
