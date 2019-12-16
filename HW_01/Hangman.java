/**
 * piece5 of the Hangman game
 * @author Ziya Mukhtarov, Javid Baghirov, Mokhlaroyim Raupova, Mannan Abdul, Alper Sari, Adeem Adil Khatri, Orazmuhammet Bayramov
 * @version 13.02.2019
 */
public class Hangman
{
   private StringBuffer secretWord = new StringBuffer();
   private StringBuffer allLetters = new StringBuffer();
   private StringBuffer usedLetters = new StringBuffer();
   private int numberOfIncorrectTries ;
   private int maxAllowedIncorrectTries;
   private StringBuffer knownSoFar = new StringBuffer();
   
   /**
    */
   public Hangman()
   {
      maxAllowedIncorrectTries = 6;
      allLetters.append("a b c d e f g h i j k l m n o p q r s t u v w x y z");
      numberOfIncorrectTries = 0;
      chooseSecretWord();
      for( int x = 0; x < secretWord.length(); x++) {
         knownSoFar.append("*");
      }
   }
   
   /**
    * Returns all the available letters
    * @return all the available letters
    */
   public String getAllLetters()
   {
      return allLetters.toString();
   }
   
   /**
    * Returns the used letters
    * @return the used letters
    */
   public String getUsedLetters()
   {
      return usedLetters.toString();
   }
   
   /**
    * Returns the number of incorrect tries so far
    * @return the number of incorrect tries so far
    */
   public int getNumOfIncorrectTries()
   {
      return numberOfIncorrectTries;
   }
   
   /**
    * Returns the number of maximum allowed incorrect tries
    * @return the number of maximum allowed incorrect tries
    */
   public int getMaxAllowedIncorrectTries()
   {
      return maxAllowedIncorrectTries;
   }
   
   public String getSecretWord() {
      return secretWord.toString();
   }
   
   /**
    * Returns the currently known word 
    * @return the currently known word 
    */
   public String getKnownSoFar()
   {
      return knownSoFar.toString();
   }
   
   /**
    * @param letter 
    */
   public int tryThis (char letter)
   {
      int count = 0, index = 0;
      if( !isGameOver()) {
         if( allLetters.indexOf(String.valueOf(letter), 0) >= 0) {
            if( usedLetters.indexOf(String.valueOf(letter), index) >= 0) {
               return -2;
            }
            else {
               for( int x = 0; x < secretWord.length(); x++) {
                  if( secretWord.indexOf(String.valueOf(letter), index) >= 0) {
                     count++;
                     index = (secretWord.indexOf(String.valueOf(letter), index)) + 1;
                     knownSoFar.setCharAt(index - 1, letter);
                  }
               }
               if( count == 0) {
                  numberOfIncorrectTries += 1; 
               }
               
            }
         }
         else {
            return -1;
         }
      }
      else {
         return -3;
      }
      usedLetters.append(letter);
      return count;
      
   }
   
   /**
    * Checks whether the game has ended
    * @return true - if the game has already ended, false - otherwise
    */
   public boolean isGameOver()
   {
      return (getKnownSoFar().equals(getSecretWord()) || hasLost());
   }
   
   /**
    * Checks whether the game is lost
    * @return true - if the game is lost, false - otherwise
    */
   public boolean hasLost()
   {
      return numberOfIncorrectTries >= maxAllowedIncorrectTries;
   }
   
   /**
    */
   private void chooseSecretWord ()
   {
      String[] words = {"apple","orange","lemon","kiwi","papaya"};
      int n;
      n = (int) (Math.random() * words.length);
      secretWord.append(words[n]);
   }
}