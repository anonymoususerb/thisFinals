package modelUi;

import java.io.Serializable;


public class studyante implements Serializable {
    private static final long serialVersionUID = 1L; // Add serialVersionUID to prevent compatibility issues

    private int stuID;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String gender;
    private String course;
    private String yearLvl;
    private String status;

    // ✅ Constructor
    public studyante(int stuID, String firstName, String middleInitial, String lastName,
                     String gender, String course, String yearLvl, String status) {
        this.stuID = stuID;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.course = course;
        this.yearLvl = yearLvl;
        this.status = status;
    }
    
    

    // ✅ Getters
    public int getStuID() {
        return stuID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getCourse() {
        return course;
    }

    public String getYearLvl() {
        return yearLvl;
    }

    public String getStatus() {
        return status;
    }

    // ✅ Setters (if needed for updates)
    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setYearLvl(String yearLvl) {
        this.yearLvl = yearLvl;
    }
    
    

    public void setStatus(String status) {
        this.status = status;
    }

    // ✅ Returns full name in "Last, First M." format
    public String getFullName() {
        return lastName + ", " + firstName + (middleInitial.isEmpty() ? "" : " " + middleInitial + ".");
    }

    // ✅ Override toString() for debugging
    @Override
    public String toString() {
        return "Student ID: " + stuID + ", Name: " + getFullName() + ", Gender: " + gender +
               ", Course: " + course + ", Year: " + yearLvl + ", Status: " + status;
    }
}