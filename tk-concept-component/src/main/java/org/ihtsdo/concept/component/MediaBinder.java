package org.ihtsdo.concept.component;

import java.util.concurrent.atomic.AtomicInteger;

import org.ihtsdo.concept.component.ConceptComponentBinder;
import org.ihtsdo.concept.component.media.Media;
import org.ihtsdo.concept.component.media.MediaRevision;

public class MediaBinder extends ConceptComponentBinder<MediaRevision, Media> {

	public static AtomicInteger encountered = new AtomicInteger();
	public static AtomicInteger written = new AtomicInteger();

	public MediaBinder() {
		super(new MediaFactory(), encountered, written);
	}
}
