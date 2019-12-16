//import java.util.Iterator;
//
//public class IntBagIterator implements Iterator <Integer> {
//   int index;
//   IntBag aBag = new IntBag();
//   
//   public IntBagIterator(IntBag x) {
//      aBag = x;
//      index = 0;
//   }
//   
//   public boolean hasNext() {
//      if(index < aBag.size()) {
//         return true;
//      }
//      else {
//         return false;
//      }
//   }
//   
//   public Integer nextInt() {
//      Integer x;
//      x = aBag.get(index);
//      return x;
//   }
//   
//   public Integer next() {
//      Integer x = nextInt();
//      index++;
//      return x;
//   }
//   
//}