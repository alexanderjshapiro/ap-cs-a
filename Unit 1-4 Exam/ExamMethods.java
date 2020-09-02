
/**
 * Read the directions and comments carefully so that you may implement each method correctly.
 *
 *
 * COMPLETE THE "yourName" METHOD FIRST!
 *
 *
 * @author Alexander Shapiro
 * @version Units 1-4
 */


public class ExamMethods
{
    
    
    
    
    
    /**
     * 
     *   20 Points
     * 
     * Simply return your name as a String, last name then first name, separated by a comma
     *
     * @return your name as a String
     */
    public static String yourName()
    {
        return "Shapiro, Alexander";
    }
    
    
    
    
    
    /**
     * 
     *   25 Points
     * 
     * An email address has the format username@domain
     * Given an email address return the username portion of the String.  In other words, return
     * the part of the string that comes before the '@' character.
     *
     * @param email address with format username@domain
     * @return the username portion of the address.
     */
    public static String emailUser(String username)
    {
        // Find the location of the "at" symbol
        int atIndex = username.indexOf("@");
        
        // Return a substring startind at the beginning and ending before the "at" symbol
        return username.substring(0, atIndex);
    }
    
    
    
    
    
    /**
     * 
     *   25 Points
     * 
     * Given an int array of length 2, return true if the testValue is between the range of the two
     * numbers.   You can assume that the first value in the array is less than the 2nd value in
     * the array
     *
     * Precondition:    array.length is 2
     *                  first item in the array is less than the 2nd item in the array
     * Postcondition:   do not modify the contents of array
     *
     * @param   array of integer values of length 2
     * @param   testValue the value to determine whether or not it is between the 2 array values
     * @return  A boolean indicating whether testValue is between the two array values or not.
     */
    public static boolean valueIsBetweenRange(int[] array, int testValue)
    {
        // Test if the number is in the range
        if (testValue > array[0] && testValue < array[1])
        {
            // If it is, return true
            return true;
        }
        else
        {
            // Otherwise, return false
            return false;
        }
    }
    
    
    
    
    
    /**
     * 
     *   20 Points
     * 
     * Given the x and y coodinates of two points, call the distance method that has
     * been provided for you to calcuate and return the distance between the points.
     * You are given the points as individual variable values.
     *
     * The distance method is already implemented below, all that you need to do is call the
     * existing method.   You MUST call that method to receive credit for this problem.
     * Here is the header definition for the method that you will call:
     *
     *   double distance(int[] point1, int[] point2)
     *
     * The distance method requires
     * that the point parameters are provided as arrays where the item as index 0 is the x
     * coordinate and the item at index 1 is the y coordinate.
     * Your task should be as follows:
     *  1) convert the variables that you were provided into 2 arrays of length 2.
     *      Each array represents one point
     *  2) call the distance method below to find the distance between the two points
     *  3) return the resulting distance
     *
     * @param   x1 the x coordinate of point 1
     * @param   y1 the x coordinate of point 1
     * @param   x2 the x coordinate of point 2
     * @param   y2 the x coordinate of point 2
     * @return  the distance between (x1, y1) and (x2, y2)
     */
    public static double distance(int x1, int y1, int x2, int y2)
    {
        // Put each point into new methods
        int[] point1 = {x1, y1};
        int[] point2 = {x2, y2};
        
        // Return the result from calling the distance method with the points
        return distance(point1, point2);
    }
    
    
    
    
    
    /**
     * 
     *   10 Points
     * 
     * You are given a 2 dimensional array of points.
     * Each row represents one point in the format [x, y]
     * You will calculate the distance between each point and the next point in the array
     * and return a 1 dimensional array containing the distances between each
     * For example, point0 is row 0 and point1 is row1 from your input array.
     * In the array that you return, the element at position 0 will store the
     * distance between point0 and point1.
     *
     * If your input array has n rows, your output array will have n-1 rows.
     *
     * You may either call your working distance method above OR the one that I have provided
     * you below.
     *
     * @param   points is a 2 dimensional array of points each with the format [x, y]
     * @return  an array specifying the distance between each subsequent row.  This array's
     *          length is one less than the number of rows in the input array.
     */
    public static double[] allDistances(int[][] points)
    {
        // Create a new 1D array that's one less than the number of rows to hold the answers
        double[] distances = new double[points.length - 1];
        
        // Loop through each point, which is the same as each row and also avoid overflow
        for (int row = 1; row < points.length; row++)
        {
            // Call the distance method and store the result in the answer array
            distances[row - 1] = distance(points[row - 1], points[row]);
        }
        
        // Return the answer array
        return distances;
    }

    
   
    
    
    /**
     *
     *  5 Points Extra Credit
     *
     * Given a 2 dimensional array.  Return the index of the column containing the largest value
     *
     * Postcondition:   do not modify the contents of array
     *
     * @param   array is a 2 dimensional array
     * @return  an integer representing the index of the column that contains the largest value
     */
    public static int columnContainingLargest(double[][] array)
    {
        // Create variables to keep track of the largest number and its index
        double largest = 0;
        int colIdx = 0;
        
        // Loop through each value in the 2D array
        for (int row = 0; row < array.length; row++)
        {
            for (int col = 0; col < array[0].length; col++)
            {
                // Test if the current number in the loop is bigger than the current largest number
                if (array[row][col] > largest)
                {
                    // If it is, replace that number with the new largest number and store the column it was in
                    largest = array[row][col];
                    colIdx = col;
                }
                    // If it isn't, do nothing and move on
            }
        }
        
        return colIdx;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * DO NOT EDIT THIS METHOD, it is used for the problem above.
     * Calculates the distance between 2 points
     *
     * @param   point1 is the x and y coordinates of a point stored in an array
     * @param   point2 is the x and y coordinates of a point stored in an array
     * @return  the distance between point1 and point2
     */
    public static double distance(int[] point1, int[] point2)
    {
        // THERE IS NOTHING FOR YOU TO DO HERE, THIS IS USED FOR THE PROBLEM ABOVE
        // SCROLL DOWN TO THE NEXT PROBLEM
        return Math.sqrt(Math.pow(point2[0] - point1[0],2) +
                         Math.pow(point2[1] - point1[1],2));
    }
}



