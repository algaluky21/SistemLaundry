
package Frame;

import controller.Controller_cucian;
import controller.Controller_pelanggan;
import controller.Controller_transaksi;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Jenis_cucian;
import model.Pelanggan;
import model.Transaksi;


public class FrameTransaksi extends javax.swing.JFrame {
    Controller_pelanggan  controller_pelanggan;
    Controller_cucian controller_cucian;
    Controller_transaksi controller_transaksi;
    Transaksi transaksi;
    
    private ArrayList<Transaksi> arrTransaksi;
    private Integer total_harga;
    private Integer Kembali;
    
    public FrameTransaksi  () throws SQLException {
        initComponents();
        controller_cucian = new Controller_cucian();
        controller_pelanggan = new Controller_pelanggan();
        controller_transaksi = new Controller_transaksi();
        this.arrTransaksi = new ArrayList<>();
        this.total_harga = 0;
        this.Kembali= 0;
        tfTotal.disable();
        tfKembali.disable();
        this.showTotalharga();
        this.showKembali();
        this.showComboBoxPelanggan();
        this.showComboBoxJeniscucian();
        this.showTableTransaksi();
        
    }

    private void showComboBoxPelanggan() throws SQLException {
        DefaultComboBoxModel dcbmPelanggan = new DefaultComboBoxModel();

        for (Pelanggan p : this.controller_pelanggan.getDataPelanggan()) {
            dcbmPelanggan.addElement(p.getNama_Pelanggan());
        }
        this.cbPelanggan.setModel(dcbmPelanggan);
    }

    private void showComboBoxJeniscucian() throws SQLException {
        DefaultComboBoxModel dcbmCucian = new DefaultComboBoxModel();

        for (Jenis_cucian p : this.controller_cucian.getDataCucian()) {
            dcbmCucian.addElement(p.getJenis_cucian());
        }
        this.cbJeniscucian.setModel(dcbmCucian);
    }
    
    public void showTotalharga(){
        tfTotal.setText(total_harga.toString());
    }
    public void showKembali(){
        tfKembali.setText(Kembali.toString());
    }
    

    
      private void showTableTransaksi() throws SQLException {
        DefaultTableModel dtmTransaksi = new DefaultTableModel(new String[]{
            "Pelanggan", "Jenis cucian", "Tgl_Transaksi","Berat Cucian", "Total Harga"
        }, 0);
        dtmTransaksi.setRowCount(0);

        for (Transaksi p : this.controller_transaksi.getDataTransaksi()) {
            dtmTransaksi.addRow(new String[]{
                p.getpelanggan().getNama_Pelanggan(),
                p.getjeniscucian().getJenis_cucian(),
                p.getTanggal_Transaksi().toString(),
                p.getBerat_cucian().toString(), 
                p.getTotal_harga().toString()
            });
        }
        this.tblTransaksi.setModel(dtmTransaksi);
    }
      

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbPelanggan = new javax.swing.JComboBox<>();
        cbJeniscucian = new javax.swing.JComboBox<>();
        jfTgl = new javax.swing.JTextField();
        jfBerat = new javax.swing.JTextField();
        jfBayar = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        tfTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfKembali = new javax.swing.JTextField();
        btnTotal = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        btnDetail = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDetailPesanan = new javax.swing.JTextArea();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Pelanggan");

        jLabel2.setText("Jenis Cucian");

        jLabel3.setText("Tgl Transaksi");

        jLabel5.setText("Berat Cucian");

        jLabel6.setText("Bayar");

