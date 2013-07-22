package org.ihtsdo.ttk.fx.concept.component.refex.type_array_of_bytearray;

//~--- non-JDK imports --------------------------------------------------------

import javafx.beans.property.SimpleObjectProperty;

import org.ihtsdo.otf.tcc.api.ContradictionException;
import org.ihtsdo.otf.tcc.api.TerminologySnapshotDI;
import org.ihtsdo.otf.tcc.api.refex.type_array_of_bytearray.RefexArrayOfBytearrayVersionBI;
import org.ihtsdo.ttk.fx.FxComponentReference;
import org.ihtsdo.ttk.fx.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.FxRefexVersion;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp.FxRefexCompCompVersion;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_float.FxRefexCompFloatVersion;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_int.FxRefexCompIntVersion;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_long.FxRefexCompLongVersion;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_string.FxRefexCompStringVersion;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Class description
 *
 *
 * @param <T>
 * @param <V>
 *
 * @version        Enter version here..., 13/04/25
 * @author         Enter your name here...    
 */
@XmlSeeAlso( {
   FxRefexCompCompVersion.class, FxRefexCompFloatVersion.class, FxRefexCompLongVersion.class,
   FxRefexCompStringVersion.class, FxRefexCompIntVersion.class
})
public class FxRefexArrayOfByteArrayVersion<T extends FxRefexChronicle,
    V extends FxRefexArrayOfByteArrayVersion> extends FxRefexVersion<T, V> {

   /** Field description */
   public static final long serialVersionUID = 1;

   /** Field description */
   private SimpleObjectProperty<byte[][]> arrayOfByteArrayProperty;

   /**
    * Constructs ...
    *
    */
   public FxRefexArrayOfByteArrayVersion() {
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
   public FxRefexArrayOfByteArrayVersion(T chronicle, TerminologySnapshotDI ss,
       RefexArrayOfBytearrayVersionBI another)
           throws IOException, ContradictionException {
      super(chronicle, ss, another);
      this.arrayOfByteArrayProperty = new SimpleObjectProperty(another.getArrayOfByteArray());
   }

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERefsetCidVersion</tt> object, and contains the same values, field by field,
    * as this <tt>ERefsetCidVersion</tt>.
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

      if (FxRefexArrayOfByteArrayVersion.class.isAssignableFrom(obj.getClass())) {
         FxRefexArrayOfByteArrayVersion another = (FxRefexArrayOfByteArrayVersion) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare c1Uuid
         if (!this.arrayOfByteArrayProperty.equals(another.arrayOfByteArrayProperty)) {
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
      buff.append(" c1:");
      buff.append(this.arrayOfByteArrayProperty);
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
   public byte[][] getArrayOfByteArray() {
      return arrayOfByteArrayProperty.get();
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public SimpleObjectProperty<byte[][]> getArrayOfByteArrayProperty() {
      return arrayOfByteArrayProperty;
   }

   /**
    * Method description
    *
    *
    * @param comp1Ref
    */
   public void setArrayOfByteArray(byte[][] comp1Ref) {
      this.arrayOfByteArrayProperty.setValue(comp1Ref);
   }
}
