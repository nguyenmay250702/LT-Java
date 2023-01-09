package Lab08;

public class TestCylinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cylinder c1 = new Cylinder();
		System.out.println("C1: " 
							+  "radius = " + c1.getRadius()
							+  " ,height = " + c1.getHeight()
							+  " ,cylindrical area = " + c1.getArea()
							+  " ,volume = " + c1.getVolume()
							+  " ,toString = " + c1.toString());
		
		Cylinder c2 = new Cylinder(10);
		System.out.println("C2: " 
							+  "radius = " + c2.getRadius()
							+  " ,height = " + c2.getHeight()
							+  " ,cylindrical area = " + c2.getArea()
							+  " ,volume = " + c2.getVolume());
		
		Cylinder c3 = new Cylinder(2,10);
		System.out.println("C3: " 
							+  "radius = " + c3.getRadius()
							+  " ,height = " + c3.getHeight()
							+  " ,cylindrical area = " + c3.getArea()
							+  " ,volume = " + c3.getVolume());
	}

}
