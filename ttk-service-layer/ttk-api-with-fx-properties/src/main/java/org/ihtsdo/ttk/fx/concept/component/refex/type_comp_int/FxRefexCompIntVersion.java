package org.ihtsdo.ttk.fx.concept.component.refex.type_comp_int;

//~--- non-JDK imports --------------------------------------------------------

import javafx.beans.property.SimpleIntegerProperty;

import org.ihtsdo.ttk.fx.concept.component.refex.type_comp.FxRefexCompVersion;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologySnapshotDI;
import org.ihtsdo.ttk.api.refex.type_nid_int.RefexNidIntVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.ihtsdo.ttk.fx.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp_comp_int.FxRefexCompCompCompIntVersion;

@XmlSeeAlso( {
    FxRefexCompCompCompIntVersion.class, 
})
public class FxRefexCompIntVersion <T extends FxRefexChronicle, V extends FxRefexCompIntVersion>
        extends FxRefexCompVersion<T, V> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   private SimpleIntegerProperty int1Property = new SimpleIntegerProperty(this, "int1");

   //~--- constructors --------------------------------------------------------

   public FxRefexCompIntVersion() {
      super();
   }

   public FxRefexCompIntVersion(T chronicle, TerminologySnapshotDI ss, RefexNidIntVersionBI another)
           throws IOException, ContradictionException {
      super(chronicle, ss, another);
      this.int1Property.set(another.getInt1());
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERefsetCidIntVersion</tt> object, and contains the same values, field by field,
    * as this <tt>ERefsetCidIntVersion</tt>.
    *
    * @param obj the object to compare with.
    * @return <code>true</code> if the objects are the same;
    *         <code>false</code> otherwise.
    */
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (FxRefexCompIntVersion.class.isAssignableFrom(obj.getClass())) {
         FxRefexCompIntVersion another = (FxRefexCompIntVersion) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare c1Uuid
         // Compare intValue
         if (this.int1Property.get() != another.int1Property.get()) {
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
      buff.append(this.int1Property.get());
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   public SimpleIntegerProperty getInt1Property() {
      return int1Property;
   }

   public int getIntValue() {
      return int1Property.get();
   }

   //~--- set methods ---------------------------------------------------------

   public void setIntValue(int intValue) {
      this.int1Property.set(intValue);
   }
}
