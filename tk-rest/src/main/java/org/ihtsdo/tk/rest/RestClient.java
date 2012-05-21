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
package org.ihtsdo.tk.rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import javax.ws.rs.core.MediaType;
import org.ihtsdo.cc.NidPair;
import org.ihtsdo.cc.NidPairForRefset;
import org.ihtsdo.cc.NidPairForRel;
import org.ihtsdo.cc.P;
import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.cc.concept.ConceptDataFetcherI;
import org.ihtsdo.cc.concept.NidDataInMemory;
import org.ihtsdo.cc.termstore.Termstore;
import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.*;
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
import org.ihtsdo.tk.dto.concept.component.TkRevision;

/**
 *
 * @author kec
 */
public class RestClient extends Termstore {

    public static final String defaultLocalHostSvr = "http://localhost:8080/rest/sim/";
    private static String serverUrlStr = defaultLocalHostSvr;
    private static Client c;
    private static RestClient singleton;

    public static void setup(String serverUrlStr) {
        RestClient.serverUrlStr = serverUrlStr;
        c = Client.create();
        singleton = new RestClient();
        P.s = singleton;
        Ts.set(singleton);
    }

    @Override
    public ConceptDataFetcherI getConceptDataFetcher(int cNid) throws IOException {
        WebResource r = c.resource(serverUrlStr + "concept/" + cNid);
        InputStream is = r.accept(new MediaType("application", "bdb")).get(InputStream.class);
        DataInputStream dis = new DataInputStream(is);
        int returnNid = dis.readInt();// the cnid
        assert returnNid == cNid : "cNid: " + cNid + " returnNid: " + returnNid;
        ConceptDataFetcherI fetcher = new NidDataInMemory(is);
        return fetcher;
    }

    @Override
    public int getMaxReadOnlySap() {
        WebResource r = c.resource(serverUrlStr + "sap/read-only-max");
        String nidStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);
        return Integer.parseInt(nidStr);
    }

    @Override
    public int getPathNidForSapNid(int sapNid) {
        WebResource r = c.resource(serverUrlStr + "sap/path/" + sapNid);
        String nidStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);
        return Integer.parseInt(nidStr);
    }

    @Override
    public int getAuthorNidForSapNid(int sapNid) {
        WebResource r = c.resource(serverUrlStr + "sap/author/" + sapNid);
        String nidStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);
        return Integer.parseInt(nidStr);
    }

    @Override
    public int getStatusNidForSapNid(int sapNid) {
        WebResource r = c.resource(serverUrlStr + "sap/status/" + sapNid);
        String nidStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);
        return Integer.parseInt(nidStr);
    }

    @Override
    public long getTimeForSapNid(int sapNid) {
        WebResource r = c.resource(serverUrlStr + "sap/time/" + sapNid);
        String timeStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);
        return Long.parseLong(timeStr);
    }
    @Override
    public int getConceptNidForNid(int nid) {
        WebResource r = c.resource(serverUrlStr + "nid/concept/" + nid);
        String nidStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);
        return Integer.parseInt(nidStr);
    }

    @Override
    public long getLastCancel() {
        WebResource r = c.resource(serverUrlStr + "sequence/last-cancel");
        String sequenceStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);
        return Long.parseLong(sequenceStr);
    }

    @Override
    public long getLastCommit() {
        WebResource r = c.resource(serverUrlStr + "sequence/last-commit");
        String sequenceStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);
        return Long.parseLong(sequenceStr);
    }
    @Override
    public long getSequence() {
        WebResource r = c.resource(serverUrlStr + "sequence");
        String sequenceStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);
        return Long.parseLong(sequenceStr);
    }
    
    @Override
    public boolean hasConcept(int cNid) throws IOException {
        if (Concept.getIfInMap(cNid) != null) {
            return true;
        }
        if (getConceptNidForNid(cNid) == cNid) {
            return true;
        }
        return false;
    }



    @Override
    public int getNidForUuids(Collection<UUID> uuids) throws IOException {
        if (uuids.size() == 1) {
            return getNidForUuid(uuids.iterator().next());
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private int getNidForUuid(UUID uuid) {
        WebResource r = c.resource(serverUrlStr + "nid/" + uuid);
        String nidStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);
        return Integer.parseInt(nidStr);
    }

    @Override
    public int getNidForUuids(UUID... uuids) throws IOException {
        if (uuids.length == 1) {
            return getNidForUuid(uuids[0]);
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getSapNid(int statusNid, int authorNid, int pathNid, long time) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getSapNid(TkRevision version) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void xrefAnnotation(RefexChronicleBI annotation) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long incrementAndGetSequence() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void waitTillWritesFinished() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean commit(ConceptChronicleBI cc, ChangeSetPolicy changeSetPolicy, ChangeSetWriterThreading changeSetWriterThreading) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Map<String, String> getProperties() throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getProperty(String key) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setProperty(String key, String value) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void cancelAfterCommit(NidSetBI commitSapNids) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addXrefPair(int nid, NidPair pair) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void forgetXrefPair(int nid, NidPair pair) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<NidPairForRel> getDestRelPairs(int cNid) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<NidPairForRefset> getRefsetPairs(int nid) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int[] getDestRelOriginNids(int cNid, NidSetBI relTypes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setConceptNidForNid(int cNid, int nid) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void resetConceptNidForNid(int cNid, int nid) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ComponentChroncileBI<?> getComponent(int nid) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<DbDependency> getLatestChangeSetDependencies() throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<? extends PathBI> getPathChildren(int nid) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int[] getPossibleChildren(int cNid, ViewCoordinate vc) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TerminologySnapshotDI getSnapshot(ViewCoordinate vc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TerminologyBuilderBI getTerminologyBuilder(EditCoordinate ec, ViewCoordinate vc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<? extends ConceptChronicleBI> getUncommittedConcepts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UUID getUuidPrimordialForNid(int nid) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<UUID> getUuidsForNid(int nid) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean hasPath(int nid) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean hasUncommittedChanges() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean hasUuid(UUID memberUUID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean hasUuid(List<UUID> memberUUIDs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getConceptCount() throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addUncommitted(ConceptChronicleBI cc) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addUncommittedNoChecks(ConceptChronicleBI cc) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void commit() throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void cancel() throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void commit(ConceptChronicleBI cc) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void cancel(ConceptChronicleBI cc) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void commit(ConceptVersionBI cv) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void cancel(ConceptVersionBI cv) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<PositionBI> getPositionSet(Set<Integer> sapNids) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<PathBI> getPathSetFromSapSet(Set<Integer> sapNids) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<PathBI> getPathSetFromPositionSet(Set<PositionBI> positions) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PathBI getPath(int pathNid) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addPropertyChangeListener(CONCEPT_EVENT pce, PropertyChangeListener l) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addVetoablePropertyChangeListener(CONCEPT_EVENT pce, VetoableChangeListener l) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean forget(ConAttrVersionBI attr) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void forget(ConceptChronicleBI concept) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void forget(DescriptionVersionBI desc) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void forget(RefexChronicleBI extension) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void forget(RelationshipVersionBI rel) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public NidBitSetBI getAllConceptNids() throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public NidBitSetBI getEmptyNidSet() throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ViewCoordinate getMetadataVC() throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void iterateConceptDataInParallel(ProcessUnfetchedConceptDataBI processor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void iterateConceptDataInSequence(ProcessUnfetchedConceptDataBI processor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void loadEconFiles(File[] econFiles) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean satisfiesDependencies(Collection<DbDependency> dependencies) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
