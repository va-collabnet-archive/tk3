package org.ihtsdo.tk.dto.concept.component.refex.type_long;

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
import org.ihtsdo.tk.api.refex.type_long.RefexLongVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexLongMemberTest</code> contains tests for the class <code>{@link TkRefexLongMember}</code>.
 *
 * @generatedBy CodePro at 2/4/12 5:14 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexLongMemberTest {
	/**
	 * Run the TkRefexLongMember() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
	public void testTkRefexLongMember_1()
		throws Exception {

		TkRefexLongMember result = new TkRefexLongMember();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0L, result.getLongValue());
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
	 * Run the TkRefexLongMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
        @Ignore
	public void testTkRefexLongMember_2()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexLongMember result = new TkRefexLongMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_long.TkRefexLongMember.<init>(TkRefexLongMember.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexLongMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
        @Ignore
	public void testTkRefexLongMember_3()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexLongMember result = new TkRefexLongMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_long.TkRefexLongMember.<init>(TkRefexLongMember.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexLongMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
        @Ignore
	public void testTkRefexLongMember_4()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexLongMember result = new TkRefexLongMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_long.TkRefexLongMember.<init>(TkRefexLongMember.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexLongMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
        @Ignore
	public void testTkRefexLongMember_5()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexLongMember result = new TkRefexLongMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_long.TkRefexLongMember.<init>(TkRefexLongMember.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexLongMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexLongMember_6()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexLongMember result = new TkRefexLongMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexLongMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexLongMember_7()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexLongMember result = new TkRefexLongMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexLongMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexLongMember_8()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexLongMember result = new TkRefexLongMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexLongMember(TkRefexLongMember,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
	public void testTkRefexLongMember_9()
		throws Exception {
		TkRefexLongMember another = new TkRefexLongMember();
		another.setLongValue(1L);
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexLongMember result = new TkRefexLongMember(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1L, result.getLongValue());
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
	 * Run the TkRefexLongMember(RefexLongVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
        @Ignore
	public void testTkRefexLongMember_10()
		throws Exception {
		RefexLongVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexLongMember result = new TkRefexLongMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_long.TkRefexLongMember.<init>(TkRefexLongMember.java:70)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		TkRefexLongMember obj = new TkRefexLongMember();
		obj.setLongValue(1L);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		TkRefexLongMember obj = new TkRefexLongMember();
		obj.setLongValue(1L);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		TkRefexLongMember obj = new TkRefexLongMember();
		obj.setLongValue(1L);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the long getLongValue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
	public void testGetLongValue_1()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();

		long result = fixture.getLongValue();

		// add additional test code here
		assertEquals(1L, result);
	}

	/**
	 * Run the List<TkRefexLongRevision> getRevisionList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
	public void testGetRevisionList_1()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();

		List<TkRefexLongRevision> result = fixture.getRevisionList();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the TK_REFEX_TYPE getType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
	public void testGetType_1()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();

		TK_REFEX_TYPE result = fixture.getType();

		// add additional test code here
		assertNotNull(result);
		assertEquals(13, result.getTypeToken());
		assertEquals("LONG", result.name());
		assertEquals("LONG", result.toString());
		assertEquals(12, result.ordinal());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(973549011, result);
	}

	/**
	 * Run the TkRevision makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_9()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setLongValue(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
	public void testSetLongValue_1()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		long longValue = 1L;

		fixture.setLongValue(longValue);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexLongMember:  long:1  refex:3558b9aa-c81f-4213-bd1f-f5093b2e4f96 component:db3b3d0e-7408-49ca-b3b2-03285fcae651  primordial:f1e13eba-c4b4-48b1-aca8-426d6f8b6c83 xtraIds:[] s:aa49bff9-c4c0-401d-8daf-2a4ba4b5721b a:d617f01f-7509-4453-9a55-10f40d5c9195 p:04736e91-e166-4376-b31b-2ef836689da4 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = null;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = new LinkedList();
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	@Test
	public void testWriteExternal_8()
		throws Exception {
		TkRefexLongMember fixture = new TkRefexLongMember();
		fixture.setLongValue(1L);
		fixture.annotations = new LinkedList();
		fixture.refexUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.componentUuid = UUID.randomUUID();
		fixture.revisions = null;
		fixture.pathUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 5:14 PM
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
	 * @generatedBy CodePro at 2/4/12 5:14 PM
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
	 * @generatedBy CodePro at 2/4/12 5:14 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexLongMemberTest.class);
	}
}