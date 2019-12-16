public class Circle extends Shape{
   //properties
   private int radius;
   private boolean selected = false;
   
   //constructor
   public Circle (int radius, int x, int y) {
      super(x, y);
      this.radius = radius;
   }
   
   //methods
   public double getArea() {
      double area;
      area = (3.142 * (Math.pow(radius, 2)));
      return area;
   }
   //super toString
   public String toString() {
      String info;
      info = "This circle has radius " + radius + " and area " + getArea();
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
      if(x < (getX() + radius) && y < (getY() + radius)) {
         return this;
      }
      else {
         return null;
      }
   }
}