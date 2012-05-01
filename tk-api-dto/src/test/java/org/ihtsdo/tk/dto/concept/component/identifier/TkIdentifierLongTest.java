package org.ihtsdo.tk.dto.concept.component.identifier;

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
import org.ihtsdo.tk.api.id.LongIdBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkIdentifierLongTest</code> contains tests for the class <code>{@link TkIdentifierLong}</code>.
 *
 * @generatedBy CodePro at 2/4/12 3:17 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkIdentifierLongTest {
	/**
	 * Run the TkIdentifierLong() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:17 PM
	 */
	@Test
	public void testTkIdentifierLong_1()
		throws Exception {

		TkIdentifierLong result = new TkIdentifierLong();

		// add additional test code here
		assertNotNull(result);
		assertEquals(new Long(0L), result.getDenotation());
		assertEquals(null, result.getAuthorityUuid());
		assertEquals(Long.MIN_VALUE, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkIdentifierLong(LongIdBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:17 PM
	 */
	@Test
        @Ignore
	public void testTkIdentifierLong_2()
		throws Exception {
		LongIdBI id = null;

		TkIdentifierLong result = new TkIdentifierLong(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:55)
		//       at org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier.<init>(TkIdentifier.java:36)
		//       at org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifierLong.<init>(TkIdentifierLong.java:32)
		assertNotNull(result);
	}

	/**
	 * Run the TkIdentifierLong(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:17 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkIdentifierLong_3()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkIdentifierLong result = new TkIdentifierLong(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkIdentifierLong(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:17 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkIdentifierLong_4()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkIdentifierLong result = new TkIdentifierLong(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkIdentifierLong(TkIdentifierLong,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:17 PM
	 */
	@Test
	public void testTkIdentifierLong_5()
		throws Exception {
		TkIdentifierLong another = new TkIdentifierLong();
		another.setDenotation(Long.valueOf(1L));
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkIdentifierLong result = new TkIdentifierLong(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(new Long(1L), result.getDenotation());
		assertEquals(null, result.getAuthorityUuid());
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
	 * @generatedBy CodePro at 2/4/12 3:17 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.setDenotation(Long.valueOf(1L));
		fixture.time = 1L;
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:17 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.setDenotation(Long.valueOf(1L));
		fixture.time = 1L;
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkIdentifierLong obj = new TkIdentifierLong();
		obj.setDenotation(Long.valueOf(1L));

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:17 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.setDenotation(Long.valueOf(1L));
		fixture.time = 1L;
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkIdentifierLong obj = new TkIdentifierLong();
		obj.setDenotation(Long.valueOf(1L));

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:17 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.setDenotation(Long.valueOf(1L));
		fixture.time = 1L;
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkIdentifierLong obj = new TkIdentifierLong();
		obj.setDenotation(Long.valueOf(1L));

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:17 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.setDenotation(Long.valueOf(1L));
		fixture.time = 1L;
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the Long getDenotation() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:17 PM
	 */
	@Test
	public void testGetDenotation_1()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.setDenotation(Long.valueOf(1L));
		fixture.time = 1L;
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		Long result = fixture.getDenotation();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	/**
	 * Run the IDENTIFIER_PART_TYPES getIdType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:17 PM
	 */
	@Test
	public void testGetIdType_1()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.setDenotation(Long.valueOf(1L));
		fixture.time = 1L;
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		IDENTIFIER_PART_TYPES result = fixture.getIdType();

		// add additional test code here
		assertNotNull(result);
		assertEquals("LONG", result.name());
		assertEquals("LONG", result.toString());
		assertEquals(0, result.ordinal());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:17 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.setDenotation(Long.valueOf(1L));
		fixture.time = 1L;
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(-801631435, result);
	}

	/**
	 * Run the TkRevision makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:17 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.setDenotation(Long.valueOf(1L));
		fixture.time = 1L;
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRevision result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(2L, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the void setDenotation(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:17 PM
	 */
	@Test
	public void testSetDenotation_1()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.setDenotation(Long.valueOf(1L));
		fixture.time = 1L;
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		Object denotation = Long.valueOf(1L);

		fixture.setDenotation(denotation);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:17 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.setDenotation(Long.valueOf(1L));
		fixture.time = 1L;
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkIdentifierLong:  denotation:1  authority:138783a9-2999-45cc-b247-1bb5ad15e197  s:b6080483-2ef2-475a-b476-90eb59734aa5 a:f8dc476a-f1f4-4e36-8c27-3fda0eeea8d8 p:8261ea98-10b3-488f-828c-8d02a740015d t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeDenotation(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:17 PM
	 */
	@Test
	public void testWriteDenotation_1()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.setDenotation(Long.valueOf(1L));
		fixture.time = 1L;
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeDenotation(out);

		// add additional test code here
	}

	/**
	 * Run the void writeDenotation(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:17 PM
	 */
	@Test
	public void testWriteDenotation_2()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.setDenotation(Long.valueOf(1L));
		fixture.time = 1L;
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeDenotation(out);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2/4/12 3:17 PM
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
	 * @generatedBy CodePro at 2/4/12 3:17 PM
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
	 * @generatedBy CodePro at 2/4/12 3:17 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkIdentifierLongTest.class);
	}
}