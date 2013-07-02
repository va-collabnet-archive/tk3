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



package org.ihtsdo.ttk.dto;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.blueprint.ConceptAttributeAB;
import org.ihtsdo.ttk.api.blueprint.ConceptCB;
import org.ihtsdo.ttk.api.blueprint.DescriptionCAB;
import org.ihtsdo.ttk.api.blueprint.InvalidCAB;
import org.ihtsdo.ttk.api.blueprint.MediaCAB;
import org.ihtsdo.ttk.api.blueprint.RefexCAB;
import org.ihtsdo.ttk.api.blueprint.ComponentProperty;
import org.ihtsdo.ttk.api.blueprint.RelationshipCAB;
import org.ihtsdo.ttk.dto.component.TkComponent;
import org.ihtsdo.ttk.dto.component.attribute.TkConceptAttributes;
import org.ihtsdo.ttk.dto.component.description.TkDescription;
import org.ihtsdo.ttk.dto.component.media.TkMedia;
import org.ihtsdo.ttk.dto.component.refex.TkRefexAbstractMember;
import org.ihtsdo.ttk.dto.component.refex.type_array_of_bytearray.TkRefexArrayOfByteArrayMember;
import org.ihtsdo.ttk.dto.component.refex.type_boolean.TkRefexBooleanMember;
import org.ihtsdo.ttk.dto.component.refex.type_int.TkRefexIntMember;
import org.ihtsdo.ttk.dto.component.refex.type_long.TkRefexLongMember;
import org.ihtsdo.ttk.dto.component.refex.type_member.TkRefexMember;
import org.ihtsdo.ttk.dto.component.refex.type_string.TkRefexStringMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid.TkRefexUuidMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_boolean.TkRefexUuidBooleanMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_float.TkRefexUuidFloatMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_int.TkRefexUuidIntMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_long.TkRefexUuidLongMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_string.TkRefexUuidStringMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid.TkRefexUuidUuidMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_string.TkRefexUuidUuidStringMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid_float.TkRefexUuidUuidUuidFloatMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid_int.TkRefexUuidUuidUuidIntMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid_long.TkRefexUuidUuidUuidLongMember;
import org.ihtsdo.ttk.dto.component.refex.type_uuid_uuid_uuid_string.TkRefexUuidUuidUuidStringMember;
import org.ihtsdo.ttk.dto.component.relationship.TkRelationship;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.List;
import java.util.UUID;

/**
 *
 * @authorUuid kec
 */
public class UuidDtoBuilder {

   /** Field description */
   long time;

   /** Field description */
   UUID authorUuid;

   /** Field description */
   UUID pathUuid;

   UUID moduleUuid;

   /**
    * Constructs ...
    *
    *
    * @param time
    * @param authorUuid
    * @param pathUuid
    */
   public UuidDtoBuilder(long time, UUID authorUuid, UUID pathUuid, UUID moduleUuid) {
      this.time   = time;
      this.authorUuid = authorUuid;
      this.pathUuid   = pathUuid;
      this.moduleUuid = moduleUuid;
   }

   /**
    * Method description
    *
    *
    * @param blueprint
    *
    * @return
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidCAB
    */
   public TtkConcept construct(ConceptCB blueprint)
           throws IOException, InvalidCAB, ContradictionException {
      TtkConcept newC = new TtkConcept();

      newC.setAnnotationStyleRefex(blueprint.isAnnotationRefexExtensionIdentity());
      newC.setPrimordialUuid(blueprint.getComponentUuid());
      construct(blueprint.getConceptAttributeAB(), newC);

      List<DescriptionCAB>  fsnBps   = blueprint.getFullySpecifiedNameCABs();
      List<DescriptionCAB>  prefBps  = blueprint.getPreferredNameCABs();
      List<DescriptionCAB>  descBps  = blueprint.getDescriptionCABs();
      List<RelationshipCAB>   relBps   = blueprint.getRelationshipCABs();
      List<MediaCAB> mediaBps = blueprint.getMediaCABs();

      for (DescriptionCAB fsnBp : fsnBps) {
         this.construct(fsnBp, newC);
      }

      for (DescriptionCAB prefBp : prefBps) {
         this.construct(prefBp, newC);
      }

      for (DescriptionCAB descBp : descBps) {
         if (fsnBps.contains(descBp) || prefBps.contains(descBp)) {
            continue;
         } else {
            this.construct(descBp, newC);
         }
      }

      for (RelationshipCAB relBp : relBps) {
         this.construct(relBp, newC);
      }

      for (MediaCAB mediaBp : mediaBps) {
         construct(mediaBp, newC);
      }

      return newC;
   }

