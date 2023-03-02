/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import static DAL.myConnect.con;
import DTO.StudenGradeDTO;

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
public class StudenGradeDAL {
    public boolean Them(StudenGradeDTO cr) {
        Connection conn = myConnect.getConnection();
        String sql = "INSERT INTO studentgrade(EnrollmentID,CourseID,StudentID,Grade) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(2, cr.getCourseID());
            ps.setString(1, cr.getEnrollmentID());
            ps.setString(3, cr.getStudentID());
            ps.setString(4, cr.getGrade());
            
            ps.executeUpdate();
           
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Lỗi");

        }
        return false;
    }


    public boolean ChinhSua(StudenGradeDTO cr) {
        Connection con = myConnect.getConnection();
        String sql = "update studentgrade set CourseID=?,StudentID=?,Grade=? where EnrollmentID=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cr.getCourseID());
            ps.setString(4, cr.getEnrollmentID());
            ps.setString(2, cr.getStudentID());
            ps.setString(3, cr.getGrade());
            ps.executeUpdate();
         
            return true;
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Không được để trùng ID");
        }
        return false;
    }

 
    public List<StudenGradeDTO> listonl() {
        List<StudenGradeDTO> list = new ArrayList<StudenGradeDTO>();
        try {
            Connection con = myConnect.getConnection();
            String sql = "SELECT * FROM studentgrade ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudenGradeDTO sp = new StudenGradeDTO();
                
                sp.setEnrollmentID(rs.getString("EnrollmentID"));
                sp.setCourseID(rs.getString("CourseID"));
                 sp.setStudentID(rs.getString("StudentID"));
                  sp.setGrade(rs.getString("Grade"));
                
                list.add(sp);
            }
        } catch (SQLException e) {
            
        }
        return list;
    }
    public boolean Xoa(String  EnrollmentID) {
        Connection conn = myConnect.getConnection();
        String sql = "Delete from studentgrade where EnrollmentID = " +  EnrollmentID;
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
           
            return true;
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        return false;
    }

  
    public List<StudenGradeDTO> TimKiem(String  EnrollmentID) {  
    List<StudenGradeDTO> list = new ArrayList<>();    
    try {        
            Connection con = myConnect.getConnection();
            String sql = "SELECT * FROM studentgrade WHERE EnrollmentID = '"+ EnrollmentID+"%' "; 
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudenGradeDTO sp = new StudenGradeDTO();
                
                sp.setEnrollmentID(rs.getString("EnrollmentID"));
                sp.setCourseID(rs.getString("CourseID"));
                 sp.setStudentID(rs.getString("StudentID"));
                  sp.setGrade(rs.getString("Grade"));
                
                list.add(sp);  
            }
           
        } catch (SQLException e) {
             e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Tìm kiếm thất bại");
        }
        return list;
    }

}
