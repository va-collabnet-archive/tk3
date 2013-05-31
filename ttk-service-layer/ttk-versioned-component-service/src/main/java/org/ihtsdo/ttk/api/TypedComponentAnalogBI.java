package org.ihtsdo.ttk.api;

import java.beans.PropertyVetoException;

public interface TypedComponentAnalogBI extends AnalogBI {

	public void setTypeNid(int nid) throws PropertyVetoException;

}
