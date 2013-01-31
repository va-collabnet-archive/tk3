package org.ihtsdo.ttk.concept.cc.component;

import java.io.IOException;

import org.ihtsdo.ttk.concept.cc.concept.Concept;
import org.ihtsdo.ttk.concept.cc.component.ComponentFactory;

import com.sleepycat.bind.tuple.TupleInput;
import org.ihtsdo.ttk.concept.cc.description.Description;
import org.ihtsdo.ttk.concept.cc.description.DescriptionRevision;

public class DescriptionFactory extends ComponentFactory<DescriptionRevision, Description> {

	@Override
	public Description create(Concept enclosingConcept, TupleInput input) throws IOException {
		return new Description(enclosingConcept, input);
	}

}
