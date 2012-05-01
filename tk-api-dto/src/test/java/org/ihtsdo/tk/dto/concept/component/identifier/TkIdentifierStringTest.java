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
import org.ihtsdo.tk.api.id.StringIdBI;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkIdentifierStringTest</code> contains tests for the class <code>{@link TkIdentifierString}</code>.
 *
 * @generatedBy CodePro at 2/4/12 3:33 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkIdentifierStringTest {
	/**
	 * Run the TkIdentifierString() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:33 PM
	 */
	@Test
	public void testTkIdentifierString_1()
		throws Exception {

		TkIdentifierString result = new TkIdentifierString();

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
	 * Run the TkIdentifierString(StringIdBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:33 PM
	 */
	@Test
        @Ignore
	public void testTkIdentifierString_2()
		throws Exception {
		StringIdBI id = null;

		TkIdentifierString result = new TkIdentifierString(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:55)
		//       at org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier.<init>(TkIdentifier.java:36)
		//       at org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifierString.<init>(TkIdentifierString.java:31)
		assertNotNull(result);
	}

	/**
	 * Run the TkIdentifierString(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:33 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkIdentifierString_3()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkIdentifierString result = new TkIdentifierString(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkIdentifierString(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:33 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkIdentifierString_4()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkIdentifierString result = new TkIdentifierString(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkIdentifierString(TkIdentifierString,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:33 PM
	 */
	@Test
	public void testTkIdentifierString_5()
		throws Exception {
		TkIdentifierString another = new TkIdentifierString();
		another.setDenotation("");
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkIdentifierString result = new TkIdentifierString(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getDenotation());
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
	 * @generatedBy CodePro at 2/4/12 3:33 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkIdentifierString fixture = new TkIdentifierString();
		fixture.setDenotation("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:33 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkIdentifierString fixture = new TkIdentifierString();
		fixture.setDenotation("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkIdentifierString obj = new TkIdentifierString();
		obj.setDenotation("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:33 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkIdentifierString fixture = new TkIdentifierString();
		fixture.setDenotation("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkIdentifierString obj = new TkIdentifierString();
		obj.setDenotation("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:33 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkIdentifierString fixture = new TkIdentifierString();
		fixture.setDenotation("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkIdentifierString obj = new TkIdentifierString();
		obj.setDenotation("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:33 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkIdentifierString fixture = new TkIdentifierString();
		fixture.setDenotation("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the String getDenotation() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:33 PM
	 */
	@Test
	public void testGetDenotation_1()
		throws Exception {
		TkIdentifierString fixture = new TkIdentifierString();
		fixture.setDenotation("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.getDenotation();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the IDENTIFIER_PART_TYPES getIdType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:33 PM
	 */
	@Test
	public void testGetIdType_1()
		throws Exception {
		TkIdentifierString fixture = new TkIdentifierString();
		fixture.setDenotation("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		IDENTIFIER_PART_TYPES result = fixture.getIdType();

		// add additional test code here
		assertNotNull(result);
		assertEquals("STRING", result.name());
		assertEquals("STRING", result.toString());
		assertEquals(1, result.ordinal());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:33 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkIdentifierString fixture = new TkIdentifierString();
		fixture.setDenotation("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(2057556879, result);
	}

	/**
	 * Run the TkIdentifierString makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:33 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkIdentifierString fixture = new TkIdentifierString();
		fixture.setDenotation("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkIdentifierString result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getDenotation());
		assertEquals(null, result.getAuthorityUuid());
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
	 * @generatedBy CodePro at 2/4/12 3:33 PM
	 */
	@Test
	public void testSetDenotation_1()
		throws Exception {
		TkIdentifierString fixture = new TkIdentifierString();
		fixture.setDenotation("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		Object denotation = "";

		fixture.setDenotation(denotation);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:33 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkIdentifierString fixture = new TkIdentifierString();
		fixture.setDenotation("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkIdentifierString:  denotation:''  authority:6c95146f-9755-4f8e-96fb-f4f3f2fa46d9  s:ec30f434-d3c2-4dec-9b29-cf003556190e a:12862c89-8272-4f08-9975-fc62b074ef09 p:c8560ed1-80f5-49aa-b1d2-78501bea387d t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeDenotation(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:33 PM
	 */
	@Test
	public void testWriteDenotation_1()
		throws Exception {
		TkIdentifierString fixture = new TkIdentifierString();
		fixture.setDenotation("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:33 PM
	 */
	@Test
	public void testWriteDenotation_2()
		throws Exception {
		TkIdentifierString fixture = new TkIdentifierString();
		fixture.setDenotation("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:33 PM
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
	 * @generatedBy CodePro at 2/4/12 3:33 PM
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
	 * @generatedBy CodePro at 2/4/12 3:33 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkIdentifierStringTest.class);
	}
}