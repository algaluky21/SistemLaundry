
package Frame;

import controller.Controller_cucian;
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
import model.Jenis_cucian;
import model.*;
public class FrameJenis_cucian extends javax.swing.JFrame {
        
    Controller_cucian controller_cucian;
    private ArrayList<Jenis_cucian> arrJenis_cucian;
    
    public FrameJenis_cucian() throws SQLException {
        initComponents();
        this.controller_cucian = new Controller_cucian();
        this.arrJenis_cucian = new ArrayList<>();
        this.setTabelModel();
    }
    
    
     public void setTabelModel() throws SQLException {
        this.tblJeniscucian.setModel(this.controller_cucian.viewTabel());
    }
     
     
      public void kosong() {
        this.jfIdjenis.setText("");
        this.jfJenis.setText("");
        this.jfHarga.setText("");
    }

  

    private boolean cekSemuaTextKosong() {
        boolean textKosong = false;
        if (this.jfIdjenis.getText().isEmpty()
                || this.jfJenis.getText().isEmpty()
                || this.jfHarga.getText().isEmpty()) {
            textKosong = true;
        }
        return textKosong;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jfIdjenis = new javax.swing.JTextField();
        jfJenis = new javax.swing.JTextField();
        jfHarga = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblJeniscucian = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id Jenis cucian");

        jLabel2.setText("Jenis Cucian");

        jLabel3.setText("Harga Perkilo");

        jfIdjenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfIdjenisActionPerformed(evt);
            }
        });

        tblJeniscucian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tblJeniscucian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblJeniscucianMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblJeniscucian);

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 1, 36)); // NOI18N
        jLabel4.setText("Tabel Jenis Cucian");

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnBack.setText("Keluar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(108, 108, 108))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUpdate)
                                .addGap(26, 26, 26)
                                .addComponent(btnDelete))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jfHarga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                .addComponent(jfJenis, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jfIdjenis, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addContainerGap(781, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jfIdjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jfJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsert)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jfIdjenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfIdjenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jfIdjenisActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
  if (cekSemuaTextKosong()) {
            JOptionPane.showMessageDialog(null, "Pilih Baris Data Terlebih Dahulu",
                    "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                int konfirmasi = JOptionPane.showConfirmDialog(null, "Data Akan Diupdate?",
                        "Konfirmasi", OK_CANCEL_OPTION, QUESTION_MESSAGE);
                if (konfirmasi == 0) {
                    
                    if ("".equals(jfIdjenis.getText()) || "".equals(jfJenis.getText()) || "".equals(jfHarga.getText())) {
                        JOptionPane.showMessageDialog(this, "Harap Lengkapi Data", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                    int id_jenis_cucian = Integer.parseInt(this.jfIdjenis.getText());
                    String jenis_cucian = this.jfJenis.getText();
                    int harga_perkilo = Integer.parseInt(this.jfHarga.getText());
                    this.controller_cucian.updateccn(id_jenis_cucian, jenis_cucian, harga_perkilo);

                    this.setTabelModel();
                    this.kosong();
                    JOptionPane.showMessageDialog(this, "Data Berhasil Diupdate", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Data Gagal Diupdate", "Gagal", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrameJenis_cucian.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
           if (cekSemuaTextKosong()) {
            JOptionPane.showMessageDialog(null, "Isi Semua Kolom Terlebih Dahulu",
                    "Gagal Insert", WARNING_MESSAGE);
        } else {
            try {
                int konfirmasi = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Untuk Input Data Jenis Cucian ?",
                        "Konfirmasi", OK_CANCEL_OPTION, QUESTION_MESSAGE);
                if (konfirmasi == 0) {
                    int id_jenis_cucian = Integer.parseInt(this.jfIdjenis.getText());
                    String jenis_cucian = this.jfJenis.getText();
                    int harga_perkilo = Integer.parseInt(this.jfHarga.getText());
                    this.controller_cucian.insertccn(id_jenis_cucian, jenis_cucian, harga_perkilo);
                
                }
                this.setTabelModel();
                this.kosong();
                JOptionPane.showMessageDialog(null, "Input Data Pelanggan Berhasil ");
            } catch (SQLException ex) {
                Logger.getLogger(FrameJenis_cucian.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (cekSemuaTextKosong()) {
            JOptionPane.showMessageDialog(null, "Pilih Baris Data Terlebih Dahulu",
                    "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                int konfirmasi = JOptionPane.showConfirmDialog(null, "Data Akan Dihapus?",
                        "Konfirmasi", OK_CANCEL_OPTION, QUESTION_MESSAGE);
                if (konfirmasi == 0) {
                    int baris = tblJeniscucian.getSelectedRow();
                    int id_jenis_cucian = Integer.parseInt(tblJeniscucian.getValueAt(baris, 0).toString());
                    this.controller_cucian.deleteccn(id_jenis_cucian);

                    this.setTabelModel();
                    this.kosong();
                    JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, "Data Gagal Dihapus", "Gagal", JOptionPane.WARNING_MESSAGE);
                }

            } catch (SQLException ex) {
                Logger.getLogger(FrameJenis_cucian.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblJeniscucianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJeniscucianMouseClicked
        int baris = tblJeniscucian.getSelectedRow();
        this.jfIdjenis.setText(tblJeniscucian.getValueAt(baris, 0).toString());
        this.jfJenis.setText(tblJeniscucian.getValueAt(baris, 1).toString());
        this.jfHarga.setText(tblJeniscucian.getValueAt(baris, 2).toString());
  
    }//GEN-LAST:event_tblJeniscucianMouseClicked

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
            java.util.logging.Logger.getLogger(FrameJenis_cucian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameJenis_cucian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameJenis_cucian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameJenis_cucian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               try {
                    new FrameJenis_cucian().setVisible(true);
                } catch (SQLException ex) {
                    
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jfHarga;
    private javax.swing.JTextField jfIdjenis;
    private javax.swing.JTextField jfJenis;
    private javax.swing.JTable tblJeniscucian;
    // End of variables declaration//GEN-END:variables
}
