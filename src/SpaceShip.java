import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.concurrent.RecursiveTask;

public class SpaceShip {
    private Vector2D position;
    private int size, speed;
    private Color color;

    public SpaceShip(Vector2D position, Color color,int size, int speed) {
        this.position = position;
        this.size = size;
        this.speed = speed;
        this.color = color;
    }

    public SpaceShip(){
        this(new Vector2D((Constants.maxWidth - Constants.spaceShipSize) / 2,
                        Constants.maxHeight - 3 * Constants.spaceShipSize),
                Constants.spaceShipColor,
                Constants.spaceShipSize, Constants.spaceShipSpeed);
    }

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Rectangle2D getBox(){
        return new Rectangle2D.Float(position.getX(),position.getY(), size,size);
    }
}
