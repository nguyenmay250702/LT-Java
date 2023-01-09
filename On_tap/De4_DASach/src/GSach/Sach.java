package GSach;

public class Sach extends Tailieu{
	private int NamXB;
	private float GiaB;
	public Sach() {
		super();
	}
	public Sach(int maS, String tenS, int namXB, float giaB) {
		super(maS, tenS);
		NamXB = namXB;
		GiaB = giaB;
	}
	public int getNamXB() {
		return NamXB;
	}
	public void setNamXB(int namXB) {
		NamXB = namXB;
	}
	public float getGiaB() {
		return GiaB;
	}
	public void setGiaB(float giaB) {
		GiaB = giaB;
	}
	public float ThanhTien() {
		if(NamXB <2015) return (float) (GiaB*0.85);
		return (float) (GiaB*0.95);
	}
	
}
