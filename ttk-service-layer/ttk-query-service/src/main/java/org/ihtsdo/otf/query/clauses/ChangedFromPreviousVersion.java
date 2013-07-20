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
import java.util.EnumSet;
import org.ihtsdo.otf.query.ClauseComputeType;
import org.ihtsdo.otf.query.LeafClause;
import org.ihtsdo.ttk.api.NativeIdSetBI;
import org.ihtsdo.otf.query.Query;
import org.ihtsdo.ttk.api.concept.ConceptVersionBI;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;

/**
 *
 * @author dylangrald
 */
public class ChangedFromPreviousVersion extends LeafClause {
    
    ViewCoordinate previousViewCoordinate;

    public ChangedFromPreviousVersion(Query enclosingQuery, ViewCoordinate previousViewCoordinate) {
        super(enclosingQuery);
        this.previousViewCoordinate = previousViewCoordinate;
    }

    @Override
    public EnumSet<ClauseComputeType> getComputePhases() {
        return ITERATION;
    }

    @Override
    public NativeIdSetBI computePossibleComponents(NativeIdSetBI incomingPossibleComponents) throws IOException {
        return incomingPossibleComponents;
    }

    @Override
    public void getQueryMatches(ConceptVersionBI conceptVersion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
