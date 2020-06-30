/*
 *       _____ _____ _____                _       _
 *      |_   _/  __ \_   _|              (_)     | |
 *        | | | /  \/ | |  ___  ___   ___ _  __ _| |
 *        | | ||      | | / __|/ _ \ / __| |/ _` | |
 *       _| |_| \__/\ | |_\__ \ (_) | (__| | (_| | |
 *      |_____\_____/ |_(_)___/\___/ \___|_|\__,_|_|
 *                   ___
 *                  |  _|___ ___ ___
 *                  |  _|  _| -_| -_|  LICENSE
 *                  |_| |_| |___|___|
 *
 * IT NEWS  <>  PROGRAMMING  <>  HW & SW  <>  COMMUNITY
 *
 * This source code is a part of online courses at IT social
 * network WWW.ICT.SOCIAL
 *
 * Feel free to use it for whatever you want, modify it and share it but
 * don't forget to keep this link in your code.
 *
 * Visit http://www.ict.social/licenses for more information
 */
package music4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJFrame extends JFrame {

    public JButton Play, choose, stop;
    private String file;
    public static MyJFrame instance;

    public MyJFrame() {
        this.setSize(400, 400);
        this.setTitle("Wave audio player");
        this.setComponents();
        this.setListeners();
    }

    public void setComponents() {
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout());
        pane.setBackground(Color.PINK);
        this.choose = new JButton("choose");
        this.Play = new JButton("play");
        this.stop = new JButton("stop");
        pane.add(choose);
        pane.add(Play);
        pane.add(stop);
    }

    public void setListeners() {
        this.choose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileDialog fd = new FileDialog(instance);
                fd.setMode(FileDialog.LOAD);
                fd.setVisible(true);
                String soubor = fd.getDirectory() + fd.getFile();
                if (soubor != null) {
                    file = soubor;
                }
            }
        });

        this.Play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Music m = new Music(file);
            }
        });
        
         this.stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Music m = new Music(file);
                
            }
        });
    }

    public static Frame setup() {
        MyJFrame window = new MyJFrame();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        return window;
    }

    public static void main(String args[]) {
        MyJFrame.setup();
    }
}
