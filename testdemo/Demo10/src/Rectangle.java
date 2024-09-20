import java.awt.*;

public class Rectangle extends Shape implements Comparable<Rectangle>,ColorDraw {

	private double width;
	private double height;

	public Rectangle(double x, double y) {
		super(x, y);
	}

	public Rectangle(double x, double y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	public static int getScreenSize() {
		return Shape.getScreenSize();
	}

	public static void setScreenSize(int screenSize) {
		Shape.setScreenSize(screenSize);
	}

	public void checkColor() {
		if (isInBoundary()) {
			super.setColor(Color.GREEN);
		} else {
			super.setColor(Color.RED);
		}
	}

	public boolean isInBoundary() {
		if (-1 * Shape.getScreenSize() > super.getX() - this.width / 2 || Shape.getScreenSize() < super.getX() + this.width / 2) {
			return false;
		}
		if (-1 * Shape.getScreenSize() > super.getY() - this.height / 2 || Shape.getScreenSize() < super.getY() + this.height / 2) {
			return false;
		}
		return true;
	}

	public double getX() {

		return super.getX();
	}

	public void setX(double x) {
		super.setX(x);
	}

	public double getY() {
		return super.getY();
	}

	public void setY(double y) {
		super.setY(y);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String toString() {
		return "Rectangle{" +
				"width=" + width +
				", height=" + height + " x=" + super.getX() +
				", y=" + super.getY() +
//				", color=" + super.getColor().getColor() +
				"}\n";
	}

	public void draw() {
		StdDraw.setPenColor(super.getColor());
		StdDraw.filledRectangle(super.getX(), super.getY(), this.width / 2, this.height / 2);
	}

	@Override
	public int compareTo(Rectangle o) {
		if (this.getX() < o.getX()) {
			return 1;
		} else if (this.getX() > o.getX()) {
			return -1;
		}
		return 0;
	}


	@Override
	public void customizedColor(ColorScheme scheme, int index) {
		Color color;
		if (scheme == ColorScheme.GRAY) {
			color = new Color(index*20, index*20, index*20);
		} else {
			color = Color.BLACK;
		}
		super.setColor(color);
	}
}
