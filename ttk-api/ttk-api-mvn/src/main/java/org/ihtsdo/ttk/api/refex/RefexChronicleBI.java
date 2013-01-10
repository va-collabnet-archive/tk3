package org.ihtsdo.ttk.api.refex;

//~--- non-JDK imports --------------------------------------------------------

import org.ihtsdo.ttk.api.ComponentChroncileBI;

public interface RefexChronicleBI<A extends RefexAnalogBI<A>>
        extends ComponentChroncileBI<RefexVersionBI<A>> {
   int getRefexNid();

   int getReferencedComponentNid();
}
