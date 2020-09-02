
/**
 * Write a description of class FirstClass here.
 * 
 * @author (Alexander Shapiro) 
 * @version (12/6/17)
 */
public class FirstClass
{
    /**
     * Simply return your name as a String.
     * 
     *                  
     * @return your name formatted as "Last, First" as a String
     * For example :
     *     return "Middler, Mitch"
     */
    public static String yourName()
    {
        
        return "Shapiro, Alexander";
    }
    
    
    // Write a method to set ALL of the elements of an array to 1
    // return the same array that is the parameter, you don't need to allocate a new array variable
    public static int[] setAllToOne1D(int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }

        return array;
    }
    
   
    // Write a method to set ALL of the elements of a 2D array to 1
    // return the same array that is the parameter, you don't need to allocate a new array variable
    public static int [][] setAllToOne(int[][] array2D)
    {

        // printArray2D(array2D);   //Remove the comment if you want to see your array
        for (int[] row : array2D)
        {
            for (int i = 0; i < row.length; i++)
            {
                row[i] = 1;
            }
        }
        return array2D;
    }
    
    // Write a method to set each element of a 2D array to the 10 times to row + the column.
    //   This will give you number that has the row number in the 10s digit and the column in the 1s digit.
    // return the same array that is the parameter, you don't need to allocate a new array variable
    public static int [][] setToRowColNumber(int[][] array2D)
    {
        // printArray2D(array2D);   //Remove the comment if you want to see your array
        for (int row = 0; row < array2D.length; row++)
        {
            for (int col = 0; col < array2D[0].length; col++)
            {
                array2D[row][col] = (row * 10) + col;
            }
        }
        return array2D;
    }
    
    // Write a method to set each element in the 2nd row of a 2D array to the number 5.
    // return the same array that is the parameter, you don't need to allocate a new array variable
    public static int [][] setRow2To5(int[][] array2D)
    {
        // printArray2D(array2D);   //Remove the comment if you want to see your array
        for (int i = 0; i < array2D[0].length; i++)
        {
            array2D[1][i] = 5;
        }
        return array2D;
    }

    // Write a method to set each element in the 3rd col of a 2D array to the number 10.
    // return the same array that is the parameter, you don't need to allocate a new array variable
    public static int [][] setCol3To10(int[][] array2D)
    {
        // printArray2D(array2D);   //Remove the comment if you want to see your array
        for (int i = 0; i < array2D.length; i++)
        {
            array2D[i][2] = 10;
        }
        return array2D;
    } 
  
    // Write a method to set the element in the last row and last column to 100.
    // return the same array that is the parameter, you don't need to allocate a new array variable
    public static int [][] setLastTo100(int[][] array2D)
    {
        //printArray2D(array2D);   //Remove the comment if you want to see your array
        for (int i = 0; i < array2D.length; i++)
        {
            array2D[array2D.length-1][array2D[0].length-1] = 100;
        }
        return array2D;
    } 
    
    // DO NOT CHANGE THIS!
    // Here is a method to print out a 2D array to help you debug
    // your methods below.  Call this method to see what your array
    // looks like both before and after you change the contents.
    public static void printArray2D(int[][] array)
    {
        String caller = Thread.currentThread().getStackTrace()[2].getMethodName();
        
        System.out.print("\nPrinting a "+array[0].length+
                         "x"+array.length+" array from " + caller + "() :\n");
        for (int row = 0; row < array.length; row++)
        {
            for (int column = 0; column < array[row].length; column++)
            {        
                System.out.print("\t"+array[row][column]);
            }
            System.out.print("\n");
        }
    }
    
}
