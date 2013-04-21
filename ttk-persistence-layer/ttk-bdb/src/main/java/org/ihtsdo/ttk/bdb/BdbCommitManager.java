package org.ihtsdo.ttk.bdb;

//~--- non-JDK imports --------------------------------------------------------
import org.ihtsdo.ttk.api.NidSetBI;
import org.ihtsdo.ttk.api.ComponentBI;
import org.ihtsdo.ttk.api.NidBitSetBI;
import org.ihtsdo.ttk.api.TerminologyStoreDI;
import org.ihtsdo.ttk.api.NidBitSetItrBI;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.ihtsdo.ttk.bdb.id.NidCNidMapBdb;
import org.ihtsdo.ttk.helpers.thread.NamedThreadFactory;
import org.ihtsdo.ttk.bdb.temp.AceLog;
import org.ihtsdo.ttk.api.conattr.ConAttrVersionBI;
import org.ihtsdo.ttk.api.concept.ConceptChronicleBI;
import org.ihtsdo.ttk.api.cs.ChangeSetPolicy;
import org.ihtsdo.ttk.api.cs.ChangeSetWriterThreading;
import org.ihtsdo.ttk.api.description.DescriptionVersionBI;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.relationship.RelationshipVersionBI;
import org.ihtsdo.ttk.concept.cc.P;
import org.ihtsdo.ttk.concept.cc.attributes.ConceptAttributes;
import org.ihtsdo.ttk.concept.cc.attributes.ConceptAttributesRevision;
import org.ihtsdo.ttk.concept.cc.change.BdbCommitSequence;
import org.ihtsdo.ttk.concept.cc.change.LastChange;
import org.ihtsdo.ttk.concept.cc.component.ConceptComponent;
import org.ihtsdo.ttk.concept.cc.component.IdentifierSet;
import org.ihtsdo.ttk.concept.cc.concept.Concept;
import org.ihtsdo.ttk.concept.cc.description.Description;
import org.ihtsdo.ttk.concept.cc.description.DescriptionRevision;
import org.ihtsdo.ttk.concept.cc.lucene.LuceneManager;
import org.ihtsdo.ttk.concept.cc.refex.RefexMember;
import org.ihtsdo.ttk.concept.cc.refex.RefexRevision;
import org.ihtsdo.ttk.concept.cc.relationship.Relationship;
import org.ihtsdo.ttk.concept.cc.relationship.RelationshipRevision;
import org.ihtsdo.ttk.concept.jsr166y.cs.ChangeSetWriterHandler;

public class BdbCommitManager {

    private static final int PERMIT_COUNT = 50;
    public static String pluginRoot = "plugins";
    private static final AtomicInteger writerCount = new AtomicInteger(0);
    private static boolean writeChangeSets = true;
    private static NidBitSetBI uncommittedCNidsNoChecks = new IdentifierSet();
    private static NidBitSetBI uncommittedCNids = new IdentifierSet();
    private static boolean performCreationTests = true;
    private static boolean performCommitTests = true;
    private static long lastDoUpdate = Long.MIN_VALUE;
    private static long lastCommit = Bdb.gVersion.incrementAndGet();
    private static long lastCancel = Integer.MIN_VALUE;
    private static Semaphore dbWriterPermit = new Semaphore(PERMIT_COUNT);
    private static ThreadGroup commitManagerThreadGroup =
            new ThreadGroup("commit manager threads");
    private static ExecutorService changeSetWriterService;
    private static ExecutorService dbWriterService;
    /**
     * <p> listeners </p>
     */
    private static ICommitListener[] listeners = new ICommitListener[0];

    //~--- static initializers -------------------------------------------------
    static {
        reset();
    }

    //~--- methods -------------------------------------------------------------
    public static void addUncommitted(ConceptChronicleBI igcd) {
        if (igcd == null) {
            return;
        }

        Concept concept = (Concept) igcd;

        LastChange.touch(concept);
        GlobalPropertyChange.firePropertyChange(TerminologyStoreDI.CONCEPT_EVENT.ADD_UNCOMMITTED, null, concept);

        if (concept.isUncommitted() == false) {
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

        try {
            uncommittedCNids.setMember(concept.getNid());
            dbWriterPermit.acquire();
            dbWriterService.execute(new SetNidsForCid(concept));
            dbWriterService.execute(new ConceptWriter(concept));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    public static void addUncommittedNoChecks(ConceptChronicleBI concept) {
        Concept c = (Concept) concept;

        c.modified();
        LastChange.touch(c);

        c = null;

        if (concept.isUncommitted()) {
            uncommittedCNidsNoChecks.setMember(concept.getNid());
         } else {
            c = (Concept) concept;

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
                        Set<Integer> cNidSet = new HashSet<>();

                        while (uncommittedCNidsItr.next()) {
                            cNidSet.addAll(Concept.get(uncommittedCNidsItr.nid()).getConceptNidsAffectedByCommit());

                            if (AceLog.getAppLog().isLoggable(Level.FINE)) {
                                AceLog.getAppLog().fine(
                                        "Canceling on concept: "
                                        + P.s.getComponent(uncommittedCNidsItr.nid()).toUserString() + " UUID: "
                                        + P.s.getUuidsForNid(uncommittedCNidsItr.nid()).toString());
                            }
                        }

                        while (uncommittedCNidsNoChecksItr.next()) {
                            cNidSet.addAll(
                                    Concept.get(uncommittedCNidsNoChecksItr.nid()).getConceptNidsAffectedByCommit());

                            if (AceLog.getAppLog().isLoggable(Level.FINE)) {
                                AceLog.getAppLog().fine(
                                        "Canceling on concept: "
                                        + P.s.getComponent(uncommittedCNidsNoChecksItr.nid()).toUserString()
                                        + " UUID: "
                                        + P.s.getUuidsForNid(uncommittedCNidsNoChecksItr.nid()).toString());
                            }
                        }

                        LastChange.touchComponents(cNidSet);
                        Bdb.getStampDb().commit(Long.MIN_VALUE);
                        Bdb.getStampDb().commit(Long.MIN_VALUE);
                        handleCanceledConcepts(uncommittedCNids);
                        handleCanceledConcepts(uncommittedCNidsNoChecks);
                        uncommittedCNidsNoChecks.clear();
                        uncommittedCNids.clear();
                    } catch (IOException e1) {
                        AceLog.getAppLog().alertAndLogException(e1);
                    }
            }
        }
    }

    public static boolean commit(ChangeSetPolicy changeSetPolicy,
            ChangeSetWriterThreading changeSetWriterThreading) {

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


                            while (uncommittedCNidItr.next()) {
                                
                                    int cnid = uncommittedCNidItr.nid();
                                    Concept c = Concept.get(cnid);

                                    c.modified(lastCommit);
                                
                            }

                            NidBitSetItrBI uncommittedCNidItrNoChecks = uncommittedCNidsNoChecks.iterator();

                            long commitTime = System.currentTimeMillis();
                            NidSetBI sapNidsFromCommit = Bdb.getStampDb().commit(commitTime);

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
                            LuceneManager.commitDescriptionsToLucene();
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
                    + P.s.getUuidsForNid(c.getNid()).toString());
            if (performCommit) {
                BdbCommitSequence.nextSequence();

                for (Concept annotationConcept : Bdb.annotationConcepts) {
                    dbWriterService.execute(new ConceptWriter(annotationConcept));
                }

                Bdb.annotationConcepts.clear();

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
                LuceneManager.commitDescriptionsToLucene(c);
            }
        } catch (Exception e1) {
            AceLog.getAppLog().alertAndLogException(e1);
        }

