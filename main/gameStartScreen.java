import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameStartScreen extends JPanel {

    public gameStartScreen(JFrame frame) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK); 

        // === TITLE SETUP ===
        JLabel titleLabel = new JLabel("Hollow Wilds"); // Game title label
        titleLabel.setForeground(Color.WHITE); // White text for that nice contrast
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48)); 
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center it horizontally
        titleLabel.setBorder(BorderFactory.createEmptyBorder(100, 0, 50, 0)); // Adds vertical space around the title

        JButton startButton = new JButton("START"); // Big start button to begin the game
        startButton.setFont(new Font("SansSerif", Font.BOLD, 24)); 
        startButton.setFocusPainted(false); //Removes that weird dotted focus outline
        startButton.setBackground(Color.BLACK); 
        startButton.setForeground(Color.WHITE); 
        startButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true)); //Gives it a white border for style
        startButton.setPreferredSize(new Dimension(200, 50)); //Makes the button bigger and easier to click

        // Wrap the button in its own panel to control layout/margins
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK); // Keep everything black
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 100, 0)); // Adds space below the button
        buttonPanel.add(startButton);

        // === ADD COMPONENTS TO MAIN PANEL ===
        add(titleLabel, BorderLayout.NORTH); // Title goes up top
        add(buttonPanel, BorderLayout.SOUTH); // Button goes at the bottom

        //switch the screen to the village scene
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll(); //Clear the current screen
                frame.add(new willMooreVillage()); //Add the next panel (the village scene)
                frame.revalidate(); 
                frame.repaint();  
            }
        });
    }
}
