/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author Bukhori
 */
public class TxtToDocToTxt1 extends javax.swing.JFrame {

    /**
     * Creates new form TxtToDocToTxt
     */
    public TxtToDocToTxt1() {
        initComponents();
        this.setLocationRelativeTo(this);
        pathfileconvert.setEnabled(false);
        pathfileopen.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tombolrefresh = new javax.swing.JButton();
        tombolopenfile = new javax.swing.JButton();
        tombolexit = new javax.swing.JButton();
        tombolconvert = new javax.swing.JButton();
        pathfileconvert = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pathfileopen = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(34, 49, 63));

        jPanel2.setBackground(new java.awt.Color(249, 105, 14));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pertemuan6/icons8-refresh-document-100 (1).png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("APLIKASI CONVERT TXT TO DOC");

        jLabel3.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DOC TO TXT");

        jLabel6.setFont(new java.awt.Font("Trajan Pro", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Bukhori_Inst");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(9, 9, 9))
        );

        tombolrefresh.setBackground(new java.awt.Color(77, 19, 209));
        tombolrefresh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tombolrefresh.setForeground(new java.awt.Color(255, 255, 255));
        tombolrefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pertemuan6/icons8-refresh-35.png"))); // NOI18N
        tombolrefresh.setText("Refresh");
        tombolrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolrefreshActionPerformed(evt);
            }
        });

        tombolopenfile.setBackground(new java.awt.Color(77, 19, 209));
        tombolopenfile.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tombolopenfile.setForeground(new java.awt.Color(255, 255, 255));
        tombolopenfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pertemuan6/icons8-documents-folder-35.png"))); // NOI18N
        tombolopenfile.setText("Open File");
        tombolopenfile.setToolTipText("");
        tombolopenfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolopenfileActionPerformed(evt);
            }
        });

        tombolexit.setBackground(new java.awt.Color(77, 19, 209));
        tombolexit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tombolexit.setForeground(new java.awt.Color(255, 255, 255));
        tombolexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pertemuan6/icons8-back-34.png"))); // NOI18N
        tombolexit.setText("Exit");
        tombolexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolexitActionPerformed(evt);
            }
        });

        tombolconvert.setBackground(new java.awt.Color(77, 19, 209));
        tombolconvert.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tombolconvert.setForeground(new java.awt.Color(255, 255, 255));
        tombolconvert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pertemuan6/icons8-export-35.png"))); // NOI18N
        tombolconvert.setText("Convert");
        tombolconvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolconvertActionPerformed(evt);
            }
        });

        pathfileconvert.setBackground(new java.awt.Color(255, 255, 255));
        pathfileconvert.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pathfileconvert.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("File Convert:");

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("File Open:");

        pathfileopen.setBackground(new java.awt.Color(255, 255, 255));
        pathfileopen.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pathfileopen.setForeground(new java.awt.Color(0, 0, 0));
        pathfileopen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathfileopenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tombolexit)
                        .addGap(18, 18, 18)
                        .addComponent(tombolrefresh)
                        .addGap(18, 18, 18)
                        .addComponent(tombolconvert)
                        .addGap(18, 18, 18)
                        .addComponent(tombolopenfile))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pathfileopen, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pathfileconvert, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathfileopen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathfileconvert, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolrefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolexit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolopenfile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolconvert, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private static String MembacaDocOrTxtFile() {
        String FilePath = "D:\\thetextfile.doc";
        FileInputStream fis;
        String outPut = null;

        if (FilePath.substring(FilePath.length() - 1).equals("x")) { // is a
            //jika file doc
            try {
                fis = new FileInputStream(new java.io.File(FilePath));
                XWPFDocument doc = new XWPFDocument();
                XWPFWordExtractor extract = new XWPFWordExtractor(doc);
                // System.out.println(extract.getText());
                outPut = extract.getText();
                return outPut;
            } catch (IOException e) {
            }
        } else { // jika file brupa txt
            BufferedReader br = null;
            String content = null;
            try {
                br = new BufferedReader(new FileReader(FilePath));
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    line = br.readLine();
                    sb.append(System.lineSeparator());
                }
                content = sb.toString();
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
            return content;
        }
        return null;
    }

    public static void MencetakToTxtOrdocfile(String str) {
        String FilePath = "thetextfile.doc";
        String FilePath2 = "thetextfile.doc";

        try {

            if (FilePath == FilePath2) {
                java.io.File newTextFile1 = new java.io.File("D://thetextfile.txt");
                try (FileWriter fw1 = new FileWriter(newTextFile1)) {
                    fw1.write(str);

                }
            } else {
                java.io.File newTextFile2 = new java.io.File("D://thetextfile.doc");
                try (FileWriter fw2 = new FileWriter(newTextFile2)) {
                    fw2.write(str);
                }
            }

        } catch (IOException iox) {
            // do stuff with exception

        }
    }

    private void tombolrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolrefreshActionPerformed
        // TODO add your handling code here:
        pathfileopen.setText("");
        pathfileconvert.setText("");
    }//GEN-LAST:event_tombolrefreshActionPerformed

    private void tombolopenfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolopenfileActionPerformed
        // TODO add your handling code here:

        JFileChooser chooser = new JFileChooser("");
        java.io.File filenya;

        int buka_dialog = chooser.showOpenDialog(TxtToDocToTxt1.this);
        if (buka_dialog == JFileChooser.APPROVE_OPTION) {
            filenya = chooser.getSelectedFile();
            pathfileopen.setText(filenya.getPath());

            // Read File
            String filename = filenya.getPath(); //path
            MembacaDocOrTxtFile();
        }
    }//GEN-LAST:event_tombolopenfileActionPerformed

    private void tombolexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolexitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_tombolexitActionPerformed

    private void tombolconvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolconvertActionPerformed
        // TODO add your handling code here:

        System.out.println(MembacaDocOrTxtFile());
        MencetakToTxtOrdocfile(MembacaDocOrTxtFile());
        pathfileconvert.setText("D://thetextfile.txt");
    }//GEN-LAST:event_tombolconvertActionPerformed

    private void pathfileopenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathfileopenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pathfileopenActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TxtToDocToTxt1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TxtToDocToTxt1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TxtToDocToTxt1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TxtToDocToTxt1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TxtToDocToTxt1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField pathfileconvert;
    private javax.swing.JTextField pathfileopen;
    private javax.swing.JButton tombolconvert;
    private javax.swing.JButton tombolexit;
    private javax.swing.JButton tombolopenfile;
    private javax.swing.JButton tombolrefresh;
    // End of variables declaration//GEN-END:variables
}
