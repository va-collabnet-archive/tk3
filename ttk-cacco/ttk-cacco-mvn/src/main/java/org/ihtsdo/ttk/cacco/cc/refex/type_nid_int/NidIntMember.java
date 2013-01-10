package org.ihtsdo.ttk.cacco.cc.refex.type_nid_int;

//~--- non-JDK imports --------------------------------------------------------

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;

import org.ihtsdo.cern.colt.list.IntArrayList;


import org.ihtsdo.ttk.cacco.cc.component.ConceptComponent;
import org.ihtsdo.ttk.cacco.cc.component.RevisionSet;
import org.ihtsdo.ttk.cacco.cc.refex.RefexMember;
import org.ihtsdo.ttk.cacco.cc.computer.version.VersionComputer;
import org.ihtsdo.ttk.api.blueprint.RefexCAB;
import org.ihtsdo.ttk.api.blueprint.RefexCAB.RefexProperty;
import org.ihtsdo.ttk.api.refex.type_nid_int.RefexNidIntAnalogBI;
import org.ihtsdo.ttk.api.TK_REFEX_TYPE;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_int.TkRefexUuidIntMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_int.TkRefexUuidIntRevision;
import org.ihtsdo.ttk.api.hash.Hashcode;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyVetoException;

import java.io.IOException;

import java.util.*;
import org.ihtsdo.ttk.cacco.cc.P;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_int.RefexNidIntVersionBI;

