package org.ihtsdo.bdb;

//~--- non-JDK imports --------------------------------------------------------
import org.ihtsdo.cc.termstore.TerminologySnapshot;
import org.ihtsdo.cs.CsProperty;
import org.ihtsdo.tk.binding.SnomedMetadataRfx;
import org.ihtsdo.tk.binding.TermAux;
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ihtsdo.cc.*;
import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.cc.computer.kindof.IsaCache;
import org.ihtsdo.cc.computer.kindof.KindOfComputer;
import org.ihtsdo.cc.computer.kindof.TypeCache;
import org.ihtsdo.bdb.id.NidCNidMapBdb;
import org.ihtsdo.helper.thread.NamedThreadFactory;
import org.ihtsdo.cc.lucene.LuceneManager;
import org.ihtsdo.bdb.temp.AceLog;
import org.ihtsdo.cc.PositionSetReadOnly;
import org.ihtsdo.cc.concept.ConceptDataFetcherI;
import org.ihtsdo.cc.termstore.Termstore;
import org.ihtsdo.tk.api.*;
import org.ihtsdo.tk.api.TerminologyDI.CONCEPT_EVENT;
import org.ihtsdo.tk.api.conattr.ConAttrVersionBI;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.concept.ConceptVersionBI;
import org.ihtsdo.tk.api.conflict.IdentifyAllConflictStrategy;
import org.ihtsdo.tk.api.coordinate.EditCoordinate;
import org.ihtsdo.tk.api.coordinate.IsaCoordinate;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.cs.ChangeSetPolicy;
import org.ihtsdo.tk.api.cs.ChangeSetWriterThreading;
import org.ihtsdo.tk.api.description.DescriptionVersionBI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.relationship.RelationshipVersionBI;
import org.ihtsdo.tk.db.DbDependency;
import org.ihtsdo.tk.db.EccsDependency;
import org.ihtsdo.tk.dto.concept.TkConcept;
import org.ihtsdo.tk.dto.concept.component.TkRevision;

public class BdbTerminologyStore extends Termstore {

    private static ViewCoordinate metadataVC = null;
    @Override
    public void addUncommitted(ConceptChronicleBI concept) throws IOException {
        BdbCommitManager.addUncommitted(concept);
    }

    @Override
    public void forget(RelationshipVersionBI rel) throws IOException {
        BdbCommitManager.forget(rel);
    }

    @Override
    public void forget(DescriptionVersionBI desc) throws IOException {
        BdbCommitManager.forget(desc);
    }

    @Override
    public void forget(RefexChronicleBI extension) throws IOException {
        BdbCommitManager.forget(extension);
    }

    @Override
    public boolean forget(ConAttrVersionBI attr) throws IOException {
        boolean forgotten = BdbCommitManager.forget(attr);
        if (forgotten) {
            Bdb.getConceptDb().forget((Concept)attr.getEnclosingConcept());
        }
        return forgotten;
    }

    @Override
    public void forget(ConceptChronicleBI concept) throws IOException {
        BdbCommitManager.forget(concept);
    }

    @Override
    public void cancel() {
        BdbCommitManager.cancel();
    }

    @Override
    public void cancel(ConceptChronicleBI concept) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void cancel(ConceptVersionBI concept) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void commit() throws IOException {
        BdbCommitManager.commit(ChangeSetPolicy.MUTABLE_ONLY, ChangeSetWriterThreading.SINGLE_THREAD);
    }

    @Override
    public void commit(ConceptChronicleBI cc) throws IOException {
        BdbCommitManager.commit((Concept) cc, ChangeSetPolicy.MUTABLE_ONLY,
                ChangeSetWriterThreading.SINGLE_THREAD);
    }

    @Override
    public void commit(ConceptVersionBI concept) throws IOException {
        this.commit(concept.getChronicle());
    }

    @Override
    public void iterateConceptDataInParallel(ProcessUnfetchedConceptDataBI processor) throws Exception {
        Bdb.getConceptDb().iterateConceptDataInParallel(processor);
    }

    @Override
    public void iterateConceptDataInSequence(ProcessUnfetchedConceptDataBI processor) throws Exception {
        Bdb.getConceptDb().iterateConceptDataInSequence(processor);
    }

