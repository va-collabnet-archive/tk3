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



package org.ihtsdo.ttk.api.blueprint;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.AnalogBI;
import org.ihtsdo.ttk.api.ComponentBI;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TK_REFEX_TYPE;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.metadata.binding.SnomedMetadataRfx;
import org.ihtsdo.ttk.api.refex.RefexAnalogBI;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.refex.type_array_of_bytearray
   .RefexArrayOfBytearrayAnalogBI;
import org.ihtsdo.ttk.api.refex.type_array_of_bytearray
   .RefexArrayOfBytearrayVersionBI;
import org.ihtsdo.ttk.api.refex.type_boolean.RefexBooleanAnalogBI;
import org.ihtsdo.ttk.api.refex.type_boolean.RefexBooleanVersionBI;
import org.ihtsdo.ttk.api.refex.type_int.RefexIntAnalogBI;
import org.ihtsdo.ttk.api.refex.type_int.RefexIntVersionBI;
import org.ihtsdo.ttk.api.refex.type_long.RefexLongAnalogBI;
import org.ihtsdo.ttk.api.refex.type_long.RefexLongVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid.RefexNidAnalogBI;
import org.ihtsdo.ttk.api.refex.type_nid.RefexNidVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_nid.RefexNidNidAnalogBI;
import org.ihtsdo.ttk.api.refex.type_nid_nid.RefexNidNidVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_nid_nid.RefexNidNidNidAnalogBI;
import org.ihtsdo.ttk.api.refex.type_nid_nid_nid.RefexNidNidNidVersionBI;
import org.ihtsdo.ttk.api.refex.type_string.RefexStringAnalogBI;
import org.ihtsdo.ttk.api.refex.type_string.RefexStringVersionBI;
import org.ihtsdo.ttk.api.uuid.UuidT5Generator;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyVetoException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.security.NoSuchAlgorithmException;

import java.util.EnumMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

/**
 *
 * @author kec
 */
public class RefexCAB extends CreateOrAmendBlueprint {
   public static final UUID refexSpecNamespace =
      UUID.fromString("c44bc030-1166-11e0-ac64-0800200c9a66");
   protected EnumMap<RefexProperty, Object> properties =
      new EnumMap<>(RefexProperty.class);
   private TK_REFEX_TYPE memberType;

   public RefexCAB(TK_REFEX_TYPE memberType, UUID rcUuid, UUID collectionUUID,
                   RefexVersionBI refex, ViewCoordinate vc, UUID moduleUuid)
           throws IOException, InvalidBlueprintException, ContradictionException {
      this(memberType, rcUuid, collectionUUID, null, refex, vc, moduleUuid);
      this.properties.put(RefexProperty.MEMBER_ID,
                          computeMemberReferencedComponentUuid());
   }

   public RefexCAB(TK_REFEX_TYPE memberType, UUID rcUuid, UUID collectionUUID,
                   ViewCoordinate vc, UUID moduleUuid)
           throws IOException, InvalidBlueprintException, ContradictionException {
      this(memberType, rcUuid, collectionUUID, null, null, vc, moduleUuid);
   }

   public RefexCAB(TK_REFEX_TYPE memberType, UUID rcUuid, UUID collectionUUID,
                   UUID memberUuid, RefexVersionBI refex, ViewCoordinate vc,
                   UUID moduleUuid)
           throws IOException, InvalidBlueprintException, ContradictionException {
      super(memberUuid, refex, vc, moduleUuid);
      this.memberType = memberType;
      this.properties.put(RefexProperty.REFERENCED_COMPONENT_ID, rcUuid);
      this.properties.put(RefexProperty.REFEX_EXTENSION_ID, collectionUUID);
      this.properties.put(RefexProperty.STATUS_ID,
                          SnomedMetadataRfx.getSTATUS_CURRENT_NID());

      if (getMemberUUID() != null) {
         this.properties.put(RefexProperty.MEMBER_ID, memberUuid);
      }

      if (this.properties.get(RefexProperty.STATUS_ID) != null) {
         setStatusUuid((UUID) this.properties.get(RefexProperty.STATUS_ID));
      }
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
   public UUID computeMemberContentUuid() throws InvalidBlueprintException, IOException {
      try {
         StringBuilder sb = new StringBuilder();

         for (RefexProperty prop : RefexProperty.values()) {
            switch (prop) {
            case MEMBER_ID :
            case STATUS_ID :
            case REFEX_EXTENSION_ID :
            case REFERENCED_COMPONENT_ID :
               break;

            default :
               if (properties.get(prop) != null) {
                  sb.append(properties.get(prop).toString());
               }
            }
         }

         return UuidT5Generator.get(
             refexSpecNamespace,
             memberType.name()
             + getPrimUuidStrForNidProp(RefexProperty.REFEX_EXTENSION_ID)
             + getPrimUuidStrForNidProp(RefexProperty.REFERENCED_COMPONENT_ID) + sb.toString());
      } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
         throw new RuntimeException(ex);
      }
   }

