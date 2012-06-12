package org.ihtsdo.fxmodel.concept.component.refex.type_comp_float;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.TerminologyStoreDI;
import org.ihtsdo.tk.api.refex.type_nid_float.RefexNidFloatVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.UUID;
import org.ihtsdo.fxmodel.concept.component.refex.type_comp.FxRefexCompVersion;


public class FxRefexCompFloatVersion extends FxRefexCompVersion {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   public float float1;

   //~--- constructors --------------------------------------------------------

   public FxRefexCompFloatVersion() {
      super();
   }

   public FxRefexCompFloatVersion(TerminologySnapshotDI ss, RefexNidFloatVersionBI another)
           throws IOException, ContradictionException {
      super(ss, another);

      TerminologyStoreDI ts = Ts.get();

      this.float1 = another.getFloat1();
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERefsetCidFloatVersion</tt> object, and contains the same values, field by field,
    * as this <tt>ERefsetCidFloatVersion</tt>.
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

      if (FxRefexCompFloatVersion.class.isAssignableFrom(obj.getClass())) {
         FxRefexCompFloatVersion another = (FxRefexCompFloatVersion) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================

         // Compare floatValue
         if (this.float1 != another.float1) {
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
      buff.append(" flt:");
      buff.append(this.float1);
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   public float getFloat1() {
      return float1;
   }

   //~--- set methods ---------------------------------------------------------

   public void setFloat1(float float1) {
      this.float1 = float1;
   }
}
