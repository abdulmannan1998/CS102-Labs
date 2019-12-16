/**
 * This program will present a menu to the user which will then prompt the user to choose
 * any option from it and performs specific functions accordingly.
 * @author Abdul Mannan
 * @version 1.0, 20 Februrary 2019
 */
import java.util.Scanner;
public class Lab01c {
  public static void main(String[] args) { 
    
    Scanner scan = new Scanner(System.in); 
     
    //creating a menu
    System.out.println("1. Create a new empty collection with a specified maximum capacity.");
    System.out.println("2. Read a set of positive values into the collection.");
    System.out.println("3. Print the collection of values.");
    System.out.println("4. Add a value to the collection of values at a specified location.");
    System.out.println("5. Remove the value at a specified location from the collection of values.");
    System.out.println("6. Read a single test value.");
    System.out.println("7. Compute the set of locations of the test value within the collection.");
    System.out.println("8. Print the set of locations.");
    System.out.println("9. Quit the program.");  
    System.out.println("Enter the corresponding number to the options presented above: ");
    int option = scan.nextInt();
    
    //variables
    int size = 0; //The size of the collection variable initialized for use by multiple if statements
    IntBag collection = new IntBag(size); //an empty collection
    int testValue = 0; //a test value initialized for use by multiple if statements
    String allIndex = ""; //index string intialized for use by multiple if statements
    
    //main code
    while (option != 9) {
      
      
      if (option == 1) { //This part deals with the creation of a list with the specified number of elements 
        System.out.println("Enter the size of the collection: ");
        size = scan.nextInt();
        collection = new IntBag(size);
        System.out.println("New array of size " + size + " created.");
      }
      
      
      if (option == 2) { //This part deals with the addition of elements to the list that was previously created
        System.out.println("Enter the values to add to collection: ");      
        int valuesToAdd = scan.nextInt();
        while (valuesToAdd >= 0) {
          collection.add(valuesToAdd);
          valuesToAdd = scan.nextInt();
        }
        System.out.println("All values added to the collection.");
      }
      
      if (option == 3) { //This part is used to print out the collection
        System.out.println(collection);
      }
      
      if (option == 4) { //This part is used to add a value at a particular place in a collection
        System.out.println("Enter the number to add to the collection: ");
        int numberToAdd = scan.nextInt();
        System.out.println("Enter the index at which the number is to be added: ");
        int index = scan.nextInt();
        if (index >= 0 && index < size){
          if (collection.add(numberToAdd,index)) { 
            System.out.println(numberToAdd + " added at index " + index);
          }
          else {
            System.out.println("Collection full. Can't add any more numbers.");
          }
        }
        else {
          System.out.println("Index not valid.");
        }
      }
      
      if (option == 5) { //This part is used to remove a value from a particular index in the collection
        System.out.println("Enter the index to remove value from: ");
        int index = scan.nextInt();
        if (collection.remove(index)) {
          System.out.println("Number at index " + index + " removed.");
        }  
      }
      
      
      if (option == 6) { //In this part, a value is read that is used during tests for the next parts
        System.out.println("Enter the test value: ");
        testValue = scan.nextInt();
      }
      
      if (option == 7) { //Indexes of test value in a collection are computed 
        allIndex = collection.findAll(testValue);
        
      }
      
      if (option == 8) { //Indexes of the test value are printed
        System.out.println(collection.findAll(testValue));
      }
      System.out.println("Select one of the options presented above by selecting the no. corresponding to it: ");
      option = scan.nextInt();
      
    }
    
  } //end main 
} //end class
