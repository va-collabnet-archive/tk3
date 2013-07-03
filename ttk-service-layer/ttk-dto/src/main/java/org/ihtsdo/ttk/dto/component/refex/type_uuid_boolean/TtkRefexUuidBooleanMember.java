package org.ihtsdo.ttk.dto.component.refex.type_uuid_boolean;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.ToolkitRefexType;
import org.ihtsdo.ttk.api.TerminologyStoreDI;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_boolean.RefexNidBooleanVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_string.RefexNidStringVersionBI;
import org.ihtsdo.ttk.dto.UtfHelper;
import org.ihtsdo.ttk.dto.component.refex.TtkRefexAbstractMember;
import org.ihtsdo.ttk.dto.component.transformer.ComponentFields;
import org.ihtsdo.ttk.dto.component.transformer.ComponentTransformerBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.*;

import javax.xml.bind.annotation.XmlAttribute;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid_string.TtkRefexUuidUuidUuidStringMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid_string.TtkRefexUuidUuidUuidStringRevision;

public class TtkRefexUuidBooleanMember extends TtkRefexAbstractMember<TtkRefexUuidBooleanRevision> {
   public static final long serialVersionUID = 1;
   @XmlAttribute
   public UUID              uuid1;
   @XmlAttribute
   public Boolean           boolean1;

   public TtkRefexUuidBooleanMember() {
      super();
   }

   public TtkRefexUuidBooleanMember(RefexChronicleBI another) throws IOException {
      super((RefexVersionBI) another.getPrimordialVersion());

      TerminologyStoreDI                             ts        = Ts.get();
      Collection<? extends RefexNidBooleanVersionBI> refexes   = another.getVersions();
      int                                            partCount = refexes.size();
      Iterator<? extends RefexNidBooleanVersionBI>   itr       = refexes.iterator();
      RefexNidBooleanVersionBI                       rv        = itr.next();

      this.uuid1    = ts.getUuidPrimordialForNid(rv.getNid1());
      this.boolean1 = rv.getBoolean1();

      if (partCount > 1) {
         revisions = new ArrayList<>(partCount - 1);

         while (itr.hasNext()) {
            rv = itr.next();
            revisions.add(new TtkRefexUuidBooleanRevision(rv));
         }
      }
   }

   public TtkRefexUuidBooleanMember(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super();
      readExternal(in, dataVersion);
   }

   public TtkRefexUuidBooleanMember(TtkRefexUuidBooleanMember another, ComponentTransformerBI transformer) {
      super(another, transformer);
      this.uuid1    = transformer.transform(another.uuid1, another, ComponentFields.REFEX_COMPONENT_1_UUID);
      this.boolean1 = transformer.transform(another.boolean1, another, ComponentFields.REFEX_STRING1);
   }

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERefsetCidStrMember</tt> object, and contains the same values, field by field,
    * as this <tt>ERefsetCidStrMember</tt>.
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

      if (TtkRefexUuidBooleanMember.class.isAssignableFrom(obj.getClass())) {
         TtkRefexUuidBooleanMember another = (TtkRefexUuidBooleanMember) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare c1Uuid
         if (!this.uuid1.equals(another.uuid1)) {
            return false;
         }

         // Compare strValue
         if (!this.boolean1.equals(another.boolean1)) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   /**
    * Returns a hash code for this <code>ERefsetCidStrMember</code>.
    *
    * @return a hash code value for this <tt>ERefsetCidStrMember</tt>.
    */
   @Override
   public int hashCode() {
      return this.primordialUuid.hashCode();
   }

   @Override
   public TtkRefexUuidBooleanMember makeTransform(ComponentTransformerBI transformer) {
      return new TtkRefexUuidBooleanMember(this, transformer);
   }

   @Override
   public final void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);
      uuid1    = new UUID(in.readLong(), in.readLong());
      boolean1 = in.readBoolean();

      int versionSize = in.readInt();

      if (versionSize > 0) {
         revisions = new ArrayList<>(versionSize);

         for (int i = 0; i < versionSize; i++) {
            revisions.add(new TtkRefexUuidBooleanRevision(in, dataVersion));
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
      buff.append(" str:");
      buff.append("'").append(this.boolean1).append("'");
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   @Override
   public void writeExternal(DataOutput out) throws IOException {
      super.writeExternal(out);
      out.writeLong(uuid1.getMostSignificantBits());
      out.writeLong(uuid1.getLeastSignificantBits());
      out.writeBoolean(boolean1);

      if (revisions == null) {
         out.writeInt(0);
      } else {
         out.writeInt(revisions.size());

         for (TtkRefexUuidBooleanRevision rmv : revisions) {
            rmv.writeExternal(out);
         }
      }
   }

   public Boolean getBoolean1() {
      return boolean1;
   }

   @Override
   public List<TtkRefexUuidBooleanRevision> getRevisionList() {
      return revisions;
   }

   @Override
   public List<TtkRefexUuidBooleanRevision> getRevisions() {
      return revisions;
   }

   @Override
   public ToolkitRefexType getType() {
      return ToolkitRefexType.CID_STR;
   }

   public UUID getUuid1() {
      return uuid1;
   }

   public void setBoolean1(Boolean boolean1) {
      this.boolean1 = boolean1;
   }

   public void setUuid1(UUID uuid1) {
      this.uuid1 = uuid1;
   }
}
