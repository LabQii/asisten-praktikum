/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tes;

import com.mysql.jdbc.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;
        
/**
 *
 * @author user
 */
public class koneksi {
    
    private static Connection mysqlkonek;
     
    public static Connection koneksiDB() throws SQLException{
         if (mysqlkonek == null){
             try {
                 String DB = "jdbc:mysql://localhost:3306/dbdata";
                 String user = "root";
                 String pw = "";
                 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                 mysqlkonek = (Connection) DriverManager.getConnection(DB, user, pw);
                 JOptionPane.showMessageDialog(null, "Koneksi berhasil");
             
             }catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Koneksi gagal: " + e.getMessage());
             }
         }
         return mysqlkonek;
    }

            
    public static void main(String[] args) {
        try {
            java.sql.Connection connection = koneksiDB();
            if (connection != null) {
                System.out.println("Koneksi BerhasiL.");
                
            }else {
                System.out.println("Koneksi Gagal");
            }
        }catch (Exception e){
            System.out.println("Terjadi kesalahan" + e.getMessage());
        }
    }
    
}
