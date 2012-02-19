package org.ihtsdo.concept.component;

import java.beans.PropertyVetoException;
import org.ihtsdo.tk.api.AnalogBI;

public interface TypedComponentFacade extends AnalogBI {

	public void setTypeNid(int nid) throws PropertyVetoException;

}
