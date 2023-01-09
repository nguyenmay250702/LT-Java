package aaa;

public class TestMovable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		movable m1 = new MovablePoint(5, 6, 10, 0);
		System.out.println(m1);
		m1.moveLeft();
		System.out.println(m1);
		
		movable m2 = new MovableCircle(2, 1, 2, 20,3);
		System.out.println(m2);
		m1.moveLeft();
		System.out.println(m2);
	}

}
