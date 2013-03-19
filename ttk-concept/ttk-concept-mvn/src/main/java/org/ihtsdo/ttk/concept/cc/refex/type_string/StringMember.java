package org.ihtsdo.ttk.concept.cc.refex.type_string;

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
import org.ihtsdo.ttk.api.refex.type_string.RefexStringAnalogBI;
import org.ihtsdo.ttk.api.TK_REFEX_TYPE;
import org.ihtsdo.ttk.dto.component.refex.type_string.TkRefexStringMember;
import org.ihtsdo.ttk.dto.component.refex.type_string.TkRefexStringRevision;
import org.ihtsdo.ttk.api.hash.Hashcode;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyVetoException;

import java.io.IOException;

import java.util.*;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.refex.type_string.RefexStringVersionBI;

public class StringMember extends RefexMember<StringRevision, StringMember>
        implements RefexStringAnalogBI<StringRevision> {
   private static VersionComputer<RefexMember<StringRevision, StringMember>.Version> computer =
      new VersionComputer<>();

   //~--- fields --------------------------------------------------------------

   private String stringValue;

   //~--- constructors --------------------------------------------------------

   public StringMember() {
      super();
   }

   public StringMember(int enclosingConceptNid, TupleInput input) throws IOException {
      super(enclosingConceptNid, input);
   }

   public StringMember(TkRefexStringMember refsetMember, int enclosingConceptNid) throws IOException {
      super(refsetMember, enclosingConceptNid);
      stringValue = refsetMember.getString1();

      if (refsetMember.getRevisionList() != null) {
         revisions = new RevisionSet<>(primordialStamp);

         for (TkRefexStringRevision eVersion : refsetMember.getRevisionList()) {
            revisions.add(new StringRevision(eVersion, this));
         }
      }
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected void addRefsetTypeNids(Set<Integer> allNids) {

      //
   }

   @Override
   protected void addSpecProperties(RefexCAB rcs) {
      rcs.with(RefexProperty.STRING_EXTENSION_1, getString1());
   }
   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (StringMember.class.isAssignableFrom(obj.getClass())) {
         StringMember another = (StringMember) obj;

         return this.nid == another.nid;
      }

      return false;
   }

   @Override
   public int hashCode() {
      return Hashcode.compute(new int[] { this.nid });
   }

   @Override
   public StringRevision makeAnalog() {
      StringRevision newR = new StringRevision(getStatusNid(), getTime(), getAuthorNid(), getModuleNid(), getPathNid(), this);
      return newR;
   }

   @Override
   public StringRevision makeAnalog(int statusNid, long time, int authorNid, int moduleNid, int pathNid) {
      StringRevision newR = new StringRevision(statusNid, time, authorNid, moduleNid, pathNid, this);

      addRevision(newR);

      return newR;
   }

   @Override
   protected boolean refexFieldsEqual(ConceptComponent<StringRevision, StringMember> obj) {
      if (StringMember.class.isAssignableFrom(obj.getClass())) {
         StringMember another = (StringMember) obj;

         return this.stringValue.equals(another.stringValue);
      }

      return false;
   }
   
   
   @Override
    public boolean refexFieldsEqual(RefexVersionBI another) {
        if(RefexStringVersionBI.class.isAssignableFrom(another.getClass())){
            RefexStringVersionBI sv = (RefexStringVersionBI) another;
            return this.stringValue.equals(sv.getString1());
        }
        return false;
    }

   @Override
   protected void readMemberFields(TupleInput input) {
      stringValue = input.readString();
   }

   @Override
   protected final StringRevision readMemberRevision(TupleInput input) {
      return new StringRevision(input, this);
   }

   @Override
   public boolean readyToWriteRefsetMember() {
      assert stringValue != null;

      return true;
   }

   /*
    *  (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuilder buf = new StringBuilder();

      buf.append(this.getClass().getSimpleName()).append(": ");
      buf.append(" stringValue: '").append(this.stringValue).append("' ");
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   protected void writeMember(TupleOutput output) {
      output.writeString(stringValue);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public String getString1() {
      return stringValue;
   }

   @Override
   protected TK_REFEX_TYPE getTkRefsetType() {
      return TK_REFEX_TYPE.STR;
   }

   @Override
   public int getTypeNid() {
      return TK_REFEX_TYPE.STR.getTypeToken();
   }

   @Override
   protected IntArrayList getVariableVersionNids() {
      return new IntArrayList(2);
   }

   @Override
   protected VersionComputer<RefexMember<StringRevision, StringMember>.Version> getVersionComputer() {
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
            for (StringRevision r : revisions) {
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

   @Override
   public void setString1(String str) throws PropertyVetoException {
      this.stringValue = str;
      modified();
   }

   //~--- inner classes -------------------------------------------------------

   public class Version extends RefexMember<StringRevision, StringMember>.Version
           implements RefexStringAnalogBI<StringRevision> {
      private Version(RefexStringAnalogBI cv) {
         super(cv);
      }

      //~--- methods ----------------------------------------------------------

      //~--- get methods ------------------------------------------------------

      RefexStringAnalogBI getCv() {
         return (RefexStringAnalogBI) cv;
      }

      @Override
      public TkRefexStringMember getERefsetMember() throws IOException {
         return new TkRefexStringMember(this);
      }

      @Override
      public TkRefexStringRevision getERefsetRevision() throws IOException {
         return new TkRefexStringRevision(this);
      }

      @Override
      public String getString1() {
         return getCv().getString1();
      }

      //~--- set methods ------------------------------------------------------

      @Override
      public void setString1(String str) throws PropertyVetoException {
         getCv().setString1(str);
      }
   }
}
