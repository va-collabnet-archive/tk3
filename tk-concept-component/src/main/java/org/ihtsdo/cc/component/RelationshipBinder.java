package org.ihtsdo.cc.component;

import java.util.concurrent.atomic.AtomicInteger;

import org.ihtsdo.cc.component.ConceptComponentBinder;
import org.ihtsdo.cc.relationship.Relationship;
import org.ihtsdo.cc.relationship.RelationshipRevision;

public class RelationshipBinder extends ConceptComponentBinder<RelationshipRevision, Relationship> {

	public static AtomicInteger encountered = new AtomicInteger();
	public static AtomicInteger written = new AtomicInteger();

	public RelationshipBinder() {
		super(new RelationshipFactory(), encountered, written);
	}

}
