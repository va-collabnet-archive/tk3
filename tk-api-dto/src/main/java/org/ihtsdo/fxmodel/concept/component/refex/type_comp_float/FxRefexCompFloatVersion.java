package org.ihtsdo.fxmodel.concept.component.refex.type_comp_float;

//~--- non-JDK imports --------------------------------------------------------

import javafx.beans.property.SimpleFloatProperty;

import org.ihtsdo.fxmodel.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_comp.FxRefexCompVersion;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.refex.type_nid_float.RefexNidFloatVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;


public class FxRefexCompFloatVersion<T extends FxRefexChronicle, V extends FxRefexCompFloatVersion>
        extends FxRefexCompVersion<T, V> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   private SimpleFloatProperty float1Property = new SimpleFloatProperty(this, "float1");

   //~--- constructors --------------------------------------------------------

   public FxRefexCompFloatVersion() {
      super();
   }

   public FxRefexCompFloatVersion(T chronicle, TerminologySnapshotDI ss, RefexNidFloatVersionBI another)
           throws IOException, ContradictionException {
      super(chronicle, ss, another);
      this.float1Property.set(another.getFloat1());
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
         if (this.float1Property.get() != another.float1Property.get()) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   public SimpleFloatProperty float1Property() {
      return float1Property;
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName()).append(": ");
      buff.append(" flt:");
      buff.append(this.float1Property.get());
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   public float getFloat1() {
      return float1Property.get();
   }

   //~--- set methods ---------------------------------------------------------

   public void setFloat1(float float1) {
      this.float1Property.set(float1);
   }
}
