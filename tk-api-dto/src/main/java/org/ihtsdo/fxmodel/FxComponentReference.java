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

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.UUID;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.ComponentVersionBI;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.concept.ConceptVersionBI;
import org.ihtsdo.tk.api.description.DescriptionVersionBI;

/**
 *
 * @author kec
 */
public class FxComponentReference implements Externalizable {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   private int                        nid = Integer.MAX_VALUE;
   private SimpleIntegerProperty      nidProperty;
   private String                     text;
   private SimpleStringProperty       textProperty;
   private UUID                       uuid;
   private SimpleObjectProperty<UUID> uuidProperty;

   //~--- constructors --------------------------------------------------------

   public FxComponentReference() {}

   public FxComponentReference(ConceptVersionBI concept) throws IOException, ContradictionException {
      nid  = concept.getNid();
      uuid = concept.getPrimUuid();
      text = concept.getPreferredDescription().getText();
   }

   public FxComponentReference(int nid) throws IOException {
      this.nid = nid;
   }

   public FxComponentReference(UUID uuid) {
      this.uuid = uuid;
   }

   public FxComponentReference(TerminologySnapshotDI ss, int nid) throws IOException, ContradictionException {
      this.nid = nid;

      ComponentVersionBI component = ss.getComponentVersion(nid);

      if (component != null) {
         uuid = component.getPrimUuid();

         if (component instanceof ConceptVersionBI) {
            text = ((ConceptVersionBI) component).getPreferredDescription().getText();
         } else if (component instanceof DescriptionVersionBI) {
            text = ((DescriptionVersionBI) component).getText();
         } else {
            text = component.getClass().getSimpleName();
         }
      } else {
         text = "null component";
      }
   }

   public FxComponentReference(UUID uuid, int nid, String text) {
      this.nid  = nid;
      this.uuid = uuid;
      this.text = text;
   }

   //~--- methods -------------------------------------------------------------

   @Override
   public boolean equals(Object obj) {
      if (obj instanceof FxComponentReference) {
         FxComponentReference another = (FxComponentReference) obj;

         return (getNid() == another.getNid()) || getUuid().equals(another.getUuid());
      }

      return false;
   }

   @Override
   public int hashCode() {
      throw new UnsupportedOperationException();
   }

   public SimpleIntegerProperty nidProperty() {
      if (nidProperty == null) {
         nidProperty = new SimpleIntegerProperty(this, "nid", Integer.valueOf(nid));
      }

      return nidProperty;
   }

   @Override
   public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
      text = in.readUTF();
      uuid = new UUID(in.readLong(), in.readLong());
      nid  = in.readInt();
   }

   public SimpleStringProperty textProperty() {
      if (textProperty == null) {
         textProperty = new SimpleStringProperty(this, "text", text);
      }

      return textProperty;
   }

   @Override
   public String toString() {
      return "Ref{text=" + getText() + ", nid=" + getNid() + ", uuid=" + getUuid() + '}';
   }

   public SimpleObjectProperty<UUID> uuidProperty() {
      if (uuidProperty == null) {
         uuidProperty = new SimpleObjectProperty<>(this, "uuid", uuid);
      }

      return uuidProperty;
   }

   @Override
   public void writeExternal(ObjectOutput out) throws IOException {
      out.writeUTF(getText());
      out.writeLong(getUuid().getMostSignificantBits());
      out.writeLong(getUuid().getLeastSignificantBits());
      out.writeInt(getNid());
   }

   //~--- get methods ---------------------------------------------------------

   /**
    * Get the value of nid
    *
    * @return the value of nid
    */
   public int getNid() {
      return (nidProperty == null)
             ? nid
             : nidProperty.get();
   }

   /**
    * Get the value of text
    *
    * @return the value of text
    */
   public String getText() {
      return (textProperty == null)
             ? text
             : textProperty.get();
   }
   
      
   public String getHtmlFragment() {
       StringBuilder sb = new StringBuilder();
       if (Ts.get().getConceptNidForNid(getNid()) == getNid()) {
        sb.append("<a href=\"../concept/");
       } else {
        sb.append("<a href=\"../component/");
       }
       sb.append(getUuid());
       sb.append("\">");
       sb.append(getText());
       sb.append("</a>");
       
       
       return sb.toString();
   }


   /**
    * Get the value of uuid
    *
    * @return the value of uuid
    */
   public UUID getUuid() {
      return (uuidProperty == null)
             ? uuid
             : uuidProperty.get();
   }

   //~--- set methods ---------------------------------------------------------

   /**
    * Set the value of nid
    *
    * @param nid new value of nid
    */
   public void setNid(int nid) {
      if (nidProperty == null) {
         this.nid = nid;
      } else {
         nidProperty.set(nid);
      }
   }

   /**
    * Set the value of text
    *
    * @param text new value of text
    */
   public void setText(String text) {
      if (textProperty == null) {
         this.text = text;
      } else {
         textProperty.set(text);
      }
   }

   /**
    * Set the value of uuid
    *
    * @param uuid new value of uuid
    */
   public void setUuid(UUID uuid) {
      if (uuidProperty == null) {
         this.uuid = uuid;
      } else {
         uuidProperty.set(uuid);
      }
   }
}
