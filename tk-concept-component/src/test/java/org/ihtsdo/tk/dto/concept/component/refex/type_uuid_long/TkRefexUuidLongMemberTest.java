package org.ihtsdo.tk.dto.concept.component.refex.type_uuid_long;

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
import org.ihtsdo.tk.api.refex.type_nid_long.RefexNidLongVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexUuidLongMemberTest</code> contains tests for the class <code>{@link TkRefexUuidLongMember}</code>.
 *
 * @generatedBy CodePro at 2/4/12 3:52 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexUuidLongMemberTest {
	/**
	 * Run the TkRefexUuidLongMember() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testTkRefexUuidLongMember_1()
		throws Exception {

		TkRefexUuidLongMember result = new TkRefexUuidLongMember();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisions());
		assertEquals(0L, result.getLong1());
		assertEquals(null, result.getUuid1());
		assertEquals(null, result.getRevisionList());
		assertEquals(null, result.getComponentUuid());
		assertEquals(null, result.getRefexUuid());
		assertEquals(null, result.getAnnotations());
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
	 * Run the TkRefexUuidLongMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidLongMember_2()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidLongMember result = new TkRefexUuidLongMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_long.TkRefexUuidLongMember.<init>(TkRefexUuidLongMember.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidLongMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidLongMember_3()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidLongMember result = new TkRefexUuidLongMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_long.TkRefexUuidLongMember.<init>(TkRefexUuidLongMember.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidLongMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidLongMember_4()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidLongMember result = new TkRefexUuidLongMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_long.TkRefexUuidLongMember.<init>(TkRefexUuidLongMember.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidLongMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidLongMember_5()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidLongMember result = new TkRefexUuidLongMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_long.TkRefexUuidLongMember.<init>(TkRefexUuidLongMember.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidLongMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidLongMember_6()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidLongMember result = new TkRefexUuidLongMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_long.TkRefexUuidLongMember.<init>(TkRefexUuidLongMember.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidLongMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidLongMember_7()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidLongMember result = new TkRefexUuidLongMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidLongMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidLongMember_8()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidLongMember result = new TkRefexUuidLongMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidLongMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidLongMember_9()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidLongMember result = new TkRefexUuidLongMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidLongMember(TkRefexUuidLongMember,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testTkRefexUuidLongMember_10()
		throws Exception {
		TkRefexUuidLongMember another = new TkRefexUuidLongMember();
		another.setLong1(1L);
		another.setUuid1(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkRefexUuidLongMember result = new TkRefexUuidLongMember(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisions());
		assertEquals(1L, result.getLong1());
		assertEquals(null, result.getRevisionList());
		assertEquals(null, result.getComponentUuid());
		assertEquals(null, result.getRefexUuid());
		assertEquals(null, result.getAnnotations());
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
	 * Run the TkRefexUuidLongMember(TkRefexUuidLongMember,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testTkRefexUuidLongMember_11()
		throws Exception {
		TkRefexUuidLongMember another = new TkRefexUuidLongMember();
		another.setLong1(1L);
		another.setUuid1(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidLongMember result = new TkRefexUuidLongMember(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisions());
		assertEquals(1L, result.getLong1());
		assertEquals(null, result.getUuid1());
		assertEquals(null, result.getRevisionList());
		assertEquals(null, result.getComponentUuid());
		assertEquals(null, result.getRefexUuid());
		assertEquals(null, result.getAnnotations());
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
	 * Run the TkRefexUuidLongMember(RefexNidLongVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidLongMember_12()
		throws Exception {
		RefexNidLongVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidLongMember result = new TkRefexUuidLongMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_long.TkRefexUuidLongMember.<init>(TkRefexUuidLongMember.java:82)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidLongMember(RefexNidLongVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidLongMember_13()
		throws Exception {
		RefexNidLongVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidLongMember result = new TkRefexUuidLongMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_long.TkRefexUuidLongMember.<init>(TkRefexUuidLongMember.java:82)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidLongMember(RefexNidLongVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidLongMember_14()
		throws Exception {
		RefexNidLongVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidLongMember result = new TkRefexUuidLongMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_long.TkRefexUuidLongMember.<init>(TkRefexUuidLongMember.java:82)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidLongMember(RefexNidLongVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidLongMember_15()
		throws Exception {
		RefexNidLongVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidLongMember result = new TkRefexUuidLongMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_long.TkRefexUuidLongMember.<init>(TkRefexUuidLongMember.java:82)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidLongMember obj = new TkRefexUuidLongMember();
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidLongMember obj = new TkRefexUuidLongMember();
		obj.setLong1(1L);
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidLongMember obj = new TkRefexUuidLongMember();
		obj.setLong1(1L);
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidLongMember obj = new TkRefexUuidLongMember();
		obj.setLong1(1L);
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the long getLong1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testGetLong1_1()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		long result = fixture.getLong1();

		// add additional test code here
		assertEquals(1L, result);
	}

	/**
	 * Run the List<TkRefexUuidLongRevision> getRevisionList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testGetRevisionList_1()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		List<TkRefexUuidLongRevision> result = fixture.getRevisionList();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the List<TkRefexUuidLongRevision> getRevisions() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testGetRevisions_1()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		List<TkRefexUuidLongRevision> result = fixture.getRevisions();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the TK_REFEX_TYPE getType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testGetType_1()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		TK_REFEX_TYPE result = fixture.getType();

		// add additional test code here
		assertNotNull(result);
		assertEquals(12, result.getTypeToken());
		assertEquals("CID_LONG", result.name());
		assertEquals("CID_LONG", result.toString());
		assertEquals(11, result.ordinal());
	}

	/**
	 * Run the UUID getUuid1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
        @Ignore
	public void testGetUuid1_1()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		UUID result = fixture.getUuid1();

		// add additional test code here
		assertNotNull(result);
		assertEquals("d072e258-ea8d-403b-8e80-9f06cec5eac0", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-3426427494955401157L, result.getMostSignificantBits());
		assertEquals(-8178362071717123392L, result.getLeastSignificantBits());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(-1562790778, result);
	}

	/**
	 * Run the TkRefexUuidLongMember makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidLongMember result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisions());
		assertEquals(1L, result.getLong1());
		assertEquals(null, result.getUuid1());
		assertEquals(null, result.getRevisionList());
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_9()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_10()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_11()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setLong1(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testSetLong1_1()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		long long1 = 1L;

		fixture.setLong1(long1);

		// add additional test code here
	}

	/**
	 * Run the void setUuid1(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testSetUuid1_1()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		UUID uuid1 = UUID.randomUUID();

		fixture.setUuid1(uuid1);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexUuidLongMember:  c1: befa7b2b-7c39-49ea-8f5f-b4e5d53e19c5 long:1  refex:fe45acde-f4dd-45ad-a178-483a2abe3de9 component:9df5707c-8bce-4c7e-95d7-9f5d392f8e67  primordial:65630a66-7d04-405d-9c8a-18eb036f9d78 xtraIds:[] s:b8a236d4-bd5d-4318-8c1c-10af8671d025 a:0a374323-341d-4937-bc22-cfd9a768620d p:bb054a5a-ee40-4458-b68a-77392996504d t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = null;
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testWriteExternal_8()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testWriteExternal_9()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	@Test
	public void testWriteExternal_10()
		throws Exception {
		TkRefexUuidLongMember fixture = new TkRefexUuidLongMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setLong1(1L);
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.additionalIds = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.extraVersions = null;
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
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
	 * @generatedBy CodePro at 2/4/12 3:52 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexUuidLongMemberTest.class);
	}
}