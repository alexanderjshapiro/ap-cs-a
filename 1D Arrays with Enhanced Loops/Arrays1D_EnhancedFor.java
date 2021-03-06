/**
 * Write a description of class Arrays1D_EnhancedFor here.
 * 
 * @author (Alexander Shapiro) 
 * @version (11.29.17)
 */
public class Arrays1D_EnhancedFor
{
    /**
     * Given an array of integer values return the sum.
     * Precondition:    values is not null
     *                  values.length > 0
     * Postcondition:   values is unchanged
     *                  
     * @param   values  an array of integer values
     * @return  the sum of the values in the parameter array
     */
    public static int sum(int[] values)
    {
        /* Change this code from a traditional for loop to
        an enhance for loop */
        int total = 0; 
        for (int i : values)
        {
            int value = i;
            total += value;
        }
        return total;
    }

    /**
     * Given an array of scores calculate the special average.
     * The special average only includes scores that are greater
     * than or equal to zero, ignoring scores below zero.
     * Precondition:    scores is not null
     *                  scores.length > 0
     * Postcondition:   scores is unchanged
     *                  
     * @param   scores  an array of scores
     * @return  the average of scores >= 0
     */
    public static double specialAverage(int[] scores)
    {
        /* Change this code from a traditional for loop to
        an enhance for loop */
        double total = 0;
        int count = 0;
        for (int i : scores)        
        {
            int score = i;
            if (score >= 0)
            {
                total += score;
                count++;
            }
        }
        return total / count;      
    }

    /**
     * Given an array of scores calculate the nice average.
     * The nice average drops the single lowest score.
     * 
     * Precondition:    scores is not null
     *                  scores.length > 1 
     * Postcondition:   scores is unchanged
     *                  
     * @param   scores  an array of scores
     * @return  the average of ignoring the single lowest score.
     */    
    public static double niceAverage(int[] scores)
    {
        // Solve using an enhanced for loop!
        int lowest = scores[0];
        for (int i : scores)
        {
            if (i < lowest)
            {
                lowest = i;
            }
        }
        
        double sum = 0.0;
        
        for (double i : scores)
        {
            sum += i;
        }
        
        sum -= lowest;
       
        return sum/(scores.length-1);
    }
   
    /**
     * Given an array of scores calculate the tossSum by.
     * discarding the highest and lowest values in the array.
     * 
     * Precondition:    scores is not null
     *                  scores.length > 2 
     * Postcondition:   scores is unchanged
     *                  
     * @param   scores  an array of scores
     * @return  return the sum of scores without the highest
     *          and lowest score included
     */    
    public static int tossSum(int[] scores)
    {
        // Solve using an enhanced for loop!
        int highest = scores[0];
        for (int i : scores)
        {
            if (i > highest)
            {
                highest = i;
            }
        }
        
        int lowest = scores[0];
        for (int i : scores)
        {
            if (i < lowest)
            {
                lowest = i;
            }
        }
        
        int sum = 0;
        
        for (int i : scores)
        {
            sum += i;
        }
        
        sum -= highest + lowest;
        
        return sum;     
    }
    
    /**
     * An enhanced for loop isn't always the best choice.
     * 
     * The next method will require two succesive loops to solve.
     * 
     * The first loop should be an enhanced for loop but the second
     * you can write any way you want.
     * 
     * Given an array of scores you will return a new array where
     * each value has been increased by the amount it takes for the
     * highest score to be at least 100.
     * 
     * Precondition:    scores is not null
     *                  scores.length > 0
     *                  all values in scores >= 0 and <= 100
     * Postcondition:   scores is unchanged
     *                  
     * @param   scores  an array of scores
     * @return  a parallel array of adjusted scores
     */
    public static int[] adjustedScores(int[] scores)
    {
        // Use an enhanced for loop to find the best so far
        int highest = scores[0];
        for (int i : scores)
        {
            if (i > highest)
            {
                highest = i;
            }
        }
        // Calculate the amount to adjust each score
        int adjustment = 100 - highest;
        
        int[] adjScores = new int[scores.length];
        // Use the loop form you think is best to finish the problem
        for (int i = 0; i < scores.length; i++)
        {
            adjScores[i] = scores[i] + adjustment;
        }
        return adjScores; // Change this
    }
    /**
     * The mathematical mode is defined as:
     *      The number which appears most often in a set of numbers.
     *      Example: in {6, 3, 9, 6, 6, 5, 9, 3} the Mode is 6 (it occurs most often).
     *      
     * Given an array scores of of at least 0, return the most common score.
     * 
     * Precondition:    scores is not null
     *                  scores.length > 0
     *                  all values in scores >= 0 and <= 100
     * Postcondition:   scores is unchanged
     *                  
     * @param   scores  an array of scores
     * @return  the score that appears most often
     */
    public static int mode(int[] scores)
    {
      // Your code goes here
    int mode = scores[0];
    int maxCount = 0;
    for (int i : scores)
    {
        int value = i;
        int count = 1;
        for (int j : scores)
        {
            if (j == value)
            {
                count++;
            }
            if (count > maxCount)
            {
                mode = value;
                maxCount = count;
            }
        }
    }
    return mode; // Change this
    }
}