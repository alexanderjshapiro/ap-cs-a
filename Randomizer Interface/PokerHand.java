import java.util.*;
import java.util.Arrays;

/**
 * Write a description of class PokerHand here.
 *
 * @author Alexander Shapiro
 * @version 3/21/18
 */
public class PokerHand
{
    private List<Card> hand = new ArrayList<Card>();
    
    public PokerHand(Card c1, Card c2, Card c3, Card c4, Card c5)
    {
        hand.add(c1);
        hand.add(c2);
        hand.add(c3);
        hand.add(c4);
        hand.add(c5);
        selectionSort();
    }
    
    public String toString()
    {
        String handString = "";
        
        for (int i = 0; i < hand.size(); i++)
        {
            handString += hand.get(i).getFace();
        }
        
        return handString;
    }
    
    public void selectionSort()
    {
        int small;
        
        for (int i = 0; i < hand.size() - 1; i++)
        {
            int index = i;
            
            small = hand.get(i).getValue();
            
            for (int j = i + 1; j < hand.size(); j++)
            {
                if (hand.get(j).getValue() < small)
                {
                    small = hand.get(j).getValue();
                    index = j;
                }
            }
            
            Card card = hand.get(index);
            hand.set(index, hand.get(i));
            hand.set(i, card);
        }
    }
    
    public Boolean isFlush()
    {
        for (int i = 1; i < hand.size(); i++)
        {
            if (!(hand.get(0).sameSuit(hand.get(i))))
            {
                return false;
            }
        }
        
        return true;
    }
    
    public int getPairs()
    {
        int pairs = 0;
        
        for (int i = 0; i < hand.size(); i++)
        {
            int match = 0;
            for (int j = 0; j < hand.size(); j++)
            {
                if (i != j){
                    if (hand.get(i).sameValue(hand.get(j)))
                    {
                        match++;
                    }
                }
            }
            
            if (match == 1)
            {
                pairs++;
            }
        }
        
        pairs = pairs - (pairs/2);
        return pairs;
    }
    
    public boolean getNumMatches(int numKind, int numPairs)
    {
        for (int i = 0; i < hand.size(); i++)
        {
            int match = 0;
            
            for (int j = 0; j < hand.size(); j++)
            {
                if (i != j)
                {
                    if (hand.get(i).sameValue(hand.get(j)))
                    {
                        match++;
                    }
                }
            }
            
            if (match == numKind-1)
            {
                int k = getPairs();
                if (k == numPairs)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isPair()
    {
        int pairs = getPairs();
        
        if (pairs == 1) return true;
        else return false;
    }
    
    public boolean isTwoPair()
    {
        int pairs = getPairs();
        
        if (pairs == 2) return true;
        else return false;
    }
    
    public boolean isThreeOfAKind()
    {
        return getNumMatches(3,0);
    }
    
    public boolean isFourOfAKind()
    {
        return getNumMatches(4,0);
    }
    
    public boolean isFullHouse()
    {
        return getNumMatches(3,1);
    }
    
    public boolean isStraight()
    {
        int[] arr = new int[5];
        
        for (int i = 0; i < hand.size(); i++)
        {
            arr[i] = hand.get(i).getValue();
        }
        
        Arrays.sort(arr);
        
        if (arr[0] == 1 && arr[1] == 10 && arr[2] == 11 &&arr[3] == 12 &&arr[4] == 13) return true;
        
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] != arr[i-1]+1)
            {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isStraightFlush()
    {
        if (isFlush() && isStraight()) return true;
        else return false;
    }
    
    
    
    public static String yourName() { return "Shapiro, Alexander"; }
}
