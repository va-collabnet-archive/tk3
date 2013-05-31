package org.ihtsdo.ttk.api.refex.type_string;

import org.ihtsdo.ttk.api.refex.RefexVersionBI;

public interface RefexStringVersionBI <A extends RefexStringAnalogBI<A>>
        extends RefexVersionBI<A> {
    
     String getString1();

}
