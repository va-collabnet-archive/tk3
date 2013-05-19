package org.ihtsdo.ttk.concept.cs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ihtsdo.ttk.concept.cc.concept.Concept;
import org.ihtsdo.ttk.concept.cc.P;
import org.ihtsdo.ttk.helpers.time.TimeHelper;
import org.ihtsdo.ttk.api.ConceptFetcherBI;
import org.ihtsdo.ttk.api.NidBitSetBI;
import org.ihtsdo.ttk.api.NidSetBI;
import org.ihtsdo.ttk.api.ProcessUnfetchedConceptDataBI;
import org.ihtsdo.ttk.api.changeset.ChangeSetGenerationPolicy;
import org.ihtsdo.ttk.api.changeset.ChangeSetGeneratorBI;
import org.ihtsdo.ttk.api.cs.ChangeSetWriterThreading;

public class ChangeSetWriterHandler implements Runnable, ProcessUnfetchedConceptDataBI {

   private static ConcurrentHashMap<String, ChangeSetGeneratorBI> writerMap = new ConcurrentHashMap<>();
   public static AtomicInteger changeSetWriters = new AtomicInteger();
   private NidBitSetBI cNidsToWrite;
   private long commitTime;
   private String commitTimeStr;
   private NidSetBI sapNidsFromCommit;
   private long startTime = System.currentTimeMillis();
   private AtomicInteger processedCount = new AtomicInteger();
   private AtomicInteger processedChangedCount = new AtomicInteger();
   private int changedCount = Integer.MIN_VALUE;
   private ChangeSetWriterThreading changeSetWriterThreading;
   private ChangeSetGenerationPolicy changeSetPolicy;
   private List<ChangeSetGeneratorBI> writerListForHandler;

   public ChangeSetWriterHandler(NidBitSetBI cNidsToWrite,
           long commitTime, NidSetBI sapNidsFromCommit, ChangeSetGenerationPolicy changeSetPolicy,
           ChangeSetWriterThreading changeSetWriterThreading) {
      super();
      assert commitTime != Long.MAX_VALUE;
      assert commitTime != Long.MIN_VALUE;
      this.cNidsToWrite = cNidsToWrite;
      changedCount = cNidsToWrite.cardinality();
      this.commitTime = commitTime;
      this.commitTimeStr = TimeHelper.formatDate(commitTime)
              + " (" + cNidsToWrite.cardinality() + " concepts)";
      this.sapNidsFromCommit = sapNidsFromCommit;
      this.changeSetWriterThreading = changeSetWriterThreading;
      changeSetWriters.incrementAndGet();
      this.changeSetPolicy = changeSetPolicy;
      writerListForHandler = new ArrayList<>(writerMap.values());
   }

   @Override
   public void run() {
      try {

         for (ChangeSetGeneratorBI writer : writerListForHandler) {
            writer.open(sapNidsFromCommit);
         }
         switch (changeSetWriterThreading) {
            case MULTI_THREAD:
               P.s.iterateConceptDataInParallel(this);
               break;
            case SINGLE_THREAD:
               P.s.iterateConceptDataInSequence(this);
               break;
            default:
               throw new RuntimeException("Can't handle threading: " + changeSetWriterThreading);
         }

         for (ChangeSetGeneratorBI writer : writerListForHandler) {
            writer.commit();
         }
         long endTime = System.currentTimeMillis();

         long elapsed = endTime - startTime;
         String elapsedStr = TimeHelper.getElapsedTimeString(elapsed);

       } catch (Exception e) {
         ChangeSetLogger.logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
      } 
   }

   public static void addWriter(String key, ChangeSetGeneratorBI writer) {
      writerMap.put(key, writer);
   }

   public static void removeWriter(String key) {
      writerMap.remove(key);
   }

   @Override
   public void processUnfetchedConceptData(int cNid, ConceptFetcherBI fcfc) throws Exception {
      if (cNidsToWrite.isMember(cNid)) {
         processedChangedCount.incrementAndGet();
         Concept c = (Concept) fcfc.fetch();
         for (ChangeSetGeneratorBI writer : writerListForHandler) {
            writer.setPolicy(changeSetPolicy);
            writer.writeChanges(c, commitTime);
         }
      }
   }

   @Override
   public boolean continueWork() {
      // user cannot cancel operation
      return true;
   }

   @Override
   public NidBitSetBI getNidSet() {
      return cNidsToWrite;
   }

    @Override
    public boolean allowCancel() {
        return false;
    }

    @Override
    public String getTitle() {
        return "Writing change sets";
    }
}
