package org.ihtsdo.tk.dto.concept.component.refex.type_uuid_float;

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
import org.ihtsdo.tk.api.refex.type_nid_float.RefexNidFloatVersionBI;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexUuidFloatRevisionTest</code> contains tests for the class <code>{@link TkRefexUuidFloatRevision}</code>.
 *
 * @generatedBy CodePro at 2/4/12 4:59 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexUuidFloatRevisionTest {
	/**
	 * Run the TkRefexUuidFloatRevision() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
	public void testTkRefexUuidFloatRevision_1()
		throws Exception {

		TkRefexUuidFloatRevision result = new TkRefexUuidFloatRevision();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0f, result.getFloat1(), 1.0f);
		assertEquals(null, result.getUuid1());
		assertEquals(Long.MIN_VALUE, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexUuidFloatRevision(RefexNidFloatVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidFloatRevision_2()
		throws Exception {
		RefexNidFloatVersionBI another = null;

		TkRefexUuidFloatRevision result = new TkRefexUuidFloatRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_float.TkRefexUuidFloatRevision.<init>(TkRefexUuidFloatRevision.java:34)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidFloatRevision(RefexNidFloatVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidFloatRevision_3()
		throws Exception {
		RefexNidFloatVersionBI another = null;

		TkRefexUuidFloatRevision result = new TkRefexUuidFloatRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_float.TkRefexUuidFloatRevision.<init>(TkRefexUuidFloatRevision.java:34)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidFloatRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidFloatRevision_4()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidFloatRevision result = new TkRefexUuidFloatRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidFloatRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidFloatRevision_5()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidFloatRevision result = new TkRefexUuidFloatRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidFloatRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidFloatRevision_6()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidFloatRevision result = new TkRefexUuidFloatRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidFloatRevision(TkRefexUuidFloatRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
	public void testTkRefexUuidFloatRevision_7()
		throws Exception {
		TkRefexUuidFloatRevision another = new TkRefexUuidFloatRevision();
		another.setUuid1(UUID.randomUUID());
		another.setFloat1(1.0f);
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkRefexUuidFloatRevision result = new TkRefexUuidFloatRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0f, result.getFloat1(), 1.0f);
		assertEquals(-9223372036854775807L, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexUuidFloatRevision(TkRefexUuidFloatRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
	public void testTkRefexUuidFloatRevision_8()
		throws Exception {
		TkRefexUuidFloatRevision another = new TkRefexUuidFloatRevision();
		another.setUuid1(UUID.randomUUID());
		another.setFloat1(1.0f);
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidFloatRevision result = new TkRefexUuidFloatRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0f, result.getFloat1(), 1.0f);
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
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		TkRefexUuidFloatRevision obj = new TkRefexUuidFloatRevision();
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
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		TkRefexUuidFloatRevision obj = new TkRefexUuidFloatRevision();
		obj.setUuid1(UUID.randomUUID());
		obj.setFloat1(1.0f);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		TkRefexUuidFloatRevision obj = new TkRefexUuidFloatRevision();
		obj.setUuid1(UUID.randomUUID());
		obj.setFloat1(1.0f);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		TkRefexUuidFloatRevision obj = new TkRefexUuidFloatRevision();
		obj.setUuid1(UUID.randomUUID());
		obj.setFloat1(1.0f);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the float getFloat1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
	public void testGetFloat1_1()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();

		float result = fixture.getFloat1();

		// add additional test code here
		assertEquals(1.0f, result, 0.1f);
	}

	/**
	 * Run the UUID getUuid1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
        @Ignore
	public void testGetUuid1_1()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();

		UUID result = fixture.getUuid1();

		// add additional test code here
		assertNotNull(result);
		assertEquals("3f9ad343-affb-491f-812e-fe05fa514186", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(4583207858471651615L, result.getMostSignificantBits());
		assertEquals(-9138087292260236922L, result.getLeastSignificantBits());
	}

	/**
	 * Run the TkRefexUuidFloatRevision makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidFloatRevision result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0f, result.getFloat1(), 1.0f);
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
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setFloat1(float) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
	public void testSetFloat1_1()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		float float1 = 1.0f;

		fixture.setFloat1(float1);

		// add additional test code here
	}

	/**
	 * Run the void setUuid1(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
	public void testSetUuid1_1()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		UUID uuid1 = UUID.randomUUID();

		fixture.setUuid1(uuid1);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexUuidFloatRevision:  c1:5e5b3a85-b2ad-4775-adf0-98afa23fdf32 flt:1.0  s:2e3a610f-6df9-42cc-9ce9-a231440bc046 a:4a253a85-7eb9-4e8c-82e3-03c41a77900d p:3d3e0ff5-5aa3-4110-ab37-ed161a1132da t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRefexUuidFloatRevision fixture = new TkRefexUuidFloatRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setFloat1(1.0f);
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:59 PM
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
	 * @generatedBy CodePro at 2/4/12 4:59 PM
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
	 * @generatedBy CodePro at 2/4/12 4:59 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexUuidFloatRevisionTest.class);
	}
}