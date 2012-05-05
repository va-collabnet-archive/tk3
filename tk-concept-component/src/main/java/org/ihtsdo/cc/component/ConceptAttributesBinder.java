package org.ihtsdo.cc.component;

import java.util.concurrent.atomic.AtomicInteger;

import org.ihtsdo.cc.component.ConceptComponentBinder;
import org.ihtsdo.cc.attributes.ConceptAttributes;
import org.ihtsdo.cc.attributes.ConceptAttributesRevision;

public class ConceptAttributesBinder extends ConceptComponentBinder<ConceptAttributesRevision, ConceptAttributes> {
	

	public static AtomicInteger encountered = new AtomicInteger();
	public static AtomicInteger written = new AtomicInteger();

	public ConceptAttributesBinder() {
		super(new ConceptAttributesFactory(), encountered, written);
	}

}
