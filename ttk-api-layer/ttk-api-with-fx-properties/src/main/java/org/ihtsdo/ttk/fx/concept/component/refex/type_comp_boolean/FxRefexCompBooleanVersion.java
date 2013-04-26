package org.ihtsdo.ttk.fx.concept.component.refex.type_comp_boolean;

//~--- non-JDK imports --------------------------------------------------------


import org.ihtsdo.ttk.fx.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp.FxRefexCompVersion;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologySnapshotDI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;
import javafx.beans.property.SimpleBooleanProperty;
import org.ihtsdo.ttk.api.refex.type_nid_boolean.RefexNidBooleanVersionBI;


public class FxRefexCompBooleanVersion<T extends FxRefexChronicle, V extends FxRefexCompBooleanVersion>
        extends FxRefexCompVersion<T, V> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   private SimpleBooleanProperty boolean1Property = new SimpleBooleanProperty(this, "boolean1");

   //~--- constructors --------------------------------------------------------

   public FxRefexCompBooleanVersion() {
      super();
   }

   public FxRefexCompBooleanVersion(T chronicle, TerminologySnapshotDI ss, RefexNidBooleanVersionBI another)
           throws IOException, ContradictionException {
      super(chronicle, ss, another);
      this.boolean1Property.set(another.getBoolean1());
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

      if (FxRefexCompBooleanVersion.class.isAssignableFrom(obj.getClass())) {
         FxRefexCompBooleanVersion another = (FxRefexCompBooleanVersion) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare 
         if (this.getBoolean1() != another.getBoolean1()) {
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
      buff.append(" boolean1: ");
      buff.append("'").append(this.boolean1Property.get()).append("'");
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   public boolean getBoolean1() {
      return boolean1Property.get();
   }

   //~--- set methods ---------------------------------------------------------

   public void setBoolean1(boolean booleanValue) {
      this.boolean1Property.set(booleanValue);
   }
   
     public SimpleBooleanProperty boolean1Property() {
      return boolean1Property;
   }
}
