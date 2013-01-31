package org.ihtsdo.ttk.concept.cc.component;

import java.util.concurrent.atomic.AtomicInteger;

import org.ihtsdo.ttk.concept.cc.component.ConceptComponentBinder;
import org.ihtsdo.ttk.concept.cc.relationship.Relationship;
import org.ihtsdo.ttk.concept.cc.relationship.RelationshipRevision;

public class RelationshipBinder extends ConceptComponentBinder<RelationshipRevision, Relationship> {

	public static AtomicInteger encountered = new AtomicInteger();
	public static AtomicInteger written = new AtomicInteger();

	public RelationshipBinder() {
		super(new RelationshipFactory(), encountered, written);
	}

}
