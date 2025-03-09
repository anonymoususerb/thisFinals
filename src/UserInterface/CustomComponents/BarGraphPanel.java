package UserInterface.CustomComponents;

import java.awt.*;
import java.util.Map;
import javax.swing.JPanel;

public class BarGraphPanel extends JPanel {
    private Map<String, Integer> graphData;

    public void setGraphData(Map<String, Integer> data) {
        this.graphData = data;  // Store data
        repaint();  // Refresh the graph
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set background color
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        if (graphData == null || graphData.isEmpty()) {
            g2d.setColor(Color.RED);
            g2d.drawString("No data to display", 50, 50);
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int barWidth = panelWidth / (graphData.size() + 2); // Spacing
        int maxBarHeight = panelHeight - 50; // Leave space for labels
        int maxValue = graphData.values().stream().max(Integer::compareTo).orElse(1); // Get highest count

        int x = 50;
        Color[] barColors = {Color.BLUE, Color.GREEN, Color.ORANGE, Color.CYAN, Color.MAGENTA}; // Color options
        int colorIndex = 0;

        for (Map.Entry<String, Integer> entry : graphData.entrySet()) {
            int value = entry.getValue();
            int barHeight = (int) ((value / (double) maxValue) * maxBarHeight); // Scale proportionally

            // Set color
            g2d.setColor(barColors[colorIndex % barColors.length]);
            colorIndex++;

            // Draw bar
            g2d.fillRect(x, panelHeight - barHeight - 20, barWidth - 10, barHeight);

            // Draw label below the bar
            g2d.setColor(Color.BLACK);
            g2d.drawString(entry.getKey(), x, panelHeight - 5);
            g2d.drawString(String.valueOf(value), x + (barWidth / 4), panelHeight - barHeight - 25);

            x += barWidth; // Move to next bar position
        }
    }
}