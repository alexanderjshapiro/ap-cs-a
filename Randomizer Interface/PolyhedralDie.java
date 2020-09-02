/**
 * Write a description of class PolyhedralDie here.
 *
 * @author Alexander Shapiro
 * @version 3/19/18
 */
public class PolyhedralDie extends NumericFace
{
    public PolyhedralDie(int setNumFaces)
    {
        numFaces = setNumFaces;
        randomize();
    }
    
    public String toString()
    {
        return numFaces + "-sided die";
    }
}