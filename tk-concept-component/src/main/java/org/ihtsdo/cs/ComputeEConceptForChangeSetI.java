package org.ihtsdo.cs;

import java.io.IOException;

import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.tk.dto.concept.TkConcept;

public interface ComputeEConceptForChangeSetI {

	public TkConcept getEConcept(Concept c) throws IOException;

}