public class NidIntMember extends RefexMember<NidIntRevision, NidIntMember>
        implements RefexNidIntAnalogBI<NidIntRevision> {
   private static VersionComputer<RefexMember<NidIntRevision, NidIntMember>.Version> computer =
      new VersionComputer<>();

   //~--- fields --------------------------------------------------------------

   private int c1Nid;
   private int intValue;

   //~--- constructors --------------------------------------------------------

   public NidIntMember() {
      super();
   }

   public NidIntMember(int enclosingConceptNid, TupleInput input) throws IOException {
      super(enclosingConceptNid, input);
   }

   public NidIntMember(TkRefexUuidIntMember refsetMember, int enclosingConceptNid) throws IOException {
      super(refsetMember, enclosingConceptNid);
      c1Nid    = P.s.getNidForUuids(refsetMember.getUuid1());
      intValue = refsetMember.getInt1();

      if (refsetMember.getRevisionList() != null) {
         revisions = new RevisionSet<>(primordialStamp);

         for (TkRefexUuidIntRevision eVersion : refsetMember.getRevisionList()) {
            revisions.add(new NidIntRevision(eVersion, this));
         }
      }
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected void addRefsetTypeNids(Set<Integer> allNids) {
      allNids.add(c1Nid);
   }

   @Override
   protected void addSpecProperties(RefexCAB rcs) {
      rcs.with(RefexProperty.CNID1, getNid1());
      rcs.with(RefexProperty.INTEGER1, getInt1());
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (NidIntMember.class.isAssignableFrom(obj.getClass())) {
         NidIntMember another = (NidIntMember) obj;

         if (super.equals(another)) {
            return (this.c1Nid == another.c1Nid) && (this.intValue == another.intValue);
         }
      }

      return false;
   }

   @Override
   public int hashCode() {
      return Hashcode.compute(new int[] { c1Nid });
   }

   @Override
   public NidIntRevision makeAnalog() {
      NidIntRevision newR = new NidIntRevision(getStatusNid(), getTime(), getAuthorNid(), getModuleNid(), getPathNid(), this);

      return newR;
   }

   @Override
   public NidIntRevision makeAnalog(int statusNid, long time, int authorNid, int moduleNid, int pathNid) {
      NidIntRevision newR = new NidIntRevision(statusNid, time, authorNid, moduleNid, pathNid, this);

      addRevision(newR);

      return newR;
   }

   @Override
   protected boolean refexFieldsEqual(ConceptComponent<NidIntRevision, NidIntMember> obj) {
      if (NidIntMember.class.isAssignableFrom(obj.getClass())) {
         NidIntMember another = (NidIntMember) obj;

         return (this.c1Nid == another.c1Nid) && (this.intValue == another.intValue);
      }

      return false;
   }
   
   @Override
    public boolean refexFieldsEqual(RefexVersionBI another) {
        if(RefexNidIntVersionBI.class.isAssignableFrom(another.getClass())){
            RefexNidIntVersionBI cv = (RefexNidIntVersionBI) another;
            return (this.c1Nid == cv.getNid1()) && (this.intValue == cv.getInt1());
        }
        return false;
    }

   @Override
   protected void readMemberFields(TupleInput input) {
      c1Nid    = input.readInt();
      intValue = input.readInt();
   }

   @Override
   protected final NidIntRevision readMemberRevision(TupleInput input) {
      return new NidIntRevision(input, this);
   }

   @Override
   public boolean readyToWriteRefsetMember() {
      assert c1Nid != Integer.MAX_VALUE;

      return true;
   }

   /*
    *  (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuffer buf = new StringBuffer();

      buf.append(this.getClass().getSimpleName()).append(":{");
      buf.append("c1Nid: ");
      ConceptComponent.addNidToBuffer(buf, c1Nid);
      buf.append(" intValue: ").append(this.intValue);
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   protected void writeMember(TupleOutput output) {
      output.writeInt(c1Nid);
      output.writeInt(intValue);
   }

   //~--- get methods ---------------------------------------------------------

   public int getC1Nid() {
      return c1Nid;
   }

   @Override
   public int getNid1() {
      return c1Nid;
   }

   @Override
   public int getInt1() {
      return intValue;
   }

   @Override
   protected TK_REFEX_TYPE getTkRefsetType() {
      return TK_REFEX_TYPE.CID_INT;
   }

   @Override
   public int getTypeNid() {
      return TK_REFEX_TYPE.CID_INT.getTypeToken();
   }

   @Override
   public IntArrayList getVariableVersionNids() {
      IntArrayList variableNids = new IntArrayList(3);

      variableNids.add(getC1Nid());

      return variableNids;
   }

   @Override
   protected VersionComputer<RefexMember<NidIntRevision, NidIntMember>.Version> getVersionComputer() {
      return computer;
   }

   @SuppressWarnings("unchecked")
   @Override
   public List<Version> getVersions() {
      if (versions == null) {
         int count = 1;

         if (revisions != null) {
            count = count + revisions.size();
         }

         ArrayList<Version> list = new ArrayList<>(count);

         if (getTime() != Long.MIN_VALUE) {
            list.add(new Version(this));
         }

         if (revisions != null) {
            for (NidIntRevision r : revisions) {
               if (r.getTime() != Long.MIN_VALUE) {
                  list.add(new Version(r));
               }
            }
         }

         versions = list;
      }

      return (List<Version>) versions;
   }

   //~--- set methods ---------------------------------------------------------

   public void setC1Nid(int c1Nid) {
      this.c1Nid = c1Nid;
      modified();
   }

   @Override
   public void setNid1(int cnid1) throws PropertyVetoException {
      this.c1Nid = cnid1;
      modified();
   }

   @Override
   public void setInt1(int l) throws PropertyVetoException {
      this.intValue = l;
      modified();
   }

   //~--- inner classes -------------------------------------------------------

   public class Version extends RefexMember<NidIntRevision, NidIntMember>.Version
           implements RefexNidIntAnalogBI<NidIntRevision> {
      private Version(RefexNidIntAnalogBI cv) {
         super(cv);
      }

      //~--- methods ----------------------------------------------------------

      //~--- get methods ------------------------------------------------------

  
      @Override
      public int getNid1() {
         return getCv().getNid1();
      }

      RefexNidIntAnalogBI getCv() {
         return (RefexNidIntAnalogBI) cv;
      }

      @Override
      public TkRefexUuidIntMember getERefsetMember() throws IOException {
         return new TkRefexUuidIntMember(this);
      }

      @Override
      public TkRefexUuidIntRevision getERefsetRevision() throws IOException {
         return new TkRefexUuidIntRevision(this);
      }

      @Override
      public int getInt1() {
         return getCv().getInt1();
      }

      //~--- set methods ------------------------------------------------------

      @Override
      public void setNid1(int cnid1) throws PropertyVetoException {
         getCv().setNid1(cnid1);
      }

      @Override
      public void setInt1(int i) throws PropertyVetoException {
         getCv().setInt1(i);
      }
   }
}
