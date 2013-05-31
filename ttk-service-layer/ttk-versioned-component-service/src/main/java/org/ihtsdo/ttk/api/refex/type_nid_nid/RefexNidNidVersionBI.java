package org.ihtsdo.ttk.api.refex.type_nid_nid;

import org.ihtsdo.ttk.api.refex.type_nid.RefexNidVersionBI;

public interface RefexNidNidVersionBI <A extends RefexNidNidAnalogBI<A>> 
    extends RefexNidVersionBI<A> {
    
     int getNid2();
     
}