        GlobalPropertyChange.firePropertyChange(TerminologyStoreDI.CONCEPT_EVENT.POST_COMMIT, null, allUncommitted);
 
        if (performCommit) {
            return true;
        }

        return false;
    }

    public static boolean forget(ConAttrVersionBI attr) throws IOException {
        Concept c = Bdb.getConcept(attr.getConceptNid());
      ConceptAttributes a = (ConceptAttributes) attr;

        if ((a.getTime() != Long.MAX_VALUE) && (a.getTime() != Long.MIN_VALUE)) {

            // Only need to forget additional versions;
            if (a.revisions != null) {
                synchronized (a.revisions) {
                    List<ConceptAttributesRevision> toRemove = new ArrayList<>();
                    Iterator<ConceptAttributesRevision> ri = a.revisions.iterator();

                    while (ri.hasNext()) {
                        ConceptAttributesRevision ar = ri.next();

                        if (ar.getTime() == Long.MAX_VALUE) {
                            toRemove.add(ar);
                        }
                    }

                    for (ConceptAttributesRevision r : toRemove) {
                        a.removeRevision(r);
                        r.stamp = -1;
                    }
                }
            }

            addUncommittedNoChecks(c);
        } else {
            a.primordialStamp = -1;

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
                    List<DescriptionRevision> toRemove = new ArrayList<>();
                    Iterator<DescriptionRevision> di = d.revisions.iterator();

                    while (di.hasNext()) {
                        DescriptionRevision dr = di.next();

                        if (dr.getTime() == Long.MAX_VALUE) {
                            toRemove.add(dr);
                        }
                    }

                    for (DescriptionRevision tr : toRemove) {
                        d.removeRevision(tr);
                        tr.stamp = -1;
                    }
                }
            }
        } else {

            // have to forget "all" references to component...
            c.getDescriptions().remove(d);
            c.getData().getDescNids().remove(d.getNid());
            d.primordialStamp = -1;
        }

        c.modified();
        addUncommittedNoChecks(c);
    }

   @SuppressWarnings("unchecked")
   public static void forget(RefexChronicleBI extension) throws IOException {
      RefexMember m         = (RefexMember) extension;
      Concept      c         = Bdb.getConcept(m.getRefexExtensionNid());
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
                    List<RefexRevision<?, ?>> toRemove = new ArrayList<>();
                    Iterator<?> mi = m.revisions.iterator();

                    while (mi.hasNext()) {
                        RefexRevision<?, ?> mr = (RefexRevision<?, ?>) mi.next();

                        if (mr.getTime() == Long.MAX_VALUE) {
                            toRemove.add(mr);
                        }
                    }

                    for (RefexRevision tr : toRemove) {
                        m.removeRevision(tr);
                        tr.stamp = -1;
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
                    List<RelationshipRevision> toRemove = new ArrayList<>();
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
            r.primordialStamp = -1;
        }

        c.modified();
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
            } catch (Exception ex) {
                AceLog.getAppLog().alertAndLogException(ex);
            }
        }
    }

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
        }
    }

    public static void reset() {
        changeSetWriterService = Executors.newFixedThreadPool(1,
                new NamedThreadFactory(commitManagerThreadGroup, "Change set writer"));
        dbWriterService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(),
                new NamedThreadFactory(commitManagerThreadGroup, "Db writer"));
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

    public static void waitTillWritesFinished() {
        if (writerCount.get() > 0) {
            try {
                dbWriterPermit.acquireUninterruptibly(PERMIT_COUNT);
            } finally {
                dbWriterPermit.release(PERMIT_COUNT);
            }
        }
    }

    private static void writeUncommitted(Concept c) throws InterruptedException {
        if (c != null) {
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
            Set<Concept> returnSet = new HashSet<>();
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
