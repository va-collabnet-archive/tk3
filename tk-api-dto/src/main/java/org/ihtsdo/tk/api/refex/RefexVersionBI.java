package org.ihtsdo.tk.api.refex;

//~--- non-JDK imports --------------------------------------------------------
import org.ihtsdo.tk.api.AnalogGeneratorBI;
import org.ihtsdo.tk.api.ComponentVersionBI;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.blueprint.RefexCAB;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import org.ihtsdo.tk.api.blueprint.InvalidCAB;

public interface RefexVersionBI<A extends RefexAnalogBI<A>>
        extends ComponentVersionBI, RefexChronicleBI<A>, AnalogGeneratorBI<A> {

    @Override
    RefexCAB makeBlueprint(ViewCoordinate vc) throws IOException, InvalidCAB, ContradictionException;

    boolean refexFieldsEqual(RefexVersionBI another);
}
