/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTS2;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

/**
 *
 * @author Bukhari_Inst
 */
public class musicStuff {

    void playMusic(String musicLocation){
        
        try{
            File musicPath = new File(musicLocation);
            
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                
                JOptionPane.showMessageDialog(null, "Klik ok untuk pause");
                long clipTimePosition = clip.getMicrosecondPosition();
                clip.stop();
                
                JOptionPane.showMessageDialog(null, "Klik ok untuk resume");
                clip.setMicrosecondPosition(clipTimePosition);
                clip.start();
                
                JOptionPane.showMessageDialog(null, "Klik OK untuk stop");
            }else{
                System.out.println("Can't find file");
            }
            
        }catch(HeadlessException | IOException | LineUnavailableException | UnsupportedAudioFileException ex){
        }
    }
}