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
package org.ihtsdo.otf.query;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.search.DocIdSetIterator;
import org.apache.lucene.util.OpenBitSet;
import org.ihtsdo.ttk.api.NativeIdSetBI;
import org.ihtsdo.ttk.api.NidBitSetBI;
import org.ihtsdo.ttk.api.NidBitSetItrBI;

/**
 *
 * @author dylangrald
 */
public class IdentifierSet implements NativeIdSetBI, NidBitSetBI, Serializable {
// See http://stackoverflow.com/questions/12424633/atomicbitset-implementation-for-java
    // TODO Consider using an implementation that uses
    // AtomicLongArray rather than simply a long[]...
    // Find power-of-two sizes best matching arguments
    private static int concurrencyLevel = 128;
    private static int sshift = 0;
    private static int ssize = 1;
    private static int segmentShift = 32 - sshift;
    private static int segmentMask = ssize - 1;
    private static ReentrantLock[] locks = new ReentrantLock[concurrencyLevel];
    private static Semaphore expandPermit = new Semaphore(1);

    //~--- static initializers -------------------------------------------------
    static {
        while (ssize < concurrencyLevel) {
            ++sshift;
            ssize <<= 1;
        }
    }

    static {
        for (int i = 0; i < concurrencyLevel; i++) {
            locks[i] = new ReentrantLock();
        }
    }
    //~--- fields --------------------------------------------------------------
    private int offset = Integer.MIN_VALUE;
    private int toStringMax = 10;
    protected OpenBitSet bitSet;

    //~--- constructors --------------------------------------------------------
    public IdentifierSet() {
        bitSet = new OpenBitSet();
    }

    public IdentifierSet(IdentifierSet anotherSet) {
        super();
        this.bitSet = (OpenBitSet) anotherSet.bitSet.clone();
    }

    public IdentifierSet(IntSet other) {
        super();
        int[] otherSetValues = other.getSetValues();
        int last = otherSetValues[otherSetValues.length - 1];
        int first = otherSetValues[0];
        this.bitSet = new OpenBitSet(last - first + 1);
        //this.bitSet = new OpenBitSet();

        for (int i : otherSetValues) {
            this.setMember(i);
        }
    }

    public IdentifierSet(int[] other) {
        Arrays.sort(other);
        int last = other[other.length - 1];
        int first = other[0];
        this.bitSet = new OpenBitSet(last - first + 1);
        //this.bitSet = new OpenBitSet();

        for (int i : other) {
            this.setMember(i);
        }
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
     * org.dwfa.ace.api.I_RepresentIdSet#and(org.dwfa.ace.api.IdentifierSet)
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

    @Override
    public boolean equals(Object obj) {
        if (IdentifierSet.class.isAssignableFrom(obj.getClass())) {
            IdentifierSet another = (IdentifierSet) obj;

            return this.bitSet.equals(another.bitSet);
        }

        return super.equals(obj);
    }


    /*
     * (non-Javadoc)
     *
     * @see org.dwfa.ace.api.I_RepresentIdSet#or(org.dwfa.ace.api.IdentifierSet)
     */
    @Override
    public void or(NidBitSetBI other) {
        bitSet.or(((IdentifierSet) other).bitSet);
    }

    @Override
    public int size() {
        return (int) bitSet.cardinality();
    }

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder();

        buff.append("IdentifierSet: cardinality: ");
        buff.append(bitSet.cardinality());
        buff.append(" ");
        /*
         I_IterateIds idIterator = iterator();
         int count = 0;
         int cardinality = (int) bitSet.cardinality();

         if (Terms.get() == null) {
         int[] theValues = this.getSetValues();
         buff.append("[");
         for (int i : theValues) {
         buff.append(i + ", ");
         }
         buff.delete(buff.length() - 2, buff.length());
         buff.append("]");
         return buff.toString();
         }
         try {
         buff.append("[");

         while ((count < toStringMax) && idIterator.next()) {
         try {
         buff.append(Terms.get().getComponent(idIterator.nid()).toString());
         } catch (TerminologyException e) {
         buff.append(e.toString());
         }


         if ((count == 10) && (count < cardinality)) {
         buff.append(", ...");
         }
         }

         buff.append("]");
         } catch (IOException e) {
         e.printStackTrace();
         }
         */
        return buff.toString();
    }

