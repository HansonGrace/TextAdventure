import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameStartScreen extends JPanel {

    public gameStartScreen(JFrame frame) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // Title
        JLabel titleLabel = new JLabel("Hollow Wilds");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(80, 0, 0, 0)); // Top padding

        // START Button
        JButton startButton = new JButton("START");
        startButton.setFont(new Font("SansSerif", Font.BOLD, 24));
        startButton.setFocusPainted(false);
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        startButton.setPreferredSize(new Dimension(200, 50));

        // Center button in panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 80, 0)); // space below title
        buttonPanel.add(startButton);

        // Add to layout
        add(titleLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button action - switch to WillMooreVillage in same window
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll(); // clear current screen
                frame.add(new willMooreVillage());  // add village screen
                frame.revalidate(); // refresh layout
                frame.repaint();    // repaint updated UI
            }
        });
    }
}
