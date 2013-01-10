package org.ihtsdo.ttk.cacco.cc.component;

import java.io.IOException;

import org.ihtsdo.ttk.cacco.cc.concept.Concept;
import org.ihtsdo.ttk.cacco.cc.component.ComponentFactory;

import com.sleepycat.bind.tuple.TupleInput;
import org.ihtsdo.ttk.cacco.cc.description.Description;
import org.ihtsdo.ttk.cacco.cc.description.DescriptionRevision;

public class DescriptionFactory extends ComponentFactory<DescriptionRevision, Description> {

	@Override
	public Description create(Concept enclosingConcept, TupleInput input) throws IOException {
		return new Description(enclosingConcept, input);
	}

}
