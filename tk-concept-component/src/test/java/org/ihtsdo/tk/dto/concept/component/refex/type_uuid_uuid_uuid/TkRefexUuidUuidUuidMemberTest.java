package org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid;

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
import org.ihtsdo.tk.api.refex.type_nid_nid_nid.RefexNidNidNidVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexUuidUuidUuidMemberTest</code> contains tests for the class <code>{@link TkRefexUuidUuidUuidMember}</code>.
 *
 * @generatedBy CodePro at 2/4/12 3:25 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexUuidUuidUuidMemberTest {
	/**
	 * Run the TkRefexUuidUuidUuidMember() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testTkRefexUuidUuidUuidMember_1()
		throws Exception {

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
		assertEquals(null, result.getRevisionList());
		assertEquals(null, result.getUuid2());
		assertEquals(null, result.getUuid3());
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
	 * Run the TkRefexUuidUuidUuidMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidUuidMember_2()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember.<init>(TkRefexUuidUuidUuidMember.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidUuidMember_3()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember.<init>(TkRefexUuidUuidUuidMember.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidUuidMember_4()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember.<init>(TkRefexUuidUuidUuidMember.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidUuidMember_5()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember.<init>(TkRefexUuidUuidUuidMember.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidUuidMember_6()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember.<init>(TkRefexUuidUuidUuidMember.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidUuidMember_7()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember.<init>(TkRefexUuidUuidUuidMember.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidUuidMember_8()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember.<init>(TkRefexUuidUuidUuidMember.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidUuidUuidMember_9()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidUuidUuidMember_10()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidUuidUuidMember_11()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidMember(TkRefexUuidUuidUuidMember,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testTkRefexUuidUuidUuidMember_12()
		throws Exception {
		TkRefexUuidUuidUuidMember another = new TkRefexUuidUuidUuidMember();
		another.setUuid2(UUID.randomUUID());
		another.setUuid1(UUID.randomUUID());
		another.setUuid3(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember(another, conversionMap, offset, mapAll);

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
	 * Run the TkRefexUuidUuidUuidMember(TkRefexUuidUuidUuidMember,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testTkRefexUuidUuidUuidMember_13()
		throws Exception {
		TkRefexUuidUuidUuidMember another = new TkRefexUuidUuidUuidMember();
		another.setUuid2(UUID.randomUUID());
		another.setUuid1(UUID.randomUUID());
		another.setUuid3(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
		assertEquals(null, result.getRevisionList());
		assertEquals(null, result.getUuid2());
		assertEquals(null, result.getUuid3());
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
	 * Run the TkRefexUuidUuidUuidMember(RefexNidNidNidVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidUuidMember_14()
		throws Exception {
		RefexNidNidNidVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember.<init>(TkRefexUuidUuidUuidMember.java:86)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidMember(RefexNidNidNidVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidUuidMember_15()
		throws Exception {
		RefexNidNidNidVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember.<init>(TkRefexUuidUuidUuidMember.java:86)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidMember(RefexNidNidNidVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidUuidMember_16()
		throws Exception {
		RefexNidNidNidVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember.<init>(TkRefexUuidUuidUuidMember.java:86)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidMember(RefexNidNidNidVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidUuidMember_17()
		throws Exception {
		RefexNidNidNidVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember.<init>(TkRefexUuidUuidUuidMember.java:86)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidMember(RefexNidNidNidVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidUuidMember_18()
		throws Exception {
		RefexNidNidNidVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember.<init>(TkRefexUuidUuidUuidMember.java:86)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidMember(RefexNidNidNidVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidUuidMember_19()
		throws Exception {
		RefexNidNidNidVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember.<init>(TkRefexUuidUuidUuidMember.java:86)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidMember(RefexNidNidNidVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidUuidMember_20()
		throws Exception {
		RefexNidNidNidVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember.<init>(TkRefexUuidUuidUuidMember.java:86)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidMember(RefexNidNidNidVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidUuidUuidMember_21()
		throws Exception {
		RefexNidNidNidVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidUuidUuidMember result = new TkRefexUuidUuidUuidMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_uuid_uuid.TkRefexUuidUuidUuidMember.<init>(TkRefexUuidUuidUuidMember.java:86)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		TkRefexUuidUuidUuidMember obj = new TkRefexUuidUuidUuidMember();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		TkRefexUuidUuidUuidMember obj = new TkRefexUuidUuidUuidMember();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		TkRefexUuidUuidUuidMember obj = new TkRefexUuidUuidUuidMember();
		obj.setUuid2(UUID.randomUUID());
		obj.setUuid1(UUID.randomUUID());
		obj.setUuid3(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		TkRefexUuidUuidUuidMember obj = new TkRefexUuidUuidUuidMember();
		obj.setUuid2(UUID.randomUUID());
		obj.setUuid1(UUID.randomUUID());
		obj.setUuid3(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		TkRefexUuidUuidUuidMember obj = new TkRefexUuidUuidUuidMember();
		obj.setUuid2(UUID.randomUUID());
		obj.setUuid1(UUID.randomUUID());
		obj.setUuid3(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the List<TkRefexUuidUuidUuidRevision> getRevisionList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testGetRevisionList_1()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();

		List<TkRefexUuidUuidUuidRevision> result = fixture.getRevisionList();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the TK_REFEX_TYPE getType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testGetType_1()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();

		TK_REFEX_TYPE result = fixture.getType();

		// add additional test code here
		assertNotNull(result);
		assertEquals(4, result.getTypeToken());
		assertEquals("CID_CID_CID", result.name());
		assertEquals("CID_CID_CID", result.toString());
		assertEquals(3, result.ordinal());
	}

	/**
	 * Run the UUID getUuid1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
        @Ignore
	public void testGetUuid1_1()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();

		UUID result = fixture.getUuid1();

		// add additional test code here
		assertNotNull(result);
		assertEquals("49c132c1-1773-47d1-bbcc-d597af6105da", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(5314584840177403857L, result.getMostSignificantBits());
		assertEquals(-4914318245908904486L, result.getLeastSignificantBits());
	}

	/**
	 * Run the UUID getUuid2() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
        @Ignore
	public void testGetUuid2_1()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();

		UUID result = fixture.getUuid2();

		// add additional test code here
		assertNotNull(result);
		assertEquals("3f6970a3-1021-4d5d-ac43-17a05a8f11de", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(4569307142596676957L, result.getMostSignificantBits());
		assertEquals(-6033953098264800802L, result.getLeastSignificantBits());
	}

	/**
	 * Run the UUID getUuid3() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
        @Ignore
	public void testGetUuid3_1()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();

		UUID result = fixture.getUuid3();

		// add additional test code here
		assertNotNull(result);
		assertEquals("2f1f86cc-154f-4c16-970a-ab92ebe39726", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(3395580855149612054L, result.getMostSignificantBits());
		assertEquals(-7563043976704190682L, result.getLeastSignificantBits());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(442490270, result);
	}

	/**
	 * Run the TkRefexUuidUuidUuidMember makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidUuidUuidMember result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
		assertEquals(null, result.getUuid2());
		assertEquals(null, result.getUuid3());
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_9()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_10()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_11()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_12()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_13()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_14()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testSetUuid1_1()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		UUID uuid1 = UUID.randomUUID();

		fixture.setUuid1(uuid1);

		// add additional test code here
	}

	/**
	 * Run the void setUuid2(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testSetUuid2_1()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		UUID uuid2 = UUID.randomUUID();

		fixture.setUuid2(uuid2);

		// add additional test code here
	}

	/**
	 * Run the void setUuid3(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testSetUuid3_1()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		UUID uuid3 = UUID.randomUUID();

		fixture.setUuid3(uuid3);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexUuidUuidUuidMember:  c1:c2859485-f77c-46a4-8aa5-674b3e82fcba c2:c3af352e-1aba-4888-bbcb-5a889aff6947 c3:a8550035-150e-4c8e-bb56-0f2d8ebf5db3  refex:78c231f0-499b-4204-a77f-5b16a8a748a1 component:b9594169-b15f-492f-98fb-454485f1bef7  primordial:5c4fe106-7a9f-41cf-b608-0142df471db3 xtraIds:[] s:b7d606fa-c6d3-4d0e-8f47-b55f7c8f0241 a:3da61ed0-7626-4ee3-8e34-287835e6c9c0 p:de8c69fe-70b4-4a05-885a-5508dc19663f t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testWriteExternal_8()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = null;
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testWriteExternal_9()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testWriteExternal_10()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testWriteExternal_11()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testWriteExternal_12()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	@Test
	public void testWriteExternal_13()
		throws Exception {
		TkRefexUuidUuidUuidMember fixture = new TkRefexUuidUuidUuidMember();
		fixture.setUuid2(UUID.randomUUID());
		fixture.setUuid1(UUID.randomUUID());
		fixture.setUuid3(UUID.randomUUID());
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.revisions = null;
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
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
	 * @generatedBy CodePro at 2/4/12 3:25 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexUuidUuidUuidMemberTest.class);
	}
}