package org.ihtsdo.bdb.concept.component;

import java.io.IOException;

import org.ihtsdo.concept.Concept;
import org.ihtsdo.bdb.concept.component.ComponentFactory;

import com.sleepycat.bind.tuple.TupleInput;
import org.ihtsdo.concept.component.media.Media;
import org.ihtsdo.concept.component.media.MediaRevision;

public class MediaFactory extends ComponentFactory<MediaRevision, Media> {

	@Override
	public Media create(Concept enclosingConcept, 
			TupleInput input) throws IOException {
		return new Media(enclosingConcept, 
				input);
	}

}