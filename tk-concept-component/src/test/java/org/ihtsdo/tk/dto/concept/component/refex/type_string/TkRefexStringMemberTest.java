package org.ihtsdo.tk.dto.concept.component.refex.type_string;

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
import org.ihtsdo.tk.api.refex.type_string.RefexStringVersionBI;
import org.ihtsdo.tk.dto.concept.component.TkRevision;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifier;
import org.ihtsdo.tk.dto.concept.component.refex.TK_REFEX_TYPE;
import org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TkRefexStringMemberTest</code> contains tests for the class <code>{@link TkRefexStringMember}</code>.
 *
 * @generatedBy CodePro at 2/4/12 4:41 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class TkRefexStringMemberTest {
	/**
	 * Run the TkRefexStringMember() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
	public void testTkRefexStringMember_1()
		throws Exception {

		TkRefexStringMember result = new TkRefexStringMember();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisionList());
		assertEquals(null, result.getString1());
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
	 * Run the TkRefexStringMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
        @Ignore
	public void testTkRefexStringMember_2()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexStringMember result = new TkRefexStringMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_string.TkRefexStringMember.<init>(TkRefexStringMember.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexStringMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
        @Ignore
	public void testTkRefexStringMember_3()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexStringMember result = new TkRefexStringMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_string.TkRefexStringMember.<init>(TkRefexStringMember.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexStringMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
        @Ignore
	public void testTkRefexStringMember_4()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexStringMember result = new TkRefexStringMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_string.TkRefexStringMember.<init>(TkRefexStringMember.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexStringMember(RefexChronicleBI) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
        @Ignore
	public void testTkRefexStringMember_5()
		throws Exception {
		RefexChronicleBI another = null;

		TkRefexStringMember result = new TkRefexStringMember(another);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_string.TkRefexStringMember.<init>(TkRefexStringMember.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexStringMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexStringMember_6()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexStringMember result = new TkRefexStringMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexStringMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexStringMember_7()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexStringMember result = new TkRefexStringMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexStringMember(DataInput,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testTkRefexStringMember_8()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		TkRefexStringMember result = new TkRefexStringMember(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TkRefexStringMember(TkRefexStringMember,Map<UUID,UUID>,long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
	public void testTkRefexStringMember_9()
		throws Exception {
		TkRefexStringMember another = new TkRefexStringMember();
		another.setString1("");
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexStringMember result = new TkRefexStringMember(another, conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRevisionList());
		assertEquals("", result.getString1());
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
	 * Run the TkRefexStringMember(RefexStringVersionBI,NidBitSetBI,Map<UUID,UUID>,long,boolean,ViewCoordinate) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
        @Ignore
	public void testTkRefexStringMember_10()
		throws Exception {
		RefexStringVersionBI another = null;
		NidBitSetBI exclusions = null;
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;
		ViewCoordinate vc = new ViewCoordinate(Precedence.MIXED, new PositionSet(new HashSet()), new NidSet(), new NidSet(), new EditPathLosesStrategy(), 1, 1, RelAssertionType.INFERRED, new NidList(), org.ihtsdo.tk.api.coordinate.ViewCoordinate.LANGUAGE_SORT.LANG_BEFORE_TYPE);

		TkRefexStringMember result = new TkRefexStringMember(another, exclusions, conversionMap, offset, mapAll, vc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.ihtsdo.tk.dto.concept.component.TkRevision.<init>(TkRevision.java:71)
		//       at org.ihtsdo.tk.dto.concept.component.TkComponent.<init>(TkComponent.java:128)
		//       at org.ihtsdo.tk.dto.concept.component.refex.TkRefexAbstractMember.<init>(TkRefexAbstractMember.java:64)
		//       at org.ihtsdo.tk.dto.concept.component.refex.type_string.TkRefexStringMember.<init>(TkRefexStringMember.java:70)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		TkRefexStringMember obj = new TkRefexStringMember();
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		TkRefexStringMember obj = new TkRefexStringMember();
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		TkRefexStringMember obj = new TkRefexStringMember();
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the List<TkRefexStringRevision> getRevisionList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
	public void testGetRevisionList_1()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();

		List<TkRefexStringRevision> result = fixture.getRevisionList();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getString1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
	public void testGetString1_1()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();

		String result = fixture.getString1();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the TK_REFEX_TYPE getType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
	public void testGetType_1()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();

		TK_REFEX_TYPE result = fixture.getType();

		// add additional test code here
		assertNotNull(result);
		assertEquals(6, result.getTypeToken());
		assertEquals("STR", result.name());
		assertEquals("STR", result.toString());
		assertEquals(5, result.ordinal());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
        @Ignore
	public void testHashCode_1()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(-394224366, result);
	}

	/**
	 * Run the TkRefexStringMember makeConversion(Map<UUID,UUID>,long,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
	public void testMakeConversion_1()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		Map<UUID, UUID> conversionMap = new HashMap();
		long offset = 1L;
		boolean mapAll = true;

		TkRefexStringMember result = fixture.makeConversion(conversionMap, offset, mapAll);

		// add additional test code here
		assertNotNull(result);
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_1()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_2()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_3()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_4()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_5()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_6()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_7()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_8()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadExternal_9()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
	public void testSetString1_1()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();
		String string1 = "";

		fixture.setString1(string1);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
        @Ignore
	public void testToString_1()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
		fixture.additionalIds = new LinkedList();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("TkRefexStringMember:  str:'';  refex:e8b8117c-fd0e-44dc-a1a5-a200f6326c1a component:24360412-17ae-413c-8d1f-bc42bc55176d  primordial:3efd22e7-e45d-4e30-9d4b-57f748ce0a6b xtraIds:[] s:cb338c87-3109-4a32-872c-9493e476a18a a:1833f19a-e80e-49ac-a106-4fbcfc6a4a78 p:15be6851-9ee4-43d7-adbd-22f99388b033 t: Wed Dec 31 16:00:00 PST 1969 1", result);
	}

	/**
	 * Run the void writeExternal(DataOutput) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
	public void testWriteExternal_1()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
	public void testWriteExternal_2()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
	public void testWriteExternal_3()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = null;
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
	public void testWriteExternal_4()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
	public void testWriteExternal_5()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
	public void testWriteExternal_6()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
	public void testWriteExternal_7()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = new LinkedList();
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	@Test
	public void testWriteExternal_8()
		throws Exception {
		TkRefexStringMember fixture = new TkRefexStringMember();
		fixture.setString1("");
		fixture.authorUuid = UUID.randomUUID();
		fixture.pathUuid = UUID.randomUUID();
		fixture.refexUuid = UUID.randomUUID();
		fixture.annotations = new LinkedList();
		fixture.statusUuid = UUID.randomUUID();
		fixture.componentUuid = UUID.randomUUID();
		fixture.primordialUuid = UUID.randomUUID();
		fixture.time = 1L;
		fixture.revisions = null;
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
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
	 * @generatedBy CodePro at 2/4/12 4:41 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TkRefexStringMemberTest.class);
	}
}