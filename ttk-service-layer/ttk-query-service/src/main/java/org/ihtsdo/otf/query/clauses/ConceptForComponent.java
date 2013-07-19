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
package org.ihtsdo.otf.query.clauses;

import java.io.IOException;
import org.ihtsdo.otf.query.ClauseComputeType;
import org.ihtsdo.otf.query.Clause;
import org.ihtsdo.otf.query.HybridNidSet;
import org.ihtsdo.otf.query.NativeIdSetBI;
import org.ihtsdo.otf.query.ParentClause;
import org.ihtsdo.otf.query.Query;
import org.ihtsdo.ttk.api.NidBitSetItrBI;

/**
 *
 * @author kec
 */
public class ConceptForComponent extends ParentClause {

    public ConceptForComponent(Query enclosingQuery, Clause child) {
        super(enclosingQuery, child);
    }

    @Override
    public ClauseComputeType computeType() {
        return ClauseComputeType.INDEXED_NO_ITERATION;
    }

    @Override
    public NativeIdSetBI computePossibleComponents(NativeIdSetBI incomingPossibleConcepts) throws IOException {
        HybridNidSet conceptsForComponents = new HybridNidSet(incomingPossibleConcepts.size());
        
        NidBitSetItrBI itr = incomingPossibleConcepts.getIterator();
        
        
        while (itr.next()) {
            conceptsForComponents.add(itr.nid());
        }
        return conceptsForComponents;
    }

    @Override
    public boolean matches() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
