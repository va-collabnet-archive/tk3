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



package org.ihtdo.tk.metrics;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.api.ComponentChroncileBI;
import org.ihtsdo.tk.api.ConceptFetcherBI;
import org.ihtsdo.tk.api.NidBitSetBI;
import org.ihtsdo.tk.api.ProcessComponentChronicleBI;
import org.ihtsdo.tk.api.ProcessUnfetchedConceptDataBI;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author kec
 */
public class SequentialFetchMetrics implements ProcessComponentChronicleBI, ProcessUnfetchedConceptDataBI {
   AtomicInteger                        processedConceptCount   = new AtomicInteger(0);
   AtomicInteger                        processedComponentCount = new AtomicInteger(0);
   ConcurrentSkipListMap<Integer, Long> processChronicleTime    = new ConcurrentSkipListMap<>();
   long                                 metricsStart            = System.currentTimeMillis();
   ConcurrentSkipListMap<Integer, Long> fetchTime               = new ConcurrentSkipListMap<>();

   //~--- methods -------------------------------------------------------------

   @Override
   public boolean continueWork() {
      return true;
   }

   @Override
   public void process(ComponentChroncileBI cc) throws Exception {
      processedComponentCount.incrementAndGet();
   }

   @Override
   public void processUnfetchedConceptData(int cNid, ConceptFetcherBI fetcher) throws Exception {
      processedConceptCount.incrementAndGet();

      long               fetchStart = System.nanoTime();
      ConceptChronicleBI cc         = fetcher.fetch();
      long               fetchEnd   = System.nanoTime();

      fetchTime.put(cNid, fetchEnd - fetchStart);

      long processComponentStart = System.nanoTime();

      cc.processComponentChronicles(this);

      long processComponentEnd = System.nanoTime();

      processChronicleTime.put(cNid, processComponentEnd - processComponentStart);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public NidBitSetBI getNidSet() throws IOException {
      return null;
   }
}