    @Override
    public boolean satisfiesDependencies(Collection<DbDependency> dependencies) {
        if (dependencies != null) {
            try {
                for (DbDependency d : dependencies) {
                    String value = P.s.getProperty(d.getKey());

                    if (d.satisfactoryValue(value) == false) {
                        return false;
                    }
                }
            } catch (Throwable e) {
                AceLog.getAppLog().alertAndLogException(e);

                return false;
            }
        }

        return true;
    }

    public int uuidsToNid(Collection<UUID> uuids) throws IOException {
        return Bdb.uuidsToNid(uuids);
    }

    public int uuidsToNid(UUID... uuids) throws IOException {
        return Bdb.uuidToNid(uuids);
    }

    //~--- get methods ---------------------------------------------------------
    @Override
    public NidBitSetBI getAllConceptNids() throws IOException {
        return Bdb.getConceptDb().getReadOnlyConceptIdSet();
    }

    public KindOfCacheBI getCache(ViewCoordinate coordinate) throws Exception {
        TypeCache c = new IsaCache(Bdb.getConceptDb().getConceptNidSet());

        c.setup(coordinate);
        c.getLatch().await();

        return c;
    }

    @Override
    public int getConceptNidForNid(int nid) {
        return Bdb.getConceptNid(nid);
    }
    @Override
    public NidBitSetBI getEmptyNidSet() throws IOException {
        return Bdb.getConceptDb().getEmptyIdSet();
    }

    @Override
    public Collection<DbDependency> getLatestChangeSetDependencies() throws IOException {
        CsProperty[] keysToCheck = new CsProperty[]{CsProperty.LAST_CHANGE_SET_WRITTEN,
            CsProperty.LAST_CHANGE_SET_READ};
        List<DbDependency> latestDependencies = new ArrayList<>(2);

        for (CsProperty prop : keysToCheck) {
            String value = Bdb.getProperty(prop.toString());

            if (value != null) {
                String changeSetName = value;
                String changeSetSize = Bdb.getProperty(changeSetName);

                latestDependencies.add(new EccsDependency(changeSetName, changeSetSize));
            }
        }

        return latestDependencies;
    }

    @Override
    public ViewCoordinate getMetadataVC() throws IOException {
        if (metadataVC == null) {
            PathBI viewPath =
                    new Path(TermAux.WB_AUX_PATH.getLenient().getNid(), null);
            PositionBI viewPosition = new Position(Long.MAX_VALUE, viewPath);
            PositionSetBI positionSet = new PositionSetReadOnly(viewPosition);
            NidSet allowedStatusNids = new NidSet();

            allowedStatusNids.add(TermAux.CURRENT.getLenient().getNid());
            allowedStatusNids.add(SnomedMetadataRfx.getSTATUS_CURRENT_NID());

            NidSetBI isaTypeNids = new NidSet();

            isaTypeNids.add(TermAux.IS_A.getLenient().getNid());

            ContradictionManagerBI contradictionManager = new IdentifyAllConflictStrategy();
            int languageNid = SnomedMetadataRfx.getUS_DIALECT_REFEX_NID();
            int classifierNid = ReferenceConcepts.SNOROCKET.getNid();

            metadataVC = new ViewCoordinate(Precedence.PATH, positionSet, allowedStatusNids, isaTypeNids,
                    contradictionManager, languageNid, classifierNid,
                    RelAssertionType.INFERRED_THEN_STATED, null,
                    ViewCoordinate.LANGUAGE_SORT.TYPE_BEFORE_LANG);
        }

        return metadataVC;
    }

    @Override
    public int getNidForUuids(Collection<UUID> uuids) throws IOException {
        return Bdb.uuidsToNid(uuids);
    }

    @Override
    public int getNidForUuids(UUID... uuids) throws IOException {
        return Bdb.uuidToNid(uuids);
    }

    @Override
    public PathBI getPath(int pathNid) throws IOException {
        return BdbPathManager.get().get(pathNid);
    }

    @Override
    public List<? extends PathBI> getPathChildren(int nid) {
        return BdbPathManager.get().getPathChildren(nid);
    }

    @Override
    public Set<PathBI> getPathSetFromPositionSet(Set<PositionBI> positions) throws IOException {
        HashSet<PathBI> paths = new HashSet<>(positions.size());

        for (PositionBI position : positions) {
            paths.add(position.getPath());

            // addOrigins(paths, position.getPath().getInheritedOrigins());
        }

        return paths;
    }

