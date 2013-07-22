package org.ihtsdo.otf.tcc.api;

import java.io.Serializable;
import java.util.Set;



public interface PositionSetBI extends Set<PositionBI>, Serializable {
    
    public NidSetBI getViewPathNidSet();
    public PositionBI[] getPositionArray();
	
}
