/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Nhan
 */
public class OnsiteDTO {
    private String CourseID;
    private String Location;
    private String Days;
    private String Time;

    public OnsiteDTO(String CourseID, String Location, String Days, String Time) {
        this.CourseID = CourseID;
        this.Location = Location;
        this.Days = Days;
        this.Time = Time;
    }
    public OnsiteDTO(){}
    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String CourseID) {
        this.CourseID = CourseID;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getDays() {
        return Days;
    }

    public void setDays(String Days) {
        this.Days = Days;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }
    
}
