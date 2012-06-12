package org.ihtsdo.fxmodel.concept.component.refex.type_int;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.fxmodel.concept.component.FxVersion;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.refex.type_int.RefexIntVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.xml.bind.annotation.XmlAttribute;

public class FxRefexIntVersion extends FxVersion {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlAttribute
   public int intValue;

   //~--- constructors --------------------------------------------------------

   public FxRefexIntVersion() {
      super();
   }

   public FxRefexIntVersion(TerminologySnapshotDI ss, RefexIntVersionBI another)
           throws IOException, ContradictionException {
      super(ss, another);
      this.intValue = another.getInt1();
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERefsetIntVersion</tt> object, and contains the same values, field by field,
    * as this <tt>ERefsetIntVersion</tt>.
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

      if (FxRefexIntVersion.class.isAssignableFrom(obj.getClass())) {
         FxRefexIntVersion another = (FxRefexIntVersion) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare intValue
         if (this.intValue != another.intValue) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName()).append(": ");
      buff.append(" int: ");
      buff.append(this.intValue);
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   public int getIntValue() {
      return intValue;
   }

   //~--- set methods ---------------------------------------------------------

   public void setIntValue(int intValue) {
      this.intValue = intValue;
   }
}
