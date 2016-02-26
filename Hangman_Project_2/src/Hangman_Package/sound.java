package Hangman_Package;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import sun.audio.*;


public class sound {

             public void track(){
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
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }

}
