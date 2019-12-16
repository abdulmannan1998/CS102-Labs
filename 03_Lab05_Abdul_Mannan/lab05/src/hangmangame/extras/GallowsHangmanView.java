package hangmangame.extras;
/**
 * This class draws the hangman body and the gallow according to the number of incorrect tries.
 * @author Mannan Abdul
 * @version 1.00, 17 April 2019
 */
import cs102.hangman.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class GallowsHangmanView extends JPanel implements IHangmanView {
  
  private Rectangle2D.Double[] rectangle;
  private Line2D.Double[] bodyLines;
  private Ellipse2D.Double head;
  private Hangman hangman;
  private Shape[] man;
  private String knownSoFar;
  private String noOfTries;
  private String lettersUsed;
  
  private static final int PANEL_HEIGHT = 400;
  private static final int WIDTH = 400;
  private static final int X = 0;
  private static final int Y = 50;
  
  public GallowsHangmanView(Hangman hangman) {
    super();
    this.hangman = hangman;
    this.setBackground(Color.white);
    
    rectangle = new Rectangle2D.Double[4];
    bodyLines = new Line2D.Double[5];
    man = new Shape[6];
    
    knownSoFar = "";
    noOfTries = "";
    lettersUsed = "";
    
    rectangle[0] = (new Rectangle2D.Double(20 + X, 400 + Y, 300, 50));
    rectangle[1] = (new Rectangle2D.Double(60 + X, 40 + Y, 20, 360));
    rectangle[2] = (new Rectangle2D.Double(80 + X, 40 + Y, 120, 20));
    rectangle[3] = (new Rectangle2D.Double(194 + X, 60 + Y, 6, 30));
    
    head = new Ellipse2D.Double(167 + X, 90 + Y, 60, 60);
    
    
    bodyLines[0] = new Line2D.Double(head.getX() + (head.getWidth() / 2),
    head.getY() + head.getHeight(), head.getX() + (head.getWidth() / 2), head.getY() + head.getHeight() + 70);
    //left leg
    bodyLines[1] = new Line2D.Double(bodyLines[0].getX2(), bodyLines[0].getY2(),
    bodyLines[0].getX2() - 30, bodyLines[0].getY2() + 60);
    //right leg
    bodyLines[2] = new Line2D.Double(bodyLines[0].getX2(), bodyLines[0].getY2(),
    bodyLines[0].getX2() + 30, bodyLines[1].getY2()); 
    //left arm
    bodyLines[3] = new Line2D.Double(bodyLines[0].getX2(), 
    ((bodyLines[0].getY2() - bodyLines[0].getY1()) / 5) + bodyLines[0].getY1(),
    bodyLines[0].getX1() - 28, ((bodyLines[0].getY2() - bodyLines[0].getY1()) / 4) + bodyLines[0].getY1() + 40);
    //right arm
    bodyLines[4] = new Line2D.Double(bodyLines[0].getX2(), bodyLines[3].getY1(),
    bodyLines[0].getX1() + 28, bodyLines[3].getY2());
    
    
    man[0] = head;
    for (int i = 1; i < man.length; i++) {
      man[i] = bodyLines[i - 1];
    }
  }
  
  
  public void updateView(Hangman hangman) {
     repaint();
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D newGraphics = (Graphics2D) g;
    
    newGraphics.setPaint(Color.black);
    for(int i = 0; i < rectangle.length; i++) {
      newGraphics.fill(rectangle[i]);
    }
    
    for(int i = 0; i < hangman.getNumOfIncorrectTries(); i++) {
      newGraphics.draw(man[i]);
    }
   
    newGraphics.setPaint(Color.blue);
    
    newGraphics.drawString(knownSoFar, (int)rectangle[0].getX() + 20,
    (int)(rectangle[0].getY() + rectangle[0].getHeight()) + 60);
    newGraphics.drawString(lettersUsed, (int)rectangle[0].getX() + 20,
    (int)(rectangle[0].getY() + rectangle[0].getHeight()) + 120);
    newGraphics.drawString(noOfTries, (int)(rectangle[1].getX()
    + rectangle[1].getWidth()) + 15, (int)rectangle[0].getY() - 50);

  }
  
}