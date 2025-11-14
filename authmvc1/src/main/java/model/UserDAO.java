package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "dculogin";
	private static final String PASS = "123456";
	
	private Connection getConnection() throws SQLException {
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
	
	public UserBean login(String id, String password) {
        final String sql = "SELECT ID, USERNAME FROM USERS "
				+ "WHERE ID=? AND PASSWORD=? ";
		try (Connection conn = getConnection();
			PreparedStatement  pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, id);
				pstmt.setString(2, password);
			
				try(ResultSet rs = pstmt.executeQuery()){
					if (rs.next()) {
						return new UserBean(
								rs.getString("id"),
								rs.getString("username")
						);
					}
					return null;
				}			
		}catch (SQLException e)	{
			throw new RuntimeException("로그인 쿼리 실패", e);
		}	
	}
}
