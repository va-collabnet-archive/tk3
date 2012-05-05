package org.ihtsdo.cc.concept;

import org.ihtsdo.cc.concept.Concept;


public interface I_BindConceptComponents {

	public Concept getEnclosingConcept();

	public void setupBinder(Concept enclosingConcept);

}