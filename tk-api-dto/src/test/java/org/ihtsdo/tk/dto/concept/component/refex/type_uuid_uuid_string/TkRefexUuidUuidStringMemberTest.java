package org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_string;

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
import org.ihtsdo.tk.api.refex.type_nid_nid_string.RefexNidNidStringVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexUuidUuidStringMemberTest</code> contains tests for the class <code>{@link TkRefexUuidUuidStringMember}</code>.
 *
 * @generatedBy CodePro at 2/4/12 5:08 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexUuidUuidStringMemberTest {
	/**
	 * Run the TkRefexUuidUuidStringMember() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testTkRefexUuidUuidStringMember_1()
		throws Exception {

		TkRefexUuidUuidStringMember result = new TkRefexUuidUuidStringMember();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisionList());
		assertEquals(null, result.getString1());
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
	 * Run the TkRefexUuidUuidStringMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidStringMember_2()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidUuidStringMember result = new TkRefexUuidUuidStringMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_string.TkRefexUuidUuidStringMember.<init>(TkRefexUuidUuidStringMember.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidStringMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidStringMember_3()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidUuidStringMember result = new TkRefexUuidUuidStringMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_string.TkRefexUuidUuidStringMember.<init>(TkRefexUuidUuidStringMember.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidStringMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidStringMember_4()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidUuidStringMember result = new TkRefexUuidUuidStringMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_string.TkRefexUuidUuidStringMember.<init>(TkRefexUuidUuidStringMember.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidStringMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidStringMember_5()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidUuidStringMember result = new TkRefexUuidUuidStringMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_string.TkRefexUuidUuidStringMember.<init>(TkRefexUuidUuidStringMember.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidStringMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidStringMember_6()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidUuidStringMember result = new TkRefexUuidUuidStringMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_string.TkRefexUuidUuidStringMember.<init>(TkRefexUuidUuidStringMember.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidStringMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidStringMember_7()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidUuidStringMember result = new TkRefexUuidUuidStringMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_string.TkRefexUuidUuidStringMember.<init>(TkRefexUuidUuidStringMember.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidStringMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidUuidStringMember_8()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidUuidStringMember result = new TkRefexUuidUuidStringMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidStringMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidUuidStringMember_9()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidUuidStringMember result = new TkRefexUuidUuidStringMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidStringMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidUuidStringMember_10()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidUuidStringMember result = new TkRefexUuidUuidStringMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidStringMember(TkRefexUuidUuidStringMember,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testTkRefexUuidUuidStringMember_11()
		throws Exception {
		TkRefexUuidUuidStringMember another = new TkRefexUuidUuidStringMember();
		another.setUuid1(UUID.randomUUID());
		another.setString1("");
		another.setUuid2(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkRefexUuidUuidStringMember result = new TkRefexUuidUuidStringMember(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisionList());
		assertEquals("", result.getString1());
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
	 * Run the TkRefexUuidUuidStringMember(TkRefexUuidUuidStringMember,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testTkRefexUuidUuidStringMember_12()
		throws Exception {
		TkRefexUuidUuidStringMember another = new TkRefexUuidUuidStringMember();
		another.setUuid1(UUID.randomUUID());
		another.setString1("");
		another.setUuid2(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidUuidStringMember result = new TkRefexUuidUuidStringMember(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisionList());
		assertEquals("", result.getString1());
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
	 * Run the TkRefexUuidUuidStringMember(RefexNidNidStringVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidStringMember_13()
		throws Exception {
		RefexNidNidStringVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidUuidStringMember result = new TkRefexUuidUuidStringMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_string.TkRefexUuidUuidStringMember.<init>(TkRefexUuidUuidStringMember.java:88)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidStringMember(RefexNidNidStringVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidStringMember_14()
		throws Exception {
		RefexNidNidStringVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidUuidStringMember result = new TkRefexUuidUuidStringMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_string.TkRefexUuidUuidStringMember.<init>(TkRefexUuidUuidStringMember.java:88)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidStringMember(RefexNidNidStringVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidStringMember_15()
		throws Exception {
		RefexNidNidStringVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidUuidStringMember result = new TkRefexUuidUuidStringMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_string.TkRefexUuidUuidStringMember.<init>(TkRefexUuidUuidStringMember.java:88)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidStringMember(RefexNidNidStringVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidStringMember_16()
		throws Exception {
		RefexNidNidStringVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidUuidStringMember result = new TkRefexUuidUuidStringMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_string.TkRefexUuidUuidStringMember.<init>(TkRefexUuidUuidStringMember.java:88)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidStringMember(RefexNidNidStringVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidStringMember_17()
		throws Exception {
		RefexNidNidStringVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidUuidStringMember result = new TkRefexUuidUuidStringMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_string.TkRefexUuidUuidStringMember.<init>(TkRefexUuidUuidStringMember.java:88)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidStringMember(RefexNidNidStringVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidStringMember_18()
		throws Exception {
		RefexNidNidStringVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidUuidStringMember result = new TkRefexUuidUuidStringMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_string.TkRefexUuidUuidStringMember.<init>(TkRefexUuidUuidStringMember.java:88)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		TkRefexUuidUuidStringMember obj = new TkRefexUuidUuidStringMember();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		TkRefexUuidUuidStringMember obj = new TkRefexUuidUuidStringMember();
		obj.setUuid1(UUID.randomUUID());
		obj.setUuid2(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		TkRefexUuidUuidStringMember obj = new TkRefexUuidUuidStringMember();
		obj.setUuid1(UUID.randomUUID());
		obj.setString1("");
		obj.setUuid2(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		TkRefexUuidUuidStringMember obj = new TkRefexUuidUuidStringMember();
		obj.setUuid1(UUID.randomUUID());
		obj.setString1("");
		obj.setUuid2(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		TkRefexUuidUuidStringMember obj = new TkRefexUuidUuidStringMember();
		obj.setUuid1(UUID.randomUUID());
		obj.setString1("");
		obj.setUuid2(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the List<TkRefexUuidUuidStringRevision> getRevisionList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testGetRevisionList_1()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();

		List<TkRefexUuidUuidStringRevision> result = fixture.getRevisionList();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getString1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testGetString1_1()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();

		String result = fixture.getString1();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the TK_REFEX_TYPE getType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testGetType_1()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();

		TK_REFEX_TYPE result = fixture.getType();

		// add additional test code here
		assertNotNull(result);
		assertEquals(5, result.getTypeToken());
		assertEquals("CID_CID_STR", result.name());
		assertEquals("CID_CID_STR", result.toString());
		assertEquals(4, result.ordinal());
	}

	/**
	 * Run the UUID getUuid1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
        @Ignore
	public void testGetUuid1_1()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();

		UUID result = fixture.getUuid1();

		// add additional test code here
		assertNotNull(result);
		assertEquals("3109c86d-4f04-4f56-9db3-a26799ec5456", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(3533575754451537750L, result.getMostSignificantBits());
		assertEquals(-7083139223075924906L, result.getLeastSignificantBits());
	}

	/**
	 * Run the UUID getUuid2() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
        @Ignore
	public void testGetUuid2_1()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();

		UUID result = fixture.getUuid2();

		// add additional test code here
		assertNotNull(result);
		assertEquals("3b660e49-4503-4f84-bb3a-f390c6cc3789", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(4280124203715481476L, result.getMostSignificantBits());
		assertEquals(-4955380636831697015L, result.getLeastSignificantBits());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(2132368904, result);
	}

	/**
	 * Run the TkRefexUuidUuidStringMember makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidUuidStringMember result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getString1());
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_9()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_10()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_11()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_12()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_13()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setString1(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testSetString1_1()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		String string1 = "";

		fixture.setString1(string1);

		// add additional test code here
	}

	/**
	 * Run the void setUuid1(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testSetUuid1_1()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		UUID uuid1 = UUID.randomUUID();

		fixture.setUuid1(uuid1);

		// add additional test code here
	}

	/**
	 * Run the void setUuid2(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testSetUuid2_1()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		UUID uuid2 = UUID.randomUUID();

		fixture.setUuid2(uuid2);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexUuidUuidStringMember:  c1:2f60f168-0312-45d0-9854-7f373db26497 c2:ce96616e-e48d-43a4-b909-1f4f0da261c8 str:''  refex:8c723b3d-a182-479d-b5f2-fc6668924360 component:ae2048d8-0d88-493d-8ff6-063a7b9db397  primordial:0d5b28ca-f977-4a4e-a25d-c1e882a41c93 xtraIds:[] s:4f5b55f5-327c-4540-87b8-0cd6d8ad4bd2 a:78ea9312-d947-4761-83d8-9fbc6cb65d40 p:d531dd17-a23c-4201-b07a-255d7761141c t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = null;
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testWriteExternal_8()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testWriteExternal_9()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testWriteExternal_10()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testWriteExternal_11()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	@Test
	public void testWriteExternal_12()
		throws Exception {
		TkRefexUuidUuidStringMember fixture = new TkRefexUuidUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.setUuid2(UUID.randomUUID());
		fixture.authorUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = null;
		fixture.componentUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.time = 1L;
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
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
	 * @generatedBy CodePro at 2/4/12 5:08 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexUuidUuidStringMemberTest.class);
	}
}