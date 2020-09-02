/**
 * Test of PlayingCards
 *
 * @author Alexander Shapiro
 */
public class CardsRunner
{
    public static void main(String[] args)
    {
        PlayingCards cards = new PlayingCards();
        
        checkHand("flush", cards);
        checkHand("pair", cards);
        checkHand("two pair", cards);
        checkHand("three of a kind", cards);
        checkHand("four of a kind", cards);
        checkHand("straight", cards);
        checkHand("full house", cards);
        checkHand("straight flush", cards);
        PokerHand ph = new PokerHand(cards.dealCard(), cards.dealCard(), cards.dealCard(), cards.dealCard(), cards.dealCard());
        System.out.println("Your hand:" + ph);
    }
    
    /**
     * Given a String representing a hand name, repeatedly deal out
     * poker hands until the specified hand comes up.  Print out how
     * many hands it took to get the desired hand.
     *
     * @param hand is a String representing which hand we are looking for.
     *   Options are : "flush", "pair", "two pair", 
     *                   "three of a kind", "four of a kind", 
     *                  "straight", "full house", "straight flush"
     * @param cards : the deck of cards object to deal
     */
    public static void checkHand(String hand, PlayingCards cards)
    {
        PokerHand ph = null;
        boolean gotHand = false;
        int count = 0;
    
        while(!gotHand) 
        {       
            cards.shuffle();
            count++;
            ph = new PokerHand(cards.dealCard(), cards.dealCard(), 
                 cards.dealCard(),
                cards.dealCard(), cards.dealCard());
                    
            if(hand.equals("flush") && ph.isFlush()) gotHand = true;
            else if(hand.equals("pair") && ph.isPair()) gotHand = true;
            else if(hand.equals("two pair") && ph.isTwoPair()) gotHand = true;
            else if(hand.equals("three of a kind") && ph.isThreeOfAKind()) gotHand = true;
            else if(hand.equals("four of a kind") && ph.isFourOfAKind()) gotHand = true;
            else if(hand.equals("straight") && ph.isStraight()) gotHand = true;
            else if(hand.equals("full house") && ph.isFullHouse()) gotHand = true;
            else if(hand.equals("straight flush") && ph.isStraightFlush()) gotHand = true; 
                
        }
        System.out.println("\nYour " + hand + " after " + count + " tries :");
        System.out.println(ph);
    }
}
