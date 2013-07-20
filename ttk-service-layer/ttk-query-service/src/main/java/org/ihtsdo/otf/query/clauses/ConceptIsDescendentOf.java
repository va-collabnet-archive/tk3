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
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.NidBitSetItrBI;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.concept.ConceptVersionBI;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.spec.ConceptSpec;
import org.ihtsdo.ttk.api.spec.ValidationException;

/**
 *
 * @author dylangrald
 */
public class ConceptIsDescendentOf extends LeafClause {

    ConceptSpec kindOfSpec;

    public ConceptIsDescendentOf(Query enclosingQuery, ConceptSpec kindOfSpec) {
        super(enclosingQuery);
        this.kindOfSpec = kindOfSpec;
    }

    @Override
    public NativeIdSetBI computePossibleComponents(NativeIdSetBI incomingPossibleComponents) 
            throws ValidationException, IOException, ContradictionException {
        ViewCoordinate viewCoordinate = getEnclosingQuery().getViewCoordinate();
        int parentNid = kindOfSpec.getNid(viewCoordinate);
        NidBitSetItrBI itr = incomingPossibleComponents.getIterator();
        while (itr.next()) {
            if (itr.nid() != parentNid && Ts.get().isKindOf(itr.nid(), parentNid, viewCoordinate)) {
                getResultsCache().setMember(itr.nid());
            }
        }
        return getResultsCache();
    }

    @Override
    public EnumSet<ClauseComputeType> getComputePhases() {
        return PRE_AND_POST_ITERATION;
    }

    @Override
    public void getQueryMatches(ConceptVersionBI conceptVersion) {
        // Nothing to do...
    }
}