   public UUID computeMemberReferencedComponentUuid()
           throws IOException, InvalidBlueprintException {
      try {
         return UuidT5Generator.get(
             refexSpecNamespace,
             memberType.name()
             + getPrimUuidStrForNidProp(RefexProperty.REFEX_EXTENSION_ID)
             + getReferencedComponentUuid().toString());
      } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
         throw new RuntimeException(ex);
      }
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

   public Object put(RefexProperty key, Boolean value) {
      assert key == RefexProperty.BOOLEAN_EXTENSION_1;

      return properties.put(key, value);
   }

   public Object put(RefexProperty key, byte[][] value) {
      return properties.put(key, value);
   }

   public Object put(RefexProperty key, Number value) {
      return properties.put(key, value);
   }

   public Object put(RefexProperty key, String value) {
      assert key == RefexProperty.STRING_EXTENSION_1;

      return properties.put(key, value);
   }

   public Object put(RefexProperty key, UUID value) {
      assert key == RefexProperty.MEMBER_ID;

      return properties.put(RefexProperty.MEMBER_ID, value);
   }

   @Override
   public void recomputeUuid()
           throws InvalidBlueprintException, IOException, ContradictionException {
      setComponentUuid(computeMemberReferencedComponentUuid());

      for (RefexCAB annotBp : getAnnotationBlueprints()) {
         annotBp.setReferencedComponentUuid(getComponentUuid());
         annotBp.recomputeUuid();
      }
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName() + " " + memberType + " "
             + properties;
   }

