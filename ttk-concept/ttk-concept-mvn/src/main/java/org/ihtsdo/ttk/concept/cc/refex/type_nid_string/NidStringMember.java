package org.ihtsdo.ttk.concept.cc.refex.type_nid_string;

//~--- non-JDK imports --------------------------------------------------------

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;

import org.ihtsdo.cern.colt.list.IntArrayList;


import org.ihtsdo.ttk.concept.cc.component.ConceptComponent;
import org.ihtsdo.ttk.concept.cc.component.RevisionSet;
import org.ihtsdo.ttk.concept.cc.refex.RefexMember;
import org.ihtsdo.ttk.concept.cc.computer.version.VersionComputer;
import org.ihtsdo.ttk.api.blueprint.RefexCAB;
import org.ihtsdo.ttk.api.blueprint.RefexProperty;
import org.ihtsdo.ttk.api.refex.type_nid_string.RefexNidStringAnalogBI;
import org.ihtsdo.ttk.api.TK_REFEX_TYPE;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_string.TkRefexUuidStringMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_string.TkRefexUuidStringRevision;
import org.ihtsdo.ttk.api.hash.Hashcode;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyVetoException;

import java.io.IOException;

import java.util.*;
import org.ihtsdo.ttk.concept.cc.P;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_string.RefexNidStringVersionBI;

public class NidStringMember extends RefexMember<NidStringRevision, NidStringMember>
        implements RefexNidStringAnalogBI<NidStringRevision> {
   private static VersionComputer<RefexMember<NidStringRevision, NidStringMember>.Version> computer =
      new VersionComputer<>();

   //~--- fields --------------------------------------------------------------

   private int    c1Nid;
   private String string1;

   //~--- constructors --------------------------------------------------------

   public NidStringMember() {
      super();
   }

   public NidStringMember(int enclosingConceptNid, TupleInput input) throws IOException {
      super(enclosingConceptNid, input);
   }

   public NidStringMember(TkRefexUuidStringMember refsetMember, int enclosingConceptNid) throws IOException {
      super(refsetMember, enclosingConceptNid);
      c1Nid    = P.s.getNidForUuids(refsetMember.getUuid1());
      string1 = refsetMember.getString1();

      if (refsetMember.getRevisionList() != null) {
         revisions = new RevisionSet<>(primordialStamp);

         for (TkRefexUuidStringRevision eVersion : refsetMember.getRevisionList()) {
            revisions.add(new NidStringRevision(eVersion, this));
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
      rcs.with(RefexProperty.COMPONENT_EXTENSION_1_ID, getNid1());
      rcs.with(RefexProperty.STRING_EXTENSION_1, getString1());
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (NidStringMember.class.isAssignableFrom(obj.getClass())) {
         NidStringMember another = (NidStringMember) obj;

         return this.c1Nid == another.c1Nid;
      }

      return false;
   }

   @Override
   public int hashCode() {
      return Hashcode.compute(new int[] { c1Nid });
   }

   @Override
   public NidStringRevision makeAnalog() {
      NidStringRevision newR = new NidStringRevision(getStatusNid(), getTime(), getAuthorNid(), getModuleNid(), getPathNid(), this);

      return newR;
   }

   @Override
   public NidStringRevision makeAnalog(int statusNid, long time, int authorNid, int moduleNid, int pathNid) {
      NidStringRevision newR = new NidStringRevision(statusNid, time, authorNid, moduleNid, pathNid, this);

      addRevision(newR);

      return newR;
   }

   @Override
   protected boolean refexFieldsEqual(ConceptComponent<NidStringRevision, NidStringMember> obj) {
      if (NidStringMember.class.isAssignableFrom(obj.getClass())) {
         NidStringMember another = (NidStringMember) obj;

         return (this.c1Nid == another.c1Nid) && this.string1.equals(another.string1);
      }

      return false;
   }
   
   @Override
    public boolean refexFieldsEqual(RefexVersionBI another) {
        if(RefexNidStringVersionBI.class.isAssignableFrom(another.getClass())){
            RefexNidStringVersionBI cv = (RefexNidStringVersionBI) another;
            return (this.c1Nid == cv.getNid1()) && this.string1.equals(cv.getString1());
        }
        return false;
    }

   @Override
   protected void readMemberFields(TupleInput input) {
      c1Nid    = input.readInt();
      string1 = input.readString();
   }

   @Override
   protected final NidStringRevision readMemberRevision(TupleInput input) {
      return new NidStringRevision(input, this);
   }

   @Override
   public boolean readyToWriteRefsetMember() {
      assert c1Nid != Integer.MAX_VALUE;
      assert string1 != null;

      return true;
   }

   /*
    *  (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuffer buf = new StringBuffer();

      buf.append(this.getClass().getSimpleName()).append(" ");
      buf.append(" c1Nid: ");
      addNidToBuffer(buf, c1Nid);
      buf.append(" strValue:" + "'").append(this.string1).append("'");
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   protected void writeMember(TupleOutput output) {
      output.writeInt(c1Nid);
      output.writeString(string1);
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
   public String getString1() {
      return string1;
   }

   @Override
   protected TK_REFEX_TYPE getTkRefsetType() {
      return TK_REFEX_TYPE.CID_STR;
   }

   @Override
   public int getTypeNid() {
      return TK_REFEX_TYPE.CID_STR.getTypeToken();
   }

   @Override
   public IntArrayList getVariableVersionNids() {
      IntArrayList variableNids = new IntArrayList(3);

      variableNids.add(getNid1());

      return variableNids;
   }

   @Override
   protected VersionComputer<RefexMember<NidStringRevision, NidStringMember>.Version> getVersionComputer() {
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
            for (RefexNidStringAnalogBI r : revisions) {
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
   public void setNid1(int cnid) throws PropertyVetoException {
      this.c1Nid = cnid;
      modified();
   }

   @Override
   public void setString1(String str) throws PropertyVetoException {
      this.string1 = str;
      modified();
   }

   //~--- inner classes -------------------------------------------------------

   public class Version extends RefexMember<NidStringRevision, NidStringMember>.Version
           implements RefexNidStringAnalogBI<NidStringRevision> {
      private Version(RefexNidStringAnalogBI cv) {
         super(cv);
      }

      //~--- methods ----------------------------------------------------------

      //~--- get methods ------------------------------------------------------

        @Override
      public int getNid1() {
         return getCv().getNid1();
      }

      RefexNidStringAnalogBI getCv() {
         return (RefexNidStringAnalogBI) cv;
      }

      @Override
      public TkRefexUuidStringMember getERefsetMember() throws IOException {
         return new TkRefexUuidStringMember(this);
      }

      @Override
      public TkRefexUuidStringRevision getERefsetRevision() throws IOException {
         return new TkRefexUuidStringRevision(this);
      }

      @Override
      public String getString1() {
         return getCv().getString1();
      }

      //~--- set methods ------------------------------------------------------

  
      @Override
      public void setNid1(int c1id) throws PropertyVetoException {
         getCv().setNid1(c1id);
      }

      @Override
      public void setString1(String value) throws PropertyVetoException {
         getCv().setString1(value);
      }
   }
}
