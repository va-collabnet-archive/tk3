/*
 * Copyright 2011
 * International Health Terminology Standards Development Organisation.
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
import org.ihtsdo.ttk.api.TK_REFEX_TYPE;
import org.ihtsdo.ttk.api.TkRelType;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.concept.ConceptVersionBI;
import org.ihtsdo.ttk.api.description.DescriptionVersionBI;
import org.ihtsdo.ttk.api.lang.LANG_CODE;
import org.ihtsdo.ttk.api.media.MediaVersionBI;
import org.ihtsdo.ttk.api.metadata.binding.SnomedMetadataRf1;
import org.ihtsdo.ttk.api.metadata.binding.SnomedMetadataRf2;
import org.ihtsdo.ttk.api.metadata.binding.SnomedMetadataRfx;
import org.ihtsdo.ttk.api.relationship.RelationshipVersionBI;
import org.ihtsdo.ttk.api.uuid.UuidT5Generator;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyChangeEvent;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.security.NoSuchAlgorithmException;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kec
 */
public final class ConceptCB extends CreateOrAmendBlueprint {
   public static final UUID conceptSpecNamespace =
      UUID.fromString("620d1f30-5285-11e0-b8af-0800200c9a66");
   private List<String>   fsns                 = new ArrayList<>();
   private List<String>   prefNames            = new ArrayList<>();
   private boolean        initialCaseSensitive = false;
   private List<DescCAB>  fsnCABs              = new ArrayList<>();
   private List<DescCAB>  prefCABs             = new ArrayList<>();
   private List<DescCAB>  descCABs             = new ArrayList<>();
   private List<RelCAB>   relCABs              = new ArrayList<>();
   private List<MediaCAB> mediaCABs            = new ArrayList<>();
   private UUID           usRefexUuid          =
      SnomedMetadataRf2.US_ENGLISH_REFSET_RF2.getUuids()[0];
   private UUID gbRefexUuid =
      SnomedMetadataRf2.GB_ENGLISH_REFSET_RF2.getUuids()[0];
   private Collection<UUID> parents = new TreeSet<UUID>() {
      @Override
      public boolean add(UUID e) {
         boolean result = super.add(e);

         comupteComponentUuid();

         return result;
      }
      @Override
      public boolean addAll(Collection<? extends UUID> clctn) {
         boolean result = super.addAll(clctn);

         comupteComponentUuid();

         return result;
      }
      @Override
      public boolean remove(Object o) {
         boolean result = super.remove(o);

         comupteComponentUuid();

         return result;
      }
      @Override
      public boolean removeAll(Collection<?> clctn) {
         boolean result = super.removeAll(clctn);

         comupteComponentUuid();

         return result;
      }
   };
   private boolean   defined = false;
   private String    fullySpecifiedName;
   private String    preferredName;
   private String    lang;
   private UUID      isaType;
   private boolean   annotation;
   private ConAttrAB conAttr;

