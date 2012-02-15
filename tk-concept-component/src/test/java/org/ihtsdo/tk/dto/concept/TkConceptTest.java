package org.ihtsdo.tk.dto.concept;

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
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.concept.ConceptVersionBI;
import org.ihtsdo.tk.api.conflict.EditPathLosesStrategy;
import org.ihtsdo.tk.api.coordinate.ViewCoordinate;
import org.ihtsdo.tk.api.refex.RefexChronicleBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes;
import org.ihtsdo.tk.dto.concept.component.description.TkDescription;
import org.ihtsdo.tk.dto.concept.component.media.TkMedia;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.ihtsdo.tk.dto.concept.component.relationship.TkRelationship;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkConceptTest</code> contains tests for the class <code>{@link TkConcept}</code>.
 *
 * @generatedBy CodePro at 2/4/12 3:55 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkConceptTest {
	/**
	 * Run the TkConcept() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testTkConcept_1()
		throws Exception {

		TkConcept result = new TkConcept();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getImages());
		assertEquals(false, result.isAnnotationStyleRefex());
		assertEquals(null, result.getRefsetMembers());
		assertEquals(null, result.getConceptAttributes());
		assertEquals(null, result.getDescriptions());
		assertEquals(null, result.getPrimordialUuid());
		assertEquals(null, result.getRelationships());
	}

	/**
	 * Run the TkConcept(DataInput) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkConcept_2()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());

		TkConcept result = new TkConcept(in);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkConcept(DataInput) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkConcept_3()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());

		TkConcept result = new TkConcept(in);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkConcept(DataInput) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkConcept_4()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());

		TkConcept result = new TkConcept(in);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkConcept(ConceptChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testTkConcept_5()
		throws Exception {
		ConceptChronicleBI c = null;

		TkConcept result = new TkConcept(c);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.<init>(TkConcept.java:85)
		assertNotNull(result);
	}

	/**
	 * Run the TkConcept(ConceptChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testTkConcept_6()
		throws Exception {
		ConceptChronicleBI c = null;

		TkConcept result = new TkConcept(c);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.<init>(TkConcept.java:85)
		assertNotNull(result);
	}

	/**
	 * Run the TkConcept(ConceptChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testTkConcept_7()
		throws Exception {
		ConceptChronicleBI c = null;

		TkConcept result = new TkConcept(c);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.<init>(TkConcept.java:85)
		assertNotNull(result);
	}

	/**
	 * Run the TkConcept(ConceptChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testTkConcept_8()
		throws Exception {
		ConceptChronicleBI c = null;

		TkConcept result = new TkConcept(c);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.<init>(TkConcept.java:85)
		assertNotNull(result);
	}

	/**
	 * Run the TkConcept(ConceptChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testTkConcept_9()
		throws Exception {
		ConceptChronicleBI c = null;

		TkConcept result = new TkConcept(c);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.<init>(TkConcept.java:85)
		assertNotNull(result);
	}

	/**
	 * Run the TkConcept(ConceptChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testTkConcept_10()
		throws Exception {
		ConceptChronicleBI c = null;

		TkConcept result = new TkConcept(c);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.<init>(TkConcept.java:85)
		assertNotNull(result);
	}

	/**
	 * Run the TkConcept(ConceptChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testTkConcept_11()
		throws Exception {
		ConceptChronicleBI c = null;

		TkConcept result = new TkConcept(c);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.<init>(TkConcept.java:85)
		assertNotNull(result);
	}

	/**
	 * Run the TkConcept(ConceptChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testTkConcept_12()
		throws Exception {
		ConceptChronicleBI c = null;

		TkConcept result = new TkConcept(c);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.<init>(TkConcept.java:85)
		assertNotNull(result);
	}

	/**
	 * Run the TkConcept(ConceptChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testTkConcept_13()
		throws Exception {
		ConceptChronicleBI c = null;

		TkConcept result = new TkConcept(c);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.<init>(TkConcept.java:85)
		assertNotNull(result);
	}

	/**
	 * Run the TkConcept(ConceptChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testTkConcept_14()
		throws Exception {
		ConceptChronicleBI c = null;

		TkConcept result = new TkConcept(c);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.<init>(TkConcept.java:85)
		assertNotNull(result);
	}

	/**
	 * Run the TkConcept(ConceptChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testTkConcept_15()
		throws Exception {
		ConceptChronicleBI c = null;

		TkConcept result = new TkConcept(c);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.<init>(TkConcept.java:85)
		assertNotNull(result);
	}

	/**
	 * Run the TkConcept(ConceptChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testTkConcept_16()
		throws Exception {
		ConceptChronicleBI c = null;

		TkConcept result = new TkConcept(c);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.<init>(TkConcept.java:85)
		assertNotNull(result);
	}

	/**
	 * Run the TkConcept(ConceptChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testTkConcept_17()
		throws Exception {
		ConceptChronicleBI c = null;

		TkConcept result = new TkConcept(c);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.<init>(TkConcept.java:85)
		assertNotNull(result);
	}

	/**
	 * Run the TkConcept(ConceptChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testTkConcept_18()
		throws Exception {
		ConceptChronicleBI c = null;

		TkConcept result = new TkConcept(c);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.<init>(TkConcept.java:85)
		assertNotNull(result);
	}

	/**
	 * Run the TkConcept(ConceptChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testTkConcept_19()
		throws Exception {
		ConceptChronicleBI c = null;

		TkConcept result = new TkConcept(c);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.<init>(TkConcept.java:85)
		assertNotNull(result);
	}

	/**
	 * Run the TkConcept(ConceptChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testTkConcept_20()
		throws Exception {
		ConceptChronicleBI c = null;

		TkConcept result = new TkConcept(c);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.<init>(TkConcept.java:85)
		assertNotNull(result);
	}

	/**
	 * Run the TkConcept(TkConcept,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testTkConcept_21()
		throws Exception {
		TkConcept another = new TkConcept();
		another.setRelationships(new LinkedList());
		another.setDescriptions(new LinkedList());
		another.setAnnotationStyleRefex(true);
		another.setConceptAttributes(new TkConceptAttributes());
		another.setPrimordialUuid(UUID.randomUUID());
		another.setImages(new LinkedList());
		another.setRefsetMembers(new LinkedList());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkConcept result = new TkConcept(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.isAnnotationStyleRefex());
		assertEquals(null, result.getPrimordialUuid());
	}

	/**
	 * Run the TkConcept(TkConcept,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testTkConcept_22()
		throws Exception {
		TkConcept another = new TkConcept();
		another.setRelationships(new LinkedList());
		another.setDescriptions(new LinkedList());
		another.setAnnotationStyleRefex(true);
		another.setConceptAttributes((TkConceptAttributes) null);
		another.setPrimordialUuid(UUID.randomUUID());
		another.setImages(new LinkedList());
		another.setRefsetMembers(new LinkedList());
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkConcept result = new TkConcept(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.isAnnotationStyleRefex());
		assertEquals(null, result.getConceptAttributes());
		assertEquals(null, result.getPrimordialUuid());
	}

	/**
	 * Run the TkConcept(TkConcept,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testTkConcept_23()
		throws Exception {
		TkConcept another = new TkConcept();
		another.setRelationships(null);
		another.setDescriptions(null);
		another.setAnnotationStyleRefex(true);
		another.setConceptAttributes(new TkConceptAttributes());
		another.setPrimordialUuid(UUID.randomUUID());
		another.setImages(new LinkedList());
		another.setRefsetMembers(null);
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkConcept result = new TkConcept(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.isAnnotationStyleRefex());
		assertEquals(null, result.getRefsetMembers());
		assertEquals(null, result.getDescriptions());
		assertEquals(null, result.getPrimordialUuid());
		assertEquals(null, result.getRelationships());
	}

	/**
	 * Run the TkConcept(TkConcept,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testTkConcept_24()
		throws Exception {
		TkConcept another = new TkConcept();
		another.setRelationships(null);
		another.setDescriptions(null);
		another.setAnnotationStyleRefex(true);
		another.setConceptAttributes((TkConceptAttributes) null);
		another.setPrimordialUuid(UUID.randomUUID());
		another.setImages(new LinkedList());
		another.setRefsetMembers(null);
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkConcept result = new TkConcept(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.isAnnotationStyleRefex());
		assertEquals(null, result.getRefsetMembers());
		assertEquals(null, result.getConceptAttributes());
		assertEquals(null, result.getDescriptions());
		assertEquals(null, result.getPrimordialUuid());
		assertEquals(null, result.getRelationships());
	}

	/**
	 * Run the TkConcept(TkConcept,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testTkConcept_25()
		throws Exception {
		TkConcept another = new TkConcept();
		another.setRelationships(null);
		another.setDescriptions(new LinkedList());
		another.setAnnotationStyleRefex(true);
		another.setConceptAttributes(new TkConceptAttributes());
		another.setPrimordialUuid(UUID.randomUUID());
		another.setImages(null);
		another.setRefsetMembers(null);
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkConcept result = new TkConcept(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getImages());
		assertEquals(true, result.isAnnotationStyleRefex());
		assertEquals(null, result.getRefsetMembers());
		assertEquals(null, result.getPrimordialUuid());
		assertEquals(null, result.getRelationships());
	}

	/**
	 * Run the TkConcept(TkConcept,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testTkConcept_26()
		throws Exception {
		TkConcept another = new TkConcept();
		another.setRelationships(null);
		another.setDescriptions(new LinkedList());
		another.setAnnotationStyleRefex(true);
		another.setConceptAttributes((TkConceptAttributes) null);
		another.setPrimordialUuid(UUID.randomUUID());
		another.setImages(null);
		another.setRefsetMembers(null);
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkConcept result = new TkConcept(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getImages());
		assertEquals(true, result.isAnnotationStyleRefex());
		assertEquals(null, result.getRefsetMembers());
		assertEquals(null, result.getConceptAttributes());
		assertEquals(null, result.getPrimordialUuid());
		assertEquals(null, result.getRelationships());
	}

	/**
	 * Run the TkConcept(TkConcept,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testTkConcept_27()
		throws Exception {
		TkConcept another = new TkConcept();
		another.setRelationships(null);
		another.setDescriptions(null);
		another.setAnnotationStyleRefex(true);
		another.setConceptAttributes(new TkConceptAttributes());
		another.setPrimordialUuid(UUID.randomUUID());
		another.setImages(null);
		another.setRefsetMembers(null);
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkConcept result = new TkConcept(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getImages());
		assertEquals(true, result.isAnnotationStyleRefex());
		assertEquals(null, result.getRefsetMembers());
		assertEquals(null, result.getDescriptions());
		assertEquals(null, result.getPrimordialUuid());
		assertEquals(null, result.getRelationships());
	}

	/**
	 * Run the TkConcept(TkConcept,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testTkConcept_28()
		throws Exception {
		TkConcept another = new TkConcept();
		another.setRelationships(null);
		another.setDescriptions(null);
		another.setAnnotationStyleRefex(true);
		another.setConceptAttributes((TkConceptAttributes) null);
		another.setPrimordialUuid(UUID.randomUUID());
		another.setImages(null);
		another.setRefsetMembers(null);
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkConcept result = new TkConcept(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getImages());
		assertEquals(true, result.isAnnotationStyleRefex());
		assertEquals(null, result.getRefsetMembers());
		assertEquals(null, result.getConceptAttributes());
		assertEquals(null, result.getDescriptions());
		assertEquals(null, result.getPrimordialUuid());
		assertEquals(null, result.getRelationships());
	}

	/**
	 * Run the TkConcept(ConceptVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testTkConcept_29()
		throws Exception {
		ConceptVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkConcept result = new TkConcept(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.<init>(TkConcept.java:214)
		//       at org.ihtsdo.tk.dto.concept.TkConcept.<init>(TkConcept.java:204)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());
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
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testEquals_2()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());
		TkConcept obj = new TkConcept();
		obj.setConceptAttributes(new TkConceptAttributes());

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.equals(TkComponent.java:181)
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.equals(TkConceptAttributes.java:102)
		//       at org.ihtsdo.tk.dto.concept.TkConcept.equals(TkConcept.java:327)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testEquals_3()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());
		TkConcept obj = new TkConcept();
		obj.setDescriptions(new LinkedList());
		obj.setConceptAttributes(new TkConceptAttributes());

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.equals(TkComponent.java:181)
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.equals(TkConceptAttributes.java:102)
		//       at org.ihtsdo.tk.dto.concept.TkConcept.equals(TkConcept.java:327)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(null);
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes((TkConceptAttributes) null);
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());
		TkConcept obj = new TkConcept();
		obj.setDescriptions(null);
		obj.setRelationships(new LinkedList());
		obj.setConceptAttributes((TkConceptAttributes) null);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(null);
		fixture.setDescriptions(null);
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes((TkConceptAttributes) null);
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());
		TkConcept obj = new TkConcept();
		obj.setDescriptions(null);
		obj.setRelationships(null);
		obj.setConceptAttributes((TkConceptAttributes) null);
		obj.setImages(new LinkedList());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(null);
		fixture.setDescriptions(null);
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes((TkConceptAttributes) null);
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(null);
		fixture.setRefsetMembers(new LinkedList());
		TkConcept obj = new TkConcept();
		obj.setDescriptions(null);
		obj.setRelationships(null);
		obj.setConceptAttributes((TkConceptAttributes) null);
		obj.setImages(null);
		obj.setRefsetMembers(new LinkedList());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes((TkConceptAttributes) null);
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());
		TkConcept obj = new TkConcept();
		obj.setDescriptions(new LinkedList());
		obj.setRelationships(new LinkedList());
		obj.setConceptAttributes((TkConceptAttributes) null);
		obj.setImages(new LinkedList());
		obj.setRefsetMembers(new LinkedList());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testEquals_8()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(null);
		fixture.setDescriptions(null);
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes((TkConceptAttributes) null);
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(null);
		fixture.setRefsetMembers(null);
		TkConcept obj = new TkConcept();
		obj.setDescriptions(null);
		obj.setRelationships(null);
		obj.setConceptAttributes((TkConceptAttributes) null);
		obj.setImages(null);
		obj.setRefsetMembers(null);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testEquals_9()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the TkConceptAttributes getConceptAttributes() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testGetConceptAttributes_1()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());

		TkConceptAttributes result = fixture.getConceptAttributes();

		// add additional test code here
		assertNotNull(result);
		assertEquals(false, result.isDefined());
		assertEquals(null, result.getRevisionList());
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
	 * Run the List<TkDescription> getDescriptions() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testGetDescriptions_1()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());

		List<TkDescription> result = fixture.getDescriptions();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the List<TkMedia> getImages() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testGetImages_1()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());

		List<TkMedia> result = fixture.getImages();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the UUID getPrimordialUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testGetPrimordialUuid_1()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());

		UUID result = fixture.getPrimordialUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("cf1aead5-919f-438f-a564-21ca18587258", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-3523245555471924337L, result.getMostSignificantBits());
		assertEquals(-6529056407904816552L, result.getLeastSignificantBits());
	}

	/**
	 * Run the List<TkRelationship> getRelationships() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testGetRelationships_1()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());

		List<TkRelationship> result = fixture.getRelationships();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());

		int result = fixture.hashCode();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.hashCode(TkConcept.java:390)
		assertEquals(0, result);
	}

	/**
	 * Run the boolean isAnnotationStyleRefex() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testIsAnnotationStyleRefex_1()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());

		boolean result = fixture.isAnnotationStyleRefex();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isAnnotationStyleRefex() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testIsAnnotationStyleRefex_2()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(false);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());

		boolean result = fixture.isAnnotationStyleRefex();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the void setAnnotationStyleRefex(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testSetAnnotationStyleRefex_1()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());
		boolean annotationStyleRefex = true;

		fixture.setAnnotationStyleRefex(annotationStyleRefex);

		// add additional test code here
	}

	/**
	 * Run the void setConceptAttributes(TkConceptAttributes) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testSetConceptAttributes_1()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());
		TkConceptAttributes conceptAttributes = new TkConceptAttributes();

		fixture.setConceptAttributes(conceptAttributes);

		// add additional test code here
	}

	/**
	 * Run the void setDescriptions(List<TkDescription>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testSetDescriptions_1()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());
		List<TkDescription> descriptions = new LinkedList();

		fixture.setDescriptions(descriptions);

		// add additional test code here
	}

	/**
	 * Run the void setImages(List<TkMedia>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testSetImages_1()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());
		List<TkMedia> images = new LinkedList();

		fixture.setImages(images);

		// add additional test code here
	}

	/**
	 * Run the void setPrimordialUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testSetPrimordialUuid_1()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());
		UUID primordialUuid = UUID.randomUUID();

		fixture.setPrimordialUuid(primordialUuid);

		// add additional test code here
	}

	/**
	 * Run the void setRelationships(List<TkRelationship>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testSetRelationships_1()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());
		List<TkRelationship> relationships = new LinkedList();

		fixture.setRelationships(relationships);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes((TkConceptAttributes) null);
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(new LinkedList());
		fixture.setRefsetMembers(new LinkedList());

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkConcept: \n   primordial UUID: 14fdbd79-ebfa-4b17-8b8a-64a5d6c71221\n   ConceptAttributes: \n          none\n\n   Descriptions: \n\n   Relationships: \n\n   RefsetMembers: \n\n   Media: \n", result);
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testToString_2()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(null);
		fixture.setDescriptions(null);
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(null);
		fixture.setRefsetMembers(null);

		String result = fixture.toString();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.informAboutUuid(TkRevision.java:173)
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.toString(TkRevision.java:243)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.toString(TkComponent.java:393)
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.toString(TkConceptAttributes.java:152)
		//       at java.lang.String.valueOf(String.java:2826)
		//       at java.lang.StringBuilder.append(StringBuilder.java:115)
		//       at org.ihtsdo.tk.dto.concept.TkConcept.toString(TkConcept.java:555)
		assertNotNull(result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testWriteExternal_1()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(new LinkedList());
		fixture.setDescriptions(null);
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid((UUID) null);
		fixture.setImages(null);
		fixture.setRefsetMembers(null);
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.writeExternal(TkConcept.java:617)
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testWriteExternal_2()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(null);
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid((UUID) null);
		fixture.setImages(null);
		fixture.setRefsetMembers(null);
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.writeExternal(TkConcept.java:617)
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testWriteExternal_3()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(null);
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(null);
		fixture.setRefsetMembers(null);
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.writeExternal(TkRevision.java:259)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.writeExternal(TkComponent.java:438)
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.writeExternal(TkConceptAttributes.java:159)
		//       at org.ihtsdo.tk.dto.concept.TkConcept.writeExternal(TkConcept.java:624)
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(null);
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes((TkConceptAttributes) null);
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(null);
		fixture.setRefsetMembers(null);
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testWriteExternal_5()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(null);
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid((UUID) null);
		fixture.setImages(null);
		fixture.setRefsetMembers(null);
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.writeExternal(TkConcept.java:617)
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testWriteExternal_6()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(null);
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(null);
		fixture.setRefsetMembers(null);
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.writeExternal(TkRevision.java:259)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.writeExternal(TkComponent.java:438)
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.writeExternal(TkConceptAttributes.java:159)
		//       at org.ihtsdo.tk.dto.concept.TkConcept.writeExternal(TkConcept.java:624)
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(null);
		fixture.setDescriptions(new LinkedList());
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes((TkConceptAttributes) null);
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(null);
		fixture.setRefsetMembers(null);
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testWriteExternal_8()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(null);
		fixture.setDescriptions(null);
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid((UUID) null);
		fixture.setImages(null);
		fixture.setRefsetMembers(null);
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.TkConcept.writeExternal(TkConcept.java:617)
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
        @Ignore
	public void testWriteExternal_9()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(null);
		fixture.setDescriptions(null);
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes(new TkConceptAttributes());
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(null);
		fixture.setRefsetMembers(null);
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());

		fixture.writeExternal(out);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.writeExternal(TkRevision.java:259)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.writeExternal(TkComponent.java:438)
		//       at org.ihtsdo.tk.dto.concept.component.attribute.TkConceptAttributes.writeExternal(TkConceptAttributes.java:159)
		//       at org.ihtsdo.tk.dto.concept.TkConcept.writeExternal(TkConcept.java:624)
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	@Test
	public void testWriteExternal_10()
		throws Exception {
		TkConcept fixture = new TkConcept();
		fixture.setRelationships(null);
		fixture.setDescriptions(null);
		fixture.setAnnotationStyleRefex(true);
		fixture.setConceptAttributes((TkConceptAttributes) null);
		fixture.setPrimordialUuid(UUID.randomUUID());
		fixture.setImages(null);
		fixture.setRefsetMembers(null);
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
	 * @generatedBy CodePro at 2/4/12 3:55 PM
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
	 * @generatedBy CodePro at 2/4/12 3:55 PM
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
	 * @generatedBy CodePro at 2/4/12 3:55 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkConceptTest.class);
	}
}