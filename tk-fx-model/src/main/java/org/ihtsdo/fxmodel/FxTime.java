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



package org.ihtsdo.fxmodel;

//~--- non-JDK imports --------------------------------------------------------

import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;

import org.ihtsdo.helper.time.TimeHelper;

//~--- JDK imports ------------------------------------------------------------

import java.io.Serializable;

import java.text.SimpleDateFormat;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kec
 */
public class FxTime implements Serializable {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   private final SimpleLongProperty timeProperty = new SimpleLongProperty(this, "timeProperty",
                                                      Long.MIN_VALUE);
   private SimpleObjectProperty<ThreadLocal<SimpleDateFormat>> formatterProperty =
      new SimpleObjectProperty<>(this, "formatterProperty", TimeHelper.localDateFormat);
   private final StringBinding timeTextBinding = new StringBinding() {
      {
         super.bind(timeProperty, formatterProperty);
      }
      @Override
      protected String computeValue() {
         return TimeHelper.formatDate(timeProperty.get(), formatterProperty.get());
      }
   };

    public FxTime() {
    }
    public FxTime(long time) {
        timeProperty.set(time);
    }

   //~--- methods -------------------------------------------------------------

   public SimpleLongProperty timeProperty() {
      return timeProperty();
   }

   public StringBinding timeTextBinding() {
      return timeTextBinding;
   }

   @Override
   public String toString() {
      return timeTextBinding.get() + " ("+ timeProperty.get() + ')';
   }

   //~--- get methods ---------------------------------------------------------

   public long getTime() {
      return timeProperty.get();
   }

   public String getTimeText() {
      return timeTextBinding.get();
   }

   //~--- set methods ---------------------------------------------------------

   public void setTime(long time) {
      timeProperty.set(time);
   }
}
