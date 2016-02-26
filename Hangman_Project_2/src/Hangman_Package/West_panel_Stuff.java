package Hangman_Package;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class West_panel_Stuff extends JPanel {

    public JLabel guessesL;
    public  static JLabel guessesNUmberL;
    public static JLabel wrongL;
    public static JLabel wordBankL;
    public static JPanel west_subpanel;
    public static ArrayList<Character> guesses = new ArrayList<Character>();
    public static char[] templist;

    public West_panel_Stuff(){


    this.setSize(100, 300);
    this.setVisible(true);
    this.setFocusable(true);
    this.setLayout(new GridLayout(20,6));



        // make the number guessed Jlabel

        wordBankL = new JLabel("" +  Hangman_panel.userInputChar);
        wordBankL.setText("" + Hangman_panel.userInputChar);
        wordBankL.setSize(50,50);


        wrongL = new JLabel("wrong");
        wrongL.setSize(50,50);
       // wrongL.setLocation(10,30);

        guessesL = new JLabel("Number of\n guesses \n wrong");
        guessesL.setSize(50,50);
       // guessesL.setLocation(10,10);

        // make guessesNumberL
        guessesNUmberL = new JLabel(""+ check_it.wrongchoice );

        guessesL.setSize(20,20);
        //guessesL.setLocation(15,15);


        add(guessesL);
       // add(wrongL);
        add(guessesNUmberL);
        add(wordBankL);

    }

}



