import cs1.SimpleURLReader;

public class Test2 {
   public static void main( String[] args) {
      XHTMLFilteredReader test = new XHTMLFilteredReader("http://www.cs.bilkent.edu.tr/~david/index.html");
      System.out.println(test.getLinks());
   }
}