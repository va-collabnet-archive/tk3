package org.ihtsdo.concept.component.media;

import java.io.IOException;

import org.ihtsdo.concept.Concept;
import org.ihtsdo.concept.component.ComponentFactory;

import com.sleepycat.bind.tuple.TupleInput;

public class MediaFactory extends ComponentFactory<MediaRevision, Media> {

	@Override
	public Media create(Concept enclosingConcept, 
			TupleInput input) throws IOException {
		return new Media(enclosingConcept, 
				input);
	}

}