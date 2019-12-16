public abstract class Shape implements Locatable,Selectable{
   //properties
   int x, y; 
   
   //constructor
   public Shape( int x, int y) {
      setLocation(x, y);
   }
   
   //methods
   public abstract double getArea();
   
   public int getX() {
      return x;
   }
   
   public int getY() {
      return y;
   }
   
   public void setLocation(int x, int y) {
      this.x = x;
      this.y = y;
   }
   
   public String toString() {
      String s;
      s = ". The coordinates of this Shape are (" + getX() + ", " + getY() + ")";
      return s;
   }
}