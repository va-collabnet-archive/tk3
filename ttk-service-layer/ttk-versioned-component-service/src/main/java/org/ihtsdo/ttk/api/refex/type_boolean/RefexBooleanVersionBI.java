package org.ihtsdo.ttk.api.refex.type_boolean;

import org.ihtsdo.ttk.api.refex.RefexVersionBI;

public interface RefexBooleanVersionBI <A extends RefexBooleanAnalogBI<A>>
        extends RefexVersionBI<A> {
    
     boolean getBoolean1();

}
