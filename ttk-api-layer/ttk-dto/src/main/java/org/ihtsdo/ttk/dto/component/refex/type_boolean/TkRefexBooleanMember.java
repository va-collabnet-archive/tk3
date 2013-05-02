package org.ihtsdo.ttk.dto.component.refex.type_boolean;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.refex.type_boolean.RefexBooleanVersionBI;
import org.ihtsdo.ttk.api.ToolkitRefexType;
import org.ihtsdo.ttk.dto.component.refex.TkRefexAbstractMember;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.*;
import javax.xml.bind.annotation.XmlAttribute;
import org.ihtsdo.ttk.dto.component.transformer.ComponentFields;
import org.ihtsdo.ttk.dto.component.transformer.ComponentTransformerBI;

public class TkRefexBooleanMember extends TkRefexAbstractMember<TkRefexBooleanRevision> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlAttribute
   public boolean booleanValue;

   //~--- constructors --------------------------------------------------------

   public TkRefexBooleanMember() {
      super();
   }

   public TkRefexBooleanMember(RefexChronicleBI another) throws IOException {
      super((RefexVersionBI) another.getPrimordialVersion());

      Collection<? extends RefexBooleanVersionBI> refexes   = another.getVersions();
      int                                         partCount = refexes.size();
      Iterator<? extends RefexBooleanVersionBI>   itr       = refexes.iterator();
      RefexBooleanVersionBI                       rv        = itr.next();

      this.booleanValue = rv.getBoolean1();

      if (partCount > 1) {
         revisions = new ArrayList<>(partCount - 1);

         while (itr.hasNext()) {
            rv = itr.next();
            revisions.add(new TkRefexBooleanRevision(rv));
         }
      }
   }

   public TkRefexBooleanMember(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super();
      readExternal(in, dataVersion);
   }

   public TkRefexBooleanMember(TkRefexBooleanMember another, ComponentTransformerBI transformer) {
      super(another, transformer);
      this.booleanValue = transformer.transform(another.booleanValue, another, ComponentFields.REFEX_BOOLEAN1);
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERefsetBooleanMember</tt> object, and contains the same values, field by field,
    * as this <tt>ERefsetBooleanMember</tt>.
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

      if (TkRefexBooleanMember.class.isAssignableFrom(obj.getClass())) {
         TkRefexBooleanMember another = (TkRefexBooleanMember) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare booleanValue
         if (this.booleanValue != another.booleanValue) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   /**
    * Returns a hash code for this <code>ERefsetBooleanMember</code>.
    *
    * @return a hash code value for this <tt>ERefsetBooleanMember</tt>.
    */
   @Override
   public int hashCode() {
      return this.primordialUuid.hashCode();
   }

   @Override
   public TkRefexBooleanMember makeTransform(ComponentTransformerBI transformer) {
      return new TkRefexBooleanMember(this, transformer);
   }

   @Override
   public void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);
      booleanValue = in.readBoolean();

      int versionSize = in.readInt();

      if (versionSize > 0) {
         revisions = new ArrayList<>(versionSize);

         for (int i = 0; i < versionSize; i++) {
            revisions.add(new TkRefexBooleanRevision(in, dataVersion));
         }
      }
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName()).append(": ");
      buff.append(this.booleanValue);
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   @Override
   public void writeExternal(DataOutput out) throws IOException {
      super.writeExternal(out);
      out.writeBoolean(booleanValue);

      if (revisions == null) {
         out.writeInt(0);
      } else {
         out.writeInt(revisions.size());

         for (TkRefexBooleanRevision rmv : revisions) {
            rmv.writeExternal(out);
         }
      }
   }

   //~--- get methods ---------------------------------------------------------

   public boolean getBooleanValue() {
      return booleanValue;
   }

   public List<TkRefexBooleanRevision> getRevisionList() {
      return revisions;
   }

   @Override
   public ToolkitRefexType getType() {
      return ToolkitRefexType.BOOLEAN;
   }

   //~--- set methods ---------------------------------------------------------

   public void setBooleanValue(boolean booleanValue) {
      this.booleanValue = booleanValue;
   }
}
