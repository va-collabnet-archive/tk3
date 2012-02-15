package org.ihtsdo.tk.dto.concept.component.description;

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
import org.ihtsdo.tk.api.description.DescriptionVersionBI;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkDescriptionRevisionTest</code> contains tests for the class <code>{@link TkDescriptionRevision}</code>.
 *
 * @generatedBy CodePro at 2/4/12 5:17 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkDescriptionRevisionTest {
	/**
	 * Run the TkDescriptionRevision() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testTkDescriptionRevision_1()
		throws Exception {

		TkDescriptionRevision result = new TkDescriptionRevision();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getText());
		assertEquals(false, result.isInitialCaseSignificant());
		assertEquals(null, result.getLang());
		assertEquals(null, result.getTypeUuid());
		assertEquals(Long.MIN_VALUE, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkDescriptionRevision(DescriptionVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
        @Ignore
	public void testTkDescriptionRevision_2()
		throws Exception {
		DescriptionVersionBI another = null;

		TkDescriptionRevision result = new TkDescriptionRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.description.TkDescriptionRevision.<init>(TkDescriptionRevision.java:36)
		assertNotNull(result);
	}

	/**
	 * Run the TkDescriptionRevision(DescriptionVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
        @Ignore
	public void testTkDescriptionRevision_3()
		throws Exception {
		DescriptionVersionBI another = null;

		TkDescriptionRevision result = new TkDescriptionRevision(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:44)
		//       at org.ihtsdo.tk.dto.concept.component.description.TkDescriptionRevision.<init>(TkDescriptionRevision.java:36)
		assertNotNull(result);
	}

	/**
	 * Run the TkDescriptionRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkDescriptionRevision_4()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkDescriptionRevision result = new TkDescriptionRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkDescriptionRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkDescriptionRevision_5()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkDescriptionRevision result = new TkDescriptionRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkDescriptionRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkDescriptionRevision_6()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkDescriptionRevision result = new TkDescriptionRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkDescriptionRevision(TkDescriptionRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testTkDescriptionRevision_7()
		throws Exception {
		TkDescriptionRevision another = new TkDescriptionRevision();
		another.setInitialCaseSignificant(true);
		another.setText("");
		another.setLang("");
		another.setTypeUuid(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkDescriptionRevision result = new TkDescriptionRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getText());
		assertEquals(true, result.isInitialCaseSignificant());
		assertEquals("", result.getLang());
		assertEquals(-9223372036854775807L, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkDescriptionRevision(TkDescriptionRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testTkDescriptionRevision_8()
		throws Exception {
		TkDescriptionRevision another = new TkDescriptionRevision();
		another.setInitialCaseSignificant(true);
		another.setText("");
		another.setLang("");
		another.setTypeUuid(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkDescriptionRevision result = new TkDescriptionRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getText());
		assertEquals(true, result.isInitialCaseSignificant());
		assertEquals("", result.getLang());
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkDescriptionRevision obj = new TkDescriptionRevision();
		obj.setInitialCaseSignificant(true);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkDescriptionRevision obj = new TkDescriptionRevision();
		obj.setInitialCaseSignificant(true);
		obj.setLang("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkDescriptionRevision obj = new TkDescriptionRevision();
		obj.setInitialCaseSignificant(true);
		obj.setText("");
		obj.setLang("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkDescriptionRevision obj = new TkDescriptionRevision();
		obj.setInitialCaseSignificant(true);
		obj.setText("");
		obj.setLang("");
		obj.setTypeUuid(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkDescriptionRevision obj = new TkDescriptionRevision();
		obj.setInitialCaseSignificant(true);
		obj.setText("");
		obj.setLang("");
		obj.setTypeUuid(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkDescriptionRevision obj = new TkDescriptionRevision();
		obj.setInitialCaseSignificant(true);
		obj.setText("");
		obj.setLang("");
		obj.setTypeUuid(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testEquals_8()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the String getLang() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testGetLang_1()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		String result = fixture.getLang();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getText() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testGetText_1()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		String result = fixture.getText();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the UUID getTypeUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
        @Ignore
	public void testGetTypeUuid_1()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		UUID result = fixture.getTypeUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("4ba26459-13c2-4f81-9088-48f726e6a1b5", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(5450028832818089857L, result.getMostSignificantBits());
		assertEquals(-8032089709068508747L, result.getLeastSignificantBits());
	}

	/**
	 * Run the boolean isInitialCaseSignificant() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testIsInitialCaseSignificant_1()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		boolean result = fixture.isInitialCaseSignificant();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isInitialCaseSignificant() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testIsInitialCaseSignificant_2()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(false);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		boolean result = fixture.isInitialCaseSignificant();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the TkDescriptionRevision makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkDescriptionRevision result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getText());
		assertEquals(true, result.isInitialCaseSignificant());
		assertEquals("", result.getLang());
		assertEquals(null, result.getTypeUuid());
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void readExternal(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void readExternal(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void readExternal(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_9()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void readExternal(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_10()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void readExternal(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_11()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_12()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_13()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void readExternal(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_14()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void readExternal(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_15()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setInitialCaseSignificant(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testSetInitialCaseSignificant_1()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		boolean initialCaseSignificant = true;

		fixture.setInitialCaseSignificant(initialCaseSignificant);

		// add additional test code here
	}

	/**
	 * Run the void setLang(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testSetLang_1()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		String lang = "";

		fixture.setLang(lang);

		// add additional test code here
	}

	/**
	 * Run the void setText(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testSetText_1()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		String text = "";

		fixture.setText(text);

		// add additional test code here
	}

	/**
	 * Run the void setTypeUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testSetTypeUuid_1()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkDescriptionRevision:  ics:true lang:'' text:'' type:1877038f-ae17-4ed9-8b54-52cc9c349d57  s:b3a8c527-78a4-4fe7-8667-6ea9982a31e4 a:e209b032-c1df-4874-b44f-cc2e5634cadd p:3b765cd6-f655-48f1-8005-2b03951568db t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testWriteExternal_8()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testWriteExternal_9()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testWriteExternal_10()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testWriteExternal_11()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	@Test
	public void testWriteExternal_12()
		throws Exception {
		TkDescriptionRevision fixture = new TkDescriptionRevision();
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
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
	 * @generatedBy CodePro at 2/4/12 5:17 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkDescriptionRevisionTest.class);
	}
}