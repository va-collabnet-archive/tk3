package org.ihtsdo.ttk.concept.jsr166y.cs;

import java.io.IOException;

import org.ihtsdo.ttk.concept.cc.concept.Concept;
import org.ihtsdo.ttk.dto.TkConcept;

public interface ComputeEConceptForChangeSetI {

	public TkConcept getEConcept(Concept c) throws IOException;

}