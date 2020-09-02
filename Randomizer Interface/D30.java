/**
 * Defines a dice randomizer object with 30 sides.
 *
 * @author Alexander Shapiro
 * @version 3/7/18
 */
public class D30 extends NumericFace
{
    public D30()
    {
        numFaces = 30;
        randomize();
    }
    
    public String imageURL()
    {
        return "https://goo.gl/K4afdN";
    }
    
    public String toString()
    {
        return "30-sided die";
    }

}
