/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ihtsdo.tk.rest.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.StreamingOutput;
import org.ihtsdo.cc.concept.ConceptDataFetcherI;
import org.ihtsdo.cc.termstore.PersistentStoreI;
import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.fetchpolicy.RefexPolicy;
import org.ihtsdo.fxmodel.fetchpolicy.RelationshipPolicy;
import org.ihtsdo.fxmodel.fetchpolicy.VersionPolicy;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.coordinate.StandardViewCoordinates;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.dto.concept.TkConcept;

/**
 *
 * @author kec
 */
@Path("/concept")
public class ConceptResource {

    @Context
    PersistentStoreI ts;

    @GET
    @Path("{id}")
    @Produces("text/plain")
    public String getConceptPlain(@PathParam("id") String id) throws IOException {
        ConceptChronicleBI c;

        if (id.length() == 36) {
            c = ts.getConcept(UUID.fromString(id));
        } else {
            c = ts.getConcept(Integer.parseInt(id));
        }
        return c.toLongString();
    }

    @GET
    @Path("{id}")
    @Produces("text/html")
    
    public String getConceptHtml(@PathParam("id") String id) throws IOException, ContradictionException {
         UUID uuid;
        
        if (id.length() == 36) {
            uuid = UUID.fromString(id);
        } else {
            uuid = ts.getUuidPrimordialForNid(Integer.parseInt(id));
        }
        ViewCoordinate vc = StandardViewCoordinates.getSnomedLatest();
        FxConcept fxc = ts.getFxConcept(uuid, vc,
                    VersionPolicy.ACTIVE_VERSIONS,
                    RefexPolicy.ANNOTATION_MEMBERS,
                    RelationshipPolicy.ORIGINATING_AND_DESTINATION_RELATIONSHIPS);
        return fxc.toHtml();
    }

    @GET
    @Path("{id}")
    @Produces("application/xml")
    public TkConcept getConceptXml(@PathParam("id") String id) throws IOException {
        ConceptChronicleBI c;
        if (id.length() == 36) {
            c = ts.getConcept(UUID.fromString(id));
        } else {
            c = ts.getConcept(Integer.parseInt(id));
        }
        return new TkConcept(c);
    }

    @GET
    @Path("{id}")
    @Produces("application/bdb")
    public StreamingOutput getConceptByteArray(@PathParam("id") String id) throws IOException {
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
    @Path("{id}")
    @Produces("application/econ")
    public StreamingOutput getEConceptByteArray(@PathParam("id") String id) throws IOException {
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
