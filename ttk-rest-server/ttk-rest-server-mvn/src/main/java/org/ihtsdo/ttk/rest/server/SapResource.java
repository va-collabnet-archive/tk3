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
import org.ihtsdo.ttk.cacco.cc.termstore.PersistentStoreI;

/**
 *
 * @author kec
 */
@Path("/sap")
public class SapResource {

    @Context
    PersistentStoreI ts;

    @GET
    @Path("/read-only-max")
    @Produces("text/plain")
    public String getRoMaxSap() throws IOException {
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
    public String getStatusNid(@PathParam("id") String id) throws IOException {
        return Integer.toString(ts.getStatusNidForStamp(Integer.parseInt(id)));
    }
    @GET
    @Path("/module/{id}")
    @Produces("text/plain")
    public String getModuleNid(@PathParam("id") String id) throws IOException {
        return Integer.toString(ts.getModuleNidForStamp(Integer.parseInt(id)));
    }
}
