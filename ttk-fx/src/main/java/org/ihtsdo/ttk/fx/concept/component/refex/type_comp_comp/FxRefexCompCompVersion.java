package org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.fx.FxComponentReference;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp.FxRefexCompVersion;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp_comp.FxRefexCompCompCompVersion;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp_string.FxRefexCompCompStringVersion;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologySnapshotDI;
import org.ihtsdo.ttk.api.refex.type_nid_nid.RefexNidNidVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.xml.bind.annotation.XmlSeeAlso;
import org.ihtsdo.ttk.fx.concept.component.refex.FxRefexChronicle;

@XmlSeeAlso({ FxRefexCompCompStringVersion.class, FxRefexCompCompCompVersion.class })
public class FxRefexCompCompVersion<T extends FxRefexChronicle, V extends FxRefexCompCompVersion>
        extends FxRefexCompVersion<T, V> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   private FxComponentReference comp2Ref;

   //~--- constructors --------------------------------------------------------

   public FxRefexCompCompVersion() {
      super();
   }

   public FxRefexCompCompVersion(T chronicle, TerminologySnapshotDI ss, RefexNidNidVersionBI another)
           throws IOException, ContradictionException {
      super(chronicle, ss, another);
      this.comp2Ref = new FxComponentReference(ss, another.getNid2());
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERefsetCidCidVersion</tt> object, and contains the same values, field by field,
    * as this <tt>ERefsetCidCidVersion</tt>.
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

      if (FxRefexCompCompVersion.class.isAssignableFrom(obj.getClass())) {
         FxRefexCompCompVersion another = (FxRefexCompCompVersion) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare c2Uuid
         if (!this.comp2Ref.equals(another.comp2Ref)) {
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
      buff.append(" c2:");
      buff.append(this.comp2Ref);
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   public FxComponentReference getComponent2Ref() {
      return comp2Ref;
   }

   //~--- set methods ---------------------------------------------------------

   public void setComponent2Ref(FxComponentReference comp2Ref) {
      this.comp2Ref = comp2Ref;
   }
}
