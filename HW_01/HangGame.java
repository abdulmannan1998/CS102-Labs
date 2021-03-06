import java.util.Scanner; 

public class HangGame {
   /*
    * Yi�it G�rses
    * �mer �nl�soy 
    * �ebnem Uslu
    * Defne �ift�i
    * Gizem Bal
    * Cemre Biltekin
    */   
   public static void main( String[] args) {
      
      //variables
      Scanner scan = new Scanner( System.in);
      Hangman game = new Hangman();
      int result= 0;
      
      //program code
      
      System.out.println("Welcome to the Hangman game");
      
      //the game loop
      while( !game.isGameOver()) {
         
         //prints the available letters
         
         System.out.println("available letters: " + game.getAllLetters() + "\n" );
         
         //prints the knownsofar, used letters and tries left
         System.out.println("the word: " + game.getKnownSoFar() + "\n" );
             
         System.out.println("Used letters: " + game.getUsedLetters() + "\n" );
         
         System.out.println("You have " + (game.getMaxAllowedIncorrectTries() 
                                              - game.getNumOfIncorrectTries()) 
                               + " tries left");
         
         //asks for next guess
         System.out.println("Try a letter from the list: ");
         result = game.tryThis( scan.next().charAt(0));
         if( result == -1) {
            System.out.println("Invalid Letter, Try Again!");
         }
         else if( result == -2) {
            System.out.println("Letter Already Used!");
         }
      }
      
      //informs the user if he/she won or not
      if ( game.hasLost() ) {
         System.out.println(" You lost :( ");
         //if secret word is not private
         System.out.println("the word was: " + game.getSecretWord());
      }
      else {
         System.out.println("You won!");
         System.out.println("the word was: " + game.getKnownSoFar() + "\n" );
      }
      
      
   }
} //end class