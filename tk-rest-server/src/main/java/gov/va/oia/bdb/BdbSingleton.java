
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package gov.va.oia.bdb;

import com.sun.jersey.spi.inject.SingletonTypeInjectableProvider;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import org.ihtsdo.cc.P;
import org.ihtsdo.cc.termstore.PersistentStoreI;
import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.coordinate.StandardViewCoordinates;

/**
 *
 * @author kec
 */
@Provider
public class BdbSingleton extends SingletonTypeInjectableProvider<Context, PersistentStoreI> {
   static {
      try {
         String directory = "berkeley-db";

         if (new File(directory).exists()) {
            Ts.setup(Ts.EMBEDDED_BERKELEY_DB_IMPL_CLASS, directory);
         } else {
            Ts.setup(Ts.EMBEDDED_BERKELEY_DB_IMPL_CLASS, directory);
            System.out.println("Start load of eConcept.jbin");

            File[] econFiles = new File[] { new File("/Users/kec/NetBeansProjects/eConcept.jbin") };

            Ts.get().loadEconFiles(econFiles);
            System.out.println("Finished load of eConcept.jbin");
         }
         Ts.get().setGlobalSnapshot(Ts.get().getSnapshot(StandardViewCoordinates.getSnomedLatest()));
      } catch (Exception ex) {
         Logger.getLogger(BdbSingleton.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   //~--- constructors --------------------------------------------------------

   public BdbSingleton() {
      super(PersistentStoreI.class, P.s);
   }

   //~--- methods -------------------------------------------------------------

   @PreDestroy
   public void close() throws Exception {
      Ts.close(Ts.EMBEDDED_BERKELEY_DB_IMPL_CLASS);
   }
}
