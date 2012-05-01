package org.ihtsdo.tk.dto.concept.component.refex.type_uuid_float;

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
import org.ihtsdo.tk.api.refex.type_nid_float.RefexNidFloatVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexUuidFloatMemberTest</code> contains tests for the class <code>{@link TkRefexUuidFloatMember}</code>.
 *
 * @generatedBy CodePro at 2/4/12 3:19 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexUuidFloatMemberTest {
	/**
	 * Run the TkRefexUuidFloatMember() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testTkRefexUuidFloatMember_1()
		throws Exception {

		TkRefexUuidFloatMember result = new TkRefexUuidFloatMember();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisions());
		assertEquals(0.0f, result.getFloatValue(), 1.0f);
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
	 * Run the TkRefexUuidFloatMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidFloatMember_2()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidFloatMember result = new TkRefexUuidFloatMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_float.TkRefexUuidFloatMember.<init>(TkRefexUuidFloatMember.java:39)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidFloatMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidFloatMember_3()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidFloatMember result = new TkRefexUuidFloatMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_float.TkRefexUuidFloatMember.<init>(TkRefexUuidFloatMember.java:39)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidFloatMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidFloatMember_4()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidFloatMember result = new TkRefexUuidFloatMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_float.TkRefexUuidFloatMember.<init>(TkRefexUuidFloatMember.java:39)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidFloatMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidFloatMember_5()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidFloatMember result = new TkRefexUuidFloatMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_float.TkRefexUuidFloatMember.<init>(TkRefexUuidFloatMember.java:39)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidFloatMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidFloatMember_6()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidFloatMember result = new TkRefexUuidFloatMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_float.TkRefexUuidFloatMember.<init>(TkRefexUuidFloatMember.java:39)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidFloatMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidFloatMember_7()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidFloatMember result = new TkRefexUuidFloatMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidFloatMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidFloatMember_8()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidFloatMember result = new TkRefexUuidFloatMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidFloatMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidFloatMember_9()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidFloatMember result = new TkRefexUuidFloatMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidFloatMember(TkRefexUuidFloatMember,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testTkRefexUuidFloatMember_10()
		throws Exception {
		TkRefexUuidFloatMember another = new TkRefexUuidFloatMember();
		another.setFloatValue(1.0f);
		another.setUuid1(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkRefexUuidFloatMember result = new TkRefexUuidFloatMember(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisions());
		assertEquals(1.0f, result.getFloatValue(), 1.0f);
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
	 * Run the TkRefexUuidFloatMember(TkRefexUuidFloatMember,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testTkRefexUuidFloatMember_11()
		throws Exception {
		TkRefexUuidFloatMember another = new TkRefexUuidFloatMember();
		another.setFloatValue(1.0f);
		another.setUuid1(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidFloatMember result = new TkRefexUuidFloatMember(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisions());
		assertEquals(1.0f, result.getFloatValue(), 1.0f);
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
	 * Run the TkRefexUuidFloatMember(RefexNidFloatVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidFloatMember_12()
		throws Exception {
		RefexNidFloatVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidFloatMember result = new TkRefexUuidFloatMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_float.TkRefexUuidFloatMember.<init>(TkRefexUuidFloatMember.java:82)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidFloatMember(RefexNidFloatVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidFloatMember_13()
		throws Exception {
		RefexNidFloatVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidFloatMember result = new TkRefexUuidFloatMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_float.TkRefexUuidFloatMember.<init>(TkRefexUuidFloatMember.java:82)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidFloatMember(RefexNidFloatVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidFloatMember_14()
		throws Exception {
		RefexNidFloatVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidFloatMember result = new TkRefexUuidFloatMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_float.TkRefexUuidFloatMember.<init>(TkRefexUuidFloatMember.java:82)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidFloatMember(RefexNidFloatVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidFloatMember_15()
		throws Exception {
		RefexNidFloatVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidFloatMember result = new TkRefexUuidFloatMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_float.TkRefexUuidFloatMember.<init>(TkRefexUuidFloatMember.java:82)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		TkRefexUuidFloatMember obj = new TkRefexUuidFloatMember();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		TkRefexUuidFloatMember obj = new TkRefexUuidFloatMember();
		obj.setFloatValue(1.0f);
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		TkRefexUuidFloatMember obj = new TkRefexUuidFloatMember();
		obj.setFloatValue(1.0f);
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		TkRefexUuidFloatMember obj = new TkRefexUuidFloatMember();
		obj.setFloatValue(1.0f);
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the float getFloatValue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testGetFloatValue_1()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();

		float result = fixture.getFloatValue();

		// add additional test code here
		assertEquals(1.0f, result, 0.1f);
	}

	/**
	 * Run the List<TkRefexUuidFloatRevision> getRevisionList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testGetRevisionList_1()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();

		List<TkRefexUuidFloatRevision> result = fixture.getRevisionList();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the List<TkRefexUuidFloatRevision> getRevisions() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testGetRevisions_1()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();

		List<TkRefexUuidFloatRevision> result = fixture.getRevisions();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the TK_REFEX_TYPE getType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testGetType_1()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();

		TK_REFEX_TYPE result = fixture.getType();

		// add additional test code here
		assertNotNull(result);
		assertEquals(11, result.getTypeToken());
		assertEquals("CID_FLOAT", result.name());
		assertEquals("CID_FLOAT", result.toString());
		assertEquals(10, result.ordinal());
	}

	/**
	 * Run the UUID getUuid1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
        @Ignore
	public void testGetUuid1_1()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();

		UUID result = fixture.getUuid1();

		// add additional test code here
		assertNotNull(result);
		assertEquals("da0e2544-6873-4c42-a681-6db216541a53", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-2734206948026921918L, result.getMostSignificantBits());
		assertEquals(-6448752579771622829L, result.getLeastSignificantBits());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(-209138536, result);
	}

	/**
	 * Run the TkRefexUuidFloatMember makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidFloatMember result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0f, result.getFloatValue(), 1.0f);
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_9()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_10()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_11()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setFloatValue(float) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testSetFloatValue_1()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		float floatValue = 1.0f;

		fixture.setFloatValue(floatValue);

		// add additional test code here
	}

	/**
	 * Run the void setUuid1(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testSetUuid1_1()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		UUID uuid1 = UUID.randomUUID();

		fixture.setUuid1(uuid1);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexUuidFloatMember:  c1:3f466fe2-7008-4432-ae95-09c212a8a3d6 flt:1.0  refex:ab02b9dd-cb5e-4714-bc4f-b0c86cd4e1c8 component:1b608d53-776e-4adf-8110-dc2b347dfab2  primordial:6b0abcef-4b49-49a8-a016-6b0ec134ab67 xtraIds:[] s:0a60402b-5cab-4d65-98a8-9d1d19e34953 a:706ae9c4-a7d6-47ac-8dcf-028ddd3e8e32 p:acd0a090-5bf7-43af-96f2-3dd11e42fa9a t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = null;
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testWriteExternal_8()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testWriteExternal_9()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	@Test
	public void testWriteExternal_10()
		throws Exception {
		TkRefexUuidFloatMember fixture = new TkRefexUuidFloatMember();
		fixture.setFloatValue(1.0f);
		fixture.setUuid1(UUID.randomUUID());
		fixture.revisions = null;
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.refexUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
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
	 * @generatedBy CodePro at 2/4/12 3:19 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexUuidFloatMemberTest.class);
	}
}