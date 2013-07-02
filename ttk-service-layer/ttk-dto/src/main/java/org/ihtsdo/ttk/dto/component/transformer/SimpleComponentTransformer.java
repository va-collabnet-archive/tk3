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

import java.util.EnumSet;
import java.util.Map;
import java.util.UUID;
import org.ihtsdo.ttk.dto.TtkConcept;

/**
 *
 * @author kec
 */
public class SimpleComponentTransformer implements ComponentTransformerBI {
    private EnumSet<ComponentFields> fieldsToConvert;
    private Map<UUID, UUID>          uuidMap;

    public SimpleComponentTransformer(EnumSet<ComponentFields> fieldsToConvert, Map<UUID, UUID> uuidMap) {
        this.fieldsToConvert = fieldsToConvert;
        this.uuidMap         = uuidMap;
    }

    @Override
    public UUID transform(UUID input, TkRevision revision, ComponentFields field) {
        if (fieldsToConvert.contains(field)) {
            if (uuidMap.containsKey(input)) {
                return uuidMap.get(input);
            }
        }

        return input;
    }

    @Override
    public String transform(String input, TkRevision revision, ComponentFields field) {
        if (fieldsToConvert.contains(field)) {
            throw new UnsupportedOperationException();
        }

        return input;
    }

    @Override
    public int transform(int input, TkRevision revision, ComponentFields field) {
        if (fieldsToConvert.contains(field)) {
            throw new UnsupportedOperationException();
        }

        return input;
    }

    @Override
    public long transform(long input, TkRevision revision, ComponentFields field) {
        if (fieldsToConvert.contains(field)) {
            throw new UnsupportedOperationException();
        }

        return input;
    }

    @Override
    public float transform(float input, TkRevision revision, ComponentFields field) {
        if (fieldsToConvert.contains(field)) {
            throw new UnsupportedOperationException();
        }

        return input;
    }

    @Override
    public boolean transform(boolean input, TkRevision revision, ComponentFields field) {
        if (fieldsToConvert.contains(field)) {
            throw new UnsupportedOperationException();
        }

        return input;
    }

    @Override
    public byte[] transform(byte[] input, TkRevision component, ComponentFields field) {
        if (fieldsToConvert.contains(field)) {
            throw new UnsupportedOperationException();
        }

        return input;
    }

    @Override
    public byte[][] transform(byte[][] input, TkRevision component, ComponentFields field) {
        if (fieldsToConvert.contains(field)) {
            throw new UnsupportedOperationException();
        }

        return input;
    }

    @Override
    public UUID transform(UUID input, TtkConcept concept, ComponentFields field) {
        if (fieldsToConvert.contains(field)) {
            if (uuidMap.containsKey(input)) {
                return uuidMap.get(input);
            }
        }

        return input;
    }

    @Override
    public boolean transform(boolean input, TtkConcept concept, ComponentFields field) {
        if (fieldsToConvert.contains(field)) {
            throw new UnsupportedOperationException();
        }

        return input;
    }
}
