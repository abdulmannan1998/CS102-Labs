package cardgame;

// Cards - Maintains a collection of zero or more playing cards.
//         Provides facilities to create a full pack of 52 cards
//         and to shuffle the cards.
// author: Abdul Mannan
// date: 06/03/2019
public class Cards
{
    final int NOOFCARDSINFULLPACK = 52;
    
    // properties
    Card[] cards;
    int    valid;  // number of cards currently in collection
    
    // constructors
    public Cards( boolean fullPack)
    {
        cards = new Card[ NOOFCARDSINFULLPACK ];
        valid = 0;
        
        if ( fullPack)
            createFullPackOfCards();
    }
    
    // methods
    public Card getTopCard()
    {
        Card temp;

        if ( valid <= 0)
            return null;
        else
        {
            valid--;
            temp = cards[valid];
            cards[valid] = null;
            return temp;
        }
    }
    
    public boolean addTopCard( Card c)
    {
        if ( valid < cards.length)
        {
            cards[valid] = c;   // should this be cloned?
            valid++;
            return true;
        }
        return false;
    }
    
    private void createFullPackOfCards()
    {
        for( int x = 0; x < NOOFCARDSINFULLPACK; x++) {
          addTopCard( new Card(x));
       }
    }
    
    public void shuffle()
    {
        Card intermediate = new Card(0);
        int shuffle = 0, shuffle2 = 0;
        
        for( int x = 0; x < (int)((Math.random() * 51) + 50); x++) {
           shuffle = (int)(Math.random() * 52);
           shuffle2 = (int)(Math.random() * 52);           
           intermediate = cards[shuffle];
           cards[shuffle] = cards[shuffle2];
           cards[shuffle2] = intermediate;
        }
    }
    
    
   
    
} // end class Cards
