package GKH;

public class KhachHang {
	private int SoTK;
	private String HoTen, GT, DiaChi;
	private float SoDu;
	
	public KhachHang() {
		super();
	}
	
	public KhachHang(int soTK, String hoTen, String gT, String diaChi, float soDu) {
		super();
		SoTK = soTK;
		HoTen = hoTen;
		GT = gT;
		DiaChi = diaChi;
		SoDu = soDu;
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

	public float getSoDu() {
		return SoDu;
	}

	public void setSoDu(float soDu) {
		SoDu = soDu;
	}

	
}