   /**
    * Method description
    *
    *
    * @param blueprint
    * @param c
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidCAB
    */
   private void construct(ConceptAttributeAB blueprint, TtkConcept c)
           throws IOException, InvalidCAB, ContradictionException {
      TkConceptAttributes ca = new TkConceptAttributes();

      ca.primordialUuid = c.primordialUuid;
      ca.defined        = blueprint.defined;
      ca.statusUuid     = blueprint.getStatusUuid();
      ca.time           = time;
      ca.authorUuid     = authorUuid;
      ca.moduleUuid     = moduleUuid;
      ca.pathUuid       = pathUuid;

      for (RefexCAB annotBp : blueprint.getAnnotationBlueprints()) {
         construct(annotBp, ca);
      }

      c.conceptAttributes = ca;
   }

   /**
    * Method description
    *
    *
    * @param blueprint
    * @param c
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidCAB
    */
   private void construct(DescriptionCAB blueprint, TtkConcept c)
           throws IOException, InvalidCAB, ContradictionException {
      TkDescription d = new TkDescription();

      d.primordialUuid = blueprint.getComponentUuid();
      d.conceptUuid    = c.primordialUuid;
      d.typeUuid       = blueprint.getTypeUuid();
      d.setLang(blueprint.getLang());
      d.setText(blueprint.getText());
      d.setInitialCaseSignificant(blueprint.isInitialCaseSignificant());
      d.statusUuid = blueprint.getStatusUuid();
      d.time       = time;
      d.authorUuid = authorUuid;
      d.moduleUuid = moduleUuid;
      d.pathUuid   = pathUuid;

      for (RefexCAB annotBp : blueprint.getAnnotationBlueprints()) {
         construct(annotBp, d);
      }

      c.getDescriptions().add(d);
   }

   /**
    * Method description
    *
    *
    * @param blueprint
    * @param c
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidCAB
    */
   private void construct(MediaCAB blueprint, TtkConcept c)
           throws IOException, InvalidCAB, ContradictionException {
      TkMedia img = new TkMedia();

      img.primordialUuid  = blueprint.getComponentUuid();
      img.conceptUuid     = c.primordialUuid;
      img.dataBytes       = blueprint.dataBytes;
      img.format          = blueprint.format;
      img.textDescription = blueprint.textDescription;
      img.typeUuid        = blueprint.getTypeUuid();
      img.statusUuid      = blueprint.getStatusUuid();
      img.time            = time;
      img.authorUuid      = authorUuid;
      img.moduleUuid      = moduleUuid;
      img.pathUuid        = pathUuid;

      for (RefexCAB annotBp : blueprint.getAnnotationBlueprints()) {
         construct(annotBp, img);
      }

      c.getMedia().add(img);
   }

   /**
    * Method description
    *
    *
    * @param blueprint
    * @param component
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidCAB
    */
   private void construct(RefexCAB blueprint, TkComponent component)
           throws IOException, InvalidCAB, ContradictionException {
      TkRefexAbstractMember annot = createRefex(blueprint);

      component.getAnnotations().add(annot);

      for (RefexCAB childBp : blueprint.getAnnotationBlueprints()) {
         construct(childBp, annot);
      }
   }

