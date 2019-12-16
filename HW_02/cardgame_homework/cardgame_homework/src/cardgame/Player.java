package cardgame;

// Player - Simple card game player with name and hand of cards
// author: Abdul Mannan 
// date: 06/03/2019
public class Player
{
    // properties
    String name;
    Cards hand;
    
    // constructors
    public Player( String name)
    {
        this.name = name;
        hand = new Cards(false);
    }
    
    // methods
    public String getName()
    {
        return name;
    }
    
    public void add( Card c)
    {
    	hand.addTopCard(c);
    }
    
    public Card playCard()
    {
    	Card c = new Card(0);
    	c = hand.getTopCard();
        if(c == null) {
           return null;
        }
        else {
           return c;
        }
    }
    
} // end class Player
