package GUI.CustomComponents;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class TotalFemaleStudentsPanel extends JPanel {
    private int totalFemales = 0; // Holds total female count
    private ImageIcon femaleIcon;

    public TotalFemaleStudentsPanel() {
        setPreferredSize(new Dimension(150, 150)); // 🔳 Square shape
        setBackground(Color.WHITE); // ⚪ White Background
        setLayout(null); // No automatic layout

        // Load the female icon safely
        URL iconUrl = getClass().getResource("/Icon/Female.png");
        if (iconUrl != null) {
            femaleIcon = new ImageIcon(iconUrl);
        } else {
            System.err.println("⚠ Warning: Female icon not found! Check the path.");
            femaleIcon = null;
        }
    }

    // ✅ Standardized method name to match `statistics.java`
    public void setTotalStudents(int total) {
        this.totalFemales = total;
        System.out.println("✅ Updating Total Females: " + total); // Debugging
        repaint(); // Only repaint needed
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Background with rounded corners (white)
        g2d.setColor(Color.WHITE);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        // Gray border for a subtle look
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 20, 20);

        // Draw female icon (centered)
        if (femaleIcon != null) {
            int iconSize = 40;
            int iconX = (getWidth() - iconSize) / 2;
            int iconY = (getHeight() - iconSize) / 4;
            g2d.drawImage(femaleIcon.getImage(), iconX, iconY, iconSize, iconSize, this);
        }

        // Display total females (centered below icon)
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Segoe Print", Font.BOLD, 18));
        String text = "Female: " + totalFemales;
        FontMetrics fm = g2d.getFontMetrics();
        int textX = (getWidth() - fm.stringWidth(text)) / 2;
        int textY = getHeight() - 30;
        g2d.drawString(text, textX, textY);
    }
}
