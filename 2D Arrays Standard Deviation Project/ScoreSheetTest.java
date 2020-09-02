
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.lang.reflect.Array;
/**
 * The test class Fill2DTest.
 *
 * @author  Aaron Braskin and Mitch Middler
 * @version 11/21/2016
 */
public class ScoreSheetTest
{
    private static String summary = "";
    private static boolean allPassed = true;
    private static String firstFailExpected = null;
    private static String firstFailRun = null;
    private static String captureSummary = "";
    /**
     * This method will return a 2 dimensional array that calculates the square of the difference between the value
     * and the average of the row.  The avarage of the row was already calculated for you and passed in as a parameter.
     * You will do the calculation and store the result back into the same element of the scores array for which you 
     * are calculating the result.  At the end of the method, simply return the scores array.
     * 
     * @param   scores      2D array of scores
     * @param   average     1D array representing the average of each row of scores
     * @return  diffSquared 2D array
     */

    @Test
    public void scoresLessMeanSquared()
    {
        double[][][] testsScores =
            {
                {
                    {50,75,100},
                    {75,75,75},
                    {85,90,92},
                    {90,92,97},
                },
                {
                    {85},
                    {80}
                },
                {
                    {75,76},
                    {74,75},
                    {100,100}
                }

            };
        double[][] testsAverage =
            {
                {75.0,75.0,89.0,93.0},
                {85.0,80.0},
                {75.5,74.5,100.0}
            };
        double[][][] expected = 
            {
                {
                    {625.0,0.0,625.0},
                    {0.0,0.0,0.0},
                    {16.0,1.0,9.0},
                    {9.0,1.0,16.0}
                },
                {
                    {0.0},
                    {0.0}
                },
                {
                    {0.25,0.25},
                    {0.25,0.25},
                    {0.0,0.0}
                }
            };
        for (int testIndex = 0; testIndex < testsScores.length; testIndex++)
        {
            double[][] paramScores = testsScores[testIndex];
            double[] paramAverage = testsAverage[testIndex];
            double[][] run = ScoreSheet.scoresLessMeanSquared(paramScores, paramAverage);
            String declaration = "double[] expected = ";
            assertNotNull("Array Is Null",run);
            String params = summarize(paramScores) + "," + summarize(paramAverage);
            // The version below is for the students:
            outputSummary(summarizeParams(params), summarize(expected[testIndex]), summarize(run), null);
        }
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);

    }

    private String summarizeParams(String params)
    {

        return "(" + params + ")";
    }

    /**
     * This method will return an array that calculates the standard deviation of all of the columns
     * in each row of the given array.
     * 
     * To caluclauate the standard deviation, perform the following steps:
     * 1: Use your calcAvg method to get the average value for each row
     * 2: Use your scoresLessMeanSquared method to calculate the square of the difference of each value with the row's avarage
     * 3: Use your calAvg again to get the average of what was calculated in step 2.
     * 4: Calculate the square root of each value in the array returned by step 3.
     * 5: return the results of step 4.
     * 
     * @param   scores      2D array of scores
     * @return  1D array representing the standard deviation in each row of scores.
     */    

    @Test
    public void stdDev()
    {
        double[][][] testsScores =
            {
                {
                    {50,75,100},
                    {75,75,75},
                    {85,90,92},
                    {90,92,97},
                },
                {
                    {85},
                    {80}
                },
                {
                    {75,76},
                    {74,75},
                    {100,100}
                }

            };
        double[][] expected = 
            {
                {20.412414523193153,0.0,2.943920288775949,2.943920288775949},
                {0.0,0.0},
                {0.5,0.5,0.0}
            };
        for (int testIndex = 0; testIndex < testsScores.length; testIndex++)
        {
            double[][] paramScores = testsScores[testIndex];
            double[] run = ScoreSheet.stdDev(paramScores);
            String declaration = "double[] expected = ";
            assertNotNull("Array Is Null",run);
            String params = summarize(paramScores);
            // The version below is for the students:
            outputSummary(summarizeParams(params), summarize(expected[testIndex]), summarize(run), null);
        }
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);

    }

    @SuppressWarnings("unchecked")
    public static <T> T[] deepCopyOf(T[] array) {

        if (0 >= array.length) return array;

        return (T[]) deepCopyOf(
            array, 
            Array.newInstance(array[0].getClass(), array.length), 
            0);
    }

    private static Object deepCopyOf(Object array, Object copiedArray, int index) {

        if (index >= Array.getLength(array)) return copiedArray;

        Object element = Array.get(array, index);

        if (element.getClass().isArray()) {

            Array.set(copiedArray, index, deepCopyOf(
                    element,
                    Array.newInstance(
                        element.getClass().getComponentType(),
                        Array.getLength(element)),
                    0));

        } else {

            Array.set(copiedArray, index, element);
        }

        return deepCopyOf(array, copiedArray, ++index);
    }    

    @Test
    public void calcAvg()
    {
        double[][][] tests =
            {
                {
                    {50,75,100},
                    {75,75,75},
                    {85,90,92},
                    {90,92,97},
                },
                {
                    {85},
                    {80}
                },
                {
                    {75,76},
                    {74,75},
                    {100,100}
                }

            };
        double[][] expected =
            {
                {75.0,75.0,89.0,93.0},
                {85.0,80.0},
                {75.5,74.5,100.0}
            };
        for (int testIndex = 0; testIndex < tests.length; testIndex++)
        {
            double[][] params = tests[testIndex];
            double[] run = ScoreSheet.calcAvg(params);
            String declaration = "double[] expected = ";
            assertNotNull("Array Is Null",run);
            // The version below is for the students:
            outputSummary(summarize(params), summarize(expected[testIndex]), summarize(run), null);
        }
        if (!allPassed) assertEquals(summary, firstFailExpected, firstFailRun);

    }

    /**
     * Remove before distribution to students
     */
    private static double[] calcAvg(double[][] scores)
    {
        double[] avg = new double[scores.length];
        for (int r = 0; r < scores.length; r++)
        {
            double total = 0;
            for (int c = 0; c < scores[r].length; c++)
            {
                total += scores[r][c];
            }
            avg[r] = total / scores[r].length;
        }
        return avg;
    }

    /**
     * This method adds the values passed to this method to the $captureSummary instance variable
     * each time it is called.
     * 
     * It should be called once for each test result in your test group.
     * 
     * If the expected and run Strings don't match then it will be included in the summary.
     * 
     * This method also takes a parameter String declaration that will be prepended to the summary in
     * place of the normal output so that it can be easily copied and pasted into a test method.
     * 
     * If declaration is null then only the calling method with psuedo parameters along with the
     * expected and run results.
     * 
     * if declaration has a value then (see below for optimal format) it will be included in the summary.
     * SUGGESTED declaration format:
     * type variableName =
     * 
     * If a method call does <b>not</b> survive the test then another check is made to see if this
     * is the first method that has failed and if it is the failed call expected and run are recorded so that
     * they can be used in an assert that will fail.
     * 
     * @param   parameters      the values passed as parameters to the called method.
     * @param   expected        specifies what the method <b>should</b> return as it's
     *                          results.
     * @param   run             specifies the results when run from the student's class
     * @param   declaration     If <em>not</em> null then a line is ouput to the console that includes
     *                          the exact java code needed to make the method call that can be pasted
     *                          into a code editor.
     * @return  boolean         the summary of calling the test method including the method name,
     *                          optionally as a valid method call, so it is a valid declaration,
     *                          the parameters and a ;
     */
    private static boolean outputSummary(String parameters, String expected, String run, String declaration)
    {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];
        String methodName = e.getMethodName();
        summary += methodName + parameters + "\n";
        if (declaration != null)
        {
            System.out.println(declaration + expected + ";"); 
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

    /**
     * Returns a String that summarizes the contents of the array.
     * For example: give an array of three elements:
     *  arr[0] = 5, arr[1] = 10, arr[2] = 15 the result is:
     *  {5,10,15}
     * @param  arr   the array to summarize
     * @return     String in the form {arr[0],arr[...],arr[arr.length -1]}
     *
     */
    public  String summarize(int[] arr)
    {
        String s = "{";
        for (int i = 0; i < arr.length; i++)
        {
            s += arr[i];
            if (i < arr.length - 1)
            {
                s += ",";
            }
        }
        s += "}";
        return s;
    }

    /**
     * Returns a String that summarizes the contents of the array.
     * For example: give an array of three elements:
     *  arr[0] = 5.0, arr[1] = 10.5, arr[2] = 15.75 the result is:
     *  {5.0,10.5,15.75}
     * @param  arr   the array to summarize
     * @return     String in the form {arr[0],arr[...],arr[arr.length -1]}
     *
     */
    public static String summarize(double[] arr)
    {
        String s = "{";
        for (int i = 0; i < arr.length; i++)
        {
            s += arr[i];
            if (i < arr.length - 1)
            {
                s += ",";
            }
        }
        s += "}";
        return s;
    }

    /**
     * Returns a String that summarizes the contents of the array.
     * For example: give an array of three elements:
     *  arr[0] = "A", arr[1] = "BC", arr[2] = "DEF" the result is:
     *  {"A","BC","DEF"}
     * @param  arr   the array to summarize
     * @return     String in the form {arr[0],arr[...],arr[arr.length -1]}
     *
     */
    public static String summarize(String[] arr)
    {
        String s = "{";
        for (int i = 0; i < arr.length; i++)
        {
            s += "\"" + arr[i] + "\"";
            if (i < arr.length - 1)
            {
                s += ",";
            }
        }
        s += "}";
        return s;
    }

    /**
     * Returns a String that summarizes the contents of the array in row major order.
     * For example: give an array of three elements:
     *  arr2d[0][0] = 5, arr2d[0][1] = 10, arr2d[1][0] = 15, arr2d[1][1] = 20 the result is:
     *  {{5,10},{15,20}}
     * @param  arr   the array to summarize
     * @return     String in the form {{r0c0,r0c...},{r...c0,r...c...}}
     *
     */
    public static String summarize(int[][] arr2d)
    {
        String s = "{";
        for (int r = 0; r < arr2d.length; r++)
        {
            s += "{";
            for (int c = 0; c < arr2d[r].length; c++)
            {
                s += arr2d[r][c];
                if (c < arr2d[r].length - 1)
                {
                    s += ",";
                }
            }
            s += "}";
            if (r < arr2d.length - 1)
            {
                s += ",";
            }
        }
        s += "}";
        return s;
    }

    /**
     * Returns a String that summarizes the contents of the array in row major order.
     * @param  arr   the array to summarize
     * @return     String in the form {{r0c0,r0c...},{r...c0,r...c...}}
     *
     */
    public static String summarize(double[][] arr2d)
    {
        String s = "{";
        for (int r = 0; r < arr2d.length; r++)
        {
            s += "{";
            for (int c = 0; c < arr2d[r].length; c++)
            {
                s += arr2d[r][c];
                if (c < arr2d[r].length - 1)
                {
                    s += ",";
                }
            }
            s += "}";
            if (r < arr2d.length - 1)
            {
                s += ",";
            }
        }
        s += "}";
        return s;
    }

    /**
     * Returns a String that summarizes the contents of the array in row major order.
     * For example: give an array of three elements:
     *  arr[0][0] = "A", arr[0][1] = "BC", arr[1][0] = "DEF", arr[1][1] the result is:
     *  {{"A","BC"},{"DEF","GHIJ"}}
     * @param  arr   the array to summarize
     * @return     String in the form {{r0c0,r0c...},{r...c0,r...c...}}
     *
     */
    public static String summarize(String[][] arr2d)
    {
        String s = "{";
        for (int r = 0; r < arr2d.length; r++)
        {
            s += "{";
            for (int c = 0; c < arr2d.length; c++)
            {
                s += "\"" + arr2d[r][c] + "\"";
                if (c < arr2d[r].length - 1)
                {
                    s += ",";
                }
            }
            s += "}";
            if (r < arr2d.length - 1)
            {
                s += ",";
            }
        }
        s += "}";
        return s;
    }    

    /**
     * Default constructor for test class ScoreSheetTest
     */
    public ScoreSheetTest()
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
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
