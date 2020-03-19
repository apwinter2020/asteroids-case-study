import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    private GameState gameState = GameState.getInstance();

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP:
                gameState.moveSpaceShip(Constants.Direction.UP);
                break;
            case KeyEvent.VK_RIGHT:
                gameState.moveSpaceShip(Constants.Direction.RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                gameState.moveSpaceShip(Constants.Direction.LEFT);
                break;
            case KeyEvent.VK_DOWN:
                gameState.moveSpaceShip(Constants.Direction.DOWN);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
