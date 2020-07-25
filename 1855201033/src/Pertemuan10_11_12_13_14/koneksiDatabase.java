/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan10_11_12_13_14;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Bukhari_Inst
 */
public class koneksiDatabase {

    public static void main(String[] args) {
        koneksiDatabase test = new koneksiDatabase();
        test.koneksi();
    }

    Connection con = null;
    String statusKoneksi;

    public void koneksi() {
        try {
            String connectionURL = "jdbc:mysql://localhost/mahasiswa";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(connectionURL, username, password);
//            JOptionPane.showMessageDialog(null,"Sukses Koneksi");
            statusKoneksi = "Koneksi Berhasil";
        } catch (Exception e) {
            statusKoneksi = "Koneksi Gagal";
//            JOptionPane.showMessageDialog(null, e);
//            System.exit(0);
        }
    }
}
