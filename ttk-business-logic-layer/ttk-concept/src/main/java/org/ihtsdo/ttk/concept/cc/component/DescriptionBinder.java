package org.ihtsdo.ttk.concept.cc.component;

import java.util.concurrent.atomic.AtomicInteger;

import org.ihtsdo.ttk.concept.cc.description.Description;
import org.ihtsdo.ttk.concept.cc.description.DescriptionRevision;

public class DescriptionBinder extends ConceptComponentBinder<DescriptionRevision, Description> {

    public static AtomicInteger encountered = new AtomicInteger();
    public static AtomicInteger written = new AtomicInteger();

    public DescriptionBinder() {
        super(new DescriptionFactory(), encountered, written);
    }
}
