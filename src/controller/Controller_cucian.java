
package controller;

import model.Jenis_cucian;
import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import model.Pelanggan;


public class Controller_cucian {
    
    Koneksi koneksi;
    ArrayList<Jenis_cucian> arrJeniscucian;
    
     public Controller_cucian() throws SQLException {
        this.koneksi = new Koneksi();
        this.arrJeniscucian = new ArrayList<>();

    }
     
     public ArrayList<Jenis_cucian> getDataCucian() throws SQLException {
        this.arrJeniscucian.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM T_JENIS_CUCIAN");
        while (rs.next()) {
            Jenis_cucian j = new Jenis_cucian();
            j.setId_jenis_cucian(rs.getInt("ID_JENIS_CUCIAN"));
            j.setJenis_cucian(rs.getString("JENIS_CUCIAN"));
            j.setHargaperkilo(rs.getInt("HARGA_PERKILO"));
            this.arrJeniscucian.add(j);
        }
        return this.arrJeniscucian;
    }

     public void insertccn(int id_jenis_cucian, String jenis_cucian , int harga_perkilo) {
        String kodeSql = "INSERT INTO T_JENIS_CUCIAN (id_jenis_cucian,jenis_cucian, harga_perkilo) VALUES ("
                + id_jenis_cucian + ", '" + jenis_cucian + "', '"  + harga_perkilo + "')";
        this.koneksi.ManipulasiData(kodeSql);
    }
    
        public void deleteccn(int id_jenis_cucian) {
        String kodeSql = "DELETE FROM T_JENIS_CUCIAN WHERE id_jenis_cucian = " + id_jenis_cucian;
        this.koneksi.ManipulasiData(kodeSql);
    }

    public void updateccn(int id_jenis_cucian, String jenis_cucian , int harga_perkilo) {
        String kodeSql =  "UPDATE T_JENIS_CUCIAN SET " 
                + "id_jenis_cucian = '" + id_jenis_cucian +"', "
                + "jenis_cucian = '" + jenis_cucian +"', "
                + "harga_perkilo = '" + harga_perkilo +"'"
                +"WHERE id_jenis_cucian = " + id_jenis_cucian;
        this.koneksi.ManipulasiData(kodeSql);
    }
    
    
    public DefaultTableModel viewTabel() throws SQLException {
       DefaultTableModel dtmJeniscucian = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtmJeniscucian.addColumn("ID Jenis Cucian");
        dtmJeniscucian.addColumn("Jenis Cucian");
        dtmJeniscucian.addColumn("Harga Perkilo");
        

        String kodeSql = "SELECT * FROM T_JENIS_CUCIAN ORDER BY Id_JENIS_CUCIAN ASC";
        ResultSet hasilKodeSql = this.koneksi.GetData(kodeSql);
        while (hasilKodeSql.next()) {
            int id_jenis_cucian = hasilKodeSql.getInt("ID_JENIS_CUCIAN");
            String jenis_cucian = hasilKodeSql.getString("JENIS_CUCIAN");
            int harga_perkilo = hasilKodeSql.getInt("HARGA_PERKILO");

            Jenis_cucian ccn = new Jenis_cucian();
            ccn.setId_jenis_cucian(id_jenis_cucian);
            ccn.setJenis_cucian(jenis_cucian);
            ccn.setHargaperkilo(harga_perkilo);
            Object[] temp = new Object[3];
            temp[0] = ccn.getId_jenis_cucian();
            temp[1] = ccn.getJenis_cucian();
            temp[2] = ccn.getHargaperkilo();
            dtmJeniscucian.addRow(temp);
        }
        return dtmJeniscucian;
    }
     
     
}
