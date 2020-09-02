/**
 * Defines a generic dice randomizer object. The generic dice can be randomized and its 
 * properties can be accessed.
 *
 * @author Alexander Shapiro
 * @version 3/7/18
 */
public abstract class NumericFace implements Randomizer
{
    int numFaces = 0;
    private int currentValue = 0;
    
    public int getNumFaces()
    {
        return numFaces;
    }
    
    public int getCurrentValue()
    {
        return currentValue;
    }
    
    public String getFace(int faceNum)
    {
        if (faceNum >= 1 && faceNum <= numFaces)
        {
            return faceNum + "";
        }
        else
        {
            return "";
        }
    }
    
    public String getCurrentFace()
    {
        return getFace(getCurrentValue());
    }
    
    public void randomize()
    {
        currentValue = (int)(Math.random() * numFaces) + 1;
    }
    
    // public abstract String imageURL();
}
