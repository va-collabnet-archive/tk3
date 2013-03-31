package org.ihtsdo.ttk.bdb.concept;

import java.util.List;

import org.ihtsdo.ttk.bdb.temp.I_TrackContinuation;
import org.ihtsdo.ttk.api.ProcessUnfetchedConceptDataBI;

public interface I_ProcessUnfetchedConceptData extends I_TrackContinuation,
        ProcessUnfetchedConceptDataBI {

     public void setParallelConceptIterators(List<ParallelConceptIterator> pcis);
     
}
