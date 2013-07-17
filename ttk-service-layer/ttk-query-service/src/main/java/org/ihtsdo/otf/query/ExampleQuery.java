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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ihtsdo.ttk.api.coordinate.StandardViewCoordinates;
import org.ihtsdo.ttk.api.metadata.binding.Snomed;

/**
 *
 * @author kec
 */
public class ExampleQuery {
    
    
    public void main(String[] args) {
        try {
            Query q = new Query() {

                @Override
                protected void declareLets() throws IOException {
                    let("allergic-asthma", Snomed.ALLERGIC_ASTHMA);
                    let("snomed-latest", StandardViewCoordinates.getSnomedInferredLatest());
                }

                @Override
                protected WhereClause declareWhere() {
                    return And(ConceptIsKindOf("allergic-asthma"),
                               ConceptIsKindOf("another-let"));
                }
            };
            
            q.compute();
        } catch (IOException ex) {
            Logger.getLogger(ExampleQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //q.let("respiratory-disorder", Snomed.RESPIRATORY_DISORDER);
}
