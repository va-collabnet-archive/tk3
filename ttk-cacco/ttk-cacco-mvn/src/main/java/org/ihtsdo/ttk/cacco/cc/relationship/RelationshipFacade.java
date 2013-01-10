package org.ihtsdo.ttk.cacco.cc.relationship;

import java.beans.PropertyVetoException;

import org.ihtsdo.ttk.cacco.cc.component.TypedComponentFacade;
import org.ihtsdo.ttk.api.relationship.RelationshipVersionBI;

public interface RelationshipFacade
        extends TypedComponentFacade, RelationshipVersionBI {


	void setDestinationNid(int nid) throws PropertyVetoException;
	void setRefinabilityNid(int nid) throws PropertyVetoException;
	void setCharacteristicNid(int nid) throws PropertyVetoException;
	void setGroup(int group) throws PropertyVetoException;
        RelationshipRevision makeAnalog(int statusNid, int authorNid, int pathNid, long time);

}
