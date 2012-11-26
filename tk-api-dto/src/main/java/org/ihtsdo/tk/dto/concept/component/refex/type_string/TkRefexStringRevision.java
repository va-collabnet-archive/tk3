package org.ihtsdo.tk.dto.concept.component.refex.type_string;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.api.refex.type_string.RefexStringVersionBI;
import org.ihtsdo.tk.dto.concept.UtfHelper;
import org.ihtsdo.tk.dto.concept.component.TkRevision;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import javax.xml.bind.annotation.XmlAttribute;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentFields;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentTransformerBI;

public class TkRefexStringRevision extends TkRevision {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlAttribute
   public String string1;

   //~--- constructors --------------------------------------------------------

   public TkRefexStringRevision() {
      super();
   }

   public TkRefexStringRevision(RefexStringVersionBI another) throws IOException {
      super(another);
      this.string1 = another.getString1();
   }

   public TkRefexStringRevision(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super();
      readExternal(in, dataVersion);
   }

   public TkRefexStringRevision(TkRefexStringRevision another, ComponentTransformerBI transformer) {
      super(another, transformer);
      this.string1 = transformer.transform(another.string1, another, ComponentFields.REFEX_STRING1);
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERefsetStrVersion</tt> object, and contains the same values, field by field,
    * as this <tt>ERefsetStrVersion</tt>.
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

      if (TkRefexStringRevision.class.isAssignableFrom(obj.getClass())) {
         TkRefexStringRevision another = (TkRefexStringRevision) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare stringValue
         if (!this.string1.equals(another.string1)) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   @Override
   public TkRefexStringRevision makeTransform(ComponentTransformerBI transformer) {
      return new TkRefexStringRevision(this, transformer);
   }

   @Override
   public final void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);
      string1 = UtfHelper.readUtfV7(in, dataVersion);
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName()).append(": ");
      buff.append(" str:");
      buff.append("'").append(this.string1).append("' ");
      buff.append(super.toString());

      return buff.toString();
   }

   @Override
   public void writeExternal(DataOutput out) throws IOException {
      super.writeExternal(out);
      UtfHelper.writeUtf(out, string1);
   }

   //~--- get methods ---------------------------------------------------------

   public String getString1() {
      return string1;
   }

   //~--- set methods ---------------------------------------------------------

   public void setString1(String string1) {
      this.string1 = string1;
   }
}
