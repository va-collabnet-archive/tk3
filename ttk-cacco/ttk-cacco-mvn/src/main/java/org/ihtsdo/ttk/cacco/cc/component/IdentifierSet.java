/**
 * Copyright (c) 2009 International Health Terminology Standards Development
 * Organisation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



package org.ihtsdo.ttk.cacco.cc.component;

//~--- non-JDK imports --------------------------------------------------------

import org.apache.lucene.search.DocIdSetIterator;
import org.apache.lucene.util.OpenBitSet;

import org.ihtsdo.ttk.cacco.cc.P;
import org.ihtsdo.ttk.helpers.concurrency.ConcurrentReentrantLocks;
import org.ihtsdo.ttk.api.NidBitSetBI;
import org.ihtsdo.ttk.api.NidBitSetItrBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;
import java.io.Serializable;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IdentifierSet implements NidBitSetBI, Serializable {
   protected static final Logger           logger       = Logger.getLogger(IdentifierSet.class.getName());
   private static ConcurrentReentrantLocks locks        = new ConcurrentReentrantLocks(128);
   private static Semaphore                expandPermit = new Semaphore(1);

   //~--- fields --------------------------------------------------------------

   private int          offset      = Integer.MIN_VALUE;
   private int          toStringMax = 10;
   protected OpenBitSet bitSet;

   //~--- constructors --------------------------------------------------------

   public IdentifierSet() {
      bitSet = new OpenBitSet();
   }

   public IdentifierSet(IdentifierSet anotherSet) {
      super();
      this.bitSet = (OpenBitSet) anotherSet.bitSet.clone();
   }

   public IdentifierSet(int numBits) {
      bitSet = new OpenBitSet(numBits);
   }

   public IdentifierSet(OpenBitSet bitSet) {
      super();
      this.bitSet = bitSet;
   }

   //~--- methods -------------------------------------------------------------

   /*
    * (non-Javadoc)
    *
    * @see
    * org.dwfa.ace.api.NidBitSetBI#and(org.dwfa.ace.api.IdentifierSet)
    */
   @Override
   public void and(NidBitSetBI other) {
      bitSet.and(((IdentifierSet) other).bitSet);
   }

   @Override
   public void andNot(NidBitSetBI other) {
      bitSet.andNot(((IdentifierSet) other).bitSet);
   }

   @Override
   public int cardinality() {
      return (int) bitSet.cardinality();
   }

   @Override
   public void clear() {
      bitSet.clear(0, bitSet.capacity());
   }

   public NidBitSetBI duplicate() {
      return new IdentifierSet((OpenBitSet) bitSet.clone());
   }

   @Override
   public boolean equals(Object obj) {
      if (IdentifierSet.class.isAssignableFrom(obj.getClass())) {
         IdentifierSet another = (IdentifierSet) obj;

         return this.bitSet.equals(another.bitSet);
      }

      return super.equals(obj);
   }

   @Override
   public NidBitSetItrBI iterator() {
      return new NidIterator(bitSet.iterator());
   }

   /*
    * (non-Javadoc)
    *
    * @see org.dwfa.ace.api.NidBitSetBI#or(org.dwfa.ace.api.IdentifierSet)
    */
   @Override
   public void or(NidBitSetBI other) {
      bitSet.or(((IdentifierSet) other).bitSet);
   }

   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append("IdentifierSet: cardinality: ");
      buff.append(bitSet.cardinality());
      buff.append(" ");

      NidBitSetItrBI idIterator  = iterator();
      int            count       = 0;
      int            cardinality = (int) bitSet.cardinality();

      try {
         buff.append("[");

         while ((count < toStringMax) && idIterator.next()) {
            buff.append(P.s.getComponent(idIterator.nid()).toString());
            count++;

            if ((count == 10) && (count < cardinality)) {
               buff.append(", ...");
            } else if (count < cardinality) {
               buff.append(", ");
            }
         }

         buff.append("]");
      } catch (IOException e) {
         logger.log(Level.SEVERE, "Exception converting IdentifierSet to String.", e);
      }

      return buff.toString();
   }

   @Override
   public int totalBits() {
      return bitSet.getNumWords() * 64;
   }

   @Override
   public void union(NidBitSetBI other) {
      bitSet.union(((IdentifierSet) other).bitSet);
   }

   @Override
   public void xor(NidBitSetBI other) {
      bitSet.xor(((IdentifierSet) other).bitSet);
   }

   //~--- get methods ---------------------------------------------------------

   public String getDifferences(IdentifierSet that) throws IOException {
      StringBuilder buff = new StringBuilder();

      buff.append("this->that differences: \n");

      NidBitSetItrBI thisItr = this.iterator();

      while (thisItr.next()) {
         if (!that.isMember(thisItr.nid())) {
            buff.append("   that missing: ");
            buff.append(thisItr.nid());
            buff.append("\n");
         }
      }

      buff.append("\n\nthat->this differences: \n");

      NidBitSetItrBI thatItr = this.iterator();

      while (thatItr.next()) {
         if (!this.isMember(thatItr.nid())) {
            buff.append("   this missing: ");
            buff.append(thatItr.nid());
            buff.append("\n");
         }
      }

      return buff.toString();
   }

   public int getToStringMax() {
      return toStringMax;
   }

   /*
    * (non-Javadoc)
    *
    * @see org.dwfa.ace.api.NidBitSetBI#isMember(int)
    */
   @Override
   public boolean isMember(int nid) {
      int index = nid + offset;

      if (index < bitSet.size()) {
         return bitSet.get(index);
      }

      return false;
   }

   //~--- set methods ---------------------------------------------------------

   /*
    * (non-Javadoc)
    *
    * @see org.dwfa.ace.api.NidBitSetBI#setMember(int)
    */
   @Override
   public void setMember(int nid) {
      locks.lock(nid);

      try {
         int index = nid + offset;

         expandPermit.acquireUninterruptibly();

         try {
            bitSet.ensureCapacity(index);
         } finally {
            expandPermit.release();
         }

         bitSet.set(index);
      } finally {
         locks.unlock(nid);
      }
   }

   /*
    * (non-Javadoc)
    *
    * @see org.dwfa.ace.api.NidBitSetBI#setNotMember(int)
    */
   @Override
   public void setNotMember(int nid) {
      locks.lock(nid);

      try {
         int index = nid + offset;

         expandPermit.acquireUninterruptibly();

         try {
            bitSet.ensureCapacity(index);
         } finally {
            expandPermit.release();
         }

         bitSet.clear(index);
      } finally {
         locks.unlock(nid);
      }
   }

   public void setToStringMax(int toStringMax) {
      this.toStringMax = toStringMax;
   }

   //~--- inner classes -------------------------------------------------------

   private class NidIterator implements NidBitSetItrBI {
      private DocIdSetIterator docIterator;

      //~--- constructors -----------------------------------------------------

      private NidIterator(DocIdSetIterator docIterator) {
         super();
         this.docIterator = docIterator;
      }

      //~--- methods ----------------------------------------------------------

      @Override
      public boolean next() throws IOException {
         return docIterator.nextDoc() != DocIdSetIterator.NO_MORE_DOCS;
      }

      @Override
      public int nid() {
         return docIterator.docID() + offset;
      }

      @Override
      public boolean skipTo(int target) throws IOException {
         return docIterator.advance(target + offset) != DocIdSetIterator.NO_MORE_DOCS;
      }

      @Override
      public String toString() {
         StringBuilder buff = new StringBuilder();

         buff.append("NidIterator: nid: ");
         buff.append(nid());
         buff.append(" component: ");

         try {
            if (nid() != Integer.MAX_VALUE) {
               Object component = P.s.getComponent(nid());

               if (component != null) {
                  buff.append(component.toString());
               } else {
                  buff.append(nid());
               }
            } else {
               buff.append(nid());
            }
         } catch (IOException e) {
            logger.log(Level.SEVERE, "Exception converting NidIterator to String.", e);
         }

         return buff.toString();
      }
   }
}
