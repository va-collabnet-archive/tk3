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

import org.ihtsdo.otf.tcc.api.NativeIdSetBI;
import java.io.IOException;
import org.ihtsdo.otf.tcc.api.ConcurrentBitSet;
import org.ihtsdo.otf.tcc.api.ContradictionException;
import org.ihtsdo.otf.tcc.api.spec.ValidationException;

/**
 *
 * @author dylangrald
 */
public class Or extends ParentClause{
    
    public Or(Query enclosingQuery, Clause... clauses){
        super(enclosingQuery, clauses);
    }

    @Override
    public NativeIdSetBI computePossibleComponents(NativeIdSetBI searchSpace) throws IOException, ValidationException, ContradictionException {
        NativeIdSetBI results = new ConcurrentBitSet();
        for(Clause clause : getChildren()){
            results.union(clause.computePossibleComponents(searchSpace));
        }
        return results;
    }
}