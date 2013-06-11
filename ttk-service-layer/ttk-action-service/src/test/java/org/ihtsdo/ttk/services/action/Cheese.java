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



package org.ihtsdo.ttk.services.action;

/**
 *
 * @author kec
 */
public class Cheese {

   /** Field description */
   float age;

   /** Field description */
   int price;

   /** Field description */
   String type;

   /** Field description */
   String country;

   /**
    * Constructs ...
    *
    *
    * @param type
    */
   public Cheese(String type) {
      this.type = type;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public float getAge() {
      return age;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public String getCountry() {
      return country;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public int getPrice() {
      return price;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public String getType() {
      return type;
   }

   /**
    * Method description
    *
    *
    * @param age
    */
   public void setAge(float age) {
      this.age = age;
   }

   /**
    * Method description
    *
    *
    * @param country
    */
   public void setCountry(String country) {
      this.country = country;
   }

   /**
    * Method description
    *
    *
    * @param price
    */
   public void setPrice(int price) {
      this.price = price;
   }
}
