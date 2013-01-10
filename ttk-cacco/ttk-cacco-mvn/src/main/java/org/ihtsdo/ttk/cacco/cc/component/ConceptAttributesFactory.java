package org.ihtsdo.ttk.cacco.cc.component;

import java.io.IOException;

import org.ihtsdo.ttk.cacco.cc.concept.Concept;
import org.ihtsdo.ttk.cacco.cc.component.ComponentFactory;

import com.sleepycat.bind.tuple.TupleInput;
import org.ihtsdo.ttk.cacco.cc.attributes.ConceptAttributes;
import org.ihtsdo.ttk.cacco.cc.attributes.ConceptAttributesRevision;

public class ConceptAttributesFactory extends ComponentFactory<ConceptAttributesRevision, ConceptAttributes> {

	@Override
	public ConceptAttributes create(Concept enclosingConcept, 
			TupleInput input) throws IOException {
		return new ConceptAttributes(enclosingConcept, input);
	}

}
