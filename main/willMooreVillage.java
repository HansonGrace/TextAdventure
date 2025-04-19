import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class willMooreVillage extends JPanel {
    private JTextArea textArea;
    private String message = "You awaken in the quiet town of WillMoore...";
    private int index = 0;

    public willMooreVillage() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // Text area styled as a thought box
        textArea = new JTextArea();
        textArea.setFont(new Font("Serif", Font.PLAIN, 22)); // Slightly bigger
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setBackground(new Color(0, 0, 0, 180));
        textArea.setForeground(Color.WHITE);
        textArea.setMargin(new Insets(15, 15, 15, 15));
        textArea.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));

        // Just a little bit higher than before (was 50px bottom margin before)
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBackground(Color.BLACK);
        textPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 100, 50)); // small upward shift
        textPanel.add(textArea, BorderLayout.SOUTH);

        add(textPanel, BorderLayout.SOUTH);

        startTypingEffect();
    }

    private void startTypingEffect() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (index < message.length()) {
                    textArea.append(Character.toString(message.charAt(index)));
                    index++;
                } else {
                    timer.cancel();
                }
            }
        }, 0, 50);
    }
}
