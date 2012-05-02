package org.ihtsdo.bdb.concept.component;

import java.io.IOException;

import org.ihtsdo.concept.Concept;
import org.ihtsdo.bdb.concept.component.ComponentFactory;

import com.sleepycat.bind.tuple.TupleInput;
import org.ihtsdo.concept.component.image.Image;
import org.ihtsdo.concept.component.image.ImageRevision;

public class ImageFactory extends ComponentFactory<ImageRevision, Image> {

	@Override
	public Image create(Concept enclosingConcept, 
			TupleInput input) throws IOException {
		return new Image(enclosingConcept, 
				input);
	}

}