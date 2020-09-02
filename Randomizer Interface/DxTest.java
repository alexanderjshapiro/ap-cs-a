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
import java.io.Console;
import java.nio.charset.Charset;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import static java.lang.System.out;
/**
 * The test class DxTest.
 *
 * @author  Braskin, Aaron
 * @version 2/10/17
 */
public class DxTest
{
    static int version = 1;
    private List<Class> classesToTest;
    private List<Integer> numSides;
    private static boolean outputRunToConsole = false;
    private static final int REPEAT_TEST = 10000;
    private static final double ALLOWED_VARIANCE = .015;
    @Test
    public void test_Dx_00_DefaultConstructorAndGetNumFaces()
    {
        for (int classI = 0; classI < classesToTest.size(); classI++)
        {
            Class clazz = classesToTest.get(classI);
            int expectedNumSides = numSides.get(classI);
            String className = clazz.getSimpleName();
            try {
                Constructor[] ctors = clazz.getDeclaredConstructors();
                Constructor ctor = null;
                for (int i = 0; i < ctors.length; i++) {
                    ctor = ctors[i];
                    if (ctor.getGenericParameterTypes().length == 0)
                        break;
                }

                ctor.setAccessible(true);
                Randomizer die = (Randomizer)ctor.newInstance();
                int i = die.getNumFaces();
                String callParams = "\nRandomizer die = new " + className + "();\ndie.getNumFaces();\n";

                String runResult ="" + i;
                String expect =  "" + expectedNumSides;
                outputSummary(callParams, expect, runResult, "");
                awardPoints(1);   
            }
            catch (Exception e)
            {
                outputSummary("Instantiation Error: " + e.getMessage(),"Dx",className,"");
            }
        }

        if (!allPassed) 
            assertEquals(summary, firstFailExpected, firstFailRun);
    }

    @Test
    public void test_Dx_01_GetFace()
    {
        for (int classI = 0; classI < classesToTest.size(); classI++)
        {
            Class clazz = classesToTest.get(classI);
            int expectedNumSides = numSides.get(classI);
            String className = clazz.getSimpleName();
            try {
                Constructor[] ctors = clazz.getDeclaredConstructors();
                Constructor ctor = null;
                for (int i = 0; i < ctors.length; i++) {
                    ctor = ctors[i];
                    if (ctor.getGenericParameterTypes().length == 0)
                        break;
                }

                ctor.setAccessible(true);
                Randomizer die = (Randomizer)ctor.newInstance();
                int faces = die.getNumFaces();
                for (int i = 1; i <= faces; i ++)
                {
                    String callParams = "\nRandomizer die = new " + className + "();\n.getFace("+i+")";

                    String runResult = "" + die.getFace(i);
                    String expect = "" + i;
                    outputSummary(callParams, expect, runResult, "");

                }

            }
            catch (Exception e)
            {
                outputSummary("Instantiation Error: " + e.getMessage(),"Dx",className,"");
            }
        }
        awardPoints(1);        
        if (!allPassed) 
            assertEquals(summary, firstFailExpected, firstFailRun);

    }   

