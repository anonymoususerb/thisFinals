package GUI.CustomComponents;

import javax.swing.*;
import java.awt.*;

public class PieChartPanel extends JPanel {
    private int enrolled = 0, dropped = 0, unenrolled = 0;

    public PieChartPanel() {
        setPreferredSize(new Dimension(200, 200)); // 🟠 Square panel
        setBackground(Color.WHITE);
    }

    // ✅ Method to update student counts and refresh UI
    public void setStudentData(int enrolled, int dropped, int unenrolled) {
        this.enrolled = enrolled;
        this.dropped = dropped;
        this.unenrolled = unenrolled;
        System.out.println("✅ Pie Chart Updated: Enrolled=" + enrolled + ", Dropped=" + dropped + ", Unenrolled=" + unenrolled);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int total = enrolled + dropped + unenrolled;
        if (total == 0) return; // Prevent division by zero

        // 🎨 Colors
        Color enrolledColor = new Color(0, 153, 76);   // Green
        Color droppedColor = new Color(204, 0, 0);     // Red
        Color unenrolledColor = new Color(255, 165, 0); // Orange

        // 🥧 Pie chart calculations
        int startAngle = 0;
        int enrolledAngle = (int) Math.round(360.0 * enrolled / total);
        int droppedAngle = (int) Math.round(360.0 * dropped / total);
        int unenrolledAngle = 360 - (enrolledAngle + droppedAngle); // Remaining angle

        // 🎨 Draw pie slices
        int pieSize = 150; // Increased pie size
        int pieX = (getWidth() - pieSize) / 2;
        int pieY = (getHeight() - pieSize) / 4;

        g2d.setColor(enrolledColor);
        g2d.fillArc(pieX, pieY, pieSize, pieSize, startAngle, enrolledAngle);

        g2d.setColor(droppedColor);
        g2d.fillArc(pieX, pieY, pieSize, pieSize, startAngle + enrolledAngle, droppedAngle);

        g2d.setColor(unenrolledColor);
        g2d.fillArc(pieX, pieY, pieSize, pieSize, startAngle + enrolledAngle + droppedAngle, unenrolledAngle);

        // 🏷️ Legend (bottom)
        g2d.setFont(new Font("Segoe Print", Font.BOLD, 12));
        int legendY = getHeight() - 40;
        drawLegend(g2d, enrolledColor, "Enrolled: " + enrolled, 20, legendY);
        drawLegend(g2d, droppedColor, "Dropped: " + dropped, 120, legendY);
        drawLegend(g2d, unenrolledColor, "Unenrolled: " + unenrolled, 220, legendY);
    }

    private void drawLegend(Graphics2D g2d, Color color, String text, int x, int y) {
        g2d.setColor(color);
        g2d.fillRect(x, y, 10, 10);
        g2d.setColor(Color.BLACK);
        g2d.drawString(text, x + 15, y + 10);
    }
}
