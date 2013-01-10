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
@Path("/nid")
public class NidResource {
    
    @Context
    PersistentStoreI ts;
    
    @GET
    @Path("{uuids}")
    @Produces("text/plain")
    public String getNid(@PathParam("uuids") String uuidListStr) throws IOException {
        String[] uuidStrings = uuidListStr.split("&");
        UUID[] uuids = new UUID[uuidStrings.length];
        for (int i = 0; i < uuidStrings.length; i++) {
            uuids[i] = UUID.fromString(uuidStrings[i]);
        }
        int nid = ts.getNidForUuids(uuids);
        return Integer.toString(nid);
    }

    @GET
    @Path("/concept/{id}")
    @Produces("text/plain")
    public String getConceptNid(@PathParam("id") String idStr) throws IOException {
        if (idStr.length() == 36) {
            UUID uuid = UUID.fromString(idStr);
            int cNid = ts.getConceptNidForNid(ts.getNidForUuids(uuid));
            return Integer.toString(cNid);
        }
        int cNid = ts.getConceptNidForNid(Integer.parseInt(idStr));
        return Integer.toString(cNid);
    }
}