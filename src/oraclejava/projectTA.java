package oraclejava;

import Frame.FrameJenis_cucian;
import Frame.FrameLogin;
import Frame.FramePelanggan;
import Frame.FrameTransaksi;
import database.Koneksi;
import java.sql.SQLException;

public class projectTA {

    public static void main(String[] args) throws SQLException  {
           new FrameLogin().show();
            
    }

}
