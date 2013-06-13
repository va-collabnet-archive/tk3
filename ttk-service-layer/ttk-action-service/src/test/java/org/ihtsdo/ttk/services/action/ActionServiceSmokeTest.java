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



package org.ihtsdo.ttk.services.action;

//~--- non-JDK imports --------------------------------------------------------

import org.drools.runtime.rule.FactHandle;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.runtime.KnowledgeSessionConfiguration;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.conf.ClockTypeOption;
import org.drools.runtime.rule.WorkingMemoryEntryPoint;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kec
 */
public class ActionServiceSmokeTest {

   /** Field description */
   StatefulKnowledgeSession ksession;
   
   WorkingMemoryEntryPoint uiEventStream;

   /**
    * Constructs ...
    *
    */
   public ActionServiceSmokeTest() {}

   /**
    * Method description
    *
    */
   @After
   public void tearDown() {}

   /**
    * Method description
    *
    */
   @AfterClass
   public static void tearDownClass() {}

   /**
    * Method description
    *
    */
   @Test
   public void testCheese() {

      // Insert fact
      Cheese     stilton       = new Cheese("stilton");
      FactHandle stiltonHandle = ksession.insert(stilton);

      // delete fact
      ksession.retract(stiltonHandle);

      // update example
      stiltonHandle = ksession.insert(stilton);
      stilton.setPrice(100);
      ksession.update(stiltonHandle, stilton);
      
      uiEventStream.insert("UI Event");
      
   }

   /**
    * Method description
    *
    */
   @Before
   public void setUp() {
       
      KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
      KnowledgeSessionConfiguration config = KnowledgeBaseFactory.newKnowledgeSessionConfiguration();
      config.setOption( ClockTypeOption.get("realtime") );

      ksession = kbase.newStatefulKnowledgeSession(config, null);
      uiEventStream = ksession.getWorkingMemoryEntryPoint("UI Event Stream");
   }

   /**
    * Method description
    *
    */
   @BeforeClass
   public static void setUpClass() {}
}
