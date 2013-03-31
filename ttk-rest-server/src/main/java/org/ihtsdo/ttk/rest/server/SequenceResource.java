/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ihtsdo.ttk.rest.server;

import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import org.ihtsdo.ttk.concept.cc.termstore.PersistentStoreI;

/**
 *
 * @author kec
 */
@Path("/sequence")
public class SequenceResource {
    @Context
    PersistentStoreI ts;

    @GET
    @Path("")
    @Produces("text/plain")
    public String getSequence() throws IOException {
        return Long.toString(ts.getSequence());
    }
    @GET
    @Path("/last-cancel")
    @Produces("text/plain")
    public String getLastCancel() throws IOException {
        return Long.toString(ts.getLastCancel());
    }
    @GET
    @Path("/last-commit")
    @Produces("text/plain")
    public String getLastCommit() throws IOException {
        return Long.toString(ts.getLastCommit());
    }
    @GET
    @Path("/next")
    @Produces("text/plain")
    public String getNextSequence() throws IOException {
        return Long.toString(ts.incrementAndGetSequence());
    }
}
