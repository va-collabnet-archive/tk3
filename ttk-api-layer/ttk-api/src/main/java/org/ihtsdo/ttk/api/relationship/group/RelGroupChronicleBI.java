package org.ihtsdo.ttk.api.relationship.group;

import java.util.Collection;

import org.ihtsdo.ttk.api.ComponentChronicleBI;
import org.ihtsdo.ttk.api.relationship.RelationshipChronicleBI;

public interface RelGroupChronicleBI extends ComponentChronicleBI<RelGroupVersionBI> {
	
	public Collection<? extends RelationshipChronicleBI> getRels();
	
	public int getRelGroup();
}
