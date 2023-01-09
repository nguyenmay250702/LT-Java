package circle;
public class TestCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c1 = new Circle();
		
		System.out.println("Hình tròn c1 có bán kính = " + c1.getRadius()+", diện tích = " + c1.getArea());
		
		Circle c2 = new Circle(2.0);
		System.out.println("Hình tròn c2 có bán kính = " + c2.getRadius()+", diện tích = " + c2.getArea());
	
		Circle c3 = new Circle(3.0, "xanh");
		System.out.println("Hình tròn c3 có bán kính = " + c3.getRadius()+", diện tích = " + c3.getArea()+", màu: "+c3.getColor());
	
		c3.setColor("đen");
		c3.setRadius(4);
		System.out.println("Hình tròn c3 'sau khi THAY ĐỔI THÔNG TIN' có bán kính = " + c3.getRadius()+", diện tích = " + c3.getArea()+", màu: "+c3.getColor());
	
		System.out.println(c3);	//c3.toString()
	}
}
