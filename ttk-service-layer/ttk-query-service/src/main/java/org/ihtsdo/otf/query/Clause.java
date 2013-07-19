/*
 * Copyright 2013 International Health Terminology Standards Development 
 * Organisation.
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
public abstract class Clause {
    
    Query enclosingQuery;
    Clause parent = null;

    public Query getEnclosingQuery() {
        return enclosingQuery;
    }

    public Clause getParent() {
        return parent;
    }

    public void setParent(Clause parent) {
        this.parent = parent;
    }

    public Clause(Query enclosingQuery) {
        this.enclosingQuery = enclosingQuery;
    }
    
    public Clause[] getChildren() {
        return new Clause[] {};
    }
    
    /**
     * 
     * @return the ClauseComputeType for this clause. 
     */
    
    public abstract ClauseComputeType computeType();
    
    /**
     * Compute components that meet the where clause criterion without using 
     * iteration. If the set of possibilities cannot be computed without iteration, 
     * the set of incomingPossibleComponents will be returned. 
     * @param incomingPossibleComponents
     * @return 
     */
    public abstract NativeIdSetBI computePossibleComponents(
            NativeIdSetBI incomingPossibleComponents) throws IOException;
    
    public abstract boolean matches();
    
}
