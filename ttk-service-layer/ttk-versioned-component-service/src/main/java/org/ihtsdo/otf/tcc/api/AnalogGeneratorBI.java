package org.ihtsdo.otf.tcc.api;

public interface AnalogGeneratorBI <T extends AnalogBI> {

	T makeAnalog(Status status, long time, int authorNid, int moduleNid, int pathNid);
}
