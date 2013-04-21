package org.ihtsdo.ttk.api.metadata.binding;

import org.ihtsdo.ttk.api.spec.RelSpec;

public class SnomedRelSpec {
	public static RelSpec FINDING_SITE = 
		new RelSpec(Taxonomies.SNOMED, 
					SnomedRelType.FINDING_SITE, 
					Snomed.BODY_STRUCTURE);

}
