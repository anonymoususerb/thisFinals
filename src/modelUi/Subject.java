package modelUi;  // Same package as DefaultSubjects

/**
 * Class representing a subject in an academic curriculum
 */
public class Subject {
    private String code;         
    private String description;  
    private String course;       
    private int units;           
    private String semester;     
    private boolean completed;   
    
    public Subject(String code, String description, String course, int units, String semester, boolean completed) {
        this.code = code;
        this.description = description;
        this.course = course;
        this.units = units;
        this.semester = semester;
        this.completed = completed;
    }
    
   
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getCourse() {
        return course;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }
    
    public int getUnits() {
        return units;
    }
    
    public void setUnits(int units) {
        this.units = units;
    }
    
    public String getSemester() {
        return semester;
    }
    
    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    public boolean isCompleted() {
        return completed;
    }
    
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    @Override
    public String toString() {
        return code + " - " + description;
    }
}