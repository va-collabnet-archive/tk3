package org.ihtsdo.tk.api;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.concept.ConceptVersionBI;
import org.ihtsdo.tk.api.coordinate.EditCoordinate;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.db.DbDependency;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.ihtsdo.fxmodel.FxComponentReference;
import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.fetchpolicy.RefexPolicy;
import org.ihtsdo.fxmodel.fetchpolicy.RelationshipPolicy;
import org.ihtsdo.fxmodel.fetchpolicy.VersionPolicy;
import org.ihtsdo.tk.dto.concept.component.TkRevision;

public interface TerminologyStoreDI extends TerminologyDI {
    enum DatabaseOptionPreferences {
        DB_LOCATION, BASELINE_FILES;
    }
   ComponentChroncileBI<?> getComponent(Collection<UUID> uuids) throws IOException;

   ComponentChroncileBI<?> getComponent(ComponentContainerBI cc) throws IOException;

   ComponentChroncileBI<?> getComponent(int nid) throws IOException;

   ComponentChroncileBI<?> getComponent(UUID... uuids) throws IOException;
   
   ComponentChroncileBI<?> getComponentFromAlternateId(int authorityNid, String altId) throws IOException;

   ComponentVersionBI getComponentVersion(ViewCoordinate vc, Collection<UUID> uuids)
           throws IOException, ContradictionException;

   ComponentVersionBI getComponentVersion(ViewCoordinate vc, int nid)
           throws IOException, ContradictionException;

   ComponentVersionBI getComponentVersion(ViewCoordinate vc, UUID... uuids)
           throws IOException, ContradictionException;

   ComponentVersionBI getComponentVersionFromAlternateId(ViewCoordinate vc, int authorityNid, String altId)
           throws IOException, ContradictionException;
   ComponentVersionBI getComponentVersionFromAlternateId(ViewCoordinate vc, UUID authorityUuid, String altId)
           throws IOException, ContradictionException;

   ConceptChronicleBI getConcept(Collection<UUID> uuids) throws IOException;

   ConceptChronicleBI getConcept(ConceptContainerBI cc) throws IOException;

   ConceptChronicleBI getConcept(int cNid) throws IOException;

   ConceptChronicleBI getConcept(UUID... uuids) throws IOException;

   ConceptChronicleBI getConceptFromAlternateId(int authorityNid, String altId) throws IOException;
   ConceptChronicleBI getConceptFromAlternateId(UUID authorityUuid, String altId) throws IOException;

   ConceptChronicleBI getConceptForNid(int nid) throws IOException;

   ConceptVersionBI getConceptVersion(ViewCoordinate vc, Collection<UUID> uuids) throws IOException;

   ConceptVersionBI getConceptVersion(ViewCoordinate vc, int cNid) throws IOException;

   ConceptVersionBI getConceptVersion(ViewCoordinate vc, UUID... uuids) throws IOException;

   ConceptVersionBI getConceptVersionFromAlternateId(ViewCoordinate vc, int authorityNid, String altId) throws IOException;
   ConceptVersionBI getConceptVersionFromAlternateId(ViewCoordinate vc, UUID authorityUuid, String altId) throws IOException;

   Map<Integer, ConceptVersionBI> getConceptVersions(ViewCoordinate vc, NidBitSetBI cNids) throws IOException;

   Map<Integer, ConceptChronicleBI> getConcepts(NidBitSetBI cNids) throws IOException;

   Collection<DbDependency> getLatestChangeSetDependencies() throws IOException;

   List<? extends PathBI> getPathChildren(int nid);

   int[] getPossibleChildren(int cNid, ViewCoordinate vc) throws IOException;

   TerminologySnapshotDI getSnapshot(ViewCoordinate vc);
   TerminologySnapshotDI cacheSnapshot(UUID snapshotUuid, ViewCoordinate vc);
   TerminologySnapshotDI getCachedSnapshot(UUID snapshotUuid) throws NoSuchElementException;
   TerminologySnapshotDI getGlobalSnapshot();
   void setGlobalSnapshot(TerminologySnapshotDI globalSnapshot);

   TerminologyBuilderBI getTerminologyBuilder(EditCoordinate ec, ViewCoordinate vc);

   Collection<? extends ConceptChronicleBI> getUncommittedConcepts();
   /**
    * @return the primordial UUID if known. The IUnknown UUID (00000000-0000-0000-C000-000000000046) if not known.
    */
 
   UUID getUuidPrimordialForNid(int nid) throws IOException;

   List<UUID> getUuidsForNid(int nid) throws IOException;

   boolean hasPath(int nid) throws IOException;

   boolean hasUncommittedChanges();

   boolean hasUuid(UUID memberUUID);
   
   boolean hasUuid(List<UUID> memberUUIDs);

   long getSequence();
   
   int getConceptCount() throws IOException;

   int getSapNid(TkRevision version) throws IOException;
   
   ViewCoordinate getViewCoordinate(UUID vcUuid) throws IOException;
   
   Collection<ViewCoordinate> getViewCoordinates() throws IOException;
   
   void putViewCoordinate(ViewCoordinate vc) throws IOException;

   boolean isKindOf(int childNid, int parentNid, ViewCoordinate vc)
           throws IOException, ContradictionException;
   
   FxConcept getFxConcept(UUID conceptUUID, ViewCoordinate vc) throws IOException, ContradictionException;

   FxConcept getFxConcept(FxComponentReference ref, ViewCoordinate vc, VersionPolicy versionPolicy,
                                 RefexPolicy refexPolicy, RelationshipPolicy relationshipPolicy)
           throws IOException, ContradictionException;

   FxConcept getFxConcept(UUID conceptUUID, ViewCoordinate vc, VersionPolicy versionPolicy,
                                 RefexPolicy refexPolicy, RelationshipPolicy relationshipPolicy)
           throws IOException, ContradictionException;

}
