import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Asteroid {
    private Vector2D position;
    private int size, speed;
    private Color color;

    public Asteroid(Vector2D position, int size, int speed, Color color) {
        this.position = position;
        this.size = size;
        this.color = color;
        this.speed = speed;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Ellipse2D getBox() {
        return new Ellipse2D.Float(position.getX(), position.getY(), size, size);
    }

}
