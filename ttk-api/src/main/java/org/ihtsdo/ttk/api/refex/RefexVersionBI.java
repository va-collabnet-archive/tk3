package org.ihtsdo.ttk.api.refex;

//~--- non-JDK imports --------------------------------------------------------
import org.ihtsdo.ttk.api.AnalogGeneratorBI;
import org.ihtsdo.ttk.api.ComponentVersionBI;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.blueprint.RefexCAB;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import org.ihtsdo.ttk.api.blueprint.InvalidBlueprintException;

public interface RefexVersionBI<A extends RefexAnalogBI<A>>
        extends ComponentVersionBI, RefexChronicleBI<A>, AnalogGeneratorBI<A> {

    @Override
    RefexCAB makeBlueprint(ViewCoordinate vc) throws IOException, InvalidBlueprintException, ContradictionException;

    boolean refexFieldsEqual(RefexVersionBI another);
}