   public ConceptCB(ConceptVersionBI cv, UUID newConceptUuid)
           throws IOException, ContradictionException, InvalidCAB {
      super(null, cv, cv.getViewCoordinate(),
            Ts.get().getUuidPrimordialForNid(
               cv.getConAttrsActive().getModuleNid()));
      pcs.addPropertyChangeListener(this);

      UUID uuid = getComponentUuid();

      if (cv.getConAttrsActive() != null) {
         defined = cv.getConAttrsActive().isDefined();
      }

      for (DescriptionVersionBI dv : cv.getFsnDescsActive()) {
         fsns.add(dv.getText());

         DescCAB fsnBp = dv.makeBlueprint(cv.getViewCoordinate());

         fsnCABs.add(fsnBp);
         descCABs.add(fsnBp);
         fsnBp.getAnnotationBlueprints();
      }

      for (DescriptionVersionBI dv : cv.getPrefDescsActive()) {
         prefNames.add(dv.getText());

         DescCAB prefBp = dv.makeBlueprint(cv.getViewCoordinate());

         prefCABs.add(prefBp);
         descCABs.add(prefBp);
         prefBp.getAnnotationBlueprints();
      }

      for (DescriptionVersionBI dv : cv.getDescsActive()) {
         if (cv.getFsnDescsActive().contains(dv)
                 || cv.getPrefDescsActive().contains(dv)) {
            continue;
         }

         DescCAB descBp = dv.makeBlueprint(cv.getViewCoordinate());

         descCABs.add(descBp);
         descBp.getAnnotationBlueprints();
      }

      for (RelationshipVersionBI rv : cv.getRelsOutgoingActive()) {
         if ((rv.getCharacteristicNid()
                 == SnomedMetadataRf1.INFERRED_DEFINING_CHARACTERISTIC_TYPE_RF1
                    .getLenient().getNid()) || (rv.getCharacteristicNid()
                       == SnomedMetadataRf1.DEFINING_CHARACTERISTIC_TYPE_RF1
                          .getLenient().getNid()) || (rv.getCharacteristicNid()
                             == SnomedMetadataRf2.INFERRED_RELATIONSHIP_RF2
                                .getLenient().getNid())) {
            continue;
         }

         RelCAB relBp = rv.makeBlueprint(cv.getViewCoordinate());

         relCABs.add(relBp);
         relBp.getAnnotationBlueprints();
      }

      for (MediaVersionBI mv : cv.getMediaActive()) {
         MediaCAB mediaBp = mv.makeBlueprint(cv.getViewCoordinate());

         mediaCABs.add(mediaBp);
         mediaBp.getAnnotationBlueprints();
      }

      this.setComponentUuid(newConceptUuid);
   }

   public ConceptCB(List<String> fullySpecifiedNames,
                    List<String> preferredNames, LANG_CODE lang, UUID isaType,
                    UUID moduleUuid, UUID... parents)
           throws IOException, InvalidCAB, ContradictionException {
      super(null, null, null, moduleUuid);
      this.fsns      = fullySpecifiedNames;
      this.prefNames = preferredNames;
      this.lang      = lang.getFormatedLanguageCode();
      this.isaType   = isaType;

      if (parents != null) {
         this.parents.addAll(Arrays.asList(parents));
      }

      pcs.addPropertyChangeListener(this);
      comupteComponentUuid();
   }

   public ConceptCB(String fullySpecifiedName, String preferredName,
                    LANG_CODE lang, UUID isaType, UUID moduleUuid,
                    UUID... parents)
           throws IOException, InvalidCAB, ContradictionException {
      super(null, null, null, moduleUuid);
      this.fsns.add(fullySpecifiedName);
      this.fullySpecifiedName =
         fullySpecifiedName;    // @akf todo: these should be removed when NewConcept, etc. is upated
      this.prefNames.add(preferredName);
      this.preferredName =
         preferredName;    // @akf todo: these should be removed when NewConcept, etc. is upated
      this.lang    = lang.getFormatedLanguageCode();
      this.isaType = isaType;

      if (parents != null) {
         this.parents.addAll(Arrays.asList(parents));
      }

      pcs.addPropertyChangeListener(this);
      comupteComponentUuid();
   }

   /**
    * Adds an fsn.
    *
    * @param fsnBp blueprint of fsn
    * @param dialect language code of fsn dialect
    */
   public ConceptCB addFsn(DescCAB fsnBp, LANG_CODE dialect)
           throws NoSuchAlgorithmException, UnsupportedEncodingException,
                  IOException, InvalidCAB, ContradictionException {
      fsns.add(fsnBp.getText());
      addFsnDialectRefexes(fsnBp, dialect);
      this.recomputeUuid();

      return this;
   }

