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
import org.ihtsdo.ttk.bdb.BdbTerminologyStore;
import org.ihtsdo.ttk.cacco.cc.termstore.PersistentStoreI;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

/**
 *
 * @author kec
 */
@ServiceProviders(value={
@ServiceProvider(service = TerminologyStoreDI.class),
@ServiceProvider(service = PersistentStoreI.class)
})
public class BdbTerminologyStoreNbm extends BdbTerminologyStore {

    public BdbTerminologyStoreNbm() {
        System.out.println("Constructing BdbTerminologyStoreNbm");
    }
    
}
