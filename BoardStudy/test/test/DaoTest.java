package test;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dao.BoardDao;
import com.entity.Article;

public class DaoTest {
	public static void main(String[] args) throws SQLException {

		// base package to scan
		// ApplicationContext context = new AnnotationConfigApplicationContext("dao");

		// ApplicationContext context = new
		// AnnotationConfigApplicationContext(DaoFactory.class);
		ApplicationContext context = new GenericXmlApplicationContext(
        "main/java/applicationContext.xml");

		BoardDao dao = context.getBean("boardDao", BoardDao.class);

		dao.insertBoard("test", "test2", "123", "테스트");
		List<Article> boardList = dao.getBoardList();
		for (Article board : boardList) {
			System.out.println(board);
		}

	}
}
