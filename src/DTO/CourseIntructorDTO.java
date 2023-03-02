/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Nhan
 */
public class CourseIntructorDTO {
    private String CourseID;
    private String PersonID;

    public CourseIntructorDTO(String CourseID, String PersonID) {
        this.CourseID = CourseID;
        this.PersonID = PersonID;
    }
    public CourseIntructorDTO(){}

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String CourseID) {
        this.CourseID = CourseID;
    }

    public String getPersonID() {
        return PersonID;
    }

    public void setPersonID(String PersonID) {
        this.PersonID = PersonID;
    }
    
}
