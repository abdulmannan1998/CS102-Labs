/**
 * This class is used to create a Balloon in the x,y plane.
 * It is used to grow and burst the balloon too.
 * @author Abdul Mannan
 * @version 1.0, 2 April 2019
 */
import shapes.Circle;
import shapes.Drawable;
import java.awt.Graphics;
import java.awt.Color;
public class Balloon extends Circle implements Drawable {
  
  // Constants
  private static final int DEFAULT_SIZE = 25;
  private final int MAXIMUM_SIZE = 100;
  private final int INCREASE_SIZE_BY = 2;
  
  /**
   * Constructor for class Balloon. Initiliazes balloons with default radius 
   * and sets the random location of the circle.
   * @param int x, the random x-coordinate of the circle.
   * @param int y, the random y-coordinate of the circle.
   */
  public Balloon(int x, int y){
    super(DEFAULT_SIZE);
    setLocation(x, y);
  }
  
  
  
  /**
   * This method overrides the draw method. It draws circles.
   * @param Graphics g, the particular circle shape.
   * @return Does not return anything.
   */
  @Override
  public void draw(Graphics g) {
    g.setColor(new Color(0f, 1f, 0f, .5f));
    int radius = this.getRadius();
    g.fillOval(this.getX() - radius, this.getY() - radius, radius * 2, radius * 2);
  }
  
  
  /**
   * This method grows the size of the circle upto a maximum size.
   * @param No input parameters.
   * @return boolean true if balloon not burst, false otherwise.
   */
  public boolean grow() {
    setRadius(getRadius() + INCREASE_SIZE_BY);
    if (getRadius() > MAXIMUM_SIZE) {
      burst();
    }
    return (getRadius() != 0);
  }
  
  
  /**
   * This method bursts the balloon.
   * @param No input parameters.
   * @return Does not return anything.
   */
  public void burst() {
    setRadius(0);
    setSelected(true);
  }
}