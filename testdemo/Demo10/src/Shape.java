import java.awt.*;

public abstract class Shape {
    private double x;
    private double y;
    private Color color;
    private static int screenSize = 10;
    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    protected Shape() {
    }

    public void draw(){
    }
    public void checkColor(){
    }

    @Override
    public String toString() {
        return " x=" + x + ", y=" + y + ", color=" + color;
    }
    //Add getter/setter methods for the private variable by yourself

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public static int getScreenSize() {
        return screenSize;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static void setScreenSize(int screenSize) {
        Shape.screenSize = screenSize;
    }
}
