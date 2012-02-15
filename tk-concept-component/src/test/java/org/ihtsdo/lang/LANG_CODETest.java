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
package org.ihtsdo.lang;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author kec
 */
public class LANG_CODETest {
    
    public LANG_CODETest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of values method, of class LANG_CODE.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        LANG_CODE[] expResult = LANG_CODE.values();
        LANG_CODE[] result = LANG_CODE.values();
        assertEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class LANG_CODE.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "EN_AU";
        LANG_CODE expResult = LANG_CODE.EN_AU;
        LANG_CODE result = LANG_CODE.valueOf(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormatedLanguageCode method, of class LANG_CODE.
     */
    @Test
    public void testGetFormatedLanguageCode() {
        System.out.println("getFormatedLanguageCode");
        LANG_CODE instance = LANG_CODE.EN_AU;
        String expResult = "en-AU";
        String result = instance.getFormatedLanguageCode();
        assertEquals(expResult, result);
        instance = LANG_CODE.EN;
        expResult = "en";
        result = instance.getFormatedLanguageCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLangCode method, of class LANG_CODE.
     */
    @Test
    public void testGetLangCode() {
        System.out.println("getLangCode");
        String name = "EN_AU";
        LANG_CODE expResult = LANG_CODE.EN_AU;
        LANG_CODE result = LANG_CODE.getLangCode(name);
        assertEquals(expResult, result);
        name = "en-AU";
        result = LANG_CODE.getLangCode(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class LANG_CODE.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        LANG_CODE instance = LANG_CODE.EN_AU;
        String expResult = "EN_AU";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
