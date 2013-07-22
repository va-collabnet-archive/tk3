package org.ihtsdo.ttk.concept.cs;

import java.io.IOException;

import org.ihtsdo.ttk.concept.cc.concept.ConceptChronicle;
import org.ihtsdo.otf.tcc.dto.TtkConceptChronicle;

public interface ComputeEConceptForChangeSetI {

	public TtkConceptChronicle getEConcept(ConceptChronicle c) throws IOException;

}