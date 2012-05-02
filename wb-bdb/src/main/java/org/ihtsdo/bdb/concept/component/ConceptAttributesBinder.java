package org.ihtsdo.bdb.concept.component;

import java.util.concurrent.atomic.AtomicInteger;

import org.ihtsdo.bdb.concept.component.ConceptComponentBinder;
import org.ihtsdo.concept.component.attributes.ConceptAttributes;
import org.ihtsdo.concept.component.attributes.ConceptAttributesRevision;

public class ConceptAttributesBinder extends ConceptComponentBinder<ConceptAttributesRevision, ConceptAttributes> {
	

	public static AtomicInteger encountered = new AtomicInteger();
	public static AtomicInteger written = new AtomicInteger();

	public ConceptAttributesBinder() {
		super(new ConceptAttributesFactory(), encountered, written);
	}

}
