package Lab04;

public class MyCircle {
	private MyPoint center;
	private int radius = 1;
	
	//MyPoint p = new MyPoint();
	public MyCircle(int x, int y, int radius) {
		super();
		center = new MyPoint(x,y);
		this.radius = radius;
	}

	public MyCircle(MyPoint center, int radius) {
		super();
		this.center = center;
		this.radius = radius;
	}

	public MyPoint getCenter() {
		return center;
	}

	public void setCenter(MyPoint center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public int getCenterX() {
		return this.center.getX();
	}
	
	public int getCenterY() {
		return this.center.getY();
	}
	
	public void setCenterXY(int x, int y) {
		this.center.setXY(x, y);
	}

	public String toString() {
		return "MyCircle [center=" + center + ", radius=" + radius + "]";
	}
	
	public double getArea() {
		return Math.PI*radius*radius;
	}
}
