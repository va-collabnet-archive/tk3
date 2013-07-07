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
import org.ihtsdo.ttk.api.Status;
import org.ihtsdo.ttk.concept.cc.termstore.PersistentStoreI;

/**
 *
 * @author kec
 */
@Path("/stamp")
public class StampResource {

    @Context
    PersistentStoreI ts;

    @GET
    @Path("/read-only-max")
    @Produces("text/plain")
    public String getRoMaxStamp() throws IOException {
        return Integer.toString(ts.getMaxReadOnlyStamp());
    }
    @GET
    @Path("/time/{id}")
    @Produces("text/plain")
    public String getTime(@PathParam("id") String id) throws IOException {
        return Long.toString(ts.getTimeForStamp(Integer.parseInt(id)));
    }
    @GET
    @Path("/path/{id}")
    @Produces("text/plain")
    public String getPathNid(@PathParam("id") String id) throws IOException {
        return Integer.toString(ts.getPathNidForStamp(Integer.parseInt(id)));
    }
    @GET
    @Path("/author/{id}")
    @Produces("text/plain")
    public String getAuthorNid(@PathParam("id") String id) throws IOException {
        return Integer.toString(ts.getAuthorNidForStamp(Integer.parseInt(id)));
    }
    @GET
    @Path("/status/{id}")
    @Produces("text/plain")
    public String getStatus(@PathParam("id") String id) throws IOException {
        return ts.getStatusForStamp(Integer.parseInt(id)).name();
    }
    @GET
    @Path("/module/{id}")
    @Produces("text/plain")
    public String getModuleNid(@PathParam("id") String id) throws IOException {
        return Integer.toString(ts.getModuleNidForStamp(Integer.parseInt(id)));
    }
}
