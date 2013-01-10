/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ihtsdo.ttk.rest.server;

import java.io.IOException;
import java.util.UUID;
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
@Path("/uuid")
public class UuidResource {
    
    @Context
    PersistentStoreI ts;

        
    @GET
    @Path("{uuid}")
    @Produces("text/plain")
    public String getNid(@PathParam("uuid") String uuidStr) throws IOException {
        return Boolean.toString(ts.hasUuid(UUID.fromString(uuidStr)));
    }
    

    @GET
    @Path("primordial/{nid}")
    @Produces("text/plain")
    public String getNid(@PathParam("nid") int nid) throws IOException {
        return ts.getUuidPrimordialForNid(nid).toString();
    }
    
}
