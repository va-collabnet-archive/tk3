/*
 * Copyright 2013
 * International Health Terminology Standards Development Organisation.
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



package org.ihtsdo.ttk.auxiliary.taxonomies;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.lang.LANG_CODE;
import org.ihtsdo.ttk.api.metadata.binding.TermAux;

//~--- JDK imports ------------------------------------------------------------

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import java.security.NoSuchAlgorithmException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kec
 */
public class DescriptionLogicAuxiliary extends Taxonomy {

   /** Field description */
   private static final String moduleName = "DL Module";

   public DescriptionLogicAuxiliary() throws NoSuchAlgorithmException, UnsupportedEncodingException {
      super(TermAux.WB_AUX_PATH, TermAux.USER, moduleName, TermAux.IS_A, "(DL Metadata)", LANG_CODE.EN);

      try {
         createConcept("description-logic auxiliary");
         pushParent(current());
         createConcept("description-logic metadata");
         pushParent(current());
         createConcept(moduleName);
         popParent();
         createConcept("object property characteristics");
         pushParent(current());
         createConcept("functional");
         createConcept("transitive");
         createConcept("reflexive");
         popParent();
         createConcept("object property operators");
         pushParent(current());
         createConcept("sub-property of");
         createConcept("composition");
         popParent();
         createConcept("set operators");
         pushParent(current());
         createConcept("sufficient set");
         createConcept("necessary set");
         popParent();
         createConcept("connective operators");
         pushParent(current());
         createConcept("and");
         createConcept("or");
         createConcept("disjoint with");
         createConcept("definition root");
         popParent();
         createConcept("template operators");
         pushParent(current());
         createConcept("template merge");
         createConcept("field substitution");
         popParent();
         createConcept("field operators");
         pushParent(current());
         createConcept("component extension 1 id substitution");
         createConcept("component extension 2 id substitution");
         createConcept("component extension 3 id substitution");
         createConcept("integer 1 substitution");
         createConcept("long 1 substitution");
         createConcept("float 1 substitution");
         popParent();
         createConcept("field annotations");
         pushParent(current());
         createConcept("component extension 1 label").setAnnotation(true);
         createConcept("component extension 1 order").setAnnotation(true);
         createConcept("component extension 1 default value").setAnnotation(true);
         createConcept("component extension 2 label").setAnnotation(true);
         createConcept("component extension 2 order").setAnnotation(true);
         createConcept("component extension 2 default value").setAnnotation(true);
         createConcept("component extension 3 label").setAnnotation(true);
         createConcept("component extension 3 order").setAnnotation(true);
         createConcept("component extension 3 default value").setAnnotation(true);
         createConcept("integer 1 label").setAnnotation(true);
         createConcept("integer 1 order").setAnnotation(true);
         createConcept("integer 1 default value").setAnnotation(true);
         createConcept("long 1 label").setAnnotation(true);
         createConcept("long 1 order").setAnnotation(true);
         createConcept("long 1 default value").setAnnotation(true);
         createConcept("float 1 label").setAnnotation(true);
         createConcept("float 1 order").setAnnotation(true);
         createConcept("float 1 default value").setAnnotation(true);
         popParent();
         createConcept("template concepts");
         pushParent(current());
         createConcept("skin of region template");
         // add annotations for order and labels
         current().getAnnotationBlueprints().add(null);
         // create template
         popParent();
         createConcept("role operators");
         pushParent(current());
         createConcept("universal restriction");
         createConcept("extensional restriction");
         popParent();
         createConcept("concrete domain operators");
         pushParent(current());
         createConcept("greater than");
         createConcept("greater than or equal to");
         createConcept("equal to");
         createConcept("less than or equal to");
         createConcept("less than");
         popParent();
         createConcept("description-logic variety");
         pushParent(current());
         createConcept("EL++").setAnnotation(true);
         createConcept("SH").setAnnotation(true);
         popParent();
         createConcept("description-logic classifier");
         pushParent(current());
         createConcept("SnoRocket");
         createConcept("ConDOR");
         popParent();
         createConcept("intrinsic roles");
         pushParent(current());
         createConcept("role group");
      } catch (Exception ex) {
         Logger.getLogger(DescriptionLogicAuxiliary.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   public static void main(String[] args) {
      Writer           writer = null;
      DataOutputStream data   = null;

      try {
         DescriptionLogicAuxiliary dlmdt = new DescriptionLogicAuxiliary();

         writer = new BufferedWriter(new FileWriter("DescriptionLogicBinding.java"));
         dlmdt.exportJavaBinding(writer, "org.ihtsdo.ttk.auxiliary.taxonomies", "DescriptionLogicBinding");
         data = new DataOutputStream(
             new BufferedOutputStream(new FileOutputStream("DescriptionLogicMetadata.econ")));
         dlmdt.exportEConcept(data);
      } catch (Exception ex) {
         Logger.getLogger(DescriptionLogicAuxiliary.class.getName()).log(Level.SEVERE, null, ex);
      } finally {
         try {
            if (writer != null) {
               writer.close();
            }

            if (data != null) {
               data.close();
            }
         } catch (IOException ex) {
            Logger.getLogger(DescriptionLogicAuxiliary.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
   }
}
