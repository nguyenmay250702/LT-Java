package aaa;

public class MovableRectangle {
	private MovablePoint topLeft;
	private MovablePoint bottomLeft;
	public MovableRectangle(int x1,int y1,int x2, int y2, int xSpeed, int ySpeed) {
		topLeft = new MovablePoint(x2, y2, xSpeed, ySpeed);
		bottomLeft = new MovablePoint(x2, y2, xSpeed, ySpeed);
	}
	
	@Override
	public String toString() {
		return "MovableRectangle [topLeft=" + topLeft + ", bottomLeft=" + bottomLeft + "]";
	}
	
	
	
}
