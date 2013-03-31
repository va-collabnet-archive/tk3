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
package org.ihtsdo.ttk.api.blueprint;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.UUID;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.media.MediaVersionBI;
import org.ihtsdo.ttk.api.uuid.UuidT5Generator;

/**
 *
 * @author kec
 */
public class MediaCAB extends CreateOrAmendBlueprint {

    public static final UUID mediaSpecNamespace =
            UUID.fromString("743f0510-5285-11e0-b8af-0800200c9a66");
    private UUID conceptUuid;
    private UUID typeUuid;
    public String format;
    public String textDescription;
    public byte[] dataBytes;

    public MediaCAB(
            int conceptNid, int typeNid, String format, String textDescription,
            byte[] dataBytes, UUID moduleUuid)
            throws IOException, InvalidBlueprintException, ContradictionException {
        this(Ts.get().getComponent(conceptNid).getPrimUuid(),
                Ts.get().getComponent(typeNid).getPrimUuid(),
                format, textDescription, dataBytes, moduleUuid);
    }

    public MediaCAB(
            UUID conceptUuid, UUID typeUuid, String format, String textDescription,
            byte[] dataBytes, UUID moduleUuid)
            throws IOException, InvalidBlueprintException, ContradictionException {
        this(conceptUuid, typeUuid, format, textDescription, dataBytes,
                null, null, null, moduleUuid);
    }

    public MediaCAB(
            int conceptNid, int typeNid, String format, String textDescription,
            byte[] dataBytes, MediaVersionBI media, ViewCoordinate vc, UUID moduleUuid)
            throws IOException, InvalidBlueprintException, ContradictionException {
        this(Ts.get().getComponent(conceptNid).getPrimUuid(),
                Ts.get().getComponent(typeNid).getPrimUuid(),
                format, textDescription, dataBytes, media, vc, moduleUuid);
    }

    public MediaCAB(
            UUID conceptUuid, UUID typeUuid, String format, String textDescription,
            byte[] dataBytes, MediaVersionBI media, ViewCoordinate vc, UUID moduleUuid)
            throws IOException, InvalidBlueprintException, ContradictionException {
        this(conceptUuid, typeUuid, format, textDescription, dataBytes,
                null, media, vc, moduleUuid);
    }

    public MediaCAB(
            UUID conceptUuid, UUID typeUuid, String format, String textDescription,
            byte[] dataBytes, UUID componentUuid, MediaVersionBI media,
            ViewCoordinate vc, UUID moduleUuid) throws IOException, InvalidBlueprintException, ContradictionException {
        super(componentUuid, media, vc, moduleUuid);

        this.conceptUuid = conceptUuid;
        this.typeUuid = typeUuid;
        this.format = format;
        this.textDescription = textDescription;
        this.dataBytes = dataBytes;
        if (getComponentUuid() == null) {
            try {
                recomputeUuid();
            } catch (    IOException | InvalidBlueprintException | NoSuchAlgorithmException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void recomputeUuid() throws NoSuchAlgorithmException, IOException, InvalidBlueprintException, ContradictionException {
        setComponentUuid(
                UuidT5Generator.get(mediaSpecNamespace,
                getPrimoridalUuidStr(conceptUuid)
                + dataBytes));
        for(RefexCAB annotBp: getAnnotationBlueprints()){
            annotBp.setReferencedComponentUuid(getComponentUuid());
            annotBp.recomputeUuid();
        }
    }

    public UUID getTypeUuid() {
        return typeUuid;
    }

    public int getTypeNid() throws IOException {
        return Ts.get().getNidForUuids(typeUuid);
    }

    public int getConceptNid() throws IOException {
        return Ts.get().getNidForUuids(conceptUuid);
    }

    public UUID getConceptUuid() {
        return conceptUuid;
    }

    public byte[] getDataBytes() {
        return dataBytes;
    }

    public String getFormat() {
        return format;
    }

    public String getTextDescription() {
        return textDescription;
    }
    
    protected void setConceptUuid(UUID conceptNewUuid){
        this.conceptUuid = conceptNewUuid;
    }

    public boolean validate(MediaVersionBI version) throws IOException {
        if (version.getStatusNid() != getStatusNid()) {
            return false;
        }
        if (version.getNid() != getComponentNid()) {
            return false;
        }
        if (version.getConceptNid() != getConceptNid()) {
            return false;
        }
        if (version.getTypeNid() != getTypeNid()) {
            return false;
        }
        if (!version.getFormat().equals(getFormat())) {
            return false;
        }
        if (!version.getTextDescription().equals(getTextDescription())) {
            return false;
        }
        if (!Arrays.equals(version.getMedia(), getDataBytes())) {
            return false;
        }
        return true;
    }
}
