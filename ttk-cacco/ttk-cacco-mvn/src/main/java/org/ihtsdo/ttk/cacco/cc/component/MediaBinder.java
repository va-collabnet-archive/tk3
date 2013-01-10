package org.ihtsdo.ttk.cacco.cc.component;

import java.util.concurrent.atomic.AtomicInteger;

import org.ihtsdo.ttk.cacco.cc.component.ConceptComponentBinder;
import org.ihtsdo.ttk.cacco.cc.media.Media;
import org.ihtsdo.ttk.cacco.cc.media.MediaRevision;

public class MediaBinder extends ConceptComponentBinder<MediaRevision, Media> {

	public static AtomicInteger encountered = new AtomicInteger();
	public static AtomicInteger written = new AtomicInteger();

	public MediaBinder() {
		super(new MediaFactory(), encountered, written);
	}
}