package org.ihtsdo.ttk.api.refex.type_nid_nid_nid;

import org.ihtsdo.ttk.api.refex.type_nid_nid.RefexNidNidVersionBI;

public interface RefexNidNidNidVersionBI <A extends RefexNidNidNidAnalogBI<A>> 
    extends RefexNidNidVersionBI<A> {
     int getNid3();

}
