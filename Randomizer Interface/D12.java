/**
 * Defines a dice randomizer object with 12 sides. The dice can be randomized and its 
 * properties can be accessed.
 *
 * @author Alexander Shapiro
 * @version 3/5/18
 */
public class D12 implements Randomizer
{
    int numFaces = 0;
    int currentValue = 0;
    
    public D12()
    {
        numFaces = 12;
    }
    
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
        if (faceNum >= 1 && faceNum <= 12)
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
        currentValue = (int)(Math.random() * 12) + 1;
    }
    
    public static String yourName() {return "Shapiro, Alexander";}
}
