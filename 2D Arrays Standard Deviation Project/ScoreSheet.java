
/**
 * Write a description of class ScoreSheet here.
 * 
 * @author (Chance T. and Alex S.) 
 * @version (12/8/17)
 */
public class ScoreSheet
{
    /**
     * This method will return an array that calculates the average of all the columns
     * in each row of the given array.
     * 
     * @param   scores      2D array of scores
     * @return  averages    1D array representing the average of each row of scores
     */
    public static double[] calcAvg(double[][] scores)
    {
        double[] average = new double[scores.length];
        
        for (int row = 0; row < scores.length; row++)
        {
            double sum = 0.0;
            for (int col = 0; col < scores[row].length; col++)
            {
                sum += scores[row][col];
            }
            average[row] = sum / scores[row].length;
        }
        
        return average;
    }



    /**
     * This method will return a 2 dimensional array that calculates the square of the difference
     * between the value
     * and the average of the row.  The avarage of the row was already calculated for you and passed 
     * in as a parameter.
     * You will do the calculation and store the result back into the same element of the scores 
     * array for which you 
     * are calculating the result.  At the end of the method, simply return the scores array.
     * 
     * @param   scores      2D array of scores
     * @param   average     1D array representing the average of each row of scores
     * @return  diffSquared 2D array
     */
    public static double[][] scoresLessMeanSquared(double[][] scores, double[] average)
    {
        // Your code goes here
        for (int row = 0; row < scores.length; row++)
        {
            for (int col = 0; col < scores[row].length; col++)
            {
                scores[row][col] = Math.pow(((scores[row][col]) - average[row]),2);
            }
            
        }
         return scores;// You MUST replace this!
    }

    /**
     * This method will return an array that calculates the standard deviation of all of the columns
     * in each row of the given array.
     * 
     * To caluclauate the standard deviation, perform the following steps:
     * 1: Use your calcAvg method to get the average value for each row
     * 2: Use your scoresLessMeanSquared method to calculate the square of the difference of each value 
     *     with the row's avarage
     * 3: Use your calAvg again to get the average of what was calculated in step 2.
     * 4: Calculate the square root of each value in the array returned by step 3.
     * 5: return the results of step 4.
     * 
     * @param   scores      2D array of scores
     * @return  stdDev      1D array representing the standard deviation in each row of scores.
     */    
    public static double[] stdDev(double[][] scores)
    {
        // Your code goes here
        double[] rowAvg = calcAvg(scores);;
        double[][] rowLessMeanSquared = scoresLessMeanSquared(scores,rowAvg);
        double[] rowLessMeanSquaredAvg = calcAvg(rowLessMeanSquared);
        double[] deviation = new double[scores.length];
        for (int i = 0; i < rowLessMeanSquaredAvg.length; i++)
        {
            deviation[i] = Math.sqrt(rowLessMeanSquaredAvg[i]);
        }
        return deviation;// You MUST replace this!
    }
}
