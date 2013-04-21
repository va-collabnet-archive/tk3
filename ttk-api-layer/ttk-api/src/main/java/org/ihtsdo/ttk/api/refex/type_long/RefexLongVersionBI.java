package org.ihtsdo.ttk.api.refex.type_long;

import org.ihtsdo.ttk.api.refex.RefexVersionBI;

public interface RefexLongVersionBI <A extends RefexLongAnalogBI<A>>
        extends RefexVersionBI<A> {
    
     long getLong1();

}
