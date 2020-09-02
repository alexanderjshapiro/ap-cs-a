import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * The test class D6Test.
 *
 * @version 1/29/17
 */
public class D6Test
{
    static int version = 1;
    private static boolean outputRunToConsole = false;

    @Test
    public void test_00_DefaultConstructorAndGetNumFaces()
    {
        Randomizer die = new D6();
        int i = die.getNumFaces();
        String callParams = "\nRandomizer die = new D6();\ndie.getNumFaces();\n";

        String runResult ="" + i;
        String expect =  "6";
        outputSummary(callParams, expect, runResult, "");
        awardPoints(1);        
        if (!allPassed) 
            assertEquals(summary, firstFailExpected, firstFailRun);
    }   

    @Test
    public void test_01_GetFace()
    {
        Randomizer die = new D6();
        int faces = die.getNumFaces();
        for (int i = 1; i <= faces; i ++)
        {
            String callParams = "\n.getFace("+i+")";

            String runResult = "" + die.getFace(i);
            String expect = "" + i;
            outputSummary(callParams, expect, runResult, "");

        }
        awardPoints(1);        
        if (!allPassed) 
            assertEquals(summary, firstFailExpected, firstFailRun);
    }   

    @Test
    public void test_02_Randomize_GetCurrentValue_GetCurrentFace()
    {
        Randomizer die = new D6();
        int numFaces = die.getNumFaces();
        String[] faces = new String[numFaces];
        for (int i = 0; i < 10000; i++)
        {
            die.randomize();
            int faceIndex = die.getCurrentValue() - 1;
            String face = die.getCurrentFace();
            if (faceIndex >= 0 && faceIndex < numFaces && faces[faceIndex] == null)
            {
                faces[faceIndex] = face;
            }
        }
        for (int i = 0; i < die.getNumFaces(); i++)
        {
            String callParams = "\nChecking face #" + (i + 1);

            String runResult = faces[i];
            String expect = "" + die.getFace(i + 1);
            outputSummary(callParams, expect, runResult, "");

        }
        awardPoints(1);        
        if (!allPassed) 
            assertEquals(summary, firstFailExpected, firstFailRun);
    }   

    @Test
    public void test_03_toString()
    {
        Randomizer die = new D6();
        int numFaces = die.getNumFaces();
        for (int i = 0; i < 10000; i++)
        {
            die.randomize();
            int val = die.getCurrentValue();
            String callParams = "\ntoString() when current value is " + val;
            String expect = "d" + numFaces + " = " + die.getFace(val);
            String runResult = die.toString();
            if (!expect.equals(runResult))
            {
                outputSummary(callParams, expect, runResult, "");
            }
        }
        awardPoints(1);        
        if (!allPassed) 
            assertEquals(summary, firstFailExpected, firstFailRun);
    }   
    public static void main(String[] args)
    {
        points = 0;
        pointsPossible = 0;

        try
        {
            Class runnerClass = Class.forName(args[0]);

            Result result = JUnitCore.runClasses(runnerClass);

            for (Failure failure : result.getFailures())
            {
                System.out.println(failure.toString());
            }

            int runCount = result.getRunCount();
            int failCount = result.getFailureCount();
            //System.out.println("RESULT Student: " + ExamMethods.yourName());
            System.out.println("RESULT: Version :" + D6Test.version);
            System.out.println("RESULT: " + (runCount-failCount) + " of  " + runCount + " tests were successful.  All tests passed = " + result.wasSuccessful());
            System.out.println("RESULT: " + points + " of  " + pointsPossible + " points achieved.");            

        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Failed to find runner class : " + args[0]);
        }

    }

    private static boolean outputSummary(String parameters, String expected, String run, String declaration)
    {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];
        String methodName = e.getMethodName();
        //summary += methodName + parameters + "\n";
        if (outputRunToConsole && declaration != null)
        {
            if (captureRun == null)
            {
                captureRun = declaration + "{\n";
            }
            captureRun += run + ","; 
        }
        //summary += "Expected:\t" + expected+"\nRun:\t" + run + "\n";
        boolean result = expected.equals(run);
        if (!result) 
        {
            summary += methodName + parameters + "\n";
            summary += "Expected:\t" + expected+"\nRun:\t" + run + "\n";

            allPassed = false;
            if (firstFailExpected == null)
            {
                firstFailExpected = expected;
                firstFailRun = run;
            }
        }
        return result;
    }

    private static void awardPoints(double ptsPossible)
    {
        pointsPossible += ptsPossible;

        if (allPassed)
        {
            points += ptsPossible;
        }

    }

    private static String summary = "";
    private static boolean allPassed = true;
    private static String firstFailExpected = null;
    private static String firstFailRun = null;
    private static String captureSummary = "";
    private static String captureRun = null;
    private static double points = 0;
    private static double pointsPossible = 0;

    /**
     * Default constructor for test class D6Test
     */
    public D6Test()
    {
    }

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

    @Test
    public void yourName()
    {
        String studentName = D6.yourName();
        if (studentName == null || studentName.equals(""))
        {
            System.out.println("Student did not complete the yourName method!");
            allPassed = false;            
        }
        else
        {
            System.out.println("RESULT Student: " + studentName);
        }
        awardPoints(1);
        assertNotNull(studentName);
    }
}
