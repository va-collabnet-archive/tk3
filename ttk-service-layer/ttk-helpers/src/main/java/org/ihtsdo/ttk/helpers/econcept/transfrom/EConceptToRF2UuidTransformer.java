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



package org.ihtsdo.ttk.helpers.econcept.transfrom;

//~--- non-JDK imports --------------------------------------------------------
import org.ihtsdo.otf.tcc.api.country.COUNTRY_CODE;
import org.ihtsdo.ttk.helpers.time.TimeHelper;
import org.ihtsdo.otf.tcc.api.lang.LanguageCode;
import org.ihtsdo.otf.tcc.dto.TtkConceptChronicle;
import org.ihtsdo.otf.tcc.dto.component.attribute.TtkConceptAttributesChronicle;
import org.ihtsdo.otf.tcc.dto.component.attribute.TtkConceptAttributesRevision;
import org.ihtsdo.otf.tcc.dto.component.description.TtkDescriptionChronicle;
import org.ihtsdo.otf.tcc.dto.component.description.TtkDescriptionRevision;
import org.ihtsdo.otf.tcc.dto.component.relationship.TtkRelationshipChronicle;
import org.ihtsdo.otf.tcc.dto.component.relationship.TtkRelationshipRevision;

//~--- JDK imports ------------------------------------------------------------

import java.io.*;

import java.util.Date;
import org.ihtsdo.ttk.helpers.rf2.Rf2File.ConceptsFileFields;
import org.ihtsdo.ttk.helpers.rf2.Rf2File.DescriptionsFileFields;
import org.ihtsdo.ttk.helpers.rf2.Rf2File.IdentifiersFileFields;
import org.ihtsdo.ttk.helpers.rf2.Rf2File.RelationshipsFileFields;
import org.ihtsdo.ttk.helpers.rf2.Rf2File.ReleaseType;

/**
 *
 * @author kec
 */
public class EConceptToRF2UuidTransformer implements EConceptTransformerBI {
   Writer       conceptsWriter;
   COUNTRY_CODE country;
   Writer       descriptionsWriter;
   Date         effectiveDate;
   Writer       identifiersWriter;
   LanguageCode    language;
   String       namespace;
   Writer       relationshipsWriter;
   ReleaseType  releaseType;

   //~--- constructors --------------------------------------------------------

   public EConceptToRF2UuidTransformer(File directory, ReleaseType releaseType, LanguageCode language,
                             COUNTRY_CODE country, String namespace, Date effectiveDate)
           throws IOException {
      directory.mkdirs();
      this.releaseType = releaseType;
      this.language    = language;
      this.country     = country;
      this.namespace   = namespace;

      File conceptsFile = new File(directory,
                                   "sct2_Concept_" + releaseType.suffix + "_"
                                   + country.getFormatedCountryCode() + namespace + "_"
                                   + TimeHelper.getShortFileDateFormat().format(effectiveDate) + ".txt");
      File descriptionsFile = new File(directory,
                                       "sct2_Description_" + releaseType.suffix + "-"
                                       + language.getFormatedLanguageCode() + "_"
                                       + country.getFormatedCountryCode() + namespace + "_"
                                       + TimeHelper.getShortFileDateFormat().format(effectiveDate) + ".txt");
      File relationshipsFile = new File(directory,
                                        "sct2_Relationship_" + releaseType.suffix + "_"
                                        + country.getFormatedCountryCode() + namespace + "_"
                                        + TimeHelper.getShortFileDateFormat().format(effectiveDate) + ".txt");
      File identifiersFile = new File(directory,
                                      "sct2_Identifier_" + releaseType.suffix + "_"
                                      + country.getFormatedCountryCode() + namespace + "_"
                                      + TimeHelper.getShortFileDateFormat().format(effectiveDate) + ".txt");

      conceptsWriter      = new BufferedWriter(new FileWriter(conceptsFile));
      descriptionsWriter  = new BufferedWriter(new FileWriter(descriptionsFile));
      relationshipsWriter = new BufferedWriter(new FileWriter(relationshipsFile));
      identifiersWriter   = new BufferedWriter(new FileWriter(identifiersFile));

      for (ConceptsFileFields field : ConceptsFileFields.values()) {
         conceptsWriter.write(field.headerText);

         if (field != ConceptsFileFields.DEFINITION_STATUS_ID) {
            conceptsWriter.write("\t");
         } else {
            conceptsWriter.write("\n");
         }
      }

      for (DescriptionsFileFields field : DescriptionsFileFields.values()) {
         descriptionsWriter.write(field.headerText);

         if (field != DescriptionsFileFields.CASE_SIGNIFICANCE_ID) {
            descriptionsWriter.write("\t");
         } else {
            descriptionsWriter.write("\n");
         }
      }

      for (RelationshipsFileFields field : RelationshipsFileFields.values()) {
         relationshipsWriter.write(field.headerText);

         if (field != RelationshipsFileFields.MODIFIER_ID) {
            relationshipsWriter.write("\t");
         } else {
            relationshipsWriter.write("\n");
         }
      }

      for (IdentifiersFileFields field : IdentifiersFileFields.values()) {
         identifiersWriter.write(field.headerText);

         if (field != IdentifiersFileFields.REFERENCED_COMPONENT_ID) {
            identifiersWriter.write("\t");
         } else {
            identifiersWriter.write("\n");
         }
      }
   }

 
   //~--- methods -------------------------------------------------------------

