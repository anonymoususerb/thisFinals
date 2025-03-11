package GUI.CustomComponents;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class TotalMaleStudentsPanel extends JPanel {
    private int totalMaleStudents = 0;
    private ImageIcon maleIcon;

    public TotalMaleStudentsPanel() {
        setPreferredSize(new Dimension(150, 150));
        setBackground(Color.WHITE);
        setLayout(null);

        // Load Male icon
        URL iconUrl = getClass().getResource("/Icon/Male.png");
        if (iconUrl != null) {
            maleIcon = new ImageIcon(iconUrl);
        } else {
            System.err.println("⚠ Warning: Male icon not found! Check the path.");
            maleIcon = null;
        }
    }

    // ✅ Add this method so statistics.java can call it
    public void setTotalStudents(int count) {
        this.totalMaleStudents = count;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.WHITE);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 20, 20);

        // Draw Male icon
        if (maleIcon != null) {
            int iconSize = 40;
            int iconX = (getWidth() - iconSize) / 2;
            int iconY = (getHeight() - iconSize) / 4;
            g2d.drawImage(maleIcon.getImage(), iconX, iconY, iconSize, iconSize, this);
        }

        // Display total male students
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Segoe Print", Font.BOLD, 18));
        String text = "Male: " + totalMaleStudents;
        FontMetrics fm = g2d.getFontMetrics();
        int textX = (getWidth() - fm.stringWidth(text)) / 2;
        int textY = getHeight() - 30;
        g2d.drawString(text, textX, textY);
    }
}