package com.example.sellingmanagement.SQLServerManagement;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerHelper {
    private static String sql = "jdbc:jtds:sqlserver://192.168.1.17:1433;databasename=QLCU;user=CNPM;password=tranvietkhoa123"; // dia chi ket noi
    public static Connection connectionSQLSever(){
        Connection connection = null;
        try {
            try {
                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build(); // lấy tất cả các quyền
                StrictMode.setThreadPolicy(policy); // thiết lập chính xác kết nối các quyền
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection(sql);
                Log.i("THONG BAO:","Ket noi thanh cong"); // thông báo kết nối thành công
            } catch (Exception e) {
                Log.e("THONGBAO","LOSS"); // thông báo kết nối không thành công
                throw new RuntimeException(e);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
