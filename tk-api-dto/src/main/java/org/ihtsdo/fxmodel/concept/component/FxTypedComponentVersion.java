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



package org.ihtsdo.fxmodel.concept.component;

//~--- non-JDK imports --------------------------------------------------------

import javafx.beans.property.SimpleObjectProperty;

import org.ihtsdo.fxmodel.FxComponentReference;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.TypedComponentVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

/**
 *
 * @author kec
 */
public class FxTypedComponentVersion<V extends FxComponentChronicle, T extends FxTypedComponentVersion>
        extends FxComponentVersion<V, T> {
   protected SimpleObjectProperty<FxComponentReference> typeReferenceProperty =
      new SimpleObjectProperty<>(this, "type");

   //~--- constructors --------------------------------------------------------

   public FxTypedComponentVersion() {}

   public FxTypedComponentVersion(V chronicle, TerminologySnapshotDI ss, TypedComponentVersionBI another)
           throws IOException, ContradictionException {
      super(chronicle, ss, another);
      typeReferenceProperty.set(new FxComponentReference(ss.getConceptForNid(another.getTypeNid())));
   }

   //~--- methods -------------------------------------------------------------
  /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(" type:");
      buff.append(getTypeReference().getText());
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }


   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (obj instanceof FxTypedComponentVersion) {
         FxTypedComponentVersion another = (FxTypedComponentVersion) obj;

         if (!this.typeReferenceProperty.equals(another.typeReferenceProperty)) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   public final SimpleObjectProperty<FxComponentReference> typeReferenceProperty() {
      return typeReferenceProperty;
   }

   //~--- get methods ---------------------------------------------------------

   public final FxComponentReference getTypeReference() {
      return typeReferenceProperty.get();
   }

   //~--- set methods ---------------------------------------------------------

   public final void setTypeReference(FxComponentReference typeReference) {
      this.typeReferenceProperty.set(typeReference);
   }
}
