package org.ihtsdo.ttk.api.concept;

//~--- non-JDK imports --------------------------------------------------------
import org.ihtsdo.ttk.api.ComponentVersionBI;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.NidSetBI;
import org.ihtsdo.ttk.api.conattr.ConceptAttributeVersionBI;
import org.ihtsdo.ttk.api.constraint.ConstraintBI;
import org.ihtsdo.ttk.api.constraint.ConstraintCheckType;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.description.DescriptionVersionBI;
import org.ihtsdo.ttk.api.media.MediaVersionBI;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.relationship.RelationshipVersionBI;
import org.ihtsdo.ttk.api.relationship.group.RelGroupVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.Collection;
import java.util.List;
import org.ihtsdo.ttk.api.blueprint.ConceptCB;
import org.ihtsdo.ttk.api.blueprint.IdDirective;
import org.ihtsdo.ttk.api.blueprint.InvalidCAB;
import org.ihtsdo.ttk.api.blueprint.RefexDirective;

public interface ConceptVersionBI extends ComponentVersionBI, ConceptChronicleBI {

    boolean satisfies(ConstraintBI constraint, ConstraintCheckType subjectCheck,
            ConstraintCheckType propertyCheck, ConstraintCheckType valueCheck)
            throws IOException, ContradictionException;

    //~--- get methods ---------------------------------------------------------
    @Override
    ConceptChronicleBI getChronicle();

    ConceptAttributeVersionBI getConceptAttributesActive() throws IOException, ContradictionException;

    Collection<? extends RefexVersionBI<?>> getCurrentRefexMembers(int refsetNid) throws IOException;

    RefexChronicleBI<?> getCurrentRefsetMemberForComponent(int componentNid) throws IOException;

    Collection<? extends DescriptionVersionBI> getDescriptionsActive() throws IOException, ContradictionException;

    Collection<? extends DescriptionVersionBI> getDescriptionsActive(int typeNid)
            throws IOException, ContradictionException;

    Collection<? extends DescriptionVersionBI> getDescriptionsFullySpecifiedActive(NidSetBI typeNids)
            throws IOException, ContradictionException;

    Collection<? extends DescriptionVersionBI> getDescriptionsFullySpecifiedActive() throws IOException;

    DescriptionVersionBI getFullySpecifiedDescription() throws IOException, ContradictionException;

    Collection<? extends MediaVersionBI> getMediaActive() throws IOException, ContradictionException;

    Collection<List<Integer>> getNidPathsToRoot() throws IOException;

    Collection<? extends DescriptionVersionBI> getDescriptionsPreferredActive() throws IOException;

    DescriptionVersionBI getPreferredDescription() throws IOException, ContradictionException;

    Collection<? extends RefexVersionBI<?>> getRefsetMembersActive() throws IOException, ContradictionException;

    Collection<? extends RelGroupVersionBI> getRelationshipGroupsActive() throws IOException, ContradictionException;

    Collection<? extends RelationshipVersionBI> getRelationshipsIncomingActive()
            throws IOException, ContradictionException;

    Collection<? extends RelationshipVersionBI> getRelationshipsIncomingActiveIsa()
            throws IOException, ContradictionException;

    Collection<? extends ConceptVersionBI> getRelationshipsIncomingOrigins() throws IOException;

    Collection<? extends ConceptVersionBI> getRelationshipsIncomingOrigins(int typeNid) throws IOException;

    Collection<? extends ConceptVersionBI> getRelationshipsIncomingOrigins(NidSetBI typeNids) throws IOException;

    Collection<? extends ConceptVersionBI> getRelationshipsIncomingOriginsActive()
            throws IOException, ContradictionException;

    Collection<? extends ConceptVersionBI> getRelationshipsIncomingOriginsActive(int typeNid)
            throws IOException, ContradictionException;

    Collection<? extends ConceptVersionBI> getRelationshipsIncomingOriginsActive(NidSetBI typeNids)
            throws IOException, ContradictionException;

    Collection<? extends ConceptVersionBI> getRelationshipsIncomingOriginsActiveIsa()
            throws IOException, ContradictionException;

    Collection<? extends ConceptVersionBI> getRelationshipsIncomingOriginsIsa() throws IOException;

    Collection<? extends RelationshipVersionBI> getRelationshipsOutgoingActive()
            throws IOException, ContradictionException;

    Collection<? extends RelationshipVersionBI> getRelationshipsOutgoingActiveIsa()
            throws IOException, ContradictionException;

    Collection<? extends ConceptVersionBI> getRelationshipsOutgoingDestinations() throws IOException;

    Collection<? extends ConceptVersionBI> getRelationshipsOutgoingDestinations(int typeNid) throws IOException;

    Collection<? extends ConceptVersionBI> getRelationshipsOutgoingDestinations(NidSetBI typeNids) throws IOException;

    Collection<? extends ConceptVersionBI> getRelationshipsOutgoingDestinationsActive()
            throws IOException, ContradictionException;

    Collection<? extends ConceptVersionBI> getRelationshipsOutgoingDestinationsActive(int typeNid)
            throws IOException, ContradictionException;

    Collection<? extends ConceptVersionBI> getRelationshipsOutgoingDestinationsActive(NidSetBI typeNids)
            throws IOException, ContradictionException;

    Collection<? extends ConceptVersionBI> getRelationshipsOutgoingDestinationsActiveIsa()
            throws IOException, ContradictionException;

    Collection<? extends ConceptVersionBI> getRelationshipsOutgoingDestinationsIsa() throws IOException;

    int[] getRelationshipsOutgoingDestinationsNidsActiveIsa() throws IOException;

    Collection<? extends DescriptionVersionBI> getSynonyms() throws IOException;

    ViewCoordinate getViewCoordinate();

    boolean hasAnnotationMemberActive(int refsetNid) throws IOException;

    boolean hasChildren() throws IOException, ContradictionException;

    boolean hasHistoricalRels() throws IOException, ContradictionException;

    boolean hasRefexMemberActive(int refsetNid) throws IOException;

    boolean hasRefsetMemberForComponentActive(int componentNid) throws IOException;

    boolean isChildOf(ConceptVersionBI child) throws IOException;

    boolean isKindOf(ConceptVersionBI parentKind) throws IOException, ContradictionException;

    boolean isLeaf() throws IOException;

    boolean isMember(int evalRefsetNid) throws IOException;

    @Override
    ConceptCB makeBlueprint(ViewCoordinate vc, IdDirective idDirective, RefexDirective refexDirective) throws IOException, ContradictionException, InvalidCAB;
}
