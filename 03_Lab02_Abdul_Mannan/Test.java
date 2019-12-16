/**
 * This provides a menu to the user, allows them to add links of poems, 
 * see all the poems in a collection and further view each poem individually
 * @author Abdul Mannan
 * @version 1.0, 06 03 2019
 */

import cs1.SimpleURLReader;
import java.util.Scanner;
import java.util.ArrayList;

public class Test {
   public static void main( String[] args) {
      Scanner scan = new Scanner( System.in);
      
      //variables
      String url;
      int option = 0, subOption;
      ArrayList<MySimpleURLReader> collection = new ArrayList<MySimpleURLReader>();
      
      //menu & main code
      while(option != 3) {// so that we keep seeing menu until user quits
         System.out.println("");
         System.out.println("(1) Enter the url of the poem to add to collection");
         System.out.println("(2) List all poems in the collection");
         System.out.println("(3) Quit");
         System.out.println("Enter the index number of the option you want:");
         option = scan.nextInt();
         
         if(option == 1) {
            System.out.println("Enter URL:");
            url = scan.next();
            System.out.println("");
            if(url.contains(".txt")) {//checks if link leads to txt file
               MySimpleURLReader txtPoem = new MySimpleURLReader(url);
               collection.add(txtPoem);
            }
            else if(url.contains(".htm")) {//checks if link leads to htm file
               HTMLFilteredReader htmPoem = new HTMLFilteredReader(url);
               collection.add(htmPoem);
            }
            else {
               System.out.println("Unknown Error!");
            }
         }
         
         if(option == 2) {
            do {
               System.out.println("");
               for( int x = 0; x < collection.size(); x++) {
                  System.out.println( (x + 1) + ". " + (collection.get(x).getName()));
               }
               System.out.println("Enter the index number of the poem you want to view (Main Menu: last index + 1):");
               do {
                  subOption = scan.nextInt();
               }while( subOption > collection.size() + 1);
               if(subOption <= collection.size()) {
                  System.out.println(collection.get(subOption - 1).getPageContents());
               }
            }while(subOption != (collection.size() + 1));//runs until user enters last index + 1               
         }
      }
      System.out.println("GoodBye!");
   }
}