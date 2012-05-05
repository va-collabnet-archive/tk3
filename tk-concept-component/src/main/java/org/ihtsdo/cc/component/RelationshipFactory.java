package org.ihtsdo.cc.component;

import java.io.IOException;

import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.cc.component.ComponentFactory;

import com.sleepycat.bind.tuple.TupleInput;
import org.ihtsdo.cc.relationship.Relationship;
import org.ihtsdo.cc.relationship.RelationshipRevision;

public class RelationshipFactory extends ComponentFactory<RelationshipRevision, Relationship> {

	@Override
	public Relationship create(Concept enclosingConcept, 
			TupleInput input) throws IOException {
		return new Relationship(enclosingConcept, 
				input);
	}

}
