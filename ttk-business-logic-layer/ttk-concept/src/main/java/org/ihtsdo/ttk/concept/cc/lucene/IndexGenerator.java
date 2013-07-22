package org.ihtsdo.ttk.concept.cc.lucene;

import java.io.IOException;

import org.apache.lucene.index.IndexWriter;
import org.ihtsdo.ttk.api.NativeIdSetBI;
import org.ihtsdo.ttk.concept.cc.P;
import org.ihtsdo.ttk.api.ProcessUnfetchedConceptDataBI;

public abstract class IndexGenerator implements ProcessUnfetchedConceptDataBI {

    protected IndexWriter writer;
    protected NativeIdSetBI nidSet;
    protected int lineCounter = 0;

    @Override
    public NativeIdSetBI getNidSet() {
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
