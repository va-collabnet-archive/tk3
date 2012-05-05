package org.ihtsdo.cc.concept;

import java.io.IOException;

import com.sleepycat.bind.tuple.TupleInput;

public interface ConceptDataFetcherI {

	public byte[] getReadOnlyBytes() throws IOException;

	public byte[] getReadWriteBytes() throws IOException;

	public TupleInput getReadOnlyTupleInput() throws IOException;

	public TupleInput getMutableTupleInput() throws IOException;

	public boolean isPrimordial() throws IOException;
	
	public void reset();

}