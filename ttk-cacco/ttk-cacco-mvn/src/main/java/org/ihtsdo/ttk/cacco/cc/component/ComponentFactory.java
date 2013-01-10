package org.ihtsdo.ttk.cacco.cc.component;

import java.io.IOException;

import org.ihtsdo.ttk.cacco.cc.concept.Concept;

import com.sleepycat.bind.tuple.TupleInput;
import org.ihtsdo.ttk.cacco.cc.component.ConceptComponent;
import org.ihtsdo.ttk.cacco.cc.component.Revision;

public abstract class ComponentFactory<V extends Revision<V, C>, C extends ConceptComponent<V, C>> {
	
	public abstract C create(Concept enclosingConcept, TupleInput input) throws IOException;

}
