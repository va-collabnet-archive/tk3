package org.ihtsdo.cc.component;

import java.io.IOException;

import org.ihtsdo.cc.concept.Concept;
import org.ihtsdo.cc.component.ComponentFactory;

import com.sleepycat.bind.tuple.TupleInput;
import org.ihtsdo.cc.media.Media;
import org.ihtsdo.cc.media.MediaRevision;

public class MediaFactory extends ComponentFactory<MediaRevision, Media> {

	@Override
	public Media create(Concept enclosingConcept, 
			TupleInput input) throws IOException {
		return new Media(enclosingConcept, 
				input);
	}

}