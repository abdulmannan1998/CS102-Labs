package hangmangame.extras;

import java.awt.event.*;
import cs102.hangman.*;
import javax.swing.*;

public class LetterButtonsController implements ActionListener {

   
 private Hangman hangman;
 
 
 public LetterButtonsController(Hangman hangman) {
   this.hangman = hangman;
 }
  
 public void actionPerformed(ActionEvent event) {
   JButton button = (JButton) event.getSource(); 
   char ch = button.getText().charAt(0);
   hangman.tryThis(ch); 
   button.setEnabled(false);
   
 }
 
 
}