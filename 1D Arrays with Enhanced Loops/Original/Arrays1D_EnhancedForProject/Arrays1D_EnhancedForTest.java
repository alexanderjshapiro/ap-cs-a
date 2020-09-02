
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Arrays1D_EnhancedForTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Arrays1D_EnhancedForTest
{

    private static boolean outputRunToConsole = false;
    @Test
    public void sum()
    {
        int[][] tests =
            {
                {50,75,100},
                {75,75,75},
                {85,90,92},
                {90,92,97},
                {85},
                {80,75,76,74,75,65,68,85,92,93,100,100}
            };
        int[] expected = {225,225,267,279,85,983};
        for (int testIndex = 0; testIndex < tests.length; testIndex++)
        {
            int[] param = tests[testIndex];
            // For 1D arrays use .clone()
            int[] runParam = param.clone();
            // For 2D or deeper arrays, use UTS.deepCopy
            //int[][] runParam = UTS.deepCopy(runParam);
            int run = Arrays1D_EnhancedFor.sum(runParam);
            String declaration = "int expected = ";
            assertNotNull("return is null",run);
            assertArrayEquals("Post Condition Failure",param,runParam);
            String params = UTS.summarizeParams(UTS.summarize(param));           
            outputSummary(params, ""+expected[testIndex], ""+run, declaration);
        }
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);
    }

    @Test
    public void specialAverage()
    {
        int[][] tests =
            {
                {50,75,100},
                {75,75,75},
                {85,-1,92},
                {-1,92,-1},
                {85},
                {80,75,-1,74,75,65,68,-1,92,-1,100,-1}
            };
        double[] expected = {75.0,75.0,88.5,92.0,85.0,78.625};
        for (int testIndex = 0; testIndex < tests.length; testIndex++)
        {
            int[] param = tests[testIndex];
            // For 1D arrays use .clone()
            int[] runParam = param.clone();
            // For 2D or deeper arrays, use UTS.deepCopy
            //int[][] runParam = UTS.deepCopy(runParam);
            double run = Arrays1D_EnhancedFor.specialAverage(runParam);
            String declaration = "int expected = ";
            assertNotNull("return is null",run);
            assertArrayEquals("Post Condition Failure",param,runParam);
            String params = UTS.summarizeParams(UTS.summarize(param));           
            outputSummary(params, ""+expected[testIndex], ""+run, declaration);
        }
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);
    }

    @Test
    public void niceAverage()
    {
        int[][] tests =
            {
                {50,75,100},
                {75,0,75},
                {85,90,92},
                {90,92,97},
                {85,85},
                {80,75,76,74,75,65,85,92,93,100,100}
            };
        double[] expected = {87.5,75.0,91.0,94.5,85.0,85.0};
        for (int testIndex = 0; testIndex < tests.length; testIndex++)
        {
            int[] param = tests[testIndex];
            // For 1D arrays use .clone()
            int[] runParam = param.clone();
            // For 2D or deeper arrays, use UTS.deepCopy
            //int[][] runParam = UTS.deepCopy(runParam);
            double run = Arrays1D_EnhancedFor.niceAverage(runParam);
            String declaration = "int expected = ";
            assertNotNull("return is null",run);
            assertArrayEquals("Post Condition Failure",param,runParam);
            String params = UTS.summarizeParams(UTS.summarize(param));           
            outputSummary(params, ""+expected[testIndex], ""+run, declaration);
        }
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);
    }

    @Test
    public void tossSum()
    {
        int[][] tests =
            {
                {50,75,100},
                {75,0,75},
                {85,90,92},
                {90,92,97},
                {85,85,85},
                {80,75,76,74,75,65,85,92,93,100,100}
            };
        int[] expected = {
                75,75,90,92,85,750
            };    
        for (int testIndex = 0; testIndex < tests.length; testIndex++)
        {
            int[] param = tests[testIndex];
            // For 1D arrays use .clone()
            int[] runParam = param.clone();
            // For 2D or deeper arrays, use UTS.deepCopy
            //int[][] runParam = UTS.deepCopy(runParam);
            int run = Arrays1D_EnhancedFor.tossSum(runParam);
            String declaration = "int expected = ";
            assertNotNull("return is null",run);
            assertArrayEquals("Post Condition Failure",param,runParam);
            String params = UTS.summarizeParams(UTS.summarize(param));
            String expect = "";
            if (expected != null && expected.length > testIndex)
            {
                expect = "" + expected[testIndex];
            }
            outputSummary(params, "" + expect, "" + run, declaration);
        }
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);
    }

    @Test
    public void adjustedScores()
    {
        int[][] tests =
            {
                {50,75,100},
                {75,75,75},
                {85,90,92},
                {90,92,97},
                {85},
                {80,75,76,74,75,65,68,85,92,93,100,100}
            };

        int[][] expected = {
                {50,75,100},
                {100,100,100},
                {93,98,100},
                {93,95,100},
                {100},
                {80,75,76,74,75,65,68,85,92,93,100,100}
            };

        for (int testIndex = 0; testIndex < tests.length; testIndex++)
        {
            int[] param = tests[testIndex];
            // For 1D arrays use .clone()
            int[] runParam = param.clone();
            // For 2D or deeper arrays, use UTS.deepCopy
            //int[][] runParam = UTS.deepCopy(runParam);
            int[] run = Arrays1D_EnhancedFor.adjustedScores(runParam);
            String declaration = "int[] expected = ";
            assertNotNull("return is null",run);
            assertArrayEquals("Post Condition Failure",param,runParam);
            String params = UTS.summarizeParams(UTS.summarize(param));           
            String expect = "";
            if (expected != null && expected.length > testIndex)
            {
                expect = UTS.summarize( expected[testIndex]);
            }
            outputSummary(params, "" + expect, UTS.summarize(run), declaration);
        }
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);
    }

