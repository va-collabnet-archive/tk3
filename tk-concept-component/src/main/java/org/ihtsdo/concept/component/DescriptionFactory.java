package org.ihtsdo.concept.component;

import java.io.IOException;

import org.ihtsdo.concept.Concept;
import org.ihtsdo.concept.component.ComponentFactory;

import com.sleepycat.bind.tuple.TupleInput;
import org.ihtsdo.concept.component.description.Description;
import org.ihtsdo.concept.component.description.DescriptionRevision;

public class DescriptionFactory extends ComponentFactory<DescriptionRevision, Description> {

	@Override
	public Description create(Concept enclosingConcept, TupleInput input) throws IOException {
		return new Description(enclosingConcept, input);
	}

}
