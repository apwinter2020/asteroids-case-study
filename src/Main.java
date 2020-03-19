import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GameState gameState = GameState.getInstance();
        Canvas canvas = new Canvas();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(canvas);
        frame.setSize(Constants.maxWidth, Constants.maxHeight);
        frame.setTitle("Asteroids");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
