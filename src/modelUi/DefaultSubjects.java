package modelUi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class for managing default subjects by course and year level
 */
public class DefaultSubjects {
    
    // Maps to store default subjects by course and year
    private static final Map<String, Map<String, List<Subject>>> courseSubjects = new HashMap<>();
    
    // Initialize the default subjects
    static {
        initBSIT();
        initBSBA();
        initBSED();
        initBEED();
        initBSHM();
    }
    
    /**
     * Get default subjects for a specific course and year level
     * 
     * @param course The course code (e.g., "BSIT", "BSBA")
     * @param yearLevel The year level (e.g., "1st Year", "2nd Year")
     * @return List of default subjects for the course and year level
     */
    public static List<Subject> getDefaultSubjects(String course, String yearLevel) {
        if (course == null || yearLevel == null) {
            return new ArrayList<>();
        }
        
        // Normalize course code (remove spaces, uppercase)
        String normalizedCourse = course.trim().toUpperCase().replaceAll("\\s+", "");
        
        // Normalize year level (extract just the number part)
        String normalizedYear = normalizeYearLevel(yearLevel);
        
        // Get subjects for this course
        Map<String, List<Subject>> yearSubjects = courseSubjects.get(normalizedCourse);
        if (yearSubjects == null) {
            return new ArrayList<>();
        }
        
        // Get subjects for this year
        List<Subject> subjects = yearSubjects.get(normalizedYear);
        if (subjects == null) {
            return new ArrayList<>();
        }
        
        // Return a copy of the list to prevent modifications
        return new ArrayList<>(subjects);
    }
    
    /**
     * Normalize year level string to standard format (1, 2, 3, 4)
     */
    private static String normalizeYearLevel(String yearLevel) {
        yearLevel = yearLevel.trim().toLowerCase();
        
        if (yearLevel.contains("1") || yearLevel.contains("first") || yearLevel.contains("freshman")) {
            return "1";
        } else if (yearLevel.contains("2") || yearLevel.contains("second") || yearLevel.contains("sophomore")) {
            return "2";
        } else if (yearLevel.contains("3") || yearLevel.contains("third") || yearLevel.contains("junior")) {
            return "3";
        } else if (yearLevel.contains("4") || yearLevel.contains("fourth") || yearLevel.contains("senior")) {
            return "4";
        }
        
        return "1"; // Default to first year if unrecognized
    }
    
