package org.ihtsdo.concept.component.description;

import java.beans.PropertyVetoException;

import org.ihtsdo.concept.component.TypedComponentFacade;
import org.ihtsdo.tk.api.description.DescriptionVersionBI;

public interface DescriptionFacade
        extends TypedComponentFacade, DescriptionVersionBI {

 void setInitialCaseSignificant(boolean capStatus) throws PropertyVetoException;
 void setLang(String lang) throws PropertyVetoException;
 public void setText(String text) throws PropertyVetoException;
 @Override
 DescriptionRevision makeAnalog(int statusNid, int authorNid, int pathNid, long time);

}
