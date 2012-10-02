package org.ihtsdo.tk.api;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.api.concept.ConceptVersionBI;
import org.ihtsdo.tk.api.coordinate.EditCoordinate;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import org.ihtsdo.fxmodel.FxComponentReference;
import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.fetchpolicy.RefexPolicy;
import org.ihtsdo.fxmodel.fetchpolicy.RelationshipPolicy;
import org.ihtsdo.fxmodel.fetchpolicy.VersionPolicy;

public interface TerminologySnapshotDI extends TerminologyDI {

   TerminologyBuilderBI getBuilder(EditCoordinate ec);

   ComponentVersionBI getComponentVersion(Collection<UUID> uuids) throws IOException, ContradictionException;

   ComponentVersionBI getComponentVersion(ComponentContainerBI cc) throws IOException, ContradictionException;

   ComponentVersionBI getComponentVersion(int nid) throws IOException, ContradictionException;

   ComponentVersionBI getComponentVersion(UUID... uuids) throws IOException, ContradictionException;

   ConceptVersionBI getConceptForNid(int nid) throws IOException;

   ConceptVersionBI getConceptVersion(Collection<UUID> uuids) throws IOException;

   ConceptVersionBI getConceptVersion(ConceptContainerBI cc) throws IOException;

   ConceptVersionBI getConceptVersion(int cNid) throws IOException;

   ConceptVersionBI getConceptVersion(UUID... uuids) throws IOException;

   Map<Integer, ConceptVersionBI> getConceptVersions(NidBitSetBI cNids) throws IOException;

   int[] getPossibleChildren(int cNid) throws IOException;

   ViewCoordinate getViewCoordinate();

   int getConceptNidForNid(Integer nid);
   
   boolean isKindOf(int childNid, int parentNid) throws IOException, ContradictionException;
   
   FxConcept getFxConcept(UUID conceptUUID, ViewCoordinate vc) throws IOException, ContradictionException;

   FxConcept getFxConcept(FxComponentReference ref, RefexPolicy refexPolicy, RelationshipPolicy relationshipPolicy)
           throws IOException, ContradictionException;

   FxConcept getFxConcept(UUID conceptUUID, RefexPolicy refexPolicy, RelationshipPolicy relationshipPolicy)
           throws IOException, ContradictionException;

}
