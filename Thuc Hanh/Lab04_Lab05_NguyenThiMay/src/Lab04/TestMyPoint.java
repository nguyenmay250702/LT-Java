package Lab04;

public class TestMyPoint {

	public static void main(String[] args) {
		MyPoint p1 = new MyPoint(3, 0);
		MyPoint p2 = new MyPoint(0, 4);
		
		System.out.println("Khoang cach từ p1 đến điểm p2 là: " + p1.distance(p2));
		System.out.println("Khoang cach từ p1 đến điểm (0,4) là: " + p1.distance(0,4));
	
		MyPoint points[] = new MyPoint[10];
		for(int i = 0; i<10; i++) {
			points[i] = new MyPoint(i+1, i+1);
		}
	
		for(int i = 0; i<10; i++) {
			System.out.println(points[i]);
		}
	}

}
