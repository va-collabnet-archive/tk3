/*
 * Copyright 2012 International Health Terminology Standards Development Organisation.
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



package org.ihtsdo.ttk.api.coordinate;

import java.io.IOException;
import java.util.UUID;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.PositionBI;
import org.ihtsdo.ttk.api.PositionSet;
import org.ihtsdo.ttk.api.RelAssertionType;
import org.ihtsdo.ttk.api.metadata.binding.Snomed;
import org.ihtsdo.ttk.api.metadata.binding.TermAux;

/**
 *
 * @author kec
 */
public class StandardViewCoordinates {
   public static ViewCoordinate getSnomedInferredLatest() throws IOException {
      ViewCoordinate snomedVc = new ViewCoordinate(UUID.fromString("0c734870-836a-11e2-9e96-0800200c9a66"),
                                   "SNOMED Infered-Latest", Ts.get().getMetadataVC());
      PositionBI snomedPosition =
         Ts.get().newPosition(Ts.get().getPath(Snomed.SNOMED_RELEASE_PATH.getLenient().getConceptNid()),
                              Long.MAX_VALUE);

      snomedVc.setPositionSet(new PositionSet(snomedPosition));
      snomedVc.setRelAssertionType(RelAssertionType.INFERRED);

      return snomedVc;
   }
   public static ViewCoordinate getSnomedStatedLatest() throws IOException {
      ViewCoordinate snomedVc = new ViewCoordinate(UUID.fromString("0c734871-836a-11e2-9e96-0800200c9a66"),
                                   "SNOMED Stated-Latest", Ts.get().getMetadataVC());
      PositionBI snomedPosition =
         Ts.get().newPosition(Ts.get().getPath(Snomed.SNOMED_RELEASE_PATH.getLenient().getConceptNid()),
                              Long.MAX_VALUE);

      snomedVc.setPositionSet(new PositionSet(snomedPosition));
      snomedVc.setRelAssertionType(RelAssertionType.STATED);

      return snomedVc;
   }
   
      public static ViewCoordinate getSnomedInferredThenStatedLatest() throws IOException {
      ViewCoordinate snomedVc = new ViewCoordinate(UUID.fromString("0c734872-836a-11e2-9e96-0800200c9a66"),
                                   "SNOMED Inferred then Stated-Latest", Ts.get().getMetadataVC());
      PositionBI snomedPosition =
         Ts.get().newPosition(Ts.get().getPath(Snomed.SNOMED_RELEASE_PATH.getLenient().getConceptNid()),
                              Long.MAX_VALUE);

      snomedVc.setPositionSet(new PositionSet(snomedPosition));
      snomedVc.setRelAssertionType(RelAssertionType.INFERRED_THEN_STATED);

      return snomedVc;
   }

}
