
/**
 * Write a description of class PolyhedralPlusRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PolyhedralPlusRunner
{
    public static void main(String[] args)
    {
        int numRolls = Integer.MAX_VALUE;
        
        Randomizer dice = new PolyhedralPlus(70);
        
        int greatest = -1;
        for (int i = 1; i <= numRolls; i++)
        {
            dice.randomize();
            if (dice.getCurrentValue() > greatest)
            {
                greatest = dice.getCurrentValue();
                System.out.println("New Best Value " + greatest + " on roll " + i);
            }
        }
    }
}

