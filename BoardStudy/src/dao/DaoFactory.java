package dao;

import connection.AwsConnectionMaker;
import connection.ConnectionMaker;

public class DaoFactory {
	public ConnectionMaker connectionMaker() {
		return new AwsConnectionMaker();
	}

	public BoardDao boardDao() {
		BoardDao boardDao = new BoardDao(connectionMaker());
		return boardDao;
	}

	public UserDao userDao() {
		UserDao userDao = new UserDao(connectionMaker());
		return userDao;
	}
}