   public boolean validate(RefexVersionBI<?> version) {
      if (memberType != null) {
         if (TK_REFEX_TYPE.classToType(version.getClass()) != memberType) {
            return false;
         }
      }

      for (Entry<RefexProperty, Object> entry : properties.entrySet()) {
         switch (entry.getKey()) {
         case REFERENCED_COMPONENT_ID :
            if (!entry.getValue().equals(version.getPrimUuid())) {
               return false;
            }

            break;

         case REFEX_EXTENSION_ID :
            if (!entry.getValue().equals(version.getRefexExtensionNid())) {
               return false;
            }

            break;

         case MEMBER_ID :
            try {
               if (version.getNid()
                       != Ts.get().getNidForUuids((UUID) entry.getValue())) {
                  return false;
               }
            } catch (IOException e) {
               throw new RuntimeException(e);
            }

            break;

         case BOOLEAN_EXTENSION_1 :
            if (!RefexBooleanVersionBI.class.isAssignableFrom(
                    version.getClass())) {
               return false;
            }

            RefexBooleanVersionBI<?> booleanPart =
               (RefexBooleanVersionBI<?>) version;

            if (!entry.getValue().equals(booleanPart.getBoolean1())) {
               return false;
            }

            break;

         case COMPONENT_EXTENSION_1_ID :
            if (!RefexNidVersionBI.class.isAssignableFrom(version.getClass())) {
               return false;
            }

            RefexNidVersionBI<?> c1part = (RefexNidVersionBI<?>) version;

            if (!entry.getValue().equals(c1part.getNid1())) {
               return false;
            }

            break;

         case COMPONENT_EXTENSION_3_ID :
            if (!RefexNidNidNidVersionBI.class.isAssignableFrom(
                    version.getClass())) {
               return false;
            }

            RefexNidNidNidVersionBI<?> c3part =
               (RefexNidNidNidVersionBI<?>) version;

            if (!entry.getValue().equals(c3part.getNid3())) {
               return false;
            }

            break;

         case COMPONENT_EXTENSION_2_ID :
            if (!RefexNidNidVersionBI.class.isAssignableFrom(
                    version.getClass())) {
               return false;
            }

            RefexNidNidVersionBI<?> c2part = (RefexNidNidVersionBI<?>) version;

            if (!entry.getValue().equals(c2part.getNid2())) {
               return false;
            }

            break;

         case INTEGER_EXTENSION_1 :
            if (!RefexIntVersionBI.class.isAssignableFrom(version.getClass())) {
               return false;
            }

            RefexIntVersionBI<?> intPart = (RefexIntVersionBI<?>) version;

            if (!entry.getValue().equals(intPart.getInt1())) {
               return false;
            }

            break;

         case LONG_EXTENSION_1 :
            if (!RefexLongVersionBI.class.isAssignableFrom(
                    version.getClass())) {
               return false;
            }

            RefexLongVersionBI<?> longPart = (RefexLongVersionBI<?>) version;

            if (!entry.getValue().equals(longPart.getLong1())) {
               return false;
            }

            break;

         case STATUS_ID :
            if (!entry.getValue().equals(version.getStatusNid())) {
               return false;
            }

            break;

         case STRING_EXTENSION_1 :
            if (!RefexStringVersionBI.class.isAssignableFrom(
                    version.getClass())) {
               return false;
            }

            RefexStringVersionBI<?> strPart = (RefexStringVersionBI<?>) version;

            if (!entry.getValue().equals(strPart.getString1())) {
               return false;
            }

            break;

         case ARRAY_OF_BYTEARRAY :
            if (!RefexArrayOfBytearrayVersionBI.class.isAssignableFrom(
                    version.getClass())) {
               return false;
            }

            RefexArrayOfBytearrayVersionBI<?> arrayPart =
               (RefexArrayOfBytearrayVersionBI<?>) version;

            if (!entry.getValue().equals(arrayPart.getArrayOfByteArray())) {
               return false;
            }

            break;

         default :
            throw new RuntimeException("Can't handle: " + entry.getKey());
         }
      }

      return true;
   }

   public RefexCAB with(RefexProperty key, Boolean value) {
      assert key == RefexProperty.BOOLEAN_EXTENSION_1;
      properties.put(key, value);

      return this;
   }

   public RefexCAB with(RefexProperty key, byte[][] value) {
      put(key, value);

      return this;
   }

   public RefexCAB with(RefexProperty key, Number value) {
      put(key, value);

      return this;
   }

   public RefexCAB with(RefexProperty key, String value) {
      assert key == RefexProperty.STRING_EXTENSION_1;
      properties.put(key, value);

      return this;
   }

   public void writeTo(RefexAnalogBI<?> version)
           throws PropertyVetoException, IOException {
      setProperties(version);
   }

   public byte[][] getArrayOfByteArray() {
      return (byte[][]) properties.get(RefexProperty.ARRAY_OF_BYTEARRAY);
   }

   public boolean getBoolean(RefexProperty key) {
      assert key == RefexProperty.BOOLEAN_EXTENSION_1;

      return (Boolean) properties.get(key);
   }

   public float getFloat(RefexProperty key) {
      return (Float) properties.get(key);
   }

   public int getInt(RefexProperty key) {
      return (Integer) properties.get(key);
   }

   public TK_REFEX_TYPE getMemberType() {
      return memberType;
   }

   public UUID getMemberUUID() {
      if (this.getComponentUuid() != null) {
         return this.getComponentUuid();
      }

      return (UUID) properties.get(RefexProperty.MEMBER_ID);
   }

   public UUID getMemberUuid() {
      return getComponentUuid();
   }

   private String getPrimUuidStrForNidProp(RefexProperty prop)
           throws IOException, InvalidBlueprintException {
      Object nidObj = properties.get(prop);

      if (nidObj == null) {
         throw new InvalidBlueprintException("No data for: " + prop);
      }

      int         nid       = (Integer) nidObj;
      ComponentBI component = Ts.get().getComponent(nid);

      if (component != null) {
         return component.getPrimUuid().toString();
      }

      List<UUID> uuids = Ts.get().getUuidsForNid(nid);

      if (uuids.size() == 1) {
         return uuids.get(0).toString();
      }

      throw new InvalidBlueprintException("Can't find nid for: " + prop + " props: "
                           + this.properties);
   }

