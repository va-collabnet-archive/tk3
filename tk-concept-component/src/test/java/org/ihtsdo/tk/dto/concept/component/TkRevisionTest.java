package org.ihtsdo.tk.dto.concept.component;

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
import org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRevisionTest</code> contains tests for the class <code>{@link TkRevision}</code>.
 *
 * @generatedBy CodePro at 2/4/12 4:57 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRevisionTest {
	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testEquals_2()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		TkConceptAttributes obj = new TkConceptAttributes();
		obj.statusUuid = UUID.randomUUID();

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.equals(TkComponent.java:181)
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.equals(TkConceptAttributes.java:102)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testEquals_3()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		TkConceptAttributes obj = new TkConceptAttributes();
		obj.authorUuid = UUID.randomUUID();
		obj.statusUuid = UUID.randomUUID();

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.equals(TkComponent.java:181)
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.equals(TkConceptAttributes.java:102)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testEquals_4()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		TkConceptAttributes obj = new TkConceptAttributes();
		obj.authorUuid = UUID.randomUUID();
		obj.statusUuid = UUID.randomUUID();
		obj.pathUuid = UUID.randomUUID();
		obj.time = 1L;

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.equals(TkComponent.java:181)
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.equals(TkConceptAttributes.java:102)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the UUID getAuthorUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testGetAuthorUuid_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;

		UUID result = fixture.getAuthorUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("32b8581f-e0ea-491f-9dee-9938a6de4921", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(3654767991551838495L, result.getMostSignificantBits());
		assertEquals(-7066542296700925663L, result.getLeastSignificantBits());
	}

	/**
	 * Run the UUID getPathUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testGetPathUuid_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;

		UUID result = fixture.getPathUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ec4c431f-9e08-4c1d-b3f0-9b03bd5a20e8", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-1419685979454157795L, result.getMostSignificantBits());
		assertEquals(-5480710306145885976L, result.getLeastSignificantBits());
	}

	/**
	 * Run the UUID getStatusUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testGetStatusUuid_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;

		UUID result = fixture.getStatusUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("29e452fe-2a5e-4a3a-8458-bc6a9b41e267", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(3018628901831068218L, result.getMostSignificantBits());
		assertEquals(-8910164696695184793L, result.getLeastSignificantBits());
	}

	/**
	 * Run the long getTime() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
	public void testGetTime_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;

		long result = fixture.getTime();

		// add additional test code here
		assertEquals(1L, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;

		int result = fixture.hashCode();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.hashCode(TkConceptAttributes.java:115)
		assertEquals(0, result);
	}

	/**
	 * Run the CharSequence informAboutUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testInformAboutUuid_1()
		throws Exception {
		UUID uuid = UUID.randomUUID();

		CharSequence result = TkRevision.informAboutUuid(uuid);

		// add additional test code here
		assertNotNull(result);
		assertEquals("6303ad03-b792-4926-b49d-5e1c408bfc20", result.toString());
		assertEquals(36, result.length());
	}

	/**
	 * Run the CharSequence informAboutUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testInformAboutUuid_2()
		throws Exception {
		UUID uuid = UUID.randomUUID();

		CharSequence result = TkRevision.informAboutUuid(uuid);

		// add additional test code here
		assertNotNull(result);
		assertEquals("0567b8c8-5a14-4bf6-8caf-7a5cf3d9d6c5", result.toString());
		assertEquals(36, result.length());
	}

	/**
	 * Run the CharSequence informAboutUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testInformAboutUuid_3()
		throws Exception {
		UUID uuid = UUID.randomUUID();

		CharSequence result = TkRevision.informAboutUuid(uuid);

		// add additional test code here
		assertNotNull(result);
		assertEquals("bcf26cb3-1f31-42ec-b900-387a2eef18f1", result.toString());
		assertEquals(36, result.length());
	}

	/**
	 * Run the CharSequence informAboutUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testInformAboutUuid_4()
		throws Exception {
		UUID uuid = UUID.randomUUID();

		CharSequence result = TkRevision.informAboutUuid(uuid);

		// add additional test code here
		assertNotNull(result);
		assertEquals("4d556937-b52d-4a0a-9506-8105eee069c8", result.toString());
		assertEquals(36, result.length());
	}

	/**
	 * Run the CharSequence informAboutUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testInformAboutUuid_5()
		throws Exception {
		UUID uuid = UUID.randomUUID();

		CharSequence result = TkRevision.informAboutUuid(uuid);

		// add additional test code here
		assertNotNull(result);
		assertEquals("f45e99c9-aaf2-49e8-a0c0-a24639a0e3c4", result.toString());
		assertEquals(36, result.length());
	}

	/**
	 * Run the CharSequence informAboutUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testInformAboutUuid_6()
		throws Exception {
		UUID uuid = UUID.randomUUID();

		CharSequence result = TkRevision.informAboutUuid(uuid);

		// add additional test code here
		assertNotNull(result);
		assertEquals("203c4184-55f2-49d6-a05e-b27d1076de2d", result.toString());
		assertEquals(36, result.length());
	}

	/**
	 * Run the CharSequence informAboutUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testInformAboutUuid_7()
		throws Exception {
		UUID uuid = UUID.randomUUID();

		CharSequence result = TkRevision.informAboutUuid(uuid);

		// add additional test code here
		assertNotNull(result);
		assertEquals("f4040812-b5e2-4911-8a9b-4d8b9bd4d2c8", result.toString());
		assertEquals(36, result.length());
	}

	/**
	 * Run the CharSequence informAboutUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testInformAboutUuid_8()
		throws Exception {
		UUID uuid = UUID.randomUUID();

		CharSequence result = TkRevision.informAboutUuid(uuid);

		// add additional test code here
		assertNotNull(result);
		assertEquals("89e155de-3cf0-45e3-9d6f-753eb9a180cd", result.toString());
		assertEquals(36, result.length());
	}

	/**
	 * Run the void readExternal(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 3;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void readExternal(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 3;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void readExternal(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 3;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void readExternal(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_9()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 3;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void readExternal(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_10()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
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
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_11()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 3;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setAuthorUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
	public void testSetAuthorUuid_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		UUID authorUuid = UUID.randomUUID();

		fixture.setAuthorUuid(authorUuid);

		// add additional test code here
	}

	/**
	 * Run the void setPathUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
	public void testSetPathUuid_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		UUID pathUuid = UUID.randomUUID();

		fixture.setPathUuid(pathUuid);

		// add additional test code here
	}

	/**
	 * Run the void setStatusUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
	public void testSetStatusUuid_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		UUID statusUuid = UUID.randomUUID();

		fixture.setStatusUuid(statusUuid);

		// add additional test code here
	}

	/**
	 * Run the void setTime(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
	public void testSetTime_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		long time = 1L;

		fixture.setTime(time);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkConceptAttributes:  defined: false  primordial:null xtraIds:null s:a264c626-d1f1-4e0c-96ce-d95c6c555f40 a:6de1ce7a-14bf-4605-ad48-139a98b9b0af p:74a3ae6e-376d-45eb-8c69-47090cdc6929 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testWriteExternal_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = Long.MAX_VALUE;
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.writeExternal(TkComponent.java:439)
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.writeExternal(TkConceptAttributes.java:159)
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testWriteExternal_2()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = Long.MAX_VALUE;
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.writeExternal(TkComponent.java:439)
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.writeExternal(TkConceptAttributes.java:159)
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testWriteExternal_3()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = Long.MAX_VALUE;
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.writeExternal(TkComponent.java:439)
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.writeExternal(TkConceptAttributes.java:159)
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testWriteExternal_4()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = Long.MAX_VALUE;
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.writeExternal(TkComponent.java:439)
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.writeExternal(TkConceptAttributes.java:159)
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testWriteExternal_5()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = null;
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.writeExternal(TkComponent.java:439)
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.writeExternal(TkConceptAttributes.java:159)
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testWriteExternal_6()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = Long.MAX_VALUE;
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.writeExternal(TkComponent.java:439)
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.writeExternal(TkConceptAttributes.java:159)
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testWriteExternal_7()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = null;
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = Long.MAX_VALUE;
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.writeExternal(TkComponent.java:439)
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.writeExternal(TkConceptAttributes.java:159)
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testWriteExternal_8()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = null;
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = Long.MAX_VALUE;
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.writeExternal(TkComponent.java:439)
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.writeExternal(TkConceptAttributes.java:159)
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testWriteExternal_9()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = null;
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.writeExternal(TkComponent.java:439)
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.writeExternal(TkConceptAttributes.java:159)
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testWriteExternal_10()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = Long.MAX_VALUE;
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.writeExternal(TkComponent.java:439)
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.writeExternal(TkConceptAttributes.java:159)
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	@Test
        @Ignore
	public void testWriteExternal_11()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.writeExternal(TkComponent.java:439)
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.writeExternal(TkConceptAttributes.java:159)
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2/4/12 4:57 PM
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
	 * @generatedBy CodePro at 2/4/12 4:57 PM
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
	 * @generatedBy CodePro at 2/4/12 4:57 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRevisionTest.class);
	}
}