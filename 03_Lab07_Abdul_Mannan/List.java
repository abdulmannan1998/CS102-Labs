/** This class is used to create a list in data structures using nodes which
  * include data and a reference to the next node.
  * @author Mannan Abdul
  * @version 1.00, 8 May 2019
 **/
import junit.framework.TestCase;
public class List extends TestCase{
  
  private Node head;
  
  public List() {
    this.head = null;
  }
  
  public void addToHead(String item){
    Node nodeToAdd = new Node(item, null);
    if (head == null) {
      head = nodeToAdd;
    }
    else {
      nodeToAdd.next = head;
      head = nodeToAdd;
    }
  }
  
  public void addToTail(String item) {
    if (head == null) {
      Node temp = new Node(item, null);
      head = temp;
    }
    else {
      Node currNode = tail();
      Node tail = new Node(item, null);
      currNode.next = tail;
    }
    
  }
  
  public String removeFromHead() {
    Node temp = head;
    if (temp == null) {
      return null;
    }
    head = head.next;
    return temp.data;
  }
  
  public boolean isEmpty() {
    if (head == null) {
      return true;
    }
    return false;
  }
  
  public String getData (int index){
    Node currentNode = head;
    int counter = 0;
    
    while (currentNode != null) {
      if(counter == index)
        return currentNode.data;
      else {
        currentNode = currentNode.next;
      }
      counter += 1;
    }
    return null;
  }
  
  public void print() {
    Node currNode = head;
    System.out.print("List: ");
    while (currNode != null) { 
      System.out.print(currNode.data + " ");
      currNode = currNode.next; 
    } 
  }
  
  public void printReverse() {
    Node temp = head;
    if (head != null) {
      printReverseHelper(temp);
    } else {
      System.out.println("List is Empty");
    }
  }
  
  private void printReverseHelper(Node n){
    if ( n == null) {
      return;
    }
    
    printReverseHelper(n.next);
    System.out.print(n.data + " ");
  }
  
  public boolean contains(String target) {
    Node currNode = head; 
    boolean contains = false; 
    while (currNode != null && !contains) { 
      if ((currNode.data).equals(target)){
        contains = true;
      }
      currNode = currNode.next; 
    }
    return contains;
  }
  
  public boolean isOrdered() {
    Node currNode = head;
    
    if (head == null) {
      return true;
    }
    
    if (head.next == null){
      return true;
    }  
    boolean ordered = false; 
    while (currNode != null && currNode.next != null&& !ordered) { 
      if ((currNode.data).compareTo((currNode.next).data) == -1){
        ordered = true;
      }
      currNode = currNode.next; 
    }
    return ordered;
  }
  
  private Node next(Node n) {
    if (n.next != null) {
      return n.next;
    }
    else {
      return null;
    }
  }
  
  private Node previous(Node n) {
    Node currNode = head;
    if (isEmpty()) {
      return null;
    }
    
    while (currNode.next != null) {
      if (((currNode.next).data).equals(n.data)) {
        return currNode;
      }
      currNode = currNode.next;
    }
    
    return null;
  }
  
  private Node tail() {
    Node currNode = head;
    while (currNode.next != null) {
      currNode = currNode.next;
    }
    
    return currNode;
  }
  
  public String toString() {
    String list = "";
    Node currNode = head;
    while (currNode != null) {
      list = list + currNode.data + " ";
      currNode = currNode.next;
    }
    return list;
  }
  
  public void testContains() {
    List list = this;
    assertTrue("Does not contain the String", list.contains("h1"));
  }
  
  public void testIsEmpty() {
    List list = this;
    assertEquals("List is not empty", 0, this.toString().length());
  }
  
  private class Node {
    String data; 
    Node next; 
    public Node( String data, Node next) {
      this.data = data; 
      this.next = next; 
    } 
  }
  
  
}