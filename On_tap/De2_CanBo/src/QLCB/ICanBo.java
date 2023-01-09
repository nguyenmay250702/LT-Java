package QLCB;

import java.sql.Connection;
import java.sql.SQLException;

public interface ICanBo {
	public Connection getCon();
	public void updateCB(int SoTK_new, String HoTen_new, String GT_new, String DiaChi_new, float Luong_New, int SoTK_old) throws SQLException;
}