   private void addFsnDialectRefexes(DescCAB fsnBp, LANG_CODE dialect)
           throws NoSuchAlgorithmException, UnsupportedEncodingException,
                  IOException, InvalidCAB, ContradictionException {
      RefexCAB usAnnot;
      RefexCAB gbAnnot;

      if (dialect == LANG_CODE.EN) {
         usAnnot = new RefexCAB(TK_REFEX_TYPE.CID, fsnBp.getComponentUuid(),
                                usRefexUuid, null, null, getModuleUuid());
         usAnnot.put(RefexCAB.RefexProperty.CNID1,
                     SnomedMetadataRfx.getDESC_PREFERRED_NID());
         gbAnnot = new RefexCAB(TK_REFEX_TYPE.CID, fsnBp.getComponentUuid(),
                                gbRefexUuid, null, null, getModuleUuid());
         gbAnnot.put(RefexCAB.RefexProperty.CNID1,
                     SnomedMetadataRfx.getDESC_PREFERRED_NID());
         fsnBp.setAnnotationBlueprint(usAnnot);
         fsnBp.setAnnotationBlueprint(gbAnnot);
      } else if (dialect == LANG_CODE.EN_US) {
         usAnnot = new RefexCAB(TK_REFEX_TYPE.CID, fsnBp.getComponentUuid(),
                                usRefexUuid, null, null, getModuleUuid());
         usAnnot.put(RefexCAB.RefexProperty.CNID1,
                     SnomedMetadataRfx.getDESC_PREFERRED_NID());
         fsnBp.setAnnotationBlueprint(usAnnot);
      } else if (dialect == LANG_CODE.EN_GB) {
         throw new InvalidCAB(
             "<html>Currently FSNs are only allowed for en or en-us. "
             + "<br>Please add gb dialect variants as preferred terms.");
      } else {
         throw new InvalidCAB("Dialect not supported: "
                              + dialect.getFormatedLanguageCode());
      }
   }

   private void addPrefNameDialectRefexes(DescCAB prefBp, LANG_CODE dialect)
           throws NoSuchAlgorithmException, UnsupportedEncodingException,
                  IOException, InvalidCAB, ContradictionException {
      RefexCAB usAnnot;
      RefexCAB gbAnnot;

      if (dialect == LANG_CODE.EN) {
         usAnnot = new RefexCAB(TK_REFEX_TYPE.CID, prefBp.getComponentUuid(),
                                usRefexUuid, null, null, getModuleUuid());
         usAnnot.put(RefexCAB.RefexProperty.CNID1,
                     SnomedMetadataRfx.getDESC_PREFERRED_NID());
         gbAnnot = new RefexCAB(TK_REFEX_TYPE.CID, prefBp.getComponentUuid(),
                                gbRefexUuid, null, null, getModuleUuid());
         gbAnnot.put(RefexCAB.RefexProperty.CNID1,
                     SnomedMetadataRfx.getDESC_PREFERRED_NID());
         prefBp.setAnnotationBlueprint(usAnnot);
         prefBp.setAnnotationBlueprint(gbAnnot);
      } else if (dialect == LANG_CODE.EN_US) {
         usAnnot = new RefexCAB(TK_REFEX_TYPE.CID, prefBp.getComponentUuid(),
                                usRefexUuid, null, null, getModuleUuid());
         usAnnot.put(RefexCAB.RefexProperty.CNID1,
                     SnomedMetadataRfx.getDESC_PREFERRED_NID());
         prefBp.setAnnotationBlueprint(usAnnot);
      } else if (dialect == LANG_CODE.EN_GB) {
         gbAnnot = new RefexCAB(TK_REFEX_TYPE.CID, prefBp.getComponentUuid(),
                                gbRefexUuid, null, null, getModuleUuid());
         gbAnnot.put(RefexCAB.RefexProperty.CNID1,
                     SnomedMetadataRfx.getDESC_PREFERRED_NID());
         prefBp.setAnnotationBlueprint(gbAnnot);
      } else {
         throw new InvalidCAB("Dialect not supported: "
                              + dialect.getFormatedLanguageCode());
      }
   }

   /**
    * Adds a new preferred name.
    *
    * @param prefBp blueprint of pref name
    * @param dialect language code of pref name dialect
    */
   public ConceptCB addPreferredName(DescCAB prefBp, LANG_CODE dialect)
           throws NoSuchAlgorithmException, UnsupportedEncodingException,
                  IOException, InvalidCAB, ContradictionException {
      prefNames.add(prefBp.getText());
      this.recomputeUuid();
      addPrefNameDialectRefexes(prefBp, dialect);

      return this;
   }

   public final void comupteComponentUuid() throws RuntimeException {
      try {
         StringBuilder sb    = new StringBuilder();
         List<String>  descs = new ArrayList<>();

         descs.addAll(fsns);
         descs.addAll(prefNames);
         java.util.Collections.sort(descs);

         for (String desc : descs) {
            sb.append(desc);
         }

         setComponentUuid(UuidT5Generator.get(conceptSpecNamespace,
                 sb.toString()));
      } catch (IOException | NoSuchAlgorithmException ex) {
         throw new RuntimeException(ex);
      }
   }

