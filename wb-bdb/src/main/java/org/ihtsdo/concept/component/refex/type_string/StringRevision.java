package org.ihtsdo.concept.component.refex.type_string;

//~--- non-JDK imports --------------------------------------------------------

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;

import org.ihtsdo.cern.colt.list.IntArrayList;


import org.ihtsdo.concept.component.refex.RefexRevision;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.NidBitSetBI;
import org.ihtsdo.tk.api.blueprint.RefexCAB;
import org.ihtsdo.tk.api.blueprint.RefexCAB.RefexProperty;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_string.RefexStringAnalogBI;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_string.TkRefexStringMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_string.TkRefexStringRevision;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyVetoException;

import java.io.IOException;

import java.util.*;

public class StringRevision extends RefexRevision<StringRevision, StringMember>
        implements RefexStringAnalogBI<StringRevision> {
   private String stringValue;

   //~--- constructors --------------------------------------------------------

   public StringRevision() {
      super();
   }

   public StringRevision(int statusAtPositionNid, StringMember another) {
      super(statusAtPositionNid, another);
      stringValue = another.getString1();
   }

   public StringRevision(TkRefexStringRevision eVersion, StringMember primoridalMember) {
      super(eVersion, primoridalMember);
      this.stringValue = eVersion.getString1();
   }

   public StringRevision(TupleInput input, StringMember primoridalMember) {
      super(input, primoridalMember);
      stringValue = input.readString();
   }

   public StringRevision(int statusNid, int authorNid, int pathNid, long time, StringMember another) {
      super(statusNid, authorNid, pathNid, time, another);
      stringValue = another.getString1();
   }

   protected StringRevision(int statusNid, int authorNid, int pathNid, long time, StringRevision another) {
      super(statusNid, authorNid, pathNid, time, another.primordialComponent);
      stringValue = another.stringValue;
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected void addRefsetTypeNids(Set<Integer> allNids) {

      //
   }

   @Override
   protected void addSpecProperties(RefexCAB rcs) {
      rcs.with(RefexProperty.STRING1, getString1());
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (StringRevision.class.isAssignableFrom(obj.getClass())) {
         StringRevision another = (StringRevision) obj;

         return stringValue.equals(another.stringValue) && super.equals(obj);
      }

      return false;
   }

   @Override
   public StringRevision makeAnalog() {
      return new StringRevision(getStatusNid(), getAuthorNid(), getPathNid(), getTime(), this);
   }

   @Override
   public StringRevision makeAnalog(int statusNid, int authorNid, int pathNid, long time) {
      if ((this.getTime() == time) && (this.getPathNid() == pathNid)) {
         this.setStatusNid(statusNid);
         this.setAuthorNid(authorNid);

         return this;
      }

      StringRevision newR = new StringRevision(statusNid, authorNid, pathNid, time, this);

      primordialComponent.addRevision(newR);

      return newR;
   }

   @Override
   public boolean readyToWriteRefsetRevision() {
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

      buf.append(this.getClass().getSimpleName()).append(":{");
      buf.append(" stringValue:" + "'").append(this.stringValue).append("' ");
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   protected void writeFieldsToBdb(TupleOutput output) {
      output.writeString(stringValue);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public String getString1() {
      return stringValue;
   }

   @Override
   public TkRefexAbstractMember<?> getTkRefexMemberActiveOnly(ViewCoordinate vc, NidBitSetBI exclusionSet,
           Map<UUID, UUID> conversionMap)
           throws ContradictionException, IOException {
      return new TkRefexStringMember(this, exclusionSet, conversionMap, 0, true, vc);
   }

   @Override
   protected TK_REFEX_TYPE getTkRefsetType() {
      return TK_REFEX_TYPE.STR;
   }

   @Override
   public IntArrayList getVariableVersionNids() {
      return new IntArrayList(2);
   }

   @Override
   public StringMember.Version getVersion(ViewCoordinate c) throws ContradictionException {
      return (StringMember.Version) ((StringMember) primordialComponent).getVersion(c);
   }

   @Override
   public Collection<StringMember.Version> getVersions() {
      return ((StringMember) primordialComponent).getVersions();
   }

   @Override
   public Collection<? extends RefexVersionBI<StringRevision>> getVersions(ViewCoordinate c) {
      return ((StringMember) primordialComponent).getVersions(c);
   }

   //~--- set methods ---------------------------------------------------------

   @Override
   public void setString1(String str) throws PropertyVetoException {
      this.stringValue = str;
      modified();
   }

   public void setStringValue(String stringValue) {
      this.stringValue = stringValue;
      modified();
   }
}
