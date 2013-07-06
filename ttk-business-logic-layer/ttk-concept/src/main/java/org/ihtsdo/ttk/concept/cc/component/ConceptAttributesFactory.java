package org.ihtsdo.ttk.concept.cc.component;

import java.io.IOException;

import org.ihtsdo.ttk.concept.cc.concept.ConceptChronicle;

import com.sleepycat.bind.tuple.TupleInput;
import org.ihtsdo.ttk.concept.cc.attributes.ConceptAttributes;
import org.ihtsdo.ttk.concept.cc.attributes.ConceptAttributesRevision;

public class ConceptAttributesFactory extends ComponentFactory<ConceptAttributesRevision, ConceptAttributes> {

	@Override
	public ConceptAttributes create(ConceptChronicle enclosingConcept, 
			TupleInput input) throws IOException {
		return new ConceptAttributes(enclosingConcept, input);
	}

}
