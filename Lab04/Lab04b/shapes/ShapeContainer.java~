import java.util.ArrayList;
public class ShapeContainer {
   //properties
   ArrayList<Shape> collection = new ArrayList<Shape>();
      
   //constructor
   public ShapeContainer() {
   }
   
   //methods
   public void add(Shape s) {
      if(s instanceof Selectable) {
         collection.add(s);
      }
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
}