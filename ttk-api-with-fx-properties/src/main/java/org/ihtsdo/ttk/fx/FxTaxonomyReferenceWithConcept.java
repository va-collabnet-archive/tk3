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



package org.ihtsdo.ttk.fx;

//~--- non-JDK imports --------------------------------------------------------

import javafx.beans.property.SimpleObjectProperty;

import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.fx.concept.FxConcept;
import org.ihtsdo.ttk.fx.concept.component.relationship.FxRelationshipVersion;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.UUID;

/**
 *
 * @author kec
 */
public class FxTaxonomyReferenceWithConcept {
   private final SimpleObjectProperty<FxConcept>             conceptProperty             =
      new SimpleObjectProperty<>();
   private final SimpleObjectProperty<FxRelationshipVersion> relationshipVersionProperty =
      new SimpleObjectProperty<>();
   private WhichConcept whichConcept = WhichConcept.ORIGIN;

   public enum WhichConcept { ORIGIN, DESTINATION }

   public FxTaxonomyReferenceWithConcept() {}

   public FxTaxonomyReferenceWithConcept(FxRelationshipVersion rv)
           throws IOException, ContradictionException {
      relationshipVersionProperty.set(rv);
   }

   public FxTaxonomyReferenceWithConcept(FxRelationshipVersion rv, WhichConcept whichConcept)
           throws IOException, ContradictionException {
      this.whichConcept = whichConcept;
      relationshipVersionProperty.set(rv);
   }

   public SimpleObjectProperty<FxConcept> conceptProperty() {
      return conceptProperty;
   }

   public SimpleObjectProperty<FxRelationshipVersion> relationshipVersionProperty() {
      return relationshipVersionProperty;
   }

   @Override
   public String toString() {
      if (relationshipVersionProperty.get() != null) {
         switch (whichConcept) {
         case ORIGIN :
            return relationshipVersionProperty.get().getOriginReference().getText();

         case DESTINATION :
            return relationshipVersionProperty.get().getDestinationReference().getText();
         }
      }

      if (conceptProperty.get() != null) {
         return conceptProperty.get().getConceptReference().getText();
      }

      return "root";
   }

   public SimpleObjectProperty<FxComponentReference> typeReferenceProperty() {
      return relationshipVersionProperty.get().typeReferenceProperty();
   }

   public FxConcept getConcept() {
      return conceptProperty.get();
   }

   public FxRelationshipVersion getRelationshipVersion() {
      return relationshipVersionProperty.get();
   }

   public FxComponentReference getTypeReference() {
      return relationshipVersionProperty.get().getTypeReference();
   }

   public void setConcept(FxConcept concept) {
      conceptProperty.set(concept);
   }

   public void setRelationshipVersion(FxRelationshipVersion fxRelationshipVersion) {
      relationshipVersionProperty.set(fxRelationshipVersion);
   }

   public void setTypeReference(FxComponentReference typeRef) {
      relationshipVersionProperty.get().typeReferenceProperty().set(typeRef);
   }
}
