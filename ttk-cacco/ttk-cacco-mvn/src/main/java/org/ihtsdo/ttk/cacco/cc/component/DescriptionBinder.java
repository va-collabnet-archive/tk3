package org.ihtsdo.ttk.cacco.cc.component;

import java.util.concurrent.atomic.AtomicInteger;

import org.ihtsdo.ttk.cacco.cc.component.ConceptComponentBinder;
import org.ihtsdo.ttk.cacco.cc.description.Description;
import org.ihtsdo.ttk.cacco.cc.description.DescriptionRevision;

public class DescriptionBinder extends ConceptComponentBinder<DescriptionRevision, Description> {
	
		public static AtomicInteger encountered = new AtomicInteger();
		public static AtomicInteger written = new AtomicInteger();

		public DescriptionBinder() {
			super(new DescriptionFactory(), encountered, written);
		}

}
