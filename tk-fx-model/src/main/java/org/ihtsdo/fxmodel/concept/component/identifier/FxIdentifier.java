package org.ihtsdo.fxmodel.concept.component.identifier;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.fxmodel.concept.component.FxVersion;
import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.id.IdBI;
import org.ihtsdo.tk.api.id.LongIdBI;
import org.ihtsdo.tk.api.id.StringIdBI;
import org.ihtsdo.tk.api.id.UuidIdBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataOutput;
import java.io.IOException;

import java.util.Arrays;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class FxIdentifier extends FxVersion {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlAttribute
   public UUID authorityUuid;

   //~--- constructors --------------------------------------------------------

   public FxIdentifier() {
      super();
   }

   public FxIdentifier(IdBI id) throws IOException {
      super(id);
      this.authorityUuid = Ts.get().getComponent(id.getAuthorityNid()).getPrimUuid();
   }

   //~--- methods -------------------------------------------------------------

   public static FxIdentifier convertId(IdBI id) throws IOException {
      Object denotation = id.getDenotation();

      switch (IDENTIFIER_PART_TYPES.getType(denotation.getClass())) {
      case LONG :
         return new FxIdentifierLong((LongIdBI) id);

      case STRING :
         return new FxIdentifierString((StringIdBI) id);

      case UUID :
         return new FxIdentifierUuid((UuidIdBI) id);

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

      if (FxIdentifier.class.isAssignableFrom(obj.getClass())) {
         FxIdentifier another = (FxIdentifier) obj;

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
