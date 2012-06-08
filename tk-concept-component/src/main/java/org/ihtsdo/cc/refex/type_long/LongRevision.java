package org.ihtsdo.cc.refex.type_long;

//~--- non-JDK imports --------------------------------------------------------

import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.ihtsdo.cern.colt.list.IntArrayList;
import org.ihtsdo.cc.refex.RefexRevision;
import org.ihtsdo.cc.refex.type_long.LongMember.Version;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.NidBitSetBI;
import org.ihtsdo.tk.api.blueprint.RefexCAB;
import org.ihtsdo.tk.api.blueprint.RefexCAB.RefexProperty;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_long.RefexLongAnalogBI;
import org.ihtsdo.tk.dto.concept.component.refex.type_long.TkRefexLongMember;
import org.ihtsdo.tk.dto.concept.component.refex.type_long.TkRefexLongRevision;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;

public class LongRevision extends RefexRevision<LongRevision, LongMember>
        implements RefexLongAnalogBI<LongRevision> {
   private long longValue;

   //~--- constructors --------------------------------------------------------

   public LongRevision() {
      super();
   }

   public LongRevision(int statusAtPositionNid, LongMember primoridalMember) {
      super(statusAtPositionNid, primoridalMember);
      longValue = primoridalMember.getLong1();
   }

   public LongRevision(TkRefexLongRevision eVersion, LongMember member) throws IOException {
      super(eVersion, member);
      this.longValue = eVersion.getLongValue();
   }

   public LongRevision(TupleInput input, LongMember primoridalMember) {
      super(input, primoridalMember);
      longValue = input.readLong();
   }

   public LongRevision(int statusNid, long time, int authorNid, int moduleNid, int pathNid, LongMember primoridalMember) {
      super(statusNid, time, authorNid, moduleNid, pathNid, primoridalMember);
      longValue = primoridalMember.getLong1();
   }

   protected LongRevision(int statusNid, long time, int authorNid, int moduleNid, int pathNid, LongRevision another) {
      super(statusNid, time, authorNid, moduleNid, pathNid, another.primordialComponent);
      longValue = another.longValue;
   }

   //~--- methods -------------------------------------------------------------

   @Override
   protected void addRefsetTypeNids(Set<Integer> allNids) {

      // ;
   }

   @Override
   protected void addSpecProperties(RefexCAB rcs) {
      rcs.with(RefexProperty.LONG1, getLong1());
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (LongRevision.class.isAssignableFrom(obj.getClass())) {
         LongRevision another = (LongRevision) obj;

         return (this.longValue == another.longValue) && super.equals(obj);
      }

      return false;
   }

   @Override
   public LongRevision makeAnalog() {
      return new LongRevision(getStatusNid(), getTime(), getAuthorNid(), getModuleNid(), getPathNid(), this);
   }
   
   @Override
   public LongRevision makeAnalog(int statusNid, long time, int authorNid, int moduleNid, int pathNid) {
       if ((this.getTime() == time) && (this.getPathNid() == pathNid)) {
         this.setStatusNid(statusNid);
         this.setAuthorNid(authorNid);
         this.setModuleNid(moduleNid);

         return this;
      }
      LongRevision newR = new LongRevision(statusNid, time, authorNid,
              moduleNid, pathNid, this);

      primordialComponent.addRevision(newR);

      return newR;
   }

   @Override
   public boolean readyToWriteRefsetRevision() {
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
      buf.append(" longValue:").append(this.longValue);
      buf.append(super.toString());

      return buf.toString();
   }

   @Override
   protected void writeFieldsToBdb(TupleOutput output) {
      output.writeLong(longValue);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public long getLong1() {
      return longValue;
   }

   @Override
   public TkRefexAbstractMember<?> getTkRefexMemberActiveOnly(ViewCoordinate vc, NidBitSetBI exclusionSet,
           Map<UUID, UUID> conversionMap)
           throws ContradictionException, IOException {
      return new TkRefexLongMember(this, exclusionSet, conversionMap, 0, true, vc);
   }

   @Override
   protected TK_REFEX_TYPE getTkRefsetType() {
      return TK_REFEX_TYPE.LONG;
   }

   @Override
   public IntArrayList getVariableVersionNids() {
      return new IntArrayList(2);
   }

   @Override
   public LongMember.Version getVersion(ViewCoordinate c) throws ContradictionException {
      return (Version) ((LongMember) primordialComponent).getVersion(c);
   }

   @Override
   public Collection<LongMember.Version> getVersions() {
      return ((LongMember) primordialComponent).getVersions();
   }

   @Override
   public Collection<? extends RefexVersionBI<LongRevision>> getVersions(ViewCoordinate c) {
      return ((LongMember) primordialComponent).getVersions(c);
   }

   //~--- set methods ---------------------------------------------------------

   @Override
   public void setLong1(long l) throws PropertyVetoException {
      this.longValue = l;
      modified();
   }

   public void setLongValue(long longValue) {
      this.longValue = longValue;
      modified();
   }
}
