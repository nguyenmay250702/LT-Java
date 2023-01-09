package GTS;

public class Thisinh {
	private int SoBD;
	private String Hoten, GT, NganhH;
	private float TongD;
	public Thisinh() {}
	public Thisinh(int soBD, String hoten, String gT, String nganhH, float tongD) {
		super();
		SoBD = soBD;
		Hoten = hoten;
		GT = gT;
		NganhH = nganhH;
		TongD = tongD;
	}
	public int getSoBD() {
		return SoBD;
	}
	public void setSoBD(int soBD) {
		SoBD = soBD;
	}
	public String getHoten() {
		return Hoten;
	}
	public void setHoten(String hoten) {
		Hoten = hoten;
	}
	public String getGT() {
		return GT;
	}
	public void setGT(String gT) {
		GT = gT;
	}
	public String getNganhH() {
		return NganhH;
	}
	public void setNganhH(String nganhH) {
		NganhH = nganhH;
	}
	public float getTongD() {
		return TongD;
	}
	public void setTongD(float tongD) {
		TongD = tongD;
	}
	public String Xettuyen() {
		return (this.TongD>20)? "Trúng tuyển":"Không trúng tuyển";
	}
	
}
