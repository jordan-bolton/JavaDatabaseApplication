package DatabaseConnect;

import java.sql.Connection;
import java.sql.ResultSet;

public interface DBConnectivity {

	/**
	 * 
	 * @param sql
	 */
	Connection connect();

	/**
	 * 
	 * @param connect
	 */
	void closeConnection();

	/**
	 * 
	 * @param sql
	 */
	ResultSet read(String sql);

	/**
	 * 
	 * @param sql
	 * @param conn
	 */
	void write(String sql);
        
        final String user = "root";
        final String pass = "Password1";

}