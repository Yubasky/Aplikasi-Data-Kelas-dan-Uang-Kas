import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Component;
import java.sql.PreparedStatement;
import javax.swing.JTable;

public class UangKas extends javax.swing.JFrame {
    private Connection con; 
    private Statement st;
    private ResultSet rs;
    private DefaultTableModel t;
   private DefaultTableModel tblMode1 = getDefaultTableModel();
    private javax.swing.table.DefaultTableModel originalTblModel;
    private javax.swing.JButton btnCari;
    String data[] = new String[4];
    String tableName = "kas";
    
    public UangKas() {
         initComponents();
    Tabel.setModel(tblMode1);
    tampildata();
    originalTblModel = (javax.swing.table.DefaultTableModel) Tabel.getModel();
    btnCari = new javax.swing.JButton();
    btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png")));
    btnCari.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCariActionPerformed(evt);
        }
          private void btnCariActionPerformed(ActionEvent evt) {
               
           }
    });
    jPanel1.add(btnCari);
    btnCari.setBounds(1050, 230, 42, 36);
    }
    
    
    private void cariData(String keyword) {
      try {
        String dbname = "jdbc:mysql://localhost:3306/dbsiswa";
        Connection con = DriverManager.getConnection(dbname, "root", ""); // Deklarasi dan inisialisasi variabel con di sini
        Statement statement = con.createStatement();
        String sql = "SELECT * FROM uangka WHERE NIS LIKE '%" + keyword + "%'";
        ResultSet res = statement.executeQuery(sql);

        tblMode1.setRowCount(0);

        while (res.next()) {
            data[0] = res.getString(1);
            data[1] = res.getString(2);
            data[2] = res.getString(3);
            data[3] = res.getString(4);
            data[4] = res.getString(5);
            tblMode1.addRow(data);
        }

        statement.close();
        con.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Gagal", JOptionPane.WARNING_MESSAGE);
    }
} 
   private javax.swing.table.DefaultTableModel getDefaultTableModel() {
   return new DefaultTableModel(
            new Object[][]{},
            new String[]{"NIS", "Nama", "Tanggal", "Bayar", "Status"}) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
   }
    public void tampildata(){       
           try {
            String dbname = "jdbc:mysql://localhost:3306/dbsiswa";
            Connection con = DriverManager.getConnection(dbname, "root", "");
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM uangka";
            ResultSet res = statement.executeQuery(sql);
            tblMode1.setRowCount(0);
            while (res.next()) {
                String[] data = {
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5)
                };
                tblMode1.addRow(data);
            }
            statement.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Gagal", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void Tampil(){
        int row = Tabel.getSelectedRow();
        txtnis.setText(tblMode1.getValueAt(row, 0).toString());
        txtnama.setText(tblMode1.getValueAt(row, 1).toString());
        try {
            String tanggaltabel = tblMode1.getValueAt(row, 2).toString();
            Date tanggaldate = new SimpleDateFormat("dd-MM-yyyy").parse(tanggaltabel);
            dctanggal.setDate(tanggaldate);
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, "Error: " + e2.getMessage(), "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        txtjumlah.setText(tblMode1.getValueAt(row, 3).toString());
    }
public void hapus(){
       txtnis.setText("");
        txtnama.setText("");
        dctanggal.setCalendar(null);
        txtjumlah.setText("");
        txtnis.requestFocus();
        cbstatus.setSelectedIndex(0);
    }
private boolean nisSudahAda(String nis) {
    try {
        String dbname = "jdbc:mysql://localhost:3306/dbsiswa";
        Connection con = DriverManager.getConnection(dbname, "root", "");
        Statement statement = con.createStatement();
        String sql = "SELECT * FROM uangka WHERE NIS = '" + nis + "'";
        ResultSet resultSet = statement.executeQuery(sql);

        return resultSet.next();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Gagal", JOptionPane.WARNING_MESSAGE);
        return false;
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtnis = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        txtjumlah = new javax.swing.JTextField();
        dctanggal = new com.toedter.calendar.JDateChooser();
        Simpan = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Search = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel = new javax.swing.JTable();
        Menu = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        cbstatus = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 1000));
        jPanel1.setLayout(null);

        txtnis.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtnis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnisKeyTyped(evt);
            }
        });
        jPanel1.add(txtnis);
        txtnis.setBounds(490, 80, 165, 36);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Uang kas");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(660, 40, 83, 22);

        txtnama.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtnama);
        txtnama.setBounds(490, 130, 165, 36);

        txtjumlah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtjumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtjumlahKeyTyped(evt);
            }
        });
        jPanel1.add(txtjumlah);
        txtjumlah.setBounds(780, 80, 205, 36);
        jPanel1.add(dctanggal);
        dctanggal.setBounds(490, 180, 165, 36);

        Simpan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diskette.png"))); // NOI18N
        Simpan.setText("Simpan");
        Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanActionPerformed(evt);
            }
        });
        jPanel1.add(Simpan);
        Simpan.setBounds(680, 230, 110, 42);

        Edit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit.png"))); // NOI18N
        Edit.setText("Edit");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });
        jPanel1.add(Edit);
        Edit.setBounds(430, 230, 100, 42);

        Delete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        Delete.setText("Hapus");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(Delete);
        Delete.setBounds(550, 230, 110, 42);

        Search.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        Search.setText("Cari");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        jPanel1.add(Search);
        Search.setBounds(950, 230, 90, 42);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("TANGGAL");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(430, 190, 56, 15);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("NIS");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(430, 90, 21, 15);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("BAYAR");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(720, 90, 42, 15);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("NAMA");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(430, 140, 37, 15);

        Tabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabel);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(430, 280, 610, 330);

        Menu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/left-arrow.png"))); // NOI18N
        Menu.setText("Kembali");
        Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuActionPerformed(evt);
            }
        });
        jPanel1.add(Menu);
        Menu.setBounds(1226, 11, 120, 41);

        Clear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cleaning.png"))); // NOI18N
        Clear.setText("Bersihkan");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        jPanel1.add(Clear);
        Clear.setBounds(810, 230, 130, 41);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("STATUS");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(720, 140, 47, 15);

        cbstatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Lunas", "Belum Lunas" }));
        cbstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbstatusActionPerformed(evt);
            }
        });
        jPanel1.add(cbstatus);
        cbstatus.setBounds(780, 130, 122, 36);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/888.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1400, 1000);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        hapus();
    }//GEN-LAST:event_ClearActionPerformed

    private void MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuActionPerformed
        new MenuUtama().setVisible(true);
        dispose();
    }//GEN-LAST:event_MenuActionPerformed

    private void TabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelMouseClicked
        Tampil();
    }//GEN-LAST:event_TabelMouseClicked

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
      try {
        String keyword = txtnis.getText(); 
        String query = "SELECT * FROM uangka WHERE NIS=?";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbsiswa", "root", "");
                PreparedStatement st = con.prepareStatement(query)) {
            st.setString(1, keyword);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    txtnis.setText(rs.getString("NIS"));
                    txtnama.setText(rs.getString("Nama"));
                    txtjumlah.setText(rs.getString("Jumlah"));
                    java.util.Date tanggal = rs.getDate("Tanggal");
                    if (tanggal != null) {
                        dctanggal.setDate(tanggal);
                    } else {
                        dctanggal.setDate(null);
                    }
                    String status = rs.getString("Status");
                    if (status != null) {
                        cbstatus.setSelectedItem(status);
                    } else {
                        cbstatus.setSelectedIndex(0);
                    }
                    JOptionPane.showMessageDialog(rootPane, "Data berhasil ditemukan");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Data tidak ditemukan");
                    hapus();
                }
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage(), "Gagal", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_SearchActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
         int selectedRow = Tabel.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int response1 = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (response1 == JOptionPane.YES_OPTION) {
        try {
            String dbname = "jdbc:mysql://localhost:3306/dbsiswa";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbname, "root", "");
            Statement statement = con.createStatement();
            
            String NIS = tblMode1.getValueAt(selectedRow, 0).toString();
            
            String sql = "DELETE FROM uangka WHERE NIS = '" + NIS + "'";
            
            statement.executeUpdate(sql);
            
            statement.close();
            
            tblMode1.removeRow(selectedRow);
            
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, "Gagal", JOptionPane.WARNING_MESSAGE);
        }
    }
    }//GEN-LAST:event_DeleteActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
      int selectedRow = Tabel.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris yang ingin diubah", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int response1 = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin mengubah data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (response1 == JOptionPane.YES_OPTION) {
        String NIS = txtnis.getText();
        String Nama = txtnama.getText();
        String Jumlah = txtjumlah.getText();
        Date tanggal = dctanggal.getDate();

        if (tanggal == null || Jumlah.isEmpty()) {
            JOptionPane.showMessageDialog(this, "LENGKAPI DATA", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String tanggalstr = dateFormat.format(tanggal);
        String statusItem = (String) cbstatus.getSelectedItem();

        tblMode1.setValueAt(NIS, selectedRow, 0);
        tblMode1.setValueAt(Nama, selectedRow, 1);
        tblMode1.setValueAt(Jumlah, selectedRow, 3);
        tblMode1.setValueAt(tanggalstr, selectedRow, 2);
        tblMode1.setValueAt(statusItem, selectedRow, 4); 

        int jumlahBayar = Integer.parseInt(Jumlah);
        if (jumlahBayar < 500) {
            JOptionPane.showMessageDialog(this, "Minimal Harus Bayar 500 Perminggu", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (jumlahBayar > 12000) {
            JOptionPane.showMessageDialog(this, "Maksimal Harus Bayar 12000 Perminggu", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (NIS.isEmpty() || Nama.isEmpty() || tanggalstr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "LENGKAPI DATA", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            try {
                String dbname = "jdbc:mysql://localhost:3306/dbsiswa";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(dbname, "root", "");
                Statement statement = con.createStatement();
                String updatedNIS = tblMode1.getValueAt(selectedRow, 0).toString();
                String updatedNama = tblMode1.getValueAt(selectedRow, 1).toString();
                String updatedTanggal = tblMode1.getValueAt(selectedRow, 2).toString();
                String updatedJumlah = tblMode1.getValueAt(selectedRow, 3).toString();
                String updatedStatus = tblMode1.getValueAt(selectedRow, 4).toString(); // Ambil nilai combo box yang sudah diset
                String sql = "UPDATE uangka SET NIS='" + updatedNIS + "', Nama='" + updatedNama + "', Tanggal='" + updatedTanggal + "', Jumlah='" + updatedJumlah + "', Status='" + updatedStatus + "' WHERE NIS ='" + updatedNIS + "'";

                statement.executeUpdate(sql);
                statement.close();
                hapus();
                JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Error: " + e2.getMessage(), "Gagal", JOptionPane.WARNING_MESSAGE);
                hapus();
                tampildata();
            }
        }
    }
    }//GEN-LAST:event_EditActionPerformed

    private void SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanActionPerformed
    String statusItem = (String) cbstatus.getSelectedItem(); 

    Date tanggal = dctanggal.getDate();
    SimpleDateFormat formattanggal = new SimpleDateFormat("yyyy-MM-dd");
    String NIS = txtnis.getText();
    if (nisSudahAda(NIS)) {
        JOptionPane.showMessageDialog(this, "NIS Sudah Terdata, Gunakan Nis Yang Berbeda.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }
    String Nama = txtnama.getText();
    String Tanggal = formattanggal.format(tanggal);
    String Jumlah = txtjumlah.getText();

    int jumlahBayar = Integer.parseInt(Jumlah);
    if (jumlahBayar < 500) {
        JOptionPane.showMessageDialog(this, "Minimal Harus Bayar 500 Perminggu", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }
    if (jumlahBayar > 12000) {
        JOptionPane.showMessageDialog(this, "Jumlah bayar maksimum adalah 12000", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (NIS.isEmpty() || Nama.isEmpty() || Tanggal == null || Jumlah.isEmpty() || statusItem.isEmpty()) {
        JOptionPane.showMessageDialog(this, "LENGKAPI DATA", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        String dbname = "jdbc:mysql://localhost:3306/dbsiswa";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(dbname, "root", "");
        Statement statement = con.createStatement();
        String sql = "INSERT INTO uangka (NIS, Nama, Tanggal, Jumlah, Status) VALUES ('" + NIS + "', '" + Nama + "', '" + Tanggal + "', '" + Jumlah + "', '" + statusItem + "')";
        statement.executeUpdate(sql);
        statement.close();
        JOptionPane.showMessageDialog(null, "Data berhasil dimasukkan..", "Insert Data", JOptionPane.INFORMATION_MESSAGE);
        Object[] newData = {NIS, Nama, Tanggal, Jumlah, statusItem};
        tblMode1.addRow(newData);
        
        con.close();

        hapus();
    } catch (Exception e2) {
        JOptionPane.showMessageDialog(null, "Eror:" + e2, "Gagal", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_SimpanActionPerformed

    private void txtjumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjumlahKeyTyped
        char jumlah=evt.getKeyChar();
        if(!(Character.isDigit(jumlah)))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtjumlahKeyTyped

    private void txtnisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnisKeyTyped
        char nis=evt.getKeyChar();
        if(!(Character.isDigit(nis)))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtnisKeyTyped

    private void cbstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbstatusActionPerformed

    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UangKas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UangKas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UangKas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UangKas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UangKas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JButton Menu;
    private javax.swing.JButton Search;
    private javax.swing.JButton Simpan;
    private javax.swing.JTable Tabel;
    private javax.swing.JComboBox<String> cbstatus;
    private com.toedter.calendar.JDateChooser dctanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnis;
    // End of variables declaration//GEN-END:variables

   
}
