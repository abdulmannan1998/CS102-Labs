package cardgame;

/**
 * Card - a single playing card
 * @author Abdul Mannan
 * @version 1.0
 */
public class Card
{
    final String[] SUITS = { "Hearts", "Diamonds", "Spades", "Clubs"};
    final String[] FACES = { "2", "3", "4", "5",
                             "6", "7", "8", "9", "10",
                             "J", "Q", "K", "A"};
    
    final int NOOFCARDSINSUIT = 13;
    
    // properties
    int  cardNo;
    
    // constructors
    public Card( int faceValue, int suit )
    {
        cardNo = faceValue + suit * NOOFCARDSINSUIT;
    }
    
    public Card( int cardNumber)
    {
        cardNo = cardNumber;
    }
    
    //methods
    public int getFaceValue()
    {
        return cardNo % NOOFCARDSINSUIT;
    }
    
    public int getSuit()
    {
        return cardNo / NOOFCARDSINSUIT;
    }
    
    public String toString()
    {
        return FACES[ getFaceValue() ] + " of " + SUITS[ getSuit() ];
    }
    
    public boolean equals( Card c)
    {
       if(getFaceValue() == c.getFaceValue() &&  getSuit() == c.getSuit()) {
          return true;
       }
       else{
          return false;
       }
    }
    
    public int compareTo( Card c)
    {
       if(cardNo > c.cardNo) {
          return 1;
       }
       else if(cardNo == c.cardNo) {
          return 0;
       }
       else {
          return -1;
       }
    }
}