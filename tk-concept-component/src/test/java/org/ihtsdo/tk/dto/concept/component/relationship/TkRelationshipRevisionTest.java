package org.ihtsdo.tk.dto.concept.component.relationship;

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
import org.ihtsdo.tk.api.relationship.RelationshipVersionBI;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRelationshipRevisionTest</code> contains tests for the class <code>{@link TkRelationshipRevision}</code>.
 *
 * @generatedBy CodePro at 2/4/12 4:24 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRelationshipRevisionTest {
	/**
	 * Run the TkRelationshipRevision() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testTkRelationshipRevision_1()
		throws Exception {

		TkRelationshipRevision result = new TkRelationshipRevision();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getGroup());
		assertEquals(null, result.getTypeUuid());
		assertEquals(null, result.getCharacteristicUuid());
		assertEquals(0, result.getRelGroup());
		assertEquals(null, result.getRefinabilityUuid());
		assertEquals(Long.MIN_VALUE, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRelationshipRevision(RelationshipVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
        @Ignore
	public void testTkRelationshipRevision_2()
		throws Exception {
		RelationshipVersionBI rv = null;

		TkRelationshipRevision result = new TkRelationshipRevision(rv);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationshipRevision.<init>(TkRelationshipRevision.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationshipRevision(RelationshipVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
        @Ignore
	public void testTkRelationshipRevision_3()
		throws Exception {
		RelationshipVersionBI rv = null;

		TkRelationshipRevision result = new TkRelationshipRevision(rv);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationshipRevision.<init>(TkRelationshipRevision.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationshipRevision(RelationshipVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
        @Ignore
	public void testTkRelationshipRevision_4()
		throws Exception {
		RelationshipVersionBI rv = null;

		TkRelationshipRevision result = new TkRelationshipRevision(rv);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationshipRevision.<init>(TkRelationshipRevision.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationshipRevision(RelationshipVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
        @Ignore
	public void testTkRelationshipRevision_5()
		throws Exception {
		RelationshipVersionBI rv = null;

		TkRelationshipRevision result = new TkRelationshipRevision(rv);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationshipRevision.<init>(TkRelationshipRevision.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationshipRevision(RelationshipVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
        @Ignore
	public void testTkRelationshipRevision_6()
		throws Exception {
		RelationshipVersionBI rv = null;

		TkRelationshipRevision result = new TkRelationshipRevision(rv);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationshipRevision.<init>(TkRelationshipRevision.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationshipRevision(RelationshipVersionBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
        @Ignore
	public void testTkRelationshipRevision_7()
		throws Exception {
		RelationshipVersionBI rv = null;

		TkRelationshipRevision result = new TkRelationshipRevision(rv);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationshipRevision.<init>(TkRelationshipRevision.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationshipRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRelationshipRevision_8()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRelationshipRevision result = new TkRelationshipRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationshipRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRelationshipRevision_9()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRelationshipRevision result = new TkRelationshipRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationshipRevision(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRelationshipRevision_10()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRelationshipRevision result = new TkRelationshipRevision(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationshipRevision(TkRelationshipRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testTkRelationshipRevision_11()
		throws Exception {
		TkRelationshipRevision another = new TkRelationshipRevision();
		another.setTypeUuid(UUID.randomUUID());
		another.setRefinabilityUuid(UUID.randomUUID());
		another.setCharacteristicUuid(UUID.randomUUID());
		another.setRelGroup(1);
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkRelationshipRevision result = new TkRelationshipRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getGroup());
		assertEquals(1, result.getRelGroup());
		assertEquals(-9223372036854775807L, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRelationshipRevision(TkRelationshipRevision,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testTkRelationshipRevision_12()
		throws Exception {
		TkRelationshipRevision another = new TkRelationshipRevision();
		another.setTypeUuid(UUID.randomUUID());
		another.setRefinabilityUuid(UUID.randomUUID());
		another.setCharacteristicUuid(UUID.randomUUID());
		another.setRelGroup(1);
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRelationshipRevision result = new TkRelationshipRevision(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getGroup());
		assertEquals(null, result.getTypeUuid());
		assertEquals(null, result.getCharacteristicUuid());
		assertEquals(1, result.getRelGroup());
		assertEquals(null, result.getRefinabilityUuid());
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkRelationshipRevision obj = new TkRelationshipRevision();
		obj.setCharacteristicUuid(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkRelationshipRevision obj = new TkRelationshipRevision();
		obj.setRefinabilityUuid(UUID.randomUUID());
		obj.setCharacteristicUuid(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkRelationshipRevision obj = new TkRelationshipRevision();
		obj.setRefinabilityUuid(UUID.randomUUID());
		obj.setCharacteristicUuid(UUID.randomUUID());
		obj.setRelGroup(1);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkRelationshipRevision obj = new TkRelationshipRevision();
		obj.setTypeUuid(UUID.randomUUID());
		obj.setRefinabilityUuid(UUID.randomUUID());
		obj.setCharacteristicUuid(UUID.randomUUID());
		obj.setRelGroup(1);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkRelationshipRevision obj = new TkRelationshipRevision();
		obj.setTypeUuid(UUID.randomUUID());
		obj.setRefinabilityUuid(UUID.randomUUID());
		obj.setCharacteristicUuid(UUID.randomUUID());
		obj.setRelGroup(1);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		TkRelationshipRevision obj = new TkRelationshipRevision();
		obj.setTypeUuid(UUID.randomUUID());
		obj.setRefinabilityUuid(UUID.randomUUID());
		obj.setCharacteristicUuid(UUID.randomUUID());
		obj.setRelGroup(1);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testEquals_8()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * Run the UUID getCharacteristicUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
        @Ignore
	public void testGetCharacteristicUuid_1()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		UUID result = fixture.getCharacteristicUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("3cd5282e-d48e-4195-b677-7ef463058990", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(4383453993914745237L, result.getMostSignificantBits());
		assertEquals(-5298626848479671920L, result.getLeastSignificantBits());
	}

	/**
	 * Run the int getGroup() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testGetGroup_1()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		int result = fixture.getGroup();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the UUID getRefinabilityUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
        @Ignore
	public void testGetRefinabilityUuid_1()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		UUID result = fixture.getRefinabilityUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("303b5e20-cba0-4984-aa3b-6dfa3b4cb66e", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(3475475032394713476L, result.getMostSignificantBits());
		assertEquals(-6180225142131739026L, result.getLeastSignificantBits());
	}

	/**
	 * Run the int getRelGroup() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testGetRelGroup_1()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		int result = fixture.getRelGroup();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the UUID getTypeUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
        @Ignore
	public void testGetTypeUuid_1()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		UUID result = fixture.getTypeUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("97253f2c-1319-4140-bdbb-3a287459476b", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-7555563341312605888L, result.getMostSignificantBits());
		assertEquals(-4775159034471168149L, result.getLeastSignificantBits());
	}

	/**
	 * Run the TkRelationshipRevision makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRelationshipRevision result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getGroup());
		assertEquals(null, result.getTypeUuid());
		assertEquals(null, result.getCharacteristicUuid());
		assertEquals(1, result.getRelGroup());
		assertEquals(null, result.getRefinabilityUuid());
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_9()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_10()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * Run the void setCharacteristicUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testSetCharacteristicUuid_1()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		UUID characteristicUuid = UUID.randomUUID();

		fixture.setCharacteristicUuid(characteristicUuid);

		// add additional test code here
	}

	/**
	 * Run the void setRefinabilityUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testSetRefinabilityUuid_1()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		UUID refinabilityUuid = UUID.randomUUID();

		fixture.setRefinabilityUuid(refinabilityUuid);

		// add additional test code here
	}

	/**
	 * Run the void setRelGroup(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testSetRelGroup_1()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		int relGroup = 1;

		fixture.setRelGroup(relGroup);

		// add additional test code here
	}

	/**
	 * Run the void setTypeUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testSetTypeUuid_1()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.pathUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRelationshipRevision:  type:baa2f2eb-a1c8-4ca9-99c3-86b06e2e2759 grp:1 char:2da50ff4-f57e-42c8-96ec-b02b293a3ecc ref:3b2926f5-f067-45a4-b940-96a0792beb0f  s:4f59a838-2712-4499-8c69-bb3aec77654d a:01e5ab79-02c2-4102-85e4-cd41bfacf4bf p:84f243d0-a072-46d9-8224-c2f7bb476df7 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testWriteExternal_8()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	@Test
	public void testWriteExternal_9()
		throws Exception {
		TkRelationshipRevision fixture = new TkRelationshipRevision();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setRelGroup(1);
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
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
	 * @generatedBy CodePro at 2/4/12 4:24 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRelationshipRevisionTest.class);
	}
}