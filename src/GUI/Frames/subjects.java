/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Frames;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import modelUi.studyante;
import java.util.List;
import modelUi.Subject;
import modelUi.DefaultSubjects;
import java.util.HashSet;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Frame;
import java.io.*;

public class subjects extends javax.swing.JPanel {

    private HashMap<String, DefaultListModel<String>> studentSubjects = new HashMap<>();
    private ArrayList<studyante> students;
    private JLabel lblStudentInfo;
    private DefaultListModel<String> allSubjectsModel = new DefaultListModel<>();

    // File to store subject data
    private static final String SUBJECT_DATA_FILE = "studentSubjects.dat";

    // Reference to the static student list from studentData class
    private static ArrayList<studyante> stu;

    public subjects(ArrayList<studyante> students) {
        // Store the passed list and ensure we're using the latest data
        this.students = students;
        this.stu = studentData.stu; // Get the latest data from studentData

        initComponents();

        lblStudentInfo = new JLabel("Student: - | Course: -");
        lblStudentInfo.setBounds(10, 10, 300, 25);
        add(lblStudentInfo);

        // Load saved subject data
        loadSubjectData();

        // Add a selection listener for the table since there's no mouse click handler
        subjectTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = subjectTable.getSelectedRow();
                if (selectedRow != -1) {
                    String studentId = subjectTable.getValueAt(selectedRow, 0).toString();
                    String studentName = subjectTable.getValueAt(selectedRow, 1).toString();
                    String course = subjectTable.getValueAt(selectedRow, 2).toString();
                    lblStudentInfo.setText("Student: " + studentName + " | Course: " + course);

                    // Get the selected student
                    studyante selectedStudent = null;
                    for (studyante s : students) {
                        if (String.valueOf(s.getStuID()).equals(studentId)) {
                            selectedStudent = s;
                            break;
                        }
                    }

                    if (selectedStudent != null) {
                        // Get or create subject list for this student
                        DefaultListModel<String> model = studentSubjects.get(studentName);

                        // If this is the first time selecting this student, load default subjects
                        if (model == null) {
                            model = new DefaultListModel<>();
                            studentSubjects.put(studentName, model);

                            // Get default subjects for this course and year level
                            List<Subject> defaultSubjects = DefaultSubjects.getDefaultSubjects(
                                    selectedStudent.getCourse(), selectedStudent.getYearLvl());

                            // Add default subjects to the student's model
                            for (Subject subject : defaultSubjects) {
                                String subjectEntry = subject.getCode() + " - " + subject.getDescription();
                                model.addElement(subjectEntry);
                            }

                            System.out.println("Loaded " + model.size() + " default subjects for " + studentName);

                            // Save the updated subject data
                            saveSubjectData();
                        }
                    }
                }
            }
        });

        System.out.println("Subjects panel constructor - Students count: " + (students != null ? students.size() : "null"));
        loadStudents();
    }

    // Constructor overload to include statsPanel
    public subjects(ArrayList<studyante> students, statistics statsPanel) {
        this.students = students;
        this.stu = studentData.stu; // Get the latest data from studentData

        initComponents();

        lblStudentInfo = new JLabel("Student: - | Course: -");
        lblStudentInfo.setBounds(10, 10, 300, 25);
        add(lblStudentInfo);

        // Load saved subject data
        loadSubjectData();

        // Add a selection listener for the table since there's no mouse click handler
        subjectTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = subjectTable.getSelectedRow();
                System.out.println("Selection changed: Row " + selectedRow);

                if (selectedRow != -1) {
                    String studentId = subjectTable.getValueAt(selectedRow, 0).toString();
                    String studentName = subjectTable.getValueAt(selectedRow, 1).toString();
                    String course = subjectTable.getValueAt(selectedRow, 2).toString();
                    lblStudentInfo.setText("Student: " + studentName + " | Course: " + course);

                    // Get the selected student
                    studyante selectedStudent = null;
                    for (studyante s : students) {
                        if (String.valueOf(s.getStuID()).equals(studentId)) {
                            selectedStudent = s;
                            break;
                        }
                    }

                    if (selectedStudent != null) {
                        // First check if student already has assigned subjects
                        DefaultListModel<String> studentModel = studentSubjects.get(studentName);

                        if (studentModel == null || studentModel.isEmpty()) {
                            // If no assigned subjects, create a new model and get available subjects
                            studentModel = new DefaultListModel<>();
                            studentSubjects.put(studentName, studentModel);

                            // Get subjects for this student's course and year level
                            List<Subject> availableSubjects = DefaultSubjects.getDefaultSubjects(
                                    selectedStudent.getCourse(), selectedStudent.getYearLvl());

                            // Add available subjects to the list for display
                            for (Subject subject : availableSubjects) {
                                studentModel.addElement(subject.getCode() + " - " + subject.getDescription());
                            }

                            // Save the updated subject data
                            saveSubjectData();
                        }
                    }
                }
            }
        });

        System.out.println("Subjects panel constructor with statsPanel - Students count: "
                + (students != null ? students.size() : "null"));
        loadStudents();
    }

    // Method to save the student subjects to a file
    private void saveSubjectData() {
        String SUBJECT_DATA_FILE = "studentSubjects.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SUBJECT_DATA_FILE))) {
            // Convert DefaultListModel to serializable ArrayList
            HashMap<String, ArrayList<String>> serializableMap = new HashMap<>();

            for (String studentName : studentSubjects.keySet()) {
                DefaultListModel<String> model = studentSubjects.get(studentName);
                ArrayList<String> subjects = new ArrayList<>();

                for (int i = 0; i < model.getSize(); i++) {
                    subjects.add(model.getElementAt(i));
                }

                serializableMap.put(studentName, subjects);
            }

            oos.writeObject(serializableMap);
            System.out.println("Subject data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving subject data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to load the student subjects from a file
        @SuppressWarnings("unchecked")
    private void loadSubjectData() {
        String SUBJECT_DATA_FILE = "studentSubjects.dat";
        File file = new File(SUBJECT_DATA_FILE);
        if (!file.exists()) {
            System.out.println("No saved subject data found.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            HashMap<String, ArrayList<String>> serializableMap = (HashMap<String, ArrayList<String>>) ois.readObject();

            // Convert back to DefaultListModel
            for (String studentName : serializableMap.keySet()) {
                ArrayList<String> subjects = serializableMap.get(studentName);
                DefaultListModel<String> model = new DefaultListModel<>();

                for (String subject : subjects) {
                    model.addElement(subject);
                }

                studentSubjects.put(studentName, model);
            }

            System.out.println("Subject data loaded successfully for " + serializableMap.size() + " students.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading subject data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void refreshData() {
        // Method to refresh data from studentData class
        this.stu = studentData.stu;
        this.students = studentData.stu;
        loadStudents();
        System.out.println("Data refreshed in subjects panel - Students count: "
                + (students != null ? students.size() : "null"));
    }

    private void loadStudents() {
        DefaultTableModel model = (DefaultTableModel) subjectTable.getModel();
        model.setRowCount(0);

        // Safety check to prevent NullPointerException
        if (students == null || students.isEmpty()) {
            System.out.println("WARNING: No student data to load in subjects panel");
            // Try to get data directly from studentData
            if (studentData.stu != null && !studentData.stu.isEmpty()) {
                students = studentData.stu;
                System.out.println("Loaded " + students.size() + " students from studentData");
            } else {
                System.out.println("No student data available in studentData either");
                return;
            }
        }

        System.out.println("Loading " + students.size() + " students into subjects table");

        // Now populate the table
        for (studyante s : students) {
            model.addRow(new Object[]{
                s.getStuID(),
                s.getLastName() + ", " + s.getFirstName(),
                s.getCourse()
            });
            System.out.println("Added student: " + s.getStuID() + " | " + s.getFullName() + " | " + s.getCourse());
        }
    }

    // Helper method to check if an item already exists in the model
    private boolean containsItem(DefaultListModel<String> model, String item) {
        for (int i = 0; i < model.getSize(); i++) {
            if (model.getElementAt(i).equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        subDelete = new GUI.CustomComponents.MyButton();
        subAdd = new GUI.CustomComponents.MyButton();
        txtSubSearch = new GUI.CustomComponents.MyTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        subjectTable = new GUI.CustomComponents.MyTable();
        btnDisplay = new GUI.CustomComponents.MyButton();

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        subDelete.setBackground(new java.awt.Color(255, 255, 255));
        subDelete.setForeground(new java.awt.Color(0, 0, 0));
        subDelete.setText("DELETE");
        subDelete.setBorderColor(new java.awt.Color(255, 255, 255));
        subDelete.setColor(new java.awt.Color(255, 255, 255));
        subDelete.setColorClick(new java.awt.Color(204, 204, 204));
        subDelete.setColorOver(new java.awt.Color(153, 153, 153));
        subDelete.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        subDelete.setRadius(40);
        subDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subDeleteActionPerformed(evt);
            }
        });

        subAdd.setBackground(new java.awt.Color(255, 255, 255));
        subAdd.setForeground(new java.awt.Color(0, 0, 0));
        subAdd.setText("ADD");
        subAdd.setBorderColor(new java.awt.Color(255, 255, 255));
        subAdd.setColor(new java.awt.Color(255, 255, 255));
        subAdd.setColorClick(new java.awt.Color(204, 204, 204));
        subAdd.setColorOver(new java.awt.Color(153, 153, 153));
        subAdd.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        subAdd.setRadius(40);
        subAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subAddActionPerformed(evt);
            }
        });

        txtSubSearch.setForeground(new java.awt.Color(0, 0, 0));
        txtSubSearch.setText("Search student data");
        txtSubSearch.setCustomIcon1(new javax.swing.ImageIcon(getClass().getResource("/Icon/Github-Octicons-Search-16.24.png"))); // NOI18N

        subjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Course"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(subjectTable);

        btnDisplay.setBackground(new java.awt.Color(255, 255, 255));
        btnDisplay.setForeground(new java.awt.Color(0, 0, 0));
        btnDisplay.setText("SUBJECTS");
        btnDisplay.setBorderColor(new java.awt.Color(255, 255, 255));
        btnDisplay.setColor(new java.awt.Color(255, 255, 255));
        btnDisplay.setColorClick(new java.awt.Color(204, 204, 204));
        btnDisplay.setColorOver(new java.awt.Color(153, 153, 153));
        btnDisplay.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        btnDisplay.setRadius(40);
        btnDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(subAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(subDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(txtSubSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSubSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void subDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subDeleteActionPerformed
        int selectedRow = subjectTable.getSelectedRow();
        if (selectedRow != -1) {
            String studentName = subjectTable.getValueAt(selectedRow, 1).toString();

            // Check if student has any subjects assigned
            DefaultListModel<String> model = studentSubjects.get(studentName);
            if (model == null || model.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No subjects found for this student to delete.",
                        "No Subjects",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Create dialog to select subjects to delete
            JDialog dialog = new JDialog();
            dialog.setTitle("Delete Subjects");
            dialog.setModal(true);
            dialog.setSize(400, 300);
            dialog.setLocationRelativeTo(this);

            JPanel panel = new JPanel(new BorderLayout());

            JList<String> subjectList = new JList<>(model);
            JScrollPane scrollPane = new JScrollPane(subjectList);
            panel.add(scrollPane, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton deleteButton = new JButton("Delete Selected");
            JButton cancelButton = new JButton("Cancel");

            buttonPanel.add(deleteButton);
            buttonPanel.add(cancelButton);
            panel.add(buttonPanel, BorderLayout.SOUTH);

            dialog.add(panel);

            deleteButton.addActionListener(e -> {
                int[] indices = subjectList.getSelectedIndices();
                if (indices.length > 0) {
                    // Remove in reverse order to avoid index shifting issues
                    for (int i = indices.length - 1; i >= 0; i--) {
                        model.remove(indices[i]);
                    }

                    // Save changes to file
                    saveSubjectData();

                    JOptionPane.showMessageDialog(dialog,
                            "Selected subjects have been removed.",
                            "Subjects Removed",
                            JOptionPane.INFORMATION_MESSAGE);
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog,
                            "Please select at least one subject to delete.",
                            "No Selection",
                            JOptionPane.WARNING_MESSAGE);
                }
            });

            cancelButton.addActionListener(e -> dialog.dispose());

            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Please select a student first.",
                    "No Selection",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_subDeleteActionPerformed

    private void subAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subAddActionPerformed
        int[] selectedRows = subjectTable.getSelectedRows();
        System.out.println("Selected rows count: " + selectedRows.length);

        if (selectedRows.length == 0) {
            // Try to ensure selection is recognized
            selectedRows = subjectTable.getSelectedRows();
            if (selectedRows.length == 0) {
                JOptionPane.showMessageDialog(this,
                        "Please select at least one student.",
                        "No Selection",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        // Process each selected student
        for (int selectedRow : selectedRows) {
            String studentId = subjectTable.getValueAt(selectedRow, 0).toString();
            String studentName = subjectTable.getValueAt(selectedRow, 1).toString();
            String course = subjectTable.getValueAt(selectedRow, 2).toString();

            // Get the selected student
            studyante selectedStudent = null;
            for (studyante s : students) {
                if (String.valueOf(s.getStuID()).equals(studentId)) {
                    selectedStudent = s;
                    break;
                }
            }

            if (selectedStudent == null) {
                JOptionPane.showMessageDialog(this,
                        "Could not find data for student: " + studentName,
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                continue; // Skip this student and move to next
            }

            // Get student's existing subjects - make this final or effectively final
            final DefaultListModel<String> studentModel = studentSubjects.computeIfAbsent(studentName, k -> new DefaultListModel<>());

            // Create a model of available subjects for this course/year
            DefaultListModel<String> availableSubjectsModel = new DefaultListModel<>();

            // Store the student reference in a final variable for lambda use
            final studyante finalSelectedStudent = selectedStudent;

            // Get all possible subjects for this course/year
            List<Subject> allPossibleSubjects = DefaultSubjects.getDefaultSubjects(
                    finalSelectedStudent.getCourse(), finalSelectedStudent.getYearLvl());

            // Convert to set of codes for easy checking
            Set<String> enrolledSubjectCodes = new HashSet<>();
            for (int i = 0; i < studentModel.size(); i++) {
                String subjectEntry = studentModel.getElementAt(i);
                String code = subjectEntry.split(" - ")[0];
                enrolledSubjectCodes.add(code);
            }

            // Add subjects that aren't already enrolled in
            for (Subject subject : allPossibleSubjects) {
                if (!enrolledSubjectCodes.contains(subject.getCode())) {
                    availableSubjectsModel.addElement(subject.getCode() + " - " + subject.getDescription());
                }
            }

            // If no available subjects
            if (availableSubjectsModel.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No additional subjects available for student: " + studentName,
                        "No Available Subjects",
                        JOptionPane.INFORMATION_MESSAGE);
                continue; // Skip this student and move to next
            }

            // Create dialog for subject selection
            JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Add Subjects for " + studentName, true);
            dialog.setSize(400, 300);
            dialog.setLocationRelativeTo(this);

            JPanel panel = new JPanel(new BorderLayout());

            JList<String> subjectList = new JList<>(availableSubjectsModel);
            // Enable multiple selection in the subject list
            subjectList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            JScrollPane scrollPane = new JScrollPane(subjectList);
            panel.add(scrollPane, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton addSubjectsButton = new JButton("Add Selected");
            JButton cancelButton = new JButton("Cancel");

            buttonPanel.add(addSubjectsButton);
            buttonPanel.add(cancelButton);
            panel.add(buttonPanel, BorderLayout.SOUTH);

            dialog.add(panel);

            addSubjectsButton.addActionListener(e1 -> {
                int[] indices = subjectList.getSelectedIndices();
                if (indices.length > 0) {
                    for (int index : indices) {
                        String subject = availableSubjectsModel.getElementAt(index);
                        studentModel.addElement(subject);
                    }

                    // Save changes to file
                    saveSubjectData();

                    JOptionPane.showMessageDialog(dialog,
                            "Selected subjects have been added for " + studentName,
                            "Subjects Added",
                            JOptionPane.INFORMATION_MESSAGE);
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog,
                            "Please select at least one subject to add.",
                            "No Selection",
                            JOptionPane.WARNING_MESSAGE);
                }
            });

            cancelButton.addActionListener(e1 -> dialog.dispose());

            // Make sure to pack and set dialog to visible
            dialog.pack();
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_subAddActionPerformed

    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayActionPerformed
        int selectedRow = subjectTable.getSelectedRow();
        if (selectedRow != -1) {
            String studentName = subjectTable.getValueAt(selectedRow, 1).toString();

            // Get subject list for this student
            DefaultListModel<String> model = studentSubjects.get(studentName);
            if (model == null || model.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No subjects found for this student.",
                        "No Subjects",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Display the subjects in a dialog
            JDialog dialog = new JDialog();
            dialog.setTitle("Subjects for " + studentName);
            dialog.setModal(true);
            dialog.setSize(500, 400);
            dialog.setLocationRelativeTo(this);

            JPanel panel = new JPanel(new BorderLayout());

            JList<String> subjectList = new JList<>(model);
            JScrollPane scrollPane = new JScrollPane(subjectList);
            panel.add(scrollPane, BorderLayout.CENTER);

            JButton closeButton = new JButton("Close");
            closeButton.addActionListener(e -> dialog.dispose());

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(closeButton);
            panel.add(buttonPanel, BorderLayout.SOUTH);

            dialog.add(panel);
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Please select a student first.",
                    "No Selection",
                    JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnDisplayActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.CustomComponents.MyButton btnDisplay;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.CustomComponents.MyButton subAdd;
    private GUI.CustomComponents.MyButton subDelete;
    private GUI.CustomComponents.MyTable subjectTable;
    private GUI.CustomComponents.MyTextField txtSubSearch;
    // End of variables declaration//GEN-END:variables
}
