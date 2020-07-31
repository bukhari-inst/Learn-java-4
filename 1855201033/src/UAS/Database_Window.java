/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Bukhari_Inst
 */
public class Database_Window extends javax.swing.JFrame {

    /**
     * Creates new form Main_Window
     */
    public Database_Window() {
        initComponents();
        //this.setTitle("Manage Product");
        this.setLocationRelativeTo(this);
        getConnection();
        ButtonGroup bG = new ButtonGroup();
        bG.add(in_lakilaki);
        bG.add(in_perempuan);
        Show_InJTable();
    }
    
    Statement pst;
    ResultSet rs;
    String ImgPath = null;
    int Posisi = 0;

    public Connection getConnection() {
        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/dataclient", "root", "");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(Database_Window.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "databaseNot Connected!");
            return null;
        }
    }

    // Check Input
    public boolean checkInputs() {
        if (txt_name.getText() == null
                || txt_nokamar.getText() == null
                || txt_nohp.getText() == null
                || txt_AddDate.getDate() == null) {
            return false;
        } else {
            try {
                txt_nohp.getText();
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
    }

    // Resize Image Di JLabel
    public ImageIcon ResizeImage(String imagePath, byte[] pic) {
        ImageIcon myImage = null;
        if (imagePath != null) {
            myImage = new ImageIcon(imagePath);
        } else {
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }

    // Menampilkan Data Di JTable: 
    // Mengisi ArrayList
    public ArrayList<Client> getClientList() {
        ArrayList<Client> clientList = new ArrayList<Client>();
        Connection con = getConnection();
        String query = "SELECT * FROM client";
        try {
            pst = con.createStatement();
            rs = pst.executeQuery(query);
            Client client;

            while (rs.next()) {
                client = new Client(rs.getInt("id"), rs.getString("nama"), rs.getString("jeniskelamin"), rs.getString("nokamar"), rs.getString("nohp"), rs.getString("tanggal"), rs.getBytes("foto"));
                clientList.add(client);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientList;
    }

    // Menampilkan di JTable
    public void Show_InJTable() {
        ArrayList<Client> list = getClientList();
        DefaultTableModel model = (DefaultTableModel) JTable_Products.getModel();
        // hapus isi jtable
        model.setRowCount(0);
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getJk();
            row[3] = list.get(i).getNokamar();
            row[4] = list.get(i).getNohp();
            row[5] = list.get(i).getAddDate();
            model.addRow(row);
        }
    }

    // Show Data In Inputs
    public void ShowItem(int index) {
        try {
            txt_id.setText(Integer.toString(getClientList().get(index).getId()));
            txt_name.setText(getClientList().get(index).getName());
            Connection con = getConnection();
            int id = Integer.parseInt(txt_id.getText());
            String sql = "select * from client where id like '%" + id + "%'";
            pst = con.createStatement();
            rs = pst.executeQuery(sql);
            if (rs.next()) {
                String jenis = rs.getString("jeniskelamin");
                if (jenis.equals("L")) {
                    in_lakilaki.setSelected(true);
                } else {
                    in_perempuan.setSelected(true);
                }
            }
            txt_nokamar.setText(getClientList().get(index).getNokamar());
            txt_nohp.setText(getClientList().get(index).getNohp());
            try {
                Date addDate = null;
                addDate = new SimpleDateFormat("yyyy-MM-dd").parse((String) getClientList().get(index).getAddDate());
                txt_AddDate.setDate(addDate);
            } catch (ParseException ex) {
                Logger.getLogger(Database_Window.class.getName()).log(Level.SEVERE, null, ex);
            }

            lbl_image.setIcon(ResizeImage(null, getClientList().get(index).getImage()));
        } catch (SQLException ex) {
            Logger.getLogger(Database_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void selectById(int id) {
        try {
            Connection con = getConnection();
            try {
                String sql = "select id, nama, jeniskelamin, nokamar, nohp, tanggal  from client where id like '%" + id + "%'";
                pst = con.createStatement();
                rs = pst.executeQuery(sql);
                JTable_Products.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            String sql2 = "select * from client where id like '%" + id + "%'";
            pst = con.createStatement();
            rs = pst.executeQuery(sql2);
            if (rs.next()) {
                txt_id.setText(Integer.toString(rs.getInt("id")));
                txt_name.setText(rs.getString("nama"));
                String jenis = rs.getString("jeniskelamin");
                if (jenis.equals("L")) {
                    in_lakilaki.setSelected(true);
                } else {
                    in_perempuan.setSelected(true);
                }
                txt_nokamar.setText(rs.getString("nokamar"));
                txt_nohp.setText(rs.getString("nohp"));
                txt_AddDate.setDate(rs.getDate("tanggal"));
                lbl_image.setIcon(ResizeImage(null, rs.getBytes("foto")));
            } else {
                JOptionPane.showMessageDialog(null, "File Not Found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void selectByNama(String nama) {
        try {
            Connection con = getConnection();
            try {
                String sql = "select id, nama, jeniskelamin, nokamar, nohp, tanggal  from client where nama like '%" + nama + "%'";
                pst = con.createStatement();
                rs = pst.executeQuery(sql);
                JTable_Products.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            String sql2 = "select * from client where nama like '%" + nama + "%'";
            pst = con.createStatement();
            rs = pst.executeQuery(sql2);
            if (rs.next()) {
                txt_id.setText(Integer.toString(rs.getInt("id")));
                txt_name.setText(rs.getString("nama"));
                String jenis = rs.getString("jeniskelamin");
                if (jenis.equals("L")) {
                    in_lakilaki.setSelected(true);
                } else {
                    in_perempuan.setSelected(true);
                }
                txt_nokamar.setText(rs.getString("nokamar"));
                txt_nohp.setText(rs.getString("nohp"));
                txt_AddDate.setDate(rs.getDate("tanggal"));
                lbl_image.setIcon(ResizeImage(null, rs.getBytes("foto")));
            } else {
                JOptionPane.showMessageDialog(null, "File Not Found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void selectByJk(String Jk) {
        try {
            Connection con = getConnection();
            try {
                String sql = "select id, nama, jeniskelamin, nokamar, nohp, tanggal  from client where jeniskelamin like '%" + Jk + "%'";
                pst = con.createStatement();
                rs = pst.executeQuery(sql);
                JTable_Products.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            String sql2 = "select * from client where jeniskelamin like '%" + Jk + "%'";
            pst = con.createStatement();
            rs = pst.executeQuery(sql2);
            if (rs.next()) {
                txt_id.setText(Integer.toString(rs.getInt("id")));
                txt_name.setText(rs.getString("nama"));
                String jenis = rs.getString("jeniskelamin");
                if (jenis.equals("L")) {
                    in_lakilaki.setSelected(true);
                } else {
                    in_perempuan.setSelected(true);
                }
                txt_nokamar.setText(rs.getString("nokamar"));
                txt_nohp.setText(rs.getString("nohp"));
                txt_AddDate.setDate(rs.getDate("tanggal"));
                lbl_image.setIcon(ResizeImage(null, rs.getBytes("foto")));
            } else {
                JOptionPane.showMessageDialog(null, "File Not Found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void selectByNokamar(String Kmr) {
        try {
            Connection con = getConnection();
            try {
                String sql = "select id, nama, jeniskelamin,  nokamar, nohp, tanggal  from client where nokamar like '%" + Kmr + "%'";
                pst = con.createStatement();
                rs = pst.executeQuery(sql);
                JTable_Products.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            String sql2 = "select * from client where nokamar like '%" + Kmr + "%'";
            pst = con.createStatement();
            rs = pst.executeQuery(sql2);
            if (rs.next()) {
                txt_id.setText(Integer.toString(rs.getInt("id")));
                txt_name.setText(rs.getString("nama"));
                String jenis = rs.getString("jeniskelamin");
                if (jenis.equals("L")) {
                    in_lakilaki.setSelected(true);
                } else {
                    in_perempuan.setSelected(true);
                }
                txt_nokamar.setText(rs.getString("nokamar"));
                txt_nohp.setText(rs.getString("nohp"));
                txt_AddDate.setDate(rs.getDate("tanggal"));
                lbl_image.setIcon(ResizeImage(null, rs.getBytes("foto")));
            } else {
                JOptionPane.showMessageDialog(null, "File Not Found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void selectByNohp(String hp) {
        try {
            Connection con = getConnection();
            try {
                String sql = "select id, nama, jeniskelamin,  nokamar, nohp, tanggal  from client where nohp like '%" + hp + "%'";
                pst = con.createStatement();
                rs = pst.executeQuery(sql);
                JTable_Products.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            String sql2 = "select * from client where nohp like '%" + hp + "%'";
            pst = con.createStatement();
            rs = pst.executeQuery(sql2);
            if (rs.next()) {
                txt_id.setText(Integer.toString(rs.getInt("id")));
                txt_name.setText(rs.getString("nama"));
                String jenis = rs.getString("jeniskelamin");
                if (jenis.equals("L")) {
                    in_lakilaki.setSelected(true);
                } else {
                    in_perempuan.setSelected(true);
                }
                txt_nokamar.setText(rs.getString("nokamar"));
                txt_nohp.setText(rs.getString("nohp"));
                txt_AddDate.setDate(rs.getDate("tanggal"));
                lbl_image.setIcon(ResizeImage(null, rs.getBytes("foto")));
            } else {
                JOptionPane.showMessageDialog(null, "File Not Found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void selectByTanggal(String Tgl) {
        try {
            Connection con = getConnection();
            try {
                String sql = "select id, nama, jeniskelamin, nokamar, nohp, tanggal  from client where tanggal like '%" + Tgl + "%'";
                pst = con.createStatement();
                rs = pst.executeQuery(sql);
                JTable_Products.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }

            String sql2 = "select * from client where tanggal like '%" + Tgl + "%'";
            pst = con.createStatement();
            rs = pst.executeQuery(sql2);
            if (rs.next()) {
                txt_id.setText(Integer.toString(rs.getInt("id")));
                txt_name.setText(rs.getString("nama"));
                String jenis = rs.getString("jeniskelamin");
                if (jenis.equals("L")) {
                    in_lakilaki.setSelected(true);
                } else {
                    in_perempuan.setSelected(true);
                }
                txt_nokamar.setText(rs.getString("nokamar"));
                txt_nohp.setText(rs.getString("nohp"));
                txt_AddDate.setDate(rs.getDate("tanggal"));
                lbl_image.setIcon(ResizeImage(null, rs.getBytes("foto")));
            } else {
                JOptionPane.showMessageDialog(null, "File Not Found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        txt_AddDate = new com.toedter.calendar.JDateChooser();
        lbl_image = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_Products = new javax.swing.JTable();
        Btn_Choose_Image = new javax.swing.JButton();
        Btn_Update = new javax.swing.JButton();
        Btn_Delete = new javax.swing.JButton();
        Btn_First = new javax.swing.JButton();
        Btn_previous = new javax.swing.JButton();
        Btn_Insert = new javax.swing.JButton();
        Btn_Next = new javax.swing.JButton();
        Btn_Last = new javax.swing.JButton();
        pilihPencarian = new javax.swing.JComboBox<>();
        Btn_Cari = new javax.swing.JButton();
        inputPencarian = new javax.swing.JTextField();
        defaultTabel = new javax.swing.JButton();
        ResetInput = new javax.swing.JButton();
        Btn_Reset = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_nokamar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_nohp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        in_lakilaki = new javax.swing.JRadioButton();
        in_perempuan = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tanggal:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Image:");

        txt_name.setBackground(new java.awt.Color(255, 255, 255));
        txt_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_name.setForeground(new java.awt.Color(0, 0, 0));

        txt_id.setBackground(new java.awt.Color(255, 255, 255));
        txt_id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_id.setForeground(new java.awt.Color(0, 0, 0));
        txt_id.setEnabled(false);

        txt_AddDate.setBackground(java.awt.Color.white);
        txt_AddDate.setForeground(new java.awt.Color(0, 0, 0));
        txt_AddDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbl_image.setBackground(new java.awt.Color(255, 255, 255));
        lbl_image.setForeground(new java.awt.Color(255, 255, 255));
        lbl_image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_image.setOpaque(true);

        JTable_Products.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        JTable_Products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Jenis Kelamin", "No Kamar", "No Hp", "Tanggal"
            }
        ));
        JTable_Products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_ProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable_Products);

        Btn_Choose_Image.setBackground(new java.awt.Color(77, 19, 209));
        Btn_Choose_Image.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Btn_Choose_Image.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Choose_Image.setText("Choose Image");
        Btn_Choose_Image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Choose_ImageActionPerformed(evt);
            }
        });

        Btn_Update.setBackground(new java.awt.Color(77, 19, 209));
        Btn_Update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Btn_Update.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UAS/icon/icons8-update-30.png"))); // NOI18N
        Btn_Update.setText("Update");
        Btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_UpdateActionPerformed(evt);
            }
        });

        Btn_Delete.setBackground(new java.awt.Color(255, 0, 0));
        Btn_Delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Btn_Delete.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UAS/icon/icons8-delete-30.png"))); // NOI18N
        Btn_Delete.setText("Delete");
        Btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DeleteActionPerformed(evt);
            }
        });

        Btn_First.setBackground(new java.awt.Color(255, 0, 102));
        Btn_First.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Btn_First.setForeground(new java.awt.Color(255, 255, 255));
        Btn_First.setText("|< First");
        Btn_First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_FirstActionPerformed(evt);
            }
        });

        Btn_previous.setBackground(new java.awt.Color(153, 0, 0));
        Btn_previous.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Btn_previous.setForeground(new java.awt.Color(255, 255, 255));
        Btn_previous.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UAS/icon/icons8-back-30.png"))); // NOI18N
        Btn_previous.setText("Previous");
        Btn_previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_previousActionPerformed(evt);
            }
        });

        Btn_Insert.setBackground(new java.awt.Color(77, 19, 209));
        Btn_Insert.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Btn_Insert.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Insert.setIcon(new javax.swing.ImageIcon("D:\\Materi\\Semester 4\\AP2\\Java Project\\1855201033\\src\\UAS\\icon\\icons8-plus-30.png")); // NOI18N
        Btn_Insert.setText("Insert");
        Btn_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_InsertActionPerformed(evt);
            }
        });

        Btn_Next.setBackground(new java.awt.Color(153, 0, 0));
        Btn_Next.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Btn_Next.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UAS/icon/icons8-next-page-30.png"))); // NOI18N
        Btn_Next.setText("Next");
        Btn_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_NextActionPerformed(evt);
            }
        });

        Btn_Last.setBackground(new java.awt.Color(255, 0, 102));
        Btn_Last.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Btn_Last.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Last.setText(">| Last");
        Btn_Last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LastActionPerformed(evt);
            }
        });

        pilihPencarian.setBackground(new java.awt.Color(255, 255, 255));
        pilihPencarian.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pilihPencarian.setForeground(new java.awt.Color(0, 0, 0));
        pilihPencarian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Pencarian", "ID", "Nama", "Jenis Kelamin", "No Kamar", "No Hp", "Tanggal" }));
        pilihPencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihPencarianActionPerformed(evt);
            }
        });

        Btn_Cari.setBackground(new java.awt.Color(77, 19, 209));
        Btn_Cari.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Btn_Cari.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UAS/icon/icons8-search-30.png"))); // NOI18N
        Btn_Cari.setText("CARI");
        Btn_Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CariActionPerformed(evt);
            }
        });

        inputPencarian.setBackground(new java.awt.Color(255, 255, 255));
        inputPencarian.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputPencarian.setForeground(new java.awt.Color(0, 0, 0));

        defaultTabel.setBackground(new java.awt.Color(77, 19, 209));
        defaultTabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        defaultTabel.setForeground(new java.awt.Color(255, 255, 255));
        defaultTabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UAS/icon/icons8-reset-30.png"))); // NOI18N
        defaultTabel.setText("REFRESH TABEL");
        defaultTabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultTabelActionPerformed(evt);
            }
        });

        ResetInput.setBackground(new java.awt.Color(77, 19, 209));
        ResetInput.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ResetInput.setForeground(new java.awt.Color(255, 255, 255));
        ResetInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UAS/icon/icons8-reset-30.png"))); // NOI18N
        ResetInput.setText("RESET");
        ResetInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetInputActionPerformed(evt);
            }
        });

        Btn_Reset.setBackground(new java.awt.Color(77, 19, 209));
        Btn_Reset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Btn_Reset.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UAS/icon/icons8-reset-30.png"))); // NOI18N
        Btn_Reset.setText("RESET");
        Btn_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ResetActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("No Kamar:");

        txt_nokamar.setBackground(new java.awt.Color(255, 255, 255));
        txt_nokamar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_nokamar.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("No Hp:");

        txt_nohp.setBackground(new java.awt.Color(255, 255, 255));
        txt_nohp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_nohp.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Jenis Kelamin:");

        in_lakilaki.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        in_lakilaki.setForeground(new java.awt.Color(255, 255, 255));
        in_lakilaki.setText("Laki-laki");
        in_lakilaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in_lakilakiActionPerformed(evt);
            }
        });

        in_perempuan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        in_perempuan.setForeground(new java.awt.Color(255, 255, 255));
        in_perempuan.setText("Perempuan");
        in_perempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in_perempuanActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 204, 0));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText(" Management CLient Hotel");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(118, 118, 118))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(txt_AddDate, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_id)
                                        .addComponent(txt_name)
                                        .addComponent(txt_nokamar)
                                        .addComponent(txt_nohp)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(in_lakilaki)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                            .addComponent(in_perempuan)))
                                    .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btn_Choose_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Btn_Insert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Btn_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btn_Reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_Delete, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))))
                .addGap(167, 167, 167)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(inputPencarian)
                                .addComponent(Btn_Cari, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                            .addGap(29, 29, 29)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(ResetInput, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(defaultTabel, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(pilihPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(121, 121, 121))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Btn_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_previous)
                        .addGap(29, 29, 29)
                        .addComponent(Btn_First, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_Last, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(in_lakilaki)
                            .addComponent(in_perempuan))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_nokamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_nohp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(txt_AddDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_Choose_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_Reset)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pilihPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ResetInput)
                            .addComponent(defaultTabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_previous)
                            .addComponent(Btn_Next)
                            .addComponent(Btn_Last, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_First, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1284, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_previousActionPerformed
        Posisi--;
        if (Posisi < 0) {
            Posisi = 0;
        }
        ShowItem(Posisi);
    }//GEN-LAST:event_Btn_previousActionPerformed

    private void Btn_Choose_ImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Choose_ImageActionPerformed

        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lbl_image.setIcon(ResizeImage(path, null));
            ImgPath = path;
        } else {
            System.out.println("No File Selected");
        }
    }//GEN-LAST:event_Btn_Choose_ImageActionPerformed

    private void Btn_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_InsertActionPerformed

        if (checkInputs() && ImgPath != null && in_lakilaki.isSelected() || in_perempuan.isSelected()) {
            try {
                Connection con = getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO client(nama,jeniskelamin,nokamar,nohp,tanggal,foto)"
                        + "values(?,?,?,?,?,?) ");
                ps.setString(1, txt_name.getText());
                String jenis = "";
                if (in_lakilaki.isSelected()) {
                    jenis = "L";
                } else if (in_perempuan.isSelected()) {
                    jenis = "P";
                }
                ps.setString(2, jenis);
                ps.setString(3, txt_nokamar.getText());
                ps.setString(4, txt_nohp.getText());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String addDate = dateFormat.format(txt_AddDate.getDate());
                ps.setString(5, addDate);
                InputStream img = new FileInputStream(new File(ImgPath));
                ps.setBlob(6, img);
                ps.executeUpdate();
                Show_InJTable();
                JOptionPane.showMessageDialog(null, "Data Inserted");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Satu Atau Lebih Bidang Kosong");
        }
    }//GEN-LAST:event_Btn_InsertActionPerformed

    private void Btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_UpdateActionPerformed
        if (checkInputs() && txt_id.getText() != null) {
            String UpdateQuery = null;
            PreparedStatement ps = null;
            Connection con = getConnection();
            // update tanpa foto
            if (ImgPath == null) {
                try {
                    UpdateQuery = "UPDATE client SET nama = ?, jeniskelamin = ?"
                            + ", nokamar = ?, nohp = ?"
                            + ", tanggal = ? WHERE id = ?";
                    ps = con.prepareStatement(UpdateQuery);
                    ps.setString(1, txt_name.getText());
                    String jenis = "";
                    if (in_lakilaki.isSelected()) {
                        jenis = "L";
                    } else if (in_perempuan.isSelected()) {
                        jenis = "P";
                    }
                    ps.setString(2, jenis);
                    ps.setString(3, txt_nokamar.getText());
                    ps.setString(4, txt_nohp.getText());
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String addDate = dateFormat.format(txt_AddDate.getDate());
                    ps.setString(5, addDate);
                    ps.setInt(6, Integer.parseInt(txt_id.getText()));
                    ps.executeUpdate();
                    Show_InJTable();
                    JOptionPane.showMessageDialog(null, "Data Updated");
                } catch (SQLException ex) {
                    Logger.getLogger(Database_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
            } // update dengan foto
            else {
                try {
                    InputStream img = new FileInputStream(new File(ImgPath));
                    UpdateQuery = "UPDATE client SET nama = ?, jeniskelamin = ?"
                            + ", nokamar = ?, nohp = ?"
                            + ", tanggal = ?, foto = ? WHERE id = ?";
                    ps = con.prepareStatement(UpdateQuery);
                    ps.setString(1, txt_name.getText());
                    String jenis = "";
                    if (in_lakilaki.isSelected()) {
                        jenis = "L";
                    } else if (in_perempuan.isSelected()) {
                        jenis = "P";
                    }
                    ps.setString(2, jenis);
                    ps.setString(3, txt_nokamar.getText());
                    ps.setString(4, txt_nohp.getText());
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String addDate = dateFormat.format(txt_AddDate.getDate());
                    ps.setString(5, addDate);
                    ps.setBlob(6, img);
                    ps.setInt(7, Integer.parseInt(txt_id.getText()));
                    ps.executeUpdate();
                    Show_InJTable();
                    JOptionPane.showMessageDialog(null, "Data Updated");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Satu Atau Lebih Bidang Kosong Atau Salah");
        }
    }//GEN-LAST:event_Btn_UpdateActionPerformed

    private void Btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DeleteActionPerformed
        if (!txt_id.getText().equals("")) {
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM client WHERE id = ?");
                int id = Integer.parseInt(txt_id.getText());
                ps.setInt(1, id);
                ps.executeUpdate();
                Show_InJTable();
                JOptionPane.showMessageDialog(null, "Data Deleted");
            } catch (SQLException ex) {
                Logger.getLogger(Database_Window.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Data Not Deleted");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Data Not Deleted : No Id To Delete");
        }
    }//GEN-LAST:event_Btn_DeleteActionPerformed

    private void JTable_ProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_ProductsMouseClicked
        try {
            DefaultTableModel dtm = (DefaultTableModel) JTable_Products.getModel(); //membuat model
            int selectedRowIndex = JTable_Products.getSelectedRow(); //select baris
            int id = (int) dtm.getValueAt(selectedRowIndex, 0); //select baris untuk mengambil data.
            Connection con = getConnection();
            String sql = "select * from client where id like '%" + id + "%'";
            pst = con.createStatement();
            rs = pst.executeQuery(sql);
            while (rs.next()) {
                txt_id.setText(Integer.toString(rs.getInt("id")));
                txt_name.setText(rs.getString("nama"));
                String jenis = rs.getString("jeniskelamin");
                if (jenis.equals("L")) {
                    in_lakilaki.setSelected(true);
                } else {
                    in_perempuan.setSelected(true);
                }
                txt_nokamar.setText(rs.getString("nokamar"));
                txt_nohp.setText(rs.getString("nohp"));
                txt_AddDate.setDate(rs.getDate("tanggal"));
                lbl_image.setIcon(ResizeImage(null, rs.getBytes("foto")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JTable_ProductsMouseClicked

    private void Btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_FirstActionPerformed
        Posisi = 0;
        ShowItem(Posisi);
    }//GEN-LAST:event_Btn_FirstActionPerformed

    private void Btn_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LastActionPerformed
        Posisi = getClientList().size() - 1;
        ShowItem(Posisi);
    }//GEN-LAST:event_Btn_LastActionPerformed

    private void Btn_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_NextActionPerformed

        Posisi++;
        if (Posisi >= getClientList().size()) {
            Posisi = getClientList().size() - 1;
        }
        ShowItem(Posisi);
    }//GEN-LAST:event_Btn_NextActionPerformed

    private void pilihPencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihPencarianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pilihPencarianActionPerformed

    private void Btn_CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CariActionPerformed
        if (pilihPencarian.getSelectedIndex() == 1) {
            selectById(Integer.parseInt(inputPencarian.getText()));
        } else if (pilihPencarian.getSelectedIndex() == 2) {
            selectByNama(inputPencarian.getText());
        } else if (pilihPencarian.getSelectedIndex() == 3) {
            selectByJk(inputPencarian.getText());
        } else if (pilihPencarian.getSelectedIndex() == 4) {
            selectByNokamar(inputPencarian.getText());
        } else if (pilihPencarian.getSelectedIndex() == 5) {
            selectByNohp(inputPencarian.getText());
        } else if (pilihPencarian.getSelectedIndex() == 6) {
            selectByTanggal(inputPencarian.getText());
        } else {
            Show_InJTable();
            JOptionPane.showMessageDialog(null, "Sesuikan Pilihan Pencarian!");
        }
    }//GEN-LAST:event_Btn_CariActionPerformed

    private void defaultTabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultTabelActionPerformed
        Show_InJTable();
    }//GEN-LAST:event_defaultTabelActionPerformed

    private void ResetInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetInputActionPerformed
        inputPencarian.setText("");
    }//GEN-LAST:event_ResetInputActionPerformed

    private void Btn_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ResetActionPerformed
        txt_id.setText("");
        txt_name.setText("");
        ButtonGroup bG = new ButtonGroup();
        bG.add(in_lakilaki);
        bG.add(in_perempuan);
        bG.clearSelection();
        txt_nokamar.setText("");
        txt_nohp.setText("");
        txt_AddDate.setDate(new Date());
        lbl_image.setIcon(null);
    }//GEN-LAST:event_Btn_ResetActionPerformed

    private void in_lakilakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in_lakilakiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_in_lakilakiActionPerformed

    private void in_perempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in_perempuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_in_perempuanActionPerformed

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
            java.util.logging.Logger.getLogger(Database_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Database_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Database_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Database_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Database_Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Cari;
    private javax.swing.JButton Btn_Choose_Image;
    private javax.swing.JButton Btn_Delete;
    private javax.swing.JButton Btn_First;
    private javax.swing.JButton Btn_Insert;
    private javax.swing.JButton Btn_Last;
    private javax.swing.JButton Btn_Next;
    private javax.swing.JButton Btn_Reset;
    private javax.swing.JButton Btn_Update;
    private javax.swing.JButton Btn_previous;
    private javax.swing.JTable JTable_Products;
    private javax.swing.JButton ResetInput;
    private javax.swing.JButton defaultTabel;
    private javax.swing.JRadioButton in_lakilaki;
    private javax.swing.JRadioButton in_perempuan;
    private javax.swing.JTextField inputPencarian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JComboBox<String> pilihPencarian;
    private com.toedter.calendar.JDateChooser txt_AddDate;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_nohp;
    private javax.swing.JTextField txt_nokamar;
    // End of variables declaration//GEN-END:variables
}
