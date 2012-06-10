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



package org.ihtsdo.fxmodel;

//~--- non-JDK imports --------------------------------------------------------

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

//~--- JDK imports ------------------------------------------------------------

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.UUID;

/**
 *
 * @author kec
 */
public class FxComponentReference implements Externalizable {
   private final SimpleObjectProperty<Integer> nidProperty  = new SimpleObjectProperty<>();
   private final SimpleObjectProperty<UUID>    uuidProperty = new SimpleObjectProperty<>();
   private final SimpleStringProperty          textProperty = new SimpleStringProperty();

   //~--- constructors --------------------------------------------------------

   public FxComponentReference(int nid) throws IOException {
      nidProperty.set(nid);
   }

   public FxComponentReference(UUID uuid) {
      uuidProperty.set(uuid);
   }

   public FxComponentReference(UUID primordialUuid, Integer nid, String text) {
      nidProperty.set(nid);
      uuidProperty.set(primordialUuid);
      textProperty.set(text);
   }

   //~--- methods -------------------------------------------------------------

   public SimpleObjectProperty<Integer> nidProperty() {
      return nidProperty;
   }

   @Override
   public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
      textProperty.set(in.readUTF());
      uuidProperty.set((UUID) in.readObject());
      nidProperty.set((Integer) in.readObject());
   }

   public SimpleStringProperty textProperty() {
      return textProperty;
   }

   @Override
   public String toString() {
      return "FxId{text=" + textProperty + ", nid=" + nidProperty + ", uuid=" + uuidProperty + '}';
   }

   public SimpleObjectProperty<UUID> uuidProperty() {
      return uuidProperty;
   }

   @Override
   public void writeExternal(ObjectOutput out) throws IOException {
      out.writeUTF(textProperty.get());
      out.writeObject(uuidProperty.get());
      out.writeObject(nidProperty.get());
   }

   //~--- get methods ---------------------------------------------------------

   /**
    * Get the value of nid
    *
    * @return the value of nid
    */
   public Integer getNid() {
      return nidProperty.get();
   }

   /**
    * Get the value of text
    *
    * @return the value of text
    */
   public String getText() {
      return textProperty.get();
   }

   /**
    * Get the value of uuid
    *
    * @return the value of uuid
    */
   public UUID getUuid() {
      return uuidProperty.get();
   }

   //~--- set methods ---------------------------------------------------------

   /**
    * Set the value of nid
    *
    * @param nid new value of nid
    */
   public void setNid(Integer nid) {
      nidProperty.set(nid);
   }

   /**
    * Set the value of text
    *
    * @param text new value of text
    */
   public void setText(String text) {
      textProperty.set(text);
   }

   /**
    * Set the value of uuid
    *
    * @param uuid new value of uuid
    */
   public void setUuid(UUID uuid) {
      uuidProperty.set(uuid);
   }
}
