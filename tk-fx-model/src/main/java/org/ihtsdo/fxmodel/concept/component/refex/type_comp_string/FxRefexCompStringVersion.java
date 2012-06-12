package org.ihtsdo.fxmodel.concept.component.refex.type_comp_string;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.api.refex.type_nid_string.RefexNidStringVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import org.ihtsdo.fxmodel.concept.component.refex.type_comp.FxRefexCompVersion;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;

public class FxRefexCompStringVersion extends FxRefexCompVersion {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   public String string1;

   //~--- constructors --------------------------------------------------------

   public FxRefexCompStringVersion() {
      super();
   }

   public FxRefexCompStringVersion(TerminologySnapshotDI ss, RefexNidStringVersionBI another) throws IOException, ContradictionException {
      super(ss, another);

       this.string1 = another.getString1();
   }

   //~--- methods -------------------------------------------------------------

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

      if (FxRefexCompStringVersion.class.isAssignableFrom(obj.getClass())) {
         FxRefexCompStringVersion another = (FxRefexCompStringVersion) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================

         // Compare strValue
         if (!this.string1.equals(another.string1)) {
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
      buff.append(" str: ");
      buff.append("'").append(this.string1).append("'");
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   public String getString1() {
      return string1;
   }

   //~--- set methods ---------------------------------------------------------

   public void setString1(String string1) {
      this.string1 = string1;
   }
}
