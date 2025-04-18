import javax.swing.JFrame;

public class textAdventureWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Adventure");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the custom start screen panel
        gameStartScreen startScreen = new gameStartScreen();
        frame.add(startScreen);

        frame.setVisible(true);
    }
}