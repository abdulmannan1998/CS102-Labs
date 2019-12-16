package hangmangame;

import cs102.hangman.*;
import hangmangame.extras.*;
import java.awt.*;
import javax.swing.*;

/**
 * Hangman (Revised for Lab05 Spring 2018-19)
 * @author david
 */
public class GUIHangmanDemo {
   
   public static void main(String[] args) { 
      
      // variables
      JFrame           f;
      IHangmanSetup    hmSetup;
      HangmanModel     hmModel;
      HangmanGUIPanel  hmView;
      
      // program code ~ set up models, views & controllers!
      f = new JFrame( "MVC GUI Hangman ~ v2");
      f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      f.setLayout( new FlowLayout( FlowLayout.CENTER, 20, 10) );
      f.setResizable(false);
      hmSetup = new BasicSetup();
      hmModel = new HangmanModel( hmSetup );
      
      // create a console (textonly) view and add it to the hmModel
      //hmModel.addView( new HangmanConsoleView() );
      
      // create a GUI view, passing it the hmModel, then add to frame 
      hmView = new HangmanGUIPanel( hmModel);
      
      f.add( hmView );
    
      f.pack();
      f.setVisible(true);
      
   }
    
}
