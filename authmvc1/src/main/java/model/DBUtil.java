package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "dculogin";
	private static final String PASS = "123456";
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			return conn;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