    private void addOrigins(Set<PathBI> paths, Collection<? extends PositionBI> origins) {
        if (origins == null) {
            return;
        }

        for (PositionBI o : origins) {
            paths.add(o.getPath());
            addOrigins(paths, o.getPath().getOrigins());
        }
    }


    @Override
    public Set<PathBI> getPathSetFromSapSet(Set<Integer> sapNids) throws IOException {
        HashSet<PathBI> paths = new HashSet<>(sapNids.size());

        for (int sap : sapNids) {
            PathBI path = Bdb.getSapDb().getPosition(sap).getPath();

            paths.add(path);
            addOrigins(paths, path.getOrigins());
        }

        return paths;
    }

    @Override
    public Set<PositionBI> getPositionSet(Set<Integer> sapNids) throws IOException {
        HashSet<PositionBI> positions = new HashSet<>(sapNids.size());

        for (int sap : sapNids) {

            if (sap >= 0) {
                positions.add(Bdb.getSapDb().getPosition(sap));
            }

        }

        return positions;
    }

    @Override
    public int[] getPossibleChildren(int parentNid, ViewCoordinate vc) throws IOException {
        if (vc.getIsaCoordinates().size() == 1) {
            IsaCoordinate isaCoordinate = vc.getIsaCoordinates().iterator().next();
            IsaCache cache = KindOfComputer.getIsaCacheMap().get(isaCoordinate);

            if ((cache != null) && cache.isReady()) {
                int[] allPossibleNids = Bdb.xref.getDestRelOrigins(parentNid, vc.getIsaTypeNids());
                NidListBI viewPossibleNids = new NidList();

                for (int childNid : allPossibleNids) {
                    try {
                        if (cache.isKindOf(childNid, parentNid)) {
                            viewPossibleNids.add(childNid);
                        }
                    } catch (Exception ex) {
                        throw new IOException(ex);
                    }
                }

                return viewPossibleNids.getListArray();
            }
        }

        return Bdb.xref.getDestRelOrigins(parentNid, vc.getIsaTypeNids());
    }

    @Override
    public long getSequence() {
        return Bdb.gVersion.incrementAndGet();
    }

    @Override
    public TerminologySnapshotDI getSnapshot(ViewCoordinate c) {
        return new TerminologySnapshot(this, c);
    }

    @Override
    public TerminologyBuilderBI getTerminologyBuilder(EditCoordinate ec, ViewCoordinate vc) {
        return new BdbTermBuilder(ec, vc);
    }

    @Override
    public Collection<? extends ConceptChronicleBI> getUncommittedConcepts() {
        return BdbCommitManager.getUncommitted();
    }

    @Override
    public List<UUID> getUuidsForNid(int nid) throws IOException {
        return Bdb.getUuidsToNidMap().getUuidsForNid(nid);
    }

    @Override
    public UUID getUuidPrimordialForNid(int nid) throws IOException {
        ComponentChroncileBI<?> c = getComponent(nid);
        if (c != null) {
            return c.getPrimUuid();
        }
        return UUID.fromString("00000000-0000-0000-C000-000000000046");
    }

    @Override
    public boolean hasPath(int nid) throws IOException {
        return BdbPathManager.get().hasPath(nid);
    }

    @Override
    public boolean hasUncommittedChanges() {
        if (BdbCommitManager.getUncommitted().isEmpty()) {
            return false;
        }

        return true;
    }

    @Override
    public boolean hasUuid(UUID memberUUID) {
        assert memberUUID != null;

        return Bdb.hasUuid(memberUUID);
    }

