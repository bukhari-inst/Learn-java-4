/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager; 
import javax.swing.JOptionPane;


/**
 *
 * @author Bukhari_Inst
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Test test = new Test();
        test.koneksi();
    }
    Connection con=null;
    private void koneksi()
    {
        try
        {
            String connectionURL = "jdbc:mysql://localhost/test";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(connectionURL, username, password);
            JOptionPane.showMessageDialog(null,"Sukses Koneksi");
        }

        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null, e);
        System.exit(0);
        }
    }
}

