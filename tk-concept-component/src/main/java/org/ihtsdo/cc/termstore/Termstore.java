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
package org.ihtsdo.cc.termstore;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;
import org.ihtsdo.cc.P;
import org.ihtsdo.cc.change.LastChange;
import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.cc.concept.ConceptVersion;
import org.ihtsdo.cc.lucene.LuceneManager;
import org.ihtsdo.cc.lucene.SearchResult;
import org.ihtsdo.cs.ChangeSetWriterHandler;
import org.ihtsdo.cs.econcept.EConceptChangeSetWriter;
import org.ihtsdo.tk.api.*;
import org.ihtsdo.tk.api.changeset.ChangeSetGenerationPolicy;
import org.ihtsdo.tk.api.changeset.ChangeSetGeneratorBI;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.concept.ConceptVersionBI;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;

/**
 *
 * @author kec
 */
public abstract class Termstore implements PersistentStoreI {

    @Override
    public void addTermChangeListener(TermChangeListener cl) {
        LastChange.addTermChangeListener(cl);
    }

    //~--- methods -------------------------------------------------------------
    @Override
    public void addChangeSetGenerator(String key, ChangeSetGeneratorBI writer) {
        ChangeSetWriterHandler.addWriter(key, writer);
    }

    @Override
    public void addUncommitted(ConceptVersionBI cv) throws IOException {
        addUncommitted(cv.getChronicle());
    }

    @Override
    public ChangeSetGeneratorBI createDtoChangeSetGenerator(File changeSetFileName, File changeSetTempFileName, ChangeSetGenerationPolicy policy) {
        return new EConceptChangeSetWriter(changeSetFileName, changeSetTempFileName, policy, true);
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
    public ComponentChroncileBI<?> getComponent(ComponentContainerBI cc) throws IOException {
        return getComponent(cc.getNid());
    }

    @Override
    public ComponentVersionBI getComponentVersion(ViewCoordinate coordinate, int nid) throws IOException, ContradictionException {
        ComponentBI component = getComponent(nid);
        if (Concept.class.isAssignableFrom(component.getClass())) {
            return new ConceptVersion((Concept) component, coordinate);
        }
        return ((ComponentChroncileBI<?>) component).getVersion(coordinate);
    }

    @Override
    public ComponentChroncileBI<?> getComponent(Collection<UUID> uuids) throws IOException {
        return getComponent(getNidForUuids(uuids));
    }

    @Override
    public ComponentChroncileBI<?> getComponent(UUID... uuids) throws IOException {
        return getComponent(getNidForUuids(uuids));
    }

    @Override
    public ConceptChronicleBI getConcept(int cNid) throws IOException {
        return Concept.get(cNid);
    }

    @Override
    public ConceptChronicleBI getConcept(Collection<UUID> uuids) throws IOException {
        return getConcept(getNidForUuids(uuids));
    }

    @Override
    public ConceptChronicleBI getConcept(ConceptContainerBI cc) throws IOException {
        return getConcept(cc.getCnid());
    }

    @Override
    public ConceptChronicleBI getConcept(UUID... uuids) throws IOException {
        return getConcept(getNidForUuids(uuids));
    }

    @Override
    public ConceptChronicleBI getConceptForNid(int nid) throws IOException {
        return getConcept(getConceptNidForNid(nid));
    }

    @Override
    public ConceptVersionBI getConceptVersion(ViewCoordinate c, Collection<UUID> uuids) throws IOException {
        return getConceptVersion(c, getNidForUuids(uuids));
    }

    @Override
    public ConceptVersionBI getConceptVersion(ViewCoordinate c, int cNid) throws IOException {
        return new ConceptVersion(Concept.get(cNid), c);
    }

    @Override
    public ConceptVersionBI getConceptVersion(ViewCoordinate c, UUID... uuids) throws IOException {
        return getConceptVersion(c, getNidForUuids(uuids));
    }

    @Override
    public ComponentChroncileBI<?> getComponentFromAlternateId(String altId) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ComponentVersionBI getComponentVersionFromAlternateId(ViewCoordinate vc, String altId) throws IOException, ContradictionException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Collection<Integer> searchLucene(String query, SearchType searchType) throws IOException {
        try {
            Query q = new QueryParser(LuceneManager.version, "desc", new StandardAnalyzer(LuceneManager.version)).parse(query);
            SearchResult result = LuceneManager.search(q);
            if (result.topDocs.totalHits > 0) {
                if (TermstoreLogger.logger.isLoggable(Level.FINE)) {
                    TermstoreLogger.logger.log(Level.FINE, "StandardAnalyzer query returned {0} hits", result.topDocs.totalHits);
                }
            } else {
                if (TermstoreLogger.logger.isLoggable(Level.FINE)) {
                    TermstoreLogger.logger.fine("StandardAnalyzer query returned no results. Now trying WhitespaceAnalyzer query");
                    q = new QueryParser(LuceneManager.version, "desc", new WhitespaceAnalyzer()).parse(query);
                }
                result = LuceneManager.search(q);
            }
            HashSet<Integer> nidSet = new HashSet<>(result.topDocs.totalHits);
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
                if (TermstoreLogger.logger.isLoggable(Level.FINE)) {
                    TermstoreLogger.logger.log(Level.FINE, "Hit: {0} Score: {1}", new Object[]{doc, score});
                }
            }
            return nidSet;
        } catch (ParseException | IOException | NumberFormatException e) {
            throw new IOException(e);
        }
    }

    @Override
    public Concept getConceptFromAlternateId(String altId) throws IOException {
        Collection<Integer> cnids = searchLucene(altId, SearchType.CONCEPT);
        if (cnids.size() > 1) {
            NidSet ns = new NidSet();
            for (int nid : cnids) {
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

    @Override
    public Map<Integer, ConceptVersionBI> getConceptVersions(ViewCoordinate c, NidBitSetBI cNids)
            throws IOException {
        ConceptVersionGetter processor = new ConceptVersionGetter(cNids, c);

        try {
            P.s.iterateConceptDataInParallel(processor);
        } catch (Exception e) {
            throw new IOException(e);
        }

        return Collections.unmodifiableMap(new HashMap<>(processor.conceptMap));
    }

    @Override
    public ComponentVersionBI getComponentVersion(ViewCoordinate c, Collection<UUID> uuids)
            throws IOException, ContradictionException {
        return getComponentVersion(c, getNidForUuids(uuids));
    }

    @Override
    public ComponentVersionBI getComponentVersion(ViewCoordinate c, UUID... uuids)
            throws IOException, ContradictionException {
        return getComponentVersion(c, getNidForUuids(uuids));
    }

    
    @Override
    public Map<Integer, ConceptChronicleBI> getConcepts(NidBitSetBI cNids) throws IOException {
        ConceptGetter processor = new ConceptGetter(cNids);

        try {
            P.s.iterateConceptDataInParallel(processor);
        } catch (Exception e) {
            throw new IOException(e);
        }

        return Collections.unmodifiableMap(new HashMap<>(processor.conceptMap));
    }

    @Override
    public void addUncommittedNoChecks(ConceptVersionBI cv) throws IOException {
        addUncommittedNoChecks(cv.getChronicle());
    }

}
