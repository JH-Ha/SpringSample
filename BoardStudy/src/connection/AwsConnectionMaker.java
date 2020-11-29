package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AwsConnectionMaker implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://database-study-spring.chsxiosrbq1b.ap-northeast-2.rds.amazonaws.com:3306/sys";
		String dbId = "admin";
		String dbPw = "6s8GJggs8q9Ol3biXshz";
		Connection conn = DriverManager.getConnection(url, dbId, dbPw);
		return conn;
	}

}
