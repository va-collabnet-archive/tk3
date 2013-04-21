package org.ihtsdo.ttk.api;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.concept.ConceptVersionBI;
import org.ihtsdo.ttk.api.coordinate.EditCoordinate;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

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
}
