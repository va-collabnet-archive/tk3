package org.ihtsdo.tk.dto.concept.component.refex.type_long;

import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.ihtsdo.tk.api.refex.type_long.RefexLongVersionBI;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexLongRevisionTest</code> contains tests for the class <code>{@link TkRefexLongRevision}</code>.
 *
 * @generatedBy CodePro at 2/4/12 3:30 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexLongRevisionTest {
	/**
	 * Run the TkRefexLongRevision() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test
	public void testTkRefexLongRevision_1()
		throws Exception {

		TkRefexLongRevision result = new TkRefexLongRevision();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0L, result.getLongValue());
		assertEquals(Long.MIN_VALUE, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexLongRevision(RefexLongVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test
        @Ignore
	public void testTkRefexLongRevision_2()
		throws Exception {
		RefexLongVersionBI another = null;

		TkRefexLongRevision result = new TkRefexLongRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_long.TkRefexLongRevision.<init>(TkRefexLongRevision.java:31)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexLongRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexLongRevision_3()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexLongRevision result = new TkRefexLongRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexLongRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexLongRevision_4()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexLongRevision result = new TkRefexLongRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexLongRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexLongRevision_5()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexLongRevision result = new TkRefexLongRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexLongRevision(TkRefexLongRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test
	public void testTkRefexLongRevision_6()
		throws Exception {
		TkRefexLongRevision another = new TkRefexLongRevision();
		another.setLongValue(1L);
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexLongRevision result = new TkRefexLongRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1L, result.getLongValue());
		assertEquals(-9223372036854775807L, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexLongRevision fixture = new TkRefexLongRevision();
		fixture.setLongValue(1L);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		Object obj = null;

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexLongRevision fixture = new TkRefexLongRevision();
		fixture.setLongValue(1L);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		TkRefexLongRevision obj = new TkRefexLongRevision();
		obj.setLongValue(1L);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexLongRevision fixture = new TkRefexLongRevision();
		fixture.setLongValue(1L);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		TkRefexLongRevision obj = new TkRefexLongRevision();
		obj.setLongValue(1L);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexLongRevision fixture = new TkRefexLongRevision();
		fixture.setLongValue(1L);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		TkRefexLongRevision obj = new TkRefexLongRevision();
		obj.setLongValue(1L);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexLongRevision fixture = new TkRefexLongRevision();
		fixture.setLongValue(1L);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the long getLongValue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test
	public void testGetLongValue_1()
		throws Exception {
		TkRefexLongRevision fixture = new TkRefexLongRevision();
		fixture.setLongValue(1L);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;

		long result = fixture.getLongValue();

		// add additional test code here
		assertEquals(1L, result);
	}

	/**
	 * Run the TkRefexLongRevision makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexLongRevision fixture = new TkRefexLongRevision();
		fixture.setLongValue(1L);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexLongRevision result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1L, result.getLongValue());
		assertEquals(2L, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the void readExternal(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexLongRevision fixture = new TkRefexLongRevision();
		fixture.setLongValue(1L);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void readExternal(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexLongRevision fixture = new TkRefexLongRevision();
		fixture.setLongValue(1L);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void readExternal(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexLongRevision fixture = new TkRefexLongRevision();
		fixture.setLongValue(1L);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void readExternal(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexLongRevision fixture = new TkRefexLongRevision();
		fixture.setLongValue(1L);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setLongValue(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test
	public void testSetLongValue_1()
		throws Exception {
		TkRefexLongRevision fixture = new TkRefexLongRevision();
		fixture.setLongValue(1L);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		long longValue = 1L;

		fixture.setLongValue(longValue);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexLongRevision fixture = new TkRefexLongRevision();
		fixture.setLongValue(1L);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexLongRevision:  long: 1  s:826eb64a-77c1-498c-b5e1-59b4da34097c a:7db509bd-658e-4371-b2aa-3b5e38fa8cdf p:180ebdec-6d3c-40d0-99f4-57bd7e5ea6e5 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexLongRevision fixture = new TkRefexLongRevision();
		fixture.setLongValue(1L);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexLongRevision fixture = new TkRefexLongRevision();
		fixture.setLongValue(1L);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexLongRevision fixture = new TkRefexLongRevision();
		fixture.setLongValue(1L);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 2/4/12 3:30 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexLongRevisionTest.class);
	}
}