    /**
     * Initialize BSIT subjects
     */
    private static void initBSIT() {
        Map<String, List<Subject>> yearSubjects = new HashMap<>();
        
        // First year BSIT subjects
        List<Subject> firstYear = new ArrayList<>();
        firstYear.add(new Subject("COMM101", "Purposive Communication", "BSIT", 3, "1st", false));
        firstYear.add(new Subject("SELF101", "Understanding the Self", "BSIT", 3, "1st", false));
        firstYear.add(new Subject("MATH101", "Mathematics in the Modern World", "BSIT", 3, "1st", false));
        firstYear.add(new Subject("STS101", "Science, Technology, and Society", "BSIT", 3, "1st", false));
        firstYear.add(new Subject("HIST101", "Readings in Philippine History", "BSIT", 3, "1st", false));
        firstYear.add(new Subject("ARTS101", "Art Appreciation", "BSIT", 3, "2nd", false));
        firstYear.add(new Subject("LOGIC101", "Logic and Critical Thinking", "BSIT", 3, "2nd", false));
        firstYear.add(new Subject("COMP101", "Introduction to Computing", "BSIT", 3, "1st", false));
        firstYear.add(new Subject("PROG101", "Computer Programming 1", "BSIT", 3, "1st", false));
        firstYear.add(new Subject("PROG102", "Computer Programming 2 OOP", "BSIT", 3, "2nd", false));
        firstYear.add(new Subject("MATH201", "Discrete Mathematics", "BSIT", 3, "2nd", false));
        firstYear.add(new Subject("HCI101", "Human-Computer Interaction", "BSIT", 3, "2nd", false));
        firstYear.add(new Subject("DSA101", "Data Structures and Algorithms", "BSIT", 3, "2nd", false));
        firstYear.add(new Subject("OS101", "Operating Systems", "BSIT", 3, "2nd", false));
        firstYear.add(new Subject("PE101", "Physical Education 1", "BSIT", 2, "1st", false));
        firstYear.add(new Subject("PE102", "Physical Education 2", "BSIT", 2, "2nd", false));
        firstYear.add(new Subject("NSTP1", "National Service Training Program 1", "BSIT", 3, "1st", false));
        firstYear.add(new Subject("NSTP2", "National Service Training Program 2", "BSIT", 3, "2nd", false));
        
        // Second year BSIT subjects
        List<Subject> secondYear = new ArrayList<>();
        secondYear.add(new Subject("CONT201", "The Contemporary World", "BSIT", 3, "1st", false));
        secondYear.add(new Subject("ETHICS201", "Ethics", "BSIT", 3, "1st", false));
        secondYear.add(new Subject("ITLIFE201", "Living in the IT Era", "BSIT", 3, "1st", false));
        secondYear.add(new Subject("INMA201", "Information Management", "BSIT", 3, "1st", false));
        secondYear.add(new Subject("AOOP201", "Advanced Object-Oriented Programming", "BSIT", 3, "1st", false));
        secondYear.add(new Subject("NET201", "Computer Networks and Data Communications", "BSIT", 3, "1st", false));
        secondYear.add(new Subject("WEB201", "Web Development", "BSIT", 3, "2nd", false));
        secondYear.add(new Subject("SAD201", "System Analysis and Design", "BSIT", 3, "2nd", false));
        secondYear.add(new Subject("DSA202", "Data Structures and Algorithms 2", "BSIT", 3, "2nd", false));
        secondYear.add(new Subject("CSEC201", "Cybersecurity Fundamentals", "BSIT", 3, "2nd", false));
        secondYear.add(new Subject("PE103", "Physical Education 3", "BSIT", 2, "1st", false));
        secondYear.add(new Subject("PE104", "Physical Education 4", "BSIT", 2, "2nd", false));
        
        // Third year BSIT subjects
        List<Subject> thirdYear = new ArrayList<>();
        thirdYear.add(new Subject("ENTR301", "Entrepreneurship", "BSIT", 3, "1st", false));
        thirdYear.add(new Subject("WRITE301", "Technical Writing", "BSIT", 3, "1st", false));
        thirdYear.add(new Subject("SENG301", "Software Engineering", "BSIT", 3, "1st", false));
        thirdYear.add(new Subject("MOBILE301", "Mobile Application Development", "BSIT", 3, "1st", false));
        thirdYear.add(new Subject("CLOUD301", "Cloud Computing", "BSIT", 3, "1st", false));
        thirdYear.add(new Subject("AI301", "Artificial Intelligence", "BSIT", 3, "2nd", false));
        thirdYear.add(new Subject("DBS301", "Advanced Database Systems", "BSIT", 3, "2nd", false));
        thirdYear.add(new Subject("HCI301", "Human-Computer Interaction 2", "BSIT", 3, "2nd", false));
        thirdYear.add(new Subject("IOT301", "Internet of Things (IoT)", "BSIT", 3, "2nd", false));
        thirdYear.add(new Subject("CAP301", "Capstone Project 1", "BSIT", 3, "2nd", false));
        thirdYear.add(new Subject("RES301", "Research in IT", "BSIT", 3, "2nd", false));
        
        // Fourth year BSIT subjects
        List<Subject> fourthYear = new ArrayList<>();
        fourthYear.add(new Subject("DEVOPS401", "DevOps and Software Deployment", "BSIT", 3, "1st", false));
        fourthYear.add(new Subject("ML401", "Machine Learning", "BSIT", 3, "1st", false));
        fourthYear.add(new Subject("ITGOV401", "IT Governance and Ethics", "BSIT", 3, "1st", false));
        fourthYear.add(new Subject("CAP401", "Capstone Project 2", "BSIT", 3, "1st", false));
        fourthYear.add(new Subject("OJT401", "On-the-Job Training (OJT)", "BSIT", 6, "2nd", false));
        
        // Store in map
        yearSubjects.put("1", firstYear);
        yearSubjects.put("2", secondYear);
        yearSubjects.put("3", thirdYear);
        yearSubjects.put("4", fourthYear);
        
        courseSubjects.put("BSIT", yearSubjects);
    }
    
