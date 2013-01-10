package org.ihtsdo.ttk.api.description;

import java.io.IOException;
import java.util.regex.Pattern;
import org.ihtsdo.ttk.api.AnalogGeneratorBI;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TypedComponentVersionBI;
import org.ihtsdo.ttk.api.blueprint.DescCAB;
import org.ihtsdo.ttk.api.blueprint.InvalidCAB;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;

public interface DescriptionVersionBI<A extends DescriptionAnalogBI>
	extends TypedComponentVersionBI, 
			DescriptionChronicleBI, 
			AnalogGeneratorBI<A> {
	
	public String getText();

    public boolean isInitialCaseSignificant();

    public String getLang();
    
    @Override
    public DescCAB makeBlueprint(ViewCoordinate vc) throws IOException, ContradictionException, InvalidCAB;
    
    public boolean matches(Pattern p);
}
