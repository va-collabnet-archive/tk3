package org.ihtsdo.fxmodel.concept.component.refex.type_comp;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.fxmodel.FxComponentRef;
import org.ihtsdo.fxmodel.concept.component.FxVersion;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.refex.type_nid.RefexNidVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement()
public class FxRefexCompVersion extends FxVersion {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   private FxComponentRef comp1Ref;

   //~--- constructors --------------------------------------------------------

   public FxRefexCompVersion() {
      super();
   }

   public FxRefexCompVersion(TerminologySnapshotDI ss, RefexNidVersionBI another)
           throws IOException, ContradictionException {
      super(ss, another);
      this.comp1Ref = new FxComponentRef(ss.getConceptVersion(another.getNid1()));
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

   public FxComponentRef getComp1Ref() {
      return comp1Ref;
   }

   //~--- set methods ---------------------------------------------------------

   public void setComp1Ref(FxComponentRef comp1Ref) {
      this.comp1Ref = comp1Ref;
   }
}
