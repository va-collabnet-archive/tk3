package org.ihtsdo.ttk.concept.cc.media;

import java.beans.PropertyVetoException;

import org.ihtsdo.ttk.concept.cc.component.TypedComponentFacade;
import org.ihtsdo.otf.tcc.api.media.MediaAnalogBI;

public interface MediaVersionFacade
        extends TypedComponentFacade, MediaAnalogBI<MediaRevision> {
	
    void setTextDescription(String desc) throws PropertyVetoException;
    
    @Override
    MediaRevision makeAnalog(org.ihtsdo.otf.tcc.api.Status status, long time, int authorNid, int moduleNid, int pathNid);
    
}
