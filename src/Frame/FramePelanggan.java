
package Frame;

import controller.Controller_pelanggan;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.table.DefaultTableModel;
import model.Pelanggan;
import model.*;


public class FramePelanggan extends javax.swing.JFrame {

    Controller_pelanggan  controller_pelanggan;
    private ArrayList<Pelanggan> arrPelanggan;
   

    public FramePelanggan() throws SQLException {
        initComponents();
        this.controller_pelanggan = new Controller_pelanggan();
        this.arrPelanggan = new ArrayList<>();
        this.setTabelModel();
  
                
    }
    
     public void setTabelModel() throws SQLException {
        this.tblPelanggan.setModel(this.controller_pelanggan.viewTabel());
    }
     
     
      public void kosong() {
        this.jfIdPelanggan.setText("");
        this.jfNamapelanggan.setText("");
        this.jfAlamat.setText("");
        this.jfNohp.setText("");
    }

  

    private boolean cekSemuaTextKosong() {
        boolean textKosong = false;
        if (this.jfIdPelanggan.getText().isEmpty()
                || this.jfNamapelanggan.getText().isEmpty()
                || this.jfAlamat.getText().isEmpty()
                || this.jfNohp.getText().isEmpty()) {
            textKosong = true;
        }
        return textKosong;
    }
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jfNamapelanggan = new javax.swing.JTextField();
        jfAlamat = new javax.swing.JTextField();
        jfNohp = new javax.swing.JTextField();
        jfIdPelanggan = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPelanggan = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id Pelangan");

        jLabel2.setText("Nama Pelanggan");

        jLabel3.setText("Alamat");

        jLabel4.setText("No Hp ");

        jfNamapelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfNamapelangganActionPerformed(evt);
            }
        });

        jfAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfAlamatActionPerformed(evt);
            }
        });

        jfNohp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfNohpActionPerformed(evt);
            }
        });

        jfIdPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfIdPelangganActionPerformed(evt);
            }
        });

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        tblPelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPelangganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPelanggan);

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 1, 36)); // NOI18N
        jLabel5.setText("Tabel Pelanggan");

        jButton1.setText("Keluar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(128, 128, 128))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(30, 30, 30)
                                .addComponent(btnUpdate)
                                .addGap(30, 30, 30)
                                .addComponent(btnDelete))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jfNohp, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(jfAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(jfIdPelanggan)
                                    .addComponent(jfNamapelanggan))))
                        .addGap(77, 77, 77)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jfIdPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jfNamapelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jfAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jfNohp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsert)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jButton1)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jfIdPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfIdPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jfIdPelangganActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
      if (cekSemuaTextKosong()) {
            JOptionPane.showMessageDialog(null, "Isi Semua Kolom Terlebih Dahulu",
                    "Gagal Insert", WARNING_MESSAGE);
        } else {
            try {
                int konfirmasi = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Untuk Input Pelanggan?",
                        "Konfirmasi", OK_CANCEL_OPTION, QUESTION_MESSAGE);
                if (konfirmasi == 0) {
                    int id_pelanggan = Integer.parseInt(this.jfIdPelanggan.getText());
                    String nama_pelanggan = this.jfNamapelanggan.getText();
                    String alamat = this.jfAlamat.getText();
                    int no_hp = Integer.parseInt(this.jfNohp.getText());
                    this.controller_pelanggan.insertplg(id_pelanggan, nama_pelanggan, alamat, no_hp);
                }
                this.setTabelModel();
                this.kosong();
                JOptionPane.showMessageDialog(null, "Input Data Pelanggan Berhasil ");
            } catch (SQLException ex) {
                Logger.getLogger(FramePelanggan.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
                                          
    }//GEN-LAST:event_btnInsertActionPerformed

    private void jfNamapelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfNamapelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jfNamapelangganActionPerformed

    private void jfAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jfAlamatActionPerformed

    private void jfNohpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfNohpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jfNohpActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    setVisible(false);     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
               if (cekSemuaTextKosong()) {
            JOptionPane.showMessageDialog(null, "Pilih Baris Data Terlebih Dahulu",
                    "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                int konfirmasi = JOptionPane.showConfirmDialog(null, "Data Akan Diupdate?",
                        "Konfirmasi", OK_CANCEL_OPTION, QUESTION_MESSAGE);
                if (konfirmasi == 0) {
     
                    if ("".equals(jfIdPelanggan.getText()) || "".equals(jfNamapelanggan.getText()) || "".equals(jfAlamat.getText()) || "".equals(jfNohp.getText())) {
                        JOptionPane.showMessageDialog(this, "Harap Lengkapi Data", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                    int id_pelanggan = Integer.parseInt(this.jfIdPelanggan.getText());
                    String nama_pelanggan = this.jfNamapelanggan.getText();
                    String alamat = this.jfAlamat.getText();
                    int no_hp = Integer.parseInt(this.jfNohp.getText());
                    this.controller_pelanggan.updateplg(id_pelanggan, nama_pelanggan, alamat, no_hp);

                    this.setTabelModel();
                    this.kosong();
                    JOptionPane.showMessageDialog(this, "Data Berhasil Diupdate", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Data Gagal Diupdate", "Gagal", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(FramePelanggan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPelangganMouseClicked
        int baris = tblPelanggan.getSelectedRow();
        this.jfIdPelanggan.setText(tblPelanggan.getValueAt(baris, 0).toString());
        this.jfNamapelanggan.setText(tblPelanggan.getValueAt(baris, 1).toString());
        this.jfAlamat.setText(tblPelanggan.getValueAt(baris, 2).toString());
        this.jfNohp.setText(tblPelanggan.getValueAt(baris, 3).toString());
    }//GEN-LAST:event_tblPelangganMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
 if (cekSemuaTextKosong()) {
            JOptionPane.showMessageDialog(null, "Pilih Baris Data Terlebih Dahulu",
                    "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                int konfirmasi = JOptionPane.showConfirmDialog(null, "Data Akan Dihapus?",
                        "Konfirmasi", OK_CANCEL_OPTION, QUESTION_MESSAGE);
                if (konfirmasi == 0) {
                    int baris = tblPelanggan.getSelectedRow();
                    int id_pelanggan = Integer.parseInt(tblPelanggan.getValueAt(baris, 0).toString());
                    this.controller_pelanggan.deleteplg(id_pelanggan);

                    this.setTabelModel();
                    this.kosong();
                    JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, "Data Gagal Dihapus", "Gagal", JOptionPane.WARNING_MESSAGE);
                }

            } catch (SQLException ex) {
                Logger.getLogger(FramePelanggan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(FramePelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                try {
                    new FramePelanggan().setVisible(true);
                } catch (SQLException ex) {
                    
                }
            }
        });
        /* Create and display the form */
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jfAlamat;
    private javax.swing.JTextField jfIdPelanggan;
    private javax.swing.JTextField jfNamapelanggan;
    private javax.swing.JTextField jfNohp;
    private javax.swing.JTable tblPelanggan;
    // End of variables declaration//GEN-END:variables
}
