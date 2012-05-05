package org.ihtsdo.cs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.Timer;
import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.cc.P;
import org.ihtsdo.helper.time.TimeHelper;
import org.ihtsdo.bdb.temp.AceLog;
import org.ihtsdo.bdb.temp.ConsoleActivityViewer;
import org.ihtsdo.bdb.temp.I_ShowActivity;
import org.ihtsdo.tk.api.ConceptFetcherBI;
import org.ihtsdo.tk.api.NidBitSetBI;
import org.ihtsdo.tk.api.NidSetBI;
import org.ihtsdo.tk.api.ProcessUnfetchedConceptDataBI;
import org.ihtsdo.tk.api.changeset.ChangeSetGenerationPolicy;
import org.ihtsdo.tk.api.changeset.ChangeSetGeneratorBI;
import org.ihtsdo.tk.api.cs.ChangeSetWriterThreading;

public class ChangeSetWriterHandler implements Runnable, ProcessUnfetchedConceptDataBI, ActionListener {

   private static ConcurrentHashMap<String, ChangeSetGeneratorBI> writerMap = new ConcurrentHashMap<>();
   public static AtomicInteger changeSetWriters = new AtomicInteger();
   private NidBitSetBI cNidsToWrite;
   private long commitTime;
   private String commitTimeStr;
   private NidSetBI sapNidsFromCommit;
   private I_ShowActivity activity;
   private long startTime = System.currentTimeMillis();
   private AtomicInteger processedCount = new AtomicInteger();
   private AtomicInteger processedChangedCount = new AtomicInteger();
   private int changedCount = Integer.MIN_VALUE;
   private ChangeSetWriterThreading changeSetWriterThreading;
   private ChangeSetGenerationPolicy changeSetPolicy;
   private Timer timer;
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

         activity = new ConsoleActivityViewer();
         activity.setIndeterminate(true);
         activity.setProgressInfoUpper("CS writer: " + commitTimeStr + "...");
         activity.setProgressInfoLower("Opening change set writers...");
         timer = new Timer(2000, this);
         timer.start();
         activity.setStopButtonVisible(false);
         for (ChangeSetGeneratorBI writer : writerListForHandler) {
            writer.open(sapNidsFromCommit);
         }
         activity.setValue(0);
         activity.setMaximum(changedCount);
         activity.setIndeterminate(false);

         activity.setProgressInfoLower("Iterating over concepts...");
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

         activity.setProgressInfoLower("Committing change set writers...");
         for (ChangeSetGeneratorBI writer : writerListForHandler) {
            writer.commit();
         }
         long endTime = System.currentTimeMillis();

         long elapsed = endTime - startTime;
         String elapsedStr = TimeHelper.getElapsedTimeString(elapsed);

         activity.setProgressInfoUpper("Change sets written for: " + commitTimeStr);
         activity.setProgressInfoLower("Elapsed: " + elapsedStr);
         activity.complete();
      } catch (Exception e) {
         AceLog.getAppLog().alertAndLogException(e);
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
   public void actionPerformed(ActionEvent e) {
      int completed = processedCount.incrementAndGet();
      activity.setValue(completed);
      long endTime = System.currentTimeMillis();
      long elapsed = endTime - startTime;
      String elapsedStr = TimeHelper.getElapsedTimeString(elapsed);

      String remainingStr = TimeHelper.getRemainingTimeString(completed, changedCount, elapsed);

      activity.setProgressInfoLower("Elapsed: " + elapsedStr + ";  Remaining: " + remainingStr
              + " processed: " + processedChangedCount + "/" + changedCount);
      if (activity.isCompleteForComparison()) {
         timer.stop();
      }
   }
   
   @Override
   public NidBitSetBI getNidSet() {
      return cNidsToWrite;
   }
}