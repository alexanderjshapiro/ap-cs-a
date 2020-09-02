/**
 * Defines the methods that randomizers (dice, cards, coins) should have.
 *
 * @author Alexander Shapiro
 * @version 3/2/18
 */
public interface Randomizer
{
    public int getNumFaces();
    public int getCurrentValue();
    public String getFace(int faceNum);
    public String getCurrentFace();
    public void randomize();
}
