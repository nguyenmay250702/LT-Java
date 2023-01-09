package Lab04;

//mô tả hình tam giá có 3 điểm
public class MyTriangle {
	private MyPoint v1;
	private MyPoint v2;
	private MyPoint v3;
	
	public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		this.v1 = new MyPoint(x1,y1);
		this.v2 = new MyPoint(x2,y2);
		this.v3 = new MyPoint(x3,y3);
	}
	
	public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}
	
	public String toString() {
		return "MyTriangle [v1=" + v1 + ", v2=" + v2 + ", v3=" + v3 + "]";
	}
	
	public double getPerimeter() {
		return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
	}
	
	public String printType() {
		double c1 = v1.distance(v2), c2 = v2.distance(v3) , c3 = v3.distance(v1);
		if(c1 == c2 && c2==c3 && c3==c1) return "Tam giác đều";
		else if((c1 == c2 && c2!=c3) || (c1 != c2 && c2==c3) || (c2!=c3 && c3==c1)) return "Tam giác cân";
		else if(c1*c1 == c2*c2 + c3*c3 || c2*c2 == c1*c1 + c3*c3 || c3*c3 == c1*c1 + c2*c2) return "Tam giác vuông";
		else return "tam giác thường";
	}
}
