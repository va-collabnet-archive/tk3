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
package org.ihtsdo.otf.query;

import org.ihtsdo.ttk.api.NativeIdSetBI;
import java.io.IOException;

/**
 *
 * @author kec
 */
public class And extends ParentClause {

    public And(Query enclosingQuery, Clause... clauses) {
        super(enclosingQuery, clauses);
    }

    @Override
    public NativeIdSetBI computePossibleComponents(NativeIdSetBI incomingPossibleComponents) throws IOException {
        NativeIdSetBI results = new HybridNidSet();
        for(Clause clause : getChildren()){
            results.and(clause.computePossibleComponents(incomingPossibleComponents));
        }
        return results;
    }

    @Override
    public ClauseComputeType computeType() {
        return ClauseComputeType.INDEXED_NO_ITERATION;
    }

    @Override
    public boolean matches() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
