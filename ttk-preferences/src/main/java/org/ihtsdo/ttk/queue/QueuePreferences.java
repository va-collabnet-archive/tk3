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
import org.ihtsdo.ttk.preferences.PreferenceObject;
import org.ihtsdo.ttk.preferences.PreferenceWithDefaultEnumBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.File;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kec
 */
public class QueuePreferences extends PreferenceObject {
    List<PreferenceObject> serviceItemProperties = new ArrayList<>();
    File                   queueDirectory;

    public QueuePreferences() {
        this.queueDirectory = new File(Fields.QUEUE_DIRECTORY.getDefaultValue().toString());
        this.serviceItemProperties.add(new QueueAddress());
        this.serviceItemProperties.add(new QueueName());
        this.serviceItemProperties.add(new QueueType());
    }

    public QueuePreferences(EnumBasedPreferences preferences) {
        this.queueDirectory        = new File(preferences.get(Fields.QUEUE_DIRECTORY));
        this.serviceItemProperties = (List<PreferenceObject>) preferences.getList(Fields.QUEUE_INSTANCE_PROPERTIES_LIST);
    }

    public enum Fields implements PreferenceWithDefaultEnumBI {
        QUEUE_DIRECTORY("queue/inbox"), QUEUE_INSTANCE_PROPERTIES_LIST(0);

        final Object defaultValue;

        private Fields(Object defaultValue) {
            this.defaultValue = defaultValue;
        }

        @Override
        public Object getDefaultValue() {
            return defaultValue;
        }
    }

    @Override
    public String toString() {
        return "QueuePreferences{" + "serviceItemProperties=" + serviceItemProperties + ", queueDirectory="
               + queueDirectory + '}';
    }

    public List<PreferenceObject> getServiceItemProperties() {
        return serviceItemProperties;
    }

    public File getQueueDirectory() {
        return queueDirectory;
    }

    public void setQueueDirectory(File queueDirectory) {
        this.queueDirectory = queueDirectory;
    }

    @Override
    protected void exportFields(EnumBasedPreferences preferences) {
        preferences.put(Fields.QUEUE_DIRECTORY, this.queueDirectory.getAbsolutePath());
        preferences.putList(Fields.QUEUE_INSTANCE_PROPERTIES_LIST, serviceItemProperties);
    }
}
