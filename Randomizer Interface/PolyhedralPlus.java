/**
 * Defines a dice randomizer object with any number of sides. If the highest number
 * is rolled, a "bonus" dice with the same number of sides is created which is rolled
 * again and added to the first roll.
 *
 * @author Alexander Shapiro
 * @version 3/21/18
 */
public class PolyhedralPlus extends PolyhedralDie
{
    private int bonusValue = 0;
    
    public PolyhedralPlus(int setNumFaces)
    {
        super(setNumFaces);
        bonusValue = 0;
        randomize();
    }
    
    public int getCurrentValue()
    {
        return super.getCurrentValue() + bonusValue;
    }
    
    public String toString()
    {
        return "bonus " + numFaces + "-sided die";
    }
    
    public void randomize()
    {
        super.randomize();
        
        if (super.getCurrentValue() == numFaces)
        {
            Randomizer bonusDie = new PolyhedralPlus(getNumFaces());
            bonusValue = bonusDie.getCurrentValue();
        }
        else
        {
            bonusValue = 0;
        }
    }
}
