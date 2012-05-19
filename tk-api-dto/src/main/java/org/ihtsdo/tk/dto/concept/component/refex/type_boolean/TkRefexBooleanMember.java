package org.ihtsdo.tk.dto.concept.component.refex.type_boolean;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.NidBitSetBI;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_boolean.RefexBooleanVersionBI;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.*;
import javax.xml.bind.annotation.XmlAttribute;

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
         revisions = new ArrayList<TkRefexBooleanRevision>(partCount - 1);

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

   public TkRefexBooleanMember(TkRefexBooleanMember another, Map<UUID, UUID> conversionMap, long offset,
                                boolean mapAll) {
      super(another, conversionMap, offset, mapAll);
      this.booleanValue = another.booleanValue;
   }

   public TkRefexBooleanMember(RefexBooleanVersionBI another, NidBitSetBI exclusions,
                                Map<UUID, UUID> conversionMap, long offset, boolean mapAll, ViewCoordinate vc)
           throws IOException, ContradictionException {
      super(another, exclusions, conversionMap, offset, mapAll, vc);
      this.booleanValue = another.getBoolean1();
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
   public TkRefexBooleanMember makeConversion(Map<UUID, UUID> conversionMap, long offset, boolean mapAll) {
      return new TkRefexBooleanMember(this, conversionMap, offset, mapAll);
   }

   @Override
   public void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);
      booleanValue = in.readBoolean();

      int versionSize = in.readInt();

      if (versionSize > 0) {
         revisions = new ArrayList<TkRefexBooleanRevision>(versionSize);

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
   public TK_REFEX_TYPE getType() {
      return TK_REFEX_TYPE.BOOLEAN;
   }

   //~--- set methods ---------------------------------------------------------

   public void setBooleanValue(boolean booleanValue) {
      this.booleanValue = booleanValue;
   }
}
