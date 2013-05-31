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

//~--- non-JDK imports --------------------------------------------------------

import com.javafx.experiments.scenicview.ScenicView;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;

import org.ihtsdo.ttk.lookup.Looker;
import org.ihtsdo.ttk.lookup.TtkEnvironment;

//~--- JDK imports ------------------------------------------------------------


import java.io.IOException;
import javafx.application.Platform;


/**
 *
 * @author kec
 */
public class IsaacApp extends Application {

   /**
    * Method description
    *
    *
    * @param primaryStage
    *
    * @throws IOException
    */
   private void init(Stage primaryStage) throws IOException {
      Pane isaacPane = (Pane) FXMLLoader.load(getClass().getResource("/fxml/Isaac.fxml"));

      //ScenicView.show(isaacPane);
      primaryStage.setScene(new Scene(isaacPane));
   }

   /**
    * Method description
    *
    *
    * @param args
    */
   public static void main(String[] args) {
      launch(args);
   }

   /**
    * Method description
    *
    *
    * @param primaryStage
    *
    * @throws Exception
    */
   @Override
   public void start(Stage primaryStage) throws Exception {
      Looker.lookup(TtkEnvironment.class).setUseFxWorkers(true);
      init(primaryStage);
      primaryStage.show();
   }

    @Override
    public void stop() throws Exception {
       System.exit(0);
    }
}
