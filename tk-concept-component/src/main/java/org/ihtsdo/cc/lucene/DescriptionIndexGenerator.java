package org.ihtsdo.cc.lucene;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.ihtsdo.cc.P;
import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.helper.uuid.Type5UuidFactory;
import org.ihtsdo.tk.api.ComponentBI;
import org.ihtsdo.tk.api.ConceptFetcherBI;
import org.ihtsdo.tk.api.description.DescriptionChronicleBI;
import org.ihtsdo.tk.api.description.DescriptionVersionBI;
import org.ihtsdo.tk.api.id.IdBI;
import org.ihtsdo.tk.api.id.UuidIdBI;

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
		
		String lastDesc = null;
		for (DescriptionVersionBI tuple : desc.getVersions()) {
		    if (lastDesc == null || lastDesc.equals(tuple.getText()) == false) {
		        doc.add(new Field("desc", tuple.getText(), Field.Store.NO, Field.Index.ANALYZED));
		    }
		}
		return doc;
    }

    private static void addIdsToIndex(ComponentBI c) throws IOException {
        if (c != null) {
            int nid = c.getNid();
            for (IdBI p : c.getAllIds()) {
                UUID uuid;
                if (p instanceof UuidIdBI) {
                    UuidIdBI uuidId = (UuidIdBI) p;
                    uuid = uuidId.getDenotation();
                } else {
                    try {
                        uuid = Type5UuidFactory.get(P.s.getUuidPrimordialForNid(p.getAuthorityNid()), p.getDenotation().toString());
                    } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
                        throw new RuntimeException(ex);
                    } 
                }
                P.s.put(uuid, nid);
            }
        }
    }
}