    /**
     * Initialize BSBA subjects
     */
    private static void initBSBA() {
        Map<String, List<Subject>> yearSubjects = new HashMap<>();
        
        // First year BSBA subjects
        List<Subject> firstYear = new ArrayList<>();
        firstYear.add(new Subject("SELF101", "Understanding the Self", "BSBA", 3, "1st", false));
        firstYear.add(new Subject("COMM101", "Purposive Communication", "BSBA", 3, "1st", false));
        firstYear.add(new Subject("MATH101", "Mathematics in the Modern World", "BSBA", 3, "1st", false));
        firstYear.add(new Subject("STS101", "Science, Technology, and Society", "BSBA", 3, "1st", false));
        firstYear.add(new Subject("HIST101", "Readings in Philippine History", "BSBA", 3, "1st", false));
        firstYear.add(new Subject("ARTS101", "Art Appreciation", "BSBA", 3, "2nd", false));
        firstYear.add(new Subject("LOGIC101", "Logic and Critical Thinking", "BSBA", 3, "2nd", false));
        firstYear.add(new Subject("ACCT101", "Fundamentals of Accounting", "BSBA", 3, "1st", false));
        firstYear.add(new Subject("BMATH101", "Business Mathematics", "BSBA", 3, "2nd", false));
        firstYear.add(new Subject("MGMT101", "Principles of Management", "BSBA", 3, "2nd", false));
        firstYear.add(new Subject("PE101", "Physical Education 1", "BSBA", 2, "1st", false));
        firstYear.add(new Subject("PE102", "Physical Education 2", "BSBA", 2, "2nd", false));
        firstYear.add(new Subject("NSTP1", "National Service Training Program 1", "BSBA", 3, "1st", false));
        firstYear.add(new Subject("NSTP2", "National Service Training Program 2", "BSBA", 3, "2nd", false));
        
        // Second year BSBA subjects
        List<Subject> secondYear = new ArrayList<>();
        secondYear.add(new Subject("CONT201", "The Contemporary World", "BSBA", 3, "1st", false));
        secondYear.add(new Subject("ETHICS201", "Ethics", "BSBA", 3, "1st", false));
        secondYear.add(new Subject("BWORLD201", "Living in the Business World", "BSBA", 3, "1st", false));
        secondYear.add(new Subject("FACCT201", "Financial Accounting", "BSBA", 3, "1st", false));
        secondYear.add(new Subject("BLAW201", "Business Law and Taxation", "BSBA", 3, "1st", false));
        secondYear.add(new Subject("MKTG201", "Marketing Management", "BSBA", 3, "2nd", false));
        secondYear.add(new Subject("BCOMM201", "Business Communication", "BSBA", 3, "2nd", false));
        secondYear.add(new Subject("MICRO201", "Microeconomics", "BSBA", 3, "1st", false));
        secondYear.add(new Subject("MACRO201", "Macroeconomics", "BSBA", 3, "2nd", false));
        secondYear.add(new Subject("OPS201", "Operations Management", "BSBA", 3, "2nd", false));
        secondYear.add(new Subject("HRM201", "Human Resource Management", "BSBA", 3, "2nd", false));
        secondYear.add(new Subject("PE103", "Physical Education 3", "BSBA", 2, "1st", false));
        secondYear.add(new Subject("PE104", "Physical Education 4", "BSBA", 2, "2nd", false));
        
        // Third year BSBA subjects
        List<Subject> thirdYear = new ArrayList<>();
        thirdYear.add(new Subject("ENTR301", "Entrepreneurship", "BSBA", 3, "1st", false));
        thirdYear.add(new Subject("STRAT301", "Strategic Management", "BSBA", 3, "1st", false));
        thirdYear.add(new Subject("MACCT301", "Managerial Accounting", "BSBA", 3, "1st", false));
        thirdYear.add(new Subject("FMGMT301", "Financial Management", "BSBA", 3, "1st", false));
        thirdYear.add(new Subject("BRES301", "Business Research Methods", "BSBA", 3, "1st", false));
        thirdYear.add(new Subject("CBEHAV301", "Consumer Behavior", "BSBA", 3, "2nd", false));
        thirdYear.add(new Subject("ECOMM301", "E-Commerce and Digital Marketing", "BSBA", 3, "2nd", false));
        thirdYear.add(new Subject("BANALY301", "Business Analytics", "BSBA", 3, "2nd", false));
        thirdYear.add(new Subject("RISK301", "Risk Management", "BSBA", 3, "2nd", false));
        thirdYear.add(new Subject("INTL301", "International Business", "BSBA", 3, "2nd",false));
         thirdYear.add(new Subject("INTL301", "International Business", "BSBA", 3, "2nd", false));
        thirdYear.add(new Subject("CAP301", "Business Capstone 1", "BSBA", 3, "2nd", false));
        
        // Fourth year BSBA subjects
        List<Subject> fourthYear = new ArrayList<>();
        fourthYear.add(new Subject("CSR401", "Corporate Social Responsibility", "BSBA", 3, "1st", false));
        fourthYear.add(new Subject("IPM401", "Investment and Portfolio Management", "BSBA", 3, "1st", false));
        fourthYear.add(new Subject("BPD401", "Business Policy and Development", "BSBA", 3, "1st", false));
        fourthYear.add(new Subject("LOB401", "Leadership and Organizational Behavior", "BSBA", 3, "1st", false));
        fourthYear.add(new Subject("CAP401", "Capstone Project", "BSBA", 3, "1st", false));
        fourthYear.add(new Subject("OJT401", "Internship / On-the-Job Training (OJT)", "BSBA", 6, "2nd", false));
        
        // Store in map
        yearSubjects.put("1", firstYear);
        yearSubjects.put("2", secondYear);
        yearSubjects.put("3", thirdYear);
        yearSubjects.put("4", fourthYear);
        
        courseSubjects.put("BSBA", yearSubjects);
    }
    
