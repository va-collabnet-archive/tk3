package org.ihtsdo.bdb.uuidmap;

public interface UuidIntProcedure {

	/**
	 * 
	 * @param uuid
	 * @param second
	 * @return 	iteration will stop if <tt>false</tt>, otherwise continues.

	 */
	public boolean apply(long[] uuid, int second);
	
	public void close();
}
