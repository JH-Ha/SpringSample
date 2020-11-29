package test;

import java.util.List;

import dao.BoardDao;
import entity.Board;

public class Test {
	public static void main(String[] args) {
		BoardDao dao = new BoardDao();

		dao.insertBoard("test", "test2", "123", "¿Ã∏ß");
		List<Board> boardList = dao.getBoardList();
		for (Board board : boardList) {
			System.out.println(board);
		}
	}
}
