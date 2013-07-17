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

import java.io.IOException;
import java.util.HashMap;
import org.ihtsdo.ttk.api.spec.ConceptSpec;

/**
 *
 * @author kec
 */
public abstract class Query {
    
    private final HashMap<String, Object> letDeclarations = new HashMap<String, Object>();

    public Query() {
    }
    
    protected abstract void declareLets()throws IOException;

    protected abstract WhereClause declareWhere();
    
    
    public void let(String key, Object object) throws IOException {
        letDeclarations.put(key, object);
    }
    
    public void where(WhereClause clause) {
        declareWhere();
    }

    void compute() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected ConceptIsKindOf ConceptIsKindOf(String conceptSpecKey) {
        return new ConceptIsKindOf((ConceptSpec) letDeclarations.get(conceptSpecKey));
       
    }
    
    protected WhereClause DescriptionRegexMatch(String regex) {
        throw new UnsupportedOperationException();
    }
    
    protected And And(WhereClause... clauses) {
        return new And(clauses);
    }
    
    protected And Intersection(WhereClause... clauses) {
        return new And(clauses);
    }
}
