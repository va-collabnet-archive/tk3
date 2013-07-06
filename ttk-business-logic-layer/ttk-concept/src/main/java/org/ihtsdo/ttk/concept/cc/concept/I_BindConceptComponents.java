package org.ihtsdo.ttk.concept.cc.concept;


public interface I_BindConceptComponents {

	public ConceptChronicle getEnclosingConcept();

	public void setupBinder(ConceptChronicle enclosingConcept);

}