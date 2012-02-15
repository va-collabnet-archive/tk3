package org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid;

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
import org.ihtsdo.tk.api.refex.type_nid_nid_nid.RefexNidNidNidVersionBI;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexUuidUuidUuidRevisionTest</code> contains tests for the class <code>{@link TkRefexUuidUuidUuidRevision}</code>.
 *
 * @generatedBy CodePro at 2/4/12 3:28 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexUuidUuidUuidRevisionTest {
	/**
	 * Run the TkRefexUuidUuidUuidRevision() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testTkRefexUuidUuidUuidRevision_1()
		throws Exception {

		TkRefexUuidUuidUuidRevision result = new TkRefexUuidUuidUuidRevision();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
		assertEquals(null, result.getUuid2());
		assertEquals(null, result.getUuid3());
		assertEquals(Long.MIN_VALUE, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexUuidUuidUuidRevision(RefexNidNidNidVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidUuidRevision_2()
		throws Exception {
		RefexNidNidNidVersionBI another = null;

		TkRefexUuidUuidUuidRevision result = new TkRefexUuidUuidUuidRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidRevision.<init>(TkRefexUuidUuidUuidRevision.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidRevision(RefexNidNidNidVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidUuidRevision_3()
		throws Exception {
		RefexNidNidNidVersionBI another = null;

		TkRefexUuidUuidUuidRevision result = new TkRefexUuidUuidUuidRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidRevision.<init>(TkRefexUuidUuidUuidRevision.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidRevision(RefexNidNidNidVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidUuidRevision_4()
		throws Exception {
		RefexNidNidNidVersionBI another = null;

		TkRefexUuidUuidUuidRevision result = new TkRefexUuidUuidUuidRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidRevision.<init>(TkRefexUuidUuidUuidRevision.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidRevision(RefexNidNidNidVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidUuidRevision_5()
		throws Exception {
		RefexNidNidNidVersionBI another = null;

		TkRefexUuidUuidUuidRevision result = new TkRefexUuidUuidUuidRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidRevision.<init>(TkRefexUuidUuidUuidRevision.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidUuidUuidRevision_6()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidUuidUuidRevision result = new TkRefexUuidUuidUuidRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidUuidUuidRevision_7()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidUuidUuidRevision result = new TkRefexUuidUuidUuidRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidUuidUuidRevision_8()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidUuidUuidRevision result = new TkRefexUuidUuidUuidRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidRevision(TkRefexUuidUuidUuidRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testTkRefexUuidUuidUuidRevision_9()
		throws Exception {
		TkRefexUuidUuidUuidRevision another = new TkRefexUuidUuidUuidRevision();
		another.setUuid2(UUID.randomUUID());
		another.setUuid3(UUID.randomUUID());
		another.setUuid1(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkRefexUuidUuidUuidRevision result = new TkRefexUuidUuidUuidRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(-9223372036854775807L, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexUuidUuidUuidRevision(TkRefexUuidUuidUuidRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testTkRefexUuidUuidUuidRevision_10()
		throws Exception {
		TkRefexUuidUuidUuidRevision another = new TkRefexUuidUuidUuidRevision();
		another.setUuid2(UUID.randomUUID());
		another.setUuid3(UUID.randomUUID());
		another.setUuid1(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidUuidUuidRevision result = new TkRefexUuidUuidUuidRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
		assertEquals(null, result.getUuid2());
		assertEquals(null, result.getUuid3());
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		TkRefexUuidUuidUuidRevision obj = new TkRefexUuidUuidUuidRevision();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		TkRefexUuidUuidUuidRevision obj = new TkRefexUuidUuidUuidRevision();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		TkRefexUuidUuidUuidRevision obj = new TkRefexUuidUuidUuidRevision();
		obj.setUuid2(UUID.randomUUID());
		obj.setUuid3(UUID.randomUUID());
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		TkRefexUuidUuidUuidRevision obj = new TkRefexUuidUuidUuidRevision();
		obj.setUuid2(UUID.randomUUID());
		obj.setUuid3(UUID.randomUUID());
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		TkRefexUuidUuidUuidRevision obj = new TkRefexUuidUuidUuidRevision();
		obj.setUuid2(UUID.randomUUID());
		obj.setUuid3(UUID.randomUUID());
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
        @Ignore
	public void testGetUuid1_1()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();

		UUID result = fixture.getUuid1();

		// add additional test code here
		assertNotNull(result);
		assertEquals("2cdd05c1-9877-4199-bf9e-8e45eed1b62f", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(3232746436566663577L, result.getMostSignificantBits());
		assertEquals(-4639114135134423505L, result.getLeastSignificantBits());
	}

	/**
	 * Run the UUID getUuid2() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
        @Ignore
	public void testGetUuid2_1()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();

		UUID result = fixture.getUuid2();

		// add additional test code here
		assertNotNull(result);
		assertEquals("9f491a9e-a413-4f4d-9d46-fdfb9b455816", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-6969009679719248051L, result.getMostSignificantBits());
		assertEquals(-7113719304301488106L, result.getLeastSignificantBits());
	}

	/**
	 * Run the UUID getUuid3() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
        @Ignore
	public void testGetUuid3_1()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();

		UUID result = fixture.getUuid3();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ce464a6a-527a-4a7d-9dce-ef1b706115f2", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-3583094633015915907L, result.getMostSignificantBits());
		assertEquals(-7075455063423904270L, result.getLeastSignificantBits());
	}

	/**
	 * Run the TkRefexUuidUuidUuidRevision makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidUuidUuidRevision result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
		assertEquals(null, result.getUuid2());
		assertEquals(null, result.getUuid3());
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_9()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testSetUuid1_1()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		UUID uuid1 = UUID.randomUUID();

		fixture.setUuid1(uuid1);

		// add additional test code here
	}

	/**
	 * Run the void setUuid2(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testSetUuid2_1()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		UUID uuid2 = UUID.randomUUID();

		fixture.setUuid2(uuid2);

		// add additional test code here
	}

	/**
	 * Run the void setUuid3(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testSetUuid3_1()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		UUID uuid3 = UUID.randomUUID();

		fixture.setUuid3(uuid3);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexUuidUuidUuidRevision:  c1:535ba171-1f77-4858-b62e-044a5e43f735 c2:a02d6636-e61f-49ed-ad7d-6788c5036135 c3:c2cdc30e-447d-466e-9a08-a311fe8269e4  s:f8562927-0bdc-471b-8d04-59784ecf2f12 a:acad91e5-3974-44ee-92a1-2d11a2c53f0b p:72a0758f-0d01-4193-b2db-ddf84c187e94 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	@Test
	public void testWriteExternal_8()
		throws Exception {
		TkRefexUuidUuidUuidRevision fixture = new TkRefexUuidUuidUuidRevision();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
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
	 * @generatedBy CodePro at 2/4/12 3:28 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexUuidUuidUuidRevisionTest.class);
	}
}