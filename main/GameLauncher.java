import javax.swing.*;

public class GameLauncher {
    private JFrame frame;

    public GameLauncher() {
        frame = new JFrame("Super Cool Game!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        showStartScreen();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void showStartScreen() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new StartScreen(this));
        frame.revalidate();
        frame.repaint();
    }

    public void launchGame() {
        frame.getContentPane().removeAll();
        Display game = new Display();
        frame.getContentPane().add(game);
        frame.revalidate();
        frame.repaint();
        game.start();
        game.requestFocus();
    }

    public static void main(String[] args) {
        new GameLauncher();
    }
}
