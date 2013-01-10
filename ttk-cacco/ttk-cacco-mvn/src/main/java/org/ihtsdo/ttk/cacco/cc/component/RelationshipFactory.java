package org.ihtsdo.ttk.cacco.cc.component;

import java.io.IOException;

import org.ihtsdo.ttk.cacco.cc.concept.Concept;
import org.ihtsdo.ttk.cacco.cc.component.ComponentFactory;

import com.sleepycat.bind.tuple.TupleInput;
import org.ihtsdo.ttk.cacco.cc.relationship.Relationship;
import org.ihtsdo.ttk.cacco.cc.relationship.RelationshipRevision;

public class RelationshipFactory extends ComponentFactory<RelationshipRevision, Relationship> {

	@Override
	public Relationship create(Concept enclosingConcept, 
			TupleInput input) throws IOException {
		return new Relationship(enclosingConcept, 
				input);
	}

}
