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
    private String Lastname;
    private String Firtname;

    public CourseIntructorDTO(String CourseID, String PersonID, String Lastname, String Firtname) {
        this.CourseID = CourseID;
        this.PersonID = PersonID;
        this.Lastname = Lastname;
        this.Firtname = Firtname;
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

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getFirtname() {
        return Firtname;
    }

    public void setFirtname(String Firtname) {
        this.Firtname = Firtname;
    }
    
    
}
