package org.ihtsdo.ttk.concept.cc.lucene;

import java.io.IOException;

import org.apache.lucene.index.IndexWriter;
import org.ihtsdo.ttk.concept.cc.P;
import org.ihtsdo.ttk.api.NidBitSetBI;
import org.ihtsdo.ttk.api.ProcessUnfetchedConceptDataBI;

public abstract class IndexGenerator implements ProcessUnfetchedConceptDataBI {

    protected IndexWriter writer;
    protected NidBitSetBI nidSet;
    protected int lineCounter = 0;

    @Override
    public NidBitSetBI getNidSet() {
        return nidSet;
    }

    public IndexGenerator(IndexWriter writer) throws IOException {
        super();
        this.writer = writer;
        this.nidSet = P.s.getAllConceptNids();
    }

    @Override
    public boolean continueWork() {
        return true;
    }
}
