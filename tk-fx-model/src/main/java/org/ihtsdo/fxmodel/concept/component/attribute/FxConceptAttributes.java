package org.ihtsdo.fxmodel.concept.component.attribute;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.api.conattr.ConAttrChronicleBI;
import org.ihtsdo.tk.api.conattr.ConAttrVersionBI;
import org.ihtsdo.tk.api.ext.I_ConceptualizeExternally;
import org.ihtsdo.fxmodel.concept.component.FxComponent;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="attributes")
public class FxConceptAttributes extends FxComponent<FxConceptAttributesRevision>
        implements I_ConceptualizeExternally {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlAttribute
   public boolean defined;

   //~--- constructors --------------------------------------------------------

   public FxConceptAttributes() {
      super();
   }

   public FxConceptAttributes(ConAttrChronicleBI another) throws IOException {
      super(another.getPrimordialVersion());

      Collection<? extends ConAttrVersionBI> versions = another.getVersions();
      Iterator<? extends ConAttrVersionBI>   itr      = versions.iterator();
      ConAttrVersionBI                       vers     = itr.next();

      this.defined = vers.isDefined();

      if (versions.size() > 1) {
         revisions = new ArrayList<>(versions.size() - 1);

         while (itr.hasNext()) {
            vers = itr.next();
            revisions.add(new FxConceptAttributesRevision(vers));
         }
      }
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>EConceptAttributes</tt> object, and contains the same values, field by field,
    * as this <tt>EConceptAttributes</tt>.
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

      if (FxConceptAttributes.class.isAssignableFrom(obj.getClass())) {
         FxConceptAttributes another = (FxConceptAttributes) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare defined
         if (this.defined != another.defined) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   /**
    * Returns a hash code for this <code>EConceptAttributes</code>.
    *
    * @return a hash code value for this <tt>EConceptAttributes</tt>.
    */
   @Override
   public int hashCode() {
      return this.primordialUuid.hashCode();
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName()).append(": ");
      buff.append(" defined: ");
      buff.append(this.defined);
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public List<FxConceptAttributesRevision> getRevisionList() {
      return revisions;
   }

   @Override
   public boolean isDefined() {
      return defined;
   }

   //~--- set methods ---------------------------------------------------------

   public void setDefined(boolean defined) {
      this.defined = defined;
   }
}
