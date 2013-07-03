package org.ihtsdo.ttk.dto.component.refex.type_uuid_float;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.TerminologyStoreDI;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_float.RefexNidFloatVersionBI;
import org.ihtsdo.ttk.api.ToolkitRefexType;
import org.ihtsdo.ttk.dto.component.refex.TtkRefexAbstractMember;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.*;
import javax.xml.bind.annotation.XmlAttribute;
import org.ihtsdo.ttk.dto.component.transformer.ComponentFields;
import org.ihtsdo.ttk.dto.component.transformer.ComponentTransformerBI;

public class TtkRefexUuidFloatMember extends TtkRefexAbstractMember<TtkRefexUuidFloatRevision> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlAttribute
   public UUID  uuid1;
   @XmlAttribute
   public float float1;

   //~--- constructors --------------------------------------------------------

   public TtkRefexUuidFloatMember() {
      super();
   }

   public TtkRefexUuidFloatMember(RefexChronicleBI another) throws IOException {
      super((RefexVersionBI) another.getPrimordialVersion());

      TerminologyStoreDI                            ts        = Ts.get();
      Collection<? extends RefexNidFloatVersionBI> refexes   = another.getVersions();
      int                                           partCount = refexes.size();
      Iterator<? extends RefexNidFloatVersionBI>   itr       = refexes.iterator();
      RefexNidFloatVersionBI                       rv        = itr.next();

      this.uuid1     = ts.getUuidPrimordialForNid(rv.getNid1());
      this.float1 = rv.getFloat1();

      if (partCount > 1) {
         revisions = new ArrayList<>(partCount - 1);

         while (itr.hasNext()) {
            rv = itr.next();
            revisions.add(new TtkRefexUuidFloatRevision(rv));
         }
      }
   }

   public TtkRefexUuidFloatMember(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super();
      readExternal(in, dataVersion);
   }

   public TtkRefexUuidFloatMember(TtkRefexUuidFloatMember another, ComponentTransformerBI transformer) {
      super(another, transformer);

      this.uuid1 = transformer.transform(another.uuid1, another, ComponentFields.REFEX_COMPONENT_1_UUID);
      this.float1 = transformer.transform(another.float1, another, ComponentFields.REFEX_FLOAT1);
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERefsetCidFloatMember</tt> object, and contains the same values, field by field,
    * as this <tt>ERefsetCidFloatMember</tt>.
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

      if (TtkRefexUuidFloatMember.class.isAssignableFrom(obj.getClass())) {
         TtkRefexUuidFloatMember another = (TtkRefexUuidFloatMember) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare c1Uuid
         if (!this.uuid1.equals(another.uuid1)) {
            return false;
         }

         // Compare floatValue
         if (this.float1 != another.float1) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   /**
    * Returns a hash code for this <code>ERefsetCidFloatMember</code>.
    *
    * @return a hash code value for this <tt>ERefsetCidFloatMember</tt>.
    */
   @Override
   public int hashCode() {
      return this.primordialUuid.hashCode();
   }

   @Override
   public TtkRefexUuidFloatMember makeTransform(ComponentTransformerBI transformer) {
      return new TtkRefexUuidFloatMember(this, transformer);
   }

   @Override
   public void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);
      uuid1     = new UUID(in.readLong(), in.readLong());
      float1 = in.readFloat();

      int versionSize = in.readInt();

      if (versionSize > 0) {
         revisions = new ArrayList<>(versionSize);

         for (int i = 0; i < versionSize; i++) {
            revisions.add(new TtkRefexUuidFloatRevision(in, dataVersion));
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
      buff.append(" c1:");
      buff.append(informAboutUuid(this.uuid1));
      buff.append(" flt:");
      buff.append(this.float1);
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   @Override
   public void writeExternal(DataOutput out) throws IOException {
      super.writeExternal(out);
      out.writeLong(uuid1.getMostSignificantBits());
      out.writeLong(uuid1.getLeastSignificantBits());
      out.writeFloat(float1);

      if (revisions == null) {
         out.writeInt(0);
      } else {
         out.writeInt(revisions.size());

         for (TtkRefexUuidFloatRevision rmv : revisions) {
            rmv.writeExternal(out);
         }
      }
   }

   //~--- get methods ---------------------------------------------------------

   public UUID getUuid1() {
      return uuid1;
   }

   public float getFloatValue() {
      return float1;
   }

   @Override
   public List<TtkRefexUuidFloatRevision> getRevisionList() {
      return revisions;
   }

   @Override
   public List<TtkRefexUuidFloatRevision> getRevisions() {
      return revisions;
   }

   @Override
   public ToolkitRefexType getType() {
      return ToolkitRefexType.CID_FLOAT;
   }

   //~--- set methods ---------------------------------------------------------

   public void setUuid1(UUID uuid1) {
      this.uuid1 = uuid1;
   }

   public void setFloatValue(float floatValue) {
      this.float1 = floatValue;
   }
}
