package org.ihtsdo.concept.component.media;

import java.util.concurrent.atomic.AtomicInteger;

import org.ihtsdo.concept.component.ConceptComponentBinder;

public class MediaBinder extends ConceptComponentBinder<MediaRevision, Media> {

	public static AtomicInteger encountered = new AtomicInteger();
	public static AtomicInteger written = new AtomicInteger();

	public MediaBinder() {
		super(new MediaFactory(), encountered, written);
	}
}
