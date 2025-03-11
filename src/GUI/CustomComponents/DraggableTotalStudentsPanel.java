package GUI.CustomComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class DraggableTotalStudentsPanel extends JPanel {
    private int totalStudents = 0; // Holds total student count
    private int mouseX, mouseY;
    private ImageIcon userGroupIcon;

    public DraggableTotalStudentsPanel() {
        setPreferredSize(new Dimension(150, 150)); // 🔳 Square shape
        setBackground(Color.WHITE); // ⚪ White Background
        setLayout(null); // No automatic layout

        // Load the user group icon safely
        URL iconUrl = getClass().getResource("/Icon/user_group.png");
        if (iconUrl != null) {
            userGroupIcon = new ImageIcon(iconUrl);
        } else {
            System.err.println("⚠ Warning: Icon not found! Check the path.");
            userGroupIcon = null;
        }

        // Enable dragging functionality
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point location = getLocation();
                setLocation(location.x + e.getX() - mouseX, location.y + e.getY() - mouseY);
            }
        });
    }

    // ✅ Method to update total students and force UI refresh
    public void setTotalStudents(int total) {
        this.totalStudents = total;
        System.out.println("✅ Updating Total Students: " + total); // Debugging

        // ✅ Ensure UI refresh
        revalidate();
        repaint();
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

        // Draw user group icon (centered)
        if (userGroupIcon != null) {
            int iconSize = 40;
            int iconX = (getWidth() - iconSize) / 2;
            int iconY = (getHeight() - iconSize) / 4;
            g2d.drawImage(userGroupIcon.getImage(), iconX, iconY, iconSize, iconSize, this);
        }

        // Display total students (centered below icon)
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Segoe Print", Font.BOLD, 18));
        String text = "Total Students: " + totalStudents;
        FontMetrics fm = g2d.getFontMetrics();
        int textX = (getWidth() - fm.stringWidth(text)) / 2;
        int textY = getHeight() - 30;
        g2d.drawString(text, textX, textY);
    }
}
