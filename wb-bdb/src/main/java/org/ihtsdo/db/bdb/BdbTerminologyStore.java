package org.ihtsdo.db.bdb;

//~--- non-JDK imports --------------------------------------------------------
import org.ihtsdo.tk.binding.SnomedMetadataRfx;
import org.ihtsdo.tk.binding.SnomedMetadataRf1;
import org.ihtsdo.tk.binding.TermAux;
import org.ihtsdo.tk.binding.Taxonomies;
import org.ihtsdo.tk.binding.SnomedMetadataRf2;
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;
import org.ihtsdo.concept.*;
import org.ihtsdo.cs.ChangeSetWriterHandler;
import org.ihtsdo.cs.econcept.EConceptChangeSetWriter;
import org.ihtsdo.db.bdb.computer.ReferenceConcepts;
import org.ihtsdo.db.bdb.computer.kindof.IsaCache;
import org.ihtsdo.db.bdb.computer.kindof.KindOfComputer;
import org.ihtsdo.db.bdb.computer.kindof.TypeCache;
import org.ihtsdo.db.bdb.id.NidCNidMapBdb;
import org.ihtsdo.db.change.LastChange;
import org.ihtsdo.helper.thread.NamedThreadFactory;
import org.ihtsdo.lucene.LuceneManager;
import org.ihtsdo.temp.AceLog;
import org.ihtsdo.temp.PositionSetReadOnly;
import org.ihtsdo.temp.SearchResult;
import org.ihtsdo.tk.api.*;
import org.ihtsdo.tk.api.changeset.ChangeSetGenerationPolicy;
import org.ihtsdo.tk.api.changeset.ChangeSetGeneratorBI;
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

public class BdbTerminologyStore implements TerminologyStoreDI {

    private static ViewCoordinate metadataVC = null;
    private static boolean isReleaseFormatSetup = false;
    private static int releaseFormat = 0;

