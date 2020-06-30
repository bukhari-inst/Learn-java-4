/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author Bukhori
 */
public class konverter extends javax.swing.JFrame {

    /**
     * Creates new form TxtToDocToTxt
     */
    public konverter() {
        initComponents();
        this.setTitle("Konverter Apps");
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
        jLabel6 = new javax.swing.JLabel();
        tombolrefresh = new javax.swing.JButton();
        tombolexit = new javax.swing.JButton();
        tombolconvertDoc = new javax.swing.JButton();
        pathfileconvert = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pathfileopen = new javax.swing.JTextField();
        tombolconvertDocx = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(34, 49, 63));

        jPanel2.setBackground(new java.awt.Color(249, 105, 14));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pertemuan6/icons8-refresh-document-100 (1).png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Convert Txt To Doc-Docx");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Bukhori_Inst");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(112, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(86, 86, 86))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel6)))
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

        tombolexit.setBackground(new java.awt.Color(77, 19, 209));
        tombolexit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tombolexit.setForeground(new java.awt.Color(255, 255, 255));
        tombolexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pertemuan6/icons8-back-34.png"))); // NOI18N
        tombolexit.setText("Back");
        tombolexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolexitActionPerformed(evt);
            }
        });

        tombolconvertDoc.setBackground(new java.awt.Color(77, 19, 209));
        tombolconvertDoc.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tombolconvertDoc.setForeground(new java.awt.Color(255, 255, 255));
        tombolconvertDoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pertemuan6/icons8-export-35.png"))); // NOI18N
        tombolconvertDoc.setText("Convert To Doc");
        tombolconvertDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolconvertDocActionPerformed(evt);
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

        tombolconvertDocx.setBackground(new java.awt.Color(77, 19, 209));
        tombolconvertDocx.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tombolconvertDocx.setForeground(new java.awt.Color(255, 255, 255));
        tombolconvertDocx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pertemuan6/icons8-export-35.png"))); // NOI18N
        tombolconvertDocx.setText("Convert To Docx");
        tombolconvertDocx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolconvertDocxActionPerformed(evt);
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tombolexit)
                                .addGap(18, 18, 18)
                                .addComponent(tombolconvertDoc)
                                .addGap(18, 18, 18)
                                .addComponent(tombolconvertDocx))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pathfileconvert, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                                    .addComponent(pathfileopen))))
                        .addGap(0, 179, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tombolrefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pathfileopen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolrefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathfileconvert, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolexit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolconvertDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolconvertDocx, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ConvertToDoc() {
        String content = null;
        FileFilter filter = new FileNameExtensionFilter("txt Files", "txt", "txt");
        JFileChooser chooser = new JFileChooser("");
        chooser.addChoosableFileFilter(filter);
        java.io.File filenya;

        int buka_dialog = chooser.showOpenDialog(konverter.this);
        if (buka_dialog == JFileChooser.APPROVE_OPTION) {
            filenya = chooser.getSelectedFile();
            pathfileopen.setText(filenya.getPath());
            String filename = filenya.getPath();

            // membaca Txt file
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(filename));
                StringBuilder stringBuilder = new StringBuilder();
                String line = bufferedReader.readLine();

                while (line != null) {
                    stringBuilder.append(line);
                    line = bufferedReader.readLine();
                    stringBuilder.append(System.lineSeparator());
                }
                content = stringBuilder.toString();
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                }
            }
        }

        // Write doc
        String outDoc = "D://Dochasilconvert.doc";
        XWPFDocument document = new XWPFDocument();
        try (FileOutputStream out = new FileOutputStream(new File(outDoc))) {
            XWPFParagraph paragraf = document.createParagraph();
            XWPFRun run = paragraf.createRun();
            run.setText(content);
            document.write(out);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(konverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(konverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Write doc successfully");
        pathfileconvert.setText(outDoc);
    }

    public void ConvertToDocx() throws FileNotFoundException, IOException {
        String content = null;
        FileFilter filter = new FileNameExtensionFilter("txt Files", "txt", "txt");
        JFileChooser chooser = new JFileChooser("");
        chooser.addChoosableFileFilter(filter);
        java.io.File filenya;

        int buka_dialog = chooser.showOpenDialog(konverter.this);
        if (buka_dialog == JFileChooser.APPROVE_OPTION) {
            filenya = chooser.getSelectedFile();
            pathfileopen.setText(filenya.getPath());
            String filename = filenya.getPath();

            // membaca Txt file
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(filename));
                StringBuilder stringBuilder = new StringBuilder();
                String line = bufferedReader.readLine();

                while (line != null) {
                    stringBuilder.append(line);
                    line = bufferedReader.readLine();
                    stringBuilder.append(System.lineSeparator());
                }
                content = stringBuilder.toString();
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                }
            }
        }

        // Write Docx
        XWPFDocument documentDocx = new XWPFDocument();
        String outDocxEn = "D://Docxhasilconvert.docx";
        //create paragraph
        try (FileOutputStream outDocx = new FileOutputStream(new File(outDocxEn))) {
            //create paragraph
            XWPFParagraph paragraphDocx = documentDocx.createParagraph();
            XWPFRun runDocx = paragraphDocx.createRun();
            runDocx.setText(content);
            documentDocx.write(outDocx);
        }
        JOptionPane.showMessageDialog(null, "Write docx successfully");
        pathfileconvert.setText(outDocxEn);
    }

    private void tombolrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolrefreshActionPerformed
        pathfileopen.setText("");
        pathfileconvert.setText("");
    }//GEN-LAST:event_tombolrefreshActionPerformed

    private void tombolexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolexitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_tombolexitActionPerformed

    private void tombolconvertDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolconvertDocActionPerformed
        ConvertToDoc();
    }//GEN-LAST:event_tombolconvertDocActionPerformed

    private void pathfileopenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathfileopenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pathfileopenActionPerformed

    private void tombolconvertDocxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolconvertDocxActionPerformed
        try {
            ConvertToDocx();
        } catch (IOException ex) {
            Logger.getLogger(konverter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tombolconvertDocxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        BasicConfigurator.configure();
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
            java.util.logging.Logger.getLogger(konverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(konverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(konverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(konverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new konverter().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField pathfileconvert;
    private javax.swing.JTextField pathfileopen;
    private javax.swing.JButton tombolconvertDoc;
    private javax.swing.JButton tombolconvertDocx;
    private javax.swing.JButton tombolexit;
    private javax.swing.JButton tombolrefresh;
    // End of variables declaration//GEN-END:variables
}