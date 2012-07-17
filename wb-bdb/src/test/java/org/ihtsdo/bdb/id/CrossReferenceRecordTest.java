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

import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kec
 */
public class CrossReferenceRecordTest {
   private int[] test1 = new int[] { 3, 3, 10 };
   private int[] test2 = new int[] { 3, 3, 10, 11 };    // 1 refset record
   private int[] test3 = new int[] { 3, 4, 10, 12 };    // 1 destination origin nid

   //~--- constructors --------------------------------------------------------

   public CrossReferenceRecordTest() {}

   //~--- methods -------------------------------------------------------------

   @After
   public void tearDown() {}

   @AfterClass
   public static void tearDownClass() {}

   /**
    * Test of getDestinationOriginNids method, of class CrossReferenceRecord.
    */
   @Test
   public void testGetDestinationOriginNids() {
      System.out.println("getDestinationOriginNids");

      CrossReferenceRecord instance  = new CrossReferenceRecord(test1);
      int[]                expResult = new int[0];
      int[]                result    = instance.getDestinationOriginNids();

      assertArrayEquals(expResult, result);
      instance  = new CrossReferenceRecord(test2);
      expResult = new int[] {};
      result    = instance.getDestinationOriginNids();
      assertArrayEquals(expResult, result);
      instance  = new CrossReferenceRecord(test3);
      expResult = new int[] { 12 };
      result    = instance.getDestinationOriginNids();
      assertArrayEquals(expResult, result);
   }

   /**
    * Test of getRefexIndexArray method, of class CrossReferenceRecord.
    */
   @Test
   public void testGetRefexIndexArray() {
      System.out.println("getRefexIndexArray");

      CrossReferenceRecord instance  = new CrossReferenceRecord(test1);
      int[]                expResult = new int[0];
      int[]                result    = instance.getRefexIndexArray();

      assertArrayEquals(expResult, result);
      instance  = new CrossReferenceRecord(test2);
      expResult = new int[] { 11 };
      result    = instance.getRefexIndexArray();
      assertArrayEquals(expResult, result);
      instance  = new CrossReferenceRecord(test3);
      expResult = new int[] {};
      result    = instance.getRefexIndexArray();
      assertArrayEquals(expResult, result);
   }

   /**
    * Test of getRelationshipOutgoingArray method, of class CrossReferenceRecord.
    */
   @Test
   public void testGetRelationshipOutgoingArray() {
      System.out.println("getRelationshipOutgoingArray");

      CrossReferenceRecord instance  = new CrossReferenceRecord(test1);
      int[]                expResult = new int[] { 10 };
      int[]                result    = instance.getRelationshipOutgoingArray();

      assertArrayEquals(expResult, result);
      instance  = new CrossReferenceRecord(test2);
      expResult = new int[] { 10 };
      result    = instance.getRelationshipOutgoingArray();
      assertArrayEquals(expResult, result);
      instance  = new CrossReferenceRecord(test3);
      expResult = new int[] { 10 };
      result    = instance.getRelationshipOutgoingArray();
      assertArrayEquals(expResult, result);
   }

   /**
    *  Test of updateData method, of class CrossReferenceRecord.
    */
   @Test
   public void testUpdateData() {
      System.out.println("getDestinationOriginNids");

      CrossReferenceRecord instance                 = new CrossReferenceRecord(test1);
      int[]                destinationOriginData    = instance.getDestinationOriginNids();
      int[]                relationshipOutgoingData = instance.getRelationshipOutgoingArray();
      int[]                refexData                = instance.getRefexIndexArray();
      int[]                result                   = instance.updateData(relationshipOutgoingData, destinationOriginData, refexData);

      assertArrayEquals(test1, result);
      instance                 = new CrossReferenceRecord(test2);
      destinationOriginData    = instance.getDestinationOriginNids();
      relationshipOutgoingData = instance.getRelationshipOutgoingArray();
      refexData                = instance.getRefexIndexArray();
      result                   = instance.updateData(relationshipOutgoingData, destinationOriginData, refexData);
      assertArrayEquals(test2, result);
      instance                 = new CrossReferenceRecord(test3);
      destinationOriginData    = instance.getDestinationOriginNids();
      relationshipOutgoingData = instance.getRelationshipOutgoingArray();
      refexData                = instance.getRefexIndexArray();
      result                   = instance.updateData(relationshipOutgoingData, destinationOriginData, refexData);
      assertArrayEquals(test3, result);
   }

   //~--- set methods ---------------------------------------------------------

   @Before
   public void setUp() {}

   @BeforeClass
   public static void setUpClass() {}
}
