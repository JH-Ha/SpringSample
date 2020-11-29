package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class UserDao {
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		// String url = "jdbc:mysql://localhost/study?serverTimezone=UTC";

		// String dbId = "root";
		// String dbPw = "admin";
		String url = "jdbc:mysql://database-study-spring.chsxiosrbq1b.ap-northeast-2.rds.amazonaws.com:3306/sys";
		String dbId = "admin";
		String dbPw = "6s8GJggs8q9Ol3biXshz";
		Connection conn = DriverManager.getConnection(url, dbId, dbPw);
		// Connection conn = DriverManager.getConnection(url);
		return conn;
	}

	public User get(String id, String password) {
		User user = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			conn = getConnection();
			String sql = "select * from user where id = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				user = new User();
				user.setId(rset.getString("id"));
				user.setName(rset.getString("name"));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rset != null)
					rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}
}
