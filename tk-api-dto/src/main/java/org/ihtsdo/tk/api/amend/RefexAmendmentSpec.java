/*
 * Copyright 2011 International Health Terminology Standards Development Organisation.
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

package org.ihtsdo.tk.api.amend;

import java.io.IOException;
import java.util.UUID;
import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.blueprint.InvalidCAB;
import org.ihtsdo.tk.api.blueprint.RefexCAB;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;

/**
 *
 * @author kec
 * @deprecated 
 */
@Deprecated
public class RefexAmendmentSpec extends RefexCAB {

    public RefexAmendmentSpec(TK_REFEX_TYPE memberType, UUID rcUuid, int collectionNid, UUID memberUuid) 
            throws IOException, InvalidCAB, ContradictionException {
        super(memberType, rcUuid, collectionNid, memberUuid, null, null);
    }

    public RefexAmendmentSpec(TK_REFEX_TYPE memberType, int rcNid, int collectionNid) 
            throws IOException, InvalidCAB, ContradictionException {
        super(memberType, rcNid, collectionNid);
    }

}
