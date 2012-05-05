package org.ihtsdo.cc.lucene;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.tk.api.ComponentBI;
import org.ihtsdo.tk.api.ConceptFetcherBI;
import org.ihtsdo.tk.api.description.DescriptionChronicleBI;
import org.ihtsdo.tk.api.description.DescriptionVersionBI;
import org.ihtsdo.tk.api.id.IdBI;

public class DescriptionIndexGenerator extends IndexGenerator {

    private int descCounter = 0;
    private int conceptCounter = 0;
    private int feedbackInterval = 1000;

    public DescriptionIndexGenerator(IndexWriter writer) throws IOException {
		super(writer);
	}


    @Override
    public void processUnfetchedConceptData(int cNid, ConceptFetcherBI fetcher) throws Exception {
        conceptCounter++;
        for (DescriptionChronicleBI d : fetcher.fetch().getDescs()) {
            writer.addDocument(createDoc(d));
            descCounter++;

            if (descCounter % feedbackInterval == 0) {
                System.out.print(".");
                lineCounter++;
                if (lineCounter > 80) {
                    lineCounter = 0;
                    System.out.println();
                    System.out.print("c:" + conceptCounter
                            + " d:" + descCounter);
                }
            }
        }
    }

    public static Document createDoc(DescriptionChronicleBI desc)
    throws IOException {
		Document doc = new Document();
		doc.add(new Field("dnid", Integer.toString(desc.getNid()), Field.Store.YES, Field.Index.NOT_ANALYZED));
		doc.add(new Field("cnid", Integer.toString(desc.getConceptNid()), Field.Store.YES, Field.Index.NOT_ANALYZED));
		addIdsToIndex(doc, desc);
		addIdsToIndex(doc, Concept.get(desc.getConceptNid()).getConceptAttributes());
		
		String lastDesc = null;
		for (DescriptionVersionBI tuple : desc.getVersions()) {
		    if (lastDesc == null || lastDesc.equals(tuple.getText()) == false) {
		        doc.add(new Field("desc", tuple.getText(), Field.Store.NO, Field.Index.ANALYZED));
		    }
		}
		return doc;
    }

    private static void addIdsToIndex(Document doc, ComponentBI c) throws IOException {
        if (c != null) {
            for (IdBI p : c.getAllIds()) {
                doc.add(new Field("desc", p.getDenotation().toString(), Field.Store.NO,
                        Field.Index.ANALYZED));
            }
        }
    }
}
