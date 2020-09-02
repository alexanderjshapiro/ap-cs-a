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
 * The test class StringListsTest.
 *
 * @author  Middler
 * @version 1
 */

public class StringListsTest
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
            System.out.println("RESULT: Version :" + StringListsTest.version);
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
    public StringListsTest()
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
        String studentName = StringLists.yourName();
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
    public void arraysAreEqual()
    {
        String[][] testArrs1 =
            {
                { "a" }, 
                { "a" }, 
                {"a","b","c"},
                {"a","b","c"},
                {"ab","cd"},
                {"This","is","so","fun"},
                {"This","is","so","fun"},
                {"This","so","fun"},
                {"This","so","fun"},
            };
            
        String[][] testArrs2 =
            {
                { "a" },
                { "ab" }, 
                {"a","b","c"},
                {"a","b","c", "d"},
                {"ab","cd"},
                {"This","is","so","fun"},
                {"This","is","so","fun","Agreed!"},
                {"This","not","fun"},
                {"This","so","fun","Agreed!"},
            };

            boolean[] expected = {
                true,false,true,false,true,true,false,false,false
            };

        
        for (int testIndex = 0; testIndex < testArrs1.length; testIndex++)
        {
            String[] param1 = testArrs1[testIndex];
            String[] param2 = testArrs2[testIndex];
            // For 1D arrays use .clone()
            String[] runParam1 = param1.clone();
            String[] runParam2 = param2.clone();
     
            boolean run = StringLists.arraysAreEqual(runParam1, runParam2);
            String runResult = UTS.summarize(run);
            String declaration = "boolean[] expected = ";
            assertArrayEquals("Post Condition Failure",param1,runParam1);
            assertArrayEquals("Post Condition Failure",param2,runParam2);
           
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
    public void arrayListsAreEqual()
    {
        List<List<String>> testArrs1 = new ArrayList<List<String>>();
        testArrs1.add( new ArrayList<String>(Arrays.asList("a")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("a", "b", "c")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("a")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("a", "b", "c")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("ab","cd")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("This","is","so","fun")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("This","is","so","fun")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("This","so","fun")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("This","so","fun")) );
        
        List<List<String>> testArrs2 = new ArrayList<List<String>>();
        testArrs2.add( new ArrayList<String>(Arrays.asList("a")) );
        testArrs2.add( new ArrayList<String>(Arrays.asList("a", "b", "c")) );
        testArrs2.add( new ArrayList<String>(Arrays.asList("ab")) );
        testArrs2.add( new ArrayList<String>(Arrays.asList("a", "b", "c", "d")) );
        testArrs2.add( new ArrayList<String>(Arrays.asList("ab","cd")) );
        testArrs2.add( new ArrayList<String>(Arrays.asList("This","is","so","fun")) );
        testArrs2.add( new ArrayList<String>(Arrays.asList("This","is","so","fun","Agreed!")) );
        testArrs2.add( new ArrayList<String>(Arrays.asList("This","so","fun","Agreed!")) );
        testArrs2.add( new ArrayList<String>(Arrays.asList("This","so","fun")) );

        boolean[] expected = {
            true,true,false,false,true,true,false,false,true
        };
        
        for (int testIndex = 0; testIndex < testArrs1.size(); testIndex++)
        {
            List<String> param1 = testArrs1.get(testIndex);
            List<String> param2 = testArrs2.get(testIndex);
            // For 1D arrays use .clone()
            //String[] runParam1 = param1.clone();
            //String[] runParam2 = param2.clone();
     
            boolean run = StringLists.arraysAreEqual(param1, param2);
            String runResult = UTS.summarize(run);
            String declaration = "boolean[] expected = ";
            //assertArrayEquals("Post Condition Failure",param1,runParam1);
            //assertArrayEquals("Post Condition Failure",param2,runParam2);
           
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
    public void strToArr()
    {
        String[]testStrings =
            {
                 "abcd" ,"a", "HellO", "Goodbye", "Whatever!", "S P A C E"
            };
            
            String[][] expected = 
            {
                {"a","b","c","d"},
                {"a"},
                {"H","e","l","l","O"},
                {"G","o","o","d","b","y","e"},
                {"W","h","a","t","e","v","e","r","!"},
                {"S"," ","P"," ","A"," ","C"," ","E"}
            };
            
        
        for (int testIndex = 0; testIndex < testStrings.length; testIndex++)
        {
            String param1 = testStrings[testIndex];
     
            String[] run = StringLists.strToArr(param1);
            String runResult = UTS.summarize(run);
            String declaration = "String[][] expected = ";
           
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
    public void stringToArr()
    {
        String[]testStrings =
            {
                 "HellO", "abcd" , "Goodbye", "YoWhatever!", "S P A C E", "a"
            };
           
        List<List<String>> expected = new ArrayList<List<String>>();
        expected.add( new ArrayList<String>(Arrays.asList("H","e","l","l","O")) );
        expected.add( new ArrayList<String>(Arrays.asList("a","b","c","d")) );
        expected.add( new ArrayList<String>(Arrays.asList("G","o","o","d","b","y","e")) );
        expected.add( new ArrayList<String>(Arrays.asList("Y","o","W","h","a","t","e","v","e","r","!")) );
        expected.add( new ArrayList<String>(Arrays.asList("S"," ","P"," ","A"," ","C"," ","E")) );
        expected.add( new ArrayList<String>(Arrays.asList("a")) );

        
        for (int testIndex = 0; testIndex < testStrings.length; testIndex++)
        {
            String param1 = testStrings[testIndex];
     
            List<String> run = StringLists.stringToArr(param1);
            String runResult = UTS.summarize(run);
            String declaration = "String[][] expected = ";
           
            String params1 = UTS.summarize(param1);
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
    public void firstOccursAtIndex()
    {
        String[][] testArrs1 =
            {
                { "hello","I","must","be","going"}, 
                { "hello","I","must","be","going"}, 
                {"hello","hello","I","must","be","going"},
                {"hello","hello","hello","hello"},
                {"hello","hello","hello","hello"},
                {"a","b","b","a"},
                {"a","b","b","a"},
                {"ab","bc","cb","ca"},
                {"ca","cb","cb","ca"},
            };       
        String[]testStrings =
            {
                 "where" ,"going", "hello", "hello", "llo", "b", "a", "b", "cb"
            };
            
        int[] expected = {
            -1,4,0,0,-1,1,0,-1,1
        };
            
        
        for (int testIndex = 0; testIndex < testStrings.length; testIndex++)
        {
            String[] param1 = testArrs1[testIndex];
     
            int run = StringLists.firstOccursAtIndex(param1,testStrings[testIndex]);
            String runResult = UTS.summarize(run);
            String declaration = "int[] expected = ";
           
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
    public void firstOccursAtIndexList()
    {
        List<List<String>> testArrs1 = new ArrayList<List<String>>();
        testArrs1.add( new ArrayList<String>(Arrays.asList("hello","I","must","be","going")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("hello","hello","I","must","be","going")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("hello","hello","hello","hello")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("hello","hello","hello","hello")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("a","b","b","a")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("a","b","b","a")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("ab","bc","cb","ca")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("ca","cb","cb","ca")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("hello","I","must","be","going")) );
        
        String[]testStrings =
            {
                 "going", "hello", "hello", "llo", "b", "a", "b", "cb", "where" 
            };
            
        int[] expected = {
                4,0,0,-1,1,0,-1,1,-1
            };
            
        
        for (int testIndex = 0; testIndex < testStrings.length; testIndex++)
        {
            List<String> param1 = testArrs1.get(testIndex);
            String param2 = testStrings[testIndex];
     
            int run = StringLists.firstOccursAtIndex(param1,param2);
            String runResult = UTS.summarize(run);
            String declaration = "int[] expected = ";
           
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
    public void swapFirstLast()
    {
        String[][] testStrings =
            {
                { "hello","I","must","be","going"}, 
                { "I","Palindrome","I"}, 
                { "going", "to", "a", "party"},
                {"a","b","c","d"},
                {"d","b","c","a"},
            };       
            
        String[][] expected = 
        {
            {"going","I","must","be","hello"},
            {"I","Palindrome","I"},
            {"party","to","a","going"},
            {"d","b","c","a"},
            {"a","b","c","d"}
        };
            
        
        for (int testIndex = 0; testIndex < testStrings.length; testIndex++)
        {
            String[] param1 = testStrings[testIndex];
     
            String[] run = StringLists.swapFirstLast(param1);
            String runResult = UTS.summarize(run);
            String declaration = "String[][] expected = ";
            
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
    public void swapFirstLastList()
    {
        List<List<String>> testStrings = new ArrayList<List<String>>();
        testStrings.add( new ArrayList<String>(Arrays.asList("d","b","c","a")) );
        testStrings.add( new ArrayList<String>(Arrays.asList("hello","I","must","be","going")) );
        testStrings.add( new ArrayList<String>(Arrays.asList("going", "to", "a", "party")) );
        testStrings.add( new ArrayList<String>(Arrays.asList("a","b","c","d")) );
        testStrings.add( new ArrayList<String>(Arrays.asList("I","Palindrome","I")) );

        List<List<String>> expected = new ArrayList<List<String>>();
        expected.add( new ArrayList<String>(Arrays.asList("a","b","c","d")) );
        expected.add( new ArrayList<String>(Arrays.asList("going","I","must","be","hello")) );
        expected.add( new ArrayList<String>(Arrays.asList("party", "to", "a", "going")) );
        expected.add( new ArrayList<String>(Arrays.asList("d","b","c","a")) );
        expected.add( new ArrayList<String>(Arrays.asList("I","Palindrome","I")) );

        
        for (int testIndex = 0; testIndex < testStrings.size(); testIndex++)
        {
            List<String> param1 = testStrings.get(testIndex);
            List<String> origP1 = new ArrayList<>(param1);
            List<String> run = StringLists.swapFirstLast(param1);
            String runResult = UTS.summarize(run);
            String declaration = "String[][] expected = ";
            
            String params1 = UTS.summarize(origP1);
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
    public void removeTarget()
    {
        String[][] testArrs1 =
            {
                { "hello","I","must","be","going"}, 
                { "hello","I","must","be","going"}, 
                {"hello","hello","I","must","be","going"},
                {"hello","hello","hello","hello"},
                {"hello","hello","hello","hello"},
                {"a","b","b","a", "a","b","b","a"},
                {"a","b","b","a"},
                {"ab","bc","cb","ca"},
                {"ca","cb","cb","ca"},
            };       
        String[]testStrings =
            {
                 "hello" ,"going", "hello", "hello", "llo", "b", "a", "ca", "acb"
            };
            
        String[][] expected = {
                {"I","must","be","going"},
                {"hello","I","must","be"},
                {"I","must","be","going"},
                {},
                {"hello","hello","hello","hello"},
                {"a","a","a","a"},
                {"b","b"},
                {"ab","bc","cb"},
                {"ca","cb","cb","ca"}
            };            
           
        
        for (int testIndex = 0; testIndex < testStrings.length; testIndex++)
        {
            String[] param1 = testArrs1[testIndex];
            String param2 = testStrings[testIndex];
            String[] run = StringLists.removeTarget(param1,param2);
            String runResult = UTS.summarize(run);
            String declaration = "String[][] expected = ";

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
    public void removeTargetList()
    {
        List<List<String>> testArrs1 = new ArrayList<List<String>>();
        testArrs1.add( new ArrayList<String>(Arrays.asList("hello","I","must","be","going")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("hello","hello","I","must","be","going")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("hello","hello","hello","hello")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("hello","hello","hello","hello")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("a","b","b","a", "a","b","b","a")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("a","b","b","a")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("ab","bc","cb","ca")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("ca","cb","cb","ca")) );
        testArrs1.add( new ArrayList<String>(Arrays.asList("hello","I","must","be","going")) );
        
        String[] testStrings =
            {
                 "going", "hello", "hello", "llo", "b", "b", "ab", "ca", "acb" 
            };
            
        List<List<String>> expected = new ArrayList<List<String>>();
        expected.add(new ArrayList<String>(Arrays.asList( "hello","I","must","be" )));
        expected.add(new ArrayList<String>(Arrays.asList( "I","must","be","going" )));
        expected.add(new ArrayList<String>());
        expected.add(new ArrayList<String>(Arrays.asList( "hello","hello","hello","hello" )));
        expected.add(new ArrayList<String>(Arrays.asList( "a","a","a","a" )));
        expected.add(new ArrayList<String>(Arrays.asList( "a","a" )));
        expected.add(new ArrayList<String>(Arrays.asList( "bc","cb","ca" )));
        expected.add(new ArrayList<String>(Arrays.asList( "cb","cb" )));
        expected.add(new ArrayList<String>(Arrays.asList( "hello","I","must","be","going" )));       
        
        for (int testIndex = 0; testIndex < testStrings.length; testIndex++)
        {
            List<String> param1 = testArrs1.get(testIndex);
            List<String> origP1 = new ArrayList<>(param1);
            String param2 = testStrings[testIndex];
     
            List<String> run = StringLists.removeTarget(param1,param2);
            String runResult = UTS.summarize(run);
            String declaration = "List<String> expected = ";
           
            String params1 = UTS.summarize(origP1);
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



