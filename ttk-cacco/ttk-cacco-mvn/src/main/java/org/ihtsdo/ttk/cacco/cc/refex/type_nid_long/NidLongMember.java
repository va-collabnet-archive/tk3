package org.ihtsdo.ttk.cacco.cc.refex.type_nid_long;

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
import org.ihtsdo.ttk.api.refex.type_nid_long.RefexNidLongAnalogBI;
import org.ihtsdo.ttk.api.TK_REFEX_TYPE;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_long.TkRefexUuidLongMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_long.TkRefexUuidLongRevision;
import org.ihtsdo.ttk.api.hash.Hashcode;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyVetoException;

import java.io.IOException;

import java.util.*;
import org.ihtsdo.ttk.cacco.cc.P;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_long.RefexNidLongVersionBI;

public class NidLongMember extends RefexMember<NidLongRevision, NidLongMember>
        implements RefexNidLongAnalogBI<NidLongRevision> {
   private static VersionComputer<RefexMember<NidLongRevision, NidLongMember>.Version> computer =
      new VersionComputer<>();

   //~--- fields --------------------------------------------------------------

   private int  c1Nid;
   private long longValue;

   //~--- constructors --------------------------------------------------------

   public NidLongMember() {
      super();
   }

   public NidLongMember(int enclosingConceptNid, TupleInput input) throws IOException {
      super(enclosingConceptNid, input);
   }

   public NidLongMember(TkRefexUuidLongMember refsetMember, int enclosingConceptNid) throws IOException {
      super(refsetMember, enclosingConceptNid);
      c1Nid     = P.s.getNidForUuids(refsetMember.getUuid1());
      longValue = refsetMember.getLong1();

      if (refsetMember.getRevisionList() != null) {
         revisions = new RevisionSet<>(primordialStamp);

         for (TkRefexUuidLongRevision eVersion : refsetMember.getRevisionList()) {
            revisions.add(new NidLongRevision(eVersion, this));
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
      rcs.with(RefexProperty.LONG1, getLong1());
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (NidLongMember.class.isAssignableFrom(obj.getClass())) {
         NidLongMember another = (NidLongMember) obj;

         return this.c1Nid == another.c1Nid;
      }

      return false;
   }

   @Override
   public int hashCode() {
      return Hashcode.compute(new int[] { c1Nid });
   }

   @Override
   public NidLongRevision makeAnalog() {
      NidLongRevision newR = new NidLongRevision(getStatusNid(), getTime(), getAuthorNid(), getModuleNid(), getPathNid(), this);

      return newR;
   }

   @Override
   public NidLongRevision makeAnalog(int statusNid, long time, int authorNid, int moduleNid, int pathNid) {
      NidLongRevision newR = new NidLongRevision(statusNid, time, authorNid, moduleNid, pathNid, this);

      addRevision(newR);

      return newR;
   }

   @Override
   protected boolean refexFieldsEqual(ConceptComponent<NidLongRevision, NidLongMember> obj) {
      if (NidLongMember.class.isAssignableFrom(obj.getClass())) {
         NidLongMember another = (NidLongMember) obj;

         return (this.c1Nid == another.c1Nid) && (this.longValue == another.longValue);
      }

      return false;
   }
   
   @Override
    public boolean refexFieldsEqual(RefexVersionBI another) {
        if(RefexNidLongVersionBI.class.isAssignableFrom(another.getClass())){
            RefexNidLongVersionBI cv = (RefexNidLongVersionBI) another;
            return (this.c1Nid == cv.getNid1()) && (this.longValue == cv.getLong1());
        }
        return false;
    }

   @Override
   protected void readMemberFields(TupleInput input) {
      c1Nid     = input.readInt();
      longValue = input.readLong();
   }

   @Override
   protected final NidLongRevision readMemberRevision(TupleInput input) {
      return new NidLongRevision(input, this);
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
      buf.append(" c1Nid: ");
      addNidToBuffer(buf, c1Nid);
      buf.append(" longValue:").append(this.longValue);
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   protected void writeMember(TupleOutput output) {
      output.writeInt(c1Nid);
      output.writeLong(longValue);
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
   public long getLong1() {
      return this.longValue;
   }

   public long getLongValue() {
      return longValue;
   }

   @Override
   protected TK_REFEX_TYPE getTkRefsetType() {
      return TK_REFEX_TYPE.CID_LONG;
   }

   @Override
   public int getTypeNid() {
      return TK_REFEX_TYPE.CID_LONG.getTypeToken();
   }

   @Override
   public IntArrayList getVariableVersionNids() {
      IntArrayList variableNids = new IntArrayList(3);

      variableNids.add(getC1Nid());

      return variableNids;
   }

   @Override
   protected VersionComputer<RefexMember<NidLongRevision, NidLongMember>.Version> getVersionComputer() {
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
            for (NidLongRevision r : revisions) {
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
   public void setLong1(long l) throws PropertyVetoException {
      this.longValue = l;
      modified();
   }

   public void setLongValue(long longValue) {
      this.longValue = longValue;
      modified();
   }

   //~--- inner classes -------------------------------------------------------

   public class Version extends RefexMember<NidLongRevision, NidLongMember>.Version
           implements RefexNidLongAnalogBI<NidLongRevision> {
      private Version(RefexNidLongAnalogBI cv) {
         super(cv);
      }

      //~--- methods ----------------------------------------------------------


      //~--- get methods ------------------------------------------------------

      @Override
      public int getNid1() {
         return getCv().getNid1();
      }

      RefexNidLongAnalogBI getCv() {
         return (RefexNidLongAnalogBI) cv;
      }

      @Override
      public TkRefexUuidLongMember getERefsetMember() throws IOException {
         return new TkRefexUuidLongMember(this);
      }

      @Override
      public TkRefexUuidLongRevision getERefsetRevision() throws IOException {
         return new TkRefexUuidLongRevision(this);
      }

      @Override
      public long getLong1() {
         return getCv().getLong1();
      }

      //~--- set methods ------------------------------------------------------

      @Override
      public void setNid1(int cnid1) throws PropertyVetoException {
         getCv().setNid1(cnid1);
      }

      @Override
      public void setLong1(long l) throws PropertyVetoException {
         getCv().setLong1(l);
      }
   }
}
