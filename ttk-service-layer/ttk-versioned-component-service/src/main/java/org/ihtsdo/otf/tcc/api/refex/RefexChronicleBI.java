package org.ihtsdo.otf.tcc.api.refex;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.otf.tcc.api.ComponentChronicleBI;
import org.ihtsdo.otf.tcc.api.ToolkitRefexType;

public interface RefexChronicleBI<A extends RefexAnalogBI<A>>
        extends ComponentChronicleBI<RefexVersionBI<A>> {
   int getRefexExtensionNid();

   int getReferencedComponentNid();
   
   ToolkitRefexType getRefexType();
}
