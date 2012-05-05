package org.ihtsdo.db.bdb;

//~--- non-JDK imports --------------------------------------------------------
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import org.ihtsdo.cc.concept.ConceptVersion;
import org.ihtsdo.tk.api.*;
import org.ihtsdo.tk.api.changeset.ChangeSetGenerationPolicy;
import org.ihtsdo.tk.api.changeset.ChangeSetGeneratorBI;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.concept.ConceptVersionBI;
import org.ihtsdo.tk.api.coordinate.EditCoordinate;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;

//~--- JDK imports ------------------------------------------------------------

import java.io.File;
import java.io.IOException;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.tk.api.conattr.ConAttrVersionBI;
import org.ihtsdo.tk.api.cs.ChangeSetPolicy;
import org.ihtsdo.tk.api.cs.ChangeSetWriterThreading;
import org.ihtsdo.tk.api.description.DescriptionVersionBI;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.relationship.RelationshipVersionBI;
import org.ihtsdo.tk.db.DbDependency;

public class BdbTerminologySnapshot implements TerminologySnapshotDI {

    private BdbTerminologyStore store;
    private ViewCoordinate vc;

    //~--- constructors --------------------------------------------------------
    public BdbTerminologySnapshot(BdbTerminologyStore store, ViewCoordinate coordinate) {
        super();
        this.store = store;
        this.vc = coordinate;
    }

    //~--- methods -------------------------------------------------------------
    @Override
    public void addChangeSetGenerator(String key, ChangeSetGeneratorBI writer) {
        store.addChangeSetGenerator(key, writer);
    }

    @Override
    public void addUncommitted(ConceptChronicleBI concept) throws IOException {
        BdbCommitManager.addUncommitted(concept);
    }

    @Override
    public void addUncommitted(ConceptVersionBI cv) throws IOException {
        BdbCommitManager.addUncommitted(cv);
    }

    @Override
    public void cancel() throws IOException {
        BdbCommitManager.cancel();
    }

    @Override
    public void cancel(ConceptChronicleBI cc) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void cancel(ConceptVersionBI concept) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void commit() throws IOException {
        BdbCommitManager.commit(ChangeSetPolicy.MUTABLE_ONLY, ChangeSetWriterThreading.SINGLE_THREAD);
    }

    @Override
    public void commit(ConceptChronicleBI cc) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void commit(ConceptVersionBI cv) throws IOException {
        commit(cv);
    }

    @Override
    public ChangeSetGeneratorBI createDtoChangeSetGenerator(File changeSetFileName,
            File changeSetTempFileName, ChangeSetGenerationPolicy policy) {
        return store.createDtoChangeSetGenerator(changeSetFileName, changeSetTempFileName, policy);
    }

    @Override
    public PositionBI newPosition(PathBI path, long time) throws IOException {
        return store.newPosition(path, time);
    }

    @Override
    public void removeChangeSetGenerator(String key) {
        store.removeChangeSetGenerator(key);
    }

    //~--- get methods ---------------------------------------------------------
    @Override
    public TerminologyBuilderBI getBuilder(EditCoordinate ec) {
        return store.getTerminologyBuilder(ec, vc);
    }

    @Override
    public ComponentVersionBI getComponentVersion(Collection<UUID> uuids)
            throws IOException, ContradictionException {
        return store.getComponentVersion(vc, uuids);
    }

    @Override
    public ComponentVersionBI getComponentVersion(ComponentContainerBI cc)
            throws IOException, ContradictionException {
        return getComponentVersion(cc.getNid());
    }

    @Override
    public ComponentVersionBI getComponentVersion(int nid) throws IOException, ContradictionException {
        return store.getComponentVersion(vc, nid);
    }

    @Override
    public ComponentVersionBI getComponentVersion(UUID... uuids) throws IOException, ContradictionException {
        return store.getComponentVersion(vc, uuids);
    }

    @Override
    public ComponentVersionBI getComponentVersionFromAlternateId(String alternateId) throws IOException, ContradictionException {
        return store.getComponentVersionFromAlternateId(vc, alternateId);
    }

    @Override
    public ConceptVersionBI getConceptForNid(int nid) throws IOException {
        return new ConceptVersion((Concept) store.getConceptForNid(nid), vc);
    }

    @Override
    public ConceptVersionBI getConceptVersion(Collection<UUID> uuids) throws IOException {
        return new ConceptVersion(Bdb.getConcept(Bdb.uuidsToNid(uuids)), vc);
    }

