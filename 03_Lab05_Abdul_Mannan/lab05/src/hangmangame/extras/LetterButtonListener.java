package hangmangame.extras;

import javax.swing.*;
import java.awt.event.*;
import cs102.hangman.*;

public class LetterButtonListener implements ActionListener {
   Hangman hangman;
   LetterButtonControls letterButtonControls;
   
   public LetterButtonListener( Hangman hangman) {
      this.hangman = hangman;
   }
   
   public void actionPerformed(ActionEvent e) {
      ( (JButton)e.getSource()).setEnabled( false);
      hangman.tryThis( ((JButton)e.getSource()).getActionCommand().charAt(0));
   }
}