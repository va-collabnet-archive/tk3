package org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid;

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
import org.ihtsdo.tk.api.refex.type_nid_nid.RefexNidNidVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexUuidUuidMemberTest</code> contains tests for the class <code>{@link TkRefexUuidUuidMember}</code>.
 *
 * @generatedBy CodePro at 2/4/12 4:43 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexUuidUuidMemberTest {
	/**
	 * Run the TkRefexUuidUuidMember() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testTkRefexUuidUuidMember_1()
		throws Exception {

		TkRefexUuidUuidMember result = new TkRefexUuidUuidMember();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisionList());
		assertEquals(null, result.getUuid1());
		assertEquals(null, result.getUuid2());
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
	 * Run the TkRefexUuidUuidMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidMember_2()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidUuidMember result = new TkRefexUuidUuidMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid.TkRefexUuidUuidMember.<init>(TkRefexUuidUuidMember.java:39)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidMember_3()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidUuidMember result = new TkRefexUuidUuidMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid.TkRefexUuidUuidMember.<init>(TkRefexUuidUuidMember.java:39)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidMember_4()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidUuidMember result = new TkRefexUuidUuidMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid.TkRefexUuidUuidMember.<init>(TkRefexUuidUuidMember.java:39)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidMember_5()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidUuidMember result = new TkRefexUuidUuidMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid.TkRefexUuidUuidMember.<init>(TkRefexUuidUuidMember.java:39)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidMember_6()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidUuidMember result = new TkRefexUuidUuidMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid.TkRefexUuidUuidMember.<init>(TkRefexUuidUuidMember.java:39)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidMember_7()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidUuidMember result = new TkRefexUuidUuidMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid.TkRefexUuidUuidMember.<init>(TkRefexUuidUuidMember.java:39)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidUuidMember_8()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidUuidMember result = new TkRefexUuidUuidMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidUuidMember_9()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidUuidMember result = new TkRefexUuidUuidMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidUuidMember_10()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidUuidMember result = new TkRefexUuidUuidMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidMember(TkRefexUuidUuidMember,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testTkRefexUuidUuidMember_11()
		throws Exception {
		TkRefexUuidUuidMember another = new TkRefexUuidUuidMember();
		another.setUuid2(UUID.randomUUID());
		another.setUuid1(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkRefexUuidUuidMember result = new TkRefexUuidUuidMember(another, conversionMap, offset, mapAll);

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
	 * Run the TkRefexUuidUuidMember(TkRefexUuidUuidMember,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testTkRefexUuidUuidMember_12()
		throws Exception {
		TkRefexUuidUuidMember another = new TkRefexUuidUuidMember();
		another.setUuid2(UUID.randomUUID());
		another.setUuid1(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidUuidMember result = new TkRefexUuidUuidMember(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisionList());
		assertEquals(null, result.getUuid1());
		assertEquals(null, result.getUuid2());
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
	 * Run the TkRefexUuidUuidMember(RefexNidNidVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidMember_13()
		throws Exception {
		RefexNidNidVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidUuidMember result = new TkRefexUuidUuidMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid.TkRefexUuidUuidMember.<init>(TkRefexUuidUuidMember.java:81)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidMember(RefexNidNidVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidMember_14()
		throws Exception {
		RefexNidNidVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidUuidMember result = new TkRefexUuidUuidMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid.TkRefexUuidUuidMember.<init>(TkRefexUuidUuidMember.java:81)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidMember(RefexNidNidVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidMember_15()
		throws Exception {
		RefexNidNidVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidUuidMember result = new TkRefexUuidUuidMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid.TkRefexUuidUuidMember.<init>(TkRefexUuidUuidMember.java:81)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidMember(RefexNidNidVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidMember_16()
		throws Exception {
		RefexNidNidVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidUuidMember result = new TkRefexUuidUuidMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid.TkRefexUuidUuidMember.<init>(TkRefexUuidUuidMember.java:81)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidMember(RefexNidNidVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidMember_17()
		throws Exception {
		RefexNidNidVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidUuidMember result = new TkRefexUuidUuidMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid.TkRefexUuidUuidMember.<init>(TkRefexUuidUuidMember.java:81)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidMember(RefexNidNidVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidMember_18()
		throws Exception {
		RefexNidNidVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidUuidMember result = new TkRefexUuidUuidMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid.TkRefexUuidUuidMember.<init>(TkRefexUuidUuidMember.java:81)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		TkRefexUuidUuidMember obj = new TkRefexUuidUuidMember();
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		TkRefexUuidUuidMember obj = new TkRefexUuidUuidMember();
		obj.setUuid2(UUID.randomUUID());
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		TkRefexUuidUuidMember obj = new TkRefexUuidUuidMember();
		obj.setUuid2(UUID.randomUUID());
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		TkRefexUuidUuidMember obj = new TkRefexUuidUuidMember();
		obj.setUuid2(UUID.randomUUID());
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the List<TkRefexUuidUuidRevision> getRevisionList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testGetRevisionList_1()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();

		List<TkRefexUuidUuidRevision> result = fixture.getRevisionList();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the TK_REFEX_TYPE getType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testGetType_1()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();

		TK_REFEX_TYPE result = fixture.getType();

		// add additional test code here
		assertNotNull(result);
		assertEquals(3, result.getTypeToken());
		assertEquals("CID_CID", result.name());
		assertEquals("CID_CID", result.toString());
		assertEquals(2, result.ordinal());
	}

	/**
	 * Run the UUID getUuid1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
        @Ignore
	public void testGetUuid1_1()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();

		UUID result = fixture.getUuid1();

		// add additional test code here
		assertNotNull(result);
		assertEquals("74164b79-fb7d-4ea2-9c7f-72ebd82ca329", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(8364956345169694370L, result.getMostSignificantBits());
		assertEquals(-7169885724480855255L, result.getLeastSignificantBits());
	}

	/**
	 * Run the UUID getUuid2() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
        @Ignore
	public void testGetUuid2_1()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();

		UUID result = fixture.getUuid2();

		// add additional test code here
		assertNotNull(result);
		assertEquals("e5d18554-7147-4c79-a371-589579a86c0c", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-1886580171167282055L, result.getMostSignificantBits());
		assertEquals(-6669452174144541684L, result.getLeastSignificantBits());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(1369750357, result);
	}

	/**
	 * Run the TkRefexUuidUuidMember makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidUuidMember result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
		assertEquals(null, result.getUuid2());
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_9()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_10()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_11()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_12()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testSetUuid1_1()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		UUID uuid1 = UUID.randomUUID();

		fixture.setUuid1(uuid1);

		// add additional test code here
	}

	/**
	 * Run the void setUuid2(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testSetUuid2_1()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		UUID uuid2 = UUID.randomUUID();

		fixture.setUuid2(uuid2);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexUuidUuidMember:  c1:c9e43162-acdd-4bad-bc20-21cef4ce78b0 c2:cb7b6bad-9ad3-4536-8c7a-3624a001f56c  refex:2f26fb0c-fed5-47b9-93fc-337c4943ac0b component:0e14bbca-c073-4aca-86a4-04a860990c44  primordial:9c17a79c-685b-4cb8-a2a5-7cbb09a74567 xtraIds:[] s:4e969435-a431-485f-b859-801695168a34 a:3807b605-bb3b-4455-8c14-0a474b5cb90b p:64656768-03a4-43c1-b6d6-9237f76b7448 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = null;
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testWriteExternal_8()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testWriteExternal_9()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testWriteExternal_10()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	@Test
	public void testWriteExternal_11()
		throws Exception {
		TkRefexUuidUuidMember fixture = new TkRefexUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = null;
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
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
	 * @generatedBy CodePro at 2/4/12 4:43 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexUuidUuidMemberTest.class);
	}
}