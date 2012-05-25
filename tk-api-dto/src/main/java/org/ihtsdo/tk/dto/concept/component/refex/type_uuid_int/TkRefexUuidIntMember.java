package org.ihtsdo.tk.dto.concept.component.refex.type_uuid_int;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.NidBitSetBI;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.refex.type_nid_int.RefexNidIntVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.*;
import javax.xml.bind.annotation.XmlAttribute;
import org.ihtsdo.tk.api.TerminologyStoreDI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;

public class TkRefexUuidIntMember extends TkRefexAbstractMember<TkRefexUuidIntRevision> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlAttribute
   public UUID uuid1;
   @XmlAttribute
   public int  int1;

   //~--- constructors --------------------------------------------------------

   public TkRefexUuidIntMember(RefexChronicleBI another) throws IOException {
      super((RefexVersionBI) another.getPrimordialVersion());

      TerminologyStoreDI                               ts        = Ts.get();
      Collection<? extends RefexNidIntVersionBI> refexes      = another.getVersions();
      int                                              partCount = refexes.size();
      Iterator<? extends RefexNidIntVersionBI>   relItr    = refexes.iterator();
      RefexNidIntVersionBI                       rv        = relItr.next();

      this.uuid1 = ts.getUuidPrimordialForNid(rv.getNid1());
      this.int1 = rv.getInt1();
 
      if (partCount > 1) {
         revisions = new ArrayList<>(partCount - 1);

         while (relItr.hasNext()) {
            rv = relItr.next();
            revisions.add(new TkRefexUuidIntRevision(rv));
         }
      }
   }


   public TkRefexUuidIntMember() {
      super();
   }

   public TkRefexUuidIntMember(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super();
      readExternal(in, dataVersion);
   }

   public TkRefexUuidIntMember(TkRefexUuidIntMember another, Map<UUID, UUID> conversionMap, long offset,
                               boolean mapAll) {
      super(another, conversionMap, offset, mapAll);

      if (mapAll) {
         this.uuid1   = conversionMap.get(another.uuid1);
         this.int1 = another.int1;
      } else {
         this.uuid1   = another.uuid1;
         this.int1 = another.int1;
      }
   }

   public TkRefexUuidIntMember(RefexNidIntVersionBI another, NidBitSetBI exclusions,
                               Map<UUID, UUID> conversionMap, long offset, boolean mapAll, ViewCoordinate vc)
           throws IOException, ContradictionException {
      super(another, exclusions, conversionMap, offset, mapAll, vc);

      if (mapAll) {
         this.uuid1 = conversionMap.get(Ts.get().getComponent(another.getNid1()).getPrimUuid());
      } else {
         this.uuid1 = Ts.get().getComponent(another.getNid1()).getPrimUuid();
      }

      this.int1 = another.getInt1();
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERefsetCidIntMember</tt> object, and contains the same values,
    * field by field, as this <tt>ERefsetCidIntMember</tt>.
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

      if (TkRefexUuidIntMember.class.isAssignableFrom(obj.getClass())) {
         TkRefexUuidIntMember another = (TkRefexUuidIntMember) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare c1Uuid
         if (!this.uuid1.equals(another.uuid1)) {
            return false;
         }

         // Compare intValue
         if (this.int1 != another.int1) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   /**
    * Returns a hash code for this <code>ERefsetCidIntMember</code>.
    *
    * @return  a hash code value for this <tt>ERefsetCidIntMember</tt>.
    */
   @Override
   public int hashCode() {
      return this.primordialUuid.hashCode();
   }

   @Override
   public TkRevision makeConversion(Map<UUID, UUID> conversionMap, long offset, boolean mapAll) {
      return new TkRefexUuidIntMember(this, conversionMap, offset, mapAll);
   }

   @Override
   public void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);
      uuid1   = new UUID(in.readLong(), in.readLong());
      int1 = in.readInt();

      int versionSize = in.readInt();

      if (versionSize > 0) {
         revisions = new ArrayList<>(versionSize);

         for (int i = 0; i < versionSize; i++) {
            revisions.add(new TkRefexUuidIntRevision(in, dataVersion));
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
      buff.append(" int:");
      buff.append(this.int1);
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   @Override
   public void writeExternal(DataOutput out) throws IOException {
      super.writeExternal(out);
      out.writeLong(uuid1.getMostSignificantBits());
      out.writeLong(uuid1.getLeastSignificantBits());
      out.writeInt(int1);

      if (revisions == null) {
         out.writeInt(0);
      } else {
         out.writeInt(revisions.size());

         for (TkRefexUuidIntRevision rmv : revisions) {
            rmv.writeExternal(out);
         }
      }
   }

   //~--- get methods ---------------------------------------------------------

   public UUID getUuid1() {
      return uuid1;
   }

   public int getInt1() {
      return int1;
   }

   @Override
   public List<TkRefexUuidIntRevision> getRevisionList() {
      return revisions;
   }

   @Override
   public TK_REFEX_TYPE getType() {
      return TK_REFEX_TYPE.CID_INT;
   }

   //~--- set methods ---------------------------------------------------------

   public void setUuid1(UUID uuid1) {
      this.uuid1 = uuid1;
   }

   public void setInt1(int int1) {
      this.int1 = int1;
   }
}
