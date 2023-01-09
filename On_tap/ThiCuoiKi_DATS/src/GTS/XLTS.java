package GTS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class XLTS implements IThisinh{
	private Connection cn;
	public Connection getCon() {
		cn = null;
		String usename = "sa";
		String pass = "250702";
		String url = "jdbc:sqlserver://MSI\\\\SQLEXPRESS:1433;DatabaseName=DLTS;encrypt=false";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn = DriverManager.getConnection(url, usename, pass);
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}
	
	public Vector<Thisinh> getTS() throws SQLException{
		cn = getCon();
		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery("select *from tbThisinh");
		Vector<Thisinh> V = new Vector<>();
		while(rs.next()) {
			V.add(new Thisinh(rs.getInt("SoBD"), rs.getString("Hoten"), rs.getString("GT"), rs.getString("NganhH"), rs.getFloat("TongD")));
		}
		cn.close();
		return V;
	};
	
	public void deleteTS(String NganhH) throws SQLException {
		cn = getCon();
		Statement st = cn.createStatement();
		st.executeUpdate("DELETE FROM tbThisinh where NganhH = N'"+ NganhH +"'");
		cn.close();
	};
}