   public UUID getReferencedComponentUuid() {
      return (UUID) properties.get(RefexProperty.REFERENCED_COMPONENT_ID);
   }

   public UUID getRefexColllectionUuid() {
      return (UUID) properties.get(RefexProperty.REFEX_EXTENSION_ID);
   }

   @Override
   public UUID getStatusUuid() {
      try {
         super.setStatusUuid(
             Ts.get().getComponent(
                (Integer) this.properties.get(
                   RefexProperty.STATUS_ID)).getPrimUuid());
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }

      return super.getStatusUuid();
   }

   public String getString(RefexProperty key) {
      assert key == RefexProperty.STRING_EXTENSION_1;

      return (String) properties.get(key);
   }

   public UUID getUUID(RefexProperty key) {
      assert key == RefexProperty.MEMBER_ID;

      return (UUID) properties.get(key);
   }

   public boolean hasProperty(RefexProperty key) {
      return properties.containsKey(key);
   }

   public void setContentUuid() throws InvalidBlueprintException, IOException {
      this.properties.put(RefexProperty.MEMBER_ID,
                          computeMemberContentUuid());
   }

   @Override
   public void setCurrent() {
      super.setCurrent();

      try {
         this.properties.put(RefexProperty.STATUS_ID,
                             Ts.get().getNidForUuids(super.getStatusUuid()));
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }
   }

   public UUID setMemberContentUuid() throws InvalidBlueprintException, IOException {
      UUID memberContentUuid = computeMemberContentUuid();

      properties.put(RefexProperty.MEMBER_ID, memberContentUuid);

      return memberContentUuid;
   }

   public void setMemberType(TK_REFEX_TYPE memberType) {
      this.memberType = memberType;
   }

   public void setMemberUuid(UUID memberUuid) {
      setComponentUuid(memberUuid);
      properties.put(RefexProperty.MEMBER_ID, memberUuid);
   }

   public void setProperties(RefexAnalogBI<?> version)
           throws PropertyVetoException, IOException {
      for (Entry<RefexProperty, Object> entry : properties.entrySet()) {
         switch (entry.getKey()) {
         case MEMBER_ID :
            try {
               version.setNid(Ts.get().getNidForUuids((UUID) entry.getValue()));
            } catch (IOException e) {
               throw new RuntimeException(e);
            }

            break;

         case REFERENCED_COMPONENT_ID :
            version.setReferencedComponentNid(
                Ts.get().getNidForUuids((UUID) entry.getValue()));

            break;

         case BOOLEAN_EXTENSION_1 :
            RefexBooleanAnalogBI<?> booleanPart =
               (RefexBooleanAnalogBI<?>) version;

            booleanPart.setBoolean1((Boolean) entry.getValue());

            break;

         case COMPONENT_EXTENSION_1_ID :
            RefexNidAnalogBI<?> c1v = (RefexNidAnalogBI<?>) version;

            c1v.setNid1((Integer) entry.getValue());

            break;

         case COMPONENT_EXTENSION_3_ID :
            RefexNidNidNidAnalogBI<?> c3part =
               (RefexNidNidNidAnalogBI<?>) version;

            c3part.setNid3((Integer) entry.getValue());

            break;

         case COMPONENT_EXTENSION_2_ID :
            RefexNidNidAnalogBI<?> c2part = (RefexNidNidAnalogBI<?>) version;

            c2part.setNid2((Integer) entry.getValue());

            break;

         case INTEGER_EXTENSION_1 :
            RefexIntAnalogBI<?> intPart = (RefexIntAnalogBI<?>) version;

            intPart.setInt1((Integer) entry.getValue());

            break;

         case LONG_EXTENSION_1 :
            RefexLongAnalogBI<?> longPart = (RefexLongAnalogBI<?>) version;

            longPart.setLong1((Long) entry.getValue());

            break;

         case STATUS_ID :
            ((AnalogBI) version).setStatusNid((Integer) entry.getValue());

            break;

         case STRING_EXTENSION_1 :
            RefexStringAnalogBI<?> strPart = (RefexStringAnalogBI<?>) version;

            strPart.setString1((String) entry.getValue());

            break;

         case ARRAY_OF_BYTEARRAY :
            RefexArrayOfBytearrayAnalogBI<?> arrayPart =
               (RefexArrayOfBytearrayAnalogBI<?>) version;

            arrayPart.setArrayOfByteArray((byte[][]) entry.getValue());

            break;

         default :
            throw new RuntimeException("Can't handle: " + entry.getKey());
         }
      }
   }

