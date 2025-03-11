/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Frames;

import modelUi.studyante;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Asus
 */
public class DashboardSidButtons extends javax.swing.JFrame {

    private ArrayList<studyante> stu; // Store student list
    private statistics statsPanel; // Store statistics panel
     private home homePanel; 
    
    public DashboardSidButtons(ArrayList<studyante> students) {
        this.stu = students;
        this.statsPanel = new statistics(stu); // Create statistics panel once
        this.homePanel = new home(); // Create home panel once
        initComponents();
        this.setLocationRelativeTo(null);

        // ✅ Show Home panel on startup
        ViewPanel.setViewportView(homePanel);
    }

    // ✅ Method to switch to Statistics Panel
    private void switchToStatistics() {
        statsPanel.refreshData(stu); // Update data before showing
        ViewPanel.setViewportView(statsPanel); // Show existing panel
        ViewPanel.revalidate(); // Refresh UI
        ViewPanel.repaint();
    }

    // ✅ Label Hover Effects
    public void LblHover(JLabel lbl) {
        lbl.setForeground(Color.WHITE);
        lbl.setFont(new java.awt.Font("Segoe Print", 1, 26));
    }

    public void LblHoverOut(JLabel lbl) {
        lbl.setForeground(Color.WHITE);
        lbl.setFont(new java.awt.Font("Segoe Print", 0, 24));
    }

    public void LblHoverOutwo(JLabel lbl) {
        lbl.setForeground(Color.WHITE);
        lbl.setFont(new java.awt.Font("Segoe Print", 0, 23));
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
        lblStatistics = new javax.swing.JLabel();
        lblStuData = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ViewPanel = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblStatistics.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        lblStatistics.setForeground(new java.awt.Color(255, 255, 255));
        lblStatistics.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatistics.setText("STATISTICS");
        lblStatistics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStatisticsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblStatisticsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblStatisticsMouseExited(evt);
            }
        });

        lblStuData.setFont(new java.awt.Font("Segoe Print", 1, 23)); // NOI18N
        lblStuData.setForeground(new java.awt.Color(255, 255, 255));
        lblStuData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStuData.setText("STUDENTS INFO");
        lblStuData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStuDataMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblStuDataMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblStuDataMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LOG OUT");

        lblHome.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        lblHome.setForeground(new java.awt.Color(255, 255, 255));
        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHome.setText("HOME");
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHomeMouseExited(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Dark Blue and Gold  Circle Logo_300x300.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStuData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(lblHome)
                .addGap(18, 18, 18)
                .addComponent(lblStuData, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(51, 51, 51))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 29)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Information System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ViewPanel)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(ViewPanel)))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblStuDataMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStuDataMouseExited
        LblHoverOutwo(lblStuData);
    }//GEN-LAST:event_lblStuDataMouseExited

    private void lblStuDataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStuDataMouseEntered
        LblHover(lblStuData);
    }//GEN-LAST:event_lblStuDataMouseEntered

    private void lblStuDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStuDataMouseClicked
        ViewPanel.setViewportView(new studentData(stu, statsPanel));
    }//GEN-LAST:event_lblStuDataMouseClicked

    private void lblStatisticsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStatisticsMouseExited
        LblHoverOut(lblStatistics);
    }//GEN-LAST:event_lblStatisticsMouseExited

    private void lblStatisticsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStatisticsMouseEntered
        LblHover(lblStatistics);
    }//GEN-LAST:event_lblStatisticsMouseEntered

    private void lblStatisticsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStatisticsMouseClicked
        switchToStatistics();
    }//GEN-LAST:event_lblStatisticsMouseClicked

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        ViewPanel.setViewportView(homePanel);
        ViewPanel.revalidate();
        ViewPanel.repaint();
    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseEntered
        LblHover(lblHome);
    }//GEN-LAST:event_lblHomeMouseEntered

    private void lblHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseExited
        LblHoverOut(lblHome);
    }//GEN-LAST:event_lblHomeMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            ArrayList<studyante> students = new ArrayList<>();
            new DashboardSidButtons(students).setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ViewPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblStatistics;
    private javax.swing.JLabel lblStuData;
    // End of variables declaration//GEN-END:variables
}
