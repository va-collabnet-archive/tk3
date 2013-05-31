package org.ihtsdo.ttk.fx.concept.component.refex.type_comp;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.fx.FxComponentReference;
import org.ihtsdo.ttk.fx.concept.component.refex.FxRefexVersion;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp.FxRefexCompCompVersion;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_float.FxRefexCompFloatVersion;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_int.FxRefexCompIntVersion;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_long.FxRefexCompLongVersion;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_string.FxRefexCompStringVersion;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologySnapshotDI;
import org.ihtsdo.ttk.api.refex.type_nid.RefexNidVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.xml.bind.annotation.XmlSeeAlso;
import org.ihtsdo.ttk.fx.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_boolean.FxRefexCompBooleanVersion;

@XmlSeeAlso( {
    FxRefexCompBooleanVersion.class,
    FxRefexCompCompVersion.class, 
    FxRefexCompFloatVersion.class, 
    FxRefexCompIntVersion.class,
    FxRefexCompLongVersion.class,
    FxRefexCompStringVersion.class, 
})
public class FxRefexCompVersion<T extends FxRefexChronicle, V extends FxRefexCompVersion>
        extends FxRefexVersion<T, V> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   private FxComponentReference comp1Ref;

   //~--- constructors --------------------------------------------------------

   public FxRefexCompVersion() {
      super();
   }

   public FxRefexCompVersion(T chronicle, TerminologySnapshotDI ss,
                             RefexNidVersionBI another)
           throws IOException, ContradictionException {
      super(chronicle, ss, another);
      this.comp1Ref = new FxComponentReference(ss, another.getNid1());
   }

   //~--- methods -------------------------------------------------------------

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

      if (FxRefexCompVersion.class.isAssignableFrom(obj.getClass())) {
         FxRefexCompVersion another = (FxRefexCompVersion) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare c1Uuid
         if (!this.comp1Ref.equals(another.comp1Ref)) {
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
      buff.append(" c1:");
      buff.append(this.comp1Ref);
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   public FxComponentReference getComp1Ref() {
      return comp1Ref;
   }

   //~--- set methods ---------------------------------------------------------

   public void setComp1Ref(FxComponentReference comp1Ref) {
      this.comp1Ref = comp1Ref;
   }
}
