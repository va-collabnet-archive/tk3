package org.ihtsdo.ttk.api.relationship;

import org.ihtsdo.ttk.api.ComponentChroncileBI;

public interface RelationshipChronicleBI extends ComponentChroncileBI<RelationshipVersionBI> {

    int getOriginNid();

    int getDestinationNid();
}
