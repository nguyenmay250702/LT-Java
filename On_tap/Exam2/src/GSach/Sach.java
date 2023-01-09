package GSach;

public class Sach {
	private String MaS;
	private String TenS;
	private String NhaXB;
	private int NamXB;
	private float GiaB;
	
	public Sach() {}
	
	public Sach(String maS, String tenS, String nhaXB, int namXB, float giaB) {
		super();
		MaS = maS;
		TenS = tenS;
		NhaXB = nhaXB;
		NamXB = namXB;
		GiaB = giaB;
	}

	public String getMaS() {
		return MaS;
	}
	public void setMaS(String maS) {
		MaS = maS;
	}
	public String getTenS() {
		return TenS;
	}
	public void setTenS(String tenS) {
		TenS = tenS;
	}
	public String getNhaXB() {
		return NhaXB;
	}
	public void setNhaXB(String nhaXB) {
		NhaXB = nhaXB;
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
	public float KhuyenMai() {
		return (float) ((this.NamXB < 2019)? this.GiaB*0.25:0);
	}
	
}
