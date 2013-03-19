package org.ihtsdo.ttk.concept.cc.concept;

import org.ihtsdo.ttk.concept.cc.concept.AttributeComparer;
import org.ihtsdo.ttk.api.ComponentVersionBI;
import org.ihtsdo.ttk.api.relationship.RelationshipVersionBI;
import org.ihtsdo.ttk.api.contradiction.ComponentType;

public class RelationshipAttributeComparer extends AttributeComparer {

    private int lcaOriginNid = 0;
    private int lcaDestinationNid = 0;
    private int lcaRefinabilityNid = 0;
    private int lcaCharacteristicNid = 0;
    private int lcaGroup = 0;
    private int lcaStatusNid = 0;

    public RelationshipAttributeComparer() {
        super();
        componentType = ComponentType.SRC_RELATIONSHIP;
    }

    public void setRelationshipType(ComponentType rel) {
        componentType = rel;
    }

    @Override
    boolean hasSameAttributes(ComponentVersionBI v) {
        RelationshipVersionBI relAttributeVersion = (RelationshipVersionBI) v;

        if ((relAttributeVersion.getOriginNid() != lcaOriginNid)
                || (relAttributeVersion.getDestinationNid() != lcaDestinationNid)
                || (relAttributeVersion.getRefinabilityNid() != lcaRefinabilityNid)
                || (relAttributeVersion.getCharacteristicNid() != lcaCharacteristicNid)
                || (relAttributeVersion.getGroup() != lcaGroup)
                || (relAttributeVersion.getStatusNid() != lcaStatusNid)) {
            return false;
        }

        return true;
    }

    @Override
    public void initializeAttributes(ComponentVersionBI v) {
        RelationshipVersionBI relAttributeVersion = (RelationshipVersionBI) v;
        comparerInitialized = true;

        lcaOriginNid = relAttributeVersion.getOriginNid();
        lcaDestinationNid = relAttributeVersion.getDestinationNid();
        lcaRefinabilityNid = relAttributeVersion.getRefinabilityNid();
        lcaCharacteristicNid = relAttributeVersion.getCharacteristicNid();
        lcaGroup = relAttributeVersion.getGroup();
        lcaStatusNid = relAttributeVersion.getStatusNid();
    }
}