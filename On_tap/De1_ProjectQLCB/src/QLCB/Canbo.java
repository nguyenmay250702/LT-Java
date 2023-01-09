package QLCB;

public class Canbo {
	private int SoTK;
	private String HoTen;
	private String GT, DiaChi;
	private float Luong;
	
	public Canbo() {}

	public Canbo(int soTK, String hoTen, String gT, String diaChi, float luong) {
		super();
		SoTK = soTK;
		HoTen = hoTen;
		GT = gT;
		DiaChi = diaChi;
		Luong = luong;
	}

	public int getSoTK() {
		return SoTK;
	}

	public void setSoTK(int soTK) {
		SoTK = soTK;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public String getGT() {
		return GT;
	}

	public void setGT(String gT) {
		GT = gT;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public float getLuong() {
		return Luong;
	}

	public void setLuong(float luong) {
		Luong = luong;
	}
	
	
	
}
