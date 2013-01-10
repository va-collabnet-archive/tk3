package org.ihtsdo.ttk.cacco.cc.concept;

import org.ihtsdo.ttk.cacco.cc.concept.Concept;


public interface I_BindConceptComponents {

	public Concept getEnclosingConcept();

	public void setupBinder(Concept enclosingConcept);

}