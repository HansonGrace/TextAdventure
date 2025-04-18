import javax.swing.*;
import java.awt.*;

public class willMooreVillage {

    public static void launch() {
        JFrame frame = new JFrame("WillMoore Village - Level 1");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea area = new JTextArea();
        area.setText("You awaken in the quiet town of WillMoore...");
        area.setFont(new Font("Serif", Font.PLAIN, 18));
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        area.setEditable(false);
        area.setBackground(Color.BLACK);
        area.setForeground(Color.GREEN);
        area.setMargin(new Insets(20, 20, 20, 20));

        frame.add(area);
        frame.setVisible(true);
    }
}