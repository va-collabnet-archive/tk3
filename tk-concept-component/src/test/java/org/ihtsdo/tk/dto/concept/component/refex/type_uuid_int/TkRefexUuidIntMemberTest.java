package org.ihtsdo.tk.dto.concept.component.refex.type_uuid_int;

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
import org.ihtsdo.tk.api.refex.type_nid_int.RefexNidIntVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexUuidIntMemberTest</code> contains tests for the class <code>{@link TkRefexUuidIntMember}</code>.
 *
 * @generatedBy CodePro at 2/4/12 4:49 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexUuidIntMemberTest {
	/**
	 * Run the TkRefexUuidIntMember() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testTkRefexUuidIntMember_1()
		throws Exception {

		TkRefexUuidIntMember result = new TkRefexUuidIntMember();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getInt1());
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
	 * Run the TkRefexUuidIntMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidIntMember_2()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidIntMember result = new TkRefexUuidIntMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_int.TkRefexUuidIntMember.<init>(TkRefexUuidIntMember.java:36)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidIntMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidIntMember_3()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidIntMember result = new TkRefexUuidIntMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_int.TkRefexUuidIntMember.<init>(TkRefexUuidIntMember.java:36)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidIntMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidIntMember_4()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidIntMember result = new TkRefexUuidIntMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_int.TkRefexUuidIntMember.<init>(TkRefexUuidIntMember.java:36)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidIntMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidIntMember_5()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidIntMember result = new TkRefexUuidIntMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_int.TkRefexUuidIntMember.<init>(TkRefexUuidIntMember.java:36)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidIntMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidIntMember_6()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidIntMember result = new TkRefexUuidIntMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_int.TkRefexUuidIntMember.<init>(TkRefexUuidIntMember.java:36)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidIntMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidIntMember_7()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidIntMember result = new TkRefexUuidIntMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidIntMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidIntMember_8()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidIntMember result = new TkRefexUuidIntMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidIntMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidIntMember_9()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidIntMember result = new TkRefexUuidIntMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidIntMember(TkRefexUuidIntMember,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testTkRefexUuidIntMember_10()
		throws Exception {
		TkRefexUuidIntMember another = new TkRefexUuidIntMember();
		another.setInt1(1);
		another.setUuid1(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkRefexUuidIntMember result = new TkRefexUuidIntMember(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getInt1());
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
	 * Run the TkRefexUuidIntMember(TkRefexUuidIntMember,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testTkRefexUuidIntMember_11()
		throws Exception {
		TkRefexUuidIntMember another = new TkRefexUuidIntMember();
		another.setInt1(1);
		another.setUuid1(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidIntMember result = new TkRefexUuidIntMember(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getInt1());
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
	 * Run the TkRefexUuidIntMember(RefexNidIntVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidIntMember_12()
		throws Exception {
		RefexNidIntVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidIntMember result = new TkRefexUuidIntMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_int.TkRefexUuidIntMember.<init>(TkRefexUuidIntMember.java:83)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidIntMember(RefexNidIntVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidIntMember_13()
		throws Exception {
		RefexNidIntVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidIntMember result = new TkRefexUuidIntMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_int.TkRefexUuidIntMember.<init>(TkRefexUuidIntMember.java:83)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidIntMember(RefexNidIntVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidIntMember_14()
		throws Exception {
		RefexNidIntVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidIntMember result = new TkRefexUuidIntMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_int.TkRefexUuidIntMember.<init>(TkRefexUuidIntMember.java:83)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidIntMember(RefexNidIntVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidIntMember_15()
		throws Exception {
		RefexNidIntVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidIntMember result = new TkRefexUuidIntMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_int.TkRefexUuidIntMember.<init>(TkRefexUuidIntMember.java:83)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		TkRefexUuidIntMember obj = new TkRefexUuidIntMember();
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
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		TkRefexUuidIntMember obj = new TkRefexUuidIntMember();
		obj.setInt1(1);
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
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		TkRefexUuidIntMember obj = new TkRefexUuidIntMember();
		obj.setInt1(1);
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
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		TkRefexUuidIntMember obj = new TkRefexUuidIntMember();
		obj.setInt1(1);
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
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the int getInt1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testGetInt1_1()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();

		int result = fixture.getInt1();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the List<TkRefexUuidIntRevision> getRevisionList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testGetRevisionList_1()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();

		List<TkRefexUuidIntRevision> result = fixture.getRevisionList();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the TK_REFEX_TYPE getType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testGetType_1()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();

		TK_REFEX_TYPE result = fixture.getType();

		// add additional test code here
		assertNotNull(result);
		assertEquals(8, result.getTypeToken());
		assertEquals("CID_INT", result.name());
		assertEquals("CID_INT", result.toString());
		assertEquals(7, result.ordinal());
	}

	/**
	 * Run the UUID getUuid1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
        @Ignore
	public void testGetUuid1_1()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();

		UUID result = fixture.getUuid1();

		// add additional test code here
		assertNotNull(result);
		assertEquals("037a6752-b65a-4661-b5c2-508a571ab1e6", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(250626334216832609L, result.getMostSignificantBits());
		assertEquals(-5349624852265651738L, result.getLeastSignificantBits());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(-1947079849, result);
	}

	/**
	 * Run the TkRevision makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_9()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_10()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_11()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setInt1(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testSetInt1_1()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		int int1 = 1;

		fixture.setInt1(int1);

		// add additional test code here
	}

	/**
	 * Run the void setUuid1(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testSetUuid1_1()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		UUID uuid1 = UUID.randomUUID();

		fixture.setUuid1(uuid1);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexUuidIntMember:  c1:749f0d7b-d2a0-42b4-9066-85ec200d43b0 int:1  refex:55dfc299-1596-4e1e-b17a-8f8f21f6ffbf component:dde88b93-18e3-4883-8c9b-6ca3fd7cab2d  primordial:83d01193-db98-4ffd-9f6e-3befb021cdaf xtraIds:[] s:4dfd825f-446d-4172-881c-a5f9f65b626b a:ed9ffa6b-ffd2-4d4e-a2bf-16c59a43b262 p:1f5133cf-1ad5-4a68-a73a-0f8a465be406 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = null;
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testWriteExternal_8()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testWriteExternal_9()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	@Test
	public void testWriteExternal_10()
		throws Exception {
		TkRefexUuidIntMember fixture = new TkRefexUuidIntMember();
		fixture.setInt1(1);
		fixture.setUuid1(UUID.randomUUID());
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = null;
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
	 * @generatedBy CodePro at 2/4/12 4:49 PM
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
	 * @generatedBy CodePro at 2/4/12 4:49 PM
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
	 * @generatedBy CodePro at 2/4/12 4:49 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexUuidIntMemberTest.class);
	}
}