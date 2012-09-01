package org.ihtsdo.bdb.concept;

import java.util.List;

import org.ihtsdo.bdb.temp.I_TrackContinuation;
import org.ihtsdo.tk.api.ProcessUnfetchedConceptDataBI;

public interface I_ProcessUnfetchedConceptData extends I_TrackContinuation,
        ProcessUnfetchedConceptDataBI {

     public void setParallelConceptIterators(List<ParallelConceptIterator> pcis);
     
}
