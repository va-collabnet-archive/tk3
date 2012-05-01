package org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_string;

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
import org.ihtsdo.tk.api.refex.type_nid_nid_string.RefexNidNidStringVersionBI;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexUuidUuidStringRevisionTest</code> contains tests for the class <code>{@link TkRefexUuidUuidStringRevision}</code>.
 *
 * @generatedBy CodePro at 2/4/12 4:51 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexUuidUuidStringRevisionTest {
	/**
	 * Run the TkRefexUuidUuidStringRevision() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testTkRefexUuidUuidStringRevision_1()
		throws Exception {

		TkRefexUuidUuidStringRevision result = new TkRefexUuidUuidStringRevision();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
		assertEquals(null, result.getString1());
		assertEquals(null, result.getUuid2());
		assertEquals(Long.MIN_VALUE, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexUuidUuidStringRevision(RefexNidNidStringVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidStringRevision_2()
		throws Exception {
		RefexNidNidStringVersionBI another = null;

		TkRefexUuidUuidStringRevision result = new TkRefexUuidUuidStringRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_string.TkRefexUuidUuidStringRevision.<init>(TkRefexUuidUuidStringRevision.java:36)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidStringRevision(RefexNidNidStringVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidStringRevision_3()
		throws Exception {
		RefexNidNidStringVersionBI another = null;

		TkRefexUuidUuidStringRevision result = new TkRefexUuidUuidStringRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_string.TkRefexUuidUuidStringRevision.<init>(TkRefexUuidUuidStringRevision.java:36)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidStringRevision(RefexNidNidStringVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidStringRevision_4()
		throws Exception {
		RefexNidNidStringVersionBI another = null;

		TkRefexUuidUuidStringRevision result = new TkRefexUuidUuidStringRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_string.TkRefexUuidUuidStringRevision.<init>(TkRefexUuidUuidStringRevision.java:36)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidStringRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidUuidStringRevision_5()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidUuidStringRevision result = new TkRefexUuidUuidStringRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidStringRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidUuidStringRevision_6()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidUuidStringRevision result = new TkRefexUuidUuidStringRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidStringRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidUuidStringRevision_7()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidUuidStringRevision result = new TkRefexUuidUuidStringRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidStringRevision(TkRefexUuidUuidStringRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testTkRefexUuidUuidStringRevision_8()
		throws Exception {
		TkRefexUuidUuidStringRevision another = new TkRefexUuidUuidStringRevision();
		another.setUuid1(UUID.randomUUID());
		another.setString1("");
		another.setUuid2(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkRefexUuidUuidStringRevision result = new TkRefexUuidUuidStringRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getString1());
		assertEquals(-9223372036854775807L, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexUuidUuidStringRevision(TkRefexUuidUuidStringRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testTkRefexUuidUuidStringRevision_9()
		throws Exception {
		TkRefexUuidUuidStringRevision another = new TkRefexUuidUuidStringRevision();
		another.setUuid1(UUID.randomUUID());
		another.setString1("");
		another.setUuid2(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidUuidStringRevision result = new TkRefexUuidUuidStringRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
		assertEquals("", result.getString1());
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidUuidStringRevision obj = new TkRefexUuidUuidStringRevision();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidUuidStringRevision obj = new TkRefexUuidUuidStringRevision();
		obj.setUuid1(UUID.randomUUID());
		obj.setUuid2(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidUuidStringRevision obj = new TkRefexUuidUuidStringRevision();
		obj.setUuid1(UUID.randomUUID());
		obj.setString1("");
		obj.setUuid2(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidUuidStringRevision obj = new TkRefexUuidUuidStringRevision();
		obj.setUuid1(UUID.randomUUID());
		obj.setString1("");
		obj.setUuid2(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidUuidStringRevision obj = new TkRefexUuidUuidStringRevision();
		obj.setUuid1(UUID.randomUUID());
		obj.setString1("");
		obj.setUuid2(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testGetString1_1()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
        @Ignore
	public void testGetUuid1_1()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		UUID result = fixture.getUuid1();

		// add additional test code here
		assertNotNull(result);
		assertEquals("fc2889cf-2f8f-4270-929c-af0d368d402f", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-276819854134132112L, result.getMostSignificantBits());
		assertEquals(-7882232776520548305L, result.getLeastSignificantBits());
	}

	/**
	 * Run the UUID getUuid2() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
        @Ignore
	public void testGetUuid2_1()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		UUID result = fixture.getUuid2();

		// add additional test code here
		assertNotNull(result);
		assertEquals("3dfc97a5-1d5b-44a9-98d2-5b2b6cef6bb5", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(4466611665862608041L, result.getMostSignificantBits());
		assertEquals(-7434779792765916235L, result.getLeastSignificantBits());
	}

	/**
	 * Run the TkRefexUuidUuidStringRevision makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidUuidStringRevision result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
		assertEquals("", result.getString1());
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testSetString1_1()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testSetUuid1_1()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testSetUuid2_1()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexUuidUuidStringRevision:  c1:81a8a17b-a2f8-46a1-903d-7458b7b0f074 c2:d8d5d8a1-daf2-49ec-bc97-41e535573739 str:''  s:78b60b00-cbf7-4e45-b756-d358d736129e a:0d0149c6-cec0-4ea1-80c6-0e23cc5c4e9c p:51ccb2d3-f611-46c0-b478-0de9cb12eab8 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkRefexUuidUuidStringRevision fixture = new TkRefexUuidUuidStringRevision();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
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
	 * @generatedBy CodePro at 2/4/12 4:51 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexUuidUuidStringRevisionTest.class);
	}
}