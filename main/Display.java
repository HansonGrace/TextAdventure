import javax.swing.JFrame;
import java.awt.Canvas;

public class Display extends Canvas implements Runnable {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "NOTITLE pre-alpha 0.01";

    private Thread thread;
    private boolean running = false;

    // if already running dont initialize the game again
    private void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();

        System.out.println("Game started!");
    }

    public void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    public void run() {
        while (running) {

        }
    }

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

        game.start();

    }
}
