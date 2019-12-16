package hangmangame.extras;
/**
 * This class creates the text field in which the hangman game letters are input.
 * @author Mannan Abdul
 * @version 1.00, 17 April 2019
 */
import cs102.hangman.*;
import javax.swing.*;
import java.awt.event.*;

public class TextFieldControlPanel extends JPanel implements ActionListener {
  
  private JTextField textField;
  private Hangman hangman;
  
  public TextFieldControlPanel(Hangman hangman) {
    super();   
    this.hangman = hangman;
    textField = new JTextField(50);//max length of 10
    
    this.add(textField); //adding textField to the panel
    textField.addActionListener(this);//adding controls to the textfield
  }
  
  public void actionPerformed(ActionEvent event) {
    String letters = textField.getText();
    
    //tryThis for all characters
    for (int i = 0; i < letters.length(); i++) {
      hangman.tryThis(letters.charAt(i));
    }
    
    //changes the textfield to an empty one
    textField.setText("");
  }
}