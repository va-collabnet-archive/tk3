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

import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.identifier.FxIdentifier;
import org.ihtsdo.fxmodel.concept.component.refex.FxRefexChronicle;
import org.ihtsdo.tk.api.ComponentVersionBI;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.id.IdBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.List;
import java.util.UUID;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kec
 */
public class FxComponentVersion<T extends FxComponentChronicle, V extends FxComponentVersion>
        extends FxVersion {
   @XmlTransient
   protected T chronicle;

   //~--- constructors --------------------------------------------------------

   public FxComponentVersion() {}

   public FxComponentVersion(T chronicle, TerminologySnapshotDI ss, ComponentVersionBI another)
           throws IOException, ContradictionException {
      super(ss, another);
      this.chronicle = chronicle;
   }

   public FxComponentVersion(T chronicle, TerminologySnapshotDI ss, IdBI id)
           throws IOException, ContradictionException {
      super(ss, id);
      this.chronicle = chronicle;
   }

   //~--- methods -------------------------------------------------------------

   public void afterUnmarshal(Unmarshaller u, Object parent) {
      if (parent instanceof FxComponentChronicle) {
         this.chronicle = (T) parent;
      }
   }

   //~--- get methods ---------------------------------------------------------

   @XmlTransient
   public List<FxIdentifier> getAdditionalIds() {
      return this.chronicle.additionalIds;
   }

   @XmlTransient
   public List<FxRefexChronicle<?,?>> getAnnotations() {
      return this.chronicle.refexes;
   }

   @XmlTransient
   public final T getChronicle() {
      return this.chronicle;
   }

   @XmlTransient
   public FxConcept getConcept() {
      return this.chronicle.concept;
   }

   @XmlTransient
   public int getIdCount() {
      return this.chronicle.getIdCount();
   }

   @XmlTransient
   public UUID getPrimordialComponentUuid() {
      return this.chronicle.getPrimordialComponentUuid();
   }

   @XmlTransient
   public List<UUID> getUuids() {
      return this.chronicle.getUuids();
   }

   @XmlTransient
   public int getVersionCount() {
      return this.chronicle.getVersionCount();
   }

   @XmlTransient
   public final List<V> getVersions() {
      return this.chronicle.getVersions();
   }
   
   @XmlTransient
   public int getComponentNid() {
       return this.chronicle.getComponentNid();
   }
}
