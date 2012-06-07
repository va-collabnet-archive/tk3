package org.ihtsdo.fxmodel.concept.component.identifier;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.api.id.UuidIdBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataOutput;
import java.io.IOException;

import java.util.Arrays;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAttribute;

public class FxIdentifierUuid extends FxIdentifier {
   public static final long serialVersionUID = 1;
   public static UUID       generatedUuid    = UUID.fromString("2faa9262-8fb2-11db-b606-0800200c9a66");

   //~--- fields --------------------------------------------------------------

   @XmlAttribute
   public UUID denotation;

   //~--- constructors --------------------------------------------------------

   public FxIdentifierUuid() {
      super();
   }

   public FxIdentifierUuid(UUID denotation) {
      super();
      this.denotation    = denotation;
      this.authorityUuid = generatedUuid;
   }

   public FxIdentifierUuid(UuidIdBI id) throws IOException {
      super(id);
      denotation = id.getDenotation();
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>EIdentifierVersionUuid</tt> object, and contains the same values, field by field,
    * as this <tt>EIdentifierVersionUuid</tt>.
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

      if (FxIdentifierUuid.class.isAssignableFrom(obj.getClass())) {
         FxIdentifierUuid another = (FxIdentifierUuid) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare denotation
         if (!this.denotation.equals(another.denotation)) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   /**
    * Returns a hash code for this <code>EIdentifierVersionUuid</code>.
    *
    * @return a hash code value for this <tt>EIdentifierVersionUuid</tt>.
    */
   @Override
   public int hashCode() {
      return Arrays.hashCode(new int[] { denotation.hashCode(), statusUuid.hashCode(), pathUuid.hashCode(),
                                         (int) time, (int) (time >>> 32) });
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName()).append(": ");
      buff.append(" denotation:");
      buff.append(this.denotation);
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   @Override
   public void writeDenotation(DataOutput out) throws IOException {
      out.writeLong(denotation.getMostSignificantBits());
      out.writeLong(denotation.getLeastSignificantBits());
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public UUID getDenotation() {
      return denotation;
   }

   @Override
   public IDENTIFIER_PART_TYPES getIdType() {
      return IDENTIFIER_PART_TYPES.UUID;
   }

   //~--- set methods ---------------------------------------------------------

   @Override
   public void setDenotation(Object denotation) {
      this.denotation = (UUID) denotation;
   }
}