   @Override
   public void close() throws IOException {
      if (conceptsWriter != null) {
         conceptsWriter.close();
      }

      if (descriptionsWriter != null) {
         descriptionsWriter.close();
      }

      if (relationshipsWriter != null) {
         relationshipsWriter.close();
      }

      if (identifiersWriter != null) {
         identifiersWriter.close();
      }
   }

   @Override
   public void process(TtkConceptChronicle c) throws Exception {
      TtkConceptAttributesChronicle ca = c.getConceptAttributes();

      processConceptAttribute(ca);

      if (c.getDescriptions() != null) {
         for (TtkDescriptionChronicle d : c.getDescriptions()) {
            processDescription(d);
         }
      }

      if (c.getRelationships() != null) {
         for (TtkRelationshipChronicle r : c.getRelationships()) {
            processRelationship(r);
         }
      }

      throw new UnsupportedOperationException("Not supported yet.");
   }

   private void processConceptAttribute(TtkConceptAttributesChronicle ca) throws IOException {
      if (ca != null) {
         for (ConceptsFileFields field : ConceptsFileFields.values()) {
            switch (field) {
            case ACTIVE :
               conceptsWriter.write(ca.getStatus().toString() + "\t");

               break;

            case DEFINITION_STATUS_ID :
               conceptsWriter.write(ca.isDefined() + "\n");

               break;

            case EFFECTIVE_TIME :
               conceptsWriter.write(TimeHelper.formatDateForFile(ca.getTime()) + "\t");

               break;

            case ID :
               conceptsWriter.write(ca.getPrimordialComponentUuid().toString() + "\t");

               break;

            case MODULE_ID :
               conceptsWriter.write(namespace + "\t");

               break;
            }
         }

         if (ca.revisions != null) {
            for (TtkConceptAttributesRevision car : ca.revisions) {
               for (ConceptsFileFields field : ConceptsFileFields.values()) {
                  switch (field) {
                  case ACTIVE :
                     conceptsWriter.write(car.getStatus().toString() + "\t");

                     break;

                  case DEFINITION_STATUS_ID :
                     conceptsWriter.write(car.isDefined() + "\n");

                     break;

                  case EFFECTIVE_TIME :
                     conceptsWriter.write(TimeHelper.formatDateForFile(car.getTime()) + "\t");

                     break;

                  case ID :
                     conceptsWriter.write(ca.getPrimordialComponentUuid().toString() + "\t");

                     break;

                  case MODULE_ID :
                     conceptsWriter.write(namespace + "\n");

                     break;
                  }
               }
            }
         }
      }
   }

