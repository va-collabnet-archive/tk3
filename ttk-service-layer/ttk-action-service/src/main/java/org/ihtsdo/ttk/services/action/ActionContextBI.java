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

import java.util.EnumSet;
import java.util.List;
import java.util.UUID;
import org.ihtsdo.ttk.api.ComponentVersionBI;
import org.ihtsdo.ttk.api.coordinate.EditCoordinate;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;

/**
 *
 * @author kec
 */
public interface ActionContextBI {
    UUID getId();
    ComponentVersionBI getComponentForContext();
    EnumSet<InterfaceContext> getInterfaceContextSet();
    ViewCoordinate getViewCoordinate();
    EditCoordinate getEditCoordinate();
    /** not so sure about this one */
    List<ActionContextBI> getLinkedContexts();
    
    boolean hasFocus();
    boolean isSelected();
    
}