@Test
public void mode()
{

        int[][] tests =
            {
                {50,50,75,100},
                {75,75,75},
                {85,90,92,90},
                {90,92,90,92,93,92,97},
                {85},
                {80,75,76,74,75,65,68,85,100,92,93,100,100}
            };
            
       int[] expected = {
50,75,90,92,85,100
};

for (int testIndex = 0; testIndex < tests.length; testIndex++)
{
    int[] param = tests[testIndex];
    // For 1D arrays use .clone()
    int[] runParam = param.clone();
    // For 2D or deeper arrays, use UTS.deepCopy
    //int[][] runParam = UTS.deepCopy(runParam);
    int run = Arrays1D_EnhancedFor.mode(runParam);
    String runResult = UTS.summarize(run);
    String declaration = "int expected = ";
    assertNotNull("return is null",run);
    assertArrayEquals("Post Condition Failure",param,runParam);
    String params = UTS.summarizeParams(UTS.summarize(param));           
    String expect = "";
    if (expected != null && expected.length > testIndex)
    {
        expect = "" + expected[testIndex];
    }
    outputSummary(params, "" + expect, runResult, declaration);
}
if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);

}

    /**
     * Default constructor for test class Arrays1D_EnhancedForTest
     */
    public Arrays1D_EnhancedForTest()
    {
    }

    private static boolean outputSummary(String parameters, String expected, String run, String declaration)
    {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];
        String methodName = e.getMethodName();
        summary += methodName + parameters + "\n";
        if (outputRunToConsole && declaration != null)
        {
            if (captureRun == null)
            {
                captureRun = declaration + "{\n";
            }
            captureRun += run + ","; 
        }
        summary += "Expected:\t" + expected+"\nRun:\t" + run + "\n";
        boolean result = expected.equals(run);
        if (!result) 
        {
            allPassed = false;
            if (firstFailExpected == null)
            {
                firstFailExpected = expected;
                firstFailRun = run;
            }
        }
        return result;
    }
    private static String summary = "";
    private static boolean allPassed = true;
    private static String firstFailExpected = null;
    private static String firstFailRun = null;
    private static String captureSummary = "";
    private static String captureRun = null;
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        summary = "";
        allPassed = true;
        firstFailExpected = null;
        firstFailRun = null;
        captureSummary = "";
        captureRun = null;
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        if (captureRun != null)
        {
            int crLen = captureRun.length() - 1;
            System.out.println(captureRun.substring(0, crLen) + "\n" + "};");
        }
    }
}
