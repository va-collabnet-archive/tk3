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

import org.ihtsdo.ttk.api.ConceptFetcherBI;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.NidBitSetBI;
import org.ihtsdo.ttk.api.ProcessUnfetchedConceptDataBI;
import org.ihtsdo.ttk.api.TerminologyBuilderBI;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.blueprint.InvalidBlueprintException;
import org.ihtsdo.ttk.api.blueprint.RefexCAB;
import org.ihtsdo.ttk.api.concept.ConceptVersionBI;
import org.ihtsdo.ttk.api.coordinate.EditCoordinate;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.metadata.binding.Snomed;
import org.ihtsdo.ttk.api.metadata.binding.SnomedMetadataRf2;
import org.ihtsdo.ttk.api.relationship.RelationshipVersionBI;
import org.ihtsdo.ttk.api.relationship.group.RelGroupVersionBI;
import org.ihtsdo.ttk.auxiliary.taxonomies.DescriptionLogicBinding;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author kec
 */
public class SnomedToLogicTree extends LogicBlueprintBuilder implements ProcessUnfetchedConceptDataBI {

   /** Field description */
   TerminologyBuilderBI builder;
   
   /**
    *
    * @param vc
    * @param ec
    */
   public SnomedToLogicTree(ViewCoordinate vc, EditCoordinate ec) {
      super(DescriptionLogicBinding.EL_PLUS_PLUS.getUuids()[0], vc,
            DescriptionLogicBinding.DL_MODULE.getUuids()[0]);
      builder = Ts.get().getTerminologyBuilder(ec, vc);
   }

   /**
    * Method description
    *
    *
    * @return
    */
   @Override
   public boolean continueWork() {
      return true;
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
      setConceptUuid(cv.getPrimUuid());

      RefexCAB root    = newNode(DescriptionLogicBinding.DEFINITION_ROOT);
      boolean  defined = (cv.getConAttrsActive() != null) && cv.getConAttrsActive().isDefined();
      RefexCAB set;

      if (defined) {

         // create sufficient set node
         set = add(root, DescriptionLogicBinding.SUFFICIENT_SET);
      } else {

         // create necessary set node
         set = add(root, DescriptionLogicBinding.NECESSARY_SET);
      }

      // Make the roles, etc...
      Collection<? extends RelationshipVersionBI> rels         = cv.getRelsOutgoingActive();
      Collection<? extends RelGroupVersionBI>     relGroups    = cv.getRelGroupsActive();
      Collection<RelationshipVersionBI>           definingRels = new ArrayList<>();

      for (RelationshipVersionBI rel : rels) {
         if (SnomedMetadataRf2.STATED_RELATIONSHIP_RF2.getStrict(vc).getNid() == rel.getCharacteristicNid()) {
            definingRels.add(rel);
         }
      }

      // need to exclude the non-defining ones...
      if (definingRels.size() > 1) {
         RefexCAB and = add(set, DescriptionLogicBinding.AND);

         for (RelationshipVersionBI rel : definingRels) {
            if (vc.getIsaTypeNids().contains(rel.getTypeNid())) {
               add(and, rel.getDestinationNid());
            } else if (rel.getGroup() == 0) {
               addExtensionalRole(and, rel.getTypeNid(), rel.getDestinationNid());
            }
         }

         for (RelGroupVersionBI relGroup : relGroups) {
            RefexCAB group = add(and, DescriptionLogicBinding.ROLE_GROUP);

            for (RelationshipVersionBI rel : relGroup.getAllCurrentRelVersions()) {
               addExtensionalRole(group, rel.getTypeNid(), rel.getDestinationNid());
            }
         }
      } else {
         for (RelationshipVersionBI rel : definingRels) {
            if (vc.getIsaTypeNids().contains(rel.getTypeNid())) {
               add(set, rel.getDestinationNid());
            } else {
               throw new InvalidBlueprintException("Concept must have at least one is-a");
            }
         }
      }
   }

   /**
    * Method description
    *
    *
    * @param cNid
    * @param fetcher
    *
    * @throws Exception
    */
   @Override
   public void processUnfetchedConceptData(int cNid, ConceptFetcherBI fetcher) throws Exception {
      ConceptVersionBI cv = fetcher.fetch(vc);

      if ((cv.getConAttrsActive() != null)
          && ((cv.getConAttrsActive().getModuleNid() == Snomed.SNOMED_RELEASE_PATH.getStrict(vc).getNid())
              || (cv.getConAttrsActive().getModuleNid() == Snomed.CORE_MODULE.getStrict(vc).getNid()))) {
         convert(cv);
         build(builder);
         Ts.get().addUncommittedNoChecks(cv);
         if (verbose) {
            DefinitionTree dt = new DefinitionTree(cv, DescriptionLogicBinding.EL_PLUS_PLUS.getNid(vc));
            System.out.print("\n" + cv.getPreferredDescription().getText() + ":");
            dt.dfsPrint();
         }

      }
   }

   /**
    * Method description
    *
    *
    * @return
    *
    * @throws IOException
    */
   @Override
   public NidBitSetBI getNidSet() throws IOException {
      return Ts.get().getAllConceptNids();
   }

    @Override
    public boolean allowCancel() {
        return false;
    }

    @Override
    public String getTitle() {
        return "Converting RF2 to Logic Tree";
    }
}
