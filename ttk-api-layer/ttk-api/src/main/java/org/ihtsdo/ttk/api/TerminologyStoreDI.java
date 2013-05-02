package org.ihtsdo.ttk.api;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.concept.ConceptChronicleBI;
import org.ihtsdo.ttk.api.concept.ConceptVersionBI;
import org.ihtsdo.ttk.api.coordinate.EditCoordinate;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.db.DbDependency;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

public interface TerminologyStoreDI extends TerminologyDI {

    enum DatabaseOptionPreferences {
        DB_LOCATION, BASELINE_FILES;
    }
   ComponentChronicleBI<?> getComponent(Collection<UUID> uuids) throws IOException;

   ComponentChronicleBI<?> getComponent(ComponentContainerBI cc) throws IOException;

   ComponentChronicleBI<?> getComponent(int nid) throws IOException;

   ComponentChronicleBI<?> getComponent(UUID... uuids) throws IOException;
   
   ComponentChronicleBI<?> getComponentFromAlternateId(int authorityNid, String altId) throws IOException;

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

   int getStamp(ExternalStampBI version) throws IOException;
   
   ViewCoordinate getViewCoordinate(UUID vcUuid) throws IOException;
   
   Collection<ViewCoordinate> getViewCoordinates() throws IOException;
   
   void putViewCoordinate(ViewCoordinate vc) throws IOException;

   boolean isKindOf(int childNid, int parentNid, ViewCoordinate vc)
           throws IOException, ContradictionException;
}
