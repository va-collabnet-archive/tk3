package org.ihtsdo.ttk.cacco.cc.concept;

import org.ihtsdo.ttk.cacco.cc.concept.AttributeComparer;
import org.ihtsdo.ttk.api.ComponentVersionBI;
import org.ihtsdo.ttk.api.conattr.ConAttrVersionBI;
import org.ihtsdo.ttk.api.contradiction.ComponentType;

public class ConceptAttributeComparer extends AttributeComparer {

	private boolean lcaDefinedValue = false;
	private int lcaStatusNid = 0;

	public ConceptAttributeComparer() {
		super();
		componentType = ComponentType.ATTRIBUTE;
	}

	@Override
	boolean hasSameAttributes(ComponentVersionBI v) {
		ConAttrVersionBI conAttrVersion = (ConAttrVersionBI)v;

		if ((conAttrVersion.isDefined() != lcaDefinedValue) ||
			(conAttrVersion.getStatusNid() != lcaStatusNid))
			return false;
		
		return true;
	}

	@Override
	public void initializeAttributes(ComponentVersionBI v) {
		ConAttrVersionBI conAttrVersion = (ConAttrVersionBI)v;
		comparerInitialized = true;
		
		lcaDefinedValue = conAttrVersion.isDefined();
		lcaStatusNid = conAttrVersion.getStatusNid();
	}

}
