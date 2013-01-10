package org.ihtsdo.ttk.cacco.cc.component;

import java.util.concurrent.atomic.AtomicInteger;

import org.ihtsdo.ttk.cacco.cc.component.ConceptComponentBinder;
import org.ihtsdo.ttk.cacco.cc.attributes.ConceptAttributes;
import org.ihtsdo.ttk.cacco.cc.attributes.ConceptAttributesRevision;

public class ConceptAttributesBinder extends ConceptComponentBinder<ConceptAttributesRevision, ConceptAttributes> {
	

	public static AtomicInteger encountered = new AtomicInteger();
	public static AtomicInteger written = new AtomicInteger();

	public ConceptAttributesBinder() {
		super(new ConceptAttributesFactory(), encountered, written);
	}

}
