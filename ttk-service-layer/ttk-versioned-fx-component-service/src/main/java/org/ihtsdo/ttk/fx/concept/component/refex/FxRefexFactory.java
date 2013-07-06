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



package org.ihtsdo.ttk.fx.concept.component.refex;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologySnapshotDI;
import org.ihtsdo.ttk.api.refex.RefexChronicleBI;
import org.ihtsdo.ttk.fx.concept.FxConceptChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_array_of_bytearray.FxRefexArrayOfByteArrayChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_boolean.FxRefexBooleanChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp.FxRefexCompChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_boolean.FxRefexCompBooleanChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp.FxRefexCompCompChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp_comp.FxRefexCompCompCompChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp_comp_float.FxRefexCompCompCompFloatChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp_comp_int.FxRefexCompCompCompIntChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp_comp_long.FxRefexCompCompCompLongChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp_comp_string
   .FxRefexCompCompCompStringChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_comp_string.FxRefexCompCompStringChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_float.FxRefexCompFloatChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_int.FxRefexCompIntChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_long.FxRefexCompLongChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_comp_string.FxRefexCompStringChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_int.FxRefexIntChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_long.FxRefexLongChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_member.FxRefexMembershipChronicle;
import org.ihtsdo.ttk.fx.concept.component.refex.type_string.FxRefexStringChronicle;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

/**
 *
 * @author kec
 */
public class FxRefexFactory {

   /**
    * Method description
    *
    *
    * @param ss
    * @param concept
    * @param another
    *
    * @return
    *
    * @throws ContradictionException
    * @throws IOException
    */
   public static FxRefexChronicle make(TerminologySnapshotDI ss, FxConceptChronicle concept, RefexChronicleBI another)
           throws IOException, ContradictionException {
      switch (another.getRefexType()) {
      case ARRAY_BYTEARRAY :
         return new FxRefexArrayOfByteArrayChronicle(ss, concept, another);

      case BOOLEAN :
         return new FxRefexBooleanChronicle(ss, concept, another);

      case CID :
         return new FxRefexCompChronicle(ss, concept, another);

      case CID_BOOLEAN :
         return new FxRefexCompBooleanChronicle(ss, concept, another);

      case CID_CID :
         return new FxRefexCompCompChronicle(ss, concept, another);

      case CID_CID_CID :
         return new FxRefexCompCompCompChronicle(ss, concept, another);

      case CID_CID_CID_FLOAT :
         return new FxRefexCompCompCompFloatChronicle(ss, concept, another);

      case CID_CID_CID_INT :
         return new FxRefexCompCompCompIntChronicle(ss, concept, another);

      case CID_CID_CID_LONG :
         return new FxRefexCompCompCompLongChronicle(ss, concept, another);

      case CID_CID_CID_STRING :
         return new FxRefexCompCompCompStringChronicle(ss, concept, another);

      case CID_CID_STR :
         return new FxRefexCompCompStringChronicle(ss, concept, another);

      case CID_FLOAT :
         return new FxRefexCompFloatChronicle();

      case CID_INT :
         return new FxRefexCompIntChronicle(ss, concept, another);

      case CID_LONG :
         return new FxRefexCompLongChronicle(ss, concept, another);

      case CID_STR :
         return new FxRefexCompStringChronicle(ss, concept, another);

      case INT :
         return new FxRefexIntChronicle(ss, concept, another);

      case LONG :
         return new FxRefexLongChronicle(ss, concept, another);

      case MEMBER :
         return new FxRefexMembershipChronicle(ss, concept, another);

      case STR :
         return new FxRefexStringChronicle(ss, concept, another);

      default :
         throw new UnsupportedOperationException("Can't handle: " + another.getRefexType());
      }
   }
}
