package shapes;
import java.util.ArrayList; 
import java.util.Iterator;
public class ShapeContainer implements Iterable {
   //properties
   ArrayList<Shape> collection;
   
   //constructor
   public ShapeContainer() {
      collection = new ArrayList<Shape>();
   }
   
   //methods
   public void add(Shape s) {
      if(s instanceof Selectable) {
         collection.add(s);
      }
   }
   
   public int size(){
      return this.collection.size();
   }
   
   public double getArea() {
      double totalArea = 0;
      for(int x = 0; x < collection.size(); x++) {
         totalArea = totalArea + collection.get(x).getArea();
      }
      return totalArea;
   }
   
   public String toString() {
      String info = "";
      for(int x = 0; x < collection.size(); x++) {
         info = info + collection.get(x).toString() + "\n";
      }
      return info;
   }
   
   public Shape findContaining(int x, int y) {
      for(int i = 0; x < collection.size(); i++) {
         if(collection.get(i).contains(x, y) != null) {
            return collection.get(i);
         }
      }
      return null;
   }
   
   public void removeSelected() {
      for(int x = 0; x < collection.size(); x++) {
         if(collection.get(x).getSelected() == true) {
            collection.remove(x);
         }
      }
   }
   
   public Iterator<Shape> iterator() {
      return collection.iterator();
   }
   
   public Shape contains(int x, int y) {
      for (int i = 0 ; i < collection.size() ; i++ ) {
         if(((Selectable)collection.get(i)).contains(x, y) == collection.get(i)) {
            ((Selectable)collection.get(i)).setSelected(true);
            return collection.get(i);
         }
      }
      return null;
   }
   
   public int selectAllAt(int x, int y) {
      int numberOfShapes = 0;
      for (int i = 0 ; i < collection.size() ; i++) {
         if (((Selectable)collection.get(i)).contains(x, y) == collection.get(i)) {
            if ((Selectable)collection.get(i) != null) {
               ((Selectable)collection.get(i)).setSelected(true);
               numberOfShapes += 1;
            }
         }
      }
      return numberOfShapes;
   }
}