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
 * The test class MoreStringListsTest.
 *
 * @author  Middler
 * @version 1
 */

public class UnitTests
{
    static int version = 1;

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
            System.out.println("RESULT: Version :" + UnitTests.version);
            System.out.println("RESULT: " + (runCount-failCount) + " of  " + runCount + " tests were successful.  All tests passed = " + result.wasSuccessful());
            System.out.println("RESULT: " + points + " of  " + pointsPossible + " points achieved.");            

        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Failed to find runner class : " + args[0]);
        }

    }

    private static boolean outputRunToConsole = false;

    /**
     * Default constructor for test class ExamMethodsTest
     */
    public UnitTests()
    {
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
        String studentName = MoreStringLists.yourName();
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

    @Test
    public void csvListTest()
    {
        String[] testArrs1 =
            {
                "Mitch", 
                "up,down,left,right,top,bottom", 
                "north,south,east,west", 
                "Braskin,Aaron", 
                "Bush,Clinton,Bush,Obama,Trump",            
            };

        String[][] expected =
            {
                { "Mitch" },
                { "up","down","left","right","top","bottom" }, 
                { "north","south","east","west" }, 
                { "Braskin","Aaron" }, 
                { "Bush","Clinton","Bush","Obama","Trump" },            
            };

        for (int testIndex = 0; testIndex < testArrs1.length; testIndex++)
        {
            String param1 = testArrs1[testIndex];

            String runParam1 = param1;

            List<String> run = MoreStringLists.csvList(runParam1);
            assertNotNull("return is null",run);
            String runResult = UTS.summarize(run);
            String declaration = "String[][] expected = ";

            String params1 = UTS.summarize(param1);

            String expect = "";
            if (expected != null && expected.length > testIndex)
            {
                expect = UTS.summarize(expected[testIndex]);
            }
            outputSummary(params1, expect, runResult, declaration);
        }
        awardPoints(1);        
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);
    }

    @Test
    public void isUniqueTest()
    {
        String[][] testArrs1 =
            {
                {"Mitch"}, 
                {"Mitch"},
                {"Mitch","Aaron"},
                {"Ken","Gena","Jason","David","Brandy"}, 
                {"Ken","Gena","Jason","David","Brandy"}, 
            };

        String[] testArrs2 =
            {
                "Mitch",
                "Aaron",
                "Aaron",
                "Aaron",
                "Ken",
            };

        boolean[] expected =
            {
                false,
                true,
                false,
                true,
                false
            };

        for (int testIndex = 0; testIndex < testArrs1.length; testIndex++)
        {
            List<String> param1 = Arrays.asList(testArrs1[testIndex]);

            List<String> runParam1 = new ArrayList<String>(param1);

            String runParam2 = testArrs2[testIndex];

            boolean run = MoreStringLists.isUnique(runParam1, runParam2);
            String runResult = UTS.summarize(run);
            assertEquals("Post Condition Failure",param1,runParam1);
            String declaration = "boolean[] expected = ";

            String params1 = UTS.summarize(param1);
            params1 += "," + UTS.summarize(runParam2);
            String expect = "";
            if (expected != null && expected.length > testIndex)
            {
                expect = UTS.summarize(expected[testIndex]);
            }
            outputSummary(params1, expect, runResult, declaration);
        }
        awardPoints(1);        
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);
    }

    @Test
    public void mergeDups()
    {
        String[][] testArrs1 =
            {
                {"Mitch"}, 
                {"Mitch"},
                {"Mitch","Aaron"},
                {"Aaron","Mitch"},
                {"Mitch","Aaron"},
                {"Aaron", "Ken", "Gena", "Michael"},
                {"Ken","Gena","Jason","David","Brandy"}, 
                {"Ken","Gena","Jason","David","Brandy"}, 
                {"David","Jason","Charlotte","Ken","Michael"}, 
            };

        String[][] testArrs2 =
            {
                {"Mitch"}, 
                {"Aaron"},
                {"Mitch","Aaron"},
                {"Mitch","Aaron"},
                {"Aaron","Mitch"},
                {"David", "Ken", "Aaron", "Jason"},
                {"Gena","Ken","David","Brandy","Jason"}, 
                {"Ken","Jason","Charlotte","David","Michael"}, 
                {"Ken","Gena","Jason","David","Brandy"}, 
            };

        String[][] expected =
            {
                {"Mitch"}, 
                {},
                {"Mitch","Aaron"},
                {"Aaron","Mitch"},
                {"Mitch","Aaron"},
                {"Aaron", "Ken"},
                {"Ken","Gena","Jason","David","Brandy"}, 
                {"Ken","Jason","David"}, 
                {"David","Jason","Ken"}, 
            };

        for (int testIndex = 0; testIndex < testArrs1.length; testIndex++)
        {
            List<String> param1 = Arrays.asList(testArrs1[testIndex]);
            List<String> runParam1 = new ArrayList<String>(param1);

            List<String> param2 = Arrays.asList(testArrs2[testIndex]);
            List<String> runParam2 = new ArrayList<String>(param2);

            List<String> run = MoreStringLists.mergeDups(runParam1, runParam2);
            assertNotNull("return is null",run);
            String runResult = UTS.summarize(run);
            assertEquals("Post Condition Failure",param1,runParam1);
            assertEquals("Post Condition Failure",param2,runParam2);
            String declaration = "String[][] expected = ";

            String params1 = UTS.summarize(param1);
            params1 += "," + UTS.summarize(param2);
            String expect = "";
            if (expected != null && expected.length > testIndex)
            {
                expect = UTS.summarize(expected[testIndex]);
            }
            outputSummary(params1, expect, runResult, declaration);
        }
        awardPoints(1);        
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);
    }

    @Test
    public void reduce()
    {
        String[][] testArrs1 =
            {
                {"Mitch"}, 
                {"Mitch","Aaron"},
                {"Mitch","Mitch"},
                {"Aaron", "Ken", "Gena", "Ken"},
                {"Aaron", "Ken", "Gena", "Aaron", "Michael"}, 
                {"Aaron","Aaron","Aaron","Aaron","Aaron"}, 
                {"David","Jason","Charlotte","Ken","Ken"}, 
            };

        String[][] expected =
            {
                {"Mitch"}, 
                {"Mitch","Aaron"},
                {"Mitch"},
                {"Aaron", "Ken", "Gena"},
                {"Aaron", "Ken", "Gena", "Michael"}, 
                {"Aaron"}, 
                {"David","Jason","Charlotte","Ken"}, 
            };

        for (int testIndex = 0; testIndex < testArrs1.length; testIndex++)
        {
            String[] param1 = testArrs1[testIndex];
            String[] runParam1 = param1.clone();

            List<String> run = MoreStringLists.reduce(runParam1);
            assertNotNull("return is null",run);
            String runResult = UTS.summarize(run);
            assertArrayEquals("Post Condition Failure",param1,runParam1);
            String declaration = "String[][] expected = ";

            String params1 = UTS.summarize(param1);
            String expect = "";
            if (expected != null && expected.length > testIndex)
            {
                expect = UTS.summarize(expected[testIndex]);
            }
            outputSummary(params1, expect, runResult, declaration);
        }
        awardPoints(1);        
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);
    }

    @Test
    public void alphaOrder()
    {
        String[] testArrs1 =
            {
                "AARON",
                "ABCDEFG",
                "GFEDCBA",
                "AABBCC",
                "ACB",            
                "AACBCB",
                "MIDDLER",
                "ABBRACADDBRA"
            };

        String[][] expected =
            {
                {"A","N","O","R"}, 
                {"A","B","C","D","E","F","G"},
                {"A","B","C","D","E","F","G"},
                {"A","B","C"},
                {"A","B","C"},
                {"A","B","C"},
                {"D","E","I","L","M","R"},
                {"A","B","C","D","R"}
            };

        for (int testIndex = 0; testIndex < testArrs1.length; testIndex++)
        {
            String param1 = testArrs1[testIndex];

            List<String> run = MoreStringLists.alphaOrder(param1);
            assertNotNull("return is null",run);
            String runResult = UTS.summarize(run);
            String declaration = "String[][] expected = ";

            String params1 = UTS.summarize(param1);
            String expect = "";
            if (expected != null && expected.length > testIndex)
            {
                expect = UTS.summarize(expected[testIndex]);
            }
            outputSummary(params1, expect, runResult, declaration);
        }
        awardPoints(1);        
        if (!allPassed) 
            assertEquals(summary, firstFailExpected, firstFailRun);
    }
}

