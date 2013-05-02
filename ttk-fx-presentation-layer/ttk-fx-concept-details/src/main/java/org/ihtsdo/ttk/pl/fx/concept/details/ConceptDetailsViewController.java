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

import javafx.application.Platform;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javafx.util.Callback;

import org.ihtsdo.ttk.api.RelAssertionType;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.coordinate.EditCoordinate;
import org.ihtsdo.ttk.api.coordinate.StandardViewCoordinates;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.metadata.binding.Snomed;
import org.ihtsdo.ttk.api.metadata.binding.TermAux;
import org.ihtsdo.ttk.fx.concept.FxConcept;
import org.ihtsdo.ttk.fx.context.TerminologyContext;
import org.ihtsdo.ttk.helpers.time.TimeHelper;
import org.ihtsdo.ttk.logic.SnomedToLogicTree;
import org.ihtsdo.ttk.lookup.Looker;

import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.net.URL;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

/**
 *
 * @author kec
 */
public class ConceptDetailsViewController
        implements LookupListener, Initializable, ChangeListener<FxConcept> {

   /** Field description */
   @FXML                                        // fx:id="contextComboBox"
   private ComboBox<Object> contextComboBox;    // Value injected by FXMLLoader

   /** Field description */
   @FXML                           // fx:id="textField"
   private TextField textField;    // Value injected by FXMLLoader

   /** Field description */
   @FXML                         // fx:id="testButton"
   private Button testButton;    // Value injected by FXMLLoader

   /** Field description */
   TerminologyContext currentContext;

   /** Field description */
   Lookup.Result<TerminologyContext> contextLookupResult;

   /**
    * Method description
    *
    *
    * @param contextConcept
    */
   private void changeConcept(FxConcept contextConcept) {
      if (contextConcept != null) {
         textField.setText(contextConcept.toString());
      } else {
         textField.setText("No selection");
      }
   }

   /**
    * Method description
    *
    *
    * @param ov
    * @param oldValue
    * @param newValue
    */
   @Override
   public void changed(ObservableValue<? extends FxConcept> ov, FxConcept oldValue,
                       final FxConcept newValue) {
      Platform.runLater(new Runnable() {
         @Override
         public void run() {
            changeConcept(newValue);
         }
      });
   }

   /**
    * Method description
    *
    *
    * @param newValue
    */
   private void contextChanged(Object newValue) {
      if (currentContext != null) {
         currentContext.getContextProperty().removeListener(this);
         currentContext = null;
      }

      if (newValue instanceof TerminologyContext) {
         currentContext = (TerminologyContext) newValue;
         currentContext.getContextProperty().addListener(this);
         changeConcept(currentContext.getContext());
      }
   }

   /**
    * Method description
    *
    *
    * @param event
    */
   @FXML
   public void doEvent(ActionEvent event) {
      new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               ViewCoordinate vc = StandardViewCoordinates.getSnomedInferredLatest();

               vc.setRelAssertionType(RelAssertionType.STATED);

               EditCoordinate ec = new EditCoordinate(TermAux.USER.getNid(), Snomed.CORE_MODULE.getNid(),
                                      Snomed.SNOMED_RELEASE_PATH.getNid());

               // Convert to new form.
               SnomedToLogicTree converter = new SnomedToLogicTree(vc, ec);
               long              time      = System.currentTimeMillis();

               System.out.println(TimeHelper.formatDate(time));
               Ts.get().iterateConceptDataInParallel(converter);
               Ts.get().commit();
               System.out.println("Conversion time: "
                                  + TimeHelper.getElapsedTimeString(System.currentTimeMillis() - time));
            } catch (IOException ex) {
               Logger.getLogger(ConceptDetailsViewController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
               Logger.getLogger(ConceptDetailsViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
      }).start();
   }

   /**
    * Method description
    *
    *
    * @param fxmlFileLocation
    * @param resources
    */
   @Override    // This method is called by the FXMLLoader when initialization is complete
   public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
      assert contextComboBox != null :
             "fx:id=\"contextChoiceBox\" was not injected: check your FXML file 'ConceptDetailsView.fxml'.";
      assert textField != null :
             "fx:id=\"textField\" was not injected: check your FXML file 'ConceptDetailsView.fxml'.";
      assert testButton != null :
             "fx:id=\"testButton\" was not injected: check your FXML file 'ConceptDetailsView.fxml'.";
      contextComboBox.setButtonCell(new ContextListCell());
      contextComboBox.setCellFactory(new Callback<ListView<Object>, ListCell<Object>>() {
         @Override
         public ListCell<Object> call(ListView<Object> p) {
            return new ContextListCell();
         }
      });

      // initialize your logic here: all @FXML variables will have been injected
      contextLookupResult = Looker.lookupResult(TerminologyContext.class);
      setupChoiceBox(contextLookupResult);
      contextComboBox.getSelectionModel().selectFirst();
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            contextLookupResult.addLookupListener(ConceptDetailsViewController.this);
         }
      });
      contextComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
         @Override
         public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
            contextChanged(newValue);
         }
      });
   }

   /**
    * On swing event thread.
    *
    * @param ev
    */
   @Override
   public void resultChanged(LookupEvent ev) {
      Platform.runLater(new Runnable() {
         @Override
         public void run() {
            Object selectedItem = contextComboBox.getSelectionModel().getSelectedItem();

            setupChoiceBox(contextLookupResult);

            if (selectedItem != null) {
               contextComboBox.getSelectionModel().select(selectedItem);
            }
         }
      });
   }

   /**
    * Method description
    *
    *
    * @param result
    */
   private void setupChoiceBox(Lookup.Result<TerminologyContext> result) {
      contextComboBox.getItems().clear();
      contextComboBox.getItems().add("No linked context");

      for (TerminologyContext c : result.allInstances()) {
         contextComboBox.getItems().add(c);
      }
   }

   /**
    * Class description
    *
    *
    * @version        Enter version here..., 13/04/24
    * @author         Enter your name here...
    */
   static class ContextListCell extends ListCell<Object> {

      /**
       * Method description
       *
       *
       * @param item
       * @param empty
       */
      @Override
      protected void updateItem(Object item, boolean empty) {
         super.updateItem(item, empty);

         if ((item != null) && (item instanceof TerminologyContext)) {
            TerminologyContext context = (TerminologyContext) item;

            setGraphic(context.getGraphic());
            setText(context.getWindowName() + ": " + context.getContextName());
         }
      }
   }
}