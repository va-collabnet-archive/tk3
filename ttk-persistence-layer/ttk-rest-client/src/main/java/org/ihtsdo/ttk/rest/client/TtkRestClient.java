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



package org.ihtsdo.ttk.rest.client;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.NidBitSetBI;
import org.ihtsdo.ttk.api.NidSetBI;
import org.ihtsdo.ttk.api.PathBI;
import org.ihtsdo.ttk.api.PositionBI;
import org.ihtsdo.ttk.api.ProcessUnfetchedConceptDataBI;
import org.ihtsdo.ttk.api.TerminologyBuilderBI;
import org.ihtsdo.ttk.api.TerminologyDI.CONCEPT_EVENT;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.conattr.ConceptAttributeVersionBI;
import org.ihtsdo.ttk.api.concept.ConceptChronicleBI;
import org.ihtsdo.ttk.api.concept.ConceptVersionBI;
import org.ihtsdo.ttk.api.coordinate.EditCoordinate;
import org.ihtsdo.ttk.api.coordinate.StandardViewCoordinates;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.cs.ChangeSetPolicy;
import org.ihtsdo.ttk.api.cs.ChangeSetWriterThreading;
import org.ihtsdo.ttk.api.db.DbDependency;
import org.ihtsdo.ttk.api.description.DescriptionVersionBI;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.api.relationship.RelationshipVersionBI;
import org.ihtsdo.ttk.concept.cc.NidPairForRefex;
import org.ihtsdo.ttk.concept.cc.P;
import org.ihtsdo.ttk.concept.cc.concept.Concept;
import org.ihtsdo.ttk.concept.cc.concept.ConceptDataFetcherI;
import org.ihtsdo.ttk.concept.cc.concept.NidDataInMemory;
import org.ihtsdo.ttk.concept.cc.relationship.Relationship;
import org.ihtsdo.ttk.concept.cc.termstore.Termstore;
import org.ihtsdo.ttk.fx.FxComponentReference;
import org.ihtsdo.ttk.fx.concept.FxConcept;
import org.ihtsdo.ttk.fx.fetchpolicy.RefexPolicy;
import org.ihtsdo.ttk.fx.fetchpolicy.RelationshipPolicy;
import org.ihtsdo.ttk.fx.fetchpolicy.VersionPolicy;

//~--- JDK imports ------------------------------------------------------------

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import java.util.*;

import javax.ws.rs.core.MediaType;

/**
 *
 * @author kec
 */
public class TtkRestClient extends Termstore {
   public static final String    defaultLocalHostServer = "http://localhost:8080/terminology/rest/";
   public static final MediaType bdbMediaType           = new MediaType("application", "bdb");
   private static String         serverUrlStr           = defaultLocalHostServer;
   private static Client         restClient;
   private static TtkRestClient  restClientSingleton;

   @Override
   public long incrementAndGetSequence() {
      WebResource r           = restClient.resource(serverUrlStr + "sequence/next");
      String      sequenceStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);

