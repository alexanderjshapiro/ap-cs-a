import java.util.ArrayList;
import java.util.List;

/**
 * Groups dice object that implement the Randomizer interface into an array where they are
 * rolled and their result it printed to the console.
 *
 * @author Alexander Shapiro
 * @version 3/12/18
 */
public class DiceCupRunner
{
    public static void main(String [] args)
    {
        List<Randomizer> diceCup = new ArrayList<Randomizer>();
        
        diceCup.add(new PolyhedralDie(32));
        diceCup.add(new PolyhedralDie(16));
        diceCup.add(new PolyhedralDie(12));
        diceCup.add(new PolyhedralDie(98));
        diceCup.add(new PolyhedralDie(33));

    
        System.out.println("Rolling " + diceCup.size() + " dice...");
        int total = 0;
        for (Randomizer dice : diceCup)
        {
            dice.randomize();
            total += dice.getCurrentValue();
            System.out.println("\tThe " + dice + " rolled " + dice.getCurrentValue() + ".");
        }
        System.out.println("The total is " + total + ".\n");
    }

}