    @Override
    public ConceptVersionBI getConceptVersion(ConceptContainerBI cc) throws IOException {
        return getConceptVersion(cc.getCnid());
    }

    @Override
    public ConceptVersionBI getConceptVersion(int cNid) throws IOException {
        return new ConceptVersion(Bdb.getConcept(cNid), vc);
    }

    @Override
    public ConceptVersionBI getConceptVersion(UUID... uuids) throws IOException {
        return new ConceptVersion(Bdb.getConcept(Bdb.uuidToNid(uuids)), vc);
    }

    @Override
    public ConceptVersionBI getConceptVersionFromAlternateId(String alternateId) throws IOException {
        Concept c = store.getConceptFromAlternateId(alternateId);
        if (c != null) {
            return new ConceptVersion(c, vc);
        }
        return null;
    }

    @Override
    public Map<Integer, ConceptVersionBI> getConceptVersions(NidBitSetBI cNids) throws IOException {
        return store.getConceptVersions(vc, cNids);
    }

    @Override
    public PathBI getPath(int pathNid) throws IOException {
        return store.getPath(pathNid);
    }

    @Override
    public Set<PathBI> getPathSetFromPositionSet(Set<PositionBI> positions) throws IOException {
        return store.getPathSetFromPositionSet(positions);
    }

    @Override
    public Set<PathBI> getPathSetFromSapSet(Set<Integer> sapNids) throws IOException {
        return store.getPathSetFromSapSet(sapNids);
    }

    @Override
    public Set<PositionBI> getPositionSet(Set<Integer> sapNids) throws IOException {
        return store.getPositionSet(sapNids);
    }

    @Override
    public int[] getPossibleChildren(int cNid) throws IOException {
        return store.getPossibleChildren(cNid, vc);
    }

    @Override
    public ViewCoordinate getViewCoordinate() {
        return vc;
    }

    @Override
    public int getConceptNidForNid(Integer nid) {
        return store.getConceptNidForNid(nid);
    }

    @Override
    public void addPropertyChangeListener(CONCEPT_EVENT pce, PropertyChangeListener l) {
        store.addPropertyChangeListener(pce, l);
    }

    @Override
    public void addTermChangeListener(TermChangeListener cl) {
        store.addTermChangeListener(cl);
    }

    @Override
    public void addVetoablePropertyChangeListener(CONCEPT_EVENT pce, VetoableChangeListener l) {
        store.addVetoablePropertyChangeListener(pce, l);
    }

    @Override
    public boolean forget(ConAttrVersionBI attr) throws IOException {
        return store.forget(attr);
    }

    @Override
    public void forget(ConceptChronicleBI concept) throws IOException {
        store.forget(concept);
    }

    @Override
    public void forget(DescriptionVersionBI desc) throws IOException {
        store.forget(desc);
    }

    @Override
    public void forget(RefexChronicleBI extension) throws IOException {
        store.forget(extension);
    }

    @Override
    public void forget(RelationshipVersionBI rel) throws IOException {
        store.forget(rel);
    }

    @Override
    public NidBitSetBI getAllConceptNids() throws IOException {
        return store.getAllConceptNids();
    }

    @Override
    public NidBitSetBI getEmptyNidSet() throws IOException {
        return store.getEmptyNidSet();
    }

    @Override
    public ViewCoordinate getMetadataVC() throws IOException {
        return store.getMetadataVC();
    }

    @Override
    public void iterateConceptDataInParallel(ProcessUnfetchedConceptDataBI processor) throws Exception {
        store.iterateConceptDataInParallel(processor);
    }

    @Override
    public void iterateConceptDataInSequence(ProcessUnfetchedConceptDataBI processor) throws Exception {
        store.iterateConceptDataInSequence(processor);
    }

    @Override
    public void loadEconFiles(File[] econFiles) throws Exception {
        store.loadEconFiles(econFiles);
    }

    @Override
    public void removeTermChangeListener(TermChangeListener cl) {
        store.removeTermChangeListener(cl);
    }

    @Override
    public boolean satisfiesDependencies(Collection<DbDependency> dependencies) {
        return store.satisfiesDependencies(dependencies);
    }

    @Override
    public void addUncommittedNoChecks(ConceptChronicleBI cc) throws IOException {
        BdbCommitManager.addUncommittedNoChecks(cc);
    }

    @Override
    public void addUncommittedNoChecks(ConceptVersionBI cv) throws IOException {
        BdbCommitManager.addUncommittedNoChecks(cv);
    }
    
}
