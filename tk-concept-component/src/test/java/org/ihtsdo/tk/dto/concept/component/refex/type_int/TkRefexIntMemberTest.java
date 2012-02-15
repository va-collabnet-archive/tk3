package org.ihtsdo.tk.dto.concept.component.refex.type_int;

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
import org.ihtsdo.tk.api.refex.type_int.RefexIntVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexIntMemberTest</code> contains tests for the class <code>{@link TkRefexIntMember}</code>.
 *
 * @generatedBy CodePro at 2/4/12 4:30 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexIntMemberTest {
	/**
	 * Run the TkRefexIntMember() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testTkRefexIntMember_1()
		throws Exception {

		TkRefexIntMember result = new TkRefexIntMember();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getIntValue());
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
	 * Run the TkRefexIntMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
        @Ignore
	public void testTkRefexIntMember_2()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexIntMember result = new TkRefexIntMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_int.TkRefexIntMember.<init>(TkRefexIntMember.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexIntMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
        @Ignore
	public void testTkRefexIntMember_3()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexIntMember result = new TkRefexIntMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_int.TkRefexIntMember.<init>(TkRefexIntMember.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexIntMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
        @Ignore
	public void testTkRefexIntMember_4()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexIntMember result = new TkRefexIntMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_int.TkRefexIntMember.<init>(TkRefexIntMember.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexIntMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
        @Ignore
	public void testTkRefexIntMember_5()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexIntMember result = new TkRefexIntMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_int.TkRefexIntMember.<init>(TkRefexIntMember.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexIntMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexIntMember_6()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexIntMember result = new TkRefexIntMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexIntMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexIntMember_7()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexIntMember result = new TkRefexIntMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexIntMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexIntMember_8()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexIntMember result = new TkRefexIntMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexIntMember(TkRefexIntMember,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testTkRefexIntMember_9()
		throws Exception {
		TkRefexIntMember another = new TkRefexIntMember();
		another.setIntValue(1);
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexIntMember result = new TkRefexIntMember(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getIntValue());
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
	 * Run the TkRefexIntMember(RefexIntVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
        @Ignore
	public void testTkRefexIntMember_10()
		throws Exception {
		RefexIntVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexIntMember result = new TkRefexIntMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_int.TkRefexIntMember.<init>(TkRefexIntMember.java:72)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		TkRefexIntMember obj = new TkRefexIntMember();
		obj.setIntValue(1);

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		TkRefexIntMember obj = new TkRefexIntMember();
		obj.setIntValue(1);
		obj.revisions = new LinkedList();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = null;
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		TkRefexIntMember obj = new TkRefexIntMember();
		obj.setIntValue(1);
		obj.revisions = null;

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		TkRefexIntMember obj = new TkRefexIntMember();
		obj.setIntValue(1);
		obj.revisions = new LinkedList();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the int getIntValue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testGetIntValue_1()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();

		int result = fixture.getIntValue();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the List<TkRefexIntRevision> getRevisionList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testGetRevisionList_1()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();

		List<TkRefexIntRevision> result = fixture.getRevisionList();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the TK_REFEX_TYPE getType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testGetType_1()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();

		TK_REFEX_TYPE result = fixture.getType();

		// add additional test code here
		assertNotNull(result);
		assertEquals(7, result.getTypeToken());
		assertEquals("INT", result.name());
		assertEquals("INT", result.toString());
		assertEquals(6, result.ordinal());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(-455245166, result);
	}

	/**
	 * Run the TkRefexIntMember makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexIntMember result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getIntValue());
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
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_9()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		fixture.readExternal(in, dataVersion);

		// add additional test code here
	}

	/**
	 * Run the void setIntValue(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testSetIntValue_1()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();
		int intValue = 1;

		fixture.setIntValue(intValue);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
		fixture.additionalIds = new LinkedList();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexIntMember:  int: 1  refex:02d51d82-b1a0-4cf6-a501-3206359c1baf component:8e6374dc-7e40-4416-bf98-e044f9aad3eb  primordial:8a115fe4-b80d-445d-bcfb-f1193e043cd4 xtraIds:[] s:f1b60260-28dd-4ff7-b5d5-38cfc1446aab a:c375cede-1cf8-4696-bdd8-5c38fd9e74ef p:01af6bd3-ff20-4943-adf9-b26e6fde837b t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = null;
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = new LinkedList();
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	@Test
	public void testWriteExternal_8()
		throws Exception {
		TkRefexIntMember fixture = new TkRefexIntMember();
		fixture.setIntValue(1);
		fixture.primordialUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.statusUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.annotations = new LinkedList();
		fixture.revisions = null;
		fixture.componentUuid = UUID.randomUUID();
		fixture.authorUuid = UUID.randomUUID();
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
	 * @generatedBy CodePro at 2/4/12 4:30 PM
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
	 * @generatedBy CodePro at 2/4/12 4:30 PM
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
	 * @generatedBy CodePro at 2/4/12 4:30 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexIntMemberTest.class);
	}
}