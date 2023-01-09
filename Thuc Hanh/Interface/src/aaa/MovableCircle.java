package aaa;

public class MovableCircle implements movable{
	private int radius;
	private MovablePoint center;
	
	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
		center = new MovablePoint(x, y, xSpeed, ySpeed);
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "MovableCircle [radius=" + radius + ", center=" + center + "]";
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		center.y -= center.ySpeed;
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		center.y += center.ySpeed;
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		center.x -= center.xSpeed;
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		center.x += center.xSpeed;
	}
	
	
	
	
	
}
