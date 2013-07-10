
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ihtsdo.ttk.rest.server;

import com.sun.jersey.spi.inject.SingletonTypeInjectableProvider;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.coordinate.StandardViewCoordinates;
import org.ihtsdo.ttk.concept.cc.P;
import org.ihtsdo.ttk.concept.cc.termstore.PersistentStoreI;

/**
 *
 * @author kec
 */
@Provider
public class BdbSingleton extends SingletonTypeInjectableProvider<Context, PersistentStoreI> {

    static {
        try {
            String directory = "berkeley-db";


            if (System.getProperty("BdbSingleton.BDB_LOCATION") != null) {
                directory = System.getProperty("BdbSingleton.BDB_LOCATION");
            }
            if (new File(directory).exists()) {
                Ts.setup(Ts.EMBEDDED_BERKELEY_DB_IMPL_CLASS, directory);
            } else {
                Ts.setup(Ts.EMBEDDED_BERKELEY_DB_IMPL_CLASS, directory);

                File[] econFiles = new File[]{new File("/Users/kec/NetBeansProjects/econ/eConcept.econ"),
                    new File("/Users/kec/NetBeansProjects/econ/DescriptionLogicMetadata.econ")};

                Ts.get().loadEconFiles(econFiles);
                System.out.println("Finished load of eConcept.jbin");
            }
        System.out.println("3. Initializing BdbSingleton.");
            Ts.get().setGlobalSnapshot(Ts.get().getSnapshot(StandardViewCoordinates.getSnomedInferredLatest()));
            Ts.get().putViewCoordinate(StandardViewCoordinates.getSnomedInferredThenStatedLatest());
            Ts.get().putViewCoordinate(StandardViewCoordinates.getSnomedStatedLatest());
        } catch (Throwable ex) {
            Logger.getLogger(BdbSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //~--- constructors --------------------------------------------------------
    public BdbSingleton() {
        super(PersistentStoreI.class, P.s);
    }

    //~--- methods -------------------------------------------------------------
    @PreDestroy
    public void close() {
        try {
            Ts.close(Ts.EMBEDDED_BERKELEY_DB_IMPL_CLASS);
        } catch (Exception ex) {
            Logger.getLogger(BdbSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
