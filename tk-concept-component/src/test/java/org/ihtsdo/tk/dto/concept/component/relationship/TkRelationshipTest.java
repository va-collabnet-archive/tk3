package org.ihtsdo.tk.dto.concept.component.relationship;

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
import org.ihtsdo.tk.api.relationship.RelationshipChronicleBI;
import org.ihtsdo.tk.api.relationship.RelationshipVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRelationshipTest</code> contains tests for the class <code>{@link TkRelationship}</code>.
 *
 * @generatedBy CodePro at 2/4/12 3:58 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRelationshipTest {
	/**
	 * Run the TkRelationship() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testTkRelationship_1()
		throws Exception {

		TkRelationship result = new TkRelationship();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisionList());
		assertEquals(null, result.getC1Uuid());
		assertEquals(null, result.getC2Uuid());
		assertEquals(null, result.getCharacteristicUuid());
		assertEquals(null, result.getRefinabilityUuid());
		assertEquals(0, result.getRelGroup());
		assertEquals(null, result.getTypeUuid());
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
	 * Run the TkRelationship(RelationshipChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_2()
		throws Exception {
		RelationshipChronicleBI rel = null;

		TkRelationship result = new TkRelationship(rel);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_3()
		throws Exception {
		RelationshipChronicleBI rel = null;

		TkRelationship result = new TkRelationship(rel);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_4()
		throws Exception {
		RelationshipChronicleBI rel = null;

		TkRelationship result = new TkRelationship(rel);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_5()
		throws Exception {
		RelationshipChronicleBI rel = null;

		TkRelationship result = new TkRelationship(rel);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_6()
		throws Exception {
		RelationshipChronicleBI rel = null;

		TkRelationship result = new TkRelationship(rel);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_7()
		throws Exception {
		RelationshipChronicleBI rel = null;

		TkRelationship result = new TkRelationship(rel);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_8()
		throws Exception {
		RelationshipChronicleBI rel = null;

		TkRelationship result = new TkRelationship(rel);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_9()
		throws Exception {
		RelationshipChronicleBI rel = null;

		TkRelationship result = new TkRelationship(rel);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_10()
		throws Exception {
		RelationshipChronicleBI rel = null;

		TkRelationship result = new TkRelationship(rel);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_11()
		throws Exception {
		RelationshipChronicleBI rel = null;

		TkRelationship result = new TkRelationship(rel);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_12()
		throws Exception {
		RelationshipChronicleBI rel = null;

		TkRelationship result = new TkRelationship(rel);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRelationship_13()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRelationship result = new TkRelationship(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRelationship_14()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRelationship result = new TkRelationship(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRelationship_15()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRelationship result = new TkRelationship(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(TkRelationship,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testTkRelationship_16()
		throws Exception {
		TkRelationship another = new TkRelationship();
		another.setC2Uuid(UUID.randomUUID());
		another.setCharacteristicUuid(UUID.randomUUID());
		another.setRelGroup(1);
		another.setC1Uuid(UUID.randomUUID());
		another.setRefinabilityUuid(UUID.randomUUID());
		another.setTypeUuid(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkRelationship result = new TkRelationship(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisionList());
		assertEquals(1, result.getRelGroup());
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
	 * Run the TkRelationship(TkRelationship,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testTkRelationship_17()
		throws Exception {
		TkRelationship another = new TkRelationship();
		another.setC2Uuid(UUID.randomUUID());
		another.setCharacteristicUuid(UUID.randomUUID());
		another.setRelGroup(1);
		another.setC1Uuid(UUID.randomUUID());
		another.setRefinabilityUuid(UUID.randomUUID());
		another.setTypeUuid(UUID.randomUUID());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRelationship result = new TkRelationship(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisionList());
		assertEquals(null, result.getC1Uuid());
		assertEquals(null, result.getC2Uuid());
		assertEquals(null, result.getCharacteristicUuid());
		assertEquals(null, result.getRefinabilityUuid());
		assertEquals(1, result.getRelGroup());
		assertEquals(null, result.getTypeUuid());
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
	 * Run the TkRelationship(RelationshipVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_18()
		throws Exception {
		RelationshipVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRelationship result = new TkRelationship(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:98)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_19()
		throws Exception {
		RelationshipVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRelationship result = new TkRelationship(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:98)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_20()
		throws Exception {
		RelationshipVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRelationship result = new TkRelationship(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:98)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_21()
		throws Exception {
		RelationshipVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRelationship result = new TkRelationship(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:98)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_22()
		throws Exception {
		RelationshipVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRelationship result = new TkRelationship(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:98)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_23()
		throws Exception {
		RelationshipVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRelationship result = new TkRelationship(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:98)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_24()
		throws Exception {
		RelationshipVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRelationship result = new TkRelationship(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:98)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_25()
		throws Exception {
		RelationshipVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRelationship result = new TkRelationship(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:98)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_26()
		throws Exception {
		RelationshipVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRelationship result = new TkRelationship(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:98)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_27()
		throws Exception {
		RelationshipVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRelationship result = new TkRelationship(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:98)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_28()
		throws Exception {
		RelationshipVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRelationship result = new TkRelationship(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:98)
		assertNotNull(result);
	}

	/**
	 * Run the TkRelationship(RelationshipVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testTkRelationship_29()
		throws Exception {
		RelationshipVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRelationship result = new TkRelationship(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship.<init>(TkRelationship.java:98)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		TkRelationship obj = new TkRelationship();
		obj.setC1Uuid(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		TkRelationship obj = new TkRelationship();
		obj.setC2Uuid(UUID.randomUUID());
		obj.setC1Uuid(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		TkRelationship obj = new TkRelationship();
		obj.setCharacteristicUuid(UUID.randomUUID());
		obj.setC2Uuid(UUID.randomUUID());
		obj.setC1Uuid(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		TkRelationship obj = new TkRelationship();
		obj.setC2Uuid(UUID.randomUUID());
		obj.setCharacteristicUuid(UUID.randomUUID());
		obj.setC1Uuid(UUID.randomUUID());
		obj.setRefinabilityUuid(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		TkRelationship obj = new TkRelationship();
		obj.setC2Uuid(UUID.randomUUID());
		obj.setCharacteristicUuid(UUID.randomUUID());
		obj.setRelGroup(1);
		obj.setC1Uuid(UUID.randomUUID());
		obj.setRefinabilityUuid(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		TkRelationship obj = new TkRelationship();
		obj.setC2Uuid(UUID.randomUUID());
		obj.setCharacteristicUuid(UUID.randomUUID());
		obj.setRelGroup(1);
		obj.setC1Uuid(UUID.randomUUID());
		obj.setRefinabilityUuid(UUID.randomUUID());
		obj.setTypeUuid(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testEquals_8()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		TkRelationship obj = new TkRelationship();
		obj.setC2Uuid(UUID.randomUUID());
		obj.setCharacteristicUuid(UUID.randomUUID());
		obj.setRelGroup(1);
		obj.setC1Uuid(UUID.randomUUID());
		obj.setRefinabilityUuid(UUID.randomUUID());
		obj.setTypeUuid(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testEquals_9()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		TkRelationship obj = new TkRelationship();
		obj.setC2Uuid(UUID.randomUUID());
		obj.setCharacteristicUuid(UUID.randomUUID());
		obj.setRelGroup(1);
		obj.setC1Uuid(UUID.randomUUID());
		obj.setRefinabilityUuid(UUID.randomUUID());
		obj.setTypeUuid(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testEquals_10()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the UUID getC1Uuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testGetC1Uuid_1()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();

		UUID result = fixture.getC1Uuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("05d9be8b-322e-4992-944d-0ddb99ba9239", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(421577545187477906L, result.getMostSignificantBits());
		assertEquals(-7760531346061356487L, result.getLeastSignificantBits());
	}

	/**
	 * Run the UUID getC2Uuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testGetC2Uuid_1()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();

		UUID result = fixture.getC2Uuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("cc7fe9c8-d399-4346-8202-9c09b69223b0", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-3710990519177231546L, result.getMostSignificantBits());
		assertEquals(-9078522333293829200L, result.getLeastSignificantBits());
	}

	/**
	 * Run the UUID getCharacteristicUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testGetCharacteristicUuid_1()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();

		UUID result = fixture.getCharacteristicUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("f25da4a6-7dd7-47d5-bc7a-2c2f21088bc2", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-982448108714113067L, result.getMostSignificantBits());
		assertEquals(-4865527866491106366L, result.getLeastSignificantBits());
	}

	/**
	 * Run the UUID getRefinabilityUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testGetRefinabilityUuid_1()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();

		UUID result = fixture.getRefinabilityUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("f88333b4-71fa-4f35-9c84-a0b1259d3d7f", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-539530680254968011L, result.getMostSignificantBits());
		assertEquals(-7168428024166269569L, result.getLeastSignificantBits());
	}

	/**
	 * Run the int getRelGroup() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testGetRelGroup_1()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();

		int result = fixture.getRelGroup();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the List<TkRelationshipRevision> getRevisionList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testGetRevisionList_1()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();

		List<TkRelationshipRevision> result = fixture.getRevisionList();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the UUID getTypeUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testGetTypeUuid_1()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();

		UUID result = fixture.getTypeUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("af0f0df4-50ca-44a6-83da-5974f0f5f656", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-5832427649442888538L, result.getMostSignificantBits());
		assertEquals(-8945739351024339370L, result.getLeastSignificantBits());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(659367434, result);
	}

	/**
	 * Run the TkRelationship makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRelationship result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getC1Uuid());
		assertEquals(null, result.getC2Uuid());
		assertEquals(null, result.getCharacteristicUuid());
		assertEquals(null, result.getRefinabilityUuid());
		assertEquals(1, result.getRelGroup());
		assertEquals(null, result.getTypeUuid());
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_9()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_10()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_11()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_12()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_13()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_14()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_15()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_16()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setC1Uuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testSetC1Uuid_1()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		UUID c1Uuid = UUID.randomUUID();

		fixture.setC1Uuid(c1Uuid);

		// add additional test code here
	}

	/**
	 * Run the void setC2Uuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testSetC2Uuid_1()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		UUID c2Uuid = UUID.randomUUID();

		fixture.setC2Uuid(c2Uuid);

		// add additional test code here
	}

	/**
	 * Run the void setCharacteristicUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testSetCharacteristicUuid_1()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		UUID characteristicUuid = UUID.randomUUID();

		fixture.setCharacteristicUuid(characteristicUuid);

		// add additional test code here
	}

	/**
	 * Run the void setRefinabilityUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testSetRefinabilityUuid_1()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		UUID refinabilityUuid = UUID.randomUUID();

		fixture.setRefinabilityUuid(refinabilityUuid);

		// add additional test code here
	}

	/**
	 * Run the void setRelGroup(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testSetRelGroup_1()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		int relGroup = 1;

		fixture.setRelGroup(relGroup);

		// add additional test code here
	}

	/**
	 * Run the void setTypeUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testSetTypeUuid_1()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		UUID typeUuid = UUID.randomUUID();

		fixture.setTypeUuid(typeUuid);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRelationship:  c1: 856570eb-42b9-4afc-a739-b7fda99e5dab type:67329e78-45d4-46f2-beb7-8711699d8214 c2: 4f850837-55a8-414e-b59b-ffd47077686e grp:1 char: 86da515a-761d-416e-83a5-80c95e5536ed ref: ee2640f5-021a-4932-8ad7-0476cdf3ab4e  primordial:e4149a29-59bb-4494-b7e1-78582dbc8626 xtraIds:[] s:399f8a8a-f17c-4197-8172-9e3ffec941af a:7b09359e-a8c9-44d4-a33c-2280ca97201a p:b33da777-021c-472a-8484-cb43e220ceb8 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testWriteExternal_8()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testWriteExternal_9()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testWriteExternal_10()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testWriteExternal_11()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = null;
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testWriteExternal_12()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testWriteExternal_13()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testWriteExternal_14()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testWriteExternal_15()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	@Test
	public void testWriteExternal_16()
		throws Exception {
		TkRelationship fixture = new TkRelationship();
		fixture.setC2Uuid(UUID.randomUUID());
		fixture.setCharacteristicUuid(UUID.randomUUID());
		fixture.setC1Uuid(UUID.randomUUID());
		fixture.setRelGroup(1);
		fixture.setRefinabilityUuid(UUID.randomUUID());
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.pathUuid = UUID.randomUUID();
		fixture.revisions = null;
		fixture.primordialUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
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
	 * @generatedBy CodePro at 2/4/12 3:58 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRelationshipTest.class);
	}
}