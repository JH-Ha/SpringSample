package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.connection.ConnectionMaker;

public class LocalConnectionMaker implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost/study?serverTimezone=UTC";

		String dbId = "root";
		String dbPw = "admin";
		Connection conn = DriverManager.getConnection(url, dbId, dbPw);

		return null;
	}

}
