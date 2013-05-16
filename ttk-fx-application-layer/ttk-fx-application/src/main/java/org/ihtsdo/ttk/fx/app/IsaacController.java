/*
 * Copyright 2013 VA Office of Informatics and Analytics.
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
package org.ihtsdo.ttk.fx.app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import org.ihtsdo.ttk.helpers.database.DbStartupListener;
import org.ihtsdo.ttk.pl.fx.concept.details.ConceptDetailsSetup;
import org.ihtsdo.ttk.pl.fx.taxonomy.multiparent.TaxonomySetup;


public class IsaacController
    implements Initializable {

    @FXML //  fx:id="conceptDetailsAnchorPane"
    private AnchorPane conceptDetailsAnchorPane; // Value injected by FXMLLoader

    @FXML //  fx:id="searchAnchorPane"
    private AnchorPane searchAnchorPane; // Value injected by FXMLLoader

    @FXML //  fx:id="taxonomyAnchorPane"
    private AnchorPane taxonomyAnchorPane; // Value injected by FXMLLoader

    @FXML //  fx:id="taxonomyBorderPane"
    private BorderPane taxonomyBorderPane; // Value injected by FXMLLoader
    
    @FXML //  fx:id="conceptDetailsBorderPane"
    private BorderPane conceptDetailsBorderPane; // Value injected by FXMLLoader
    
    private static DbStartupListener dbStartup;
    
    private boolean embeddedDb = false;

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert conceptDetailsAnchorPane != null : "fx:id=\"conceptDetailsAnchorPane\" was not injected: check your FXML file 'Isaac.fxml'.";
        assert searchAnchorPane != null : "fx:id=\"searchAnchorPane\" was not injected: check your FXML file 'Isaac.fxml'.";
        assert taxonomyAnchorPane != null : "fx:id=\"taxonomyAnchorPane\" was not injected: check your FXML file 'Isaac.fxml'.";
        assert taxonomyBorderPane != null : "fx:id=\"taxonomyBorderPane\" was not injected: check your FXML file 'Isaac.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected
             dbStartup = new DbStartupListener(embeddedDb, new TaxonomySetup(taxonomyBorderPane),
                new ConceptDetailsSetup(conceptDetailsBorderPane));
            
    }
     
}
