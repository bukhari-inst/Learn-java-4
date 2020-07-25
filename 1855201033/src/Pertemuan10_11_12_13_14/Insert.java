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
public class Insert {

    koneksiDatabase konek = new koneksiDatabase();

    public void insert(int nim, String nama, String alamat, String jk) {
        try {
            
            konek.koneksi();
            Statement statement = konek.con.createStatement();
            // dengan menyebutkan nama kolom
//            String sql = "insert into identitas (nim, nama, alamat, jeniskelamin)" + "values('" + nim + "','" + nama + "','" + alamat + "','" + jk + "');";
            // tnpa menyebutkan nama kolom
            String sql = "insert into identitas values('" + nim + "','" + nama + "','" + alamat + "','" + jk + "');";
            statement.executeUpdate(sql);
            statement.close();

// kemudian data yang disisipkan akan saya tampilkan lewat textArea 
//            menampilkan.setText(mah_nim.getText() + "\n" + mah_nama.getText() + "\n" + mah_alamat.getText() + "\n" + mah_fak_id.getText() + "\n" + jenis);
            JOptionPane.showMessageDialog(null, "Berhasil Disimpan");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
