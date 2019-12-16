package shapes;
public class Rectangle extends Shape {
   //properties
   private int width, height;
   boolean selected = false;
   
   //constructor
   public Rectangle( int width, int height, int x, int y) {
      super.setLocation(x, y);
      this.width = width;
      this.height = height;
   }
   
   //methods
   public double getArea() {
      double area;
      area = width * height;
      return area;
   }
   
   public String toString() {
      String info;
      info = "This rectangle has width " + width + ", height " + height + " and area " + getArea();
      info = info + super.toString();
      if(getSelected() == true) {
         info = info + " and this shape is selected!";
      }
      else {
         info = info + " and this shape is not selected!";
      }
      return info;
   }
   
   public boolean getSelected() {
      return selected;
   }
   
   public void setSelected( boolean select) {
      selected = select;
   }
   
   public Shape contains(int x, int y) {
      if(x < (getX() + width) && y < (getY() + height)) {
         return this;
      }
      else {
         return null;
      }
   }
}