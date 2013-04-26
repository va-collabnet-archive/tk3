package org.ihtsdo.ttk.fx.concept.component.refex.type_boolean;

//~--- non-JDK imports --------------------------------------------------------

import javafx.beans.property.SimpleBooleanProperty;

import org.ihtsdo.ttk.fx.concept.component.refex.FxRefexVersion;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologySnapshotDI;
import org.ihtsdo.ttk.api.refex.type_boolean.RefexBooleanVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;


public class FxRefexBooleanVersion extends FxRefexVersion<FxRefexBooleanChronicle, FxRefexBooleanVersion> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   private SimpleBooleanProperty boolean1Property = new SimpleBooleanProperty(this, "boolean1");

   //~--- constructors --------------------------------------------------------

   public FxRefexBooleanVersion() {
      super();
   }

   public FxRefexBooleanVersion(FxRefexBooleanChronicle chronicle, TerminologySnapshotDI ss,
                                RefexBooleanVersionBI another)
           throws IOException, ContradictionException {
      super(chronicle, ss, another);
      this.boolean1Property.set(another.getBoolean1());
   }

   //~--- methods -------------------------------------------------------------

   public SimpleBooleanProperty boolean1Property() {
      return boolean1Property;
   }

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERefsetBooleanVersion</tt> object, and contains the same values, field by field,
    * as this <tt>ERefsetBooleanVersion</tt>.
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

      if (FxRefexBooleanVersion.class.isAssignableFrom(obj.getClass())) {
         FxRefexBooleanVersion another = (FxRefexBooleanVersion) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare boolean1Property
         if (this.boolean1Property.get() != another.boolean1Property.get()) {
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
      buff.append(this.boolean1Property.get());
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   public boolean getBoolean1() {
      return boolean1Property.get();
   }

   //~--- set methods ---------------------------------------------------------

   public void setBoolean1(boolean booleanValue) {
      this.boolean1Property.set(booleanValue);
   }
  
}
