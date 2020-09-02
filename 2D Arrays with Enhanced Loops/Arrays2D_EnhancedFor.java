
/**
 * Write a description of class Arrays2D_EnhancedFor here.
 * 
 * @author (Alexander Shapiro) 
 * @version (12/9/17)
 */
public class Arrays2D_EnhancedFor
{
    /**
     * Given an array of integer values return the number of elements that
     * have at least one 1 digit in them.
     * 
     * For example:
     *  1, 123, 501, and 911 all have at least one 1 digit
     * but:
     *  42, 0, 666, and 98765432 have no 1 digits
     * so, given the array:
     *  {1, 501, 0, 42, 911}
     * 3 would be returned.
     * 
     * Precondition:    nums is not null
     *                  nums.length > 0
     *                  all values in nums >= 0
     * Postcondition:   nums is unchanged
     *                  
     * @param   nums an array of integer values >= 0
     * @return  the number of values in nums containing the digit 1
     */
    public static int count1s(int[] nums)
    {
        /* If you complete the other methods, rewrite this solution using
           String manipulation.
           
           Hint: To easily convert a number to a String simply add "" to it.
        */
       String[] strs = new String[nums.length];
       for (int i = 0; i < nums.length; i++)
       {
           strs[i] = "" + nums[i];
           System.out.println(strs[i]);
       }
       
       int count = 0;
       for (int i = 0; i < strs.length; i++)
       {
           
        if (strs[i].indexOf("1") != -1)
        {
            count++;
        }
        
       }
       return count;
    }
    /**
     * Given a 2D array of int values return the total number of values
     * that DON'T have 1s in them.
     * 
     * Note:    To receive full credit you must use an enhanced for loop
     *          AND use the count1s() method!
     * 
     * Precondition:    mat is not null
     *                  mat.length > 0
     *                  mat[0].length > 0
     *                  all values in mat >= 0
     * Postcondition:   mat is unchanged
     *                  
     * @param   mat a 2D array of integer values >= 0
     * @return  the number of values in mat that don't have a digit 1
     *          in them
     */
    public static int nonOnes(int[][] mat)
    {
        // Solve using an enhanced for loop and by calling count1s()
        int count = 0;
        for (int[] row : mat)
        {
            count += row.length - count1s(row);
        } 
        return count; // Change this
    }
}
