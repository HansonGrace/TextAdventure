import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Grace Hanson
 * @brief This class creates the start screen for the game "Hollow Wilds".
 * It includes a title and a start button that transitions to the WillMooreVillage screen.
 */
public class gameStartScreen extends JPanel {

    public gameStartScreen(JFrame frame) {
        setLayout(new BorderLayout()); // Proper responsive layout
        setBackground(Color.BLACK);

        // === TITLE ===
        JLabel titleLabel = new JLabel("Hollow Wilds");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(100, 0, 50, 0));

        // === START BUTTON ===
        JButton startButton = new JButton("START");
        startButton.setFont(new Font("SansSerif", Font.BOLD, 24));
        startButton.setFocusPainted(false);
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        startButton.setPreferredSize(new Dimension(200, 50));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 100, 0));
        buttonPanel.add(startButton);

        // Add to layout
        add(titleLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        // Start button functionality: go to the WillMooreVillage screen
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(new willMooreVillage());
                frame.revalidate();
                frame.repaint();
            }
        });
    }
}
