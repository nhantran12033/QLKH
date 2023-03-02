/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.OnlineCourseDAL;
import DAL.OnsiteCourseDAL;
import DTO.OnlineCourseDTO;
import DTO.OnsiteDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nhan
 */
public class OnsiteCourseBLL {
     private ArrayList<OnsiteDTO> listonl = null;
    OnsiteCourseDAL dal = new OnsiteCourseDAL();

    public OnsiteCourseBLL() {
        docListonl();
    }

    public void docListonl() {
        listonl= (ArrayList<OnsiteDTO>) dal.listonl();
    }

    public ArrayList<OnsiteDTO> getListonl() {
        if (listonl == null) {
            docListonl();
        }
        return listonl;
    }
    public boolean them(String CourseID, String location,String days, String time) {
      

        if (location.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được để trống Tên URL");
            return false;
        }
         if (days.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được để trống Tên URL");
            return false;
        }
          if (time.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được để trống Tên URL");
            return false;
        }
          
         else {
            
            OnsiteDTO sp = new OnsiteDTO();
            sp.setCourseID(CourseID);
            sp.setLocation(location);
            sp.setDays(days);
            sp.setTime(time);
            if (dal.Them(sp)) {
                JOptionPane.showMessageDialog(null, "Thêm thành công!");
                return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm Không thành công!");
                    return false;
                }       
          }
    }
    public boolean xoa(String CourseID) {

        if (dal.Xoa(CourseID)) {
            
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Xóa Không thành công!");
                return false;
            }
        
       
    }

    public boolean ChinhSua(String CourseID, String location,String days,String time) {
        
        
       if (location.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được để trống Tên URL");
            return false;
        }
         if (days.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được để trống Tên URL");
            return false;
        }
          if (time.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được để trống Tên URL");
            return false;
        }
         else {
            
           OnsiteDTO sp = new OnsiteDTO();
            sp.setCourseID(CourseID);
            sp.setLocation(location);
            sp.setDays(days);
            sp.setTime(time);
            
            if (dal.ChinhSua(sp)) {
               
                    JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Chỉnh sửa không thành công!");
                    return false;
                }

            
        }
   
    }  
    public List<OnsiteDTO> listonl(){
        return dal.listonl();
    }
     public List<OnsiteDTO> TimKiem(String CourseID){
        return dal.TimKiem(CourseID);
    }
}
