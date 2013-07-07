package org.ihtsdo.ttk.api;

public interface AnalogGeneratorBI <T extends AnalogBI> {

	T makeAnalog(Status status, long time, int authorNid, int moduleNid, int pathNid);
}
