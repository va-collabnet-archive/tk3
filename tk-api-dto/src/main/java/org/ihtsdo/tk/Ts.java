package org.ihtsdo.tk;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.TerminologyStoreDI;

//~--- JDK imports ------------------------------------------------------------

import java.lang.reflect.Method;

/**
 * Ts is short for Terminology store...
 *
 * @author kec
 *
 */
public class Ts {
   private static TerminologyStoreDI store;

   //~--- methods -------------------------------------------------------------

   public static void setup() throws Exception {
      setup("org.ihtsdo.db.bdb.Bdb", "berkeley-db");
   }

   public static void setup(String storeClassName, String dbRoot) throws Exception {
      Class<?> class1 = Class.forName(storeClassName);
      Method   method = class1.getMethod("setup", String.class);

      method.invoke(null, dbRoot);
   }

   //~--- get methods ---------------------------------------------------------

   public static TerminologyStoreDI get() {
      return store;
   }

   public static TerminologySnapshotDI getGlobalSnapshot() {
      return store.getGlobalSnapshot();
   }

   //~--- set methods ---------------------------------------------------------

   public static void set(TerminologyStoreDI store) {
      Ts.store = store;
   }
}
