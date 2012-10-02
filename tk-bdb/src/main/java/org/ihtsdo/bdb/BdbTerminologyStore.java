package org.ihtsdo.bdb;

import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ihtsdo.bdb.id.NidCNidMapBdb;
import org.ihtsdo.bdb.temp.AceLog;
import org.ihtsdo.cc.*;
import org.ihtsdo.cc.change.LastChange;
import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.cc.concept.ConceptDataFetcherI;
import org.ihtsdo.cc.lucene.LuceneManager;
import org.ihtsdo.cc.relationship.Relationship;
import org.ihtsdo.cc.termstore.TerminologySnapshot;
import org.ihtsdo.cc.termstore.Termstore;
import org.ihtsdo.cs.CsProperty;
import org.ihtsdo.fxmodel.FxComponentReference;
import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.fetchpolicy.RefexPolicy;
import org.ihtsdo.fxmodel.fetchpolicy.RelationshipPolicy;
import org.ihtsdo.fxmodel.fetchpolicy.VersionPolicy;
import org.ihtsdo.helper.thread.NamedThreadFactory;
import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.*;
import org.ihtsdo.tk.api.TerminologyDI.CONCEPT_EVENT;
import org.ihtsdo.tk.api.conattr.ConAttrVersionBI;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.concept.ConceptVersionBI;
import org.ihtsdo.tk.api.coordinate.EditCoordinate;
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

   //~--- methods -------------------------------------------------------------

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
   public void addPropertyChangeListener(CONCEPT_EVENT pce, PropertyChangeListener l) {
      GlobalPropertyChange.addPropertyChangeListener(pce, l);
   }

   @Override
   public void addRelOrigin(int destinationCNid, int originCNid) throws IOException {
      Bdb.addRelOrigin(destinationCNid, originCNid);
   }

   @Override
   public void addUncommitted(ConceptChronicleBI concept) throws IOException {
      BdbCommitManager.addUncommitted(concept);
   }

   @Override
   public void addUncommittedNoChecks(ConceptChronicleBI cc) throws IOException {
      BdbCommitManager.addUncommittedNoChecks(cc);
   }

   @Override
   public void addVetoablePropertyChangeListener(CONCEPT_EVENT pce, VetoableChangeListener l) {
      GlobalPropertyChange.addVetoableChangeListener(pce, l);
   }

   @Override
   public void addXrefPair(int nid, NidPairForRefex pair) throws IOException {
      Bdb.addXrefPair(nid, pair);
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
   public void cancelAfterCommit(NidSetBI commitSapNids) throws IOException {
      Bdb.getStampDb().cancelAfterCommit(commitSapNids);
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
   public boolean commit(ConceptChronicleBI cc, ChangeSetPolicy changeSetPolicy,
                         ChangeSetWriterThreading changeSetWriterThreading)
           throws IOException {
      return BdbCommitManager.commit((Concept) cc, changeSetPolicy, changeSetWriterThreading);
   }

   @Override
   public boolean forget(ConAttrVersionBI attr) throws IOException {
      boolean forgotten = BdbCommitManager.forget(attr);

      if (forgotten) {
         Bdb.getConceptDb().forget((Concept) attr.getEnclosingConcept());
      }

      return forgotten;
   }

   @Override
   public void forget(ConceptChronicleBI concept) throws IOException {
      BdbCommitManager.forget(concept);
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
   public void forget(RelationshipVersionBI rel) throws IOException {
      BdbCommitManager.forget(rel);
   }

   @Override
   public void forgetXrefPair(int nid, NidPairForRefex pair) {
      Bdb.forgetXrefPair(nid, pair);
   }

   @Override
   public long incrementAndGetSequence() {
      return Bdb.gVersion.incrementAndGet();
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
   public void loadEconFiles(File[] econFiles) throws Exception {
      ThreadGroup loadBdbMultiDbThreadGroup = new ThreadGroup(this.getClass().getSimpleName()
                                                 + ".loadEconFiles threads");
      ExecutorService executors =
         Executors.newCachedThreadPool(new NamedThreadFactory(loadBdbMultiDbThreadGroup, "converter "));

      try {
         LinkedBlockingQueue<ConceptConverter>     converters                = new LinkedBlockingQueue<>();
         int                                       runtimeConverterSize      =
            Runtime.getRuntime().availableProcessors() * 2;
         int                                       converterSize             = runtimeConverterSize;
         AtomicInteger                             conceptsRead              = new AtomicInteger();
         AtomicInteger                             conceptsProcessed         = new AtomicInteger();
         ConcurrentSkipListSet<ConceptChronicleBI> indexedAnnotationConcepts = new ConcurrentSkipListSet<>();

         for (int i = 0; i < converterSize; i++) {
            converters.add(new ConceptConverter(converters, conceptsProcessed, indexedAnnotationConcepts));
         }

         for (File conceptsFile : econFiles) {
            System.out.println("Starting load from: " + conceptsFile.getAbsolutePath());

            FileInputStream     fis = new FileInputStream(conceptsFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream     in  = new DataInputStream(bis);

            try {
               System.out.print(conceptsRead + "-");

               while (true) {
                  TkConcept eConcept = new TkConcept(in);
                  int       read     = conceptsRead.incrementAndGet();

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

            for (ConceptChronicleBI indexedAnnotationConcept : indexedAnnotationConcepts) {
               Ts.get().addUncommittedNoChecks(indexedAnnotationConcept);
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
   public void put(UUID uuid, int nid) {
      Bdb.getUuidsToNidMap().put(uuid, nid);
   }

   @Override
   public void putViewCoordinate(ViewCoordinate vc) throws IOException {
      Bdb.putViewCoordinate(vc);
   }

   @Override
   public void resetConceptNidForNid(int cNid, int nid) throws IOException {
      Bdb.getNidCNidMap().resetCNidForNid(cNid, nid);
   }

   @Override
   public void resumeChangeNotifications() {
      LastChange.resumeChangeNotifications();
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

   @Override
   public void suspendChangeNotifications() {
      LastChange.suspendChangeNotifications();
   }

   public int uuidsToNid(Collection<UUID> uuids) throws IOException {
      return Bdb.uuidsToNid(uuids);
   }

   public int uuidsToNid(UUID... uuids) throws IOException {
      return Bdb.uuidToNid(uuids);
   }

   @Override
   public void waitTillWritesFinished() {
      BdbCommitManager.waitTillWritesFinished();
   }

   @Override
   public void xrefAnnotation(RefexChronicleBI annotation) throws IOException {
      Bdb.xrefAnnotation(annotation);
   }

   //~--- get methods ---------------------------------------------------------

   @Override
   public NidBitSetBI getAllConceptNids() throws IOException {
      return Bdb.getConceptDb().getReadOnlyConceptIdSet();
   }

   @Override
   public int getAuthorNidForStamp(int sapNid) {
      return Bdb.getAuthorNidForSapNid(sapNid);
   }

   @Override
   public int getConceptCount() throws IOException {
      return Bdb.getConceptDb().getCount();
   }

   @Override
   public ConceptDataFetcherI getConceptDataFetcher(int cNid) throws IOException {
      return new NidDataFromBdb(cNid);
   }

   @Override
   public int getConceptNidForNid(int nid) {
      return Bdb.getConceptNid(nid);
   }

   @Override
   public int[] getDestRelOriginNids(int cNid) throws IOException {
      return Bdb.getNidCNidMap().getDestRelNids(cNid);
   }

   @Override
   public int[] getDestRelOriginNids(int cNid, NidSetBI relTypes) throws IOException {
      return Bdb.getNidCNidMap().getDestRelNids(cNid, relTypes);
   }

   @Override
   public Collection<Relationship> getDestRels(int cNid) throws IOException {
      return Bdb.getNidCNidMap().getDestRels(cNid);
   }

   @Override
   public NidBitSetBI getEmptyNidSet() throws IOException {
      return Bdb.getConceptDb().getEmptyIdSet();
   }

   @Override
   public FxConcept getFxConcept(UUID conceptUUID, ViewCoordinate vc)
           throws IOException, ContradictionException {
      TerminologySnapshotDI ts = getSnapshot(vc);
      ConceptVersionBI      c  = ts.getConceptVersion(conceptUUID);

      return new FxConcept(ts, c, VersionPolicy.ALL_VERSIONS, RefexPolicy.REFEX_MEMBERS,
                           RelationshipPolicy.ORIGINATING_RELATIONSHIPS);
   }

   @Override
   public FxConcept getFxConcept(FxComponentReference ref, ViewCoordinate vc, VersionPolicy versionPolicy,
                                 RefexPolicy refexPolicy, RelationshipPolicy relationshipPolicy)
           throws IOException, ContradictionException {
      TerminologySnapshotDI ts = getSnapshot(vc);
      ConceptVersionBI      c;

      if (ref.getNid() != Integer.MAX_VALUE) {
         c = ts.getConceptVersion(ref.getNid());
      } else {
         c = ts.getConceptVersion(ref.getUuid());
      }

      return new FxConcept(ts, c, versionPolicy, refexPolicy, relationshipPolicy);
   }

   @Override
   public FxConcept getFxConcept(UUID conceptUUID, ViewCoordinate vc, VersionPolicy versionPolicy,
                                 RefexPolicy refexPolicy, RelationshipPolicy relationshipPolicy)
           throws IOException, ContradictionException {
      TerminologySnapshotDI ts = getSnapshot(vc);
      ConceptVersionBI      c  = ts.getConceptVersion(conceptUUID);

      return new FxConcept(ts, c, versionPolicy, refexPolicy, relationshipPolicy);
   }

   @Override
   public long getLastCancel() {
      return BdbCommitManager.getLastCancel();
   }

   @Override
   public long getLastCommit() {
      return BdbCommitManager.getLastCommit();
   }

   @Override
   public Collection<DbDependency> getLatestChangeSetDependencies() throws IOException {
      CsProperty[] keysToCheck = new CsProperty[] { CsProperty.LAST_CHANGE_SET_WRITTEN,
              CsProperty.LAST_CHANGE_SET_READ };
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
   public int getMaxReadOnlyStamp() {
      return Bdb.getStampDb().getReadOnlyMax();
   }

   @Override
   public ViewCoordinate getMetadataVC() throws IOException {
      if (metadataVC == null) {
         metadataVC = makeMetaVc();
         Bdb.putViewCoordinate(metadataVC);
      }

      return metadataVC;
   }

   @Override
   public int getModuleNidForStamp(int sapNid) {
      return Bdb.getModuleNidForSapNid(sapNid);
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
   public int getPathNidForStamp(int sapNid) {
      return Bdb.getPathNidForSapNid(sapNid);
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

   @Override
   public Set<PathBI> getPathSetFromSapSet(Set<Integer> sapNids) throws IOException {
      HashSet<PathBI> paths = new HashSet<>(sapNids.size());

      for (int sap : sapNids) {
         PathBI path = Bdb.getStampDb().getPosition(sap).getPath();

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
            positions.add(Bdb.getStampDb().getPosition(sap));
         }
      }

      return positions;
   }

   @Override
   public int[] getPossibleChildren(int parentNid, ViewCoordinate vc) throws IOException {
      throw new UnsupportedOperationException("needs to get concept nids, not rel nids");

      // return Bdb.getNidCNidMap().getDestRelNids(parentNid, vc);
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
   public List<NidPairForRefex> getRefexPairs(int nid) {
      return Bdb.getRefsetPairs(nid);
   }

   @Override
   public int getSapNid(TkRevision version) {
      return Bdb.getStamp(version);
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
   public int getStampNid(int statusNid, long time, int authorNid, int moduleNid, int pathNid) {
      return Bdb.getStampDb().getSapNid(statusNid, time, authorNid, moduleNid, pathNid);
   }

   @Override
   public int getStatusNidForStamp(int sapNid) {
      return Bdb.getStatusNidForSapNid(sapNid);
   }

   @Override
   public TerminologyBuilderBI getTerminologyBuilder(EditCoordinate ec, ViewCoordinate vc) {
      return new BdbTermBuilder(ec, vc);
   }

   @Override
   public long getTimeForStamp(int sapNid) {
      return Bdb.getTimeForSapNid(sapNid);
   }

   @Override
   public Collection<? extends ConceptChronicleBI> getUncommittedConcepts() {
      return BdbCommitManager.getUncommitted();
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
   public List<UUID> getUuidsForNid(int nid) throws IOException {
      return Bdb.getUuidsToNidMap().getUuidsForNid(nid);
   }

   @Override
   public ViewCoordinate getViewCoordinate(UUID vcUuid) throws IOException {
      return Bdb.getViewCoordinate(vcUuid);
   }

   @Override
   public Collection<ViewCoordinate> getViewCoordinates() throws IOException {
      return Bdb.getViewCoordinates();
   }

   @Override
   public boolean hasConcept(int cNid) throws IOException {
      return Bdb.isConcept(cNid);
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
   public boolean hasUuid(UUID memberUUID) {
      assert memberUUID != null;

      return Bdb.hasUuid(memberUUID);
   }

   @Override
   public boolean isKindOf(int childNid, int parentNid, ViewCoordinate vc)
           throws IOException, ContradictionException {
      return Bdb.getNidCNidMap().isKindOf(childNid, parentNid, vc);
   }

   //~--- set methods ---------------------------------------------------------

   @Override
   public void setConceptNidForNid(int cNid, int nid) throws IOException {
      Bdb.getNidCNidMap().setCNidForNid(cNid, nid);
   }

   @Override
   public void setProperty(String key, String value) throws IOException {
      Bdb.setProperty(key, value);
   }

   //~--- inner classes -------------------------------------------------------

   private static class ConceptConverter implements Runnable {
      TkConcept                                 eConcept   = null;
      Throwable                                 exception  = null;
      Concept                                   newConcept = null;
      AtomicInteger                             conceptsProcessed;
      LinkedBlockingQueue<ConceptConverter>     converters;
      ConcurrentSkipListSet<ConceptChronicleBI> indexedAnnotationConcepts;
      NidCNidMapBdb                             nidCnidMap;

      //~--- constructors -----------------------------------------------------

      public ConceptConverter(LinkedBlockingQueue<ConceptConverter> converters, AtomicInteger conceptsRead,
                              ConcurrentSkipListSet<ConceptChronicleBI> indexedAnnotationConcepts) {
         this.converters                = converters;
         this.conceptsProcessed         = conceptsRead;
         this.indexedAnnotationConcepts = indexedAnnotationConcepts;
      }

      //~--- methods ----------------------------------------------------------

      @Override
      public void run() {
         if (nidCnidMap == null) {
            nidCnidMap = Bdb.getNidCNidMap();
         }

         try {
            newConcept = Concept.get(eConcept, indexedAnnotationConcepts);

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

      //~--- set methods ------------------------------------------------------

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
}
