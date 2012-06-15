package org.ihtsdo.fxmodel.concept.component.refex.type_comp_comp_comp;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.fxmodel.FxComponentRef;
import org.ihtsdo.fxmodel.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.fxmodel.concept.component.refex.type_comp_comp.FxRefexCompCompVersion;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.refex.type_nid_nid_nid.RefexNidNidNidVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class FxRefexCompCompCompVersion<T extends FxRefexChronicle, V extends FxRefexCompCompCompVersion>
        extends FxRefexCompCompVersion<T, V> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   private FxComponentRef comp3Ref;

   //~--- constructors --------------------------------------------------------

   public FxRefexCompCompCompVersion() {
      super();
   }

   public FxRefexCompCompCompVersion(T chronicle, TerminologySnapshotDI ss, RefexNidNidNidVersionBI another)
           throws IOException, ContradictionException {
      super(chronicle, ss, another);
      this.comp3Ref = new FxComponentRef(ss, another.getNid3());
   }

   //~--- methods -------------------------------------------------------------

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

      if (FxRefexCompCompCompVersion.class.isAssignableFrom(obj.getClass())) {
         FxRefexCompCompCompVersion another = (FxRefexCompCompCompVersion) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         if (!this.comp3Ref.equals(another.comp3Ref)) {
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
      buff.append(" c3:");
      buff.append(this.comp3Ref);
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   public FxComponentRef getComp3Ref() {
      return comp3Ref;
   }

   //~--- set methods ---------------------------------------------------------

   public void setComp3Ref(FxComponentRef comp3Ref) {
      this.comp3Ref = comp3Ref;
   }
}
