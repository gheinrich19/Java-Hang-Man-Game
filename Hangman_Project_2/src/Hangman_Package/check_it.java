package Hangman_Package;


import javax.swing.*;
import java.util.Random;

/**
 * Created by gage heinrich on 4/15/14.
 */
public class check_it extends JPanel{

    public static String [] wordsArray1 = {"hi", "java","microsoft","apple","hawaii"};
    public static String [] wordsArray2 = {"congruent", "wrangler","","ambulance","pseudoscience","camoflauge",
            "xenophobia"," The cat is fat"};
    public String  tempArray;
    public char [] blankArray = {'_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_',
                                '_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_',};
    public char [] letters;
    public static  char [] guessedletters = {'_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_',
                                     '_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_'};
    public static char [] arrayChar;
    public char [] arrayCharCheck;
    public static int  wrongchoice;
    public static boolean wrongguess;
    public static boolean letterUsed;
    public static boolean Winorloose;
    public static int answer;
    private ImageIcon gameOverI,winnerIcon;
   // private Hangman_panel hangman_panel;
    private Rest_Game rest_game;
    Random rand;


    public void chooseWord(String[] temp){


        // make the game over icon
        gameOverI = createImageIcon("game_over.jpg");
        winnerIcon = createImageIcon("You-Win.png");

        rand = new Random();

        // lets choose a word from our list

        //use the temp array to put string in from our wordsarray of string type
        tempArray = temp[rand.nextInt(temp.length)];
        arrayCharCheck = tempArray.toCharArray();
        letters = tempArray.toCharArray();
        arrayChar = tempArray.toCharArray();

        // this will set the arrays we will use to blank for initialization
        for (int i = 0; i <arrayChar.length; i++)
        {
            arrayCharCheck[i]=blankArray[i];
            letters[i] = blankArray[i];
        }

    }

    // this function compares arrayChar with the word we have put into it with the letters passed through
    // the perameter of the function.
    public void checkWord(char c){

        wrongguess = false;
        letterUsed = false;
        int temp = 0;
        // lets increment the wrongchoice if the guessed letter isn't
        // contained in the word!

        for ( int i =0; i<guessedletters.length; i++){

            if(guessedletters[i]== c)
                letterUsed = true;
        }

        for (int i = 0; i<arrayChar.length; i++)
        {
            if(arrayChar[i] == c && wrongguess == false)
                wrongguess = true;
        }

        if (letterUsed = false){
            for(int i = 0; i<guessedletters.length; i++){
                if(guessedletters[i] ==c ){
                    temp = 1;
                    break;
                }
        }
        }

        if(wrongguess == false)
            wrongchoice = wrongchoice+1;

        if(letterUsed == true)
            wrongchoice = wrongchoice-1;

        West_panel_Stuff.guessesNUmberL.setText("" +wrongchoice );
        System.out.println("" + wrongchoice);

        for (int i =0; i < arrayChar.length;i++){
            if(arrayChar[i] == c)
                letters[i] = c;
        }

            int count = 0;
            for(int i = 0; i<arrayChar.length;i++){
                if(letters[i] == arrayChar[i])
                         {   count++;
                         if(count == arrayChar.length){
                                 answer = JOptionPane.showOptionDialog(this,
                                     "You only got " + West_panel_Stuff.guessesNUmberL.getText() + " Guesses wrong but ou save the man!\n" + "Think you can do it again?",
                                     "Try it Again!!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                                     winnerIcon, null, null);
                             if (answer == JOptionPane.YES_OPTION) {
                             Hangman_panel.hangman_panel.removeAll();
                             Hangman_panel.hangman_panel = new Hangman_panel();
                             check_it.wrongchoice = 0;
                             West_panel_Stuff.guessesNUmberL.setText("" + check_it.wrongchoice);

                             Hangman_panel.hangman_panel.checkstring.chooseWord(check_it.wordsArray2);
                             West_panel_Stuff.wordBankL.setText("");
                             Hangman_panel.hangman_panel.repaint();
                             Hangman_panel.hangman_panel.updateUI();
                             }
                             else { System.exit(0); }
                                  }
                         }

                 }
    }



    public ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

}