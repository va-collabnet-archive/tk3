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



package org.ihtsdo.fxmodel.concept.component.refex;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.fxmodel.FxComponentReference;
import org.ihtsdo.fxmodel.concept.component.FxComponentVersion;
import org.ihtsdo.tk.api.ComponentVersionBI;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.id.IdBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kec
 */
public class FxRefexVersion<T extends FxRefexChronicle, V extends FxRefexVersion>
        extends FxComponentVersion<T, V> {
   public FxRefexVersion() {}

   public FxRefexVersion(T chronicle, TerminologySnapshotDI ss, ComponentVersionBI another)
           throws IOException, ContradictionException {
      super(chronicle, ss, another);
   }

   public FxRefexVersion(T chronicle, TerminologySnapshotDI ss, IdBI id)
           throws IOException, ContradictionException {
      super(chronicle, ss, id);
   }

   //~--- get methods ---------------------------------------------------------

   @XmlTransient
   public FxComponentReference getComponentRef() {
      return chronicle.componentReference;
   }

   @XmlTransient
   public FxComponentReference getRefexRef() {
      return chronicle.refexReference;
   }

   @XmlTransient
   public FX_REFEX_TYPE getType() {
      return chronicle.getType();
   }
}
