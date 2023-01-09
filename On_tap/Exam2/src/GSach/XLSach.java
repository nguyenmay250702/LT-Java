package GSach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class XLSach implements ISach{
	private Connection cn;
	
	public Connection getCon() {
		cn = null;
		String usename = "sa";
		String pass = "250702";
		String url  = "jdbc:sqlserver://MSI\\SQLEXPRESS:1433;DatabaseName=DLSach;encrypt=false";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn = DriverManager.getConnection(url, usename, pass);
			System.out.println("pass");
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			System.out.println("fail");
		}
		return cn;
	}
	
	//lấy ra tất vả sách
	public Vector<Sach> getSA() throws SQLException{
		cn = getCon();
		Statement st = cn.createStatement();
		String sql = "select *from tbSach";
		ResultSet result = st.executeQuery(sql);
		Vector<Sach> V = new Vector<>();
		while(result.next()) {
			V.add(new Sach(result.getString("MaS"), result.getString("TenS"), result.getString("NhaXB"), result.getInt("NamXB"), result.getFloat("GiaB")));
		}
		return V;
	}
	
	//lấy sách theo NXB và giá
	public Vector<Sach> getSAbyNXBGB(String nxb, float gia) throws SQLException{
		cn = getCon();
		
		String sql = "select *from tbSach"
					 + " where NhaXB = N'"+ nxb + "' and GiaB = " + gia;
		
		Statement st = cn.createStatement();
		ResultSet result = st.executeQuery(sql);
		
		Vector<Sach> V = new Vector<>();
		while(result.next()) {
			V.add(new Sach(result.getString("MaS"), result.getString("TenS"), result.getString("NhaXB"), result.getInt("NamXB"), result.getFloat("GiaB")));
		}
		return V;
	}
	
}
