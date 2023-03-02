/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import static DAL.myConnect.con;
import DTO.CourseIntructorDTO;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nhan
 */
public class CourseIntructorDAL {
     public boolean Them(CourseIntructorDTO cr) {
        Connection conn = myConnect.getConnection();
        String sql = "INSERT INTO courseinstructor(CourseID,PersonID) VALUES (?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cr.getCourseID());
            ps.setString(2, cr.getPersonID());
            
            ps.executeUpdate();
           
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Không được để trùng ID");

        }
        return false;
    }


    public boolean ChinhSua(CourseIntructorDTO cr) {
        Connection con = myConnect.getConnection();
        String sql = "update courseinstructor set PersonID=? where CourseID=? ";
        PreparedStatement ps;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cr.getPersonID());
            ps.setString(2, cr.getCourseID());
           
            ps.executeUpdate();
         
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không được để trùng ID");
        }
        return false;
    }

 
    public List<CourseIntructorDTO> listonl() {
        List<CourseIntructorDTO> list = new ArrayList<CourseIntructorDTO>();
        try {
            Connection con = myConnect.getConnection();
            String sql = "SELECT * FROM courseinstructor ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CourseIntructorDTO sp = new CourseIntructorDTO();
                sp.setCourseID(rs.getString("CourseID"));
                sp.setPersonID(rs.getString("PersonID"));
                
                list.add(sp);
            }
        } catch (SQLException e) {
            
        }
        return list;
    }
    public boolean Xoa(String CourseID) {
        Connection conn = myConnect.getConnection();
        String sql = "Delete from courseinstructor where CourseID = " + CourseID;
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
           
            return true;
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        return false;
    }

  
    public List<CourseIntructorDTO> TimKiem(String CourseID) {  
    List<CourseIntructorDTO> list = new ArrayList<>();    
    try {        
            Connection con = myConnect.getConnection();
            String sql = "SELECT * FROM courseinstructor WHERE CourseID ='"+CourseID+"%'"; 
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                while (rs.next()) {
                    CourseIntructorDTO nv = new CourseIntructorDTO();
                    nv.setCourseID(rs.getString("CourseID"));
                    nv.setPersonID(rs.getString("PersonID"));  
                    list.add(nv);                     
                }   
            }
        } catch (SQLException e) {           
            JOptionPane.showMessageDialog(null,"Tìm kiếm thất bại");
        }
        return list;
    }

}
