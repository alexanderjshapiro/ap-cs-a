
/**
 * Represents a single card.
 *
 * @author Alexander Shapiro
 * @version 3/21/18
 */
public class Card
{
    private int value = 0;
    private int suit = 0;
    
    public Card(int setValue, int setSuit)
    {
        value = setValue;
        suit = setSuit;
    }
    
    public Card(String setSuit, int setValue)
    {
        value = setValue;
        if (setSuit.equals("spade")) suit = 1;
        else if (setSuit.equals("heart")) suit = 2;
        else if (setSuit.equals("club")) suit = 3;
        else suit = 4;
    }
    
    public int getValue()
    {
        return value;
    }
    
    public String getFace()
    {
        return getFaceValue() + getFaceSuit();
    }
    
    public String getFaceValue()
    {
        if (value >= 2 && value <= 10) return value + "";
        else if (value == 11) return "Jack";
        else if (value == 12) return "Queen";
        else if (value == 13) return "King";
        else return "Ace";
    }
    
    public String getFaceSuit()
    {
        if (suit == 1) return "\u2660";
        else if (suit == 2) return "\u2661";
        else if (suit == 3) return "\u2663";
        else return "\u2662";
    }
    
    public boolean sameSuit(Card other)
    {
        if (suit == other.suit)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean sameValue(Card other)
    {
        if (value == other.value)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
