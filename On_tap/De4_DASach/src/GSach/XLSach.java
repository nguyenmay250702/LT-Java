package GSach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class XLSach {
	//kết nối sql
	public Connection getCon() {
		Connection conn = null;
		String userName = "sa";
		String pass = "250702";
		String str = "jdbc:sqlserver://MSI\\\\SQLEXPRESS:1433;DatabaseName=DLSach;encrypt=false";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(str, userName, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//lấy dữ liệu từ database
	public Vector<Sach> getSA() throws SQLException{
		Connection conn = getCon();
		Statement st = conn.createStatement();
		ResultSet result = st.executeQuery("select * from tbSach");
		
		Vector<Sach> V = new Vector<>();
		while(result.next()) {
			V.add(new Sach(result.getInt("MaS"), result.getString("TenS"), result.getInt("NamXB"), result.getFloat("GiaB")));
		}
		conn.close();
		return V;
	}
	
	//tìm kiếm
	public Vector<Sach> getTimKiem(int MaS1, int NamXB1) throws SQLException{
		Connection conn = getCon();
		Statement st = conn.createStatement();
		ResultSet result = st.executeQuery("select * from tbSach where MaS = " + MaS1 + " and NamXB = " + NamXB1);
		
		Vector<Sach> V = new Vector<>();
		while(result.next()) {
			V.add(new Sach(result.getInt("MaS"), result.getString("TenS"), result.getInt("NamXB"), result.getFloat("GiaB")));
		}
		conn.close();
		return V;
	}
	
	//xóa theo năm xuất bản
	public void deleteSA(int nam_xoa) throws SQLException {
		Connection conn = getCon();
		Statement st = conn.createStatement();
		st.executeUpdate("delete from tbSach where NamXB = " + nam_xoa);
		conn.close();
	}
	
	//thêm
	public void insertSA(int MaS1, String TenS1, int NamXB1, float GiaB1) throws SQLException {
		Connection conn = getCon();
		Statement st = conn.createStatement();
		String sqlInsert = "insert into tbSach values (" + MaS1 + ", N'"+ TenS1 +"',"+ NamXB1 +", " + GiaB1 +")";
		st.executeUpdate(sqlInsert);
		conn.close();
	}
	
	//cập nhật
	public void updateSA(int MaS_old, int MaS_new, String TenS_new, int NamXB_new, float GiaB_new) throws SQLException {
		Connection conn = getCon();
		Statement st = conn.createStatement();
		String sqlUpdate = "UPDATE tbSach SET MaS = " + MaS_new +", TenS = N'"+ TenS_new +"', NamXB = " + NamXB_new +", GiaB = " + GiaB_new 
						+ " where MaS = " + MaS_old;
		st.executeUpdate(sqlUpdate);
		conn.close();
	}
}
