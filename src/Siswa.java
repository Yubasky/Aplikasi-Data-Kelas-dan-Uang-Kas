import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Siswa extends javax.swing.JFrame {
    private Connection con; 
    private Statement st;
    private ResultSet rs;
    private DefaultTableModel t;
    
    public Siswa() {
       initComponents();
        koneksi();
        kosongkan();
        t = new DefaultTableModel();
        tabel.setModel(t);
        table();
    }
    
    private void koneksi() {
   try {
            con = config.configDB();
            st = con.createStatement();
       } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Koneksi gagal: " + e.getMessage());
        }
    }
 private void table (){
        DefaultTableModel t = new DefaultTableModel();
        t.addColumn("Nis");
        t.addColumn("Nama");
        t.addColumn("Jenis Kelamin");
        t.addColumn("No HP");
        t.addColumn("Alamat");
        tabel.setModel(t);

             try {
            if (st != null) {
                ResultSet rs = st.executeQuery("SELECT NIS, Nama, JenisKelamin, NoHp, Alamat FROM sisw");
                while (rs.next()) {
                    t.addRow(new Object[]{
                            rs.getString("NIS"),
                            rs.getString("Nama"),
                            rs.getString("JenisKelamin"),
                            rs.getString("NoHp"),
                            rs.getString("Alamat")
                    });
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Statement is null.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Error tidak menerima data: " + e.getMessage());
        }

    }
    
    
    
     private void kosongkan(){
        Nis.setText("");
    Nama.setText("");
    Jk.setSelectedItem("");
    NoHp.setText("");
    Alamat.setText("");
        Nis.requestFocus();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Nis = new javax.swing.JTextField();
        Nama = new javax.swing.JTextField();
        NoHp = new javax.swing.JTextField();
        Menu = new javax.swing.JButton();
        Simpan = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        Hapus = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Clear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        Cari = new javax.swing.JButton();
        Alamat = new javax.swing.JTextField();
        Jk = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36)); // NOI18N
        jLabel1.setText("Data Siswa");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 1000));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("NIS");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(550, 120, 27, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nama");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(550, 180, 40, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Alamat");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(550, 330, 48, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("No Handphone");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(550, 280, 105, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Jenis Kelamin");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(550, 230, 92, 17);

        Nis.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Nis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NisActionPerformed(evt);
            }
        });
        Nis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NisKeyTyped(evt);
            }
        });
        jPanel1.add(Nis);
        Nis.setBounds(720, 111, 154, 30);

        Nama.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(Nama);
        Nama.setBounds(720, 167, 154, 30);

        NoHp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        NoHp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoHpActionPerformed(evt);
            }
        });
        NoHp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NoHpKeyTyped(evt);
            }
        });
        jPanel1.add(NoHp);
        NoHp.setBounds(720, 274, 154, 30);

        Menu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/left-arrow.png"))); // NOI18N
        Menu.setText("Kembali");
        Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuActionPerformed(evt);
            }
        });
        jPanel1.add(Menu);
        Menu.setBounds(1240, 10, 120, 39);

        Simpan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diskette.png"))); // NOI18N
        Simpan.setText("Simpan");
        Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanActionPerformed(evt);
            }
        });
        jPanel1.add(Simpan);
        Simpan.setBounds(810, 370, 110, 58);

        Edit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit.png"))); // NOI18N
        Edit.setText("Edit");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });
        jPanel1.add(Edit);
        Edit.setBounds(400, 370, 100, 58);

        Hapus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        Hapus.setText("Hapus");
        Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusActionPerformed(evt);
            }
        });
        jPanel1.add(Hapus);
        Hapus.setBounds(520, 370, 120, 58);

        jLabel7.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36)); // NOI18N
        jLabel7.setText("Data Siswa");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(630, 27, 209, 58);

        Clear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cleaning.png"))); // NOI18N
        Clear.setText("Bersihkan");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        jPanel1.add(Clear);
        Clear.setBounds(660, 370, 130, 57);

        tabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(400, 440, 640, 166);

        Cari.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        Cari.setText("Cari");
        Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariActionPerformed(evt);
            }
        });
        jPanel1.add(Cari);
        Cari.setBounds(940, 370, 100, 58);

        Alamat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlamatActionPerformed(evt);
            }
        });
        jPanel1.add(Alamat);
        Alamat.setBounds(720, 322, 154, 30);

        Jk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Laki-Laki", "Perempuan" }));
        jPanel1.add(Jk);
        Jk.setBounds(720, 225, 154, 31);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/888.png"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(0, 0, 1410, 1000);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1412, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuActionPerformed
        new MenuUtama().setVisible(true);
        dispose();
    }//GEN-LAST:event_MenuActionPerformed

    private void NisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NisActionPerformed
         try {
    rs = st.executeQuery("select * from sisw where " + "Nis='" + Nis.getText() + "'");
    while (rs.next()) {
        Nama.setText(rs.getString("Nama"));
        Jk.setSelectedItem(rs.getString("JenisKelamin")); 
        NoHp.setText(rs.getString("NoHp"));
        Alamat.setText(rs.getString("Alamat"));
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(rootPane, e);
}
    }//GEN-LAST:event_NisActionPerformed
    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
                  try {
        int ok = JOptionPane.showConfirmDialog(null, "Apakah yakin ingin mengedit data?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (ok == 0) {
            String sql = "UPDATE sisw SET Nis=?, Nama=?, JenisKelamin=?, NoHp=?, Alamat=? WHERE Nis=?";
            
            try (PreparedStatement st = con.prepareStatement(sql)) {
                st.setString(1, Nis.getText());
                st.setString(2, Nama.getText());
               st.setString(3, (String) Jk.getSelectedItem());
                st.setString(4, NoHp.getText());
                st.setString(5, Alamat.getText());
                st.setString(6, Nis.getText()); // 
                
                int rowsAffected = st.executeUpdate();

                if (rowsAffected > 0) {
                    kosongkan();
                    JOptionPane.showMessageDialog(null, "Edit Data Sukses");
                    new Siswa().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Edit Data Gagal: " + e.getMessage());
    }

    }//GEN-LAST:event_EditActionPerformed

    private void HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusActionPerformed
              int ok = JOptionPane.showConfirmDialog(null, "Apakah yakin ingin menghapus?", "Confirmation", 
            JOptionPane.YES_NO_OPTION);
    if (ok == 0) {
        try {
            String sql = "DELETE FROM sisw WHERE Nis=?";
            try (PreparedStatement st = con.prepareStatement(sql)) {
                st.setString(1, Nis.getText());
                int rowsAffected = st.executeUpdate();

                if (rowsAffected > 0) {
                    kosongkan();
                    JOptionPane.showMessageDialog(null, "Delete Data Sukses");
                    new Siswa().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Delete Data Gagal: " + e.getMessage());
        }
    }


    }//GEN-LAST:event_HapusActionPerformed

    private void SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanActionPerformed
      try {
            String sql = "INSERT INTO sisw (NIS, Nama, JenisKelamin, NoHp, Alamat) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement st = con.prepareStatement(sql)) {
                st.setString(1, Nis.getText());
                st.setString(2, Nama.getText());
                st.setString(3, (String) Jk.getSelectedItem());
                st.setString(4, NoHp.getText());
                st.setString(5, Alamat.getText());

                int rowsAffected = st.executeUpdate();

                if (rowsAffected > 0) {
                    kosongkan();
                    JOptionPane.showMessageDialog(null, "Berhasil Menyimpan Data");
                    new Siswa().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal Menyimpan Data!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan Data! : " + e.getMessage());
        }
    }                                      

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {                                       
             try {
        String query = "SELECT * FROM sisw WHERE Nis=?";
        try (PreparedStatement st = con.prepareStatement(query)) {
            st.setString(1, Nis.getText());

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Nama.setText(rs.getString("Nama"));
                st.setString(3, (String) Jk.getSelectedItem());
                NoHp.setText(rs.getString("NoHp"));
                Alamat.setText(rs.getString("Alamat"));
                JOptionPane.showMessageDialog(rootPane, "Data berhasil ditemukan");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Data tidak ditemukan");
                kosongkan();
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, e);
    }
    }//GEN-LAST:event_SimpanActionPerformed

    private void NisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NisKeyTyped
        char Nis = evt.getKeyChar();
        if(!(Character.isDigit(Nis)))
        {
            evt.consume();
        }
    }//GEN-LAST:event_NisKeyTyped

    private void NoHpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoHpKeyTyped
       char No=evt.getKeyChar();
        if(!(Character.isDigit(No)))
        {
            evt.consume();
        }
    }//GEN-LAST:event_NoHpKeyTyped

    private void NoHpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoHpActionPerformed
     
    }//GEN-LAST:event_NoHpActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
      kosongkan();
    }//GEN-LAST:event_ClearActionPerformed

    private void CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariActionPerformed
          try {
    String query = "SELECT * FROM sisw WHERE NIS=?";
    try (PreparedStatement st = con.prepareStatement(query)) {
        st.setString(1, Nis.getText());

        try (ResultSet rs = st.executeQuery()) {
            if (rs.next()) {
                Nama.setText(rs.getString("Nama"));
                NoHp.setText(rs.getString("NoHp"));
                Jk.setSelectedItem(rs.getString("JenisKelamin")); 
                Alamat.setText(rs.getString("Alamat"));
                JOptionPane.showMessageDialog(rootPane, "Data berhasil ditemukan");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Data tidak ditemukan");
                kosongkan();
            }
        }
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(rootPane, e);
}

    }//GEN-LAST:event_CariActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int row = tabel.rowAtPoint(evt.getPoint());
    Nis.setText(tabel.getValueAt(row, 0).toString());
    Nama.setText(tabel.getValueAt(row, 1).toString());
    Jk.setSelectedItem(tabel.getValueAt(row, 2).toString());
    NoHp.setText(tabel.getValueAt(row, 3).toString());
    Alamat.setText(tabel.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tabelMouseClicked

    private void AlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlamatActionPerformed

    public static void main(String args[]) {
     
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Siswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Alamat;
    private javax.swing.JButton Cari;
    private javax.swing.JButton Clear;
    private javax.swing.JButton Edit;
    private javax.swing.JButton Hapus;
    private javax.swing.JComboBox<String> Jk;
    private javax.swing.JButton Menu;
    public javax.swing.JTextField Nama;
    public javax.swing.JTextField Nis;
    public javax.swing.JTextField NoHp;
    private javax.swing.JButton Simpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
