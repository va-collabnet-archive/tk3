package org.ihtsdo.tk.dto.concept.component.refex.type_uuid_string;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.TerminologyStoreDI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_string.RefexNidStringVersionBI;
import org.ihtsdo.tk.dto.concept.UtfHelper;
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

public class TkRefexUuidStringMember extends TkRefexAbstractMember<TkRefexUuidStringRevision> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlAttribute
   public UUID   uuid1;
   @XmlAttribute
   public String string1;

   //~--- constructors --------------------------------------------------------

   public TkRefexUuidStringMember() {
      super();
   }

   public TkRefexUuidStringMember(RefexChronicleBI another) throws IOException {
      super((RefexVersionBI) another.getPrimordialVersion());

      TerminologyStoreDI                          ts        = Ts.get();
      Collection<? extends RefexNidStringVersionBI> refexes   = another.getVersions();
      int                                         partCount = refexes.size();
      Iterator<? extends RefexNidStringVersionBI>   itr       = refexes.iterator();
      RefexNidStringVersionBI                       rv        = itr.next();

      this.uuid1   = ts.getUuidPrimordialForNid(rv.getNid1());
      this.string1 = rv.getString1();

      if (partCount > 1) {
         revisions = new ArrayList<>(partCount - 1);

         while (itr.hasNext()) {
            rv = itr.next();
            revisions.add(new TkRefexUuidStringRevision(rv));
         }
      }
   }

   public TkRefexUuidStringMember(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super();
      readExternal(in, dataVersion);
   }

   public TkRefexUuidStringMember(TkRefexUuidStringMember another, ComponentTransformerBI transformer) {
      super(another, transformer);
      this.uuid1 = transformer.transform(another.uuid1, another, ComponentFields.REFEX_COMPONENT_1_UUID);
      this.string1 = transformer.transform(another.string1, another, ComponentFields.REFEX_STRING1);
   }

   //~--- methods -------------------------------------------------------------

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

      if (TkRefexUuidStringMember.class.isAssignableFrom(obj.getClass())) {
         TkRefexUuidStringMember another = (TkRefexUuidStringMember) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare c1Uuid
         if (!this.uuid1.equals(another.uuid1)) {
            return false;
         }

         // Compare strValue
         if (!this.string1.equals(another.string1)) {
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
   public TkRefexUuidStringMember makeTransform(ComponentTransformerBI transformer) {
      return new TkRefexUuidStringMember(this, transformer);
   }

   @Override
   public final void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);
      uuid1   = new UUID(in.readLong(), in.readLong());
      string1 = UtfHelper.readUtfV7(in, dataVersion);

      int versionSize = in.readInt();

      if (versionSize > 0) {
         revisions = new ArrayList<>(versionSize);

         for (int i = 0; i < versionSize; i++) {
            revisions.add(new TkRefexUuidStringRevision(in, dataVersion));
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
      buff.append("'").append(this.string1).append("'");
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   @Override
   public void writeExternal(DataOutput out) throws IOException {
      super.writeExternal(out);
      out.writeLong(uuid1.getMostSignificantBits());
      out.writeLong(uuid1.getLeastSignificantBits());
      UtfHelper.writeUtf(out, string1);

      if (revisions == null) {
         out.writeInt(0);
      } else {
         out.writeInt(revisions.size());

         for (TkRefexUuidStringRevision rmv : revisions) {
            rmv.writeExternal(out);
         }
      }
   }

   //~--- get methods ---------------------------------------------------------

   public UUID getUuid1() {
      return uuid1;
   }

   @Override
   public List<TkRefexUuidStringRevision> getRevisionList() {
      return revisions;
   }

   @Override
   public List<TkRefexUuidStringRevision> getRevisions() {
      return revisions;
   }

   public String getString1() {
      return string1;
   }

   @Override
   public TK_REFEX_TYPE getType() {
      return TK_REFEX_TYPE.CID_STR;
   }

   //~--- set methods ---------------------------------------------------------

   public void setUuid1(UUID uuid1) {
      this.uuid1 = uuid1;
   }

   public void setString1(String string1) {
      this.string1 = string1;
   }
}
