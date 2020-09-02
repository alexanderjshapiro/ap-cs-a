/**
 * Defines a dice randomizer object with six sides. The dice can be randomized and its 
 * properties can be accessed.
 *
 * @author Alexander Shapiro
 * @version 3/2/18
 */
public class D6 implements Randomizer
{
    private int numFaces = 0;
    private int currentValue = 0;
    
    public D6()
    {
        numFaces = 6;
        randomize();
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
        if (faceNum >= 1 && faceNum <= 6)
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
        currentValue = (int)(Math.random() * 6) + 1;
    }
    
    public static String yourName() {return "Shapiro, Alexander";}
}
