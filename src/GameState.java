import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameState {
    private List<Asteroid> asteroids;
    private static GameState gameState;
    private AsteroidFactory asteroidFactory;
    private SpaceShip spaceShip;
    private Random random;
    private boolean gameOver;


    private GameState() {
        asteroids = new ArrayList<>();
        spaceShip = new SpaceShip();
        asteroidFactory = new AsteroidFactory();
        random = new Random(System.nanoTime());

    }

    public static GameState getInstance() {
        if (gameState == null) gameState = new GameState();
        return gameState;
    }

    public List<Asteroid> getAsteroids() {
        return asteroids;
    }

    public SpaceShip getSpaceShip(){
        return spaceShip;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void makeAsteroid() {
        int chance = random.nextInt(100);
        if (chance <= Constants.asteroidChance) {
            asteroids.add(asteroidFactory.makeAsteroid());
        }
    }

    public void moveSpaceShip(Constants.Direction direction) {
        if (direction == Constants.Direction.UP)spaceShip.getPosition().addY(-spaceShip.getSpeed());
        if (direction == Constants.Direction.DOWN)spaceShip.getPosition().addY(spaceShip.getSpeed());
        if (direction == Constants.Direction.LEFT)spaceShip.getPosition().addX(-spaceShip.getSpeed());
        if (direction == Constants.Direction.RIGHT)spaceShip.getPosition().addX(spaceShip.getSpeed());
    }
}
