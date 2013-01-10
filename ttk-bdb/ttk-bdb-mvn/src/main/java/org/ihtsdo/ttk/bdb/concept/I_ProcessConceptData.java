package org.ihtsdo.ttk.bdb.concept;

import java.io.IOException;

import org.ihtsdo.ttk.bdb.temp.I_TrackContinuation;
import org.ihtsdo.ttk.api.NidBitSetBI;
import org.ihtsdo.ttk.cacco.cc.concept.Concept;

public interface I_ProcessConceptData extends I_TrackContinuation {

	public void processConceptData(Concept concept) throws Exception;
	
    public NidBitSetBI getNidSet() throws IOException;


}