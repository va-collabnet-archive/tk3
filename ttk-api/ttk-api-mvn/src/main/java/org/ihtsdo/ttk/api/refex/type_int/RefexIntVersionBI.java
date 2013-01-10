package org.ihtsdo.ttk.api.refex.type_int;

import org.ihtsdo.ttk.api.refex.RefexVersionBI;

public interface RefexIntVersionBI <A extends RefexIntAnalogBI<A>>
        extends RefexVersionBI<A> {
    
     int getInt1();

}
