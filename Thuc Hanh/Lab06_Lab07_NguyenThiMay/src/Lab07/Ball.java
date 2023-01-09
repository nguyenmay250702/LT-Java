package Lab07;

public class Ball {
	private float x;
	private float y;
	private int radius;
	private float xDelta;
	private float yDelta;
	
	public Ball(float x, float y, int radius, int speed, int direction) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.xDelta = (float)(speed*Math.cos(direction));
		this.yDelta = (float)(-speed*Math.sin(direction));
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public int getRadius() {
		return radius;
	}
	public float getxDelta() {
		return xDelta;
	}
	public float getyDelta() {
		return yDelta;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	public void setY(float y) {
		this.y = y;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public void setxDelta(float xDelta) {
		this.xDelta = xDelta;
	}
	public void setyDelta(float yDelta) {
		this.yDelta = yDelta;
	}
	
	public void setXY(int x, int y) {
		setX(x);
		setY(y);
	}
	
	//di chuyển bóng 1 khoảng
	public void move() {
		this.x += xDelta;
		this.y += yDelta;
	}
	
	//bóng đập vào tường rồi bật chở lại di chuyển theo chiều ngang 1 khoảng
	public void reflectHorizontal() {
		this.xDelta = -this.xDelta;
	}
	
	//bóng đập vào tường rồi bật chở lại di chuyển theo chiều dọc 1 khoảng
	public void reflectVertical() {
		this.yDelta = -this.yDelta;
	}
}
