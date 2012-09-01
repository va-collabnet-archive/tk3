/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.va.oia.sim.rest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.StreamingOutput;
import org.ihtsdo.cc.concept.ConceptDataFetcherI;
import org.ihtsdo.cc.termstore.PersistentStoreI;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
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
        return "Concept plain: " + id + " " + c.toLongString();
    }

    @GET
    @Path("{id}")
    @Produces("text/html")
    public String getConceptHtml(@PathParam("id") String id) throws IOException {
        ConceptChronicleBI c;
    
        if (id.length() == 36) {
            c = ts.getConcept(UUID.fromString(id));
        } else {
            c = ts.getConcept(Integer.parseInt(id));
        }
        return "Concept html: " + id + " " + c.toLongString();
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
