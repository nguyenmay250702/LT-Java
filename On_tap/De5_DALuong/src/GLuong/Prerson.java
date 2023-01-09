package GLuong;

public class Prerson {
	protected int MaNV;
	protected String Hoten;
	public Prerson() {}
	public Prerson(int maNV, String hoten) {
		super();
		MaNV = maNV;
		Hoten = hoten;
	}
	public int getMaNV() {
		return MaNV;
	}
	public void setMaNV(int maNV) {
		MaNV = maNV;
	}
	public String getHoten() {
		return Hoten;
	}
	public void setHoten(String hoten) {
		Hoten = hoten;
	}
}
