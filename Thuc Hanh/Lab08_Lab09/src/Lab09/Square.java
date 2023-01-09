package Lab09;

public class Square extends Rectangle {

	public Square() {
		super();
	}

	public Square(double side) {
		super(side,side);
	}
	
	public Square(double side, String color, boolean filled) {
		super(side, side, color, filled);
	}

	public double getSide() {
		return this.width;
	}
	
	public void setSide(double side) {
		setWidth(side);
		setLenght(side);
	}

	@Override
	public void setWidth(double side) {
		super.setWidth(side);
	}

	@Override
	public void setLenght(double side) {
		super.setLenght(side);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