    /**
     * Initialize BSED subjects
     */
    private static void initBSED() {
        Map<String, List<Subject>> yearSubjects = new HashMap<>();
        
        // First year BSED subjects
        List<Subject> firstYear = new ArrayList<>();
        firstYear.add(new Subject("SELF101", "Understanding the Self", "BSED", 3, "1st", false));
        firstYear.add(new Subject("COMM101", "Purposive Communication", "BSED", 3, "1st", false));
        firstYear.add(new Subject("MATH101", "Mathematics in the Modern World", "BSED", 3, "1st", false));
        firstYear.add(new Subject("STS101", "Science, Technology, and Society", "BSED", 3, "1st", false));
        firstYear.add(new Subject("HIST101", "Readings in Philippine History", "BSED", 3, "1st", false));
        firstYear.add(new Subject("ARTS101", "Art Appreciation", "BSED", 3, "2nd", false));
        firstYear.add(new Subject("LOGIC101", "Logic and Critical Thinking", "BSED", 3, "2nd", false));
        firstYear.add(new Subject("TEACH101", "The Teaching Profession", "BSED", 3, "1st", false));
        firstYear.add(new Subject("LEARNER101", "Facilitating Learner-Centered Teaching", "BSED", 3, "2nd", false));
        firstYear.add(new Subject("FOUND101", "Foundations of Education", "BSED", 3, "2nd", false));
        firstYear.add(new Subject("PE101", "Physical Education 1", "BSED", 2, "1st", false));
        firstYear.add(new Subject("PE102", "Physical Education 2", "BSED", 2, "2nd", false));
        firstYear.add(new Subject("NSTP1", "National Service Training Program 1", "BSED", 3, "1st", false));
        firstYear.add(new Subject("NSTP2", "National Service Training Program 2", "BSED", 3, "2nd", false));
        
        // Second year BSED subjects
        List<Subject> secondYear = new ArrayList<>();
        secondYear.add(new Subject("CONT201", "The Contemporary World", "BSED", 3, "1st", false));
        secondYear.add(new Subject("ETHICS201", "Ethics", "BSED", 3, "1st", false));
        secondYear.add(new Subject("TECHTL201", "Technology for Teaching and Learning", "BSED", 3, "1st", false));
        secondYear.add(new Subject("ASSESS201", "Assessment of Learning 1", "BSED", 3, "1st", false));
        secondYear.add(new Subject("CURRIC201", "Curriculum Development", "BSED", 3, "2nd", false));
        secondYear.add(new Subject("EDUPSY201", "Educational Psychology", "BSED", 3, "2nd", false));
        secondYear.add(new Subject("MULTI201", "Teaching Multi-grade Classes", "BSED", 3, "2nd", false));
        secondYear.add(new Subject("MAJOR201", "Content and Pedagogy for the Major Subject", "BSED", 3, "2nd", false));
        secondYear.add(new Subject("PE103", "Physical Education 3", "BSED", 2, "1st", false));
        secondYear.add(new Subject("PE104", "Physical Education 4", "BSED", 2, "2nd", false));
        
        // Third year BSED subjects
        List<Subject> thirdYear = new ArrayList<>();
        thirdYear.add(new Subject("ERES301", "Educational Research", "BSED", 3, "1st", false));
        thirdYear.add(new Subject("ASSESS302", "Assessment of Learning 2", "BSED", 3, "1st", false));
        thirdYear.add(new Subject("CLASS301", "Classroom Management and Discipline", "BSED", 3, "1st", false));
        thirdYear.add(new Subject("TREND301", "Trends and Issues in Education", "BSED", 3, "1st", false));
        thirdYear.add(new Subject("STRAT301", "Teaching Strategies and Approaches", "BSED", 3, "2nd", false));
        thirdYear.add(new Subject("INSTM301", "Instructional Materials Development", "BSED", 3, "2nd", false));
        thirdYear.add(new Subject("INTERN301", "Teaching Internship Preparation", "BSED", 3, "2nd", false));
        thirdYear.add(new Subject("MAJOR301", "Content and Pedagogy for the Major Subject", "BSED", 3, "2nd", false));
        
        // Fourth year BSED subjects
        List<Subject> fourthYear = new ArrayList<>();
        fourthYear.add(new Subject("INTERN401", "Teaching Internship", "BSED", 6, "1st", false));
        fourthYear.add(new Subject("ACTION401", "Action Research in Education", "BSED", 3, "2nd", false));
        fourthYear.add(new Subject("INCL401", "Inclusive Education", "BSED", 3, "2nd", false));
        fourthYear.add(new Subject("SPEC401", "Special Topics in Education", "BSED", 3, "2nd", false));
        fourthYear.add(new Subject("CAP401", "Capstone Project", "BSED", 3, "2nd", false));
        
        // Store in map
        yearSubjects.put("1", firstYear);
        yearSubjects.put("2", secondYear);
        yearSubjects.put("3", thirdYear);
        yearSubjects.put("4", fourthYear);
        
        courseSubjects.put("BSED", yearSubjects);
    }
    
