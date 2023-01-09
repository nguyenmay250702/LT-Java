package GKH;

import java.sql.Connection;
import java.sql.SQLException;

public interface IKhachHang {
	public Connection getCon();
	
	//xóa theo địa chỉ và giới tính
	public void delKH(String DiaChi, String GioiTinh) throws SQLException;
}
