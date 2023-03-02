/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Nhan
 */
public class StudenGradeDTO {
    private String EnrollmentID;
    private String CourseID;
    private String StudentID;
    private String Grade;

    public StudenGradeDTO(String EnrollmentID, String CourseID, String StudentID, String Grade) {
        this.EnrollmentID = EnrollmentID;
        this.CourseID = CourseID;
        this.StudentID = StudentID;
        this.Grade = Grade;
    }
    public StudenGradeDTO(){}

    public String getEnrollmentID() {
        return EnrollmentID;
    }

    public void setEnrollmentID(String EnrollmentID) {
        this.EnrollmentID = EnrollmentID;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String CourseID) {
        this.CourseID = CourseID;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }
    
}
