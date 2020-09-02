import java.util.*;

/**
 * Write a description of class PlayingCards here.
 *
 * @author Alexander Shapiro
 * @version 3/21/18
 */
public class PlayingCards extends NumericFace
{
    List<Card> deck = new ArrayList<Card>();
    
    public PlayingCards()
    {
        shuffle();
    }
    
    public String getFace(int faceNum)
    {
        if (faceNum >= 1 && faceNum <= numFaces)
        {
            Card card = deck.get(faceNum - 1);
            return card.getFace() + "";
        }
        else
        {
            return "";
        }
    }
    
    /**
     * Returns the next randomized card from the deck.  The 
     * returned card is then removed from the deck and the 
     * number of cards left in the deck is adjusted.
     *
     * @return The next Card in the deck.  If no more cards are left 
     *         in the deck, null is returned.
     */
    public Card dealCard()
    {
        randomize();
        Card card = deck.remove(getCurrentValue() -1);
        numFaces--;
	return card;
    }

    /**
     * Reset all of the dealt cards and shuffle the deck.
     *
     */  
    public void shuffle()
    {
        numFaces = 52;
        for (int currentSuit = 1; currentSuit <= 4; currentSuit++)
        {
            for (int currentValue = 2; currentValue <= 14; currentValue++)
            {
                deck.add(new Card(currentValue, currentSuit));
            }
        }
        randomize();
    }

}
