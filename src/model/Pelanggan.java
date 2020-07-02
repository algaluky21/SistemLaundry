
package model;

import java.util.ArrayList;
import java.util.Date;


public class Pelanggan {
    private Integer Id_Pelanggan;
    private String Nama_Pelanggan;
    private String Alamat;
    private Integer No_Hp;
    private ArrayList<Pelanggan>arrPelanggan;
    
    
     public Integer getId_Pelanggan(){
        return Id_Pelanggan;
    }
    public void setId_Pelanggan(Integer Id_Pelanggan){
        this.Id_Pelanggan=Id_Pelanggan;
    }
    
    public String getNama_Pelanggan(){
        return Nama_Pelanggan;
    }
    public void setNama_Pelanggan(String Nama_Pelanggan){
        this.Nama_Pelanggan=Nama_Pelanggan;
    }
    
    public String getAlamat(){
        return Alamat;
    }
    public void setAlamat(String Alamat){
        this.Alamat=Alamat;
    }
    
    public Integer getNo_Hp(){
        return No_Hp;
    }
    public void setNo_Hp(Integer No_Hp){
        this.No_Hp=No_Hp;
    }
}
