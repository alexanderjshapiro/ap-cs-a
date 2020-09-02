

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AppListerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AppListerTest
{
    private static boolean outputRunToConsole = false;
    /**
     * Default constructor for test class AppListerTest
     */
    public AppListerTest()
    {
    }

    @Test
    public void getAppsInFolder()
    {
        String[] tests =
            {
                "Main",
                "Sports",
                "Games",
                "Social"
            };


        String[][] expected = {
            {"Stocks", "Messages", "Calendar", "Photos", "FOLDERSports", "FOLDERGames"},
            {"Golf", "MLB"},
            {"FOLDERSocial", "Doodle Jump", "Pokemon Go", "Dots"},
            {"Words With Friends", "Dice"},
        };            

        for (int testIndex = 0; testIndex < tests.length; testIndex++)
        {
            String param = tests[testIndex];
            String[] run = AppLister.getAppsInFolder(param);
            String declaration = "String expected = ";
            assertNotNull("return is null",run);
            
            assertArrayEquals("Results don't match\n",expected[testIndex], run);
            
            /*

            String expect = "";
            if (expected != null && expected.length > testIndex)
            {
                expect = "" + expected[testIndex];
            }
            outputSummary(param, "" + expect, "" + run, declaration);
            */
        }
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);

    }
    
    @Test
    public void printAppsInFolder()
    {
        AppLister.printAppsInFolder("Main");
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
