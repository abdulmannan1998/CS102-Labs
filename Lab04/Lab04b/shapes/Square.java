package shapes;
public class Square extends Rectangle{
   //properties
   private int side;

   //constructor
   public Square( int side, int x, int y) {
      super(side, side, x, y);
      this.side = side;
   }
   
   //methods
     public String toString() {
      String info;
      info = "This square has sides " + side + " and area " + getArea();
      return info;
   }
}