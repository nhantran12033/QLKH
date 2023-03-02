/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseIntructorDAL;
import DTO.CourseIntructorDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nhan
 */
public class CourseIntructorBLL {
    private ArrayList<CourseIntructorDTO> listonl = null;
    CourseIntructorDAL dal = new CourseIntructorDAL();

    public CourseIntructorBLL() {
        docListonl();
    }

    public void docListonl() {
        listonl= (ArrayList<CourseIntructorDTO>) dal.listonl();
    }

    public ArrayList<CourseIntructorDTO> getListonl() {
        if (listonl == null) {
            docListonl();
        }
        return listonl;
    }
    public boolean them(String CourseID, String url) {
      
        
        
            
            CourseIntructorDTO sp = new CourseIntructorDTO();
            sp.setCourseID(CourseID);
            sp.setPersonID(url);
            
            if (dal.Them(sp)) {
                
                    JOptionPane.showMessageDialog(null, "Thêm thành công!");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm Không thành công!");
                    return false;
                }

            
     
    }
    public boolean xoa(String CourseID) {
       
        int warning = JOptionPane.showConfirmDialog(null, "Bạn muốn giữ lại hay xóa, Bạn Xóa ?", "Warning",
                JOptionPane.YES_NO_OPTION);
        if (dal.Xoa(CourseID)) {
            if (warning == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Xóa Không thành công!");
                return false;
            }
        }
        return false;
    }

    public boolean ChinhSua(String CourseID, String url) {
        int warning = JOptionPane.showConfirmDialog(null, "Kiểm tra lại lần nữa trước khi thêm, bạn đã chắc chắn ?", "Warning",
                JOptionPane.YES_NO_OPTION);

        
       if (url.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được để trống url");
            return false;
        } 
         else {
            
            CourseIntructorDTO sp = new CourseIntructorDTO();
            sp.setCourseID(CourseID);
            sp.setPersonID(url);
            
            if (dal.ChinhSua(sp)) {
                if (warning == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Chỉnh sửa không thành công!");
                    return false;
                }

            }
        }
        return false;
    }  
     public List<CourseIntructorDTO> listonl(){
        return dal.listonl();
    }
     public List<CourseIntructorDTO> TimKiem(String CourseID){
        return dal.TimKiem(CourseID);
    }
}
