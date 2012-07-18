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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.ihtsdo.cc.ReferenceConcepts;
import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.binding.SnomedMetadataRf2;

/**
 * Origin relationship data is stores the following data for each entry:
 * <br>
 * <br><code>[record length]</code>
 * <br><code>[typeNid]</code>
 * <br><code>[destinationNid]</code>
 * <br><code>[inferredBit + groupGtZeroBit + STAMP]</code>
 * <br><code>[groupId]</code> Only if indicated by groupGtZeroBit
 * <br><code>[inferredBit + groupGtZeroBit + STAMP]</code> addition record only if > 1 STAMP
 * <br><code>[group if indicated by groupGtZeroBit]</code> Only if indicated by groupGtZeroBit
 * <br><code>[inferredBit + groupGtZeroBit + STAMP]</code> addition record only if > 2 STAMP
 * <br><code>[group if indicated by groupGtZeroBit]</code> Only if indicated by groupGtZeroBit
 * <br>...
 * <br> Note this record has no member id. If inferred and stated relationships have the
 * same type, the STAMPs and groups are merged into a single integer. This combination of stated and inferred
 * saves 96 bits/inferred relationship, and makes search more efficient, since there is less data to
 * search over. In addition, the compression of STAMP, Group, and Inferred values for relationships in group 0
 * saves an additional 64 bits, for ~196 bit savings per relationship. Further savings are also realized by
 * not requiring each revision to represent the type and refinability, and eliminating an object pointer
 * for each revision (96 bits + 64 bits per revision).
 * @author kec
 */
public class RelationshipIndexRecord implements Iterator<RelationshipIndexRecord> {
   private static final int   DESTINATION_NID_OFFSET          = 2;
   protected static final int GROUP_BITMASK                   = (1 << 30);
   protected static final int INFERRED_BITMASK                = (1 << 31);
   private static final int   RECORD_LENGTH_OFFSET            = 0;
   private static final int   STAMP_INFERRED_HAS_GROUP_OFFSET = 3;
   private static final int   TYPE_NID_OFFSET                 = 1;
   private static int         inferredNid                     = Integer.MAX_VALUE;
   private static int         statedNid                       = Integer.MAX_VALUE;

   //~--- fields --------------------------------------------------------------

   int[] data;
   int   offset;
   int   relationshipDataEnd;

   //~--- constructors --------------------------------------------------------

   public RelationshipIndexRecord(int[] data, int offset, int relationshipDataEnd) {
      this.data                = data;
      this.offset              = offset;
      this.relationshipDataEnd = relationshipDataEnd;
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Allows iteration over the relationship records without allocating an object for each
    * record, it just reuses this object, but updates the offset to point to the next record.
    * @return this <code>RelationshipIndexRecord</code> with the offset of the next record,
    * or null if the end of the relationship data is
    */
   public RelationshipIndexRecord advance() {
      if (hasNext()) {
         offset = offset + data[offset + RECORD_LENGTH_OFFSET];

         return this;
      }

      throw new NoSuchElementException();
   }

   @Override
   public RelationshipIndexRecord next() {
      if (hasNext()) {
         return new RelationshipIndexRecord(data, offset + data[offset + RECORD_LENGTH_OFFSET],
                                            relationshipDataEnd);
      }

      throw new NoSuchElementException();
   }

   @Override
   public void remove() {
      throw new UnsupportedOperationException("Not supported.");
   }

   //~--- get methods ---------------------------------------------------------

   public int getDestinationNid() {
      return data[offset + DESTINATION_NID_OFFSET];
   }

   public int getTypeNid() {
      return data[offset + TYPE_NID_OFFSET];
   }

   public List<RelationshipIndexVersion> getVersions() throws IOException {
      if (inferredNid == Integer.MAX_VALUE) {
         if (Ts.get() != null) {
            inferredNid = SnomedMetadataRf2.INFERRED_RELATIONSHIP_RF2.getLenient().getNid();
            statedNid   = SnomedMetadataRf2.STATED_RELATIONSHIP_RF2.getLenient().getNid();
         } else {
            inferredNid = 99;
            statedNid   = 100;
         }
      }

      List<RelationshipIndexVersion> versions = new ArrayList<>();
      int                            end      = offset + data[offset + RECORD_LENGTH_OFFSET];
      int firstStamp = offset + STAMP_INFERRED_HAS_GROUP_OFFSET;
      for (int i = firstStamp; i < end; i++) {
         int stamp = data[i];

         stamp &= ~INFERRED_BITMASK;    // Clears the flag using bitwise AND and NOT
         stamp &= ~GROUP_BITMASK;       // Clears the flag using bitwise AND and NOT

         int characteristicNid;
         int group = 0;

         if ((data[i] & INFERRED_BITMASK) != 0) {
            characteristicNid = inferredNid;
         } else {
            characteristicNid = statedNid;
         }

         if ((data[i] & GROUP_BITMASK) != 0) {
            group = data[i++];
         }

         versions.add(new RelationshipIndexVersion(stamp, characteristicNid, group));
      }

      return versions;
   }

   @Override
   public boolean hasNext() {
      if (offset + data[offset + RECORD_LENGTH_OFFSET] < relationshipDataEnd) {
         return true;
      }

      return false;
   }

   //~--- set methods ---------------------------------------------------------

   public static int setGroupFlag(int stamp, boolean groupGtZero) {
      if (groupGtZero) {
         stamp |= GROUP_BITMASK;    // Sets the flag using bitwise OR
      }

      return stamp;
   }

   public static int setInferredFlag(int stamp, boolean inferred) {
      if (inferred) {
         stamp |= INFERRED_BITMASK;    // Sets the flag using bitwise OR
      }

      return stamp;
   }
}
