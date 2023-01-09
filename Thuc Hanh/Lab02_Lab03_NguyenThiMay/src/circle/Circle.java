package circle;

public class Circle {
	private double radius;
	private String color;
	
	public Circle() {
		this.radius = 1.0;
		this.color = "red";
	}
	
	public Circle(double r) {
		this.radius = r;
		this.color = "red";
	}
	
	public Circle(double r, String c) {
		this.radius = r;
		this.color = c;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public double getArea() {
		return this.radius*this.radius*Math.PI;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setRadius(double r) {
		this.radius = r;
	}
	
	public void setColor(String c) {
		this.color = c;
	}
	
	public String toString() {
		return "Circle: radius = " + radius + ", color = " + color;
	}
}