   public DescCAB makeFsnCAB()
           throws IOException, InvalidCAB, ContradictionException {

      // get rf1/rf2 concepts
      UUID fsnUuid =
         SnomedMetadataRf2.FULLY_SPECIFIED_NAME_RF2.getUuids()[0];

      return new DescCAB(getComponentUuid(), fsnUuid,
                         LANG_CODE.getLangCode(lang), getFullySpecifiedName(),
                         isInitialCaseSensitive(), getModuleUuid());
   }

   public DescCAB makePreferredCAB()
           throws IOException, InvalidCAB, ContradictionException {

      // get rf1/rf2 concepts
      UUID synUuid = SnomedMetadataRf2.SYNONYM_RF2.getUuids()[0];

      return new DescCAB(getComponentUuid(), synUuid,    // from PREFERRED
                         LANG_CODE.getLangCode(lang), getPreferredName(),
                         isInitialCaseSensitive(), getModuleUuid());
   }

   @Override
   public void propertyChange(PropertyChangeEvent pce) {
      try {
         recomputeUuid();
      } catch (NoSuchAlgorithmException | InvalidCAB | ContradictionException
               | IOException ex) {
         Logger.getLogger(CreateOrAmendBlueprint.class.getName()).log(
             Level.SEVERE, null, ex);
      }
   }

   @Override
   public void recomputeUuid()
           throws NoSuchAlgorithmException, UnsupportedEncodingException,
                  IOException, InvalidCAB, ContradictionException {
      for (DescCAB descBp : getDescCABs()) {
         descBp.setConceptUuid(getComponentUuid());
         descBp.recomputeUuid();
      }

      for (RelCAB relBp : getRelCABs()) {
         relBp.setSourceUuid(getComponentUuid());
         relBp.recomputeUuid();
      }

      for (MediaCAB mediaBp : getMediaCABs()) {
         mediaBp.setConceptUuid(getComponentUuid());
         mediaBp.recomputeUuid();
      }
   }

   /**
    * Updates an existing fsn.
    *
    * @param newFsn text to be updated
    * @param fsnBp blueprint of fsn
    * @param dialect language code of fsn dialect, leave null if dialect isn't
    * changing
    */
   public void updateFsn(String newFsn, DescCAB fsnBp, LANG_CODE dialect)
           throws NoSuchAlgorithmException, UnsupportedEncodingException,
                  IOException, InvalidCAB, ContradictionException {
      String oldText = fsnBp.getText();

      fsns.remove(oldText);
      fsns.add(newFsn);
      this.recomputeUuid();
      fsnBp.setText(newFsn);

      if (dialect != null) {
         List<RefexCAB> annotationBlueprints = fsnBp.getAnnotationBlueprints();

         for (RefexCAB annot : annotationBlueprints) {
            if ((annot.getRefexColllectionUuid() == usRefexUuid)
                    || (annot.getRefexColllectionUuid() == gbRefexUuid)) {
               annotationBlueprints.remove(annot);
            }
         }

         fsnBp.replaceAnnotationBlueprints(annotationBlueprints);
         addFsnDialectRefexes(fsnBp, dialect);
      }
   }

   /**
    * Updates an existing preferred name.
    *
    * @param newPreferredName text to be updated
    * @param prefBp blueprint of pref name
    * @param dialect language code of pref name dialect, leave null if dialect
    * isn't changing
    */
   public void updatePreferredName(String newPreferredName, DescCAB prefBp,
                                   LANG_CODE dialect)
           throws NoSuchAlgorithmException, UnsupportedEncodingException,
                  IOException, InvalidCAB, ContradictionException {
      String oldText = prefBp.getText();

      prefNames.remove(oldText);
      prefNames.add(newPreferredName);
      this.recomputeUuid();
      prefBp.setText(newPreferredName);

      if (dialect != null) {
         List<RefexCAB> annotationBlueprints = prefBp.getAnnotationBlueprints();

         for (RefexCAB annot : annotationBlueprints) {
            if ((annot.getRefexColllectionUuid() == usRefexUuid)
                    || (annot.getRefexColllectionUuid() == gbRefexUuid)) {
               annotationBlueprints.remove(annot);
            }
         }

         prefBp.replaceAnnotationBlueprints(annotationBlueprints);
         addPrefNameDialectRefexes(prefBp, dialect);
      }
   }

