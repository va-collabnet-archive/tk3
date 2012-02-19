package org.ihtsdo.db.bdb;

//~--- non-JDK imports --------------------------------------------------------
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.ihtsdo.concept.Concept;
import org.ihtsdo.concept.component.ConceptComponent;
import org.ihtsdo.concept.component.attributes.ConceptAttributes;
import org.ihtsdo.concept.component.attributes.ConceptAttributesRevision;
import org.ihtsdo.concept.component.description.Description;
import org.ihtsdo.concept.component.description.DescriptionRevision;
import org.ihtsdo.concept.component.identifier.IdentifierSet;
import org.ihtsdo.concept.component.refex.RefexMember;
import org.ihtsdo.concept.component.refex.RefexRevision;
import org.ihtsdo.concept.component.relationship.Relationship;
import org.ihtsdo.concept.component.relationship.RelationshipRevision;
import org.ihtsdo.cs.ChangeSetWriterHandler;
import org.ihtsdo.db.bdb.computer.kindof.KindOfComputer;
import org.ihtsdo.db.bdb.id.NidCNidMapBdb;
import org.ihtsdo.db.change.BdbCommitSequence;
import org.ihtsdo.db.change.LastChange;
import org.ihtsdo.helper.thread.NamedThreadFactory;
import org.ihtsdo.lucene.LuceneManager;
import org.ihtsdo.temp.AceLog;
import org.ihtsdo.temp.DwfaEnv;
import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.*;
import org.ihtsdo.tk.api.conattr.ConAttrVersionBI;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.cs.ChangeSetPolicy;
import org.ihtsdo.tk.api.cs.ChangeSetWriterThreading;
import org.ihtsdo.tk.api.description.DescriptionVersionBI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.relationship.RelationshipVersionBI;

public class BdbCommitManager {

    private static final int PERMIT_COUNT = 50;
    public static String pluginRoot = "plugins";
    private static final AtomicInteger writerCount = new AtomicInteger(0);
    private static boolean writeChangeSets = true;
    private static NidBitSetBI uncommittedDescNids = new IdentifierSet();
    private static NidBitSetBI uncommittedCNidsNoChecks = new IdentifierSet();
    private static NidBitSetBI uncommittedCNids = new IdentifierSet();
    private static boolean performCreationTests = true;
    private static boolean performCommitTests = true;
    private static Semaphore luceneWriterPermit = new Semaphore(PERMIT_COUNT);
    private static AtomicReference<Concept> lastUncommitted = new AtomicReference<Concept>();
    private static long lastDoUpdate = Long.MIN_VALUE;
    private static long lastCommit = Bdb.gVersion.incrementAndGet();
    private static long lastCancel = Integer.MIN_VALUE;
    private static Semaphore dbWriterPermit = new Semaphore(PERMIT_COUNT);
//    private static List<I_TestDataConstraints> creationTests =
//            new ArrayList<I_TestDataConstraints>();
//    private static List<I_TestDataConstraints> commitTests =
//            new ArrayList<I_TestDataConstraints>();
    private static ThreadGroup commitManagerThreadGroup =
            new ThreadGroup("commit manager threads");
    private static ExecutorService changeSetWriterService;
    private static ExecutorService dbWriterService;
    private static ExecutorService luceneWriterService;
    /**
     * <p> listeners </p>
     */
    private static ICommitListener[] listeners = new ICommitListener[0];
    //J-
//    private static ConcurrentHashMap<I_GetConceptData, Collection<AlertToDataConstraintFailure>> dataCheckMap =
//            new ConcurrentHashMap<I_GetConceptData, Collection<AlertToDataConstraintFailure>>();
    //J+

    //~--- static initializers -------------------------------------------------
    static {
        reset();
    }

