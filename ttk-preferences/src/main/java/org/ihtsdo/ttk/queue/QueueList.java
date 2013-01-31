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



package org.ihtsdo.ttk.queue;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.preferences.EnumBasedPreferences;
import org.ihtsdo.ttk.preferences.PreferenceWithDefaultEnumBI;
import org.ihtsdo.ttk.preferences.PreferenceObject;

//~--- JDK imports ------------------------------------------------------------

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kec
 */
public class QueueList extends PreferenceObject {
    List<QueuePreferences> queueList = new ArrayList();

    public QueueList() {}

    public QueueList(EnumBasedPreferences preferences) {
        super(preferences);
        queueList = (List<QueuePreferences>) preferences.getList(Fields.QUEUE_LIST);
    }

    public enum Fields implements PreferenceWithDefaultEnumBI {
        QUEUE_LIST;

        @Override
        public Object getDefaultValue() {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "QueueList: " + queueList;
    }

    public List<QueuePreferences> getQueueList() {
        return queueList;
    }

    @Override
    protected void exportFields(EnumBasedPreferences preferences) {
        preferences.putList(Fields.QUEUE_LIST, queueList);
    }
}
