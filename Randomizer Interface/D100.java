/**
 * Defines a dice randomizer object with 100 sides.
 *
 * @author Alexander Shapiro
 * @version 3/7/18
 */
public class D100 extends NumericFace
{
    public D100()
    {
        numFaces = 100; 
        randomize();
    }
    
    public String imageURL()
    {
        return "https://goo.gl/K4afdN";
    }
    
    public String toString()
    {
        return "100-sided die";
    }

}
