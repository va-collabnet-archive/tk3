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

import org.ihtsdo.otf.query.Clause;
import org.ihtsdo.otf.query.ClauseComputeType;
import org.ihtsdo.ttk.api.NativeIdSetBI;
import org.ihtsdo.otf.query.Query;
import org.ihtsdo.ttk.api.Ts;

/**
 *
 * @author dylangrald
 */
public class RegexMatch extends Clause {

    String regex;

    public RegexMatch(Query enclosingQuery, String regex) {
        super(enclosingQuery);
        this.regex = regex;
    }

    @Override
    public ClauseComputeType computeType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NativeIdSetBI computePossibleComponents(NativeIdSetBI incomingPossibleComponents) {
        return incomingPossibleComponents;
    }

    @Override
    public boolean matches() {
        /*
        ConceptVersionBI conceptVersion2 = ((ConceptChronicleBI) component).getVersion(v1Is);
        for (DescriptionVersionBI dv : conceptVersion2.getDescriptionsActive()) {
            if (dv.getText().matches(s.getQueryText())) {
                return true;
            }
        }
        return false;
        */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
