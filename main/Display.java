import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.event.*;

public class Display extends Canvas implements Runnable, KeyListener, MouseMotionListener {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "NOTITLE pre-alpha 0.01";

    private Thread thread;
    private boolean running = false;

    private boolean[] keys = new boolean[256];
    private double px = 0, py = 0, angle = 0;

    private Robot robot;
    private boolean ignoreNextMouseEvent = false;

    public Display() {
        addKeyListener(this);
        addMouseMotionListener(this);
        setFocusable(true);
        setBackground(Color.BLACK);

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
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
        createBufferStrategy(3);
        BufferStrategy bs = getBufferStrategy();

        long lastTime = System.nanoTime();
        double nsPerUpdate = 1e9 / 60.0;

        while (running) {
            long now = System.nanoTime();
            while (now - lastTime > nsPerUpdate) {
                update();
                lastTime += nsPerUpdate;
            }

            Graphics g = bs.getDrawGraphics();
            render(g);
            g.dispose();
            bs.show();

            try {
                Thread.sleep(2);
            } catch (InterruptedException ignored) {
            }
        }
    }

    private void update() {
        double speed = 0.1;
        if (keys[KeyEvent.VK_W]) {
            px += Math.cos(angle) * speed;
            py += Math.sin(angle) * speed;
        }
        if (keys[KeyEvent.VK_S]) {
            px -= Math.cos(angle) * speed;
            py -= Math.sin(angle) * speed;
        }
        if (keys[KeyEvent.VK_A])
            angle -= 0.03;
        if (keys[KeyEvent.VK_D])
            angle += 0.03;
    }

    private void render(Graphics g) {
        g.setColor(new Color(135, 206, 235));
        g.fillRect(0, 0, WIDTH, HEIGHT / 2);

        for (int y = HEIGHT / 2; y < HEIGHT; y++) {
            double dy = y - HEIGHT / 2.0;
            double perspective = 1.0 / dy;

            for (int x = 0; x < WIDTH; x++) {
                double dx = (x - WIDTH / 2.0) * perspective;
                double worldX = px + Math.cos(angle) - dx * Math.sin(angle);
                double worldY = py + Math.sin(angle) + dx * Math.cos(angle);

                int tileSize = 4;
                int tx = (int) Math.floor(worldX / tileSize);
                int ty = (int) Math.floor(worldY / tileSize);
                boolean even = ((tx + ty) % 2 == 0);

                g.setColor(even ? new Color(50, 50, 50) : new Color(30, 30, 30));
                g.fillRect(x, y, 1, 1);
            }
        }
    }

    public void mouseMoved(MouseEvent e) {
        if (ignoreNextMouseEvent) {
            ignoreNextMouseEvent = false;
            return;
        }

        int dx = e.getX() - WIDTH / 2;
        angle += dx * 0.003;

        Point canvasLocation = getLocationOnScreen();
        int cx = canvasLocation.x + WIDTH / 2;
        int cy = canvasLocation.y + HEIGHT / 2;
        robot.mouseMove(cx, cy);

        ignoreNextMouseEvent = true;
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public void keyTyped(KeyEvent e) {
    }
}
