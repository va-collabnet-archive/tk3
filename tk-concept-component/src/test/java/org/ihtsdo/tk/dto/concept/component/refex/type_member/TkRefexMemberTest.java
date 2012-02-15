package org.ihtsdo.tk.dto.concept.component.refex.type_member;

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
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.ihtsdo.tk.api.ContradictionManagerBI;
import org.ihtsdo.tk.api.NidBitSetBI;
import org.ihtsdo.tk.api.NidList;
import org.ihtsdo.tk.api.NidListBI;
import org.ihtsdo.tk.api.NidSet;
import org.ihtsdo.tk.api.NidSetBI;
import org.ihtsdo.tk.api.PositionBI;
import org.ihtsdo.tk.api.PositionSet;
import org.ihtsdo.tk.api.PositionSetBI;
import org.ihtsdo.tk.api.Precedence;
import org.ihtsdo.tk.api.RelAssertionType;
import org.ihtsdo.tk.api.conflict.EditPathLosesStrategy;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.api.refex.RefexVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexMemberTest</code> contains tests for the class <code>{@link TkRefexMember}</code>.
 *
 * @generatedBy CodePro at 2/4/12 4:14 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexMemberTest {
	/**
	 * Run the TkRefexMember() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
	public void testTkRefexMember_1()
		throws Exception {

		TkRefexMember result = new TkRefexMember();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisionList());
		assertEquals(null, result.getComponentUuid());
		assertEquals(null, result.getRefexUuid());
		assertEquals(null, result.getAnnotations());
		assertEquals(null, result.getRevisions());
		assertEquals(null, result.getPrimordialComponentUuid());
		assertEquals(null, result.getAdditionalIdComponents());
		assertEquals(1, result.getIdComponentCount());
		assertEquals(1, result.getVersionCount());
		assertEquals(Long.MIN_VALUE, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
        @Ignore
	public void testTkRefexMember_2()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexMember result = new TkRefexMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_member.TkRefexMember.<init>(TkRefexMember.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
        @Ignore
	public void testTkRefexMember_3()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexMember result = new TkRefexMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_member.TkRefexMember.<init>(TkRefexMember.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
        @Ignore
	public void testTkRefexMember_4()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexMember result = new TkRefexMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_member.TkRefexMember.<init>(TkRefexMember.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
        @Ignore
	public void testTkRefexMember_5()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexMember result = new TkRefexMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_member.TkRefexMember.<init>(TkRefexMember.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexMember_6()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexMember result = new TkRefexMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexMember_7()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexMember result = new TkRefexMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexMember_8()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexMember result = new TkRefexMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexMember(TkRefexMember,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
	public void testTkRefexMember_9()
		throws Exception {
		TkRefexMember another = new TkRefexMember();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexMember result = new TkRefexMember(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisionList());
		assertEquals(null, result.getComponentUuid());
		assertEquals(null, result.getRefexUuid());
		assertEquals(null, result.getAnnotations());
		assertEquals(null, result.getRevisions());
		assertEquals(null, result.getPrimordialComponentUuid());
		assertEquals(null, result.getAdditionalIdComponents());
		assertEquals(1, result.getIdComponentCount());
		assertEquals(1, result.getVersionCount());
		assertEquals(-9223372036854775807L, result.getTime());
		assertEquals(null, result.getAuthorUuid());
		assertEquals(null, result.getPathUuid());
		assertEquals(null, result.getStatusUuid());
	}

	/**
	 * Run the TkRefexMember(RefexVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
        @Ignore
	public void testTkRefexMember_10()
		throws Exception {
		RefexVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexMember result = new TkRefexMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_member.TkRefexMember.<init>(TkRefexMember.java:61)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the List<TkRefexRevision> getRevisionList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
	public void testGetRevisionList_1()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();

		List<TkRefexRevision> result = fixture.getRevisionList();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the TK_REFEX_TYPE getType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
	public void testGetType_1()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();

		TK_REFEX_TYPE result = fixture.getType();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getTypeToken());
		assertEquals("MEMBER", result.name());
		assertEquals("MEMBER", result.toString());
		assertEquals(0, result.ordinal());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(1735036427, result);
	}

	/**
	 * Run the TkRevision makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexMember:   refex:82edc729-450d-4a45-83b1-c07db3c94933 component:1bb6b1de-0f5a-4abe-88a4-8c18a284ba1f  primordial:4fb65453-3b33-4939-a74c-9f517a739366 xtraIds:[] s:1b731aee-dc57-4518-b327-123bcc8e26de a:c53419b1-e013-424d-92f6-e093895958c8 p:37be3bde-b4e8-4eba-a8c6-cd19f571c5ac t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = null;
		fixture.annotations = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkRefexMember fixture = new TkRefexMember();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.revisions = null;
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:14 PM
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
	 * @generatedBy CodePro at 2/4/12 4:14 PM
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
	 * @generatedBy CodePro at 2/4/12 4:14 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexMemberTest.class);
	}
}