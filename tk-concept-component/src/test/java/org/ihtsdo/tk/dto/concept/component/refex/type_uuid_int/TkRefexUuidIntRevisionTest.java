package org.ihtsdo.tk.dto.concept.component.refex.type_uuid_int;

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
import org.ihtsdo.tk.api.refex.type_nid_int.RefexNidIntVersionBI;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexUuidIntRevisionTest</code> contains tests for the class <code>{@link TkRefexUuidIntRevision}</code>.
 *
 * @generatedBy CodePro at 2/4/12 3:44 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexUuidIntRevisionTest {
	/**
	 * Run the TkRefexUuidIntRevision() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
	public void testTkRefexUuidIntRevision_1()
		throws Exception {

		TkRefexUuidIntRevision result = new TkRefexUuidIntRevision();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getIntValue());
		assertEquals(null, result.getUuid1());
		assertEquals(Long.MIN_VALUE, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexUuidIntRevision(RefexNidIntVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidIntRevision_2()
		throws Exception {
		RefexNidIntVersionBI another = null;

		TkRefexUuidIntRevision result = new TkRefexUuidIntRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_int.TkRefexUuidIntRevision.<init>(TkRefexUuidIntRevision.java:34)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidIntRevision(RefexNidIntVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidIntRevision_3()
		throws Exception {
		RefexNidIntVersionBI another = null;

		TkRefexUuidIntRevision result = new TkRefexUuidIntRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_int.TkRefexUuidIntRevision.<init>(TkRefexUuidIntRevision.java:34)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidIntRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidIntRevision_4()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidIntRevision result = new TkRefexUuidIntRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidIntRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidIntRevision_5()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidIntRevision result = new TkRefexUuidIntRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidIntRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidIntRevision_6()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidIntRevision result = new TkRefexUuidIntRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidIntRevision(TkRefexUuidIntRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
	public void testTkRefexUuidIntRevision_7()
		throws Exception {
		TkRefexUuidIntRevision another = new TkRefexUuidIntRevision();
		another.setUuid1(UUID.randomUUID());
		another.setIntValue(1);
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkRefexUuidIntRevision result = new TkRefexUuidIntRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getIntValue());
		assertEquals(-9223372036854775807L, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexUuidIntRevision(TkRefexUuidIntRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
	public void testTkRefexUuidIntRevision_8()
		throws Exception {
		TkRefexUuidIntRevision another = new TkRefexUuidIntRevision();
		another.setUuid1(UUID.randomUUID());
		another.setIntValue(1);
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidIntRevision result = new TkRefexUuidIntRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getIntValue());
		assertEquals(null, result.getUuid1());
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
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkRefexUuidIntRevision obj = new TkRefexUuidIntRevision();
		obj.setUuid1(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkRefexUuidIntRevision obj = new TkRefexUuidIntRevision();
		obj.setUuid1(UUID.randomUUID());
		obj.setIntValue(1);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkRefexUuidIntRevision obj = new TkRefexUuidIntRevision();
		obj.setUuid1(UUID.randomUUID());
		obj.setIntValue(1);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkRefexUuidIntRevision obj = new TkRefexUuidIntRevision();
		obj.setUuid1(UUID.randomUUID());
		obj.setIntValue(1);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the int getIntValue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
	public void testGetIntValue_1()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		int result = fixture.getIntValue();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the UUID getUuid1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
        @Ignore
	public void testGetUuid1_1()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		UUID result = fixture.getUuid1();

		// add additional test code here
		assertNotNull(result);
		assertEquals("76976a29-c518-4b5a-91b0-b69bfa26ee5f", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(8545415545591712602L, result.getMostSignificantBits());
		assertEquals(-7948652561275883937L, result.getLeastSignificantBits());
	}

	/**
	 * Run the TkRefexUuidIntRevision makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidIntRevision result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getIntValue());
		assertEquals(null, result.getUuid1());
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
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setIntValue(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
	public void testSetIntValue_1()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		int intValue = 1;

		fixture.setIntValue(intValue);

		// add additional test code here
	}

	/**
	 * Run the void setUuid1(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
	public void testSetUuid1_1()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		UUID uuid1 = UUID.randomUUID();

		fixture.setUuid1(uuid1);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexUuidIntRevision:  c1:2b54310e-e880-4d60-96da-63885def47a1 int: 1  s:68f5a623-8bbf-490b-9296-bad83ca4dd81 a:1b3b12e2-ab5d-45b8-90c3-eb6b7d51b24d p:429edce8-8687-4a47-ac01-c4479a36bcbb t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRefexUuidIntRevision fixture = new TkRefexUuidIntRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setIntValue(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:44 PM
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
	 * @generatedBy CodePro at 2/4/12 3:44 PM
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
	 * @generatedBy CodePro at 2/4/12 3:44 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexUuidIntRevisionTest.class);
	}
}