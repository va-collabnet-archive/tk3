package org.ihtsdo.ttk.api.conattr;

import java.beans.PropertyVetoException;

import org.ihtsdo.ttk.api.AnalogBI;

public interface ConAttrAnalogBI<A extends ConAttrAnalogBI>
        extends AnalogBI, ConAttrVersionBI<A> {
	
    public void setDefined(boolean defined) throws PropertyVetoException;

}
