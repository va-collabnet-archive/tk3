package org.ihtsdo.ttk.concept.cc.concept;

import org.ihtsdo.ttk.concept.cc.concept.ConceptChronicle;


public interface I_BindConceptComponents {

	public ConceptChronicle getEnclosingConcept();

	public void setupBinder(ConceptChronicle enclosingConcept);

}