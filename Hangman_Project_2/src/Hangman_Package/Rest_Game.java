package Hangman_Package;


public class Rest_Game {

    Hangman_panel hangman_panel;
    public void resetGame(){
        hangman_panel.removeAll();
        hangman_panel = new Hangman_panel();
        check_it.wrongchoice = 0;
        West_panel_Stuff.guessesNUmberL.setText("" + check_it.wrongchoice);

        hangman_panel.checkstring.chooseWord(check_it.wordsArray1);
        West_panel_Stuff.wordBankL.setText("");
        hangman_panel.repaint();
        hangman_panel.updateUI();
        hangman_panel.repaint();
        hangman_panel.getTopLevelAncestor().requestFocus();
    }
}
