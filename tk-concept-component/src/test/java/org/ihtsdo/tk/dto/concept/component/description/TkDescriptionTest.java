package org.ihtsdo.tk.dto.concept.component.description;

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
import org.ihtsdo.tk.api.description.DescriptionChronicleBI;
import org.ihtsdo.tk.api.description.DescriptionVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkDescriptionTest</code> contains tests for the class <code>{@link TkDescription}</code>.
 *
 * @generatedBy CodePro at 2/4/12 5:05 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkDescriptionTest {
	/**
	 * Run the TkDescription() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testTkDescription_1()
		throws Exception {

		TkDescription result = new TkDescription();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getText());
		assertEquals(null, result.getRevisionList());
		assertEquals(null, result.getConceptUuid());
		assertEquals(null, result.getTypeUuid());
		assertEquals(false, result.isInitialCaseSignificant());
		assertEquals(null, result.getLang());
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
	 * Run the TkDescription(DescriptionChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
        @Ignore
	public void testTkDescription_2()
		throws Exception {
		DescriptionChronicleBI desc = null;

		TkDescription result = new TkDescription(desc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.description.TkDescription.<init>(TkDescription.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the TkDescription(DescriptionChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
        @Ignore
	public void testTkDescription_3()
		throws Exception {
		DescriptionChronicleBI desc = null;

		TkDescription result = new TkDescription(desc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.description.TkDescription.<init>(TkDescription.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the TkDescription(DescriptionChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
        @Ignore
	public void testTkDescription_4()
		throws Exception {
		DescriptionChronicleBI desc = null;

		TkDescription result = new TkDescription(desc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.description.TkDescription.<init>(TkDescription.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the TkDescription(DescriptionChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
        @Ignore
	public void testTkDescription_5()
		throws Exception {
		DescriptionChronicleBI desc = null;

		TkDescription result = new TkDescription(desc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.description.TkDescription.<init>(TkDescription.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the TkDescription(DescriptionChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
        @Ignore
	public void testTkDescription_6()
		throws Exception {
		DescriptionChronicleBI desc = null;

		TkDescription result = new TkDescription(desc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.description.TkDescription.<init>(TkDescription.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the TkDescription(DescriptionChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
        @Ignore
	public void testTkDescription_7()
		throws Exception {
		DescriptionChronicleBI desc = null;

		TkDescription result = new TkDescription(desc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.description.TkDescription.<init>(TkDescription.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the TkDescription(DescriptionChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
        @Ignore
	public void testTkDescription_8()
		throws Exception {
		DescriptionChronicleBI desc = null;

		TkDescription result = new TkDescription(desc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.description.TkDescription.<init>(TkDescription.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the TkDescription(DescriptionChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
        @Ignore
	public void testTkDescription_9()
		throws Exception {
		DescriptionChronicleBI desc = null;

		TkDescription result = new TkDescription(desc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.description.TkDescription.<init>(TkDescription.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the TkDescription(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkDescription_10()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkDescription result = new TkDescription(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkDescription(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkDescription_11()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkDescription result = new TkDescription(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkDescription(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkDescription_12()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkDescription result = new TkDescription(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkDescription(TkDescription,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testTkDescription_13()
		throws Exception {
		TkDescription another = new TkDescription();
		another.setTypeUuid(UUID.randomUUID());
		another.setConceptUuid(UUID.randomUUID());
		another.setInitialCaseSignificant(true);
		another.setText("");
		another.setLang("");
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkDescription result = new TkDescription(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getText());
		assertEquals(null, result.getRevisionList());
		assertEquals(true, result.isInitialCaseSignificant());
		assertEquals("", result.getLang());
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
	 * Run the TkDescription(TkDescription,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testTkDescription_14()
		throws Exception {
		TkDescription another = new TkDescription();
		another.setTypeUuid(UUID.randomUUID());
		another.setConceptUuid(UUID.randomUUID());
		another.setInitialCaseSignificant(true);
		another.setText("");
		another.setLang("");
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkDescription result = new TkDescription(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getText());
		assertEquals(null, result.getRevisionList());
		assertEquals(null, result.getConceptUuid());
		assertEquals(null, result.getTypeUuid());
		assertEquals(true, result.isInitialCaseSignificant());
		assertEquals("", result.getLang());
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
	 * Run the TkDescription(DescriptionVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
        @Ignore
	public void testTkDescription_15()
		throws Exception {
		DescriptionVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkDescription result = new TkDescription(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.description.TkDescription.<init>(TkDescription.java:93)
		assertNotNull(result);
	}

	/**
	 * Run the TkDescription(DescriptionVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
        @Ignore
	public void testTkDescription_16()
		throws Exception {
		DescriptionVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkDescription result = new TkDescription(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.description.TkDescription.<init>(TkDescription.java:93)
		assertNotNull(result);
	}

	/**
	 * Run the TkDescription(DescriptionVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
        @Ignore
	public void testTkDescription_17()
		throws Exception {
		DescriptionVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkDescription result = new TkDescription(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.description.TkDescription.<init>(TkDescription.java:93)
		assertNotNull(result);
	}

	/**
	 * Run the TkDescription(DescriptionVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
        @Ignore
	public void testTkDescription_18()
		throws Exception {
		DescriptionVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkDescription result = new TkDescription(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.description.TkDescription.<init>(TkDescription.java:93)
		assertNotNull(result);
	}

	/**
	 * Run the TkDescription(DescriptionVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
        @Ignore
	public void testTkDescription_19()
		throws Exception {
		DescriptionVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkDescription result = new TkDescription(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.description.TkDescription.<init>(TkDescription.java:93)
		assertNotNull(result);
	}

	/**
	 * Run the TkDescription(DescriptionVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
        @Ignore
	public void testTkDescription_20()
		throws Exception {
		DescriptionVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkDescription result = new TkDescription(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.description.TkDescription.<init>(TkDescription.java:93)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();
		TkDescription obj = new TkDescription();
		obj.setConceptUuid(UUID.randomUUID());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();
		TkDescription obj = new TkDescription();
		obj.setConceptUuid(UUID.randomUUID());
		obj.setInitialCaseSignificant(true);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();
		TkDescription obj = new TkDescription();
		obj.setConceptUuid(UUID.randomUUID());
		obj.setInitialCaseSignificant(true);
		obj.setLang("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();
		TkDescription obj = new TkDescription();
		obj.setConceptUuid(UUID.randomUUID());
		obj.setInitialCaseSignificant(true);
		obj.setText("");
		obj.setLang("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();
		TkDescription obj = new TkDescription();
		obj.setTypeUuid(UUID.randomUUID());
		obj.setConceptUuid(UUID.randomUUID());
		obj.setInitialCaseSignificant(true);
		obj.setText("");
		obj.setLang("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();
		TkDescription obj = new TkDescription();
		obj.setTypeUuid(UUID.randomUUID());
		obj.setConceptUuid(UUID.randomUUID());
		obj.setInitialCaseSignificant(true);
		obj.setText("");
		obj.setLang("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testEquals_8()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();
		TkDescription obj = new TkDescription();
		obj.setTypeUuid(UUID.randomUUID());
		obj.setConceptUuid(UUID.randomUUID());
		obj.setInitialCaseSignificant(true);
		obj.setText("");
		obj.setLang("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testEquals_9()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the UUID getConceptUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
        @Ignore
	public void testGetConceptUuid_1()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();

		UUID result = fixture.getConceptUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("e0c4f25f-7ba3-46d2-8964-527960b5f7d1", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-2250407421868292398L, result.getMostSignificantBits());
		assertEquals(-8546615511575300143L, result.getLeastSignificantBits());
	}

	/**
	 * Run the String getLang() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testGetLang_1()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();

		String result = fixture.getLang();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the List<TkDescriptionRevision> getRevisionList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testGetRevisionList_1()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();

		List<TkDescriptionRevision> result = fixture.getRevisionList();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getText() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testGetText_1()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();

		String result = fixture.getText();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the UUID getTypeUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
        @Ignore
	public void testGetTypeUuid_1()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();

		UUID result = fixture.getTypeUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("c98e772f-47bd-483d-900c-6ff4fd43193e", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(-3923067180442367939L, result.getMostSignificantBits());
		assertEquals(-8066949734515664578L, result.getLeastSignificantBits());
	}

	/**
	 * Run the boolean isInitialCaseSignificant() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testIsInitialCaseSignificant_1()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();

		boolean result = fixture.isInitialCaseSignificant();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isInitialCaseSignificant() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testIsInitialCaseSignificant_2()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(false);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();

		boolean result = fixture.isInitialCaseSignificant();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the TkDescription makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkDescription result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getText());
		assertEquals(null, result.getConceptUuid());
		assertEquals(null, result.getTypeUuid());
		assertEquals(true, result.isInitialCaseSignificant());
		assertEquals("", result.getLang());
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_9()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_10()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_11()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_12()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_13()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_14()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_15()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setConceptUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testSetConceptUuid_1()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();
		UUID conceptUuid = UUID.randomUUID();

		fixture.setConceptUuid(conceptUuid);

		// add additional test code here
	}

	/**
	 * Run the void setInitialCaseSignificant(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testSetInitialCaseSignificant_1()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();
		boolean initialCaseSignificant = true;

		fixture.setInitialCaseSignificant(initialCaseSignificant);

		// add additional test code here
	}

	/**
	 * Run the void setLang(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testSetLang_1()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();
		String lang = "";

		fixture.setLang(lang);

		// add additional test code here
	}

	/**
	 * Run the void setText(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testSetText_1()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();
		String text = "";

		fixture.setText(text);

		// add additional test code here
	}

	/**
	 * Run the void setTypeUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testSetTypeUuid_1()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();
		UUID typeUuid = UUID.randomUUID();

		fixture.setTypeUuid(typeUuid);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.additionalIds = new LinkedList();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkDescription: '' concept:ebe5b24f-9f0d-4480-acc5-917c90d6ff61 ics:true lang:'' type:9a434042-609e-40a3-8938-5d954664a04a  primordial:a5695825-f5ee-464e-b752-792e751564bd xtraIds:[] s:4837624c-d4d7-4232-96cf-51e95e05843a a:d5c6ccf7-9b20-4dce-bd7a-1834a3d4eae0 p:32756906-d662-4c43-bf49-a6a229cba90d t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testWriteExternal_8()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testWriteExternal_9()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = null;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testWriteExternal_10()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testWriteExternal_11()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testWriteExternal_12()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testWriteExternal_13()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	@Test
	public void testWriteExternal_14()
		throws Exception {
		TkDescription fixture = new TkDescription();
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.setInitialCaseSignificant(true);
		fixture.setText("");
		fixture.setLang("");
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = null;
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
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
	 * @generatedBy CodePro at 2/4/12 5:05 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkDescriptionTest.class);
	}
}