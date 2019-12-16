/** This class is used to create recursive methods.
  * One counts the number of "E"s in a string
  * One of them prints the binary equivalent of a decimal number
  * One checks if strings in an ArrayList are in lexicographic order
  * One prints n digit even numbers provided that the previous digit is smaller than the next
  * Methods are all done by recursion
  * @author Mannan Abdul
  * @version 1.00, 01 May 2019
  **/
import java.util.ArrayList;
public class Lab06 {
   
   public static void main(String[] args) {
      
      System.out.println("Part A");
      System.out.println(eCounter("Do you want game of thrones spoilers?"));
      
      System.out.println("Part B");
      toBinary(6);
      System.out.println();
      
      System.out.println("Part C");
      ArrayList<String> list = new ArrayList<String>();
      list.add("wolf");
      list.add("antenna");
      System.out.println(lexicographicOrder(list));
      
      System.out.println("Part D");
      nDigits(8);
      
   }
   
  /** This method counts the number of "E"s in a string recursively.
    * @param string - The string
    * @return - The number of "E"s
    **/
   public static int eCounter (String string) {
      int count = 0;
      
      if (string.length() == 0) {
         return count;
      }
      
      if (string.substring(0,1).equalsIgnoreCase("e")) {
         count = 1 + eCounter(string.substring(1));
         return count;
      }
      
      count = eCounter(string.substring(1));
      return count;
   }
   
  /** This method prints the binary equivalent of a decimal number recursively.
    * @param decimalNumber - The number in decimal 
    **/
   public static void toBinary (int number) {
      String binary = "";
      
      if (number > 0) {
         toBinary(number / 2); 
         System.out.print(number % 2 + binary);
      }
   }
   
   /** This method checks if the list is in lexicographic order or not.
     * @param list - The arraylist of strings
     * @return - If in order or not
     **/
   public static Boolean lexicographicOrder(ArrayList<String> list) {
      if (list.size() == 1) {
         return true;
      }
      
      if ((list.get(0)).compareTo(list.get(1)) <= 0) {        
         list.remove(0);
         return lexicographicOrder(list);
      }
      return false;
   }

   /** This method prints n digit even numbers given that the previous digit is smaller than the next one.
     * @param n - The number of digits
     **/
   public static void nDigits(int num) {
      for(int x = ((int)Math.pow(10, num - 1)); x < (int)Math.pow(10, num); x++) {
         if(x % 2 == 0){
            if(conditionChecker(x)) {
               System.out.println(x);
            }
         }
      }
   }
   
   public static boolean conditionChecker(int num) {
      if(((num % 10) > ((num / 10) % 10)) && (num >= 10)) {
         return conditionChecker(num / 10);
      }
      else if( num < 10) {
         return true;
      }
      else{
         return false;
      }
   }
   
}



