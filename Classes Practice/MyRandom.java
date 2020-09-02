import java.util.ArrayList;
import java.util.List;

/**
 * In this project you will learn about writing classes in Java.
 * 
 * You will:
 * 1. Write a traditional class with a class (static) method
 * 
 * 2. Add instance variables, instance methods, and a constructor so that it can be instaniated.
 *  
 * @author Alexander Shapiro 
 * @version Unit 7 - Writing Object Classes
 */

// Class Declaration
public class MyRandom
{
    // Instance Variable(s)
    private int from = 1;
    private int to = 10;
    
    public MyRandom (int setFrom, int setTo)
    {
        from = setFrom;
        to = setTo;
    }
    
    // Getter(s)
    public int getFrom()
    {
        return from;
    }
    
    public int getTo()
    {
        return to;
    }

    /**
     * Simply return your name as a String, last name then first name, separated by a comma
     *
     * @return your name as a String
     */
    public static String yourName()
    {
        return "Shapiro, Alexander"; 
    }
    
    // Instance Method(s)
    /**
     * Return a random number 
     *
     * @return  the next random number
     */
    public int nextRandom() 
    {
    	return randomInRange(from, to);	
    }

    // Class (static) Method(s)
    /**
     * Given two int parameter values, from and to, you will return a random int that falls
     * in the range of from and to (inclusive).
     * 
     * For example:
     *  randomInRange(1,10) would return a number between 1 and 10 inclusive.
     *    Valid return values would be the numbers: 1...10
     *  
     *  randomInRange(10,1) would also return a number between 1 and 10 inclusive.
     *  
     *  randomInRange(-5,5) would return a number between -5 and 5 inclusive.
     *  
     *  NOTE: This method does not work as intended!
     *  
     * @param   from    one bound of the random int to be generated
     * @return  to      the second bound of the random int ot be genrated
     */
    public static int randomInRange(int from, int to)
    {
        if (from > to)
        {
            int holder = from;
            from = to;
            to = holder;
        }
        return (int)(Math.random() * (to - from + 1)) + from;
    }
}