    //~--- methods -------------------------------------------------------------
    public static void addUncommitted(ConceptChronicleBI igcd) {
        if (igcd == null) {
            return;
        }

        try {
            KindOfComputer.updateIsaCache(igcd.getNid());
        } catch (Exception ex) {
            AceLog.getAppLog().alertAndLogException(ex);
        }

        Concept concept = (Concept) igcd;

        LastChange.touch(concept);
//        dataCheckMap.remove(concept);
        GlobalPropertyChange.firePropertyChange(TerminologyStoreDI.CONCEPT_EVENT.ADD_UNCOMMITTED, null, concept);

        if (concept.isUncommitted() == false) {
            if (Bdb.watchList.containsKey(concept.getNid())) {
                AceLog.getAppLog().info("--- Removing uncommitted concept: " + concept.getNid() + " --- ");
            }

            removeUncommitted(concept);

            try {
                dbWriterPermit.acquire();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

            dbWriterService.execute(new SetNidsForCid(concept));
            dbWriterService.execute(new ConceptWriter(concept));

            return;
        }

        concept.modified();

        if (Bdb.watchList.containsKey(concept.getNid())) {
            AceLog.getAppLog().info("---@@@ Adding uncommitted concept: " + concept.getNid() + " ---@@@ ");
        }

        try {
//            if (performCreationTests) {
//                Set<AlertToDataConstraintFailure> warningsAndErrors = new HashSet<AlertToDataConstraintFailure>();
//
////                dataCheckMap.put(concept, warningsAndErrors);
////                DataCheckRunner.runDataChecks(concept, creationTests);
//            }

            uncommittedCNids.setMember(concept.getNid());
            dbWriterPermit.acquire();
            dbWriterService.execute(new SetNidsForCid(concept));
            dbWriterService.execute(new ConceptWriter(concept));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        SwingUtilities.invokeLater(new UpdateFrames(concept));
    }


    public static void addUncommittedDescNid(int dNid) {
        uncommittedDescNids.setMember(dNid);
    }

    public static void addUncommittedNoChecks(ConceptChronicleBI concept) {
        Concept c = (Concept) concept;

        c.modified();
        LastChange.touch(c);

        try {
            KindOfComputer.updateIsaCache(c.getNid());
        } catch (Exception ex) {
            AceLog.getAppLog().alertAndLogException(ex);
        }

        if (Bdb.watchList.containsKey(concept.getNid())) {
            AceLog.getAppLog().info("---@@@ Adding uncommitted NO checks: " + concept.getNid() + " ---@@@ ");
        }

        c = null;

        if (concept.isUncommitted()) {
            uncommittedCNidsNoChecks.setMember(concept.getNid());
            c = lastUncommitted.getAndSet((Concept) concept);

            if (c == concept) {
                c = null;
            }
        } else {
            c = (Concept) concept;

            if (Bdb.watchList.containsKey(concept.getNid())) {
                AceLog.getAppLog().info("--- Removing uncommitted concept: " + concept.getNid() + " --- ");
            }

            removeUncommitted(c);
        }

        try {
            writeUncommitted(c);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void cancel() {
        lastCancel = Bdb.gVersion.incrementAndGet();

        synchronized (uncommittedCNids) {
            synchronized (uncommittedCNidsNoChecks) {
                    try {
                        NidBitSetItrBI uncommittedCNidsItr = uncommittedCNids.iterator();
                        NidBitSetItrBI uncommittedCNidsNoChecksItr = uncommittedCNidsNoChecks.iterator();
                        Set<Integer> cNidSet = new HashSet<Integer>();

                        while (uncommittedCNidsItr.next()) {
                            cNidSet.addAll(Concept.get(uncommittedCNidsItr.nid()).getConceptNidsAffectedByCommit());

                            if (AceLog.getAppLog().isLoggable(Level.FINE)) {
                                AceLog.getAppLog().fine(
                                        "Canceling on concept: "
                                        + Ts.get().getComponent(uncommittedCNidsItr.nid()).toUserString() + " UUID: "
                                        + Ts.get().getUuidsForNid(uncommittedCNidsItr.nid()).toString());
                            }
                        }

                        while (uncommittedCNidsNoChecksItr.next()) {
                            cNidSet.addAll(
                                    Concept.get(uncommittedCNidsNoChecksItr.nid()).getConceptNidsAffectedByCommit());

                            if (AceLog.getAppLog().isLoggable(Level.FINE)) {
                                AceLog.getAppLog().fine(
                                        "Canceling on concept: "
                                        + Ts.get().getComponent(uncommittedCNidsNoChecksItr.nid()).toUserString()
                                        + " UUID: "
                                        + Ts.get().getUuidsForNid(uncommittedCNidsNoChecksItr.nid()).toString());
                            }
                        }

                        LastChange.touchComponents(cNidSet);
                        Bdb.getSapDb().commit(Long.MIN_VALUE);
                        Bdb.getSapDb().commit(Long.MIN_VALUE);
                        KindOfComputer.reset();
                        handleCanceledConcepts(uncommittedCNids);
                        handleCanceledConcepts(uncommittedCNidsNoChecks);
                        uncommittedCNidsNoChecks.clear();
                        uncommittedCNids.clear();
//                        DataCheckRunner.cancelAll();
//                        dataCheckMap.clear();
                    } catch (IOException e1) {
                        AceLog.getAppLog().alertAndLogException(e1);
                    }
            }
        }

        fireCancel();
//        updateFrames();
    }

    public static boolean commit(ChangeSetPolicy changeSetPolicy,
            ChangeSetWriterThreading changeSetWriterThreading) {
//        Svn.rwl.acquireUninterruptibly();

        boolean passedRelease = false;
        boolean performCommit = true;

        try {
            synchronized (uncommittedCNids) {
                synchronized (uncommittedCNidsNoChecks) {
                        NidBitSetBI allUncommitted = new IdentifierSet();
                        allUncommitted.or(uncommittedCNids);
                        allUncommitted.or(uncommittedCNidsNoChecks);
                        try {
                            GlobalPropertyChange.fireVetoableChange(TerminologyStoreDI.CONCEPT_EVENT.PRE_COMMIT, null, allUncommitted);
                        } catch (PropertyVetoException ex) {
                            return false;
                        }
                        flushUncommitted();

                        int errorCount = 0;
                        int warningCount = 0;

                        if (performCreationTests) {
                            NidBitSetItrBI uncommittedCNidItr = uncommittedCNids.iterator();

                        if (performCommit) {
                            lastCommit = Bdb.gVersion.incrementAndGet();
                            if (Bdb.annotationConcepts != null) {
                                for (Concept annotationConcept : Bdb.annotationConcepts) {
                                    dbWriterService.execute(new ConceptWriter(annotationConcept));
                                }
                                Bdb.annotationConcepts.clear();
                            }
                            KindOfComputer.reset();


                            while (uncommittedCNidItr.next()) {
                                
                                    int cnid = uncommittedCNidItr.nid();

                                    KindOfComputer.updateIsaCache(cnid);

                                    Concept c = Concept.get(cnid);

                                    c.modified(lastCommit);
                                
                            }

                            NidBitSetItrBI uncommittedCNidItrNoChecks = uncommittedCNidsNoChecks.iterator();

                            while (uncommittedCNidItrNoChecks.next()) {
                                KindOfComputer.updateIsaCache(uncommittedCNidItrNoChecks.nid());
                            }

                            long commitTime = System.currentTimeMillis();
                            NidSetBI sapNidsFromCommit = Bdb.getSapDb().commit(commitTime);

                            if (writeChangeSets && (sapNidsFromCommit.size() > 0)) {
                                if (changeSetPolicy == null) {
                                    changeSetPolicy = ChangeSetPolicy.OFF;
                                }

                                if (changeSetWriterThreading == null) {
                                    changeSetWriterThreading = ChangeSetWriterThreading.SINGLE_THREAD;
                                }

                                switch (changeSetPolicy) {
                                    case COMPREHENSIVE:
                                    case INCREMENTAL:
                                    case MUTABLE_ONLY:
                                        uncommittedCNidsNoChecks.or(uncommittedCNids);

                                        if (uncommittedCNidsNoChecks.cardinality() > 0) {
                                            ChangeSetWriterHandler handler =
                                                    new ChangeSetWriterHandler(uncommittedCNidsNoChecks, commitTime,
                                                    sapNidsFromCommit, changeSetPolicy.convert(),
                                                    changeSetWriterThreading);

                                            changeSetWriterService.execute(handler);
                                            passedRelease = true;
                                        }

                                        break;

                                    case OFF:
                                        break;

                                    default:
                                        throw new RuntimeException("Can't handle policy: " + changeSetPolicy);
                                }
                            }

                            notifyCommit();
                            uncommittedCNids.clear();
                            uncommittedCNidsNoChecks = Bdb.getConceptDb().getEmptyIdSet();
                            luceneWriterPermit.acquire();

                            IdentifierSet descNidsToCommit = new IdentifierSet((IdentifierSet) uncommittedDescNids);

                            uncommittedDescNids.clear();
                            luceneWriterService.execute(new DescLuceneWriter(descNidsToCommit));


//                            dataCheckMap.clear();
                        }
                        GlobalPropertyChange.firePropertyChange(TerminologyStoreDI.CONCEPT_EVENT.POST_COMMIT, null, allUncommitted);

                    }
                }
            }

            if (performCommit) {
                Bdb.sync();
                BdbCommitSequence.nextSequence();
            }
        } catch (Exception e1) {
            AceLog.getAppLog().alertAndLogException(e1);
        }

        fireCommit();

        if (performCommit) {
            return true;
        }

        return false;
    }

    public static boolean commit(Concept c, ChangeSetPolicy changeSetPolicy,
            ChangeSetWriterThreading changeSetWriterThreading) {
        if ((uncommittedCNids.cardinality() == 1) && (uncommittedCNidsNoChecks.cardinality() == 1)
                && uncommittedCNids.isMember(c.getNid()) && uncommittedCNidsNoChecks.isMember(c.getNid())) {
            return commit(changeSetPolicy, changeSetWriterThreading);
        } else if ((uncommittedCNids.cardinality() == 1) && (uncommittedCNidsNoChecks.cardinality() == 0)
                && uncommittedCNids.isMember(c.getNid())) {
            return commit(changeSetPolicy, changeSetWriterThreading);
        } else if ((uncommittedCNids.cardinality() == 0) && (uncommittedCNidsNoChecks.cardinality() == 1)
                && uncommittedCNidsNoChecks.isMember(c.getNid())) {
            return commit(changeSetPolicy, changeSetWriterThreading);
        }

        NidBitSetBI allUncommitted = new IdentifierSet();
        allUncommitted.setMember(c.getConceptNid());
        try {
            GlobalPropertyChange.fireVetoableChange(TerminologyStoreDI.CONCEPT_EVENT.PRE_COMMIT, null, allUncommitted);
        } catch (PropertyVetoException ex) {
            return false;
        }

        boolean performCommit = true;

        try {
            AceLog.getAppLog().info("Committing concept: " + c.toUserString() + " UUID: "
                    + Ts.get().getUuidsForNid(c.getNid()).toString());

//            int errorCount = 0;
//            int warningCount = 0;
//            Set<AlertToDataConstraintFailure> warningsAndErrors = new HashSet<AlertToDataConstraintFailure>();

//            dataCheckMap.put(c, warningsAndErrors);

//            DataCheckRunner checkRunner = DataCheckRunner.runDataChecks(c, commitTests);
//            CountDownLatch latch = checkRunner.latch;

//            latch.await();
//            warningsAndErrors.addAll(checkRunner.get());

//            for (AlertToDataConstraintFailure alert : warningsAndErrors) {
//                if (alert.getAlertType().equals(ALERT_TYPE.ERROR)) {
//                    errorCount++;
//                } else if (alert.getAlertType().equals(ALERT_TYPE.WARNING)) {
//                    warningCount++;
//                }
//            }

//            if (errorCount + warningCount != 0) {
//                if (errorCount > 0) {
//                    performCommit = false;
//                    SwingUtilities.invokeLater(new Runnable() {
//
//                        @Override
//                        public void run() {
//                            JOptionPane.showMessageDialog(new JFrame(), "Please fix data errors prior to commit.",
//                                    "Data errors exist", JOptionPane.ERROR_MESSAGE);
//                        }
//                    });
//                } else {
//                    if (SwingUtilities.isEventDispatchThread()) {
//                        int selection = JOptionPane.showConfirmDialog(new JFrame(),
//                                "Do you want to continue with commit?", "Warnings Detected",
//                                JOptionPane.YES_NO_OPTION);
//
//                        performCommit = selection == JOptionPane.YES_OPTION;
//                    } else {
//                        try {
//                            AskToContinue asker = new AskToContinue();
//
//                            SwingUtilities.invokeAndWait(asker);
//                            performCommit = asker.continueWithCommit;
//                        } catch (InvocationTargetException e) {
//                            AceLog.getAppLog().alertAndLogException(e);
//                            performCommit = false;
//                        }
//                    }
//                }
//            }

            if (performCommit) {
                BdbCommitSequence.nextSequence();

                for (Concept annotationConcept : Bdb.annotationConcepts) {
                    dbWriterService.execute(new ConceptWriter(annotationConcept));
                }

                Bdb.annotationConcepts.clear();
                KindOfComputer.reset();

                KindOfComputer.updateIsaCache(c.getNid());

                long commitTime = System.currentTimeMillis();
                NidSetBI sapNidsFromCommit = c.setCommitTime(commitTime);
                IdentifierSet commitSet = new IdentifierSet();

                commitSet.setMember(c.getNid());
                c.modified();
                Bdb.getConceptDb().writeConcept(c);



                if (writeChangeSets) {
                    if (changeSetPolicy == null) {
                        changeSetPolicy = ChangeSetPolicy.OFF;
                    }

                    if (changeSetWriterThreading == null) {
                        changeSetWriterThreading = ChangeSetWriterThreading.SINGLE_THREAD;
                    }

                    switch (changeSetPolicy) {
                        case COMPREHENSIVE:
                        case INCREMENTAL:
                        case MUTABLE_ONLY:
                            ChangeSetWriterHandler handler = new ChangeSetWriterHandler(commitSet, commitTime,
                                    sapNidsFromCommit, changeSetPolicy.convert(),
                                    changeSetWriterThreading);

                            changeSetWriterService.execute(handler);

                            break;

                        case OFF:
                            break;

                        default:
                            throw new RuntimeException("Can't handle policy: " + changeSetPolicy);
                    }
                }

                uncommittedCNids.andNot(commitSet);
                uncommittedCNidsNoChecks.andNot(commitSet);
                luceneWriterPermit.acquire();

                IdentifierSet descNidsToCommit = new IdentifierSet();

                for (int dnid : c.getData().getDescNids()) {
                    descNidsToCommit.setMember(dnid);
                    uncommittedDescNids.setNotMember(dnid);
                }

                luceneWriterService.execute(new DescLuceneWriter(descNidsToCommit));


//                dataCheckMap.remove(c);
            }
        } catch (Exception e1) {
            AceLog.getAppLog().alertAndLogException(e1);
        }

        GlobalPropertyChange.firePropertyChange(TerminologyStoreDI.CONCEPT_EVENT.POST_COMMIT, null, allUncommitted);
        fireCommit();

        if (performCommit) {
            return true;
        }

        return false;
    }

    public static void fireCancel() {
        if (DwfaEnv.isHeadless()) {
            return;
        }

    }

    private static void fireCommit() {
        if (DwfaEnv.isHeadless()) {
            return;
        }

    }

    private static void flushUncommitted() throws InterruptedException {
        Concept c = lastUncommitted.getAndSet(null);

        if (c != null) {
            writeUncommitted(c);
        }
    }

    public static boolean forget(ConAttrVersionBI attr) throws IOException {
        Concept c = Bdb.getConcept(attr.getConceptNid());
      ConceptAttributes a = (ConceptAttributes) attr;

        if ((a.getTime() != Long.MAX_VALUE) && (a.getTime() != Long.MIN_VALUE)) {

            // Only need to forget additional versions;
            if (a.revisions != null) {
                synchronized (a.revisions) {
                    List<ConceptAttributesRevision> toRemove = new ArrayList<ConceptAttributesRevision>();
                    Iterator<ConceptAttributesRevision> ri = a.revisions.iterator();

                    while (ri.hasNext()) {
                        ConceptAttributesRevision ar = ri.next();

                        if (ar.getTime() == Long.MAX_VALUE) {
                            toRemove.add(ar);
                        }
                    }

                    for (ConceptAttributesRevision r : toRemove) {
                        a.removeRevision(r);
                        r.sapNid = -1;
                    }
                }
            }

            try {
                KindOfComputer.updateIsaCaches((Concept) c);
            } catch (Exception e) {
                AceLog.getAppLog().alertAndLog(Level.SEVERE, "Canceling cache for: " + c.toString(), e);
            }

            addUncommittedNoChecks(c);
        } else {
            a.primordialSapNid = -1;

            return true;
        }

        return false;
    }


   public static void forget(DescriptionVersionBI desc) throws IOException {
      Description d = (Description) desc;
        Concept c = Bdb.getConcept(d.getConceptNid());

        if (d.getTime() != Long.MAX_VALUE) {

            // Only need to forget additional versions;
            if (d.revisions == null) {
                throw new UnsupportedOperationException("Cannot forget a committed component.");
            } else {
                synchronized (d.revisions) {
                    List<DescriptionRevision> toRemove = new ArrayList<DescriptionRevision>();
                    Iterator<DescriptionRevision> di = d.revisions.iterator();

                    while (di.hasNext()) {
                        DescriptionRevision dr = di.next();

                        if (dr.getTime() == Long.MAX_VALUE) {
                            toRemove.add(dr);
                        }
                    }

                    for (DescriptionRevision tr : toRemove) {
                        d.removeRevision(tr);
                        tr.sapNid = -1;
                    }
                }
            }
        } else {

            // have to forget "all" references to component...
            c.getDescriptions().remove(d);
            c.getData().getDescNids().remove(d.getNid());
            d.primordialSapNid = -1;
        }

        c.modified();
        addUncommittedNoChecks(c);
    }

   @SuppressWarnings("unchecked")
   public static void forget(RefexChronicleBI extension) throws IOException {
      RefexMember m         = (RefexMember) extension;
      Concept      c         = Bdb.getConcept(m.getRefexNid());
      ComponentBI  component = Bdb.getComponent(m.getReferencedComponentNid());

        if (component instanceof Concept) {
            component = ((Concept) component).getConAttrs();
        }

        ConceptComponent comp = (ConceptComponent) component;

        if (m.getTime() != Long.MAX_VALUE) {

            // Only need to forget additional versions;
            if (m.revisions == null) {
                throw new UnsupportedOperationException("Cannot forget a committed component.");
            } else {
                synchronized (m.revisions) {
                    List<RefexRevision<?, ?>> toRemove = new ArrayList<RefexRevision<?, ?>>();
                    Iterator<?> mi = m.revisions.iterator();

                    while (mi.hasNext()) {
                        RefexRevision<?, ?> mr = (RefexRevision<?, ?>) mi.next();

                        if (mr.getTime() == Long.MAX_VALUE) {
                            toRemove.add(mr);
                        }
                    }

                    for (RefexRevision tr : toRemove) {
                        m.removeRevision(tr);
                        tr.sapNid = -1;
                    }
                }
            }
        } else {

            // have to forget "all" references to component...
            if (c.isAnnotationStyleRefex()) {
                comp.getAnnotationsMod().remove(m);
            } else {
                c.getRefsetMembers().remove(m);
                c.getData().getMemberNids().remove(m.getNid());
            }

            m.setStatusAtPositionNid(-1);
        }


        c.modified();
        addUncommittedNoChecks(c);
    }


   public static void forget(ConceptChronicleBI concept) throws IOException {
      Concept c = (Concept) concept;

        c.cancel();
    }


   public static void forget(RelationshipVersionBI rel) throws IOException {
      Concept      c = Bdb.getConcept(rel.getOriginNid());
      Relationship r = (Relationship) rel;

        if (r.getTime() != Long.MAX_VALUE) {

            // Only need to forget additional versions;
            if (r.revisions == null) {
                throw new UnsupportedOperationException("Cannot forget a committed component.");
            } else {
                synchronized (r.revisions) {
                    List<RelationshipRevision> toRemove = new ArrayList<RelationshipRevision>();
                    Iterator<RelationshipRevision> ri = r.revisions.iterator();

                    while (ri.hasNext()) {
                        RelationshipRevision rr = ri.next();

                        if (rr.getTime() == Long.MAX_VALUE) {
                            toRemove.add(rr);
                        }
                    }

                    for (RelationshipRevision tr : toRemove) {
                        r.removeRevision(tr);
                    }
                }
            }
        } else {

            // have to forget "all" references to component...
            c.getRelsOutgoing().remove((Relationship) rel);
            c.getData().getSrcRelNids().remove(rel.getNid());
            r.primordialSapNid = -1;
        }

        c.modified();

        try {
            KindOfComputer.updateIsaCaches((Concept) c);
        } catch (Exception e) {
            AceLog.getAppLog().alertAndLog(Level.SEVERE, "Canceling cache for: " + c.toString(), e);
        }

        addUncommittedNoChecks(c);
    }

    private static void handleCanceledConcepts(NidBitSetBI uncommittedCNids2) throws IOException {
        NidBitSetItrBI idItr = uncommittedCNids2.iterator();

        while (idItr.next()) {
            try {
                Concept c = Concept.get(idItr.nid());

                if (c.isCanceled()) {
                    forget(c);
                }

                c.flushVersions();
                c.modified();
                c.setLastWrite(Bdb.gVersion.incrementAndGet());

                try {
                    KindOfComputer.updateIsaCaches((Concept) c);
                } catch (Exception e) {
                    AceLog.getAppLog().alertAndLog(Level.SEVERE, "Canceling cache for: " + c.toString(), e);
                }
            } catch (Exception ex) {
                AceLog.getAppLog().alertAndLogException(ex);
            }
        }
    }



//    private static void loadTests(String directory, List<I_TestDataConstraints> list) {
//        File componentPluginDir = new File(pluginRoot + File.separator + directory);
//        File[] plugins = componentPluginDir.listFiles(new FilenameFilter() {
//
//            @Override
//            public boolean accept(File arg0, String fileName) {
//                return fileName.toLowerCase().endsWith(".task");
//            }
//        });
//
//        if (plugins != null) {
//            for (File f : plugins) {
//                try {
//                    FileInputStream fis = new FileInputStream(f);
//                    BufferedInputStream bis = new BufferedInputStream(fis);
//                    ObjectInputStream ois = new ObjectInputStream(bis);
//                    I_TestDataConstraints test = (I_TestDataConstraints) ois.readObject();
//
//                    ois.close();
//                    list.add(test);
//                } catch (Exception e) {
//                    AceLog.getAppLog().alertAndLog(Level.WARNING, "Processing: " + f.getAbsolutePath(), e);
//                }
//            }
//        }
//    }

    private static void notifyCommit() {
        if ((listeners != null) && (listeners.length > 0)) {
            final CommitEvent event;

            event = new CommitEvent(uncommittedCNidsNoChecks);

            for (final ICommitListener listener : listeners) {
                try {
                    listener.afterCommit(event);
                } catch (final Exception exception) {

                    // @todo handle exception
                    exception.printStackTrace();
                }
            }
        }
    }

    /**
     * <p> notify the commit event </p>
     */
    private static void notifyShutdown() {
        if ((listeners != null) && (listeners.length > 0)) {
            for (final ICommitListener listener : listeners) {
                try {
                    listener.shutdown();
                } catch (final Exception exception) {

                    // @todo handle exception
                    exception.printStackTrace();
                }
            }
        }
    }

    public static void removeUncommitted(final Concept concept) {
        if (uncommittedCNids.isMember(concept.getNid())) {
            uncommittedCNids.setNotMember(concept.getNid());

//            if (uncommittedCNids.cardinality() == 0) {
////                dataCheckMap.clear();
//            } else {
////                dataCheckMap.remove(concept);
//            }

//            if (getActiveFrame() != null) {
//                SwingUtilities.invokeLater(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        removeUncommittedUpdateFrame(concept);
//                    }
//                });
//            }
        }
    }

//    private static void removeUncommittedUpdateFrame(Concept concept) {
//        for (I_ConfigAceFrame frameConfig : getActiveFrame().getDbConfig().getAceFrames()) {
//            try {
//                frameConfig.removeUncommitted(concept);
////                updateAlerts();
//
//                if (uncommittedCNids.cardinality() == 0) {
//                    frameConfig.setCommitEnabled(false);
//                }
//            } catch (Exception e) {
//                AceLog.getAppLog().warning(e.toString());
//            }
//        }
//    }

    public static void reset() {
        changeSetWriterService = Executors.newFixedThreadPool(1,
                new NamedThreadFactory(commitManagerThreadGroup, "Change set writer"));
        dbWriterService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(),
                new NamedThreadFactory(commitManagerThreadGroup, "Db writer"));
        luceneWriterService = Executors.newFixedThreadPool(1,
                new NamedThreadFactory(commitManagerThreadGroup, "Lucene writer"));
//        loadTests("commit", commitTests);
//        loadTests("precommit", creationTests);
    }

    public static void resumeChangeSetWriters() {
        writeChangeSets = true;
    }

    public static void shutdown() throws InterruptedException {
        cancel();
        AceLog.getAppLog().info("Shutting down dbWriterService.");
        dbWriterService.shutdown();
        AceLog.getAppLog().info("Awaiting termination of dbWriterService.");
        dbWriterService.awaitTermination(90, TimeUnit.MINUTES);
        AceLog.getAppLog().info("Shutting down luceneWriterService.");
        luceneWriterService.shutdown();
        AceLog.getAppLog().info("Awaiting termination of luceneWriterService.");
        luceneWriterService.awaitTermination(90, TimeUnit.MINUTES);
        AceLog.getAppLog().info("Shutting down changeSetWriterService.");
        changeSetWriterService.shutdown();
        AceLog.getAppLog().info("Awaiting termination of changeSetWriterService.");
        changeSetWriterService.awaitTermination(90, TimeUnit.MINUTES);
        AceLog.getAppLog().info("BdbCommitManager is shutdown.");
        notifyShutdown();
    }

    public static void suspendChangeSetWriters() {
        writeChangeSets = false;
    }

//    public static void updateAlerts() {
//        SwingUtilities.invokeLater(new Runnable() {
//
//            @Override
//            public void run() {
//                doUpdate();
//            }
//        });
//    }
//
//    public static void updateFrames() {
//        SwingUtilities.invokeLater(new Runnable() {
//
//            @Override
//            public void run() {
//                doUpdate();
//            }
//        });
//    }

    public static void waitTillWritesFinished() {
        if (writerCount.get() > 0) {
            try {
                dbWriterPermit.acquireUninterruptibly(PERMIT_COUNT);
            } finally {
                dbWriterPermit.release(PERMIT_COUNT);
            }
        }
    }

    public static void writeImmediate(Concept concept) {
        new ConceptWriter(concept).run();
    }

    private static void writeUncommitted(Concept c) throws InterruptedException {
        if (c != null) {
            if (Bdb.watchList.containsKey(c.getNid())) {
                AceLog.getAppLog().info("---@@@ writeUncommitted checks: " + c.getNid() + " ---@@@ ");
            }

            dbWriterPermit.acquire();
            dbWriterService.execute(new SetNidsForCid(c));
            dbWriterService.execute(new ConceptWriter(c));
        }
    }

    //~--- get methods ---------------------------------------------------------


    public static long getLastCancel() {
        return lastCancel;
    }

    public static long getLastCommit() {
        return lastCommit;
    }

    public static Set<Concept> getUncommitted() {
        try {
            Set<Concept> returnSet = new HashSet<Concept>();
            NidBitSetItrBI cNidItr = uncommittedCNids.iterator();

            while (cNidItr.next()) {
                returnSet.add(Concept.get(cNidItr.nid()));
            }

            cNidItr = uncommittedCNidsNoChecks.iterator();

            while (cNidItr.next()) {
                returnSet.add(Concept.get(cNidItr.nid()));
            }

            return returnSet;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isCheckCommitDataEnabled() {
        return performCommitTests;
    }

    public static boolean isCheckCreationDataEnabled() {
        return performCreationTests;
    }

    //~--- set methods ---------------------------------------------------------
    public static void setCheckCommitDataEnabled(boolean enabled) {
        performCommitTests = enabled;
    }

    public static void setCheckCreationDataEnabled(boolean enabled) {
        performCreationTests = enabled;
    }

    //~--- inner classes -------------------------------------------------------
    public static class AskToContinue implements Runnable {

        private boolean continueWithCommit;

        //~--- methods ----------------------------------------------------------
        @Override
        public void run() {
            int selection = JOptionPane.showConfirmDialog(new JFrame(), "Do you want to continue with commit?",
                    "Warnings Detected", JOptionPane.YES_NO_OPTION);

            continueWithCommit = selection == JOptionPane.YES_OPTION;
        }
    }

    private static class ConceptWriter implements Runnable {

        private Concept c;

        //~--- constructors -----------------------------------------------------
        public ConceptWriter(Concept c) {
            super();
            assert c.readyToWrite();
            this.c = c;
            writerCount.incrementAndGet();
        }

        //~--- methods ----------------------------------------------------------
        @Override
        public void run() {
            try {
                while (c.isUnwritten() && !c.isCanceled()) {
                    Bdb.getConceptDb().writeConcept(c);
                }
            } catch (Throwable e) {
                String exceptionStr = "Exception Writing: " + c.toLongString();
                Exception newEx = new Exception(exceptionStr, e);

                System.out.println(exceptionStr + "\n\n" + e.toString());
                AceLog.getAppLog().alertAndLogException(newEx);
            } finally {
                dbWriterPermit.release();
                writerCount.decrementAndGet();
            }
        }
    }

    private static class DescLuceneWriter implements Runnable {

        private int batchSize = 200;
        private IdentifierSet descNidsToWrite;

        //~--- constructors -----------------------------------------------------
        public DescLuceneWriter(IdentifierSet descNidsToCommit) {
            super();
            this.descNidsToWrite = descNidsToCommit;
        }

        //~--- methods ----------------------------------------------------------
        @Override
        public void run() {
            try {
                ArrayList<Description> toIndex = new ArrayList<Description>(batchSize + 1);
                NidBitSetItrBI idItr = descNidsToWrite.iterator();
                int count = 0;

                while (idItr.next()) {
                    count++;

                    Description d = (Description) Bdb.getComponent(idItr.nid());

                    toIndex.add(d);

                    if (count > batchSize) {
                        count = 0;
                        LuceneManager.writeToLucene(toIndex);
                        toIndex = new ArrayList<Description>(batchSize + 1);
                    }
                }

                LuceneManager.writeToLucene(toIndex);
            } catch (Exception e) {
                AceLog.getAppLog().alertAndLogException(e);
            }

            luceneWriterPermit.release();
        }
    }

    private static class SetNidsForCid implements Runnable {

        Concept concept;

        //~--- constructors -----------------------------------------------------
        public SetNidsForCid(Concept concept) {
            super();
            this.concept = concept;
        }

        //~--- methods ----------------------------------------------------------
        @Override
        public void run() {
            try {
                Collection<Integer> nids = concept.getAllNids();
                NidCNidMapBdb nidCidMap = Bdb.getNidCNidMap();

                for (int nid : nids) {
                    nidCidMap.setCNidForNid(concept.getNid(), nid);
                }
            } catch (IOException e) {
                AceLog.getAppLog().alertAndLogException(e);
            }
        }
    }
}
