package org.ihtsdo.ttk.concept.cc.concept;

import org.ihtsdo.ttk.concept.cc.concept.Concept;


public interface I_BindConceptComponents {

	public Concept getEnclosingConcept();

	public void setupBinder(Concept enclosingConcept);

}