    /**
     * Initialize BEED subjects
     */
    private static void initBEED() {
        Map<String, List<Subject>> yearSubjects = new HashMap<>();
        
        // First year BEED subjects
        List<Subject> firstYear = new ArrayList<>();
        firstYear.add(new Subject("SELF101", "Understanding the Self", "BEED", 3, "1st", false));
        firstYear.add(new Subject("COMM101", "Purposive Communication", "BEED", 3, "1st", false));
        firstYear.add(new Subject("MATH101", "Mathematics in the Modern World", "BEED", 3, "1st", false));
        firstYear.add(new Subject("STS101", "Science, Technology, and Society", "BEED", 3, "1st", false));
        firstYear.add(new Subject("HIST101", "Readings in Philippine History", "BEED", 3, "1st", false));
        firstYear.add(new Subject("ARTS101", "Art Appreciation", "BEED", 3, "2nd", false));
        firstYear.add(new Subject("LOGIC101", "Logic and Critical Thinking", "BEED", 3, "2nd", false));
        firstYear.add(new Subject("TEACH101", "The Teaching Profession", "BEED", 3, "1st", false));
        firstYear.add(new Subject("LEARNER101", "Facilitating Learner-Centered Teaching", "BEED", 3, "2nd", false));
        firstYear.add(new Subject("CHILD101", "Child and Adolescent Development", "BEED", 3, "2nd", false));
        firstYear.add(new Subject("PE101", "Physical Education 1", "BEED", 2, "1st", false));
        firstYear.add(new Subject("PE102", "Physical Education 2", "BEED", 2, "2nd", false));
        firstYear.add(new Subject("NSTP1", "National Service Training Program 1", "BEED", 3, "1st", false));
        firstYear.add(new Subject("NSTP2", "National Service Training Program 2", "BEED", 3, "2nd", false));
        
        // Second year BEED subjects
        List<Subject> secondYear = new ArrayList<>();
        secondYear.add(new Subject("CONT201", "The Contemporary World", "BEED", 3, "1st", false));
        secondYear.add(new Subject("ETHICS201", "Ethics", "BEED", 3, "1st", false));
        secondYear.add(new Subject("TECHTL201", "Technology for Teaching and Learning", "BEED", 3, "1st", false));
        secondYear.add(new Subject("ASSESS201", "Assessment of Learning 1", "BEED", 3, "1st", false));
        secondYear.add(new Subject("CURRIC201", "Curriculum Development in Elementary Education", "BEED", 3, "2nd", false));
        secondYear.add(new Subject("EDUPSY201", "Educational Psychology", "BEED", 3, "2nd", false));
        secondYear.add(new Subject("MTONG201", "Content and Pedagogy for the Mother Tongue", "BEED", 3, "1st", false));
        secondYear.add(new Subject("ENGL201", "Content and Pedagogy for English", "BEED", 3, "2nd", false));
        secondYear.add(new Subject("MATH201", "Content and Pedagogy for Mathematics", "BEED", 3, "2nd", false));
        secondYear.add(new Subject("PE103", "Physical Education 3", "BEED", 2, "1st", false));
        secondYear.add(new Subject("PE104", "Physical Education 4", "BEED", 2, "2nd", false));
        
        // Third year BEED subjects
        List<Subject> thirdYear = new ArrayList<>();
        thirdYear.add(new Subject("ERES301", "Educational Research", "BEED", 3, "1st", false));
        thirdYear.add(new Subject("ASSESS302", "Assessment of Learning 2", "BEED", 3, "1st", false));
        thirdYear.add(new Subject("SCIENCE301", "Content and Pedagogy for Science", "BEED", 3, "1st", false));
        thirdYear.add(new Subject("SOCST301", "Content and Pedagogy for Social Studies", "BEED", 3, "1st", false));
        thirdYear.add(new Subject("MAPEH301", "Content and Pedagogy for Music, Arts, PE, and Health (MAPEH)", "BEED", 3, "2nd", false));
        thirdYear.add(new Subject("TLE301", "Content and Pedagogy for Technology and Livelihood Education (TLE)", "BEED", 3, "2nd", false));
        thirdYear.add(new Subject("INSTM301", "Instructional Materials Development for Elementary Education", "BEED", 3, "2nd", false));
        thirdYear.add(new Subject("CLASS301", "Classroom Management and Discipline", "BEED", 3, "2nd", false));
        
        // Fourth year BEED subjects
        List<Subject> fourthYear = new ArrayList<>();
        fourthYear.add(new Subject("INTERN401", "Teaching Internship", "BEED", 6, "1st", false));
        fourthYear.add(new Subject("ACTION401", "Action Research in Education", "BEED", 3, "2nd", false));
        fourthYear.add(new Subject("INCL401", "Inclusive Education", "BEED", 3, "2nd", false));
        fourthYear.add(new Subject("SPEC401", "Special Topics in Elementary Education", "BEED", 3, "2nd", false));
        fourthYear.add(new Subject("CAP401", "Capstone Project", "BEED", 3, "2nd", false));
        
        // Store in map
        yearSubjects.put("1", firstYear);
        yearSubjects.put("2", secondYear);
        yearSubjects.put("3", thirdYear);
        yearSubjects.put("4", fourthYear);
        
        courseSubjects.put("BEED", yearSubjects);
    }
    
