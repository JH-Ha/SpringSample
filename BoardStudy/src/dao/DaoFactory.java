package dao;

import connection.AwsConnectionMaker;
import connection.ConnectionMaker;

public class DaoFactory {
	public BoardDao boardDao() {
		ConnectionMaker connectionMaker = new AwsConnectionMaker();
		BoardDao boardDao = new BoardDao(connectionMaker);
		return boardDao;
	}
}
