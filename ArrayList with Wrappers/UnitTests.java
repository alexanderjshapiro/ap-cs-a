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
 * The test class ArrayListsTest.
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
        String studentName = ArrayLists.yourName();
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
    public void valueSqRoot()
    {
        double[][] testArrs1 =
        {
            { 25 }, 
            { 25, 50, 100 }, 
            { 25, 50, 100 }, 
            { 25, 50, 100, 81 }, 
            { 25, 50, 100, 36, 81, 16 }, 
            { 25, 16, 81 }, 
            { 25, 50, 4 }, 
           
        };

        int[] testIndexParam = 
        {
            0,
            2,
            0,
            3,
            4,
            1,
            2
        };

        double[] expected = {
            5.0,10.0,5.0,9.0,9.0,4.0,2.0
        };
        
        for (int testIndex = 0; testIndex < testArrs1.length; testIndex++)
        {
            double[] param1 = testArrs1[testIndex];
            int param2 = testIndexParam[testIndex];
            // For 1D arrays use .clone()
            double[] runParam1 = param1.clone();
     
            double run = ArrayLists.valueSqRoot(runParam1, param2);
            String runResult = UTS.summarize(run);
            String declaration = "double[] expected = ";
            assertArrayEquals("Post Condition Failure",param1,runParam1,0.05);
           
            String params1 = UTS.summarize(param1);
            String params2 = UTS.summarize(param2);
            params1 += ", " + params2;
            params1 = UTS.summarizeParams(params1);           

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
    public void listValueSqRoot()
    {
        List<List<Double>> testArrs1 = new ArrayList<List<Double>>();
        testArrs1.add( new ArrayList<Double>(Arrays.asList(900.)) );
        testArrs1.add( new ArrayList<Double>(Arrays.asList(25.,16.,36.)) );
        testArrs1.add( new ArrayList<Double>(Arrays.asList(25.,16.,36.)) );
        testArrs1.add( new ArrayList<Double>(Arrays.asList(4.,25.)) );
        testArrs1.add( new ArrayList<Double>(Arrays.asList(25., 50., 100., 36., 81., 16.)) );
        testArrs1.add( new ArrayList<Double>(Arrays.asList(0.,900.)) );

        int[] testIndexParam = 
        {
            0,
            0,
            2,
            1,
            5,
            0
        };
        
        double[] expected = {
            30.0,5.0,6.0,5.0,4.0,0.0
        };
        
        
        for (int testIndex = 0; testIndex < testArrs1.size(); testIndex++)
        {
            List<Double> param1 = testArrs1.get(testIndex);
            int param2 = testIndexParam[testIndex];
            // For 1D arrays use .clone()
            List<Double> origP1 = new ArrayList<>(param1);
     
            double run = ArrayLists.listValueSqRoot(param1, param2);
            String runResult = UTS.summarize(run);
            String declaration = "double[] expected = ";
            assertEquals("Post Condition Failure",param1,origP1);
           
            String params1 = UTS.summarize(param1);
            String params2 = UTS.summarize(param2);
            params1 += ", " + params2;
            params1 = UTS.summarizeParams(params1);           

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
    public void safeGet()
    {
        int[][] testArrs1 =
        {
            { 25 }, 
            { 25, 50, 100 }, 
            { 25, 50, 100 }, 
            { 25, 50, 100, 81 }, 
            { 25, 50, 100, 36, 81, 16 }, 
            { 25, 16, 81 }, 
            { 25, 50, 4 }, 
           
        };

        int[] testIndexParam = 
        {
            -1,
            2,
            1,
            3,
            6,
            0,
            2
        };

        int[] expected = {
            -1,100,50,81,-1,25,4
        };
        
        for (int testIndex = 0; testIndex < testArrs1.length; testIndex++)
        {
            int[] param1 = testArrs1[testIndex];
            int param2 = testIndexParam[testIndex];
            // For 1D arrays use .clone()
            int[] runParam1 = param1.clone();
     
            int run = ArrayLists.safeGet(runParam1, param2);
            String runResult = UTS.summarize(run);
            String declaration = "int[] expected = ";
            assertArrayEquals("Post Condition Failure",param1,runParam1);
           
            String params1 = UTS.summarize(param1);
            String params2 = UTS.summarize(param2);
            params1 += ", " + params2;
            params1 = UTS.summarizeParams(params1);           

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
    public void listSafeGet()
    {
        List<List<Integer>> testArrs1 = new ArrayList<List<Integer>>();
        testArrs1.add( new ArrayList<Integer>(Arrays.asList(900)) );
        testArrs1.add( new ArrayList<Integer>(Arrays.asList(25,16,36)) );
        testArrs1.add( new ArrayList<Integer>(Arrays.asList(25,16,36)) );
        testArrs1.add( new ArrayList<Integer>(Arrays.asList(4,25)) );
        testArrs1.add( new ArrayList<Integer>(Arrays.asList(25, 50, 100, 36, 81, 16)) );
        testArrs1.add( new ArrayList<Integer>(Arrays.asList(0,900)) );

        int[] testIndexParam = 
        {
            0,
            3,
            2,
            1,
            -5,
            0
        };
        
        Integer[] expected = {
            900,-1,36,25,-1,0
        };
        
        for (int testIndex = 0; testIndex < testArrs1.size(); testIndex++)
        {
            List<Integer> param1 = testArrs1.get(testIndex);
            int param2 = testIndexParam[testIndex];
            // For 1D arrays use .clone()
            List<Integer> origP1 = new ArrayList<>(param1);
     
            Integer run = ArrayLists.listSafeGet(param1, param2);
            String runResult = UTS.summarize(run);
            String declaration = "Integer[] expected = ";
            assertEquals("Post Condition Failure",param1,origP1);
           
            String params1 = UTS.summarize(param1);
            String params2 = UTS.summarize(param2);
            params1 += ", " + params2;
            params1 = UTS.summarizeParams(params1);           

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
    public void avgArray()
    {
        int[][] testArrs1 =
        {
            { 25 }, 
            { 25, 50, 100, 25 }, 
            { 25, 50, 100, -25, -50, -100 }, 
            { 18, 81, 36, 3, -18 }, 
            { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 },  
            { 3, 6, 9 }, 
            { -25, -54, 25 }, 
           
        };


        double[] expected = {
            25.0,50.0,0.0,24.0,11.0,6.0,-18.0
        };
        
        for (int testIndex = 0; testIndex < testArrs1.length; testIndex++)
        {
            int[] param1 = testArrs1[testIndex];
            // For 1D arrays use .clone()
            int[] runParam1 = param1.clone();
     
            double run = ArrayLists.avgArray(runParam1);
            String runResult = UTS.summarize(run);
            String declaration = "double[] expected = ";
            assertArrayEquals("Post Condition Failure",param1,runParam1);
           
            String params1 = UTS.summarize(param1);
            params1 = UTS.summarizeParams(params1);           

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
    public void avgList()
    {
       List<List<Integer>> testArrs1 = new ArrayList<List<Integer>>();
       testArrs1.add( new ArrayList<Integer>(Arrays.asList(25, 50, 100, 25)) );
       testArrs1.add( new ArrayList<Integer>(Arrays.asList(25, 50, 100, -25, -50, -100)) );
       testArrs1.add( new ArrayList<Integer>(Arrays.asList(8)) );
       testArrs1.add( new ArrayList<Integer>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)) );
       testArrs1.add( new ArrayList<Integer>(Arrays.asList(-25, -54, 25)) );
       testArrs1.add( new ArrayList<Integer>(Arrays.asList(3, 6, 9)) );

       double[] expected = {
           50.0,0.0,8.0,11.0,-18.0,6.0
        };
        
        for (int testIndex = 0; testIndex < testArrs1.size(); testIndex++)
        {
            List<Integer> param1 = testArrs1.get(testIndex);
            List<Integer> origP1 = new ArrayList<Integer>(param1);
     
            double run = ArrayLists.avgList(param1);
            String runResult = UTS.summarize(run);
            String declaration = "double[] expected = ";
            assertEquals("Post Condition Failure",param1,origP1);
           
            String params1 = UTS.summarize(param1);
            params1 = UTS.summarizeParams(params1);           

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
    public void byTwoArray()
    {
        int[] p1 =
        {
            1, 0, 2, 10, 100, 31
        };

        int[] p2 =
        {
            5, 4, 10, 3, 2, 5
        };

        
        int[][] expected = {
            {1,3,5,7,9},
            {0,2,4,6},
            {2,4,6,8,10,12,14,16,18,20},
            {10,12,14},
            {100,102},
            {31,33,35,37,39}
        };
        
        for (int testIndex = 0; testIndex < p1.length; testIndex++)
        {
            int param1 = p1[testIndex];
            int param2 = p2[testIndex];
            
            int[] run = ArrayLists.byTwoArray(param1, param2);
            String runResult = UTS.summarize(run);
            String declaration = "int[][] expected = ";
           
            String params1 = UTS.summarize(param1);
            String params2 = UTS.summarize(param2);
            params1 += ", " + params2;
            params1 = UTS.summarizeParams(params1);  
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
    public void byTwoList()
    {
       int[] p1 =
       {
           0, 1, 2, 101, 220, 29
       };

        int[] p2 =
        {
            4, 2, 9, 4, 3, 4
        };

       Integer[][] expectedAsArray = {
           {0,2,4,6},{1,3},{2,4,6,8,10,12,14,16,18},{101,103,105,107},{220,222,224},{29,31,33,35}
        };

        List<List<Integer>> expected = UTS.twoDArrayToList(expectedAsArray);
        
        
        for (int testIndex = 0; testIndex < p1.length; testIndex++)
        {
            int param1 = p1[testIndex];
            int param2 = p2[testIndex];
            
            List<Integer>run = ArrayLists.byTwoList(param1, param2);
            String runResult = UTS.summarize(run);
            String declaration = "int[][] expectedAsArray = ";
           
            String params1 = UTS.summarize(param1);
            String params2 = UTS.summarize(param2);
            params1 += ", " + params2;
            params1 = UTS.summarizeParams(params1);  
            
            String expect = "";
            if (expected != null && expected.size() > testIndex)
            {
                expect = UTS.summarize(expected.get(testIndex));
            }
            outputSummary(params1, expect, runResult, declaration);
        }
        awardPoints(1);        
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);
    }    
    
    @Test
    public void replaceAboveTarget()
    {
        double[][] testArrs1 =
        {
            { 1.,3.,5.,25.,16. }, 
            { 25., 50., 100., 25. }, 
            { 25., 50., 100., -25., -50., -100. }, 
            { 18., 81., 36., 3., -18. }, 
            { 2., 4., 6., 8., 10., 12., 14., 16. },  
            { 3., 6., 9. }, 
            { -25., -54., 25. }, 
           
        };
        
        double[] p2 =
        {
            6., 50., 99., 0., 0., 50., -26.
        };

        
        double[][] expected = {
            {1.0,3.0,5.0,-1.0,-1.0},
            {25.0,50.0,-1.0,25.0},
            {25.0,50.0,-1.0,-25.0,-50.0,-100.0},
            {-1.0,-1.0,-1.0,-1.0,-18.0},
            {-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0},
            {3.0,6.0,9.0},
            {-1.0,-54.0,-1.0}        
        };
        
        for (int testIndex = 0; testIndex < testArrs1.length; testIndex++)
        {
            double[] param1 = testArrs1[testIndex];
            double param2 = p2[testIndex];
            
            double[] origP1 = param1.clone();   
            
            double[] run = ArrayLists.replaceAboveTarget(origP1, param2);
            String runResult = UTS.summarize(run);
            String declaration = "double[][] expected = ";
           
           // assertEquals("Post Condition Failure",param1,origP1);
            
            String params1 = UTS.summarize(param1);
            String params2 = UTS.summarize(param2);
            params1 += ", " + params2;
            params1 = UTS.summarizeParams(params1);  
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
    public void listReplaceAboveTarget()
    {
        Double[][] testArrs1 =
        {
            { 25., 50., 100., 25. }, 
            { 25., 50., 100., -25., -50., -100. }, 
            { 18., 81., 36., 3., -18. }, 
            { 2., 4., 6., 8., 10., 12., 14., 16. },  
            { 3., 6., 9. }, 
            { -25., -54., 25. }, 
            { 1.,3.,5.,25.,16. }, 
  
        };
        
        List<List<Double>> testList1 = UTS.twoDArrayToList(testArrs1);
        
        List<Double> p2 =  new ArrayList<Double>(Arrays.asList(50., 99., 0., 0., 50., -26.,6.));

        Double[][] arrexpected = {
            {25.0,50.0,-1.0,25.0},{25.0,50.0,-1.0,-25.0,-50.0,-100.0},{-1.0,-1.0,-1.0,-1.0,-18.0},{-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0},{3.0,6.0,9.0},{-1.0,-54.0,-1.0},{1.0,3.0,5.0,-1.0,-1.0}
        };
        
        List<List<Double>> expected = UTS.twoDArrayToList(arrexpected);

        for (int testIndex = 0; testIndex < testArrs1.length; testIndex++)
        {
            List<Double> param1 = testList1.get(testIndex);
            Double param2 = p2.get(testIndex);
            
            List<Double> run = ArrayLists.listReplaceAboveTarget(param1, param2);
            String runResult = UTS.summarize(run);
            String declaration = "Double[][] expected = ";
           
            String params1 = UTS.summarize(param1);
            String params2 = UTS.summarize(param2);
            params1 += ", " + params2;
            params1 = UTS.summarizeParams(params1);  
            String expect = "";
            if (expected != null && expected.size() > testIndex)
            {
                expect = UTS.summarize(expected.get(testIndex));
            }
            outputSummary(params1, expect, runResult, declaration);
        }
        awardPoints(1);        
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);
    }      
    
    @Test
    public void removeBelowTarget()
    {
        double[][] testArrs1 =
        {
            { 1.,3.,5.,25.,16. }, 
            { 25., 50., 100., 25. }, 
            { 25., 50., 100., -25., -50., -100. }, 
            { 18., 81., 36., 3., -18. }, 
            { 2., 4., 6., 8., 10., 12., 14., 16. },  
            { 3., 6., 9. }, 
            { -25., -54., 25. }, 
           
        };
        
        double[] p2 =
        {
            6., 50., 99., 0., 0., 50., -26.
        };

        
        double[][] expected = {
            {25.0,16.0},
            {50.0,100.0},
            {100.0},
            {18.0,81.0,36.0,3.0},
            {2.0,4.0,6.0,8.0,10.0,12.0,14.0,16.0},
            {},
            {-25.0,25.0}       
        };
        
        for (int testIndex = 0; testIndex < testArrs1.length; testIndex++)
        {
            double[] param1 = testArrs1[testIndex];
            double param2 = p2[testIndex];
            
            double[] origP1 = param1.clone();
            
            double[] run = ArrayLists.removeBelowTarget(param1, param2);
            String runResult = UTS.summarize(run);
            String declaration = "double[][] expected = ";
           
            //assertEquals("Post Condition Failure",param1,origP1);            
            
            String params1 = UTS.summarize(param1);
            String params2 = UTS.summarize(param2);
            params1 += ", " + params2;
            params1 = UTS.summarizeParams(params1);  
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
    public void listRemoveBelowTarget()
    {
        Double[][] testArrs1 =
        {
            { 25., 50., 100., -25., -50., -100. }, 
            { 1.,3.,5.,25.,16. }, 
            { 25., 50., 100., 25. }, 
            { 18., 81., 36., 3., -18. }, 
            { 2., 4., 6., 8., 10., 12., 14., 16. },  
            { 3., 6., 9. }, 
            { -25., -54., 25. }, 
           
        };

        List<List<Double>> testList1 = UTS.twoDArrayToList(testArrs1);
        
        List<Double> p2 =  new ArrayList<Double>(Arrays.asList(99., 6., 50., 0., 10., 9., 0.));
        
        Double[][] arrexpected = {
            {100.0},{25.0,16.0},{50.0,100.0},{18.0,81.0,36.0,3.0},{10.0,12.0,14.0,16.0},{9.0},{25.0}
        };        
        List<List<Double>> expected =  UTS.twoDArrayToList(arrexpected);
        
        for (int testIndex = 0; testIndex < testArrs1.length; testIndex++)
        {
            List<Double> param1 = testList1.get(testIndex);
            Double param2 = p2.get(testIndex);
            
            List<Double> run = ArrayLists.listRemoveBelowTarget(param1, param2);
            String runResult = UTS.summarize(run);
            String declaration = "Double[][] expected = ";
           
            String params1 = UTS.summarize(param1);
            String params2 = UTS.summarize(param2);
            params1 += ", " + params2;
            params1 = UTS.summarizeParams(params1);  
            String expect = "";
            if (expected != null && expected.size() > testIndex)
            {
                expect = UTS.summarize(expected.get(testIndex));
            }
            outputSummary(params1, expect, runResult, declaration);
        }
        awardPoints(1);        
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);
    }      
        
    
}



