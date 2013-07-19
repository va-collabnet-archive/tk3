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
import org.ihtsdo.otf.query.clauses.ConceptIsKindOf;
import java.io.IOException;
import java.util.HashMap;
import org.ihtsdo.ttk.api.spec.ConceptSpec;

/**
 *
 * @author kec
 */
public abstract class Query {

    private final HashMap<String, Object> letDeclarations = 
            new HashMap<String, Object>();
    private NativeIdSetBI forSet;


    public Query() {
    }

    protected abstract NativeIdSetBI For() throws IOException;

    protected abstract void Let() throws IOException;

    protected abstract Clause Where();

    public void let(String key, Object object) throws IOException {
        letDeclarations.put(key, object);
    }

    void compute() throws IOException {
        forSet = For();
        Clause rootClause = Where();
        rootClause.computePossibleComponents(forSet);

        throw new UnsupportedOperationException("Not supported yet."); 
    }

    protected ConceptIsKindOf ConceptIsKindOf(String conceptSpecKey) {
        return new ConceptIsKindOf(this, 
                (ConceptSpec) letDeclarations.get(conceptSpecKey));
    }

    protected Clause DescriptionRegexMatch(String regex) {
        throw new UnsupportedOperationException();
    }

    protected And And(Clause... clauses) {
        return new And(this, clauses);
    }

    protected And Intersection(Clause... clauses) {
        return new And(this, clauses);
    }
    
    public Not Not(Clause clause) {
        return new Not(this, clause);
    }
    
    public NativeIdSetBI getForSet() {
        return forSet;
    }
    
    protected Or Or(Clause... clauses) {
        return new Or(this, clauses);
    }
    
    protected Or Union(Clause... clauses){
        return new Or(this, clauses);
    }
}
