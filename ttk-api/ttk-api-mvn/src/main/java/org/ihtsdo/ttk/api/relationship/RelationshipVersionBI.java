package org.ihtsdo.ttk.api.relationship;

import java.io.IOException;
import org.ihtsdo.ttk.api.AnalogGeneratorBI;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TypedComponentVersionBI;
import org.ihtsdo.ttk.api.blueprint.InvalidCAB;
import org.ihtsdo.ttk.api.blueprint.RelCAB;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;

public interface RelationshipVersionBI<A extends RelationshipAnalogBI>
        extends TypedComponentVersionBI,
        RelationshipChronicleBI,
        AnalogGeneratorBI<A> {

    public int getRefinabilityNid();

    public int getCharacteristicNid();

    public int getGroup();

    public boolean isInferred();
    
    public boolean isStated();
    
    @Override
    public RelCAB makeBlueprint(ViewCoordinate vc) throws IOException, ContradictionException, InvalidCAB;

}
