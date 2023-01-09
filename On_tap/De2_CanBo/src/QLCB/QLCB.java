package QLCB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class QLCB implements ICanBo{
	private Connection conn;
	public Connection getCon() {
		conn = null;
		String usename = "sa";
		String pass = "250702";
		String url = "jdbc:sqlserver://MSI\\SQLEXPRESS:1433;DatabaseName=QLCB;encrypt=false";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, usename, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void updateCB(int SoTK_new, String HoTen_new, String GT_new, String DiaChi_new, float Luong_new, int SoTK_old) throws SQLException {
		conn = getCon();
		Statement st = conn.createStatement();
		String sqlUpdate = "UPDATE tbCanBo"
							+ " SET SoTK = " + SoTK_new + ", Hoten = N' "+ HoTen_new + "', GT = N' "+ GT_new + "', DiaChi = N'"+ DiaChi_new + "', Luong = " + Luong_new
							+ " where SoTK = " + SoTK_old;
		st.executeUpdate(sqlUpdate);
		conn.close();
	}
}
