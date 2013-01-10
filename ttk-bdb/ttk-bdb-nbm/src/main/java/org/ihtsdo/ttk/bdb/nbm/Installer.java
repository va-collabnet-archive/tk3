/*
 * Copyright 2013 International Health Terminology Standards Development Organisation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ihtsdo.ttk.bdb.nbm;

import org.ihtsdo.ttk.api.TerminologyStoreDI;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.bdb.Bdb;
import org.ihtsdo.ttk.cacco.cc.P;
import org.ihtsdo.ttk.cacco.cc.termstore.PersistentStoreI;
import org.openide.modules.ModuleInstall;
import org.openide.util.Lookup;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        PersistentStoreI persistentStore = Lookup.getDefault().lookup(PersistentStoreI.class);
        P.s = persistentStore;
        System.out.println("Set PersistentStoreI: " + persistentStore);
        TerminologyStoreDI store = Lookup.getDefault().lookup(TerminologyStoreDI.class);
        Ts.set(store);
        System.out.println("Set TerminologyStoreDI: " + store);
        Bdb.setup("berkeley-db", false);
    }
}