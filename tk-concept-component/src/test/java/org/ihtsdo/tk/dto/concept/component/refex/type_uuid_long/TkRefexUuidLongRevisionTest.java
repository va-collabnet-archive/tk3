package org.ihtsdo.tk.dto.concept.component.refex.type_uuid_long;

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
import org.ihtsdo.tk.api.refex.type_nid_long.RefexNidLongVersionBI;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexUuidLongRevisionTest</code> contains tests for the class <code>{@link TkRefexUuidLongRevision}</code>.
 *
 * @generatedBy CodePro at 2/4/12 3:41 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexUuidLongRevisionTest {
	/**
	 * Run the TkRefexUuidLongRevision() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
	public void testTkRefexUuidLongRevision_1()
		throws Exception {

		TkRefexUuidLongRevision result = new TkRefexUuidLongRevision();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0L, result.getLong1());
		assertEquals(null, result.getUuid1());
		assertEquals(Long.MIN_VALUE, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexUuidLongRevision(RefexNidLongVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidLongRevision_2()
		throws Exception {
		RefexNidLongVersionBI another = null;

		TkRefexUuidLongRevision result = new TkRefexUuidLongRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_long.TkRefexUuidLongRevision.<init>(TkRefexUuidLongRevision.java:34)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidLongRevision(RefexNidLongVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidLongRevision_3()
		throws Exception {
		RefexNidLongVersionBI another = null;

		TkRefexUuidLongRevision result = new TkRefexUuidLongRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_long.TkRefexUuidLongRevision.<init>(TkRefexUuidLongRevision.java:34)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidLongRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidLongRevision_4()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidLongRevision result = new TkRefexUuidLongRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidLongRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidLongRevision_5()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidLongRevision result = new TkRefexUuidLongRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidLongRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidLongRevision_6()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidLongRevision result = new TkRefexUuidLongRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidLongRevision(TkRefexUuidLongRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
	public void testTkRefexUuidLongRevision_7()
		throws Exception {
		TkRefexUuidLongRevision another = new TkRefexUuidLongRevision();
		another.setLong1(1L);
		another.setUuid1(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkRefexUuidLongRevision result = new TkRefexUuidLongRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1L, result.getLong1());
		assertEquals(-9223372036854775807L, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexUuidLongRevision(TkRefexUuidLongRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
	public void testTkRefexUuidLongRevision_8()
		throws Exception {
		TkRefexUuidLongRevision another = new TkRefexUuidLongRevision();
		another.setLong1(1L);
		another.setUuid1(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidLongRevision result = new TkRefexUuidLongRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1L, result.getLong1());
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
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkRefexUuidLongRevision obj = new TkRefexUuidLongRevision();
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
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkRefexUuidLongRevision obj = new TkRefexUuidLongRevision();
		obj.setLong1(1L);
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
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkRefexUuidLongRevision obj = new TkRefexUuidLongRevision();
		obj.setLong1(1L);
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
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkRefexUuidLongRevision obj = new TkRefexUuidLongRevision();
		obj.setLong1(1L);
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
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the long getLong1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
	public void testGetLong1_1()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		long result = fixture.getLong1();

		// add additional test code here
		assertEquals(1L, result);
	}

	/**
	 * Run the UUID getUuid1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
        @Ignore
	public void testGetUuid1_1()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		UUID result = fixture.getUuid1();

		// add additional test code here
		assertNotNull(result);
		assertEquals("338feca3-033e-46f4-9249-c52df288a4f4", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(3715448402482185972L, result.getMostSignificantBits());
		assertEquals(-7905570869738953484L, result.getLeastSignificantBits());
	}

	/**
	 * Run the TkRefexUuidLongRevision makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidLongRevision result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1L, result.getLong1());
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
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setLong1(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
	public void testSetLong1_1()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		long long1 = 1L;

		fixture.setLong1(long1);

		// add additional test code here
	}

	/**
	 * Run the void setUuid1(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
	public void testSetUuid1_1()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexUuidLongRevision:  c1: b943c024-d70d-4002-bd2b-627738593bfb long: 1  s:64ee76b7-7086-46a1-bb10-04ac7aacc352 a:13b62d97-c955-4871-88d7-f6a4e3e878bf p:6edb0a9e-01af-40db-aa05-c99c2b4f0aba t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRefexUuidLongRevision fixture = new TkRefexUuidLongRevision();
		fixture.setLong1(1L);
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:41 PM
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
	 * @generatedBy CodePro at 2/4/12 3:41 PM
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
	 * @generatedBy CodePro at 2/4/12 3:41 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexUuidLongRevisionTest.class);
	}
}