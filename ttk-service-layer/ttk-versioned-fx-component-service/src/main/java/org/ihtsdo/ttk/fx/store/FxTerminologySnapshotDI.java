/*
 * Copyright 2012 International Health Terminology Standards Development Organisation.
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
package org.ihtsdo.ttk.fx.store;

import java.io.IOException;
import java.util.UUID;
import org.ihtsdo.ttk.fx.FxComponentReference;
import org.ihtsdo.ttk.fx.concept.FxConceptChronicle;
import org.ihtsdo.ttk.fx.fetchpolicy.RefexPolicy;
import org.ihtsdo.ttk.fx.fetchpolicy.RelationshipPolicy;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologySnapshotDI;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;

/**
 *
 * @author kec
 */
public interface FxTerminologySnapshotDI extends TerminologySnapshotDI {
   
   FxConceptChronicle getFxConcept(UUID conceptUUID, ViewCoordinate vc) throws IOException, ContradictionException;

   FxConceptChronicle getFxConcept(FxComponentReference ref, RefexPolicy refexPolicy, RelationshipPolicy relationshipPolicy)
           throws IOException, ContradictionException;

   FxConceptChronicle getFxConcept(UUID conceptUUID, RefexPolicy refexPolicy, RelationshipPolicy relationshipPolicy)
           throws IOException, ContradictionException;

    
}
