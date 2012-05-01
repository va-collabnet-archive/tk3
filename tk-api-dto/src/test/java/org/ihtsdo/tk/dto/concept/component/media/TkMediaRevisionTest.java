package org.ihtsdo.tk.dto.concept.component.media;

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
import org.ihtsdo.tk.api.media.MediaVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkMediaRevisionTest</code> contains tests for the class <code>{@link TkMediaRevision}</code>.
 *
 * @generatedBy CodePro at 2/4/12 4:22 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkMediaRevisionTest {
	/**
	 * Run the TkMediaRevision() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
	public void testTkMediaRevision_1()
		throws Exception {

		TkMediaRevision result = new TkMediaRevision();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getTextDescription());
		assertEquals(null, result.getTypeUuid());
		assertEquals(Long.MIN_VALUE, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkMediaRevision(MediaVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
        @Ignore
	public void testTkMediaRevision_2()
		throws Exception {
		MediaVersionBI another = null;

		TkMediaRevision result = new TkMediaRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.media.TkMediaRevision.<init>(TkMediaRevision.java:33)
		assertNotNull(result);
	}

	/**
	 * Run the TkMediaRevision(MediaVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
        @Ignore
	public void testTkMediaRevision_3()
		throws Exception {
		MediaVersionBI another = null;

		TkMediaRevision result = new TkMediaRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.media.TkMediaRevision.<init>(TkMediaRevision.java:33)
		assertNotNull(result);
	}

	/**
	 * Run the TkMediaRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkMediaRevision_4()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkMediaRevision result = new TkMediaRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkMediaRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkMediaRevision_5()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkMediaRevision result = new TkMediaRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkMediaRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkMediaRevision_6()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkMediaRevision result = new TkMediaRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkMediaRevision(TkMediaRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
	public void testTkMediaRevision_7()
		throws Exception {
		TkMediaRevision another = new TkMediaRevision();
		another.setTypeUuid(UUID.randomUUID());
		another.setTextDescription("");
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkMediaRevision result = new TkMediaRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getTextDescription());
		assertEquals(-9223372036854775807L, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkMediaRevision(TkMediaRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
	public void testTkMediaRevision_8()
		throws Exception {
		TkMediaRevision another = new TkMediaRevision();
		another.setTypeUuid(UUID.randomUUID());
		another.setTextDescription("");
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkMediaRevision result = new TkMediaRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getTextDescription());
		assertEquals(null, result.getTypeUuid());
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
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkMediaRevision obj = new TkMediaRevision();
		obj.setTextDescription("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkMediaRevision obj = new TkMediaRevision();
		obj.setTypeUuid(UUID.randomUUID());
		obj.setTextDescription("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkMediaRevision obj = new TkMediaRevision();
		obj.setTypeUuid(UUID.randomUUID());
		obj.setTextDescription("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkMediaRevision obj = new TkMediaRevision();
		obj.setTypeUuid(UUID.randomUUID());
		obj.setTextDescription("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the String getTextDescription() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
	public void testGetTextDescription_1()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		String result = fixture.getTextDescription();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the UUID getTypeUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
        @Ignore
	public void testGetTypeUuid_1()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		UUID result = fixture.getTypeUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("6d52b99f-e9fd-4c37-ae4b-497f59987975", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(7877562794701048887L, result.getMostSignificantBits());
		assertEquals(-5887531276543952523L, result.getLeastSignificantBits());
	}

	/**
	 * Run the TkRevision makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * Run the void readExternal(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setTextDescription(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
	public void testSetTextDescription_1()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		String textDescription = "";

		fixture.setTextDescription(textDescription);

		// add additional test code here
	}

	/**
	 * Run the void setTypeUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
	public void testSetTypeUuid_1()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		UUID typeUuid = UUID.randomUUID();

		fixture.setTypeUuid(typeUuid);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkMediaRevision:  desc:'' type:08d06d1b-c353-48f6-8e93-f430aca6b52a  s:6cfb1576-88cc-4413-9315-30181ace212d a:266ce53c-019e-43c4-b63f-0934fd4a752a p:e21e7644-033d-4928-8575-ef31ad534fd0 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkMediaRevision fixture = new TkMediaRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setTextDescription("");
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:22 PM
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
	 * @generatedBy CodePro at 2/4/12 4:22 PM
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
	 * @generatedBy CodePro at 2/4/12 4:22 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkMediaRevisionTest.class);
	}
}