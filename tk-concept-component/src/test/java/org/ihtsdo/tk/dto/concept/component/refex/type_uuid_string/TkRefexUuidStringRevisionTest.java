package org.ihtsdo.tk.dto.concept.component.refex.type_uuid_string;

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
import org.ihtsdo.tk.api.refex.type_nid_string.RefexNidStringVersionBI;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexUuidStringRevisionTest</code> contains tests for the class <code>{@link TkRefexUuidStringRevision}</code>.
 *
 * @generatedBy CodePro at 2/4/12 3:50 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexUuidStringRevisionTest {
	/**
	 * Run the TkRefexUuidStringRevision() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
	public void testTkRefexUuidStringRevision_1()
		throws Exception {

		TkRefexUuidStringRevision result = new TkRefexUuidStringRevision();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
		assertEquals(null, result.getString1());
		assertEquals(Long.MIN_VALUE, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexUuidStringRevision(RefexNidStringVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidStringRevision_2()
		throws Exception {
		RefexNidStringVersionBI another = null;

		TkRefexUuidStringRevision result = new TkRefexUuidStringRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_string.TkRefexUuidStringRevision.<init>(TkRefexUuidStringRevision.java:34)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidStringRevision(RefexNidStringVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidStringRevision_3()
		throws Exception {
		RefexNidStringVersionBI another = null;

		TkRefexUuidStringRevision result = new TkRefexUuidStringRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_string.TkRefexUuidStringRevision.<init>(TkRefexUuidStringRevision.java:34)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidStringRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidStringRevision_4()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidStringRevision result = new TkRefexUuidStringRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidStringRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidStringRevision_5()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidStringRevision result = new TkRefexUuidStringRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidStringRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidStringRevision_6()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidStringRevision result = new TkRefexUuidStringRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidStringRevision(TkRefexUuidStringRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
	public void testTkRefexUuidStringRevision_7()
		throws Exception {
		TkRefexUuidStringRevision another = new TkRefexUuidStringRevision();
		another.setString1("");
		another.setUuid1(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkRefexUuidStringRevision result = new TkRefexUuidStringRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getString1());
		assertEquals(-9223372036854775807L, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexUuidStringRevision(TkRefexUuidStringRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
	public void testTkRefexUuidStringRevision_8()
		throws Exception {
		TkRefexUuidStringRevision another = new TkRefexUuidStringRevision();
		another.setString1("");
		another.setUuid1(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidStringRevision result = new TkRefexUuidStringRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
		assertEquals("", result.getString1());
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
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidStringRevision obj = new TkRefexUuidStringRevision();
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
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidStringRevision obj = new TkRefexUuidStringRevision();
		obj.setString1("");
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
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidStringRevision obj = new TkRefexUuidStringRevision();
		obj.setString1("");
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
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidStringRevision obj = new TkRefexUuidStringRevision();
		obj.setString1("");
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
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the String getString1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
	public void testGetString1_1()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.getString1();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the UUID getUuid1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
        @Ignore
	public void testGetUuid1_1()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		UUID result = fixture.getUuid1();

		// add additional test code here
		assertNotNull(result);
		assertEquals("95d2b77c-41f8-465f-876d-7cbe51193e7e", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-7650851072638433697L, result.getMostSignificantBits());
		assertEquals(-8688150949281579394L, result.getLeastSignificantBits());
	}

	/**
	 * Run the TkRefexUuidStringRevision makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidStringRevision result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
		assertEquals("", result.getString1());
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
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setString1(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
	public void testSetString1_1()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		String string1 = "";

		fixture.setString1(string1);

		// add additional test code here
	}

	/**
	 * Run the void setUuid1(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
	public void testSetUuid1_1()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		UUID uuid1 = UUID.randomUUID();

		fixture.setUuid1(uuid1);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexUuidStringRevision:  c1: c22f76f7-bb37-4fab-ab4d-2bd3b426e3df str: ''  s:8b042fcd-d9aa-4f75-aa65-e971d9ee0b7d a:0d97e99a-7a55-4999-b746-88d7fe79517b p:3cce8882-ff14-4f43-b6ba-d6362ad481a9 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRefexUuidStringRevision fixture = new TkRefexUuidStringRevision();
		fixture.setString1("");
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:50 PM
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
	 * @generatedBy CodePro at 2/4/12 3:50 PM
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
	 * @generatedBy CodePro at 2/4/12 3:50 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexUuidStringRevisionTest.class);
	}
}