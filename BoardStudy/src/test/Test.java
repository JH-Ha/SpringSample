package test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.BoardDao;
import dao.DaoFactory;
import entity.Board;

public class Test {
	public static void main(String[] args) {

		// base package to scan
		// ApplicationContext context = new AnnotationConfigApplicationContext("dao");

		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

		BoardDao dao = context.getBean("boardDao", BoardDao.class);

		dao.insertBoard("test", "test2", "123", "테스트");
		List<Board> boardList = dao.getBoardList();
		for (Board board : boardList) {
			System.out.println(board);
		}

	}
}
