import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * The test class ExamMethodsTest.
 *
 * @author  Middler
 * @version 1
 */

public class ExamMethodsTest
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
            System.out.println("RESULT: Version :" + ExamMethodsTest.version);
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
    public ExamMethodsTest()
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
    
    private static void awardPoints(int ptsPossible)
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
    private static int    points = 0;
    private static int    pointsPossible = 0;
    
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
        String studentName = ExamMethods.yourName();
        if (studentName == null || studentName.equals(""))
        {
            System.out.println("Student did not complete the yourName method!");
            allPassed = false;            
        }
        else
        {
            System.out.println("RESULT Student: " + studentName);
        }
        awardPoints(20);
        assertNotNull(studentName);
    }

    @Test
    public void emailUser()
    {
        String[] tests =
            {
                "mmiddler@rbusd.org",
                "smartgirl63@Yahoo.com",
                "Ben@affleck.com",
                "president@whitehouse.gov",
                "PMcCartney@emi.com",
                "jennifer_Lopez@sonymusic.com"
            };

        String[] expected = {
            "mmiddler","smartgirl63","Ben","president","PMcCartney","jennifer_Lopez"
        };            
        
        for (int testIndex = 0; testIndex < tests.length; testIndex++)
        {
            String param = tests[testIndex];
            String run = ExamMethods.emailUser(param);
            String runResult = UTS.summarize(run);
            String declaration = "String[] expected = ";
            String params = UTS.summarize(param);
            params = UTS.summarizeParams(params);           

            String expect = "";
            if (expected != null && expected.length > testIndex)
            {
                expect = UTS.summarize(expected[testIndex]);
            }
            outputSummary(params, expect, runResult, declaration);
        }
        awardPoints(25);        
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);
        
    }    
    
    @Test
    public void valueIsBetweenRange()
    {
        int[][] testArrs =
            {
                {0,10},
                {0,10},
                {0,10},
                {17,19},
                {17,19},
                {17,19},
            };

        int[] testVals =
            {
                9,
                11,
                -1,
                18,
                16,
                20,
            };

        boolean[] expected = 
            {
                true,false,false,true,false,false
            };
            
        
        for (int testIndex = 0; testIndex < testArrs.length; testIndex++)
        {
            int[] param = testArrs[testIndex];
            int   testVal = testVals[testIndex];
            // For 1D arrays use .clone()
            int[] runParam = param.clone();
            boolean run = ExamMethods.valueIsBetweenRange(runParam, testVal);
            String runResult = UTS.summarize(run);
            String declaration = "boolean[] expected = ";
            assertArrayEquals("Post Condition Failure",param,runParam);
            String params = UTS.summarize(param);
            String params2 = UTS.summarize(testVal);
            params += ", " + params2;
            params = UTS.summarizeParams(params);           

            String expect = "";
            if (expected != null && expected.length > testIndex)
            {
                expect = UTS.summarize(expected[testIndex]);
            }
            outputSummary(params, expect, runResult, declaration);
        }
        awardPoints(25);        
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);
        
    }
    


    @Test
    public void columnContainingLargest()
    {
        
        double[][][] testArrs =
            {
                { {0,10,1}, {0,10, 1}, {0,10, 40}, {21,10, 1} }, 
                { {500,10, 1, -1}, {3, 0,10, 1}, {50, 0,10, 40}, {21,10, 1, 499} }, 
                { {0,10}, {0,120}, {0,13}, {4,10}, {0,10} },
                { {5000,10}, {0,120}, {0,13}, {4,10}, {0,10} },
                { {5000,10}, {0,120}, {0,13}, {4,10}, {0,5110} },
                { {-10,101,1,2}, {0,10, 1,102}, {0,102, 40,104}, {21,10, 1,3} }, 

            };

        int[] expected = { 2,0,1,0,1,3 };

        
        for (int testIndex = 0; testIndex < testArrs.length; testIndex++)
        {
            double[][] param = testArrs[testIndex];
            // For 2D or deeper arrays, use UTS.deepCopy
            double[][] runParam = UTS.deepCopyOf(param);
            int run = ExamMethods.columnContainingLargest(runParam);
            String runResult = UTS.summarize(run);
            String declaration = "int expected = ";
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
        awardPoints(5);        
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);
        
    }
    


    @Test
    public void distance()
    {
        int[] testP1 =
            {
               0, 0, 2, -5, 7 
            };
        int[] testP2 =
            {
                0, 0, 2, -10, 7 
            };
        int[] testP3 =
            {
                0, 10, 22, -2, 126 
            };
        int[] testP4 =
            {
                5, 0, 23, -6, 127
            };
            
        double[] expected = 
        {
           5.0,10.0,29.0,5.0,169.0
        };
        
        for (int testIndex = 0; testIndex < testP1.length; testIndex++)
        {
            int param1 = testP1[testIndex];
            int param2 = testP2[testIndex];
            int param3 = testP3[testIndex];
            int param4 = testP4[testIndex];

            double run = ExamMethods.distance(param1, param2, param3, param4);
            String runResult = UTS.summarize(run);
            String declaration = "double[] expected = ";
            String params1 = UTS.summarize(param1);
            String params2 = UTS.summarize(param2);
            params1 += ", " + params2;
            String params3 = UTS.summarize(param3);
            params1 += ", " + params3;
            String params4 = UTS.summarize(param4);
            params1 += ", " + params4;
            params1 = UTS.summarizeParams(params1);           

            String expect = "";
            if (expected != null && expected.length > testIndex)
            {
                expect = UTS.summarize(expected[testIndex]);
            }
            outputSummary(params1, expect, runResult, declaration);
        }
        awardPoints(20);        
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);
    }
    
    @Test
    public void allDistances()
    {
        int[][][] testArrs =
            {
               { {0,5}, {0,0}, {10,0} },                
               { {0,0}, {0,5}, {0,0}, {10,0} },
               { {0,0}, {0,5}, {3,9}, {6,13} },
               { {0,0}, {0,5}, {3,9}, {6,13}, {-3,1} },
            };
            
        double[][] expected =
        {
           {5.0,10.0},{5.0,5.0,10.0},{5.0,5.0,5.0},{5.0,5.0,5.0,15.0}
        };
        
        for (int testIndex = 0; testIndex < testArrs.length; testIndex++)
        {
            int[][] param = testArrs[testIndex];
            // For 2D or deeper arrays, use UTS.deepCopy
            int[][] runParam = UTS.deepCopyOf(param);
            double[] run = ExamMethods.allDistances(runParam);
            String runResult = UTS.summarize(run);
            String declaration = "double[] expected = ";
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
        awardPoints(10);        
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);
    }
    
    


}



