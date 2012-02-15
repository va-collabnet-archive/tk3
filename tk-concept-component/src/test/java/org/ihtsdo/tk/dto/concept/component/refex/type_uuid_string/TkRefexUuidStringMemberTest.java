package org.ihtsdo.tk.dto.concept.component.refex.type_uuid_string;

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
import org.ihtsdo.tk.api.refex.type_nid_string.RefexNidStringVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexUuidStringMemberTest</code> contains tests for the class <code>{@link TkRefexUuidStringMember}</code>.
 *
 * @generatedBy CodePro at 2/4/12 4:03 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexUuidStringMemberTest {
	/**
	 * Run the TkRefexUuidStringMember() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testTkRefexUuidStringMember_1()
		throws Exception {

		TkRefexUuidStringMember result = new TkRefexUuidStringMember();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisions());
		assertEquals(null, result.getUuid1());
		assertEquals(null, result.getString1());
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
	 * Run the TkRefexUuidStringMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidStringMember_2()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidStringMember result = new TkRefexUuidStringMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_string.TkRefexUuidStringMember.<init>(TkRefexUuidStringMember.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidStringMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidStringMember_3()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidStringMember result = new TkRefexUuidStringMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_string.TkRefexUuidStringMember.<init>(TkRefexUuidStringMember.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidStringMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidStringMember_4()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidStringMember result = new TkRefexUuidStringMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_string.TkRefexUuidStringMember.<init>(TkRefexUuidStringMember.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidStringMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidStringMember_5()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidStringMember result = new TkRefexUuidStringMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_string.TkRefexUuidStringMember.<init>(TkRefexUuidStringMember.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidStringMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidStringMember_6()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexUuidStringMember result = new TkRefexUuidStringMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_string.TkRefexUuidStringMember.<init>(TkRefexUuidStringMember.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidStringMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidStringMember_7()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidStringMember result = new TkRefexUuidStringMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidStringMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidStringMember_8()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidStringMember result = new TkRefexUuidStringMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidStringMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexUuidStringMember_9()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexUuidStringMember result = new TkRefexUuidStringMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidStringMember(TkRefexUuidStringMember,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testTkRefexUuidStringMember_10()
		throws Exception {
		TkRefexUuidStringMember another = new TkRefexUuidStringMember();
		another.setUuid1(UUID.randomUUID());
		another.setString1("");
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkRefexUuidStringMember result = new TkRefexUuidStringMember(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisions());
		assertEquals("", result.getString1());
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
	 * Run the TkRefexUuidStringMember(TkRefexUuidStringMember,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testTkRefexUuidStringMember_11()
		throws Exception {
		TkRefexUuidStringMember another = new TkRefexUuidStringMember();
		another.setUuid1(UUID.randomUUID());
		another.setString1("");
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidStringMember result = new TkRefexUuidStringMember(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisions());
		assertEquals(null, result.getUuid1());
		assertEquals("", result.getString1());
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
	 * Run the TkRefexUuidStringMember(RefexNidStringVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidStringMember_12()
		throws Exception {
		RefexNidStringVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidStringMember result = new TkRefexUuidStringMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_string.TkRefexUuidStringMember.<init>(TkRefexUuidStringMember.java:82)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidStringMember(RefexNidStringVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidStringMember_13()
		throws Exception {
		RefexNidStringVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidStringMember result = new TkRefexUuidStringMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_string.TkRefexUuidStringMember.<init>(TkRefexUuidStringMember.java:82)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidStringMember(RefexNidStringVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidStringMember_14()
		throws Exception {
		RefexNidStringVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidStringMember result = new TkRefexUuidStringMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_string.TkRefexUuidStringMember.<init>(TkRefexUuidStringMember.java:82)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexUuidStringMember(RefexNidStringVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
        @Ignore
	public void testTkRefexUuidStringMember_15()
		throws Exception {
		RefexNidStringVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexUuidStringMember result = new TkRefexUuidStringMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_uuid_string.TkRefexUuidStringMember.<init>(TkRefexUuidStringMember.java:82)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidStringMember obj = new TkRefexUuidStringMember();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidStringMember obj = new TkRefexUuidStringMember();
		obj.setUuid1(UUID.randomUUID());
		obj.setString1("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidStringMember obj = new TkRefexUuidStringMember();
		obj.setUuid1(UUID.randomUUID());
		obj.setString1("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		TkRefexUuidStringMember obj = new TkRefexUuidStringMember();
		obj.setUuid1(UUID.randomUUID());
		obj.setString1("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the List<TkRefexUuidStringRevision> getRevisionList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testGetRevisionList_1()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		List<TkRefexUuidStringRevision> result = fixture.getRevisionList();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the List<TkRefexUuidStringRevision> getRevisions() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testGetRevisions_1()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		List<TkRefexUuidStringRevision> result = fixture.getRevisions();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getString1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testGetString1_1()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.getString1();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the TK_REFEX_TYPE getType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testGetType_1()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		TK_REFEX_TYPE result = fixture.getType();

		// add additional test code here
		assertNotNull(result);
		assertEquals(10, result.getTypeToken());
		assertEquals("CID_STR", result.name());
		assertEquals("CID_STR", result.toString());
		assertEquals(9, result.ordinal());
	}

	/**
	 * Run the UUID getUuid1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
        @Ignore
	public void testGetUuid1_1()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		UUID result = fixture.getUuid1();

		// add additional test code here
		assertNotNull(result);
		assertEquals("12266f7b-c2f1-483c-b66f-c57274ac5d0f", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(1307855319139960892L, result.getMostSignificantBits());
		assertEquals(-5300801141017387761L, result.getLeastSignificantBits());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(972258617, result);
	}

	/**
	 * Run the TkRefexUuidStringMember makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexUuidStringMember result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUuid1());
		assertEquals("", result.getString1());
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_9()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_10()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_11()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testSetString1_1()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		String string1 = "";

		fixture.setString1(string1);

		// add additional test code here
	}

	/**
	 * Run the void setUuid1(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testSetUuid1_1()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexUuidStringMember:  c1:16326f55-9667-4354-8e9d-1917157c3377 str:''  refex:e23a7aaa-8b4e-4304-93b0-cc02d4d25f27 component:e663899f-3cca-4ab0-b549-8b857f01101f  primordial:b0ff9897-2140-448a-94f1-e8e62dc500b9 xtraIds:[] s:9a3aabff-953a-41fe-9a8a-6c22ad781adf a:777e0990-0c9e-40dd-9a75-fc90adfb11a2 p:51cd2a53-a440-4e27-be83-ed4cd608d91f t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = null;
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testWriteExternal_8()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testWriteExternal_9()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	@Test
	public void testWriteExternal_10()
		throws Exception {
		TkRefexUuidStringMember fixture = new TkRefexUuidStringMember();
		fixture.setUuid1(UUID.randomUUID());
		fixture.setString1("");
		fixture.componentUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = null;
		fixture.annotations = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
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
	 * @generatedBy CodePro at 2/4/12 4:03 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexUuidStringMemberTest.class);
	}
}