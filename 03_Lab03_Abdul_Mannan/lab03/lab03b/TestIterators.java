import java.util.Iterator;

public class TestIterators {
   public static void main( String[] args) {
      Iterator i, j;
      
      IntBag bag = new IntBag();
      bag.add(1);
      bag.add(2);
      bag.add(3);
      bag.add(4);
      i = bag.iterator();
      
      while ( i.hasNext() ) 
      {
         System.out.println( i.next() );
         
         //j = new IntBagIterator( bag);
         j = bag.iterator();
         
         while ( j.hasNext() )
         {
            System.out.println( "--" + j.next() );
         }
      }
   }
}