   public ConAttrAB getConAttrAB() throws IOException, InvalidCAB, ContradictionException {
       if (conAttr == null) {
           conAttr = new ConAttrAB(getComponentUuid(), defined, getModuleUuid());
       }
      return conAttr;
   }

   public List<DescCAB> getDescCABs() {
      return descCABs;
   }

   public List<DescCAB> getFsnCABs()
           throws IOException, InvalidCAB, ContradictionException {
      if (fsnCABs.isEmpty()) {
         fsnCABs.add(makeFsnCAB());
      }

      return fsnCABs;
   }

   public String getFullySpecifiedName() {    // @akf todo : update to use set when NewConcept, etc. has been updated
      return fullySpecifiedName;
   }

   public UUID getIsaType() {
      return isaType;
   }

   public String getLang() {
      return lang;
   }

   public List<MediaCAB> getMediaCABs() {
      return mediaCABs;
   }

   public List<RelCAB> getParentCABs()
           throws IOException, InvalidCAB, ContradictionException {
      List<RelCAB> parentCabs = new ArrayList<>(getParents().size());

      for (UUID parentUuid : parents) {
         RelCAB parent = new RelCAB(getComponentUuid(), isaType, parentUuid, 0,
                                    TkRelType.STATED_HIERARCHY,
                                    getModuleUuid());

         parentCabs.add(parent);
      }

      return parentCabs;
   }

   public Collection<UUID> getParents() {
      return parents;
   }

   public List<DescCAB> getPrefCABs()
           throws IOException, InvalidCAB, ContradictionException {
      if (prefCABs.isEmpty()) {
         prefCABs.add(makePreferredCAB());
      }

      return prefCABs;
   }

   public String getPreferredName() {    // @akf todo : update to use set when NewConcept, etc. has been updated
      return preferredName;
   }

   public List<RelCAB> getRelCABs()
           throws IOException, InvalidCAB, ContradictionException {
      if (relCABs.isEmpty()) {
         List<RelCAB> parentCABs = getParentCABs();

         for (RelCAB parentBp : parentCABs) {
            relCABs.add(parentBp);
         }
      }

      return relCABs;
   }

   public boolean isAnnotation() {
      return annotation;
   }

   public boolean isDefined() {
      return defined;
   }

   public boolean isInitialCaseSensitive() {
      return initialCaseSensitive;
   }

   public void setAnnotation(boolean annotation) {
      this.annotation = annotation;
   }

   public void setConAttrAB(ConAttrAB conAttrBp) {
      this.conAttr = conAttrBp;
   }

   public void setDefined(boolean defined) {
      this.defined = defined;
   }

   public void setDescCABs(DescCAB descBp) {
      descCABs.add(descBp);
   }

   public void setFsnCABs(DescCAB fsnBp) {
      fsnCABs.add(fsnBp);
   }

   public void setFullySpecifiedName(String fullySpecifiedName) {
      this.fullySpecifiedName = fullySpecifiedName;
      comupteComponentUuid();
   }

   public void setInitialCaseSensitive(boolean initialCaseSensitive) {
      this.initialCaseSensitive = initialCaseSensitive;
   }

   public void setIsaType(UUID isaType) {
      this.isaType = isaType;
      comupteComponentUuid();
   }

   public void setLang(String lang) {
      this.lang = lang;
      comupteComponentUuid();
   }

   public void setMediaCABs(MediaCAB mediaBp) {
      mediaCABs.add(mediaBp);
   }

   public void setPrefCABs(DescCAB prefBp) {
      prefCABs.add(prefBp);
   }

   public void setPreferredName(String preferredName) {
      this.preferredName = preferredName;
      comupteComponentUuid();
   }

   public void setRelCABs(RelCAB relBp) {
      relCABs.add(relBp);
   }
}
