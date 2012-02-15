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
import org.ihtsdo.tk.api.id.UuidIdBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkIdentifierUuidTest</code> contains tests for the class <code>{@link TkIdentifierUuid}</code>.
 *
 * @generatedBy CodePro at 2/4/12 4:46 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkIdentifierUuidTest {
	/**
	 * Run the TkIdentifierUuid() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test
	public void testTkIdentifierUuid_1()
		throws Exception {

		TkIdentifierUuid result = new TkIdentifierUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getDenotation());
		assertEquals(null, result.getAuthorityUuid());
		assertEquals(Long.MIN_VALUE, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkIdentifierUuid(UUID) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test
	public void testTkIdentifierUuid_2()
		throws Exception {
		UUID denotation = UUID.randomUUID();

		TkIdentifierUuid result = new TkIdentifierUuid(denotation);

		// add additional test code here
		assertNotNull(result);
		assertEquals(Long.MIN_VALUE, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkIdentifierUuid(UuidIdBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test
        @Ignore
	public void testTkIdentifierUuid_3()
		throws Exception {
		UuidIdBI id = null;

		TkIdentifierUuid result = new TkIdentifierUuid(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:55)
		//       at org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier.<init>(TkIdentifier.java:36)
		//       at org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifierUuid.<init>(TkIdentifierUuid.java:39)
		assertNotNull(result);
	}

	/**
	 * Run the TkIdentifierUuid(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkIdentifierUuid_4()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkIdentifierUuid result = new TkIdentifierUuid(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkIdentifierUuid(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkIdentifierUuid_5()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkIdentifierUuid result = new TkIdentifierUuid(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkIdentifierUuid(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkIdentifierUuid_6()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkIdentifierUuid result = new TkIdentifierUuid(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkIdentifierUuid(TkIdentifierUuid,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test
	public void testTkIdentifierUuid_7()
		throws Exception {
		TkIdentifierUuid another = new TkIdentifierUuid(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkIdentifierUuid result = new TkIdentifierUuid(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getDenotation());
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
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkIdentifierUuid fixture = new TkIdentifierUuid(UUID.randomUUID());
		fixture.authorityUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkIdentifierUuid fixture = new TkIdentifierUuid(UUID.randomUUID());
		fixture.authorityUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		Object obj = new TkIdentifierUuid(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkIdentifierUuid fixture = new TkIdentifierUuid(UUID.randomUUID());
		fixture.authorityUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		Object obj = new TkIdentifierUuid(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkIdentifierUuid fixture = new TkIdentifierUuid(UUID.randomUUID());
		fixture.authorityUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		Object obj = new TkIdentifierUuid(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkIdentifierUuid fixture = new TkIdentifierUuid(UUID.randomUUID());
		fixture.authorityUuid = UUID.randomUUID();
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
	 * Run the UUID getDenotation() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test
        @Ignore
	public void testGetDenotation_1()
		throws Exception {
		TkIdentifierUuid fixture = new TkIdentifierUuid(UUID.randomUUID());
		fixture.authorityUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();

		UUID result = fixture.getDenotation();

		// add additional test code here
		assertNotNull(result);
		assertEquals("3e5310f5-4198-4e60-9e51-368aa2209e3c", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(4490951898972048992L, result.getMostSignificantBits());
		assertEquals(-7038784773549941188L, result.getLeastSignificantBits());
	}

	/**
	 * Run the IDENTIFIER_PART_TYPES getIdType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test
	public void testGetIdType_1()
		throws Exception {
		TkIdentifierUuid fixture = new TkIdentifierUuid(UUID.randomUUID());
		fixture.authorityUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();

		IDENTIFIER_PART_TYPES result = fixture.getIdType();

		// add additional test code here
		assertNotNull(result);
		assertEquals("UUID", result.name());
		assertEquals("UUID", result.toString());
		assertEquals(2, result.ordinal());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkIdentifierUuid fixture = new TkIdentifierUuid(UUID.randomUUID());
		fixture.authorityUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(258743308, result);
	}

	/**
	 * Run the TkRevision makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkIdentifierUuid fixture = new TkIdentifierUuid(UUID.randomUUID());
		fixture.authorityUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test
	public void testSetDenotation_1()
		throws Exception {
		TkIdentifierUuid fixture = new TkIdentifierUuid(UUID.randomUUID());
		fixture.authorityUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		Object denotation = UUID.randomUUID();

		fixture.setDenotation(denotation);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkIdentifierUuid fixture = new TkIdentifierUuid(UUID.randomUUID());
		fixture.authorityUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkIdentifierUuid:  denotation:ca25381f-b539-4eac-8516-48675ffbd906  authority:805bfaee-df0d-41a0-adb2-76b6498eb882  s:cf28a8be-728f-4333-b6eb-142d417e85ea a:14f7131d-6a37-406a-bdb0-ad84d587b971 p:c3819b1f-a757-431b-96af-d6957fafa54e t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeDenotation(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test
	public void testWriteDenotation_1()
		throws Exception {
		TkIdentifierUuid fixture = new TkIdentifierUuid(UUID.randomUUID());
		fixture.authorityUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test
	public void testWriteDenotation_2()
		throws Exception {
		TkIdentifierUuid fixture = new TkIdentifierUuid(UUID.randomUUID());
		fixture.authorityUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	@Test
	public void testWriteDenotation_3()
		throws Exception {
		TkIdentifierUuid fixture = new TkIdentifierUuid(UUID.randomUUID());
		fixture.authorityUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:46 PM
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
	 * @generatedBy CodePro at 2/4/12 4:46 PM
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
	 * @generatedBy CodePro at 2/4/12 4:46 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkIdentifierUuidTest.class);
	}
}