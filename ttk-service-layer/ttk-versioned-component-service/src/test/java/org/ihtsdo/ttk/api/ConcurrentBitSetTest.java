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
package org.ihtsdo.ttk.api;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dylangrald
 */
public class ConcurrentBitSetTest {

    public ConcurrentBitSetTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of get method, of class ConcurrentBitSet.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        ConcurrentBitSet instance = new ConcurrentBitSet(5);
        instance.set(1);
        System.out.println(instance.toString());
        assertTrue(instance.get(1));
    }

    /**
     * Test of set method, of class ConcurrentBitSet.
     */
    @Test
    public void testSet_int_boolean() {
        System.out.println("set");
        ConcurrentBitSet instance = new ConcurrentBitSet(5);
        instance.set(1);
        System.out.println(instance.toString());
        assertTrue(instance.get(1));
        instance.set(1, false);
        System.out.println(instance.toString());
        assertTrue(!instance.get(1));
    }

    /**
     * Test of set method, of class ConcurrentBitSet.
     */
    @Test
    public void testSet_int() {
        System.out.println("set");
        int bit = 0;
        ConcurrentBitSet instance = new ConcurrentBitSet();
        instance.set(bit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class ConcurrentBitSet.
     */
    @Test
    public void testClear_int() {
        System.out.println("clear");
        int bit = 0;
        ConcurrentBitSet instance = new ConcurrentBitSet();
        instance.clear(bit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearAll method, of class ConcurrentBitSet.
     */
    @Test
    public void testClearAll() {
        System.out.println("clearAll");
        ConcurrentBitSet instance = new ConcurrentBitSet(5);
        instance.set(3);
        instance.set(1);
        assertTrue(instance.contains(3));
        instance.clearAll();
        assertEquals(0, instance.size());
    }

    /**
     * Test of nextSetBit method, of class ConcurrentBitSet.
     */
    @Test
    public void testNextSetBit() {
        System.out.println("nextSetBit");
        ConcurrentBitSet instance = new ConcurrentBitSet(5);
        instance.set(3);
        instance.set(1);
        assertTrue(instance.contains(3));
        assertEquals(3, instance.nextSetBit(2));
    }

    /**
     * Test of length method, of class ConcurrentBitSet.
     */
    @Test
    public void testLength() {
        System.out.println("length");
         ConcurrentBitSet instance = new ConcurrentBitSet();
        instance.set(3);
        instance.set(1);
        assertEquals(4, instance.length());
    }

    /**
     * Test of and method, of class ConcurrentBitSet.
     */
    @Test
    public void testAnd_ConcurrentBitSet() {
        System.out.println("and");
        ConcurrentBitSet first = new ConcurrentBitSet(5);
        ConcurrentBitSet second = new ConcurrentBitSet(5);
        first.addAll(new int[] {1,2,5});
        second.addAll(new int[] {1,3,5});
        first.and(second);
        assertArrayEquals(new int[] {1,5}, first.getSetValues());
        
    }

    /**
     * Test of or method, of class ConcurrentBitSet.
     */
    @Test
    public void testOr_ConcurrentBitSet() {
        System.out.println("or");
        ConcurrentBitSet first = new ConcurrentBitSet(5);
        ConcurrentBitSet second = new ConcurrentBitSet(5);
        first.addAll(new int[] {1,2,5});
        second.addAll(new int[] {1,3,5});
        first.or(second);
        assertArrayEquals(new int[] {1,2,3,5}, first.getSetValues());
    }

    /**
     * Test of xor method, of class ConcurrentBitSet.
     */
    @Test
    public void testXor_ConcurrentBitSet() {
        System.out.println("xor");
        ConcurrentBitSet first = new ConcurrentBitSet(5);
        ConcurrentBitSet second = new ConcurrentBitSet(5);
        first.addAll(new int[] {1,2,5});
        second.addAll(new int[] {1,3,5});
        first.xor(second);
        assertArrayEquals(new int[] {2,3}, first.getSetValues());
    }

    /**
     * Test of andNot method, of class ConcurrentBitSet.
     */
    @Test
    public void testAndNot_ConcurrentBitSet() {
        System.out.println("andNot");
        ConcurrentBitSet first = new ConcurrentBitSet(5);
        ConcurrentBitSet second = new ConcurrentBitSet(5);
        first.addAll(new int[] {1,2,5});
        second.addAll(new int[] {1,3,5});
        first.andNot(second);
        assertArrayEquals(new int[] {2}, first.getSetValues());
    }

    /**
     * Test of toLongArray method, of class ConcurrentBitSet.
     */
    @Test
    public void testToLongArray_0args() {
        System.out.println("toLongArray");
        ConcurrentBitSet instance = new ConcurrentBitSet();
        long[] expResult = null;
        long[] result = instance.toLongArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toLongArray method, of class ConcurrentBitSet.
     */
    @Test
    public void testToLongArray_longArr_int() {
        System.out.println("toLongArray");
        long[] arr = null;
        int offset = 0;
        ConcurrentBitSet instance = new ConcurrentBitSet();
        long[] expResult = null;
        long[] result = instance.toLongArray(arr, offset);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toIntArray method, of class ConcurrentBitSet.
     */
    @Test
    public void testToIntArray_0args() {
        System.out.println("toIntArray");
        ConcurrentBitSet instance = new ConcurrentBitSet();
        int[] expResult = null;
        int[] result = instance.toIntArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toIntArray method, of class ConcurrentBitSet.
     */
    @Test
    public void testToIntArray_intArr_int() {
        System.out.println("toIntArray");
        int[] arr = null;
        int offset = 0;
        ConcurrentBitSet instance = new ConcurrentBitSet();
        int[] expResult = null;
        int[] result = instance.toIntArray(arr, offset);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cardinality method, of class ConcurrentBitSet.
     */
    @Test
    public void testCardinality() {
        System.out.println("cardinality");
        ConcurrentBitSet instance = new ConcurrentBitSet();
        int expResult = 0;
        int result = instance.cardinality();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIterator method, of class ConcurrentBitSet.
     */
    @Test
    public void testGetIterator() {
        System.out.println("getIterator");
        ConcurrentBitSet instance = new ConcurrentBitSet();
        NidBitSetItrBI expResult = null;
        NidBitSetItrBI result = instance.getIterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class ConcurrentBitSet.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        ConcurrentBitSet instance = new ConcurrentBitSet(5);
        instance.set(1);
        assertEquals(1,instance.size());
        instance.set(2);
        assertEquals(2, instance.size());
        
    }

    /**
     * Test of isMember method, of class ConcurrentBitSet.
     */
    @Test
    public void testIsMember() {
        System.out.println("isMember");
        ConcurrentBitSet instance = new ConcurrentBitSet(5);
        instance.set(3);
        assertTrue(instance.contains(3));
    }

    /**
     * Test of setMember method, of class ConcurrentBitSet.
     */
    @Test
    public void testSetMember() {
        System.out.println("setMember");
        ConcurrentBitSet instance = new ConcurrentBitSet(5);
        instance.setMember(3);
        assertTrue(instance.contains(3));
    }

    /**
     * Test of and method, of class ConcurrentBitSet.
     */
    @Test
    public void testAnd_NativeIdSetBI() {
        System.out.println("and");
        NativeIdSetBI other = null;
        ConcurrentBitSet instance = new ConcurrentBitSet();
        instance.and(other);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of or method, of class ConcurrentBitSet.
     */
    @Test
    public void testOr_NativeIdSetBI() {
        System.out.println("or");
        NativeIdSetBI other = null;
        ConcurrentBitSet instance = new ConcurrentBitSet();
        instance.or(other);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of xor method, of class ConcurrentBitSet.
     */
    @Test
    public void testXor_NativeIdSetBI() {
        System.out.println("xor");
        NativeIdSetBI other = null;
        ConcurrentBitSet instance = new ConcurrentBitSet();
        instance.xor(other);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class ConcurrentBitSet.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
         ConcurrentBitSet instance = new ConcurrentBitSet(5);
        instance.set(3);
        instance.set(1);
        assertTrue(instance.contains(3));
    }

    /**
     * Test of getSetValues method, of class ConcurrentBitSet.
     */
    @Test
    public void testGetSetValues() {
        System.out.println("getSetValues");
        ConcurrentBitSet instance = new ConcurrentBitSet(5);
        instance.set(3);
        instance.set(1);
        instance.set(4);
        //System.out.println(instance.getSetValues().toString());
        assertArrayEquals(new int[] {1,3,4}, instance.toIntArray());
    }

    /**
     * Test of add method, of class ConcurrentBitSet.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        ConcurrentBitSet instance = new ConcurrentBitSet(5);
        instance.add(3);
        instance.add(1);
        assertTrue(instance.contains(3));
    }

    /**
     * Test of addAll method, of class ConcurrentBitSet.
     */
    @Test
    public void testAddAll() {
        System.out.println("addAll");
        int[] nids = null;
        ConcurrentBitSet instance = new ConcurrentBitSet();
        instance.addAll(nids);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class ConcurrentBitSet.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        int nid = 0;
        ConcurrentBitSet instance = new ConcurrentBitSet();
        instance.remove(nid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAll method, of class ConcurrentBitSet.
     */
    @Test
    public void testRemoveAll() {
        System.out.println("removeAll");
        int[] nids = null;
        ConcurrentBitSet instance = new ConcurrentBitSet();
        instance.removeAll(nids);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class ConcurrentBitSet.
     */
    @Test
    public void testClear_0args() {
        System.out.println("clear");
        ConcurrentBitSet instance = new ConcurrentBitSet();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMax method, of class ConcurrentBitSet.
     */
    @Test
    public void testGetMax() {
        System.out.println("getMax");
        ConcurrentBitSet instance = new ConcurrentBitSet();
        int expResult = 0;
        int result = instance.getMax();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMin method, of class ConcurrentBitSet.
     */
    @Test
    public void testGetMin() {
        System.out.println("getMin");
        ConcurrentBitSet instance = new ConcurrentBitSet();
        int expResult = 0;
        int result = instance.getMin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contiguous method, of class ConcurrentBitSet.
     */
    @Test
    public void testContiguous() {
        System.out.println("contiguous");
        ConcurrentBitSet instance = new ConcurrentBitSet();
        boolean expResult = false;
        boolean result = instance.contiguous();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of union method, of class ConcurrentBitSet.
     */
    @Test
    public void testUnion() {
        System.out.println("union");
        NativeIdSetBI other = null;
        ConcurrentBitSet instance = new ConcurrentBitSet();
        instance.union(other);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNotMember method, of class ConcurrentBitSet.
     */
    @Test
    public void testSetNotMember() {
        System.out.println("setNotMember");
        int nid = 0;
        ConcurrentBitSet instance = new ConcurrentBitSet();
        instance.setNotMember(nid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of andNot method, of class ConcurrentBitSet.
     */
    @Test
    public void testAndNot_NativeIdSetBI() {
        System.out.println("andNot");
        NativeIdSetBI other = null;
        ConcurrentBitSet instance = new ConcurrentBitSet();
        instance.andNot(other);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class ConcurrentBitSet.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        ConcurrentBitSet instance = new ConcurrentBitSet();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}