    /**
     * Initialize BSHM subjects
     */
    private static void initBSHM() {
        Map<String, List<Subject>> yearSubjects = new HashMap<>();
        
        // First year BSHM subjects
        List<Subject> firstYear = new ArrayList<>();
        firstYear.add(new Subject("SELF101", "Understanding the Self", "BSHM", 3, "1st", false));
        firstYear.add(new Subject("COMM101", "Purposive Communication", "BSHM", 3, "1st", false));
        firstYear.add(new Subject("MATH101", "Mathematics in the Modern World", "BSHM", 3, "1st", false));
        firstYear.add(new Subject("STS101", "Science, Technology, and Society", "BSHM", 3, "1st", false));
        firstYear.add(new Subject("HIST101", "Readings in Philippine History", "BSHM", 3, "1st", false));
        firstYear.add(new Subject("ARTS101", "Art Appreciation", "BSHM", 3, "2nd", false));
        firstYear.add(new Subject("LOGIC101", "Logic and Critical Thinking", "BSHM", 3, "2nd", false));
        firstYear.add(new Subject("INTRO101", "Introduction to Hospitality Management", "BSHM", 3, "1st", false));
        firstYear.add(new Subject("FBSVC101", "Fundamentals of Food and Beverage Service", "BSHM", 3, "2nd", false));
        firstYear.add(new Subject("TOUR101", "Principles of Tourism", "BSHM", 3, "2nd", false));
        firstYear.add(new Subject("PE101", "Physical Education 1", "BSHM", 2, "1st", false));
        firstYear.add(new Subject("PE102", "Physical Education 2", "BSHM", 2, "2nd", false));
        firstYear.add(new Subject("NSTP1", "National Service Training Program 1", "BSHM", 3, "1st", false));
        firstYear.add(new Subject("NSTP2", "National Service Training Program 2", "BSHM", 3, "2nd", false));
        
        // Second year BSHM subjects
        List<Subject> secondYear = new ArrayList<>();
        secondYear.add(new Subject("CONT201", "The Contemporary World", "BSHM", 3, "1st", false));
        secondYear.add(new Subject("ETHICS201", "Ethics", "BSHM", 3, "1st", false));
        secondYear.add(new Subject("HTECH201", "Technology in the Hospitality Industry", "BSHM", 3, "1st", false));
        secondYear.add(new Subject("HMKTG201", "Hospitality Marketing and Sales", "BSHM", 3, "1st", false));
        secondYear.add(new Subject("CULIN201", "Culinary Fundamentals", "BSHM", 3, "2nd", false));
        secondYear.add(new Subject("FRONT201", "Front Office Operations", "BSHM", 3, "2nd", false));
        secondYear.add(new Subject("HOUSE201", "Housekeeping Operations", "BSHM", 3, "2nd", false));
        secondYear.add(new Subject("ENTRE201", "Entrepreneurial Management in Hospitality", "BSHM", 3, "1st", false));
        secondYear.add(new Subject("FSAFETY201", "Food Safety and Sanitation", "BSHM", 3, "2nd", false));
        secondYear.add(new Subject("PE103", "Physical Education 3", "BSHM", 2, "1st", false));
        secondYear.add(new Subject("PE104", "Physical Education 4", "BSHM", 2, "2nd", false));
        
        // Third year BSHM subjects
        List<Subject> thirdYear = new ArrayList<>();
        thirdYear.add(new Subject("FBCOST301", "Food and Beverage Cost Control", "BSHM", 3, "1st", false));
        thirdYear.add(new Subject("ROOMS301", "Rooms Division Management", "BSHM", 3, "1st", false));
        thirdYear.add(new Subject("HFIN301", "Hospitality Financial Management", "BSHM", 3, "1st", false));
        thirdYear.add(new Subject("EVENT301", "Events Planning and Management", "BSHM", 3, "1st", false));
        thirdYear.add(new Subject("RESORT301", "Resort and Club Operations", "BSHM", 3, "2nd", false));
        thirdYear.add(new Subject("CUST301", "Customer Service in Hospitality", "BSHM", 3, "2nd", false));
        thirdYear.add(new Subject("HLAW301", "Hospitality Law and Ethics", "BSHM", 3, "2nd", false));
        thirdYear.add(new Subject("INTCUI301", "International Cuisine", "BSHM", 3, "2nd", false));
        
        // Fourth year BSHM subjects
        List<Subject> fourthYear = new ArrayList<>();
        fourthYear.add(new Subject("HSTRAT401", "Hospitality Strategic Management", "BSHM", 3, "1st", false));
        fourthYear.add(new Subject("TREND401", "Trends and Issues in Hospitality Industry", "BSHM", 3, "1st", false));
        fourthYear.add(new Subject("SUSTAIN401", "Sustainable Tourism and Hospitality", "BSHM", 3, "1st", false));
        fourthYear.add(new Subject("CAP401", "Capstone Project", "BSHM", 3, "1st", false));
        fourthYear.add(new Subject("OJT401", "On-the-Job Training (OJT)", "BSHM", 6, "2nd", false));
        
        // Store in map
        yearSubjects.put("1", firstYear);
        yearSubjects.put("2", secondYear);
        yearSubjects.put("3", thirdYear);
        yearSubjects.put("4", fourthYear);
        
        courseSubjects.put("BSHM", yearSubjects);
    }
}