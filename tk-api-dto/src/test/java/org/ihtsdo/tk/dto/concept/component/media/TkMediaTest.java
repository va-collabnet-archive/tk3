package org.ihtsdo.tk.dto.concept.component.media;

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
import org.ihtsdo.tk.api.media.MediaChronicleBI;
import org.ihtsdo.tk.api.media.MediaVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkMediaTest</code> contains tests for the class <code>{@link TkMedia}</code>.
 *
 * @generatedBy CodePro at 2/4/12 5:02 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkMediaTest {
	/**
	 * Run the TkMedia() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testTkMedia_1()
		throws Exception {

		TkMedia result = new TkMedia();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getDataBytes());
		assertEquals(null, result.getFormat());
		assertEquals(null, result.getRevisionList());
		assertEquals(null, result.getTextDescription());
		assertEquals(null, result.getConceptUuid());
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
	 * Run the TkMedia(MediaChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
        @Ignore
	public void testTkMedia_2()
		throws Exception {
		MediaChronicleBI another = null;

		TkMedia result = new TkMedia(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.media.TkMedia.<init>(TkMedia.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the TkMedia(MediaChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
        @Ignore
	public void testTkMedia_3()
		throws Exception {
		MediaChronicleBI another = null;

		TkMedia result = new TkMedia(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.media.TkMedia.<init>(TkMedia.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the TkMedia(MediaChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
        @Ignore
	public void testTkMedia_4()
		throws Exception {
		MediaChronicleBI another = null;

		TkMedia result = new TkMedia(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.media.TkMedia.<init>(TkMedia.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the TkMedia(MediaChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
        @Ignore
	public void testTkMedia_5()
		throws Exception {
		MediaChronicleBI another = null;

		TkMedia result = new TkMedia(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.media.TkMedia.<init>(TkMedia.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the TkMedia(MediaChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
        @Ignore
	public void testTkMedia_6()
		throws Exception {
		MediaChronicleBI another = null;

		TkMedia result = new TkMedia(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.media.TkMedia.<init>(TkMedia.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the TkMedia(MediaChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
        @Ignore
	public void testTkMedia_7()
		throws Exception {
		MediaChronicleBI another = null;

		TkMedia result = new TkMedia(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.media.TkMedia.<init>(TkMedia.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the TkMedia(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkMedia_8()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkMedia result = new TkMedia(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkMedia(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkMedia_9()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkMedia result = new TkMedia(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkMedia(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkMedia_10()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkMedia result = new TkMedia(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkMedia(TkMedia,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testTkMedia_11()
		throws Exception {
		TkMedia another = new TkMedia();
		another.setTextDescription("");
		another.setTypeUuid(UUID.randomUUID());
		another.setConceptUuid(UUID.randomUUID());
		another.setFormat("");
		another.setDataBytes(new byte[] {});
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;

		TkMedia result = new TkMedia(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getFormat());
		assertEquals(null, result.getRevisionList());
		assertEquals("", result.getTextDescription());
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
	 * Run the TkMedia(TkMedia,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testTkMedia_12()
		throws Exception {
		TkMedia another = new TkMedia();
		another.setTextDescription("");
		another.setTypeUuid(UUID.randomUUID());
		another.setConceptUuid(UUID.randomUUID());
		another.setFormat("");
		another.setDataBytes(new byte[] {});
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkMedia result = new TkMedia(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getFormat());
		assertEquals(null, result.getRevisionList());
		assertEquals("", result.getTextDescription());
		assertEquals(null, result.getConceptUuid());
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
	 * Run the TkMedia(MediaVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
        @Ignore
	public void testTkMedia_13()
		throws Exception {
		MediaVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkMedia result = new TkMedia(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.media.TkMedia.<init>(TkMedia.java:90)
		assertNotNull(result);
	}

	/**
	 * Run the TkMedia(MediaVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
        @Ignore
	public void testTkMedia_14()
		throws Exception {
		MediaVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkMedia result = new TkMedia(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.media.TkMedia.<init>(TkMedia.java:90)
		assertNotNull(result);
	}

	/**
	 * Run the TkMedia(MediaVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
        @Ignore
	public void testTkMedia_15()
		throws Exception {
		MediaVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkMedia result = new TkMedia(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.media.TkMedia.<init>(TkMedia.java:90)
		assertNotNull(result);
	}

	/**
	 * Run the TkMedia(MediaVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
        @Ignore
	public void testTkMedia_16()
		throws Exception {
		MediaVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkMedia result = new TkMedia(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.media.TkMedia.<init>(TkMedia.java:90)
		assertNotNull(result);
	}

	/**
	 * Run the TkMedia(MediaVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
        @Ignore
	public void testTkMedia_17()
		throws Exception {
		MediaVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = false;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkMedia result = new TkMedia(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:75)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.media.TkMedia.<init>(TkMedia.java:90)
		assertNotNull(result);
	}

	/**
	 * Run the TkMedia(MediaVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
        @Ignore
	public void testTkMedia_18()
		throws Exception {
		MediaVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkMedia result = new TkMedia(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.media.TkMedia.<init>(TkMedia.java:90)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		TkMedia obj = new TkMedia();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		TkMedia obj = new TkMedia();
		obj.setConceptUuid(UUID.randomUUID());
		obj.setFormat("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		TkMedia obj = new TkMedia();
		obj.setConceptUuid(UUID.randomUUID());
		obj.setFormat("");
		obj.setDataBytes(new byte[] {});

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		TkMedia obj = new TkMedia();
		obj.setTextDescription("");
		obj.setConceptUuid(UUID.randomUUID());
		obj.setFormat("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		TkMedia obj = new TkMedia();
		obj.setTextDescription("");
		obj.setTypeUuid(UUID.randomUUID());
		obj.setConceptUuid(UUID.randomUUID());
		obj.setFormat("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		TkMedia obj = new TkMedia();
		obj.setConceptUuid(UUID.randomUUID());
		obj.setFormat("");
		obj.setDataBytes(new byte[] {});

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testEquals_8()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		TkMedia obj = new TkMedia();
		obj.setTextDescription("");
		obj.setTypeUuid(UUID.randomUUID());
		obj.setConceptUuid(UUID.randomUUID());
		obj.setFormat("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testEquals_9()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
        @Ignore
	public void testGetConceptUuid_1()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		UUID result = fixture.getConceptUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("2f9da025-6354-4481-bdf7-5475d15d0244", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(3431074573566887041L, result.getMostSignificantBits());
		assertEquals(-4758241616293199292L, result.getLeastSignificantBits());
	}

	/**
	 * Run the byte[] getDataBytes() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testGetDataBytes_1()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		byte[] result = fixture.getDataBytes();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.length);
	}

	/**
	 * Run the String getFormat() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testGetFormat_1()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.getFormat();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the List<TkMediaRevision> getRevisionList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testGetRevisionList_1()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		List<TkMediaRevision> result = fixture.getRevisionList();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getTextDescription() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testGetTextDescription_1()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.getTextDescription();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the UUID getTypeUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
        @Ignore
	public void testGetTypeUuid_1()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		UUID result = fixture.getTypeUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals("16b8401e-7002-41b6-97b2-f8cf95ae1334", result.toString());
		assertEquals(2, result.variant());
		assertEquals(4, result.version());
		assertEquals(1637128964021567926L, result.getMostSignificantBits());
		assertEquals(-7515671257674804428L, result.getLeastSignificantBits());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(1552038471, result);
	}

	/**
	 * Run the TkMedia makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkMedia result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getFormat());
		assertEquals("", result.getTextDescription());
		assertEquals(null, result.getConceptUuid());
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_9()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_10()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_11()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_12()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_13()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_14()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_15()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_16()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testSetConceptUuid_1()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		UUID conceptUuid = UUID.randomUUID();

		fixture.setConceptUuid(conceptUuid);

		// add additional test code here
	}

	/**
	 * Run the void setDataBytes(byte[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testSetDataBytes_1()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		byte[] data = new byte[] {};

		fixture.setDataBytes(data);

		// add additional test code here
	}

	/**
	 * Run the void setFormat(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testSetFormat_1()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		String format = "";

		fixture.setFormat(format);

		// add additional test code here
	}

	/**
	 * Run the void setTextDescription(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testSetTextDescription_1()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		String textDescription = "";

		fixture.setTextDescription(textDescription);

		// add additional test code here
	}

	/**
	 * Run the void setTypeUuid(UUID) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testSetTypeUuid_1()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();
		UUID typeUuid = UUID.randomUUID();

		fixture.setTypeUuid(typeUuid);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		fixture.authorUuid = UUID.randomUUID();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkMedia:  concept:b88aca5e-c72a-43a7-82f0-b01a5b4f18fd format:'' image: desc:'' type:0ee5fa59-bc25-4cf1-9044-fdd8aa6f8855  primordial:72dbf57e-551e-4450-80a8-d1e8005033aa xtraIds:[] s:5563535f-dc2b-4322-a503-821cf93601eb a:cb0db649-0889-4dcd-a4b5-7a8bb60d2ada p:c045a32e-cda4-4639-b203-5ddb0fc3d53f t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testWriteExternal_8()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testWriteExternal_9()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testWriteExternal_10()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = null;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testWriteExternal_11()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testWriteExternal_12()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testWriteExternal_13()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testWriteExternal_14()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	@Test
	public void testWriteExternal_15()
		throws Exception {
		TkMedia fixture = new TkMedia();
		fixture.setFormat("");
		fixture.setDataBytes(new byte[] {});
		fixture.setTextDescription("");
		fixture.setTypeUuid(UUID.randomUUID());
		fixture.setConceptUuid(UUID.randomUUID());
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.time = 1L;
		fixture.revisions = null;
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
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
	 * @generatedBy CodePro at 2/4/12 5:02 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkMediaTest.class);
	}
}