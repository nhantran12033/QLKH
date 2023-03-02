/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import static DAL.myConnect.con;
import DTO.OnlineCourseDTO;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kiera
 */
public class OnlineCourseDAL {

    public boolean Them(OnlineCourseDTO cr) {
        Connection conn = myConnect.getConnection();
        String sql = "INSERT INTO onlinecourse(CourseID,url) VALUES (?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cr.getCourseID());
            ps.setString(2, cr.getUrl());
            
            ps.executeUpdate();
           
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Không được để trùng ID");

        }
        return false;
    }


    public boolean ChinhSua(OnlineCourseDTO cr) {
        Connection con = myConnect.getConnection();
        String sql = "update onlinecourse set url=? where CourseID=? ";
        PreparedStatement ps;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cr.getUrl());
            ps.setString(2, cr.getCourseID());
           
            ps.executeUpdate();
         
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không được để trùng ID");
        }
        return false;
    }

 
    public List<OnlineCourseDTO> listonl() {
        List<OnlineCourseDTO> list = new ArrayList<OnlineCourseDTO>();
        try {
            Connection con = myConnect.getConnection();
            String sql = "SELECT * FROM onlinecourse ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OnlineCourseDTO sp = new OnlineCourseDTO();
                sp.setCourseID(rs.getString("CourseID"));
                sp.setUrl(rs.getString("url"));
                
                list.add(sp);
            }
        } catch (SQLException e) {
            
        }
        return list;
    }
    public boolean Xoa(String CourseID) {
        Connection conn = myConnect.getConnection();
        String sql = "Delete from onlinecourse where CourseID = " + CourseID;
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
           
            return true;
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        return false;
    }

  
    public List<OnlineCourseDTO> TimKiem(String CourseID) {  
    List<OnlineCourseDTO> list = new ArrayList<>();    
    try {        
            Connection con = myConnect.getConnection();
            String sql = "SELECT * FROM onlinecourse WHERE CourseID ='"+CourseID+"%'"; 
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                while (rs.next()) {
                    OnlineCourseDTO nv = new OnlineCourseDTO();
                    nv.setCourseID(rs.getString("CourseID"));
                    nv.setUrl(rs.getString("url"));  
                    list.add(nv);                     
                }   
            }
        } catch (SQLException e) {           
            JOptionPane.showMessageDialog(null,"Tìm kiếm thất bại");
        }
        return list;
    }

}
