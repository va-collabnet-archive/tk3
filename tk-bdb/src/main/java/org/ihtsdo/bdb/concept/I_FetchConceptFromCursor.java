package org.ihtsdo.bdb.concept;

import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.tk.api.ConceptFetcherBI;

public interface I_FetchConceptFromCursor  extends ConceptFetcherBI {

   @Override
    public Concept fetch() throws Exception;

}
