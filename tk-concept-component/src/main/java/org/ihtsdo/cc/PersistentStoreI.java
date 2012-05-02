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
package org.ihtsdo.cc;

import java.io.IOException;
import java.util.List;
import org.ihtsdo.tk.api.TerminologyStoreDI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;

/**
 *
 * @author kec
 */
public interface PersistentStoreI extends TerminologyStoreDI {
    
   int getPathNidForSapNid(int sapNid);
   int getAuthorNidForSapNid(int sapNid);
   int getStatusNidForSapNid(int sapNid);
   long getTimeForSapNid(int sapNid);
   
   // For a lower level interface? 
   void setConceptNidForNid(int cNid, int nid) throws IOException;
   void resetConceptNidForNid(int cNid, int nid) throws IOException;
   int getSapNid(int statusNid, int authorNid, int pathNid, long time);
   int getMaxReadOnlySap();
   int getSapNid(TkRevision version);
   void xrefAnnotation(RefexChronicleBI annotation) throws IOException;
   boolean hasConcept(int cNid) throws IOException;
   /**
    * @TODO modify the write concept routine to update the identifiers map (UUIDs, etc)
    * Possibly remove identifiers from Lucene?
    */
   List<NidPairForRel> getDestRelPairs(int cNid);

    List<NidPairForRefset> getRefsetPairs(int nid);

}
