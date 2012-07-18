/*
 * Copyright 2012 International Health Terminology Standards Development Organisation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ihtsdo.cc.termstore;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.ihtsdo.cc.NidPair;
import org.ihtsdo.cc.NidPairForRefex;
import org.ihtsdo.cc.NidPairForRel;
import org.ihtsdo.cc.concept.ConceptDataFetcherI;
import org.ihtsdo.tk.api.NidSetBI;
import org.ihtsdo.tk.api.TerminologyStoreDI;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.cs.ChangeSetPolicy;
import org.ihtsdo.tk.api.cs.ChangeSetWriterThreading;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;

/**
 *
 * @author kec
 */
public interface PersistentStoreI extends TerminologyStoreDI {
   int getStampNid(int statusNid, long time, int authorNid, int moduleNid, int pathNid);
   int getMaxReadOnlyStamp();
   void xrefAnnotation(RefexChronicleBI annotation) throws IOException;
   boolean hasConcept(int cNid) throws IOException;


    long getLastCancel();
    long getLastCommit();
    long incrementAndGetSequence();
    void waitTillWritesFinished();

    boolean commit(ConceptChronicleBI cc, ChangeSetPolicy changeSetPolicy,
            ChangeSetWriterThreading changeSetWriterThreading) throws IOException;

    
    
    Map<String, String> getProperties() throws IOException;
    String getProperty(String key) throws IOException;
    void setProperty(String key, String value) throws IOException;
    void cancelAfterCommit(NidSetBI commitSapNids) throws IOException;
    
    // Method to wrap for client...
    ConceptDataFetcherI getConceptDataFetcher(int cNid) throws IOException;
    
    // Methods to remove from this interface...
    
    void addXrefPair(int nid, NidPair pair);
    void forgetXrefPair(int nid, NidPair pair);
   /**
    * @TODO modify the write concept routine to update the identifiers map (UUIDs, etc)
    * Possibly remove identifiers from Lucene?
    */
    List<NidPairForRel> getDestRelPairs(int cNid) throws IOException;
    List<NidPairForRefex> getRefexPairs(int nid) throws IOException;
    int[] getDestRelOriginNids(int cNid, NidSetBI relTypes) throws IOException;
   // For a lower level interface? 
   void setConceptNidForNid(int cNid, int nid) throws IOException;
   void resetConceptNidForNid(int cNid, int nid) throws IOException;
    
    

}
