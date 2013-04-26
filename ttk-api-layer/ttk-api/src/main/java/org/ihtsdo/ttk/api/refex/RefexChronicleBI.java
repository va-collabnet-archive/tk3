package org.ihtsdo.ttk.api.refex;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.ComponentChroncileBI;
import org.ihtsdo.ttk.api.TK_REFEX_TYPE;

public interface RefexChronicleBI<A extends RefexAnalogBI<A>>
        extends ComponentChroncileBI<RefexVersionBI<A>> {
   int getRefexExtensionNid();

   int getReferencedComponentNid();
   
   TK_REFEX_TYPE getRefexType();
}
