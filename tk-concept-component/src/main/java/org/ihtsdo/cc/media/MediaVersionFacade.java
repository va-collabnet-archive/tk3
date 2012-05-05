package org.ihtsdo.cc.media;

import java.beans.PropertyVetoException;

import org.ihtsdo.cc.component.TypedComponentFacade;
import org.ihtsdo.tk.api.media.MediaAnalogBI;

public interface MediaVersionFacade
        extends TypedComponentFacade, MediaAnalogBI<MediaRevision> {
	
    void setTextDescription(String desc) throws PropertyVetoException;
    
    @Override
    MediaRevision makeAnalog(int statusNid, int authorNid, int pathNid, long time);
    
}
