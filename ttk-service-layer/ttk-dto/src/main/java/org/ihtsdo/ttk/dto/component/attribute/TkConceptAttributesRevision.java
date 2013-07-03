package org.ihtsdo.ttk.dto.component.attribute;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.conattr.ConceptAttributeVersionBI;
import org.ihtsdo.ttk.dto.component.TtkRevision;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import org.ihtsdo.ttk.dto.component.transformer.ComponentFields;
import org.ihtsdo.ttk.dto.component.transformer.ComponentTransformerBI;

@XmlRootElement(name="attributes-revision")
public class TkConceptAttributesRevision extends TtkRevision {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlAttribute
   public boolean defined;

   //~--- constructors --------------------------------------------------------

   public TkConceptAttributesRevision() {
      super();
   }

   public TkConceptAttributesRevision(ConceptAttributeVersionBI another) throws IOException {
      super(another);
      this.defined = another.isDefined();
   }

   public TkConceptAttributesRevision(DataInput in, int dataVersion)
           throws IOException, ClassNotFoundException {
      super();
      readExternal(in, dataVersion);
   }

   public TkConceptAttributesRevision(TkConceptAttributesRevision another, ComponentTransformerBI transformer) {
      super(another, transformer);
      this.defined = transformer.transform(another.defined, another, ComponentFields.ATTRIBUTE_DEFINED);
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>EConceptAttributesVersion</tt> object, and contains the same values, field by field,
    * as this <tt>EConceptAttributesVersion</tt>.
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

      if (TkConceptAttributesRevision.class.isAssignableFrom(obj.getClass())) {
         TkConceptAttributesRevision another = (TkConceptAttributesRevision) obj;

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

   @Override
   public TkConceptAttributesRevision makeTransform(ComponentTransformerBI transformer) {
      return new TkConceptAttributesRevision(this, transformer);
   }

   @Override
   public void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);
      defined = in.readBoolean();
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName()).append(": ");
      buff.append(" defined:");
      buff.append(this.defined);
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   @Override
   public void writeExternal(DataOutput out) throws IOException {
      super.writeExternal(out);
      out.writeBoolean(defined);
   }

   //~--- get methods ---------------------------------------------------------

   /*
    * (non-Javadoc)
    *
    * @see org.ihtsdo.etypes.I_ConceptualizeExternally#isDefined()
    */
   public boolean isDefined() {
      return defined;
   }

   //~--- set methods ---------------------------------------------------------

   public void setDefined(boolean defined) {
      this.defined = defined;
   }
}
