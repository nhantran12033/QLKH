/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.StudenGradeDAL;
import DTO.StudenGradeDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nhan
 */
public class StudentGradeBLL {
    private ArrayList<StudenGradeDTO> listonl = null;
    StudenGradeDAL dal = new StudenGradeDAL();

    public StudentGradeBLL() {
        docListonl();
    }

    public void docListonl() {
        listonl= (ArrayList<StudenGradeDTO>) dal.listonl();
    }

    public ArrayList<StudenGradeDTO> getListonl() {
        if (listonl == null) {
            docListonl();
        }
        return listonl;
    }
    public boolean them(String EnrollmentID, String CourseID,String StudentID, String Grade) {
    
         
             if(Grade.isEmpty()){
                JOptionPane.showMessageDialog(null, "Không được để trống Grade");
                return false;
            }
            
            StudenGradeDTO sp = new StudenGradeDTO();
            sp.setEnrollmentID(EnrollmentID);
            sp.setCourseID(CourseID);
            sp.setStudentID(StudentID);
            sp.setGrade(Grade);
            if (dal.Them(sp)) {
                JOptionPane.showMessageDialog(null, "Thêm thành công!");
                return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm Không thành công!");
                    return false;
                }       
          
    }
    public boolean xoa(String EnrollmentID) {
         
        if (dal.Xoa(EnrollmentID)) {
            
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Xóa Không thành công!");
                return false;
            }
        
       
    }

    public boolean ChinhSua(String EnrollmentID, String CourseID,String StudentID, String Grade) {
        
        
            if(Grade.isEmpty()){
                JOptionPane.showMessageDialog(null, "Không được để trống Grade");
                return false;
            }
            
            StudenGradeDTO sp = new StudenGradeDTO();
            sp.setEnrollmentID(EnrollmentID);
            sp.setCourseID(CourseID);
            sp.setStudentID(StudentID);
            sp.setGrade(Grade);
            
            if (dal.ChinhSua(sp)) {
               
                    JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Chỉnh sửa không thành công!");
                    return false;
                }

            
        
   
    } 
     public List<StudenGradeDTO> listonl(){
        return dal.listonl();
    }
     public List<StudenGradeDTO> TimKiem(String EnrollmentID){
        return dal.TimKiem(EnrollmentID);
    }
}
