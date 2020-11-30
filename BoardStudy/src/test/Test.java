package test;

import java.util.List;

import dao.BoardDao;
import dao.DaoFactory;
import entity.Board;

public class Test {
	public static void main(String[] args) {

		BoardDao dao = new DaoFactory().boardDao();

		dao.insertBoard("test", "test2", "123", "�̸�");
		List<Board> boardList = dao.getBoardList();
		for (Board board : boardList) {
			System.out.println(board);
		}
	}
}
