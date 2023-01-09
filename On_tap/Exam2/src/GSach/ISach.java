package GSach;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public interface ISach {
	public Connection getCon();
	public Vector<Sach> getSA() throws SQLException;
	public Vector<Sach> getSAbyNXBGB(String nxb, float gia) throws SQLException;
}
