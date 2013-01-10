package org.ihtsdo.ttk.bdb.concept;

import org.ihtsdo.ttk.api.ConceptFetcherBI;
import org.ihtsdo.ttk.cacco.cc.concept.Concept;

public interface I_FetchConceptFromCursor  extends ConceptFetcherBI {

   @Override
    public Concept fetch() throws Exception;

}
