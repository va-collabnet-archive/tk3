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
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkComponentTest</code> contains tests for the class <code>{@link TkComponent}</code>.
 *
 * @generatedBy CodePro at 2/4/12 4:38 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkComponentTest {
	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		TkConceptAttributes obj = new TkConceptAttributes();
		obj.primordialUuid = UUID.randomUUID();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		TkConceptAttributes obj = new TkConceptAttributes();
		obj.primordialUuid = UUID.randomUUID();
		obj.additionalIds = new LinkedList();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = null;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		TkConceptAttributes obj = new TkConceptAttributes();
		obj.primordialUuid = UUID.randomUUID();
		obj.revisions = new LinkedList();
		obj.additionalIds = null;

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		TkConceptAttributes obj = new TkConceptAttributes();
		obj.primordialUuid = UUID.randomUUID();
		obj.revisions = new LinkedList();
		obj.additionalIds = new LinkedList();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = null;
		fixture.additionalIds = null;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		TkConceptAttributes obj = new TkConceptAttributes();
		obj.primordialUuid = UUID.randomUUID();
		obj.revisions = null;
		obj.additionalIds = null;

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the List<TkIdentifier> getAdditionalIdComponents() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testGetAdditionalIdComponents_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		List<TkIdentifier> result = fixture.getAdditionalIdComponents();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the List<TkIdentifier> getEIdentifiers() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testGetEIdentifiers_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = null;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		List<TkIdentifier> result = fixture.getEIdentifiers();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	/**
	 * Run the List<TkIdentifier> getEIdentifiers() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testGetEIdentifiers_2()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		List<TkIdentifier> result = fixture.getEIdentifiers();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	/**
	 * Run the int getIdComponentCount() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testGetIdComponentCount_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = null;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		int result = fixture.getIdComponentCount();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the int getIdComponentCount() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testGetIdComponentCount_2()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		int result = fixture.getIdComponentCount();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the UUID getPrimordialComponentUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
        @Ignore
	public void testGetPrimordialComponentUuid_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		UUID result = fixture.getPrimordialComponentUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("bd98faeb-4f5e-4d68-ac4c-5e6135a4858f", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-4784798715525313176L, result.getMostSignificantBits());
		assertEquals(-6031342029351123569L, result.getLeastSignificantBits());
	}

	/**
	 * Run the List<UUID> getUuids() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testGetUuids_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		List<UUID> result = fixture.getUuids();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	/**
	 * Run the List<UUID> getUuids() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testGetUuids_2()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		List<UUID> result = fixture.getUuids();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	/**
	 * Run the List<UUID> getUuids() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testGetUuids_3()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		List<UUID> result = fixture.getUuids();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	/**
	 * Run the List<UUID> getUuids() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testGetUuids_4()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = null;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		List<UUID> result = fixture.getUuids();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	/**
	 * Run the int getVersionCount() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testGetVersionCount_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		int result = fixture.getVersionCount();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the int getVersionCount() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testGetVersionCount_2()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		int result = fixture.getVersionCount();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(752616469, result);
	}

	/**
	 * Run the void readExternal(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_9()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_10()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_11()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_12()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_13()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_14()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_15()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_16()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setAdditionalIdComponents(List<TkIdentifier>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testSetAdditionalIdComponents_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		List<TkIdentifier> additionalIdComponents = new LinkedList();

		fixture.setAdditionalIdComponents(additionalIdComponents);

		// add additional test code here
	}


	/**
	 * Run the void setPrimordialComponentUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testSetPrimordialComponentUuid_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		UUID primordialComponentUuid = UUID.randomUUID();

		fixture.setPrimordialComponentUuid(primordialComponentUuid);

		// add additional test code here
	}


	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkConceptAttributes:  defined: false  primordial:9e437646-1f88-48df-b826-eb39b9edfea9 xtraIds:[] s:3c5e9ab4-edf9-456f-bdd8-7d29cec64d5e a:619dfbd8-0bcb-4726-b8d6-01fbd18be7f1 p:fce36bdb-246e-4938-92df-e083acd13a7f t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
        @Ignore
	public void testToString_2()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkConceptAttributes:  defined: false  primordial:cffa54a2-d0b4-4a9f-8292-5732cd3f74dd xtraIds:[] s:59c899d9-4c1b-4d74-85d6-e4c03b50ca29 a:cdc3907f-43d2-45d3-bfb1-f1c61e4531e5 p:2f7937df-3616-4449-afee-c5d318f26551 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
        @Ignore
	public void testToString_3()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = null;
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkConceptAttributes:  defined: false  primordial:c2d292ba-bc87-47a4-b630-4a6d47628d65 xtraIds:[] s:fadffdaf-60b2-4791-8f84-55e3b9dc5cf4 a:996bbf5c-af88-450f-8332-2cc1be505779 p:bef80cbf-2c38-48d6-9293-348410390f77 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
        @Ignore
	public void testToString_4()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = null;
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkConceptAttributes:  defined: false  primordial:a74be3bc-f020-450c-b3bd-159a3227e8c5 xtraIds:[] s:d707ece9-9797-40ff-b5d2-1ebcfd58c716 a:b7457d4d-8b33-4092-a5fa-cb08d7dfd8b9 p:e938817d-7ec4-496e-9af7-7931d0273423 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
        @Ignore
	public void testToString_5()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkConceptAttributes:  defined: false  primordial:3ea46cbf-add2-45fb-9f0e-db0535c43048 xtraIds:[] s:c18f6e3c-d96f-4160-a46e-3e01e1f5fe95 a:5b10d8e9-5263-415f-9c1e-6c9d70a7e11a p:de06f41f-e85b-4325-84af-6b3412d31514 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = null;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = null;
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = null;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = null;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = null;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = null;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testWriteExternal_8()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testWriteExternal_9()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = null;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testWriteExternal_10()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testWriteExternal_11()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = null;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testWriteExternal_12()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = null;
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testWriteExternal_13()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = null;
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	@Test
	public void testWriteExternal_14()
		throws Exception {
		TkConceptAttributes fixture = new TkConceptAttributes();
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = null;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = null;
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
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
	 * @generatedBy CodePro at 2/4/12 4:38 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkComponentTest.class);
	}
}