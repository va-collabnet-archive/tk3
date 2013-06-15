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

import javafx.animation.ScaleTransition;
import javafx.animation.ScaleTransitionBuilder;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.animation.TranslateTransitionBuilder;

import javafx.event.EventHandler;

import javafx.geometry.Point2D;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javafx.util.Duration;

import org.ihtsdo.ttk.logic.DefinitionPart;
import org.ihtsdo.ttk.logic.DefinitionPartType;
import org.ihtsdo.ttk.pl.fx.helper.Drag;

//~--- JDK imports ------------------------------------------------------------

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/**
 *
 * @author kec
 */
public class ContextualDragAndDropNode extends Label {

   /** Field description */
   private static Set<ContextualDragAndDropNode> contextualNodeSet =
      Collections.newSetFromMap(new WeakHashMap<ContextualDragAndDropNode, Boolean>());

   /** Field description */
   double xTranslation = 140;

   /** Field description */
   double yTranslation = 40;

   /** Field description */
   DefinitionPart part;

   /** Field description */
   DefinitionPartType partType;

   /** Field description */
   Rectangle dropNode;

   /** Field description */
   TaskBarTransition growTransition;

   /**
    * Constructs ...
    *
    *
    * @param part
    * @param partType
    */
   public ContextualDragAndDropNode(DefinitionPart part, DefinitionPartType partType) {
      setup(part, partType);
   }

   /**
    * Constructs ...
    *
    *
    * @param text
    * @param part
    * @param partType
    */
   public ContextualDragAndDropNode(String text, DefinitionPart part, DefinitionPartType partType) {
      super(text);
      setup(part, partType);
   }

   /**
    * Constructs ...
    *
    *
    * @param text
    * @param graphic
    * @param part
    * @param partType
    */
   public ContextualDragAndDropNode(String text, Node graphic, DefinitionPart part,
                                    DefinitionPartType partType) {
      super(text, graphic);
      setup(part, partType);
   }

   /**
    * Method description
    *
    */
   public void disableDrop() {
      if (this.getScene() != null) {
         dropNode.setVisible(false);
         ((AnchorPane) getScene().getRoot()).getChildren().remove(dropNode);
      }
   }

   /**
    * Method description
    *
    */
   public void enableDrop() {
      if (this != Drag.getDragComponent()) {
         if (this.getScene() != null) {
            ((AnchorPane) getScene().getRoot()).getChildren().add(dropNode);
            dropNode.setVisible(true);
            

            Point2D scenePt = getParent().localToScene(this.getBoundsInParent().getMinX()
                                 - dropNode.getWidth(), this.getBoundsInParent().getMinY());

            dropNode.relocate(scenePt.getX(), scenePt.getY());
            growTransition = new TaskBarTransition(xTranslation, yTranslation, 
                    scenePt.getX(), scenePt.getY(), dropNode);
         }
      }
   }

   /**
    * Method description
    *
    *
    * @param part
    * @param partType
    */
   private void setup(DefinitionPart part, DefinitionPartType partType) {
      this.part     = part;
      this.partType = partType;
      setCursor(Cursor.OPEN_HAND);
      dropNode = new Rectangle(0, 0, 10, 10);
      dropNode.setOpacity(0.5);
      dropNode.getStyleClass().add("dl-drop-disclosure");

      contextualNodeSet.add(this);
      setOnDragDetected(new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent event) {
            System.out.println("OnDragDetected: " + getText());

            SnapshotParameters snapParams = new SnapshotParameters();

            snapParams.setFill(Color.TRANSPARENT);

            ImageView dragImageView = new ImageView();

            dragImageView.setImage(snapshot(snapParams, null));
            dragImageView.setOpacity(0.5);
            ((AnchorPane) getScene().getRoot()).getChildren().add(dragImageView);
            ((Node) event.getSource()).setCursor(Cursor.CLOSED_HAND);
            Drag.startDrag(ContextualDragAndDropNode.this, ContextualDragAndDropNode.this.part,
                           dragImageView);
            startFullDrag();

            for (ContextualDragAndDropNode node : contextualNodeSet) {
               node.enableDrop();
            }
         }
      });
      setOnMouseReleased(new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent me) {
            System.out.println("OnMouseReleased: " + getText());
            ((Node) me.getSource()).setCursor(Cursor.OPEN_HAND);
            getStyleClass().remove("dl-drag-accept");

            if (Drag.getDragImageView() != null) {
               Drag.getDragImageView().setVisible(false);
               ((AnchorPane) getScene().getRoot()).getChildren().remove(Drag.getDragImageView());
               Drag.endDrag();
            }

            for (ContextualDragAndDropNode node : contextualNodeSet) {
               node.disableDrop();
            }
         }
      });
      setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {
         @Override
         public void handle(MouseDragEvent t) {
            System.out.println("OnMouseDragEntered: " + getText());

            if (t.getGestureSource() != t.getTarget()) {
               getStyleClass().add("dl-drag-accept");
            }
            growTransition.grow();
            growTransition.play();
         }
      });
      setOnMouseDragExited(new EventHandler<MouseDragEvent>() {
         @Override
         public void handle(MouseDragEvent t) {
            getStyleClass().remove("dl-drag-accept");
            System.out.println("OnMouseDragExited: " + getText());
            growTransition.stop();
            growTransition.shrink();
            growTransition.play();
         }
      });
      setOnMouseDragged(new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent event) {
            if (Drag.getDragImageView() != null) {
               Drag.getDragImageView().relocate(event.getSceneX(), event.getSceneY());
            }

            // event.consume();
         }
      });
   }
}
