package Lab05;

public class MyComplex {
	private double real;
	private double imag;
	
	public MyComplex(double real, double imag) {
		super();
		this.real = real;
		this.imag = imag;
	}
	public double getReal() {
		return real;
	}
	public double getImag() {
		return imag;
	}
	public void setReal(double real) {
		this.real = real;
	}
	public void setImag(double imag) {
		this.imag = imag;
	}
	
	public void setValue (double real, double imag) {
		this.real = real;
		this.imag = imag;
	}
	
	public String toString() {
		if(imag >= 0) return "(" + real + " + " + imag + "i)";
		else return "(" + real + " - " + Math.abs(imag) + "i)";
	}
	
	//trả về TRUE nếu là số thực
	public boolean isReal() {
		return this.imag == 0;
	}
	
	//trả về TRUE nếu là số ảo
	public boolean isImaginary() {
		return this.real==0;
	}
	
	//trả về TRUE nếu 2 số phức bằng nhau
	public boolean equals(double real, double imag) {
		return this.real==real && this.imag == imag;
	}
	
	//trả về TRUE nếu 2 số phức bằng nhau
	public boolean equals(MyComplex another) {
		return this.real==another.real && this.imag==another.imag;
	}
	
	//trả về độ lớn của số phức
	public double magnitude() {
		return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imag, 2));
	}
	
	//trả về góc theta ở dạng radian từ việc chuyển đổi tọa độ vuông góc(x,y) về tọa độ cực (r, theta)
	public double argumantInRadians() {
		return Math.atan2(imag, real);	//tính argtan(x+yi)
	}
	
	//trả về góc theta ở dạng degrees
	public double argumentInDegrees() {
		return  Math.toDegrees(argumantInRadians());
	}
	
	//trả về MyComplex mới
	public MyComplex conjugate() {
		return new MyComplex(real, -imag);
	}
	
	public MyComplex add(MyComplex another) {
		return new MyComplex(this.real + another.real, this.imag + another.imag);
	}
	
	public MyComplex subtract(MyComplex another) {
		return new MyComplex(this.real - another.real, this.imag - another.imag);
	}
	
	public MyComplex multiplyWith(MyComplex another) {
		return new MyComplex(this.real*another.real - this.imag*another.imag, this.real*another.imag + this.imag*another.real);
	}
	
	public MyComplex divides(MyComplex another) {
		MyComplex p1 = multiplyWith(another.conjugate());
		return new MyComplex(p1.real/(another.real*another.real + another.imag*another.imag), p1.imag/(another.real*another.real + another.imag*another.imag));
	}
}
