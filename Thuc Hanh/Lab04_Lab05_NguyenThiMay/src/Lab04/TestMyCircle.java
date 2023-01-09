package Lab04;

public class TestMyCircle {

	public static void main(String[] args) {
		MyCircle c1 = new MyCircle(0,2,3);
		MyCircle c2 = new MyCircle(new MyPoint(1,1), 2);
		
		System.out.println("Thông tin đường tròn c1: " + c1.toString() + ", diện tích = " + c1.getArea());
		
		System.out.println("Thông tin đường tròn c2: " + c2.toString() + ", diện tích = " + c2.getArea());

	}
}
