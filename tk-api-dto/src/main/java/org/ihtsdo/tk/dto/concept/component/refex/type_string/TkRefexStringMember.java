package org.ihtsdo.tk.dto.concept.component.refex.type_string;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.NidBitSetBI;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_string.RefexStringVersionBI;
import org.ihtsdo.tk.dto.concept.UtfHelper;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.*;
import javax.xml.bind.annotation.XmlAttribute;

public class TkRefexStringMember extends TkRefexAbstractMember<TkRefexStringRevision> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   @XmlAttribute
   public String string1;

   //~--- constructors --------------------------------------------------------

   public TkRefexStringMember() {
      super();
   }

   public TkRefexStringMember(RefexChronicleBI another) throws IOException {
      super((RefexVersionBI) another.getPrimordialVersion());

      Collection<? extends RefexStringVersionBI> refexes   = another.getVersions();
      int                                     partCount = refexes.size();
      Iterator<? extends RefexStringVersionBI>   itr       = refexes.iterator();
      RefexStringVersionBI                       rv        = itr.next();

      this.string1 = rv.getString1();

      if (partCount > 1) {
         revisions = new ArrayList<TkRefexStringRevision>(partCount - 1);

         while (itr.hasNext()) {
            rv = itr.next();
            revisions.add(new TkRefexStringRevision(rv));
         }
      }
   }

   public TkRefexStringMember(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super();
      readExternal(in, dataVersion);
   }

   public TkRefexStringMember(TkRefexStringMember another, Map<UUID, UUID> conversionMap, long offset,
                            boolean mapAll) {
      super(another, conversionMap, offset, mapAll);
      this.string1 = another.string1;
   }

   public TkRefexStringMember(RefexStringVersionBI another, NidBitSetBI exclusions, Map<UUID, UUID> conversionMap,
                            long offset, boolean mapAll, ViewCoordinate vc)
           throws IOException, ContradictionException {
      super(another, exclusions, conversionMap, offset, mapAll, vc);
      this.string1 = another.getString1();
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERefsetStrMember</tt> object, and contains the same values, field by field,
    * as this <tt>ERefsetStrMember</tt>.
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

      if (TkRefexStringMember.class.isAssignableFrom(obj.getClass())) {
         TkRefexStringMember another = (TkRefexStringMember) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
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
    * Returns a hash code for this <code>ERefsetStrMember</code>.
    *
    * @return a hash code value for this <tt>ERefsetStrMember</tt>.
    */
   @Override
   public int hashCode() {
      return this.primordialUuid.hashCode();
   }

   @Override
   public TkRefexStringMember makeConversion(Map<UUID, UUID> conversionMap, long offset, boolean mapAll) {
      return new TkRefexStringMember(this, conversionMap, offset, mapAll);
   }

   @Override
   public final void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);
      string1 = UtfHelper.readUtfV6(in, dataVersion);

      int versionSize = in.readInt();

      if (versionSize > 0) {
         revisions = new ArrayList<TkRefexStringRevision>(versionSize);

         for (int i = 0; i < versionSize; i++) {
            revisions.add(new TkRefexStringRevision(in, dataVersion));
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
      buff.append(" str:");
      buff.append("'").append(this.string1).append("'");
      buff.append("; ");
      buff.append(super.toString());

      return buff.toString();
   }

   @Override
   public void writeExternal(DataOutput out) throws IOException {
      super.writeExternal(out);
      UtfHelper.writeUtf(out, string1);

      if (revisions == null) {
         out.writeInt(0);
      } else {
         out.writeInt(revisions.size());

         for (TkRefexStringRevision rmv : revisions) {
            rmv.writeExternal(out);
         }
      }
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public List<TkRefexStringRevision> getRevisionList() {
      return revisions;
   }

   public String getString1() {
      return string1;
   }

   @Override
   public TK_REFEX_TYPE getType() {
      return TK_REFEX_TYPE.STR;
   }

   //~--- set methods ---------------------------------------------------------

   public void setString1(String string1) {
      this.string1 = string1;
   }
}
