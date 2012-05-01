package org.ihtsdo.tk.dto.concept.component.refex.type_uuid_float;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.NidBitSetBI;
import org.ihtsdo.tk.api.TerminologyStoreDI;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_float.RefexNidFloatVersionBI;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.*;

public class TkRefexUuidFloatMember extends TkRefexAbstractMember<TkRefexUuidFloatRevision> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   public UUID  uuid1;
   public float floatValue;

   //~--- constructors --------------------------------------------------------

   public TkRefexUuidFloatMember() {
      super();
   }

   public TkRefexUuidFloatMember(RefexChronicleBI another) throws IOException {
      super((RefexVersionBI) another.getPrimordialVersion());

      TerminologyStoreDI                            ts        = Ts.get();
      Collection<? extends RefexNidFloatVersionBI> refexes   = another.getVersions();
      int                                           partCount = refexes.size();
      Iterator<? extends RefexNidFloatVersionBI>   itr       = refexes.iterator();
      RefexNidFloatVersionBI                       rv        = itr.next();

      this.uuid1     = ts.getUuidPrimordialForNid(rv.getNid1());
      this.floatValue = rv.getFloat1();

      if (partCount > 1) {
         revisions = new ArrayList<TkRefexUuidFloatRevision>(partCount - 1);

         while (itr.hasNext()) {
            rv = itr.next();
            revisions.add(new TkRefexUuidFloatRevision(rv));
         }
      }
   }

   public TkRefexUuidFloatMember(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super();
      readExternal(in, dataVersion);
   }

   public TkRefexUuidFloatMember(TkRefexUuidFloatMember another, Map<UUID, UUID> conversionMap, long offset,
                                 boolean mapAll) {
      super(another, conversionMap, offset, mapAll);

      if (mapAll) {
         this.uuid1     = conversionMap.get(another.uuid1);
         this.floatValue = another.floatValue;
      } else {
         this.uuid1     = another.uuid1;
         this.floatValue = another.floatValue;
      }
   }

   public TkRefexUuidFloatMember(RefexNidFloatVersionBI another, NidBitSetBI exclusions,
                                 Map<UUID, UUID> conversionMap, long offset, boolean mapAll,
                                 ViewCoordinate vc)
           throws IOException, ContradictionException {
      super(another, exclusions, conversionMap, offset, mapAll, vc);

      if (mapAll) {
         this.uuid1 = conversionMap.get(Ts.get().getComponent(another.getNid1()).getPrimUuid());
      } else {
         this.uuid1 = Ts.get().getComponent(another.getNid1()).getPrimUuid();
      }

      this.floatValue = another.getFloat1();
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

      if (TkRefexUuidFloatMember.class.isAssignableFrom(obj.getClass())) {
         TkRefexUuidFloatMember another = (TkRefexUuidFloatMember) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare c1Uuid
         if (!this.uuid1.equals(another.uuid1)) {
            return false;
         }

         // Compare floatValue
         if (this.floatValue != another.floatValue) {
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
   public TkRefexUuidFloatMember makeConversion(Map<UUID, UUID> conversionMap, long offset, boolean mapAll) {
      return new TkRefexUuidFloatMember(this, conversionMap, offset, mapAll);
   }

   @Override
   public void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);
      uuid1     = new UUID(in.readLong(), in.readLong());
      floatValue = in.readFloat();

      int versionSize = in.readInt();

      if (versionSize > 0) {
         revisions = new ArrayList<TkRefexUuidFloatRevision>(versionSize);

         for (int i = 0; i < versionSize; i++) {
            revisions.add(new TkRefexUuidFloatRevision(in, dataVersion));
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
      buff.append(this.floatValue);
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   @Override
   public void writeExternal(DataOutput out) throws IOException {
      super.writeExternal(out);
      out.writeLong(uuid1.getMostSignificantBits());
      out.writeLong(uuid1.getLeastSignificantBits());
      out.writeFloat(floatValue);

      if (revisions == null) {
         out.writeInt(0);
      } else {
         out.writeInt(revisions.size());

         for (TkRefexUuidFloatRevision rmv : revisions) {
            rmv.writeExternal(out);
         }
      }
   }

   //~--- get methods ---------------------------------------------------------

   public UUID getUuid1() {
      return uuid1;
   }

   public float getFloatValue() {
      return floatValue;
   }

   @Override
   public List<TkRefexUuidFloatRevision> getRevisionList() {
      return revisions;
   }

   @Override
   public List<TkRefexUuidFloatRevision> getRevisions() {
      return revisions;
   }

   @Override
   public TK_REFEX_TYPE getType() {
      return TK_REFEX_TYPE.CID_FLOAT;
   }

   //~--- set methods ---------------------------------------------------------

   public void setUuid1(UUID uuid1) {
      this.uuid1 = uuid1;
   }

   public void setFloatValue(float floatValue) {
      this.floatValue = floatValue;
   }
}
