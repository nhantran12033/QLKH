/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;


import static DAL.myConnect.con;
import DTO.OnsiteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nhan
 */
public class OnsiteCourseDAL {
    public boolean Them(OnsiteDTO cr) {
        Connection conn = myConnect.getConnection();
        String sql = "INSERT INTO onsitecourse(CourseID,Location,Days,Time) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cr.getCourseID());
            ps.setString(2, cr.getLocation());
            ps.setString(3, cr.getDays());
            ps.setString(4, cr.getTime());
            
            ps.executeUpdate();
           
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Không được để trùng ID");

        }
        return false;
    }


    public boolean ChinhSua(OnsiteDTO cr) {
        Connection con = myConnect.getConnection();
        String sql = "update onsitecourse set Location=?,Days=?,Time=? where CourseID=? ";
        PreparedStatement ps;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cr.getLocation());
            ps.setString(2, cr.getDays());
           ps.setString(3, cr.getTime());
           ps.setString(4, cr.getCourseID());
            ps.executeUpdate();
         
            return true;
        } catch (SQLException e) {
            
        }
        return false;
    }

 
    public List<OnsiteDTO> listonl() {
        List<OnsiteDTO> list = new ArrayList<OnsiteDTO>();
        try {
            Connection con = myConnect.getConnection();
            String sql = "SELECT * FROM onsitecourse ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OnsiteDTO sp = new OnsiteDTO();
                sp.setCourseID(rs.getString("CourseID"));
                sp.setLocation(rs.getString("Location"));
                 sp.setDays(rs.getString("Days"));
                  sp.setTime(rs.getString("Time"));
                
                list.add(sp);
            }
        } catch (SQLException e) {
            
        }
        return list;
    }
    public boolean Xoa(String CourseID) {
        Connection conn = myConnect.getConnection();
        String sql = "Delete from onsitecourse where CourseID = " + CourseID;
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
           
            return true;
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        return false;
    }

  
    public List<OnsiteDTO> TimKiem(String CourseID) {  
    List<OnsiteDTO> list = new ArrayList<>();    
    try {        
            Connection con = myConnect.getConnection();
            String sql = "SELECT * FROM onsitecourse WHERE CourseID = '"+CourseID+"%' "; 
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OnsiteDTO nv = new OnsiteDTO();
                nv.setCourseID(rs.getString("CourseID"));
                nv.setLocation(rs.getString("Location"));  
                nv.setDays(rs.getString("Days")); 
                nv.setTime(rs.getString("Time")); 
                
                list.add(nv);  
            }
           
        } catch (SQLException e) {
             e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Tìm kiếm thất bại");
        }
        return list;
    }

}
