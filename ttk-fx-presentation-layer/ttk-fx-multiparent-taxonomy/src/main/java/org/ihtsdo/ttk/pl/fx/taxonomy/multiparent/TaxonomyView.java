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



package org.ihtsdo.ttk.pl.fx.taxonomy.multiparent;

//~--- non-JDK imports --------------------------------------------------------

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import org.ihtsdo.ttk.fx.FxTaxonomyReferenceWithConcept;
import org.ihtsdo.ttk.fx.concept.FxConcept;
import org.ihtsdo.ttk.fx.context.TerminologyContext;

/**
 *
 * @author kec
 */
public class TaxonomyView extends TreeView<FxTaxonomyReferenceWithConcept>
        implements ChangeListener<TreeItem<FxTaxonomyReferenceWithConcept>> {

   /** Field description */
   final String contextName, windowName;

   /** Field description */
   final TerminologyContext context;

   /**
    * Constructs ...
    *
    *
    * @param contextName
    * @param windowName
    */
   public TaxonomyView(String contextName, String windowName) {
      this(contextName, windowName, null);
   }

   /**
    * Constructs ...
    *
    *
    * @param contextName
    * @param windowName
    * @param ti
    */
   public TaxonomyView(String contextName, String windowName, TreeItem<FxTaxonomyReferenceWithConcept> ti) {
      super(ti);
      this.contextName = contextName;
      this.windowName  = windowName;
      this.context     = new TerminologyContext(contextName, windowName, SimTreeIcons.ROOT.getImageView());
      this.getSelectionModel().selectedItemProperty().addListener(this);
   }

   /**
    * Method description
    *
    *
    *
    * @param observableValue
    * @param oldValue
    * @param newValue
    */
   @Override
   public void changed(ObservableValue<? extends TreeItem<FxTaxonomyReferenceWithConcept>> observableValue,
                       TreeItem<FxTaxonomyReferenceWithConcept> oldValue,
                       TreeItem<FxTaxonomyReferenceWithConcept> newValue) {
      if (newValue == null) {
         context.getContextProperty().setValue(null);
      } else {
         FxConcept value = newValue.getValue().getConcept();
         context.getContextProperty().setValue(value);
      }

      System.out.println(context);
   }
}
