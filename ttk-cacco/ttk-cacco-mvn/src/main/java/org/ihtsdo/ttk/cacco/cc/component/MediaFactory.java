package org.ihtsdo.ttk.cacco.cc.component;

import java.io.IOException;

import org.ihtsdo.ttk.cacco.cc.concept.Concept;
import org.ihtsdo.ttk.cacco.cc.component.ComponentFactory;

import com.sleepycat.bind.tuple.TupleInput;
import org.ihtsdo.ttk.cacco.cc.media.Media;
import org.ihtsdo.ttk.cacco.cc.media.MediaRevision;

public class MediaFactory extends ComponentFactory<MediaRevision, Media> {

	@Override
	public Media create(Concept enclosingConcept, 
			TupleInput input) throws IOException {
		return new Media(enclosingConcept, 
				input);
	}

}