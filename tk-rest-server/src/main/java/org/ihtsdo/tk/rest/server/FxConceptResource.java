
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package org.ihtsdo.tk.rest.server;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.cc.concept.ConceptDataFetcherI;
import org.ihtsdo.cc.termstore.PersistentStoreI;
import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.fetchpolicy.RefexPolicy;
import org.ihtsdo.fxmodel.fetchpolicy.RelationshipPolicy;
import org.ihtsdo.fxmodel.fetchpolicy.VersionPolicy;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.dto.concept.TkConcept;

//~--- JDK imports ------------------------------------------------------------

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.StreamingOutput;

/**
 *
 * @author kec
 */
@Path("/fx-concept")
public class FxConceptResource {
   @Context
   PersistentStoreI ts;

   //~--- get methods ---------------------------------------------------------

   @GET
   @Path("{id}/{vcUuid}")
   @Produces("application/bdb")
   public StreamingOutput getConceptByteArray(@PathParam("id") String id, @PathParam("vcUuid") String vcUuid)
           throws IOException {
      final int cnid;

      if (id.length() == 36) {
         UUID uuid = UUID.fromString(id);

         cnid = ts.getNidForUuids(uuid);
      } else {
         cnid = Integer.parseInt(id);
      }

      final ConceptDataFetcherI fetcher = ts.getConceptDataFetcher(cnid);

      return new StreamingOutput() {
         @Override
         public void write(OutputStream output) throws IOException, WebApplicationException {
            DataOutputStream dos = new DataOutputStream(output);

            dos.writeInt(cnid);

            byte[] robs = fetcher.getReadOnlyBytes();

            dos.writeInt(robs.length);
            dos.write(robs);

            byte[] rwbs = fetcher.getReadWriteBytes();

            dos.writeInt(rwbs.length);
            dos.write(rwbs);
         }
      };
   }

   @GET
   @Path("{id}/{vcUuid}")
   @Produces("text/html")
   public String getConceptHtml(@PathParam("id") String id, @PathParam("vcUuid") String vcUuid)
           throws IOException {
      ConceptChronicleBI c;

      if (id.length() == 36) {
         c = ts.getConcept(UUID.fromString(id));
      } else {
         c = ts.getConcept(Integer.parseInt(id));
      }

      return "Concept html: " + id + " " + c.toLongString();
   }

   @GET
   @Path("{id}/{vcUuid}")
   @Produces("text/plain")
   public String getConceptPlain(@PathParam("id") String id, @PathParam("vcUuid") String vcUuid)
           throws IOException {
      ConceptChronicleBI c;

      if (id.length() == 36) {
         c = ts.getConcept(UUID.fromString(id));
      } else {
         c = ts.getConcept(Integer.parseInt(id));
      }

      return "Concept plain: " + id + " " + c.toLongString();
   }

   @GET
   @Path("{id}/{vcUuid}")
   @Produces("application/xml")
   public FxConcept getConceptXml(@PathParam("id") String id, @PathParam("vcUuid") String vcUuid)
           throws IOException, ContradictionException {
      ConceptChronicleBI c;

      if (id.length() == 36) {
         c = ts.getConcept(UUID.fromString(id));
      } else {
         c = ts.getConcept(Integer.parseInt(id));
      }

      ViewCoordinate        vc   = ts.getViewCoordinate(UUID.fromString(vcUuid));
      TerminologySnapshotDI snap = ts.getSnapshot(vc);

      return new FxConcept(snap, c, VersionPolicy.ALL_VERSIONS, RefexPolicy.REFEX_MEMBERS,
                           RelationshipPolicy.ORIGINATING_RELATIONSHIPS);
   }

   @GET
   @Path("{id}/{vcUuid}/{versionPolicy}/{refexPolicy}/{relationshipPolicy}")
   @Produces("application/xml")
   public FxConcept getConceptXmlPerPolicy(@PathParam("id") String id, @PathParam("vcUuid") String vcUuid,
           @PathParam("versionPolicy") VersionPolicy versionPolicy,
           @PathParam("refexPolicy") RefexPolicy refexPolicy,
           @PathParam("relationshipPolicy") RelationshipPolicy relationshipPolicy)
           throws IOException, ContradictionException {
      ConceptChronicleBI c;

      if (id.length() == 36) {
         c = ts.getConcept(UUID.fromString(id));
      } else {
         c = ts.getConcept(Integer.parseInt(id));
      }

      ViewCoordinate        vc   = ts.getViewCoordinate(UUID.fromString(vcUuid));
      TerminologySnapshotDI snap = ts.getSnapshot(vc);

      return new FxConcept(snap, c, versionPolicy, refexPolicy, relationshipPolicy);
   }

   @GET
   @Path("{id}/{vcUuid}")
   @Produces("application/econ")
   public StreamingOutput getEConceptByteArray(@PathParam("id") String id, @PathParam("vcUuid") String vcUuid)
           throws IOException {
      ConceptChronicleBI c;

      if (id.length() == 36) {
         c = ts.getConcept(UUID.fromString(id));
      } else {
         c = ts.getConcept(Integer.parseInt(id));
      }

      final TkConcept econ = new TkConcept(c);

      return new StreamingOutput() {
         @Override
         public void write(OutputStream output) throws IOException, WebApplicationException {
            DataOutputStream dos = new DataOutputStream(output);

            econ.writeExternal(dos);
         }
      };
   }
}
