/**
 * This class extends the JFrame class of Swing Library. It creates a game that
 * presents the user with 25 buttons, with a hidden prize.
 * @author Abdul Mannan
 * @version 1.0, 2 April 2019
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class Lab04a extends JFrame implements ActionListener {
   
   // Constants  
   private final int ROW = 5;
   private final int COLUMN = 5;
   
   // Variables
   private JLabel label;
   private JButton prizeButton;
   private int prize = 0;
   private int counter;
   private JButton restartGame;
   private JPanel contentPanel;
   private JPanel panel;
   
   /**
    * This is a constructor for the PotLuck class. It sets the game.
    * @param No input parameters.
    * @return Does not return anyting.
    */
   public Lab04a() {
      setTitle("Pot Luck Game");
      setBounds(500, 500, 500, 500);
      contentPanel = new JPanel();
      contentPanel.setBorder(new EmptyBorder(ROW, ROW, COLUMN, COLUMN));
      contentPanel.setLayout(new BorderLayout());
      setContentPane(contentPanel);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      panel = new JPanel();
      contentPanel.add(panel, BorderLayout.CENTER);
      panel.setLayout(new GridLayout(ROW, COLUMN, ROW*2, COLUMN*2));
      
      // To count the number of clicks
      counter = 0;
      
      // Generating random locations
      prize = (int)(Math.random()*(ROW*COLUMN));
      
      // System.out.println(prize);
      
      // Adding buttons
      for(int i = 0; i < (ROW*COLUMN); i++){
         
         // Adding prize button at the randombly generated locattion
         if(prize == i){
            prizeButton = new JButton();
            prizeButton.addActionListener(this);
            panel.add(prizeButton);
         }
         else{
            JButton temp = new JButton();
            panel.add(temp);
            temp.addActionListener(this);
         }
      }
      // Setting and aligning the number of buttons clicked
      label = new JLabel();
      label.setText("You clicked " + counter + " times.");
      label.setHorizontalAlignment(SwingConstants.CENTER);
      contentPanel.add(label, BorderLayout.NORTH);
   }
   
   /**
    * This method overrides the abstract method from the ActionListener interface. It performs specific functions with 
    * specific button clicks.
    * @param event, that contains the details of the event.
    * @return Does not return anyting.
    */
   
   public void actionPerformed(ActionEvent e) {
      // Checking if empty buttons clicked
      if (e.getSource() != prizeButton){
         counter += 1;
         ((JButton) e.getSource()).setEnabled(false);
         label.setText("You clicked " + counter + " times.");
      }
      // Checking if prize button clicked
      else{ 
         label.setText("You got the prize in " + (counter + 1) + " clicks." );
         for(int i = 0; i < (ROW*COLUMN); i++){
            if(panel.getComponent(i) != prizeButton){
               ((JButton) panel.getComponent(i)).setEnabled(false);   
            }
         }
      }
   }
   
// Main Method
   public static void main(String[] args) {
      Lab04a game = new Lab04a();
   }
}