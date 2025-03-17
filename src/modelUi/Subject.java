package modelUi;  // Same package as DefaultSubjects

/**
 * Class representing a subject in an academic curriculum
 */
public class Subject {
    private String code;         // Subject code (e.g., "COMM101")
    private String description;  // Subject description/name
    private String course;       // Course code this subject belongs to
    private int units;           // Number of academic units
    private String semester;     // Semester ("1st" or "2nd")
    private boolean completed;   // Whether the student has completed this subject
    
    /**
     * Constructor for Subject
     * 
     * @param code Subject code
     * @param description Subject description/name
     * @param course Course code
     * @param units Number of academic units
     * @param semester Semester ("1st" or "2nd")
     * @param completed Whether the subject is completed
     */
    public Subject(String code, String description, String course, int units, String semester, boolean completed) {
        this.code = code;
        this.description = description;
        this.course = course;
        this.units = units;
        this.semester = semester;
        this.completed = completed;
    }
    
    // Getters and setters
    
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