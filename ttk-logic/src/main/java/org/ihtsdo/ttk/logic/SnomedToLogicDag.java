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



package org.ihtsdo.ttk.logic;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TK_REFEX_TYPE;
import org.ihtsdo.ttk.api.blueprint.AnnotationBlueprintBuilder;
import org.ihtsdo.ttk.api.blueprint.InvalidBlueprintException;
import org.ihtsdo.ttk.api.blueprint.RefexCAB;
import org.ihtsdo.ttk.api.blueprint.RefexProperty;
import org.ihtsdo.ttk.api.concept.ConceptVersionBI;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.auxiliary.taxonomies.DescriptionLogicBinding;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;


/**
 *
 * @author kec
 */
public class SnomedToLogicDag extends AnnotationBlueprintBuilder {

   /**
    *
    * @param vc
    */
   public SnomedToLogicDag(ViewCoordinate vc) {
      super(DescriptionLogicBinding.EL_PLUS_PLUS.getUuids()[0], vc,
            DescriptionLogicBinding.DL_MODULE.getUuids()[0], true);
   }

   /**
    *
    * @param cv
    * @throws IOException
    * @throws ContradictionException
    * @throws InvalidBlueprintException
    */
   public void convert(ConceptVersionBI cv)
           throws IOException, ContradictionException, InvalidBlueprintException {
      pushReferencedComponent(cv.getPrimUuid());

      boolean defined = (cv.getConAttrsActive() != null) && cv.getConAttrsActive().isDefined();

      // create sufficient set node
      if (defined) {
         newAnnotation(TK_REFEX_TYPE.CID).put(RefexProperty.COMPONENT_EXTENSION_1_ID,
                       DescriptionLogicBinding.SUFFICIENT_SET.getUuids()[0]);
      } else {
         newAnnotation(TK_REFEX_TYPE.CID).put(RefexProperty.COMPONENT_EXTENSION_1_ID,
                       DescriptionLogicBinding.NECESSARY_SET.getUuids()[0]);
      }

      RefexCAB setNode = current();

      // link from the concept to the sufficient/necessary set node.
      newAnnotation(TK_REFEX_TYPE.CID).put(RefexProperty.COMPONENT_EXTENSION_1_ID, last().getMemberUuid());
      current().getAnnotationBlueprints().add(last());
      pushReferencedComponent(setNode.getMemberUuid());

      // Make the roles, etc...
   }
}