    @Test
    public void test_Dx_02_Randomize_GetCurrentValue_GetCurrentFace()
    {
        for (int classI = 0; classI < classesToTest.size(); classI++)
        {
            Class clazz = classesToTest.get(classI);
            int expectedNumSides = numSides.get(classI);
            String className = clazz.getSimpleName();
            try {
                Constructor[] ctors = clazz.getDeclaredConstructors();
                Constructor ctor = null;
                for (int i = 0; i < ctors.length; i++) {
                    ctor = ctors[i];
                    if (ctor.getGenericParameterTypes().length == 0)
                        break;
                }

                ctor.setAccessible(true);
                Randomizer die = (Randomizer)ctor.newInstance();
                String[] faces = new String[expectedNumSides];
                int[] faceCount = new int[expectedNumSides];

                for (int i = 0; i < REPEAT_TEST; i++)
                {
                    die.randomize();
                    int faceIndex = die.getCurrentValue() - 1;
                    String face = die.getCurrentFace();
                    faceCount[faceIndex]++;
                    if (faceIndex >= 0 && faceIndex < expectedNumSides && faces[faceIndex] == null)
                    {
                        faces[faceIndex] = face;
                       
                    }
                }
                for (int i = 0; i < die.getNumFaces(); i++)
                {
                    String callParams = "\nRandomizer die = new " + className + "();\nChecking face #" + (i + 1);
                    String runResult = faces[i];
                    String expect = "" + die.getFace(i + 1);
                    outputSummary(callParams, expect, runResult, "");
                    int expectedNum =(int)(1 / (double)die.getNumFaces() * REPEAT_TEST);
                    int actualNum = faceCount[i];
                    int variance = Math.abs(expectedNum - actualNum);
                    double variancePercent = (double)variance / REPEAT_TEST;
                    
                    callParams = "\nRandomizer die = new " + className + "();\nChecking Random Distribution on face #" + (i + 1);
                    
                    if (variancePercent > ALLOWED_VARIANCE)
                    {
                        String expectedS = expectedNum + "/" + REPEAT_TEST + ", Variance: " + variancePercent;
                        String actualS =  actualNum + "/" + REPEAT_TEST + ", Allowed Variance: " + ALLOWED_VARIANCE;
                        outputSummary(callParams, expectedS, actualS, "");
                    }
                    
                }                
            }
            catch (Exception e)
            {
                outputSummary("Instantiation Error: " + e.getMessage(),"Dx",className,"");
            }
        }

        awardPoints(1);        
        if (!allPassed) 
            assertEquals(summary, firstFailExpected, firstFailRun);
    }   
/*
    @Test
    public void test_Dx_03_toString()
    { for (int classI = 0; classI < classesToTest.size(); classI++)
        {
            Class clazz = classesToTest.get(classI);
            int expectedNumSides = numSides.get(classI);
            String className = clazz.getSimpleName();
            try {
                Constructor[] ctors = clazz.getDeclaredConstructors();
                Constructor ctor = null;
                for (int i = 0; i < ctors.length; i++) {
                    ctor = ctors[i];
                    if (ctor.getGenericParameterTypes().length == 0)
                        break;
                }

                ctor.setAccessible(true);
                Randomizer die = (Randomizer)ctor.newInstance();

                int numFaces = die.getNumFaces();
                for (int i = 0; i < REPEAT_TEST; i++)
                {
                    die.randomize();
                    int val = die.getCurrentValue();
                    String callParams = "\nRandomizer die = new " + className + "();\ntoString() when current value is " + val;
                    String expect = "d" + numFaces + " = " + die.getFace(val);
                    String runResult = die.toString();
                    if (!expect.equals(runResult))
                    {
                        outputSummary(callParams, expect, runResult, "");
                    }
                }
            }
            catch (Exception e)
            {
                outputSummary("Instantiation Error: " + e.getMessage(),"Dx",className,"");
            }
        }

        awardPoints(1);        
        if (!allPassed) 
            assertEquals(summary, firstFailExpected, firstFailRun);
    }   
*/
    /**
     * Default constructor for test class DxTest
     */
    public DxTest()
    {   
        classesToTest = new ArrayList<Class>();
        numSides = new ArrayList<Integer>();
        for (int i = 2; i <=100; i++)
        {
            String className = "D" + i;
            try {
                Class clazz = Class.forName(className);
                classesToTest.add(clazz);
                numSides.add(i);
            }
            catch (ClassNotFoundException e) 
            {
            }
        }   
        if (classesToTest.size() == 0)
        {
            outputSummary("No Dx Classesd Found!", "Class Dx", "", "");
        }
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
            System.out.println("RESULT: Version :" + DxTest.version);
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
