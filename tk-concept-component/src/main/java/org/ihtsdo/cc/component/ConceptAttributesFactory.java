package org.ihtsdo.cc.component;

import java.io.IOException;

import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.cc.component.ComponentFactory;

import com.sleepycat.bind.tuple.TupleInput;
import org.ihtsdo.cc.attributes.ConceptAttributes;
import org.ihtsdo.cc.attributes.ConceptAttributesRevision;

public class ConceptAttributesFactory extends ComponentFactory<ConceptAttributesRevision, ConceptAttributes> {

	@Override
	public ConceptAttributes create(Concept enclosingConcept, 
			TupleInput input) throws IOException {
		return new ConceptAttributes(enclosingConcept, input);
	}

}
