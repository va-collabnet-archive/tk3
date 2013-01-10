package org.ihtsdo.ttk.cacco.cc.media;

import java.beans.PropertyVetoException;

import org.ihtsdo.ttk.cacco.cc.component.TypedComponentFacade;
import org.ihtsdo.ttk.api.media.MediaAnalogBI;

public interface MediaVersionFacade
        extends TypedComponentFacade, MediaAnalogBI<MediaRevision> {
	
    void setTextDescription(String desc) throws PropertyVetoException;
    
    @Override
    MediaRevision makeAnalog(int statusNid, long time, int authorNid, int moduleNid, int pathNid);
    
}