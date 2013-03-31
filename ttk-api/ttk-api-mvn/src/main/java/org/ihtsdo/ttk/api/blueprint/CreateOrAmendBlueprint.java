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
import java.util.EnumMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kec
 */
public abstract class CreateOrAmendBlueprint implements PropertyChangeListener {

   /** Field description */
   private static UUID currentStatusUuid = null;

   /** Field description */
   private static UUID retiredStatusUuid = null;

   /** Field description */
   private List<RefexCAB> annotations = new ArrayList<>();

   /** Field description */
   protected PropertyChangeSupport pcs = new PropertyChangeSupport(this);

   /** Field description */
   protected EnumMap<RefexProperty, Object> properties = new EnumMap<>(RefexProperty.class);

   /** Field description */
   private UUID componentUuid;

   /** Field description */
   private ComponentVersionBI cv;

   /** Field description */
   private ViewCoordinate vc;

   /**
    * Constructs ...
    *
    *
    * @param componentUuid
    * @param cv
    * @param vc
    * @param moduleUuid
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidBlueprintException
    */
   public CreateOrAmendBlueprint(UUID componentUuid, ComponentVersionBI cv, ViewCoordinate vc,
                                 UUID moduleUuid)
           throws IOException, InvalidBlueprintException, ContradictionException {
      if (currentStatusUuid == null) {
         currentStatusUuid = SnomedMetadataRf2.ACTIVE_VALUE_RF2.getUuids()[0];
      }

      if (retiredStatusUuid == null) {
         retiredStatusUuid = SnomedMetadataRf2.INACTIVE_VALUE_RF2.getUuids()[0];
      }

      properties.put(RefexProperty.STATUS_ID, currentStatusUuid);
      properties.put(RefexProperty.MODULE_ID, moduleUuid);
      this.componentUuid = componentUuid;
      this.cv            = cv;
      this.vc            = vc;
      getAnnotationBlueprints();
      pcs.addPropertyChangeListener(this);
   }

   /**
    * Method description
    *
    *
    * @param pl
    */
   public synchronized void addPropertyChangeListener(PropertyChangeListener pl) {
      pcs.addPropertyChangeListener(pl);
   }

   /**
    * Method description
    *
    *
    * @param string
    * @param pl
    */
   public synchronized void addPropertyChangeListener(String string, PropertyChangeListener pl) {
      pcs.addPropertyChangeListener(string, pl);
   }

