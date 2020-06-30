/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


/**
 *
 * @author Bukhari_Inst
 */
public class MP3Player {
    public static void main(String[] args) throws JavaLayerException {
        try {
			FileInputStream fileInputStream = new FileInputStream("lathi.mp3");
			Player player = new Player(fileInputStream);
			System.out.println("Song is playing...");
			player.play();
                        
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
}
