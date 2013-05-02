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
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.concept.ConceptVersionBI;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid.RefexNidVersionBI;
import org.ihtsdo.ttk.api.refex.type_nid_boolean.RefexNidBooleanVersionBI;
import org.ihtsdo.ttk.auxiliary.taxonomies.DescriptionLogicBinding;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kec
 */
public class DefinitionTree {

   /** Field description */
   private static final String indent = "    ";

   /** Field description */
   private Map<Integer, RefexVersionBI> nodes = new HashMap<>();

   /** Field description */
   private RefexNidVersionBI definitionRoot = null;

   /** Field description */
   private ConceptVersionBI cv;

   /** Field description */
   private ViewCoordinate vc;

   /** Field description */
   private int refexExtensionNid;

   /**
    * Constructs ...
    *
    *
    * @param cv
    * @param refexExtensionNid
    *
    * @throws ContradictionException
    * @throws IOException
    */
   public DefinitionTree(ConceptVersionBI cv, int refexExtensionNid)
           throws IOException, ContradictionException {
      this.cv                = cv;
      this.vc                = cv.getViewCoordinate();
      this.refexExtensionNid = refexExtensionNid;

      for (RefexVersionBI<?> annotation :
          cv.getConceptAttributesActive().getCurrentAnnotationMembers(cv.getViewCoordinate())) {
         if (annotation.getRefexExtensionNid() == refexExtensionNid) {
            nodes.put(annotation.getNid(), annotation);

            if ((definitionRoot == null) && (annotation instanceof RefexNidVersionBI)) {
               if (((RefexNidVersionBI) annotation).getNid1()
                   == DescriptionLogicBinding.DEFINITION_ROOT.getNid(cv.getViewCoordinate())) {
                  definitionRoot = (RefexNidVersionBI) annotation;
               }
            }
         }
      }
   }

   /**
    * Method description
    *
    *
    * @throws ContradictionException
    * @throws IOException
    */
   public void dfsPrint() throws IOException, ContradictionException {
      dfsPrint(true, definitionRoot, 1);
      System.out.println();
   }

   /**
    * Method description
    *
    *
    * @param truth
    * @param node
    * @param depth
    *
    * @throws ContradictionException
    * @throws IOException
    */
   private void dfsPrint(boolean truth, RefexVersionBI node, int depth)
           throws IOException, ContradictionException {
      System.out.println();

      for (int i = 0; i < depth; i++) {
         System.out.print(indent);
      }

      if (!truth) {
         System.out.print("FALSE: ");
      }

      if (node instanceof RefexNidVersionBI) {
         System.out.print(Ts.get().getConceptVersion(vc,
             ((RefexNidVersionBI) node).getNid1()).getPreferredDescription().getText());
      } else {
         System.out.print(node);
      }

      Collection<? extends RefexVersionBI<?>> edges = node.getCurrentAnnotationMembers(vc);

      for (RefexVersionBI<?> edge : edges) {
         if ((edge.getRefexExtensionNid() == refexExtensionNid)
             && (edge instanceof RefexNidBooleanVersionBI)) {
            RefexNidBooleanVersionBI theEdge = (RefexNidBooleanVersionBI) edge;

            dfsPrint(theEdge.getBoolean1(), nodes.get(theEdge.getNid1()), depth + 1);
         }
      }
   }
}
