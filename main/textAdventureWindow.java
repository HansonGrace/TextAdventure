import javax.swing.JFrame;

public class textAdventureWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hollow Wilds");
        frame.setSize(800, 600); // or any default size you want
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true); // allow manual fullscreen via maximize

        gameStartScreen startScreen = new gameStartScreen(frame);
        frame.add(startScreen);

        frame.setVisible(true);
    }
}
