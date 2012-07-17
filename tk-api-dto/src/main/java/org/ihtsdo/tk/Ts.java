package org.ihtsdo.tk;

import java.lang.reflect.Method;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.TerminologyStoreDI;

/**
 * Ts is short for Terminology store...
 *
 * @author kec
 *
 */
public class Ts {
   public static final String        BERKELEY_DB_FOLDER              = "berkeley-db";
   public static final String        EMBEDDED_BERKELEY_DB_IMPL_CLASS = "org.ihtsdo.bdb.Bdb";
   private static Class<?>           implClass;
   private static TerminologyStoreDI store;

   //~--- methods -------------------------------------------------------------

   public static void close() throws Exception {
      Method method = implClass.getMethod("close");

      method.invoke(null);
   }

   public static void close(String storeClassName) throws Exception {
      Class<?> class1 = Class.forName(storeClassName);
      Method   method = class1.getMethod("close");

      method.invoke(null);
   }

   public static void setup() throws Exception {
      setup(EMBEDDED_BERKELEY_DB_IMPL_CLASS, BERKELEY_DB_FOLDER);
   }

   public static void setup(String storeClassName, String dbRoot) throws Exception {
      implClass = Class.forName(storeClassName);

      Method method = implClass.getMethod("setup", String.class);

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
