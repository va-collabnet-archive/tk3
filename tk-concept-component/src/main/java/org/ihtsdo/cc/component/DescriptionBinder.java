package org.ihtsdo.cc.component;

import java.util.concurrent.atomic.AtomicInteger;

import org.ihtsdo.cc.component.ConceptComponentBinder;
import org.ihtsdo.cc.description.Description;
import org.ihtsdo.cc.description.DescriptionRevision;

public class DescriptionBinder extends ConceptComponentBinder<DescriptionRevision, Description> {
	
		public static AtomicInteger encountered = new AtomicInteger();
		public static AtomicInteger written = new AtomicInteger();

		public DescriptionBinder() {
			super(new DescriptionFactory(), encountered, written);
		}

}
