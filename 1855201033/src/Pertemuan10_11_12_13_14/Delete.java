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
public class Delete {
    koneksiDatabase konek = new koneksiDatabase();
    public void delete(int nim) {
        try {
            konek.koneksi();
            Statement statement = konek.con.createStatement();
            String sql = "delete from identitas where nim = '" + nim + "'";
            statement.executeUpdate(sql);
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
