
package model;

import java.util.ArrayList;


public class Jenis_cucian {
    private Integer Id_jenis_cucian;
    private String Jenis_cucian;
    private Integer Harga_perkilo;   
     private ArrayList<Jenis_cucian>arrJeniscucian;
    
     public Integer getId_jenis_cucian(){
        return Id_jenis_cucian;
    }
    public void setId_jenis_cucian(Integer Id_jenis_cucian){
        this.Id_jenis_cucian=Id_jenis_cucian;
    }
    
    public String getJenis_cucian(){
        return Jenis_cucian;
    }
    public void setJenis_cucian(String Jenis_cucian){
        this.Jenis_cucian=Jenis_cucian;
    }
    
    public Integer getHargaperkilo(){
        return Harga_perkilo;
    }
    public void setHargaperkilo(Integer Harga_perkilo){
        this.Harga_perkilo=Harga_perkilo;
    }
}
