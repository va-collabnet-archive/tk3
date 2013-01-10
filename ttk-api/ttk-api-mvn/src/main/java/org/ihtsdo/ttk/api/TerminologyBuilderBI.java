package org.ihtsdo.ttk.api;

import java.io.IOException;
import org.ihtsdo.ttk.api.blueprint.ConAttrAB;
import org.ihtsdo.ttk.api.blueprint.ConceptCB;
import org.ihtsdo.ttk.api.blueprint.DescCAB;
import org.ihtsdo.ttk.api.blueprint.InvalidCAB;
import org.ihtsdo.ttk.api.blueprint.MediaCAB;
import org.ihtsdo.ttk.api.blueprint.RefexCAB;
import org.ihtsdo.ttk.api.blueprint.RelCAB;
import org.ihtsdo.ttk.api.conattr.ConAttrChronicleBI;
import org.ihtsdo.ttk.api.concept.ConceptChronicleBI;
import org.ihtsdo.ttk.api.coordinate.EditCoordinate;
import org.ihtsdo.ttk.api.description.DescriptionChronicleBI;
import org.ihtsdo.ttk.api.media.MediaChronicleBI;

import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.relationship.RelationshipChronicleBI;

public interface TerminologyBuilderBI {

    /**
     *  
     * @param res
     * @return A <code>RefexChronicleBI</code> if the <code>blueprint</code> 
     * regardless of if the RefexChronicleBI was modified. 
     * @throws IOException
     * @throws InvalidAmendmentSpec
     */
    RefexChronicleBI<?> construct(RefexCAB blueprint) throws IOException, InvalidCAB, ContradictionException;

    /**
     *  This method incurs an extra cost to determine if a current version already meets the specification. 
     * @param res
     * @return A <code>RefexChronicleBI</code> if the <code>blueprint</code> 
     * regardless of if the RefexChronicleBI was modified. 
     * @throws IOException
     * @throws InvalidAmendmentSpec
     */
    RefexChronicleBI<?> constructIfNotCurrent(RefexCAB blueprint) throws IOException, InvalidCAB, ContradictionException;

    /**
     *  
     * @param res
     * @return A <code>RelationshipChronicleBI</code> if the <code>blueprint</code> 
     * regardless of if the RelationshipChronicleBI was modified. 
     * @throws IOException
     * @throws InvalidAmendmentSpec
     */
    RelationshipChronicleBI construct(RelCAB blueprint) throws IOException, InvalidCAB, ContradictionException;

    /**
     *  This method incurs an extra cost to determine if a current version already meets the specification. 
     * @param res
     * @return A <code>RelationshipChronicleBI</code> if the 
     * <code>blueprint</code> regardless of if the RelationshipChronicleBI was modified. 
     * @throws IOException
     * @throws InvalidAmendmentSpec
     */
    RelationshipChronicleBI constructIfNotCurrent(RelCAB blueprint) throws IOException, InvalidCAB, ContradictionException;

    /**
     *  
     * @param res
     * @return A <code>DescriptionChronicleBI</code> if the <code>blueprint</code> 
     * regardless of if the DescriptionChronicleBI was modified. 
     * @throws IOException
     * @throws InvalidAmendmentSpec
     */
    DescriptionChronicleBI construct(DescCAB blueprint) throws IOException, InvalidCAB, ContradictionException;

    /**
     *  This method incurs an extra cost to determine if a current version already meets the specification. 
     * @param res
     * @return A <code>DescriptionChronicleBI</code> if the
     * <code>blueprint</code> regardless of if the DescriptionChronicleBI was modified. 
     * @throws IOException
     * @throws InvalidAmendmentSpec
     */
    DescriptionChronicleBI constructIfNotCurrent(DescCAB blueprint) throws IOException, InvalidCAB, ContradictionException;

    /**
     *  
     * @param res
     * @return A <code>MediaChronicleBI</code> if the <code>blueprint</code> 
     * regardless of if the MediaChronicleBI was modified. 
     * @throws IOException
     * @throws InvalidAmendmentSpec
     */
    MediaChronicleBI construct(MediaCAB blueprint) throws IOException, InvalidCAB, ContradictionException;

    /**
     *  This method incurs an extra cost to determine if a current version already meets the specification. 
     * @param res
     * @return A <code>MediaChronicleBI</code> if the <code>blueprint</code> 
     *         regardless of if the MediaChronicleBI was modified. 
     * @throws IOException
     * @throws InvalidAmendmentSpec
     */
    MediaChronicleBI constructIfNotCurrent(MediaCAB blueprint) throws IOException, InvalidCAB, ContradictionException;

    /**
     *  
     * @param res
     * @return A <code>ConceptChronicleBI</code> if the <code>blueprint</code> 
     *          regardless of if the ConceptChronicleBI was modified. 
     * @throws IOException
     * @throws InvalidAmendmentSpec
     */
    ConceptChronicleBI construct(ConceptCB blueprint) throws IOException, InvalidCAB, ContradictionException;

    /**
     *  This method incurs an extra cost to determine if a current version 
     *  already meets the specification. 
     * @param res
     * @return A <code>ConceptChronicleBI</code> if the <code>blueprint</code> 
     *          regardless of if the ConceptChronicleBI was modified. 
     * @throws IOException
     * @throws InvalidAmendmentSpec
     */
    ConceptChronicleBI constructIfNotCurrent(ConceptCB blueprint) throws IOException, InvalidCAB, ContradictionException;

    /**
     *  
     * @param res
     * @return A <code>ConAttrChronicleBI</code> if the <code>blueprint</code> regardless of if the ConAttrChronicleBI was modified. 
     * @throws IOException
     * @throws InvalidAmendmentSpec
     */
    ConAttrChronicleBI construct(ConAttrAB blueprint) throws IOException, InvalidCAB, ContradictionException;

    /**
     *  This method incurs an extra cost to determine if a current version already meets the specification. 
     * @param res
     * @return A <code>ConAttrChronicleBI</code> if the <code>blueprint</code> regardless of if the ConAttrChronicleBI was modified. 
     * @throws IOException
     * @throws InvalidAmendmentSpec
     */
    ConAttrChronicleBI constructIfNotCurrent(ConAttrAB blueprint) throws IOException, InvalidCAB, ContradictionException;

    EditCoordinate getEditCoordinate();
}
