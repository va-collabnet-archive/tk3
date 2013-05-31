package org.ihtsdo.ttk.api.refex.type_nid;

import org.ihtsdo.ttk.api.refex.RefexVersionBI;

public interface RefexNidVersionBI <A extends RefexNidAnalogBI<A>> 
        extends RefexVersionBI<A> {
    
     int getNid1();

}
