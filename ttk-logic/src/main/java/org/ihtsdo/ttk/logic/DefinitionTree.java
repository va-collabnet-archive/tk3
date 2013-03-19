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
package org.ihtsdo.ttk.logic;

import java.util.List;
import org.ihtsdo.ttk.api.concept.ConceptVersionBI;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;

/**
 *
 * @author kec
 */
public class DefinitionTree {
    
    public static RefexVersionBI<?> getNecessarySet(ConceptVersionBI cv) {
         throw new UnsupportedOperationException();
    }

    public static List<RefexVersionBI<?>> getSufficientSets(ConceptVersionBI cv) {
        throw new UnsupportedOperationException();
    }

}