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



package org.ihtsdo.ttk.pl.fx.concept.details;

//~--- non-JDK imports --------------------------------------------------------

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.helpers.refex.RefexStringHelper;
import org.ihtsdo.ttk.logic.DefinitionPart;
import org.ihtsdo.ttk.logic.DefinitionTree;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

/**
 *
 * @author kec
 */
public class DefinitionPane extends GridPane {

   /** Field description */
   private DefinitionTree definitionTree;

   /**
    * Method description
    *
    *
    * @return
    */
   public DefinitionTree getDefinitionTree() {
      return definitionTree;
   }

   /**
    * Method description
    *
    *
    * @param definitionTree
    *
    * @throws ContradictionException
    * @throws IOException
    */
   public void setDefinitionTree(DefinitionTree definitionTree) throws ContradictionException, IOException {
      this.definitionTree = definitionTree;
      this.getChildren().clear();
      for (DefinitionPart part : definitionTree.getParts()) {
         Label partLabel = new Label(RefexStringHelper.getString(part.getRefexVersion(),
                              definitionTree.getViewCoordinate()));
         this.add(partLabel, part.getColumn(), part.getRow());
      }
   }
}
