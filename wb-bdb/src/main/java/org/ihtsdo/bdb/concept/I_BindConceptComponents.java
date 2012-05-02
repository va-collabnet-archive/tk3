package org.ihtsdo.bdb.concept;

import org.ihtsdo.concept.Concept;


public interface I_BindConceptComponents {

	public Concept getEnclosingConcept();

	public void setupBinder(Concept enclosingConcept);

}