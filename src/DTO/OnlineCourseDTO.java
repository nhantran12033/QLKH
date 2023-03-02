/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Nhan
 */
public class OnlineCourseDTO {
    private String CourseID;
    private String url;
    
    public OnlineCourseDTO(String CourseID, String url) {
        this.CourseID = CourseID;
        this.url = url;
    }
    public OnlineCourseDTO(){}
    
    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String CourseID) {
        this.CourseID = CourseID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
