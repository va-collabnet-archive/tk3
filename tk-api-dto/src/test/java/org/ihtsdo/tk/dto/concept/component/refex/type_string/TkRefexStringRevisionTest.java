package org.ihtsdo.tk.dto.concept.component.refex.type_string;

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
import org.ihtsdo.tk.api.refex.type_string.RefexStringVersionBI;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexStringRevisionTest</code> contains tests for the class <code>{@link TkRefexStringRevision}</code>.
 *
 * @generatedBy CodePro at 2/4/12 4:16 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexStringRevisionTest {
	/**
	 * Run the TkRefexStringRevision() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test
	public void testTkRefexStringRevision_1()
		throws Exception {

		TkRefexStringRevision result = new TkRefexStringRevision();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getString1());
		assertEquals(Long.MIN_VALUE, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexStringRevision(RefexStringVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test
        @Ignore
	public void testTkRefexStringRevision_2()
		throws Exception {
		RefexStringVersionBI another = null;

		TkRefexStringRevision result = new TkRefexStringRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_string.TkRefexStringRevision.<init>(TkRefexStringRevision.java:32)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexStringRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexStringRevision_3()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexStringRevision result = new TkRefexStringRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexStringRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexStringRevision_4()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexStringRevision result = new TkRefexStringRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexStringRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexStringRevision_5()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexStringRevision result = new TkRefexStringRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexStringRevision(TkRefexStringRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test
	public void testTkRefexStringRevision_6()
		throws Exception {
		TkRefexStringRevision another = new TkRefexStringRevision();
		another.setString1("");
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexStringRevision result = new TkRefexStringRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getString1());
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
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexStringRevision fixture = new TkRefexStringRevision();
		fixture.setString1("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexStringRevision fixture = new TkRefexStringRevision();
		fixture.setString1("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		TkRefexStringRevision obj = new TkRefexStringRevision();
		obj.setString1("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexStringRevision fixture = new TkRefexStringRevision();
		fixture.setString1("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		TkRefexStringRevision obj = new TkRefexStringRevision();
		obj.setString1("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexStringRevision fixture = new TkRefexStringRevision();
		fixture.setString1("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		TkRefexStringRevision obj = new TkRefexStringRevision();
		obj.setString1("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexStringRevision fixture = new TkRefexStringRevision();
		fixture.setString1("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test
	public void testGetString1_1()
		throws Exception {
		TkRefexStringRevision fixture = new TkRefexStringRevision();
		fixture.setString1("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();

		String result = fixture.getString1();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the TkRefexStringRevision makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexStringRevision fixture = new TkRefexStringRevision();
		fixture.setString1("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexStringRevision result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getString1());
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
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexStringRevision fixture = new TkRefexStringRevision();
		fixture.setString1("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexStringRevision fixture = new TkRefexStringRevision();
		fixture.setString1("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexStringRevision fixture = new TkRefexStringRevision();
		fixture.setString1("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexStringRevision fixture = new TkRefexStringRevision();
		fixture.setString1("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test
	public void testSetString1_1()
		throws Exception {
		TkRefexStringRevision fixture = new TkRefexStringRevision();
		fixture.setString1("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		String string1 = "";

		fixture.setString1(string1);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexStringRevision fixture = new TkRefexStringRevision();
		fixture.setString1("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexStringRevision:  str:''  s:f4e5d580-75b7-422d-a986-3bef964573b7 a:b506e973-7b44-410a-ad37-c6be6b7e3f74 p:e5d92213-a050-429f-952f-bf4a84b08bb8 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexStringRevision fixture = new TkRefexStringRevision();
		fixture.setString1("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexStringRevision fixture = new TkRefexStringRevision();
		fixture.setString1("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexStringRevision fixture = new TkRefexStringRevision();
		fixture.setString1("");
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:16 PM
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
	 * @generatedBy CodePro at 2/4/12 4:16 PM
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
	 * @generatedBy CodePro at 2/4/12 4:16 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexStringRevisionTest.class);
	}
}