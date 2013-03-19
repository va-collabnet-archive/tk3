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



package org.ihtsdo.ttk.api.blueprint;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TK_REFEX_TYPE;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.Stack;
import java.util.UUID;

/**
 *
 * @author kec
 */
public class AnnotationBlueprintBuilder extends BlueprintBuilder {
   private Stack<UUID> referencedComponentStack = new Stack<>();
   private UUID        collectionUUID;
   private RefexCAB    last;
   private RefexCAB    current;
   private boolean     randomUuid;

   public AnnotationBlueprintBuilder(UUID collectionUUID, ViewCoordinate vc, UUID moduleUuid,
                                     boolean randomUuid) {
      super(vc, moduleUuid);
      this.collectionUUID = collectionUUID;
      this.randomUuid     = randomUuid;
   }

   public RefexCAB current() {
      return current;
   }

   public RefexCAB last() {
      return last;
   }

   public RefexCAB newAnnotation(TK_REFEX_TYPE refexType)
           throws IOException, InvalidBlueprintException, ContradictionException {
      last    = current;
      current = new RefexCAB(refexType, referencedComponentStack.peek(), collectionUUID, vc, moduleUuid);

      if (randomUuid) {
         current.setMemberUuid(UUID.randomUUID());
      }

      return current;
   }

   public void popReferencedComponent() {
      referencedComponentStack.pop();
   }

   public void pushReferencedComponent(UUID parent) {
      referencedComponentStack.push(parent);
   }
}
