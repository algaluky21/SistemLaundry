
package model;
import java.util.ArrayList;
import java.util.Date;


public class Transaksi {
    private Integer Id_Transaksi;
    private Pelanggan pelanggan;
    private Jenis_cucian jenis_cucian;
    private Date Tanggal_transaksi;
    private Integer Total_harga;
    private Integer Berat_cucian;
    private Integer Bayar;
    private Integer Kembali;
    private ArrayList<Transaksi>arrTransaksi;
    
    public Integer getId_Transaksi(){
        return Id_Transaksi;
    }
    public void setId_Transaksi(Integer Id_Transaksi){
        this.Id_Transaksi=Id_Transaksi;
    }
    public Pelanggan getpelanggan(){
        return pelanggan;
    }
    public void setpelanggan(Pelanggan pelanggan){
        this.pelanggan=pelanggan;
    }
    public Jenis_cucian getjeniscucian(){
        return jenis_cucian;
    }
    public void setjeniscucian(Jenis_cucian jenis_cucian){
        this.jenis_cucian=jenis_cucian;
    }
    public Date getTanggal_Transaksi(){
        return Tanggal_transaksi;
    }
    public void setTanggal_Transaksi(Date Tanggal_transaksi){
        this.Tanggal_transaksi=Tanggal_transaksi;
    }
  
     public Integer getBerat_cucian(){
        return Berat_cucian;
    }
    public void setBerat_cucian(Integer Berat_cucian){
        this.Berat_cucian=Berat_cucian;
    }
    
    public Integer getTotal_harga(){
        return Total_harga;
    }
    public void setTotal_harga(Integer Total_harga){
        this.Total_harga=Total_harga;
    }
    
     public Integer getBayar(){
        return Bayar;
    }
    public void setBayar(Integer Bayar){
        this.Bayar=Bayar;
    }
    
     public Integer getKembali(){
        return Kembali;
    }
    public void setKembali(Integer Kembali){
        this.Kembali=Kembali;
    }
    
    public void setarrTransaksi(ArrayList<Transaksi>arrTransaksi){
        this.arrTransaksi=arrTransaksi;
    }
    public ArrayList<Transaksi>getarrTransaksi(){
        return arrTransaksi;
    }
}




