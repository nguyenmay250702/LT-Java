package Lab04;

public class TestMyTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTriangle t1 = new MyTriangle(new MyPoint(2,2), new MyPoint(3,3), new MyPoint(4,4));
		MyTriangle t2 = new MyTriangle(new MyPoint(2,0), new MyPoint(3,1), new MyPoint(4,5));
		System.out.println("t1 là: " + t1.printType() + ", có chu vi là: " + t1.getPerimeter());
		System.out.println("t2 là: " + t2.printType() + ", có chu vi là: " + t2.getPerimeter());
	}
}
