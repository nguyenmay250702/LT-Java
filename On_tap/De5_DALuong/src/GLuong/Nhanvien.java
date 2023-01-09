package GLuong;

public class Nhanvien extends Prerson{
	private String Diachi;
	private float Luong;
	public Nhanvien() {
		super();
	}
	public Nhanvien(int maNV, String hoten) {
		super(maNV, hoten);
	}
	public Nhanvien(int maNV, String hoten, String diachi, float luong) {
		super(maNV, hoten);
		Diachi = diachi;
		Luong = luong;
	}
	public String getDiachi() {
		return Diachi;
	}
	public void setDiachi(String diachi) {
		Diachi = diachi;
	}
	public float getLuong() {
		return Luong;
	}
	public void setLuong(float luong) {
		Luong = luong;
	}
}
