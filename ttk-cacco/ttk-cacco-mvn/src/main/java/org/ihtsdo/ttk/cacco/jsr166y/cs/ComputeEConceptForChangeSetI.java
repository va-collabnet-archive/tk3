package org.ihtsdo.ttk.cacco.jsr166y.cs;

import java.io.IOException;

import org.ihtsdo.ttk.cacco.cc.concept.Concept;
import org.ihtsdo.ttk.dto.TkConcept;

public interface ComputeEConceptForChangeSetI {

	public TkConcept getEConcept(Concept c) throws IOException;

}