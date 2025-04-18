import javax.swing.JFrame;

public class textAdventureWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hollow Wilds");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        gameStartScreen startScreen = new gameStartScreen(frame);
        frame.add(startScreen);

        frame.setVisible(true);
    }
}
