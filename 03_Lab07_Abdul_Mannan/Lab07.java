/** This class is used to test the list class.
  * It creates an instance of the class and checks all the methods.
  * @author Mannan Abdul
  * @version 1.00, 8 May 2019
  **/
public class Lab07 {
  public static void main(String[] args) { 
    
    List list = new List();
    
    list.addToHead("e");
    list.addToHead("d");
    list.addToHead("c");
    list.addToHead("b");
    list.addToHead("a");
    System.out.println("List after adding to head: " + list);
    
    list.addToTail("z");
    System.out.println("List after adding to tail: " + list);
    
    System.out.println("Item removed from head: " + list.removeFromHead());
    System.out.println("List after removing from head: " + list);
    
    int index = 4;
    System.out.println("Data at index " + index + " is " + list.getData(index));  
    
    list.print();
    System.out.println();
    
    System.out.print("List in reverse is: ");
    list.printReverse();
    System.out.println();
    
    String element = "c";
    if (list.contains(element)) {
      System.out.println(element + " is in list.");
    } 
    else {
      System.out.println(element + " is not in list.");
    }
    
    if (list.isOrdered()) {
      System.out.println("List is in order.");
    }
    else {
      System.out.println("List is not in order.");
    }
    
    String arrayOfStrings[] = new String[2];
    arrayOfStrings[0] = "hello";
    arrayOfStrings[1] = "world";
    System.out.println(createFrom(arrayOfStrings));
    
    String str = "hello";
    System.out.println(createFrom(str));
    
    List a = new List();
    a.addToTail("A");
    a.addToTail("D");
    a.addToTail("C");
    
    List b = new List();
    b.addToTail("K");
    b.addToTail("B");
    b.addToTail("A");
    b.addToTail("C");
    b.addToTail("R");
    System.out.println(b);
    System.out.println(a);
    System.out.println(merger(a, b));
    
    
    list.addToTail("a");
    list.addToTail("b");
    list.addToTail("c");
    list.addToTail("d");
    list.addToTail("e");
    System.out.println(list);
    
    list.removeFromHead();
    list.removeFromHead();
    list.removeFromHead();
    list.removeFromHead();
    System.out.println(list);
    
    list.addToTail("Hail");
    System.out.println(list);
    
    list.addToTail("Mary");
    System.out.println(list);
    list.removeFromHead();
    list.removeFromHead();
    System.out.println(list);
    
    //JUnit Testing
    //list.testContains();
    //list.testIsEmpty();
  }
  
  public static List createFrom(String[] string) {
    List list = new List();
    for (int i = 0; i < string.length; i++) {
      list.addToTail(string[i]);
    }
    return list;
  }
  
  public static List createFrom(String string) {
    List list = new List();
    for (int i = 0; i < string.length(); i++) {
      list.addToTail(string.substring(i,i+1));
    }
    return list;
  }
  
  public static List merger (List a, List b) {
    List list = new List();
    for (int i = 0 ; a.getData(i) != null ; i++) {
      if (!b.contains(a.getData(i))) {
        list.addToTail(a.getData(i));
      }
    }
    
    for (int j = 0 ; b.getData(j) != null ; j++) {
      if (!a.contains(b.getData(j))) {
        list.addToTail(b.getData(j));
      }
    }
    return list;
    
  }
}
