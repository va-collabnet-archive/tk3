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



package org.ihtsdo.ttk.api.blueprint;

/**
 *
 * @author kec
 */
public enum RefexProperty {

   /**
    * Identifier of the member, either represented as a UUID or a nid.
    */
   MEMBER_ID, ENCLOSING_CONCEPT_ID,

   /**
    * An identifier to the refex extension to which this member belongs.
    */
   REFEX_EXTENSION_ID,

   /**
    * Identifier of the referenced component&mdash;the component this refex extends&mdash;
    * either represented as a UUID or a nid.
    */
   REFERENCED_COMPONENT_ID,

   /**
    * Identifier of the status concept for this refex version,
    * either represented as a UUID or a nid.
    */
   STATUS_ID, TIME_IN_MS, AUTHOR_ID, MODULE_ID, PATH_ID,

   /**
    *
    */
   COMPONENT_EXTENSION_1_ID,

   /**
    *
    */
   COMPONENT_EXTENSION_2_ID,

   /**
    *
    */
   COMPONENT_EXTENSION_3_ID,

   /**
    *
    */
   BOOLEAN_EXTENSION_1,

   /**
    *
    */
   INTEGER_EXTENSION_1,

   /**
    *
    */
   STRING_EXTENSION_1,

   /**
    *
    */
   LONG_EXTENSION_1,

   /**
    *
    */
   FLOAT_EXTENSION_1,

   /**
    *
    */
   ARRAY_OF_BYTEARRAY
}
