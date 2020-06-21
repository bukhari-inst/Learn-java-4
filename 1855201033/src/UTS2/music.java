/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTS2;

/**
 *
 * @author Bukhari_Inst
 */
public class music {

    public static void main(String[] args) {
        String filepath = "lathi.wav";
//        String filepath2 = "lathi.wav";
//
//        if(filepath == filepath2){
        musicStuff musicObject = new musicStuff();
        musicObject.playMusic(filepath);

//        }else{
//        try {
//            FileInputStream fileInputStream = new FileInputStream(filepath);
//            Player player = new Player(fileInputStream);
//            System.out.println("Song is playing...");
//            player.play();
//        } catch (FileNotFoundException e) {
//        }
//        }
    }
}
