/**
 * Instantiates three D30 objects where they are rolled until the sum of their results are
 * 50. The number of rolls that is took to roll a sum of 50 is printed to the console.
 *
 * @author Alexander Shapiro
 * @version 3/9/18
 */
public class DiceRunner
{
    public static void main(String [] args)
    {
        Randomizer dice1 = new D30();
        Randomizer dice2 = new D30();
        Randomizer dice3 = new D30();
        
        int total = 0;
        int rolls = 0;
        
        for (rolls = 0; total != 50; rolls++)
        {
           dice1.randomize();
           dice2.randomize();
           dice3.randomize();
           total = dice1.getCurrentValue() + dice2.getCurrentValue() + dice3.getCurrentValue();
        }
        
        System.out.println("Using " + dice1.toString() + ", it took " + rolls + " roll(s) to total 50");

    }

}
