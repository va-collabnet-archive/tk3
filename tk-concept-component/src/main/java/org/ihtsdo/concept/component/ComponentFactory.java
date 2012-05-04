package org.ihtsdo.concept.component;

import java.io.IOException;

import org.ihtsdo.concept.Concept;

import com.sleepycat.bind.tuple.TupleInput;
import org.ihtsdo.concept.component.ConceptComponent;
import org.ihtsdo.concept.component.Revision;

public abstract class ComponentFactory<V extends Revision<V, C>, C extends ConceptComponent<V, C>> {
	
	public abstract C create(Concept enclosingConcept, TupleInput input) throws IOException;

}
