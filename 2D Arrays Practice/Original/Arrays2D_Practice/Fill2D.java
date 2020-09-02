
/**
 * Practice with 2D arrays
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fill2D
{
    /**
     * Simply return your name as a String.
     * 
     *                  
     * @return your name formatted as "Last, First" as a String
     */
    public static String yourName()
    {
        return "Rose,Taylor";
    }
        
    /**
     * Write a method that fills the parameter array so that all of its
     * border elements have the value specified in the border parameter
     * and its interior elements have the value of the interior parameter.
     * 
     * The border is defined as the first and last row and column
     * The interior is everything but the border
     * 
     * For example, given the array:
     * {
     *   {0,0,0,0},
     *   {0,0,0,0},
     *   {0,0,0,0}
     * }
     * and the border value 5 and interior value 2
     * Your method should return:
     * {
     *     {5,5,5,5},
     *     {5,2,2,5},
     *     {5,5,5,5}
     * }
     * 
     * 
     * @param   arr2d       The array to manipulate
     * @param   border      The value that should be placed in the border elements
     * @param   interior    The value that should be placed in the interior elements
     * @return  a two dimensional array of equal size and shape as the parameter arr2d
     */
    public static int[][] boxFill(int[][] arr2d, int border, int interior)
    {
        
        for ( int i = 0; i < arr2d[0].length; i++) {
            arr2d[0][i] = border;
            arr2d[arr2d.length - 1][i] = border;
        }
        for ( int row = 0; row < arr2d.length; row++) {
            for ( int col = 0; col < arr2d[0].length; col++) {
                if (row != 0 && row != arr2d.length - 1) {
                    arr2d[row][0] = border;
                    arr2d[row][arr2d[0].length - 1] = border; 
                    if ( col != 0 && col != arr2d[0].length - 1) {
                        arr2d[row][col] = interior; 
                        
                       
                    }
            }
        }
            
        }
        return arr2d;
    }
    
    /**
     * Write a method that fills the parameter array following the pattern:
     * Even rows should count up from the highest value in the array so far
     * going left to right but odd rows should go from right to left.
     * For example, given the array:
     * {
     *   {0,0,0,0},
     *   {0,0,0,0},
     *   {0,0,0,0}
     * }
     * Your method should return:
     * {
     *     {1,2,3,4},
     *     {8,7,6,5},
     *     {9,10,11,12}
     * }
     * @param   arr2d     the input array
     * @return  a two dimensional array of equal size and shape as the parameter arr2d
     */
    public static int[][] fill_lToR_rToL(int[][] arr2d)
    { 
        int count = 1;
        int index = 0;
        for ( int row = 0; row < arr2d.length; row ++) {
            for (int col = 0; col < arr2d[0].length; col ++) {
                if (row % 2 == 0 ) {
                   arr2d[row][col] = count;
                   count ++;
                   index++;
                }
                
                else if (row % 2 == 1) {
                    count += arr2d[0].length;
                    arr2d[row][col] = count; 
                    count--;
                    index++;
                }
            }
        }

        return arr2d;             
    }
    
     /**
     * Write a method that multiplies a matrix of dimension m x m by a vector of lengh m.
     * A matrix is represented by a 2 dimensional array and a vector is represented by a one 
     * dimensional array.
     * 
     * HINT:  You will need to create a new array of length m to return the final result.
     * 
     * Here is an explanation of how to multiply a matrix by a vector:
     * http://www.varsitytutors.com/hotmath/hotmath_help/topics/multiplying-vector-by-a-matrix
     * 
     * @param   matrix     the 2D input array
     * @param   vector     the 1D array to mutliply by
     * @return  an array of equal length to the vector
     */
    public static int[] multMatrixByVector(int[][] matrix, int[] vector)
    {
        // declare a new array to return, don't reuse vector
        int[] out = new int[vector.length];
        
        return out;
    }
    
     /**
     * Write a method that multiplies a matrix of dimension m x m by a another matrix of dimension m x m.
     * A matrix is represented by a 2 dimensional array and returned product of the multiplication is another matrix
     * 
     * HINT:  You will use the 2D array that is already allocated in the code below.
     * 
     * Here is an explanation of how to multiply a matrix by a matrix:
     * https://www.khanacademy.org/math/precalculus/precalc-matrices/multiplying-matrices-by-matrices/v/multiplying-a-matrix-by-a-matrix
     * 
     * Here is a website where you can test example of matrix multiplication to test your results.
     * Try it with simple 2x2 matrices first:
     * http://www.calcul.com/show/calculator/matrix-multiplication_;3;3;3;3
     * 
     * @param   matrix     the 2D input array
     * @param   vector     the 2D array to mutliply by
     * @return  an array of equal size to the matrix
     */
    public static int[][] multMatrixByMatrix(int[][] matrix1, int[][] matrix2)
    {
        int[][] out = new int[matrix1.length][matrix1.length];  // declare a new 2D array to return, don't write results back into parameters
        
        // Your code goes here

        return out;     
    }
    
}
