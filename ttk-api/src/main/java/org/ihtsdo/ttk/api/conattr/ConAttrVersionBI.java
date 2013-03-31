package org.ihtsdo.ttk.api.conattr;

import java.io.IOException;
import org.ihtsdo.ttk.api.AnalogGeneratorBI;
import org.ihtsdo.ttk.api.ComponentVersionBI;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.blueprint.ConAttrAB;
import org.ihtsdo.ttk.api.blueprint.InvalidBlueprintException;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;

public interface ConAttrVersionBI<A extends ConAttrAnalogBI>
	extends ComponentVersionBI,
        ConAttrChronicleBI,
        AnalogGeneratorBI<A> {

    public boolean isDefined();
    
    @Override
    public ConAttrAB makeBlueprint(ViewCoordinate vc) throws IOException, ContradictionException, InvalidBlueprintException;
}
