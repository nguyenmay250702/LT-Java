package Lab09;

public class TestShape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Shape s1 = new Circle(5.5, "Red", false);
		System.out.println("- Thông tin của Shape 1: ");
		System.out.println("\t+ " + s1);
		System.out.println("\t+ Diện tích: " + s1.getArea());
		System.out.println("\t+ Chu vi: " + s1.getPerimeter());
		System.out.println("\t+ Màu: " + s1.getColor());
		System.out.println("\t+ " + s1.isFilled());
		//System.out.println(s1.getRadius());
		
		Circle c1 = (Circle) s1;
		System.out.println("- Thông tin của Circle 1: ");
		System.out.println("\t+ " + c1);
		System.out.println("\t+ Diện tích: " + c1.getArea());
		System.out.println("\t+ Chu vi: " + c1.getPerimeter());
		System.out.println("\t+ Màu: " + c1.getColor());
		System.out.println("\t+ " + c1.isFilled());
		System.out.println("\t+ Bán kính: " + c1.getRadius());
		
		//Shape s2 = new Shape();
		
		Shape s3 = new Rectangle(1.0, 2.0, "RED", false);
		System.out.println("- Thông tin của Shape 3: ");
		System.out.println("\t+ " + s3);
		System.out.println("\t+ Diện tích: " + s3.getArea());
		System.out.println("\t+ Chu vi: " + s3.getPerimeter());
		System.out.println("\t+ Màu: " + s3.getColor());
		//System.out.println("\t+ Bán kính: " + s3.getlength());
		
		Rectangle r1 = (Rectangle) s3;
		System.out.println("- Thông tin của Rectangle 1: ");
		System.out.println("\t+ " + r1);
		System.out.println("\t+ Diện tích: " + r1.getArea());
		System.out.println("\t+ Chu vi: " + r1.getPerimeter());
		System.out.println("\t+ Màu: " + r1.getColor());
		System.out.println("\t+ Chiều dài: " + r1.getLength());
		System.out.println("\t+ Chiều rộng: " + r1.getWidth());
		
		Shape s4 = new Square(6.6);
		System.out.println("- Thông tin của Shape 4: ");
		System.out.println("\t+ " + s4);
		System.out.println("\t+ Diện tích: " + s4.getArea());
		System.out.println("\t+ Chu vi: " + s4.getPerimeter());
		System.out.println("\t+ Màu: " + s4.getColor());
		//System.out.println("\t+ side: " + s4.getSide());
		
		Rectangle r2 = (Rectangle) s4;
		System.out.println("- Thông tin của Rectangle 2: ");
		System.out.println("\t+ " + r2);
		System.out.println("\t+ Diện tích: " + r2.getArea());
		System.out.println("\t+ Chu vi: " + r2.getPerimeter());
		System.out.println("\t+ Màu: " + r2.getColor());
		System.out.println("\t+ Length: " + r2.getLength());
		//System.out.println("\t+ side: " + r2.getSide());
		
		Square sq1 = (Square) r2;
		System.out.println("- Thông tin của Square 2: ");
		System.out.println("\t+ " + sq1);
		System.out.println("\t+ Diện tích: " + sq1.getArea());
		System.out.println("\t+ Chu vi: " + sq1.getPerimeter());
		System.out.println("\t+ Màu: " + sq1.getColor());
		System.out.println("\t+ Length: " + sq1.getLength());
		System.out.println("\t+ side: " + sq1.getSide());
	}
}
