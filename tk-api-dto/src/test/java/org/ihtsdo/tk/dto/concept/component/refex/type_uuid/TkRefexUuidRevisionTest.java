package org.ihtsdo.tk.dto.concept.component.refex.type_uuid;

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
import org.ihtsdo.tk.api.refex.type_nid.RefexNidVersionBI;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexUuidRevisionTest</code> contains tests for the class <code>{@link TkRefexUuidRevision}</code>.
 *
 * @generatedBy CodePro at 2/4/12 4:00 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexUuidRevisionTest {
	/**
	 * Run the TkRefexUuidRevision() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test
	public void testTkRefexUuidRevision_1()
		throws Exception {

		TkRefexUuidRevision result = new TkRefexUuidRevision();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
		assertEquals(Long.MIN_VALUE, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexUuidRevision(RefexNidVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidRevision_2()
		throws Exception {
		RefexNidVersionBI another = null;

		TkRefexUuidRevision result = new TkRefexUuidRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid.TkRefexUuidRevision.<init>(TkRefexUuidRevision.java:33)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidRevision(RefexNidVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidRevision_3()
		throws Exception {
		RefexNidVersionBI another = null;

		TkRefexUuidRevision result = new TkRefexUuidRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid.TkRefexUuidRevision.<init>(TkRefexUuidRevision.java:33)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidRevision_4()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidRevision result = new TkRefexUuidRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidRevision_5()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidRevision result = new TkRefexUuidRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidRevision_6()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidRevision result = new TkRefexUuidRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidRevision(TkRefexUuidRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test
	public void testTkRefexUuidRevision_7()
		throws Exception {
		TkRefexUuidRevision another = new TkRefexUuidRevision();
		another.setUuid1(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkRefexUuidRevision result = new TkRefexUuidRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(-9223372036854775807L, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexUuidRevision(TkRefexUuidRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test
	public void testTkRefexUuidRevision_8()
		throws Exception {
		TkRefexUuidRevision another = new TkRefexUuidRevision();
		another.setUuid1(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidRevision result = new TkRefexUuidRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
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
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexUuidRevision fixture = new TkRefexUuidRevision();
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
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexUuidRevision fixture = new TkRefexUuidRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidRevision obj = new TkRefexUuidRevision();
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
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexUuidRevision fixture = new TkRefexUuidRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidRevision obj = new TkRefexUuidRevision();
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
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexUuidRevision fixture = new TkRefexUuidRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidRevision obj = new TkRefexUuidRevision();
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
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexUuidRevision fixture = new TkRefexUuidRevision();
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
	 * Run the UUID getUuid1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test
        @Ignore
	public void testGetUuid1_1()
		throws Exception {
		TkRefexUuidRevision fixture = new TkRefexUuidRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		UUID result = fixture.getUuid1();

		// add additional test code here
		assertNotNull(result);
		assertEquals("8315bfc9-1134-41e1-a368-780670de62ad", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-9001077409932099103L, result.getMostSignificantBits());
		assertEquals(-6671950878890630483L, result.getLeastSignificantBits());
	}

	/**
	 * Run the TkRefexUuidRevision makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexUuidRevision fixture = new TkRefexUuidRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidRevision result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
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
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexUuidRevision fixture = new TkRefexUuidRevision();
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
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexUuidRevision fixture = new TkRefexUuidRevision();
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
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexUuidRevision fixture = new TkRefexUuidRevision();
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
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexUuidRevision fixture = new TkRefexUuidRevision();
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
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexUuidRevision fixture = new TkRefexUuidRevision();
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
	 * Run the void setUuid1(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test
	public void testSetUuid1_1()
		throws Exception {
		TkRefexUuidRevision fixture = new TkRefexUuidRevision();
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
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexUuidRevision fixture = new TkRefexUuidRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexUuidRevision:  c1:545a93aa-1a1d-4163-b281-7dbbf63daa9d  s:00af7352-d14a-4b96-ae61-b5586cbc3164 a:1251994b-8272-4832-9e96-f30075afec02 p:77c735c4-183e-406c-bf39-12ba028c417c t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexUuidRevision fixture = new TkRefexUuidRevision();
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
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexUuidRevision fixture = new TkRefexUuidRevision();
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
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexUuidRevision fixture = new TkRefexUuidRevision();
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
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexUuidRevision fixture = new TkRefexUuidRevision();
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
	 * @generatedBy CodePro at 2/4/12 4:00 PM
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
	 * @generatedBy CodePro at 2/4/12 4:00 PM
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
	 * @generatedBy CodePro at 2/4/12 4:00 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexUuidRevisionTest.class);
	}
}