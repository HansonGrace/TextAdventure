import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

/** 
 * 
 * @Author Grace Hanson
 * @brief This class creates the WillMooreVillage screen for the game "Hollow Wilds".
 * It includes a text area for dialogue, an inventory button, and an inventory panel.
 * The text area displays a typing effect for the story intro, and the inventory panel shows items and their amounts.
 */
public class willMooreVillage extends JPanel {
    private JTextArea textArea;
    private String message = "You awaken in the quiet town of WillMoore...";
    private int index = 0;

    private JPanel inventoryPanel;

    public willMooreVillage() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // === TOP PANEL with LARGER INVENTORY BUTTON ===
        JButton inventoryButton = new JButton("INVENTORY");
        inventoryButton.setFont(new Font("SansSerif", Font.BOLD, 18)); // Increased font size
        inventoryButton.setFocusPainted(false);
        inventoryButton.setBackground(Color.BLACK);
        inventoryButton.setForeground(Color.WHITE);
        inventoryButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        inventoryButton.setPreferredSize(new Dimension(200, 50)); // Increased button size

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.setBackground(Color.BLACK);
        topPanel.add(inventoryButton);

        // === TEXT BOX (dialogue-style at bottom) ===
        textArea = new JTextArea();
        textArea.setFont(new Font("Serif", Font.PLAIN, 22));
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setBackground(new Color(0, 0, 0, 180));
        textArea.setForeground(Color.WHITE);
        textArea.setMargin(new Insets(15, 15, 15, 15));
        textArea.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));

        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBackground(Color.BLACK);
        textPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 100, 50));
        textPanel.add(textArea, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.SOUTH);

        // === INVENTORY PANEL (hidden by default) ===
        inventoryPanel = createInventoryPanel();
        inventoryPanel.setVisible(false);
        add(inventoryPanel, BorderLayout.EAST); // adds it on the side but it looks like a popup

        // === Button Logic ===
        inventoryButton.addActionListener(e -> inventoryPanel.setVisible(true));

        startTypingEffect();
    }

    // === Inventory Panel Setup ===
    private JPanel createInventoryPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(250, 150));
        panel.setBackground(Color.DARK_GRAY);
        panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));

        // === Table setup ===
        String[] columnNames = {"Item", "Amount"};
        Object[][] data = {
            {"COINS", 0},
            {"ARROWS", 0},
            {"SWORDS", 0},
            {"FOODS", 0}
        };

        JTable table = new JTable(data, columnNames);
        table.setEnabled(false);
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.setRowHeight(24);
        JScrollPane scrollPane = new JScrollPane(table);

        // === X Button ===
        JButton closeButton = new JButton("X");
        closeButton.setFocusPainted(false);
        closeButton.setFont(new Font("SansSerif", Font.BOLD, 12));
        closeButton.setBackground(Color.BLACK);
        closeButton.setForeground(Color.WHITE);
        closeButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        closeButton.addActionListener(e -> panel.setVisible(false));

        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topBar.setBackground(Color.DARK_GRAY);
        topBar.add(closeButton);

        panel.add(topBar, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // === Typing animation for story intro ===
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
