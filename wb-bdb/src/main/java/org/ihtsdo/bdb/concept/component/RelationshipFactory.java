package org.ihtsdo.bdb.concept.component;

import java.io.IOException;

import org.ihtsdo.concept.Concept;
import org.ihtsdo.bdb.concept.component.ComponentFactory;

import com.sleepycat.bind.tuple.TupleInput;
import org.ihtsdo.concept.component.relationship.Relationship;
import org.ihtsdo.concept.component.relationship.RelationshipRevision;

public class RelationshipFactory extends ComponentFactory<RelationshipRevision, Relationship> {

	@Override
	public Relationship create(Concept enclosingConcept, 
			TupleInput input) throws IOException {
		return new Relationship(enclosingConcept, 
				input);
	}

}
