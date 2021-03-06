/*
 * Copyright 2010 International Health Terminology Standards Development Organisation.
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
package org.ihtsdo.tk.api.blueprint;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.EnumMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.AnalogBI;
import org.ihtsdo.tk.api.ComponentBI;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.amend.InvalidAmendmentSpec;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.refex.RefexAnalogBI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.api.refex.type_array_of_bytearray.RefexArrayOfBytearrayAnalogBI;
import org.ihtsdo.tk.api.refex.type_array_of_bytearray.RefexArrayOfBytearrayVersionBI;
import org.ihtsdo.tk.api.refex.type_boolean.RefexBooleanAnalogBI;
import org.ihtsdo.tk.api.refex.type_boolean.RefexBooleanVersionBI;
import org.ihtsdo.tk.api.refex.type_nid.RefexNidAnalogBI;
import org.ihtsdo.tk.api.refex.type_nid.RefexNidVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_nid.RefexNidNidAnalogBI;
import org.ihtsdo.tk.api.refex.type_nid_nid.RefexNidNidVersionBI;
import org.ihtsdo.tk.api.refex.type_nid_nid_nid.RefexNidNidNidAnalogBI;
import org.ihtsdo.tk.api.refex.type_nid_nid_nid.RefexNidNidNidVersionBI;
import org.ihtsdo.tk.api.refex.type_int.RefexIntAnalogBI;
import org.ihtsdo.tk.api.refex.type_int.RefexIntVersionBI;
import org.ihtsdo.tk.api.refex.type_long.RefexLongAnalogBI;
import org.ihtsdo.tk.api.refex.type_long.RefexLongVersionBI;
import org.ihtsdo.tk.api.refex.type_string.RefexStringAnalogBI;
import org.ihtsdo.tk.api.refex.type_string.RefexStringVersionBI;
import org.ihtsdo.tk.binding.SnomedMetadataRfx;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.uuid.UuidT5Generator;

/**
 *
 * @author kec
 */
public class RefexCAB extends CreateOrAmendBlueprint {

    public static final UUID refexSpecNamespace =
            UUID.fromString("c44bc030-1166-11e0-ac64-0800200c9a66");
    private TK_REFEX_TYPE memberType;

