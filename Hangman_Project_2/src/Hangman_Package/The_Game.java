package Hangman_Package;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by gage heinrich on 4/13/14.
 */
public class The_Game extends JFrame implements  ActionListener {

    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private Rest_Game rest_game;


    public static Hangman_panel hangman_panel;
    public static West_panel_Stuff west_panel_stuff;
    private JMenuBar selectionBar;
    private JMenu gameMenu,changeDifficultyM;
    private JMenuItem changeWordMI, ExitMI;
    private JCheckBoxMenuItem textChangeBox, musicMIcheckbox;
    private ImageIcon fontIcon;
    public static JMenuItem easyMI,HardMI;
    public static JButton resetButton;
    public static JRadioButton colorBLueRB, colorRedRB;
    public static ButtonGroup buttongroup;
    public static JPanel northPanel;
    public static Color mYcolor;
    public static Font myfont;

    public The_Game()  {

      super(" Hangman!!! Try to guess the word without killing him!!");

      setLayout(new BorderLayout());  // using a border layout.

        //make my font
        myfont = new Font("Serif", Font.BOLD, 12);

        /** This is the panel that will contain the drawing of the hangman with interfaces in another class**/
      hangman_panel = new Hangman_panel();
      west_panel_stuff = new West_panel_Stuff();

        selectionBar = new JMenuBar();
        gameMenu = new JMenu("Game");
        selectionBar.add(gameMenu);

        buttongroup = new ButtonGroup();

        colorBLueRB = new JRadioButton("blue");
        colorBLueRB.setFocusable(false);


        colorRedRB= new JRadioButton("Red");
        colorRedRB.setFocusable(false);

        buttongroup.add(colorBLueRB);
        buttongroup.add(colorRedRB);

        //choose mycolor
        mYcolor = Color.ORANGE;

        // make the reset button

        resetButton = new JButton("Reset");
        resetButton.setFocusable(false);
        resetButton.setBackground(Color.gray);
        resetButton.setForeground(Color.cyan);
        resetButton.addActionListener(this);

        // music checkbox
        musicMIcheckbox = new JCheckBoxMenuItem("Music");
        musicMIcheckbox.setFocusable(false);
        musicMIcheckbox.addActionListener(this);
        // creating font icon and gallows image!

        fontIcon = createImageIcon("font_icon.png");

        // Creating the checkbox to change the fonts!!!!
        textChangeBox = new JCheckBoxMenuItem();
        textChangeBox.setIcon(fontIcon);

        // lets create the Menu Items
        ExitMI = new JMenuItem("Exit");
        ExitMI.addActionListener(this);
        changeWordMI = new JMenuItem("Change word");
        changeDifficultyM = new JMenu("Difficulty");

        // create easy and hard menu items

        easyMI = new JMenuItem("Easy");
        easyMI.addActionListener(this);

        HardMI = new JMenuItem("Hard");
        HardMI.addActionListener(this);

        // add easymi to changedifficulty menu
        changeDifficultyM.add(easyMI);
        changeDifficultyM.add(HardMI);

        // sound

        // lets make the east panel

        northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());
        northPanel.setVisible(true);
        northPanel.setSize(50,100);
        northPanel.setBackground(Color.blue);

        // add the menus' and menu items.
        gameMenu.add(changeDifficultyM);
        gameMenu.add(changeWordMI);
        gameMenu.add(ExitMI);
        gameMenu.add(textChangeBox);

        // adding the menu to the selection bar
        selectionBar.add(gameMenu);
       // selectionBar.add(musicMIcheckbox);

        selectionBar.setSize(100,20);
        //selectionBar.add(resetButton);
        //selectionBar.add(colorRedRB);
        //selectionBar.add(colorBLueRB);

        northPanel.add(selectionBar);
        northPanel.add(musicMIcheckbox);
        northPanel.add(colorBLueRB);
        northPanel.add(colorRedRB);
        northPanel.add(resetButton);

        // Lets configure where the panels will go on the JFrame


        add(hangman_panel, BorderLayout.CENTER);
       add(west_panel_stuff,BorderLayout.WEST);
        add(northPanel,BorderLayout.NORTH);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setVisible(true);


    }
    public void resetGame(){
        hangman_panel.removeAll();
        hangman_panel = new Hangman_panel();
        check_it.wrongchoice = 0;
        West_panel_Stuff.guessesNUmberL.setText("" + check_it.wrongchoice);
        hangman_panel.checkstring.chooseWord(check_it.wordsArray1);
        hangman_panel.updateUI();
        hangman_panel.repaint();

    }


    public void actionPerformed (ActionEvent e){


        if(e.getSource() == The_Game.easyMI){
            hangman_panel.removeAll();
            hangman_panel = new Hangman_panel();
            check_it.wrongchoice = 0;
            West_panel_Stuff.guessesNUmberL.setText("" + check_it.wrongchoice);

            hangman_panel.checkstring.chooseWord(check_it.wordsArray1);
            West_panel_Stuff.wordBankL.setText("");
            hangman_panel.repaint();
            hangman_panel.updateUI();

        }
        if(e.getSource() == The_Game.HardMI){
            hangman_panel.removeAll();
            hangman_panel = new Hangman_panel();
            check_it.wrongchoice = 0;
            West_panel_Stuff.guessesNUmberL.setText("" + check_it.wrongchoice);

            hangman_panel.checkstring.chooseWord(check_it.wordsArray2);
            West_panel_Stuff.wordBankL.setText("");
             hangman_panel.repaint();
            hangman_panel.updateUI();

        }

        if(check_it.answer == JOptionPane.YES_OPTION)
        {
            hangman_panel.removeAll();
            hangman_panel = new Hangman_panel();
            check_it.wrongchoice = 0;
            West_panel_Stuff.guessesNUmberL.setText("" + check_it.wrongchoice);

            hangman_panel.checkstring.chooseWord(check_it.wordsArray1);
            West_panel_Stuff.wordBankL.setText("");
            hangman_panel.repaint();
            hangman_panel.updateUI();
        }
        if (e.getSource() == ExitMI)
            System.exit(0);

        if(e.getSource() == musicMIcheckbox)

            if(musicMIcheckbox.isSelected())
             System.out.println("you selected the box");

        if (e.getSource() == resetButton) resetGame();


        if(colorRedRB.isSelected()){
            colorRedRB.setSelected(true);
            colorBLueRB.setSelected(false);
            mYcolor = Color.RED;
            hangman_panel.updateUI();
            hangman_panel.repaint();
        }


        if(colorBLueRB.isSelected()){
            colorBLueRB.setSelected(true);
            colorRedRB.setSelected(false);
            mYcolor = Color.BLUE;
            hangman_panel.repaint();
            hangman_panel.updateUI();}

        if(musicMIcheckbox.isSelected()){
            JFileChooser openf =new JFileChooser();
            openf.showOpenDialog(null);
            File fl= openf.getSelectedFile();
            String sound = fl.getAbsolutePath();
            JOptionPane.showMessageDialog(null, sound);
            InputStream in;
            try{
                in = new FileInputStream(sound);
                AudioStream audio = new AudioStream(in);
                AudioPlayer.player.start(audio);
            }catch(Exception a){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }


        hangman_panel.repaint();
        hangman_panel.getTopLevelAncestor().requestFocus();
    }


    // image icon to create with string perameter

    public ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        new The_Game();
        while (!hangman_panel.hasFocus())
            hangman_panel.requestFocusInWindow();
    }
}