import java.awt.*;

public class Drawer {
    private Graphics2D graphics2D;

    public Drawer(Graphics2D graphics2D) {
        setGraphics2D(graphics2D);
    }

    private void fillRect(Vector2D vector2D, int size, Color color) {
        graphics2D.setColor(color);
        graphics2D.fillRect(vector2D.getX(), vector2D.getY(), size, size);
    }

    private void fillCircle(Vector2D vector2D, int size, Color color) {
        graphics2D.setColor(color);
        graphics2D.fillOval(vector2D.getX(), vector2D.getY(), size, size);
    }

    public void drawGameState(GameState gameState) {
        for (Asteroid asteroid : gameState.getAsteroids()) {
            fillCircle(asteroid.getPosition(), asteroid.getSize(), asteroid.getColor());
        }
        SpaceShip spaceShip = gameState.getSpaceShip();
        fillRect(spaceShip.getPosition(), spaceShip.getSize(), spaceShip.getColor());
    }

    public void setGraphics2D(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
    }


    public void drawGameOver(Graphics2D graphics2D) {
        String prompt = "Game Over! :(";
        Font font = new Font("Helvetica", Font.BOLD, 50);
        FontMetrics fontMetrics = graphics2D.getFontMetrics(font);
        int width = fontMetrics.stringWidth(prompt);
        graphics2D.setFont(font);
        graphics2D.drawString(prompt, (Constants.maxWidth - width) / 2, (Constants.maxHeight - 50) / 2);

    }
}
