package org.ihtsdo.ttk.api.media;

import java.io.IOException;
import org.ihtsdo.ttk.api.AnalogGeneratorBI;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TypedComponentVersionBI;
import org.ihtsdo.ttk.api.blueprint.InvalidBlueprintException;
import org.ihtsdo.ttk.api.blueprint.MediaCAB;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;

public interface MediaVersionBI<A extends MediaAnalogBI>
        extends TypedComponentVersionBI,
		MediaChronicleBI, AnalogGeneratorBI<A> {

    public byte[] getMedia();

    public String getTextDescription();

    public String getFormat();

    public int getConceptNid();
    
    @Override
    public MediaCAB makeBlueprint(ViewCoordinate vc) throws IOException, ContradictionException, InvalidBlueprintException;

}
