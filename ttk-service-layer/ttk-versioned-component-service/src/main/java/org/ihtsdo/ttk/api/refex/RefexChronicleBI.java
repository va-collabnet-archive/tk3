package org.ihtsdo.ttk.api.refex;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.ComponentChronicleBI;
import org.ihtsdo.ttk.api.ToolkitRefexType;

public interface RefexChronicleBI<A extends RefexAnalogBI<A>>
        extends ComponentChronicleBI<RefexVersionBI<A>> {
   int getRefexExtensionNid();

   int getReferencedComponentNid();
   
   ToolkitRefexType getRefexType();
}