   /**
    * Method description
    *
    *
    * @param pce
    */
   @Override
   public void propertyChange(PropertyChangeEvent pce) {
      try {
         recomputeUuid();
      } catch (NoSuchAlgorithmException | InvalidBlueprintException | ContradictionException
               | IOException ex) {
         Logger.getLogger(CreateOrAmendBlueprint.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   /**
    * Method description
    *
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidBlueprintException
    * @throws NoSuchAlgorithmException
    * @throws UnsupportedEncodingException
    */
   public abstract void recomputeUuid()
           throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException,
                  InvalidBlueprintException, ContradictionException;

   /**
    * Method description
    *
    *
    * @param pl
    */
   public synchronized void removePropertyChangeListener(PropertyChangeListener pl) {
      pcs.removePropertyChangeListener(pl);
   }

   /**
    * Method description
    *
    *
    * @param string
    * @param pl
    */
   public synchronized void removePropertyChangeListener(String string, PropertyChangeListener pl) {
      pcs.removePropertyChangeListener(string, pl);
   }

   /**
    * Method description
    *
    *
    * @param annotations
    */
   public void replaceAnnotationBlueprints(List<RefexCAB> annotations) {
      this.annotations = annotations;
   }

   /**
    * Method description
    *
    *
    * @return
    *
    * @throws ContradictionException
    * @throws IOException
    * @throws InvalidBlueprintException
    */
   public final List<RefexCAB> getAnnotationBlueprints()
           throws IOException, InvalidBlueprintException, ContradictionException {
      if (annotations.isEmpty() && (cv != null)) {
         if (cv.getCurrentRefexes(vc) != null) {
            Collection<? extends RefexVersionBI<?>> originalRefexes = cv.getCurrentRefexes(vc);

            if (!originalRefexes.isEmpty()) {
               for (RefexVersionBI refex : originalRefexes) {
                  annotations.add(refex.makeBlueprint(vc));
               }
            }
         }
      }

      return annotations;
   }

   /**
    * Method description
    *
    *
    * @return
    *
    * @throws IOException
    */
   public int getComponentNid() throws IOException {
      return Ts.get().getNidForUuids(componentUuid);
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public UUID getComponentUuid() {
      return componentUuid;
   }

   /**
    * Method description
    *
    *
    * @return
    *
    * @throws IOException
    */
   public UUID getModuleUuid() throws IOException {
      Object moduleId = properties.get(RefexProperty.MODULE_ID);

      if (moduleId instanceof UUID) {
         return (UUID) moduleId;
      }

      return Ts.get().getUuidPrimordialForNid((Integer) moduleId);
   }

   /**
    * Method description
    *
    *
    * @param nid
    *
    * @return
    *
    * @throws IOException
    * @throws InvalidBlueprintException
    */
   protected String getPrimoridalUuidStr(int nid) throws IOException, InvalidBlueprintException {
      ComponentBI component = Ts.get().getComponent(nid);

      if (component != null) {
         return component.getPrimUuid().toString();
      }

      List<UUID> uuids = Ts.get().getUuidsForNid(nid);

      if (uuids.size() == 1) {
         return uuids.get(0).toString();
      }

      throw new InvalidBlueprintException("Can't find primordialUuid for: " + component);
   }

   /**
    * Method description
    *
    *
    * @param uuid
    *
    * @return
    *
    * @throws IOException
    * @throws InvalidBlueprintException
    */
   protected String getPrimoridalUuidStr(UUID uuid) throws IOException, InvalidBlueprintException {
      if (Ts.get() != null) {
         ComponentBI component = Ts.get().getComponent(uuid);

         if (component != null) {
            return component.getPrimUuid().toString();
         }
      }

      return uuid.toString();
   }

   /**
    * Method description
    *
    *
    * @return
    *
    * @throws IOException
    */
   public int getStatusNid() throws IOException {
      Object statusId = properties.get(RefexProperty.STATUS_ID);

      if (statusId instanceof UUID) {
         return Ts.get().getNidForUuids((UUID) statusId);
      }

      return (Integer) statusId;
   }

   /**
    * Method description
    *
    *
    * @return
    *
    * @throws IOException
    */
   public UUID getStatusUuid() throws IOException {
      Object statusId = properties.get(RefexProperty.STATUS_ID);

      if (statusId instanceof UUID) {
         return (UUID) statusId;
      }

      return Ts.get().getUuidPrimordialForNid((Integer) statusId);
   }

   /**
    * Method description
    *
    *
    * @param annotation
    */
   public void setAnnotationBlueprint(RefexCAB annotation) {
      annotations.add(annotation);
   }

   /**
    * Method description
    *
    *
    * @param componentUuid
    */
   public void setComponentUuid(UUID componentUuid) {
      UUID oldUuid = this.componentUuid;

      this.componentUuid = componentUuid;
      pcs.firePropertyChange("componentUuid", oldUuid, this.componentUuid);
   }

   /**
    * Method description
    *
    */
   public void setCurrent() {
      this.properties.put(RefexProperty.STATUS_ID, currentStatusUuid);
   }

   /**
    * Method description
    *
    *
    * @param moduleUuid
    */
   public void setModuleUuid(UUID moduleUuid) {
      this.properties.put(RefexProperty.MODULE_ID, moduleUuid);
   }

   /**
    * Method description
    *
    */
   public void setRetired() {
      this.properties.put(RefexProperty.STATUS_ID, retiredStatusUuid);
   }

   /**
    * Method description
    *
    *
    * @param statusUuid
    */
   public void setStatusUuid(UUID statusUuid) {
      this.properties.put(RefexProperty.STATUS_ID, statusUuid);
   }
}
