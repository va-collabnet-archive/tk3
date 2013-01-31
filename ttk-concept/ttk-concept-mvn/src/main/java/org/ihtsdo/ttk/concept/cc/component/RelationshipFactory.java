package org.ihtsdo.ttk.concept.cc.component;

import java.io.IOException;

import org.ihtsdo.ttk.concept.cc.concept.Concept;
import org.ihtsdo.ttk.concept.cc.component.ComponentFactory;

import com.sleepycat.bind.tuple.TupleInput;
import org.ihtsdo.ttk.concept.cc.relationship.Relationship;
import org.ihtsdo.ttk.concept.cc.relationship.RelationshipRevision;

public class RelationshipFactory extends ComponentFactory<RelationshipRevision, Relationship> {

	@Override
	public Relationship create(Concept enclosingConcept, 
			TupleInput input) throws IOException {
		return new Relationship(enclosingConcept, 
				input);
	}

}
