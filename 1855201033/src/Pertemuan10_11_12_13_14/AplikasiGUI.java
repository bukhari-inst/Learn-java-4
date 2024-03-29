/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan10_11_12_13_14;

import javax.swing.ButtonGroup;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Bukhari_Inst
 */
public class AplikasiGUI extends javax.swing.JFrame {

    /**
     * Creates new form koneksiGUI
     */
    public AplikasiGUI() {
        initComponents();
        this.setTitle("Aplikasi Data Mahasiswa");
        this.setLocationRelativeTo(this);

        koneksiDatabase konek = new koneksiDatabase();
        konek.koneksi();
        statusKoneksi.setText(konek.statusKoneksi);

        // button group
        ButtonGroup bG = new ButtonGroup();
        bG.add(in_lakilaki);
        bG.add(in_perempuan);

        // panggil method table
        table();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        in_nim = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        in_nama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        in_alamat = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        in_lakilaki = new javax.swing.JRadioButton();
        in_perempuan = new javax.swing.JRadioButton();
        tombolInsert = new javax.swing.JButton();
        TomboDelete = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pilihPencarian = new javax.swing.JComboBox<>();
        tombolReset = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelIdentitas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        statusKoneksi = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("DATA MAHASISWA ILKOM UNU BLITAR");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Data Mahasiswa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel3.setText("NIM");

        jLabel4.setText("Nama");

        in_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in_namaActionPerformed(evt);
            }
        });

        jLabel5.setText("Alamat");

        in_alamat.setColumns(20);
        in_alamat.setRows(5);
        jScrollPane1.setViewportView(in_alamat);

        jLabel6.setText("Jenis Kelamin");

        in_lakilaki.setText("Laki-laki");
        in_lakilaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in_lakilakiActionPerformed(evt);
            }
        });

        in_perempuan.setText("Perempuan");
        in_perempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in_perempuanActionPerformed(evt);
            }
        });

        tombolInsert.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tombolInsert.setText("INSERT");
        tombolInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolInsertActionPerformed(evt);
            }
        });

        TomboDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TomboDelete.setText("DELETE");
        TomboDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TomboDeleteActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("CARI");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        pilihPencarian.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pilihPencarian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Pencarian", "NIM", "Nama", "Alamat", "Jenis Kelamin" }));
        pilihPencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihPencarianActionPerformed(evt);
            }
        });

        tombolReset.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tombolReset.setText("RESET");
        tombolReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolResetActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(in_lakilaki)
                                .addGap(18, 18, 18)
                                .addComponent(in_perempuan))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                    .addComponent(in_nama)
                                    .addComponent(in_nim))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(pilihPencarian, 0, 147, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(TomboDelete)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tombolInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tombolReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(in_nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(in_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tombolReset)
                        .addGap(26, 26, 26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(in_lakilaki)
                        .addComponent(in_perempuan)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolInsert)
                    .addComponent(TomboDelete)
                    .addComponent(jButton2)
                    .addComponent(pilihPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Output Data Mahasiswa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tabelIdentitas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabelIdentitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIM", "Nama", "Alamat", "Jenias Kelamin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelIdentitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelIdentitasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelIdentitas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Status Koneksi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(statusKoneksi, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(statusKoneksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Statement pst;
    ResultSet rs;

    public void table() {
        koneksiDatabase konek = new koneksiDatabase();
        konek.koneksi();
        try {
            String sql = "select * from identitas";
            pst = konek.con.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            tabelIdentitas.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void selectByNim(int nim) {
        koneksiDatabase konek = new koneksiDatabase();
        konek.koneksi();

        try {
            String sql = "select * from identitas where nim like '%" + nim + "%'";
            pst = konek.con.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            tabelIdentitas.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void selectByNama(String nama) {
        koneksiDatabase konek = new koneksiDatabase();
        konek.koneksi();

        try {
            String sql = "select * from identitas where nama like '%" + nama + "%'";
            pst = konek.con.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            tabelIdentitas.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void selectByAlamat(String alamat) {
        koneksiDatabase konek = new koneksiDatabase();
        konek.koneksi();

        try {
            String sql = "select * from identitas where alamat like '%" + alamat + "%'";
            pst = konek.con.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            tabelIdentitas.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void selectByJK(String jenis) {
        koneksiDatabase konek = new koneksiDatabase();
        konek.koneksi();

        try {
            String sql = "select * from identitas where jeniskelamin like '%" + jenis + "%'";
            pst = konek.con.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            tabelIdentitas.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void in_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_in_namaActionPerformed

    private void in_perempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in_perempuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_in_perempuanActionPerformed

    private void tombolInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolInsertActionPerformed

        String jenis = "";
        if (in_lakilaki.isSelected()) {
            jenis = "L";
        } else if (in_perempuan.isSelected()) {
            jenis = "P";
        }

        // memanggil class Insert
        Insert in = new Insert();
        int nim = Integer.parseInt(in_nim.getText());
        String nama = in_nama.getText();
        String alamat = in_alamat.getText();

        in.insert(nim, nama, alamat, jenis);

        // tampil pada tabel
        table();
    }//GEN-LAST:event_tombolInsertActionPerformed

    private void in_lakilakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in_lakilakiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_in_lakilakiActionPerformed

    private void pilihPencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihPencarianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pilihPencarianActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (pilihPencarian.getSelectedIndex() == 1) {
            selectByNim(Integer.parseInt(in_nim.getText()));
        } else if (pilihPencarian.getSelectedIndex() == 2) {
            selectByNama(in_nama.getText());
        } else if (pilihPencarian.getSelectedIndex() == 3) {
            selectByAlamat(in_alamat.getText());
        } else if (pilihPencarian.getSelectedIndex() == 4) {
            String jenis = "";
            if (in_lakilaki.isSelected()) {
                jenis = "L";
            } else if (in_perempuan.isSelected()) {
                jenis = "P";
            }
            selectByJK(jenis);
        } else {
            in_nim.setText("");
            in_nama.setText("");
            in_alamat.setText("");
            table();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabelIdentitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelIdentitasMouseClicked
        try {
            DefaultTableModel dtm = (DefaultTableModel) tabelIdentitas.getModel(); //create a model
            int selectedRowIndex = tabelIdentitas.getSelectedRow(); //get selected row
            int id = (int) dtm.getValueAt(selectedRowIndex, 0); //get the primary key to fetch data.

            koneksiDatabase konek = new koneksiDatabase();
            konek.koneksi();

            String sql = "select * from identitas where nim like '%" + id + "%'";
            pst = konek.con.prepareStatement(sql);
            rs = pst.executeQuery(sql); //dont worry about dbcon.getdata, its my class to get data.
            while (rs.next()) {    //u can use normal query
                in_nim.setText(rs.getString("nim"));
                in_nama.setText(rs.getString("nama"));
                in_alamat.setText(rs.getString("alamat"));
                String jenis = rs.getString("jeniskelamin");
                if (jenis.equals("L")) {
                    in_lakilaki.setSelected(true);
                } else {
                    in_perempuan.setSelected(true);
                }
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AplikasiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabelIdentitasMouseClicked

    private void TomboDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TomboDeleteActionPerformed
        koneksiDatabase konek = new koneksiDatabase();
        konek.koneksi();
        Delete del = new Delete();
        del.delete(Integer.parseInt(in_nim.getText()));
        table();
    }//GEN-LAST:event_TomboDeleteActionPerformed

    private void tombolResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolResetActionPerformed
        in_nim.setText("");
        in_nama.setText("");
        in_alamat.setText("");
        ButtonGroup bG = new ButtonGroup();
        bG.add(in_lakilaki);
        bG.add(in_perempuan);
        bG.clearSelection();
    }//GEN-LAST:event_tombolResetActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        koneksiDatabase konek = new koneksiDatabase();
        konek.koneksi();
        Update up = new Update();
        String nama = in_nama.getText();
        String alamat = in_alamat.getText();
        String jenis = "";
        if (in_lakilaki.isSelected()) {
            jenis = "L";
        } else if (in_perempuan.isSelected()) {
            jenis = "P";
        }
        up.update(Integer.parseInt(in_nim.getText()), nama, alamat, jenis);
        table();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AplikasiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplikasiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplikasiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplikasiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikasiGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TomboDelete;
    private javax.swing.JTextArea in_alamat;
    private javax.swing.JRadioButton in_lakilaki;
    private javax.swing.JTextField in_nama;
    private javax.swing.JTextField in_nim;
    private javax.swing.JRadioButton in_perempuan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> pilihPencarian;
    private javax.swing.JTextField statusKoneksi;
    private javax.swing.JTable tabelIdentitas;
    private javax.swing.JButton tombolInsert;
    private javax.swing.JButton tombolReset;
    // End of variables declaration//GEN-END:variables
}
