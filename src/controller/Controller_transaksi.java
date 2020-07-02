

package controller;

import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Jenis_cucian;
import model.Pelanggan;
import model.Transaksi;


public class Controller_transaksi {
    Koneksi koneksi;
    ArrayList<Jenis_cucian> arrJenscucian;
    ArrayList<Pelanggan> arrPelanggan;
    ArrayList<Transaksi> arrTransaksi;

    
     public Controller_transaksi() throws SQLException {
        this.koneksi = new Koneksi();
        this.arrJenscucian = new ArrayList<>();
        this.arrPelanggan = new ArrayList<>();
        this.arrTransaksi = new ArrayList<>();
    }
    
      public ArrayList<Transaksi> getDataTransaksi() throws SQLException {
        this.arrTransaksi.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM T_TRANSAKSI JOIN T_JENIS_CUCIAN ON T_TRANSAKSI.ID_JENIS_CUCIAN = T_JENIS_CUCIAN.ID_JENIS_CUCIAN JOIN T_PELANGGAN ON T_TRANSAKSI.ID_PELANGGAN = T_PELANGGAN.ID_PELANGGAN");
        while (rs.next()) {
            Jenis_cucian J = new Jenis_cucian();
            J.setId_jenis_cucian(rs.getInt("ID_JENIS_CUCIAN"));
            J.setJenis_cucian(rs.getString("JENIS_CUCIAN"));
            J.setHargaperkilo(rs.getInt("HARGA_PERKILO"));
            
            Pelanggan P = new Pelanggan();
            P.setId_Pelanggan(rs.getInt("ID_PELANGGAN"));
            P.setNama_Pelanggan(rs.getString("NAMA_PELANGGAN"));
            P.setAlamat(rs.getString("ALAMAT"));
            P.setNo_Hp(rs.getInt("NO_HP"));
            
            Transaksi t = new Transaksi();
            t.setId_Transaksi(rs.getInt("ID_TRANSAKSI"));
            t.setpelanggan(P);
            t.setjeniscucian(J);
            t.setTanggal_Transaksi(new Date(rs.getString("TGL_TRANSAKSI")));
            t.setBerat_cucian(rs.getInt("BERAT_CUCIAN")) ;
            t.setTotal_harga(rs.getInt("TOTAL_HARGA")) ;
            t.setBayar(rs.getInt("BAYAR")) ;
            t.setKembali(rs.getInt("KEMBALI")) ;
            
                      this.arrTransaksi .add(t);
        }
        return this.arrTransaksi;
    }
     
     public void insertTransaksi(Transaksi transaksi) {
       try{                                                                                                                                                                                                                                                                                                                                                                                                           
            String datetransaksi = new SimpleDateFormat("dd/MM/yyyy").format(transaksi.getTanggal_Transaksi());
            
            koneksi.ManipulasiData("INSERT INTO T_TRANSAKSI VALUES (ID_TRANSAKSI.NEXTVAL, "
                    + transaksi.getpelanggan().getId_Pelanggan()+"," 
                    + transaksi.getjeniscucian().getId_jenis_cucian() 
                    +" , TO_DATE('" +datetransaksi+ "','DD/MM/YYYY')," 
                    +transaksi.getBerat_cucian()+ ","
                    +transaksi.getTotal_harga()+ "," 
                    +transaksi.getBayar()+ ","
                    + transaksi.getKembali()+ ")");
            ResultSet rs = koneksi.GetData("SELECT ID_TRANSAKSI.CURRVAL FROM DUAL");
            
            System.out.println(rs);
            rs.next();
            int id_transaksi = rs.getInt("CURRVAL");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    }
     
     
     

