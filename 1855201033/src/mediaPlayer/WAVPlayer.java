/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaPlayer;

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
public class WAVPlayer {
     private static Clip musik;

    public void mainMusik(String source) {
//        URL url = this.getClass().getResource(source);
//        musik = (Clip) Applet.newAudioClip(url);
//        musik.start();

        try {
            File musicPath = new File(source);
            if (musicPath.exists()) {
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
            } else {
                System.out.println("Can't find file");
            }
        } catch (HeadlessException | IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
        }
    }

    public void stopmusik(String source) {
//        URL url = this.getClass().getResource(source);
//        musik = (Clip) Applet.newAudioClip(url);
        musik.stop();
    }

    public static void main(String[] args) {
        WAVPlayer musik = new WAVPlayer();
        musik.mainMusik("lathi1.wav");
    }
}
