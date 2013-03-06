/*
 * Copyright 2011 International Health Terminology Standards Development Organisation.
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



package org.ihtsdo.ttk.api.blueprint;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.ComponentBI;
import org.ihtsdo.ttk.api.ComponentVersionBI;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.metadata.binding.SnomedMetadataRf2;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.security.NoSuchAlgorithmException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kec
 */
public abstract class CreateOrAmendBlueprint implements PropertyChangeListener {
   private static UUID             currentStatusUuid = null;
   private static UUID             retiredStatusUuid = null;
   private List<RefexCAB>          annotations       = new ArrayList<>();
   protected PropertyChangeSupport pcs               =
      new PropertyChangeSupport(this);
   private UUID                    componentUuid;
   private UUID                    statusUuid;
   private UUID                    moduleUuid;
   private ComponentVersionBI      cv;
   private ViewCoordinate          vc;

   public CreateOrAmendBlueprint(UUID componentUuid, ComponentVersionBI cv,
                                 ViewCoordinate vc, UUID moduleUuid)
           throws IOException, InvalidCAB, ContradictionException {
      currentStatusUuid  = SnomedMetadataRf2.ACTIVE_VALUE_RF2.getUuids()[0];
      retiredStatusUuid  = SnomedMetadataRf2.INACTIVE_VALUE_RF2.getUuids()[0];
      statusUuid         = currentStatusUuid;
      this.moduleUuid    = moduleUuid;
      this.componentUuid = componentUuid;
      this.cv            = cv;
      this.vc            = vc;
      getAnnotationBlueprints();
      pcs.addPropertyChangeListener(this);
   }

   public synchronized void addPropertyChangeListener(
           PropertyChangeListener pl) {
      pcs.addPropertyChangeListener(pl);
   }

   public synchronized void addPropertyChangeListener(String string,
           PropertyChangeListener pl) {
      pcs.addPropertyChangeListener(string, pl);
   }

   @Override
   public void propertyChange(PropertyChangeEvent pce) {
      try {
         recomputeUuid();
      } catch (NoSuchAlgorithmException | InvalidCAB | ContradictionException
               | IOException ex) {
         Logger.getLogger(CreateOrAmendBlueprint.class.getName()).log(
             Level.SEVERE, null, ex);
      }
   }

   public abstract void recomputeUuid()
           throws NoSuchAlgorithmException, UnsupportedEncodingException,
                  IOException, InvalidCAB, ContradictionException;

   public synchronized void removePropertyChangeListener(
           PropertyChangeListener pl) {
      pcs.removePropertyChangeListener(pl);
   }

   public synchronized void removePropertyChangeListener(String string,
           PropertyChangeListener pl) {
      pcs.removePropertyChangeListener(string, pl);
   }

   public void replaceAnnotationBlueprints(List<RefexCAB> annotations) {
      this.annotations = annotations;
   }

   public List<RefexCAB> getAnnotationBlueprints()
           throws IOException, InvalidCAB, ContradictionException {
      if (annotations.isEmpty() && (cv != null)) {
         if (cv.getCurrentRefexes(vc) != null) {
            Collection<? extends RefexVersionBI<?>> originalRefexes =
               cv.getCurrentRefexes(vc);

            if (!originalRefexes.isEmpty()) {
               for (RefexVersionBI refex : originalRefexes) {
                  annotations.add(refex.makeBlueprint(vc));
               }
            }
         }
      }

      return annotations;
   }

   public int getComponentNid() throws IOException {
      return Ts.get().getNidForUuids(componentUuid);
   }

   public UUID getComponentUuid() {
      return componentUuid;
   }

   public UUID getModuleUuid() {
      return moduleUuid;
   }

   protected String getPrimoridalUuidStr(int nid)
           throws IOException, InvalidCAB {
      ComponentBI component = Ts.get().getComponent(nid);

      if (component != null) {
         return component.getPrimUuid().toString();
      }

      List<UUID> uuids = Ts.get().getUuidsForNid(nid);

      if (uuids.size() == 1) {
         return uuids.get(0).toString();
      }

      throw new InvalidCAB("Can't find primordialUuid for: " + component);
   }

   protected String getPrimoridalUuidStr(UUID uuid)
           throws IOException, InvalidCAB {
      if (Ts.get() != null) {
         ComponentBI component = Ts.get().getComponent(uuid);

         if (component != null) {
            return component.getPrimUuid().toString();
         }
      }

      return uuid.toString();
   }

   public int getStatusNid() throws IOException {
      return Ts.get().getNidForUuids(statusUuid);
   }

   public UUID getStatusUuid() {
      return statusUuid;
   }

   public void setAnnotationBlueprint(RefexCAB annotation) {
      annotations.add(annotation);
   }

   public void setComponentUuid(UUID componentUuid) {
      UUID oldUuid = this.componentUuid;

      this.componentUuid = componentUuid;
      pcs.firePropertyChange("componentUuid", oldUuid, this.componentUuid);
   }

   public void setCurrent() {
      this.statusUuid = currentStatusUuid;
   }

   public void setModuleUuid(UUID moduleUuid) {
      this.moduleUuid = moduleUuid;
   }

   public void setRetired() {
      this.statusUuid = retiredStatusUuid;
   }

   public void setStatusUuid(UUID statusUuid) {
      this.statusUuid = statusUuid;
   }
}
