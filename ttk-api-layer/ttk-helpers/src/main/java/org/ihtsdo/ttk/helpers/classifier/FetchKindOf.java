/*
 * Copyright 2013 International Health Terminology Standards Development Organisation.
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
package org.ihtsdo.ttk.helpers.classifier;

import java.io.IOException;
import org.ihtsdo.ttk.api.ConceptFetcherBI;
import org.ihtsdo.ttk.api.NidBitSetBI;
import org.ihtsdo.ttk.api.ProcessUnfetchedConceptDataBI;
import org.ihtsdo.ttk.api.TerminologyStoreDI;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;

/**
 *
 * @author kec
 */
public class FetchKindOf implements ProcessUnfetchedConceptDataBI {
   private int                kindOfNid;
   private TerminologyStoreDI store;
   private ViewCoordinate     vc;
   private NidBitSetBI        kindOfBitSet;

    public NidBitSetBI getKindOfBitSet() {
        return kindOfBitSet;
    }
   

    public FetchKindOf(int kindOfNid, ViewCoordinate vc) throws IOException {
        this.kindOfNid = kindOfNid;
        this.vc = vc;
        this.store = Ts.get();
        this.kindOfBitSet = store.getEmptyNidSet();
        
    }

   //~--- methods -------------------------------------------------------------

   @Override
   public boolean continueWork() {
      return true;
   }

   @Override
   public void processUnfetchedConceptData(int cNid, ConceptFetcherBI fetcher) throws Exception {
      if (store.isKindOf(cNid, kindOfNid, vc)) {
         kindOfBitSet.setMember(cNid);
      } 
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public NidBitSetBI getNidSet() throws IOException {
      return null;
   }
}
