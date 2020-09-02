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
 * The test class PokerHandTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PokerHandTest
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
            System.out.println("RESULT Student: " + PokerHand.yourName());
            
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
     * Default constructor for test class PokerHandTest
     */
    public PokerHandTest()
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
        String studentName = PokerHand.yourName();
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
    public void isFlushTest()
    {
        PokerHand[] hands =
            {
                new PokerHand(new Card("diamond", 3),
                              new Card("diamond", 6),
                              new Card("diamond", 1),
                              new Card("diamond", 12),
                              new Card("diamond", 8)),
                new PokerHand(new Card("spade", 3),
                              new Card("diamond", 6),
                              new Card("diamond", 1),
                              new Card("diamond", 12),
                              new Card("diamond", 8)),
                new PokerHand(new Card("diamond", 2),
                              new Card("club", 2),
                              new Card("diamond", 1),
                              new Card("diamond", 12),
                              new Card("diamond", 8)),
                new PokerHand(new Card("club", 3),
                              new Card("club", 6),
                              new Card("club", 1),
                              new Card("heart", 12),
                              new Card("club", 8)),
               new PokerHand(new Card("diamond", 1),
                              new Card("diamond", 2),
                              new Card("diamond", 3),
                              new Card("diamond", 4),
                              new Card("diamond", 5))                
            };

        boolean[] expected =
            {
                true, false,false,false,true            
            };

        for (int testIndex = 0; testIndex < hands.length; testIndex++)
        {
            PokerHand hand = hands[testIndex];

            boolean run = hand.isFlush();
            
            String runResult = UTS.summarize(run);
            String declaration = "boolean expected = ";

            String params1 = UTS.summarize(hand.toString());

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
    public void isStraightTest()
    {
        PokerHand[] hands =
            {
                new PokerHand(new Card("diamond", 3),
                              new Card("diamond", 6),
                              new Card("diamond", 1),
                              new Card("diamond", 12),
                              new Card("diamond", 8)),
                new PokerHand(new Card("spade", 11),
                              new Card("diamond", 10),
                              new Card("club", 1),
                              new Card("spade", 12),
                              new Card("diamond", 13)),
                new PokerHand(new Card("diamond", 11),
                              new Card("club", 2),
                              new Card("diamond", 1),
                              new Card("diamond", 12),
                              new Card("diamond", 8)),
                new PokerHand(new Card("club", 3),
                              new Card("club", 6),
                              new Card("club", 1),
                              new Card("heart", 12),
                              new Card("club", 8)),
               new PokerHand(new Card("diamond", 4),
                              new Card("club", 2),
                              new Card("diamond", 3),
                              new Card("diamond", 1),
                              new Card("diamond", 5))                
            };

        boolean[] expected =
            {
                false, true,false,false,true            
            };

        for (int testIndex = 0; testIndex < hands.length; testIndex++)
        {
            PokerHand hand = hands[testIndex];

            boolean run = hand.isStraight();
            
            String runResult = UTS.summarize(run);
            String declaration = "boolean expected = ";

            String params1 = UTS.summarize(hand.toString());

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
    public void isPairTest()
    {
        PokerHand[] hands =
            {
                new PokerHand(new Card("diamond", 3),
                              new Card("spade", 1),
                              new Card("club", 1),
                              new Card("diamond", 12),
                              new Card("diamond", 8)),
                new PokerHand(new Card("spade", 11),
                              new Card("diamond", 10),
                              new Card("club", 1),
                              new Card("spade", 12),
                              new Card("diamond", 13)),
                new PokerHand(new Card("diamond", 11),
                              new Card("club", 2),
                              new Card("diamond", 1),
                              new Card("diamond", 12),
                              new Card("heart", 11)),
                new PokerHand(new Card("club", 3),
                              new Card("heart", 3),
                              new Card("club", 1),
                              new Card("heart", 12),
                              new Card("spade", 3)),
               new PokerHand(new Card("diamond", 4),
                              new Card("club", 2),
                              new Card("spade", 4),
                              new Card("diamond", 2),
                              new Card("heart", 5))                
            };

        boolean[] expected =
            {
                true, false,true,false,false            
            };

        for (int testIndex = 0; testIndex < hands.length; testIndex++)
        {
            PokerHand hand = hands[testIndex];

            boolean run = hand.isPair();
            
            String runResult = UTS.summarize(run);
            String declaration = "boolean expected = ";

            String params1 = UTS.summarize(hand.toString());

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
    public void isThreeOfAKindTest()
    {
        PokerHand[] hands =
            {
                new PokerHand(new Card("diamond", 3),
                              new Card("spade", 1),
                              new Card("club", 1),
                              new Card("diamond", 12),
                              new Card("diamond", 8)),
                new PokerHand(new Card("spade", 11),
                              new Card("diamond", 10),
                              new Card("club", 11),
                              new Card("spade", 12),
                              new Card("diamond", 11)),
                new PokerHand(new Card("spade", 11),
                              new Card("diamond", 10),
                              new Card("club", 11),
                              new Card("spade", 10),
                              new Card("diamond", 11)),
                new PokerHand(new Card("club", 3),
                              new Card("heart", 3),
                              new Card("club", 1),
                              new Card("heart", 12),
                              new Card("spade", 3)),
               new PokerHand(new Card("diamond", 1),
                              new Card("club", 2),
                              new Card("spade", 1),
                              new Card("diamond", 2),
                              new Card("heart", 1))                
            };

        boolean[] expected =
            {
                false, true,false,true,false            
            };

        for (int testIndex = 0; testIndex < hands.length; testIndex++)
        {
            PokerHand hand = hands[testIndex];

            boolean run = hand.isThreeOfAKind();
            
            String runResult = UTS.summarize(run);
            String declaration = "boolean expected = ";

            String params1 = UTS.summarize(hand.toString());

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
    public void isFourOfAKindTest()
    {
        PokerHand[] hands =
            {
                new PokerHand(new Card("diamond", 3),
                              new Card("spade", 1),
                              new Card("club", 1),
                              new Card("diamond", 12),
                              new Card("diamond", 8)),
                new PokerHand(new Card("spade", 11),
                              new Card("diamond", 11),
                              new Card("club", 11),
                              new Card("spade", 12),
                              new Card("heart", 11)),
                new PokerHand(new Card("spade", 11),
                              new Card("diamond", 10),
                              new Card("club", 11),
                              new Card("spade", 10),
                              new Card("diamond", 11)),
                new PokerHand(new Card("club", 3),
                              new Card("heart", 3),
                              new Card("diamond", 3),
                              new Card("heart", 12),
                              new Card("spade", 3)),
               new PokerHand(new Card("diamond", 1),
                              new Card("club", 2),
                              new Card("spade", 1),
                              new Card("diamond", 2),
                              new Card("heart", 1))                
            };

        boolean[] expected =
            {
                false, true,false,true,false            
            };

        for (int testIndex = 0; testIndex < hands.length; testIndex++)
        {
            PokerHand hand = hands[testIndex];

            boolean run = hand.isFourOfAKind();
            
            String runResult = UTS.summarize(run);
            String declaration = "boolean expected = ";

            String params1 = UTS.summarize(hand.toString());

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
    public void isFullHouseTest()
    {
        PokerHand[] hands =
            {
                new PokerHand(new Card("spade", 11),
                              new Card("diamond", 12),
                              new Card("club", 11),
                              new Card("spade", 12),
                              new Card("diamond", 11)),
                              
                new PokerHand(new Card("diamond", 3),
                              new Card("spade", 1),
                              new Card("club", 1),
                              new Card("diamond", 12),
                              new Card("diamond", 8)),
                
                new PokerHand(new Card("spade", 11),
                              new Card("diamond", 10),
                              new Card("club", 11),
                              new Card("spade", 10),
                              new Card("diamond", 11)),
                new PokerHand(new Card("club", 3),
                              new Card("heart", 3),
                              new Card("club", 1),
                              new Card("heart", 12),
                              new Card("spade", 3)),
               new PokerHand(new Card("diamond", 1),
                              new Card("club", 2),
                              new Card("spade", 1),
                              new Card("diamond", 2),
                              new Card("heart", 1))                
            };

        boolean[] expected =
            {
                true,false,true,false,true            
            };

        for (int testIndex = 0; testIndex < hands.length; testIndex++)
        {
            PokerHand hand = hands[testIndex];

            boolean run = hand.isFullHouse();
            
            String runResult = UTS.summarize(run);
            String declaration = "boolean expected = ";

            String params1 = UTS.summarize(hand.toString());

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
    public void isStraightFlushTest()
    {
        PokerHand[] hands =
            {
                new PokerHand(new Card("diamond", 3),
                              new Card("diamond", 6),
                              new Card("diamond", 1),
                              new Card("diamond", 12),
                              new Card("diamond", 8)),
                
                new PokerHand(new Card("diamond", 11),
                              new Card("club", 2),
                              new Card("diamond", 1),
                              new Card("diamond", 12),
                              new Card("diamond", 8)),
                new PokerHand(new Card("club", 3),
                              new Card("club", 6),
                              new Card("club", 1),
                              new Card("heart", 12),
                              new Card("club", 8)),
               new PokerHand(new Card("spade", 11),
                              new Card("spade", 10),
                              new Card("spade", 1),
                              new Card("spade", 12),
                              new Card("spade", 13)),               
               new PokerHand(new Card("diamond", 4),
                              new Card("diamond", 2),
                              new Card("diamond", 3),
                              new Card("diamond", 1),
                              new Card("diamond", 5))                
            };

        boolean[] expected =
            {
                false, false,false,true,true            
            };

        for (int testIndex = 0; testIndex < hands.length; testIndex++)
        {
            PokerHand hand = hands[testIndex];

            boolean run = hand.isStraightFlush();
            
            String runResult = UTS.summarize(run);
            String declaration = "boolean expected = ";

            String params1 = UTS.summarize(hand.toString());

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
}



