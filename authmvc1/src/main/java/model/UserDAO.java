package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	
	public UserBean login(String id, String password) {
        final String sql = "SELECT ID, USERNAME FROM USERS "
				+ "WHERE ID=? AND PASSWORD=? ";
		try (Connection conn = DBUtil.getConnection();
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
