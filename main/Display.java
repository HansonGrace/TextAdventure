import javax.swing.JFrame;
import java.awt.Canvas;

public class Display extends Canvas {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "NOTITLE pre-alpha 0.01";

    // private Thread

    public static void main(String[] args) {
        // new object of Display class
        Display game = new Display();
        JFrame frame = new JFrame();
        frame.add(game);
        frame.pack();
        frame.setTitle(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(WIDTH, HEIGHT);

    }
}
