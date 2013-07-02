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



package org.ihtsdo.ttk.dto.component.transformer;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.dto.component.TkRevision;

//~--- JDK imports ------------------------------------------------------------

import java.util.UUID;
import org.ihtsdo.ttk.dto.TtkConcept;

/**
 *
 * @author kec
 */
public interface ComponentTransformerBI {
    UUID transform(UUID input, TkRevision component, ComponentFields field);
    
    UUID transform(UUID input, TtkConcept concept, ComponentFields field);

    String transform(String input, TkRevision component, ComponentFields field);

    int transform(int input, TkRevision component, ComponentFields field);

    long transform(long input, TkRevision component, ComponentFields field);

    float transform(float input, TkRevision component, ComponentFields field);

    boolean transform(boolean input, TkRevision component, ComponentFields field);
    
    boolean transform(boolean input, TtkConcept concept, ComponentFields field);
    
    byte[][] transform(byte[][] input, TkRevision component, ComponentFields field);
    
    byte[] transform(byte[] input, TkRevision component, ComponentFields field);
}
