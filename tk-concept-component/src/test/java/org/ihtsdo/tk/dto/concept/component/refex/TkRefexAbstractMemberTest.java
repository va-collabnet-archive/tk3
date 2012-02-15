package org.ihtsdo.tk.dto.concept.component.refex;

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
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;
import org.ihtsdo.tk.dto.concept.component.refex.type_boolean.TkRefexBooleanMember;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexAbstractMemberTest</code> contains tests for the class <code>{@link TkRefexAbstractMember}</code>.
 *
 * @generatedBy CodePro at 2/4/12 4:35 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexAbstractMemberTest {
	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		TkRefexBooleanMember obj = new TkRefexBooleanMember();
		obj.refexUuid = UUID.randomUUID();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		TkRefexBooleanMember obj = new TkRefexBooleanMember();
		obj.refexUuid = UUID.randomUUID();
		obj.componentUuid = UUID.randomUUID();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		TkRefexBooleanMember obj = new TkRefexBooleanMember();
		obj.refexUuid = UUID.randomUUID();
		obj.componentUuid = UUID.randomUUID();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		TkRefexBooleanMember obj = new TkRefexBooleanMember();
		obj.refexUuid = UUID.randomUUID();
		obj.componentUuid = UUID.randomUUID();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the UUID getComponentUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test
        @Ignore
	public void testGetComponentUuid_1()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();

		UUID result = fixture.getComponentUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("cddbe1ad-9d2d-457c-90a3-47ded03dd9fb", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-3613046140252109444L, result.getMostSignificantBits());
		assertEquals(-8024491088742065669L, result.getLeastSignificantBits());
	}

	/**
	 * Run the UUID getRefexUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test
        @Ignore
	public void testGetRefexUuid_1()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();

		UUID result = fixture.getRefexUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("72855d48-09a6-4006-9e3a-9e8ca1c30a2d", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(8252104456207220742L, result.getMostSignificantBits());
		assertEquals(-7045144340221195731L, result.getLeastSignificantBits());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(-416198916, result);
	}

	/**
	 * Run the void readExternal(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setComponentUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test
	public void testSetComponentUuid_1()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		UUID componentUuid = UUID.randomUUID();

		fixture.setComponentUuid(componentUuid);

		// add additional test code here
	}

	/**
	 * Run the void setRefexUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test
	public void testSetRefexUuid_1()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		UUID refexUuid = UUID.randomUUID();

		fixture.setRefexUuid(refexUuid);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexBooleanMember: false  refex:e37ef2c9-cff4-4794-9a37-1050dfce6de5 component:f20aa675-0e6c-4c2e-8e7d-bac97cd38c80  primordial:e98ab209-85f0-4800-9ec7-82f73fe5fbc1 xtraIds:[] s:b04bd6c0-7aa3-46ac-a0ca-0844cd97f350 a:c585719e-5769-4c85-810d-293cb40de38a p:68c613f1-3f26-48b4-b9ee-b7214458de53 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkRefexBooleanMember fixture = new TkRefexBooleanMember();
		fixture.additionalIds = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:35 PM
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
	 * @generatedBy CodePro at 2/4/12 4:35 PM
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
	 * @generatedBy CodePro at 2/4/12 4:35 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexAbstractMemberTest.class);
	}
}