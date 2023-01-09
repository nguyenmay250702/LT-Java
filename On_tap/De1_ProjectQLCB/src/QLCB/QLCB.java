package QLCB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class QLCB implements ICanbo{
	private Connection conn;
	
	public Connection getCon() {
		conn = null;
		String userName = "sa";
		String pass = "250702";
		String str = "jdbc:sqlserver://MSI\\SQLEXPRESS:1433;DatabaseName=QLCB;encrypt=false";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(str, userName, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//thực hiện lấy dữ liệu từ vector sang đối tượng PreparedStatement
	public void insertCB(Vector V) throws SQLException{
		conn = getCon();
		String sql = "insert into tbCanBo values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,  (int) V.elementAt(0));
		ps.setString(2, (String) V.elementAt(1));
		ps.setString(3, (String) V.elementAt(2));
		ps.setString(4, (String) V.elementAt(3));
		ps.setFloat(5, (Float) V.elementAt(4));
		
		ps.execute();
	}
}
