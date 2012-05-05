package org.ihtsdo.cc.component;

import java.io.IOException;

import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.cc.component.ComponentFactory;

import com.sleepycat.bind.tuple.TupleInput;
import org.ihtsdo.cc.description.Description;
import org.ihtsdo.cc.description.DescriptionRevision;

public class DescriptionFactory extends ComponentFactory<DescriptionRevision, Description> {

	@Override
	public Description create(Concept enclosingConcept, TupleInput input) throws IOException {
		return new Description(enclosingConcept, input);
	}

}
