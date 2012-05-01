package org.ihtsdo.tk.dto.concept.component.refex.type_int;

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
import org.ihtsdo.tk.api.refex.type_int.RefexIntVersionBI;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexIntRevisionTest</code> contains tests for the class <code>{@link TkRefexIntRevision}</code>.
 *
 * @generatedBy CodePro at 2/4/12 3:36 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexIntRevisionTest {
	/**
	 * Run the TkRefexIntRevision() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test
	public void testTkRefexIntRevision_1()
		throws Exception {

		TkRefexIntRevision result = new TkRefexIntRevision();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getIntValue());
		assertEquals(Long.MIN_VALUE, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexIntRevision(RefexIntVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test
        @Ignore
	public void testTkRefexIntRevision_2()
		throws Exception {
		RefexIntVersionBI another = null;

		TkRefexIntRevision result = new TkRefexIntRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_int.TkRefexIntRevision.<init>(TkRefexIntRevision.java:31)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexIntRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexIntRevision_3()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexIntRevision result = new TkRefexIntRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexIntRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexIntRevision_4()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexIntRevision result = new TkRefexIntRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexIntRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexIntRevision_5()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexIntRevision result = new TkRefexIntRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexIntRevision(TkRefexIntRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test
	public void testTkRefexIntRevision_6()
		throws Exception {
		TkRefexIntRevision another = new TkRefexIntRevision();
		another.setIntValue(1);
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexIntRevision result = new TkRefexIntRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getIntValue());
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
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexIntRevision fixture = new TkRefexIntRevision();
		fixture.setIntValue(1);
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexIntRevision fixture = new TkRefexIntRevision();
		fixture.setIntValue(1);
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		TkRefexIntRevision obj = new TkRefexIntRevision();
		obj.setIntValue(1);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexIntRevision fixture = new TkRefexIntRevision();
		fixture.setIntValue(1);
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		TkRefexIntRevision obj = new TkRefexIntRevision();
		obj.setIntValue(1);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexIntRevision fixture = new TkRefexIntRevision();
		fixture.setIntValue(1);
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		TkRefexIntRevision obj = new TkRefexIntRevision();
		obj.setIntValue(1);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexIntRevision fixture = new TkRefexIntRevision();
		fixture.setIntValue(1);
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the int getIntValue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test
	public void testGetIntValue_1()
		throws Exception {
		TkRefexIntRevision fixture = new TkRefexIntRevision();
		fixture.setIntValue(1);
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();

		int result = fixture.getIntValue();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the TkRefexIntRevision makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexIntRevision fixture = new TkRefexIntRevision();
		fixture.setIntValue(1);
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexIntRevision result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getIntValue());
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
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexIntRevision fixture = new TkRefexIntRevision();
		fixture.setIntValue(1);
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexIntRevision fixture = new TkRefexIntRevision();
		fixture.setIntValue(1);
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexIntRevision fixture = new TkRefexIntRevision();
		fixture.setIntValue(1);
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexIntRevision fixture = new TkRefexIntRevision();
		fixture.setIntValue(1);
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setIntValue(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test
	public void testSetIntValue_1()
		throws Exception {
		TkRefexIntRevision fixture = new TkRefexIntRevision();
		fixture.setIntValue(1);
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();
		int intValue = 1;

		fixture.setIntValue(intValue);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexIntRevision fixture = new TkRefexIntRevision();
		fixture.setIntValue(1);
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexIntRevision:  int: 1  s:4797a6f7-f9d4-4d69-ac35-9ed154689446 a:030cdfb1-6777-495b-98e4-6e89a4c8d82e p:998c195c-7eb4-4e15-98d5-5a0bac72b629 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexIntRevision fixture = new TkRefexIntRevision();
		fixture.setIntValue(1);
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexIntRevision fixture = new TkRefexIntRevision();
		fixture.setIntValue(1);
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexIntRevision fixture = new TkRefexIntRevision();
		fixture.setIntValue(1);
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:36 PM
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
	 * @generatedBy CodePro at 2/4/12 3:36 PM
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
	 * @generatedBy CodePro at 2/4/12 3:36 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexIntRevisionTest.class);
	}
}