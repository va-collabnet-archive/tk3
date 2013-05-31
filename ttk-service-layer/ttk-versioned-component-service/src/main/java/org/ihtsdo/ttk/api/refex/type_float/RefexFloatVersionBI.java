package org.ihtsdo.ttk.api.refex.type_float;

import org.ihtsdo.ttk.api.refex.RefexVersionBI;

public interface RefexFloatVersionBI <A extends RefexFloatAnalogBI<A>>
        extends RefexVersionBI<A> {
    
     float getFloat1();

}
