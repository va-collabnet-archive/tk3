package org.ihtsdo.bdb.concept.component;

import java.util.concurrent.atomic.AtomicInteger;

import org.ihtsdo.bdb.concept.component.ConceptComponentBinder;
import org.ihtsdo.concept.component.image.Image;
import org.ihtsdo.concept.component.image.ImageRevision;

public class ImageBinder extends ConceptComponentBinder<ImageRevision, Image> {

	public static AtomicInteger encountered = new AtomicInteger();
	public static AtomicInteger written = new AtomicInteger();

	public ImageBinder() {
		super(new ImageFactory(), encountered, written);
	}
}