    @Override
    public int totalBits() {
        return (int) (bitSet.getNumWords() * 64L) - 1;
    }

    @Override
    public void union(NidBitSetBI other) {
        bitSet.union(((IdentifierSet) other).bitSet);
    }

    @Override
    public void xor(NidBitSetBI other) {
        bitSet.xor(((IdentifierSet) other).bitSet);
    }

//    @Override
    public NidBitSetItrBI iterator() {
        return new NidIterator(bitSet.iterator());
    }

    @Override
    public void setMember(int nid) {
        int word = (nid >>> segmentShift) & segmentMask;

        locks[word].lock();

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
            locks[word].unlock();
        }

    }

    public void setToStringMax(int toStringMax) {
        this.toStringMax = toStringMax;
    }

    public void setAll() {
        bitSet.set(0, bitSet.size());
    }

    public void and(NativeIdSetBI other) {
        for (int i : this.getSetValues()) {
            if (!other.isMember(i)) {
                this.remove(i);
            }
        }
    }

    @Override
    public void andNot(NativeIdSetBI other) {
        int[] otherSet = other.getSetValues();
        for (int i : otherSet) {
            if (this.isMember(i)) {
                this.remove(i);
            }
        }
    }

    @Override
    public boolean contains(int nid) {
        return this.isMember(nid);
    }

    @Override
    public int[] getSetValues() {
        int[] intArray = new int[(int) bitSet.cardinality()];
        int count = 0;
        NidBitSetItrBI idIterator = iterator();
        try {
            while (idIterator.next()) {
                intArray[count] = idIterator.nid();
                count++;


            }
        } catch (IOException ex) {
            Logger.getLogger(IdentifierSet.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return intArray;

    }

    public int getOffset() {
        return this.offset;
    }

    @Override
    public void add(int nid) {
        this.setMember(nid);
    }

    @Override
    public void remove(int nid) {
        this.setNotMember(nid);
    }

//    @Override
    @Override
    public void addAll(int[] nids) {
        for (int i : nids) {
            this.setMember(i);
        }
    }

    @Override
    public void removeAll(int[] nids) {
        for (int i : nids) {
            this.setNotMember(i);
        }
    }

    @Override
    public int getMax() {
        int[] theValues = this.getSetValues();
        if (theValues.length > 0) {
            return theValues[theValues.length - 1];
        } else {
            return 0;
        }
    }

    @Override
    public int getMin() {
        int[] theValues = this.getSetValues();
        if (theValues.length > 0) {
            return theValues[0];
        } else {
            return 0;
        }
    }

    @Override
    public boolean contiguous() {
        int[] theValues = this.getSetValues();
        if (theValues.length < 2) {
            return true;
        } else {
            for (int i = 0; i < theValues.length - 1; i++) {
                if (theValues[i + 1] - theValues[i] > 1) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public void union(NativeIdSetBI other) {
        int[] otherSet = other.getSetValues();
        for (int i : otherSet) {
            this.setMember(i);
        }
    }

    @Override
    public void xor(NativeIdSetBI other) {
        int[] otherSet = other.getSetValues();
        for (int i : otherSet) {
            if (!this.isMember(i)) {
                this.setMember(i);
            } else {
                this.setNotMember(i);


            }
        }
    }

    @Override
    public void setNotMember(int nid) {
        int word = (nid >>> segmentShift) & segmentMask;

        locks[word].lock();

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
            locks[word].unlock();
        }
    }

    @Override
    public boolean isMember(int nid) {
        int index = nid + offset;
        return bitSet.get(index);

    }

    @Override
    public void or(NativeIdSetBI other) {
        int[] otherSet = other.getSetValues();
        for (int i : otherSet) {
            this.setMember(i);
        }
    }
    //~--- inner classes -------------------------------------------------------

    @Override
    public NidBitSetItrBI getIterator() {
        return new NidIterator(this.bitSet.iterator());
    }

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
            /*
             try {
             if (nid() != Integer.MAX_VALUE) {
             Object component = Terms.get().getComponent(nid());

             if (component != null) {
             buff.append(component.toString());
             } else {
             buff.append(nid());
             }
             } else {
             buff.append(nid());
             }
             } catch (TerminologyException e) {
             AceLog.getAppLog().alertAndLogException(e);
             } catch (IOException e) {
             AceLog.getAppLog().alertAndLogException(e);
             }*/

            return buff.toString();
        }
    }
}
