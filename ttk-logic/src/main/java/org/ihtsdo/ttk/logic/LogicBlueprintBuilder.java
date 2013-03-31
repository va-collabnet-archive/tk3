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
import org.ihtsdo.ttk.api.TerminologyBuilderBI;
import org.ihtsdo.ttk.api.blueprint.BlueprintBuilder;
import org.ihtsdo.ttk.api.blueprint.InvalidBlueprintException;
import org.ihtsdo.ttk.api.blueprint.RefexCAB;
import org.ihtsdo.ttk.api.blueprint.RefexProperty;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.spec.ConceptSpec;
import org.ihtsdo.ttk.auxiliary.taxonomies.DescriptionLogicBinding;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.Stack;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author kec
 */
public class LogicBlueprintBuilder extends BlueprintBuilder {

   /** Field description */
   public static boolean verbose = false;

   /** Field description */
   private Stack<RefexCAB> nodes = new Stack<>();

   /** Field description */
   private AtomicInteger count = new AtomicInteger(0);

   /** Field description */
   private AtomicInteger dots = new AtomicInteger(0);

   /** Field description */
   private UUID refexExtensionUuid;

   /** Field description */
   private UUID conceptUuid;

   /**
    * Constructs ...
    *
    *
    * @param refexExtensionUuid
    * @param vc
    * @param moduleUuid
    */
   public LogicBlueprintBuilder(UUID refexExtensionUuid, ViewCoordinate vc, UUID moduleUuid) {
      super(vc, moduleUuid);
      this.refexExtensionUuid = refexExtensionUuid;
   }

   /**
    * Add a segment (an newEdge and node) to the definition tree.
    *
    *
    * @param originNode
    * @param specs
    *
    * @return terminal node blueprint of this segment.
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidBlueprintException
    */
   public RefexCAB add(RefexCAB originNode, ConceptSpec... specs)
           throws IOException, InvalidBlueprintException, ContradictionException {
      return addSegment(originNode, true, specs);
   }

   /**
    * Method description
    *
    *
    * @param originNode
    * @param nids
    *
    * @return
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidBlueprintException
    */
   public RefexCAB add(RefexCAB originNode, int... nids)
           throws IOException, InvalidBlueprintException, ContradictionException {
      return addSegment(originNode, true, nids);
   }

   /**
    * Method description
    *
    *
    * @param root
    * @param typeNid
    * @param destinationNid
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidBlueprintException
    */
   public void addExtensionalRole(RefexCAB root, int typeNid, int destinationNid)
           throws IOException, InvalidBlueprintException, ContradictionException {
      RefexCAB role = addSegment(root, true, DescriptionLogicBinding.EXISTENTIAL_RESTRICTION, typeNid);

      add(role, destinationNid);
   }

   /**
    * Method description
    *
    *
    * @param originNode
    * @param truth
    * @param specs
    *
    * @return terminal node blueprint of this segment.
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidBlueprintException
    */
   public RefexCAB addSegment(RefexCAB originNode, boolean truth, ConceptSpec... specs)
           throws IOException, InvalidBlueprintException, ContradictionException {
      RefexCAB destinationNode = newNode(specs);
      RefexCAB edge            = newEdge(originNode, truth, destinationNode);

      originNode.getAnnotationBlueprints().add(edge);

      return destinationNode;
   }

   /**
    * Method description
    *
    *
    * @param originNode
    * @param truth
    * @param nids
    *
    * @return
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidBlueprintException
    */
   public RefexCAB addSegment(RefexCAB originNode, boolean truth, int... nids)
           throws IOException, InvalidBlueprintException, ContradictionException {
      RefexCAB destinationNode = newNode(nids);
      RefexCAB edge            = newEdge(originNode, truth, destinationNode);

      originNode.getAnnotationBlueprints().add(edge);

      return destinationNode;
   }

