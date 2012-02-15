package org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid;

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
import org.ihtsdo.tk.api.refex.type_nid_nid.RefexNidNidVersionBI;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexUuidUuidRevisionTest</code> contains tests for the class <code>{@link TkRefexUuidUuidRevision}</code>.
 *
 * @generatedBy CodePro at 2/4/12 3:47 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexUuidUuidRevisionTest {
	/**
	 * Run the TkRefexUuidUuidRevision() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
	public void testTkRefexUuidUuidRevision_1()
		throws Exception {

		TkRefexUuidUuidRevision result = new TkRefexUuidUuidRevision();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
		assertEquals(null, result.getUuid2());
		assertEquals(Long.MIN_VALUE, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexUuidUuidRevision(RefexNidNidVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidRevision_2()
		throws Exception {
		RefexNidNidVersionBI another = null;

		TkRefexUuidUuidRevision result = new TkRefexUuidUuidRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid.TkRefexUuidUuidRevision.<init>(TkRefexUuidUuidRevision.java:34)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidRevision(RefexNidNidVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidRevision_3()
		throws Exception {
		RefexNidNidVersionBI another = null;

		TkRefexUuidUuidRevision result = new TkRefexUuidUuidRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid.TkRefexUuidUuidRevision.<init>(TkRefexUuidUuidRevision.java:34)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidRevision(RefexNidNidVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidRevision_4()
		throws Exception {
		RefexNidNidVersionBI another = null;

		TkRefexUuidUuidRevision result = new TkRefexUuidUuidRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid.TkRefexUuidUuidRevision.<init>(TkRefexUuidUuidRevision.java:34)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidUuidRevision_5()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidUuidRevision result = new TkRefexUuidUuidRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidUuidRevision_6()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidUuidRevision result = new TkRefexUuidUuidRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidUuidRevision_7()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidUuidRevision result = new TkRefexUuidUuidRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidRevision(TkRefexUuidUuidRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
	public void testTkRefexUuidUuidRevision_8()
		throws Exception {
		TkRefexUuidUuidRevision another = new TkRefexUuidUuidRevision();
		another.setUuid2(UUID.randomUUID());
		another.setUuid1(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkRefexUuidUuidRevision result = new TkRefexUuidUuidRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(-9223372036854775807L, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexUuidUuidRevision(TkRefexUuidUuidRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
	public void testTkRefexUuidUuidRevision_9()
		throws Exception {
		TkRefexUuidUuidRevision another = new TkRefexUuidUuidRevision();
		another.setUuid2(UUID.randomUUID());
		another.setUuid1(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidUuidRevision result = new TkRefexUuidUuidRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
		assertEquals(null, result.getUuid2());
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidUuidRevision obj = new TkRefexUuidUuidRevision();
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidUuidRevision obj = new TkRefexUuidUuidRevision();
		obj.setUuid2(UUID.randomUUID());
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidUuidRevision obj = new TkRefexUuidUuidRevision();
		obj.setUuid2(UUID.randomUUID());
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidUuidRevision obj = new TkRefexUuidUuidRevision();
		obj.setUuid2(UUID.randomUUID());
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
        @Ignore
	public void testGetUuid1_1()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();

		UUID result = fixture.getUuid1();

		// add additional test code here
		assertNotNull(result);
		assertEquals("a3c29b5f-2ae6-4b84-ad1a-64584fe4a2df", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-6646579267001496700L, result.getMostSignificantBits());
		assertEquals(-5973351625293258017L, result.getLeastSignificantBits());
	}

	/**
	 * Run the UUID getUuid2() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
        @Ignore
	public void testGetUuid2_1()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();

		UUID result = fixture.getUuid2();

		// add additional test code here
		assertNotNull(result);
		assertEquals("21750717-d23f-4a6a-97ef-9c317d14b0d5", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(2410840974419774058L, result.getMostSignificantBits());
		assertEquals(-7498603118182747947L, result.getLeastSignificantBits());
	}

	/**
	 * Run the TkRefexUuidUuidRevision makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidUuidRevision result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
		assertEquals(null, result.getUuid2());
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
	public void testSetUuid1_1()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		UUID uuid1 = UUID.randomUUID();

		fixture.setUuid1(uuid1);

		// add additional test code here
	}

	/**
	 * Run the void setUuid2(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
	public void testSetUuid2_1()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		UUID uuid2 = UUID.randomUUID();

		fixture.setUuid2(uuid2);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexUuidUuidRevision:  c1:abe613d6-69aa-4f0e-9cfe-3ebabf38dc49 c2:2a852378-a225-421d-a608-9a9a43d2ec56  s:12d4c322-57bc-4a16-8f32-8b7e505894de a:b09ce794-18f9-4206-9ef4-5cece613222a p:f8c887b8-772e-4789-bad3-10a5fb34e88e t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkRefexUuidUuidRevision fixture = new TkRefexUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
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
	 * @generatedBy CodePro at 2/4/12 3:47 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexUuidUuidRevisionTest.class);
	}
}