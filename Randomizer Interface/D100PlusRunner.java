
/**
 * Instantiates a D100Plus object where it is rolled. The first five rolls as well as every roll that totalled 100 or above is 
 * printed to the console after 1000 rolls. The number of rolls that takes to roll a number 300 or above is also printed to the 
 * console.
 *
 * @author Alexander Shapiro
 * @version 3/14/18
 */
public class D100PlusRunner
{
    public static void main(String [] args)
    {
        System.out.println("Rolling dice...");
        
        Randomizer dice = new D100Plus();
        
        for (int i = 1; i <= 1000; i++)
        {
            dice.randomize();
            
            if (dice.getCurrentValue() >= 100 || i <= 5)
            {
                System.out.println("\tDice #" + i + " rolled " + dice.getCurrentValue() + ".");
            }
        }
        
        System.out.println("Rolling dice...");
        int rolls = 0;
        
        for (rolls = 0; dice.getCurrentValue() <= 300; rolls++)
        {
           dice.randomize();
        }
        
        System.out.println("\tIt took " + rolls + " roll(s) to roll " + dice.getCurrentValue() + ".");

    }
}
