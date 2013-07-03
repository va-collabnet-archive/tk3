package org.ihtsdo.ttk.dto.component.refex.type_member;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.NidBitSetBI;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.dto.component.TtkRevision;
import org.ihtsdo.ttk.api.ToolkitRefexType;
import org.ihtsdo.ttk.dto.component.refex.TtkRefexAbstractMember;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import java.util.*;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.refex.type_nid_nid_nid.RefexNidNidNidVersionBI;
import org.ihtsdo.ttk.dto.component.transformer.ComponentTransformerBI;

public class TtkRefexMember extends TtkRefexAbstractMember<TtkRefexRevision> {
   public static final long serialVersionUID = 1;

   //~--- constructors --------------------------------------------------------

   public TtkRefexMember() {
      super();
   }

   public TtkRefexMember(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super();
      readExternal(in, dataVersion);
   }
   public TtkRefexMember(RefexChronicleBI another) throws IOException {
      super((RefexVersionBI) another.getPrimordialVersion());

      Collection<? extends RefexNidNidNidVersionBI> refexes   = another.getVersions();
      int                                              partCount = refexes.size();
      Iterator<? extends RefexNidNidNidVersionBI>   itr       = refexes.iterator();
      RefexNidNidNidVersionBI                       rv        = itr.next();

      if (partCount > 1) {
         revisions = new ArrayList<>(partCount - 1);

         while (itr.hasNext()) {
            rv = itr.next();
            revisions.add(new TtkRefexRevision(rv));
         }
      }
   }

   public TtkRefexMember(TtkRefexMember another, ComponentTransformerBI transformer) {
      super(another, transformer);
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>ERefsetMember</tt> object, and contains the same values, field by field,
    * as this <tt>ERefsetMember</tt>.
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

      if (TtkRefexMember.class.isAssignableFrom(obj.getClass())) {

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   /**
    * Returns a hash code for this <code>ERefsetMember</code>.
    *
    * @return a hash code value for this <tt>ERefsetMember</tt>.
    */
   @Override
   public int hashCode() {
      return this.primordialUuid.hashCode();
   }

   @Override
   public TtkRevision makeTransform(ComponentTransformerBI transformer) {
      return new TtkRefexMember(this, transformer);
   }

   @Override
   public void readExternal(DataInput in, int dataVersion) throws IOException, ClassNotFoundException {
      super.readExternal(in, dataVersion);

      int versionSize = in.readInt();

      if (versionSize > 0) {
         revisions = new ArrayList<>(versionSize);

         for (int i = 0; i < versionSize; i++) {
            revisions.add(new TtkRefexRevision(in, dataVersion));
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
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   @Override
   public void writeExternal(DataOutput out) throws IOException {
      super.writeExternal(out);

      if (revisions == null) {
         out.writeInt(0);
      } else {
         out.writeInt(revisions.size());

         for (TtkRefexRevision rmv : revisions) {
            rmv.writeExternal(out);
         }
      }
   }

   //~--- get methods ---------------------------------------------------------

   public List<TtkRefexRevision> getRevisionList() {
      return revisions;
   }

   @Override
   public ToolkitRefexType getType() {
      return ToolkitRefexType.MEMBER;
   }
}