   public void setPropertiesExceptSap(RefexAnalogBI<?> version)
           throws PropertyVetoException, IOException {
      for (Entry<RefexProperty, Object> entry : properties.entrySet()) {
         switch (entry.getKey()) {
         case MEMBER_ID :
            try {
               int nid = Ts.get().getNidForUuids((UUID) entry.getValue());

               if (version.getNid() != nid) {
                  version.setNid(nid);
               }
            } catch (IOException e) {
               throw new RuntimeException(e);
            }

            break;

         case BOOLEAN_EXTENSION_1 :
            RefexBooleanAnalogBI<?> booleanPart =
               (RefexBooleanAnalogBI<?>) version;

            booleanPart.setBoolean1((Boolean) entry.getValue());

            break;

         case REFEX_EXTENSION_ID :
            version.setRefexExtensionNid((Integer) entry.getValue());

            break;

         case REFERENCED_COMPONENT_ID :
            version.setReferencedComponentNid(
                Ts.get().getNidForUuids((UUID) entry.getValue()));

            break;

         case COMPONENT_EXTENSION_1_ID :
            RefexNidAnalogBI<?> c1part = (RefexNidAnalogBI<?>) version;

            c1part.setNid1((Integer) entry.getValue());

            break;

         case COMPONENT_EXTENSION_3_ID :
            RefexNidNidNidAnalogBI<?> c3part =
               (RefexNidNidNidAnalogBI<?>) version;

            c3part.setNid3((Integer) entry.getValue());

            break;

         case COMPONENT_EXTENSION_2_ID :
            RefexNidNidAnalogBI<?> c2part = (RefexNidNidAnalogBI<?>) version;

            c2part.setNid2((Integer) entry.getValue());

            break;

         case INTEGER_EXTENSION_1 :
            RefexIntAnalogBI<?> intPart = (RefexIntAnalogBI<?>) version;

            intPart.setInt1((Integer) entry.getValue());

            break;

         case LONG_EXTENSION_1 :
            RefexLongAnalogBI<?> longPart = (RefexLongAnalogBI<?>) version;

            longPart.setLong1((Long) entry.getValue());

            break;

         case STATUS_ID :

            // SAP property
            break;

         case STRING_EXTENSION_1 :
            RefexStringAnalogBI<?> strPart = (RefexStringAnalogBI<?>) version;

            strPart.setString1((String) entry.getValue());

            break;

         case ARRAY_OF_BYTEARRAY :
            RefexArrayOfBytearrayAnalogBI<?> arrayPart =
               (RefexArrayOfBytearrayAnalogBI<?>) version;

            arrayPart.setArrayOfByteArray((byte[][]) entry.getValue());

            break;

         default :
            throw new RuntimeException("Can't handle: " + entry.getKey());
         }
      }
   }

   protected void setReferencedComponentUuid(UUID rcUuid) {
      this.properties.put(RefexProperty.REFERENCED_COMPONENT_ID, rcUuid);
   }

   @Override
   public void setRetired() {
      super.setRetired();

      try {
         this.properties.put(RefexProperty.STATUS_ID,
                             Ts.get().getNidForUuids(super.getStatusUuid()));
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }
   }

   @Override
   public void setStatusUuid(UUID statusUuid) {
      super.setStatusUuid(statusUuid);

      if (this.properties.get(RefexProperty.STATUS_ID) != null) {
         try {
            this.properties.put(RefexProperty.STATUS_ID,
                                Ts.get().getNidForUuids(statusUuid));
         } catch (IOException ex) {
            throw new RuntimeException(ex);
         }
      }
   }
}
