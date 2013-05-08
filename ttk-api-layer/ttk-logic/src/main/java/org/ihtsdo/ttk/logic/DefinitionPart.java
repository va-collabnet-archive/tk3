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



package org.ihtsdo.ttk.logic;

//~--- non-JDK imports --------------------------------------------------------

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.util.Objects;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.refex.type_nid_boolean.RefexNidBooleanVersionBI;

/**
 *
 * @author kec
 */
public class DefinitionPart {

   /**
    * row and column of this definition part, as computed by a depth
    * first walk of the tree.
    */
   private int row, column;

   /** Field description */
   private final RefexVersionBI refexVersion;

   /**
    * Constructs ...
    *
    *
    * @param refexVersion
    */
   public DefinitionPart(RefexVersionBI refexVersion) {
      this.refexVersion = refexVersion;
   }
   
   public List<DefinitionPart> getChildren(Map<Integer, DefinitionPart> parts,
           ViewCoordinate xyz, int refexNid) throws IOException {
       if (refexVersion instanceof RefexNidBooleanVersionBI) {
           List<DefinitionPart> children = new ArrayList<>(1);
           RefexNidBooleanVersionBI edge = (RefexNidBooleanVersionBI) refexVersion;
           children.add(parts.get(edge.getNid1()));
           return children;
       } 
       Collection<? extends RefexVersionBI<?>> partAnnotations = 
               refexVersion.getAnnotationsActive(xyz, refexNid);
       List<DefinitionPart> children = new ArrayList<>(partAnnotations.size());
       for (RefexVersionBI<?> partAnnotation: partAnnotations) {
           children.add(parts.get(partAnnotation.getNid()));
       }
       return children;
   }

   /**
    * Method description
    *
    *
    * @param obj
    *
    * @return
    */
   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (getClass() != obj.getClass()) {
         return false;
      }

      final DefinitionPart other = (DefinitionPart) obj;

      if (this.refexVersion.getNid() != other.refexVersion.getNid()) {
         return false;
      }

      return true;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   @Override
   public int hashCode() {
      int hash = 3;

      hash = 53 * hash + Objects.hashCode(this.refexVersion.getNid());

      return hash;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public int getColumn() {
      return column;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public RefexVersionBI getRefexVersion() {
      return refexVersion;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public int getRow() {
      return row;
   }

   /**
    * Method description
    *
    *
    * @param column
    */
   public void setColumn(int column) {
      this.column = column;
   }

   /**
    * Method description
    *
    *
    * @param row
    */
   public void setRow(int row) {
      this.row = row;
   }

}
