package org.ihtsdo.fxmodel.concept.component.refex.type_comp_long;

//~--- non-JDK imports --------------------------------------------------------

import javafx.beans.property.SimpleLongProperty;

import org.ihtsdo.fxmodel.concept.component.refex.type_comp.FxRefexCompVersion;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.refex.type_nid_long.RefexNidLongVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class FxRefexCompLongVersion extends FxRefexCompVersion {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   public SimpleLongProperty long1Property = new SimpleLongProperty(this, "long1");

   //~--- constructors --------------------------------------------------------

   public FxRefexCompLongVersion() {
      super();
   }

   public FxRefexCompLongVersion(TerminologySnapshotDI ss, RefexNidLongVersionBI another)
           throws IOException, ContradictionException {
      super(ss, another);
      this.long1Property.set(another.getLong1());
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERefsetCidLongVersion</tt> object, and contains the same values, field by field,
    * as this <tt>ERefsetCidLongVersion</tt>.
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

      if (FxRefexCompLongVersion.class.isAssignableFrom(obj.getClass())) {
         FxRefexCompLongVersion another = (FxRefexCompLongVersion) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare longValue
         if (this.long1Property != another.long1Property) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   public SimpleLongProperty long1Property() {
      return long1Property;
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName()).append(": ");
      buff.append(" long: ");
      buff.append(this.long1Property);
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   public long getLong1() {
      return long1Property.get();
   }

   //~--- set methods ---------------------------------------------------------

   public void setLong1(long long1) {
      this.long1Property.set(long1);
   }
}
