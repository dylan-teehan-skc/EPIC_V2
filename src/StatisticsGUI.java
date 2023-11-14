
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class StatisticsGUI {
    private static BufferedImage backgroundImage;

    public static void main(String[] args) {
        // Call the ShowStatistics method to display statistics
        ShowStatistics(10, 10, 10, 10, 10);
        File csvFile; // Declare a File object (not used in this context)
    }

    public static void ShowStatistics(int CurrentScore, long CurrentTime, int MeanScore, int SDScores, int MeanTime) {
        JFrame frame;
        JPanel panel;

        // Create a heading for the statistics window
        frame = new JFrame("Show Statistics");
        frame.setSize(500, 500); // Set the window size
        frame.setLocation(250, 200); // Set the window position
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define how to close the application

        try {
            // Load the background image
            backgroundImage = ImageIO.read(new File("your-scores.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create a custom panel for displaying the background image
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    // Draw the background image to cover the panel
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        panel.setOpaque(false); // Make the panel transparent to reveal the background
        frame.setContentPane(panel);
        panel.setLayout(null); // Use absolute positioning for components

        // Customize the font
        Font customFont = new Font("Arial", Font.PLAIN, 25);

        // Create and add labels for each statistic with custom bounds and font
        JLabel currentScoreLabel = createLabel("" + CurrentScore, 325, 138, 380, 20, customFont);
        JLabel currentTimeLabel = createLabel("" + CurrentTime + " seconds", 325, 190, 380, 20, customFont);
        JLabel meanScoreLabel = createLabel("" + MeanScore, 325, 293, 380, 20, customFont);
        JLabel sdScoresLabel = createLabel("" + SDScores, 325, 340, 380, 20, customFont);
        JLabel meanTimeLabel = createLabel(MeanTime + " seconds", 325, 390, 380, 20, customFont);

        // Add all labels to the panel
        panel.add(currentScoreLabel);
        panel.add(currentTimeLabel);
        panel.add(meanScoreLabel);
        panel.add(sdScoresLabel);
        panel.add(meanTimeLabel);

        frame.setVisible(true); // Make the window visible to the user
    }

    private static JLabel createLabel(String text, int x, int y, int width, int height, Font font) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height); // Set the position and size of the label
        label.setFont(font); // Set the font for the label
        return label;
    }
}