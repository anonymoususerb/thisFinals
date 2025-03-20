package modelUi;

import java.io.Serializable;


public class studyante implements Serializable {
    private static final long serialVersionUID = 1L; // Add serialVersionUID to prevent compatibility issues

    private String stuID;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String address;
    private String phoneNo;
    private String gender;
    private String course;
    private String yearLvl;
    private String status;
    
    private String subject;

    public studyante(String subject) {
        this.subject = subject;
    }

     public studyante(String stuID, String firstName, String middleInitial, String lastName, 
                    String address, String phoneNo, String gender, String course, 
                    String yearLvl, String status) {
        this.stuID = stuID;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.course = course;
        this.yearLvl = yearLvl;
        this.status = status;
    }
    
    
    

   
    public String getStuID() {
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

    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
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
    public void setStuID(String stuID) {
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
    
      public void setAddress(String address) {  // Added setter for address
        this.address = address;
    }
    
    public void setPhoneNo(String phoneNo) {  // Added setter for phone number
        this.phoneNo = phoneNo;
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

   
    public String getFullName() {
        return lastName + ", " + firstName + (middleInitial.isEmpty() ? "" : " " + middleInitial + ".");
    }

    
    @Override
    public String toString() {
        return "Student ID: " + stuID + ", Name: " + getFullName() + ", Gender: " + gender +
               ", Course: " + course + ", Year: " + yearLvl + ", Status: " + status;
    }
}