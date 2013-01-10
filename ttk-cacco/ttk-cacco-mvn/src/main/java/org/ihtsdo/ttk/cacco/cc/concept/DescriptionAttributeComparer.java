package org.ihtsdo.ttk.cacco.cc.concept;

import org.ihtsdo.ttk.cacco.cc.concept.AttributeComparer;
import org.ihtsdo.ttk.api.ComponentVersionBI;
import org.ihtsdo.ttk.api.description.DescriptionVersionBI;
import org.ihtsdo.ttk.api.contradiction.ComponentType;

public class DescriptionAttributeComparer extends AttributeComparer {

	private String lcaLanguage = null;
	private boolean lcaInitialCaseSignificance = false;
	private String lcaText = null;
	private int lcaStatusNid = 0;
	
	public DescriptionAttributeComparer() {
		super();
		componentType = ComponentType.DESCRIPTION;
	}

	@Override
	boolean hasSameAttributes(ComponentVersionBI v) {
		DescriptionVersionBI descVersion = (DescriptionVersionBI)v;

		if ((!descVersion.getLang().equals(lcaLanguage)) ||
			(descVersion.isInitialCaseSignificant() != lcaInitialCaseSignificance)||
			(!descVersion.getText().equals(lcaText)) ||
			(descVersion.getStatusNid() != lcaStatusNid))
			return false;
		
		return true;
	}

	@Override
	public void initializeAttributes(ComponentVersionBI v) {
		DescriptionVersionBI descVersion = (DescriptionVersionBI)v;
		comparerInitialized = true;

		lcaLanguage = descVersion.getLang();
		lcaInitialCaseSignificance = descVersion.isInitialCaseSignificant();
		lcaText = descVersion.getText();
		lcaStatusNid = descVersion.getStatusNid();
	}

}
