package GKH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class XLKH implements IKhachHang{
	private Connection conn;
	public Connection getCon() {
		conn = null;
		String username = "sa";
		String pass = "250702";
		String url  = "jdbc:sqlserver://MSI\\SQLEXPRESS:1433;DatabaseName=DLKH;encrypt=false";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void delKH(String DiaChi, String GioiTinh) throws SQLException {
		conn = getCon();
		Statement st = conn.createStatement();
		st.executeUpdate("delete from tbKhachHang where DiaChi = N'"+ DiaChi + "' and GT = N'" + GioiTinh + "'");
		conn.close();
	}
}
