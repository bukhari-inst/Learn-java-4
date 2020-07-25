/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan10_11_12_13_14;

import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Bukhari_Inst
 */
public class Update {

    koneksiDatabase konek = new koneksiDatabase();

    public void update(int nim, String nama, String alamat, String jk) {
        try {
            konek.koneksi();
            Statement statement = konek.con.createStatement();
            String sql_nim = "update identitas set nama = '" + nim + "' where nama = '" + nama + "'";
            String sql_nama = "update identitas set nama = '" + nama + "' where nim = '" + nim + "'";
            String sql_alamat = "update identitas set alamat = '" + alamat + "' where nim = '" + nim + "'";
            String sql_jk = "update identitas set jeniskelamin = '" + jk + "' where nim = '" + nim + "'";
            statement.executeUpdate(sql_nim);
            statement.executeUpdate(sql_nama);
            statement.executeUpdate(sql_alamat);
            statement.executeUpdate(sql_jk);
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Diupdate");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
