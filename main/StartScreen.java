import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartScreen extends JPanel {
    private final GameLauncher launcher;

    public StartScreen(GameLauncher launcher) {
        this.launcher = launcher;
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Rectangle startButton = new Rectangle(325, 300, 150, 50);
                if (startButton.contains(e.getPoint())) {
                    launcher.launchGame();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        g.drawString("NO NAME", 270, 200);

        g.setColor(Color.WHITE);
        g.fillRect(325, 300, 150, 50);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("START", 360, 335);
    }
}
