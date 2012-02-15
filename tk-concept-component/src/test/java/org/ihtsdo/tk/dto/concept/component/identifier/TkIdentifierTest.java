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
import java.util.UUID;
import org.ihtsdo.tk.api.id.IdBI;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkIdentifierTest</code> contains tests for the class <code>{@link TkIdentifier}</code>.
 *
 * @generatedBy CodePro at 2/4/12 5:11 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkIdentifierTest {
	/**
	 * Run the TkIdentifier convertId(IdBI) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
        @Ignore
	public void testConvertId_1()
		throws Exception {
		IdBI id = null;

		TkIdentifier result = TkIdentifier.convertId(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier.convertId(TkIdentifier.java:58)
		assertNotNull(result);
	}

	/**
	 * Run the TkIdentifier convertId(IdBI) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
        @Ignore
	public void testConvertId_2()
		throws Exception {
		IdBI id = null;

		TkIdentifier result = TkIdentifier.convertId(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier.convertId(TkIdentifier.java:58)
		assertNotNull(result);
	}

	/**
	 * Run the TkIdentifier convertId(IdBI) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
        @Ignore
	public void testConvertId_3()
		throws Exception {
		IdBI id = null;

		TkIdentifier result = TkIdentifier.convertId(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier.convertId(TkIdentifier.java:58)
		assertNotNull(result);
	}

	/**
	 * Run the TkIdentifier convertId(IdBI) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
        @Ignore
	public void testConvertId_4()
		throws Exception {
		IdBI id = null;

		TkIdentifier result = TkIdentifier.convertId(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier.convertId(TkIdentifier.java:58)
		assertNotNull(result);
	}

	/**
	 * Run the TkIdentifier convertId(IdBI) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
        @Ignore
	public void testConvertId_5()
		throws Exception {
		IdBI id = null;

		TkIdentifier result = TkIdentifier.convertId(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier.convertId(TkIdentifier.java:58)
		assertNotNull(result);
	}

	/**
	 * Run the TkIdentifier convertId(IdBI) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
        @Ignore
	public void testConvertId_6()
		throws Exception {
		IdBI id = null;

		TkIdentifier result = TkIdentifier.convertId(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier.convertId(TkIdentifier.java:58)
		assertNotNull(result);
	}

	/**
	 * Run the TkIdentifier convertId(IdBI) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
        @Ignore
	public void testConvertId_7()
		throws Exception {
		IdBI id = null;

		TkIdentifier result = TkIdentifier.convertId(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier.convertId(TkIdentifier.java:58)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		TkIdentifierLong obj = new TkIdentifierLong();
		obj.authorityUuid = UUID.randomUUID();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		TkIdentifierLong obj = new TkIdentifierLong();
		obj.authorityUuid = UUID.randomUUID();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		TkIdentifierLong obj = new TkIdentifierLong();
		obj.authorityUuid = UUID.randomUUID();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the UUID getAuthorityUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
        @Ignore
	public void testGetAuthorityUuid_1()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();

		UUID result = fixture.getAuthorityUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("c843358f-8df2-4590-a1e0-7b03c2bc991c", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-4016307552006290032L, result.getMostSignificantBits());
		assertEquals(-6782285782737708772L, result.getLeastSignificantBits());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(-724178590, result);
	}

	/**
	 * Run the void readExternal(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setAuthorityUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
	public void testSetAuthorityUuid_1()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		UUID authorityUuid = UUID.randomUUID();

		fixture.setAuthorityUuid(authorityUuid);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkIdentifierLong:  denotation:0  authority:620e3da5-911b-415f-b774-11fe425d5477  s:8e5cee76-3198-4a5b-8420-f9587ac9f5b7 a:d2f948fa-1383-4c61-96fb-8f2db82fabba p:ab8dd77c-5de6-477e-ae13-285d6ede9db0 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkIdentifierLong fixture = new TkIdentifierLong();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		fixture.authorityUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:11 PM
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
	 * @generatedBy CodePro at 2/4/12 5:11 PM
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
	 * @generatedBy CodePro at 2/4/12 5:11 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkIdentifierTest.class);
	}
}