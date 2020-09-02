
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Fill2DTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Fill2DTest
{
    private static final boolean OUTPUT_SUMMARY = false;
     @Test
    public void boxFill()
    {
        int[][] tests =
            {
                {3,3,1,2},
                {9,2,9,8},
                {4,6,5,5},
                {5,5,3,2}
            };
        for (int[] params : tests)
        {
            int[][] expected = boxFill(params[0], params[1], params[2], params[3]);
            int[][] arr = new int[params[0]][params[1]];
            int[][] run = Fill2D.boxFill(arr, params[2], params[3]);
            
            assertArrayEquals("Expected:\t" + summarize(expected)+"\nRun:\t" + summarize(run)+"\n",expected, run);
        }

    }
    private static int[][] boxFill(int rows, int cols, int border, int interior)
    {
        int[][] arr2d = new int[rows][cols];
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                if (r == 0 || c == 0 || r == rows - 1 || c == cols - 1)
                {
                    arr2d[r][c] = border;
                }
                else
                {
                    arr2d[r][c] = interior;
                }
            }
        }
        return arr2d;
    }
    @Test
    public void yourName()
    {
        String studentName = Fill2D.yourName();
        if (studentName == null || studentName.equals(""))
        {
            System.out.println("Student did not complete the yourName method!");
            assertNotNull(studentName);
        }
        else
        {
            System.out.println("RETURN " + studentName);
        }
    }        
   @Test
    public void fill_lToR_rToL()
    {
        int[][] tests =
            {
                {3,3},
                {9,2},
                {4,6},
                {5,5}
            };
        for (int[] params : tests)
        {
            int[][] expected = fill_lToR_rToL(params[0], params[1]);
            int[][] arr = new int[params[0]][params[1]];
            int[][] run = Fill2D.fill_lToR_rToL(arr);
            if (OUTPUT_SUMMARY)
            {
              String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
              System.out.println("Method: " + methodName);
              System.out.println("Parameters: " + summarize(params));
              System.out.println("Expected:\t" + summarize(expected)+"\nRun:\t" + summarize(run));
            }
            assertArrayEquals("Expected:\t" + summarize(expected)+"\nRun:\t" + summarize(run)+"\n",expected, run);
        }

    }
    private static int[][] fill_lToR_rToL(int rows, int cols)
    {
        int cnt = 1;
        int[][] arr2d = new int[rows][cols];
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                if (r % 2 == 0)
                {
                    arr2d[r][c] = cnt;
                }
                else
                {
                    arr2d[r][cols - c - 1] = cnt;
                }
                cnt++;
            }
        }
        return arr2d;        
    }
    
    
    @Test
    public void multMatrixByVector()
    {
        int[][] test1M =
            {
                {1,2,3},
                {4,5,6},
                {7,8,9}
            };
        int[] test1V = { 2,1,3 };
        
        int[] expected = multMatrixByVector(test1M, test1V);
        int[] run = Fill2D.multMatrixByVector(test1M, test1V);
            
        assertArrayEquals("Expected:\t" + summarize(expected)+"\nRun:\t" + summarize(run)+"\n",expected, run);
        
        int[][] test2M =
            {
                {5,1,2,3},
                {1,4,5,6},
                {0,7,8,9},
                {1,1,1,1}
            };
        int[] test2V = { 2,2,1,3 };
        expected = multMatrixByVector(test2M, test2V);
        run = Fill2D.multMatrixByVector(test2M, test2V);

        assertArrayEquals("Expected:\t" + summarize(expected)+"\nRun:\t\t\t" + summarize(run)+"\n",expected, run);
    }
    
    private static int[] multMatrixByVector(int[][] matrix, int[] vector)
    {
        int[] out = new int[vector.length];
        
        for (int r = 0; r < matrix.length; r++) 
        {
            int sum = 0;
            for (int c = 0; c < matrix[r].length; c++) 
            {
                sum += matrix[r][c] * vector[c];
            }
            out[r] = sum;
        }

        return out;     
    }
    
    @Test
    public void multMatrixByMatrix()
    {
        int[][] test1M =
            {
                {1,2},
                {3,4}
            };
        int[][] test2M =
            {
                {5,6},
                {7,8}
            };
        
        int[][] expected = multMatrixByMatrix(test1M, test2M);
        int[][] run = Fill2D.multMatrixByMatrix(test1M, test2M);
            
        assertArrayEquals("Expected:\t" + summarize(expected)+"\nRun:\t" + summarize(run)+"\n",expected, run);

        int[][] test3M =
            {
                {1,2,3},
                {3,4,5},
                {3,2,0}
            };
        int[][] test4M =
            {
                {5,6,1},
                {7,8,1},
                {2,3,1},
            };        

        expected = multMatrixByMatrix(test3M, test4M);
        run = Fill2D.multMatrixByMatrix(test3M, test4M);
            
        assertArrayEquals("Expected:\t" + summarize(expected)+"\nRun:\t" + summarize(run)+"\n",expected, run);
            
            
    }
    
    private static int[][] multMatrixByMatrix(int[][] matrix1, int[][] matrix2)
    {
        int[][] out = new int[matrix1.length][matrix1.length];
        
        for (int r = 0; r < matrix1.length; r++) 
        {
            for (int c = 0; c < matrix1[r].length; c++) 
            {
                int sum = 0;

                for (int m = 0; m < matrix1[r].length; m++) 
                {
                    sum += matrix1[r][m] * matrix2[m][c];
                }
                out[r][c] = sum;
            }
        }

        return out;     
    }
    
    /**
     * Default constructor for test class Fill2DTest
     */
    public Fill2DTest()
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

}
