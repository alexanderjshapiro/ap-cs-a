/**
 * Defines a dice randomizer object with 100 sides. If a 100 is rolled, a "bonus" 
 * 100-sided dice is created which is rolled again and added to the first roll.
 *
 * @author Alexander Shapiro
 * @version 3/14/18
 */
public class D100Plus extends D100
{
    private int bonusValue = 0;

    public D100Plus() {
        bonusValue = 0;
        numFaces = 100;
        randomize();
    }
    
    public int getCurrentValue()
    {
        return super.getCurrentValue() + bonusValue;
    }
    
    public String toString()
    {
        return "bonus 100-sided die";
    }
    
    public void randomize()
    {
        super.randomize();
        
        if (super.getCurrentValue() == 100)
        {
            Randomizer bonusDie = new D100Plus();
            bonusValue = bonusDie.getCurrentValue();
        }
        else
        {
            bonusValue = 0;
        }
    }

}

