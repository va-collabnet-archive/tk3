package org.ihtsdo.tk.dto.concept.component.refex.type_uuid;

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
import org.ihtsdo.tk.api.refex.type_nid.RefexNidVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexUuidMemberTest</code> contains tests for the class <code>{@link TkRefexUuidMember}</code>.
 *
 * @generatedBy CodePro at 2/4/12 4:27 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexUuidMemberTest {
	/**
	 * Run the TkRefexUuidMember() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testTkRefexUuidMember_1()
		throws Exception {

		TkRefexUuidMember result = new TkRefexUuidMember();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
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
	 * Run the TkRefexUuidMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidMember_2()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidMember result = new TkRefexUuidMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid.TkRefexUuidMember.<init>(TkRefexUuidMember.java:33)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidMember_3()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidMember result = new TkRefexUuidMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid.TkRefexUuidMember.<init>(TkRefexUuidMember.java:33)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidMember_4()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidMember result = new TkRefexUuidMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid.TkRefexUuidMember.<init>(TkRefexUuidMember.java:33)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidMember_5()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidMember result = new TkRefexUuidMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid.TkRefexUuidMember.<init>(TkRefexUuidMember.java:33)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidMember_6()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidMember result = new TkRefexUuidMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid.TkRefexUuidMember.<init>(TkRefexUuidMember.java:33)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidMember_7()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidMember result = new TkRefexUuidMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidMember_8()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidMember result = new TkRefexUuidMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidMember_9()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidMember result = new TkRefexUuidMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidMember(TkRefexUuidMember,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testTkRefexUuidMember_10()
		throws Exception {
		TkRefexUuidMember another = new TkRefexUuidMember();
		another.setUuid1(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkRefexUuidMember result = new TkRefexUuidMember(another, conversionMap, offset, mapAll);

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
	 * Run the TkRefexUuidMember(TkRefexUuidMember,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testTkRefexUuidMember_11()
		throws Exception {
		TkRefexUuidMember another = new TkRefexUuidMember();
		another.setUuid1(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidMember result = new TkRefexUuidMember(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
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
	 * Run the TkRefexUuidMember(RefexNidVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidMember_12()
		throws Exception {
		RefexNidVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidMember result = new TkRefexUuidMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid.TkRefexUuidMember.<init>(TkRefexUuidMember.java:76)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidMember(RefexNidVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidMember_13()
		throws Exception {
		RefexNidVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidMember result = new TkRefexUuidMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid.TkRefexUuidMember.<init>(TkRefexUuidMember.java:76)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidMember(RefexNidVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidMember_14()
		throws Exception {
		RefexNidVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidMember result = new TkRefexUuidMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid.TkRefexUuidMember.<init>(TkRefexUuidMember.java:76)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidMember(RefexNidVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidMember_15()
		throws Exception {
		RefexNidVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidMember result = new TkRefexUuidMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid.TkRefexUuidMember.<init>(TkRefexUuidMember.java:76)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		TkRefexUuidMember obj = new TkRefexUuidMember();
		obj.setUuid1(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		TkRefexUuidMember obj = new TkRefexUuidMember();
		obj.setUuid1(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		TkRefexUuidMember obj = new TkRefexUuidMember();
		obj.setUuid1(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the List<TkRefexUuidRevision> getRevisionList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testGetRevisionList_1()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();

		List<TkRefexUuidRevision> result = fixture.getRevisionList();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the TK_REFEX_TYPE getType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testGetType_1()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();

		TK_REFEX_TYPE result = fixture.getType();

		// add additional test code here
		assertNotNull(result);
		assertEquals(2, result.getTypeToken());
		assertEquals("CID", result.name());
		assertEquals("CID", result.toString());
		assertEquals(1, result.ordinal());
	}

	/**
	 * Run the UUID getUuid1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
        @Ignore
	public void testGetUuid1_1()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();

		UUID result = fixture.getUuid1();

		// add additional test code here
		assertNotNull(result);
		assertEquals("09f7cee2-52d1-4ae1-b809-a4025bec9f43", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(718270137036262113L, result.getMostSignificantBits());
		assertEquals(-5185433165901291709L, result.getLeastSignificantBits());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(1270089784, result);
	}

	/**
	 * Run the TkRefexUuidMember makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidMember result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
		assertEquals(null, result.getComponentUuid());
		assertEquals(null, result.getRefexUuid());
		assertEquals(null, result.getPrimordialComponentUuid());
		assertEquals(1, result.getIdComponentCount());
		assertEquals(1, result.getVersionCount());
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_9()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_10()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setUuid1(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testSetUuid1_1()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		UUID uuid1 = UUID.randomUUID();

		fixture.setUuid1(uuid1);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexUuidMember:  c1:3f6a924e-cc29-4d6a-b7df-91298865ab8c  refex:22ef23b5-2379-4034-afcf-b93d3c976d9d component:02f4688b-53f1-4a17-b5d6-81fa5e14048d  primordial:d415c339-d2bc-4766-840b-0206ce236511 xtraIds:[] s:61820055-bdf5-4618-96dd-4d7a0b4445ef a:4bff8c6e-2221-43ea-bae1-f506ea91149b p:d15d6ec5-fa64-47c0-89fb-343a2b418eac t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = null;
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testWriteExternal_8()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	@Test
	public void testWriteExternal_9()
		throws Exception {
		TkRefexUuidMember fixture = new TkRefexUuidMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = null;
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
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
	 * @generatedBy CodePro at 2/4/12 4:27 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexUuidMemberTest.class);
	}
}