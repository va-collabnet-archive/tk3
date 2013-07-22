package org.ihtsdo.otf.tcc.api.relationship;

import org.ihtsdo.otf.tcc.api.ComponentChronicleBI;

public interface RelationshipChronicleBI extends ComponentChronicleBI<RelationshipVersionBI> {

    int getOriginNid();

    int getDestinationNid();
}
