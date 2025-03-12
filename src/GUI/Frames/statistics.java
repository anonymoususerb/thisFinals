package GUI.Frames;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelUi.studyante;
import GUI.CustomComponents.DraggableTotalStudentsPanel;
import GUI.CustomComponents.BarGraphPanel;
import GUI.CustomComponents.TotalMaleStudentsPanel;
import GUI.CustomComponents.TotalFemaleStudentsPanel;
import GUI.CustomComponents.PieChartPanel;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class statistics extends javax.swing.JPanel {
private List<studyante> students;
     

    public statistics(List<studyante> students) {
        this.students = (students != null) ? students : new ArrayList<>();
        initComponents();
        initializeComponents();
        updateAllCharts();
    }

    private void initializeComponents() {
        if (stuOverall == null) {
            System.out.println("❌ stuOverall is NULL! Initializing manually...");
            stuOverall = new DraggableTotalStudentsPanel();
            add(stuOverall);
        }

        if (stuMale == null) {
            System.out.println("❌ stuMale is NULL! Initializing manually...");
            stuMale = new TotalMaleStudentsPanel();
            add(stuMale);
        }

        if (stuFemale == null) {
            System.out.println("❌ stuFemale is NULL! Initializing manually...");
            stuFemale = new TotalFemaleStudentsPanel();
            add(stuFemale);
        }

        if (pnlBar == null) {
            System.out.println("❌ pnlBar is NULL! Initializing manually...");
            pnlBar = new BarGraphPanel();
            add(pnlBar);
        }

        if (stuPie == null) {
            System.out.println("❌ stuPie is NULL! Initializing manually...");
            stuPie = new PieChartPanel();
            add(stuPie);
        }
    }

    private void updateAllCharts() {
        updateStudentCount();
        updateBarGraph();
        updatePieChart();
    }
    
// total student, male, famale
    private void updateStudentCount() {
        int maleCount = 0;
        int femaleCount = 0;
//calculates male, female
        for (studyante s : students) {
            if ("Male".equalsIgnoreCase(s.getGender())) {
                maleCount++;
            } else if ("Female".equalsIgnoreCase(s.getGender())) {
                femaleCount++;
            }
        }

        if (stuMale != null) stuMale.setTotalStudents(maleCount);
        if (stuFemale != null) stuFemale.setTotalStudents(femaleCount);
        if (stuOverall != null) stuOverall.setTotalStudents(students.size());  // calculate the student total

        System.out.println("✅ Updated student counts - Male: " + maleCount + ", Female: " + femaleCount);
    }
// bar graph
    private void updateBarGraph() {
        if (pnlBar == null) {
            System.out.println("❌ pnlBar is NULL! Cannot update bar graph.");
            return;
        }

        if (students.isEmpty()) {
            System.out.println("⚠ Students list is empty! No data to count.");
            return;
        }

        Map<String, Integer> courseCount = new HashMap<>();
//  calculate the bargraph course
        for (studyante s : students) {
            if (!"Enter student Lastname".equals(s.getCourse())) {
                courseCount.put(s.getCourse(), courseCount.getOrDefault(s.getCourse(), 0) + 1);
            }
        }

        if (courseCount.isEmpty()) {
            System.out.println("⚠ No data to display in bar graph!");
        } else {
            pnlBar.setGraphData(courseCount);
        }
    }
// pie chart
    private void updatePieChart() {
        if (stuPie == null) {
            System.out.println("❌ stuPie is NULL! Cannot update pie chart.");
            return;
        }

        int enrolled = 0, dropped = 0, unenrolled = 0;
// calculates student pie chart
        for (studyante s : students) {
            if ("Enrolled".equalsIgnoreCase(s.getStatus())) {
                enrolled++;
            } else if ("Dropped".equalsIgnoreCase(s.getStatus())) {
                dropped++;
            } else {
                unenrolled++;
            }
        }

        stuPie.setStudentData(enrolled, dropped, unenrolled);
    }

    public void refreshData(List<studyante> updatedStudents) {
        if (updatedStudents == null || updatedStudents.isEmpty()) {
            System.out.println("❌ Cannot refresh data: updatedStudents is null or empty! Keeping old data.");
            return;
        }

        this.students = updatedStudents;
        System.out.println("🔄 Refreshing data... New size: " + students.size());

        updateAllCharts();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        pnlBar = new GUI.CustomComponents.BarGraphPanel();
        stuPie = new GUI.CustomComponents.PieChartPanel();
        stuOverall = new GUI.CustomComponents.DraggableTotalStudentsPanel();
        stuMale = new GUI.CustomComponents.TotalMaleStudentsPanel();
        stuFemale = new GUI.CustomComponents.TotalFemaleStudentsPanel();

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "Student Bar Graph", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        pnlBar.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N

        javax.swing.GroupLayout pnlBarLayout = new javax.swing.GroupLayout(pnlBar);
        pnlBar.setLayout(pnlBarLayout);
        pnlBarLayout.setHorizontalGroup(
            pnlBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );
        pnlBarLayout.setVerticalGroup(
            pnlBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout stuPieLayout = new javax.swing.GroupLayout(stuPie);
        stuPie.setLayout(stuPieLayout);
        stuPieLayout.setHorizontalGroup(
            stuPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );
        stuPieLayout.setVerticalGroup(
            stuPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stuPie, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stuPie, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
                .addContainerGap())
        );

        stuOverall.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        stuOverall.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N

        stuMale.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        stuFemale.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(stuOverall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(19, 19, 19)
                        .addComponent(stuMale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(19, 19, 19)
                        .addComponent(stuFemale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stuOverall, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(stuMale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stuFemale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
// public void refreshData(List<studyante> updatedStudents) {
//        this.students = updatedStudents; // Update student list
//        updateBarGraph(); // Refresh the bar graph
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private GUI.CustomComponents.BarGraphPanel pnlBar;
    private GUI.CustomComponents.TotalFemaleStudentsPanel stuFemale;
    private GUI.CustomComponents.TotalMaleStudentsPanel stuMale;
    private GUI.CustomComponents.DraggableTotalStudentsPanel stuOverall;
    private GUI.CustomComponents.PieChartPanel stuPie;
    // End of variables declaration//GEN-END:variables
}