   /**
    * Method description
    *
    *
    * @param originNode
    * @param truth
    * @param restricionType
    * @param destinationNid
    *
    * @return
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidBlueprintException
    */
   public RefexCAB addSegment(RefexCAB originNode, boolean truth, ConceptSpec restricionType,
                              int destinationNid)
           throws IOException, InvalidBlueprintException, ContradictionException {
      RefexCAB destinationNode = newNode(restricionType, destinationNid);
      RefexCAB edge            = newEdge(originNode, truth, destinationNode);

      originNode.getAnnotationBlueprints().add(edge);

      return destinationNode;
   }

   /**
    * Method description
    *
    *
    * @param builder
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidBlueprintException
    */
   public void build(TerminologyBuilderBI builder)
           throws IOException, InvalidBlueprintException, ContradictionException {
      while (!nodes.isEmpty()) {
         count.incrementAndGet();

         if (count.get() % 1000 == 0) {
            System.out.print(".");
            System.out.flush();
            dots.incrementAndGet();

            if (dots.get() > 80) {
               dots.set(0);
               System.out.println();
               System.out.print(count.get() + ": ");
            }
         }

         RefexCAB blueprint = nodes.pop();

         // System.out.println("Constructing: " + blueprint);
         builder.construct(blueprint);
      }
   }

   /**
    * Create a new newEdge for a DefinitionTree. <code>truth</code> defaults to true.
    *
    *
    * @param originNode
    * @param destinationNode
    *
    * @return
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidBlueprintException
    */
   public RefexCAB newEdge(RefexCAB originNode, RefexCAB destinationNode)
           throws IOException, InvalidBlueprintException, ContradictionException {
      return newEdge(originNode, true, destinationNode);
   }

   /**
    * Create a new newEdge for a DefinitionTree.
    *
    *
    * @param originNode
    * @param truth
    * @param destinationNode
    *
    * @return
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidBlueprintException
    */
   public RefexCAB newEdge(RefexCAB originNode, boolean truth, RefexCAB destinationNode)
           throws IOException, InvalidBlueprintException, ContradictionException {
      RefexCAB newEdge = new RefexCAB(TK_REFEX_TYPE.CID_BOOLEAN, originNode.getMemberUUID(),
                                      refexExtensionUuid, UUID.randomUUID(), null, vc, moduleUuid);

      newEdge.put(RefexProperty.ENCLOSING_CONCEPT_ID, conceptUuid);
      newEdge.put(RefexProperty.COMPONENT_EXTENSION_1_ID, destinationNode.getMemberUuid());
      newEdge.put(RefexProperty.BOOLEAN_EXTENSION_1, truth);
      originNode.getAnnotationBlueprints().add(newEdge);

      if (verbose) {
         System.out.println(newEdge);
      }

      return newEdge;
   }

   /**
    * Method description
    *
    *
    * @param specs
    *
    * @return
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidBlueprintException
    */
   public RefexCAB newNode(ConceptSpec... specs)
           throws IOException, InvalidBlueprintException, ContradictionException {
      RefexCAB newNode;

      switch (specs.length) {
      case 1 :
         newNode = newNode(TK_REFEX_TYPE.CID);
         newNode.put(RefexProperty.COMPONENT_EXTENSION_1_ID, specs[0]);
         nodes.push(newNode);

         if (verbose) {
            System.out.println(newNode);
         }

         return newNode;

      case 2 :
         newNode = newNode(TK_REFEX_TYPE.CID_CID);
         newNode.put(RefexProperty.COMPONENT_EXTENSION_1_ID, specs[0]);
         newNode.put(RefexProperty.COMPONENT_EXTENSION_2_ID, specs[1]);

         if (verbose) {
            System.out.println(newNode);
         }

         nodes.push(newNode);

         return newNode;

      case 3 :
         newNode = newNode(TK_REFEX_TYPE.CID_CID_CID);
         newNode.put(RefexProperty.COMPONENT_EXTENSION_1_ID, specs[0]);
         newNode.put(RefexProperty.COMPONENT_EXTENSION_2_ID, specs[1]);
         newNode.put(RefexProperty.COMPONENT_EXTENSION_3_ID, specs[2]);

         if (verbose) {
            System.out.println(newNode);
         }

         nodes.push(newNode);

         return newNode;

      default :
         throw new InvalidBlueprintException("Invalid spec number: " + specs);
      }
   }

