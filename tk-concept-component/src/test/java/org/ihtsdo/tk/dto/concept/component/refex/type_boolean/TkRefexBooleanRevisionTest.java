package org.ihtsdo.tk.dto.concept.component.refex.type_boolean;

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
import org.ihtsdo.tk.api.refex.type_boolean.RefexBooleanVersionBI;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexBooleanRevisionTest</code> contains tests for the class <code>{@link TkRefexBooleanRevision}</code>.
 *
 * @generatedBy CodePro at 2/4/12 4:33 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexBooleanRevisionTest {
	/**
	 * Run the TkRefexBooleanRevision() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test
	public void testTkRefexBooleanRevision_1()
		throws Exception {

		TkRefexBooleanRevision result = new TkRefexBooleanRevision();

		// add additional test code here
		assertNotNull(result);
		assertEquals(false, result.getBooleanValue());
		assertEquals(false, result.isBooleanValue());
		assertEquals(Long.MIN_VALUE, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexBooleanRevision(RefexBooleanVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test
        @Ignore
	public void testTkRefexBooleanRevision_2()
		throws Exception {
		RefexBooleanVersionBI another = null;

		TkRefexBooleanRevision result = new TkRefexBooleanRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_boolean.TkRefexBooleanRevision.<init>(TkRefexBooleanRevision.java:31)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexBooleanRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexBooleanRevision_3()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexBooleanRevision result = new TkRefexBooleanRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexBooleanRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexBooleanRevision_4()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexBooleanRevision result = new TkRefexBooleanRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexBooleanRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexBooleanRevision_5()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexBooleanRevision result = new TkRefexBooleanRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexBooleanRevision(TkRefexBooleanRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test
	public void testTkRefexBooleanRevision_6()
		throws Exception {
		TkRefexBooleanRevision another = new TkRefexBooleanRevision();
		another.setBooleanValue(true);
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexBooleanRevision result = new TkRefexBooleanRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.getBooleanValue());
		assertEquals(true, result.isBooleanValue());
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
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexBooleanRevision fixture = new TkRefexBooleanRevision();
		fixture.setBooleanValue(true);
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexBooleanRevision fixture = new TkRefexBooleanRevision();
		fixture.setBooleanValue(true);
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		TkRefexBooleanRevision obj = new TkRefexBooleanRevision();
		obj.setBooleanValue(true);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexBooleanRevision fixture = new TkRefexBooleanRevision();
		fixture.setBooleanValue(true);
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		TkRefexBooleanRevision obj = new TkRefexBooleanRevision();
		obj.setBooleanValue(true);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexBooleanRevision fixture = new TkRefexBooleanRevision();
		fixture.setBooleanValue(true);
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		TkRefexBooleanRevision obj = new TkRefexBooleanRevision();
		obj.setBooleanValue(true);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexBooleanRevision fixture = new TkRefexBooleanRevision();
		fixture.setBooleanValue(true);
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean getBooleanValue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test
	public void testGetBooleanValue_1()
		throws Exception {
		TkRefexBooleanRevision fixture = new TkRefexBooleanRevision();
		fixture.setBooleanValue(true);
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();

		boolean result = fixture.getBooleanValue();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean getBooleanValue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test
	public void testGetBooleanValue_2()
		throws Exception {
		TkRefexBooleanRevision fixture = new TkRefexBooleanRevision();
		fixture.setBooleanValue(false);
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();

		boolean result = fixture.getBooleanValue();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean isBooleanValue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test
	public void testIsBooleanValue_1()
		throws Exception {
		TkRefexBooleanRevision fixture = new TkRefexBooleanRevision();
		fixture.setBooleanValue(true);
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();

		boolean result = fixture.isBooleanValue();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isBooleanValue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test
	public void testIsBooleanValue_2()
		throws Exception {
		TkRefexBooleanRevision fixture = new TkRefexBooleanRevision();
		fixture.setBooleanValue(false);
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();

		boolean result = fixture.isBooleanValue();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the TkRefexBooleanRevision makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexBooleanRevision fixture = new TkRefexBooleanRevision();
		fixture.setBooleanValue(true);
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexBooleanRevision result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.getBooleanValue());
		assertEquals(true, result.isBooleanValue());
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
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexBooleanRevision fixture = new TkRefexBooleanRevision();
		fixture.setBooleanValue(true);
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexBooleanRevision fixture = new TkRefexBooleanRevision();
		fixture.setBooleanValue(true);
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexBooleanRevision fixture = new TkRefexBooleanRevision();
		fixture.setBooleanValue(true);
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexBooleanRevision fixture = new TkRefexBooleanRevision();
		fixture.setBooleanValue(true);
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setBooleanValue(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test
	public void testSetBooleanValue_1()
		throws Exception {
		TkRefexBooleanRevision fixture = new TkRefexBooleanRevision();
		fixture.setBooleanValue(true);
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		boolean booleanValue = true;

		fixture.setBooleanValue(booleanValue);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexBooleanRevision fixture = new TkRefexBooleanRevision();
		fixture.setBooleanValue(true);
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexBooleanRevision: true  s:5b1cc6d3-12b7-40f6-a65b-998a03cac496 a:2972da83-2fb9-48da-b78c-ea33667f0c50 p:f6299d89-4c32-428e-b1af-c2430aeba1c7 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexBooleanRevision fixture = new TkRefexBooleanRevision();
		fixture.setBooleanValue(true);
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexBooleanRevision fixture = new TkRefexBooleanRevision();
		fixture.setBooleanValue(true);
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexBooleanRevision fixture = new TkRefexBooleanRevision();
		fixture.setBooleanValue(true);
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:33 PM
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
	 * @generatedBy CodePro at 2/4/12 4:33 PM
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
	 * @generatedBy CodePro at 2/4/12 4:33 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexBooleanRevisionTest.class);
	}
}