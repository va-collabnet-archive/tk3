package org.ihtsdo.bdb.concept.component;

import java.io.IOException;

import org.ihtsdo.concept.Concept;
import org.ihtsdo.bdb.concept.component.ComponentFactory;

import com.sleepycat.bind.tuple.TupleInput;
import org.ihtsdo.concept.component.attributes.ConceptAttributes;
import org.ihtsdo.concept.component.attributes.ConceptAttributesRevision;

public class ConceptAttributesFactory extends ComponentFactory<ConceptAttributesRevision, ConceptAttributes> {

	@Override
	public ConceptAttributes create(Concept enclosingConcept, 
			TupleInput input) throws IOException {
		return new ConceptAttributes(enclosingConcept, input);
	}

}
