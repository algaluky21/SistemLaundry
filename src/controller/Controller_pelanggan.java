package controller;


import model.Pelanggan;

import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class Controller_pelanggan {

    Koneksi koneksi;
    ArrayList<Pelanggan> arrPelanggan;

    public Controller_pelanggan() throws SQLException {
        this.koneksi = new Koneksi();
        this.arrPelanggan = new ArrayList<>();


    }

     public ArrayList<Pelanggan> getDataPelanggan() throws SQLException {
        this.arrPelanggan.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM T_PELANGGAN");
        while (rs.next()) {
            Pelanggan p = new Pelanggan();
            p.setId_Pelanggan(rs.getInt("ID_PELANGGAN"));
            p.setNama_Pelanggan(rs.getString("NAMA_PELANGGAN"));
            p.setAlamat(rs.getString("ALAMAT"));
            p.setNo_Hp(rs.getInt("NO_HP"));
            this.arrPelanggan.add(p);
        }
        return this.arrPelanggan;
    }
    
    
     public void insertplg(int id_pelanggan, String nama_pelanggan, String alamat, int no_hp) {
        String kodeSql = "INSERT INTO T_PELANGGAN (id_pelanggan, nama_pelanggan, alamat, no_hp) VALUES ("
                + id_pelanggan + ", '" + nama_pelanggan + "', '" + alamat + "', '" + no_hp + "')";
        this.koneksi.ManipulasiData(kodeSql);
    }
    
        public void deleteplg(int id_pelanggan) {
        String kodeSql = "DELETE FROM T_PELANGGAN WHERE id_pelanggan = " + id_pelanggan;
        this.koneksi.ManipulasiData(kodeSql);
    }

    public void updateplg(int id_pelanggan, String nama_pelanggan, String alamat, int no_hp) {
        String kodeSql = "UPDATE T_PELANGGAN SET " 
                + "id_pelanggan = '" + id_pelanggan + "', "
                + "nama_pelanggan = '" + nama_pelanggan + "', "
                + "alamat = '" + alamat + "', "
                + "no_hp = '" + no_hp + "'"
                + "WHERE id_pelanggan = " + id_pelanggan;
        this.koneksi.ManipulasiData(kodeSql);
    }
    
    
    public DefaultTableModel viewTabel() throws SQLException {
        DefaultTableModel dtmPelanggan = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtmPelanggan.addColumn("ID Pelanggan");
        dtmPelanggan.addColumn("Nama Pelanggan");
        dtmPelanggan.addColumn("Alamat");
        dtmPelanggan.addColumn("NO Hp");

        String kodeSql = "SELECT * FROM T_PELANGGAN ORDER BY Id_pelanggan ASC";
        ResultSet hasilKodeSql = this.koneksi.GetData(kodeSql);
        while (hasilKodeSql.next()) {
            int id_pelanggan = hasilKodeSql.getInt("ID_PELANGGAN");
            String nama_pelanggan = hasilKodeSql.getString("NAMA_PELANGGAN");
            String alamat = hasilKodeSql.getString("ALAMAT");
            int no_hp = hasilKodeSql.getInt("NO_HP");

            Pelanggan plg = new Pelanggan();
            plg.setId_Pelanggan(id_pelanggan);
            plg.setNama_Pelanggan(nama_pelanggan);
            plg.setAlamat(alamat);
            plg.setNo_Hp(no_hp);
            Object[] temp = new Object[4];
            temp[0] = plg.getId_Pelanggan();
            temp[1] = plg.getNama_Pelanggan();
            temp[2] = plg.getAlamat();
            temp[3] = plg.getNo_Hp();
            dtmPelanggan.addRow(temp);
        }
        return dtmPelanggan;
    }
 
}