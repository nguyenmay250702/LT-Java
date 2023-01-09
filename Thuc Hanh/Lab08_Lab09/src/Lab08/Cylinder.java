package Lab08;

//hình trụ
public class Cylinder extends Circle{
	private double height = 1.0;

	public Cylinder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cylinder(double height) {
		super();
		this.height = height;
	}
	
	public Cylinder(double radius, double height) {
		super(radius);
		this.height = height;
	}

	public double getHeight() {
		return height;
	}
	
	//diện tích hình trụ
	public double getArea() {
		return 2*Math.PI*this.getRadius()*this.height + 2*super.getArea();
	}
	
	//thể tích hình trụ
	public double getVolume() {
		return super.getArea()*height;
	}

	@Override
	public String toString() {
		return super.toString() + " height=" + this.height;
	}
	
	
	
}
