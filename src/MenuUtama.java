public class MenuUtama extends javax.swing.JFrame {
 
    public MenuUtama() {
        initComponents();
    }

    MenuUtama(String username) {
    }
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Logout = new javax.swing.JButton();
        UangKas = new javax.swing.JButton();
        Siswa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 1000));
        jPanel1.setLayout(null);

        Logout.setBackground(new java.awt.Color(51, 255, 255));
        Logout.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout.png"))); // NOI18N
        Logout.setText("Keluar");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        jPanel1.add(Logout);
        Logout.setBounds(1244, 11, 110, 41);

        UangKas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        UangKas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contract.png"))); // NOI18N
        UangKas.setText("Uang  Kas");
        UangKas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UangKasActionPerformed(evt);
            }
        });
        jPanel1.add(UangKas);
        UangKas.setBounds(590, 360, 220, 46);

        Siswa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Siswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/study.png"))); // NOI18N
        Siswa.setText("Siswa");
        Siswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiswaActionPerformed(evt);
            }
        });
        jPanel1.add(Siswa);
        Siswa.setBounds(590, 220, 220, 46);

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36)); // NOI18N
        jLabel1.setText("Menu Utama");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(580, 80, 300, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/88.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 1400, 1000);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        new Login().setVisible(true);
        dispose();
        javax.swing.JOptionPane.showMessageDialog(null, "Anda Berhasil Logout");
    }//GEN-LAST:event_LogoutActionPerformed

    private void UangKasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UangKasActionPerformed
         new UangKas().setVisible(true);
         dispose();
    }//GEN-LAST:event_UangKasActionPerformed

    private void SiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiswaActionPerformed
          new Siswa().setVisible(true);
        dispose();
    }//GEN-LAST:event_SiswaActionPerformed

    public static void main(String args[]) {
       
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JButton Siswa;
    private javax.swing.JButton UangKas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