    public UUID computeMemberReferencedComponentUuid() throws IOException, InvalidCAB {
        try {
            return UuidT5Generator.get(refexSpecNamespace,
                    memberType.name()
                    + getPrimUuidStrForNidProp(RefexProperty.COLLECTION_NID)
                    + getRcUuid().toString());
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public UUID setMemberContentUuid() throws InvalidCAB, IOException {
        UUID memberContentUuid = computeMemberContentUuid();
        properties.put(RefexProperty.MEMBER_UUID, memberContentUuid);
        return memberContentUuid;
    }

    /**
     * Use when the 1-1 relationship between a refex and a referenced component
     * does not apply.
     *
     * @return A
     * <code>UUID</code> based on a Type 5 generator that uses the content
     * fields of the refex.
     * @throws InvalidAmendmentSpec
     * @throws IOException
     */
    public UUID computeMemberContentUuid() throws InvalidCAB, IOException {
        try {
            StringBuilder sb = new StringBuilder();
            for (RefexProperty prop : RefexProperty.values()) {
                switch (prop) {
                    case MEMBER_UUID:
                    case STATUS_NID:
                    case COLLECTION_NID:
                    case RC_UUID:
                        break;
                    default:
                        if (properties.get(prop) != null) {
                            sb.append(properties.get(prop).toString());
                        }
                }
            }
            return UuidT5Generator.get(refexSpecNamespace,
                    memberType.name()
                    + getPrimUuidStrForNidProp(RefexProperty.COLLECTION_NID)
                    + getPrimUuidStrForNidProp(RefexProperty.RC_UUID)
                    + sb.toString());
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void recomputeUuid() throws InvalidCAB, IOException, ContradictionException {
        setComponentUuid(computeMemberReferencedComponentUuid());
        for (RefexCAB annotBp : getAnnotationBlueprints()) {
            annotBp.setReferencedComponentUuid(getComponentUuid());
            annotBp.recomputeUuid();
        }
    }

    private String getPrimUuidStrForNidProp(RefexProperty prop)
            throws IOException, InvalidCAB {
        Object nidObj = properties.get(prop);
        if (nidObj == null) {
            throw new InvalidCAB(
                    "No data for: " + prop);
        }
        int nid = (Integer) nidObj;
        ComponentBI component = Ts.get().getComponent(nid);
        if (component != null) {
            return component.getPrimUuid().toString();
        }
        List<UUID> uuids = Ts.get().getUuidsForNid(nid);
        if (uuids.size() == 1) {
            return uuids.get(0).toString();
        }
        throw new InvalidCAB("Can't find nid for: " + prop
                + " props: " + this.properties);
    }
    protected EnumMap<RefexProperty, Object> properties =
            new EnumMap<>(RefexProperty.class);

    /**
     * This constructor creates a MEMBER_UUID that is computed from a type 5
     * UUID generator that uses a hash of the
     * <code>memberType</code>,
     * <code>rcNid</code>, and
     * <code>collectionNid</code>. This member ID is suitable for all refex
     * collections where there should be no more than one refex per referenced
     * component.
     *
     * @param memberType
     * @param rcNid
     * @param collectionNid
     * @throws IOException
     * @throws InvalidAmendmentSpec
     */
    public RefexCAB(TK_REFEX_TYPE memberType,
            int rcNid, int collectionNid) throws IOException, InvalidCAB, ContradictionException {
        this(memberType, Ts.get().getUuidPrimordialForNid(rcNid), collectionNid, null, null, null);

        this.properties.put(RefexProperty.MEMBER_UUID,
                computeMemberReferencedComponentUuid());
    }

    public RefexCAB(TK_REFEX_TYPE memberType,
            UUID rcUuid, int collectionNid, RefexVersionBI refex,
            ViewCoordinate vc) throws IOException, InvalidCAB, ContradictionException {
        this(memberType, rcUuid, collectionNid, null, refex, vc);

        this.properties.put(RefexProperty.MEMBER_UUID,
                computeMemberReferencedComponentUuid());
    }

    public RefexCAB(TK_REFEX_TYPE memberType,
            UUID rcUuid, int collectionNid,
            UUID memberUuid, RefexVersionBI refex,
            ViewCoordinate vc) throws IOException, InvalidCAB, ContradictionException {
        super(memberUuid, refex, vc);
        this.memberType = memberType;
        this.properties.put(RefexProperty.RC_UUID, rcUuid);
        this.properties.put(RefexProperty.COLLECTION_NID, collectionNid);
        this.properties.put(RefexProperty.STATUS_NID,
                SnomedMetadataRfx.getSTATUS_CURRENT_NID());
        if (getMemberUUID() != null) {
            this.properties.put(RefexProperty.MEMBER_UUID, memberUuid);
        }
        if (this.properties.get(RefexProperty.STATUS_NID) != null) {
            setStatusUuid(Ts.get().getComponent(
                    (Integer) this.properties.get(RefexProperty.STATUS_NID)).getPrimUuid());
        }
    }

    @Override
    public void setCurrent() {
        super.setCurrent();
        try {
            this.properties.put(RefexProperty.STATUS_NID,
                    Ts.get().getNidForUuids(super.getStatusUuid()));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void setRetired() {
        super.setRetired();
        try {
            this.properties.put(RefexProperty.STATUS_NID,
                    Ts.get().getNidForUuids(super.getStatusUuid()));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    protected void setReferencedComponentUuid(UUID rcUuid) {
        this.properties.put(RefexProperty.RC_UUID, rcUuid);
    }

    @Override
    public UUID getStatusUuid() {
        try {
            super.setStatusUuid(Ts.get().getComponent(
                    (Integer) this.properties.get(RefexProperty.STATUS_NID)).getPrimUuid());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return super.getStatusUuid();
    }

    @Override
    public void setStatusUuid(UUID statusUuid) {
        super.setStatusUuid(statusUuid);
        if (this.properties.get(RefexProperty.STATUS_NID) != null) {
            try {
                this.properties.put(RefexProperty.STATUS_NID,
                        Ts.get().getNidForUuids(statusUuid));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public enum RefexProperty {

        MEMBER_UUID,
        COLLECTION_NID,
        RC_UUID,
        STATUS_NID,
        CNID1,
        CNID2,
        CNID3,
        BOOLEAN1,
        INTEGER1,
        STRING1,
        LONG1,
        FLOAT1,
        ARRAY_OF_BYTEARRAY,
    }

    public UUID getMemberUuid() {
        return getComponentUuid();
    }

    public void setMemberUuid(UUID memberUuid) {
        setComponentUuid(memberUuid);
        properties.put(RefexProperty.MEMBER_UUID, memberUuid);
    }

    public boolean containsKey(RefexProperty key) {
        return properties.containsKey(key);
    }

    public Set<Entry<RefexProperty, Object>> entrySet() {
        return properties.entrySet();
    }

    public Set<RefexProperty> keySet() {
        return properties.keySet();
    }

    public Object put(RefexProperty key, Number value) {
        return properties.put(key, value);
    }

    public Object put(RefexProperty key, byte[][] value) {
        return properties.put(key, value);
    }

    public Object put(RefexProperty key, String value) {
        assert key == RefexProperty.STRING1;
        return properties.put(key, value);
    }

    public Object put(RefexProperty key, Boolean value) {
        assert key == RefexProperty.BOOLEAN1;
        return properties.put(key, value);
    }

    public Object put(RefexProperty key, UUID value) {
        assert key == RefexProperty.MEMBER_UUID;
        return properties.put(RefexProperty.MEMBER_UUID,
                value);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " "
                + memberType + " " + properties;
    }

    public RefexCAB with(RefexProperty key, Number value) {
        put(key, value);
        return this;
    }

    public RefexCAB with(RefexProperty key, byte[][] value) {
        put(key, value);
        return this;
    }

    public RefexCAB with(RefexProperty key, String value) {
        assert key == RefexProperty.STRING1;
        properties.put(key, value);
        return this;
    }

    public RefexCAB with(RefexProperty key, Boolean value) {
        assert key == RefexProperty.BOOLEAN1;
        properties.put(key, value);
        return this;
    }

    public boolean hasProperty(RefexProperty key) {
        return properties.containsKey(key);
    }

    public void writeTo(RefexAnalogBI<?> version) throws PropertyVetoException, IOException {
        setProperties(version);
    }

    public void setProperties(RefexAnalogBI<?> version) throws PropertyVetoException, IOException {
        for (Entry<RefexProperty, Object> entry : properties.entrySet()) {
            switch (entry.getKey()) {
                case MEMBER_UUID:
                    try {
                        version.setNid(Ts.get().getNidForUuids((UUID) entry.getValue()));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case RC_UUID:
                    version.setReferencedComponentNid(Ts.get().getNidForUuids((UUID) entry.getValue()));
                    break;
                case BOOLEAN1:
                    RefexBooleanAnalogBI<?> booleanPart = (RefexBooleanAnalogBI<?>) version;
                    booleanPart.setBoolean1((Boolean) entry.getValue());
                    break;
                case CNID1:
                    RefexNidAnalogBI<?> c1v = (RefexNidAnalogBI<?>) version;
                    c1v.setNid1((Integer) entry.getValue());
                    break;
                case CNID3:
                    RefexNidNidNidAnalogBI<?> c3part = (RefexNidNidNidAnalogBI<?>) version;
                    c3part.setNid3((Integer) entry.getValue());
                    break;
                case CNID2:
                    RefexNidNidAnalogBI<?> c2part = (RefexNidNidAnalogBI<?>) version;
                    c2part.setNid2((Integer) entry.getValue());
                    break;
                case INTEGER1:
                    RefexIntAnalogBI<?> intPart = (RefexIntAnalogBI<?>) version;
                    intPart.setInt1((Integer) entry.getValue());
                    break;
                case LONG1:
                    RefexLongAnalogBI<?> longPart = (RefexLongAnalogBI<?>) version;
                    longPart.setLong1((Long) entry.getValue());
                    break;
                case STATUS_NID:
                    ((AnalogBI) version).setStatusNid((Integer) entry.getValue());
                    break;
                case STRING1:
                    RefexStringAnalogBI<?> strPart = (RefexStringAnalogBI<?>) version;
                    strPart.setString1((String) entry.getValue());
                    break;
                case ARRAY_OF_BYTEARRAY:
                    RefexArrayOfBytearrayAnalogBI<?> arrayPart = (RefexArrayOfBytearrayAnalogBI<?>) version;
                    arrayPart.setArrayOfByteArray((byte[][]) entry.getValue());
                    break;

                default:
                    throw new RuntimeException("Can't handle: " + entry.getKey());
            }
        }
    }

    public void setPropertiesExceptSap(RefexAnalogBI<?> version) throws PropertyVetoException, IOException {
        for (Entry<RefexProperty, Object> entry : properties.entrySet()) {
            switch (entry.getKey()) {
                case MEMBER_UUID:
                    try {
                        int nid = Ts.get().getNidForUuids((UUID) entry.getValue());
                        if (version.getNid() != nid) {
                            version.setNid(nid);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case BOOLEAN1:
                    RefexBooleanAnalogBI<?> booleanPart = (RefexBooleanAnalogBI<?>) version;
                    booleanPart.setBoolean1((Boolean) entry.getValue());
                    break;
                case COLLECTION_NID:
                    version.setRefexNid((Integer) entry.getValue());
                    break;
                case RC_UUID:
                    version.setReferencedComponentNid(Ts.get().getNidForUuids((UUID) entry.getValue()));
                    break;
                case CNID1:
                    RefexNidAnalogBI<?> c1part = (RefexNidAnalogBI<?>) version;
                    c1part.setNid1((Integer) entry.getValue());
                    break;
                case CNID3:
                    RefexNidNidNidAnalogBI<?> c3part = (RefexNidNidNidAnalogBI<?>) version;
                    c3part.setNid3((Integer) entry.getValue());
                    break;
                case CNID2:
                    RefexNidNidAnalogBI<?> c2part = (RefexNidNidAnalogBI<?>) version;
                    c2part.setNid2((Integer) entry.getValue());
                    break;
                case INTEGER1:
                    RefexIntAnalogBI<?> intPart = (RefexIntAnalogBI<?>) version;
                    intPart.setInt1((Integer) entry.getValue());
                    break;
                case LONG1:
                    RefexLongAnalogBI<?> longPart = (RefexLongAnalogBI<?>) version;
                    longPart.setLong1((Long) entry.getValue());
                    break;
                case STATUS_NID:
                    // SAP property
                    break;
                case STRING1:
                    RefexStringAnalogBI<?> strPart = (RefexStringAnalogBI<?>) version;
                    strPart.setString1((String) entry.getValue());
                    break;
                case ARRAY_OF_BYTEARRAY:
                    RefexArrayOfBytearrayAnalogBI<?> arrayPart = (RefexArrayOfBytearrayAnalogBI<?>) version;
                    arrayPart.setArrayOfByteArray((byte[][]) entry.getValue());
                    break;
                default:
                    throw new RuntimeException("Can't handle: " + entry.getKey());
            }
        }
    }

    public boolean validate(RefexVersionBI<?> version) {
        if (memberType != null) {
            if (TK_REFEX_TYPE.classToType(version.getClass()) != memberType) {
                return false;
            }
        }
        for (Entry<RefexProperty, Object> entry : properties.entrySet()) {
            switch (entry.getKey()) {
                case RC_UUID:
                    if (!entry.getValue().equals(version.getPrimUuid())) {
                        return false;
                    }
                    break;
                case COLLECTION_NID:
                    if (!entry.getValue().equals(version.getRefexNid())) {
                        return false;
                    }
                    break;
                case MEMBER_UUID:
                    try {
                        if (version.getNid() != Ts.get().getNidForUuids((UUID) entry.getValue())) {
                            return false;
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case BOOLEAN1:
                    if (!RefexBooleanVersionBI.class.isAssignableFrom(version.getClass())) {
                        return false;
                    }
                    RefexBooleanVersionBI<?> booleanPart = (RefexBooleanVersionBI<?>) version;
                    if (!entry.getValue().equals(booleanPart.getBoolean1())) {
                        return false;
                    }
                    break;
                case CNID1:
                    if (!RefexNidVersionBI.class.isAssignableFrom(version.getClass())) {
                        return false;
                    }
                    RefexNidVersionBI<?> c1part = (RefexNidVersionBI<?>) version;
                    if (!entry.getValue().equals(c1part.getNid1())) {
                        return false;
                    }
                    break;
                case CNID3:
                    if (!RefexNidNidNidVersionBI.class.isAssignableFrom(version.getClass())) {
                        return false;
                    }
                    RefexNidNidNidVersionBI<?> c3part = (RefexNidNidNidVersionBI<?>) version;
                    if (!entry.getValue().equals(c3part.getNid3())) {
                        return false;
                    }
                    break;
                case CNID2:
                    if (!RefexNidNidVersionBI.class.isAssignableFrom(version.getClass())) {
                        return false;
                    }
                    RefexNidNidVersionBI<?> c2part = (RefexNidNidVersionBI<?>) version;
                    if (!entry.getValue().equals(c2part.getNid2())) {
                        return false;
                    }
                    break;
                case INTEGER1:
                    if (!RefexIntVersionBI.class.isAssignableFrom(version.getClass())) {
                        return false;
                    }
                    RefexIntVersionBI<?> intPart = (RefexIntVersionBI<?>) version;
                    if (!entry.getValue().equals(intPart.getInt1())) {
                        return false;
                    }
                    break;
                case LONG1:
                    if (!RefexLongVersionBI.class.isAssignableFrom(version.getClass())) {
                        return false;
                    }
                    RefexLongVersionBI<?> longPart = (RefexLongVersionBI<?>) version;
                    if (!entry.getValue().equals(longPart.getLong1())) {
                        return false;
                    }
                    break;
                case STATUS_NID:
                    if (!entry.getValue().equals(version.getStatusNid())) {
                        return false;
                    }
                    break;
                case STRING1:
                    if (!RefexStringVersionBI.class.isAssignableFrom(version.getClass())) {
                        return false;
                    }
                    RefexStringVersionBI<?> strPart = (RefexStringVersionBI<?>) version;
                    if (!entry.getValue().equals(strPart.getString1())) {
                        return false;
                    }
                    break;
                case ARRAY_OF_BYTEARRAY:
                    if (!RefexArrayOfBytearrayVersionBI.class.isAssignableFrom(version.getClass())) {
                        return false;
                    }
                    RefexArrayOfBytearrayVersionBI<?> arrayPart = (RefexArrayOfBytearrayVersionBI<?>) version;
                    if (!entry.getValue().equals(arrayPart.getArrayOfByteArray())) {
                        return false;
                    }
                    break;
                default:
                    throw new RuntimeException("Can't handle: " + entry.getKey());
            }
        }
        return true;
    }

    public int getInt(RefexProperty key) {
        return (Integer) properties.get(key);
    }

    public int getRefexColNid() {
        return getInt(RefexProperty.COLLECTION_NID);
    }

    public UUID getRcUuid() {
        return (UUID) properties.get(RefexProperty.RC_UUID);
    }

    public String getString(RefexProperty key) {
        assert key == RefexProperty.STRING1;
        return (String) properties.get(key);
    }

    public boolean getBoolean(RefexProperty key) {
        assert key == RefexProperty.BOOLEAN1;
        return (Boolean) properties.get(key);
    }

    public UUID getUUID(RefexProperty key) {
        assert key == RefexProperty.MEMBER_UUID;
        return (UUID) properties.get(key);
    }

    public UUID getMemberUUID() {
        if (this.getComponentUuid() != null) {
            return this.getComponentUuid();
        }
        return (UUID) properties.get(RefexProperty.MEMBER_UUID);
    }

   public byte[][] getArrayOfByteArray() {
        return (byte[][]) properties.get(RefexProperty.ARRAY_OF_BYTEARRAY);
    }

    public TK_REFEX_TYPE getMemberType() {
        return memberType;
    }

    public void setMemberType(TK_REFEX_TYPE memberType) {
        this.memberType = memberType;
    }

    public void setContentUuid() throws InvalidCAB, IOException {
        this.properties.put(RefexProperty.MEMBER_UUID,
                computeMemberContentUuid());
    }
}
