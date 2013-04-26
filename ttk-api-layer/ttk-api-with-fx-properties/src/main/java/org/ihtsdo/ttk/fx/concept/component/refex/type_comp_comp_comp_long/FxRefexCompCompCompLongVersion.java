package org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp_comp_long;

//~--- non-JDK imports --------------------------------------------------------


import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologySnapshotDI;
import org.ihtsdo.ttk.fx.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp_comp.FxRefexCompCompCompVersion;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;
import javafx.beans.property.SimpleLongProperty;
import org.ihtsdo.ttk.api.refex.type_nid_nid_nid_long.RefexNidNidNidLongVersionBI;

/**
 * Class description
 *
 *
 * @param <T>
 * @param <V>
 *
 * @version        Enter version here..., 13/04/24
 * @author         Enter your name here...    
 */
public class FxRefexCompCompCompLongVersion<T extends FxRefexChronicle,
    V extends FxRefexCompCompCompLongVersion> extends FxRefexCompCompCompVersion<T, V> {

   /** Field description */
   public static final long serialVersionUID = 1;

   /** Field description */
   private SimpleLongProperty long1property = new SimpleLongProperty(this, "long1");

   /**
    * Constructs ...
    *
    */
   public FxRefexCompCompCompLongVersion() {
      super();
   }

   /**
    * Constructs ...
    *
    *
    * @param chronicle
    * @param ss
    * @param another
    *
    * @throws ContradictionException
    * @throws IOException
    */
   public FxRefexCompCompCompLongVersion(T chronicle, TerminologySnapshotDI ss,
       RefexNidNidNidLongVersionBI another)
           throws IOException, ContradictionException {
      super(chronicle, ss, another);
      this.long1property.set(another.getLong1());
   }

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERefsetCidCidCidVersion</tt> object, and contains the same values, field by field,
    * as this <tt>ERefsetCidCidCidVersion</tt>.
    *
    * @param obj the object to compare with.
    * @return <code>true</code> if the objects are the same;
    *         <code>false</code> otherwise.
    */
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (FxRefexCompCompCompLongVersion.class.isAssignableFrom(obj.getClass())) {
         FxRefexCompCompCompLongVersion another = (FxRefexCompCompCompLongVersion) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         if (this.long1property.get() != another.long1property.get()) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   /**
    * Returns a string representation of the object.
    *
    * @return
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName()).append(": ");
      buff.append(" long1:");
      buff.append(this.long1property.get());
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public long getLong1() {
      return long1property.get();
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public SimpleLongProperty getLong1Property() {
      return long1property;
   }

   /**
    * Method description
    *
    *
    * @param float1
    */
   public void setLong1(long long1) {
      this.long1property.set(long1);
   }
}
