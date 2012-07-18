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

import java.util.Arrays;
import org.ihtsdo.cc.NidPairForRefex;

/**
 * Stores cross-reference information for origin relationships, destination relationship origins, and 
 * refex referenced components in a integer array, minimizing the object allocation burden that would
 * otherwise be associated with this information. This class interprets and manages the contents of that array.
 * <br>
 * <h2>Implementation notes</h2>
 * See the class <code>RelationshipIndexRecord</code> for documentation of the structure of the
 * relationship index data.
 * @see RelationshipIndexRecord
 * @author kec
 */
public class IndexCacheRecord {
   private static final int DESTINATION_OFFSET_INDEX = 0;
   private static final int REFEX_OFFSET_INDEX       = 1;
   private static final int RELATIONSHIP_OFFSET      = 2;

   //~--- fields --------------------------------------------------------------

   private int[] data;

   //~--- constructors --------------------------------------------------------

   public IndexCacheRecord(int[] data) {
      this.data = data;
   }

   //~--- methods -------------------------------------------------------------

   public void addDestinationOriginNid(int originNid) {
      int arrayLength = data[REFEX_OFFSET_INDEX] - data[DESTINATION_OFFSET_INDEX];
      int index       = Arrays.binarySearch(data, data[DESTINATION_OFFSET_INDEX],
                                      data[DESTINATION_OFFSET_INDEX] + arrayLength, originNid);

      if (index >= 0) {
         return;    // origin already there...
      }

      int[] destinationOriginNids = new int[arrayLength + 1];

      destinationOriginNids[arrayLength] = originNid;
      System.arraycopy(data, data[DESTINATION_OFFSET_INDEX], destinationOriginNids, 0,
                       destinationOriginNids.length - 1);
      Arrays.sort(destinationOriginNids);
      updateData(getRelationshipOutgoingArray(), destinationOriginNids, getRefexIndexArray());
   }

   public void addNidPairForRefex(int refexNid, int memberNid) {
      int arrayLength = data.length - data[REFEX_OFFSET_INDEX];
      int start       = data.length - arrayLength;

      for (int i = start; i < data.length; i++) {
         if (data[i] == memberNid) {
            return;    // already there...
         }
      }

      int[] nidPairForRefexArray = new int[arrayLength + 2];

      nidPairForRefexArray[arrayLength] = refexNid;
      nidPairForRefexArray[arrayLength+1]     = memberNid;
      System.arraycopy(data, data[REFEX_OFFSET_INDEX], nidPairForRefexArray, 0,
                       nidPairForRefexArray.length - 2);
      updateData(getRelationshipOutgoingArray(), getDestinationOriginNids(), nidPairForRefexArray);
   }

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

   public NidPairForRefex[] getNidPairsForRefsets() {
      int arrayLength = data.length - data[REFEX_OFFSET_INDEX];

      assert arrayLength % 2 == 0;

      if (arrayLength < 2) {
         return new NidPairForRefex[0];
      }

      NidPairForRefex[] returnValues = new NidPairForRefex[arrayLength / 2];
      int                start        = data[REFEX_OFFSET_INDEX];
      int                returnIndex  = 0;

      for (int i = start; i < data.length; i = i + 2) {
         returnValues[returnIndex++] = NidPairForRefex.getRefexNidMemberNidPair(data[i], data[i + 1]);
      }

      return returnValues;
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
