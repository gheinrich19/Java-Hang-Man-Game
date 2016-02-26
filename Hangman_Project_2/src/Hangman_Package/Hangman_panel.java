package Hangman_Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by gage heinrich on 4/13/14.
 */
public class Hangman_panel extends JPanel{

    private char myLetter = ' ';
    private char [] tempChar;
    private int count;

    public Image grimImage;
    public ImageIcon grim_reaper;

    // here is an istance of the check_it class
    public static check_it checkstring;
    public static Hangman_panel hangman_panel;
    public static char userInputChar;
    public Hangman_panel(){
        checkstring = new check_it();

        // now choosing the word to try and guess!!
        checkstring.chooseWord(check_it.wordsArray2);

        grim_reaper = createImageIcon("grim_reaper.png");
        grimImage = grim_reaper.getImage();

        this.setBackground(Color.gray);
        this.setSize(500, 100);
        this.setVisible(true);
        this.setFocusable(true);


      addKeyListener(new KeyAdapter() {
          public void keyTyped(KeyEvent e) {

              userInputChar = e.getKeyChar();

              checkstring.checkWord(userInputChar);

              if (e.getKeyChar() <= ' ' || e.getKeyChar() > 'z')
               return;
              myLetter = e.getKeyChar();
              for(int i = 0; i < checkstring.letters.length; i++){
              System.out.println("" + checkstring.letters[i]);
              }

              check_it.guessedletters[count] = userInputChar;
              count++;
              repaint();

                String fun;
              fun =  West_panel_Stuff.wordBankL.getText();

              West_panel_Stuff.wordBankL.setText( fun + " " +userInputChar);

          }
      });
    }

        public void paint(Graphics g){
            super.paint(g);

            // lets draw the gallows!!
            g.setColor(The_Game.mYcolor);
            g.drawRect(30, 30, 25, 350);
            g.drawRect(30, 30, 200, 25);
            g.setColor(Color.darkGray);
            g.fillRect( 31, 31, 24, 349 );
            g.fillRect(31, 31, 199, 24);
            g.setColor(The_Game.mYcolor);
            tempChar = new char[1];
            tempChar[0] = myLetter;

        g.setColor(The_Game.mYcolor);
        g.setFont(new Font("Dialog", Font.BOLD, 64));
        g.drawChars(tempChar, 0, 1, 400, 100);
        g.drawChars(checkstring.letters,0,checkstring.arrayChar.length,60,430);


            g.setColor(The_Game.mYcolor);
            // draw the head!!
            if(check_it.wrongchoice == 1){
                g.drawOval(200,95,55,55);
            }

            if(check_it.wrongchoice == 2 ){
                g.drawOval(200,95,55,55);
                g.drawLine(228,150,228,265);
            }

            if(check_it.wrongchoice == 3 ){
                g.drawOval(200,95,55,55);
                g.drawLine(228,150,228,265);
                g.drawLine(228,190,175,220);
            }
            if(check_it.wrongchoice == 4 ){
                g.drawOval(200,95,55,55);
                g.drawLine(228,150,228,265);
                g.drawLine(228,190,175,220);
                g.drawLine(228,190,281,220);
            }
            if(check_it.wrongchoice == 5 ){
                g.drawOval(200,95,55,55);
                g.drawLine(228,150,228,265);
                g.drawLine(228,190,175,220);
                g.drawLine(228,190,281,220);
                g.drawLine(228,265,175,320);
            }
            if(check_it.wrongchoice == 6 ){
                g.drawOval(200,95,55,55);
                g.drawLine(228,150,228,265);
                g.drawLine(228,190,175,220);
                g.drawLine(228,190,281,220);
                g.drawLine(228,265,175,320);
                g.drawLine(228,265,275,320);
            }
            if(check_it.wrongchoice == 7 ){
                g.drawOval(200,95,55,55);
                g.drawLine(228,150,228,265);
                g.drawLine(228,190,175,220);
                g.drawLine(228,190,281,220);
                g.drawLine(228,265,175,320);
                g.drawLine(228,265,275,320);
                g.drawLine(210,115,214,120);
                g.drawLine(210,120,214,115);
            }

            if(check_it.wrongchoice == 8 ){
                g.drawOval(200,95,55,55);
                g.drawLine(228,150,228,265);
                g.drawLine(228,190,175,220);
                g.drawLine(228,190,281,220);
                g.drawLine(228,265,175,320);
                g.drawLine(228,265,275,320);
                g.drawLine(210,115,214,120);
                g.drawLine(210,120,214,115);
                g.drawLine(235,115,240,120);
            }

            if(check_it.wrongchoice == 9 ){
                g.drawOval(200,95,55,55);
                g.drawLine(228,150,228,265);
                g.drawLine(228,190,175,220);
                g.drawLine(228,190,281,220);
                g.drawLine(228,265,175,320);
                g.drawLine(228,265,275,320);
                g.drawLine(210,115,214,120);
                g.drawLine(210,120,214,115);
                g.drawLine(235,115,240,120);
                g.drawLine(235,120,240,115);
            }
            if(check_it.wrongchoice == 10 ){
                g.drawOval(200,95,55,55);
                g.drawLine(228,150,228,265);
                g.drawLine(228,190,175,220);
                g.drawLine(228,190,281,220);
                g.drawLine(228,265,175,320);
                g.drawLine(228,265,275,320);
                g.drawLine(210,115,214,120);
                g.drawLine(210,120,214,115);
                g.drawLine(235,115,240,120);
                g.drawLine(235,120,240,115);
                g.drawLine(220,135,235,135);
            }

            if(check_it.wrongchoice == 11){
               g.drawImage(grimImage,0,0,700,500,null);
                g.setColor(The_Game.mYcolor);
                char[] message = {'y','o','u',' ','l','o','o','s','e'};

                g.drawChars(message,0,message.length,160,400);
                g.drawChars(check_it.arrayChar, 0,check_it.arrayChar.length,160,450);
            }
        repaint();
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