      return Long.parseLong(sequenceStr);
   }

   @Override
   public void putViewCoordinate(ViewCoordinate vc) throws IOException {
      WebResource r = restClient.resource(serverUrlStr + "coordinate/view/" + vc.getVcUuid());

      r.type(bdbMediaType).accept(MediaType.TEXT_PLAIN).entity(vc, bdbMediaType).put();
   }

   public static void setup(String serverUrlStr) throws IOException {
      TtkRestClient.serverUrlStr = serverUrlStr;

      ClientConfig cc = new DefaultClientConfig();

      cc.getClasses().add(ViewCoordinateSerializationProvider.class);
      restClient          = Client.create(cc);
      restClientSingleton = new TtkRestClient();
      P.s                 = restClientSingleton;
      Ts.set(restClientSingleton);
      P.s.putViewCoordinate(P.s.getMetadataVC());
      P.s.putViewCoordinate(StandardViewCoordinates.getSnomedInferredLatest());
      Ts.get().setGlobalSnapshot(Ts.get().getSnapshot(StandardViewCoordinates.getSnomedInferredLatest()));
   }

   @Override
   public void waitTillWritesFinished() {
      WebResource r = restClient.resource(serverUrlStr + "termstore/wait-for-writes");

      r.accept(MediaType.TEXT_PLAIN).get(String.class);
   }

   @Override
   public int getAuthorNidForStamp(int sapNid) {
      WebResource r      = restClient.resource(serverUrlStr + "sap/author/" + sapNid);
      String      nidStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);

      return Integer.parseInt(nidStr);
   }

   @Override
   public ConceptDataFetcherI getConceptDataFetcher(int cNid) throws IOException {
      WebResource r  = restClient.resource(serverUrlStr + "concept/" + cNid);
      InputStream is = r.accept(bdbMediaType).get(InputStream.class);

      try (DataInputStream dis = new DataInputStream(is)) {
         int returnNid = dis.readInt();    // the cnid

         assert returnNid == cNid : "cNid: " + cNid + " returnNid: " + returnNid;

         ConceptDataFetcherI fetcher = new NidDataInMemory(is);

         return fetcher;
      }
   }

   @Override
   public int getConceptNidForNid(int nid) {
      WebResource r      = restClient.resource(serverUrlStr + "nid/concept/" + nid);
      String      nidStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);

      return Integer.parseInt(nidStr);
   }

   @Override
   public int[] getDestRelOriginNids(int cNid) throws IOException {
      WebResource r  = restClient.resource(serverUrlStr + "relationship/origin/" + cNid);
      InputStream is = r.accept(bdbMediaType).get(InputStream.class);

      try (ObjectInputStream ois = new ObjectInputStream(is)) {
         return (int[]) ois.readObject();
      } catch (ClassNotFoundException ex) {
         throw new IOException(ex);
      }
   }

   @Override
   public int[] getDestRelOriginNids(int cNid, NidSetBI relTypes) throws IOException {
      WebResource r  = restClient.resource(serverUrlStr + "relationship/origin/" + cNid + "/typed");
      InputStream is =
         r.queryParam("relTypes", relTypes.getAmpersandString()).accept(bdbMediaType).get(InputStream.class);

      try (ObjectInputStream ois = new ObjectInputStream(is)) {
         return (int[]) ois.readObject();
      } catch (ClassNotFoundException ex) {
         throw new IOException(ex);
      }
   }

   @Override
   public NidBitSetBI getEmptyNidSet() throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   private FxConcept getFxConcept(UUID conceptUUID, UUID vcUuid) {
      WebResource    r        = restClient.resource(serverUrlStr + "fx-concept/" + conceptUUID + "/"
                                   + vcUuid);
      ClientResponse response = r.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);

      return response.getEntity(FxConcept.class);
   }

   @Override
   public FxConcept getFxConcept(UUID conceptUUID, ViewCoordinate vc)
           throws IOException, ContradictionException {
      return getFxConcept(conceptUUID, vc.getVcUuid());
   }

   @Override
   public FxConcept getFxConcept(FxComponentReference ref, UUID vcUuid, VersionPolicy versionPolicy,
                                 RefexPolicy refexPolicy, RelationshipPolicy relationshipPolicy) {
      return getFxConcept(ref.getUuid(), vcUuid, versionPolicy, refexPolicy, relationshipPolicy);
   }

   @Override
   public FxConcept getFxConcept(FxComponentReference ref, ViewCoordinate vc, VersionPolicy versionPolicy,
                                 RefexPolicy refexPolicy, RelationshipPolicy relationshipPolicy) {
      return getFxConcept(ref, vc.getVcUuid(), versionPolicy, refexPolicy, relationshipPolicy);
   }

   @Override
   public FxConcept getFxConcept(UUID conceptUUID, UUID vcUuid, VersionPolicy versionPolicy,
                                 RefexPolicy refexPolicy, RelationshipPolicy relationshipPolicy) {
      WebResource r = restClient.resource(serverUrlStr + "fx-concept/" + conceptUUID + "/" + vcUuid + "/"
                         + versionPolicy + "/" + refexPolicy + "/" + relationshipPolicy);
      ClientResponse response = r.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);

      return response.getEntity(FxConcept.class);
   }

   @Override
   public FxConcept getFxConcept(UUID conceptUUID, ViewCoordinate vc, VersionPolicy versionPolicy,
                                 RefexPolicy refexPolicy, RelationshipPolicy relationshipPolicy) {
      return getFxConcept(conceptUUID, vc.getVcUuid(), versionPolicy, refexPolicy, relationshipPolicy);
   }

   @Override
   public long getLastCancel() {
      WebResource r           = restClient.resource(serverUrlStr + "sequence/last-cancel");
      String      sequenceStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);

      return Long.parseLong(sequenceStr);
   }

   @Override
   public long getLastCommit() {
      WebResource r           = restClient.resource(serverUrlStr + "sequence/last-commit");
      String      sequenceStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);

      return Long.parseLong(sequenceStr);
   }

   @Override
   public int getMaxReadOnlyStamp() {
      WebResource r      = restClient.resource(serverUrlStr + "sap/read-only-max");
      String      nidStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);

      return Integer.parseInt(nidStr);
   }

   @Override
   public ViewCoordinate getMetadataVC() throws IOException {
      return makeMetaVc();
   }

   @Override
   public int getModuleNidForStamp(int sapNid) {
      WebResource r      = restClient.resource(serverUrlStr + "sap/module/" + sapNid);
      String      nidStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);

      return Integer.parseInt(nidStr);
   }

   private int getNidForUuidSetString(String uuidSetString) {
      WebResource r      = restClient.resource(serverUrlStr + "nid/" + uuidSetString);
      String      nidStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);

      return Integer.parseInt(nidStr);
   }

   @Override
   public int getNidForUuids(Collection<UUID> uuids) throws IOException {
      StringBuilder  uuidSetStringBuilder = new StringBuilder();
      Iterator<UUID> uuidItr              = uuids.iterator();

      while (uuidItr.hasNext()) {
         uuidSetStringBuilder.append(uuidItr.next());

         if (uuidItr.hasNext()) {
            uuidSetStringBuilder.append("&");
         }
      }

      return getNidForUuidSetString(uuidSetStringBuilder.toString());
   }

   @Override
   public int getNidForUuids(UUID... uuids) throws IOException {
      StringBuilder uuidSetStringBuilder = new StringBuilder();

      for (int i = 0; i < uuids.length; i++) {
         uuidSetStringBuilder.append(uuids[i]);

         if (i + 1 < uuids.length) {
            uuidSetStringBuilder.append("&");
         }
      }

      return getNidForUuidSetString(uuidSetStringBuilder.toString());
   }

   @Override
   public PathBI getPath(int pathNid) throws IOException {
      WebResource r  = restClient.resource(serverUrlStr + "path/" + pathNid);
      InputStream is = r.accept(bdbMediaType).get(InputStream.class);

      try (ObjectInputStream ois = new ObjectInputStream(is)) {
         return (PathBI) ois.readObject();
      } catch (ClassNotFoundException ex) {
         throw new IOException(ex);
      }
   }

   @Override
   public int getPathNidForStamp(int sapNid) {
      WebResource r      = restClient.resource(serverUrlStr + "sap/path/" + sapNid);
      String      nidStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);

      return Integer.parseInt(nidStr);
   }

   @Override
   public Map<String, String> getProperties() throws IOException {
      WebResource r  = restClient.resource(serverUrlStr + "property/");
      InputStream is = r.accept(bdbMediaType).get(InputStream.class);

      try (ObjectInputStream ois = new ObjectInputStream(is)) {
         return (Map<String, String>) ois.readObject();
      } catch (ClassNotFoundException ex) {
         throw new IOException(ex);
      }
   }

   @Override
   public String getProperty(String key) throws IOException {
      WebResource r = restClient.resource(serverUrlStr + "property/" + key);

      return r.accept(MediaType.TEXT_PLAIN).get(String.class);
   }

   @Override
   public List<NidPairForRefex> getRefexPairs(int cNid) throws IOException {
      WebResource r  = restClient.resource(serverUrlStr + "nidpairs/refex" + cNid);
      InputStream is = r.accept(bdbMediaType).get(InputStream.class);

      try (ObjectInputStream ois = new ObjectInputStream(is)) {
         return (List<NidPairForRefex>) ois.readObject();
      } catch (ClassNotFoundException ex) {
         throw new IOException(ex);
      }
   }

   public static TtkRestClient getRestClient() throws IOException {
      if (restClientSingleton == null) {
         setup(TtkRestClient.defaultLocalHostServer);
      }

      return restClientSingleton;
   }

   @Override
   public long getSequence() {
      WebResource r           = restClient.resource(serverUrlStr + "sequence");
      String      sequenceStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);

      return Long.parseLong(sequenceStr);
   }

   @Override
   public int getStamp(int statusNid, long time, int authorNid, int moduleNid, int pathNid) {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public int getStatusNidForStamp(int sapNid) {
      WebResource r      = restClient.resource(serverUrlStr + "sap/status/" + sapNid);
      String      nidStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);

      return Integer.parseInt(nidStr);
   }

   @Override
   public TerminologyBuilderBI getTerminologyBuilder(EditCoordinate ec, ViewCoordinate vc) {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public long getTimeForStamp(int sapNid) {
      WebResource r       = restClient.resource(serverUrlStr + "sap/time/" + sapNid);
      String      timeStr = r.accept(MediaType.TEXT_PLAIN).get(String.class);

      return Long.parseLong(timeStr);
   }

   @Override
   public UUID getUuidPrimordialForNid(int nid) throws IOException {
      WebResource r = restClient.resource(serverUrlStr + "uuid/primordial/" + nid);

      return UUID.fromString(r.accept(MediaType.TEXT_PLAIN).get(String.class));
   }

   @Override
   public ViewCoordinate getViewCoordinate(UUID vcUuid) throws IOException {
      WebResource r  = restClient.resource(serverUrlStr + "coordinate/view/" + vcUuid.toString());
      InputStream is = r.accept(bdbMediaType).get(InputStream.class);

      try (ObjectInputStream ois = new ObjectInputStream(is)) {
         return (ViewCoordinate) ois.readObject();
      } catch (ClassNotFoundException ex) {
         throw new IOException(ex);
      }
   }

   @Override
   public Collection<ViewCoordinate> getViewCoordinates() throws IOException {
      WebResource r  = restClient.resource(serverUrlStr + "coordinate/view");
      InputStream is = r.accept(bdbMediaType).get(InputStream.class);

      try (ObjectInputStream ois = new ObjectInputStream(is)) {
         return (Collection<ViewCoordinate>) ois.readObject();
      } catch (ClassNotFoundException ex) {
         throw new IOException(ex);
      }
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
   public boolean hasUuid(UUID memberUUID) {
      WebResource r = restClient.resource(serverUrlStr + "uuid/" + memberUUID.toString());

      return Boolean.valueOf(r.accept(MediaType.TEXT_PLAIN).get(String.class));
   }

   //J-

   @Override
   public Collection<DbDependency> getLatestChangeSetDependencies() throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public Collection<? extends ConceptChronicleBI> getUncommittedConcepts() {
      throw new UnsupportedOperationException("Not supported yet.");
   }
   
   
   @Override
   public List<UUID> getUuidsForNid(int nid) throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void setConceptNidForNid(int cNid, int nid) throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void setProperty(String key, String value) throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }
   
   
   @Override
   public void addPropertyChangeListener(CONCEPT_EVENT pce, PropertyChangeListener l) {
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
   public void addVetoablePropertyChangeListener(CONCEPT_EVENT pce, VetoableChangeListener l) {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void addXrefPair(int nid, NidPairForRefex pair) {
      throw new UnsupportedOperationException("Not supported yet.");
   }

    @Override
    public void addRelOrigin(int destinationCNid, int originCNid) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   @Override
   public void cancel() throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void cancel(ConceptChronicleBI cc) throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void cancel(ConceptVersionBI cv) throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void cancelAfterCommit(NidSetBI commitSapNids) throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void commit() throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void commit(ConceptChronicleBI cc) throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void commit(ConceptVersionBI cv) throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public boolean commit(ConceptChronicleBI cc, ChangeSetPolicy changeSetPolicy,
                         ChangeSetWriterThreading changeSetWriterThreading)
           throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public boolean forget(ConceptAttributeVersionBI attr) throws IOException {
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
   public void forgetXrefPair(int nid, NidPairForRefex pair) {
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
   public void resetConceptNidForNid(int cNid, int nid) throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public boolean satisfiesDependencies(Collection<DbDependency> dependencies) {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void xrefAnnotation(RefexChronicleBI annotation) throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public NidBitSetBI getAllConceptNids() throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public Set<PathBI> getPathSetFromPositionSet(Set<PositionBI> positions) throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public Set<PathBI> getPathSetFromSapSet(Set<Integer> sapNids) throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public Set<PositionBI> getPositionSet(Set<Integer> sapNids) throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public int[] getPossibleChildren(int cNid, ViewCoordinate vc) throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }


   @Override
   public int getConceptCount() throws IOException {
      throw new UnsupportedOperationException("Not supported yet.");
   }


   @Override
   public List<? extends PathBI> getPathChildren(int nid) {
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
   public boolean hasUuid(List<UUID> memberUUIDs) {
      throw new UnsupportedOperationException("Not supported yet.");
   }

    @Override
    public void resumeChangeNotifications() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void suspendChangeNotifications() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<Relationship> getDestRels(int cNid) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isKindOf(int childNid, int parentNid, ViewCoordinate vc) throws IOException, ContradictionException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void put(UUID uuid, int nid) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    //J+
}
