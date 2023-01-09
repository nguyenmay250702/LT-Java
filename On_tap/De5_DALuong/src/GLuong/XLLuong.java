package GLuong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class XLLuong {
	public Connection getCon() {
		Connection conn = null;
		String userName = "sa";
		String pass = "250702";
		String str = "jdbc:sqlserver://MSI\\\\SQLEXPRESS:1433;DatabaseName=DLLuong;encrypt=false";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(str, userName, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public Vector<Nhanvien> getNVbyMa(int manv) throws SQLException{
		Connection conn = getCon();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from tbNhanvien where MaNV = " + manv);
		Vector<Nhanvien> V = new Vector<>();
		while(rs.next()) {
			V.add(new Nhanvien(rs.getInt("MaNV"), rs.getString("Hoten"), rs.getString("Diachi"), rs.getFloat("Luong")));
		}
		conn.close();
		return V;
	}
	
	public void updateNV(int manv_old, String hoten, String diachi, float luong) throws SQLException {
		Connection conn = getCon();
		Statement st = conn.createStatement();
		st.executeUpdate("UPDATE tbNhanvien SET Hoten = N'"+hoten+"', Diachi = N'"+ diachi +"', Luong = "+luong+" where MaNV = " + manv_old);
		conn.close();
	}
}
