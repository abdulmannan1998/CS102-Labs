import java.util.Iterator;

/**
 * This class creates a collection of integers. It stores integers in an array and keeps track of the number of 
 * elements added to the collection.
 * @author Abdul Mannan
 * @version 1.0, 20 Februrary 2019
 */
public class IntBag {
  
  //properties
  private int[] bag; //holds the values in the bag
  private int valid; // position for elements of the bag (valid or not?)
  
  private int maxElements = 100;
  
  //constructors
  /**
   * Constructor for class IntBag. Initializes an array of elemets with a total of maxElems number of elements.
   * @param no input parameters.
   */
  public IntBag() { 
    bag = new int[maxElements];
    valid = 0;
  }
  
  /**
   * Another constructor for class IntBag. Initializes an array of elements with the number of elements provided.
   * @param numberOfElements (number of elements in the int bag)
   */
  public IntBag(int numberOfElements) {
    this.maxElements = numberOfElements;
    bag = new int[this.maxElements];
    valid = 0;
  }
  
  //methods
  /**
   * This method adds an integer to the end of the collection.
   * @param valueToAdd (integer to be added)
   * @return If added, true returned. It not, false returned.
   */
  public boolean add(int valueToAdd){
    
    if (!isValid()) {
      return false;
    }
    
    bag[valid] = valueToAdd;
    valid++;
    return true;
  }
  
  /**
   * This method adds an integer to a specified index in the collection.
   * @param valueToAdd (integer to be added)
   * @param i (index at which the integer is to be added)
   * @return If added, true returned. It not, false returned.
   */
  public boolean add(int valueToAdd , int i){
    
    if(!isValid()) {
      return false;
    }
    
    // Check if i is in within bounds
    if ( i < 0 || i > maxElements || i > valid) {
      return false;
    }
    
    // Move the values an index forward
    for ( int j = valid; j > i; j--) { 
      bag[j] = bag[j - 1]; 
    }
    
    // Add the element at i
    bag[i] = valueToAdd;
    
    valid++;
    return true;
  }
  
  /**
   * This method removes the integer at the specified index and then moves all the rest of the
   * integers in the collection "down" the list.
   * @param i (index at which the integer is to be removed)
   * @return  If removed, true returned. It not, false returned
   */
  public boolean remove(int i) {
    if ( i >= 1 && i < maxElements ){
      for (int j = i ; j < bag.length - 1 ; j++) {
        bag[j] = bag[j+1];
      }
      
      valid--;
      return true;
    }
    else {
      return false;
    }
  }
  
  /**
   * This method tells if an integer is present in a collection or not.
   * @param valueToSearch (integer to search  for in the collection)
   * @return If present, true returned. It not, false returned.
   */
  public boolean contain(int valueToSearch) {
    for (int i = 0 ; i < bag.length ; i++) {
      if (bag[i] == valueToSearch) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * This method tells the number of integers present in the collection.
   * @param No input parameters.
   * @return valid which is the number of integers in the collection.
   */
  public int size() {
    return valid;
  }
  /**
   * This method gets the element at a particular index.
   * @param index (index of element to be returned)
   * @return integer present at the particular index.
   */  
  public int get(int index) {
    return bag[index];
  }
  
  /**
   * This method returns the elements of the collection in a String format.
   * @param No input parameters.
   * @return The string format of the array.
   */
  public String toString() {
    String contents = "";
    
    if (valid > 0) {
      for (int i = 0 ; i < valid ; i++) {
        contents += bag[i] + " ";
      }
    }
    else {
      contents = "Nothing in the collection.";
    }
    
    return contents;
  }
  
  
  /**
   * This method tells if the number of elements in the collection exceeds the maximum number or not.
   * @param No input parameters.
   * @return Returns false if index is exceeded, and true if not.
   */
  private boolean isValid() {
    if ( valid >= this.maxElements) {
      return false;
    }
    return true;
  }
  
  /**
   * This method gives us all the indexes of an element in the collection.
   * @param numberToFind (integer that is to be searched in the collection)
   * @return The positions of an integer in the collection.
   */
  public String findAll(int numberToFind) {
    String allIndexes = "";  
    
    for (int i = 0 ; i < valid ; i++) {
      if (bag[i] == numberToFind) {
        allIndexes += i + " ";
      }
    }
    return allIndexes;
  }
  
  public Iterator iterator() {
     IntBagIterator iterator = new IntBagIterator(this);
     return iterator;
  }
  
  public class IntBagIterator implements Iterator <Integer> {
   int index;
   IntBag aBag = new IntBag();
   
   public IntBagIterator(IntBag x) {
      aBag = x;
      index = 0;
   }
   
   public boolean hasNext() {
      if(index < aBag.size()) {
         return true;
      }
      else {
         return false;
      }
   }
   
   public Integer nextInt() {
      Integer x;
      x = aBag.get(index);
      return x;
   }
   
   public Integer next() {
      Integer x = nextInt();
      index++;
      return x;
   }
   
}
}
