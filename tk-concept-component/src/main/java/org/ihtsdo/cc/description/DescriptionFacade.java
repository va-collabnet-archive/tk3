package org.ihtsdo.cc.description;

import java.beans.PropertyVetoException;

import org.ihtsdo.cc.component.TypedComponentFacade;
import org.ihtsdo.tk.api.description.DescriptionVersionBI;

public interface DescriptionFacade
        extends TypedComponentFacade, DescriptionVersionBI {

 void setInitialCaseSignificant(boolean capStatus) throws PropertyVetoException;
 void setLang(String lang) throws PropertyVetoException;
 public void setText(String text) throws PropertyVetoException;
 @Override
 DescriptionRevision makeAnalog(int statusNid,long time, int authorNid, int moduleNid, int pathNid);

}