   /**
    * Method description
    *
    *
    * @param blueprint
    * @param c
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidCAB
    */
   private void construct(RelationshipCAB blueprint, TtkConcept c)
           throws IOException, InvalidCAB, ContradictionException {
      TkRelationship r = new TkRelationship();

      r.primordialUuid     = blueprint.getComponentUuid();
      r.c1Uuid             = c.getPrimordialUuid();
      r.c2Uuid             = blueprint.getTargetUuid();
      r.characteristicUuid = blueprint.getCharacteristicUuid();
      r.group              = blueprint.getGroup();
      r.typeUuid           = blueprint.getTypeUuid();
      r.refinabilityUuid   = blueprint.getRefinabilityUuid();
      r.statusUuid         = blueprint.getStatusUuid();
      r.time               = time;
      r.authorUuid         = authorUuid;
      r.moduleUuid         = moduleUuid;
      r.pathUuid           = pathUuid;

      for (RefexCAB annotBp : blueprint.getAnnotationBlueprints()) {
         construct(annotBp, r);
      }

      c.getRelationships().add(r);
   }

   /**
    * Method description
    *
    *
    * @param blueprint
    *
    * @return
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidCAB
    */
   private TkRefexAbstractMember createRefex(RefexCAB blueprint)
           throws IOException, InvalidCAB, ContradictionException {
      switch (blueprint.getMemberType()) {
      case ARRAY_BYTEARRAY :
         TkRefexArrayOfByteArrayMember rm1 = new TkRefexArrayOfByteArrayMember();

         rm1.arrayOfByteArray1 = blueprint.getArrayOfByteArray();
         setStandardFields(rm1, blueprint);

         return rm1;

      case BOOLEAN :
         TkRefexBooleanMember rm2 = new TkRefexBooleanMember();

         rm2.booleanValue = blueprint.getBoolean(ComponentProperty.BOOLEAN_EXTENSION_1);
         setStandardFields(rm2, blueprint);

         return rm2;

      case CID :
         TkRefexUuidMember rm3 = new TkRefexUuidMember();

         rm3.uuid1 = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_1_ID);
         setStandardFields(rm3, blueprint);

         return rm3;

      case CID_CID :
         TkRefexUuidUuidMember rm4 = new TkRefexUuidUuidMember();

         rm4.uuid1 = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_1_ID);
         rm4.uuid2 = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_2_ID);
         setStandardFields(rm4, blueprint);

         return rm4;

      case CID_CID_CID :
         TkRefexUuidUuidUuidMember rm5 = new TkRefexUuidUuidUuidMember();

         rm5.uuid1 = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_1_ID);
         rm5.uuid2 = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_2_ID);
         rm5.uuid3 = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_3_ID);
         setStandardFields(rm5, blueprint);

         return rm5;

      case CID_CID_CID_FLOAT :
         TkRefexUuidUuidUuidFloatMember rm6 = new TkRefexUuidUuidUuidFloatMember();

         rm6.uuid1  = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_1_ID);
         rm6.uuid2  = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_2_ID);
         rm6.uuid3  = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_3_ID);
         rm6.float1 = blueprint.getFloat(ComponentProperty.FLOAT_EXTENSION_1);
         setStandardFields(rm6, blueprint);

         return rm6;

      case CID_CID_CID_INT :
         TkRefexUuidUuidUuidIntMember rm7 = new TkRefexUuidUuidUuidIntMember();

         rm7.uuid1 = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_1_ID);
         rm7.uuid2 = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_2_ID);
         rm7.uuid3 = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_3_ID);
         rm7.int1  = blueprint.getInt(ComponentProperty.INTEGER_EXTENSION_1);
         setStandardFields(rm7, blueprint);

         return rm7;

      case CID_CID_CID_LONG :
         TkRefexUuidUuidUuidLongMember rm8 = new TkRefexUuidUuidUuidLongMember();

         rm8.uuid1 = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_1_ID);
         rm8.uuid2 = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_2_ID);
         rm8.uuid3 = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_3_ID);
         rm8.long1 = blueprint.getLong(ComponentProperty.LONG_EXTENSION_1);
         setStandardFields(rm8, blueprint);

         return rm8;

      case CID_CID_CID_STRING :
         TkRefexUuidUuidUuidStringMember rm9 = new TkRefexUuidUuidUuidStringMember();

         rm9.uuid1   = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_1_ID);
         rm9.uuid2   = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_2_ID);
         rm9.uuid3   = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_3_ID);
         rm9.string1 = blueprint.getString(ComponentProperty.STRING_EXTENSION_1);
         setStandardFields(rm9, blueprint);

         return rm9;

      case CID_BOOLEAN :
         TkRefexUuidBooleanMember rm9b = new TkRefexUuidBooleanMember();

         rm9b.uuid1    = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_1_ID);
         rm9b.boolean1 = blueprint.getBoolean(ComponentProperty.BOOLEAN_EXTENSION_1);

         return rm9b;

      case CID_CID_STR :
         TkRefexUuidUuidStringMember rm10 = new TkRefexUuidUuidStringMember();

         rm10.uuid1   = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_1_ID);
         rm10.uuid2   = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_2_ID);
         rm10.string1 = blueprint.getString(ComponentProperty.STRING_EXTENSION_1);
         setStandardFields(rm10, blueprint);

         return rm10;

      case CID_FLOAT :
         TkRefexUuidFloatMember rm11 = new TkRefexUuidFloatMember();

         rm11.uuid1  = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_1_ID);
         rm11.float1 = blueprint.getFloat(ComponentProperty.FLOAT_EXTENSION_1);
         setStandardFields(rm11, blueprint);

         return rm11;

      case CID_INT :
         TkRefexUuidIntMember rm12 = new TkRefexUuidIntMember();

         rm12.uuid1 = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_1_ID);
         rm12.int1  = blueprint.getInt(ComponentProperty.INTEGER_EXTENSION_1);
         setStandardFields(rm12, blueprint);

         return rm12;

      case CID_LONG :
         TkRefexUuidLongMember rm13 = new TkRefexUuidLongMember();

         rm13.uuid1 = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_1_ID);
         rm13.long1 = blueprint.getLong(ComponentProperty.LONG_EXTENSION_1);
         setStandardFields(rm13, blueprint);

         return rm13;

      case CID_STR :
         TkRefexUuidStringMember rm14 = new TkRefexUuidStringMember();

         rm14.uuid1   = blueprint.getUuid(ComponentProperty.COMPONENT_EXTENSION_1_ID);
         rm14.string1 = blueprint.getString(ComponentProperty.STRING_EXTENSION_1);
         setStandardFields(rm14, blueprint);

         return rm14;

      case INT :
         TkRefexIntMember rm15 = new TkRefexIntMember();

         rm15.int1 = blueprint.getInt(ComponentProperty.INTEGER_EXTENSION_1);
         setStandardFields(rm15, blueprint);

         return rm15;

      case LONG :
         TkRefexLongMember rm16 = new TkRefexLongMember();

         rm16.long1 = blueprint.getLong(ComponentProperty.LONG_EXTENSION_1);
         setStandardFields(rm16, blueprint);

         return rm16;

      case MEMBER :
         TkRefexMember rm17 = new TkRefexMember();

         setStandardFields(rm17, blueprint);

         return rm17;

      case STR :
         TkRefexStringMember rm18 = new TkRefexStringMember();

         rm18.string1 = blueprint.getString(ComponentProperty.STRING_EXTENSION_1);
         setStandardFields(rm18, blueprint);

         return rm18;

      case UNKNOWN :
      default :
         throw new UnsupportedOperationException("Can't handle: " + blueprint.getMemberType());
      }
   }

   /**
    * Method description
    *
    *
    * @param rm1
    * @param blueprint
    *
    * @throws IOException
    */
   private void setStandardFields(TkRefexAbstractMember rm1, RefexCAB blueprint) throws IOException {
      rm1.primordialUuid     = blueprint.getMemberUUID();
      rm1.componentUuid      = blueprint.getComponentUuid();
      rm1.refexExtensionUuid = blueprint.getRefexCollectionUuid();
      rm1.statusUuid         = blueprint.getStatusUuid();
      rm1.time               = time;
      rm1.authorUuid         = authorUuid;
      rm1.moduleUuid         = moduleUuid;
   }
}
