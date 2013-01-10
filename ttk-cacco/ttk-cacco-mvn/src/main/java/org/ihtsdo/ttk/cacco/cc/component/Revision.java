package org.ihtsdo.ttk.cacco.cc.component;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.TerminologySnapshotDI;
import org.ihtsdo.ttk.api.ComponentVersionBI;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.cacco.cc.Position;
import org.ihtsdo.ttk.api.AnalogBI;
import org.ihtsdo.ttk.api.ComponentChroncileBI;
import org.ihtsdo.ttk.api.NidSetBI;
import org.ihtsdo.ttk.api.AnalogGeneratorBI;
import org.ihtsdo.ttk.api.PositionBI;
import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;

import org.ihtsdo.ttk.cacco.cc.P;
import org.ihtsdo.ttk.cacco.cc.concept.Concept;
import org.ihtsdo.cern.colt.list.IntArrayList;
import org.ihtsdo.ttk.helpers.time.TimeHelper;
import org.ihtsdo.ttk.api.coordinate.EditCoordinate;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.id.IdBI;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.hash.Hashcode;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyVetoException;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Revision<V extends Revision<V, C>, C extends ConceptComponent<V, C>>
        implements ComponentVersionBI, AnalogBI, AnalogGeneratorBI<V> {
   protected static final Logger  logger         = Logger.getLogger(ConceptComponent.class.getName());
   public static SimpleDateFormat fileDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");

   //~--- fields --------------------------------------------------------------

   public C   primordialComponent;
   public int stamp;

   //~--- constructors --------------------------------------------------------

   public Revision() {
      super();
   }

   public Revision(int stamp, C primordialComponent) {
      super();
      assert primordialComponent != null;
      assert stamp != 0;
      this.stamp            = stamp;
      this.primordialComponent = primordialComponent;
      primordialComponent.clearVersions();
      assert stamp != Integer.MAX_VALUE;
      this.primordialComponent.getEnclosingConcept().modified();
   }

   public Revision(TupleInput input, C conceptComponent) {
      this(input.readInt(), conceptComponent);
      conceptComponent.clearVersions();
      assert stamp != 0;
   }

   public Revision(int statusNid, long time, int authorNid, int moduleNid, int pathNid,
                   C primordialComponent) {
      this.stamp = P.s.getStamp(statusNid, time, authorNid, moduleNid, pathNid);
      assert stamp != 0;
      this.primordialComponent = primordialComponent;
      primordialComponent.clearVersions();
      assert primordialComponent != null;
      assert stamp != Integer.MAX_VALUE;
      this.primordialComponent.getEnclosingConcept().modified();
   }

   //~--- methods -------------------------------------------------------------

   @Override
   public boolean addAnnotation(@SuppressWarnings("rawtypes") RefexChronicleBI annotation)
           throws IOException {
      return primordialComponent.addAnnotation(annotation);
   }

   abstract protected void addComponentNids(Set<Integer> allNids);

   @Override
   public boolean addLongId(Long longId, int authorityNid, int statusNid, EditCoordinate ec, long time) {
      return primordialComponent.addLongId(longId, authorityNid, statusNid, ec, time);
   }

   protected String assertionString() {
      try {
         return P.s.getConcept(primordialComponent.enclosingConceptNid).toLongString();
      } catch (IOException ex) {
         Logger.getLogger(ConceptComponent.class.getName()).log(Level.SEVERE, null, ex);
      }

      return toString();
   }

   @SuppressWarnings("unchecked")
   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (Revision.class.isAssignableFrom(obj.getClass())) {
         Revision<V, C> another = (Revision<V, C>) obj;

         if (this.stamp == another.stamp) {
            return true;
         }
      }

      return false;
   }

   @Override
   public final int hashCode() {
      return Hashcode.compute(primordialComponent.nid);
   }

   public boolean makeAdjudicationAnalogs(EditCoordinate ec, ViewCoordinate vc) throws IOException {
      return primordialComponent.makeAdjudicationAnalogs(ec, vc);
   }

   /**
    * 1. Analog, an object, concept or situation which in some way
    *    resembles a different situation
    * 2. Analogy, in language, a comparison between concepts
    * @param statusNid
    * @param pathNid
    * @param time
    * @return
    */
   @Override
   public abstract V makeAnalog(int statusNid, long time, int authorNid, int moduleNid, int pathNid);

   protected void modified() {
      if (primordialComponent != null) {
         primordialComponent.modified();
      }
   }

   public final boolean readyToWrite() {
      assert primordialComponent != null : assertionString();
      assert stamp != Integer.MAX_VALUE : assertionString();
      assert(stamp > 0) || (stamp == -1);

      return true;
   }

   public abstract boolean readyToWriteRevision();

   @Override
   public boolean stampIsInRange(int min, int max) {
      return (stamp >= min) && (stamp <= max);
   }

   /*
    *  (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuffer buf = new StringBuffer();

      buf.append(" stamp:");
      buf.append(stamp);

      try {
         buf.append(" s:");
         ConceptComponent.addNidToBuffer(buf, getStatusNid());
         buf.append(" t: ");
         buf.append(TimeHelper.formatDate(getTime()));
         buf.append(" a:");
         ConceptComponent.addNidToBuffer(buf, getAuthorNid());
         buf.append(" m:");
         ConceptComponent.addNidToBuffer(buf, getModuleNid());
         buf.append(" p:");
         ConceptComponent.addNidToBuffer(buf, getPathNid());
         buf.append(" ");
         buf.append(getTime());
      } catch (Throwable e) {
         buf.append(" !!! Invalid sapNid. Cannot compute path, time, status. !!! ");
         buf.append(e.getLocalizedMessage());
      }

      buf.append(" };");

      return buf.toString();
   }

   @Override
   public abstract String toUserString();

   @Override
   public String toUserString(TerminologySnapshotDI snapshot) throws IOException, ContradictionException {
      return toUserString();
   }

   /**
    * Test method to check to see if two objects are equal in all respects.
    * @param another
    * @return either a zero length String, or a String containing a
    * description of the validation failures.
    * @throws IOException
    */
   public String validate(Revision<?, ?> another) throws IOException {
      assert another != null;

      StringBuilder buf = new StringBuilder();

      if (this.stamp != another.stamp) {
         buf.append("\t\tRevision.sapNid not equal: \n\t\t\tthis.sapNid = ").append(this.stamp).append(
             "\n\t\t\tanother.sapNid = ").append(another.stamp).append("\n");
      }

      if (!this.primordialComponent.equals(another.primordialComponent)) {
         buf.append(
             "\t\tRevision.primordialComponent not equal: " + "\n\t\t\tthis.primordialComponent = ").append(
             this.primordialComponent).append("\n\t\t\tanother.primordialComponent = ").append(
             another.primordialComponent).append("\n");
      }

      return buf.toString();
   }

   @Override
   public boolean versionsEqual(ViewCoordinate vc1, ViewCoordinate vc2, Boolean compareAuthoring) {
      return primordialComponent.versionsEqual(vc1, vc2, compareAuthoring);
   }

   protected abstract void writeFieldsToBdb(TupleOutput output);

   public final void writeRevisionBdb(TupleOutput output) {
      output.writeInt(stamp);
      writeFieldsToBdb(output);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public Collection<? extends IdBI> getAdditionalIds() {
      return primordialComponent.getAdditionalIds();
   }

   @Override
   public Collection<? extends IdBI> getAllIds() {
      return primordialComponent.getAllIds();
   }

   @Override
   public Set<Integer> getAllNidsForVersion() throws IOException {
      HashSet<Integer> allNids = new HashSet<>();

      allNids.add(primordialComponent.nid);
      allNids.add(getStatusNid());
      allNids.add(getAuthorNid());
      allNids.add(getPathNid());
      addComponentNids(allNids);

      return allNids;
   }

   public Set<Integer> getAllStamps() throws IOException {
      return primordialComponent.getAllStamps();
   }

   @Override
   public Collection<? extends RefexChronicleBI<?>> getAnnotations() {
      return primordialComponent.getAnnotations();
   }

   @Override
   public int getAuthorNid() {
      return P.s.getAuthorNidForStamp(stamp);
   }

   @Override
   public ComponentChroncileBI getChronicle() {
      return (ComponentChroncileBI) primordialComponent;
   }

   @Override
   public int getConceptNid() {
      return primordialComponent.enclosingConceptNid;
   }

   @Override
   public Collection<? extends RefexVersionBI<?>> getCurrentAnnotationMembers(ViewCoordinate xyz)
           throws IOException {
      return primordialComponent.getCurrentAnnotationMembers(xyz);
   }

   @Override
   public <T extends RefexVersionBI<?>> Collection<T> getCurrentAnnotationMembers(ViewCoordinate xyz,
           Class<T> cls)
           throws IOException {
      return primordialComponent.getCurrentAnnotationMembers(xyz, cls);
   }

   @Override
   public Collection<? extends RefexVersionBI<?>> getCurrentAnnotationMembers(ViewCoordinate xyz,
           int refexNid)
           throws IOException {
      return primordialComponent.getCurrentAnnotationMembers(xyz, refexNid);
   }

   @Override
   public <T extends RefexVersionBI<?>> Collection<T> getCurrentAnnotationMembers(ViewCoordinate xyz,
           int refexNid, Class<T> cls)
           throws IOException {
      return primordialComponent.getCurrentAnnotationMembers(xyz, refexNid, cls);
   }

   @Override
   public Collection<? extends RefexVersionBI<?>> getCurrentRefexMembers(ViewCoordinate xyz, int refsetNid)
           throws IOException {
      return primordialComponent.getCurrentRefexMembers(xyz, refsetNid);
   }

   @Override
   public Collection<? extends RefexVersionBI<?>> getCurrentRefexes(ViewCoordinate xyz) throws IOException {
      return primordialComponent.getCurrentRefexes(xyz);
   }

   @Override
   public Collection<? extends RefexVersionBI<?>> getCurrentRefexes(ViewCoordinate xyz, int refsetNid)
           throws IOException {
      return primordialComponent.getCurrentRefexes(xyz, refsetNid);
   }

   public Concept getEnclosingConcept() {
      return primordialComponent.getEnclosingConcept();
   }

   @Override
   public Collection<? extends RefexVersionBI<?>> getInactiveRefexes(ViewCoordinate xyz) throws IOException {
      return getChronicle().getInactiveRefexes(xyz);
   }

   @Override
   public int getModuleNid() {
      return P.s.getModuleNidForStamp(stamp);
   }

   @Override
   public final int getNid() {
      return primordialComponent.getNid();
   }

   @Override
   public int getPathNid() {
      return P.s.getPathNidForStamp(stamp);
   }

   @Override
   public PositionBI getPosition() throws IOException {
      return new Position(getTime(), P.s.getPath(getPathNid()));
   }

   public Set<PositionBI> getPositions() throws IOException {
      return primordialComponent.getPositions();
   }

   @Override
   public UUID getPrimUuid() {
      return primordialComponent.getPrimUuid();
   }

   @Override
   public Collection<? extends RefexChronicleBI<?>> getRefexMembers(int refsetNid) throws IOException {
      return primordialComponent.getRefexMembers(refsetNid);
   }

   @Override
   public Collection<? extends RefexChronicleBI<?>> getRefexes() throws IOException {
      return primordialComponent.getRefexes();
   }

   @Override
   @Deprecated
   public Collection<? extends RefexChronicleBI<?>> getRefexes(int refsetNid) throws IOException {
      return primordialComponent.getRefexMembers(refsetNid);
   }

   @Override
   public int getStamp() {
      return stamp;
   }

   public final int getStatusAtPositionNid() {
      return stamp;
   }

   @Override
   public int getStatusNid() {
      return P.s.getStatusNidForStamp(stamp);
   }

   @Override
   public long getTime() {
      return P.s.getTimeForStamp(stamp);
   }

   @Override
   public final List<UUID> getUUIDs() {
      return primordialComponent.getUUIDs();
   }

   public abstract IntArrayList getVariableVersionNids();

   public final C getVersioned() {
      return primordialComponent;
   }

   @Override
   public boolean hasCurrentAnnotationMember(ViewCoordinate xyz, int refsetNid) throws IOException {
      return primordialComponent.hasCurrentAnnotationMember(xyz, refsetNid);
   }

   @Override
   public boolean hasCurrentRefexMember(ViewCoordinate xyz, int refsetNid) throws IOException {
      return primordialComponent.hasCurrentRefexMember(xyz, refsetNid);
   }

   @Override
   public boolean isActive(NidSetBI allowedStatusNids) {
      return allowedStatusNids.contains(getStatusNid());
   }

   @Override
   public boolean isActive(ViewCoordinate vc) {
      return isActive(vc.getAllowedStatusNids());
   }

   @Override
   public boolean isBaselineGeneration() {
      return stamp <= P.s.getMaxReadOnlyStamp();
   }

   @Override
   public boolean isUncommitted() {
      return getTime() == Long.MAX_VALUE;
   }

   //~--- set methods ---------------------------------------------------------

   @Override
   public void setAuthorNid(int authorNid) {
      if (getTime() != Long.MAX_VALUE) {
         throw new UnsupportedOperationException("Cannot change status if time != Long.MAX_VALUE; "
                 + "Use makeAnalog instead.");
      }

      if (authorNid != getPathNid()) {
         this.stamp = P.s.getStamp(getStatusNid(), Long.MAX_VALUE, authorNid, getModuleNid(),
                                         getPathNid());
         modified();
      }
   }

   @Override
   public final void setModuleNid(int moduleNid) {
      if (getTime() != Long.MAX_VALUE) {
         throw new UnsupportedOperationException("Cannot change status if time != Long.MAX_VALUE; "
                 + "Use makeAnalog instead.");
      }

      try {
         this.stamp = P.s.getStamp(getStatusNid(), Long.MAX_VALUE, getAuthorNid(), moduleNid,
                                         getPathNid());
      } catch (Exception e) {
         throw new RuntimeException();
      }

      modified();
   }

   @Override
   public final void setNid(int nid) throws PropertyVetoException {
      throw new PropertyVetoException("nid", null);
   }

   @Override
   public final void setPathNid(int pathId) {
      if (getTime() != Long.MAX_VALUE) {
         throw new UnsupportedOperationException("Cannot change status if time != Long.MAX_VALUE; "
                 + "Use makeAnalog instead.");
      }

      this.stamp = P.s.getStamp(getStatusNid(), Long.MAX_VALUE, getAuthorNid(), getModuleNid(), pathId);
   }

   public void setStatusAtPosition(int statusNid, long time, int authorNid, int moduleNid, int pathNid) {
      this.stamp = P.s.getStamp(statusNid, time, authorNid, moduleNid, pathNid);
      modified();
   }

   @Override
   public final void setStatusNid(int statusNid) {
      if (getTime() != Long.MAX_VALUE) {
         throw new UnsupportedOperationException("Cannot change status if time != Long.MAX_VALUE; "
                 + "Use makeAnalog instead.");
      }

      try {
         this.stamp = P.s.getStamp(statusNid, Long.MAX_VALUE, getAuthorNid(), getModuleNid(),
                                         getPathNid());
      } catch (Exception e) {
         throw new RuntimeException();
      }

      modified();
   }

   @Override
   public final void setTime(long time) {
      if (getTime() != Long.MAX_VALUE) {
         throw new UnsupportedOperationException("Cannot change status if time != Long.MAX_VALUE; "
                 + "Use makeAnalog instead.");
      }

      if (time != getTime()) {
         try {
            this.stamp = P.s.getStamp(getStatusNid(), time, getAuthorNid(), getModuleNid(),
                                            getPathNid());
         } catch (Exception e) {
            throw new RuntimeException();
         }

         modified();
      }
   }
}