   /**
    * Method description
    *
    *
    * @param spec
    *
    * @return
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidBlueprintException
    */
   public RefexCAB newNode(ConceptSpec spec)
           throws IOException, InvalidBlueprintException, ContradictionException {
      return newNode(new ConceptSpec[] { spec });
   }

   /**
    * Method description
    *
    *
    * @param specs
    *
    * @return
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidBlueprintException
    */
   public RefexCAB newNode(int... specs)
           throws IOException, InvalidBlueprintException, ContradictionException {
      RefexCAB newNode;

      switch (specs.length) {
      case 1 :
         newNode = newNode(TK_REFEX_TYPE.CID);
         newNode.put(RefexProperty.COMPONENT_EXTENSION_1_ID, specs[0]);
         nodes.push(newNode);

         if (verbose) {
            System.out.println(newNode);
         }

         return newNode;

      case 2 :
         newNode = newNode(TK_REFEX_TYPE.CID_CID);
         newNode.put(RefexProperty.COMPONENT_EXTENSION_1_ID, specs[0]);
         newNode.put(RefexProperty.COMPONENT_EXTENSION_2_ID, specs[1]);
         nodes.push(newNode);

         if (verbose) {
            System.out.println(newNode);
         }

         return newNode;

      case 3 :
         newNode = newNode(TK_REFEX_TYPE.CID_CID_CID);
         newNode.put(RefexProperty.COMPONENT_EXTENSION_1_ID, specs[0]);
         newNode.put(RefexProperty.COMPONENT_EXTENSION_2_ID, specs[1]);
         newNode.put(RefexProperty.COMPONENT_EXTENSION_3_ID, specs[2]);
         nodes.push(newNode);

         if (verbose) {
            System.out.println(newNode);
         }

         return newNode;

      default :
         throw new InvalidBlueprintException("Invalid spec number: " + specs);
      }
   }

   /**
    * Method description
    *
    *
    * @param refexType
    *
    * @return
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidBlueprintException
    */
   public RefexCAB newNode(TK_REFEX_TYPE refexType)
           throws IOException, InvalidBlueprintException, ContradictionException {
      RefexCAB newNode = new RefexCAB(refexType, conceptUuid, refexExtensionUuid, UUID.randomUUID(), null,
                                      vc, moduleUuid);

      newNode.put(RefexProperty.ENCLOSING_CONCEPT_ID, conceptUuid);
      nodes.push(newNode);

      if (verbose) {
         System.out.println(newNode);
      }

      return newNode;
   }

   /**
    * Method description
    *
    *
    * @param spec
    * @param nids
    *
    * @return
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidBlueprintException
    */
   public RefexCAB newNode(ConceptSpec spec, int... nids)
           throws IOException, InvalidBlueprintException, ContradictionException {
      RefexCAB newNode;

      switch (nids.length) {
      case 1 :
         newNode = newNode(TK_REFEX_TYPE.CID_CID);
         newNode.put(RefexProperty.COMPONENT_EXTENSION_1_ID, spec);
         newNode.put(RefexProperty.COMPONENT_EXTENSION_2_ID, nids[0]);
         nodes.push(newNode);

         if (verbose) {
            System.out.println(newNode);
         }

         return newNode;

      case 2 :
         newNode = newNode(TK_REFEX_TYPE.CID_CID_CID);
         newNode.put(RefexProperty.COMPONENT_EXTENSION_1_ID, spec);
         newNode.put(RefexProperty.COMPONENT_EXTENSION_2_ID, nids[0]);
         newNode.put(RefexProperty.COMPONENT_EXTENSION_3_ID, nids[1]);
         nodes.push(newNode);

         if (verbose) {
            System.out.println(newNode);
         }

         return newNode;

      default :
         throw new InvalidBlueprintException("Invalid nid number: " + nids);
      }
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public UUID getConceptUuid() {
      return conceptUuid;
   }

   /**
    * Method description
    *
    *
    * @param conceptUuid
    */
   public void setConceptUuid(UUID conceptUuid) {
      this.conceptUuid = conceptUuid;
   }
}
