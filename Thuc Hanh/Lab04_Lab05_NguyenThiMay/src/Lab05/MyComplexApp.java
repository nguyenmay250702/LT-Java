package Lab05;

public class MyComplexApp {

	public static void main(String[] args) {
		MyComplex number1 = new MyComplex(2, 0);
		MyComplex number2 = new MyComplex(3, -4);

		System.out.println(number1.toString());
		System.out.println(number2.toString());
		
		System.out.println("\n- kiểm tra tính thực ảo: ");
		if(number1.isReal()) System.out.println("\t+ Number1 là số thực");
		else if(number1.isImaginary()) System.out.println("\t+ Number1 là số ảo");
		else System.out.println("\t+ Number1 là số phức");
		
		if(number2.isReal()) System.out.println("\t+ Number2 là số thực");
		else if(number2.isImaginary()) System.out.println("\t+ Number2 là số ảo");
		else System.out.println("\t+ Number2 là số phức");
		
		System.out.println("\n- So sánh 2 số phức");
		if(number2.equals(6.6))  System.out.println("\t+ " + number2.toString() + " == " + 6.6);
		else  System.out.println("\t+ " + number2.toString() + " != " + 6.6);
		
		System.out.println("\n- Phép tính số phức:");
		System.out.println("\t+ add: " + number2.toString() + " + " + number1.toString() + " = " + number2.add(number1));
		System.out.println("\t+ subtract: " + number2.toString() + " - " + number1.toString() + " = " + number2.subtract(number1));
		System.out.println("\t+ conjugate: " + number2.toString() +  " => " + number2.conjugate());
		System.out.println("\t+ multiplyWith: " + number2.toString() + " * " + number1.toString() + " = " + number2.multiplyWith(number1));
		System.out.println("\t+ dividesBy: " + number2.toString() + " / " + number1.toString() + " = " + number2.divides(number1));
		
		MyComplex number3 = new MyComplex(1, Math.sqrt(3));
		System.out.println("\n- Chuyển đổi số phức về radians:" + number3.argumantInRadians());
		System.out.println("- Chuyển đổi số phức về degrees:" + number3.argumentInDegrees());
	}
}
