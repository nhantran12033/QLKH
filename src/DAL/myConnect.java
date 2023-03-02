/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kiera
 */
public class myConnect {

    public myConnect() {
    }

    static Connection con;
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/qlkh";
    static String uname = "root";
    static String pass = "";

    public static Connection getConnection() {
        if (con == null) {
            try {
                // 1. Load Driver
                Class.forName(driver);
                // 2. Open connection
                con = DriverManager.getConnection(url, uname, pass);
                

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(myConnect.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Không kết nối được với kho dữ liệu!!!");
            }
        }
        return con;
    }
}
