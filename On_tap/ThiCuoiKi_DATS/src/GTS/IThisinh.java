package GTS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public interface IThisinh {
	public Connection getCon();
	public Vector<Thisinh> getTS() throws SQLException;
	public void deleteTS(String NganhH) throws SQLException;
}
