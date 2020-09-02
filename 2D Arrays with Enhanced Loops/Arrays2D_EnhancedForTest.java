
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Arrays2D_EnhancedForTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Arrays2D_EnhancedForTest
{

    private static boolean outputRunToConsole = false;

    @Test
    public void count1s()
    {

        int[][] tests =
            {
                {1, 501, 0, 42, 911},
                {1,123,501,911},
                {42,0,666},
                {1,0,1,0},
                {0},
                {1,23,456,7890,12345,678901,2345678,90123456}
            };
        int[] expected = {
                3,
                4,
                0,
                2,
                0,
                4
            };

        for (int testIndex = 0; testIndex < tests.length; testIndex++)
        {
            int[] param = tests[testIndex];
            // For 1D arrays use .clone()
            int[] runParam = param.clone();
            // For 2D or deeper arrays, use UTS.deepCopy
            //int[][] runParam = UTS.deepCopy(runParam);
            int run = Arrays2D_EnhancedFor.count1s(runParam);
            String runResult = UTS.summarize(run);
            String declaration = "int[] expected = ";
            assertNotNull("return is null",run);
            assertArrayEquals("Post Condition Failure",param,runParam);
            String params = UTS.summarize(param);
            params = UTS.summarizeParams(params);           
            String expect = "";
            if (expected != null && expected.length > testIndex)
            {
                expect = UTS.summarize(expected[testIndex]);
            }
            outputSummary(params, expect, runResult, declaration);
        }
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);

    }

    @Test
    public void nonOnes()
    {

        int[][][] tests =
            {
                {
                    {1, 501, 0, 42, 911},
                    {1,123,501,911,90123456},
                    {42,0,666,678901,2345678},
                    {1,0,1,0,1},
                    {0,0,0,0,0},
                    {1,23,456,7890,12345}
                },
                {
                    {1,1,1,1},
                    {0,1,0,1}
                },
                {
                    {1,2,3,4,5},
                    {11,12,13,14,15},
                    {21,22,23,24,25}
                }

            };
        int[] expected = {
                16,
                2,
                8
            };


        for (int testIndex = 0; testIndex < tests.length; testIndex++)
        {
            int[][] param = tests[testIndex];
            // For 1D arrays use .clone()
            int[][] runParam = UTS.deepCopyOf(param);
            int run = Arrays2D_EnhancedFor.nonOnes(runParam);
            String runResult = UTS.summarize(run);
            String declaration = "int[] expected = ";
            assertNotNull("return is null",run);
            assertArrayEquals("Post Condition Failure",param,runParam);
            String params = UTS.summarize(param);
            params = UTS.summarizeParams(params);           
            String expect = "";
            if (expected != null && expected.length > testIndex)
            {
                expect = UTS.summarize(expected[testIndex]);
            }
            outputSummary(params, expect, runResult, declaration);
        }
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);

    }

    /**
     * Default constructor for test class Arrays2D_EnhancedForTest
     */
    public Arrays2D_EnhancedForTest()
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
