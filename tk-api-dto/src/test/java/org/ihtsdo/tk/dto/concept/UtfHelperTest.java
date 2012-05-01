package org.ihtsdo.tk.dto.concept;

import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>UtfHelperTest</code> contains tests for the class <code>{@link UtfHelper}</code>.
 *
 * @generatedBy CodePro at 2/4/12 3:04 PM
 * @author kec
 * @version $Revision: 1.0 $
 */
public class UtfHelperTest {
	/**
	 * Run the UtfHelper() constructor test.
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test
	public void testUtfHelper_1()
		throws Exception {
		UtfHelper result = new UtfHelper();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the String readUtfV6(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV6_1()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		String result = UtfHelper.readUtfV6(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV6(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV6_2()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		String result = UtfHelper.readUtfV6(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV6(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV6_3()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 6;

		String result = UtfHelper.readUtfV6(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV6(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV6_4()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 6;

		String result = UtfHelper.readUtfV6(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV6(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV6_5()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 6;

		String result = UtfHelper.readUtfV6(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV6(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV6_6()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 6;

		String result = UtfHelper.readUtfV6(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV6(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV6_7()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 6;

		String result = UtfHelper.readUtfV6(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV6(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV6_8()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 6;

		String result = UtfHelper.readUtfV6(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV6(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV6_9()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 6;

		String result = UtfHelper.readUtfV6(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV6(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV6_10()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		String result = UtfHelper.readUtfV6(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV6(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV6_11()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		String result = UtfHelper.readUtfV6(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV6(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV6_12()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		String result = UtfHelper.readUtfV6(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV6(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV6_13()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		String result = UtfHelper.readUtfV6(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV6(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV6_14()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		String result = UtfHelper.readUtfV6(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV6(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV6_15()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		String result = UtfHelper.readUtfV6(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV6(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV6_16()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		String result = UtfHelper.readUtfV6(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV7(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV7_1()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		String result = UtfHelper.readUtfV7(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV7(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV7_2()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 1;

		String result = UtfHelper.readUtfV7(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV7(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV7_3()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		String result = UtfHelper.readUtfV7(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV7(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV7_4()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		String result = UtfHelper.readUtfV7(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV7(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV7_5()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		String result = UtfHelper.readUtfV7(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV7(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV7_6()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		String result = UtfHelper.readUtfV7(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV7(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV7_7()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		String result = UtfHelper.readUtfV7(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV7(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV7_8()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		String result = UtfHelper.readUtfV7(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readUtfV7(DataInput,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadUtfV7_9()
		throws Exception {
		DataInput in = new DataInputStream(new PipedInputStream());
		int dataVersion = 7;

		String result = UtfHelper.readUtfV7(in, dataVersion);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void writeUtf(DataOutput,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test
	public void testWriteUtf_1()
		throws Exception {
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());
		String utfData = "";

		UtfHelper.writeUtf(out, utfData);

		// add additional test code here
	}

	/**
	 * Run the void writeUtf(DataOutput,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test
	public void testWriteUtf_2()
		throws Exception {
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());
		String utfData = "";

		UtfHelper.writeUtf(out, utfData);

		// add additional test code here
	}

	/**
	 * Run the void writeUtf(DataOutput,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test
	public void testWriteUtf_3()
		throws Exception {
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());
		String utfData = "";

		UtfHelper.writeUtf(out, utfData);

		// add additional test code here
	}

	/**
	 * Run the void writeUtf(DataOutput,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test
	public void testWriteUtf_4()
		throws Exception {
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());
		String utfData = "";

		UtfHelper.writeUtf(out, utfData);

		// add additional test code here
	}

	/**
	 * Run the void writeUtf(DataOutput,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test
	public void testWriteUtf_5()
		throws Exception {
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());
		String utfData = "";

		UtfHelper.writeUtf(out, utfData);

		// add additional test code here
	}

	/**
	 * Run the void writeUtf(DataOutput,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test
	public void testWriteUtf_6()
		throws Exception {
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());
		String utfData = "";

		UtfHelper.writeUtf(out, utfData);

		// add additional test code here
	}

	/**
	 * Run the void writeUtf(DataOutput,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Test
	public void testWriteUtf_7()
		throws Exception {
		DataOutput out = new DataOutputStream(new ByteArrayOutputStream());
		String utfData = "";

		UtfHelper.writeUtf(out, utfData);
                
		// add additional test code here
	}
        String longString;
	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 24000; i++) {
                    sb.append("Test line: ").append(i);
                }
                longString = sb.toString();
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 2/4/12 3:04 PM
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
	 * @generatedBy CodePro at 2/4/12 3:04 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(UtfHelperTest.class);
	}
}