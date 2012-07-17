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



package org.ihtsdo.bdb.id;

/**
 *
 * @author kec
 */
public class CrossReferenceRecord {
   private static final int DESTINATION_OFFSET_INDEX = 0;
   private static final int REFEX_OFFSET_INDEX       = 1;
   private static final int RELATIONSHIP_OFFSET      = 2;

   //~--- fields --------------------------------------------------------------

   private int[] data;

   //~--- constructors --------------------------------------------------------

   public CrossReferenceRecord(int[] data) {
      this.data = data;
   }

   //~--- methods -------------------------------------------------------------

   public int[] updateData(int[] relationshipOutgoingData, int[] destinationOriginData, int[] refexData) {
      int length = relationshipOutgoingData.length + destinationOriginData.length + refexData.length
                   + RELATIONSHIP_OFFSET;

      data                           = new int[length];
      data[DESTINATION_OFFSET_INDEX] = relationshipOutgoingData.length + RELATIONSHIP_OFFSET;
      data[REFEX_OFFSET_INDEX]       = data[DESTINATION_OFFSET_INDEX] + destinationOriginData.length;
      System.arraycopy(relationshipOutgoingData, 0, data, RELATIONSHIP_OFFSET,
                       relationshipOutgoingData.length);
      System.arraycopy(destinationOriginData, 0, data, data[DESTINATION_OFFSET_INDEX],
                       destinationOriginData.length);
      System.arraycopy(refexData, 0, data, data[REFEX_OFFSET_INDEX], refexData.length);

      return data;
   }

   //~--- get methods ---------------------------------------------------------

   public int[] getDestinationOriginNids() {
      int   arrayLength           = data[REFEX_OFFSET_INDEX] - data[DESTINATION_OFFSET_INDEX];
      int[] destinationOriginNids = new int[arrayLength];

      System.arraycopy(data, data[DESTINATION_OFFSET_INDEX], destinationOriginNids, 0, arrayLength);

      return destinationOriginNids;
   }

   public int[] getRefexIndexArray() {
      int   arrayLength               = data.length - data[REFEX_OFFSET_INDEX];
      int[] relationshipOutgoingArray = new int[arrayLength];

      if (arrayLength > 0) {
         System.arraycopy(data, data[REFEX_OFFSET_INDEX], relationshipOutgoingArray, 0, arrayLength);
      }

      return relationshipOutgoingArray;
   }

   public int[] getRelationshipOutgoingArray() {
      int   arrayLength               = data[DESTINATION_OFFSET_INDEX] - RELATIONSHIP_OFFSET;
      int[] relationshipOutgoingArray = new int[arrayLength];

      if (arrayLength > 0) {
         System.arraycopy(data, RELATIONSHIP_OFFSET, relationshipOutgoingArray, 0, arrayLength);
      }

      return relationshipOutgoingArray;
   }
}
