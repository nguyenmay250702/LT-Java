package Lab09;

public class Circle extends Shape {
	protected double radius;

	public Circle() {}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	
	public Circle(double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return Math.PI*this.radius*this.radius;
	}
	
	public double getPerimeter() {
		return Math.PI*this.radius*2;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", màu= " + getColor() +"]";
	}
}
