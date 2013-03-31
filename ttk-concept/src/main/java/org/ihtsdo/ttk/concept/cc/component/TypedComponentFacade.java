package org.ihtsdo.ttk.concept.cc.component;

import java.beans.PropertyVetoException;
import org.ihtsdo.ttk.api.AnalogBI;

public interface TypedComponentFacade extends AnalogBI {

	public void setTypeNid(int nid) throws PropertyVetoException;

}
