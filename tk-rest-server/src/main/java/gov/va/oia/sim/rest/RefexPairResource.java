/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.va.oia.sim.rest;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.StreamingOutput;
import org.ihtsdo.cc.termstore.PersistentStoreI;

/**
 *
 * @author kec
 */
@Path("/nidpairs/refex")
public class RefexPairResource {
    @Context
    PersistentStoreI ts;
        
    @GET
    @Path("{nid}")
    @Produces("application/bdb")
    public StreamingOutput getRefexPairs(@PathParam("nid") final int nid) throws IOException  {
        return new StreamingOutput() {

            @Override
            public void write(OutputStream output) throws IOException, WebApplicationException {
                ObjectOutputStream oos = new ObjectOutputStream(output);
                oos.writeObject(ts.getRefexPairs(nid));
            }
        };
    }
    
}