        cbPelanggan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbJeniscucian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jfBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfBayarActionPerformed(evt);
            }
        });

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        tblTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTransaksi);

        jLabel7.setText("Total Harga");

        tfTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTotalActionPerformed(evt);
            }
        });

        jLabel8.setText("Kembali ");

        tfKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfKembaliActionPerformed(evt);
            }
        });

        btnTotal.setText("Total Harga");
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Bright", 1, 36)); // NOI18N
        jLabel9.setText("Tabel Transaksi");

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnKembali.setText("Keluar");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        btnDetail.setText("Detail");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        taDetailPesanan.setColumns(20);
        taDetailPesanan.setRows(5);
        jScrollPane2.setViewportView(taDetailPesanan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel5))
                                            .addGap(57, 57, 57)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cbPelanggan, 0, 139, Short.MAX_VALUE)
                                                .addComponent(cbJeniscucian, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jfTgl)
                                                .addComponent(jfBerat)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(67, 67, 67)
                                            .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8))
                                        .addGap(54, 54, 54)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jfBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnTambah)
                                    .addComponent(btnClear)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnKembali)))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))
                        .addContainerGap(66, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(166, 166, 166))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnDetail)
                                .addGap(281, 281, 281))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDetail)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(68, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jfBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbJeniscucian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTambah))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jfTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(tfKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jfBerat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnClear)))
                        .addGap(17, 17, 17)
                        .addComponent(btnTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKembali)
                        .addGap(95, 95, 95))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
   Transaksi transaksi = new Transaksi();
        try {
            transaksi.setpelanggan(this.controller_pelanggan.getDataPelanggan().get(this.cbPelanggan.getSelectedIndex()));
            transaksi.setjeniscucian(this.controller_cucian.getDataCucian().get(this.cbJeniscucian.getSelectedIndex()));
            transaksi.setTanggal_Transaksi(new SimpleDateFormat("dd/MM/yyyy").parse(this.jfTgl.getText()));
            transaksi.setBerat_cucian(Integer.parseInt(jfBerat.getText()));
            total_harga += controller_cucian.getDataCucian().get(cbJeniscucian.getSelectedIndex()).getHargaperkilo()* Integer.parseInt(jfBerat.getText());
   
            transaksi.setTotal_harga(total_harga);
            transaksi.setBayar(Integer.parseInt(jfBayar.getText()));
            Kembali = Integer.parseInt(jfBayar.getText()) - Integer.parseInt(tfTotal.getText());
            
            transaksi.setKembali(Kembali);
            this.controller_transaksi.insertTransaksi(transaksi);  
            this.showTableTransaksi();
            showTotalharga();
            showKembali();
            total_harga=0;
            Kembali =0;
                 
        } catch (SQLException | ParseException err) {
            System.out.println(err);
        } 
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
     Transaksi transaksi = new Transaksi();
        try {
            transaksi.setpelanggan(this.controller_pelanggan.getDataPelanggan().get(this.cbPelanggan.getSelectedIndex()));
            transaksi.setjeniscucian(this.controller_cucian.getDataCucian().get(this.cbJeniscucian.getSelectedIndex()));
            transaksi.setTanggal_Transaksi(new SimpleDateFormat("dd/MM/yyyy").parse(this.jfTgl.getText()));
            transaksi.setBerat_cucian(Integer.parseInt(jfBerat.getText()));
            
            total_harga += controller_cucian.getDataCucian().get(cbJeniscucian.getSelectedIndex()).getHargaperkilo()* Integer.parseInt(jfBerat.getText());
            transaksi.setTotal_harga(total_harga);
            
           
            this.showTotalharga();
             total_harga=0;
      
        } catch (SQLException | ParseException err) {
            System.out.println(err);
        } 
    }//GEN-LAST:event_btnTotalActionPerformed

    private void tfTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTotalActionPerformed

    private void jfBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jfBayarActionPerformed

    private void tfKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfKembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfKembaliActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        this.jfBerat.setText("");
        this.jfTgl.setText("");
        this.jfBayar.setText("");
        showTotalharga();
        showKembali();
        total_harga=0;
        Kembali =0;
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
                try{
         Transaksi transaksi = this.controller_transaksi.getDataTransaksi().get(this.tblTransaksi.getSelectedRow());
            String teks = "" + "===========================PELANGGAN==========================" + "\n"
                    + "Nama Pelanggan : " + transaksi.getpelanggan().getNama_Pelanggan()+ "\n"
                    + "Alamat : " + transaksi.getpelanggan().getAlamat() + "\n"
                    + "No Telp : " + transaksi.getpelanggan().getNo_Hp()+ "\n"
                    + "===========================JENIS CUCIAN========================" + "\n"
                    + "Jenis Cucian : " + transaksi.getjeniscucian().getJenis_cucian()+ "\n"
                    + "Harga Perkilo :" + transaksi.getjeniscucian().getHargaperkilo()+ "\n"
                    + "===========================TRANSAKSI==========================" + "\n"
                    + "Tanggal Transaksi : " + new SimpleDateFormat("dd/MM/yyyy").format(transaksi.getTanggal_Transaksi()) + "\n"
                    + "Berat Cucian : " + transaksi.getBerat_cucian()+ "\n"
                    + "Total Harga : " + transaksi.getTotal_harga()+ "\n"
                    + "Bayar : " + transaksi.getBayar()+ "\n"
                    + "Kembali : " + transaksi.getKembali()+ "\n";
                 this.taDetailPesanan.setText(teks);
     
        }catch(SQLException re){
            
        }
    }//GEN-LAST:event_btnDetailActionPerformed


    public static void main(String args[]) {
       
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
            java.util.logging.Logger.getLogger(FrameTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                try {
                    new FrameTransaksi().setVisible(true);
                } catch (SQLException ex) {
                    
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTotal;
    private javax.swing.JComboBox<String> cbJeniscucian;
    private javax.swing.JComboBox<String> cbPelanggan;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jfBayar;
    private javax.swing.JTextField jfBerat;
    private javax.swing.JTextField jfTgl;
    private javax.swing.JTextArea taDetailPesanan;
    private javax.swing.JTable tblTransaksi;
    private javax.swing.JTextField tfKembali;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
