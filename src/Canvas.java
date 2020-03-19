import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Canvas extends JComponent {
    private Drawer drawer;
    private GameState gameState;

    public Canvas() {
        gameState = GameState.getInstance();
        addKeyListener(new KeyboardListener());
        Timer timer = new Timer();
        TimerTask timerTask = new Ticker();
        timer.scheduleAtFixedRate(timerTask, 1000, Constants.tickTime);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (drawer == null) drawer = new Drawer(g2d);
        requestFocus();
        drawer.setGraphics2D(g2d);
        if (gameState.isGameOver()) {
                drawer.drawGameOver(g2d);
        } else {
            drawer.drawGameState(gameState);
        }
    }

    private void update() {
        updateAsteroids();
        checkCollisions();
    }

    private void checkCollisions() {
        SpaceShip spaceShip = gameState.getSpaceShip();
        for (Asteroid asteroid : gameState.getAsteroids()) {
            if (asteroid.getBox().intersects(spaceShip.getBox())) {
                gameState.setGameOver(true);
            }
        }
    }

    private void updateAsteroids() {
        gameState.makeAsteroid();
        for (Asteroid asteroid : gameState.getAsteroids()) {
            asteroid.setPosition(new Vector2D(asteroid.getPosition().getX(),
                    asteroid.getPosition().getY() + asteroid.getSpeed()));
        }
    }

    private class Ticker extends TimerTask {
        @Override
        public void run() {
            if (!gameState.isGameOver()) update();
            repaint();
        }
    }
}