    //~--- methods -------------------------------------------------------------
    @Override
    public void addChangeSetGenerator(String key, ChangeSetGeneratorBI writer) {
        ChangeSetWriterHandler.addWriter(key, writer);
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
    public void addTermChangeListener(TermChangeListener cl) {
        LastChange.addTermChangeListener(cl);
    }

    @Override
    public void addUncommitted(ConceptChronicleBI concept) throws IOException {
        BdbCommitManager.addUncommitted(concept);
    }

    @Override
    public void addUncommitted(ConceptVersionBI cv) throws IOException {
        addUncommitted(cv.getChronicle());
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
    public void forget(ConAttrVersionBI attr) throws IOException {
        BdbCommitManager.forget(attr);
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
    public ChangeSetGeneratorBI createDtoChangeSetGenerator(File changeSetFileName,
            File changeSetTempFileName, ChangeSetGenerationPolicy policy) {
        return new EConceptChangeSetWriter(changeSetFileName, changeSetTempFileName, policy, true);
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
    public PositionBI newPosition(PathBI path, long time) throws IOException {
        return new Position(time, path);
    }

    @Override
    public void removeChangeSetGenerator(String key) {
        ChangeSetWriterHandler.removeWriter(key);
    }

    @Override
    public void removeTermChangeListener(TermChangeListener cl) {
        LastChange.removeTermChangeListener(cl);
    }

    @Override
    public boolean satisfiesDependencies(Collection<DbDependency> dependencies) {
        if (dependencies != null) {
            try {
                for (DbDependency d : dependencies) {
                    String value = Bdb.getProperty(d.getKey());

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

    @Override
    public boolean usesRf2Metadata() throws IOException {
        if (isReleaseFormatSetup == false) {
            UUID snomedRootUuid = Taxonomies.SNOMED.getUuids()[0];
            if (hasUuid(snomedRootUuid)) {
                int snomedRootNid = Bdb.uuidToNid(snomedRootUuid);
                Concept cb = Bdb.getConcept(snomedRootNid);
                int rootStatusNid = cb.getConAttrs().getVersions().iterator().next().getStatusNid();
                int rf1CurrentNid = Bdb.uuidToNid(SnomedMetadataRf1.CURRENT_RF1.getUuids());
                int rf2ActiveValueNid = Bdb.uuidToNid(SnomedMetadataRf2.ACTIVE_VALUE_RF2.getUuids());

                if (rootStatusNid == rf1CurrentNid) {
                    releaseFormat = 1;
                    isReleaseFormatSetup = true;
                } else if (rootStatusNid == rf2ActiveValueNid) {
                    releaseFormat = 2;
                    isReleaseFormatSetup = true;
                } else {
                    throw new IOException("usesRf2Metadata current/active status did not match Rf1 or Rf2.");
                }
            }
        }

        if (releaseFormat == 2) {
            return true;
        } else {
            return false;
        }
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

    @Override
    public KindOfCacheBI getCache(ViewCoordinate coordinate) throws Exception {
        TypeCache c = new IsaCache(Bdb.getConceptDb().getConceptNidSet());

        c.setup(coordinate);
        c.getLatch().await();

        return c;
    }

    @Override
    public ComponentChroncileBI<?> getComponent(Collection<UUID> uuids) throws IOException {
        return getComponent(Bdb.uuidsToNid(uuids));
    }

    @Override
    public ComponentChroncileBI<?> getComponent(ComponentContainerBI cc) throws IOException {
        return getComponent(cc.getNid());
    }

    @Override
    public ComponentChroncileBI<?> getComponent(int nid) throws IOException {
        return (ComponentChroncileBI<?>) Bdb.getComponent(nid);
    }

    @Override
    public ComponentChroncileBI<?> getComponent(UUID... uuids) throws IOException {
        return getComponent(Bdb.uuidToNid(uuids));
    }

    @Override
    public ComponentVersionBI getComponentVersion(ViewCoordinate c, Collection<UUID> uuids)
            throws IOException, ContradictionException {
        return getComponentVersion(c, Bdb.uuidsToNid(uuids));
    }

    @Override
    public ComponentVersionBI getComponentVersion(ViewCoordinate coordinate, int nid)
            throws IOException, ContradictionException {
        ComponentBI component = getComponent(nid);

        if (Concept.class.isAssignableFrom(component.getClass())) {
            return new ConceptVersion((Concept) component, coordinate);
        }

        return ((ComponentChroncileBI<?>) component).getVersion(coordinate);
    }

    @Override
    public ComponentVersionBI getComponentVersion(ViewCoordinate c, UUID... uuids)
            throws IOException, ContradictionException {
        return getComponentVersion(c, Bdb.uuidToNid(uuids));
    }

    @Override
    public ConceptChronicleBI getConcept(Collection<UUID> uuids) throws IOException {
        return getConcept(Bdb.uuidsToNid(uuids));
    }

    @Override
    public ConceptChronicleBI getConcept(ConceptContainerBI cc) throws IOException {
        return getConcept(cc.getCnid());
    }

    @Override
    public ConceptChronicleBI getConcept(int cNid) throws IOException {
        return Bdb.getConcept(cNid);
    }

    @Override
    public ConceptChronicleBI getConcept(UUID... uuids) throws IOException {
        return getConcept(Bdb.uuidToNid(uuids));
    }

    @Override
    public ConceptChronicleBI getConceptForNid(int nid) throws IOException {
        return getConcept(getConceptNidForNid(nid));
    }

    @Override
    public int getConceptNidForNid(int nid) throws IOException {
        return Bdb.getConceptNid(nid);
    }

    @Override
    public ConceptVersionBI getConceptVersion(ViewCoordinate c, Collection<UUID> uuids) throws IOException {
        return getConceptVersion(c, Bdb.uuidsToNid(uuids));
    }

    @Override
    public ConceptVersionBI getConceptVersion(ViewCoordinate c, int cNid) throws IOException {
        return new ConceptVersion(Bdb.getConcept(cNid), c);
    }

    @Override
    public ConceptVersionBI getConceptVersion(ViewCoordinate c, UUID... uuids) throws IOException {
        return getConceptVersion(c, Bdb.uuidToNid(uuids));
    }

    @Override
    public Map<Integer, ConceptVersionBI> getConceptVersions(ViewCoordinate c, NidBitSetBI cNids)
            throws IOException {
        ConceptVersionGetter processor = new ConceptVersionGetter(cNids, c);

        try {
            Bdb.getConceptDb().iterateConceptDataInParallel(processor);
        } catch (Exception e) {
            throw new IOException(e);
        }

        return Collections.unmodifiableMap(new HashMap<Integer, ConceptVersionBI>(processor.conceptMap));
    }

    @Override
    public Map<Integer, ConceptChronicleBI> getConcepts(NidBitSetBI cNids) throws IOException {
        ConceptGetter processor = new ConceptGetter(cNids);

        try {
            Bdb.getConceptDb().iterateConceptDataInParallel(processor);
        } catch (Exception e) {
            throw new IOException(e);
        }

        return Collections.unmodifiableMap(new HashMap<Integer, ConceptChronicleBI>(processor.conceptMap));
    }

    @Override
    public NidBitSetBI getEmptyNidSet() throws IOException {
        return Bdb.getConceptDb().getEmptyIdSet();
    }

    @Override
    public Collection<DbDependency> getLatestChangeSetDependencies() throws IOException {
        BdbProperty[] keysToCheck = new BdbProperty[]{BdbProperty.LAST_CHANGE_SET_WRITTEN,
            BdbProperty.LAST_CHANGE_SET_READ};
        List<DbDependency> latestDependencies = new ArrayList<DbDependency>(2);

        for (BdbProperty prop : keysToCheck) {
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
        HashSet<PathBI> paths = new HashSet<PathBI>(positions.size());

        for (PositionBI position : positions) {
            paths.add(position.getPath());

            // addOrigins(paths, position.getPath().getInheritedOrigins());
        }

        return paths;
    }

    @Override
    public Set<PathBI> getPathSetFromSapSet(Set<Integer> sapNids) throws IOException {
        HashSet<PathBI> paths = new HashSet<PathBI>(sapNids.size());

        for (int sap : sapNids) {
            PathBI path = Bdb.getSapDb().getPosition(sap).getPath();

            paths.add(path);
            addOrigins(paths, path.getOrigins());
        }

        return paths;
    }

    @Override
    public Set<PositionBI> getPositionSet(Set<Integer> sapNids) throws IOException {
        HashSet<PositionBI> positions = new HashSet<PositionBI>(sapNids.size());

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
        return new BdbTerminologySnapshot(this, c);
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
            LinkedBlockingQueue<ConceptConverter> converters = new LinkedBlockingQueue<ConceptConverter>();
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

    //~--- inner classes -------------------------------------------------------
    private class ConceptGetter implements I_ProcessUnfetchedConceptData {

        Map<Integer, ConceptChronicleBI> conceptMap = new ConcurrentHashMap<Integer, ConceptChronicleBI>();
        NidBitSetBI cNids;

        //~--- constructors -----------------------------------------------------
        public ConceptGetter(NidBitSetBI cNids) {
            super();
            this.cNids = cNids;
        }

        //~--- methods ----------------------------------------------------------
        @Override
        public boolean continueWork() {
            return true;
        }

        @Override
        public void processUnfetchedConceptData(int cNid, ConceptFetcherBI fcfc) throws Exception {
            if (cNids.isMember(cNid)) {
                Concept c = (Concept) fcfc.fetch();

                conceptMap.put(cNid, c);
            }
        }

        //~--- get methods ------------------------------------------------------
        @Override
        public NidBitSetBI getNidSet() throws IOException {
            return cNids;
        }

        //~--- set methods ------------------------------------------------------
        @Override
        public void setParallelConceptIterators(List<ParallelConceptIterator> pcis) {
            // TODO Auto-generated method stub
        }
    }

    private class ConceptVersionGetter implements I_ProcessUnfetchedConceptData {

        Map<Integer, ConceptVersionBI> conceptMap = new ConcurrentHashMap<Integer, ConceptVersionBI>();
        NidBitSetBI cNids;
        ViewCoordinate coordinate;

        //~--- constructors -----------------------------------------------------
        public ConceptVersionGetter(NidBitSetBI cNids, ViewCoordinate c) {
            super();
            this.cNids = cNids;
            this.coordinate = c;
        }

        //~--- methods ----------------------------------------------------------
        @Override
        public boolean continueWork() {
            return true;
        }

        @Override
        public void processUnfetchedConceptData(int cNid, ConceptFetcherBI fcfc) throws Exception {
            if (cNids.isMember(cNid)) {
                Concept c = (Concept) fcfc.fetch();

                conceptMap.put(cNid, new ConceptVersion(c, coordinate));
            }
        }

        //~--- get methods ------------------------------------------------------
        @Override
        public NidBitSetBI getNidSet() throws IOException {
            return cNids;
        }

        //~--- set methods ------------------------------------------------------
        @Override
        public void setParallelConceptIterators(List<ParallelConceptIterator> pcis) {
            // TODO Auto-generated method stub
        }
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
    public long getTimeForSapNid(int sapNid) {
        return Bdb.getTimeForSapNid(sapNid);
    }

    @Override
    public ComponentChroncileBI<?> getComponentFromAlternateId(String altId) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ComponentVersionBI getComponentVersionFromAlternateId(ViewCoordinate vc, String altId) throws IOException, ContradictionException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Concept getConceptFromAlternateId(String altId) throws IOException {
        Collection<Integer> cnids = searchLucene(altId, SearchType.CONCEPT);
        if (cnids.size() > 1) {
            NidSet ns = new NidSet();
            for (int nid: cnids) {
                ns.add(nid);
            }
            throw new IOException("Non-unique match for: " + altId + " " + cnids);
        }
        if (cnids.isEmpty()) {
            return null;
        }
        return Concept.get(cnids.iterator().next());
    }

    @Override
    public ConceptVersion getConceptVersionFromAlternateId(ViewCoordinate vc, String altId) throws IOException {
        Concept c = getConceptFromAlternateId(altId);
        return new ConceptVersion(c, vc);
    }
    

    public static enum SearchType {

        CONCEPT, DESCRIPTION
    };

    public Collection<Integer> searchLucene(String query, SearchType searchType)
            throws IOException {

        try {
            Query q = new QueryParser(LuceneManager.version, "desc",
                    new StandardAnalyzer(LuceneManager.version)).parse(query);

            SearchResult result = LuceneManager.search(q);

            if (result.topDocs.totalHits > 0) {
                if (AceLog.getAppLog().isLoggable(Level.FINE)) {
                    AceLog.getAppLog().fine("StandardAnalyzer query returned " + result.topDocs.totalHits + " hits");
                }
            } else {
                AceLog.getAppLog().info(
                        "StandardAnalyzer query returned no results. Now trying WhitespaceAnalyzer query");
                q = new QueryParser(LuceneManager.version, "desc", new WhitespaceAnalyzer()).parse(query);
                result = LuceneManager.search(q);
            }

            HashSet<Integer> nidSet = new HashSet<Integer>(result.topDocs.totalHits);
            for (int i = 0; i < result.topDocs.totalHits; i++) {
                Document doc = result.searcher.doc(result.topDocs.scoreDocs[i].doc);

                int dnid = Integer.parseInt(doc.get("dnid"));
                int cnid = Integer.parseInt(doc.get("cnid"));
                switch (searchType) {
                    case CONCEPT:
                        nidSet.add(cnid);
                        break;
                    case DESCRIPTION:
                        nidSet.add(dnid);
                        break;
                    default:
                        throw new IOException("Can't handle: " + searchType);
                }

                float score = result.topDocs.scoreDocs[i].score;

                if (AceLog.getAppLog().isLoggable(Level.FINE)) {
                    AceLog.getAppLog().fine("Hit: " + doc + " Score: " + score);
                }

            }
            return nidSet;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
