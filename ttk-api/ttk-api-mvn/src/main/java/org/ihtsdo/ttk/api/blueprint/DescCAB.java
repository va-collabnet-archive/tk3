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

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.description.DescriptionVersionBI;
import org.ihtsdo.ttk.api.lang.LANG_CODE;
import org.ihtsdo.ttk.api.uuid.UuidT5Generator;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.security.NoSuchAlgorithmException;

import java.util.UUID;

/**
 *
 * @author kec
 */
public class DescCAB extends CreateOrAmendBlueprint {
   public static final UUID descSpecNamespace =
      UUID.fromString("457e4a20-5284-11e0-b8af-0800200c9a66");
   private UUID   conceptUuid;
   private UUID   typeUuid;
   public String  lang;
   public String  text;
   public boolean initialCaseSignificant;

   public DescCAB(int conceptNid, int typeNid, LANG_CODE lang, String text,
                  boolean initialCaseSignificant, UUID moduleUuid)
           throws IOException, InvalidCAB, ContradictionException {
      this(Ts.get().getComponent(conceptNid).getPrimUuid(),
           Ts.get().getComponent(typeNid).getPrimUuid(), lang, text,
           initialCaseSignificant, moduleUuid);
   }

   public DescCAB(UUID conceptUuid, UUID typeUuid, LANG_CODE lang, String text,
                  boolean initialCaseSignificant, UUID moduleUuid)
           throws IOException, InvalidCAB, ContradictionException {
      this(conceptUuid, typeUuid, lang, text, initialCaseSignificant, null,
           null, null, moduleUuid);
   }

   public DescCAB(int conceptNid, int typeNid, LANG_CODE lang, String text,
                  boolean initialCaseSignificant, DescriptionVersionBI dv,
                  ViewCoordinate vc, UUID moduleUuid)
           throws IOException, InvalidCAB, ContradictionException {
      this(Ts.get().getComponent(conceptNid).getPrimUuid(),
           Ts.get().getComponent(typeNid).getPrimUuid(), lang, text,
           initialCaseSignificant, dv, vc, moduleUuid);
   }

   public DescCAB(UUID conceptUuid, UUID typeUuid, LANG_CODE lang, String text,
                  boolean initialCaseSignificant, DescriptionVersionBI dv,
                  ViewCoordinate vc, UUID moduleUuid)
           throws IOException, InvalidCAB, ContradictionException {
      this(conceptUuid, typeUuid, lang, text, initialCaseSignificant, null, dv,
           vc, moduleUuid);
   }

   public DescCAB(UUID conceptUuid, UUID typeUuid, LANG_CODE lang, String text,
                  boolean initialCaseSignificant, UUID componentUuid,
                  DescriptionVersionBI dv, ViewCoordinate vc, UUID moduleUuid)
           throws IOException, InvalidCAB, ContradictionException {
      super(componentUuid, dv, vc, moduleUuid);
      this.conceptUuid            = conceptUuid;
      this.lang                   = lang.getFormatedLanguageCode();
      this.text                   = text;
      this.initialCaseSignificant = initialCaseSignificant;
      this.typeUuid               = typeUuid;

      if (getComponentUuid() == null) {
         try {
            recomputeUuid();
         } catch (IOException | InvalidCAB | NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
         }
      }
   }

   @Override
   public void recomputeUuid()
           throws NoSuchAlgorithmException, UnsupportedEncodingException,
                  IOException, InvalidCAB, ContradictionException {
      setComponentUuid(UuidT5Generator.get(descSpecNamespace,
              getPrimoridalUuidStr(conceptUuid) + lang + text));

      for (RefexCAB annotBp : getAnnotationBlueprints()) {
         annotBp.setReferencedComponentUuid(getComponentUuid());
         annotBp.recomputeUuid();
      }
   }

   public boolean validate(DescriptionVersionBI version) throws IOException {
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

      if (!version.getLang().equals(getLang())) {
         return false;
      }

      if (!version.getText().equals(getText())) {
         return false;
      }

      if (version.isInitialCaseSignificant() != isInitialCaseSignificant()) {
         return false;
      }

      return true;
   }

   public int getConceptNid() throws IOException {
      return Ts.get().getNidForUuids(conceptUuid);
   }

   public UUID getConceptUuid() {
      return conceptUuid;
   }

   public String getLang() {
      return lang;
   }

   public String getText() {
      return text;
   }

   public int getTypeNid() throws IOException {
      return Ts.get().getNidForUuids(typeUuid);
   }

   public UUID getTypeUuid() {
      return typeUuid;
   }

   public boolean isInitialCaseSignificant() {
      return initialCaseSignificant;
   }

   protected void setConceptUuid(UUID conceptNewUuid) {
      this.conceptUuid = conceptNewUuid;
   }

   protected void setText(String newText) {
      this.text = newText;
   }
}
