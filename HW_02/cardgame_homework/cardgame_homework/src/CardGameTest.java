import java.util.Scanner;
import cardgame.*;

// CardGameTest
// author: Abdul Mannan
// date: 06/03/2019
public class CardGameTest
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        
        System.out.println( "Start of CardGameTest\n");
        
        // CONSTANTS
        
        // VARIABLES
        Card       c;
        Cards      cards;
        ScoreCard  scores;
        Player     p1,p2,p3,p4;
        CardGame   game;
        
        // PROGRAM CODE
        
        // test Card class
        c = new Card( 0, 2);
        System.out.println( c);
        System.out.println();
        
        // test Cards class
        cards = new Cards( false);
        cards.addTopCard( c);
        System.out.println(cards.getTopCard());
        
        
        // test ScoreCard class
        scores = new ScoreCard( 4);
        scores.update( 3, 1);
        scores.update( 1, 2);
        System.out.println( "\n" + scores );
        
        // test Player class
        p1 = new Player("Abdul");
        p2 = new Player("bdul");
        p3 = new Player("dul");
        p4 = new Player("ul");
        System.out.println(p1.getName());
        p1.add(c);
        System.out.println(p1.playCard());
        
        // test CardGame class too?
        game = new CardGame(p1, p2, p3, p4);
        System.out.println(game.playTurn(p1, c));
        System.out.println(game.getWinners()[3].getName());
        System.out.println(game.getScore(3));
        
        
        // Once you have all the bits working, complete the MyCardGame program
        // that provides a menu allowing any of the players to play their card,
        // an option to see the score card, and one to quit the game at any time.
        // When the game is over it should print out the winners.
        
        System.out.println( "\nEnd of CardGameTest\n" );
    }
    
} // end of class CardGameTest
