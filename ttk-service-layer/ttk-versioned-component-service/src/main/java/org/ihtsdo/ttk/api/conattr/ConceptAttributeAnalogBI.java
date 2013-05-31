package org.ihtsdo.ttk.api.conattr;

import java.beans.PropertyVetoException;

import org.ihtsdo.ttk.api.AnalogBI;

public interface ConceptAttributeAnalogBI<A extends ConceptAttributeAnalogBI>
        extends AnalogBI, ConceptAttributeVersionBI<A> {
	
    public void setDefined(boolean defined) throws PropertyVetoException;

}
