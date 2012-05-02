package org.ihtsdo.bdb.concept.component;

import java.util.concurrent.atomic.AtomicInteger;

import org.ihtsdo.bdb.concept.component.ConceptComponentBinder;
import org.ihtsdo.concept.component.description.Description;
import org.ihtsdo.concept.component.description.DescriptionRevision;

public class DescriptionBinder extends ConceptComponentBinder<DescriptionRevision, Description> {
	
		public static AtomicInteger encountered = new AtomicInteger();
		public static AtomicInteger written = new AtomicInteger();

		public DescriptionBinder() {
			super(new DescriptionFactory(), encountered, written);
		}

}
