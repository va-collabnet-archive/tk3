package org.ihtsdo.tk.dto.concept.component.refex.type_long;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_long.RefexLongVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.*;
import javax.xml.bind.annotation.XmlAttribute;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentFields;
import org.ihtsdo.tk.dto.concept.component.transformer.ComponentTransformerBI;

public class TkRefexLongMember extends TkRefexAbstractMember<TkRefexLongRevision> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlAttribute
   public long longValue;

   //~--- constructors --------------------------------------------------------

   public TkRefexLongMember() {
      super();
   }

   public TkRefexLongMember(RefexChronicleBI another) throws IOException {
      super((RefexVersionBI) another.getPrimordialVersion());

      Collection<? extends RefexLongVersionBI> refexes   = another.getVersions();
      int                                      partCount = refexes.size();
      Iterator<? extends RefexLongVersionBI>   itr       = refexes.iterator();
      RefexLongVersionBI                       rv        = itr.next();

      this.longValue = rv.getLong1();

      if (partCount > 1) {
         revisions = new ArrayList<>(partCount - 1);

         while (itr.hasNext()) {
            rv = itr.next();
            revisions.add(new TkRefexLongRevision(rv));
         }
      }
   }

   public TkRefexLongMember(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super();
      readExternal(in, dataVersion);
   }

   public TkRefexLongMember(TkRefexLongMember another, ComponentTransformerBI transformer) {
      super(another, transformer);
      this.longValue = transformer.transform(another.longValue, another, ComponentFields.REFEX_LONG1);
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERefsetLongMember</tt> object, and contains the same values, field by field,
    * as this <tt>ERefsetLongMember</tt>.
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

      if (TkRefexLongMember.class.isAssignableFrom(obj.getClass())) {
         TkRefexLongMember another = (TkRefexLongMember) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare longValue
         if (this.longValue != another.longValue) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   /**
    * Returns a hash code for this <code>ERefsetLongMember</code>.
    *
    * @return a hash code value for this <tt>ERefsetLongMember</tt>.
    */
   @Override
   public int hashCode() {
      return this.primordialUuid.hashCode();
   }

   @Override
   public TkRevision makeTransform(ComponentTransformerBI transformer) {
      return new TkRefexLongMember(this, transformer);
   }

   @Override
   public void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);
      longValue = in.readLong();

      int versionSize = in.readInt();

      if (versionSize > 0) {
         revisions = new ArrayList<>(versionSize);

         for (int i = 0; i < versionSize; i++) {
            revisions.add(new TkRefexLongRevision(in, dataVersion));
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
      buff.append(" long:");
      buff.append(this.longValue);
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   @Override
   public void writeExternal(DataOutput out) throws IOException {
      super.writeExternal(out);
      out.writeLong(longValue);

      if (revisions == null) {
         out.writeInt(0);
      } else {
         out.writeInt(revisions.size());

         for (TkRefexLongRevision rmv : revisions) {
            rmv.writeExternal(out);
         }
      }
   }

   //~--- get methods ---------------------------------------------------------

   public long getLongValue() {
      return longValue;
   }

   public List<TkRefexLongRevision> getRevisionList() {
      return revisions;
   }

   @Override
   public TK_REFEX_TYPE getType() {
      return TK_REFEX_TYPE.LONG;
   }

   //~--- set methods ---------------------------------------------------------

   public void setLongValue(long longValue) {
      this.longValue = longValue;
   }
}
