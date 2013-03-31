/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ihtsdo.ttk.rest.server;

import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import org.ihtsdo.ttk.concept.cc.termstore.PersistentStoreI;

/**
 *
 * @author kec
 */
@Path("/termstore")
public class TermStore {

    @Context
    PersistentStoreI ts;

    @GET
    @Path("/wait-for-writes")
    @Produces("text/plain")
    public String getConceptNid(@PathParam("id") String idStr) throws IOException {
        ts.waitTillWritesFinished();
        return "OK";
    }
}