    @Override
    public boolean hasUuid(List<UUID> memberUUIDs) {
        assert memberUUIDs != null;

        for (UUID uuid : memberUUIDs) {
            if (Bdb.hasUuid(uuid)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void addVetoablePropertyChangeListener(CONCEPT_EVENT pce, VetoableChangeListener l) {
        GlobalPropertyChange.addVetoableChangeListener(pce, l);
    }

    @Override
    public void addPropertyChangeListener(CONCEPT_EVENT pce, PropertyChangeListener l) {
        GlobalPropertyChange.addPropertyChangeListener(pce, l);
    }

    @Override
    public int getSapNid(int statusNid, long time, int authorNid, int moduleNid, int pathNid) {
        return Bdb.getSapDb().getSapNid(statusNid, time, authorNid, moduleNid, pathNid);
    }

    @Override
    public int getMaxReadOnlySap() {
        return Bdb.getSapDb().getReadOnlyMax();
    }

    @Override
    public int getSapNid(TkRevision version) {
        return Bdb.getSapNid(version);
    }

    @Override
    public void resetConceptNidForNid(int cNid, int nid) throws IOException {
        Bdb.getNidCNidMap().resetCidForNid(cNid, nid);
    }

    @Override
    public void setConceptNidForNid(int cNid, int nid) throws IOException {
        Bdb.getNidCNidMap().setCNidForNid(cNid, nid);
    }

    @Override
    public boolean hasConcept(int cNid) throws IOException {
        return Bdb.isConcept(cNid);
    }

    @Override
    public void xrefAnnotation(RefexChronicleBI annotation) throws IOException {
        Bdb.xrefAnnotation(annotation);
    }

    private static class ConceptConverter implements Runnable {

        Throwable exception = null;
        TkConcept eConcept = null;
        Concept newConcept = null;
        NidCNidMapBdb nidCnidMap;
        LinkedBlockingQueue<ConceptConverter> converters;
        AtomicInteger conceptsProcessed;

        public ConceptConverter(LinkedBlockingQueue<ConceptConverter> converters, AtomicInteger conceptsRead) {
            this.converters = converters;
            this.conceptsProcessed = conceptsRead;
        }

        @Override
        public void run() {
            if (nidCnidMap == null) {
                nidCnidMap = Bdb.getNidCNidMap();
            }
            try {
                newConcept = Concept.get(eConcept);
                if (newConcept != null) {
                    assert newConcept.readyToWrite();
                    Bdb.getConceptDb().writeConcept(newConcept);
                    Collection<Integer> nids = newConcept.getAllNids();
                    assert nidCnidMap.getCNid(newConcept.getNid()) == newConcept.getNid();
                    for (int nid : nids) {
                        assert nidCnidMap.getCNid(nid) == newConcept.getNid();
                    }
                }
                conceptsProcessed.incrementAndGet();
            } catch (Throwable e) {
                exception = e;
            }
            converters.add(this);
        }

        /*
         * (non-Javadoc)
         *
         * @see org.ihtsdo.db.bdb.I_ProcessEConcept#setEConcept(org.ihtsdo.etypes .EConcept)
         */
        public void setEConcept(TkConcept eConcept) throws Throwable {
            if (exception != null) {
                throw exception;
            }
            this.eConcept = eConcept;
        }
    }

    @Override
    public void loadEconFiles(File[] econFiles) throws Exception {
        ThreadGroup loadBdbMultiDbThreadGroup = new ThreadGroup(this.getClass().getSimpleName()
                + ".loadEconFiles threads");
        ExecutorService executors = Executors.newCachedThreadPool(
                new NamedThreadFactory(loadBdbMultiDbThreadGroup, "converter "));
        try {
            LinkedBlockingQueue<ConceptConverter> converters = new LinkedBlockingQueue<>();
            int runtimeConverterSize = Runtime.getRuntime().availableProcessors() * 2;
            int converterSize = runtimeConverterSize;
            AtomicInteger conceptsRead = new AtomicInteger();
            AtomicInteger conceptsProcessed = new AtomicInteger();
            for (int i = 0; i < converterSize; i++) {
                converters.add(new ConceptConverter(converters, conceptsProcessed));
            }
            for (File conceptsFile : econFiles) {
                System.out.println("Starting load from: " + conceptsFile.getAbsolutePath());

                FileInputStream fis = new FileInputStream(conceptsFile);
                BufferedInputStream bis = new BufferedInputStream(fis);
                DataInputStream in = new DataInputStream(bis);

                try {
                    System.out.print(conceptsRead + "-");
                    while (true) {
                        TkConcept eConcept = new TkConcept(in);
                        int read = conceptsRead.incrementAndGet();
                        if (read % 100 == 0) {
                            if (read % 8000 == 0) {
                                System.out.println('.');
                                System.out.print(read + "-");
                            } else {
                                System.out.print('.');
                            }
                        }

                        ConceptConverter conceptConverter = converters.take();
                        try {
                            conceptConverter.setEConcept(eConcept);
                        } catch (Throwable ex) {
                            throw new IOException(ex);
                        }
                        executors.execute(conceptConverter);
                    }
                } catch (EOFException e) {
                    in.close();
                }

                // See if any exceptions in the last converters;
                while (converters.isEmpty() == false) {
                    ConceptConverter conceptConverter = converters.take();
                    try {
                        conceptConverter.setEConcept(null);
                    } catch (Throwable ex) {
                        Logger.getLogger(BdbTerminologyStore.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                while (conceptsProcessed.get() < conceptsRead.get()) {
                    Thread.sleep(1000);
                }

                System.out.println("\nFinished load of " + conceptsRead + " concepts from: "
                        + conceptsFile.getAbsolutePath());
            }
        } finally {
            executors.shutdown();
        }
        System.out.println("Starting db sync.");
        Bdb.sync();
        System.out.println("Finished db sync, starting generate lucene index.");
        LuceneManager.createLuceneIndex();
        Bdb.commit();
        System.out.println("Finished create lucene index.");
    }

    @Override
    public int getAuthorNidForSapNid(int sapNid) {
        return Bdb.getAuthorNidForSapNid(sapNid);
    }

    @Override
    public int getPathNidForSapNid(int sapNid) {
        return Bdb.getPathNidForSapNid(sapNid);
    }

    @Override
    public int getStatusNidForSapNid(int sapNid) {
        return Bdb.getStatusNidForSapNid(sapNid);
    }
    
    @Override
    public int getModuleNidForSapNid(int sapNid) {
        return Bdb.getModuleNidForSapNid(sapNid);
    }

    @Override
    public long getTimeForSapNid(int sapNid) {
        return Bdb.getTimeForSapNid(sapNid);
    }

    @Override
    public List<NidPairForRel> getDestRelPairs(int cNid) {
        return Bdb.getDestRelPairs(cNid);
    }

    @Override
    public List<NidPairForRefset> getRefexPairs(int nid) {
        return Bdb.getRefsetPairs(nid);
    }
    
    @Override
    public void addXrefPair(int nid, NidPair pair) {
        Bdb.addXrefPair(nid, pair);
    }

    @Override
    public void forgetXrefPair(int nid, NidPair pair) {
        Bdb.forgetXrefPair(nid, pair);
    }

    @Override
    public long getLastCommit() {
        return BdbCommitManager.getLastCommit();
    }

    @Override
    public long getLastCancel() {
        return BdbCommitManager.getLastCancel();
    }

    @Override
    public long incrementAndGetSequence() {
        return Bdb.gVersion.incrementAndGet();
    }

    @Override
    public void addUncommittedNoChecks(ConceptChronicleBI cc) throws IOException {
        BdbCommitManager.addUncommittedNoChecks(cc);
    }

    @Override
    public int getConceptCount() throws IOException {
       return Bdb.getConceptDb().getCount();
    }

    @Override
    public void waitTillWritesFinished() {
        BdbCommitManager.waitTillWritesFinished();
    }

    @Override
    public boolean commit(ConceptChronicleBI cc, ChangeSetPolicy changeSetPolicy, ChangeSetWriterThreading changeSetWriterThreading) throws IOException {
        return BdbCommitManager.commit((Concept) cc, changeSetPolicy, changeSetWriterThreading);
    }

    @Override
    public int[] getDestRelOriginNids(int cNid, NidSetBI relTypes) {
        return Bdb.xref.getDestRelOrigins(cNid, relTypes);
    }

    @Override
    public ConceptDataFetcherI getConceptDataFetcher(int cNid) throws IOException {
        return new NidDataFromBdb(cNid);
    }
    @Override
    public Map<String, String> getProperties() throws IOException {
        return Bdb.getProperties();
    }

    @Override
    public String getProperty(String key) throws IOException {
        return Bdb.getProperty(key);
    }

    @Override
    public void setProperty(String key, String value) throws IOException {
        Bdb.setProperty(key, value);
    }

    @Override
    public void cancelAfterCommit(NidSetBI commitSapNids) throws IOException {
        Bdb.getSapDb().cancelAfterCommit(commitSapNids);
    }

}
