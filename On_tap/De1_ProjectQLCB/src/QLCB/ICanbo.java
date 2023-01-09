package QLCB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public interface ICanbo {
	public Connection getCon();
	public void insertCB(Vector V) throws SQLException;
}
