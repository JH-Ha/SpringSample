package test;

import java.util.List;

import connection.AwsConnectionMaker;
import connection.ConnectionMaker;
import dao.BoardDao;
import entity.Board;

public class Test {
	public static void main(String[] args) {
		ConnectionMaker connectionMaker = new AwsConnectionMaker();
		BoardDao dao = new BoardDao(connectionMaker);

		dao.insertBoard("test", "test2", "123", "¿Ã∏ß");
		List<Board> boardList = dao.getBoardList();
		for (Board board : boardList) {
			System.out.println(board);
		}
	}
}