   private void processDescription(TtkDescriptionChronicle desc) throws IOException {
      if (desc != null) {
         for (DescriptionsFileFields field : DescriptionsFileFields.values()) {
            switch (field) {
            case ACTIVE :
               descriptionsWriter.write(desc.getStatus().toString() + "\t");

               break;

            case EFFECTIVE_TIME :
               descriptionsWriter.write(TimeHelper.formatDateForFile(desc.getTime()) + "\t");

               break;

            case ID :
               descriptionsWriter.write(desc.getPrimordialComponentUuid().toString() + "\t");

               break;

            case MODULE_ID :
               descriptionsWriter.write(namespace + "\t");

               break;

            case CONCEPT_ID :
               descriptionsWriter.write(desc.getConceptUuid() + "\t");

               break;

            case LANGUAGE_CODE :
               descriptionsWriter.write(desc.getLang() + "\t");

               break;

            case TYPE_ID :
               descriptionsWriter.write(desc.getTypeUuid() + "\t");

               break;

            case TERM :
               descriptionsWriter.write(desc.getText() + "\t");

               break;

            case CASE_SIGNIFICANCE_ID :
               descriptionsWriter.write(desc.isInitialCaseSignificant() + "\n");

               break;
            }
         }

         if (desc.revisions != null) {
            for (TtkDescriptionRevision descr : desc.revisions) {
               for (DescriptionsFileFields field : DescriptionsFileFields.values()) {
                  switch (field) {
                  case ACTIVE :
                     descriptionsWriter.write(descr.getStatus().toString() + "\t");

                     break;

                  case EFFECTIVE_TIME :
                     descriptionsWriter.write(TimeHelper.formatDateForFile(descr.getTime()) + "\t");

                     break;

                  case ID :
                     descriptionsWriter.write(desc.getPrimordialComponentUuid().toString() + "\t");

                     break;

                  case MODULE_ID :
                     descriptionsWriter.write(namespace + "\t");

                     break;

                  case CONCEPT_ID :
                     descriptionsWriter.write(desc.getConceptUuid() + "\t");

                     break;

                  case LANGUAGE_CODE :
                     descriptionsWriter.write(descr.getLang() + "\t");

                     break;

                  case TYPE_ID :
                     descriptionsWriter.write(descr.getTypeUuid() + "\t");

                     break;

                  case TERM :
                     descriptionsWriter.write(descr.getText() + "\t");

                     break;

                  case CASE_SIGNIFICANCE_ID :
                     descriptionsWriter.write(descr.isInitialCaseSignificant() + "\n");

                     break;
                  }
               }
            }
         }
      }
   }

   private void processRelationship(TtkRelationshipChronicle r) throws IOException {
      if (r != null) {
         for (RelationshipsFileFields field : RelationshipsFileFields.values()) {
            switch (field) {
            case ACTIVE :
               relationshipsWriter.write(r.getStatus().toString() + "\t");

               break;

            case EFFECTIVE_TIME :
               relationshipsWriter.write(TimeHelper.formatDateForFile(r.getTime()) + "\t");

               break;

            case ID :
               relationshipsWriter.write(r.getPrimordialComponentUuid().toString() + "\t");

               break;

            case MODULE_ID :
               relationshipsWriter.write(namespace + "\t");

               break;

            case SOURCE_ID :
               relationshipsWriter.write(r.getC1Uuid() + "\t");

               break;

            case DESTINATION_ID :
               relationshipsWriter.write(r.getC2Uuid() + "\t");

               break;

            case RELATIONSHIP_GROUP :
               relationshipsWriter.write(r.getRelGroup() + "\t");

               break;

            case TYPE_ID :
               relationshipsWriter.write(r.getTypeUuid() + "\t");

               break;

            case CHARCTERISTIC_ID :
               relationshipsWriter.write(r.getCharacteristicUuid() + "\t");

               break;

            case MODIFIER_ID :
               relationshipsWriter.write(r.getRefinabilityUuid() + "\n");

               break;
            }
         }

         if (r.revisions != null) {
            for (TtkRelationshipRevision rv : r.revisions) {
               for (RelationshipsFileFields field : RelationshipsFileFields.values()) {
                  switch (field) {
                  case ACTIVE :
                     relationshipsWriter.write(rv.getStatus().toString() + "\t");

                     break;

                  case EFFECTIVE_TIME :
                     relationshipsWriter.write(TimeHelper.formatDateForFile(rv.getTime()) + "\t");

                     break;

                  case ID :
                     relationshipsWriter.write(r.getPrimordialComponentUuid().toString() + "\t");

                     break;

                  case MODULE_ID :
                     relationshipsWriter.write(namespace + "\t");

                     break;

                  case SOURCE_ID :
                     relationshipsWriter.write(r.getC1Uuid() + "\t");

                     break;

                  case DESTINATION_ID :
                     relationshipsWriter.write(r.getC2Uuid() + "\t");

                     break;

                  case RELATIONSHIP_GROUP :
                     relationshipsWriter.write(rv.getGroup() + "\t");

                     break;

                  case TYPE_ID :
                     relationshipsWriter.write(rv.getTypeUuid() + "\t");

                     break;

                  case CHARCTERISTIC_ID :
                     relationshipsWriter.write(rv.getCharacteristicUuid() + "\t");

                     break;

                  case MODIFIER_ID :
                     relationshipsWriter.write(rv.getRefinabilityUuid() + "\n");

                     break;
                  }
               }
            }
         }
      }
   }
}
