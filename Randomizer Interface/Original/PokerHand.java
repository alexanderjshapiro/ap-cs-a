import java.util.*;

/**
 * Write a description of class PokerHand here.
 *
 * @author Alexander Shapiro
 * @version 3/23/18
 */
public class PokerHand
{
    List<Card> hand = new ArrayList<Card>();
    public PokerHand(Card card1, Card card2, Card card3, Card card4, Card card5)
    {
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        
        selectionSort();
    }
    
    public String toString()
    {
        String str = "";
        for (Card card : hand)
        {
            str += card.getFace() + " ";
        }
        
        return str;
    }
    
    public void selectionSort()
    {
        for (int currentCard = 0; currentCard < hand.size() - 1; currentCard++)
        {
            int index = currentCard;
            for (int comparedCard = currentCard + 1; comparedCard < hand.size(); comparedCard++){
                if (hand.get(comparedCard).getValue() < hand.get(index).getValue()){
                    index = comparedCard;
                }
            }  
            
            Card replaced = hand.set(currentCard, hand.get(index));
            hand.set(index, replaced);
        }
    }
    
    public boolean isFlush()
    {
        for (int i = 0; i < 4; i++)
        {
            if (!hand.get(i).sameSuit(hand.get(i + 1))) return false;
        }
        
        return true;
    }
    
    public boolean isPair()
    {
        if (isTwoPair()) return false;
        if (isThreeOfAKind()) return false;
        if (isFourOfAKind()) return false;
        for (int i = 0; i < 4; i++)
        {
            if (hand.get(i).sameValue(hand.get(i + 1))) return true;
        }
        
        return false;
    }
    
    public boolean isTwoPair()
    {
        if (isThreeOfAKind()) return false;
        if (isFourOfAKind()) return false;
        int numPairs = 0;
        for (int i = 0; i < 4; i++)
        {
            if (hand.get(i).sameValue(hand.get(i + 1)))
            {
                i++;
                numPairs++;
            }
        }
        
        if (numPairs == 2) return true;
        else return false;
    }
    
    public boolean isThreeOfAKind()
    {
        if (isFourOfAKind()) return false;
        // if (isFullHouse()) return false;
        for (int i = 0; i < 3; i++)
        {
            if (hand.get(i).sameValue(hand.get(i + 1)) && hand.get(i).sameValue(hand.get(i + 2))) return true;
        }
        
        return false;
    }
    
    public boolean isFourOfAKind()
    {
        int numPairs = 0;
        for (int i = 0; i < 3; i++)
        {
            if (hand.get(i).sameValue(hand.get(i + 1))) numPairs++;
        }
        
        int numPairs2 = 0;
        for (int i = 1; i < 4; i++)
        {
            if (hand.get(i).sameValue(hand.get(i + 1)))
            {
                numPairs2++;
            }
        }
        
        if (numPairs == 3 || numPairs2 == 3) return true;
        else return false;
    }
    
    public boolean isFullHouse()
    {
        if (isFourOfAKind()) return false;
        int numPairs = 0;
        for (int i = 0; i < 2; i++)
        {
            if (hand.get(i).sameValue(hand.get(i + 1))) numPairs++;
        }
        
        int numPairs2 = 0;
        for (int i = 2; i < 4; i++)
        {
            if (hand.get(i).sameValue(hand.get(i + 1)))
            {
                numPairs2++;
            }
        }
        
        if (numPairs == 2 || numPairs2 == 2) return true;
        else return false;
    }
    
    public boolean isStraight()
    {
        for (int i = 0; i <= 4; i++)
        {
            if (!(hand.get(i).getValue() == hand.get(i + 1).getValue() + 1))
            {
                return false;
            }
        }
        return true;
    }
    
    public boolean isStraightFlush()
    {
        if (isStraight() && isFlush()) return true;
        else return false;
    }
    
    public static String yourName() { return "Shapiro, Alexander"; }
}
