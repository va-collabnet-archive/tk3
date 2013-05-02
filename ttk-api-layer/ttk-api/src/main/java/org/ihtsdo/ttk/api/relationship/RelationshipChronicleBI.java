package org.ihtsdo.ttk.api.relationship;

import org.ihtsdo.ttk.api.ComponentChronicleBI;

public interface RelationshipChronicleBI extends ComponentChronicleBI<RelationshipVersionBI> {

    int getOriginNid();

    int getDestinationNid();
}
