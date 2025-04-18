import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class gameStartScreen extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Fill background black
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Set text color and font
        g.setColor(Color.WHITE);
        g.setFont(new Font("Serif", Font.BOLD, 36));

        // Center the text
        String title = "Hollow Wilds";
        int stringWidth = g.getFontMetrics().stringWidth(title);
        int stringHeight = g.getFontMetrics().getAscent();

        int x = (getWidth() - stringWidth) / 2;
        int y = (getHeight() + stringHeight) / 2;

        g.drawString(title, x, y);
    }
}